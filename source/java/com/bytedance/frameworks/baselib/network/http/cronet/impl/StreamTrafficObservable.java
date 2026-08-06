package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/* loaded from: classes2.dex */
public class StreamTrafficObservable extends Observable {
    public static final String STREAM_CONTENTTYPE = "content_type";
    public static final String STREAM_RECEIVEDBYTES = "received_bytes";
    public static final String STREAM_REQUESTLOG = "request_log";
    public static final String STREAM_SENTBYTES = "sent_bytes";
    public static final String STREAM_URL = "url";
    private static volatile StreamTrafficObservable sInstance;

    public static StreamTrafficObservable inst() {
        if (sInstance == null) {
            synchronized (StreamTrafficObservable.class) {
                if (sInstance == null) {
                    sInstance = new StreamTrafficObservable();
                }
            }
        }
        return sInstance;
    }

    public void onStreamTrafficChanged(String str, long j, long j2, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("sent_bytes", Long.valueOf(j));
        hashMap.put("received_bytes", Long.valueOf(j2));
        hashMap.put("content_type", str2);
        hashMap.put("request_log", str3);
        notifyTrafficChangedObservers(hashMap);
    }

    private void notifyTrafficChangedObservers(Map<String, Object> map) {
        setChanged();
        notifyObservers(map);
    }
}
