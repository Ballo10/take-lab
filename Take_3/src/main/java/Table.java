/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import Models.Student;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Kacper
 */
@Named(value = "table")
@RequestScoped
public class Table {

    private List<Student> students;

    /**
     * Creates a new instance of Table
     */
    public Table() {
        students = new ArrayList<Student>() {
            {
                add(new Student("Kacper", "Balicki", 4.44));
                add(new Student("Michał", "Harnolewski", 3.33));
                add(new Student("Zdzisław", "Tatrzański", 3.00));
                add(new Student("Dawid", "Chmielewski", 3.69));
            }
        };
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
