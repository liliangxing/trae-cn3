package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;

/* compiled from: PrefetchHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH&J&\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H&J4\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&J&\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0013H&J4\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0013H&J6\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "", "scheme", "", "getSkipCache", ErrorType.PREFETCH, "", "url", "prefetchWithOccasion", "occasion", "variables", "Ljava/util/SortedMap;", "prefetchWithOccasionAndConfig", "configCollection", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "prefetchWithVariablesAndConfig", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPrefetchHandler {
    PrefetchProcess get(PrefetchRequest request, ProcessListener listener);

    List<PrefetchProcess> getCacheByScheme(String scheme);

    PrefetchProcess getSkipCache(PrefetchRequest request, ProcessListener listener);

    void prefetch(String url);

    void prefetchWithOccasion(String occasion, SortedMap<String, String> variables);

    void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection);

    void prefetchWithScheme(String scheme, SortedMap<String, String> variables);

    void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection);

    void prefetchWithVariables(String scheme, SortedMap<String, ? extends Object> variables);

    void prefetchWithVariablesAndConfig(String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection);
}
