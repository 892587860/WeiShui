package com.weishui.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.weishui.mapper.DeptMapper;
import com.weishui.model.Dept;
import com.weishui.service.DeptService;
//可以消除xml中对bean的配置  
@Service  
//此处使用spring的声明式事务，不在使用sqlsession和提交事务了  
@Transactional 
public class DeptServiceImpl implements DeptService{
	
	@Resource
	private DeptMapper deptMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insert(record);
	}

	@Override
	public int insertSelective(Dept record) {
		// TODO Auto-generated method stub
		return deptMapper.insertSelective(record);
	}

	@Override
	public Dept selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Dept record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDeptById(Dept record) {
		return deptMapper.updateDeptById(record);
	}

	@Override
	public List<Dept> getAlDepts() {
		// TODO Auto-generated method stub
		return deptMapper.getAlDepts();
	}

	@Override
	public int deleteByIds(List<String> deptIds) {
		return deptMapper.deleteByIds(deptIds);
	}

	@Override
	public Dept getDeptById(String id) {
		return deptMapper.getDeptById(id);
	}
}
