package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\n¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor;", "Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "business", "", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;Lcom/bytedance/ies/tools/prefetch/IConfigManager;)V", "clearCache", "", "Companion", "EnvConfigurator", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchProcessor extends BasePrefetchProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_BUSINESS = "default_business";
    private static PrefetchProcessor defaultInstance;

    public /* synthetic */ PrefetchProcessor(String str, IPrefetchHandler iPrefetchHandler, IConfigManager iConfigManager, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iPrefetchHandler, iConfigManager);
    }

    private PrefetchProcessor(String str, IPrefetchHandler iPrefetchHandler, IConfigManager iConfigManager) {
        super(str, iPrefetchHandler, iConfigManager);
    }

    public final void clearCache() {
        IPrefetchHandler handler = getHandler();
        if (!(handler instanceof PrefetchHandler)) {
            handler = null;
        }
        PrefetchHandler prefetchHandler = (PrefetchHandler) handler;
        if (prefetchHandler != null) {
            prefetchHandler.clear();
        }
    }

    /* compiled from: PrefetchProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0016J&\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0016J4\u0010 \u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J&\u0010$\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001fH\u0016J4\u0010%\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00042\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J(\u0010&\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020'\u0018\u00010\u001fH\u0016J6\u0010(\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020'\u0018\u00010\u001f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor$Companion;", "Lcom/bytedance/ies/tools/prefetch/IPrefetchProcessor;", "()V", "DEFAULT_BUSINESS", "", "defaultInstance", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor;", "createMethodStub", "Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "resultListener", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "", "scheme", "getIgnoreCache", "initDefault", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor$EnvConfigurator;", "initWith", "business", ErrorType.PREFETCH, "", "pageUrl", "prefetchWithOccasion", "occasion", "variables", "Ljava/util/SortedMap;", "prefetchWithOccasionAndConfig", "configCollection", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "", "prefetchWithVariablesAndConfig", "updateConfig", "newConfigProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion implements IPrefetchProcessor {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnvConfigurator initWith(String business) {
            Intrinsics.checkParameterIsNotNull(business, "business");
            return new EnvConfigurator(business);
        }

        public final EnvConfigurator initDefault() {
            return new EnvConfigurator("default_business");
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetch(String pageUrl) {
            Intrinsics.checkParameterIsNotNull(pageUrl, "pageUrl");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetch(pageUrl);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithScheme(String scheme, SortedMap<String, String> variables) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithScheme(scheme, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithVariables(String scheme, SortedMap<String, ? extends Object> variables) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithVariables(scheme, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithSchemeAndConfig(scheme, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithVariablesAndConfig(String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithVariablesAndConfig(scheme, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithOccasion(String occasion, SortedMap<String, String> variables) {
            Intrinsics.checkParameterIsNotNull(occasion, "occasion");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithOccasion(occasion, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(occasion, "occasion");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.prefetchWithOccasionAndConfig(occasion, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public PrefetchProcess get(PrefetchRequest request, ProcessListener listener) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            PrefetchProcess prefetchProcess = prefetchProcessor != null ? prefetchProcessor.get(request, listener) : null;
            if (prefetchProcess == null) {
                Intrinsics.throwNpe();
            }
            return prefetchProcess;
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public PrefetchProcess getIgnoreCache(PrefetchRequest request, ProcessListener listener) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            PrefetchProcess prefetchProcess = prefetchProcessor != null ? prefetchProcessor.get(request, listener) : null;
            if (prefetchProcess == null) {
                Intrinsics.throwNpe();
            }
            return prefetchProcess;
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public IPrefetchMethodStub createMethodStub(IPrefetchResultListener resultListener) {
            Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor == null) {
                Intrinsics.throwNpe();
            }
            return prefetchProcessor.createMethodStub(resultListener);
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void updateConfig(IConfigProvider newConfigProvider) {
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                prefetchProcessor.updateConfig(newConfigProvider);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public List<PrefetchProcess> getCacheByScheme(String scheme) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            PrefetchProcessor prefetchProcessor = PrefetchProcessor.defaultInstance;
            if (prefetchProcessor != null) {
                return prefetchProcessor.getCacheByScheme(scheme);
            }
            return null;
        }
    }

    /* compiled from: PrefetchProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor$EnvConfigurator;", "Lcom/bytedance/ies/tools/prefetch/BaseEnvConfigurator;", "Lcom/bytedance/ies/tools/prefetch/PrefetchProcessor;", "business", "", "(Ljava/lang/String;)V", "create", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class EnvConfigurator extends BaseEnvConfigurator<PrefetchProcessor> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnvConfigurator(String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(str, "business");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.ies.tools.prefetch.BaseEnvConfigurator
        public PrefetchProcessor create(String business, IPrefetchHandler handler, IConfigManager configManager) {
            Intrinsics.checkParameterIsNotNull(business, "business");
            Intrinsics.checkParameterIsNotNull(handler, "handler");
            Intrinsics.checkParameterIsNotNull(configManager, "configManager");
            PrefetchProcessor prefetchProcessor = new PrefetchProcessor(business, handler, configManager, null);
            if (Intrinsics.areEqual(prefetchProcessor.getBusiness(), "default_business")) {
                PrefetchProcessor.defaultInstance = prefetchProcessor;
            }
            return prefetchProcessor;
        }
    }
}
