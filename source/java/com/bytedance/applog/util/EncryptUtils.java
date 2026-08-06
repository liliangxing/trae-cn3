package com.bytedance.applog.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.server.Api;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.mpaas.IEncryptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EncryptUtils {
    public static final String KEY_AB_VERSION = "ab_version";
    static final String KEY_DEVICE_PLATFORM = "device_platform";
    public static final String KEY_EVENT_FILTER = "event_filter";
    static final String KEY_IID = "iid";
    private static final String KEY_TT_INFO = "tt_info";
    private final AppLogInstance appLogInstance;
    private static final List<String> logTags = Collections.singletonList("EncryptUtils");
    private static final String KEY_TT_DATA = "tt_data";
    private static final String[] KEYS_PLAINTEXT = {"aid", "app_version", KEY_TT_DATA, "device_id"};
    public static final String[] KEYS_REPORT_QUERY = {"aid", "version_code", "ab_version", "iid", "device_platform", "device_id", Api.KEY_APPLOG_PRIORITY_GROUP_ID};
    public static final String[] KEYS_CONFIG_QUERY = {KEY_TT_DATA, "device_platform"};

    public EncryptUtils(AppLogInstance appLogInstance) {
        this.appLogInstance = appLogInstance;
    }

    public String encryptUrl(String str) {
        if (TextUtils.isEmpty(str) || !this.appLogInstance.getEncryptAndCompress()) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        ArrayList<Pair> arrayList = new ArrayList();
        for (String str2 : KEYS_PLAINTEXT) {
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
        buildUpon.appendQueryParameter(KEY_TT_INFO, new String(Base64.encode(transformStrToByte(query), 8)));
        return buildUpon.build().toString();
    }

    public byte[] transformStrToByte(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes(UrlUtils.UTF_8);
        } catch (UnsupportedEncodingException e) {
            this.appLogInstance.getLogger().error(logTags, "get bytes failed", e, new Object[0]);
            bArr = null;
        }
        if (this.appLogInstance.getEncryptAndCompress()) {
            bArr = gzip(bArr);
        }
        return encrypt(bArr);
    }

    public static byte[] gzip(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(bArr);
                    gZIPOutputStream2.close();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    try {
                        LoggerImpl.global().error(logTags, "gzip write failed", th, new Object[0]);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] encrypt(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        if (this.appLogInstance.getEncryptAndCompress()) {
            IEncryptor encryptor = this.appLogInstance.getInitConfig() != null ? this.appLogInstance.getInitConfig().getEncryptor() : null;
            if (encryptor != null) {
                bArr = encryptor.encrypt(bArr, bArr.length);
            } else {
                bArr = TTEncryptUtils.encrypt(bArr, bArr.length);
            }
            if (bArr == null) {
                this.appLogInstance.getMonitorHelper().increaseStats(StatsCountKeys.ENCRYPT_ERROR_COUNT);
            }
        }
        return bArr;
    }

    private static String byte2String(byte[] bArr) {
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

    public static String[] genRandomKeyAndIv() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(128, secureRandom);
            byte[] bArr = new byte[8];
            secureRandom.nextBytes(bArr);
            String[] strArr = {byte2String(keyGenerator.generateKey().getEncoded()), byte2String(bArr)};
            if (isValidKeyIv(strArr)) {
                return strArr;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isValidKeyIv(String[] strArr) {
        return strArr != null && strArr.length == 2 && !TextUtils.isEmpty(strArr[0]) && strArr[0].length() == 32 && !TextUtils.isEmpty(strArr[1]) && strArr[1].length() == 16;
    }

    private static byte[] transStrCharToByte(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) str.charAt(i);
        }
        return bArr;
    }

    public static byte[] decryptAesCbc(byte[] bArr, String str, String str2) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
            cipher.init(2, new SecretKeySpec(transStrCharToByte(str), "AES"), new IvParameterSpec(transStrCharToByte(str2)));
            return cipher.doFinal(bArr);
        } catch (Throwable th) {
            LoggerImpl.global().error(logTags, "Cannot decrypt aes cbc", th, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
    
        if (r2 == null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] gzipUncompress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            } catch (IOException unused) {
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
            }
        } catch (IOException unused2) {
            byteArrayInputStream = null;
        } catch (Throwable th3) {
            byteArrayInputStream = null;
            th = th3;
            gZIPInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read >= 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused3) {
                    }
                }
            }
            gZIPInputStream.close();
        } catch (IOException unused4) {
            gZIPInputStream2 = gZIPInputStream;
            if (gZIPInputStream2 != null) {
                try {
                    gZIPInputStream2.close();
                } catch (IOException unused5) {
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (gZIPInputStream != null) {
                try {
                    gZIPInputStream.close();
                } catch (IOException unused6) {
                }
            }
            if (byteArrayInputStream != null) {
                try {
                    byteArrayInputStream.close();
                    throw th;
                } catch (IOException unused7) {
                    throw th;
                }
            }
            throw th;
        }
        try {
            byteArrayInputStream.close();
        } catch (IOException unused8) {
            return byteArrayOutputStream.toByteArray();
        }
    }
}
