package com.fmt.parttime.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.fmt.parttime.action.JoblistAction;
import com.fmt.parttime.model.Joblist;
import com.fmt.parttime.model.Message;

/**
 * 处理工作兼职列表
 */
public class JoblistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int PAGE_SIZE = 5;
       
   
    public JoblistServlet() {
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
		int jobID = request.getParameter("jobID") == null ? 0 : Integer.parseInt(request.getParameter("jobID")); 
		String jobTitle = request.getParameter("jobTitle") == null ? "" : request.getParameter("jobTitle").trim();
		String jobLat = request.getParameter("jobLat") == null ? "" : request.getParameter("jobLat").trim();
		String jobLon = request.getParameter("jobLon") == null ? "" : request.getParameter("jobLon").trim();
		String jobPostAddress = request.getParameter("jobPostAddress") == null ? "" : request.getParameter("jobPostAddress").trim();
		String jobPayFee = request.getParameter("jobPayFee") == null ? "" : request.getParameter("jobPayFee").trim();
		String jobPostDate = request.getParameter("jobPostDate") == null ? "" : request.getParameter("jobPostDate").trim();
		String jobPostCompany = request.getParameter("jobPostCompany") == null ? "" : request.getParameter("jobPostCompany").trim();
		String jobJSRQ = request.getParameter("jobJSRQ") == null ? "" : request.getParameter("jobJSRQ").trim();
		int jobZPRS = request.getParameter("jobZPRS") == null ? 0 : Integer.parseInt(request.getParameter("jobZPRS")); 
		String jobGZRQ = request.getParameter("jobGZRQ") == null ? "" : request.getParameter("jobGZRQ").trim();
		String jobGZDZ = request.getParameter("jobGZDZ") == null ? "" : request.getParameter("jobGZDZ").trim();
		String jobMSSJ = request.getParameter("jobMSSJ") == null ? "" : request.getParameter("jobMSSJ").trim();
		String jobMSDZ = request.getParameter("jobMSDZ") == null ? "" : request.getParameter("jobMSDZ").trim();
		String jobZWMS = request.getParameter("jobZWMS") == null ? "" : request.getParameter("jobZWMS").trim();
		String jobPhone = request.getParameter("jobPhone") == null ? "" : request.getParameter("jobPhone").trim();
		String jobContactUser = request.getParameter("jobContactUser") == null ? "" : request.getParameter("jobContactUser").trim();
		String jobCity = request.getParameter("jobCity") == null ? "" : request.getParameter("jobCity").trim();
		JoblistAction op = new JoblistAction(); 
		Joblist joblist = new Joblist(); 
		joblist.jobID = jobID; 
		joblist.jobTitle = jobTitle; 
		joblist.jobLat = jobLat; 
		joblist.jobLon = jobLon; 
		joblist.jobPostAddress = jobPostAddress; 
		joblist.jobPayFee = jobPayFee; 
		joblist.jobPostDate = jobPostDate; 
		joblist.jobPostCompany = jobPostCompany; 
		joblist.jobJSRQ = jobJSRQ; 
		joblist.jobZPRS = jobZPRS; 
		joblist.jobGZRQ = jobGZRQ; 
		joblist.jobGZDZ = jobGZDZ; 
		joblist.jobMSSJ = jobMSSJ; 
		joblist.jobMSDZ = jobMSDZ; 
		joblist.jobZWMS = jobZWMS; 
		joblist.jobPhone = jobPhone; 
		joblist.jobContactUser = jobContactUser; 
		joblist.jobCity = jobCity; 
		
		
		
		if(action.equals("list")){//分页查找
			System.out.println(jobCity + "<--->");
			//获得相应的页码
			int pagenum = request.getParameter("page") == null ? 1 : Integer 
					.parseInt(request.getParameter("page"));
			int start = (pagenum-1)*PAGE_SIZE;
			//获得查询工作信息
			String jobInfor = request.getParameter("jobInfo") == null ? "" : request 
					.getParameter("jobInfo").trim();  
			System.out.println(jobInfor + "--->");
			List<Joblist> list = null;
			if(!jobInfor.equals("") ){
				list = op.findByRange(start, PAGE_SIZE,jobCity,jobInfor);
			}else{
				//获得相应的分页列表
				list = op.findByRange(start, PAGE_SIZE,jobCity);
			}
			System.out.println(list.size() + "--->");
			//将List转换成Json数组
			JSONArray jsonArray = JSONArray.fromObject(list);
			
			String data = jsonArray.toString();
			Message message = new Message(1,"更新了" + list.size() + "信息", data);
			//将json数据返回给客户端
			JSONObject jsonObject = JSONObject.fromObject(message);
			
			response.getWriter().print(jsonObject.toString());
			
		}else if(action.equals("view")){//查找具体的信息
			Joblist job = op.findById(jobID);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(job !=null){
				String data = JSONObject.fromObject(job).toString();
				message = new Message(1,"找到相应的兼职信息", data);
			}else{
				message = new Message(0,"找不到相应的兼职信息","");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("applycount")){//查找具体的信息
			int count = op.getCount(jobID);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(count >0){
				message = new Message(1,"该职位以有人申请",count + "");
			}else{
				message = new Message(0,"该职位无人申请","0");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}
	}

}
