package Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.web.servlet.ModelAndView;

import java.lang.annotation.Annotation;

@Controller
public class TestController {
    @RequestMapping("/")
    public String home(){
        return "index";
    }

//    @RequestMapping("/indexx")
//    public String handleRequest(HttpServletRequest request , HttpServletResponse RE)throws  Exception{
//System.out.println("HERE");
//        //        ModelAndView m=new ModelAndView("/jsp/Home.jsp");
////        return m;
////        return "/jsp/Home.jsp";
//        String a=request.getParameter("us_id");
//        String b=request.getParameter("us_pw");
//        System.out.println("id: "+a+" pw "+b);
//        request.setAttribute("a",a);
//        request.setAttribute("b",b);
//        return "Home";
//    }


}
