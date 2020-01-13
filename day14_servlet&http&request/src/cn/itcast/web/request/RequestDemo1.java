package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 演示Request对象获取请求行数据
 */
@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取请求方式 ：GET
//                * String getMethod()
        String method = request.getMethod();
        System.out.println(method);
//        2. (重点掌握)获取虚拟目录：/day14
//                * String getContextPath()
        String path = request.getContextPath();
        System.out.println(path);
//        3. 获取Servlet路径: /demo1
//                * String getServletPath()
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
//        4. 获取get方式请求参数：name=zhangsan
//                * String getQueryString()
        String queryString = request.getQueryString();
        System.out.println(queryString);
//        5. (重点掌握)获取请求URI：/day14/demo1
//                * String getRequestURI():		/day14/demo1
//                * StringBuffer getRequestURL()  :http://localhost/day14/demo1
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
//        6. 获取协议及版本：HTTP/1.1
//                * String getProtocol()
        String requestProtocol = request.getProtocol();
        System.out.println(requestProtocol);
//        7. 获取客户机的IP地址：
//					* String getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
