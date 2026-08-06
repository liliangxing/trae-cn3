package com.vivo.push.p016g;

import android.content.Context;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.ttm.player.MediaPlayer;
import com.vivo.push.util.C1393t;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableEntryException;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* compiled from: RsaSecurity.java */
/* renamed from: com.vivo.push.g.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1262c implements InterfaceC1260a {

    /* renamed from: a */
    private PrivateKey f447a = null;

    /* renamed from: b */
    private PublicKey f448b = null;

    /* renamed from: c */
    private KeyStore f449c;

    /* renamed from: d */
    private X500Principal f450d;

    /* renamed from: e */
    private Context f451e;

    public C1262c(Context context) {
        this.f451e = context;
        m695a(context);
    }

    /* renamed from: a */
    private synchronized void m695a(Context context) {
        try {
            m696b();
            if (!m698b("PushRsaKeyAlias")) {
                m697b(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    @Override // com.vivo.push.p016g.InterfaceC1260a
    /* renamed from: a */
    public final String mo690a(String str) {
        try {
            if (TextUtils.isEmpty(str) || m699c(this.f451e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            PrivateKey m699c = m699c(this.f451e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(m699c);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            C1393t.m1048d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.p016g.InterfaceC1260a
    /* renamed from: a */
    public final boolean mo692a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private void m697b(Context context) {
        try {
            if (context == null) {
                C1393t.m1048d("RsaSecurity", " generateRSAKeyPairSign context == null ");
                return;
            }
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SHOULD_USE_PENALIZED);
            KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(this.f450d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(build);
            keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    /* renamed from: b */
    private boolean m698b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f449c == null) {
                m696b();
            }
            return this.f449c.containsAlias(str);
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    /* renamed from: b */
    private void m696b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f449c = keyStore;
            keyStore.load(null);
            this.f450d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    /* renamed from: c */
    private PrivateKey m699c(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = this.f447a;
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            C1393t.m1048d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        KeyStore.Entry m700d = m700d(context);
        if (m700d instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) m700d).getPrivateKey();
            this.f447a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    /* renamed from: d */
    private KeyStore.Entry m700d(Context context) throws UnrecoverableEntryException, NoSuchAlgorithmException, KeyStoreException {
        try {
            if (context == null) {
                C1393t.m1048d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!m698b("PushRsaKeyAlias")) {
                m697b(context);
            }
            return this.f449c.getEntry("PushRsaKeyAlias", null);
        } catch (Exception e) {
            m697b(context);
            KeyStore.Entry entry = this.f449c.getEntry("PushRsaKeyAlias", null);
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return entry;
        }
    }

    @Override // com.vivo.push.p016g.InterfaceC1260a
    /* renamed from: a */
    public final PublicKey mo691a() {
        try {
            PublicKey publicKey = this.f448b;
            if (publicKey != null) {
                return publicKey;
            }
            KeyStore.Entry m700d = m700d(this.f451e);
            if (!(m700d instanceof KeyStore.PrivateKeyEntry)) {
                return null;
            }
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) m700d).getCertificate().getPublicKey();
            this.f448b = publicKey2;
            return publicKey2;
        } catch (Exception e) {
            e.printStackTrace();
            C1393t.m1034a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
            return null;
        }
    }
}
