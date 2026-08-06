package com.bytedance.platform.settingsx.convert;

import com.bytedance.platform.settingsx.api.ITypeConverter;

/* loaded from: classes4.dex */
public class Double2StrConvert implements ITypeConverter<Double> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public Double to(String str) {
        return Double.valueOf(str);
    }

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    public String from(Double d) {
        return d.toString();
    }
}
