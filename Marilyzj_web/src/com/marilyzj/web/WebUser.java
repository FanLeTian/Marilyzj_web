package com.marilyzj.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.marilyzj.dao.UserDao;
import com.marilyzj.dao.impl.UserDaoImpl;
import com.marilyzj.model.User;
import com.marilyzj.model.jsonbean.Msg;
import com.marilyzj.servlet.BaseServlet;
import com.marilyzj.utils.CommonUtils;
import com.marilyzj.utils.MailUitls;
import com.marilyzj.utils.Send;
import com.marilyzj.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebUser extends BaseServlet {
	private static final long serialVersionUID = 1L;
	UserDao ud = new UserDaoImpl();
	Gson gson = new Gson();
	protected static final Logger LOG = LoggerFactory.getLogger(WebUser.class);
	Msg<User> msg = new Msg<User>();

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginName = request.getParameter("loginname");
		String password = request.getParameter("password");
		LOG.info("************************User********************");
		// 获取user
		User user = ud.getUser(loginName);
		String result = null;
		if (user != null) {
			if (user.getPassword().equals(password)) {
				msg.setCode("0");
				msg.setMsg("登录成功");
				msg.setObj(user);
				result = gson.toJson(msg);
				LOG.info("login-----"+result);
				Send.SendJson(result, request, response);
			} else {
				msg.setCode("1");
				msg.setMsg("密码错误");
				msg.setObj(null);
				result = gson.toJson(msg);
				LOG.info("login-----"+result);
				Send.SendJson(result, request, response);
			}
		} else if (user == null) {
			msg.setCode("2");
			msg.setMsg("用户不存在");
			msg.setObj(user);
			result = gson.toJson(msg);
			LOG.info("login-----"+result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 完善信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userid");
		String username = request.getParameter("username");
		String loginname = request.getParameter("loginname");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String remark = request.getParameter("remark");

		String result = null;

		if (!StringUtils.isNotEmpty(userId)) {
			msg.setCode("2");
			msg.setMsg("userId不能为空");
			msg.setObj(null);
			result = gson.toJson(msg);
			LOG.info("update-----"+result);
			Send.SendJson(result, request, response);
		} else {
			User user = ud.getUserById(userId);
			user.setUserId(userId);
			user.setUserName(username);
			user.setLoginName(loginname);
			user.setSex(sex);
			user.setPhone(phone);
			user.setEmail(email);
			user.setRemark(remark);
			boolean flag = ud.updateUser(user);
			if (flag) {
				msg.setCode("0");
				msg.setMsg("更新信息成功");
				msg.setObj(ud.getUserById(userId));
				result = gson.toJson(msg);
				LOG.info(result);
				Send.SendJson(result, request, response);
			} else {
				msg.setCode("1");
				msg.setMsg("更新信息失败");
				msg.setObj(ud.getUserById(userId));
				result = gson.toJson(msg);
				LOG.info("update-----"+result);
				Send.SendJson(result, request, response);
			}
		}
	}

	/**
	 * 注册用户
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void register(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String loginName = request.getParameter("loginname");
		String password = request.getParameter("password");
		// String userName =request.getParameter("name");
		LOG.info("========register()========");
		User exist = ud.getUser(loginName);
		String result = null;
		if (exist == null) {
			if (StringUtils.isNotEmpty(loginName)
					&& StringUtils.isNotEmpty(password)) {
				String userId = CommonUtils.uuid();
				LOG.info(userId);
				User user = new User();
				user.setUserId(userId);
				user.setLoginName(loginName);
				user.setPassword(password);
				boolean flag = ud.insertUser(user);
				if (flag) {
					msg.setCode("0");
					msg.setMsg("注册成功");
					msg.setObj(ud.getUserById(userId));
					result = gson.toJson(msg);
					LOG.info("register-----"+result);
					Send.SendJson(result, request, response);
				} else {
					msg.setCode("3");
					msg.setMsg("注册失败");
					result = gson.toJson(msg);
					LOG.info("register-----"+result);
					Send.SendJson(result, request, response);
				}
			}  else {
				msg.setCode("1");
				msg.setMsg("帐号密码不能为空");
				result = gson.toJson(msg);
				LOG.info("register-----"+result);
				Send.SendJson(result, request, response);
			}
		}else {
			msg.setCode("2");
			msg.setMsg("用户已存在");
			msg.setObj(null);
			result = gson.toJson(msg);
			LOG.info("register-----"+result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 获取验证码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void getCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		String email = request.getParameter("email");
		String result = null;
		if (!StringUtils.isNotEmpty(email)) {
			map.put("code", "1");
			map.put("msg", "邮箱不能为空");
			result = gson.toJson(map);
			LOG.info("getCode-----"+result);
			Send.SendJson(result, request, response);
		} else {
			String code = CommonUtils.getSafeCode();
			MailUitls.sendMail(email, code);
			map.put("code", "0");
			map.put("msg", code);
			result = gson.toJson(map);
			LOG.info("getCode-----"+result);
			Send.SendJson(result, request, response);
		}
	}

	/**
	 * 重置密码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void rePwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String userId = request.getParameter("userid");
		String result = null;
		if (StringUtils.isNotEmpty(userId) && StringUtils.isNotEmpty(password)) {
			User user = ud.getUserById(userId);
			user.setPassword(password);
			boolean flag = ud.updateUser(user);

			if (flag) {
				msg.setCode("0");
				msg.setMsg("更改密码成功");
				msg.setObj(ud.getUserById(userId));
				result = gson.toJson(msg);
				LOG.info(result);
				Send.SendJson(result, request, response);
			} else {
				msg.setCode("1");
				msg.setMsg("更改密码失败");
				msg.setObj(null);
				result = gson.toJson(msg);
				LOG.info(result);
				Send.SendJson(result, request, response);
			}
		} else {
			msg.setCode("2");
			msg.setMsg("参数不能为空");
			msg.setObj(null);
			result = gson.toJson(msg);
			LOG.info(result);
			Send.SendJson(result, request, response);
		}
	}
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	// public void add(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	//
	// LOG.info("getToken:  " + userGetTokenResult.toString());
	// Send.SendJson(userGetTokenResult.toString(), request, response);
	// }
	//
	//
}