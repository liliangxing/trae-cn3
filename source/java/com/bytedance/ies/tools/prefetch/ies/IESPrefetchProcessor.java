package com.bytedance.ies.tools.prefetch.ies;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.tools.prefetch.BaseEnvConfigurator;
import com.bytedance.ies.tools.prefetch.BasePrefetchProcessor;
import com.bytedance.ies.tools.prefetch.IConfigManager;
import com.bytedance.ies.tools.prefetch.IConfigProvider;
import com.bytedance.ies.tools.prefetch.IPrefetchHandler;
import com.bytedance.ies.tools.prefetch.IPrefetchMethodStub;
import com.bytedance.ies.tools.prefetch.IPrefetchResultListener;
import com.bytedance.ies.tools.prefetch.PrefetchProcess;
import com.bytedance.ies.tools.prefetch.PrefetchRequest;
import com.bytedance.ies.tools.prefetch.ProcessListener;
import com.bytedance.ies.tools.prefetch.RequestConfig;
import com.bytedance.ies.web.jsbridge2.BaseStatefulMethod;
import com.bytedance.ies.web.jsbridge2.JsBridge2;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESPrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0002\u000f\u0010B'\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor;", "Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "Lcom/bytedance/ies/tools/prefetch/ies/IIESPrefetchProcessor;", "business", "", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "jsBridgeName", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;Lcom/bytedance/ies/tools/prefetch/IConfigManager;Ljava/lang/String;)V", "bindJsBridge", "", "bridge", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "Companion", "EnvConfigurator", "prefetch-ies_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class IESPrefetchProcessor extends BasePrefetchProcessor implements IIESPrefetchProcessor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_BUSINESS = "default_business";
    private static IESPrefetchProcessor defaultInstance;
    private final String jsBridgeName;

    public /* synthetic */ IESPrefetchProcessor(String str, IPrefetchHandler iPrefetchHandler, IConfigManager iConfigManager, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, iPrefetchHandler, iConfigManager, str2);
    }

    private IESPrefetchProcessor(String str, IPrefetchHandler iPrefetchHandler, IConfigManager iConfigManager, String str2) {
        super(str, iPrefetchHandler, iConfigManager);
        this.jsBridgeName = str2;
    }

    @Override // com.bytedance.ies.tools.prefetch.ies.IIESPrefetchProcessor
    public void bindJsBridge(JsBridge2 bridge) {
        Intrinsics.checkParameterIsNotNull(bridge, "bridge");
        bridge.registerStatefulMethod(this.jsBridgeName, new BaseStatefulMethod.Provider() { // from class: com.bytedance.ies.tools.prefetch.ies.IESPrefetchProcessor$bindJsBridge$1
            @Override // com.bytedance.ies.web.jsbridge2.BaseStatefulMethod.Provider
            public final PrefetchMethod provideMethod() {
                return new PrefetchMethod(IESPrefetchProcessor.this);
            }
        });
    }

    /* compiled from: IESPrefetchProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J&\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"H\u0016J4\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J&\u0010'\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"H\u0016J4\u0010(\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J(\u0010)\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010\"H\u0016J6\u0010+\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00042\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\b\u0001\u0012\u00020*\u0018\u00010\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\u0012\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor$Companion;", "Lcom/bytedance/ies/tools/prefetch/ies/IIESPrefetchProcessor;", "()V", "DEFAULT_BUSINESS", "", "defaultInstance", "Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor;", "bindJsBridge", "", "bridge", "Lcom/bytedance/ies/web/jsbridge2/JsBridge2;", "createMethodStub", "Lcom/bytedance/ies/tools/prefetch/IPrefetchMethodStub;", "resultListener", "Lcom/bytedance/ies/tools/prefetch/IPrefetchResultListener;", PrefetchRequestConfig.METHOD_GET, "Lcom/bytedance/ies/tools/prefetch/PrefetchProcess;", "request", "Lcom/bytedance/ies/tools/prefetch/PrefetchRequest;", "listener", "Lcom/bytedance/ies/tools/prefetch/ProcessListener;", "getCacheByScheme", "", "scheme", "getIgnoreCache", "initDefault", "Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor$EnvConfigurator;", "initWith", "business", ErrorType.PREFETCH, "pageUrl", "prefetchWithOccasion", "occasion", "variables", "Ljava/util/SortedMap;", "prefetchWithOccasionAndConfig", "configCollection", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "prefetchWithScheme", "prefetchWithSchemeAndConfig", "prefetchWithVariables", "", "prefetchWithVariablesAndConfig", "updateConfig", "newConfigProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "prefetch-ies_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion implements IIESPrefetchProcessor {
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
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetch(pageUrl);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithScheme(String scheme, SortedMap<String, String> variables) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithScheme(scheme, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithVariables(String scheme, SortedMap<String, ? extends Object> variables) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithVariables(scheme, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithSchemeAndConfig(String scheme, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithSchemeAndConfig(scheme, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithVariablesAndConfig(String scheme, SortedMap<String, ? extends Object> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithVariablesAndConfig(scheme, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithOccasion(String occasion, SortedMap<String, String> variables) {
            Intrinsics.checkParameterIsNotNull(occasion, "occasion");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithOccasion(occasion, variables);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void prefetchWithOccasionAndConfig(String occasion, SortedMap<String, String> variables, Collection<RequestConfig> configCollection) {
            Intrinsics.checkParameterIsNotNull(occasion, "occasion");
            Intrinsics.checkParameterIsNotNull(configCollection, "configCollection");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.prefetchWithOccasionAndConfig(occasion, variables, configCollection);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public PrefetchProcess get(PrefetchRequest request, ProcessListener listener) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            PrefetchProcess prefetchProcess = iESPrefetchProcessor != null ? iESPrefetchProcessor.get(request, listener) : null;
            if (prefetchProcess == null) {
                Intrinsics.throwNpe();
            }
            return prefetchProcess;
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public PrefetchProcess getIgnoreCache(PrefetchRequest request, ProcessListener listener) {
            Intrinsics.checkParameterIsNotNull(request, "request");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            PrefetchProcess ignoreCache = iESPrefetchProcessor != null ? iESPrefetchProcessor.getIgnoreCache(request, listener) : null;
            if (ignoreCache == null) {
                Intrinsics.throwNpe();
            }
            return ignoreCache;
        }

        @Override // com.bytedance.ies.tools.prefetch.ies.IIESPrefetchProcessor
        public void bindJsBridge(JsBridge2 bridge) {
            Intrinsics.checkParameterIsNotNull(bridge, "bridge");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.bindJsBridge(bridge);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public IPrefetchMethodStub createMethodStub(IPrefetchResultListener resultListener) {
            Intrinsics.checkParameterIsNotNull(resultListener, "resultListener");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor == null) {
                Intrinsics.throwNpe();
            }
            return iESPrefetchProcessor.createMethodStub(resultListener);
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public void updateConfig(IConfigProvider newConfigProvider) {
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                iESPrefetchProcessor.updateConfig(newConfigProvider);
            }
        }

        @Override // com.bytedance.ies.tools.prefetch.IPrefetchProcessor
        public List<PrefetchProcess> getCacheByScheme(String scheme) {
            Intrinsics.checkParameterIsNotNull(scheme, "scheme");
            IESPrefetchProcessor iESPrefetchProcessor = IESPrefetchProcessor.defaultInstance;
            if (iESPrefetchProcessor != null) {
                return iESPrefetchProcessor.getCacheByScheme(scheme);
            }
            return null;
        }
    }

    /* compiled from: IESPrefetchProcessor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor$EnvConfigurator;", "Lcom/bytedance/ies/tools/prefetch/BaseEnvConfigurator;", "Lcom/bytedance/ies/tools/prefetch/ies/IESPrefetchProcessor;", "business", "", "(Ljava/lang/String;)V", "jsBridgeName", "create", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "setJsBridgeName", "name", "prefetch-ies_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class EnvConfigurator extends BaseEnvConfigurator<IESPrefetchProcessor> {
        private String jsBridgeName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EnvConfigurator(String str) {
            super(str);
            Intrinsics.checkParameterIsNotNull(str, "business");
            this.jsBridgeName = "__prefetch";
        }

        public final EnvConfigurator setJsBridgeName(String name) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            this.jsBridgeName = name;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.ies.tools.prefetch.BaseEnvConfigurator
        public IESPrefetchProcessor create(String business, IPrefetchHandler handler, IConfigManager configManager) {
            Intrinsics.checkParameterIsNotNull(business, "business");
            Intrinsics.checkParameterIsNotNull(handler, "handler");
            Intrinsics.checkParameterIsNotNull(configManager, "configManager");
            IESPrefetchProcessor iESPrefetchProcessor = new IESPrefetchProcessor(business, handler, configManager, this.jsBridgeName, null);
            if (Intrinsics.areEqual(iESPrefetchProcessor.getBusiness(), "default_business")) {
                IESPrefetchProcessor.defaultInstance = iESPrefetchProcessor;
            }
            return iESPrefetchProcessor;
        }
    }
}
