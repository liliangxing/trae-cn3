package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.tools.prefetch.BasePrefetchProcessor;
import com.bytedance.memory.api.MemoryApi;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasePrefetchProcessor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u000f\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010M\u001a\u00028\u0000¢\u0006\u0002\u0010NJ%\u0010O\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020SH$¢\u0006\u0002\u0010TJ\"\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00052\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010X\u001a\u00020\bJ\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u0016J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0010J\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020)J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020/J\u0014\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00104\u001a\u000205J\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010:\u001a\u00020;J\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u001e\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0010\u0010Z\u001a\f\u0012\u0004\u0012\u00020\"0\u000fj\u0002`#J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020HR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR.\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR,\u0010 \u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\"0\u000fj\u0002`#\u0018\u00010!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\"\u0010@\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010AX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006["}, d2 = {"Lcom/bytedance/ies/tools/prefetch/BaseEnvConfigurator;", "T", "Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "", "business", "", "(Ljava/lang/String;)V", "cacheCapacity", "", "getCacheCapacity", "()I", "setCacheCapacity", "(I)V", "conditionMap", "", "Lkotlin/Function0;", "", "getConditionMap", "()Ljava/util/Map;", "setConditionMap", "(Ljava/util/Map;)V", "configProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "getConfigProvider", "()Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "setConfigProvider", "(Lcom/bytedance/ies/tools/prefetch/IConfigProvider;)V", MemoryApi.DEBUG, "getDebug", "()Z", "setDebug", "(Z)V", "initListenerRef", "Ljava/lang/ref/WeakReference;", "", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "getInitListenerRef", "()Ljava/lang/ref/WeakReference;", "setInitListenerRef", "(Ljava/lang/ref/WeakReference;)V", "localStorage", "Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "getLocalStorage", "()Lcom/bytedance/ies/tools/prefetch/ILocalStorage;", "setLocalStorage", "(Lcom/bytedance/ies/tools/prefetch/ILocalStorage;)V", "logger", "Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;", "getLogger", "()Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;", "setLogger", "(Lcom/bytedance/ies/tools/prefetch/IPrefetchLogger;)V", "monitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "getMonitor", "()Lcom/bytedance/ies/tools/prefetch/IMonitor;", "setMonitor", "(Lcom/bytedance/ies/tools/prefetch/IMonitor;)V", "networkExecutor", "Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;", "getNetworkExecutor", "()Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;", "setNetworkExecutor", "(Lcom/bytedance/ies/tools/prefetch/INetworkExecutor;)V", "urlAdapterList", "", "Lcom/bytedance/ies/tools/prefetch/IUriAdapter;", "getUrlAdapterList", "()Ljava/util/List;", "setUrlAdapterList", "(Ljava/util/List;)V", "workerExecutor", "Ljava/util/concurrent/Executor;", "getWorkerExecutor", "()Ljava/util/concurrent/Executor;", "setWorkerExecutor", "(Ljava/util/concurrent/Executor;)V", "apply", "()Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "create", "handler", "Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;", "configManager", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "(Ljava/lang/String;Lcom/bytedance/ies/tools/prefetch/IPrefetchHandler;Lcom/bytedance/ies/tools/prefetch/IConfigManager;)Lcom/bytedance/ies/tools/prefetch/BasePrefetchProcessor;", "registerCondition", "condition", "predicate", "capacity", "setWeakInitListener", "listener", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BaseEnvConfigurator<T extends BasePrefetchProcessor> {
    private final String business;
    private int cacheCapacity;
    private Map<String, Function0<Boolean>> conditionMap;
    private IConfigProvider configProvider;
    private boolean debug;
    private WeakReference<Function0<Unit>> initListenerRef;
    private ILocalStorage localStorage;
    private IPrefetchLogger logger;
    private IMonitor monitor;
    private INetworkExecutor networkExecutor;
    private List<? extends IUriAdapter> urlAdapterList;
    private Executor workerExecutor;

    protected abstract T create(String business, IPrefetchHandler handler, IConfigManager configManager);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseEnvConfigurator(String str) {
        Intrinsics.checkParameterIsNotNull(str, "business");
        this.business = str;
        this.cacheCapacity = 32;
    }

    protected final ILocalStorage getLocalStorage() {
        return this.localStorage;
    }

    /* renamed from: setLocalStorage, reason: collision with other method in class */
    protected final void m607setLocalStorage(ILocalStorage iLocalStorage) {
        this.localStorage = iLocalStorage;
    }

    protected final Executor getWorkerExecutor() {
        return this.workerExecutor;
    }

    /* renamed from: setWorkerExecutor, reason: collision with other method in class */
    protected final void m612setWorkerExecutor(Executor executor) {
        this.workerExecutor = executor;
    }

    protected final INetworkExecutor getNetworkExecutor() {
        return this.networkExecutor;
    }

    /* renamed from: setNetworkExecutor, reason: collision with other method in class */
    protected final void m610setNetworkExecutor(INetworkExecutor iNetworkExecutor) {
        this.networkExecutor = iNetworkExecutor;
    }

    protected final IConfigProvider getConfigProvider() {
        return this.configProvider;
    }

    /* renamed from: setConfigProvider, reason: collision with other method in class */
    protected final void m605setConfigProvider(IConfigProvider iConfigProvider) {
        this.configProvider = iConfigProvider;
    }

    protected final List<IUriAdapter> getUrlAdapterList() {
        return this.urlAdapterList;
    }

    /* renamed from: setUrlAdapterList, reason: collision with other method in class */
    protected final void m611setUrlAdapterList(List<? extends IUriAdapter> list) {
        this.urlAdapterList = list;
    }

    protected final IMonitor getMonitor() {
        return this.monitor;
    }

    /* renamed from: setMonitor, reason: collision with other method in class */
    protected final void m609setMonitor(IMonitor iMonitor) {
        this.monitor = iMonitor;
    }

    protected final IPrefetchLogger getLogger() {
        return this.logger;
    }

    /* renamed from: setLogger, reason: collision with other method in class */
    protected final void m608setLogger(IPrefetchLogger iPrefetchLogger) {
        this.logger = iPrefetchLogger;
    }

    protected final boolean getDebug() {
        return this.debug;
    }

    /* renamed from: setDebug, reason: collision with other method in class */
    protected final void m606setDebug(boolean z) {
        this.debug = z;
    }

    protected final int getCacheCapacity() {
        return this.cacheCapacity;
    }

    /* renamed from: setCacheCapacity, reason: collision with other method in class */
    protected final void m604setCacheCapacity(int i) {
        this.cacheCapacity = i;
    }

    protected final WeakReference<Function0<Unit>> getInitListenerRef() {
        return this.initListenerRef;
    }

    protected final void setInitListenerRef(WeakReference<Function0<Unit>> weakReference) {
        this.initListenerRef = weakReference;
    }

    protected final Map<String, Function0<Boolean>> getConditionMap() {
        return this.conditionMap;
    }

    protected final void setConditionMap(Map<String, Function0<Boolean>> map) {
        this.conditionMap = map;
    }

    public final BaseEnvConfigurator<T> setLocalStorage(ILocalStorage localStorage) {
        Intrinsics.checkParameterIsNotNull(localStorage, "localStorage");
        this.localStorage = localStorage;
        return this;
    }

    public final BaseEnvConfigurator<T> setWorkerExecutor(Executor workerExecutor) {
        Intrinsics.checkParameterIsNotNull(workerExecutor, "workerExecutor");
        this.workerExecutor = workerExecutor;
        return this;
    }

    public final BaseEnvConfigurator<T> setNetworkExecutor(INetworkExecutor networkExecutor) {
        Intrinsics.checkParameterIsNotNull(networkExecutor, "networkExecutor");
        this.networkExecutor = networkExecutor;
        return this;
    }

    public final BaseEnvConfigurator<T> setConfigProvider(IConfigProvider configProvider) {
        Intrinsics.checkParameterIsNotNull(configProvider, "configProvider");
        this.configProvider = configProvider;
        return this;
    }

    public final BaseEnvConfigurator<T> setMonitor(IMonitor monitor) {
        Intrinsics.checkParameterIsNotNull(monitor, "monitor");
        this.monitor = monitor;
        return this;
    }

    public final BaseEnvConfigurator<T> setUrlAdapterList(List<? extends IUriAdapter> urlAdapterList) {
        Intrinsics.checkParameterIsNotNull(urlAdapterList, "urlAdapterList");
        this.urlAdapterList = urlAdapterList;
        return this;
    }

    public final BaseEnvConfigurator<T> setCacheCapacity(int capacity) {
        this.cacheCapacity = capacity;
        return this;
    }

    public final BaseEnvConfigurator<T> setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public final BaseEnvConfigurator<T> setLogger(IPrefetchLogger logger) {
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        this.logger = logger;
        return this;
    }

    public final BaseEnvConfigurator<T> setWeakInitListener(Function0<Unit> listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.initListenerRef = new WeakReference<>(listener);
        return this;
    }

    public final BaseEnvConfigurator<T> registerCondition(String condition, Function0<Boolean> predicate) {
        Intrinsics.checkParameterIsNotNull(condition, "condition");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        Map<String, Function0<Boolean>> map = this.conditionMap;
        if (map == null) {
            this.conditionMap = new LinkedHashMap();
        } else {
            if (map == null) {
                Intrinsics.throwNpe();
            }
            map.put(condition, predicate);
        }
        return this;
    }

    public final T apply() {
        IConfigProvider iConfigProvider = this.configProvider;
        if (iConfigProvider == null) {
            throw new IllegalStateException("configProvider must be provided.".toString());
        }
        INetworkExecutor iNetworkExecutor = this.networkExecutor;
        if (iNetworkExecutor == null) {
            throw new IllegalStateException("networkExecutor must be provided.".toString());
        }
        Executor executor = this.workerExecutor;
        if (executor == null) {
            throw new IllegalStateException("workerExecutor must be provided.".toString());
        }
        IPrefetchLogger iPrefetchLogger = this.logger;
        if (iPrefetchLogger != null) {
            LogUtil.INSTANCE.setLogger(iPrefetchLogger);
        }
        ConfigManager configManager = new ConfigManager(executor, iConfigProvider, this.monitor);
        ProcessManager processManager = new ProcessManager(this.localStorage, iNetworkExecutor, executor, this.cacheCapacity);
        ConfigManager configManager2 = configManager;
        T create = create(this.business, new PrefetchHandler(processManager, configManager2, this.monitor, this.conditionMap, this.urlAdapterList, this.initListenerRef), configManager2);
        if (this.debug) {
            String str = this.business + "@" + create.hashCode();
            configManager.setDebug$prefetch_release(str);
            PrefetchDebugTool.INSTANCE.addCache$prefetch_release(str, processManager.getLruCache());
        }
        return create;
    }
}
