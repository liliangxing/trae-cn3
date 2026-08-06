package com.bytedance.android.anniex.lite.flow.web.task;

import android.app.Application;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.flow.model.AnnieXWebPreloadStateModel;
import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXWebEnginePreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebEnginePreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXModelProvider $input;
    final /* synthetic */ CoroutineScope $scope;
    int label;
    final /* synthetic */ AnnieXWebEnginePreloadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebEnginePreloadTask$work$2(AnnieXModelProvider annieXModelProvider, CoroutineScope coroutineScope, AnnieXWebEnginePreloadTask annieXWebEnginePreloadTask, Continuation<? super AnnieXWebEnginePreloadTask$work$2> continuation) {
        super(2, continuation);
        this.$input = annieXModelProvider;
        this.$scope = coroutineScope;
        this.this$0 = annieXWebEnginePreloadTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXWebEnginePreloadTask$work$2(this.$input, this.$scope, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Application application = BulletEnv.Companion.getInstance().getApplication();
            final AnnieXWebPreloadStateModel annieXWebPreloadStateModel = (AnnieXWebPreloadStateModel) this.$input.get(AnnieXWebPreloadStateModel.class);
            Flow flowCombine = FlowKt.flowCombine(annieXWebPreloadStateModel.getWebModel(), ((PreTaskSchemaModel) this.$input.get(PreTaskSchemaModel.class)).getEnableEnginePreload(), new C08671(null));
            final CoroutineScope coroutineScope = this.$scope;
            final AnnieXWebEnginePreloadTask annieXWebEnginePreloadTask = this.this$0;
            this.label = 1;
            if (flowCombine.collect(new FlowCollector<AnnieXWebModel>() { // from class: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1
                public Object emit(Object obj2, Continuation continuation) {
                    AnnieXWebModel annieXWebModel = (AnnieXWebModel) obj2;
                    if (annieXWebModel != null && !DefaultWebKitDelegate.Companion.getGlobalColdStart()) {
                        BuildersKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new AnnieXWebEnginePreloadTask$work$2$2$1$1(application, annieXWebEnginePreloadTask, annieXWebModel, annieXWebPreloadStateModel, null), 2, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
            }, (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: AnnieXWebEnginePreloadTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", StrategyConstants.MODEL, StrategyConstants.ENABLE, ""}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$1", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08671 extends SuspendLambda implements Function3<AnnieXWebModel, Boolean, Continuation<? super AnnieXWebModel>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        C08671(Continuation<? super C08671> continuation) {
            super(3, continuation);
        }

        public final Object invoke(AnnieXWebModel annieXWebModel, boolean z, Continuation<? super AnnieXWebModel> continuation) {
            C08671 c08671 = new C08671(continuation);
            c08671.L$0 = annieXWebModel;
            c08671.Z$0 = z;
            return c08671.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((AnnieXWebModel) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super AnnieXWebModel>) obj3);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AnnieXWebModel annieXWebModel = (AnnieXWebModel) this.L$0;
            if (this.Z$0) {
                return annieXWebModel;
            }
            return null;
        }
    }
}
