/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import helper.TemporaryObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        this.nama = request.getParameter("name");
        this.alamat = request.getParameter("addr");
        this.telp = request.getParameter("phone");
        this.email = request.getParameter("email");
        boolean allIsWell = true;
        if (this.checkLogin(request) == 0 && allIsWell) {
            UserModel user = new UserModel();
            ArrayList<TemporaryObject> resultSet = user.getUser(username, oldPassword);
            TemporaryObject userDetails = resultSet.get(0);
                    int[] data = new int[5];

        data[0] = this.checkPassword();
        data[1] = this.checkNama();
        data[2] = this.checkEmail();
        data[3] = this.checkAddress();
        data[4] = this.checkTelp();
            if (data[0] == 1) {
                this.password = userDetails.get(1);
            } else if (data[1] == 2) {
                allIsWell = false;
                    request.setAttribute("passwordError", "Password Anda harus harus lebih dari 5 karakter!");
                } else if (data[1] == 3) {
                    allIsWell = false;
                    request.setAttribute("passwordError", "Password tidak cocok!");
                } 
            if (data[3] == 1) {
                this.alamat = userDetails.get(3);
            } else if (data[3] == 2) {
                allIsWell = false;
                request.setAttribute("addressError", "Alamat Anda hanya bisa terdiri dari kombinasi huruf, angka dan tanda (. , / : -)");
            }
            
            if (data[1] == 1) {
                this.nama = userDetails.get(2);
            } else if (data[1] == 2) {
                allIsWell = false;
                request.setAttribute("nameError", "Nama Anda hanya bisa terdiri dari kombinasi huruf dan spasi");
            }
            
            if (data[2] == 1) {
                this.email = userDetails.get(4);
            } else if (data[2] == 2) {
                allIsWell = false;
                request.setAttribute("emailError", "Format alamat e-mail Anda tidak sah!");
            }

            if (data[4] == 1) {
                this.telp = userDetails.get(5);
            } else if (data[4] == 2) {
                allIsWell = false;
                request.setAttribute("phoneError", "Nomor telepon Anda hanya bisa terdiri dari kombinasi angka~");
            }
            if (allIsWell) {
                user.updateCustomer(username, password, nama, alamat, email, telp);

                request.setAttribute("update", "Update data berhasil!!");
            } else {
                request.setAttribute("update", "Format data salah!");
            }
        } else {
            request.setAttribute("update", "Mohon isi password Anda!");
        }
request.getRequestDispatcher("/Edit_User_Profile.jsp").forward(request, response);


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
