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

@WebServlet("/login")
public class UserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserService userService = new UserServiceImpl();
        String result = userService.userLogin(user.getUsername(),user.getPassword());
        if (result.equals("登录成功")) {
            user = userService.findByN(username);
            req.getSession().setAttribute("user",user);
            res.sendRedirect(req.getContextPath()+"/main");
        } else {
            res.sendRedirect(req.getContextPath()+"/loginErr");
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        doGet(req,res);
    }
}
