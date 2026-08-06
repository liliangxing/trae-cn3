package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/gestures/MouseWheelScrollingLogic$MouseWheelScrollDelta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2", f = "MouseWheelScrollable.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: androidx.compose.foundation.gestures.MouseWheelScrollingLogic$dispatchMouseWheelScroll$waitNextScrollDelta$2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0272x7147264f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MouseWheelScrollingLogic.MouseWheelScrollDelta>, Object> {
    int label;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0272x7147264f(MouseWheelScrollingLogic mouseWheelScrollingLogic, Continuation<? super C0272x7147264f> continuation) {
        super(2, continuation);
        this.this$0 = mouseWheelScrollingLogic;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0272x7147264f(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super MouseWheelScrollingLogic.MouseWheelScrollDelta> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MouseWheelScrollingLogic mouseWheelScrollingLogic = this.this$0;
            channel = mouseWheelScrollingLogic.channel;
            this.label = 1;
            obj = mouseWheelScrollingLogic.busyReceive(channel, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
