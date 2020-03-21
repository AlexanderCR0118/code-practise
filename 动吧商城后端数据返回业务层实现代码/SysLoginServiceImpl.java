package com.db.pt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.pt.dao.SysLoginDao;
import com.db.pt.service.SysLoginService;

@Service
public class SysLoginServiceImpl implements SysLoginService {

	@Autowired
	private SysLoginDao sysLogindao;
	@Override
	public int findLogin(String password, String username) {
		if(password == null || username == null)
			throw new IllegalArgumentException("xianshuru");
		int findLoginUP = sysLogindao.findLoginUP(username);
		return findLoginUP;
	}

}
