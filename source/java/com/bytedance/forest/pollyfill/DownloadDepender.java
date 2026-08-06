package com.bytedance.forest.pollyfill;

import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.Forest;
import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import com.bytedance.forest.model.BytesProvider;
import com.bytedance.forest.model.DefaultConfig;
import com.bytedance.forest.model.ErrorInfo;
import com.bytedance.forest.model.ForestBuffer;
import com.bytedance.forest.model.LogReportNode;
import com.bytedance.forest.model.Request;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.geckox.utils.MD5Utils;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: DownloadDepender.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/forest/pollyfill/DownloadDepender;", "Lcom/bytedance/forest/pollyfill/INetDepender;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "(Lcom/bytedance/forest/utils/ForestPipelineContext;)V", "callbackSucceed", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "fetchTask", "Lcom/bytedance/forest/pollyfill/FetchTask;", "entity", "Lcom/ss/android/socialbase/downloader/model/DownloadInfo;", "cancel", "fetchFile", "onlyLocal", "", "getExtraHeaders", "", "Lcom/ss/android/socialbase/downloader/model/HttpHeader;", "request", "Lcom/bytedance/forest/model/Request;", "tryLoadFromCDN", "destination", "Ljava/io/File;", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DownloadDepender implements INetDepender {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final JSONObject downloadSetting;
    private static final Method methodSetCacheLifeMaxTime;
    private final ForestPipelineContext context;

    public DownloadDepender(ForestPipelineContext forestPipelineContext) {
        Intrinsics.checkParameterIsNotNull(forestPipelineContext, "context");
        this.context = forestPipelineContext;
    }

    /* compiled from: DownloadDepender.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/forest/pollyfill/DownloadDepender$Companion;", "", "()V", "downloadSetting", "Lorg/json/JSONObject;", "methodSetCacheLifeMaxTime", "Ljava/lang/reflect/Method;", "checkExpired", "", "url", "", "file", "Ljava/io/File;", "(Ljava/lang/String;Ljava/io/File;)Ljava/lang/Boolean;", "fetchCache", "sourceUrl", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "forest_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Boolean checkExpired(String url, File file) {
            Intrinsics.checkParameterIsNotNull(url, "url");
            if (file == null) {
                return true;
            }
            DownloadInfo downloadInfo = Downloader.getInstance(Forest.INSTANCE.getApp()).getDownloadInfo(url, file.getParent());
            if (downloadInfo != null) {
                return Boolean.valueOf(downloadInfo.cacheExpierd());
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0046, code lost:
        
            if (r3 != null) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean fetchCache(String sourceUrl, final Response response, final ForestPipelineContext context) {
            String str;
            Long longOrNull;
            Intrinsics.checkParameterIsNotNull(sourceUrl, "sourceUrl");
            Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
            Intrinsics.checkParameterIsNotNull(context, "context");
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"cdn_downloader_build_cached_path_start"}, null, 2, null);
            String stringToMd5 = MD5Utils.stringToMd5(sourceUrl);
            String encodedPath = response.getRequest().getUri().getEncodedPath();
            if (encodedPath != null && (str = FilesKt.getExtension(new File(encodedPath))) != null) {
                if (!(!TextUtils.isEmpty(str))) {
                    str = null;
                }
            }
            str = CDNFetchDepender.DEFAULT_EXTENSION;
            final File file = new File(CDNFetchDepender.INSTANCE.getDirectory(), stringToMd5 + '.' + str);
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"cdn_downloader_build_cached_path_finish", "cdn_downloader_load_cache_start"}, null, 2, null);
            if (file.exists() && file.isFile()) {
                final DownloadInfo downloadInfo = Downloader.getInstance(Forest.INSTANCE.getApp()).getDownloadInfo(sourceUrl, file.getParent());
                if (downloadInfo == null || downloadInfo.cacheExpierd()) {
                    try {
                        Result.Companion companion = Result.Companion;
                        Result.constructor-impl(Boolean.valueOf(file.delete()));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"cdn_downloader_load_cache_finish"}, null, 2, null);
                    return false;
                }
                response.setSucceed(true);
                response.setCache(true);
                String mimeType = downloadInfo.getMimeType();
                if (mimeType != null) {
                    response.setDataType$forest_release(StringsKt.substringBefore$default(mimeType, ";", (String) null, 2, (Object) null));
                    response.setCharset$forest_release(StringsKt.substringBefore$default(StringsKt.substringAfter(mimeType, "charset=", ""), ";", (String) null, 2, (Object) null));
                }
                Map httpHeaders = downloadInfo.getHttpHeaders();
                if (httpHeaders != null) {
                    String str2 = (String) httpHeaders.get(CDNFetchDepender.KEY_VERSION);
                    response.setVersion((str2 == null || (longOrNull = StringsKt.toLongOrNull(str2)) == null) ? 0L : longOrNull.longValue());
                    response.getRequest().getCustomParams().put(CDNFetchDepender.KEY_HTTP_HEADERS, httpHeaders.toString());
                }
                response.setFilePath(file.getAbsolutePath());
                response.setInMemoryBuffer$forest_release(context.obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$Companion$fetchCache$$inlined$apply$lambda$1
                    @Override // com.bytedance.forest.model.BytesProvider
                    public boolean isMultiProvider() {
                        return true;
                    }

                    @Override // com.bytedance.forest.model.BytesProvider
                    public InputStream provideInputStream() {
                        FileInputStream fileInputStream;
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Exception e) {
                            context.getLogger().printOptimize(6, ForestBuffer.TAG, true, e, LogReportNode.CDN_GET_INPUT_STREAM_ERROR, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$Companion$fetchCache$$inlined$apply$lambda$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                public final String invoke() {
                                    return "error occurs when getting input stream from downloader, file: " + file.getPath() + ", e:" + e.getMessage();
                                }
                            });
                            fileInputStream = null;
                        }
                        return fileInputStream;
                    }
                }, response.getRequest()));
                response.setFrom(ResourceFrom.CDN);
                return true;
            }
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(context, new String[]{"cdn_downloader_load_cache_finish"}, null, 2, null);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        DefaultConstructorMarker defaultConstructorMarker;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("net_lib_strategy", 5);
        downloadSetting = jSONObject;
        try {
            Result.Companion companion = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(DownloadTask.class.getDeclaredMethod("setCacheLifeTimeMax", Long.TYPE));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            defaultConstructorMarker = Result.constructor-impl(ResultKt.createFailure(th));
        }
        methodSetCacheLifeMaxTime = (Method) (Result.isFailure-impl(defaultConstructorMarker) ? null : defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean tryLoadFromCDN(Response response, final File destination) {
        if (destination.exists() && destination.isFile()) {
            response.setSucceed(true);
            response.setFilePath(destination.getAbsolutePath());
            response.setInMemoryBuffer$forest_release(this.context.obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$tryLoadFromCDN$$inlined$apply$lambda$1
                @Override // com.bytedance.forest.model.BytesProvider
                public boolean isMultiProvider() {
                    return true;
                }

                @Override // com.bytedance.forest.model.BytesProvider
                public InputStream provideInputStream() {
                    ForestPipelineContext forestPipelineContext;
                    FileInputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(destination);
                    } catch (Exception e) {
                        forestPipelineContext = DownloadDepender.this.context;
                        forestPipelineContext.getLogger().printOptimize(6, ForestBuffer.TAG, true, e, LogReportNode.CDN_GET_INPUT_STREAM_ERROR, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$tryLoadFromCDN$$inlined$apply$lambda$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public final String invoke() {
                                return "error occurs when getting input stream from downloader, file: " + destination.getPath() + ", e:" + e.getMessage();
                            }
                        });
                        fileInputStream = null;
                    }
                    return fileInputStream;
                }
            }, response.getRequest()));
            response.setFrom(ResourceFrom.CDN);
            return true;
        }
        if (StringsKt.isBlank(response.getErrorInfo().getCdnError())) {
            response.getErrorInfo().setError(ErrorInfo.Type.CDN, 4, "file not exists or a directory");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0052, code lost:
    
        if (r2 != null) goto L13;
     */
    @Override // com.bytedance.forest.pollyfill.INetDepender
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void fetchFile(Response response, FetchTask fetchTask, boolean onlyLocal) {
        String str;
        Object obj;
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        Intrinsics.checkParameterIsNotNull(fetchTask, "fetchTask");
        Object obj2 = null;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_START, "cdn_downloader_build_cached_path_start"}, null, 2, null);
        String url = response.getRequest().getUrl();
        String stringToMd5 = MD5Utils.stringToMd5(url);
        String encodedPath = response.getRequest().getUri().getEncodedPath();
        boolean z = true;
        if (encodedPath != null && (str = FilesKt.getExtension(new File(encodedPath))) != null) {
            if (!(!TextUtils.isEmpty(str))) {
                str = null;
            }
        }
        str = CDNFetchDepender.DEFAULT_EXTENSION;
        File file = new File(CDNFetchDepender.INSTANCE.getDirectory(), stringToMd5 + '.' + str);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_build_cached_path_finish"}, null, 2, null);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Request request = response.getRequest();
        if (onlyLocal) {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_load_cache_start"}, null, 2, null);
            DownloadInfo downloadInfo = Downloader.getInstance(Forest.INSTANCE.getApp()).getDownloadInfo(url, file.getParent());
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_load_cache_finish"}, null, 2, null);
            if (downloadInfo != null && tryLoadFromCDN(response, file)) {
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_FINISH}, null, 2, null);
                downloadInfo.setSuccessByCache(true);
                callbackSucceed(response, fetchTask, downloadInfo);
                return;
            } else {
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_FINISH}, null, 2, null);
                fetchTask.onFailure$forest_release(true, new Throwable("only local but no download info found"));
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_FINISH}, null, 2, null);
                return;
            }
        }
        if (!request.getOnlyOnline() && request.getEnableCDNCache()) {
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_load_cache_start"}, null, 2, null);
            DownloadInfo downloadInfo2 = Downloader.getInstance(Forest.INSTANCE.getApp()).getDownloadInfo(url, file.getParent());
            ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{"cdn_downloader_load_cache_finish"}, null, 2, null);
            if (downloadInfo2 != null && !downloadInfo2.cacheExpierd() && tryLoadFromCDN(response, file)) {
                ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_CACHE_FINISH}, null, 2, null);
                downloadInfo2.setSuccessByCache(true);
                callbackSucceed(response, fetchTask, downloadInfo2);
                return;
            }
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        IDownloadListener downloadDepender$fetchFile$absDownloadListener$1 = new DownloadDepender$fetchFile$absDownloadListener$1(this, objectRef, response, file, fetchTask, countDownLatch, url);
        boolean isCDNMultiVersionResource = GeckoXAdapter.INSTANCE.isCDNMultiVersionResource(url);
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_DOWNLOAD_START}, null, 2, null);
        if (isCDNMultiVersionResource) {
            url = CDNFetchDepender.INSTANCE.addCDNMultiVersionCommonParams(url);
        }
        IDownloadListener iDownloadListener = downloadDepender$fetchFile$absDownloadListener$1;
        DownloadTask extraHeaders = Downloader.with(Forest.INSTANCE.getApp()).url(url).name(file.getName()).savePath(file.getParent()).addListenerToSameTask(true).deleteCacheIfCheckFailed(true).retryCount(request.getLoadRetryTimes()).autoSetHashCodeForSameTask(true).accessHttpHeaderKeys(isCDNMultiVersionResource ? CDNFetchDepender.INSTANCE.getAccessHeaderKeys() : null).ttnetProtectTimeout(DefaultConfig.INSTANCE.getCDN_TIMEOUT()).expiredRedownload(request.getEnableNegotiation()).expiredHttpCheck(request.getOnlyOnline()).downloadSetting(downloadSetting).force(!request.getEnableCDNCache()).subThreadListener(iDownloadListener).monitorScene(GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG).extraHeaders(getExtraHeaders(request));
        try {
            Result.Companion companion = Result.Companion;
            Method method = methodSetCacheLifeMaxTime;
            if (method != null) {
                Object[] objArr = new Object[1];
                Integer valueOf = Integer.valueOf(Forest.INSTANCE.getCdnCacheDiskMaxAge$forest_release());
                if (valueOf.intValue() <= 0) {
                    z = false;
                }
                objArr[0] = Long.valueOf(((z ? valueOf : null) != null ? r11.intValue() : 14) * 24 * 60 * 60);
                obj2 = method.invoke(extraHeaders, objArr);
            }
            obj = Result.constructor-impl(obj2);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        final Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            ForestLogger.printOptimize$default(this.context.getLogger(), 5, CDNFetchDepender.TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.pollyfill.DownloadDepender$fetchFile$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final String invoke() {
                    return "invoke TTDownloader setCacheLifeTimeMax failed, cause by:" + th2;
                }
            }, 28, null);
        }
        fetchTask.setUnique$forest_release(Integer.valueOf(extraHeaders.download()));
        countDownLatch.await();
        if (((Integer) objectRef.element) != null) {
            Downloader downloader = Downloader.getInstance(this.context.getAndroidContext());
            Integer num = (Integer) objectRef.element;
            if (num == null) {
                Intrinsics.throwNpe();
            }
            downloader.removeSubThreadListener(num.intValue(), iDownloadListener);
        }
    }

    private final List<HttpHeader> getExtraHeaders(Request request) {
        Map<String, String> requestHeaders;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object webResourceRequest = request.getWebResourceRequest();
        if ((webResourceRequest instanceof WebResourceRequest) && (requestHeaders = ((WebResourceRequest) webResourceRequest).getRequestHeaders()) != null) {
            linkedHashMap.putAll(requestHeaders);
        }
        for (Map.Entry<String, String> entry : request.getInjectedHttpHeaders().entrySet()) {
            if (!linkedHashMap.containsKey(entry.getKey())) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add(new HttpHeader((String) entry2.getKey(), (String) entry2.getValue()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackSucceed(Response response, FetchTask fetchTask, DownloadInfo entity) {
        Map httpHeaders;
        Long longOrNull;
        String mimeType;
        ForestPipelineContext.recordPerformanceTiming$forest_release$default(this.context, new String[]{Timing.CDN_FINISH}, null, 2, null);
        response.setCache(entity != null ? entity.isSuccessByCache() : false);
        if (!response.getIsCache()) {
            response.getRequest().getForest().getMemoryManager().removeCache(response.getRequest().getCacheKey$forest_release());
        }
        if (entity != null && (mimeType = entity.getMimeType()) != null) {
            response.setDataType$forest_release(StringsKt.substringBefore$default(mimeType, ";", (String) null, 2, (Object) null));
            response.setCharset$forest_release(StringsKt.substringBefore$default(StringsKt.substringAfter(mimeType, "charset=", ""), ";", (String) null, 2, (Object) null));
        }
        if (entity != null && (httpHeaders = entity.getHttpHeaders()) != null) {
            String str = (String) httpHeaders.get(CDNFetchDepender.KEY_VERSION);
            response.setVersion((str == null || (longOrNull = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull.longValue());
            response.getRequest().getCustomParams().put(CDNFetchDepender.KEY_HTTP_HEADERS, httpHeaders.toString());
        }
        fetchTask.onSuccess$forest_release();
    }

    @Override // com.bytedance.forest.pollyfill.INetDepender
    public void cancel(FetchTask fetchTask) {
        Intrinsics.checkParameterIsNotNull(fetchTask, "fetchTask");
        Object unique = fetchTask.getUnique();
        if (!(unique instanceof Integer)) {
            unique = null;
        }
        Integer num = (Integer) unique;
        if (num != null) {
            Downloader.getInstance(Forest.INSTANCE.getApp()).cancel(num.intValue());
        }
    }
}
