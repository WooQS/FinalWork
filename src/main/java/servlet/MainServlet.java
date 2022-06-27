package servlet;

import pojo.Message;
import pojo.User;
import service.MessageService;
import service.impl.MessageServiceImpl;
import util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	MessageService mService=new MessageServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=(User) req.getSession().getAttribute("user");
		int id = user.getId();//登陆者id
		//获取页面和limit
		String p = req.getParameter("page");
		String l = req.getParameter("limit");
		System.out.println();
		if (null==p && l==null) {
			p="1";
			l="5";
		}
		Integer page = Integer.parseInt(p);
		int limit = Integer.parseInt(l);
		int count = mService.count(id);//总条数
		PageInfo pInfo=new PageInfo();
		pInfo.setLimit(limit);
		pInfo.setPage(page);
		pInfo.setCount(count);
		int totalPage = (int) Math.ceil(count * 1.0 / limit);
		pInfo.setTotalPage(totalPage);
		req.getSession().setAttribute("pageInfo", pInfo);
		List<Message> list = mService.findById(id,page,limit);
		req.getSession().setAttribute("messageList", list);
		req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, resp);
	}

}
