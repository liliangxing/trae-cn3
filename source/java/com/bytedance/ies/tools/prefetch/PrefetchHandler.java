package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PrefetchHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00120\u000bj\u0002`\u0013\u0018\u00010\u0011¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0017J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016Jd\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010\n2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%2\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%2\u0016\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020(\u0018\u00010%H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\nH\u0017J&\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\n2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%H\u0017J4\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\n2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J&\u00100\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%H\u0017J4\u00101\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010%2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J(\u00102\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020(\u0018\u00010%H\u0016J6\u00103\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\n2\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\b\u0001\u0012\u00020(\u0018\u00010%2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchHandler;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "processManager", "Lcom/bytedance/ies/tools/prefetch/IProcessManager;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "prefetchMonitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "conditionMap", "", "", "Lkotlin/Function0;", "", "urlAdapterList", "", "Lcom/bytedance/ies/tools/prefetch/IUriAdapter;", "initCallbackRef", "Ljava/lang/ref/WeakReference;", "", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "(Lcom/bytedance/ies/tools/prefetch/IProcessManager;Lcom/bytedance/ies/tools/prefetch/IConfigManager;Lcom/bytedance/ies/tools/prefetch/IMonitor;Ljava/util/Map;Ljava/util/List;Ljava/lang/ref/WeakReference;)V", "clear", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "scheme", "getSkipCache", "handlePrefetch", "logKey", "requestConfigs", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "pathParamMap", "Ljava/util/SortedMap;", "queryMap", "variableMap", "", ErrorType.PREFETCH, "url", "prefetchWithOccasion", "occasion", "variables", "prefetchWithOccasionAndConfig", "configCollection", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "prefetchWithVariablesAndConfig", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchHandler implements IPrefetchHandler {
    private final Map<String, Function0<Boolean>> conditionMap;
    private final IConfigManager configManager;
    private final IMonitor prefetchMonitor;
    private final IProcessManager processManager;
    private final List<IUriAdapter> urlAdapterList;

    /* JADX WARN: Multi-variable type inference failed */
    public PrefetchHandler(IProcessManager iProcessManager, IConfigManager iConfigManager, IMonitor iMonitor, Map<String, ? extends Function0<Boolean>> map, List<? extends IUriAdapter> list, final WeakReference<Function0<Unit>> weakReference) {
        Intrinsics.checkParameterIsNotNull(iProcessManager, "processManager");
        Intrinsics.checkParameterIsNotNull(iConfigManager, "configManager");
        this.processManager = iProcessManager;
        this.configManager = iConfigManager;
        this.prefetchMonitor = iMonitor;
        this.conditionMap = map;
        this.urlAdapterList = list;
        iConfigManager.init(new Function0<Unit>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchHandler.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m618invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m618invoke() {
                PrefetchHandler.this.processManager.init(new Function0<Unit>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchHandler.1.1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m619invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public void m619invoke() {
                        Function0 function0;
                        WeakReference weakReference2 = weakReference;
                        if (weakReference2 == null || (function0 = (Function0) weakReference2.get()) == null) {
                            return;
                        }
                    }
                });
            }
        });
    }

    public final void clear() {
        IProcessManager iProcessManager = this.processManager;
        if (!(iProcessManager instanceof ProcessManager)) {
            iProcessManager = null;
        }
        ProcessManager processManager = (ProcessManager) iProcessManager;
        if (processManager != null) {
            processManager.clear();
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetch(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        prefetchWithScheme(url, null);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithScheme(String scheme, SortedMap<String, String> variables) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        prefetchWithVariables(scheme, variables);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithVariables(final String scheme, SortedMap<String, ? extends Object> variables) {
        String str;
        Sequence asSequence;
        Sequence filter;
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        LogUtil.INSTANCE.m57i("Start prefetch, page scheme: " + scheme);
        List<IUriAdapter> list = this.urlAdapterList;
        if (list == null || (asSequence = CollectionsKt.asSequence(list)) == null || (filter = SequencesKt.filter(asSequence, new Function1<IUriAdapter, Boolean>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchHandler$prefetchWithVariables$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((IUriAdapter) obj));
            }

            public final boolean invoke(IUriAdapter iUriAdapter) {
                Intrinsics.checkParameterIsNotNull(iUriAdapter, "it");
                return iUriAdapter.shouldConvert(scheme);
            }
        })) == null) {
            str = scheme;
        } else {
            Iterator it = filter.iterator();
            String str2 = scheme;
            while (it.hasNext()) {
                str2 = ((IUriAdapter) it.next()).convert(scheme);
                LogUtil.INSTANCE.m55d("Scheme convert to [schema:" + str2 + "], origin_scheme:" + scheme);
            }
            str = str2;
        }
        UriWrapper uriWrapper = new UriWrapper(str);
        Pair<Collection<RequestConfig>, SortedMap<String, String>> configListByUrl = this.configManager.getConfigListByUrl(uriWrapper);
        if (configListByUrl == null) {
            LogUtil.w$default(LogUtil.INSTANCE, "No config found for page " + str + ", skipping...", null, 2, null);
        } else {
            handlePrefetch(str, (Collection) configListByUrl.getFirst(), (SortedMap) configListByUrl.getSecond(), uriWrapper.getQueryMap(), variables);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        prefetchWithVariablesAndConfig(scheme, variables, configCollection);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithVariablesAndConfig(final String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection) {
        String str;
        Sequence asSequence;
        Sequence filter;
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        LogUtil.INSTANCE.m57i("Start prefetch, page scheme: " + scheme);
        List<IUriAdapter> list = this.urlAdapterList;
        if (list == null || (asSequence = CollectionsKt.asSequence(list)) == null || (filter = SequencesKt.filter(asSequence, new Function1<IUriAdapter, Boolean>() { // from class: com.bytedance.ies.tools.prefetch.PrefetchHandler$prefetchWithVariablesAndConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return Boolean.valueOf(invoke((IUriAdapter) obj));
            }

            public final boolean invoke(IUriAdapter iUriAdapter) {
                Intrinsics.checkParameterIsNotNull(iUriAdapter, "it");
                return iUriAdapter.shouldConvert(scheme);
            }
        })) == null) {
            str = scheme;
        } else {
            Iterator it = filter.iterator();
            String str2 = scheme;
            while (it.hasNext()) {
                str2 = ((IUriAdapter) it.next()).convert(scheme);
                LogUtil.INSTANCE.m55d("Scheme convert to [schema:" + str2 + "], origin_scheme:" + scheme);
            }
            str = str2;
        }
        handlePrefetch(str, configCollection, null, new UriWrapper(str).getQueryMap(), variables);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithOccasion(String occasion, SortedMap<String, String> variables) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        LogUtil.INSTANCE.m57i("Start prefetch,occasion :" + occasion);
        Pair<Collection<RequestConfig>, SortedMap<String, String>> configListByOccasion = this.configManager.getConfigListByOccasion(occasion);
        if (configListByOccasion == null) {
            LogUtil.w$default(LogUtil.INSTANCE, "No config found for occasion " + occasion + ", skipping...", null, 2, null);
        } else {
            handlePrefetch(occasion, (Collection) configListByOccasion.getFirst(), (SortedMap) configListByOccasion.getSecond(), null, variables);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        handlePrefetch(occasion, configCollection, null, null, variables);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public PrefetchProcess get(PrefetchRequest request, ProcessListener listener) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        PrefetchProcess prefetchProcess = this.processManager.get(request);
        prefetchProcess.setBusinessGetDataStartTimeStamp(currentTimeMillis);
        prefetchProcess.setMonitor(this.prefetchMonitor);
        return prefetchProcess;
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public PrefetchProcess getSkipCache(PrefetchRequest request, ProcessListener listener) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        long currentTimeMillis = System.currentTimeMillis();
        PrefetchProcess skipCache = this.processManager.getSkipCache(request);
        skipCache.setBusinessGetDataStartTimeStamp(currentTimeMillis);
        skipCache.setMonitor(this.prefetchMonitor);
        return skipCache;
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchHandler
    public List<PrefetchProcess> getCacheByScheme(String scheme) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        return this.processManager.getCacheByScheme(scheme, System.currentTimeMillis(), this.prefetchMonitor);
    }

    private final void handlePrefetch(String logKey, Collection<RequestConfig> requestConfigs, SortedMap<String, String> pathParamMap, SortedMap<String, String> queryMap, SortedMap<String, ? extends Object> variableMap) {
        this.processManager.trim();
        for (RequestConfig requestConfig : requestConfigs) {
            if (this.conditionMap != null && requestConfig.getConditions() != null) {
                for (String str : requestConfig.getConditions()) {
                    Function0<Boolean> function0 = this.conditionMap.get(str);
                    if (function0 == null || !((Boolean) function0.invoke()).booleanValue()) {
                        LogUtil.INSTANCE.m57i("Condition " + str + " returned false, skipping this page.");
                        break;
                    }
                }
            }
            this.processManager.request(logKey, pathParamMap, queryMap, variableMap, requestConfig);
        }
    }
}
