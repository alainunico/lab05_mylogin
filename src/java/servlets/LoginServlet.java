/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import service.AccountService;

/**
 *
 * @author Alain Unico
 */
public class LoginServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("username") != null){
            String logOut = request.getParameter("logout");
            if (logOut != null && logOut.equals("reset")){
                session.invalidate();
                request.setAttribute("message", "You have successfully logged out.");
                session = request.getSession();
           
            }
        }
        getServletContext().getRequestDispatcher("/WEB-INF/LoginPage.jsp").forward(request, response);
    }
    
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username == null || username.isEmpty()){
            request.setAttribute("message", "Please input your username and password.");
        } else {
            AccountService account = new AccountService();
            
            User user = account.login(username, password);
                
            if(user != null){
                request.getSession().setAttribute("username", username);
                
                response.sendRedirect("home");
                return;
            }else {
                request.setAttribute("username", username);
                request.setAttribute("message", "Your credentials are invalid.");
            }
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/LoginPage.jsp").forward(request, response);
    }

}

