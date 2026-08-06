package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Float2StrConvert implements ITypeConverter<Float> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Float to(String str) {
        return Float.valueOf(str);
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Float f) {
        return f.toString();
    }
}
