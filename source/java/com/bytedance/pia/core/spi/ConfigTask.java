package com.bytedance.pia.core.spi;

import com.bytedance.pia.core.spi.api.IPiaConfigTask;
import com.bytedance.pia.core.utils.Logger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ConfigTask implements IPiaConfigTask {
    @Override // java.lang.Runnable
    public void run() {
    }

    public static IPiaConfigTask get() {
        try {
            return (IPiaConfigTask) ServiceManager.get().getService(IPiaConfigTask.class);
        } catch (Throwable unused) {
            Logger.m181i("[SPI] try get config task failed, fallback to default.");
            return new ConfigTask();
        }
    }
}
