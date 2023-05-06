package cn.biq.mn.admin.rbac.admin;


public class AdminMapper {

    public static AdminDetails toDetails(Admin entity) {
        if (entity == null) return null;
        var details = new AdminDetails();
        details.setUsername(entity.getUsername());
        return details;
    }

}
