package com.bytedance.iesgurd.strategy;

import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.bytedance.iesgurd.core.ReqType;
import com.bytedance.iesgurd.model.RequestBodyUpdate;
import com.bytedance.iesgurd.request.UpdateRequest;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ColdStartManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u001a\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/iesgurd/strategy/ColdStartManager;", "", "()V", "disableForDebug", "", "getDisableForDebug", "()Z", "setDisableForDebug", "(Z)V", "isStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "sendFinish", "getSendFinish", "isFinish", "resetForTest", "", "startUp", MetricConstant.MONITOR_STAGE_UPDATE, "accessKey", "", "reqType", "Lcom/bytedance/iesgurd/core/ReqType;", "updateIfNeeded", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ColdStartManager {
    private static boolean disableForDebug;
    public static final ColdStartManager INSTANCE = new ColdStartManager();
    private static final AtomicBoolean isStarted = new AtomicBoolean(false);
    private static final AtomicBoolean sendFinish = new AtomicBoolean(false);

    private ColdStartManager() {
    }

    public final boolean getDisableForDebug() {
        return disableForDebug;
    }

    public final void setDisableForDebug(boolean z) {
        disableForDebug = z;
    }

    public final boolean getSendFinish() {
        return sendFinish.get();
    }

    public final void startUp() {
        if (disableForDebug) {
            return;
        }
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        if (!inst.isGeckoEnable()) {
            GeckoLogger.d("coldStart update failed, gecko disable");
            return;
        }
        AtomicBoolean atomicBoolean = isStarted;
        if (atomicBoolean.get()) {
            return;
        }
        GeckoLogger.d("coldStart update");
        atomicBoolean.set(true);
        update(null, ReqType.QUEUE);
    }

    public final void updateIfNeeded(String accessKey) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        if (!disableForDebug && sendFinish.get()) {
            update(accessKey, ReqType.REGISTER_LATE);
        }
    }

    private final void update(String accessKey, ReqType reqType) {
        RequestBodyUpdate requestBodyUpdate = new RequestBodyUpdate(reqType);
        if (accessKey != null) {
            requestBodyUpdate.initCustom(CollectionsKt.listOf(accessKey));
        } else {
            requestBodyUpdate.initCustom();
        }
        sendFinish.set(true);
        new UpdateRequest(requestBodyUpdate).start();
    }

    public final boolean isFinish() {
        return sendFinish.get();
    }

    public final void resetForTest() {
        isStarted.set(false);
        sendFinish.set(false);
        disableForDebug = false;
    }
}
