package login_page;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//@WebFilter(urlPatterns = {"/Signup"})
public class login_filter extends HttpFilter {
public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws IOException, ServletException {
    if(request.getSession().getAttribute("login_um_id")==null){
       System.out.println("---------------------->Filter");
        response.sendRedirect("index.jsp");
    }
    else{
        chain.doFilter(request,response);
    }
}

    @Override
    public void destroy() {

    }
}
