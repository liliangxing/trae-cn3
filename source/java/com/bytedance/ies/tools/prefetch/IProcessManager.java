package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ProcessManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002J*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00100\u0012j\u0002`\u0013H&J^\u0010\u0004\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00162\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00162\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u0010H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IProcessManager;", "", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "getCacheByScheme", "", "scheme", "", "startTime", "", "monitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "getSkipCache", EventConstants.PARAM_SOURCE_INIT, "", "initCallback", "Lkotlin/Function0;", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "logKey", "pathParamMap", "Ljava/util/SortedMap;", "queryMap", "variableMap", "config", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "trim", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IProcessManager {
    PrefetchProcess get(PrefetchRequest request);

    List<PrefetchProcess> getCacheByScheme(String scheme, long startTime, IMonitor monitor);

    PrefetchProcess getSkipCache(PrefetchRequest request);

    void init(Function0<Unit> initCallback);

    void request(String logKey, SortedMap<String, String> pathParamMap, SortedMap<String, String> queryMap, SortedMap<String, ? extends Object> variableMap, RequestConfig config);

    void trim();
}
