package com.bytedance.push.settings.push.click;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushClickReportOptSettingsConverter implements ITypeConverter<PushClickReportOptSettingsModel>, IDefaultValueProvider<PushClickReportOptSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PushClickReportOptSettingsModel create() {
        return new PushClickReportOptSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public PushClickReportOptSettingsModel mo236to(String str) {
        PushClickReportOptSettingsModel pushClickReportOptSettingsModel = (PushClickReportOptSettingsModel) GsonUtils.from(str, PushClickReportOptSettingsModel.class);
        if (pushClickReportOptSettingsModel != null) {
            return pushClickReportOptSettingsModel;
        }
        Logger.m271e("PushClickReportOptSettingsConverter", "pushClickReportOptSettingsModel from json is null,return default object");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PushClickReportOptSettingsModel pushClickReportOptSettingsModel) {
        return GsonUtils.toJson(pushClickReportOptSettingsModel);
    }
}
