package com.bytedance.dataplatform;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface ISettings {
    <T> T getValue(String key, Type tClass, T defaultValue);
}
