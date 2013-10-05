/**
 * 
 */ 
package com.fcw.service; 

import java.util.List;

import com.fcw.common.hibernate.Page;
import com.fcw.domain.UserInfo;


public interface UserInfoManager {
	
	public void add(UserInfo userinfo);
	
	public void update(UserInfo userinfo);
	
	public void delete(Integer id);
	
	public List<UserInfo> findAll();
	
	public UserInfo get(Integer id);
	
	public Page findByPage(UserInfo userinfo,int pageNo ,int PageSize);
	
	public void batchDelete(String ids);
	
	public List findCompanyVipUser(Integer id );
	
	

}
