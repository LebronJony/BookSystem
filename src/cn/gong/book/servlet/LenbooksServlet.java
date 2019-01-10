package cn.gong.book.servlet;

import cn.gong.book.factory.ServiceFactory;
import cn.gong.book.vo.Books;
import cn.gong.book.vo.Lenbooks;
import cn.gong.book.vo.Member;
import cn.gong.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@WebServlet(name = "lenbooksServlet",urlPatterns = "/pages/back/lenbooks/LenbooksServlet/*")
public class LenbooksServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp"; //定义错误页面
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1); //表示截取最后一个字符串
        if (status != null) {
            if ("insert".equals(status)) {
                path = this.insert(request);
            }else if ("insertPro".equals(status)){
                path = this.insertPro(request);
            }else if ("listSplit".equals(status)){
                path = this.listSplit(request);
            }else if ("updateByRetdate".equals(status)){
                path = this.updateByRetdate(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    private String updateByRetdate(HttpServletRequest request) {
        String msg = "";
        //接收参数
        int leid = Integer.parseInt(request.getParameter("leid"));
        try {
            if (ServiceFactory.getILenbooksServiceInstance().updateByRetdate(leid)){
                msg = "图书已经归还";
            }else {
                msg = "数据错误，更新失败";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/lenbooks/LenbooksServlet/listSplit");
        return "/pages/forward.jsp";
    }

    private String listSplit(HttpServletRequest request) {
        int currentPage = 1;
        int lineSize = 1;
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        }catch (Exception e){}
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        }catch (Exception e){}
        String keyWord = request.getParameter("kw");
        String column = request.getParameter("col");
        if(keyWord == null){
            keyWord = "";
        }
        if (column == null){
            column = "leid";
        }

        try {
            Map<String,Object> map = ServiceFactory.getILenbooksServiceInstance().listBySplit(column,keyWord,currentPage,lineSize);
            request.setAttribute("allLenbooks",map.get("allLenbooks"));
            request.setAttribute("allRecorders",map.get("allLenbooksCounts"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("url","/pages/back/lenbooks/LenbooksServlet/listSplit");
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("lineSize",lineSize);
        return "/pages/back/lenbooks/lenbooks_list.jsp";
    }

    private String insertPro(HttpServletRequest request) {
        try {
            Map<String,Object> map = ServiceFactory.getILenbooksServiceInstance().listByMemberAndBooks();
            request.setAttribute("allMembers",map.get("allMembers"));
            request.setAttribute("allBooks",map.get("allBooks"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "/pages/back/lenbooks/lenbooks_insert.jsp";
    }

    private String insert(HttpServletRequest request) {
        String msg = "";
        String url = "";
        //接收参数
        int bid = Integer.parseInt(request.getParameter("bid"));
        String mid = request.getParameter("mid");
        if (ValidateUtils.validateEmpty(mid)){
            Lenbooks vo = new Lenbooks();
            Books books = new Books();
            books.setBid(bid);
            vo.setBooks(books); //设置图书编号
            Member member = new Member();
            member.setMid(mid);
            vo.setMember(member); //设置用户信息
            vo.setCredate(new Date());  //当前日期
            try {
                if (ServiceFactory.getILenbooksServiceInstance().insert(vo)){
                    msg = "数据增加成功";
                }else {
                    msg = "数据增加失败，请重新增加";
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            msg = "输入的内容不允许为空";

        }

        request.setAttribute("msg",msg);
        request.setAttribute("url","/pages/back/lenbooks/LenbooksServlet/insertPro");
        return  "/pages/forward.jsp";
    }
}















