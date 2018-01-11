package com.weishui.mapper;

import com.weishui.model.WsPosition;

public interface WsPositionMapper {
    int deleteByPrimaryKey(String id);

    int insert(WsPosition record);

    int insertSelective(WsPosition record);

    WsPosition selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WsPosition record);

    int updateByPrimaryKey(WsPosition record);
}