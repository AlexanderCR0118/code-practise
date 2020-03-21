package com.db.pt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.db.pt.common.exception.ServiceException;
import com.db.pt.common.vo.PageObject;
import com.db.pt.dao.SysLogDao;
import com.db.pt.entity.SysLog;
import com.db.pt.service.SysLogService;
@Service
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	private SysLogDao sysLogDao;
	@Override
	public PageObject<SysLog> findPageObjects(
			String username, Integer pageCurrent) {
		//1.验证参数的合法性
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("页码值不正确");
		//2.查询总记录数
		int rowCount=sysLogDao.getRowCount(username);
		if(rowCount==0)
			throw new ServiceException("没有对应的记录");

		//3.查询当前页要呈现的记录
		//int pageSize=pageProperties.getPageSize();
		//System.out.println("pageSize="+pageSize);
		int pageSize = 3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysLog> records=
				sysLogDao.findPageObjects(username, startIndex, pageSize);
		//4.封装查询结果
		return new PageObject<>(rowCount, records, pageCurrent, pageSize);
	}
	@Override
	public int deleteObjects(Integer... ids) {
		int deleteObjects = sysLogDao.deleteObjects(ids);
		return deleteObjects;
	}

}
