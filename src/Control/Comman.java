package Control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Comman {
    @RequestMapping("/Sign_outt")
    public String Sign_out(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getSession().invalidate();//KILL Session()
        return "index";
    }

    @RequestMapping("/Back_UserP")
    public String Back_UserPage(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return "User_page";
    }
}
