/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 816601
 */
public class ShoppingListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        
        if (action != null && action.equals("logout")) {
            session.invalidate();
            response.sendRedirect("shoppingList");
            return;
        } 
        if (username != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String username = (String) request.getParameter("username");
        ArrayList<String> listitems = (ArrayList<String>) session.getAttribute("listitems");
        
        if (listitems == null) {
            listitems = new ArrayList<>();
        }
        
        if (action != null && action.equals("register")) {
            session.setAttribute("username", username);
            response.sendRedirect("shoppingList");
            return;
        }
        
        if (action.equals("add")) {
            String item = request.getParameter("itemname");
            listitems.add(item);
            session.setAttribute("listitems", listitems);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        } else if (action.equals("delete")) {
            String item = request.getParameter("itemname");
            listitems.remove(item);
            session.setAttribute("listitems", listitems);
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            return;
        }
        
    }

}