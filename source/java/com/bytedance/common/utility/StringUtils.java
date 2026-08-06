package com.bytedance.common.utility;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Deprecated
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
        return com.bytedance.android.standard.tools.string.StringUtils.isEmpty(str);
    }

    public static boolean equal(String str, String str2) {
        return com.bytedance.android.standard.tools.string.StringUtils.equal(str, str2);
    }

    public static String ellipsize(String str, int i) {
        return com.bytedance.android.standard.tools.string.StringUtils.ellipsize(str, i);
    }

    public static void escapeEcmaScript(StringBuilder sb, String str, boolean z) {
        com.bytedance.android.standard.tools.string.StringUtils.escapeEcmaScript(sb, str, z);
    }

    public static String removeBlank(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.removeBlank(str);
    }

    public static HashMap<String, String> parseResponse(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.parseResponse(str);
    }

    public static String clean(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.clean(str);
    }

    public static String getShortDateTime(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.getShortDateTime(str);
    }

    public static String toSBC(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.toSBC(str);
    }

    public static String toDBC(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.toDBC(str);
    }

    public static boolean isChinese(char c) {
        return com.bytedance.android.standard.tools.string.StringUtils.isChinese(c);
    }

    public static String handleAdClickTrackUrl(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.handleAdClickTrackUrl(str);
    }

    private static String format(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        return new DecimalFormat("#.##").format(d) + " " + str;
    }

    public static String bytesToHuman(long j) {
        return com.bytedance.android.standard.tools.string.StringUtils.bytesToHuman(j);
    }

    public static String mapToString(Map<String, String> map) {
        return com.bytedance.android.standard.tools.string.StringUtils.mapToString(map);
    }

    public static Map<String, String> stringToMap(String str, Map<String, String> map) {
        return com.bytedance.android.standard.tools.string.StringUtils.stringToMap(str, map);
    }

    public static String strEncode(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.strEncode(str);
    }

    public static String encryptWithXor(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.encryptWithXor(str);
    }

    public static String decryptWithXor(String str, Boolean... boolArr) {
        return com.bytedance.android.standard.tools.string.StringUtils.decryptWithXor(str, boolArr);
    }

    public static String trimString(String str) {
        return com.bytedance.android.standard.tools.string.StringUtils.trimString(str);
    }

    public static String compressWithGzip(String str) throws IOException {
        return com.bytedance.android.standard.tools.string.StringUtils.compressWithGzip(str);
    }

    public static String decompressWithGzip(String str) throws IOException {
        return com.bytedance.android.standard.tools.string.StringUtils.decompressWithGzip(str);
    }
}
