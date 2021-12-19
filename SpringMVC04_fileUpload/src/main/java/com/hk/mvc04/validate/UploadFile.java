package com.hk.mvc04.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {

	private String filename;
	private String desc;
	private MultipartFile file; // 파일 객체를 담음
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
