package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitSecondDown$2", f = "TapGestureDetector.kt", i = {0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull", "minUptime"}, s = {"L$0", "J$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TapGestureDetectorKt$awaitSecondDown$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super PointerInputChange>, Object> {
    final /* synthetic */ PointerInputChange $firstUp;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$awaitSecondDown$2(PointerInputChange pointerInputChange, Continuation<? super TapGestureDetectorKt$awaitSecondDown$2> continuation) {
        super(2, continuation);
        this.$firstUp = pointerInputChange;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tapGestureDetectorKt$awaitSecondDown$2 = new TapGestureDetectorKt$awaitSecondDown$2(this.$firstUp, continuation);
        tapGestureDetectorKt$awaitSecondDown$2.L$0 = obj;
        return tapGestureDetectorKt$awaitSecondDown$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super PointerInputChange> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004f -> B:5:0x0054). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        long uptimeMillis;
        TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$2;
        Object awaitFirstDown$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AwaitPointerEventScope awaitPointerEventScope2 = (AwaitPointerEventScope) this.L$0;
            awaitPointerEventScope = awaitPointerEventScope2;
            uptimeMillis = this.$firstUp.getUptimeMillis() + awaitPointerEventScope2.getViewConfiguration().getDoubleTapMinTimeMillis();
            tapGestureDetectorKt$awaitSecondDown$2 = this;
            tapGestureDetectorKt$awaitSecondDown$2.L$0 = awaitPointerEventScope;
            tapGestureDetectorKt$awaitSecondDown$2.J$0 = uptimeMillis;
            tapGestureDetectorKt$awaitSecondDown$2.label = 1;
            awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, (Continuation) tapGestureDetectorKt$awaitSecondDown$2, 3, null);
            if (awaitFirstDown$default != coroutine_suspended) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j = this.J$0;
            AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            uptimeMillis = j;
            AwaitPointerEventScope awaitPointerEventScope4 = awaitPointerEventScope3;
            Object obj2 = coroutine_suspended;
            TapGestureDetectorKt$awaitSecondDown$2 tapGestureDetectorKt$awaitSecondDown$22 = this;
            PointerInputChange pointerInputChange = (PointerInputChange) obj;
            if (pointerInputChange.getUptimeMillis() < uptimeMillis) {
                return pointerInputChange;
            }
            tapGestureDetectorKt$awaitSecondDown$2 = tapGestureDetectorKt$awaitSecondDown$22;
            coroutine_suspended = obj2;
            awaitPointerEventScope = awaitPointerEventScope4;
            tapGestureDetectorKt$awaitSecondDown$2.L$0 = awaitPointerEventScope;
            tapGestureDetectorKt$awaitSecondDown$2.J$0 = uptimeMillis;
            tapGestureDetectorKt$awaitSecondDown$2.label = 1;
            awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, (Continuation) tapGestureDetectorKt$awaitSecondDown$2, 3, null);
            if (awaitFirstDown$default != coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj3 = coroutine_suspended;
            tapGestureDetectorKt$awaitSecondDown$22 = tapGestureDetectorKt$awaitSecondDown$2;
            obj = awaitFirstDown$default;
            awaitPointerEventScope4 = awaitPointerEventScope;
            obj2 = obj3;
            PointerInputChange pointerInputChange2 = (PointerInputChange) obj;
            if (pointerInputChange2.getUptimeMillis() < uptimeMillis) {
            }
        }
    }
}
