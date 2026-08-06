package com.cmic.sso.sdk.p003c;

import com.cmic.sso.sdk.C0088a;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Tls12SocketFactory.java */
/* renamed from: com.cmic.sso.sdk.c.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0120c extends AbstractC0106a {

    /* renamed from: a */
    private static final String[] f246a = {"TLSv1.2"};

    /* renamed from: b */
    private final C0088a f247b;

    public String toString() {
        return "Tls12SocketFactory";
    }

    public C0120c(SSLSocketFactory sSLSocketFactory, C0088a c0088a) {
        this.delegate = sSLSocketFactory;
        this.f247b = c0088a;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return m253a(this.delegate.createSocket());
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return m253a(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return m253a(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return m253a(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return m253a(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return m253a(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    /* renamed from: a */
    private Socket m253a(Socket socket) {
        boolean z = socket instanceof SSLSocket;
        this.f247b.m60a("socketip", socket.getLocalAddress().getHostAddress());
        return socket;
    }
}
