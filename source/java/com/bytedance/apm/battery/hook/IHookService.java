package com.bytedance.apm.battery.hook;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public interface IHookService {
    String getInterfaceName();

    void invoke(Object obj, Method method, Object[] objArr);
}
