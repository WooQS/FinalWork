package servlet;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        User user = new User(username, password, email);
        UserService userService = new UserServiceImpl();
        int i = userService.userRegister(user);
        if(i>0){
            res.sendRedirect(req.getContextPath());
        }else {
            res.sendRedirect(req.getContextPath()+"/toRegister");
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        doGet(req,res);
    }
}
