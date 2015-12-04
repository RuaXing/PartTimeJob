package com.fmt.parttime.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.fmt.parttime.action.VersionAction;
import com.fmt.parttime.model.Message;
import com.fmt.parttime.model.Version;

/**
 * 检查版本是否最新
 */
public class VersionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		
		String action = request.getParameter("action") == null ? "" : request 
				.getParameter("action"); 
		int versionID = request.getParameter("versionID") == null ? 0 : Integer.parseInt(request.getParameter("versionID")); 
		String apkName = request.getParameter("apkName") == null ? "" : request.getParameter("apkName").trim();
		String apkUrl = request.getParameter("apkUrl") == null ? "" : request.getParameter("apkUrl").trim();
		VersionAction op = new VersionAction(); 
		Version version = new Version(); 
		version.versionID = versionID; 
		version.apkName = apkName; 
		version.apkUrl = apkUrl; 
		
		if (action.equals("check")) {
			String where = " and ApkName = '" + apkName + "'";

			List<Version> list = op.findWhere(where);
			Message message = null;
			JSONObject jsonObject = null;
			
			if(list !=null){
				//获得当前的版本信息
				Version version2 = list.get(0);
		
				//判断是否最新版
				if(version2.getVersionID() == versionID){
					message = new Message(0,"以是最新版本了","");
				}else{
					//返回新版本的信息
					jsonObject = JSONObject.fromObject(version2);
					String data = jsonObject.toString();
					message = new Message(1,"有新版本了",data);
				}
				
				jsonObject = JSONObject.fromObject(message);
				
				response.getWriter().print(jsonObject.toString());
				
			}
			
		}
	}

}
