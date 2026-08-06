package com.bytedance.push.settings.monitor;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class PushMonitorSettingsConverter implements ITypeConverter<PushMonitorSettingsModel>, IDefaultValueProvider<PushMonitorSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PushMonitorSettingsModel create() {
        return new PushMonitorSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public PushMonitorSettingsModel to(String str) {
        PushMonitorSettingsModel pushMonitorSettingsModel = (PushMonitorSettingsModel) GsonUtils.from(str, PushMonitorSettingsModel.class);
        return pushMonitorSettingsModel == null ? create() : pushMonitorSettingsModel;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PushMonitorSettingsModel pushMonitorSettingsModel) {
        return GsonUtils.toJson(pushMonitorSettingsModel);
    }
}
