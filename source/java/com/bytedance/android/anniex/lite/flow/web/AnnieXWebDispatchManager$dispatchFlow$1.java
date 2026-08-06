package com.bytedance.android.anniex.lite.flow.web;

import com.bytedance.android.anniex.lite.flow.base.dispatch.BaseModelAnnieTask;
import com.bytedance.android.anniex.lite.flow.base.dispatch.IAnnieXPreloadStrategyProvider;
import com.bytedance.android.anniex.lite.flow.base.dispatch.LoadFlowTask;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnnieXWebDispatchManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManager$dispatchFlow$1", f = "AnnieXWebDispatchManager.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXWebDispatchManager$dispatchFlow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadFlowTask $loadFlowTask;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AnnieXWebDispatchManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebDispatchManager$dispatchFlow$1(AnnieXWebDispatchManager annieXWebDispatchManager, LoadFlowTask loadFlowTask, Continuation<? super AnnieXWebDispatchManager$dispatchFlow$1> continuation) {
        super(2, continuation);
        this.this$0 = annieXWebDispatchManager;
        this.$loadFlowTask = loadFlowTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXWebDispatchManager$dispatchFlow$1(this.this$0, this.$loadFlowTask, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<BaseModelAnnieTask> loadStrategy;
        AnnieXWebDispatchManager annieXWebDispatchManager;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IAnnieXPreloadStrategyProvider dispatchProvider = this.this$0.getDispatchProvider();
            if (dispatchProvider != null && (loadStrategy = dispatchProvider.getLoadStrategy(KitType.WEB, this.$loadFlowTask)) != null) {
                annieXWebDispatchManager = this.this$0;
                it = loadStrategy.iterator();
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        it = (Iterator) this.L$1;
        annieXWebDispatchManager = (AnnieXWebDispatchManager) this.L$0;
        ResultKt.throwOnFailure(obj);
        while (it.hasNext()) {
            BaseModelAnnieTask baseModelAnnieTask = (BaseModelAnnieTask) it.next();
            AnnieXModelProvider annieXModelProvider = annieXWebDispatchManager.getAnnieXModelProvider();
            if (annieXModelProvider != null) {
                CoroutineScope customScope = annieXWebDispatchManager.getCustomScope();
                this.L$0 = annieXWebDispatchManager;
                this.L$1 = it;
                this.label = 1;
                if (baseModelAnnieTask.work(customScope, annieXModelProvider, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }
}
