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
public class Register extends HttpServlet {

    private String username;
    private String password;
    private String password2;
    private String nama;
    private String alamat;
    private String telp;
    private String email;

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
            if(user.isAlreadyExist(username)) {
                status = 4;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        this.username = request.getParameter("id");
        this.nama = request.getParameter("name");
        this.password = request.getParameter("pwd");
        this.password2 = request.getParameter("pwd2");
        this.alamat = request.getParameter("addr");
        this.telp = request.getParameter("phone");
        this.email = request.getParameter("email");

        int[] data = new int[6];

        data[0] = this.checkUsername();
        data[1] = this.checkPassword();
        data[2] = this.checkNama();
        data[3] = this.checkEmail();
        data[4] = this.checkAddress();
        data[5] = this.checkTelp();
        try {
            response.setContentType("text/html;charset=UTF-8");
            if (data[0] != 0) {
                if (data[0] == 1) {
                    request.setAttribute("usernameError", "Mohon mengisi username Anda!");
                } else if (data[0] == 2) {
                    request.setAttribute("usernameError", "Username Anda harus harus lebih dari 5 karakter!");
                } else if(data[0] == 3) {
                    request.setAttribute("usernameError", "Username Anda hanya bisa terdiri dari kombinasi huruf dan angka!");
                }else {
                    request.setAttribute("usernameError", "Username sudah digunakan pengguna lain!");
                }
            }

            if (data[1] != 0) {
                if (data[1] == 1) {
                    request.setAttribute("passwordError", "Mohon mengisi password Anda!");
                } else if (data[1] == 2) {
                    request.setAttribute("passwordError", "Password Anda harus harus lebih dari 5 karakter!");
                } else {
                    request.setAttribute("passwordError", "Password tidak cocok!");
                }
            }
            if (data[2] != 0) {
                if (data[2] == 1) {
                    request.setAttribute("nameError", "Mohon isi nama lengkap Anda!");
                } else {
                    request.setAttribute("nameError", "Nama Anda hanya bisa terdiri dari kombinasi huruf dan spasi");
                }
            }
            if (data[3] != 0) {
                if (data[3] == 1) {
                    request.setAttribute("emailError", "Mohon isi e-mail Anda!");
                } else {
                    request.setAttribute("emailError", "Format alamat e-mail Anda tidak sah!");
                }
            }
            if (data[4] != 0) {
                if (data[4] == 1) {
                    request.setAttribute("addressError", "Mohon isi alamat Anda!");
                } else {
                    request.setAttribute("addressError", "Alamat Anda hanya bisa terdiri dari kombinasi huruf, angka dan tanda (. , / : -)");
                }
            }

            if (data[5] != 0) {
                if (data[5] == 1) {
                    request.setAttribute("phoneError", "Mohon isi nomor telepon Anda!");
                } else {
                    request.setAttribute("phoneError", "Nomor telepon Anda hanya bisa terdiri dari kombinasi angka");
                }
            }
            if (data[0] + data[1] + data[2] + data[3] + data[4] + data[5] == 0) {
                request.setAttribute("registration", "Registrasi Berhasil!");
                HttpSession signIn = request.getSession(true);
                signIn.setAttribute("username", username);
                signIn.setAttribute("role", "customer");
                request.getRequestDispatcher("/Home.jsp").forward(request, response);
            }
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
        } finally {
            out.close();
        }
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
