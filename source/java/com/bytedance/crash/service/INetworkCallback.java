package com.bytedance.crash.service;

/* loaded from: classes3.dex */
public interface INetworkCallback {
    public static final String TYPE_TTNET = "ttnet";
    public static final String TYPE_URL_CONNECTION = "urlconnection";

    void onCallback(String str);
}
