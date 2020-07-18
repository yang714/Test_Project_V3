package Index_signout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/index_SOut")
public class index_SO extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.getSession().setAttribute("login_um_id",um.getId());
//        request.getSession().setAttribute("login_um_pw",um.getPw());
//        request.getSession().setAttribute("login_um_id_number",A[0]);
        request.getSession().removeAttribute("login_um_id");
        request.getSession().removeAttribute("login_um_pw");
        request.getSession().removeAttribute("login_um_id_number");
        request.getSession().removeAttribute("user_id");
        request.removeAttribute("user_id");
        request.removeAttribute("message");
        RequestDispatcher RD=request.getRequestDispatcher("index.jsp");
        RD.forward(request, response);
        super.doPost(request, response);
    }
}
