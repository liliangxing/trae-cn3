package com.bytedance.pia.core.api.services;

import com.bytedance.pia.core.api.PiaCoreApi;

/* loaded from: classes4.dex */
public interface IPiaService {
    default void clearCache() {
    }

    void runOnPiaThread(Runnable runnable);

    static IPiaService inst() {
        IPiaService iPiaService = (IPiaService) PiaCoreApi.get(IPiaService.class);
        return iPiaService != null ? iPiaService : NullPiaService.INSTANCE;
    }

    /* loaded from: classes4.dex */
    public static class NullPiaService implements IPiaService {
        private static final NullPiaService INSTANCE = new NullPiaService();

        @Override // com.bytedance.pia.core.api.services.IPiaService
        public void runOnPiaThread(Runnable runnable) {
        }
    }
}
