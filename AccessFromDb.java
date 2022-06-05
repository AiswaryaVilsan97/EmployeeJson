import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AccessFromDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Current-Root-Password");
			s = c.createStatement();
			r = s.executeQuery("select * from employee");
	
			JSONArray jsonr = new JSONArray();    
			while(r.next()) {
				JSONObject jo = new JSONObject();
				jo.put("empl_id", r.getLong("empl_id"));
				jo.put("id", r.getLong("id"));
				jo.put("empl_name", r.getString("empl_name"));
				jo.put("phone_number", r.getLong("phone_number"));
				jo.put("place", r.getString("place"));
				jo.put("role", r.getString("role"));
				jsonr.add(jo);
				      }
			JSONObject jo1 = new JSONObject();
			jo1.put("Employee_Data", jsonr);
	         FileWriter file = new FileWriter("C:\\Users\\91965\\eclipse-workspace\\EmployeeManagementSystem");
	         file.write(jo1.toJSONString());
	         file.close();
	         System.out.println("JSON FILE FOR EMPLOYEE DATA CREATED!");
		}
		catch (Exception e) {
			e.printStackTrace();
	      
	      }
		import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class AccessFromDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		Connection c = null;
		Statement s = null;
		ResultSet r = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Current-Root-Password");
			s = c.createStatement();
			r = s.executeQuery("select * from employee");
	
			JSONArray jsonr = new JSONArray();    
			while(r.next()) {
				JSONObject jo = new JSONObject();
				
				jo.put("empl_id", r.getLong("empl_id"));
				jo.put("id", r.getLong("id"));
				jo.put("empl_name", r.getString("empl_name"));
				jo.put("phone_number", r.getLong("phone_number"));
				jo.put("place", r.getString("place"));
				jo.put("role", r.getString("role"));
				jsonr.add(jo);
				      }
			JSONObject jo1 = new JSONObject();
			jo1.put("Employee_Data", jsonr);
	         FileWriter file = new FileWriter("C:\\Users\\91965\\eclipse-workspace\\EmployeeManagementSystem");
	         file.write(jo1.toJSONString());
	         file.close();
	         System.out.println("JSON FILE FOR EMPLOYEE DATA CREATED!");
		}
		catch (Exception e) {
			e.printStackTrace();
	      
	      }
		finally {
		    try {
		        if(c != null)
		            c.close();
		        if(s != null)
		            s.close();
		    } catch(SQLException sqlee) {
		        sqlee.printStackTrace();
		    } finally { 
		        c = null;
		        s = null;
		    }
		}
		}
	}
		}
	}
