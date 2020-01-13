package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //1. String getParameter(String name):根据参数名称获取参数值 username=zs&password=123
        String username = request.getParameter("username");
//        System.out.println("post");
//        System.out.println(username);
        //根据参数名称获取参数值的数组
//        String[] hobbies = request.getParameterValues("hobby");
//        for(String hobby : hobbies){
//            System.out.println(hobby);
//        }
        //Enumeration<String> parameterNames = request.getParameterNames();

        //获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        //遍历
        Set<String> keySet = parameterMap.keySet();
        for(String name : keySet){
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for(String value : values){
                System.out.println(value);
            }
            System.out.println("--------------");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
//        String username = request.getParameter("username");
//        System.out.println("get");
//        System.out.println(username);
        this.doPost(request, response);
    }
}
