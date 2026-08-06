package com.bytedance.trae.init.task;

import android.os.Build;
import com.bytedance.crash.GlobalSwitch;
import com.bytedance.crash.util.RomUtils;
import com.bytedance.lego.init.model.BaseFeedShowTask;
import com.bytedance.trae.apm.api.IApmTrace;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;

/* compiled from: InitNpthAsyncTask.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/init/task/InitNpthAsyncTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "<init>", "()V", "TAG", "", "run", "", "setOpenLooperMonitor", "shouldDisableAnrLooperMonitor", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitNpthAsyncTask implements BaseFeedShowTask {
    public static final int $stable = 0;
    private final String TAG = "InitNpthAsyncTask";

    public void run() {
        setOpenLooperMonitor();
    }

    private final void setOpenLooperMonitor() {
        FLogger.INSTANCE.i(this.TAG, "setOpenLooperMonitor");
        boolean isDebug = AppHost.INSTANCE.isDebug();
        boolean isTestChannel = AppHost.INSTANCE.isTestChannel();
        if (!shouldDisableAnrLooperMonitor() && (isDebug || isTestChannel)) {
            FLogger.INSTANCE.i(this.TAG, "anr_looper_monitor, enable = true.  isDebug: " + isDebug + ", isTestChannel: " + isTestChannel + ", isAnrLooperMonitorEnable: false");
            IApmTrace.INSTANCE.addTag("anr_looper_monitor", "true");
            GlobalSwitch.setOpenLooperMonitor(true);
        } else {
            FLogger.INSTANCE.w(this.TAG, "anr_looper_monitor, not enable");
            IApmTrace.INSTANCE.addTag("anr_looper_monitor", "false");
            GlobalSwitch.setOpenLooperMonitor(false);
        }
    }

    private final boolean shouldDisableAnrLooperMonitor() {
        try {
            if (Build.VERSION.SDK_INT == 29) {
                return RomUtils.isHarmonyOs();
            }
            return false;
        } catch (Exception e) {
            FLogger.INSTANCE.e(this.TAG, "shouldDisableAnrLooperMonitor", e);
            return false;
        }
    }
}
