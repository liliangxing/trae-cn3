package com.bytedance.pia.core.api.context;

/* loaded from: classes4.dex */
public interface IPiaContext {
    Object get(String str);

    String put(Object obj);

    String put(Object obj, String str);

    Object remove(String str);
}
