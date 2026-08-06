package com.bytedance.trae.init.task;

import com.bytedance.lego.init.model.BaseFeedShowTask;
import com.bytedance.trae.apm.api.IApmTrace;
import com.bytedance.trae.apm.api.INpth;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;

/* compiled from: InitNpthGwpAsanTask.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "<init>", "()V", "TAG", "", "run", "", "startGWPAsanMonitor", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitNpthGwpAsanTask implements BaseFeedShowTask {
    public static final int $stable = 0;
    private final String TAG = "InitNpthGwpAsanTask";

    public void run() {
        FLogger.INSTANCE.i(this.TAG, "startGWPAsanMonitor, isNpthGwpAsanEnable: false");
        FLogger.INSTANCE.i(this.TAG, "runInternal, not enable");
        IApmTrace.INSTANCE.addTag("gwp_asan_enable", "0");
    }

    private final void startGWPAsanMonitor() {
        try {
            FLogger.INSTANCE.i(this.TAG, "startGWPAsanMonitor");
            INpth.INSTANCE.enableGwpAsan();
            IApmTrace.INSTANCE.addTag("gwp_asan_enable", "1");
        } catch (Throwable th) {
            FLogger.INSTANCE.e(this.TAG, "startGWPAsanMonitor error", th);
        }
    }
}
