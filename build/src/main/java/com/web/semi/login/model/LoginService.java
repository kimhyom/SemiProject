package com.web.semi.login.model;

public class LoginService {
	private LoginDTO dto = null;

	public LoginService(LoginDTO dto) {
		this.dto = dto;
	}

	public boolean isExisted() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(this.dto.getUsername());
		dao.close();
		
		return data != null ? true : false;
	}

	public boolean confirmPassword() {
		LoginDAO dao = new LoginDAO();
		LoginDTO data = dao.select(this.dto.getUsername());
		dao.close();
		
		if(data != null) {
			if(data.getPassword().equals(this.dto.getPassword())) {
				return true;
			}
		}
		
		return false;
	}

}
