package com.bytedance.iesgurd.strategy;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.task.HandlerTask;
import com.bytedance.geckox.task.HandlerTimerTaskManager;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoopManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/strategy/LoopManager;", "", "()V", "debugLoopEnable", "", EventConstants.PARAM_SOURCE_INTERVAL, "", "isRunning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isEnable", "resetDebugLoopEnable", "", "enable", "resetForTest", "resetLoop", "startLoop", "stopLoop", "updateBySettings", "newInterval", "LoopTask", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LoopManager {
    private static int interval;
    public static final LoopManager INSTANCE = new LoopManager();
    private static final AtomicBoolean isRunning = new AtomicBoolean(false);
    private static boolean debugLoopEnable = true;

    private LoopManager() {
    }

    public final void resetDebugLoopEnable(boolean enable) {
        GeckoLogger.d("set debug loop enable: " + enable);
        debugLoopEnable = enable;
        resetLoop();
    }

    public final void updateBySettings(int newInterval) {
        GeckoLogger.d("loop update by settings: " + newInterval);
        if (interval != newInterval) {
            if (isRunning.get()) {
                stopLoop();
            }
            interval = newInterval;
        }
        resetLoop();
    }

    public final boolean isEnable() {
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        return (inst.isGeckoEnable() && interval > 0) && debugLoopEnable;
    }

    private final void resetLoop() {
        boolean isEnable = isEnable();
        if (isEnable && !isRunning.get()) {
            startLoop();
        } else {
            if (isEnable || !isRunning.get()) {
                return;
            }
            stopLoop();
        }
    }

    private final void startLoop() {
        GeckoLogger.d("loop start: " + interval);
        isRunning.set(true);
        long j = interval * 1000;
        HandlerTimerTaskManager.inst().schedule(new LoopTask(), j, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopLoop() {
        GeckoLogger.d("loop stop: " + interval);
        isRunning.set(false);
        HandlerTimerTaskManager.inst().cancel(3);
    }

    public final void resetForTest() {
        debugLoopEnable = true;
        stopLoop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LoopManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/iesgurd/strategy/LoopManager$LoopTask;", "Lcom/bytedance/geckox/task/HandlerTask;", "", "()V", "execute", "", "taskType", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class LoopTask extends HandlerTask<Object> {
        public int taskType() {
            return 3;
        }

        public void execute() {
            if (!LoopManager.INSTANCE.isEnable()) {
                GeckoLogger.d("loop disable, cancel");
                LoopManager.INSTANCE.stopLoop();
            } else {
                RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(ReqType.POLLING);
                requestBodyUpdate.initCustom();
                new UpdateRequest(requestBodyUpdate).start();
            }
        }
    }
}
