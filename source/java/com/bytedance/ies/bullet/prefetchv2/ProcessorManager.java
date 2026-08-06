package com.bytedance.ies.bullet.prefetchv2;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/ProcessorManager;", "", "()V", "defaultProcessor", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchProcessor;", "processorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getDefault", "getNetworkExecutor", "Lcom/bytedance/ies/bullet/prefetchv2/INetworkExecutor;", "business", "getProcessor", "biz", "registerDefault", "", "processor", "registerProcessor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ProcessorManager {
    private static PrefetchProcessor defaultProcessor;
    public static final ProcessorManager INSTANCE = new ProcessorManager();
    private static final ConcurrentHashMap<String, PrefetchProcessor> processorMap = new ConcurrentHashMap<>();

    private ProcessorManager() {
    }

    public final void registerProcessor(String biz, PrefetchProcessor processor) {
        Intrinsics.checkNotNullParameter(biz, "biz");
        Intrinsics.checkNotNullParameter(processor, "processor");
        processorMap.put(biz, processor);
    }

    public final PrefetchProcessor getProcessor(String biz) {
        String str = biz;
        if (str == null || str.length() == 0) {
            return null;
        }
        return processorMap.get(biz);
    }

    public final void registerDefault(PrefetchProcessor processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        defaultProcessor = processor;
    }

    public final PrefetchProcessor getDefault() {
        return defaultProcessor;
    }

    public final INetworkExecutor getNetworkExecutor(String business) {
        INetworkExecutor provideNetworkExecutor;
        if (business != null) {
            ProcessorManager processorManager = INSTANCE;
            PrefetchProcessor processor = processorManager.getProcessor(business);
            if (processor == null || (provideNetworkExecutor = processor.provideNetworkExecutor()) == null) {
                PrefetchProcessor prefetchProcessor = processorManager.getDefault();
                provideNetworkExecutor = prefetchProcessor != null ? prefetchProcessor.provideNetworkExecutor() : null;
            }
            if (provideNetworkExecutor != null) {
                return provideNetworkExecutor;
            }
        }
        PrefetchProcessor prefetchProcessor2 = getDefault();
        if (prefetchProcessor2 != null) {
            return prefetchProcessor2.provideNetworkExecutor();
        }
        return null;
    }
}
