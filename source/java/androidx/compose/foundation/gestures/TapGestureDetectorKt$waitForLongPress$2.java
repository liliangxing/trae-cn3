package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.LongPressResult;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2", f = "TapGestureDetector.kt", i = {0, 1}, l = {386, 409}, m = "invokeSuspend", n = {"$this$withTimeout", "$this$withTimeout"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TapGestureDetectorKt$waitForLongPress$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PointerEventPass $pass;
    final /* synthetic */ Ref.ObjectRef<LongPressResult> $result;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TapGestureDetectorKt$waitForLongPress$2(PointerEventPass pointerEventPass, Ref.ObjectRef<LongPressResult> objectRef, Continuation<? super TapGestureDetectorKt$waitForLongPress$2> continuation) {
        super(2, continuation);
        this.$pass = pointerEventPass;
        this.$result = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> tapGestureDetectorKt$waitForLongPress$2 = new TapGestureDetectorKt$waitForLongPress$2(this.$pass, this.$result, continuation);
        tapGestureDetectorKt$waitForLongPress$2.L$0 = obj;
        return tapGestureDetectorKt$waitForLongPress$2;
    }

    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ed  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00da -> B:6:0x00dd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AwaitPointerEventScope awaitPointerEventScope;
        TapGestureDetectorKt$waitForLongPress$2 tapGestureDetectorKt$waitForLongPress$2;
        AwaitPointerEventScope awaitPointerEventScope2;
        int size;
        int i;
        boolean z;
        boolean z2;
        Object awaitPointerEvent;
        boolean z3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope2 = awaitPointerEventScope3;
                tapGestureDetectorKt$waitForLongPress$2 = this;
                PointerEvent pointerEvent = (PointerEvent) obj;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                size = changes.size();
                i = 0;
                while (true) {
                    if (i >= size) {
                    }
                    i++;
                }
                if (z) {
                }
                return Unit.INSTANCE;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            TapGestureDetectorKt$waitForLongPress$2 tapGestureDetectorKt$waitForLongPress$22 = this;
            List<PointerInputChange> changes2 = ((PointerEvent) obj).getChanges();
            int size2 = changes2.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size2) {
                    z3 = false;
                    break;
                }
                if (changes2.get(i3).isConsumed()) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                awaitPointerEventScope = awaitPointerEventScope4;
                tapGestureDetectorKt$waitForLongPress$2 = tapGestureDetectorKt$waitForLongPress$22;
                tapGestureDetectorKt$waitForLongPress$2.L$0 = awaitPointerEventScope;
                tapGestureDetectorKt$waitForLongPress$2.label = 1;
                awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(tapGestureDetectorKt$waitForLongPress$2.$pass, (Continuation) tapGestureDetectorKt$waitForLongPress$2);
                if (awaitPointerEvent != coroutine_suspended) {
                    return coroutine_suspended;
                }
                awaitPointerEventScope2 = awaitPointerEventScope;
                obj = awaitPointerEvent;
                PointerEvent pointerEvent2 = (PointerEvent) obj;
                List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                size = changes3.size();
                i = 0;
                while (true) {
                    if (i >= size) {
                        z = true;
                        break;
                    }
                    if (!PointerEventKt.changedToUp(changes3.get(i))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    tapGestureDetectorKt$waitForLongPress$2.$result.element = new LongPressResult.Released(pointerEvent2.getChanges().get(0));
                } else if (TapGestureDetector_androidKt.isDeepPress(pointerEvent2)) {
                    tapGestureDetectorKt$waitForLongPress$2.$result.element = LongPressResult.Success.INSTANCE;
                } else {
                    List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                    int size3 = changes4.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size3) {
                            z2 = false;
                            break;
                        }
                        PointerInputChange pointerInputChange = changes4.get(i4);
                        if (pointerInputChange.isConsumed() || PointerEventKt.m6087isOutOfBoundsjwHxaWs(pointerInputChange, awaitPointerEventScope2.mo6048getSizeYbymL2g(), awaitPointerEventScope2.mo6047getExtendedTouchPaddingNHjbRc())) {
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                    if (z2) {
                        tapGestureDetectorKt$waitForLongPress$2.$result.element = LongPressResult.Canceled.INSTANCE;
                    } else {
                        tapGestureDetectorKt$waitForLongPress$2.L$0 = awaitPointerEventScope2;
                        tapGestureDetectorKt$waitForLongPress$2.label = 2;
                        obj = awaitPointerEventScope2.awaitPointerEvent(PointerEventPass.Final, (Continuation) tapGestureDetectorKt$waitForLongPress$2);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        AwaitPointerEventScope awaitPointerEventScope5 = awaitPointerEventScope2;
                        tapGestureDetectorKt$waitForLongPress$22 = tapGestureDetectorKt$waitForLongPress$2;
                        awaitPointerEventScope4 = awaitPointerEventScope5;
                        List<PointerInputChange> changes22 = ((PointerEvent) obj).getChanges();
                        int size22 = changes22.size();
                        int i32 = 0;
                        while (true) {
                            if (i32 >= size22) {
                            }
                            i32++;
                        }
                        if (z3) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            tapGestureDetectorKt$waitForLongPress$22.$result.element = LongPressResult.Canceled.INSTANCE;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
        tapGestureDetectorKt$waitForLongPress$2 = this;
        tapGestureDetectorKt$waitForLongPress$2.L$0 = awaitPointerEventScope;
        tapGestureDetectorKt$waitForLongPress$2.label = 1;
        awaitPointerEvent = awaitPointerEventScope.awaitPointerEvent(tapGestureDetectorKt$waitForLongPress$2.$pass, (Continuation) tapGestureDetectorKt$waitForLongPress$2);
        if (awaitPointerEvent != coroutine_suspended) {
        }
    }
}
