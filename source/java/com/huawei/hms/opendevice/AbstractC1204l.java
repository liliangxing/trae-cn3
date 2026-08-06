package com.huawei.hms.opendevice;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.vmsdk.inspector_new.server.websocket.Utf8Charset;
import com.huawei.android.hms.openid.C0995R;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.encrypt.utils.BaseKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.RootKeyUtil;
import com.huawei.secure.android.common.encrypt.utils.WorkKeyCryptUtil;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SecretUtil.java */
/* renamed from: com.huawei.hms.opendevice.l */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class AbstractC1204l {

    /* renamed from: a */
    private static final String f1612a = "l";

    /* renamed from: b */
    private static Map<String, String> f1613b = new HashMap();

    /* renamed from: c */
    private static final Object f1614c = new Object();

    /* renamed from: a */
    private static String m1877a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    /* renamed from: a */
    private static byte[] m1883a(String str, String str2, String str3, String str4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, true);
        }
        return BaseKeyUtil.exportRootKey(str, str2, str3, str4, 32, false);
    }

    /* renamed from: b */
    private static byte[] m1887b() {
        return m1883a(m1890d(), m1892e(), m1888c(), m1895g());
    }

    /* renamed from: c */
    public static void m1889c(Context context) {
        synchronized (f1614c) {
            m1891d(context.getApplicationContext());
            if (m1897i()) {
                HMSLog.m2120i(f1612a, "The local secret is already in separate file mode.");
                return;
            }
            File file = new File(AbstractC1197e.m1853c(context.getApplicationContext()) + "/shared_prefs/LocalAvengers.xml");
            if (file.exists()) {
                IOUtil.deleteSecure(file);
                HMSLog.m2120i(f1612a, "destroy C, delete file LocalAvengers.xml.");
            }
            byte[] generateSecureRandom = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom2 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom3 = EncryptUtil.generateSecureRandom(32);
            byte[] generateSecureRandom4 = EncryptUtil.generateSecureRandom(32);
            String m1847a = AbstractC1196d.m1847a(generateSecureRandom);
            String m1847a2 = AbstractC1196d.m1847a(generateSecureRandom2);
            String m1847a3 = AbstractC1196d.m1847a(generateSecureRandom3);
            String m1847a4 = AbstractC1196d.m1847a(generateSecureRandom4);
            m1881a(m1847a, m1847a2, m1847a3, m1847a4, WorkKeyCryptUtil.encryptWorkKey(AbstractC1196d.m1847a(EncryptUtil.generateSecureRandom(32)), m1883a(m1847a, m1847a2, m1847a3, m1847a4)), context);
            HMSLog.m2120i(f1612a, "generate D.");
        }
    }

    /* renamed from: d */
    private static void m1891d(Context context) {
        if (m1897i()) {
            HMSLog.m2120i(f1612a, "secretKeyCache not empty.");
            return;
        }
        f1613b.clear();
        String m1853c = AbstractC1197e.m1853c(context);
        if (TextUtils.isEmpty(m1853c)) {
            return;
        }
        String m1898a = AbstractC1205m.m1898a(m1853c + "/files/math/m");
        String m1898a2 = AbstractC1205m.m1898a(m1853c + "/files/panda/p");
        String m1898a3 = AbstractC1205m.m1898a(m1853c + "/files/panda/d");
        String m1898a4 = AbstractC1205m.m1898a(m1853c + "/files/math/t");
        String m1898a5 = AbstractC1205m.m1898a(m1853c + "/files/s");
        if (C1206n.m1900a(m1898a, m1898a2, m1898a3, m1898a4, m1898a5)) {
            f1613b.put("m", m1898a);
            f1613b.put("p", m1898a2);
            f1613b.put("d", m1898a3);
            f1613b.put("t", m1898a4);
            f1613b.put("s", m1898a5);
        }
    }

    /* renamed from: e */
    private static synchronized String m1893e(Context context) {
        synchronized (AbstractC1204l.class) {
            String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(m1894f(), m1887b());
            if (C1206n.m1900a(decryptWorkKey)) {
                HMSLog.m2120i(f1612a, "keyS has been upgraded, no require operate again.");
                return decryptWorkKey;
            }
            String decryptWorkKey2 = WorkKeyCryptUtil.decryptWorkKey(m1894f(), m1896h());
            if (C1206n.m1900a(decryptWorkKey2)) {
                HMSLog.m2120i(f1612a, "keyS is encrypt by RootKeyUtil, upgrade encrypt mode.");
                m1879a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey2, m1887b()), context);
                return decryptWorkKey2;
            }
            String decryptWorkKey3 = WorkKeyCryptUtil.decryptWorkKey(m1894f(), BaseKeyUtil.exportRootKey(m1890d(), m1892e(), m1888c(), m1895g(), 32, false));
            if (C1206n.m1900a(decryptWorkKey3)) {
                HMSLog.m2120i(f1612a, "keyS is encrypt by ExportRootKey with sha1, upgrade encrypt mode to sha256.");
                m1879a(WorkKeyCryptUtil.encryptWorkKey(decryptWorkKey3, m1887b()), context);
                return decryptWorkKey3;
            }
            HMSLog.m2118e(f1612a, "all mode unable to decrypt root key.");
            return "";
        }
    }

    /* renamed from: f */
    private static String m1894f() {
        return m1878a("s");
    }

    /* renamed from: g */
    private static String m1895g() {
        return m1878a("t");
    }

    /* renamed from: h */
    private static RootKeyUtil m1896h() {
        return RootKeyUtil.newInstance(m1890d(), m1892e(), m1888c(), m1895g());
    }

    /* renamed from: i */
    private static boolean m1897i() {
        return !TextUtils.isEmpty(m1894f());
    }

    /* renamed from: b */
    public static String m1886b(Context context) {
        if (!m1897i()) {
            HMSLog.m2120i(f1612a, "work key is empty, execute init.");
            m1889c(context);
        }
        String decryptWorkKey = WorkKeyCryptUtil.decryptWorkKey(m1894f(), m1887b());
        return C1206n.m1900a(decryptWorkKey) ? decryptWorkKey : m1893e(context);
    }

    /* renamed from: a */
    public static byte[] m1882a(Context context) {
        byte[] m1848a = AbstractC1196d.m1848a(context.getString(C0995R.string.push_cat_head));
        byte[] m1848a2 = AbstractC1196d.m1848a(context.getString(C0995R.string.push_cat_body));
        return m1884a(m1885a(m1885a(m1848a, m1848a2), AbstractC1196d.m1848a(m1877a())));
    }

    /* renamed from: a */
    private static byte[] m1885a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    /* renamed from: d */
    private static String m1890d() {
        return m1878a("m");
    }

    /* renamed from: a */
    private static byte[] m1884a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] >> 2);
        }
        return bArr;
    }

    /* renamed from: e */
    private static String m1892e() {
        return m1878a("p");
    }

    /* renamed from: c */
    private static String m1888c() {
        return m1878a("d");
    }

    /* renamed from: a */
    private static void m1881a(String str, String str2, String str3, String str4, String str5, Context context) {
        String m1853c = AbstractC1197e.m1853c(context.getApplicationContext());
        if (TextUtils.isEmpty(m1853c)) {
            return;
        }
        try {
            m1880a("m", str, m1853c + "/files/math/m");
            m1880a("p", str2, m1853c + "/files/panda/p");
            m1880a("d", str3, m1853c + "/files/panda/d");
            m1880a("t", str4, m1853c + "/files/math/t");
            m1880a("s", str5, m1853c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m2118e(f1612a, "save key IOException.");
        }
    }

    /* renamed from: a */
    private static void m1879a(String str, Context context) {
        String m1853c = AbstractC1197e.m1853c(context.getApplicationContext());
        if (TextUtils.isEmpty(m1853c)) {
            return;
        }
        try {
            m1880a("s", str, m1853c + "/files/s");
        } catch (IOException unused) {
            HMSLog.m2118e(f1612a, "save keyS IOException.");
        }
    }

    /* renamed from: a */
    private static void m1880a(String str, String str2, String str3) throws IOException {
        OutputStreamWriter outputStreamWriter;
        HMSLog.m2120i(f1612a, "save local secret key.");
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str3);
            AbstractC1205m.m1899a(file);
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Utf8Charset.NAME);
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                try {
                    bufferedWriter2.write(str2);
                    bufferedWriter2.flush();
                    f1613b.put(str, str2);
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter2);
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    IOUtils.closeQuietly((Writer) outputStreamWriter);
                    IOUtils.closeQuietly((Writer) bufferedWriter);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStreamWriter = null;
        }
    }

    /* renamed from: a */
    private static String m1878a(String str) {
        String str2 = f1613b.get(str);
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
