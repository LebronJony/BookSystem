package cn.gong.book.servlet;

import cn.gong.book.factory.ServiceFactory;
import cn.gong.book.vo.Item;
import cn.gong.util.validate.ValidateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "itemServlet",urlPatterns = "/pages/back/item/ItemServlet/*")
public class ItemServlet extends HttpServlet {
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
            }else if("list".equals(status)){
                path = this.list(request);
            }
        }
        request.getRequestDispatcher(path).forward(request, response);
    }

    public String list(HttpServletRequest request) {
        try {
            request.setAttribute("allItems",ServiceFactory.getIItemServiceInstance().list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/pages/back/item/item_list.jsp";
    }

    private String insert(HttpServletRequest request) {

        String msg = "";
        String url = "";
        String name = request.getParameter("name");
        String note = request.getParameter("note");
        System.out.println(name);
        System.out.println(note);
        //数据验证
        if (ValidateUtils.validateEmpty(name) && ValidateUtils.validateEmpty(note)){
            Item vo = new Item();
            vo.setName(name);
            vo.setNote(note);

            try {
                if(ServiceFactory.getIItemServiceInstance().insert(vo)){
                    msg = "数据增加成功";
                    url = "/pages/back/item/item_insert.jsp";
                }else {
                    msg = "数据增加失败，请重新增加";
                    url = "/pages/back/item/item_insert.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            msg = "数据不能为空";
            url = "/pages/back/item/item_insert.jsp";
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
}















