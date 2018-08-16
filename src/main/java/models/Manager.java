package models;

import models.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "manager")
public class Manager extends Employee {

    private int budget;
    private Department department;
    private List<Admin> admins;

    public Manager(String name, int nin, int salary, int budget) {
        super(name, nin, salary);
        this.budget = budget;
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


    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }


    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
