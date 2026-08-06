package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.tools.prefetch.INetworkExecutor;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.tools.prefetch.TypedParam;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.sequences.SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProcessManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 B2\u00020\u0001:\u0001BB'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J2\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0011\u0010 \u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0096\u0002J*\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\"2\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010'\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010(\u001a\u00020\u00172\u0010\u0010)\u001a\f\u0012\u0004\u0012\u00020\u00170*j\u0002`+H\u0016Jd\u0010,\u001a\u00020-2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u000202\u0018\u00010/2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003040/H\u0002Jp\u00105\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002020/2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u000202\u0018\u00010/2\u0016\u00106\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u0003040/H\u0002J\u0018\u00107\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J^\u0010\u001a\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0016\u00101\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0006\b\u0001\u0012\u000202\u0018\u00010/2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0017H\u0016J1\u0010=\u001a\u0004\u0018\u000102\"\u0012\b\u0000\u0010>*\u00020?*\b\u0012\u0004\u0012\u00020\r04*\u0002H>2\b\u0010@\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010AR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ProcessManager;", "Lcom/bytedance/ies/tools/prefetch/IProcessManager;", "localStorage", "Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "networkExecutor", "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;", "workerExecutor", "Ljava/util/concurrent/Executor;", "cacheCapacity", "", "(Lcom/bytedance/ies/tools/prefetch/ILocalStorage;Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;Ljava/util/concurrent/Executor;I)V", "availableKeySet", "Ljava/util/LinkedHashSet;", "", "lruCache", "Lcom/bytedance/ies/tools/prefetch/TrimmableLruCache;", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "getLruCache", "()Lcom/bytedance/ies/tools/prefetch/TrimmableLruCache;", "checkExpires", "", "prefetchProcess", "clear", "", "fetchInternal", "logKey", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "expires", "", "fallback", "putCacheImmediately", PrefetchRequestConfig.METHOD_GET, "getCacheByScheme", "", "scheme", "startTime", "monitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "getSkipCache", EventConstants.PARAM_SOURCE_INIT, "initCallback", "Lkotlin/Function0;", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "parsePostBodyToValues", "Lorg/json/JSONObject;", "pathParamMap", "Ljava/util/SortedMap;", "queryMap", "variableMap", "", "dataMap", "Lcom/bytedance/ies/tools/prefetch/TypedParam;", "parseQueryToValues", "paramMap", "putCache", "process", "removeCache", "config", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "trim", "toSpecifiedType", "T", "Lcom/bytedance/ies/tools/prefetch/TypedParam$WithSpecifiedType;", "value", "(Lcom/bytedance/ies/tools/prefetch/TypedParam;Ljava/lang/String;)Ljava/lang/Object;", "Companion", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ProcessManager implements IProcessManager {
    public static final String KEY_ARRAY = "__prefetch_cache_key_array";
    private final LinkedHashSet<String> availableKeySet;
    private final ILocalStorage localStorage;
    private final TrimmableLruCache<String, PrefetchProcess> lruCache;
    private final INetworkExecutor networkExecutor;
    private final Executor workerExecutor;

    public ProcessManager(ILocalStorage iLocalStorage, INetworkExecutor iNetworkExecutor, Executor executor, int i) {
        Intrinsics.checkParameterIsNotNull(iNetworkExecutor, "networkExecutor");
        Intrinsics.checkParameterIsNotNull(executor, "workerExecutor");
        this.localStorage = iLocalStorage;
        this.networkExecutor = iNetworkExecutor;
        this.workerExecutor = executor;
        this.lruCache = new TrimmableLruCache<>(i, new Function2<String, PrefetchProcess, Boolean>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$lruCache$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(invoke((String) obj, (PrefetchProcess) obj2));
            }

            public final boolean invoke(String str, PrefetchProcess prefetchProcess) {
                boolean checkExpires;
                Intrinsics.checkParameterIsNotNull(str, "<anonymous parameter 0>");
                Intrinsics.checkParameterIsNotNull(prefetchProcess, "v");
                checkExpires = ProcessManager.this.checkExpires(prefetchProcess);
                return checkExpires;
            }
        }, new Function2<String, PrefetchProcess, Unit>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$lruCache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (PrefetchProcess) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, PrefetchProcess prefetchProcess) {
                ILocalStorage iLocalStorage2;
                LinkedHashSet linkedHashSet;
                LinkedHashSet linkedHashSet2;
                Intrinsics.checkParameterIsNotNull(str, "k");
                Intrinsics.checkParameterIsNotNull(prefetchProcess, "v");
                iLocalStorage2 = ProcessManager.this.localStorage;
                if (iLocalStorage2 != null) {
                    synchronized (ProcessManager.this) {
                        iLocalStorage2.remove(str);
                        linkedHashSet = ProcessManager.this.availableKeySet;
                        linkedHashSet.remove(str);
                        linkedHashSet2 = ProcessManager.this.availableKeySet;
                        iLocalStorage2.putStringSet(ProcessManager.KEY_ARRAY, linkedHashSet2);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                LogUtil.INSTANCE.m57i("PrefetchRequest " + prefetchProcess.getRequest().getUrl() + " expired(expires: " + prefetchProcess.getExpires() + "), removed from cache.");
            }
        });
        this.availableKeySet = new LinkedHashSet<>();
    }

    public final TrimmableLruCache<String, PrefetchProcess> getLruCache() {
        return this.lruCache;
    }

    public final void clear() {
        TrimmableLruCache<String, PrefetchProcess> trimmableLruCache = this.lruCache;
        Iterator<T> it = trimmableLruCache.keys().iterator();
        while (it.hasNext()) {
            trimmableLruCache.remove((String) it.next());
        }
        ILocalStorage iLocalStorage = this.localStorage;
        if (iLocalStorage != null) {
            iLocalStorage.removeAll();
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public void init(final Function0<Unit> initCallback) {
        Intrinsics.checkParameterIsNotNull(initCallback, "initCallback");
        this.workerExecutor.execute(new Runnable() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$init$1
            @Override // java.lang.Runnable
            public final void run() {
                ILocalStorage iLocalStorage;
                boolean checkExpires;
                LinkedHashSet linkedHashSet;
                iLocalStorage = ProcessManager.this.localStorage;
                if (iLocalStorage != null) {
                    Collection<String> stringSet = iLocalStorage.getStringSet(ProcessManager.KEY_ARRAY);
                    if (stringSet == null) {
                        LogUtil.INSTANCE.m57i("Nothing found in LocalStorage.");
                        iLocalStorage.removeAll();
                        return;
                    }
                    synchronized (ProcessManager.this) {
                        for (String str : stringSet) {
                            String string = iLocalStorage.getString(str);
                            if (string != null) {
                                try {
                                    PrefetchProcess fromJSONObject$prefetch_release = PrefetchProcess.INSTANCE.fromJSONObject$prefetch_release(new JSONObject(string));
                                    checkExpires = ProcessManager.this.checkExpires(fromJSONObject$prefetch_release);
                                    if (checkExpires) {
                                        iLocalStorage.remove(str);
                                    } else {
                                        ProcessManager.this.getLruCache().set(str, fromJSONObject$prefetch_release);
                                        linkedHashSet = ProcessManager.this.availableKeySet;
                                        linkedHashSet.add(str);
                                    }
                                } catch (JSONException e) {
                                    LogUtil.INSTANCE.m58w("Failed to load cache at " + str, e);
                                }
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                initCallback.invoke();
            }
        });
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public void request(String logKey, SortedMap<String, String> pathParamMap, SortedMap<String, String> queryMap, SortedMap<String, ? extends Object> variableMap, RequestConfig config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        LogUtil.INSTANCE.m57i("Start request: " + config);
        SortedMap<String, TypedParam<?>> paramMap = config.getParamMap();
        SortedMap<String, Object> parseQueryToValues = paramMap != null ? parseQueryToValues(pathParamMap, queryMap, variableMap, paramMap) : null;
        SortedMap<String, TypedParam<?>> dataMap = config.getDataMap();
        PrefetchRequest prefetchRequest = new PrefetchRequest(config.getApiUrl(), config.getMethod(), config.getHeaderMap(), parseQueryToValues, dataMap != null ? parsePostBodyToValues(pathParamMap, queryMap, variableMap, dataMap) : null, config.getNeedCommonParams(), config.getExtras(), config.getIgnoreHeaders());
        PrefetchProcess prefetchProcess = this.lruCache.get(prefetchRequest.toString());
        fetchInternal(logKey, prefetchRequest, config.getExpireTimeout(), false, prefetchProcess != null ? checkExpires(prefetchProcess) : true);
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public void trim() {
        this.lruCache.trim();
        synchronized (this) {
            ILocalStorage iLocalStorage = this.localStorage;
            if (iLocalStorage != null) {
                iLocalStorage.putStringSet(KEY_ARRAY, this.availableKeySet);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public PrefetchProcess get(PrefetchRequest request) {
        String string;
        Object obj;
        Intrinsics.checkParameterIsNotNull(request, "request");
        LogUtil.INSTANCE.m57i("Start to get from cache for " + request + '.');
        String prefetchRequest = request.toString();
        PrefetchProcess prefetchProcess = this.lruCache.get(prefetchRequest);
        if (prefetchProcess == null) {
            LogUtil.INSTANCE.m57i("Not found in lruCache.");
            ILocalStorage iLocalStorage = this.localStorage;
            if (iLocalStorage != null && (string = iLocalStorage.getString(prefetchRequest)) != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.constructor-impl(PrefetchProcess.INSTANCE.fromJSONObject$prefetch_release(new JSONObject(string)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                PrefetchProcess prefetchProcess2 = (PrefetchProcess) obj;
                if (prefetchProcess2 == null || checkExpires(prefetchProcess2)) {
                    LogUtil.INSTANCE.m57i("Found in local storage but expired.");
                    removeCache(request);
                } else {
                    LogUtil.INSTANCE.m57i("Found in local storage.");
                    prefetchProcess2.setHitState(PrefetchProcess.HitState.CACHED);
                    putCache(request, prefetchProcess2);
                    return prefetchProcess2;
                }
            }
        } else {
            if (!checkExpires(prefetchProcess)) {
                LogUtil.INSTANCE.m57i("Found in lruCache.");
                if (prefetchProcess.getResponse() != null) {
                    prefetchProcess.setHitState(PrefetchProcess.HitState.CACHED);
                }
                return prefetchProcess;
            }
            LogUtil.INSTANCE.m57i("Found in lruCache but expired.");
            removeCache(request);
        }
        LogUtil.INSTANCE.m57i("Fallback to normal fetch.");
        return fetchInternal(null, request, -1L, true, true);
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public PrefetchProcess getSkipCache(PrefetchRequest request) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        LogUtil.INSTANCE.m57i("Skip Cache to normal fetch for " + request + '.');
        return fetchInternal(null, request, -1L, true, true);
    }

    @Override // com.bytedance.ies.tools.prefetch.IProcessManager
    public List<PrefetchProcess> getCacheByScheme(String scheme, long startTime, IMonitor monitor) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        LogUtil.INSTANCE.m57i("Start to get cache by " + scheme + '.');
        ArrayList arrayList = null;
        for (PrefetchProcess prefetchProcess : this.lruCache.snapshot().values()) {
            if (Intrinsics.areEqual(scheme, prefetchProcess.getPageUrl())) {
                if (!checkExpires(prefetchProcess)) {
                    LogUtil.INSTANCE.m57i(prefetchProcess.getRequest().getUrl() + " found in lruCache.");
                    if (prefetchProcess.getResponse() != null) {
                        prefetchProcess.setHitState(PrefetchProcess.HitState.CACHED);
                    }
                    prefetchProcess.setBusinessGetDataStartTimeStamp(prefetchProcess.getStartTimeStamp());
                    prefetchProcess.setMonitor(monitor);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (arrayList != null) {
                        arrayList.add(prefetchProcess);
                    }
                } else {
                    LogUtil.INSTANCE.m57i(prefetchProcess.getRequest().getUrl() + " found in lruCache but expired.");
                    removeCache(prefetchProcess.getRequest());
                }
            }
        }
        return arrayList;
    }

    private final PrefetchProcess fetchInternal(String logKey, final PrefetchRequest request, long expires, boolean fallback, boolean putCacheImmediately) {
        String str;
        long j;
        PrefetchProcess.HitState hitState;
        String str2;
        final String createApiUrl = UtilKt.createApiUrl(request.getUrl(), request.getParamMap());
        if (logKey != null) {
            j = expires;
            str = logKey;
        } else {
            str = "";
            j = expires;
        }
        final PrefetchProcess prefetchProcess = new PrefetchProcess(str, request, j);
        if (putCacheImmediately) {
            putCache(request, prefetchProcess);
        }
        INetworkExecutor.Callback callback = new INetworkExecutor.Callback() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$fetchInternal$netCallback$1
            @Override // com.bytedance.ies.tools.prefetch.INetworkExecutor.Callback
            public void onRequestSucceed(INetworkExecutor.HttpResponse response) {
                Intrinsics.checkParameterIsNotNull(response, "response");
                LogUtil.INSTANCE.m57i("Received response, url: " + createApiUrl);
                prefetchProcess.onRequestSucceed(response);
                if (prefetchProcess.getExpires() > 0) {
                    LogUtil.INSTANCE.m57i("Putting to cache, key: " + request + ", expires: " + prefetchProcess.getExpires());
                    ProcessManager.this.putCache(request, prefetchProcess);
                }
            }

            @Override // com.bytedance.ies.tools.prefetch.INetworkExecutor.Callback
            public void onRequestFailed(Throwable throwable) {
                Intrinsics.checkParameterIsNotNull(throwable, "throwable");
                LogUtil.INSTANCE.m57i("Request failed, url: " + createApiUrl);
                prefetchProcess.onRequestFailed(throwable);
            }
        };
        String method = request.getMethod();
        Locale locale = Locale.ROOT;
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ROOT");
        if (method == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = method.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        int hashCode = lowerCase.hashCode();
        if (hashCode == 102230) {
            if (lowerCase.equals(PrefetchRequestConfig.METHOD_GET)) {
                LogUtil.INSTANCE.m55d("[request_key:" + logKey + "] get");
                INetworkExecutor iNetworkExecutor = this.networkExecutor;
                SortedMap<String, String> headerMap = request.getHeaderMap();
                iNetworkExecutor.get(createApiUrl, headerMap != null ? headerMap : MapsKt.emptyMap(), request.getNeedCommonParams(), request.getExtras(), callback);
            }
            LogUtil.e$default(LogUtil.INSTANCE, "No network impl for method '" + request.getMethod() + '\'', null, 2, null);
        } else {
            if (hashCode == 3446944 && lowerCase.equals(PrefetchRequestConfig.METHOD_POST)) {
                LogUtil.INSTANCE.m55d("[request_key:" + logKey + "] post");
                INetworkExecutor iNetworkExecutor2 = this.networkExecutor;
                SortedMap<String, String> headerMap2 = request.getHeaderMap();
                Map<String, String> emptyMap = headerMap2 != null ? headerMap2 : MapsKt.emptyMap();
                SortedMap<String, String> headerMap3 = request.getHeaderMap();
                if (headerMap3 == null || (str2 = headerMap3.get(XBridgeAPIRequestUtils.CONTENT_TYPE)) == null) {
                    str2 = "application/x-www-form-urlencoded";
                }
                String str3 = str2;
                JSONObject dataMap = request.getDataMap();
                if (dataMap == null) {
                    dataMap = new JSONObject();
                }
                iNetworkExecutor2.post(createApiUrl, emptyMap, str3, dataMap, request.getNeedCommonParams(), request.getExtras(), callback);
            }
            LogUtil.e$default(LogUtil.INSTANCE, "No network impl for method '" + request.getMethod() + '\'', null, 2, null);
        }
        if (prefetchProcess.getExpires() == -1 || fallback) {
            hitState = PrefetchProcess.HitState.FALLBACK;
        } else {
            hitState = PrefetchProcess.HitState.PENDING;
        }
        prefetchProcess.setHitState(hitState);
        return prefetchProcess;
    }

    private final SortedMap<String, Object> parseQueryToValues(final SortedMap<String, String> pathParamMap, final SortedMap<String, String> queryMap, final SortedMap<String, ? extends Object> variableMap, final SortedMap<String, TypedParam<?>> paramMap) {
        TreeMap treeMap = new TreeMap();
        Set<Map.Entry<String, TypedParam<?>>> entrySet = paramMap.entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "paramMap.entries");
        for (Pair pair : SequencesKt.mapNotNull(CollectionsKt.asSequence(entrySet), new Function1<Map.Entry<String, TypedParam<?>>, Pair<? extends String, ? extends Object>>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$parseQueryToValues$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Pair<String, Object> invoke(Map.Entry<String, TypedParam<?>> entry) {
                SortedMap sortedMap;
                Object obj;
                Intrinsics.checkParameterIsNotNull(entry, "<name for destructuring parameter 0>");
                String key = entry.getKey();
                TypedParam<?> value = entry.getValue();
                if (value instanceof StaticParam) {
                    obj = ((StaticParam) value).getValue$prefetch_release();
                } else if (value instanceof VariableParam) {
                    SortedMap sortedMap2 = variableMap;
                    if (sortedMap2 != null) {
                        obj = sortedMap2.get(((VariableParam) value).getValue$prefetch_release());
                    }
                    obj = null;
                } else if (value instanceof PathParam) {
                    SortedMap sortedMap3 = pathParamMap;
                    if (sortedMap3 != null) {
                        obj = (String) sortedMap3.get(((PathParam) value).getValue$prefetch_release());
                    }
                    obj = null;
                } else {
                    if ((value instanceof ParameterizedParam) && (sortedMap = queryMap) != null) {
                        obj = (String) sortedMap.get(((ParameterizedParam) value).getValue$prefetch_release());
                    }
                    obj = null;
                }
                if (obj != null) {
                    return new Pair<>(key, obj);
                }
                return null;
            }
        })) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            Intrinsics.checkExpressionValueIsNotNull(str, "key");
            treeMap.put(str, component2);
            LogUtil.INSTANCE.m57i("Append param: " + str + " = " + component2);
        }
        return treeMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject parsePostBodyToValues(final SortedMap<String, String> pathParamMap, final SortedMap<String, String> queryMap, final SortedMap<String, ? extends Object> variableMap, final SortedMap<String, TypedParam<?>> dataMap) {
        JSONObject jSONObject = new JSONObject();
        Set<Map.Entry<String, TypedParam<?>>> entrySet = dataMap.entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "dataMap.entries");
        for (Pair pair : SequencesKt.mapNotNull(CollectionsKt.asSequence(entrySet), new Function1<Map.Entry<String, TypedParam<?>>, Pair<? extends String, ? extends Object>>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$parsePostBodyToValues$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Pair<String, Object> invoke(Map.Entry<String, TypedParam<?>> entry) {
                Object parsePostBodyToValues;
                Intrinsics.checkParameterIsNotNull(entry, "<name for destructuring parameter 0>");
                String key = entry.getKey();
                TypedParam<?> value = entry.getValue();
                if (value instanceof StaticParam) {
                    parsePostBodyToValues = ((StaticParam) value).getValue$prefetch_release();
                } else if (value instanceof VariableParam) {
                    SortedMap sortedMap = variableMap;
                    if (sortedMap != null) {
                        parsePostBodyToValues = sortedMap.get(((VariableParam) value).getValue$prefetch_release());
                    }
                    parsePostBodyToValues = null;
                } else if (value instanceof PathParam) {
                    SortedMap sortedMap2 = pathParamMap;
                    if (sortedMap2 != null) {
                        parsePostBodyToValues = ProcessManager.this.toSpecifiedType(value, (String) sortedMap2.get(((PathParam) value).getValue$prefetch_release()));
                    }
                    parsePostBodyToValues = null;
                } else if (value instanceof ParameterizedParam) {
                    SortedMap sortedMap3 = queryMap;
                    if (sortedMap3 != null) {
                        parsePostBodyToValues = ProcessManager.this.toSpecifiedType(value, (String) sortedMap3.get(((ParameterizedParam) value).getValue$prefetch_release()));
                    }
                    parsePostBodyToValues = null;
                } else if (value instanceof NestedParam) {
                    parsePostBodyToValues = ProcessManager.this.parsePostBodyToValues(pathParamMap, queryMap, variableMap, ((NestedParam) value).getValue$prefetch_release());
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                if (parsePostBodyToValues != null) {
                    return new Pair<>(key, parsePostBodyToValues);
                }
                return null;
            }
        })) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            jSONObject.put(str, component2);
            LogUtil.INSTANCE.m57i("Append param: " + str + " = " + component2);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Incorrect types in method signature: <T:Lcom/bytedance/ies/tools/prefetch/TypedParam<Ljava/lang/String;>;:Lcom/bytedance/ies/tools/prefetch/TypedParam$WithSpecifiedType;>(TT;Ljava/lang/String;)Ljava/lang/Object; */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object toSpecifiedType(TypedParam typedParam, String str) {
        ProcessManager$toSpecifiedType$1 processManager$toSpecifiedType$1 = ProcessManager$toSpecifiedType$1.INSTANCE;
        if (str == null) {
            return null;
        }
        String dataType = ((TypedParam.WithSpecifiedType) typedParam).getDataType();
        int hashCode = dataType.hashCode();
        return hashCode != -1034364087 ? (hashCode == 3029738 && dataType.equals("bool")) ? processManager$toSpecifiedType$1.invoke(str, (Function1<? super String, ? extends Object>) new Function1<String, Boolean>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$toSpecifiedType$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((String) obj));
            }

            public final boolean invoke(String str2) {
                Intrinsics.checkParameterIsNotNull(str2, "$receiver");
                return Boolean.parseBoolean(str2);
            }
        }) : str : dataType.equals("number") ? processManager$toSpecifiedType$1.invoke(str, (Function1<? super String, ? extends Object>) new Function1<String, String>() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$toSpecifiedType$2
            public final String invoke(String str2) {
                Intrinsics.checkParameterIsNotNull(str2, "$receiver");
                double parseDouble = Double.parseDouble(str2);
                if (parseDouble - Math.floor(parseDouble) < 1.0E-10d) {
                    return String.valueOf((long) parseDouble);
                }
                return String.valueOf(parseDouble);
            }
        }) : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkExpires(PrefetchProcess prefetchProcess) {
        return (System.currentTimeMillis() - prefetchProcess.getStartTimeStamp()) - prefetchProcess.getExpires() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void putCache(PrefetchRequest request, final PrefetchProcess process) {
        if (process.getExpires() <= 0) {
            return;
        }
        final String prefetchRequest = request.toString();
        this.lruCache.set(prefetchRequest, process);
        this.workerExecutor.execute(new Runnable() { // from class: com.bytedance.ies.tools.prefetch.ProcessManager$putCache$1
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r0 = r4.this$0.localStorage;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                ILocalStorage iLocalStorage;
                LinkedHashSet linkedHashSet;
                LinkedHashSet linkedHashSet2;
                if (process.getResponse() == null || iLocalStorage == null) {
                    return;
                }
                synchronized (ProcessManager.this) {
                    linkedHashSet = ProcessManager.this.availableKeySet;
                    if (linkedHashSet.add(prefetchRequest)) {
                        linkedHashSet2 = ProcessManager.this.availableKeySet;
                        iLocalStorage.putStringSet(ProcessManager.KEY_ARRAY, linkedHashSet2);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                String str = prefetchRequest;
                String jSONObject = process.toJSONObject().toString();
                Intrinsics.checkExpressionValueIsNotNull(jSONObject, "process.toJSONObject().toString()");
                iLocalStorage.putString(str, jSONObject);
            }
        });
    }

    private final void removeCache(PrefetchRequest request) {
        String prefetchRequest = request.toString();
        this.lruCache.remove(prefetchRequest);
        ILocalStorage iLocalStorage = this.localStorage;
        if (iLocalStorage != null) {
            synchronized (this) {
                if (this.availableKeySet.remove(prefetchRequest)) {
                    iLocalStorage.putStringSet(KEY_ARRAY, this.availableKeySet);
                }
                Unit unit = Unit.INSTANCE;
            }
            iLocalStorage.remove(prefetchRequest);
        }
    }
}
