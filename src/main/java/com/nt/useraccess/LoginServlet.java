package com.nt.useraccess;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = null;

        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "sravya"); 
            String sql = "SELECT role FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    role = rs.getString("role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);

            if ("Employee".equals(role)) {
                response.sendRedirect("requestAccess.jsp");
            } else if ("Manager".equals(role)) {
                response.sendRedirect("pendingRequests.jsp");
            } else if ("admin".equals(role)) {
                response.sendRedirect("createSoftware.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
