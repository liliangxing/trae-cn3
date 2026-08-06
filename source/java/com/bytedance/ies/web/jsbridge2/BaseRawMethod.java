package com.bytedance.ies.web.jsbridge2;

/* loaded from: classes4.dex */
public abstract class BaseRawMethod extends BaseMethod {
    PermissionGroup permissionGroup = super.getPermissionGroup();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void invoke(Js2JavaCall js2JavaCall, LegacySupportStub legacySupportStub) throws Exception;

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public /* bridge */ /* synthetic */ PermissionGroup getPermission() {
        return super.getPermission();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.ies.web.jsbridge2.BaseMethod
    public PermissionGroup getPermissionGroup() {
        return this.permissionGroup;
    }
}
