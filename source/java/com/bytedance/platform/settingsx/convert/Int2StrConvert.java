package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Int2StrConvert implements ITypeConverter<Integer> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Integer to(String str) {
        return Integer.valueOf(str);
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Integer num) {
        return num.toString();
    }
}
