package servlet;

import pojo.Message;
import pojo.User;
import service.MessageService;
import service.UserService;
import service.impl.MessageServiceImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reply")
public class ReplayServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String to_name = req.getParameter("first");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		User user = (User) req.getSession().getAttribute("user");
		Message message=new Message();
		message.setContent(content);
		message.setFrom_id(user.getId());
		message.setTitle(title);
		UserService uService=new UserServiceImpl();
		User user2 = uService.findByN(to_name);
		message.setTo_id(user2.getId());
		MessageService mService=new MessageServiceImpl();
		int i = mService.insert(message);
		if (i>0) {
			resp.sendRedirect(req.getContextPath()+"/main");
		} else {
			resp.sendRedirect(req.getContextPath()+"/new");
		}
	}

}
