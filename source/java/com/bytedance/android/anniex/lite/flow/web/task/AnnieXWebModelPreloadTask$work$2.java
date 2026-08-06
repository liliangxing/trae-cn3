package com.bytedance.android.anniex.lite.flow.web.task;

import android.net.Uri;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.flow.model.AnnieXWebPreloadStateModel;
import com.bytedance.android.anniex.lite.flow.model.PreTaskSchemaModel;
import com.bytedance.android.anniex.lite.flow.schema.BDXPreTaskModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXWebModelPreloadTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask$work$2", f = "AnnieXWebModelPreloadTask.kt", i = {0, 0, 0, 1, 1, 1, 2, 2}, l = {36, 39, 41, 57}, m = "invokeSuspend", n = {"loadStateModel", "preTaskModel", "schemaModelUnion", "loadStateModel", "preTaskModel", "schemaModelUnion", "loadStateModel", "preTaskModel"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebModelPreloadTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXModelProvider $input;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AnnieXWebModelPreloadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXWebModelPreloadTask$work$2(AnnieXModelProvider annieXModelProvider, AnnieXWebModelPreloadTask annieXWebModelPreloadTask, Continuation<? super AnnieXWebModelPreloadTask$work$2> continuation) {
        super(2, continuation);
        this.$input = annieXModelProvider;
        this.this$0 = annieXWebModelPreloadTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXWebModelPreloadTask$work$2(this.$input, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00d9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AnnieXWebPreloadStateModel annieXWebPreloadStateModel;
        PreTaskSchemaModel preTaskSchemaModel;
        SchemaModelUnion schemaModelUnion;
        PreTaskSchemaModel preTaskSchemaModel2;
        AnnieXWebPreloadStateModel annieXWebPreloadStateModel2;
        final AnnieXWebPreloadStateModel annieXWebPreloadStateModel3;
        PreTaskSchemaModel preTaskSchemaModel3;
        Flow flowCombine;
        final AnnieXWebModelPreloadTask annieXWebModelPreloadTask;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            annieXWebPreloadStateModel = (AnnieXWebPreloadStateModel) this.$input.get(AnnieXWebPreloadStateModel.class);
            PreTaskSchemaModel preTaskSchemaModel4 = (PreTaskSchemaModel) this.$input.get(PreTaskSchemaModel.class);
            SchemaModelUnion orCreateSchemaData = AnnieXProcessCenter.INSTANCE.getOrCreateSchemaData(this.this$0.getConfig().getBid(), this.this$0.getConfig().getUri(), this.this$0.getConfig().getSessionId());
            this.L$0 = annieXWebPreloadStateModel;
            this.L$1 = preTaskSchemaModel4;
            this.L$2 = orCreateSchemaData;
            this.label = 1;
            if (annieXWebPreloadStateModel.postValue(orCreateSchemaData, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            preTaskSchemaModel = preTaskSchemaModel4;
            schemaModelUnion = orCreateSchemaData;
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    preTaskSchemaModel3 = (PreTaskSchemaModel) this.L$1;
                    annieXWebPreloadStateModel3 = (AnnieXWebPreloadStateModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCombine = FlowKt.flowCombine(annieXWebPreloadStateModel3.getSchemaModelUnion(), preTaskSchemaModel3.getEnableModelPreload(), new C08692(null));
                    annieXWebModelPreloadTask = this.this$0;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 4;
                    if (flowCombine.collect(new FlowCollector<SchemaModelUnion>() { // from class: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask$work$2$invokeSuspend$$inlined$collect$1
                        public Object emit(Object obj2, Continuation continuation) {
                            Uri uri;
                            SchemaModelUnion schemaModelUnion2 = (SchemaModelUnion) obj2;
                            if (schemaModelUnion2 != null) {
                                String str = (String) schemaModelUnion2.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
                                if (str == null || (uri = Uri.parse(str)) == null) {
                                    uri = Uri.EMPTY;
                                }
                                AnnieXProcessCenter annieXProcessCenter = AnnieXProcessCenter.INSTANCE;
                                String bid = AnnieXWebModelPreloadTask.this.getConfig().getBid();
                                Intrinsics.checkNotNullExpressionValue(uri, StrategyConstants.SCHEMA);
                                Object postValue = annieXWebPreloadStateModel3.postValue(annieXProcessCenter.getOrCreateWebModel(bid, uri, AnnieXWebModelPreloadTask.this.getConfig().getSessionId()), (Continuation<? super Unit>) continuation);
                                if (postValue == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                    return postValue;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                schemaModelUnion = (SchemaModelUnion) this.L$2;
                preTaskSchemaModel2 = (PreTaskSchemaModel) this.L$1;
                annieXWebPreloadStateModel2 = (AnnieXWebPreloadStateModel) this.L$0;
                ResultKt.throwOnFailure(obj);
                annieXWebPreloadStateModel = annieXWebPreloadStateModel2;
                this.L$0 = annieXWebPreloadStateModel;
                this.L$1 = preTaskSchemaModel2;
                this.L$2 = null;
                this.label = 3;
                if (annieXWebPreloadStateModel.postValue(schemaModelUnion, (Continuation<? super Unit>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                annieXWebPreloadStateModel3 = annieXWebPreloadStateModel;
                preTaskSchemaModel3 = preTaskSchemaModel2;
                flowCombine = FlowKt.flowCombine(annieXWebPreloadStateModel3.getSchemaModelUnion(), preTaskSchemaModel3.getEnableModelPreload(), new C08692(null));
                annieXWebModelPreloadTask = this.this$0;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
                if (flowCombine.collect(new FlowCollector<SchemaModelUnion>() { // from class: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask$work$2$invokeSuspend$$inlined$collect$1
                    public Object emit(Object obj2, Continuation continuation) {
                        Uri uri;
                        SchemaModelUnion schemaModelUnion2 = (SchemaModelUnion) obj2;
                        if (schemaModelUnion2 != null) {
                            String str = (String) schemaModelUnion2.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
                            if (str == null || (uri = Uri.parse(str)) == null) {
                                uri = Uri.EMPTY;
                            }
                            AnnieXProcessCenter annieXProcessCenter = AnnieXProcessCenter.INSTANCE;
                            String bid = AnnieXWebModelPreloadTask.this.getConfig().getBid();
                            Intrinsics.checkNotNullExpressionValue(uri, StrategyConstants.SCHEMA);
                            Object postValue = annieXWebPreloadStateModel3.postValue(annieXProcessCenter.getOrCreateWebModel(bid, uri, AnnieXWebModelPreloadTask.this.getConfig().getSessionId()), (Continuation<? super Unit>) continuation);
                            if (postValue == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                return postValue;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            schemaModelUnion = (SchemaModelUnion) this.L$2;
            preTaskSchemaModel = (PreTaskSchemaModel) this.L$1;
            AnnieXWebPreloadStateModel annieXWebPreloadStateModel4 = (AnnieXWebPreloadStateModel) this.L$0;
            ResultKt.throwOnFailure(obj);
            annieXWebPreloadStateModel = annieXWebPreloadStateModel4;
        }
        BDXPreTaskModel bDXPreTaskModel = (BDXPreTaskModel) SchemaService.Companion.getInstance().generateSchemaModel(schemaModelUnion.getSchemaData(), BDXPreTaskModel.class);
        if (bDXPreTaskModel != null) {
            this.L$0 = annieXWebPreloadStateModel;
            this.L$1 = preTaskSchemaModel;
            this.L$2 = schemaModelUnion;
            this.label = 2;
            if (preTaskSchemaModel.initWithData2(bDXPreTaskModel, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            preTaskSchemaModel2 = preTaskSchemaModel;
            annieXWebPreloadStateModel2 = annieXWebPreloadStateModel;
            annieXWebPreloadStateModel = annieXWebPreloadStateModel2;
            this.L$0 = annieXWebPreloadStateModel;
            this.L$1 = preTaskSchemaModel2;
            this.L$2 = null;
            this.label = 3;
            if (annieXWebPreloadStateModel.postValue(schemaModelUnion, (Continuation<? super Unit>) this) == coroutine_suspended) {
            }
        } else {
            preTaskSchemaModel2 = preTaskSchemaModel;
            this.L$0 = annieXWebPreloadStateModel;
            this.L$1 = preTaskSchemaModel2;
            this.L$2 = null;
            this.label = 3;
            if (annieXWebPreloadStateModel.postValue(schemaModelUnion, (Continuation<? super Unit>) this) == coroutine_suspended) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnieXWebModelPreloadTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "schemaModelUnion", StrategyConstants.ENABLE, ""}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask$work$2$2", f = "AnnieXWebModelPreloadTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.lite.flow.web.task.AnnieXWebModelPreloadTask$work$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08692 extends SuspendLambda implements Function3<SchemaModelUnion, Boolean, Continuation<? super SchemaModelUnion>, Object> {
        /* synthetic */ Object L$0;
        /* synthetic */ boolean Z$0;
        int label;

        C08692(Continuation<? super C08692> continuation) {
            super(3, continuation);
        }

        public final Object invoke(SchemaModelUnion schemaModelUnion, boolean z, Continuation<? super SchemaModelUnion> continuation) {
            C08692 c08692 = new C08692(continuation);
            c08692.L$0 = schemaModelUnion;
            c08692.Z$0 = z;
            return c08692.invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((SchemaModelUnion) obj, ((Boolean) obj2).booleanValue(), (Continuation<? super SchemaModelUnion>) obj3);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SchemaModelUnion schemaModelUnion = (SchemaModelUnion) this.L$0;
            if (this.Z$0) {
                return schemaModelUnion;
            }
            return null;
        }
    }
}
