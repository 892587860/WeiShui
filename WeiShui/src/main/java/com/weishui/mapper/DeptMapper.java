package com.weishui.mapper;

import java.util.List;

import com.weishui.model.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(String id);
    
    int deleteByIds(List<String> deptIds);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dept record);

    int updateDeptById(Dept record);
    
    List<Dept>  getAlDepts();
    
    Dept getDeptById(String id);
}