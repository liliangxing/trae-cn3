package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Long2StrConvert implements ITypeConverter<Long> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Long to(String str) {
        return Long.valueOf(str);
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Long l) {
        return l.toString();
    }
}
