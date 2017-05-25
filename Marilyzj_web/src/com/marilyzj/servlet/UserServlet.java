package com.marilyzj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.marilyzj.dao.UserDao;
import com.marilyzj.dao.impl.UserDaoImpl;
import com.marilyzj.model.Admin;

public class UserServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static final Logger LOG = LoggerFactory.getLogger(UserServlet.class);
	UserDao ud = new UserDaoImpl();
	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LOG.info("************************UserServlet********************");
		// 获取user
		Admin admin = ud.getAdmin(username);
		LOG.info(admin.toString());
		if(admin!=null){
			if(admin.getPassword().equals(password)){
				response.sendRedirect(request.getContextPath() + "/main.jsp");
				return;
			}else{
				request.getRequestDispatcher("/error.jsp").forward(request,
						response);
				return;
			}
		}else{
			request.setAttribute("error", "用户名不存在");
			request.getRequestDispatcher("/error.jsp").forward(request,
					response);
			return;
		}
		
	}

}
