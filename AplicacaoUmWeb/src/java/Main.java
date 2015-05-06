import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 006108L1
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
   
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        
        try {
            final Hashtable props = new Hashtable();
            props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            final Context context = new javax.naming.InitialContext(props);
            
            ClienteEjbInterface cei = (ClienteEjbInterface) context.lookup("ejb:AplicacaoUm/AplicacaoUm-ejb/ClienteEjb!ClienteEjbInterface");
            out.println(cei.main());
            
            out.println("Camada web: timestamp ["+System.currentTimeMillis()+ "] server: " +System.getProperties().getProperty("jboss.node.name"));  

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
       
    }
}