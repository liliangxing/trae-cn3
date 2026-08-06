package com.bytedance.android.anniex.lite.task;

import com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: AnnieXLynxEnginePreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/lite/task/AnnieXLynxEnginePreloadTask;", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/BaseModelAnnieTask;", "config", "Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;", "(Lcom/bytedance/android/anniex/lite/flow/base/dispatch/LoadFlowTask;)V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", StrategyConstants.NAME, "", "work", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "input", "Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/bytedance/android/anniex/lite/flow/base/model/AnnieXModelProvider;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEnginePreloadTask extends BaseModelAnnieTask {
    private static final String TASK_NAME = "lynx_preload";
    private final ContextProviderFactory contextProviderFactory;

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask
    public String name() {
        return TASK_NAME;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLynxEnginePreloadTask(LoadFlowTask loadFlowTask) {
        super(loadFlowTask);
        Intrinsics.checkNotNullParameter(loadFlowTask, "config");
        this.contextProviderFactory = new ContextProviderFactory();
    }

    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask, com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieTask
    public /* bridge */ /* synthetic */ Object work(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation continuation) {
        return work(coroutineScope, annieXModelProvider, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask
    public Object work(CoroutineScope coroutineScope, AnnieXModelProvider annieXModelProvider, Continuation<? super Unit> continuation) {
        BuildersKt.launch$default(coroutineScope, Dispatchers.getDefault(), (CoroutineStart) null, new AnnieXLynxEnginePreloadTask$work$2(annieXModelProvider, this, null), 2, (Object) null);
        return Unit.INSTANCE;
    }
}
