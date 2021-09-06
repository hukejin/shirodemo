package cn.com.godliu.shirodemo.entity;

public class RolerPermission {

    private long id;
    private long rolerId;
    private long permissionId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRolerId() {
        return rolerId;
    }

    public void setRolerId(long rolerId) {
        this.rolerId = rolerId;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }
}
