package com.bytedance.forest.pollyfill;

import android.webkit.WebResourceRequest;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.OfflineUtil;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TTNetDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&J.\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/pollyfill/ForestNetAPI;", "", "()V", "createHttpRequest", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "sourceUrl", "", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "url", "headers", "", "get", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "httpRequest", "head", "HttpRequest", "HttpResponse", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class ForestNetAPI {
    public abstract HttpRequest createHttpRequest(WebResourceRequest webResourceRequest, String sourceUrl, ForestPipelineContext context);

    public abstract HttpRequest createHttpRequest(String url, Map<String, String> headers, ForestPipelineContext context);

    public abstract HttpResponse get(HttpRequest httpRequest, ForestPipelineContext context);

    public abstract HttpResponse head(HttpRequest httpRequest, ForestPipelineContext context);

    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0017\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0000¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0014H&J\b\u0010\u0018\u001a\u00020\u0003H\u0016R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "", "url", "", "headers", "", "webResourceRequest", "Landroid/webkit/WebResourceRequest;", "(Ljava/lang/String;Ljava/util/Map;Landroid/webkit/WebResourceRequest;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "getHeaders$forest_release", "()Ljava/util/concurrent/ConcurrentHashMap;", "stringKey", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getWebResourceRequest", "()Landroid/webkit/WebResourceRequest;", "addSpecificPreloadHeader", "", "preloadFrom", "addSpecificPreloadHeader$forest_release", "cancel", "toString", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class HttpRequest {
        private final ConcurrentHashMap<String, String> headers;
        private volatile String stringKey;
        private String url;
        private final WebResourceRequest webResourceRequest;

        public abstract void cancel();

        public HttpRequest(String str, Map<String, String> map, WebResourceRequest webResourceRequest) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            Intrinsics.checkParameterIsNotNull(map, "headers");
            this.url = str;
            this.webResourceRequest = webResourceRequest;
            this.headers = new ConcurrentHashMap<>(map);
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.url = str;
        }

        public final WebResourceRequest getWebResourceRequest() {
            return this.webResourceRequest;
        }

        public final ConcurrentHashMap<String, String> getHeaders$forest_release() {
            return this.headers;
        }

        public String toString() {
            String str = this.stringKey;
            if (str != null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(this.url);
            SortedMap sortedMap = MapsKt.toSortedMap(this.headers);
            if (sortedMap == null) {
                sortedMap = MapsKt.emptyMap();
            }
            for (Map.Entry entry : sortedMap.entrySet()) {
                sb.append((String) entry.getKey()).append((String) entry.getValue());
            }
            String sb2 = sb.toString();
            this.stringKey = sb2;
            Intrinsics.checkExpressionValueIsNotNull(sb2, "it");
            return sb2;
        }

        public final void addSpecificPreloadHeader$forest_release(String preloadFrom) {
            String str = preloadFrom;
            if (str == null || str.length() == 0) {
                return;
            }
            this.headers.put("x-forest-preload", preloadFrom);
        }
    }

    /* compiled from: TTNetDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 %2\u00020\u0001:\u0001%B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000f\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u001eH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H&J\u0006\u0010#\u001a\u00020\u001eJ\u0006\u0010$\u001a\u00020\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "", "responseHttpCode", "", "errorMsg", "", "responseHttpHeader", "", "request", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "generatedTime", "", "(ILjava/lang/String;Ljava/util/Map;Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;J)V", "getErrorMsg", "()Ljava/lang/String;", "getGeneratedTime", "()J", "getRequest", "()Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;", "setRequest", "(Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpRequest;)V", "getResponseHttpCode", "()I", "getResponseHttpHeader", "()Ljava/util/Map;", "setResponseHttpHeader", "(Ljava/util/Map;)V", "getSize", "()Ljava/lang/Integer;", "isCacheChanged", "", "isCacheValid", "isSuccessful", "provideInputStream", "Ljava/io/InputStream;", "shouldRetry", "supportCache", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class HttpResponse {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final List<Integer> RETRY_CODE_LIST = CollectionsKt.listOf(new Integer[]{408, 503, 504});
        private final String errorMsg;
        private final long generatedTime;
        private HttpRequest request;
        private final int responseHttpCode;
        private Map<String, String> responseHttpHeader;

        public abstract InputStream provideInputStream();

        public HttpResponse(int i, String str, Map<String, String> map, HttpRequest httpRequest, long j) {
            Intrinsics.checkParameterIsNotNull(str, "errorMsg");
            Intrinsics.checkParameterIsNotNull(map, "responseHttpHeader");
            Intrinsics.checkParameterIsNotNull(httpRequest, "request");
            this.responseHttpCode = i;
            this.errorMsg = str;
            this.responseHttpHeader = map;
            this.request = httpRequest;
            this.generatedTime = j;
        }

        public final int getResponseHttpCode() {
            return this.responseHttpCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final Map<String, String> getResponseHttpHeader() {
            return this.responseHttpHeader;
        }

        public final void setResponseHttpHeader(Map<String, String> map) {
            Intrinsics.checkParameterIsNotNull(map, "<set-?>");
            this.responseHttpHeader = map;
        }

        public final HttpRequest getRequest() {
            return this.request;
        }

        public final void setRequest(HttpRequest httpRequest) {
            Intrinsics.checkParameterIsNotNull(httpRequest, "<set-?>");
            this.request = httpRequest;
        }

        public /* synthetic */ HttpResponse(int i, String str, Map map, HttpRequest httpRequest, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? "" : str, map, httpRequest, (i2 & 16) != 0 ? System.currentTimeMillis() : j);
        }

        public final long getGeneratedTime() {
            return this.generatedTime;
        }

        /* compiled from: TTNetDepender.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse$Companion;", "", "()V", "RETRY_CODE_LIST", "", "", "getRETRY_CODE_LIST", "()Ljava/util/List;", "ForestNetException", "forest_release"}, k = 1, mv = {1, 1, 16})
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public static final class Companion {

            /* compiled from: TTNetDepender.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse$Companion$ForestNetException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "forest_release"}, k = 1, mv = {1, 1, 16})
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
            public static final class ForestNetException extends Exception {
                private final String message;

                public ForestNetException(String str) {
                    this.message = str;
                }

                @Override // java.lang.Throwable
                public String getMessage() {
                    return this.message;
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final List<Integer> getRETRY_CODE_LIST() {
                return HttpResponse.RETRY_CODE_LIST;
            }
        }

        public boolean isSuccessful() {
            return OfflineUtil.INSTANCE.isHttpResponseSuccessful(this.responseHttpCode);
        }

        public final boolean isCacheValid() {
            return this.responseHttpCode == 304;
        }

        public final boolean isCacheChanged() {
            return this.responseHttpCode == 200;
        }

        public final boolean shouldRetry() {
            return RETRY_CODE_LIST.contains(Integer.valueOf(this.responseHttpCode));
        }

        public Integer getSize() {
            String str = this.responseHttpHeader.get(OfflineUtil.CONTENT_LENGTH_HEADER);
            if (str != null) {
                return StringsKt.toIntOrNull(str);
            }
            return null;
        }

        public final boolean supportCache() {
            return OfflineUtil.INSTANCE.supportCache$forest_release(this);
        }
    }
}
