/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.Admin;

/** 
 * 
 * @author zhangwei  
 * @version 2012-10-15 下午08:27:45 
 * 
 */
public interface AdminManager {
	
	
	public int validLogin(String name,String pwd);
	
	public void addAdmin(Admin admin);
	
	public void updatePwd(Admin admin);
	
	public void deleteAdmin(Integer id);
	
	public List<Admin> findAll();
	
	public Admin getAdmin(Integer id);
	
	public Page findByPage(int pageNo ,int PageSize);
	
	
	

}
