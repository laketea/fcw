/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Users;


public interface UsersManager {
	
	public void add(Users users);
	
	public void update(Users users);
	
	public void delete(Integer id);
	
	public List<Users> findAll();
	
	public Users get(Integer id);
	
	public Page findByPage(Users users,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public Users checkEmailExsit(String value);
	
	public Users checkNickExsit(String value);
	
	public Users login(Users users);
	
	public Users ajaxLogin(String account,String pwd);
	
	

}
