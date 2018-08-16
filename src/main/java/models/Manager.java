package models;

import models.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager extends Employee {

    private int budget;
    private String deparment;
    private List<Admin> admins;

    public Manager(String name, int nin, int salary, int budget, String deparment) {
        super(name, nin, salary);
        this.budget = budget;
        this.deparment = deparment;
        this.admins = new ArrayList<Admin>();
    }

    public Manager() {
    }


    @Column(name = "budget")
    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    @Column(name = "department")
    public String getDeparment() {
        return deparment;
    }

    public void setDeparment(String deparment) {
        this.deparment = deparment;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
}
