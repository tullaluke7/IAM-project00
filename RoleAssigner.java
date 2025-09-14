public class RoleAssigner {
    public static String assignRole(String department) {
        switch (department) {
            case "Engineering": return "Engineer";
            case "HR": return "HR_Manager";
            case "Finance": return "Accountant";
            default: return "Employee";
        }
    }
}
