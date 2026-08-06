package com.unicom.online.account.kernel;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* renamed from: com.unicom.online.account.kernel.t */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1188t extends SSLSocketFactory {

    /* renamed from: b */
    private static final String[] f309b = {"TLSv1.1", "TLSv1.2"};

    /* renamed from: a */
    final SSLSocketFactory f310a;

    public C1188t(SSLSocketFactory sSLSocketFactory) {
        this.f310a = sSLSocketFactory;
    }

    /* renamed from: a */
    private static Socket m555a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f309b);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) {
        return m555a(this.f310a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return m555a(this.f310a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) {
        return m555a(this.f310a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return m555a(this.f310a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) {
        return m555a(this.f310a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f310a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f310a.getSupportedCipherSuites();
    }
}
