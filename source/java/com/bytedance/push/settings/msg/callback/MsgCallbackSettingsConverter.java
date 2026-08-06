package com.bytedance.push.settings.msg.callback;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;

/* loaded from: classes4.dex */
public class MsgCallbackSettingsConverter implements ITypeConverter<MsgCallbackSettingsModel>, IDefaultValueProvider<MsgCallbackSettingsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public MsgCallbackSettingsModel create() {
        return new MsgCallbackSettingsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public MsgCallbackSettingsModel to(String str) {
        return new MsgCallbackSettingsModel(str);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(MsgCallbackSettingsModel msgCallbackSettingsModel) {
        return msgCallbackSettingsModel.toString();
    }
}
