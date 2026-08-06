package com.bytedance.retrofit2.mime;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TTRequestCompressManager {
    private static final String BLOCK_PATH_EQUAL_KEY = "block_path_equal_list";
    private static final String BLOCK_PATH_REGEX_KEY = "block_path_regex_list";
    private static final String BROTLI_COMPRESS_HEADER = "br";
    private static final String COMPRESS_BROTLI_QUALITY_KEY = "br_level";
    private static final String COMPRESS_ENABLED_KEY = "enabled";
    private static final int COMPRESS_MAX_BODY_SIZE = 1048576;
    private static final String COMPRESS_MAX_BODY_SIZE_KEY = "max_body_size";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_KEY = "max_body_size_map";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_PATH_EQUAL_KEY = "path_eq";
    private static final String COMPRESS_MAX_BODY_SIZE_MAP_PATH_WILDCHAR_KEY = "path_wc";
    private static final int COMPRESS_MIN_BODY_SIZE = 100;
    private static final String COMPRESS_MIN_BODY_SIZE_KEY = "min_body_size";
    private static final String COMPRESS_REQUEST_KEY = "tt_compress";
    private static final String COMPRESS_REQUEST_TYPE_KEY = "type";
    private static final String COMPRESS_ZSTD_LEVEL_KEY = "zstd_level";
    private static final int DEFAULT_BROTLI_QUALITY = 4;
    private static final int DEFAULT_ZSTD_LEVEL = 6;
    private static final String EQUAL_PATH_KEY = "equal_path";
    private static final String GZIP_COMPRESS_HEADER = "gzip";
    private static final String HOST_GROUP_KEY = "host_group";
    private static final int MAX_BROTLI_QUALITY = 11;
    private static final int MAX_ZSTD_LEVEL = 22;
    private static final int MIN_BROTLI_QUALITY = 0;
    private static final int MIN_ZSTD_LEVEL = 1;
    private static final String OPT_ENABLED_KEY = "opt_enabled";
    private static final String PREFIX_PATH_KEY = "prefix_path";
    private static final String REGEX_PATH_KEY = "regex_path";
    private static final String TAG = "TTRequestCompress";
    private static final String ZSTD_COMPRESS_HEADER = "zstd";
    private static final String ZSTD_EQUAL_PATH_KEY = "zstd_equal_path";
    private static final String ZSTD_PREFIX_PATH_KEY = "zstd_prefix_path";
    private static final String ZSTD_REGEX_PATH_KEY = "zstd_regex_path";
    private static AddZstdCompressCallback sAddZstdCompressCallback = null;
    public static volatile CompressDataCallback sCallback = null;
    private static volatile boolean sCompressOptEnabled = false;
    private static int sMaxBodyCompressSize = 1048576;
    private static volatile boolean sRequestCompressEnabled;
    private static final ConcurrentMap<String, Integer> sMaxBodyCompressEqualPathSize = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Integer> sMaxBodyCompressWildcardPathSize = new ConcurrentHashMap();
    private static int sMinBodyCompressSize = 100;
    private static int sBrotliCompressQuality = 4;
    private static int sZstdCompressLevel = 6;
    private static CompressType sCompressType = CompressType.NONE;
    private static CopyOnWriteArraySet<String> sEqualPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> sPrefixPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<Pattern> sRegexPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> sZstdEqualPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> sZstdPrefixPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<Pattern> sZstdRegexPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> sHostGroupArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<String> sBlockEqualPathArraySet = new CopyOnWriteArraySet<>();
    private static CopyOnWriteArraySet<Pattern> sBlockPatternPathArraySet = new CopyOnWriteArraySet<>();
    public static volatile Boolean sGlobalCompressDisabled = false;
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    /* loaded from: classes4.dex */
    public interface AddZstdCompressCallback {
        byte[] compress(byte[] bArr, int i);

        byte[] decompress(byte[] bArr, int i);
    }

    /* loaded from: classes4.dex */
    public interface CompressDataCallback {
        byte[] compressData(byte[] bArr, int i, int i2, int i3);

        byte[] decompressData(byte[] bArr, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public enum CompressType {
        NONE(0),
        GZIP(1),
        BROTLI(2),
        ZSTD(3);

        private final int mType;

        CompressType(int i) {
            this.mType = i;
        }

        public int getType() {
            return this.mType;
        }
    }

    /* loaded from: classes4.dex */
    public enum DisableCompress {
        NONE(0),
        GLOBAL_DISABLE(1),
        TNC_DISABLE(2),
        URL_MISMATCH(3),
        BODY_SIZE_MISMATCH(4),
        BODY_SIZE_OVERFLOW(5),
        ZSTD_PREFIX_MISMATCH(6),
        GZIP_PREFIX_MISMATCH(7),
        BODY_ENCRYPTED(8),
        REMOVE_ENCODING(9),
        DATA_NULL(10),
        NON_POST_METHOD(11),
        BODY_ENCODED(12),
        USER_DISABLE(13);

        private final int reason;

        DisableCompress(int i) {
            this.reason = i;
        }

        public int getReason() {
            return this.reason;
        }
    }

    private static void resetCompressConfig() {
        sRequestCompressEnabled = false;
        sMaxBodyCompressSize = 1048576;
        sMaxBodyCompressEqualPathSize.clear();
        sMaxBodyCompressWildcardPathSize.clear();
        sMinBodyCompressSize = 100;
        sCompressType = CompressType.NONE;
        sEqualPathArraySet.clear();
        sPrefixPathArraySet.clear();
        sRegexPathArraySet.clear();
        sZstdEqualPathArraySet.clear();
        sZstdPrefixPathArraySet.clear();
        sZstdRegexPathArraySet.clear();
        sHostGroupArraySet.clear();
        sBlockEqualPathArraySet.clear();
        sBlockPatternPathArraySet.clear();
    }

    public static boolean isBodyOptEnabled() {
        return sCompressOptEnabled;
    }

    public static void onServerConfigChanged(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        resetCompressConfig();
        JSONObject optJSONObject = jSONObject.optJSONObject(COMPRESS_REQUEST_KEY);
        if (optJSONObject == null) {
            return;
        }
        sRequestCompressEnabled = optJSONObject.optInt(COMPRESS_ENABLED_KEY, 0) > 0;
        sCompressOptEnabled = optJSONObject.optInt(OPT_ENABLED_KEY, 0) > 0;
        sMaxBodyCompressSize = optJSONObject.optInt(COMPRESS_MAX_BODY_SIZE_KEY, 1048576);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(COMPRESS_MAX_BODY_SIZE_MAP_KEY);
        if (optJSONObject2 != null) {
            parseObjectMapStringConfig(optJSONObject2, COMPRESS_MAX_BODY_SIZE_MAP_PATH_EQUAL_KEY, sMaxBodyCompressEqualPathSize);
            parseObjectMapStringConfig(optJSONObject2, COMPRESS_MAX_BODY_SIZE_MAP_PATH_WILDCHAR_KEY, sMaxBodyCompressWildcardPathSize);
        }
        sMinBodyCompressSize = optJSONObject.optInt(COMPRESS_MIN_BODY_SIZE_KEY, 100);
        int optInt = optJSONObject.optInt(COMPRESS_BROTLI_QUALITY_KEY, 4);
        if (optInt >= 0 && optInt <= 11) {
            sBrotliCompressQuality = optInt;
        }
        int optInt2 = optJSONObject.optInt(COMPRESS_ZSTD_LEVEL_KEY, 6);
        if (optInt2 >= 1 && optInt2 <= 22) {
            sZstdCompressLevel = optInt2;
        }
        int optInt3 = optJSONObject.optInt("type", CompressType.GZIP.getType());
        covertIntToCompressType(optInt3);
        parseArraySetStringConfig(optJSONObject.optJSONArray(EQUAL_PATH_KEY), sEqualPathArraySet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(PREFIX_PATH_KEY), sPrefixPathArraySet);
        parseArraySetPatternConfig(optJSONObject.optJSONArray(REGEX_PATH_KEY), sRegexPathArraySet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(ZSTD_EQUAL_PATH_KEY), sZstdEqualPathArraySet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(ZSTD_PREFIX_PATH_KEY), sZstdPrefixPathArraySet);
        parseArraySetPatternConfig(optJSONObject.optJSONArray(ZSTD_REGEX_PATH_KEY), sZstdRegexPathArraySet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(HOST_GROUP_KEY), sHostGroupArraySet);
        parseArraySetStringConfig(optJSONObject.optJSONArray(BLOCK_PATH_EQUAL_KEY), sBlockEqualPathArraySet);
        parseArraySetPatternConfig(optJSONObject.optJSONArray(BLOCK_PATH_REGEX_KEY), sBlockPatternPathArraySet);
        if (Logger.debug()) {
            Log.d(TAG, "sRequestCompressEnabled:" + sRequestCompressEnabled + " type:" + optInt3);
        }
    }

    private static void parseObjectMapStringConfig(JSONObject jSONObject, String str, ConcurrentMap<String, Integer> concurrentMap) {
        JSONObject optJSONObject;
        int optInt;
        if (jSONObject == null || TextUtils.isEmpty(str) || concurrentMap == null || (optJSONObject = jSONObject.optJSONObject(str)) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next) && (optInt = optJSONObject.optInt(next)) > 0) {
                hashMap.put(next, Integer.valueOf(optInt));
            }
        }
        concurrentMap.clear();
        concurrentMap.putAll(hashMap);
    }

    private static void parseArraySetStringConfig(JSONArray jSONArray, CopyOnWriteArraySet<String> copyOnWriteArraySet) {
        if (jSONArray == null || copyOnWriteArraySet == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArraySet.add(string);
                }
            } catch (JSONException unused) {
                return;
            }
        }
    }

    private static void parseArraySetPatternConfig(JSONArray jSONArray, CopyOnWriteArraySet<Pattern> copyOnWriteArraySet) {
        if (jSONArray == null || copyOnWriteArraySet == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                String string = jSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    try {
                        copyOnWriteArraySet.add(Pattern.compile(string, 2));
                    } catch (Throwable unused) {
                    }
                }
            } catch (JSONException unused2) {
                return;
            }
        }
    }

    private static void covertIntToCompressType(int i) {
        if (i == 1) {
            sCompressType = CompressType.GZIP;
            return;
        }
        if (i == 2) {
            sCompressType = CompressType.BROTLI;
        } else if (i == 3) {
            sCompressType = CompressType.ZSTD;
        } else {
            sCompressType = CompressType.NONE;
        }
    }

    public static void setCompressDataCallback(CompressDataCallback compressDataCallback) {
        sCallback = compressDataCallback;
    }

    public static void setGlobalForbidenCompress() {
        sGlobalCompressDisabled = true;
    }

    private static CompressType getCompressType(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return CompressType.NONE;
        }
        if (!isEmptySet(sZstdEqualPathArraySet) && sZstdEqualPathArraySet.contains(str2)) {
            return CompressType.ZSTD;
        }
        if (!isEmptySet(sZstdPrefixPathArraySet)) {
            Iterator<String> it = sZstdPrefixPathArraySet.iterator();
            while (it.hasNext()) {
                if (str2.startsWith(it.next())) {
                    return CompressType.ZSTD;
                }
            }
        }
        if (!isEmptySet(sZstdRegexPathArraySet)) {
            Iterator<Pattern> it2 = sZstdRegexPathArraySet.iterator();
            while (it2.hasNext()) {
                Pattern next = it2.next();
                if (next != null) {
                    try {
                        if (next.matcher(str2).matches()) {
                            return CompressType.ZSTD;
                        }
                        continue;
                    } catch (IllegalArgumentException unused) {
                        continue;
                    }
                }
            }
        }
        if (!isEmptySet(sEqualPathArraySet) && sEqualPathArraySet.contains(str2)) {
            return sCompressType;
        }
        if (!isEmptySet(sPrefixPathArraySet)) {
            Iterator<String> it3 = sPrefixPathArraySet.iterator();
            while (it3.hasNext()) {
                if (str2.startsWith(it3.next())) {
                    return sCompressType;
                }
            }
        }
        if (!isEmptySet(sRegexPathArraySet)) {
            Iterator<Pattern> it4 = sRegexPathArraySet.iterator();
            while (it4.hasNext()) {
                Pattern next2 = it4.next();
                if (next2 != null) {
                    try {
                        if (next2.matcher(str2).matches()) {
                            return sCompressType;
                        }
                        continue;
                    } catch (IllegalArgumentException unused2) {
                        continue;
                    }
                }
            }
        }
        if (isEmptySet(sHostGroupArraySet) || !isHostMatch(str)) {
            return CompressType.NONE;
        }
        if (!isEmptySet(sBlockEqualPathArraySet) && sBlockEqualPathArraySet.contains(str2)) {
            return CompressType.NONE;
        }
        if (!isEmptySet(sBlockPatternPathArraySet)) {
            Iterator<Pattern> it5 = sBlockPatternPathArraySet.iterator();
            while (it5.hasNext()) {
                Pattern next3 = it5.next();
                if (next3 != null) {
                    try {
                        if (next3.matcher(str2).matches()) {
                            return CompressType.NONE;
                        }
                        continue;
                    } catch (IllegalArgumentException unused3) {
                        continue;
                    }
                }
            }
        }
        return sCompressType;
    }

    private static boolean isHostMatch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = sHostGroupArraySet.iterator();
        while (it.hasNext()) {
            if (matchPattern(str, it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmptySet(Set<?> set) {
        return set == null || set.isEmpty();
    }

    /* loaded from: classes4.dex */
    public static class CompressData {
        public String contentEncoding;
        public byte[] data;
        public int failedCode;
        public String failedPrefixData;
        public CompressType type;

        CompressData(int i) {
            this.failedCode = i;
        }
    }

    public static CompressData compressBody(byte[] bArr, int i, String str, String str2, boolean z) {
        CompressData compressData = new CompressData(0);
        if (sGlobalCompressDisabled.booleanValue()) {
            if (Logger.debug()) {
                Log.d(TAG, "global compress is disabled.");
            }
            compressData.failedCode = DisableCompress.GLOBAL_DISABLE.getReason();
            return compressData;
        }
        if (!sRequestCompressEnabled || sCompressType == CompressType.NONE) {
            if (Logger.debug()) {
                Log.d(TAG, "Request compress is disabled.");
            }
            compressData.failedCode = DisableCompress.TNC_DISABLE.getReason();
            return compressData;
        }
        CompressType compressType = getCompressType(str, str2);
        if (!z && compressType == CompressType.NONE) {
            if (Logger.debug()) {
                Log.d(TAG, "Url is not matched:" + str + str2);
            }
            compressData.failedCode = DisableCompress.URL_MISMATCH.getReason();
            return compressData;
        }
        if (i > getCompressMaxBodySize(str2) || i < sMinBodyCompressSize) {
            if (Logger.debug()) {
                Log.d(TAG, "Request body size is not matched:" + i);
            }
            compressData.failedCode = DisableCompress.BODY_SIZE_MISMATCH.getReason();
            return compressData;
        }
        if (compressType == CompressType.GZIP) {
            byte[] gzipCompress = gzipCompress(bArr, i);
            if (!canUseCompressedBody(i, gzipCompress, compressType, compressData)) {
                return compressData;
            }
            compressData.data = gzipCompress;
            compressData.type = compressType;
            compressData.contentEncoding = "gzip";
            return compressData;
        }
        if (compressType == CompressType.BROTLI) {
            byte[] brotliCompress = brotliCompress(bArr, i, sBrotliCompressQuality);
            if (!canUseCompressedBody(i, brotliCompress, compressType, compressData)) {
                return compressData;
            }
            compressData.data = brotliCompress;
            compressData.type = compressType;
            compressData.contentEncoding = BROTLI_COMPRESS_HEADER;
            return compressData;
        }
        if (compressType != CompressType.ZSTD) {
            return null;
        }
        byte[] zstdCompress = zstdCompress(bArr, sZstdCompressLevel);
        if (!canUseCompressedBody(i, zstdCompress, compressType, compressData)) {
            return compressData;
        }
        compressData.data = zstdCompress;
        compressData.type = compressType;
        compressData.contentEncoding = "zstd";
        return compressData;
    }

    private static int getCompressMaxBodySize(String str) {
        if (TextUtils.isEmpty(str)) {
            return sMaxBodyCompressSize;
        }
        Integer num = sMaxBodyCompressEqualPathSize.get(str);
        if (num != null) {
            return num.intValue();
        }
        for (Map.Entry<String, Integer> entry : sMaxBodyCompressWildcardPathSize.entrySet()) {
            if (matchPattern(str, entry.getKey())) {
                Integer value = entry.getValue();
                return value != null ? value.intValue() : sMaxBodyCompressSize;
            }
        }
        return sMaxBodyCompressSize;
    }

    private static String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.MAX_VALUE;
            int i3 = i * 2;
            char[] cArr2 = HEX_ARRAY;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    public static boolean canUseCompressedBody(int i, byte[] bArr, CompressType compressType, CompressData compressData) {
        if (bArr == null || bArr.length <= 3) {
            return false;
        }
        if (!sCompressOptEnabled) {
            return true;
        }
        if (bArr.length >= i) {
            compressData.failedCode = DisableCompress.BODY_SIZE_OVERFLOW.getReason();
            return false;
        }
        if (compressType == CompressType.GZIP) {
            byte b = bArr[0];
            byte b2 = bArr[1];
            byte b3 = bArr[2];
            if (b == 31 && b2 == -117 && b3 == 8) {
                return true;
            }
            compressData.failedCode = DisableCompress.GZIP_PREFIX_MISMATCH.getReason();
            compressData.failedPrefixData = byteArrayToHexString(new byte[]{b, b2, b3});
            return false;
        }
        if (compressType != CompressType.ZSTD) {
            return true;
        }
        byte b4 = bArr[0];
        byte b5 = bArr[1];
        byte b6 = bArr[2];
        if (b4 == 40 && b5 == -75 && b6 == 47) {
            return true;
        }
        compressData.failedCode = DisableCompress.ZSTD_PREFIX_MISMATCH.getReason();
        compressData.failedPrefixData = byteArrayToHexString(new byte[]{b4, b5, b6});
        return false;
    }

    public static byte[] brotliCompress(byte[] bArr, int i, int i2) {
        if (bArr == null || sCallback == null) {
            return null;
        }
        return sCallback.compressData(bArr, i, i2, CompressType.BROTLI.getType());
    }

    public static byte[] brotliDecompress(byte[] bArr, int i) {
        if (bArr == null || sCallback == null) {
            return null;
        }
        return sCallback.decompressData(bArr, i, CompressType.BROTLI.getType());
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] gzipCompress(byte[] bArr, int i) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                try {
                    gZIPOutputStream.write(bArr);
                    try {
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e2) {
                    e = e2;
                    Log.w(TAG, "Compress with gzip exception: " + e);
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                gZIPOutputStream2 = gZIPOutputStream;
                if (gZIPOutputStream2 != null) {
                    try {
                        gZIPOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (gZIPOutputStream2 != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] gzipDecompress(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                try {
                    byte[] bArr2 = new byte[4096];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    gZIPInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e2) {
                    e = e2;
                    Log.w(TAG, "Decompress with gzip exception: " + e);
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return null;
                        }
                    }
                    byteArrayOutputStream.close();
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                gZIPInputStream2 = gZIPInputStream;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            gZIPInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (gZIPInputStream2 != null) {
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }

    public static void setAddZstdCompressCallback(AddZstdCompressCallback addZstdCompressCallback) {
        sAddZstdCompressCallback = addZstdCompressCallback;
    }

    public static byte[] zstdCompress(byte[] bArr, int i) {
        AddZstdCompressCallback addZstdCompressCallback = sAddZstdCompressCallback;
        if (addZstdCompressCallback != null) {
            return addZstdCompressCallback.compress(bArr, i);
        }
        return null;
    }

    public static byte[] zstdDecompress(byte[] bArr, int i) {
        AddZstdCompressCallback addZstdCompressCallback = sAddZstdCompressCallback;
        if (addZstdCompressCallback != null) {
            return addZstdCompressCallback.decompress(bArr, i);
        }
        return null;
    }

    public static byte[] decompressDataByType(byte[] bArr, String str, int i) {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return bArr;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 3152:
                if (str.equals(BROTLI_COMPRESS_HEADER)) {
                    c = 0;
                    break;
                }
                break;
            case 3189082:
                if (str.equals("gzip")) {
                    c = 1;
                    break;
                }
                break;
            case 3748713:
                if (str.equals("zstd")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return brotliDecompress(bArr, bArr.length);
            case 1:
                return gzipDecompress(bArr);
            case 2:
                return zstdDecompress(bArr, i);
            default:
                return bArr;
        }
    }

    private static boolean matchPattern(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        int length = str.length();
        int length2 = str2.length();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i < length) {
            if (i2 < length2 && (str2.charAt(i2) == '?' || str2.charAt(i2) == str.charAt(i))) {
                i++;
                i2++;
            } else if (i2 < length2 && str2.charAt(i2) == '*') {
                i4 = i;
                i3 = i2;
                i2++;
            } else {
                if (i3 == -1) {
                    return false;
                }
                i2 = i3 + 1;
                i4++;
                i = i4;
            }
        }
        while (i2 < length2) {
            if (str2.charAt(i2) != '*') {
                return false;
            }
            i2++;
        }
        return true;
    }
}
