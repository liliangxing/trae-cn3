package com.bytedance.pia.core.service;

import com.bytedance.pia.core.api.services.IPiaService;
import com.bytedance.pia.core.cache.PIACacheManager;
import com.bytedance.pia.core.storage.PageStorage;
import com.bytedance.pia.core.utils.Logger;
import com.bytedance.pia.core.utils.ThreadUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PiaService implements IPiaService {
    @Override // com.bytedance.pia.core.api.services.IPiaService
    public void runOnPiaThread(final Runnable runnable) {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.service.PiaService$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PiaService.lambda$runOnPiaThread$0(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$runOnPiaThread$0(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            Logger.m179e("Run task on PIA Thread error:", th);
        }
    }

    @Override // com.bytedance.pia.core.api.services.IPiaService
    public void clearCache() {
        ThreadUtil.runOnPia(new Runnable() { // from class: com.bytedance.pia.core.service.PiaService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PiaService.lambda$clearCache$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$clearCache$1() {
        Logger.m181i("Start clearing all cache.");
        PIACacheManager.clearAll();
        PageStorage.clearAll();
        Logger.m181i("Finished clearing all cache.");
    }

    public static PiaService getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        private static final PiaService INSTANCE = new PiaService();

        private InstanceHolder() {
        }
    }
}
