package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GifSysPermissionPageSettingsConverter implements ITypeConverter<GifSysPermissionPageSettingsModel>, IDefaultValueProvider<GifSysPermissionPageSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public GifSysPermissionPageSettingsModel create() {
        return new GifSysPermissionPageSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public GifSysPermissionPageSettingsModel mo236to(String str) {
        GifSysPermissionPageSettingsModel gifSysPermissionPageSettingsModel = (GifSysPermissionPageSettingsModel) GsonUtils.from(str, GifSysPermissionPageSettingsModel.class);
        if (gifSysPermissionPageSettingsModel != null) {
            return gifSysPermissionPageSettingsModel;
        }
        Logger.m271e("GifSysPermissionPageSettingsConverter", "gifSysPermissionPageSettingsModel from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(GifSysPermissionPageSettingsModel gifSysPermissionPageSettingsModel) {
        return GsonUtils.toJson(gifSysPermissionPageSettingsModel);
    }
}
