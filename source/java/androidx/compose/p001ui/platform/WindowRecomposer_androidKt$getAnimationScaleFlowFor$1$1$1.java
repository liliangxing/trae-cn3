package androidx.compose.p001ui.platform;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: WindowRecomposer.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1", f = "WindowRecomposer.android.kt", i = {0, 1}, l = {118, 125}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 extends SuspendLambda implements Function2<FlowCollector<? super Float>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $animationScaleUri;
    final /* synthetic */ Context $applicationContext;
    final /* synthetic */ Channel<Unit> $channel;
    final /* synthetic */ C0052x23580bd9 $contentObserver;
    final /* synthetic */ ContentResolver $resolver;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(ContentResolver contentResolver, Uri uri, C0052x23580bd9 c0052x23580bd9, Channel<Unit> channel, Context context, Continuation<? super WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1> continuation) {
        super(2, continuation);
        this.$resolver = contentResolver;
        this.$animationScaleUri = uri;
        this.$contentObserver = c0052x23580bd9;
        this.$channel = channel;
        this.$applicationContext = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = new WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1(this.$resolver, this.$animationScaleUri, this.$contentObserver, this.$channel, this.$applicationContext, continuation);
        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = obj;
        return windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
    }

    public final Object invoke(FlowCollector<? super Float> flowCollector, Continuation<? super Unit> continuation) {
        return create(flowCollector, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[Catch: all -> 0x0099, TRY_LEAVE, TryCatch #0 {all -> 0x0099, blocks: (B:11:0x004b, B:16:0x005e, B:18:0x0066), top: B:10:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008b -> B:10:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        WindowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1;
        FlowCollector flowCollector;
        ChannelIterator it;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    flowCollector = (FlowCollector) this.L$0;
                    this.$resolver.registerContentObserver(this.$animationScaleUri, false, this.$contentObserver);
                    it = this.$channel.iterator();
                } else if (i == 1) {
                    it = (ChannelIterator) this.L$1;
                    FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    FlowCollector flowCollector3 = flowCollector2;
                    windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = this;
                    if (!((Boolean) obj).booleanValue()) {
                        it.next();
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = flowCollector3;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$1 = it;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.label = 2;
                        if (flowCollector3.emit(Boxing.boxFloat(Settings.Global.getFloat(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$applicationContext.getContentResolver(), "animator_duration_scale", 1.0f)), (Continuation) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector3;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = flowCollector;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$1 = it;
                        windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.label = 1;
                        hasNext = it.hasNext((Continuation) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1);
                        if (hasNext != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector3 = flowCollector;
                        obj = hasNext;
                        if (!((Boolean) obj).booleanValue()) {
                            windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$resolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$contentObserver);
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (ChannelIterator) this.L$1;
                    FlowCollector flowCollector4 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector4;
                }
                windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$0 = flowCollector;
                windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.L$1 = it;
                windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.label = 1;
                hasNext = it.hasNext((Continuation) windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1);
                if (hasNext != coroutine_suspended) {
                }
            } catch (Throwable th) {
                th = th;
                windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$resolver.unregisterContentObserver(windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1.$contentObserver);
                throw th;
            }
            windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = this;
        } catch (Throwable th2) {
            th = th2;
            windowRecomposer_androidKt$getAnimationScaleFlowFor$1$1$1 = this;
        }
    }
}
