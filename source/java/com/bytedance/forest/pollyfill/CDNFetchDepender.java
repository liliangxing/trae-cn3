package com.bytedance.forest.pollyfill;

import android.net.Uri;
import com.bytedance.apm.agent.instrumentation.okhttp3.OkHttpEventListener;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.CDNFetcher;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.ThreadUtils;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CDNFetchDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ<\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020&0%J\u0012\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020)H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/bytedance/forest/pollyfill/CDNFetchDepender;", "", "()V", "DEFAULT_EXTENSION", "", "IS_CACHE", "KEY_HTTP_HEADERS", "KEY_VERSION", "TAG", "TYPE", "accessHeaderKeys", "", "getAccessHeaderKeys", "()Ljava/util/List;", "directory", "Ljava/io/File;", "getDirectory", "()Ljava/io/File;", "directory$delegate", "Lkotlin/Lazy;", "addCDNMultiVersionCommonParams", "sourceUrl", "checkExpired", "", "url", "file", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "fetchResourceFile", "Lcom/bytedance/forest/pollyfill/FetchTask;", "forest", "Lcom/bytedance/forest/Forest;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "netDepender", "Lcom/bytedance/forest/pollyfill/INetDepender;", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "", "shuffleUrl", "request", "Lcom/bytedance/forest/model/Request;", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CDNFetchDepender {
    public static final String DEFAULT_EXTENSION = "js";
    public static final String IS_CACHE = "is_cache";
    public static final String KEY_HTTP_HEADERS = "http_response_headers";
    public static final String TAG = "res-downloaderdepend";
    public static final String TYPE = "type";
    public static final CDNFetchDepender INSTANCE = new CDNFetchDepender();

    /* renamed from: directory$delegate, reason: from kotlin metadata */
    private static final Lazy directory = LazyKt.lazy(new Function0<File>() { // from class: com.bytedance.forest.pollyfill.CDNFetchDepender$directory$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final File m498invoke() {
            return new File(Forest.INSTANCE.getApp().getCacheDir(), CDNFetcher.DIR_NAME);
        }
    });
    public static final String KEY_VERSION = "x-gecko-proxy-pkgid";
    private static final List<String> accessHeaderKeys = CollectionsKt.listOf(new String[]{KEY_VERSION, "content-type", OfflineUtil.CONTENT_LENGTH_HEADER, "content-encoding", "x-gecko-proxy-logid", "x-gecko-proxy-tvid", "x-tos-version-id", "x-bdcdn-cache-status", "x-cache", "x-response-cache", OkHttpEventListener.X_TT_TRACE_HOST, "via"});

    public final File getDirectory() {
        return (File) directory.getValue();
    }

    private CDNFetchDepender() {
    }

    public final List<String> getAccessHeaderKeys() {
        return accessHeaderKeys;
    }

    public final boolean checkExpired(String url, File file, ForestPipelineContext context) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Boolean checkExpired = TTNetDepender.INSTANCE.checkExpired(url, file, context);
        if (checkExpired == null) {
            checkExpired = DownloadDepender.INSTANCE.checkExpired(url, file);
        }
        if (checkExpired != null) {
            return checkExpired.booleanValue();
        }
        return true;
    }

    public final String addCDNMultiVersionCommonParams(String sourceUrl) {
        Intrinsics.checkParameterIsNotNull(sourceUrl, "sourceUrl");
        Uri.Builder buildUpon = Uri.parse(sourceUrl).buildUpon();
        for (Map.Entry<String, String> entry : GeckoXAdapter.INSTANCE.getCDNMultiVersionCommonParams().entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        Intrinsics.checkExpressionValueIsNotNull(uri, "builder.build().toString()");
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String shuffleUrl(Request request) {
        if (!request.getSupportShuffle()) {
            return null;
        }
        LinkedList<String> remainedFallbackDomains$forest_release = request.getRemainedFallbackDomains$forest_release();
        String pop = remainedFallbackDomains$forest_release.size() > 0 ? remainedFallbackDomains$forest_release.pop() : null;
        if (pop == null) {
            return null;
        }
        Uri uri = request.getUri();
        String builder = new Uri.Builder().scheme(uri.getScheme()).authority(pop).query(uri.getQuery()).path(uri.getPath()).toString();
        Intrinsics.checkExpressionValueIsNotNull(builder, "Uri.Builder().scheme(uri…path(uri.path).toString()");
        request.setUrl(builder);
        return request.getUrl();
    }

    public final FetchTask fetchResourceFile(Forest forest, Response response, ForestPipelineContext context, INetDepender netDepender, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkParameterIsNotNull(forest, "forest");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(netDepender, "netDepender");
        Intrinsics.checkParameterIsNotNull(callback, JsCallParser.VALUE_CALLBACK);
        Request request = response.getRequest();
        boolean z = request.getOnlyLocal() || (ThreadUtils.INSTANCE.isMainThread() && !request.getIsASync());
        if (z && request.getOnlyOnline()) {
            response.getErrorInfo().setError(ErrorInfo.Type.CDN, 3, "only local or disable cdn cache");
            callback.invoke(false);
            return null;
        }
        CDNFetchDepender$fetchResourceFile$result$1 cDNFetchDepender$fetchResourceFile$result$1 = new CDNFetchDepender$fetchResourceFile$result$1(callback, response, request, netDepender, z, context, forest, forest, response, context);
        netDepender.fetchFile(response, cDNFetchDepender$fetchResourceFile$result$1, z);
        return cDNFetchDepender$fetchResourceFile$result$1;
    }
}
