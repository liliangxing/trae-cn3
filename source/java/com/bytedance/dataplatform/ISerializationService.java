package com.bytedance.dataplatform;

import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public interface ISerializationService {
    String object2Json(Object instance);

    <T> T parseObject(String input, Type clazz);
}
