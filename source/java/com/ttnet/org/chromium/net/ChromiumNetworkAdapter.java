package com.ttnet.org.chromium.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes7.dex */
public final class ChromiumNetworkAdapter {
    private ChromiumNetworkAdapter() {
    }

    public static URLConnection openConnection(URL url, NetworkTrafficAnnotationTag networkTrafficAnnotationTag) throws IOException {
        return url.openConnection();
    }

    public static URLConnection openConnection(URL url, Proxy proxy, NetworkTrafficAnnotationTag networkTrafficAnnotationTag) throws IOException {
        return url.openConnection(proxy);
    }

    public static InputStream openStream(URL url, NetworkTrafficAnnotationTag networkTrafficAnnotationTag) throws IOException {
        return url.openStream();
    }
}
