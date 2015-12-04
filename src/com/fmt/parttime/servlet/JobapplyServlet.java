package com.fmt.parttime.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fmt.parttime.action.JobapplyAction;
import com.fmt.parttime.action.JoblistAction;
import com.fmt.parttime.model.Jobapply;
import com.fmt.parttime.model.Jobcollect;
import com.fmt.parttime.model.Joblist;
import com.fmt.parttime.model.Message;

/**
 * 处理申请
 */
public class JobapplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action") == null ? "" : request 
				.getParameter("action"); 
		int applyID = request.getParameter("applyID") == null ? 0 : Integer.parseInt(request.getParameter("applyID")); 
		String applyDate = request.getParameter("applyDate") == null ? "" : request.getParameter("applyDate").trim();
		int usersID = request.getParameter("usersID") == null ? 0 : Integer.parseInt(request.getParameter("usersID")); 
		int jobID = request.getParameter("jobID") == null ? 0 : Integer.parseInt(request.getParameter("jobID")); 
		int applyStatus = request.getParameter("applyStatus") == null ? 0 : Integer.parseInt(request.getParameter("applyStatus")); 
		JobapplyAction op = new JobapplyAction(); 
		Jobapply jobapply = new Jobapply(); 
		jobapply.applyID = applyID; 
		jobapply.applyDate = applyDate; 
		jobapply.usersID = usersID; 
		jobapply.jobID = jobID; 
		jobapply.applyStatus = applyStatus; 
		
		if(action.equals("add")){//添加收藏
			
			JSONObject jsonObject = null;
			Message message = null;
			
			//判断是否已经收藏
			String sql = " and JobID=" + jobID + " and UsersID=" + usersID;
			List<Jobapply> list = op.findWhere(sql);
			
			if(list !=null && list.size() >0){
				message = new Message(2,"已经申请过了!","");
				jsonObject = JSONObject.fromObject(message);
				//返回客户端注册信息
				response.getWriter().print(jsonObject.toString());
				
				return ;
			}else{
				int id = op.add(jobapply);
				
				if(id>0){
					Jobapply jobapply2 = op.findById(id);
					String data = JSONObject.fromObject(jobapply2).toString();
					message = new Message(1,"申请成功",data);
				}else{
					message = new Message(0,"申请失败","");
				}
				jsonObject = JSONObject.fromObject(message);
				//返回客户端注册信息
				response.getWriter().print(jsonObject.toString());
			}
			
		}else if(action.equals("list")){//展示收藏
		
			//获得相应的分页列表
			List<Jobapply> list = op.findAll(usersID,applyStatus);
			//获取该用户的收藏列表
			JoblistAction jAction = new JoblistAction();
			
			List<Joblist> joblists = new ArrayList<>();
			
			for(Jobapply jc : list){
				Joblist job = jAction.findById(jc.getJobID());
				joblists.add(job);
			}
			System.out.println("size1:" + joblists.size());
			//将List转换成Json数组
			JSONArray jsonArray = JSONArray.fromObject(joblists);
			
			String data = jsonArray.toString();
			Message message = new Message(1,"更新了" + joblists.size() + "信息", data);
			//将json数据返回给客户端
			JSONObject jsonObject = JSONObject.fromObject(message);
		
			//返回收藏列表
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("delete")){
			//找到相应的收藏项
			String sql = " and JobID=" + jobID + " and UsersID=" + usersID;;
			List<Jobapply> cList = op.findWhere(sql);
			
			if(cList!=null && cList.size()>0){
				Jobapply jobapply2 = cList.get(0);
				//进行相应的删除
				int id = op.delete(jobapply2.getApplyID());
				JSONObject jsonObject = null;
				Message message = null;
				//删除成功
				if(id >0){
				
					//获得相应的分页列表
					List<Jobapply> list = op.findAll(usersID,applyStatus);
					//获取该用户的收藏列表
					JoblistAction jAction = new JoblistAction();
					
					List<Joblist> joblists = new ArrayList<>();
					
					for(Jobapply jc : list){
						Joblist job = jAction.findById(jc.getJobID());
						joblists.add(job);
					}
					System.out.println("size2:" + joblists.size());
					//将List转换成Json数组
					JSONArray jsonArray = JSONArray.fromObject(joblists);
					
					String data = jsonArray.toString();
					message = new Message(1,"删除成功", data);
					
				
				}else{
					message = new Message(0,"删除失败","");
				}
				//将json数据返回给客户端
				jsonObject = JSONObject.fromObject(message);
				response.getWriter().print(jsonObject.toString());
				
			}
		
		}else if(action.equals("agreecount")){//查找具体的信息
			int count = op.getCount(jobID,1);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(count >0){
				message = new Message(1,"",count + "");
			}else{
				message = new Message(0,"","0");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}
	}

}
