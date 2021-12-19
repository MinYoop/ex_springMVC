package com.hk.mvc04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.hk.mvc04.validate.FileValidator;
import com.hk.mvc04.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;

	@RequestMapping(value="/form")
	public String getUploadForm() {
		
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload")
	public String fileUpload(HttpServletRequest request, Model model, 
			UploadFile uploadFile, BindingResult result) {
		
		// BindingResult : 객체를 Binding 하다가 에러 발생 시 해당 에러 정보를 받기 위해 사용(객체 대신 bean이라는 말을쓰기도함)
		// binding : 데이터를 객체에 넣어주는 것, 값을 넣어주는 것
		
		fileValidator.validate(uploadFile, result);// result 에러 잡아주는애 uproadFile이 에러가 있는지 여기에 한번 거친다.(유효성 검사)
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();
		
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		
		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			
			// 절대 경로 / 상대 경로 
			//jsp servlet 할땐  루트 폴더가 있었고 지금은 webApp이 루트
			/*
			 *  /   : root(최상위 폴더)
			 * 	./  : 현재 나(index)와 같은 폴더
			 * 	../ : 상위 폴더
			 * 
			 *  //절 대 경로 / 상대 경로
			 *  //상대 경로 : ./js/test.js
			 *  //절대 경로 : c:\Workspace_Spring\SpringMVC04_fileUpload\src........
			 *  
			 *  우리가 쓰기에는 상대경로가 편하다 하지만 톰캣이 퍼블리싱하니깐 그걸보라고 요번에 절대경로로 해둠 Server path: 는 서버폴더 설정에 있다.
			 *  tomcat 껐다 키면 파일 지워주는 경우에는 톰캣말고 바탕화면같은곳에 폴더로 경로 잡아두면 안지워짐
			 *  절대경로 해서 파일 저장하기 해보자 !
			 */
			

			System.out.println("업로드 될 실제 경로 : " + path);
			
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			File newfile = new File(path + "/" + filename);
			
			
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadFile";
	}
	
	@RequestMapping(value="/download")
	@ResponseBody// 뷰리솔버 안거침
	public byte[] fileDown(HttpServletRequest request, 
			HttpServletResponse response, String filename) throws IOException {
		
		String path = WebUtils.getRealPath(
				request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
		//파일 찾고
		byte[] bytes = FileCopyUtils.copyToByteArray(file); //파일은 바이트형식으로 주고받는다
		String fn = new String(file.getName().getBytes(),"8859_1");
		
		//로컬로 저장
		response.setHeader("Content-Disposition", 
				"attachment;filename=\""+fn+"\"");
		response.setContentLength(bytes.length);
		response.setContentType("image/jpeg");
		//브라우저들간의 약속 : 틀리면 다운이 된다 (text/html -> test/html) 브라우저가 화면에 출력가능하다면 약속해주는 것 
		// Server에 web.xml 보면 605줄에 보낼 수 있는 파일 mime으로 content타입을 설정해 줄 수 있다.
		
		
		return bytes;
	}
}







