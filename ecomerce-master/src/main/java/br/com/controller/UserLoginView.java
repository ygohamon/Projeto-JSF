package br.com.controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class UserLoginView {
	
	private String username;
    
    private String password;
 
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login(ActionEvent event) throws IOException {
        FacesMessage message = null;
        boolean loggedIn = false;
         
        if(username != null && username.equals("admin") && password != null && password.equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            FacesContext.getCurrentInstance().getExternalContext().redirect("GestaoEmpresas.xhtml");
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            FacesContext.getCurrentInstance().getExternalContext().redirect("GestaoEmpresas.xhtml");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
    }   

}
