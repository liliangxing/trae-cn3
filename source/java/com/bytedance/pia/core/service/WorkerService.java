package com.bytedance.pia.core.service;

import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.pia.core.api.services.IPiaWorkerService;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;
import com.bytedance.pia.core.runtime.PiaRuntime;
import com.bytedance.pia.core.runtime.PiaRuntimeFactory;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WorkerService implements IPiaWorkerService {
    public static WorkerService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.bytedance.pia.core.api.services.IPiaWorkerService
    public boolean isAvailable(String str) {
        return str != null && (str.contains(PiaRuntime.SCHEMA_V1) || str.contains("_pia_"));
    }

    @Override // com.bytedance.pia.core.api.services.IPiaWorkerService
    public IReleasable warmup(final IPiaWorkerService.WarmupParams warmupParams, IConsumer<IPiaWorkerService.WarmupResult> iConsumer, IConsumer<Throwable> iConsumer2) {
        IReleasable warmup = PiaRuntimeFactory.getInstance().warmup(warmupParams.getUrl(), warmupParams.getNamespace(), warmupParams.getCustomContext(), IPiaLifeCycleService.WarmupStage.Activate);
        if (warmup != null && iConsumer != null) {
            Objects.requireNonNull(warmupParams);
            iConsumer.accept(new IPiaWorkerService.WarmupResult() { // from class: com.bytedance.pia.core.service.WorkerService$$ExternalSyntheticLambda0
                @Override // com.bytedance.pia.core.api.services.IPiaWorkerService.WarmupResult
                public final String getScriptUrl() {
                    return IPiaWorkerService.WarmupParams.this.getUrl();
                }
            });
        }
        if (warmup == null && iConsumer2 != null) {
            iConsumer2.accept(new IPiaWorkerService.UrlUnsupportedException());
        }
        return warmup;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class InstanceHolder {
        static final WorkerService INSTANCE = new WorkerService();

        private InstanceHolder() {
        }
    }
}
