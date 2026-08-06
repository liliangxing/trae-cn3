package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GoogleCustomSysDialogSettingsConverter implements ITypeConverter<GoogleCustomSysDialogConfig>, IDefaultValueProvider<GoogleCustomSysDialogConfig> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public GoogleCustomSysDialogConfig create() {
        return new GoogleCustomSysDialogConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public GoogleCustomSysDialogConfig mo236to(String str) {
        GoogleCustomSysDialogConfig googleCustomSysDialogConfig = (GoogleCustomSysDialogConfig) GsonUtils.from(str, GoogleCustomSysDialogConfig.class);
        if (googleCustomSysDialogConfig != null) {
            return googleCustomSysDialogConfig;
        }
        Logger.m271e("GoogleCustomSysDialogSettingsConverter", "customSysDialogConfig from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(GoogleCustomSysDialogConfig googleCustomSysDialogConfig) {
        return GsonUtils.toJson(googleCustomSysDialogConfig);
    }
}
