package com.bytedance.push.settings.notification;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClearNotificationSettingsConverter implements ITypeConverter<ClearNotificationSettingsModel>, IDefaultValueProvider<ClearNotificationSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public ClearNotificationSettingsModel create() {
        return new ClearNotificationSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public ClearNotificationSettingsModel mo236to(String str) {
        ClearNotificationSettingsModel clearNotificationSettingsModel = (ClearNotificationSettingsModel) GsonUtils.from(str, ClearNotificationSettingsModel.class);
        if (clearNotificationSettingsModel != null) {
            return clearNotificationSettingsModel;
        }
        Logger.m271e("ClearNotificationSettingsConverter", "clearNotificationSettingsModel from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(ClearNotificationSettingsModel clearNotificationSettingsModel) {
        return GsonUtils.toJson(clearNotificationSettingsModel);
    }
}
