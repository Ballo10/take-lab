/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kacper
 */
@Named(value = "calculate")
@RequestScoped
public class Calculate {
    private Integer a = 0;
    private Integer b = 0;
    private Integer result = 0;
    private String date;
    /**
     * Creates a new instance of Calculate
     */
    public Calculate() {
        updateDate();
    }
    

    /**
     * @return the a
     */
    public Integer getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Integer a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Integer getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Integer b) {
        this.b = b;
    }
    
    public void add() {
        result = a + b;
        this.updateDate();
    }

    /**
     * @return the result
     */
    public Integer getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(Integer result) {
        this.result = result;
    }
    
    private void updateDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss"); 
        setDate(myDateObj.format(myFormatObj));  
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
}
