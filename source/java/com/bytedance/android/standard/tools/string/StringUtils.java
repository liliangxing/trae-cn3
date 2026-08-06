package com.bytedance.android.standard.tools.string;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.android.standard.tools.logging.Logger;
import com.bytedance.android.standard.tools.security.DigestUtils;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.Character;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class StringUtils {
    private static final int CHAR_12288 = 12288;
    private static final int CHAR_127 = 127;
    private static final int CHAR_32 = 32;
    private static final int CHAR_65248 = 65248;
    private static final int CHAR_65280 = 65280;
    private static final int CHAR_65375 = 65375;
    private static final int CHAR_MAX = 31;
    public static final String EMPTY = "";
    private static final long G = 1073741824;
    private static final long K = 1024;
    private static final long M = 1048576;
    private static final int STRING_MAX_NUM = 255;
    private static final long T = 1099511627776L;
    private static final int XOR_MASK = 5;

    private StringUtils() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean equal(String str, String str2) {
        return (isEmpty(str) && isEmpty(str2)) || (str != null && str.equals(str2));
    }

    public static String ellipsize(String str, int i) {
        if (str == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= str.length()) {
                break;
            }
            char charAt = str.charAt(i2);
            i3 = (charAt <= 0 || charAt > 255) ? i3 + 2 : i3 + 1;
            if (i3 > i) {
                sb.append("...");
                break;
            }
            sb.append(charAt);
            i2++;
        }
        return sb.toString();
    }

    public static void escapeEcmaScript(StringBuilder sb, String str, boolean z) {
        if (z) {
            sb.append("\"");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"' || charAt == '\\') {
                sb.append(AbstractJsonLexerKt.STRING_ESC).append(charAt);
            } else if (charAt != 8232 && charAt != 8233) {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (charAt <= 31) {
                            sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            break;
                        } else {
                            sb.append(charAt);
                            break;
                        }
                }
            } else {
                sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
        }
        if (z) {
            sb.append("\"");
        }
    }

    public static String removeBlank(String str) {
        if (isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                stringBuffer.append(str.charAt(i));
            }
        }
        return stringBuffer.toString();
    }

    public static HashMap<String, String> parseResponse(String str) {
        String[] split = str.substring(str.indexOf(123) + 1, str.lastIndexOf(125)).split(",");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str2 : split) {
            String[] split2 = str2.split(Constants.COLON_SEPARATOR, 2);
            hashMap.put(clean(split2[0]), clean(split2[1]));
        }
        return hashMap;
    }

    public static String clean(String str) {
        int indexOf = str.indexOf(34);
        int lastIndexOf = str.lastIndexOf(34);
        return (indexOf < 0 || lastIndexOf <= indexOf) ? str : str.substring(indexOf + 1, lastIndexOf).trim();
    }

    public static String getShortDateTime(String str) {
        int indexOf = str.indexOf(45) + 1;
        int lastIndexOf = str.lastIndexOf(58);
        return (indexOf <= 0 || lastIndexOf <= 0) ? str : str.substring(indexOf, lastIndexOf);
    }

    public static String toSBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == ' ') {
                charArray[i] = 12288;
            } else if (c < 127 && c > ' ') {
                charArray[i] = (char) (c + CHAR_65248);
            }
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (isChinese(charArray[i])) {
                char c = charArray[i];
                if (c == 12288) {
                    charArray[i] = ' ';
                } else if (c > 65280 && c < CHAR_65375) {
                    charArray[i] = (char) (c - CHAR_65248);
                }
            }
        }
        return new String(charArray);
    }

    public static boolean isChinese(char c) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == Character.UnicodeBlock.GENERAL_PUNCTUATION || of == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static String handleAdClickTrackUrl(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new Random().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String format(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        return new DecimalFormat("#.##").format(d) + " " + str;
    }

    public static String bytesToHuman(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", TextAttributes.INLINE_BLOCK_PLACEHOLDER};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return format(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static String mapToString(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (!isEmpty(str) && !isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Map<String, String> stringToMap(String str, Map<String, String> map) {
        if (isEmpty(str) || map == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String string = jSONObject.getString(next);
                if (!isEmpty(next) && !isEmpty(string)) {
                    map.put(next, string);
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static String strEncode(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String encryptWithXor(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (bytes[i] ^ 5);
            }
            return DigestUtils.toHexString(bytes, 0, bytes.length);
        } catch (Exception unused) {
            return str;
        }
    }

    public static String decryptWithXor(String str, Boolean... boolArr) {
        byte[] hexStringToBytes;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (boolArr != null && boolArr.length > 0 && boolArr[0].booleanValue()) {
                hexStringToBytes = Base64.decode(str, 0);
            } else {
                hexStringToBytes = DigestUtils.hexStringToBytes(str);
            }
            for (int i = 0; i < hexStringToBytes.length; i++) {
                hexStringToBytes[i] = (byte) (hexStringToBytes[i] ^ 5);
            }
            return new String(hexStringToBytes, 0, hexStringToBytes.length, "UTF-8");
        } catch (Exception unused) {
            return str;
        }
    }

    public static String trimString(String str) {
        return (str == null || str.length() == 0) ? str : str.trim();
    }

    public static String compressWithGzip(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (isEmpty(str)) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(str.getBytes());
                    gZIPOutputStream.close();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    String hexString = DigestUtils.toHexString(byteArray, 0, byteArray.length);
                    try {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Throwable unused) {
                    }
                    return hexString;
                } catch (Throwable th) {
                    th = th;
                    try {
                        Logger.d("Thread", th.getMessage());
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused2) {
                                return null;
                            }
                        }
                        return null;
                    } finally {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            gZIPOutputStream = null;
        }
    }

    public static String decompressWithGzip(String str) throws IOException {
        GZIPInputStream gZIPInputStream;
        ByteArrayInputStream byteArrayInputStream;
        BufferedReader bufferedReader;
        if (isEmpty(str)) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(DigestUtils.hexStringToBytes(str));
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(gZIPInputStream, "UTF-8"));
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream = null;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPInputStream = null;
            byteArrayInputStream = null;
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
            } catch (Throwable unused) {
            }
            return sb2;
        } catch (Throwable th4) {
            th = th4;
            try {
                Logger.d("Thread", th.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
            }
        }
    }
}
