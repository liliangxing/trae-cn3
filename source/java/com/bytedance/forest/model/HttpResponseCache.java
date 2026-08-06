package com.bytedance.forest.model;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.ForestConcurrentList;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import com.bytedance.forest.pollyfill.ForestNetAPI;
import com.bytedance.forest.utils.ForestLogger;
import com.bytedance.forest.utils.ForestPipelineContext;
import com.bytedance.forest.utils.LogUtils;
import com.bytedance.forest.utils.OfflineUtil;
import com.bytedance.forest.utils.RepoUtils;
import com.bytedance.forest.utils.ThreadUtils;
import com.bytedance.geckox.utils.MD5Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: ResponseCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0006\u0010\u001c\u001a\u00020\u0003J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0000H\u0016J\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u0014J\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010%\u001a\u0004\u0018\u00010\u0012J\u0018\u0010&\u001a\u0004\u0018\u00010\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aJ\b\u0010,\u001a\u00020!H\u0002J\u001e\u0010-\u001a\u00020!2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u000e\u001a\u00020\u0003X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/forest/model/HttpResponseCache;", "Lcom/bytedance/forest/model/ForestConcurrentList$ForestListNode;", "url", "", "cacheFilename", "(Ljava/lang/String;Ljava/lang/String;)V", "httpResponse", "Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;", "forestBuffer", "Lcom/bytedance/forest/model/InMemoryByteBuffer;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/forest/model/Response;", "(Lcom/bytedance/forest/pollyfill/ForestNetAPI$HttpResponse;Lcom/bytedance/forest/model/InMemoryByteBuffer;Lcom/bytedance/forest/model/Response;)V", "(Ljava/lang/String;)V", "cacheKey", "expiredTime", "", "file", "Ljava/io/File;", "isValid", "", "varyNum", "", "weakReferredBuffer", "Ljava/lang/ref/WeakReference;", "weakReferredHeaders", "", "checkValid", "getCacheKey", "getNext", "getUrl", "getVaryNum", "invalidate", "", "deleteImmediately", "isCachedInMemory", "isStale", "provideFile", "provideForestBuffer", "context", "Lcom/bytedance/forest/utils/ForestPipelineContext;", "request", "Lcom/bytedance/forest/model/Request;", "provideHeaders", "tryDeleteFile", "updateFromOnline", "Companion", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class HttpResponseCache extends ForestConcurrentList.ForestListNode {
    private static final String TAG = "ResponseCache";
    public static final String WRITING_POSTFIX = "_tmp";
    private String cacheKey;
    private long expiredTime;
    private volatile File file;
    private volatile boolean isValid;
    private final String url;
    private int varyNum;
    private WeakReference<InMemoryByteBuffer> weakReferredBuffer;
    private WeakReference<Map<String, String>> weakReferredHeaders;

    private HttpResponseCache(String str) {
        this.url = str;
        this.isValid = true;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponseCache(String str, String str2) {
        this(str);
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(str2, "cacheFilename");
        List split$default = StringsKt.split$default(str2, new String[]{"-"}, false, 0, 6, (Object) null);
        if (split$default.size() != 3) {
            throw new IllegalArgumentException("file name not valid");
        }
        Integer intOrNull = StringsKt.toIntOrNull((String) split$default.get(1));
        if (intOrNull == null) {
            throw new IllegalArgumentException("file name not valid");
        }
        this.varyNum = intOrNull.intValue();
        Long longOrNull = StringsKt.toLongOrNull((String) split$default.get(2));
        if (longOrNull == null) {
            throw new IllegalArgumentException("file name not valid");
        }
        this.expiredTime = longOrNull.longValue();
        File file = new File(CDNFetchDepender.INSTANCE.getDirectory(), str2);
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("cache not exists or not a file");
        }
        this.cacheKey = str2;
        this.file = file;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HttpResponseCache(ForestNetAPI.HttpResponse httpResponse, InMemoryByteBuffer inMemoryByteBuffer, Response response) {
        this(httpResponse.getRequest().getUrl());
        Intrinsics.checkParameterIsNotNull(httpResponse, "httpResponse");
        Intrinsics.checkParameterIsNotNull(inMemoryByteBuffer, "forestBuffer");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        if (!inMemoryByteBuffer.isCacheProvided$forest_release()) {
            throw new IllegalArgumentException("forest buffer not support cache");
        }
        updateFromOnline(httpResponse, inMemoryByteBuffer, response);
    }

    private final boolean checkValid() {
        if (!this.isValid) {
            LogUtils logUtils = LogUtils.INSTANCE;
            StringBuilder sb = new StringBuilder();
            String str = this.cacheKey;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
            }
            LogUtils.e$default(logUtils, TAG, sb.append(str).append(" is not valid").toString(), null, 4, null);
        }
        return this.isValid;
    }

    public final boolean isCachedInMemory() {
        WeakReference<InMemoryByteBuffer> weakReference = this.weakReferredBuffer;
        return (weakReference != null ? weakReference.get() : null) != null;
    }

    public final boolean isValid() {
        return checkValid();
    }

    public final String getUrl() {
        return this.url;
    }

    public final InMemoryByteBuffer provideForestBuffer(ForestPipelineContext context, Request request) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(request, "request");
        InMemoryByteBuffer inMemoryByteBuffer = null;
        if (!checkValid()) {
            return null;
        }
        WeakReference<InMemoryByteBuffer> weakReference = this.weakReferredBuffer;
        InMemoryByteBuffer inMemoryByteBuffer2 = weakReference != null ? weakReference.get() : null;
        if (inMemoryByteBuffer2 == null || !inMemoryByteBuffer2.isCacheProvided$forest_release()) {
            File file = this.file;
            if (file != null && file.isFile()) {
                inMemoryByteBuffer = context.obtainInMemoryByteBuffer$forest_release(new BytesProvider() { // from class: com.bytedance.forest.model.HttpResponseCache$provideForestBuffer$result$1
                    @Override // com.bytedance.forest.model.BytesProvider
                    public boolean isMultiProvider() {
                        return true;
                    }

                    @Override // com.bytedance.forest.model.BytesProvider
                    public InputStream provideInputStream() {
                        File file2;
                        FileInputStream fileInputStream;
                        File file3;
                        try {
                            file3 = HttpResponseCache.this.file;
                            if (file3 == null) {
                                Intrinsics.throwNpe();
                            }
                            fileInputStream = new FileInputStream(file3);
                        } catch (Exception e) {
                            LogUtils logUtils = LogUtils.INSTANCE;
                            StringBuilder sb = new StringBuilder("error occurs when getting input stream from ResponseCache, file: ");
                            file2 = HttpResponseCache.this.file;
                            LogUtils.e$default(logUtils, ForestBuffer.TAG, sb.append(file2 != null ? file2.getPath() : null).toString(), e, true, null, null, null, 112, null);
                            fileInputStream = null;
                        }
                        return fileInputStream;
                    }
                }, request);
            }
        } else {
            inMemoryByteBuffer = inMemoryByteBuffer2;
        }
        if (inMemoryByteBuffer != null) {
            this.weakReferredBuffer = new WeakReference<>(inMemoryByteBuffer);
        }
        return inMemoryByteBuffer;
    }

    public final File provideFile() {
        if (checkValid()) {
            return this.file;
        }
        return null;
    }

    public final Map<String, String> provideHeaders() {
        Map<String, String> map;
        Map<String, String> map2 = null;
        if (!checkValid()) {
            return null;
        }
        WeakReference<Map<String, String>> weakReference = this.weakReferredHeaders;
        if (weakReference == null || (map = weakReference.get()) == null) {
            RepoUtils repoUtils = RepoUtils.INSTANCE;
            String str = this.cacheKey;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
            }
            String stringJustDisk = repoUtils.getStringJustDisk(str, null);
            if (stringJustDisk != null) {
                map2 = OfflineUtil.INSTANCE.fromStringToMap(stringJustDisk);
            }
        } else {
            map2 = map;
        }
        if (map2 != null) {
            this.weakReferredHeaders = new WeakReference<>(map2);
        }
        return map2;
    }

    public final String getCacheKey() {
        String str = this.cacheKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
        }
        return str;
    }

    public final int getVaryNum() {
        return this.varyNum;
    }

    public final void updateFromOnline(ForestNetAPI.HttpResponse httpResponse, InMemoryByteBuffer forestBuffer, Response response) {
        File file;
        int i;
        Intrinsics.checkParameterIsNotNull(httpResponse, "httpResponse");
        Intrinsics.checkParameterIsNotNull(forestBuffer, "forestBuffer");
        Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
        this.weakReferredBuffer = new WeakReference<>(forestBuffer);
        final StringBuilder append = new StringBuilder(this.url).append(':');
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        Pair<Map<String, String>, Integer> generateCachedHeaders = OfflineUtil.INSTANCE.generateCachedHeaders(httpResponse, new Function2<String, Map<String, ? extends String>, String>() { // from class: com.bytedance.forest.model.HttpResponseCache$updateFromOnline$result$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final String invoke(String str, Map<String, String> map) {
                String str2;
                Intrinsics.checkParameterIsNotNull(str, "headerKey");
                if (map == null || (str2 = map.get(str)) == null) {
                    str2 = "";
                }
                if (!booleanRef.element) {
                    append.append(",");
                }
                append.append(str).append(':').append(str2);
                booleanRef.element = false;
                return str2;
            }
        });
        Map<String, String> map = (Map) generateCachedHeaders.getFirst();
        this.weakReferredHeaders = new WeakReference<>(map);
        Long expiredTime = OfflineUtil.INSTANCE.getExpiredTime(httpResponse);
        if (expiredTime == null) {
            throw new IllegalArgumentException("Cache not supported since no expired time provided");
        }
        long longValue = expiredTime.longValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        StringBuilder sb = new StringBuilder();
        String sb2 = append.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "rawCacheString.toString()");
        String stringToMd5 = MD5Utils.stringToMd5(sb2);
        if (stringToMd5 != null) {
            String substring = stringToMd5.substring(0, 8);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            objectRef.element = sb.append(substring).append("-").append(((Number) generateCachedHeaders.getSecond()).intValue()).append("-").append(longValue).toString();
            while (RepoUtils.INSTANCE.has((String) objectRef.element)) {
                objectRef.element = "forest_" + ((String) objectRef.element);
            }
            ForestLogger logger = response.getLogger();
            if (this.file != null) {
                if (!Intrinsics.areEqual(this.file != null ? r2.getName() : null, (String) objectRef.element)) {
                    String str = this.cacheKey;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
                    }
                    this.cacheKey = (String) objectRef.element;
                    this.varyNum = ((Number) generateCachedHeaders.getSecond()).intValue();
                    this.expiredTime = longValue;
                    ThreadUtils.INSTANCE.postInSingleThread(new HttpResponseCache$updateFromOnline$1(this, objectRef, logger, response, map, str));
                    return;
                }
            }
            if (this.file != null) {
                return;
            }
            this.cacheKey = (String) objectRef.element;
            this.varyNum = ((Number) generateCachedHeaders.getSecond()).intValue();
            this.expiredTime = longValue;
            File file2 = new File(CDNFetchDepender.INSTANCE.getDirectory(), ((String) objectRef.element) + WRITING_POSTFIX);
            File file3 = new File(CDNFetchDepender.INSTANCE.getDirectory(), (String) objectRef.element);
            try {
                file = null;
                try {
                    ForestLogger.print$default(logger, 4, TAG, "start to write file, " + ((String) objectRef.element), false, null, null, 56, null);
                    file2.delete();
                    file3.delete();
                    InputStream provideInputStream = forestBuffer.provideInputStream(response);
                    if (provideInputStream != null) {
                        FileOutputStream fileOutputStream = provideInputStream;
                        try {
                            InputStream inputStream = fileOutputStream;
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                i = (int) ByteStreamsKt.copyTo$default(inputStream, fileOutputStream, 0, 2, (Object) null);
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                            } finally {
                            }
                        } finally {
                        }
                    } else {
                        i = -1;
                    }
                    if (i <= 0) {
                        invalidate$default(this, false, 1, null);
                        file2.delete();
                        throw new IOException("written file size is unexpected");
                    }
                    file2.renameTo(file3);
                    response.setFilePath(file3.getAbsolutePath());
                    final String fromMapToString = OfflineUtil.INSTANCE.fromMapToString(map);
                    RepoUtils.INSTANCE.storeStringJustDisk((String) objectRef.element, fromMapToString);
                    ForestLogger.printOptimize$default(logger, 4, TAG, false, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.HttpResponseCache$updateFromOnline$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "json recorded: " + fromMapToString;
                        }
                    }, 28, null);
                    this.file = file3;
                    final String stringToMd52 = MD5Utils.stringToMd5(fromMapToString);
                    ForestLogger.printOptimize$default(logger, 4, TAG, true, null, null, new Function0<String>() { // from class: com.bytedance.forest.model.HttpResponseCache$updateFromOnline$4
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public final String invoke() {
                            return "json recorded2: " + stringToMd52 + " for key:" + ((String) objectRef.element);
                        }
                    }, 24, null);
                } catch (Throwable th) {
                    th = th;
                    LogUtils.e$default(LogUtils.INSTANCE, TAG, "write file failed", th, true, null, null, null, 112, null);
                    this.isValid = false;
                    file2.delete();
                    file3.delete();
                    this.file = file;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                file = null;
            }
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    public final boolean isStale() {
        return this.isValid && System.currentTimeMillis() > this.expiredTime;
    }

    public static /* synthetic */ void invalidate$default(HttpResponseCache httpResponseCache, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        httpResponseCache.invalidate(z);
    }

    public final void invalidate(boolean deleteImmediately) {
        this.isValid = false;
        RepoUtils repoUtils = RepoUtils.INSTANCE;
        String str = this.cacheKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cacheKey");
        }
        repoUtils.delete(str);
        if (deleteImmediately) {
            try {
                Result.Companion companion = Result.Companion;
                File file = this.file;
                Result.constructor-impl(file != null ? Boolean.valueOf(file.delete()) : null);
                return;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
                return;
            }
        }
        tryDeleteFile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryDeleteFile() {
        WeakReference<InMemoryByteBuffer> weakReference = this.weakReferredBuffer;
        InMemoryByteBuffer inMemoryByteBuffer = weakReference != null ? weakReference.get() : null;
        if (inMemoryByteBuffer != null && !inMemoryByteBuffer.isCacheReady$forest_release()) {
            ThreadUtils.INSTANCE.postInSingleThread(new Runnable() { // from class: com.bytedance.forest.model.HttpResponseCache$tryDeleteFile$1
                @Override // java.lang.Runnable
                public final void run() {
                    HttpResponseCache.this.tryDeleteFile();
                }
            }, 300000L);
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            File file = this.file;
            Result.constructor-impl(file != null ? Boolean.valueOf(file.delete()) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        this.file = null;
    }

    @Override // com.bytedance.forest.model.ForestConcurrentList.ForestListNode
    public HttpResponseCache getNext() {
        ForestConcurrentList.ForestListNode next = super.getNext();
        if (!(next instanceof HttpResponseCache)) {
            next = null;
        }
        return (HttpResponseCache) next;
    }
}
