import db.DBHelper;
import db.DBManager;
import models.Admin;
import models.Manager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager1 = new Manager("Sally", 345, 45000, 10000, "IT");
        Manager manager2 = new Manager("Vicky", 222, 50000, 10000, "Games");
        DBHelper.save(manager1);
        DBHelper.save(manager2);

        Admin admin = new Admin("Stuart", 666, 12000, manager1);
        DBHelper.save(admin);

        List<Manager> managers = DBHelper.getAll(Manager.class);
        List<Admin> admins = DBHelper.getAll(Admin.class);

        List<Admin> adminsOfManagers = DBManager.getAdminsForManager(manager1);
    }
}
