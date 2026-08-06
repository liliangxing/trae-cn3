package com.bytedance.android.anniex.lite;

import android.net.Uri;
import bolts.Task;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess;
import com.bytedance.android.anniex.lite.flow.AnnieXLynxDispatchManager;
import com.bytedance.android.anniex.lite.flow.base.AnnieXDispatchManagerCache;
import com.bytedance.android.anniex.lite.flow.base.dispatch.FlowTaskType;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxProcessCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXLynxProcess;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxProcess;", "()V", "dispatchFlow", "", "bid", "", "sessionId", "uri", "Landroid/net/Uri;", "preCreateLynxModel", StrategyConstants.SCHEMA, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxProcess implements IAnnieXLynxProcess {
    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess
    public void preCreateLynxModel(final String bid, final String sessionId, final Uri schema) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (AnnieXLynxProcessCenter.INSTANCE.getLynxModelLruCache().get(sessionId) != null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.lite.AnnieXLynxProcess$preCreateLynxModel$1
            @Override // java.util.concurrent.Callable
            public final AnnieXLynxModel call() {
                return AnnieXLynxProcessCenter.INSTANCE.createLynxModel$anniex_release(bid, schema, sessionId);
            }
        });
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxProcess
    public void dispatchFlow(String bid, String sessionId, Uri uri) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (AnnieXDispatchManagerCache.INSTANCE.getDispatchManager(sessionId) == null) {
            AnnieXLynxDispatchManager annieXLynxDispatchManager = new AnnieXLynxDispatchManager(bid, sessionId);
            annieXLynxDispatchManager.dispatchFlow(new LoadFlowTask(FlowTaskType.RouterInitTask, bid, sessionId, uri));
            annieXLynxDispatchManager.dispatchFlow(new LoadFlowTask(FlowTaskType.EnginePreloadTask, bid, sessionId, uri));
        }
    }
}
