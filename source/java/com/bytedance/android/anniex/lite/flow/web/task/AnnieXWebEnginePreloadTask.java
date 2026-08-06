package com.bytedance.android.anniex.lite.flow.web.task;

import com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AnnieXWebEnginePreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/web/task/AnnieXWebEnginePreloadTask;", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/BaseModelAnnieTask;", "config", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "(Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;)V", StrategyConstants.NAME, "", "work", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "input", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebEnginePreloadTask extends BaseModelAnnieTask {
    private static final String TASK_NAME = "lynx_preload";

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask
    public String name() {
        return TASK_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebEnginePreloadTask(LoadFlowTask loadFlowTask) {
        super(loadFlowTask);
        Intrinsics.checkNotNullParameter(loadFlowTask, "config");
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask, com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask
    public /* bridge */ /* synthetic */ Object work(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation continuation) {
        return work(coroutineScope, annieXModelProvider, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask
    public Object work(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation<? super Unit> continuation) {
        BuildersKt.launch$default(coroutineScope, Dispatchers.getDefault(), (CoroutineStart) null, new AnnieXWebEnginePreloadTask$work$2(annieXModelProvider, coroutineScope, this, null), 2, (Object) null);
        return Unit.INSTANCE;
    }
}
