package com.cmic.sso.sdk.p003c;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: CMICTlsSocketFactory.java */
/* renamed from: com.cmic.sso.sdk.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC0106a extends SSLSocketFactory {
    protected SSLSocketFactory delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
}
