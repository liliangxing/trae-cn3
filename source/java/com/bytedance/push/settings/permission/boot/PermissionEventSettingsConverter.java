package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class PermissionEventSettingsConverter implements ITypeConverter<PermissionEventSettingsModel>, IDefaultValueProvider<PermissionEventSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PermissionEventSettingsModel create() {
        return new PermissionEventSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public PermissionEventSettingsModel to(String str) {
        return (PermissionEventSettingsModel) GsonUtils.from(str, PermissionEventSettingsModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PermissionEventSettingsModel permissionEventSettingsModel) {
        return GsonUtils.toJson(permissionEventSettingsModel);
    }
}
