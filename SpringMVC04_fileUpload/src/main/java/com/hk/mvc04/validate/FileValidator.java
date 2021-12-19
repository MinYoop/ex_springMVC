package com.hk.mvc04.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator {//validate:에러 입증 , Validator는 스프링에서 제공해줌
	
	//validator 사용 가능 여부 확인

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object uploadFile, Errors errors) {// 그파일에대해서 어떤 에러들을 잡을 수 있는지
		UploadFile file = (UploadFile) uploadFile;
		
		if(file.getFile().getSize() == 0) {//여기에 걸리면 밑에 걸려라.
			errors.rejectValue("file", "uploadForm", 
					"Please select a file");
			// field(file)에 대한 errorCode를 리턴, 해당 errorCode가 없으면 defalut message 리턴. 에러나면 uploadForm으로 가서 "file" 이름에 대한 에러메시지 출력
		}
	}

}
