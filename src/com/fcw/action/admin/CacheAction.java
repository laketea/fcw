package com.fcw.action.admin;

import com.fcw.listener.DefaultCache;
import com.fcw.listener.InforCache;
import com.fcw.listener.ResourceCache;
import com.fcw.listener.TopCache;


/*
 * 缓存刷新
 */
public class CacheAction extends BaseAction {

	private Integer id = 0;

	public String reflush() {

		switch (id) {
		case 1:
			DefaultCache.getInstance().reflush();
			break;
		case 2:
			TopCache.getInstance().reflush();
			break;
		case 3:
			InforCache.getInstance().reflush();
			break;
		case 4:
			ResourceCache.getInstance().reflush();
			break;
		case 5:
			DefaultCache.getInstance().reflush();
			TopCache.getInstance().reflush();
			InforCache.getInstance().reflush();
			ResourceCache.getInstance().reflush();
			break;
		}

		return "result";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
