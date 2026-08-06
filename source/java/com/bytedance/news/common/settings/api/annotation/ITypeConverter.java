package com.bytedance.news.common.settings.api.annotation;

/* loaded from: classes4.dex */
public interface ITypeConverter<T> extends com.bytedance.platform.settingsx.api.ITypeConverter<T> {
    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    String from(T t);

    @Override // com.bytedance.platform.settingsx.api.ITypeConverter
    T to(String str);
}
