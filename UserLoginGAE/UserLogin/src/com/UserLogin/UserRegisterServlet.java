package com.UserLogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class UserRegisterServlet extends HttpServlet {
	@SuppressWarnings("unused")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		UserDetails user = new UserDetails();
		user.setUserName(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setFirstName(request.getParameter("fname"));
		user.setLastName(request.getParameter("lname"));
		user.setEmail(request.getParameter("email"));
		user.setContactNumber(request.getParameter("phone"));
		boolean flag = false;
		Filter duplicateCheck = new FilterPredicate(DBConstants.DB_PROPERTY_USERNAME, 
				FilterOperator.EQUAL, user.getUserName());
		Query query = new Query(DBConstants.DB_KIND_NAME).setFilter(duplicateCheck);
		PreparedQuery pq = datastore.prepare(query);
		for(Entity entity : pq.asIterable()) {
			flag = true;
		}
		
		if(flag) {
			out.println("<h2>User Name already in use.. Try again..</h2>");
		} else {
			Entity userEntity = new Entity("User");
			userEntity.setProperty(DBConstants.DB_PROPERTY_USERNAME, user.getUserName());
			userEntity.setProperty(DBConstants.DB_PROPERTY_PASSWORD, user.getPassword());
			userEntity.setProperty(DBConstants.DB_PROPERTY_FIRST_NAME, user.getFirstName());
			userEntity.setProperty(DBConstants.DB_PROPERTY_LAST_NAME, user.getLastName());
			userEntity.setProperty(DBConstants.DB_PROPERTY_EMAIL, user.getEmail());
			userEntity.setProperty(DBConstants.DB_PROPERTY_CONTACT, user.getContactNumber());
			datastore.put(userEntity);
			out.println("<h2>Successfully Registered..</h2>");
		}
		out.println("<a href=\"index.html\">Back to main</a>");
	}

}