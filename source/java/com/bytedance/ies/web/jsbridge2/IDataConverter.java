package com.bytedance.ies.web.jsbridge2;

import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public interface IDataConverter {
    <T> T fromRawData(String str, Type type);

    <T> String toRawData(T t);
}
