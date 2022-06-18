/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;


/**
 *
 * @author Kacper
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    /**
     * Creates a new instance of LoginBean
     */
    private String username;
    private String password;
    private HtmlSelectBooleanCheckbox acceptCheckBox;
    private HtmlCommandButton loginButton;

    public HtmlSelectBooleanCheckbox getAcceptCheckBox() {
        return acceptCheckBox;
    }

    public void setAcceptCheckBox(HtmlSelectBooleanCheckbox acceptCheckBox) {
        this.acceptCheckBox = acceptCheckBox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

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

    public LoginBean() {

    }

    public String login() {
        if("scott".equals(getUsername()) && "tiger".equals(getPassword())) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ResourceBundle.getBundle("ApplicationMessages").getString("message.user")));
            context.renderResponse();
            return "";
        } else if(username.equals(password)){
            return "success";
        }
        return "failure";
    }

    public void activateButton(ValueChangeEvent e) {
        if (acceptCheckBox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse(); 
    }
}
