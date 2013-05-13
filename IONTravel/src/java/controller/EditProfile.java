/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserModel;

/**
 *
 * @author inassjunus
 */
public class EditProfile extends HttpServlet {
    private String oldPassword;
    private String password;
    private String password2;
    private String nama;
    private String telp;
    private String alamat;
    private String email;
    private String username;
    
    private int checkLogin(HttpServletRequest request) {
        int status = 0;
        if (this.oldPassword.length() < 1) {
            status = 1;
        } else {
            UserModel user = new UserModel();
            HttpSession signIn = request.getSession(true);
            this.username = (String) signIn.getAttribute("username");
            if (!user.isAlreadyExist(username, password)) {
                status = 2;
            }
        }
        return status;
    }

    private int checkPassword() {
        int status = 0;
        if (!this.password.equals(this.password2)) {
            status = 3;
        } else if (this.password.length() < 1) {
            status = 1;
        } else if (this.password.length() < 6) {
            status = 2;
        }

        return status;
    }
    
    private int checkEmail() {
        int status = 0;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (this.email.length() < 1) {
            status = 1;
        } else if (!this.email.matches(EMAIL_PATTERN)) {
            status = 2;
        }
        return status;
    }

    private int checkNama() {
        int status = 0;
        String NAME_PATTERN = "([a-zA-Z]+ +)*[a-zA-Z]+";
        if (this.nama.length() < 1) {
            status = 1;
        } else if (!this.nama.matches(NAME_PATTERN)) {
            status = 2;
        }
        return status;
    }

    private int checkTelp() {
        int status = 0;
        String PHONE_PATTERN = "[0-9]+";
        if (this.telp.length() < 1) {
            status = 1;
        } else if (!this.telp.matches(PHONE_PATTERN)) {
            status = 2;
        }
        return status;
    }

    private int checkAddress() {
        int status = 0;
        String ADDR_PATTERN = "([a-zA-Z0-9.,/:-]+ +)*[a-zA-Z0-9.,/:-]+";
        if (this.alamat.length() < 1) {
            status = 1;
        } else if (!this.alamat.matches(ADDR_PATTERN)) {
            status = 2;
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
        this.oldPassword = request.getParameter("pwdOld");
        this.password = request.getParameter("pwd");
        this.password2 = request.getParameter("pwd2");
        this.alamat = request.getParameter("addr");
        this.telp = request.getParameter("phone");
        this.email = request.getParameter("email");
        
        if (this.checkLogin(request) == 0) {
            if (this.checkPassword() == 1) {
                
            }
        } else {
            
        }
        
        
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EditProfile</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EditProfile at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }
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
