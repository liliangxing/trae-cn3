package com.bytedance.forest.utils;

import android.net.Uri;
import android.webkit.WebResourceRequest;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ForestConfig;
import com.bytedance.forest.model.GeckoConfig;
import com.bytedance.forest.model.GeckoModel;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.RequestParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: CacheIdentifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/forest/utils/CacheIdentifier;", "", "uri", "Landroid/net/Uri;", "baseUrl", "", "queryString", "userAgent", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getQueryString", "getUri", "()Landroid/net/Uri;", "getUserAgent", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class CacheIdentifier {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FAKE_DOMAIN = "https://gecko.offline.resource";
    private static final String TAG = "CacheIdentifier";
    private final String baseUrl;
    private final String queryString;
    private final Uri uri;
    private final String userAgent;

    public static /* synthetic */ CacheIdentifier copy$default(CacheIdentifier cacheIdentifier, Uri uri, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = cacheIdentifier.uri;
        }
        if ((i & 2) != 0) {
            str = cacheIdentifier.baseUrl;
        }
        if ((i & 4) != 0) {
            str2 = cacheIdentifier.queryString;
        }
        if ((i & 8) != 0) {
            str3 = cacheIdentifier.userAgent;
        }
        return cacheIdentifier.copy(uri, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getQueryString() {
        return this.queryString;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final CacheIdentifier copy(Uri uri, String baseUrl, String queryString, String userAgent) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(baseUrl, "baseUrl");
        Intrinsics.checkParameterIsNotNull(queryString, "queryString");
        Intrinsics.checkParameterIsNotNull(userAgent, "userAgent");
        return new CacheIdentifier(uri, baseUrl, queryString, userAgent);
    }

    public CacheIdentifier(Uri uri, String str, String str2, String str3) {
        Intrinsics.checkParameterIsNotNull(uri, "uri");
        Intrinsics.checkParameterIsNotNull(str, "baseUrl");
        Intrinsics.checkParameterIsNotNull(str2, "queryString");
        Intrinsics.checkParameterIsNotNull(str3, "userAgent");
        this.uri = uri;
        this.baseUrl = str;
        this.queryString = str2;
        this.userAgent = str3;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getQueryString() {
        return this.queryString;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    /* compiled from: CacheIdentifier.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ$\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J,\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00042\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/forest/utils/CacheIdentifier$Companion;", "", "()V", "FAKE_DOMAIN", "", "TAG", "fetchUA", "webResourceRequest", "injectUA", "obtain", "Lcom/bytedance/forest/utils/CacheIdentifier;", "request", "Lcom/bytedance/forest/model/Request;", "url", "params", "Lcom/bytedance/forest/model/RequestParams;", "forest", "Lcom/bytedance/forest/Forest;", "sensitiveQueries", "", "userAgent", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ CacheIdentifier obtain$default(Companion companion, String str, RequestParams requestParams, Forest forest, int i, Object obj) {
            if ((i & 4) != 0) {
                forest = null;
            }
            return companion.obtain(str, requestParams, forest);
        }

        public final CacheIdentifier obtain(String url, RequestParams params, Forest forest) {
            String str;
            ForestConfig config;
            GeckoConfig geckoConfig;
            String accessKey;
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(params, "params");
            String fetchUA = params.getCacheKeyUASensitive() ? fetchUA(params.getWebResourceRequest(), params.getInjectedUserAgent()) : "";
            String str2 = url;
            if (StringsKt.isBlank(str2)) {
                String accessKey2 = params.getAccessKey();
                if (accessKey2.length() == 0) {
                    accessKey2 = (forest == null || (config = forest.getConfig()) == null || (geckoConfig = config.getGeckoConfig()) == null || (accessKey = geckoConfig.getAccessKey()) == null) ? "" : accessKey;
                }
                str = accessKey2;
                if (str.length() == 0) {
                    return null;
                }
            } else {
                str = "";
            }
            if (StringsKt.isBlank(str2)) {
                str2 = "https://gecko.offline.resource/" + str + '/' + params.getChannel() + '/' + params.getBundle();
            }
            return obtain(str2, params.getCacheKeySensitiveQueries(), fetchUA != null ? fetchUA : "");
        }

        public final CacheIdentifier obtain(Request request) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            String originUrl = request.getOriginUrl();
            if (StringsKt.isBlank(originUrl)) {
                GeckoModel geckoModel = request.getGeckoModel();
                originUrl = "https://gecko.offline.resource/" + geckoModel.getAccessKey() + '/' + geckoModel.getChannel() + '/' + geckoModel.getBundle();
            }
            String str = originUrl;
            String fetchUA = request.getCacheKeyUASensitive() ? fetchUA(request.getWebResourceRequest(), request.getInjectedUserAgent()) : "";
            return obtain(str, request.getCacheKeySensitiveQueries$forest_release(), fetchUA != null ? fetchUA : "");
        }

        static /* synthetic */ String fetchUA$default(Companion companion, Object obj, String str, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = null;
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.fetchUA(obj, str);
        }

        private final String fetchUA(Object webResourceRequest, String injectUA) {
            Map<String, String> requestHeaders;
            boolean z = webResourceRequest instanceof WebResourceRequest;
            if (!z) {
                return injectUA;
            }
            if (!z) {
                webResourceRequest = null;
            }
            WebResourceRequest webResourceRequest2 = (WebResourceRequest) webResourceRequest;
            if (webResourceRequest2 == null || (requestHeaders = webResourceRequest2.getRequestHeaders()) == null) {
                return null;
            }
            return requestHeaders.get("user-agent");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CacheIdentifier obtain$default(Companion companion, String str, Set set, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                set = null;
            }
            if ((i & 4) != 0) {
                str2 = "";
            }
            return companion.obtain(str, (Set<String>) set, str2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x012c, code lost:
        
            if (r3 != null) goto L46;
         */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0136  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheIdentifier obtain(String url, Set<String> sensitiveQueries, String userAgent) {
            Object obj;
            String joinToString$default;
            Intrinsics.checkParameterIsNotNull(url, "url");
            Intrinsics.checkParameterIsNotNull(userAgent, "userAgent");
            if (StringsKt.isBlank(url)) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(Uri.parse(url));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            Uri uri = (Uri) obj;
            if (uri == null) {
                LogUtils.e$default(LogUtils.INSTANCE, CacheIdentifier.TAG, "can not parse to uri from " + url, null, true, null, null, null, 116, null);
                return null;
            }
            if (sensitiveQueries == null) {
                if (!GeckoXAdapter.INSTANCE.canParsed(uri)) {
                    joinToString$default = uri.getQuery();
                    return new CacheIdentifier(uri, UriParserKt.withoutQueries(url), joinToString$default != null ? joinToString$default : "", userAgent);
                }
                joinToString$default = "";
                return new CacheIdentifier(uri, UriParserKt.withoutQueries(url), joinToString$default != null ? joinToString$default : "", userAgent);
            }
            if (sensitiveQueries.isEmpty()) {
                joinToString$default = UriParserKt.withoutQueries(url);
            } else {
                Set<String> set = sensitiveQueries;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(set, 10)), 16));
                for (Object obj2 : set) {
                    linkedHashMap.put(obj2, UriParserKt.safeGetQueryParameter(uri, (String) obj2));
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Iterator it = linkedHashMap.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (entry.getValue() != null) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                LinkedHashMap linkedHashMap3 = linkedHashMap2.isEmpty() ^ true ? linkedHashMap2 : null;
                if (linkedHashMap3 != null) {
                    ArrayList arrayList = new ArrayList(linkedHashMap3.size());
                    for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                        arrayList.add(((String) entry2.getKey()) + '=' + ((String) entry2.getValue()));
                    }
                    joinToString$default = CollectionsKt.joinToString$default(arrayList, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
                }
                joinToString$default = "";
            }
            return new CacheIdentifier(uri, UriParserKt.withoutQueries(url), joinToString$default != null ? joinToString$default : "", userAgent);
        }
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            CacheIdentifier cacheIdentifier = (CacheIdentifier) other;
            return ((Intrinsics.areEqual(this.baseUrl, cacheIdentifier.baseUrl) ^ true) || (Intrinsics.areEqual(this.queryString, cacheIdentifier.queryString) ^ true) || (Intrinsics.areEqual(this.userAgent, cacheIdentifier.userAgent) ^ true)) ? false : true;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.forest.utils.CacheIdentifier");
    }

    public int hashCode() {
        return (((this.baseUrl.hashCode() * 31) + this.queryString.hashCode()) * 31) + this.userAgent.hashCode();
    }

    public String toString() {
        return "CacheIdentifier(baseUrl='" + this.baseUrl + "', queryString='" + this.queryString + "', userAgent='" + this.userAgent + "')";
    }
}
