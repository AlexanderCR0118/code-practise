package com.db.pt.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.db.pt.common.exception.ServiceException;
import com.db.pt.common.vo.Node;
import com.db.pt.dao.SysMenuDao;
import com.db.pt.dao.SysRoleMenuDao;
import com.db.pt.entity.SysMenu;
import com.db.pt.service.SysMenuService;
@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	@Override
	public List<Map<String, Object>> findMenuObjects() {
		List<Map<String, Object>> findMenuObjects = 
				sysMenuDao.findMenuObjects();
		if(findMenuObjects == null || findMenuObjects.size() == 0 )
			throw new ServiceException("不存在对应菜单信息！！！");
		return findMenuObjects;
	}
	@Override
	public List<Node> findZtreeMenuNodes() {
		
		return sysMenuDao.findZtreeMenuNodes();
	}
	@Override
	public int insertObjects(SysMenu entity) {
		if(entity == null)
			throw new ServiceException("参数不能为空！！！");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("用户名不能为空！！！");
		int insertObjects;
		try {
			 insertObjects = sysMenuDao.insertObjects(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("保存失败！！");
		}
		
		return insertObjects;
	}
	@Override
	public int updateObject(SysMenu entity) {
		if(entity== null)
			throw new ServiceException("保存对象不能为空！");
		if(StringUtils.isEmpty(entity))
			throw new ServiceException("用户名不能为空！");
		int row = sysMenuDao.updateObject(entity);
		if(row == 0)
			throw new ServiceException("记录可能已经不存在！");
		return row;
	}
	@Override
	public int deleteObject(Integer id) {
		if(id == null || id <1)
			throw new IllegalArgumentException("请先选择！");
		int childCount = sysMenuDao.getChildCount(id);
		if(childCount > 1)
			throw new ServiceException("请先删除子菜单！！");
		sysRoleMenuDao.deleteObjectByRoleMenuId(id);
		int row = sysMenuDao.deleteObject(id);
		if(row == 0)
			throw new ServiceException("记录可能已经不存在！");
		return row;
	}

}
