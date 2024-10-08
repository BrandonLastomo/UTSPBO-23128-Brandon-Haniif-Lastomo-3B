/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Methods;

/**
 *
 * @author brand
 */
public class Login implements LoginBlueprint{
    private String username;
    private String password;
    
    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    @Override
    // check whether the user is admin or customer
    public String credentialCheck(){        
        if ("admin".equals(this.username) && "admin@1234".equals(this.password)){
            return "admin";
        } else {
            return "customer";
        }
    }
    
}
