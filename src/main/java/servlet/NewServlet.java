package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/new")
public class NewServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("user");
		UserService uService=new UserServiceImpl();
		List<String> list = uService.list();
		list.remove(user.getUsername());
		req.setAttribute("username",list);
		req.getRequestDispatcher("/WEB-INF/jsp/newMsg.jsp").forward(req, resp);
	}
	
}
