package com.bytedance.push.settings.delay.start;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;

/* loaded from: classes4.dex */
public class DelayStartChildProcessSettingsConverter implements ITypeConverter<DelayStartChildProcessSettingsModel>, IDefaultValueProvider<DelayStartChildProcessSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public DelayStartChildProcessSettingsModel create() {
        return new DelayStartChildProcessSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public DelayStartChildProcessSettingsModel to(String str) {
        return new DelayStartChildProcessSettingsModel(str);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(DelayStartChildProcessSettingsModel delayStartChildProcessSettingsModel) {
        return delayStartChildProcessSettingsModel.toString();
    }
}
