package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class PermissionBootSettingsConverter implements ITypeConverter<PermissionBootSettingsModel>, IDefaultValueProvider<PermissionBootSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PermissionBootSettingsModel create() {
        return new PermissionBootSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public PermissionBootSettingsModel to(String str) {
        return (PermissionBootSettingsModel) GsonUtils.from(str, PermissionBootSettingsModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PermissionBootSettingsModel permissionBootSettingsModel) {
        return GsonUtils.toJson(permissionBootSettingsModel);
    }
}
