package com.bytedance.push.settings.signal.sync;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class SignalReportSettingsConverter implements ITypeConverter<SignalReportSettingsModel>, IDefaultValueProvider<SignalReportSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public SignalReportSettingsModel create() {
        return new SignalReportSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public SignalReportSettingsModel to(String str) {
        return (SignalReportSettingsModel) GsonUtils.from(str, SignalReportSettingsModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(SignalReportSettingsModel signalReportSettingsModel) {
        return GsonUtils.toJson(signalReportSettingsModel);
    }
}
