package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MouseWheelScrollable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.MouseWheelScrollingLogic", f = "MouseWheelScrollable.kt", i = {0, 0, 0}, l = {244, 295}, m = "dispatchMouseWheelScroll", n = {"$this$dispatchMouseWheelScroll", "targetValue", "speed"}, s = {"L$0", "L$1", "F$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MouseWheelScrollingLogic$dispatchMouseWheelScroll$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MouseWheelScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MouseWheelScrollingLogic$dispatchMouseWheelScroll$1(MouseWheelScrollingLogic mouseWheelScrollingLogic, Continuation<? super MouseWheelScrollingLogic$dispatchMouseWheelScroll$1> continuation) {
        super(continuation);
        this.this$0 = mouseWheelScrollingLogic;
    }

    public final Object invokeSuspend(Object obj) {
        Object dispatchMouseWheelScroll;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        dispatchMouseWheelScroll = this.this$0.dispatchMouseWheelScroll(null, null, 0.0f, 0.0f, (Continuation) this);
        return dispatchMouseWheelScroll;
    }
}
