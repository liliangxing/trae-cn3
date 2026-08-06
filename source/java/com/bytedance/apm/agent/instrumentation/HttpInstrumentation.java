package com.bytedance.apm.agent.instrumentation;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HttpInstrumentation {
    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        return uRLConnection instanceof HttpURLConnection ? new HttpURLConnectionExtension((HttpURLConnection) uRLConnection) : uRLConnection;
    }

    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        return uRLConnection instanceof HttpURLConnection ? new HttpURLConnectionExtension((HttpURLConnection) uRLConnection) : uRLConnection;
    }
}
