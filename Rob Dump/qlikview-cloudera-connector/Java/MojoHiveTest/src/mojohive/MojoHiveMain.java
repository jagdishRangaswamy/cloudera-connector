package mojohive;

import java.io.StringWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import mojohive.MojoHiveDriver;



public class MojoHiveMain {
	
	// WARNING: BAD DRIVER NAME org.apache.hadoop.hive.jdbc.HiveDriver !!! 
	//private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	
	// Correct driver name for Hive Server 2 is org.apache.hive.jdbc.HiveDriver
	private static String drivername = "org.apache.hive.jdbc.HiveDriver";

	// Connection string to online instance is jdbc:hive2://54.218.97.70:21050/;auth=noSasl
	private static String url = "jdbc:hive2://54.218.97.70:21050/;auth=noSasl";
	
	//private static String url = "jdbc:hive://54.218.97.70:10000/default";
	//private static String url = "jdbc:hive://54.218.97.70:21050/default";
	//private static String url = "jdbc:hive2://54.218.97.70:21050/default";
	
	//private static String url = "jdbc:hive://localhost:10000/default";
	//private static String url = "jdbc:hive://54.218.97.70:10000/default";
	//private static String url = "jdbc:hive2://myhost.example.com:21050/;auth=noSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/;auth=HS2NoSasl";

	//private static String url = "jdbc:hive2://54.218.97.70:21050/default;auth=HS2NoSasl";
	
	//private static String url = "jdbc:hive://54.218.97.70:21050/;auth=HS2NoSasl";
	//private static String url = "jdbc:hive2://54.218.97.70:21050/default;auth=HS2NoSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/;auth=HS2NoSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/";
	
	// Connection refused:
	//private static String url = "jdbc:hive://54.218.97.70:21050/default";
	//private static String url = "jdbc:hive://54.218.97.70:21050/default;auth=HS2NoSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/default;auth=noSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/;auth=noSasl";
	//private static String url = "jdbc:hive://54.218.97.70:21050/;auth=HS2NoSasl";
	
	// Invalid URL error (the 'hive2' appears to cause the problem):
	//private static String url = "jdbc:hive2://54.218.97.70:21050/;auth=HS2NoSasl";
	//private static String url = "jdbc:hive2://54.218.97.70:21050/default;auth=noSasl";
	//private static String url = "jdbc:hive2://54.218.97.70:21050/;auth=noSasl";
	//private static String url = "jdbc:hive2://54.218.97.70:10000/default";
	
	// Timeout error:
	
	
	// We need a placeholder for some connection parameters 
	private static String username = "";
	private static String password = "";
	private static String queuename = "";

	
	public static void main(String[] args) throws SQLException {
		

		logUtil.LogMsg("Hello World from mojohive.MojoHiveMain");

		   
		MojoHiveDriver hive_driver;
		hive_driver = new MojoHiveDriver();
		int result = hive_driver.TestConnection(drivername, url, queuename, username, password);
		
		if( result != 0 ) {
			logUtil.LogMsg("TestConnection() failed: " + hive_driver.GetLastExceptionMessage());
			logUtil.LogMsg("Stack trace: " + hive_driver.GetLastExceptionStackTrace());
		}
		else {
			logUtil.LogMsg("TestConnection() successful.");
		}
		
		
		// Call the actual query function.
		String sql_query = "SELECT * FROM billtocodes WHERE billtocode='3DAKE'";
		String xml_result = null;
		logUtil.LogMsg("Running SQL (query): " + sql_query);
		xml_result = hive_driver.QueryResultSetAsXML(drivername, url,  queuename,  username, password, sql_query);
		if(hive_driver.GetLastErrorCode() != 0 ) {
			logUtil.LogMsg("QueryResultSetAsXML() failed: " + hive_driver.GetLastExceptionMessage());
			logUtil.LogMsg("Stack trace: " + hive_driver.GetLastExceptionStackTrace());
		}
		else {
		    logUtil.LogMsg(xml_result);
		}
				
		
		return;
		
		


	}
	
    

}