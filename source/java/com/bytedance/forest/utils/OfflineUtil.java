package com.bytedance.forest.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceResponse;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.HttpResponseCache;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.pollyfill.TTNetDepender;
import com.bytedance.geckox.GkFSUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: OfflineUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018J\u001a\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bJ\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0004JP\u0010\u001f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2(\b\u0002\u0010$\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001b\u0012\u0004\u0012\u00020\u00040%JF\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u00042\u0016\b\u0002\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001dJ\u0018\u0010.\u001a\u00020/2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u00100\u001a\u00020!J\u0017\u00101\u001a\u0004\u0018\u00010/2\b\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\u0002\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u00042\b\u00104\u001a\u0004\u0018\u00010\u0004J\u0017\u00105\u001a\u00020/2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0002\b6J!\u00107\u001a\u0004\u0018\u00010!2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001b¢\u0006\u0002\u00109J+\u0010:\u001a\u00020\u00112\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d2\u0006\u0010<\u001a\u00020!H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00182\u0006\u0010A\u001a\u00020\u0004J\u0016\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020/J\u000e\u0010F\u001a\u00020\u00182\u0006\u0010G\u001a\u00020!J\u001c\u0010H\u001a\u0004\u0018\u00010'2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010\u0004J.\u0010L\u001a\u0004\u0018\u00010'2\b\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010M\u001a\u00020+2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010N\u001a\u0004\u0018\u00010\u0004J&\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001d2\u0012\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001bJ\u0015\u0010Q\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#H\u0000¢\u0006\u0002\bRR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/bytedance/forest/utils/OfflineUtil;", "", "()V", "CACHE_CONTROL_HEADER", "", "CONTENT_LENGTH_HEADER", "DISABLE_CACHE_LIST", "", "ILLEGAL_MIMETYPE", "VARY_HEADER", "gkfsCleaning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getGkfsCleaning$forest_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "gson", "Lcom/google/gson/Gson;", "cleanGkFS", "", "context", "Landroid/content/Context;", "cleanGkFS$forest_release", "extractExtension", "url", "isFilePath", "", "fromMapToString", "map", "", "fromStringToMap", "", "jsonString", "generateCachedHeaders", "Lkotlin/Pair;", "", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "varyHeaderValueInterceptor", "Lkotlin/Function2;", "generateWebResourceResponse", "Landroid/webkit/WebResourceResponse;", "mimeType", "encode", "is", "Ljava/io/InputStream;", "identity", "originalHeaders", "getCustomizedExpireTime", "", "customMaxAge", "getExpiredTime", "(Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;)Ljava/lang/Long;", "getMimeTypeFromExtension", "extension", "getRequestTime", "getRequestTime$forest_release", "getResponseSize", "httpHeader", "(Ljava/util/Map;)Ljava/lang/Integer;", "injectExpireTime", "headers", "maxAge", "injectExpireTime$forest_release", "isCacheKey", WsChannelMultiProcessSharedProvider.STRING_TYPE, "isFileExpiredByHttpProtocol", "filename", "isFileExpiredByUsageTime", "file", "Ljava/io/File;", "maxAgeInMills", "isHttpResponseSuccessful", "httpCode", "loadAssetResponse", "assetManager", "Landroid/content/res/AssetManager;", "path", "loadLocalResponse", "inputStream", "charset", "restoreResponseHeaders", "cachedHeaders", "supportCache", "supportCache$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class OfflineUtil {
    private static final String CACHE_CONTROL_HEADER = "cache-control";
    public static final String CONTENT_LENGTH_HEADER = "content-length";
    public static final String ILLEGAL_MIMETYPE = "unknown";
    public static final String VARY_HEADER = "vary";
    public static final OfflineUtil INSTANCE = new OfflineUtil();
    private static final List<String> DISABLE_CACHE_LIST = CollectionsKt.listOf(new String[]{"no-store", "no-cache", "max-age=0", "max-age=0", "must-revalidate", "proxy-revalidate"});
    private static final Gson gson = new Gson();
    private static final AtomicBoolean gkfsCleaning = new AtomicBoolean(false);

    public final boolean isHttpResponseSuccessful(int httpCode) {
        return 200 <= httpCode && 300 >= httpCode;
    }

    private OfflineUtil() {
    }

    public final String fromMapToString(Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(map, "map");
        String json = gson.toJson(map);
        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(map)");
        return json;
    }

    public final Map<String, String> fromStringToMap(String jsonString) {
        Intrinsics.checkParameterIsNotNull(jsonString, "jsonString");
        return (Map) gson.fromJson(jsonString, new HashMap().getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Pair generateCachedHeaders$default(OfflineUtil offlineUtil, ForestNetAPI.HttpResponse httpResponse, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = new Function2<String, Map<String, ? extends String>, String>() { // from class: com.bytedance.forest.utils.OfflineUtil$generateCachedHeaders$1
                public final String invoke(String str, Map<String, String> map) {
                    String str2;
                    Intrinsics.checkParameterIsNotNull(str, "headerKey");
                    return (map == null || (str2 = map.get(str)) == null) ? "" : str2;
                }
            };
        }
        return offlineUtil.generateCachedHeaders(httpResponse, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Map<String, String>, Integer> generateCachedHeaders(ForestNetAPI.HttpResponse httpResponse, Function2<? super String, ? super Map<String, String>, String> varyHeaderValueInterceptor) {
        List list;
        Intrinsics.checkParameterIsNotNull(httpResponse, "httpResponse");
        Intrinsics.checkParameterIsNotNull(varyHeaderValueInterceptor, "varyHeaderValueInterceptor");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : httpResponse.getResponseHttpHeader().entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        String str = (String) hashMap.get(VARY_HEADER);
        if (str != null) {
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String obj = StringsKt.trim(str).toString();
            if (obj != null) {
                Locale locale = Locale.ENGLISH;
                Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = obj.toLowerCase(locale);
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase != null) {
                    list = StringsKt.split$default(lowerCase, new String[]{","}, false, 0, 6, (Object) null);
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    List<String> sorted = CollectionsKt.sorted(list);
                    HashMap hashMap2 = hashMap;
                    hashMap2.put(VARY_HEADER, CollectionsKt.joinToString$default(sorted, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
                    hashMap2.put(TTNetDepender.FOREST_APPEND_REQUEST_TIME, String.valueOf(httpResponse.getGeneratedTime()));
                    for (String str2 : sorted) {
                        String str3 = TTNetDepender.FOREST_APPEND_PREFIX + str2;
                        ConcurrentHashMap<String, String> headers$forest_release = httpResponse.getRequest().getHeaders$forest_release();
                        hashMap2.put(str3, varyHeaderValueInterceptor.invoke(str2, headers$forest_release != null ? headers$forest_release : MapsKt.emptyMap()));
                    }
                    return new Pair<>(hashMap, Integer.valueOf(sorted.size()));
                }
            }
        }
        list = null;
        if (list == null) {
        }
        List<String> sorted2 = CollectionsKt.sorted(list);
        HashMap hashMap22 = hashMap;
        hashMap22.put(VARY_HEADER, CollectionsKt.joinToString$default(sorted2, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        hashMap22.put(TTNetDepender.FOREST_APPEND_REQUEST_TIME, String.valueOf(httpResponse.getGeneratedTime()));
        while (r3.hasNext()) {
        }
        return new Pair<>(hashMap, Integer.valueOf(sorted2.size()));
    }

    public final Integer getResponseSize(Map<String, String> httpHeader) {
        Intrinsics.checkParameterIsNotNull(httpHeader, "httpHeader");
        String str = httpHeader.get(CONTENT_LENGTH_HEADER);
        if (str != null) {
            return StringsKt.toIntOrNull(str);
        }
        return null;
    }

    public final void injectExpireTime$forest_release(Map<String, String> headers, int maxAge) {
        if (headers != null) {
            headers.put(CACHE_CONTROL_HEADER, "max-age=" + maxAge);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long getRequestTime$forest_release(ForestNetAPI.HttpResponse httpResponse) {
        Map<String, String> responseHttpHeader;
        Long l = null;
        if (httpResponse != null && (responseHttpHeader = httpResponse.getResponseHttpHeader()) != null) {
            String str = responseHttpHeader.get(TTNetDepender.FOREST_APPEND_REQUEST_TIME);
            Long longOrNull = str != null ? StringsKt.toLongOrNull(str) : null;
            if (longOrNull != null) {
                l = longOrNull;
                if (l == null) {
                    return l.longValue();
                }
                return 0L;
            }
        }
        if (httpResponse != null) {
            l = Long.valueOf(httpResponse.getGeneratedTime());
        }
        if (l == null) {
        }
    }

    public final Long getExpiredTime(ForestNetAPI.HttpResponse httpResponse) {
        Map<String, String> responseHttpHeader;
        Object obj;
        String substringAfter$default;
        String substringBefore$default;
        Integer intOrNull;
        Integer intOrNull2;
        if (httpResponse == null || (responseHttpHeader = httpResponse.getResponseHttpHeader()) == null) {
            return null;
        }
        long requestTime$forest_release = getRequestTime$forest_release(httpResponse);
        String str = responseHttpHeader.get(CACHE_CONTROL_HEADER);
        if (str != null && (substringAfter$default = StringsKt.substringAfter$default(str, "max-age=", (String) null, 2, (Object) null)) != null && (substringBefore$default = StringsKt.substringBefore$default(substringAfter$default, ',', (String) null, 2, (Object) null)) != null && (intOrNull = StringsKt.toIntOrNull(substringBefore$default)) != null) {
            int intValue = intOrNull.intValue();
            String str2 = responseHttpHeader.get("age");
            return Long.valueOf(requestTime$forest_release + ((intValue - ((str2 == null || (intOrNull2 = StringsKt.toIntOrNull(str2)) == null) ? 0 : intOrNull2.intValue())) * 1000));
        }
        String str3 = responseHttpHeader.get("expires");
        if (str3 == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.Companion;
            Date parse = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm:ss z", Locale.ENGLISH).parse(str3);
            Intrinsics.checkExpressionValueIsNotNull(parse, "SimpleDateFormat(\n      …              ).parse(it)");
            obj = Result.constructor-impl(Long.valueOf(parse.getTime()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return (Long) (Result.isFailure-impl(obj) ? null : obj);
    }

    public final long getCustomizedExpireTime(ForestNetAPI.HttpResponse httpResponse, int customMaxAge) {
        Map<String, String> responseHttpHeader;
        String str;
        Integer intOrNull;
        return getRequestTime$forest_release(httpResponse) + ((customMaxAge - ((httpResponse == null || (responseHttpHeader = httpResponse.getResponseHttpHeader()) == null || (str = responseHttpHeader.get("age")) == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) ? 0 : intOrNull.intValue())) * 1000);
    }

    public final boolean supportCache$forest_release(ForestNetAPI.HttpResponse httpResponse) {
        Intrinsics.checkParameterIsNotNull(httpResponse, "httpResponse");
        int responseHttpCode = httpResponse.getResponseHttpCode();
        if (!isHttpResponseSuccessful(responseHttpCode) && responseHttpCode != 304) {
            return false;
        }
        Map<String, String> responseHttpHeader = httpResponse.getResponseHttpHeader();
        if (responseHttpCode == 206 || Intrinsics.areEqual(responseHttpHeader.get(VARY_HEADER), "*")) {
            return false;
        }
        String str = responseHttpHeader.get(CACHE_CONTROL_HEADER);
        if (str != null) {
            Iterator<String> it = DISABLE_CACHE_LIST.iterator();
            while (it.hasNext()) {
                if (StringsKt.contains$default(str, it.next(), false, 2, (Object) null)) {
                    return false;
                }
            }
        }
        return getExpiredTime(httpResponse) != null;
    }

    public final boolean isCacheKey(String string) {
        Intrinsics.checkParameterIsNotNull(string, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        List split$default = StringsKt.split$default(string, new String[]{"-"}, false, 0, 6, (Object) null);
        return (split$default.size() != 3 || StringsKt.toIntOrNull((String) split$default.get(1)) == null || StringsKt.toLongOrNull((String) split$default.get(2)) == null) ? false : true;
    }

    public final boolean isFileExpiredByHttpProtocol(String filename) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(filename, "filename");
        if (StringsKt.endsWith$default(filename, HttpResponseCache.WRITING_POSTFIX, false, 2, (Object) null)) {
            return true;
        }
        List split$default = StringsKt.split$default(filename, new String[]{"-"}, false, 0, 6, (Object) null);
        if (!(split$default.size() == 3)) {
            split$default = null;
        }
        if (split$default == null) {
            return false;
        }
        if (!RepoUtils.INSTANCE.has(filename)) {
            return true;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(StringsKt.toLongOrNull((String) split$default.get(2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Long l = (Long) (Result.isFailure-impl(obj) ? null : obj);
        return l == null || l.longValue() < System.currentTimeMillis();
    }

    public final boolean isFileExpiredByUsageTime(File file, long maxAgeInMills) {
        Intrinsics.checkParameterIsNotNull(file, "file");
        return file.lastModified() + maxAgeInMills < System.currentTimeMillis();
    }

    public final Map<String, String> restoreResponseHeaders(Map<String, String> cachedHeaders) {
        Intrinsics.checkParameterIsNotNull(cachedHeaders, "cachedHeaders");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : cachedHeaders.entrySet()) {
            if (!StringsKt.startsWith$default(entry.getKey(), TTNetDepender.FOREST_APPEND_PREFIX, false, 2, (Object) null)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String extractExtension(String url, boolean isFilePath) {
        String fileExtensionFromUrl;
        String str;
        boolean z;
        Intrinsics.checkParameterIsNotNull(url, "url");
        if (isFilePath) {
            String substringAfterLast = StringsKt.substringAfterLast(url, '.', "");
            Locale locale = Locale.ENGLISH;
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
            if (substringAfterLast == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = substringAfterLast.toLowerCase(locale);
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        String str2 = null;
        try {
            fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(url);
            str = fileExtensionFromUrl;
        } catch (Throwable unused) {
        }
        if (str != null) {
            if (str.length() != 0) {
                z = false;
                if (!z) {
                    str2 = fileExtensionFromUrl;
                }
                return str2;
            }
        }
        z = true;
        if (!z) {
        }
        return str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r2.equals("jpeg") != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0082, code lost:
    
        return "image/jpeg";
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (r2.equals("jpg") != false) goto L36;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0009. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getMimeTypeFromExtension(String extension) {
        if (extension == null) {
            return null;
        }
        switch (extension.hashCode()) {
            case 3401:
                if (extension.equals(CDNFetchDepender.DEFAULT_EXTENSION)) {
                    return "application/x-javascript";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 98819:
                if (extension.equals(PreloadConfig.KEY_STYLESHEET)) {
                    return "text/css";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 102340:
                if (extension.equals("gif")) {
                    return "image/gif";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 104085:
                if (extension.equals("ico")) {
                    return "image/x-icon";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 105441:
                break;
            case 111145:
                if (extension.equals("png")) {
                    return "image/png";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 114276:
                if (extension.equals("svg")) {
                    return "image/svg+xml";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 115174:
                if (extension.equals("ttf")) {
                    return "font/ttf";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 3213227:
                if (extension.equals("html")) {
                    return "text/html";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 3268712:
                break;
            case 3271912:
                if (extension.equals("json")) {
                    return "application/json";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 3645340:
                if (extension.equals("webp")) {
                    return "image/webp";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 3655064:
                if (extension.equals("woff")) {
                    return "font/woff";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            case 113307034:
                if (extension.equals("woff2")) {
                    return "font/woff2";
                }
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
            default:
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        }
    }

    public final WebResourceResponse loadAssetResponse(AssetManager assetManager, String path) {
        if (assetManager != null) {
            String str = path;
            if (!(str == null || str.length() == 0)) {
                String mimeTypeFromExtension = getMimeTypeFromExtension(extractExtension(path, true));
                if (mimeTypeFromExtension == null) {
                    mimeTypeFromExtension = "";
                }
                return generateWebResourceResponse$default(this, mimeTypeFromExtension, "", assetManager.open(path), path, null, 16, null);
            }
        }
        return null;
    }

    public final WebResourceResponse loadLocalResponse(String path, InputStream inputStream, String mimeType, String charset) {
        Intrinsics.checkParameterIsNotNull(inputStream, "inputStream");
        try {
            Result.Companion companion = Result.Companion;
            if (path != null) {
                File file = new File(path);
                if (!(file.exists() && !file.isDirectory())) {
                    file = null;
                }
                if (file != null) {
                    OfflineUtil offlineUtil = INSTANCE;
                    return generateWebResourceResponse$default(offlineUtil, mimeType != null ? mimeType : offlineUtil.getMimeTypeFromExtension(offlineUtil.extractExtension(path, true)), charset, inputStream, path, null, 16, null);
                }
            }
            Result.constructor-impl((Object) null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return null;
    }

    public static /* synthetic */ WebResourceResponse generateWebResourceResponse$default(OfflineUtil offlineUtil, String str, String str2, InputStream inputStream, String str3, Map map, int i, Object obj) {
        if ((i & 16) != 0) {
            map = null;
        }
        return offlineUtil.generateWebResourceResponse(str, str2, inputStream, str3, map);
    }

    public final WebResourceResponse generateWebResourceResponse(String mimeType, String encode, InputStream is, String identity, Map<String, String> originalHeaders) {
        Map<String, String> hashMap;
        Set<Map.Entry<String, String>> entrySet;
        Intrinsics.checkParameterIsNotNull(identity, "identity");
        if (Intrinsics.areEqual(mimeType, "unknown")) {
            LogUtils.e$default(LogUtils.INSTANCE, "header", identity + ", cannot resolve mimetype, " + identity + ", headers: " + ((originalHeaders == null || (entrySet = originalHeaders.entrySet()) == null) ? null : CollectionsKt.joinToString$default(entrySet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1<Map.Entry<String, String>, String>() { // from class: com.bytedance.forest.utils.OfflineUtil$generateWebResourceResponse$1
                public final String invoke(Map.Entry<String, String> entry) {
                    Intrinsics.checkParameterIsNotNull(entry, "it");
                    return " : ";
                }
            }, 31, (Object) null)), null, true, null, null, null, 116, null);
            return null;
        }
        if (is != null) {
            if (originalHeaders != null) {
                hashMap = originalHeaders;
            } else {
                try {
                    hashMap = new HashMap();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (hashMap.get("Access-Control-Allow-Origin") == null && hashMap.get("access-control-allow-origin") == null) {
                hashMap.put("access-control-allow-origin", "*");
            }
            if (Intrinsics.areEqual("font/ttf", mimeType)) {
                return new WebResourceResponse(mimeType, encode, 200, "OK", hashMap, is);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, encode, is);
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        }
        return null;
    }

    public final AtomicBoolean getGkfsCleaning$forest_release() {
        return gkfsCleaning;
    }

    public final void cleanGkFS$forest_release(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        gkfsCleaning.set(true);
        GkFSUtils.INSTANCE.ensureGkFSInit(context);
        LogUtils.i$default(LogUtils.INSTANCE, "GkFS", "gkfs clean start", false, null, null, null, 60, null);
        GkFSUtils.INSTANCE.cleanOldExperiments(new Function0<Unit>() { // from class: com.bytedance.forest.utils.OfflineUtil$cleanGkFS$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m535invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m535invoke() {
                LogUtils.i$default(LogUtils.INSTANCE, "GkFS", "gkfs clean finished", false, null, null, null, 60, null);
                OfflineUtil.INSTANCE.getGkfsCleaning$forest_release().set(false);
            }
        });
    }
}
