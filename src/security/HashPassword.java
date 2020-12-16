
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HashPassword {
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        
        
        
            MessageDigest md = MessageDigest.getInstance("SHA");
            
            Logger.getLogger(HashPassword.class.getName()).log(Level.SEVERE, null, "Good");
            
            md.update(password.getBytes());
            byte[] b = md.digest();
            StringBuffer sb = new StringBuffer();
            for(byte b1 : b) {
                sb.append(Integer.toHexString(b1 & 0xff).toString());
            }
           // System.out.println(sb.toString());
            return sb.toString();
    }}
    
    
//    public static void main(String[] args) {
//        String password = 
//        System.out.println(password);
//        try{
//            System.out.println(hashPassword(password));
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println(e);
//        }
//    }
//}
