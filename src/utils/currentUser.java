package utils;

public class currentUser {
    static int id = 1;
    static String avatar;
    static int roleId;
    static String role;

    public currentUser(int userId, String ava, int rId) {
        id = userId;
        avatar = ava;
        roleId = rId;
        switch (rId) {
            case 1:
                role = "member";
            case 2:
                role = "staff";
            case 3:
                role = "admin";
        }
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        currentUser.id = id;
    }

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        currentUser.avatar = avatar;
    }

    public static int getRoleId() {
        return roleId;
    }

    public static void setRoleId(int roleId) {
        currentUser.roleId = roleId;
    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        currentUser.role = role;
    }
}
