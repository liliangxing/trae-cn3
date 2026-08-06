package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Short2StrConvert implements ITypeConverter<Short> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Short to(String str) {
        return Short.valueOf(str);
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Short sh) {
        return sh.toString();
    }
}
