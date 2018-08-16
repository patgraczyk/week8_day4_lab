import db.DBAdmin;
import db.DBHelper;
import db.DBManager;
import models.Admin;
import models.Department;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager1 = new Manager("Sally", 345, 45000, 1000);
        Manager manager2 = new Manager("Vicky", 222, 50000, 12000);
        Manager manager3 = new Manager("Jane", 345, 34000, 85000);
        DBHelper.save(manager1);
        DBHelper.save(manager2);
        DBHelper.save(manager3);

        Department department1 = new Department("The best one", manager1);
        Department department2 = new Department("The only", manager2);
        DBHelper.save(department1);
        DBHelper.save(department2);


        Admin admin = new Admin("Stuart", 666, 12000, manager1);
        DBHelper.save(admin);


        List<Manager> managers = DBHelper.getAll(Manager.class);
        List<Admin> admins = DBHelper.getAll(Admin.class);

        List<Admin> adminsOfManagers = DBManager.getAdminsForManager(manager1);

        Manager manager = DBAdmin.getManagerOfAdmin(admin);

        Department departmentFound = DBManager.getDepartmentForManager(manager1);

        Double budgetAvg = DBManager.returnAverageBudget();

        List<Manager> managersOrderedBy = DBManager.orderManagersByBudget();


    }
}
