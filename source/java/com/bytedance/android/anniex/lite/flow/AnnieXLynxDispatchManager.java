package com.bytedance.android.anniex.lite.flow;

import android.net.Uri;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.engine.AnnieXLynxEngineManager;
import com.bytedance.android.anniex.lite.AnnieXLynxProcessCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider;
import com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.model.AnnieXLynxPreloadStateModel;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AnnieXLynxDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/AnnieXLynxDispatchManager;", "Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXDispatchManager;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxPreloadProvider;", "bid", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "annieXLynxPreloadStateModel", "Lcom/bytedance/android/anniex/lite/model/AnnieXLynxPreloadStateModel;", "cancelPreload", "", "dispatchFlow", "loadFlowTask", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "getCurrentSessionId", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getOrCreateAnnieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "getPreloadEngine", "Lcom/bytedance/android/anniex/engine/AnnieXLynxEngine;", "onRelease", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxDispatchManager extends BaseAnnieXDispatchManager implements IAnnieXLynxPreloadProvider {
    private AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLynxDispatchManager(String str, String str2) {
        super(str, str2);
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        AnnieXModelProvider annieXModelProvider = getAnnieXModelProvider();
        this.annieXLynxPreloadStateModel = annieXModelProvider != null ? (AnnieXLynxPreloadStateModel) annieXModelProvider.get(AnnieXLynxPreloadStateModel.class) : null;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider, com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public KitType getKitType() {
        return KitType.LYNX;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public String getCurrentSessionId() {
        return getSessionId();
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager
    public void dispatchFlow(LoadFlowTask loadFlowTask) {
        Intrinsics.checkNotNullParameter(loadFlowTask, "loadFlowTask");
        BuildersKt.launch$default(getCustomScope(), Dispatchers.getDefault(), (CoroutineStart) null, new AnnieXLynxDispatchManager$dispatchFlow$1(this, loadFlowTask, null), 2, (Object) null);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider
    public AnnieXLynxModel getOrCreateAnnieXLynxModel(String bid, Uri schema, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return AnnieXLynxProcessCenter.INSTANCE.getOrCreateLynxModel(bid, schema, sessionId);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider
    public AnnieXLynxEngine getPreloadEngine(String bid, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return AnnieXLynxEngineManager.INSTANCE.getEngine(bid, sessionId);
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public void onRelease() {
        release();
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager, com.bytedance.android.anniex.lite.flow.base.model.BaseDispatchManager
    public void release() {
        super.release();
        AnnieXLynxEngineManager.INSTANCE.getEngine(getBid(), getSessionId());
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider
    public void cancelPreload() {
        if (IConditionCallKt.enableAnniexFlowCancelFix()) {
            CoroutineScopeKt.cancel$default(getCustomScope(), (CancellationException) null, 1, (Object) null);
        }
    }
}
