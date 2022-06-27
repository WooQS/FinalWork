package servlet;

import pojo.MessageBean;
import service.MessageService;
import service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toReplay")
public class ToReplyServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int mid = Integer.parseInt(req.getParameter("id"));
		MessageService mService=new MessageServiceImpl();
		MessageBean bean = mService.findByMid(mid);
		req.setAttribute("username", bean.getUsername());
		req.setAttribute("message", bean);
		req.getRequestDispatcher("/WEB-INF/jsp/newMsg.jsp").forward(req, resp);
	}

}
