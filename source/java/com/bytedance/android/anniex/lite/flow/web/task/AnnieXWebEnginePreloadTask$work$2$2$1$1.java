package com.bytedance.android.anniex.lite.flow.web.task;

import android.app.Application;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.container.AnnieXStickWebLifeCycleWrapper;
import com.bytedance.android.anniex.lite.flow.model.AnnieXWebPreloadStateModel;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AnnieXWebEnginePreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebEnginePreloadTask$work$2$2$1$1", f = "AnnieXWebEnginePreloadTask.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXWebEnginePreloadTask$work$2$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXWebModel $_annieWebXModel;
    final /* synthetic */ Application $context;
    final /* synthetic */ AnnieXWebPreloadStateModel $loadStateModel;
    int label;
    final /* synthetic */ AnnieXWebEnginePreloadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebEnginePreloadTask$work$2$2$1$1(Application application, AnnieXWebEnginePreloadTask annieXWebEnginePreloadTask, AnnieXWebModel annieXWebModel, AnnieXWebPreloadStateModel annieXWebPreloadStateModel, Continuation<? super AnnieXWebEnginePreloadTask$work$2$2$1$1> continuation) {
        super(2, continuation);
        this.$context = application;
        this.this$0 = annieXWebEnginePreloadTask;
        this.$_annieWebXModel = annieXWebModel;
        this.$loadStateModel = annieXWebPreloadStateModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXWebEnginePreloadTask$work$2$2$1$1(this.$context, this.this$0, this.$_annieWebXModel, this.$loadStateModel, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Application application;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnnieXProcessCenter annieXProcessCenter = AnnieXProcessCenter.INSTANCE;
            Application application2 = this.$context;
            Intrinsics.checkNotNull(application2, "null cannot be cast to non-null type android.content.Context");
            AnnieXWebKit orCreateEnginView = annieXProcessCenter.getOrCreateEnginView(application2, this.this$0.getConfig().getBid());
            Map<String, Object> globalProps = this.$_annieWebXModel.getGlobalProps();
            if (globalProps != null) {
                globalProps.put("isFromEngine", Boxing.boxBoolean(true));
            }
            if (IConditionCallKt.enableFlowPageContextFix()) {
                SSWebView realView = orCreateEnginView.getRealView();
                application = realView != null ? realView.getContext() : null;
                if (application == null) {
                    return Unit.INSTANCE;
                }
            } else {
                application = this.$context;
            }
            AnnieXWebKit.loadUri$default(orCreateEnginView, application, new AnnieXStickWebLifeCycleWrapper(this.$_annieWebXModel.getUrl()), this.$_annieWebXModel, null, 8, null);
            this.label = 1;
            if (this.$loadStateModel.postValue(orCreateEnginView, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
}
