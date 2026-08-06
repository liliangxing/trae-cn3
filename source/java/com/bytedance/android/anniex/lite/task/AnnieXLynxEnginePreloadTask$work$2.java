package com.bytedance.android.anniex.lite.task;

import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import com.bytedance.android.anniex.lite.model.AnnieXLynxPreloadStateModel;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXLynxEnginePreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2", f = "AnnieXLynxEnginePreloadTask.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEnginePreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXModelProvider $input;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnnieXLynxEnginePreloadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLynxEnginePreloadTask$work$2(AnnieXModelProvider annieXModelProvider, AnnieXLynxEnginePreloadTask annieXLynxEnginePreloadTask, Continuation<? super AnnieXLynxEnginePreloadTask$work$2> continuation) {
        super(2, continuation);
        this.$input = annieXModelProvider;
        this.this$0 = annieXLynxEnginePreloadTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> annieXLynxEnginePreloadTask$work$2 = new AnnieXLynxEnginePreloadTask$work$2(this.$input, this.this$0, continuation);
        annieXLynxEnginePreloadTask$work$2.L$0 = obj;
        return annieXLynxEnginePreloadTask$work$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel = (AnnieXLynxPreloadStateModel) this.$input.get(AnnieXLynxPreloadStateModel.class);
            PreTaskSchemaModel preTaskSchemaModel = (PreTaskSchemaModel) this.$input.get(PreTaskSchemaModel.class);
            this.label = 1;
            if (FlowKt.flowCombine(annieXLynxPreloadStateModel.getLynxModel(), preTaskSchemaModel.getEnableEnginePreload(), new C08721(null)).collect(new C0871x45c916b5(annieXLynxPreloadStateModel, coroutineScope, this.this$0), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnieXLynxEnginePreloadTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", StrategyConstants.MODEL, StrategyConstants.ENABLE, ""}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$1", f = "AnnieXLynxEnginePreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08721 extends SuspendLambda implements Function3<AnnieXLynxModel, Boolean, Continuation<? super AnnieXLynxModel>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        C08721(Continuation<? super C08721> continuation) {
            super(3, continuation);
        }

        public final Object invoke(AnnieXLynxModel annieXLynxModel, boolean z, Continuation<? super AnnieXLynxModel> continuation) {
            C08721 c08721 = new C08721(continuation);
            c08721.L$0 = annieXLynxModel;
            c08721.Z$0 = z;
            return c08721.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((AnnieXLynxModel) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super AnnieXLynxModel>) obj3);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnnieXLynxModel annieXLynxModel = (AnnieXLynxModel) this.L$0;
            if (this.Z$0) {
                return annieXLynxModel;
            }
            return null;
        }
    }
}
