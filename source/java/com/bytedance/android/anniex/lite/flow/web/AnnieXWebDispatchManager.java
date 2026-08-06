package com.bytedance.android.anniex.lite.flow.web;

import android.net.Uri;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.flow.model.AnnieXWebPreloadStateModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AnnieXWebDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016R\u0018\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/web/AnnieXWebDispatchManager;", "Lcom/bytedance/android/anniex/lite/flow/base/BaseAnnieXDispatchManager;", "Lcom/bytedance/android/anniex/lite/flow/web/IAnnieXWebPreloadProvider;", "bid", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "annieXWebEngine", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "annieXWebPreloadStateModel", "Lcom/bytedance/android/anniex/lite/flow/model/AnnieXWebPreloadStateModel;", "cancelPreload", "", "dispatchFlow", "loadFlowTask", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "getCurrentSessionId", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getOrCreateAnnieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "getPreloadEngine", "onRelease", "release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebDispatchManager extends BaseAnnieXDispatchManager implements IAnnieXWebPreloadProvider {
    private WeakReference<AnnieXWebKit> annieXWebEngine;
    private AnnieXWebPreloadStateModel annieXWebPreloadStateModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebDispatchManager(String str, String str2) {
        super(str, str2);
        Intrinsics.checkNotNullParameter(str, "bid");
        Intrinsics.checkNotNullParameter(str2, "sessionId");
        AnnieXModelProvider annieXModelProvider = getAnnieXModelProvider();
        this.annieXWebPreloadStateModel = annieXModelProvider != null ? (AnnieXWebPreloadStateModel) annieXModelProvider.get(AnnieXWebPreloadStateModel.class) : null;
        BuildersKt.launch$default(getCustomScope(), Dispatchers.getDefault(), (CoroutineStart) null, new C08651(null), 2, (Object) null);
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider, com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public KitType getKitType() {
        return KitType.WEB;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public String getCurrentSessionId() {
        return getSessionId();
    }

    /* compiled from: AnnieXWebDispatchManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1", f = "AnnieXWebDispatchManager.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    static final class C08651 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08651(Continuation<? super C08651> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08651(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Flow webEngine;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AnnieXWebPreloadStateModel annieXWebPreloadStateModel = AnnieXWebDispatchManager.this.annieXWebPreloadStateModel;
                if (annieXWebPreloadStateModel != null && (webEngine = annieXWebPreloadStateModel.getWebEngine()) != null) {
                    final AnnieXWebDispatchManager annieXWebDispatchManager = AnnieXWebDispatchManager.this;
                    this.label = 1;
                    if (webEngine.collect(new FlowCollector<AnnieXWebKit>() { // from class: com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$1$invokeSuspend$$inlined$collect$1
                        public Object emit(Object obj2, Continuation continuation) {
                            AnnieXWebDispatchManager.this.annieXWebEngine = new WeakReference((AnnieXWebKit) obj2);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager
    public void dispatchFlow(LoadFlowTask loadFlowTask) {
        Intrinsics.checkNotNullParameter(loadFlowTask, "loadFlowTask");
        BuildersKt.launch$default(getCustomScope(), Dispatchers.getDefault(), (CoroutineStart) null, new AnnieXWebDispatchManager$dispatchFlow$1(this, loadFlowTask, null), 2, (Object) null);
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider
    public AnnieXWebModel getOrCreateAnnieXWebModel(String bid, Uri schema, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return AnnieXProcessCenter.INSTANCE.getOrCreateWebModel(bid, schema, sessionId);
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider
    public AnnieXWebKit getPreloadEngine() {
        WeakReference<AnnieXWebKit> weakReference = this.annieXWebEngine;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.IAnnieXPreloadProvider
    public void onRelease() {
        release();
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.BaseAnnieXDispatchManager, com.bytedance.android.anniex.lite.flow.base.model.BaseDispatchManager
    public void release() {
        super.release();
        WeakReference<AnnieXWebKit> weakReference = this.annieXWebEngine;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    @Override // com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider
    public void cancelPreload() {
        if (IConditionCallKt.enableAnniexFlowCancelFix()) {
            CoroutineScopeKt.cancel$default(getCustomScope(), (CancellationException) null, 1, (Object) null);
        }
    }
}
