package com.bytedance.pia.core.api.services;

import com.bytedance.pia.core.api.PiaCoreApi;
import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;

@Deprecated
/* loaded from: classes4.dex */
public interface IPiaWorkerService {

    /* loaded from: classes4.dex */
    public static class DisableBySettingException extends RuntimeException {
    }

    /* loaded from: classes4.dex */
    public static class UrlUnsupportedException extends RuntimeException {
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface WarmupParams {
        default Object getCustomContext() {
            return null;
        }

        default long getExpirationTime() {
            return 30000L;
        }

        default String getNamespace() {
            return "";
        }

        String getUrl();
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public interface WarmupResult {
        String getScriptUrl();
    }

    @Deprecated
    boolean isAvailable(String str);

    @Deprecated
    IReleasable warmup(WarmupParams warmupParams, IConsumer<WarmupResult> iConsumer, IConsumer<Throwable> iConsumer2);

    static IPiaWorkerService inst() {
        return (IPiaWorkerService) PiaCoreApi.get(IPiaWorkerService.class);
    }

    /* loaded from: classes4.dex */
    public static class NoJSRuntimeException extends RuntimeException {
        public NoJSRuntimeException(Throwable th) {
            super(th);
        }
    }
}
