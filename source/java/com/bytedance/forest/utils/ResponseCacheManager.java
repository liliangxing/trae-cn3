package com.bytedance.forest.utils;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.model.ForestConcurrentList;
import com.bytedance.forest.model.HttpResponseCache;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ResponseCacheManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002Jy\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00122\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u00180\u00122\u001a\u0010\u0019\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/forest/utils/ResponseCacheManager;", "", "()V", "TAG", "", "repoCachedResponse", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/forest/model/ForestConcurrentList;", "Lcom/bytedance/forest/model/HttpResponseCache;", "createOrGetCacheList", "url", "getCacheKeys", "cacheList", "logger", "Lcom/bytedance/forest/utils/ForestLogger;", "traverseAndFetchCacheIf", "", "recordPerf", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", Api.COL_TAG, "", "condition", "Lkotlin/Pair;", "handlerIfNotMatch", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ResponseCacheManager {
    private static final String TAG = "ResponseCacheManager";
    public static final ResponseCacheManager INSTANCE = new ResponseCacheManager();
    private static final ConcurrentHashMap<String, ForestConcurrentList<HttpResponseCache>> repoCachedResponse = new ConcurrentHashMap<>();

    private ResponseCacheManager() {
    }

    private final ForestConcurrentList<HttpResponseCache> createOrGetCacheList(String url) {
        ConcurrentHashMap<String, ForestConcurrentList<HttpResponseCache>> concurrentHashMap = repoCachedResponse;
        ForestConcurrentList<HttpResponseCache> forestConcurrentList = concurrentHashMap.get(url);
        if (forestConcurrentList != null) {
            Intrinsics.checkExpressionValueIsNotNull(forestConcurrentList, "this");
            synchronized (forestConcurrentList) {
            }
            return forestConcurrentList;
        }
        ForestConcurrentList<HttpResponseCache> forestConcurrentList2 = new ForestConcurrentList<>();
        synchronized (forestConcurrentList2) {
            ForestConcurrentList<HttpResponseCache> putIfAbsent = concurrentHashMap.putIfAbsent(url, forestConcurrentList2);
            if (putIfAbsent != null) {
                Intrinsics.checkExpressionValueIsNotNull(putIfAbsent, "it");
                synchronized (putIfAbsent) {
                }
                return putIfAbsent;
            }
            String stringJustDisk = RepoUtils.INSTANCE.getStringJustDisk(url, null);
            if (stringJustDisk == null) {
                return forestConcurrentList2;
            }
            List split$default = StringsKt.split$default(stringJustDisk, new String[]{","}, false, 0, 6, (Object) null);
            for (int size = split$default.size() - 1; size >= 0; size--) {
                String str = (String) split$default.get(size);
                try {
                    Result.Companion companion = Result.Companion;
                    forestConcurrentList2.insertToHead(new HttpResponseCache(url, str));
                    Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    Result.constructor-impl(ResultKt.createFailure(th));
                }
            }
            return forestConcurrentList2;
        }
    }

    public static /* synthetic */ boolean traverseAndFetchCacheIf$default(ResponseCacheManager responseCacheManager, String str, ForestLogger forestLogger, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        return responseCacheManager.traverseAndFetchCacheIf(str, forestLogger, function1, function12, function13);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e8, code lost:
    
        if (((r26 == null || (r1 = (java.lang.Boolean) r26.invoke(r13)) == null) ? false : r1.booleanValue()) != false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean traverseAndFetchCacheIf(final String url, final ForestLogger logger, Function1<? super String, Unit> recordPerf, Function1<? super HttpResponseCache, Pair<Boolean, Boolean>> condition, Function1<? super ForestConcurrentList<HttpResponseCache>, Boolean> handlerIfNotMatch) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(condition, "condition");
        if (recordPerf != null) {
        }
        final ForestConcurrentList<HttpResponseCache> createOrGetCacheList = createOrGetCacheList(url);
        if (recordPerf != null) {
        }
        HttpResponseCache first = createOrGetCacheList.getFirst();
        if (recordPerf != null) {
        }
        boolean z = false;
        HttpResponseCache httpResponseCache = first;
        boolean z2 = false;
        boolean z3 = false;
        while (httpResponseCache != null) {
            String cacheKey = httpResponseCache.getCacheKey();
            ForestLogger.print$default(logger, 4, TAG, "get file cache key, " + cacheKey, false, null, null, 56, null);
            if (StringsKt.isBlank(cacheKey)) {
                ForestLogger.print$default(logger, 6, TAG, "hash cache key is blank", false, null, null, 56, null);
                httpResponseCache = httpResponseCache.getNext();
            } else if (!httpResponseCache.isValid() || z2) {
                httpResponseCache = httpResponseCache.getNext();
            } else {
                Pair pair = (Pair) condition.invoke(httpResponseCache);
                z2 = z2 || ((Boolean) pair.getFirst()).booleanValue();
                z3 = z3 || ((Boolean) pair.getSecond()).booleanValue();
                httpResponseCache = httpResponseCache.getNext();
            }
        }
        if (!z2) {
            if (!z3) {
            }
            z = true;
            z3 = z;
        }
        if (z3) {
            ThreadUtils.INSTANCE.postInSingleThread(new Runnable() { // from class: com.bytedance.forest.utils.ResponseCacheManager$traverseAndFetchCacheIf$1
                @Override // java.lang.Runnable
                public final void run() {
                    String cacheKeys;
                    cacheKeys = ResponseCacheManager.INSTANCE.getCacheKeys(ForestConcurrentList.this, logger);
                    if (StringsKt.isBlank(cacheKeys)) {
                        RepoUtils.INSTANCE.delete(url);
                    } else {
                        RepoUtils.INSTANCE.storeStringJustDisk(url, cacheKeys);
                    }
                }
            });
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getCacheKeys(ForestConcurrentList<HttpResponseCache> cacheList, ForestLogger logger) {
        boolean z;
        HttpResponseCache first = cacheList.getFirst();
        ArrayList arrayList = new ArrayList();
        while (true) {
            z = true;
            if (first == null) {
                break;
            }
            if (first.isValid() && (true ^ StringsKt.isBlank(first.getCacheKey()))) {
                arrayList.add(first);
            }
            first = first.getNext();
        }
        StringBuilder sb = new StringBuilder();
        CollectionsKt.sortedWith(arrayList, new Comparator<T>() { // from class: com.bytedance.forest.utils.ResponseCacheManager$getCacheKeys$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((HttpResponseCache) t).getVaryNum()), Integer.valueOf(((HttpResponseCache) t2).getVaryNum()));
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HttpResponseCache httpResponseCache = (HttpResponseCache) it.next();
            if (!z) {
                sb.append(',');
            }
            sb.append(httpResponseCache.getCacheKey());
            z = false;
        }
        String sb2 = sb.toString();
        ForestLogger.print$default(logger, 4, TAG, "write back " + sb2, false, null, null, 56, null);
        Intrinsics.checkExpressionValueIsNotNull(sb2, "it");
        return sb2;
    }
}
