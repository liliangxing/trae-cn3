package com.bytedance.push.settings.permission.boot;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HwCustomSysDialogSettingsConverter implements ITypeConverter<BusinessCustomSysDialogConfig>, IDefaultValueProvider<BusinessCustomSysDialogConfig> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public BusinessCustomSysDialogConfig create() {
        return new BusinessCustomSysDialogConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public BusinessCustomSysDialogConfig mo236to(String str) {
        BusinessCustomSysDialogConfig businessCustomSysDialogConfig = (BusinessCustomSysDialogConfig) GsonUtils.from(str, BusinessCustomSysDialogConfig.class);
        if (businessCustomSysDialogConfig != null) {
            return businessCustomSysDialogConfig;
        }
        Logger.m271e("CustomSysDialogSettingsConverter", "customSysDialogConfig from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(BusinessCustomSysDialogConfig businessCustomSysDialogConfig) {
        return GsonUtils.toJson(businessCustomSysDialogConfig);
    }
}
