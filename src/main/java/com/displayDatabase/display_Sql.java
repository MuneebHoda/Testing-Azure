package com.displayDatabase;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class display_Sql extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/learning_azure", "root",
                    "folio3");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from test_azuredb");
            out.println("<table border=1 width=50% height=50%>");
            out.println("<tr><th>Id</th><th>Name</th><th>Age</th><th>Gender</th><tr>");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String Gender = rs.getString("Gender");
                out.println(
                        "<tr><td>" + id + "</td><td>" + name + "</td><td>" + age + "</td><td>" + Gender + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            con.close();
        } catch (Exception e) {
            out.println("error");
        }
    }
}
