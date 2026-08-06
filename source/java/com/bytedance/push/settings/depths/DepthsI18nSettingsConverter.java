package com.bytedance.push.settings.depths;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;

/* loaded from: classes4.dex */
public class DepthsI18nSettingsConverter implements ITypeConverter<DepthsI18nSettingsModel>, IDefaultValueProvider<DepthsI18nSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public DepthsI18nSettingsModel create() {
        return new DepthsI18nSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public DepthsI18nSettingsModel to(String str) {
        return new DepthsI18nSettingsModel(str);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(DepthsI18nSettingsModel depthsI18nSettingsModel) {
        return depthsI18nSettingsModel.toString();
    }
}
