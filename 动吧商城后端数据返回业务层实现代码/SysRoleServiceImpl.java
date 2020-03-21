package com.db.pt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.pt.common.exception.ServiceException;
import com.db.pt.common.vo.PageObject;
import com.db.pt.common.vo.SysRoleMenuVo;
import com.db.pt.dao.SysRoleDao;
import com.db.pt.dao.SysRoleMenuDao;
import com.db.pt.dao.SysUserRoleDao;
import com.db.pt.entity.SysRole;
import com.db.pt.service.SysRoleService;
@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	@Override
	public PageObject<SysRole> findPageObjects(
			String name, Integer pageCurrent) {
		if(pageCurrent == null || pageCurrent <1)
			throw new IllegalArgumentException("页码值无效！！！");
		int rowCount = sysRoleDao.getRowCount(name);
		if(rowCount == 0)
			throw new ServiceException("没有相应记录！！！");
		int pageSize = 3;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysRole> records = 
				sysRoleDao.findPageObjects(name, startIndex, pageSize);
		return new PageObject<>(rowCount, records, pageCurrent, pageSize);
	}


	@Override
	public int deleteObject(Integer id) {
		if(id == null || id < 0)
			throw new IllegalArgumentException("请先选择！！！");
		sysRoleMenuDao.deleteObjectByRoleId(id);
		sysUserRoleDao.deleteObjectByRoleId(id);
		int row = sysRoleDao.deleteObject(id);
		if(row == 0)
			throw new ServiceException("菜单不存在");
		return row;
	}


	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
		if(id == null || id <0)
			throw new IllegalArgumentException("请先选择！！！");
		SysRoleMenuVo findObjectById = sysRoleDao.findObjectById(id);
		if(findObjectById == null)
			throw new ServiceException("记录不存在！");
		return findObjectById;
	}

	
}




















































































