package com.bytedance.crash.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes3.dex */
public interface IHttpUrlConnectionInterceptor {
    HttpURLConnection getUrlConnection(URL url) throws IOException;
}
