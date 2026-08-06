package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0017J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0018\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003H\u0017J&\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00032\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)H\u0017J4\u0010*\u001a\u00020$2\u0006\u0010'\u001a\u00020\u00032\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0017J&\u0010.\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00032\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)H\u0017J4\u0010/\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00032\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0017J(\u00100\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00032\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u000201\u0018\u00010)H\u0016J6\u00102\u001a\u00020$2\u0006\u0010!\u001a\u00020\u00032\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u000201\u0018\u00010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0016J\u0012\u00103\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "business", "", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;Lcom/bytedance/ies/tools/prefetch/IConfigManager;)V", "getBusiness", "()Ljava/lang/String;", "getConfigManager", "()Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "getHandler", "()Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "createMethodStub", "Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "resultListener", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "", "scheme", "getIgnoreCache", ErrorType.PREFETCH, "", "pageUrl", "prefetchWithOccasion", "occasion", "variables", "Ljava/util/SortedMap;", "prefetchWithOccasionAndConfig", "configCollection", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "", "prefetchWithVariablesAndConfig", "updateConfig", "newConfigProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BasePrefetchProcessor implements IPrefetchProcessor {
    private final String business;
    private final IConfigManager configManager;
    private boolean enabled;
    private final IPrefetchHandler handler;

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePrefetchProcessor(String str, IPrefetchHandler iPrefetchHandler, IConfigManager iConfigManager) {
        Intrinsics.checkParameterIsNotNull(str, "business");
        Intrinsics.checkParameterIsNotNull(iPrefetchHandler, "handler");
        Intrinsics.checkParameterIsNotNull(iConfigManager, "configManager");
        this.business = str;
        this.handler = iPrefetchHandler;
        this.configManager = iConfigManager;
        this.enabled = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getBusiness() {
        return this.business;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IPrefetchHandler getHandler() {
        return this.handler;
    }

    protected IConfigManager getConfigManager() {
        return this.configManager;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetch(String pageUrl) {
        Intrinsics.checkParameterIsNotNull(pageUrl, "pageUrl");
        if (this.enabled) {
            getHandler().prefetch(pageUrl);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithScheme(String scheme, SortedMap<String, String> variables) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        if (this.enabled) {
            getHandler().prefetchWithScheme(scheme, variables);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithVariables(String scheme, SortedMap<String, ? extends Object> variables) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        if (this.enabled) {
            getHandler().prefetchWithVariables(scheme, variables);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        if (this.enabled) {
            getHandler().prefetchWithSchemeAndConfig(scheme, variables, configCollection);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithVariablesAndConfig(String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        if (this.enabled) {
            getHandler().prefetchWithVariablesAndConfig(scheme, variables, configCollection);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithOccasion(String occasion, SortedMap<String, String> variables) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        if (this.enabled) {
            getHandler().prefetchWithOccasion(occasion, variables);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
        if (this.enabled) {
            getHandler().prefetchWithOccasionAndConfig(occasion, variables, configCollection);
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public PrefetchProcess get(PrefetchRequest request, ProcessListener listener) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (this.enabled) {
            return getHandler().get(request, listener);
        }
        return getHandler().getSkipCache(request, listener);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public PrefetchProcess getIgnoreCache(PrefetchRequest request, ProcessListener listener) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        return getHandler().getSkipCache(request, listener);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public IPrefetchMethodStub createMethodStub(IPrefetchResultListener resultListener) {
        Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
        return new PrefetchMethodStub(this, resultListener);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public void updateConfig(IConfigProvider newConfigProvider) {
        getConfigManager().updateConfig(newConfigProvider);
    }

    @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
    public List<PrefetchProcess> getCacheByScheme(String scheme) {
        Intrinsics.checkParameterIsNotNull(scheme, "scheme");
        if (this.enabled) {
            return getHandler().getCacheByScheme(scheme);
        }
        return null;
    }
}
