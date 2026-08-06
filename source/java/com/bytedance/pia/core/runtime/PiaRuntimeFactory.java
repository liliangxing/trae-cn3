package com.bytedance.pia.core.runtime;

import android.os.Handler;
import com.bytedance.ies.bullet.prefetchv2.PrefetchConfigKt;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.setting.Config;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.tracing.OnlineTracing;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.worker.WarmupWorker;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaRuntimeFactory {
    private static final ConcurrentHashMap<String, FutureTask<PiaRuntime>> warmupTasks = new ConcurrentHashMap<>();

    public static PiaRuntimeFactory getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public IReleasable warmup(String str, String str2, Object obj, IPiaLifeCycleService.WarmupStage warmupStage) {
        if (!Settings.get().getIsWarmupEnabled()) {
            return null;
        }
        if (!EnvService.getInstance().exist(str2)) {
            Logger.m178e("[Warmup] failed to warmup because there is no env for " + str2);
            return null;
        }
        final PiaRuntime.Builder isWarmup = new PiaRuntime.Builder().setUrl(str).setNamespace(str2).setCustomContext(obj).setIsWarmup(true);
        final String buildName = isWarmup.buildName();
        if (buildName == null || buildName.isEmpty()) {
            return null;
        }
        OnlineTracing.putNAVS(buildName);
        if (IPiaLifeCycleService.WarmupStage.Load == warmupStage) {
            WarmupWorker.warmup(isWarmup);
            return null;
        }
        final FutureTask<PiaRuntime> futureTask = new FutureTask<>(new Callable() { // from class: com.bytedance.pia.core.runtime.PiaRuntimeFactory$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PiaRuntimeFactory.lambda$warmup$0(PiaRuntime.Builder.this);
            }
        });
        if (warmupTasks.putIfAbsent(buildName, futureTask) != null) {
            return null;
        }
        Logger.m181i("[Runtime] start to warmup, url=" + str);
        final IReleasable iReleasable = new IReleasable() { // from class: com.bytedance.pia.core.runtime.PiaRuntimeFactory$$ExternalSyntheticLambda2
            @Override // com.bytedance.pia.core.api.utils.IReleasable
            public final void release() {
                ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.runtime.PiaRuntimeFactory$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        PiaRuntimeFactory.lambda$warmup$1(r1, r2);
                    }
                });
            }
        };
        ThreadUtil.runOnPia(futureTask);
        Handler piaHandler = ThreadUtil.INSTANCE.getPiaHandler();
        Objects.requireNonNull(iReleasable);
        piaHandler.postDelayed(new Runnable() { // from class: com.bytedance.pia.core.runtime.PiaRuntimeFactory$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                IReleasable.this.release();
            }
        }, PrefetchConfigKt.DEFAULT_EXPIRE_MS);
        return iReleasable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PiaRuntime lambda$warmup$0(PiaRuntime.Builder builder) throws Exception {
        PiaRuntime build = builder.build();
        if (build != null) {
            PluginRegistry.getRegistry().register(build);
            build.initialize();
        }
        Logger.m181i("[Runtime] warmup finish.");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$warmup$1(String str, FutureTask futureTask) {
        try {
            ConcurrentHashMap<String, FutureTask<PiaRuntime>> concurrentHashMap = warmupTasks;
            if (concurrentHashMap.get(str) == futureTask) {
                concurrentHashMap.remove(str);
                PiaRuntime piaRuntime = (PiaRuntime) futureTask.get();
                if (piaRuntime != null) {
                    piaRuntime.release();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public PiaRuntime create(String str, String str2, Object obj, boolean z) {
        return create(str, str2, obj, null, z);
    }

    public PiaRuntime create(String str, String str2, Object obj, Config config, boolean z) {
        PiaRuntime piaRuntime;
        PiaRuntime.Builder builder = new PiaRuntime.Builder();
        builder.setUrl(str).setNamespace(str2).setCustomContext(obj).setConfig(config);
        String buildName = builder.buildName();
        if (buildName == null || buildName.isEmpty()) {
            return null;
        }
        if (!z) {
            return builder.build();
        }
        FutureTask<PiaRuntime> remove = warmupTasks.remove(buildName);
        if (remove != null) {
            try {
                boolean z2 = false;
                if (Settings.openCancelUselessWarmup() && !remove.isDone()) {
                    z2 = remove.cancel(false);
                }
                if (!z2) {
                    if (Settings.get().getIsCreateRuntimeWaitEnable()) {
                        piaRuntime = remove.get();
                    } else {
                        piaRuntime = remove.get(Settings.get().getCreateRuntimeWaitInternal(), TimeUnit.MILLISECONDS);
                    }
                    if (piaRuntime != null) {
                        Logger.m181i("[Runtime] consume warmup success.");
                        return piaRuntime;
                    }
                }
            } catch (Throwable th) {
                Logger.m178e("[Runtime] consume warmup fail. " + th);
            }
        } else {
            Logger.m187w("[Runtime] lack warmup task.");
        }
        return builder.build();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final PiaRuntimeFactory INSTANCE = new PiaRuntimeFactory();

        private InstanceHolder() {
        }
    }
}
