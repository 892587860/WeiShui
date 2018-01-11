package com.weishui.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WsPosition {
    private String id;

    private String positionName;

    private String description;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
    
    /*private List<WsUser> users=new ArrayList<WsUser>();
    
    private List<WsMenu> menu=new ArrayList<WsMenu>();*/
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

/*	public List<WsUser> getUsers() {
		return users;
	}

	public void setUsers(List<WsUser> users) {
		this.users = users;
	}

	public List<WsMenu> getMenu() {
		return menu;
	}

	public void setMenu(List<WsMenu> menu) {
		this.menu = menu;
	}*/
    
    
}