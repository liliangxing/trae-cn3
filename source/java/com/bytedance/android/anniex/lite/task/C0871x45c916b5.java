package com.bytedance.android.anniex.lite.task;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.api.AnnieXApi;
import com.bytedance.android.anniex.engine.AnnieXLynxEngine;
import com.bytedance.android.anniex.lite.model.AnnieXLynxPreloadStateModel;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.lynx.service.BaseLynxGlobalConfigService;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.lynx.tasm.TemplateBundle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: Collect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", StrategyConstants.VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 3})
/* renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0871x45c916b5 implements FlowCollector<AnnieXLynxModel> {
    final /* synthetic */ CoroutineScope $$this$launch$inlined;
    final /* synthetic */ AnnieXLynxPreloadStateModel $loadStateModel$inlined;
    final /* synthetic */ AnnieXLynxEnginePreloadTask this$0;

    /* compiled from: Collect.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\u0007"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, StrategyConstants.VALUE, "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1", f = "AnnieXLynxEnginePreloadTask.kt", i = {0, 0, 0}, l = {136}, m = "emit", n = {"this", "_model", "engine"}, s = {"L$0", "L$1", "L$2"})
    /* renamed from: com.bytedance.android.anniex.lite.task.AnnieXLynxEnginePreloadTask$work$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return C0871x45c916b5.this.emit(null, this);
        }
    }

    public C0871x45c916b5(AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel, CoroutineScope coroutineScope, AnnieXLynxEnginePreloadTask annieXLynxEnginePreloadTask) {
        this.$loadStateModel$inlined = annieXLynxPreloadStateModel;
        this.$$this$launch$inlined = coroutineScope;
        this.this$0 = annieXLynxEnginePreloadTask;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(Object obj, Continuation continuation) {
        AnonymousClass1 anonymousClass1;
        int i;
        C0871x45c916b5 c0871x45c916b5;
        AnnieXLynxModel annieXLynxModel;
        AnnieXLynxEngine annieXLynxEngine;
        TemplateBundle templateBundleByUrl;
        ContextProviderFactory contextProviderFactory;
        ContextProviderFactory contextProviderFactory2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
                Object obj2 = anonymousClass1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = anonymousClass1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    AnnieXLynxModel annieXLynxModel2 = (AnnieXLynxModel) obj;
                    Application application = BulletEnv.Companion.getInstance().getApplication();
                    if (application != null && annieXLynxModel2 != null) {
                        AnnieXLynxEngine createNewLynxEngine$anniex_release = AnnieXApi.INSTANCE.createNewLynxEngine$anniex_release(application, annieXLynxModel2, null);
                        AnnieXLynxPreloadStateModel annieXLynxPreloadStateModel = this.$loadStateModel$inlined;
                        anonymousClass1.L$0 = this;
                        anonymousClass1.L$1 = annieXLynxModel2;
                        anonymousClass1.L$2 = createNewLynxEngine$anniex_release;
                        anonymousClass1.label = 1;
                        if (annieXLynxPreloadStateModel.postValue(createNewLynxEngine$anniex_release, (Continuation<? super Unit>) anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        c0871x45c916b5 = this;
                        annieXLynxModel = annieXLynxModel2;
                        annieXLynxEngine = createNewLynxEngine$anniex_release;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                annieXLynxEngine = (AnnieXLynxEngine) anonymousClass1.L$2;
                annieXLynxModel = (AnnieXLynxModel) anonymousClass1.L$1;
                c0871x45c916b5 = (C0871x45c916b5) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj2);
                CoroutineScope coroutineScope = c0871x45c916b5.$$this$launch$inlined;
                BaseLynxGlobalConfigService baseLynxGlobalConfigService = ServiceCenter.Companion.instance().get(annieXLynxModel.getBid(), ILynxGlobalConfigService.class);
                BaseLynxGlobalConfigService baseLynxGlobalConfigService2 = !(baseLynxGlobalConfigService instanceof BaseLynxGlobalConfigService) ? baseLynxGlobalConfigService : null;
                if (!IConditionCallKt.getEnableLitePageBidOpt()) {
                    baseLynxGlobalConfigService2 = null;
                }
                templateBundleByUrl = baseLynxGlobalConfigService2 != null ? baseLynxGlobalConfigService2.getTemplateBundleByUrl(annieXLynxModel.getUrl()) : null;
                if (templateBundleByUrl != null) {
                    contextProviderFactory2 = c0871x45c916b5.this$0.contextProviderFactory;
                    contextProviderFactory2.registerHolder(TemplateBundle.class, templateBundleByUrl);
                }
                contextProviderFactory = c0871x45c916b5.this$0.contextProviderFactory;
                annieXLynxEngine.load$anniex_release(annieXLynxModel, contextProviderFactory);
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj22 = anonymousClass1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = anonymousClass1.label;
        if (i != 0) {
        }
        CoroutineScope coroutineScope2 = c0871x45c916b5.$$this$launch$inlined;
        BaseLynxGlobalConfigService baseLynxGlobalConfigService3 = ServiceCenter.Companion.instance().get(annieXLynxModel.getBid(), ILynxGlobalConfigService.class);
        if (!(baseLynxGlobalConfigService3 instanceof BaseLynxGlobalConfigService)) {
        }
        if (!IConditionCallKt.getEnableLitePageBidOpt()) {
        }
        if (baseLynxGlobalConfigService2 != null) {
        }
        if (templateBundleByUrl != null) {
        }
        contextProviderFactory = c0871x45c916b5.this$0.contextProviderFactory;
        annieXLynxEngine.load$anniex_release(annieXLynxModel, contextProviderFactory);
        return Unit.INSTANCE;
    }
}
