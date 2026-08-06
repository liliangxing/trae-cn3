package com.bytedance.android.anniex.lite.flow.base;

import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.flow.base.model.BaseDispatchManager;
import com.bytedance.android.anniex.lite.flow.base.model.DefaultModelFactory;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BaseAnnieXDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020\u001dH\u0016J\b\u0010$\u001a\u00020\u001dH\u0002R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\f¨\u0006&"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXDispatchManager;", "Lcom/bytedance/android/anniex/lite/flow/base/model/BaseDispatchManager;", "bid", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "annieXModelProvider", "getAnnieXModelProvider", "()Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "getBid", "()Ljava/lang/String;", "customScope", "Lkotlinx/coroutines/CoroutineScope;", "getCustomScope", "()Lkotlinx/coroutines/CoroutineScope;", "dispatchProvider", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;", "getDispatchProvider", "()Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;", "setDispatchProvider", "(Lcom/bytedance/android/anniex/lite/flow/base/dispatch/IAnnieXPreloadStrategyProvider;)V", "", "released", "getReleased", "()Z", "getSessionId", "dispatchEvent", "", "iEvent", "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "dispatchFlow", "loadFlowTask", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "release", "releaseTask", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseAnnieXDispatchManager extends BaseDispatchManager {
    public static final String TAG = "AnnieXFlow";
    private AnnieXModelProvider annieXModelProvider;
    private final String bid;
    private final CoroutineScope customScope;
    private IAnnieXPreloadStrategyProvider dispatchProvider;
    private volatile boolean released;
    private final String sessionId;

    public final void dispatchEvent(IEvent iEvent) {
        Intrinsics.checkNotNullParameter(iEvent, "iEvent");
    }

    public abstract void dispatchFlow(LoadFlowTask loadFlowTask);

    public BaseAnnieXDispatchManager(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        this.bid = str;
        this.sessionId = str2;
        this.customScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
        AnnieXDispatchManagerCache.INSTANCE.putDispatchManager(str2, this);
        this.annieXModelProvider = new AnnieXModelProvider(getMModelStore(), DefaultModelFactory.INSTANCE.getInstance());
        this.dispatchProvider = (IAnnieXPreloadStrategyProvider) AnnieXServiceCenter.INSTANCE.getService(str, IAnnieXPreloadStrategyProvider.class);
        releaseTask();
    }

    public final String getBid() {
        return this.bid;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getReleased() {
        return this.released;
    }

    public final CoroutineScope getCustomScope() {
        return this.customScope;
    }

    public final AnnieXModelProvider getAnnieXModelProvider() {
        return this.annieXModelProvider;
    }

    public final IAnnieXPreloadStrategyProvider getDispatchProvider() {
        return this.dispatchProvider;
    }

    public final void setDispatchProvider(IAnnieXPreloadStrategyProvider iAnnieXPreloadStrategyProvider) {
        this.dispatchProvider = iAnnieXPreloadStrategyProvider;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.model.BaseDispatchManager
    public void release() {
        super.release();
        CoroutineScopeKt.cancel$default(this.customScope, (CancellationException) null, 1, (Object) null);
        AnnieXDispatchManagerCache.INSTANCE.removeDispatchManager(this.sessionId);
        this.released = true;
    }

    private final void releaseTask() {
        BuildersKt.launch$default(this.customScope, Dispatchers.getDefault(), (CoroutineStart) null, new BaseAnnieXDispatchManager$releaseTask$1(this, null), 2, (Object) null);
    }
}
