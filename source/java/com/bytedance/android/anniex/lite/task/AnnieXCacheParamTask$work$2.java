package com.bytedance.android.anniex.lite.task;

import android.net.Uri;
import coil3.disk.DiskLruCache;
import com.bytedance.android.anniex.ability.service.IAnnieXBizPropsProvider;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.lite.flow.base.model.AnnieXModelProvider;
import com.bytedance.android.anniex.lite.model.AnnieXLynxPreloadStateModel;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilderKt;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.router.RouterServiceKt;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnnieXCacheParamTask.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2", f = "AnnieXCacheParamTask.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXCacheParamTask$work$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnnieXModelProvider $input;
    int label;
    final /* synthetic */ AnnieXCacheParamTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXCacheParamTask$work$2(AnnieXModelProvider annieXModelProvider, AnnieXCacheParamTask annieXCacheParamTask, Continuation<? super AnnieXCacheParamTask$work$2> continuation) {
        super(2, continuation);
        this.$input = annieXModelProvider;
        this.this$0 = annieXCacheParamTask;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnnieXCacheParamTask$work$2(this.$input, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel = (AnnieXLynxPreloadStateModel) this.$input.get(AnnieXLynxPreloadStateModel.class);
            this.label = 1;
            if (FlowKt.collectLatest(annieXLynxPreloadStateModel.getSchemaModelUnion(), new C08701(this.this$0, annieXLynxPreloadStateModel, null), (Continuation) this) == coroutine_suspended) {
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
    /* compiled from: AnnieXCacheParamTask.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;"}, k = 3, mv = {1, 4, 3}, xi = 48)
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2$1", f = "AnnieXCacheParamTask.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.android.anniex.lite.task.AnnieXCacheParamTask$work$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class C08701 extends SuspendLambda implements Function2<SchemaModelUnion, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnnieXLynxPreloadStateModel $loadStateModel;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AnnieXCacheParamTask this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08701(AnnieXCacheParamTask annieXCacheParamTask, AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel, Continuation<? super C08701> continuation) {
            super(2, continuation);
            this.this$0 = annieXCacheParamTask;
            this.$loadStateModel = annieXLynxPreloadStateModel;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08701 = new C08701(this.this$0, this.$loadStateModel, continuation);
            c08701.L$0 = obj;
            return c08701;
        }

        public final Object invoke(SchemaModelUnion schemaModelUnion, Continuation<? super Unit> continuation) {
            return create(schemaModelUnion, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SchemaModelUnion schemaModelUnion = (SchemaModelUnion) this.L$0;
                if (schemaModelUnion != null) {
                    Uri originUrl = schemaModelUnion.getSchemaData().getOriginUrl();
                    String subUrl = AnnieXWebModelBuilderKt.getSubUrl(originUrl);
                    if (subUrl == null) {
                        return Unit.INSTANCE;
                    }
                    if (IConditionCallKt.enableWebcastLitePageGlobalPropsFix() && RouterServiceKt.getQueryParameterSafely(originUrl, "flow_page_cache_param") != null) {
                        Uri build = originUrl.buildUpon().appendQueryParameter("enable_lite_page_annie_cache_param", DiskLruCache.VERSION).build();
                        IAnnieXBizPropsProvider iAnnieXBizPropsProvider = (IAnnieXBizPropsProvider) AnnieX.INSTANCE.getService(this.this$0.getConfig().getBid(), IAnnieXBizPropsProvider.class);
                        Map<String, ? extends Object> cacheParams = iAnnieXBizPropsProvider != null ? iAnnieXBizPropsProvider.getCacheParams(build.toString(), subUrl) : null;
                        this.label = 1;
                        if (this.$loadStateModel.postValue(cacheParams, (Continuation<? super Unit>) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
}
