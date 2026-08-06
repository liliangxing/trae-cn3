package com.bytedance.android.anniex.lite.task;

import android.net.Uri;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.model.AnnieXLynxPreloadStateModel;
import com.bytedance.android.anniex.utils.IAnnieXLatchService;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: AnnieXLatchTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLatchTask$work$2", f = "AnnieXLatchTask.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class AnnieXLatchTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXModelProvider $input;
    int label;
    final /* synthetic */ AnnieXLatchTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXLatchTask$work$2(AnnieXModelProvider annieXModelProvider, AnnieXLatchTask annieXLatchTask, Continuation<? super AnnieXLatchTask$work$2> continuation) {
        super(2, continuation);
        this.$input = annieXModelProvider;
        this.this$0 = annieXLatchTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXLatchTask$work$2(this.$input, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow schemaModelUnion = ((AnnieXLynxPreloadStateModel) this.$input.get(AnnieXLynxPreloadStateModel.class)).getSchemaModelUnion();
            final AnnieXLatchTask annieXLatchTask = this.this$0;
            this.label = 1;
            if (schemaModelUnion.collect(new FlowCollector<SchemaModelUnion>() { // from class: com.bytedance.android.anniex.lite.task.AnnieXLatchTask$work$2$invokeSuspend$$inlined$collect$1
                public Object emit(Object obj2, Continuation continuation) {
                    SchemaModelUnion schemaModelUnion2 = (SchemaModelUnion) obj2;
                    if (schemaModelUnion2 != null) {
                        Uri originUrl = schemaModelUnion2.getSchemaData().getOriginUrl();
                        IAnnieXLatchService iAnnieXLatchService = (IAnnieXLatchService) AnnieX.INSTANCE.getService(AnnieXLatchTask.this.getConfig().getBid(), IAnnieXLatchService.class);
                        if (iAnnieXLatchService != null && iAnnieXLatchService.isEnableLatch(originUrl)) {
                            iAnnieXLatchService.handlePrefetch(null, originUrl, AnnieXLatchTask.this.getConfig().getSessionId(), true);
                        }
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
}
