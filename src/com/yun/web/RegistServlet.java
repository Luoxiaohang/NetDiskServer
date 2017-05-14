package com.yun.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.yun.domain.User;
import com.yun.exception.MsgException;
import com.yun.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserService service = new UserService();
		try{
//			//1.��֤��֤��
//			String valistr = request.getParameter("valistr");
//			String valistr2 = (String) request.getSession().getAttribute("valistr");
//			if(valistr == null || valistr2 == null || !valistr.equals(valistr2)){
//				request.setAttribute("msg", "��֤�벻��ȷ����");
//				request.getRequestDispatcher("/regist.jsp").forward(request, response);
//				return;
//			}
			//2.��װ���ݡ�У������
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			user.checkData();
			//3.����Service�еķ���ע���û�
			service.registUser(user);
			//4.��¼�û����ض�����ҳ
			request.getSession().setAttribute("user", user);
		}catch (MsgException e) {
			
			response.getOutputStream().write(e.getMessage().getBytes());
		//	request.setAttribute("msg", e.getMessage());
		//	request.getRequestDispatcher("/regist.jsp").forward(request, response);
			return;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
