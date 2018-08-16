package models;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends Employee {

    private Manager manager;

    public Admin(String name, int nin, int salary, Manager manager) {
        super(name, nin, salary);
        this.manager = manager;
    }

    public Admin() {
    }


    @ManyToOne
    @JoinColumn(name="manager_id", nullable = false)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}