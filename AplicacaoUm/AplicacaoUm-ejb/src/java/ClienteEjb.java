
import java.util.Properties;
import javax.ejb.Stateless;
import org.jboss.ejb3.annotation.Clustered;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 006108L1
 */
@Clustered
@Stateless
public class ClienteEjb implements ClienteEjbInterface {
    static int count = 0;
    
    @Override
    public String main() {
        
         Properties props = System.getProperties();
         
         System.out.println(props.getProperty("jboss.node.name"));
         System.out.println(ClienteEjb.count);
         ClienteEjb.count++;
         
         return "Camada de negócio: timestamp: ["+System.currentTimeMillis()+ "] server: " +props.getProperty("jboss.node.name")+ " contador de acessos à instância: " +ClienteEjb.count;
    }
}
