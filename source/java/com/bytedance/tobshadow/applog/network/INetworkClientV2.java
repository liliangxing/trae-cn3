package com.bytedance.tobshadow.applog.network;

import java.net.URL;
import java.util.Map;

/* loaded from: classes5.dex */
public interface INetworkClientV2 {

    /* loaded from: classes5.dex */
    public enum RequestMethod {
        METHOD_GET,
        METHOD_POST
    }

    /* loaded from: classes5.dex */
    public enum RequestType {
        REQUEST_AB,
        REQUEST_FINDER,
        REQUEST_TRACER
    }

    byte[] execute(RequestMethod requestMethod, URL url, byte[] bArr, Map<String, String> map, Map<String, Object> map2);
}
