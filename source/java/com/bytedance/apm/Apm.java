package com.bytedance.apm;

import android.content.Context;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmReportConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.thread.LogBypassStoreEventManager;
import com.bytedance.apm.trace.ITraceListener;
import com.bytedance.apm.trace.TraceConfig;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Apm {
    public static Apm getInstance() {
        return Holder.sInstance;
    }

    @Deprecated
    public Apm traceConfig(TraceConfig traceConfig) {
        ApmDelegate.getInstance().setTraceConfig(traceConfig);
        return this;
    }

    @Deprecated
    public Apm traceListener(ITraceListener iTraceListener) {
        ApmDelegate.getInstance().setTraceListener(iTraceListener);
        return this;
    }

    public void init(Context context) {
        ApmDelegate.getInstance().init(context);
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.Apm.1
                @Override // java.lang.Runnable
                public void run() {
                    ApmAgent.storeLogBypass("Apm#init", "Apm init");
                }
            });
        }
    }

    public void init(Context context, ApmInitConfig apmInitConfig) {
        ApmDelegate.getInstance().init(context, apmInitConfig);
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.Apm.2
                @Override // java.lang.Runnable
                public void run() {
                    ApmAgent.storeLogBypass("Apm#init", "Apm init");
                }
            });
        }
    }

    public void start(ApmStartConfig apmStartConfig) {
        ApmDelegate.getInstance().start(apmStartConfig);
        if (ApmContext.isInternalTest()) {
            LogBypassStoreEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.Apm.3
                @Override // java.lang.Runnable
                public void run() {
                    ApmAgent.storeLogBypass("Apm#start", "Apm start");
                }
            });
        }
    }

    public void pause() {
        ApmDelegate.getInstance().pause();
    }

    public void resume() {
        ApmDelegate.getInstance().resume();
    }

    public void stop() {
        ApmDelegate.getInstance().stop();
    }

    public static void setReportMode(ApmReportConfig apmReportConfig) {
        ApmDelegate.getInstance().setReportConfig(apmReportConfig);
    }

    public ApmStartConfig.Builder newStartConfigBuilder() {
        return ApmDelegate.getInstance().newStartConfigBuilder();
    }

    public void restart(ApmStartConfig apmStartConfig) {
        ApmDelegate.getInstance().restart(apmStartConfig);
    }

    public void clearBufferLog() {
        ApmDelegate.getInstance().clearBufferLog();
    }

    public void clearAllLogSync() {
        ApmDelegate.getInstance().clearBufferLogSync();
        ApmDelegate.getInstance().clearLegacyLogSync(-1L);
    }

    public void clearLegacyLog(long j) {
        ApmDelegate.getInstance().clearLegacyLog(j);
    }

    public void startAllPlugins() {
        ApmDelegate.getInstance().startAllPlugins();
    }

    public void stopAllPlugins() {
        ApmDelegate.getInstance().stopAllPlugins();
    }

    public void destroyAllPlugins() {
        ApmDelegate.getInstance().destroyAllPlugins();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Holder {
        private static final Apm sInstance = new Apm();

        private Holder() {
        }
    }

    private Apm() {
    }
}
