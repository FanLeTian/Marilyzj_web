package com.marilyzj.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Send {
	public static void sendJsp(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	public  static void SendJson(String str,HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/json;charset=utf-8");
		response.setHeader("cache-control", "no-cache");
		try {
			PrintWriter out=response.getWriter();
			out.print(str);
			out.flush();
			out.close();
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}