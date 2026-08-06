package com.bytedance.tobshadow.bdtracker;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.applog.encryptor.EncryptorUtil;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.tobshadow.applog.IAppLogInstance;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.encryptor.IEncryptorType;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.n5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0480n5 {

    /* renamed from: b */
    public static final String[] f886b = {"tt_data", "device_platform"};

    /* renamed from: c */
    public static final String[] f887c = {Constant.KEY_AID, "version_code", "ab_version", "iid", "device_platform"};

    /* renamed from: d */
    public static final String[] f888d = {Constant.KEY_AID, Constant.KEY_APP_VERSION, "tt_data", "device_id"};

    /* renamed from: a */
    public final C0467m f889a;

    public C0480n5(C0467m c0467m) {
        this.f889a = c0467m;
    }

    /* renamed from: a */
    public static String m580a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; bArr != null && i < bArr.length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static void m582a(IAppLogInstance iAppLogInstance, JSONObject jSONObject) {
        String[] m584a;
        boolean encryptAndCompress = iAppLogInstance.getEncryptAndCompress();
        InitConfig initConfig = iAppLogInstance.getInitConfig();
        boolean isResponseEncryptEnabled = initConfig != null ? initConfig.isResponseEncryptEnabled() : true;
        if (encryptAndCompress && isResponseEncryptEnabled && (m584a = m584a()) != null) {
            try {
                jSONObject.put("key", m584a[0]);
                jSONObject.put("iv", m584a[1]);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m583a(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            int length = str.length();
            byte[] bArr2 = new byte[length];
            for (int i = 0; i < length; i++) {
                bArr2[i] = (byte) str.charAt(i);
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            int length2 = str2.length();
            byte[] bArr3 = new byte[length2];
            for (int i2 = 0; i2 < length2; i2++) {
                bArr3[i2] = (byte) str2.charAt(i2);
            }
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String[] m584a() {
        String[] strArr = new String[2];
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128, secureRandom);
            strArr[0] = m580a(keyGenerator.generateKey().getEncoded());
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            strArr[1] = m580a(bArr);
            if (TextUtils.isEmpty(strArr[0]) || strArr[0].length() != 32 || TextUtils.isEmpty(strArr[1])) {
                return null;
            }
            if (strArr[1].length() == 16) {
                return strArr;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] m586b(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FConstants.DOWNLOAD_BUFFER_SIZE);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            if (this.f889a.f765E) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(str.getBytes("UTF-8"));
                    gZIPOutputStream = gZIPOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        this.f889a.f764D.error(Collections.singletonList("EncryptUtils"), "Convert string to bytes failed", th, new Object[0]);
                        this.f889a.m522b().mo639a(th, "transformStrToByte");
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (!this.f889a.f765E) {
                        }
                    } finally {
                        C0411e.m356a((Closeable) gZIPOutputStream);
                    }
                }
            } else {
                byteArrayOutputStream.write(str.getBytes("UTF-8"));
            }
        } catch (Throwable th2) {
            th = th2;
        }
        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
        return !this.f889a.f765E ? (this.f889a.getInitConfig() == null || this.f889a.getInitConfig().getEncryptor() == null) ? EncryptorUtil.encrypt(byteArray2, byteArray2.length) : this.f889a.getInitConfig().getEncryptor().encrypt(byteArray2, byteArray2.length) : byteArray2;
    }

    /* renamed from: a */
    public String m585a(String str) {
        if (TextUtils.isEmpty(str) || !this.f889a.f765E) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String encodedQuery = parse.getEncodedQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : f888d) {
            String queryParameter = parse.getQueryParameter(str2);
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(new Pair(str2, queryParameter));
            }
        }
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.clearQuery();
        for (Pair pair : arrayList) {
            buildUpon.appendQueryParameter((String) pair.first, (String) pair.second);
        }
        buildUpon.appendQueryParameter("tt_info", new String(Base64.encode(m586b(encodedQuery), 8)));
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    public static HashMap<String, String> m581a(HashMap<String, String> hashMap, C0467m c0467m) {
        hashMap.put("Content-Type", c0467m.f765E ? "application/octet-stream;tt-data=" + ((c0467m.getInitConfig() == null || c0467m.getInitConfig().getEncryptor() == null || !(c0467m.getInitConfig().getEncryptor() instanceof C0440i0)) ? IEncryptorType.DEFAULT_ENCRYPTOR : ((C0440i0) c0467m.getInitConfig().getEncryptor()).encryptorType()) : "application/json; charset=utf-8");
        return hashMap;
    }
}
