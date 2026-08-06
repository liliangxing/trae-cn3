package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: classes6.dex */
public final class CertificateUtil {
    private static final String a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static X509Certificate getHwCbgRootCA(Context context) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(h.e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (Throwable th) {
                th = th;
                inputStream2 = context;
                d.a(inputStream2);
                throw th;
            }
        } catch (IOException e) {
            e = e;
            inputStream = null;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (RuntimeException e2) {
            e = e2;
            inputStream = null;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (KeyStoreException e3) {
            e = e3;
            inputStream = null;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e4) {
            e = e4;
            inputStream = null;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (CertificateException e5) {
            e = e5;
            inputStream = null;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            d.a(inputStream2);
            throw th;
        }
        try {
            inputStream.reset();
            keyStore.load(inputStream, "".toCharArray());
            x509Certificate = (X509Certificate) keyStore.getCertificate(h.f);
            context = inputStream;
        } catch (IOException e6) {
            e = e6;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (RuntimeException e7) {
            e = e7;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (KeyStoreException e8) {
            e = e8;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (NoSuchAlgorithmException e9) {
            e = e9;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        } catch (CertificateException e10) {
            e = e10;
            e.b(a, "loadBksCA: exception : " + e.getMessage());
            context = inputStream;
            d.a((InputStream) context);
            return x509Certificate;
        }
        d.a((InputStream) context);
        return x509Certificate;
    }
}
