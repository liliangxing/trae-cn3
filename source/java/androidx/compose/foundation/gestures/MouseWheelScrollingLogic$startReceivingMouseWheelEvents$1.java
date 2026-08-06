package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1", f = "MouseWheelScrollable.kt", i = {0, 1}, l = {107, 110}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(MouseWheelScrollingLogic mouseWheelScrollingLogic, Continuation<? super MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = new MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1(this.this$0, continuation);
        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.L$0 = obj;
        return mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0088 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003f A[Catch: all -> 0x0093, TryCatch #0 {all -> 0x0093, blocks: (B:6:0x0035, B:8:0x003f, B:13:0x0056), top: B:5:0x0035 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0089 -> B:5:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1;
        CoroutineScope coroutineScope;
        Density density;
        float f;
        Density density2;
        float f2;
        ScrollingLogic scrollingLogic;
        Object dispatchMouseWheelScroll;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i != 0) {
                try {
                    if (i == 1) {
                        CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope3 = coroutineScope2;
                        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = this;
                        MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDelta = (MouseWheelScrollingLogic.MouseWheelScrollDelta) obj;
                        density = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.density;
                        f = MouseWheelScrollableKt.AnimationThreshold;
                        float f3 = density.toPx-0680j_4(f);
                        density2 = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.density;
                        f2 = MouseWheelScrollableKt.AnimationSpeed;
                        float f4 = density2.toPx-0680j_4(f2);
                        MouseWheelScrollingLogic mouseWheelScrollingLogic = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0;
                        scrollingLogic = mouseWheelScrollingLogic.scrollingLogic;
                        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.L$0 = coroutineScope3;
                        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.label = 2;
                        dispatchMouseWheelScroll = mouseWheelScrollingLogic.dispatchMouseWheelScroll(scrollingLogic, mouseWheelScrollDelta, f3, f4, (Continuation) mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1);
                        if (dispatchMouseWheelScroll != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope = coroutineScope3;
                        if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
                            channel = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.channel;
                            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.L$0 = coroutineScope;
                            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.label = 1;
                            Object receive = channel.receive((Continuation) mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1);
                            if (receive == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            coroutineScope3 = coroutineScope;
                            obj = receive;
                            MouseWheelScrollingLogic.MouseWheelScrollDelta mouseWheelScrollDelta2 = (MouseWheelScrollingLogic.MouseWheelScrollDelta) obj;
                            density = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.density;
                            f = MouseWheelScrollableKt.AnimationThreshold;
                            float f32 = density.toPx-0680j_4(f);
                            density2 = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.density;
                            f2 = MouseWheelScrollableKt.AnimationSpeed;
                            float f42 = density2.toPx-0680j_4(f2);
                            MouseWheelScrollingLogic mouseWheelScrollingLogic2 = mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0;
                            scrollingLogic = mouseWheelScrollingLogic2.scrollingLogic;
                            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.L$0 = coroutineScope3;
                            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.label = 2;
                            dispatchMouseWheelScroll = mouseWheelScrollingLogic2.dispatchMouseWheelScroll(scrollingLogic, mouseWheelScrollDelta2, f32, f42, (Continuation) mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1);
                            if (dispatchMouseWheelScroll != coroutine_suspended) {
                            }
                        } else {
                            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.receivingMouseWheelEventsJob = null;
                            return Unit.INSTANCE;
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        coroutineScope = coroutineScope4;
                    }
                } catch (Throwable th) {
                    th = th;
                    mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = this;
                    mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.receivingMouseWheelEventsJob = null;
                    throw th;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            }
            if (!JobKt.isActive(coroutineScope.getCoroutineContext())) {
            }
        } catch (Throwable th2) {
            th = th2;
            mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1.this$0.receivingMouseWheelEventsJob = null;
            throw th;
        }
        mouseWheelScrollingLogic$startReceivingMouseWheelEvents$1 = this;
    }
}
