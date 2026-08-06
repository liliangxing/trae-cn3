package com.apm.lite.p020h;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.apm.lite.h.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class C0761b extends SSLSocketFactory {

    /* renamed from: b */
    private static final String[] f487b = {"TLSv1", "TLSv1.1", "TLSv1.2", "TLSv1.3"};

    /* renamed from: c */
    private static final String[] f488c = {"TLSv1", "TLSv1.1", "TLSv1.2"};

    /* renamed from: a */
    final SSLSocketFactory f489a;

    public C0761b(SSLSocketFactory sSLSocketFactory) {
        this.f489a = sSLSocketFactory;
    }

    /* renamed from: a */
    private Socket m640a(Socket socket) {
        if (socket instanceof SSLSocket) {
            if (Build.VERSION.SDK_INT >= 29) {
                ((SSLSocket) socket).setEnabledProtocols(f487b);
            } else {
                ((SSLSocket) socket).setEnabledProtocols(f488c);
            }
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return m640a(this.f489a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m640a(this.f489a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return m640a(this.f489a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m640a(this.f489a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m640a(this.f489a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f489a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f489a.getSupportedCipherSuites();
    }
}
