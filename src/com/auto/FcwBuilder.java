package com.auto;

import com.auto.business.Po;

public class FcwBuilder {

	public void ptString(Po o) {

		String struts = "<action name=\"" + o.getFirstLowClassName() + "\"\n";
		struts += "class=\"com.fcw.action.admin." + o.getClassName() + "Action\">\n";
		struts += "\t<result name=\"list\">/admin/" + o.getClassName().toLowerCase() + "/list.jsp</result>\n";
		struts += "\t<result name=\"edit\">/admin/" + o.getClassName().toLowerCase() + "/edit.jsp</result>\n";
		struts += "</action> ";

		String application = "<bean id=\"" + o.getFirstLowClassName() + "Manager\"\n";
		application += "\tclass=\"com.fcw.service.impl." + o.getClassName() + "ManagerImpl\"\n";
		application += "\tparent=\"" + o.getFirstLowClassName() + "Template\"/>";

		String str = "<bean id=\"" + o.getFirstLowClassName() + "Dao\" class=\"com.fcw.dao.impl." + o.getClassName() + "DaoHibernate\" parent=\"daoTemplate\"/>";

		System.out.println("struts.xml-----------/////////////////////");
		System.out.println(struts);

		System.out.println("daoContext.xml-----------/////////////////////");
		System.out.println(str);

		System.out.println("application.xml-----------/////////////////////");
		System.out.println(application);

		String zz = "<bean id=\"" + o.getFirstLowClassName() + "Template\" abstract=\"true\" lazy-init=\"true\" p:" + o.getFirstLowClassName() + "Dao-ref=\"" + o.getFirstLowClassName() + "Dao\" />";
		System.out.println("xxx.xml-----------/////////////////////");
		System.out.println(zz);
	}

	public void fcnewschannelBuilder() {

		Po o = new Po("NewsChannel", "新闻频道", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "频道名称");
		o.add("Integer", "newsCount", "新闻数量");
		o.add("Integer", "status", "状态");
		o.add("String", "create_time", "创建时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);

	}

	public void newsBuilder() {
		Po o = new Po("News", "新闻", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "标题");
		o.add("String", "description", "描述");
		o.add("String", "content", "内容");
		o.add("String", "author", "发布者");
		o.add("String", "pbTime", "发布时间");
		o.add("Integer", "upCount", "顶");
		o.add("Integer", "downCount", "踩");
		o.add("Integer", "visitCount", "访问量");
		o.add("Integer", "channelId", "频道ID");
		o.add("String", "channelName", "频道名称");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);

	}

	public void userBuilder() {
		Po o = new Po("Users", "用户", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "account", "帐号名");
		o.add("String", "nick", "昵称");
		o.add("String", "email", "邮箱");
		o.add("String", "password", "密码");
		o.add("String", "apyTime", "申请时间");
		o.add("Integer", "group", "用户类型");
		o.add("Integer", "status", "是否通过验证");

		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void userInfoBuilder() {
		Po o = new Po("UserInfo", "用户资料", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "companyId", "公司ID");
		o.add("String", "companyName", "公司名称");
		o.add("String", "realName", "真实名字");
		o.add("Integer", "male", "性别");
		o.add("String", "age", "年龄");
		o.add("String", "phone", "联系电话");
		o.add("Integer", "userId", "用户id");
		o.add("String", "lastUpdateTime", "最近修改时间");
		o.add("Integer", "score", "积分");
		o.add("Integer", "status", "状态");

		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void resourceChannelBuilder() {
		Po o = new Po("ResourceChannel", "房产资源频道", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "频道名称");
		o.add("Integer", "channelCount", "子频道数量");
		o.add("Integer", "sortNum", "排列序号");
		o.add("Integer", "parentId", "父频道ID");
		o.add("String", "createTime", "创建时间");
		o.add("Integer", "status", "状态");

		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void resourceBuilder() {
		Po o = new Po("Resource", "房产资源", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "公司名称");
		o.add("Integer", "channelId", "频道ID");
		o.add("String", "area", "所属地区");
		o.add("String", "industry", "主营范围");
		o.add("String", "phone", "公司电话");
		o.add("String", "tax", "公司传真");
		o.add("String", "email", "电子邮箱");
		o.add("String", "address", "公司地址");
		o.add("String", "about", "公司概括");
		o.add("String", "description", "公司简介");
		o.add("Integer", "vip", "VIP");
		o.add("Integer", "dfRecmd", "首页推荐");
		o.add("Integer", "dfSortNum", "首页推荐排序");
		o.add("Integer", "channelRecmd", "频道推荐");
		o.add("Integer", "channelSortNum", "频道推荐排序");
		o.add("String", "createTime", "加入时间");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void resourceVisitBuilder() {
		Po o = new Po("ResourceVisit", "房产资源访客", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "resourceId", "资源ID");
		o.add("String", "resourceName", "公司名称");
		o.add("Integer", "userId", "用户ID");
		o.add("Integer", "userName", "用户名称");
		o.add("String", "userFace", "用户头像");
		o.add("String", "lastTime", "最近访问时间");
		o.add("Integer", "status", "状态");

		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void tenderBuilder() {
		Po o = new Po("Tender", "招标", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "authorId", "发布者ID");
		o.add("String", "authorName", "发布者名称");
		o.add("String", "tenderNum", "招标编号");
		o.add("String", "name", "招标项目名称");
		o.add("String", "company", "招标公司");
		o.add("String", "tenderType", "招标类别");
		o.add("String", "contact", "联系人");
		o.add("String", "phone", "联系电话");
		o.add("String", "pbTime", "发布时间");
		o.add("String", "dffDate", "有效日期");
		o.add("String", "endTime", "截至时间");
		o.add("Integer", "winnerId", "中标用户ID");
		o.add("String", "winnerName", "中标用户");
		o.add("Integer", "dfRecmd", "首页推荐");
		o.add("Integer", "dfSortNum", "首页推荐排序");
		o.add("Integer", "status", "状态");

		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void tenderGuestBuilder() {
		Po o = new Po("TenderGuest", "投标信息", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "tenderId", "招标项目ID");
		o.add("String", "tenderName", "招标项目名称");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名称");
		o.add("String", "contact", "投标人");
		o.add("String", "company", "投标公司");
		o.add("String", "phone", "联系电话");
		o.add("String", "email", "联系邮箱");
		o.add("String", "description", "描述");
		o.add("String", "guestTime", "留言时间");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void inforChannelBuilder() {
		Po o = new Po("InforChannel", "资料分类", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "分类名称");
		o.add("Integer", "channelCount", "子频道数量");
		o.add("Integer", "sortNum", "排列序号");
		o.add("Integer", "parentId", "父频道ID");
		o.add("String", "createTime", "创建时间");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void informationBuilder() {
		Po o = new Po("Information", "资料", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "channelId", "分类ID");
		o.add("String", "channelName", "分类名称");
		o.add("Integer", "userId", "上传者ID");
		o.add("String", "userName", "上传用户");
		o.add("String", "name", "资料名称");
		o.add("String", "area", "地区");
		o.add("String", "year", "年份");
		o.add("String", "intro", "简介");
		o.add("String", "filePath", "文件路径");
		o.add("String", "fileSize", "文件大小");
		o.add("String", "fileType", "文件后缀");
		o.add("String", "upTime", "上传时间");
		o.add("Integer", "vip", "vip");
		o.add("Integer", "coin", "资源币");
		o.add("Integer", "gradeCount", "评价总数");
		o.add("Integer", "score", "总评分");
		o.add("Integer", "aveScore", "评分");
		o.add("Integer", "examine", "是否审核");
		o.add("Integer", "admin", "是否管理员上传");
		o.add("Integer", "dfRecmd", "是否推荐");
		o.add("Integer", "dfSortNum", "推荐排序");
		o.add("Integer", "downCount", "下载次数");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void downLoadBuilder() {
		Po o = new Po("DownLoad", "资料下载信息", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "informationId", "资料ID");
		o.add("String", "informationName", "资料名称");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名称");
		o.add("String", "downLoadTime", "下载时间");
		o.add("String", "lastTime", "最近下载时间");
		o.add("String", "comment", "评论内容");
		o.add("Integer", "score", "评分");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void mutliSiteBuilder() {
		Po o = new Po("MutliSite", "站点信息", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "站点名称");
		o.add("String", "url", "站点Url");
		o.add("Integer", "siteNum", "站点排序");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void slideBuilder() {
		Po o = new Po("Slide", "幻灯片", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "标题");
		o.add("String", "photo", "图片地址");
		o.add("String", "url", "链接");
		o.add("Integer", "slideNum", "排序");
		o.add("Integer", "slideType", "分类");
		o.add("Integer", "status", "状态");
		o.add("String", "createTime", "上传时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void advBuilder() {
		Po o = new Po("Adv", "广告", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "名称");
		o.add("String", "photo", "图片地址");
		o.add("String", "url", "链接");
		o.add("Integer", "width", "宽");
		o.add("Integer", "height", "高");
		o.add("Integer", "advType", "分类");
		o.add("Integer", "status", "分类");
		o.add("String", "uploadTime", "修改时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void hotWordsBuilder() {
		Po o = new Po("HotWords", "热门搜索", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "name", "名称");
		o.add("String", "url", "地址");
		o.add("Integer", "sortNum", "排序");
		o.add("String", "createTime", "修改时间");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void rewardBuilder() {
		Po o = new Po("Reward", "悬赏", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "名称");
		o.add("String", "content", "内容");
		o.add("Integer", "gold", "金币");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名");
		o.add("String", "pbTime", "发布时间");
		o.add("Integer", "rpCount", "回复次数");
		o.add("Integer", "viewCount", "查看次数");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	public void rewardReplyBuilder() {
		Po o = new Po("RewardReply", "悬赏回复", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "名称");
		o.add("String", "content", "内容");
		o.add("Integer", "rewardId", "悬赏ID");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名");
		o.add("String", "pbTime", "发布时间");
		o.add("String", "url", "链接");
		o.add("Integer", "infoId", "资料ID");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}

	// 评论
	public void commentBuilder() {
		Po o = new Po("Comment", "评论", "domain");
		o.add("Integer", "id", "id");
		o.add("String", "title", "标题");
		o.add("String", "content", "内容");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名");
		o.add("String", "pbTime", "发布时间");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	/*
	 * 博客开始**********************
	 */
	
	

	// 博客信息
	public void blogInfoBuilder() {
		Po o = new Po("BlogInfo", "博客信息", "domain");
		o.add("Integer", "id", "id");
		o.add("Integer", "userId", "用户ID");
		o.add("String", "userName", "用户名称");
		o.add("String", "blogKey", "博客唯一标识");
		o.add("String", "age", "年龄");
		o.add("String", "male", "性别");
		o.add("Integer", "status", "状态");
		CodeBuilderFactory cls = new CodeBuilderFactory();
		cls.addPo(o);
		cls.setDefaultBuilderLst();
		cls.produceFiles();
		ptString(o);
	}
	
	// 文章信息
		public void articleBuilder() {
			Po o = new Po("Article", "文章", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("String", "blogName", "博客名称");
			o.add("String", "title", "标题");
			o.add("String", "content", "内容");
			o.add("String", "phTime", "发布时间");
			o.add("Integer", "view_count", "阅读次数");
			o.add("Integer", "catalogId", "分类ID");
			o.add("String", "catalogName", "分类名称");
			o.add("Integer", "status", "状态");
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void artCatalogBuilder() {
			Po o = new Po("ArtCatalog", "文章分类", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("String", "catalogName", "分类名称");
			o.add("String", "createTime", "创建时间");
			o.add("String", "articles_count", "文章数量");
			o.add("Integer", "status", "状态");
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void recordBuilder() {
			Po o = new Po("Record", "记录", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("Integer", "blogName", "博客名称");
			o.add("String", "content", "内容");
			o.add("String", "pbTime", "发布时间");
			o.add("Integer", "status", "状态");
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void friendBuilder() {
			Po o = new Po("Friend", "好友", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "fromId", "发送人ID");
			o.add("String", "fromName", "发送人名称");
			o.add("String", "content", "内容");
			o.add("Integer", "toId", "接收人ID");
			o.add("Integer", "toName", "接收人名称");
			o.add("String", "sendTime", "发送时间");
			o.add("Integer", "status", "状态");//-1拒绝  0等待 1通过
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void blogVisitBuilder() {
			Po o = new Po("BlogVisit", "博客访问信息", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("String", "blogName", "博客名称");
			o.add("Integer", "visitId", "访问人ID");
			o.add("Integer", "visitName", "访问人名称");
			o.add("String", "visitPhoto", "访问人头像");
			o.add("String", "visiteTime", "最近访问时间");//
			o.add("Integer", "status", "状态");//
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void blogGuestBuilder() {
			Po o = new Po("BlogGuest", "博客留言", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("String", "blogName", "博客名称");
			o.add("Integer", "guestId", "留言人ID");
			o.add("Integer", "guestName", "留言人名称");
			o.add("String", "guestPhoto", "留言人头像");
			o.add("String", "guestTime", "留言时间");//
			o.add("String", "title", "留言标题");//
			o.add("String", "content", "留言内容");//
			o.add("Integer", "status", "状态");//
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		
		public void messageBuilder() {
			Po o = new Po("Message", "站内信", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "fromId", "发送人ID");
			o.add("String", "fromName", "发送人名称");
			o.add("String", "title", "内容");
			o.add("String", "content", "内容");
			o.add("Integer", "toId", "接收人ID");
			o.add("Integer", "toName", "接收人名称");
			o.add("String", "sendTime", "发送时间");
			o.add("Integer", "status", "状态");//
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}
		

		public void blogCommentBuilder() {
			Po o = new Po("BlogComment", "博客评论", "domain");
			o.add("Integer", "id", "id");
			o.add("Integer", "blogId", "博客ID");
			o.add("String", "blogName", "博客名称");
			o.add("String", "title", "内容");
			o.add("String", "content", "内容");
			o.add("Integer", "cmtId", "评论人ID");
			o.add("String", "cmtName", "评论人名称");
			o.add("String", "cmtPhoto", "评论人头像");
			o.add("String", "cmtTime", "评论时间");
			o.add("Integer", "status", "状态");//
			CodeBuilderFactory cls = new CodeBuilderFactory();
			cls.addPo(o);
			cls.setDefaultBuilderLst();
			cls.produceFiles();
			ptString(o);
		}


	public static void main(String[] args) {
		FcwBuilder builder = new FcwBuilder();

		// builder.newsBuilder();
		// builder.fcnewschannelBuilder();
		// builder.userBuilder();
		// builder.userInfoBuilder();
		// builder.tenderGuestBuilder();
		// builder.inforChannelBuilder();
		// builder.informationBuilder();
		// builder.downLoadBuilder();
		// builder.mutliSiteBuilder();
		// builder.slideBuilder();
		// builder.advBuilder();
		// builder.hotWordsBuilder();
		// builder.rewardReplyBuilder();
		// builder.commentBuilder();
//		builder.blogInfoBuilder();
//		builder.articleBuilder();
//		builder.artCatalogBuilder();
//		builder.friendBuilder();
//		builder.blogVisitBuilder();
//		builder.blogGuestBuilder();
//		builder.messageBuilder();
		builder.blogCommentBuilder();

	}

}
