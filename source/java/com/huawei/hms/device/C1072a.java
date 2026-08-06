package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.util.C1305h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: X509CertUtil.java */
/* renamed from: com.huawei.hms.device.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1072a {
    /* renamed from: a */
    public static boolean m1165a(X509Certificate x509Certificate, List<X509Certificate> list) {
        if (list == null || list.size() == 0) {
            return false;
        }
        if (x509Certificate == null) {
            HMSLog.m2118e("X509CertUtil", "rootCert is null,verify failed ");
            return false;
        }
        PublicKey publicKey = x509Certificate.getPublicKey();
        for (X509Certificate x509Certificate2 : list) {
            if (x509Certificate2 != null) {
                try {
                    x509Certificate2.checkValidity();
                    x509Certificate2.verify(publicKey);
                    publicKey = x509Certificate2.getPublicKey();
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchProviderException | SignatureException | CertificateException e) {
                    HMSLog.m2118e("X509CertUtil", "verify failed " + e.getMessage());
                }
            }
            return false;
        }
        return m1167a(list);
    }

    /* renamed from: b */
    public static List<X509Certificate> m1169b(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(m1160a(it.next()));
        }
        return arrayList;
    }

    /* renamed from: c */
    private static List<String> m1172c(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 1) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return arrayList;
        } catch (JSONException e) {
            HMSLog.m2118e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    /* renamed from: b */
    public static List<X509Certificate> m1168b(String str) {
        return m1169b(m1172c(str));
    }

    /* renamed from: b */
    public static boolean m1171b(X509Certificate x509Certificate, String str, String str2) {
        if (x509Certificate == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(m1157a(x509Certificate.getSubjectDN().getName(), str));
    }

    /* renamed from: b */
    public static boolean m1170b(X509Certificate x509Certificate, String str) {
        return m1171b(x509Certificate, "OU", str);
    }

    /* renamed from: a */
    public static X509Certificate m1160a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return m1161a(Base64.decode(str));
        } catch (IllegalArgumentException e) {
            HMSLog.m2118e("X509CertUtil", "getCert failed : " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static X509Certificate m1161a(byte[] bArr) {
        try {
            return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
        } catch (CertificateException e) {
            HMSLog.m2118e("X509CertUtil", "Failed to get cert: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static String m1157a(String str, String str2) {
        int indexOf = str.toUpperCase(Locale.getDefault()).indexOf(str2 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf(",", indexOf);
        if (indexOf2 != -1) {
            return str.substring(indexOf + str2.length() + 1, indexOf2);
        }
        return str.substring(indexOf + str2.length() + 1);
    }

    /* renamed from: a */
    public static boolean m1162a(X509Certificate x509Certificate) {
        if (x509Certificate == null || x509Certificate.getBasicConstraints() == -1) {
            return false;
        }
        boolean[] keyUsage = x509Certificate.getKeyUsage();
        if (5 < keyUsage.length) {
            return keyUsage[5];
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1167a(List<X509Certificate> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (!m1162a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1163a(X509Certificate x509Certificate, String str) {
        return m1171b(x509Certificate, "CN", str);
    }

    /* renamed from: a */
    public static boolean m1164a(X509Certificate x509Certificate, String str, String str2) {
        try {
            return m1166a(x509Certificate, str.getBytes(Utf8Charset.NAME), Base64.decode(str2));
        } catch (UnsupportedEncodingException | IllegalArgumentException e) {
            HMSLog.m2118e("X509CertUtil", " plainText exception: " + e.getMessage());
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1166a(X509Certificate x509Certificate, byte[] bArr, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance(x509Certificate.getSigAlgName());
            signature.initVerify(x509Certificate.getPublicKey());
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (InvalidKeyException | NoSuchAlgorithmException | SignatureException e) {
            HMSLog.m2118e("X509CertUtil", "failed checkSignature : " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008d: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:38:0x008d */
    /* renamed from: a */
    public static X509Certificate m1159a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        KeyStore keyStore;
        InputStream inputStream3 = null;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        keyStore = KeyStore.getInstance(C1305h.f2215e);
                        inputStream2 = context.getAssets().open("hmsrootcas.bks");
                        try {
                            keyStore.load(inputStream2, "".toCharArray());
                        } catch (IOException e) {
                            e = e;
                            HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream2);
                            return null;
                        } catch (KeyStoreException e2) {
                            e = e2;
                            HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream2);
                            return null;
                        } catch (NoSuchAlgorithmException e3) {
                            e = e3;
                            HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream2);
                            return null;
                        } catch (CertificateException e4) {
                            e = e4;
                            HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                            IOUtils.closeQuietly(inputStream2);
                            return null;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        inputStream2 = null;
                        HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (KeyStoreException e6) {
                        e = e6;
                        inputStream2 = null;
                        HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (NoSuchAlgorithmException e7) {
                        e = e7;
                        inputStream2 = null;
                        HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (CertificateException e8) {
                        e = e8;
                        inputStream2 = null;
                        HMSLog.m2118e("X509CertUtil", "exception:" + e.getMessage());
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        IOUtils.closeQuietly(inputStream3);
                        throw th;
                    }
                    if (!keyStore.containsAlias(str)) {
                        HMSLog.m2118e("X509CertUtil", "Not include alias " + str);
                        HMSPackageManager.getInstance(context).setUseOldCertificate(true);
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    }
                    Certificate certificate = keyStore.getCertificate(str);
                    if (!(certificate instanceof X509Certificate)) {
                        IOUtils.closeQuietly(inputStream2);
                        return null;
                    }
                    X509Certificate x509Certificate = (X509Certificate) certificate;
                    x509Certificate.checkValidity();
                    IOUtils.closeQuietly(inputStream2);
                    return x509Certificate;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream3 = inputStream;
            }
        }
        HMSLog.m2118e("X509CertUtil", "args are error");
        return null;
    }

    /* renamed from: a */
    public static X509Certificate m1158a(Context context) {
        return m1159a(context, C1305h.f2216f);
    }
}
