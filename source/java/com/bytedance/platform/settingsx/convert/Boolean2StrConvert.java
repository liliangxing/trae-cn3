package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Boolean2StrConvert implements ITypeConverter<Boolean> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Boolean to(String str) {
        return Boolean.valueOf(ConvertUtils.convertValueToBoolean(str, false));
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Boolean bool) {
        return bool.toString();
    }
}
