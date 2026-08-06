package com.bytedance.apm.net;

import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: classes3.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(String str) throws IOException;
}
