package com.bytedance.push.settings.pull;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class PullSettingsConverter implements ITypeConverter<PullSettingsModel>, IDefaultValueProvider<PullSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public PullSettingsModel create() {
        return new PullSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public PullSettingsModel to(String str) {
        return (PullSettingsModel) GsonUtils.from(str, PullSettingsModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(PullSettingsModel pullSettingsModel) {
        return GsonUtils.toJson(pullSettingsModel);
    }
}
