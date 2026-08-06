package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class PermissionBootChannelConverter implements ITypeConverter<PermissionBootChannelModel>, IDefaultValueProvider<PermissionBootChannelModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PermissionBootChannelModel create() {
        return new PermissionBootChannelModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public PermissionBootChannelModel to(String str) {
        if (str == null || str.trim().isEmpty()) {
            return create();
        }
        return (PermissionBootChannelModel) GsonUtils.from(str, PermissionBootChannelModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PermissionBootChannelModel permissionBootChannelModel) {
        return GsonUtils.toJson(permissionBootChannelModel);
    }
}
