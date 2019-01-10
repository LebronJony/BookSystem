package cn.gong.book.servlet;

import cn.gong.book.factory.ServiceFactory;
import cn.gong.book.vo.Admin;
import cn.gong.util.MD5Code;
import cn.gong.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "adminServlet",urlPatterns = "/pages/back/AdminServlet/*")
public class AdminServlet extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; //定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1); //表示截取最后一个字符串
        if (status != null){
            if ("login".equals(status)){
                path = this.login(request);
            }else if ("logout".equals(status)){
                path = this.logout(request);
            }else if ("reg".equals(status)){
                path = this.reg(request);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    private String reg(HttpServletRequest request) {
        String msg = "";
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        if (ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){
            Admin vo = new Admin();
            vo.setAid(aid);
            vo.setPassword(new MD5Code().getMD5ofStr(password+aid)); //需要加盐处理
            vo.setLastdate(new Date());
            vo.setStatus(1); //默认激活
            try {
                if (ServiceFactory.getIAdminServiceInstance().insert(vo)){
                    msg = "用户注册成功";
                }else {
                    msg = "用户注册失败";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            msg = "数据不能为空";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/admin/admin_insert.jsp");
        return "/pages/forward.jsp";
    }

    private String logout(HttpServletRequest request) {
        request.getSession().invalidate(); //表示session失效
        request.setAttribute("msg","你已经成功退出系统，请重新登录");
        request.setAttribute("url","/login.jsp");
        return "/pages/forward.jsp";
    }

    /*
 实现登录
  */
    public String login(HttpServletRequest request) {
        String msg = ""; //表示提示信息
        String url = ""; //表示跳转路径
        //取得页面中传递过来的数据
        String aid = request.getParameter("aid");
        String password = request.getParameter("password");
        //判断数据是否为空
        if (ValidateUtils.validateEmpty(aid) && ValidateUtils.validateEmpty(password)){//表示数据存在
            Admin vo = new Admin();
            vo.setAid(aid); //取得参数
            vo.setPassword(new MD5Code().getMD5ofStr(password+aid)); //需要加盐处理
            System.out.println(vo.getPassword());
            try {
                if (ServiceFactory.getIAdminServiceInstance().login(vo)){
                    request.getSession().setAttribute("aid",aid); //保存aid
                    request.getSession().setAttribute("flag",vo.getFlag()); //保存flag
                    request.getSession().setAttribute("lastdate",vo.getLastdate()); // 保存aid
                    msg = "登录成功!";
                    url = "/pages/index.jsp";
                }else {
                    msg = "登录失败，错误的ID或密码";
                    url = "/login.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            msg = "数据不能为空";
            url = "/login.jsp";
        }

        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
}
















