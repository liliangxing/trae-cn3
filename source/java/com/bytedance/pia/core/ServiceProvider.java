package com.bytedance.pia.core;

import com.bytedance.pia.core.api.services.IPiaBridgeService;
import com.bytedance.pia.core.api.services.IPiaEnvService;
import com.bytedance.pia.core.api.services.IPiaLifeCycleService;
import com.bytedance.pia.core.api.services.IPiaRenderingService;
import com.bytedance.pia.core.api.services.IPiaService;
import com.bytedance.pia.core.api.services.IPiaSettingService;
import com.bytedance.pia.core.api.services.IPiaWorkerService;
import com.bytedance.pia.core.service.BridgeService;
import com.bytedance.pia.core.service.EnvService;
import com.bytedance.pia.core.service.PiaLifeCycleService;
import com.bytedance.pia.core.service.PiaService;
import com.bytedance.pia.core.service.PiaSettingService;
import com.bytedance.pia.core.service.RenderingService;
import com.bytedance.pia.core.service.WorkerService;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ServiceProvider {
    private final Map<Class<?>, Object> services = new HashMap();

    public ServiceProvider() {
        put(IPiaWorkerService.class, WorkerService.getInstance());
        put(IPiaEnvService.class, EnvService.getInstance());
        put(IPiaLifeCycleService.class, PiaLifeCycleService.INSTANCE);
        put(IPiaRenderingService.class, RenderingService.getInstance());
        put(IPiaSettingService.class, PiaSettingService.INSTANCE);
        put(IPiaBridgeService.class, BridgeService.getInstance());
        put(IPiaService.class, PiaService.getInstance());
    }

    private <T> void put(Class<T> cls, T t) {
        this.services.put(cls, t);
    }

    public <T> T get(Class<T> cls) {
        try {
            return (T) this.services.get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
