package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
abstract class BaseMethod<P, R> {
    private String name;

    public String getName() {
        return this.name;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setName(String str) {
        this.name = str;
    }

    public PermissionGroup getPermission() {
        return getPermissionGroup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
