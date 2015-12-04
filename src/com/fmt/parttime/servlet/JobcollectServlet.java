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

import com.fmt.parttime.action.JobcollectAction;
import com.fmt.parttime.action.JoblistAction;
import com.fmt.parttime.model.Jobcollect;
import com.fmt.parttime.model.Joblist;
import com.fmt.parttime.model.Message;


/**
 * 收藏
 */
public class JobcollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
    public JobcollectServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action") == null ? "" : request 
				.getParameter("action"); 
		int jobCollectID = request.getParameter("jobCollectID") == null ? 0 : Integer.parseInt(request.getParameter("jobCollectID")); 
		String jobCollectDate = request.getParameter("jobCollectDate") == null ? "" : request.getParameter("jobCollectDate").trim();
		int usersID = request.getParameter("usersID") == null ? 0 : Integer.parseInt(request.getParameter("usersID")); 
		int jobID = request.getParameter("jobID") == null ? 0 : Integer.parseInt(request.getParameter("jobID")); 
		JobcollectAction op = new JobcollectAction(); 
		Jobcollect jobcollect = new Jobcollect(); 
		jobcollect.jobCollectID = jobCollectID; 
		jobcollect.jobCollectDate = jobCollectDate; 
		jobcollect.usersID = usersID; 
		jobcollect.jobID = jobID; 
		
		if(action.equals("add")){//添加收藏
			JSONObject jsonObject = null;
			Message message = null;
			//判断是否已经收藏
			String sql = " and JobID=" + jobID + " and UsersID=" + usersID;
			List<Jobcollect> list = op.findWhere(sql);
			
			if(list !=null && list.size() >0){
				message = new Message(2,"已经收藏过了!","");
				jsonObject = JSONObject.fromObject(message);
				//返回客户端注册信息
				response.getWriter().print(jsonObject.toString());
				
				return ;
			}else{
				int id = op.add(jobcollect);
				
				if(id>0){
					Jobcollect collect = op.findById(id);
					String data = JSONObject.fromObject(collect).toString();
					message = new Message(1,"收藏成功",data);
				}else{
					message = new Message(0,"收藏失败","");
				}
				jsonObject = JSONObject.fromObject(message);
				//返回客户端注册信息
				response.getWriter().print(jsonObject.toString());
			}
			
		}else if(action.equals("list")){//展示收藏
		
			//获得相应的分页列表
			List<Jobcollect> list = op.findAll(usersID);
			//获取该用户的收藏列表
			JoblistAction jAction = new JoblistAction();
			
			List<Joblist> joblists = new ArrayList<>();
			
			for(Jobcollect jc : list){
				Joblist job = jAction.findById(jc.getJobID());
				joblists.add(job);
			}
			System.out.println("size:" + joblists.size());
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
			String sql = " and JobID=" + jobID + " and UsersID=" + usersID;
			List<Jobcollect> cList = op.findWhere(sql);
			
			if(cList!=null && cList.size()>0){
				Jobcollect collect = cList.get(0);
				//进行相应的删除
				int id = op.delete(collect.getJobCollectID());
				JSONObject jsonObject = null;
				Message message = null;
				//删除成功
				if(id >0){
				
					//获得相应的分页列表
					List<Jobcollect> list = op.findAll(usersID);
					//获取该用户的收藏列表
					JoblistAction jAction = new JoblistAction();
					
					List<Joblist> joblists = new ArrayList<>();
					
					for(Jobcollect jc : list){
						Joblist job = jAction.findById(jc.getJobID());
						joblists.add(job);
					}
					System.out.println("sizedelete:" + joblists.size());
					//将List转换成Json数组
					JSONArray jsonArray = JSONArray.fromObject(joblists);
					
					String data = jsonArray.toString();
					message = new Message(1,"删除成功", data);
					//将json数据返回给客户端
					jsonObject = JSONObject.fromObject(message);
				
				}else{
					message = new Message(0,"删除失败","");
				}
				
				response.getWriter().print(jsonObject.toString());
				
			}
			
			
		}
	}

}
