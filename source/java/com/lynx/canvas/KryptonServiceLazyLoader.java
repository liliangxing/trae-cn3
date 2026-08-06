package com.lynx.canvas;

/* loaded from: classes6.dex */
public abstract class KryptonServiceLazyLoader extends KryptonService {
    public abstract <T extends KryptonService> T createServiceInstance(Class<T> cls);
}
