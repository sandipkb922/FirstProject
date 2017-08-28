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
import com.google.appengine.api.datastore.Query.CompositeFilter;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean flag = false;
		Filter usernameCheck = new FilterPredicate(DBConstants.DB_PROPERTY_USERNAME, FilterOperator.EQUAL, username);
		Filter passwordCheck = new FilterPredicate(DBConstants.DB_PROPERTY_PASSWORD, FilterOperator.EQUAL, password);
		CompositeFilter validationCheck =
			    CompositeFilterOperator.and(usernameCheck, passwordCheck);
		Query query = new Query(DBConstants.DB_KIND_NAME).setFilter(validationCheck);
		PreparedQuery pq = datastore.prepare(query);
		UserDetails user = null;
		for(Entity entity : pq.asIterable()) {
			user = new UserDetails();
			user.loadAttributes(entity.getProperties());
			flag = true;
		}
		
		if(flag) {
			out.println("<h2>"+user.toHTMLTable()+"</h2>");
		} else {
			out.println("<h2>Invalid Credentials..</h2><br>");
		}
		out.println("<a href=\"index.html\">Back to main</a>");
	}

}