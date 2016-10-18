package com.bit2016.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.mysite.dao.UserDao;
import com.bit2016.mysite.vo.UserVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tempNo = request.getParameter("no");
		Long no = Long.parseLong(tempNo);
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setGender(gender);
		vo.setPassword(password);
		vo.setNo(no);
	
		
		UserDao.update(vo);
		
		/*if (password.equals("")) {
			UserVo vo = new UserVo();
			vo.setName(name);
			vo.setGender(gender);
			vo.setPassword(password);
			vo.setNo(no);
			System.out.println(vo.toString());
			
			UserDao.update(vo);
		} else {
			UserVo vo = new UserVo();
			vo.setName(name);
			vo.setGender(gender);
			vo.setNo(no);
			System.out.println(vo.toString());

			
			UserDao.update(vo);
		}*/

		UserVo authUser = (UserVo) request.getSession().getAttribute("authUser");
		authUser.setName(name);
		request.getSession().setAttribute("authUser", authUser);

		WebUtil.redirect(request, response, "/mysite3/user?a=modifyform");
	}


}
