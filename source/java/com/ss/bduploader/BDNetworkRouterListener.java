package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDNetworkRouterListener {
    public static final int ContextTypeRoutALL = 1;
    public static final int ContextTypeRoutError = 2;
    public static final int ContextTypeRoutFirst = 0;

    int networkRouteCheckNetState(int i, int i2);

    void onRouteContext(int i, int i2, String str);
}
