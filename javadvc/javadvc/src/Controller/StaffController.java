package Controller;

import DAO.StaffDAO;
import Model.Staff;
import java.util.*;

public class StaffController {
    private StaffDAO staffDAO;

    public StaffController() {
        staffDAO = new StaffDAO();
    }

    public List<Staff> getAllStaff() {
        return staffDAO.getAllStaff();
    }

    public boolean addStaff(Staff staff) {
        return staffDAO.addStaff(staff);
    }

    public boolean deleteStaff(int staffId) {
        return staffDAO.deleteStaff(staffId);
    }

    public boolean updateStaff(int staffId, Staff updatedStaff) {
        return staffDAO.updateStaff(staffId, updatedStaff);
    }
}