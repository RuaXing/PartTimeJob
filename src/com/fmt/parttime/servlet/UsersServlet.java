package com.fmt.parttime.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.fmt.parttime.action.UsersAction;
import com.fmt.parttime.model.Message;
import com.fmt.parttime.model.Users;


/**
 * 向android客户端返回相应的user对象的json数据信息
 * 功能方法:注册、登录、忘记密码
 */
public class UsersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
 
    public UsersServlet() {
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
		int usersID = request.getParameter("usersID") == null ? 0 : Integer.parseInt(request.getParameter("usersID")); 
		String usersName = request.getParameter("usersName") == null ? "" : request.getParameter("usersName").trim();
		String usersPwd = request.getParameter("usersPwd") == null ? "" : request.getParameter("usersPwd").trim();
		String usersInvalitCode = request.getParameter("usersInvalitCode") == null ? "" : request.getParameter("usersInvalitCode").trim();
		int usersIsForgot = request.getParameter("usersIsForgot") == null ? 0 : Integer.parseInt(request.getParameter("usersIsForgot")); 
		String usersRegDate = request.getParameter("usersRegDate") == null ? "" : request.getParameter("usersRegDate").trim();
		UsersAction op = new UsersAction(); 
		Users users = new Users(); 
		users.usersID = usersID; 
		users.usersName = usersName; 
		users.usersPwd = usersPwd; 
		users.usersInvalitCode = usersInvalitCode; 
		users.usersIsForgot = usersIsForgot; 
		users.usersRegDate = usersRegDate; 
		
		
		if(action.equals("register")){//注册
			//进行添加操作
			int id = op.add(users);
			
			JSONObject jsonObject = null;
			Message message = null;
			//判断注册是否成功
			if(id>0){
				Users model = op.findById(id);
				String data = JSONObject.fromObject(model).toString();
				message = new Message(1,"注册成功",data);
			}else{
				message = new Message(0,"注册失败","");
			}
			//将model数据序列化成json对象
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("login")){//登录
			
			String where = " and UsersName='" + usersName + "' and UsersPwd='"+usersPwd + "'";
			List<Users> list = op.findWhere(where);
			JSONObject jsonObject = null;
			Message message = null;
			//判断该用户是否存在
			if(list.size()>0){
				Users model = list.get(0);
				String data = JSONObject.fromObject(model).toString();
				message = new Message(1,"登录成功!", data);
			}else{
				message = new Message(0,"登录失败","");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("forget")){//忘记密码
			String where = " and UsersName='" + usersName + "'";
			List<Users> list = op.findWhere(where);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(list.size()>0){
				//获得原始数据
				Users model = list.get(0);
				//设置新数据
				model.usersPwd = usersPwd;
				model.usersIsForgot= usersIsForgot;
				//进行修改
				int id = op.edit(model);
				//判断修改是否成功
				if(id >0){
					message = new Message(1,"密码修改成功!","");
				}else{
					message = new Message(2,"密码修改失败","");
				}
			}else{
				message = new Message(0,"对不起找不到该用户!","");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("modfiypwd")){//忘记密码
			String oldpwd = request.getParameter("oldPwd") == null ? "" : request.getParameter("oldPwd").trim();
			String where = " and UsersName='" + usersName + "'" + " and UsersPwd='" + oldpwd + "'";
			List<Users> list = op.findWhere(where);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(list.size()>0){
				//获得原始数据
				Users model = list.get(0);
				//设置新数据
				model.usersPwd = usersPwd;
				//进行修改
				int id = op.edit(model);
				//判断修改是否成功
				if(id >0){
					message = new Message(1,"密码修改成功!","");
				}else{
					message = new Message(2,"密码修改失败","");
				}
			}else{
				message = new Message(0,"对不起找不到该用户!","");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}else if(action.equals("modfiyphone")){//修改电话
			String oldusername = request.getParameter("oldusername") == null ? "" : request.getParameter("oldusername").trim();
			String where = " and UsersName='" + oldusername  + "'" + " and UsersPwd='" + usersPwd + "'";
			List<Users> list = op.findWhere(where);
			JSONObject jsonObject = null;
			Message message = null;
			
			if(list.size()>0){
				//获得原始数据
				Users model = list.get(0);
				//设置新数据
				model.usersName = usersName;
				//进行修改
				int id = op.edit(model);
				//判断修改是否成功
				if(id >0){
					message = new Message(1,"电话修改成功!","");
				}else{
					message = new Message(2,"电话修改失败","");
				}
			}else{
				message = new Message(0,"对不起找不到该用户!","");
			}
			jsonObject = JSONObject.fromObject(message);
			//返回客户端注册信息
			response.getWriter().print(jsonObject.toString());
		}
	}

}
