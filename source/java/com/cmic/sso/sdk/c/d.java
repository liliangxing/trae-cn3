package com.cmic.sso.sdk.c;

import android.net.Network;
import android.net.SSLCertificateSocketFactory;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
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
/* loaded from: classes6.dex */
public class d extends a {
    private static final String[] b = {"TLSv1.2"};
    private final HttpsURLConnection d;
    private final Network e;
    private final com.cmic.sso.sdk.a f;
    private final String c = AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE;
    HostnameVerifier a = HttpsURLConnection.getDefaultHostnameVerifier();

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

    public d(HttpsURLConnection httpsURLConnection, Network network, com.cmic.sso.sdk.a aVar) {
        this.d = httpsURLConnection;
        this.e = network;
        this.f = aVar;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        String requestProperty = this.d.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        com.cmic.sso.sdk.e.c.b(this.c, "customized createSocket. host: " + str);
        com.cmic.sso.sdk.e.c.b(this.c, "plainSocket localAddress: " + socket.getLocalAddress().getHostAddress());
        if (z) {
            com.cmic.sso.sdk.e.c.b(this.c, "plainSocket close");
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket();
        if (this.e != null) {
            this.e.bindSocket(sSLSocket);
        }
        sSLSocket.connect(socket.getRemoteSocketAddress());
        this.f.a("socketip", sSLSocket.getLocalAddress().getHostAddress());
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        com.cmic.sso.sdk.e.c.b(this.c, "Setting SNI hostname");
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        SSLSession session = sSLSocket.getSession();
        if (!this.a.verify(str, session)) {
            throw new SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        com.cmic.sso.sdk.e.c.b(this.c, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
        return sSLSocket;
    }
}
