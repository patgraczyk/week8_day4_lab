import db.DBHelper;
import db.DBManager;
import models.Admin;
import models.Department;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager1 = new Manager("Sally", 345, 45000, 10000);
        Manager manager2 = new Manager("Vicky", 222, 50000, 10000);
        DBHelper.save(manager1);
        DBHelper.save(manager2);

        Department department1 = new Department("The best one", manager1);
        Department department2 = new Department("The only", manager2);
        DBHelper.save(department1);
        DBHelper.save(department2);


        Admin admin = new Admin("Stuart", 666, 12000, manager1);
        DBHelper.save(admin);


        List<Manager> managers = DBHelper.getAll(Manager.class);
        List<Admin> admins = DBHelper.getAll(Admin.class);

        List<Admin> adminsOfManagers = DBManager.getAdminsForManager(manager1);

        Department departmentFound = DBManager.getDepartmentForManager(manager1);

    }
}
