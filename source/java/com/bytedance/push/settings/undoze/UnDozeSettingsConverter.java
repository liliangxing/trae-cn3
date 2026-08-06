package com.bytedance.push.settings.undoze;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;

/* loaded from: classes4.dex */
public class UnDozeSettingsConverter implements ITypeConverter<UnDozeSettingsModel>, IDefaultValueProvider<UnDozeSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public UnDozeSettingsModel create() {
        return new UnDozeSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public UnDozeSettingsModel to(String str) {
        return (UnDozeSettingsModel) GsonUtils.from(str, UnDozeSettingsModel.class);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(UnDozeSettingsModel unDozeSettingsModel) {
        return GsonUtils.toJson(unDozeSettingsModel);
    }
}
