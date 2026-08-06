package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Str2StrConvert implements ITypeConverter<String> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(String str) {
        return str;
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String to(String str) {
        return str;
    }
}
