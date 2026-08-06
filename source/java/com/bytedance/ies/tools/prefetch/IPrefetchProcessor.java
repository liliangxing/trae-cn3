package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: BasePrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH'J&\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017H'J4\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'J&\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017H'J4\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'J(\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u0017H'J6\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000f2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH'J\u0014\u0010 \u001a\u00020\u00122\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H&¨\u0006#"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "", "createMethodStub", "Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "resultListener", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "", "scheme", "", "getIgnoreCache", ErrorType.PREFETCH, "", "pageUrl", "prefetchWithOccasion", "occasion", "variables", "Ljava/util/SortedMap;", "prefetchWithOccasionAndConfig", "configCollection", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "prefetchWithVariablesAndConfig", "updateConfig", "newConfigProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IPrefetchProcessor {
    IPrefetchMethodStub createMethodStub(IPrefetchResultListener resultListener);

    PrefetchProcess get(PrefetchRequest request, ProcessListener listener);

    List<PrefetchProcess> getCacheByScheme(String scheme);

    PrefetchProcess getIgnoreCache(PrefetchRequest request, ProcessListener listener);

    void prefetch(String pageUrl);

    void prefetchWithOccasion(String occasion, SortedMap<String, String> variables);

    void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection);

    @Deprecated(message = "Use prefetchWithVariables(scheme: String, variables: SortedMap<String, out Any>?)")
    void prefetchWithScheme(String scheme, SortedMap<String, String> variables);

    @Deprecated(message = "Use prefetchWithSchemeAndConfig(scheme: String, variables: SortedMap<String, String>?, configCollection: Collection<RequestConfig>)")
    void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection);

    void prefetchWithVariables(String scheme, SortedMap<String, ? extends Object> variables);

    void prefetchWithVariablesAndConfig(String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection);

    void updateConfig(IConfigProvider newConfigProvider);

    /* compiled from: BasePrefetchProcessor.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void updateConfig$default(IPrefetchProcessor iPrefetchProcessor, IConfigProvider iConfigProvider, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateConfig");
            }
            if ((i & 1) != 0) {
                iConfigProvider = null;
            }
            iPrefetchProcessor.updateConfig(iConfigProvider);
        }
    }
}
