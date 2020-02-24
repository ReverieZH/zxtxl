package cn.com.controller;

import cn.com.pojo.User;
import cn.com.service.UserService;
import cn.com.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response,User user){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+" "+password);
        System.out.println(user);
       // response.setContentType("text/html;charset=utf-8");
        boolean issuccess=false;
        PrintWriter out = null;
        try {
            issuccess=userService.login(user.getUsername(),user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            out = response.getWriter();
             if(issuccess==true) {
                 System.out.println("is:"+issuccess);
                    request.getSession().setAttribute("username", user.getUsername());
                    out.write(String.valueOf(issuccess));
                    out.flush();
                    out.close();
             }else {
                 System.out.println("is:"+issuccess);
                 out.write(String.valueOf(issuccess));
                 out.flush();
                 out.close();
             }
        } catch (IOException e) {
             e.printStackTrace();
        }
    }

    @RequestMapping("changepassword")
    public void changepassword(HttpServletRequest request, HttpServletResponse response,String oldpassword,String newpassword) throws IOException {
        try {
            String username= String.valueOf(request.getSession().getAttribute("username"));

            userService.changePassword(username,oldpassword,newpassword);
            Common.alertAndRedirect(response,"修改成功","changePassword.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
        }
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            HttpSession session= request.getSession();
            session.setAttribute("username",null);

            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            Common.alertAndBack(response,e.getMessage());
            return null;
        }
    }
}
