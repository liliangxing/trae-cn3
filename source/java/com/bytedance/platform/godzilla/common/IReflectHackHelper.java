package com.bytedance.platform.godzilla.common;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public interface IReflectHackHelper {
    Field getField(Class<?> cls, String str);

    Method getMethod(Class<?> cls, String str, Class... clsArr);
}
