/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.TemporaryObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserModel;

/**
 *
 * @author inassjunus
 */
public class SignIn extends HttpServlet {

    private String username;
    private String password;

    private int checkUsername() {
        int status = 0;
        if (this.username.length() < 1) {
            status = 1;
        } else if (this.username.length() < 6) {
            status = 2;
        } else if (!this.username.matches("[A-Za-z0-9]+")) {
            status = 3;
        } else {
            UserModel user = new UserModel();
            if (!user.isAlreadyExist(username)) {
                status = 4;
            }
        }
        return status;
    }

    private int checkPassword() {
        int status = 0;
        if (this.password.length() < 1) {
            status = 1;
        } 
        return status;
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.username = request.getParameter("usernama");
        this.password = request.getParameter("password");
        //PrintWriter out = response.getWriter();
        int passwordStatus = this.checkPassword();
        int usernameStatus = this.checkUsername();
        if (usernameStatus == 0 && passwordStatus == 0) {
            UserModel user = new UserModel();
            if (user.isAlreadyExist(username, password)) {
                ArrayList<TemporaryObject> resultSet = user.getUser(username, password);
                String role = resultSet.get(0).get(6);

                HttpSession signIn = request.getSession(true);
                signIn.setAttribute("username", username);
                signIn.setAttribute("role", role);
            } else  {
                request.setAttribute("signinstatus", "Wrong username or password");
            }
        } else if (usernameStatus == 1 || passwordStatus == 1) {
            request.setAttribute("signinstatus", "please fill both username and password");
        } else {
            request.setAttribute("signinstatus", "username doesn't exist");
        }
        request.getRequestDispatcher("/Home.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
