package com.mypackage.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypackage.connection.DbCon;
import com.mypackage.dao.OrderDao;
import com.mypackage.dao.OrderedProductDao;
import com.mypackage.dao.UserDao;
import com.mypackage.model.Message;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	try{
    		
    	String operation = request.getParameter("operation");
    	OrderDao orderDao = new OrderDao(DbCon.getConnection());
    	
    	if (operation.trim().equals("deleteOrder")) {
			int oid = Integer.parseInt(request.getParameter("oid"));
			orderDao.deleteOrder(oid);
			System.out.println("Order Deleted");
			
			response.sendRedirect("admin-orders.jsp");}
    	
    	
    	
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    	
    }
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
    
}
