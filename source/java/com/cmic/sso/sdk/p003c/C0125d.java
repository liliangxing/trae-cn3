package com.cmic.sso.sdk.p003c;

import android.net.Network;
import android.net.SSLCertificateSocketFactory;
import com.cmic.sso.sdk.C0088a;
import com.cmic.sso.sdk.p009e.C0133c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* compiled from: TlsSniSocketFactory.java */
/* renamed from: com.cmic.sso.sdk.c.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0125d extends AbstractC0106a {

    /* renamed from: b */
    private static final String[] f266b = {"TLSv1.2"};

    /* renamed from: d */
    private final HttpsURLConnection f269d;

    /* renamed from: e */
    private final Network f270e;

    /* renamed from: f */
    private final C0088a f271f;

    /* renamed from: c */
    private final String f268c = "d";

    /* renamed from: a */
    HostnameVerifier f267a = HttpsURLConnection.getDefaultHostnameVerifier();

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public C0125d(HttpsURLConnection httpsURLConnection, Network network, C0088a c0088a) {
        this.f269d = httpsURLConnection;
        this.f270e = network;
        this.f271f = c0088a;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        String requestProperty = this.f269d.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        C0133c.m328b(this.f268c, "customized createSocket. host: " + str);
        C0133c.m328b(this.f268c, "plainSocket localAddress: " + socket.getLocalAddress().getHostAddress());
        if (z) {
            C0133c.m328b(this.f268c, "plainSocket close");
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket();
        if (this.f270e != null) {
            this.f270e.bindSocket(sSLSocket);
        }
        sSLSocket.connect(socket.getRemoteSocketAddress());
        this.f271f.m60a("socketip", sSLSocket.getLocalAddress().getHostAddress());
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        C0133c.m328b(this.f268c, "Setting SNI hostname");
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (!this.f267a.verify(str, session)) {
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        C0133c.m328b(this.f268c, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
        return sSLSocket;
    }
}
