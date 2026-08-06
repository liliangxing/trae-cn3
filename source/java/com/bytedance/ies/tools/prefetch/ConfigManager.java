package com.bytedance.ies.tools.prefetch;

import android.text.TextUtils;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ConfigManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ2\u0010\u0011\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\nH\u0017J2\u0010\u0017\u001a$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015\u0018\u00010\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J\u001a\u0010\u001a\u001a\u00020\u001b2\u0010\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u001b0\u001dj\u0002`\u001eH\u0016J\u0015\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0016J\u0016\u0010!\u001a\u00020\u001b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0$H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/ConfigManager;", "Lcom/bytedance/ies/tools/prefetch/IConfigManager;", "workerExecutor", "Ljava/util/concurrent/Executor;", "configProvider", "Lcom/bytedance/ies/tools/prefetch/IConfigProvider;", "monitor", "Lcom/bytedance/ies/tools/prefetch/IMonitor;", "(Ljava/util/concurrent/Executor;Lcom/bytedance/ies/tools/prefetch/IConfigProvider;Lcom/bytedance/ies/tools/prefetch/IMonitor;)V", "businessTag", "", "configMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/tools/prefetch/PrefetchConfig;", MemoryApi.DEBUG, "", "initialized", "getConfigListByOccasion", "Lkotlin/Pair;", "", "Lcom/bytedance/ies/tools/prefetch/RequestConfig;", "Ljava/util/SortedMap;", "occasion", "getConfigListByUrl", "uriWrapper", "Lcom/bytedance/ies/tools/prefetch/UriWrapper;", EventConstants.PARAM_SOURCE_INIT, "", "callback", "Lkotlin/Function0;", "Lcom/bytedance/ies/tools/prefetch/InitCallback;", "setDebug", "setDebug$prefetch_release", "updateConfig", "newConfigProvider", "configList", "", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ConfigManager implements IConfigManager {
    private String businessTag;
    private final ConcurrentHashMap<String, PrefetchConfig> configMap;
    private final IConfigProvider configProvider;
    private boolean debug;
    private boolean initialized;
    private final IMonitor monitor;
    private final Executor workerExecutor;

    public ConfigManager(Executor executor, IConfigProvider iConfigProvider, IMonitor iMonitor) {
        Intrinsics.checkParameterIsNotNull(executor, "workerExecutor");
        Intrinsics.checkParameterIsNotNull(iConfigProvider, "configProvider");
        this.workerExecutor = executor;
        this.configProvider = iConfigProvider;
        this.monitor = iMonitor;
        this.configMap = new ConcurrentHashMap<>();
        this.businessTag = "";
    }

    @Override // com.bytedance.ies.tools.prefetch.IConfigManager
    public void init(final Function0<Unit> callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        if (this.initialized) {
            callback.invoke();
        } else {
            this.workerExecutor.execute(new Runnable() { // from class: com.bytedance.ies.tools.prefetch.ConfigManager$init$1
                @Override // java.lang.Runnable
                public final void run() {
                    ConcurrentHashMap concurrentHashMap;
                    IConfigProvider iConfigProvider;
                    concurrentHashMap = ConfigManager.this.configMap;
                    concurrentHashMap.clear();
                    ConfigManager configManager = ConfigManager.this;
                    iConfigProvider = configManager.configProvider;
                    configManager.updateConfig((List<String>) iConfigProvider.getConfigString());
                    ConfigManager.this.initialized = true;
                    LogUtil.INSTANCE.m57i("ConfigManager initialized successfully.");
                    callback.invoke();
                }
            });
        }
    }

    @Override // com.bytedance.ies.tools.prefetch.IConfigManager
    public void updateConfig(final IConfigProvider newConfigProvider) {
        this.workerExecutor.execute(new Runnable() { // from class: com.bytedance.ies.tools.prefetch.ConfigManager$updateConfig$1
            @Override // java.lang.Runnable
            public final void run() {
                IConfigProvider iConfigProvider;
                List<String> configString;
                ConfigManager configManager = ConfigManager.this;
                IConfigProvider iConfigProvider2 = newConfigProvider;
                if (iConfigProvider2 == null || (configString = iConfigProvider2.getConfigString()) == null) {
                    iConfigProvider = ConfigManager.this.configProvider;
                    configString = iConfigProvider.getConfigString();
                }
                configManager.updateConfig((List<String>) configString);
            }
        });
    }

    @Override // com.bytedance.ies.tools.prefetch.IConfigManager
    public Pair<Collection<RequestConfig>, SortedMap<String, String>> getConfigListByUrl(UriWrapper uriWrapper) {
        Intrinsics.checkParameterIsNotNull(uriWrapper, "uriWrapper");
        Iterator<Map.Entry<String, PrefetchConfig>> it = this.configMap.entrySet().iterator();
        while (it.hasNext()) {
            Pair<List<RequestConfig>, SortedMap<String, String>> requestConfigByUri = it.next().getValue().getRequestConfigByUri(uriWrapper);
            if (requestConfigByUri != null && (!((Collection) requestConfigByUri.getFirst()).isEmpty())) {
                return requestConfigByUri;
            }
        }
        return null;
    }

    @Override // com.bytedance.ies.tools.prefetch.IConfigManager
    public Pair<Collection<RequestConfig>, SortedMap<String, String>> getConfigListByOccasion(String occasion) {
        Intrinsics.checkParameterIsNotNull(occasion, "occasion");
        Iterator<Map.Entry<String, PrefetchConfig>> it = this.configMap.entrySet().iterator();
        while (it.hasNext()) {
            Pair<List<RequestConfig>, SortedMap<String, String>> requestConfigByOccasion = it.next().getValue().getRequestConfigByOccasion(occasion);
            if (requestConfigByOccasion != null && (!((Collection) requestConfigByOccasion.getFirst()).isEmpty())) {
                return requestConfigByOccasion;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConfig(final List<String> configList) {
        this.workerExecutor.execute(new Runnable() { // from class: com.bytedance.ies.tools.prefetch.ConfigManager$updateConfig$2
            @Override // java.lang.Runnable
            public final void run() {
                Object obj;
                IMonitor iMonitor;
                ConcurrentHashMap concurrentHashMap;
                IMonitor iMonitor2;
                boolean z;
                String str;
                IMonitor iMonitor3;
                for (String str2 : configList) {
                    try {
                        Result.Companion companion = Result.Companion;
                        PrefetchConfig prefetchConfig = new PrefetchConfig(new JSONObject(str2));
                        concurrentHashMap = ConfigManager.this.configMap;
                        concurrentHashMap.put(prefetchConfig.getProject(), prefetchConfig);
                        if (!TextUtils.isEmpty(prefetchConfig.getProject())) {
                            iMonitor3 = ConfigManager.this.monitor;
                            if (iMonitor3 != null) {
                                iMonitor3.onConfigLoaded(true, null);
                            }
                        } else {
                            iMonitor2 = ConfigManager.this.monitor;
                            if (iMonitor2 != null) {
                                iMonitor2.onConfigLoaded(false, "'project' missing.");
                            }
                        }
                        z = ConfigManager.this.debug;
                        if (z) {
                            PrefetchDebugTool prefetchDebugTool = PrefetchDebugTool.INSTANCE;
                            str = ConfigManager.this.businessTag;
                            prefetchDebugTool.addConfig$prefetch_release(str, prefetchConfig.getProject(), str2);
                        }
                        obj = Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.createFailure(th));
                    }
                    Throwable th2 = Result.exceptionOrNull-impl(obj);
                    if (th2 != null) {
                        LogUtil.INSTANCE.m56e("Failed to parse config json.", th2);
                        iMonitor = ConfigManager.this.monitor;
                        if (iMonitor != null) {
                            iMonitor.onConfigLoaded(false, "Failed to parse config json, throwable: " + UtilKt.stacktraceString(th2));
                        }
                    }
                }
            }
        });
    }

    public final void setDebug$prefetch_release(String businessTag) {
        Intrinsics.checkParameterIsNotNull(businessTag, "businessTag");
        this.businessTag = businessTag;
        this.debug = true;
    }
}
