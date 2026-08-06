package com.cmic.sso.sdk.c;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: CMICTlsSocketFactory.java */
/* loaded from: classes6.dex */
public abstract class a extends SSLSocketFactory {
    protected SSLSocketFactory delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
}
