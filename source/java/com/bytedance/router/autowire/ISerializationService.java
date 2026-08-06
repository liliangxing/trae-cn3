package com.bytedance.router.autowire;

import java.lang.reflect.Type;

/* loaded from: classes4.dex */
public interface ISerializationService {
    String object2Json(Object obj);

    <T> T parseObject(String str, Type type);
}
