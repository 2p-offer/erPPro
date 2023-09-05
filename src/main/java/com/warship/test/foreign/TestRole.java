package com.warship.test.foreign;

public class TestRole {
    private long roleId;

    private String roleName;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "TestRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
