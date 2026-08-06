package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.TransformEvent;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerEventType;
import androidx.compose.p002ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* compiled from: Transformable.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u001a(\u0010\f\u001a\u00020\r*\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u00020\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u0004\u0018\u00010\t*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0019\u001a\u00020\r*\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\bH\u0082@¢\u0006\u0002\u0010\u001b\"\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"transformable", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/gestures/TransformableState;", "lockRotationOnZoomPan", "", "enabled", "canPan", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "SCROLL_FACTOR", "", "detectZoomByCtrlMouseScroll", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "channel", "Lkotlinx/coroutines/channels/Channel;", "Landroidx/compose/foundation/gestures/TransformEvent;", "scrollConfig", "Landroidx/compose/foundation/gestures/ScrollConfig;", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlinx/coroutines/channels/Channel;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstCtrlMouseScroll", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/foundation/gestures/ScrollConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitCtrlMouseScrollOrNull", "detectZoom", "panZoomLock", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;ZLkotlinx/coroutines/channels/Channel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TransformableKt {
    public static final float SCROLL_FACTOR = 545.0f;

    public static final /* synthetic */ Object access$detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel channel, Function1 function1, Continuation continuation) {
        return detectZoom(awaitPointerEventScope, z, channel, function1, continuation);
    }

    public static final /* synthetic */ Object access$detectZoomByCtrlMouseScroll(PointerInputScope pointerInputScope, Channel channel, ScrollConfig scrollConfig, Continuation continuation) {
        return detectZoomByCtrlMouseScroll(pointerInputScope, channel, scrollConfig, continuation);
    }

    public static final boolean transformable$lambda$0(Offset offset) {
        return true;
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, boolean z, boolean z2) {
        return transformable(modifier, transformableState, new Function1() { // from class: androidx.compose.foundation.gestures.TransformableKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean transformable$lambda$0;
                transformable$lambda$0 = TransformableKt.transformable$lambda$0((Offset) obj);
                return Boolean.valueOf(transformable$lambda$0);
            }
        }, z, z2);
    }

    public static /* synthetic */ Modifier transformable$default(Modifier modifier, TransformableState transformableState, Function1 function1, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = true;
        }
        return transformable(modifier, transformableState, function1, z, z2);
    }

    public static final Modifier transformable(Modifier modifier, TransformableState transformableState, Function1<? super Offset, Boolean> function1, boolean z, boolean z2) {
        return modifier.then((Modifier) new TransformableElement(transformableState, function1, z, z2));
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x004a -> B:10:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.Object awaitFirstCtrlMouseScroll(androidx.compose.p002ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation<? super androidx.compose.p002ui.geometry.Offset> r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            if (r0 == 0) goto L14
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = (androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$1
            androidx.compose.foundation.gestures.ScrollConfig r5 = (androidx.compose.foundation.gestures.ScrollConfig) r5
            java.lang.Object r6 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.p002ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.throwOnFailure(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L4d
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
        L40:
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r7 = awaitCtrlMouseScrollOrNull(r5, r6, r0)
            if (r7 != r1) goto L4d
            return r1
        L4d:
            androidx.compose.ui.geometry.Offset r7 = (androidx.compose.p002ui.geometry.Offset) r7
            if (r7 == 0) goto L40
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.awaitFirstCtrlMouseScroll(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCtrlMouseScrollOrNull(AwaitPointerEventScope awaitPointerEventScope, ScrollConfig scrollConfig, Continuation<? super Offset> continuation) {
        TransformableKt$awaitCtrlMouseScrollOrNull$1 transformableKt$awaitCtrlMouseScrollOrNull$1;
        int i;
        PointerEvent pointerEvent;
        if (continuation instanceof TransformableKt$awaitCtrlMouseScrollOrNull$1) {
            transformableKt$awaitCtrlMouseScrollOrNull$1 = (TransformableKt$awaitCtrlMouseScrollOrNull$1) continuation;
            if ((transformableKt$awaitCtrlMouseScrollOrNull$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$awaitCtrlMouseScrollOrNull$1.label -= Integer.MIN_VALUE;
                Object obj = transformableKt$awaitCtrlMouseScrollOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformableKt$awaitCtrlMouseScrollOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    transformableKt$awaitCtrlMouseScrollOrNull$1.L$0 = awaitPointerEventScope;
                    transformableKt$awaitCtrlMouseScrollOrNull$1.L$1 = scrollConfig;
                    transformableKt$awaitCtrlMouseScrollOrNull$1.label = 1;
                    obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, null, transformableKt$awaitCtrlMouseScrollOrNull$1, 1, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    scrollConfig = (ScrollConfig) transformableKt$awaitCtrlMouseScrollOrNull$1.L$1;
                    awaitPointerEventScope = (AwaitPointerEventScope) transformableKt$awaitCtrlMouseScrollOrNull$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pointerEvent = (PointerEvent) obj;
                if (PointerEvent_androidKt.m6109isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers()) || !PointerEventType.m6091equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m6100getScroll7fucELk())) {
                    return null;
                }
                long mo636calculateMouseWheelScroll8xgXZGE = scrollConfig.mo636calculateMouseWheelScroll8xgXZGE(awaitPointerEventScope, pointerEvent, awaitPointerEventScope.mo6048getSizeYbymL2g());
                if (Offset.m4590equalsimpl0(mo636calculateMouseWheelScroll8xgXZGE, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                    return null;
                }
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                for (int i2 = 0; i2 < size; i2++) {
                    changes.get(i2).consume();
                }
                return Offset.m4582boximpl(mo636calculateMouseWheelScroll8xgXZGE);
            }
        }
        transformableKt$awaitCtrlMouseScrollOrNull$1 = new TransformableKt$awaitCtrlMouseScrollOrNull$1(continuation);
        Object obj2 = transformableKt$awaitCtrlMouseScrollOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformableKt$awaitCtrlMouseScrollOrNull$1.label;
        if (i != 0) {
        }
        pointerEvent = (PointerEvent) obj2;
        if (PointerEvent_androidKt.m6109isCtrlPressed5xRPYO0(pointerEvent.getKeyboardModifiers())) {
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0204, code lost:
    
        if (((java.lang.Boolean) r13.invoke(androidx.compose.p002ui.geometry.Offset.m4582boximpl(r1))).booleanValue() != false) goto L196;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x028e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x028f -> B:12:0x029c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object detectZoom(AwaitPointerEventScope awaitPointerEventScope, boolean z, Channel<TransformEvent> channel, Function1<? super Offset, Boolean> function1, Continuation<? super Unit> continuation) {
        TransformableKt$detectZoom$1 transformableKt$detectZoom$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        AwaitPointerEventScope awaitPointerEventScope2;
        Channel<TransformEvent> channel2;
        Function1<? super Offset, Boolean> function12;
        boolean z2;
        float f;
        long j;
        int i2;
        int i3;
        float f2;
        float f3;
        AwaitPointerEventScope awaitPointerEventScope3;
        float f4;
        Channel<TransformEvent> channel3;
        int size;
        int i4;
        int i5;
        TransformableKt$detectZoom$1 transformableKt$detectZoom$12;
        int i6;
        int i7;
        float f5;
        long j2;
        int i8;
        int i9;
        Object awaitPointerEvent;
        boolean z3;
        PointerEvent pointerEvent;
        float f6;
        float f7;
        int i10;
        Channel<TransformEvent> channel4;
        Object obj2;
        float f8;
        int i11;
        long j3;
        float f9;
        float f10;
        int size2;
        int i12;
        int size3;
        int i13;
        boolean z4;
        int size4;
        int i14;
        boolean z5;
        if (continuation instanceof TransformableKt$detectZoom$1) {
            transformableKt$detectZoom$1 = (TransformableKt$detectZoom$1) continuation;
            if ((transformableKt$detectZoom$1.label & Integer.MIN_VALUE) != 0) {
                transformableKt$detectZoom$1.label -= Integer.MIN_VALUE;
                obj = transformableKt$detectZoom$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = transformableKt$detectZoom$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    long m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
                    float touchSlop = awaitPointerEventScope.getViewConfiguration().getTouchSlop();
                    awaitPointerEventScope2 = awaitPointerEventScope;
                    transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
                    channel2 = channel;
                    transformableKt$detectZoom$1.L$1 = channel2;
                    function12 = function1;
                    transformableKt$detectZoom$1.L$2 = function12;
                    z2 = z;
                    transformableKt$detectZoom$1.Z$0 = z2;
                    transformableKt$detectZoom$1.F$0 = 0.0f;
                    transformableKt$detectZoom$1.F$1 = 1.0f;
                    transformableKt$detectZoom$1.J$0 = m4609getZeroF1C5BW0;
                    transformableKt$detectZoom$1.I$0 = 0;
                    transformableKt$detectZoom$1.F$2 = touchSlop;
                    transformableKt$detectZoom$1.I$1 = 0;
                    transformableKt$detectZoom$1.label = 1;
                    if (TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, transformableKt$detectZoom$1, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    f = touchSlop;
                    j = m4609getZeroF1C5BW0;
                    i2 = 0;
                    i3 = 0;
                    f2 = 1.0f;
                    f3 = 0.0f;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i15 = transformableKt$detectZoom$1.I$2;
                            i10 = transformableKt$detectZoom$1.I$1;
                            f7 = transformableKt$detectZoom$1.F$2;
                            i8 = transformableKt$detectZoom$1.I$0;
                            j2 = transformableKt$detectZoom$1.J$0;
                            float f11 = transformableKt$detectZoom$1.F$1;
                            float f12 = transformableKt$detectZoom$1.F$0;
                            boolean z6 = transformableKt$detectZoom$1.Z$0;
                            pointerEvent = (PointerEvent) transformableKt$detectZoom$1.L$3;
                            function12 = (Function1) transformableKt$detectZoom$1.L$2;
                            Channel<TransformEvent> channel5 = (Channel) transformableKt$detectZoom$1.L$1;
                            awaitPointerEventScope3 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            z3 = z6;
                            f4 = f12;
                            channel4 = channel5;
                            obj2 = coroutine_suspended;
                            f6 = f11;
                            i9 = i15;
                            awaitPointerEvent = obj;
                            List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent).getChanges();
                            size3 = changes.size();
                            TransformableKt$detectZoom$1 transformableKt$detectZoom$13 = transformableKt$detectZoom$1;
                            i13 = 0;
                            while (true) {
                                if (i13 >= size3) {
                                    z4 = false;
                                    break;
                                }
                                if (changes.get(i13).isConsumed()) {
                                    z4 = true;
                                    break;
                                }
                                i13++;
                            }
                            boolean z7 = !z4 && i8 == 0;
                            if (i9 == 0 && !z7) {
                                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                                size4 = changes2.size();
                                i14 = 0;
                                while (true) {
                                    if (i14 >= size4) {
                                        z5 = false;
                                        break;
                                    }
                                    if (changes2.get(i14).getPressed()) {
                                        z5 = true;
                                        break;
                                    }
                                    i14++;
                                }
                                if (z5) {
                                    transformableKt$detectZoom$1 = transformableKt$detectZoom$13;
                                    i2 = i10;
                                    f = f7;
                                    i3 = i8;
                                    j = j2;
                                    f2 = f6;
                                    coroutine_suspended = obj2;
                                    f3 = f4;
                                    awaitPointerEventScope2 = awaitPointerEventScope3;
                                    z2 = z3;
                                    channel2 = channel4;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        i2 = transformableKt$detectZoom$1.I$1;
                        f = transformableKt$detectZoom$1.F$2;
                        i3 = transformableKt$detectZoom$1.I$0;
                        j = transformableKt$detectZoom$1.J$0;
                        f2 = transformableKt$detectZoom$1.F$1;
                        float f13 = transformableKt$detectZoom$1.F$0;
                        boolean z8 = transformableKt$detectZoom$1.Z$0;
                        Function1<? super Offset, Boolean> function13 = (Function1) transformableKt$detectZoom$1.L$2;
                        Channel<TransformEvent> channel6 = (Channel) transformableKt$detectZoom$1.L$1;
                        AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        z2 = z8;
                        f4 = f13;
                        channel3 = channel6;
                        awaitPointerEventScope3 = awaitPointerEventScope4;
                        function12 = function13;
                        PointerEvent pointerEvent2 = (PointerEvent) obj;
                        List<PointerInputChange> changes3 = pointerEvent2.getChanges();
                        size = changes3.size();
                        int i16 = i2;
                        i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                i5 = 0;
                                break;
                            }
                            if (changes3.get(i4).isConsumed()) {
                                i5 = 1;
                                break;
                            }
                            i4++;
                        }
                        if (i5 != 0) {
                            float calculateZoom = TransformGestureDetectorKt.calculateZoom(pointerEvent2);
                            float calculateRotation = TransformGestureDetectorKt.calculateRotation(pointerEvent2);
                            transformableKt$detectZoom$12 = transformableKt$detectZoom$1;
                            i6 = i5;
                            long calculatePan = TransformGestureDetectorKt.calculatePan(pointerEvent2);
                            if (i3 == 0) {
                                f2 *= calculateZoom;
                                f4 += calculateRotation;
                                j = Offset.m4598plusMKHz9U(j, calculatePan);
                                int i17 = i3;
                                float calculateCentroidSize = TransformGestureDetectorKt.calculateCentroidSize(pointerEvent2, false);
                                f8 = calculateRotation;
                                float abs = Math.abs(1 - f2) * calculateCentroidSize;
                                float abs2 = Math.abs(((3.1415927f * f4) * calculateCentroidSize) / 180.0f);
                                float m4591getDistanceimpl = Offset.m4591getDistanceimpl(j);
                                if (abs > f || abs2 > f || (m4591getDistanceimpl > f && ((Boolean) function12.invoke(Offset.m4582boximpl(calculatePan))).booleanValue())) {
                                    i7 = (!z2 || abs2 >= f) ? 0 : 1;
                                    channel3.trySend-JP2dKIU(TransformEvent.TransformStarted.INSTANCE);
                                    i3 = 1;
                                } else {
                                    i7 = i16;
                                    i3 = i17;
                                }
                            } else {
                                f8 = calculateRotation;
                                i7 = i16;
                            }
                            if (i3 == 0) {
                                i11 = i3;
                                j3 = j;
                            } else {
                                if (i7 != 0) {
                                    f10 = 0.0f;
                                    f9 = 0.0f;
                                } else {
                                    f9 = f8;
                                    f10 = 0.0f;
                                }
                                if (!(f9 == f10)) {
                                    i11 = i3;
                                    j3 = j;
                                } else if (calculateZoom == 1.0f) {
                                    i11 = i3;
                                    j3 = j;
                                    if (!Offset.m4590equalsimpl0(calculatePan, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                                    }
                                    List<PointerInputChange> changes4 = pointerEvent2.getChanges();
                                    size2 = changes4.size();
                                    for (i12 = 0; i12 < size2; i12++) {
                                        PointerInputChange pointerInputChange = changes4.get(i12);
                                        if (PointerEventKt.positionChanged(pointerInputChange)) {
                                            pointerInputChange.consume();
                                        }
                                    }
                                } else {
                                    i11 = i3;
                                    j3 = j;
                                }
                                channel3.trySend-JP2dKIU(new TransformEvent.TransformDelta(calculateZoom, calculatePan, f9, null));
                                List<PointerInputChange> changes42 = pointerEvent2.getChanges();
                                size2 = changes42.size();
                                while (i12 < size2) {
                                }
                            }
                            i8 = i11;
                            f5 = f2;
                            j2 = j3;
                        } else {
                            transformableKt$detectZoom$12 = transformableKt$detectZoom$1;
                            i6 = i5;
                            ChannelResult.box-impl(channel3.trySend-JP2dKIU(TransformEvent.TransformStopped.INSTANCE));
                            i7 = i16;
                            f5 = f2;
                            j2 = j;
                            i8 = i3;
                        }
                        PointerEventPass pointerEventPass = PointerEventPass.Final;
                        TransformableKt$detectZoom$1 transformableKt$detectZoom$14 = transformableKt$detectZoom$12;
                        transformableKt$detectZoom$14.L$0 = awaitPointerEventScope3;
                        transformableKt$detectZoom$14.L$1 = channel3;
                        transformableKt$detectZoom$14.L$2 = function12;
                        transformableKt$detectZoom$14.L$3 = pointerEvent2;
                        transformableKt$detectZoom$14.Z$0 = z2;
                        transformableKt$detectZoom$14.F$0 = f4;
                        transformableKt$detectZoom$14.F$1 = f5;
                        transformableKt$detectZoom$14.J$0 = j2;
                        transformableKt$detectZoom$14.I$0 = i8;
                        transformableKt$detectZoom$14.F$2 = f;
                        transformableKt$detectZoom$14.I$1 = i7;
                        i9 = i6;
                        transformableKt$detectZoom$14.I$2 = i9;
                        transformableKt$detectZoom$14.label = 3;
                        awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass, transformableKt$detectZoom$14);
                        if (awaitPointerEvent != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z3 = z2;
                        pointerEvent = pointerEvent2;
                        Object obj3 = coroutine_suspended;
                        f6 = f5;
                        transformableKt$detectZoom$1 = transformableKt$detectZoom$14;
                        f7 = f;
                        i10 = i7;
                        channel4 = channel3;
                        obj2 = obj3;
                        List<PointerInputChange> changes5 = ((PointerEvent) awaitPointerEvent).getChanges();
                        size3 = changes5.size();
                        TransformableKt$detectZoom$1 transformableKt$detectZoom$132 = transformableKt$detectZoom$1;
                        i13 = 0;
                        while (true) {
                            if (i13 >= size3) {
                            }
                            i13++;
                        }
                        if (z4) {
                        }
                        if (i9 == 0) {
                            List<PointerInputChange> changes22 = pointerEvent.getChanges();
                            size4 = changes22.size();
                            i14 = 0;
                            while (true) {
                                if (i14 >= size4) {
                                }
                                i14++;
                            }
                            if (z5) {
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    i2 = transformableKt$detectZoom$1.I$1;
                    f = transformableKt$detectZoom$1.F$2;
                    i3 = transformableKt$detectZoom$1.I$0;
                    j = transformableKt$detectZoom$1.J$0;
                    f2 = transformableKt$detectZoom$1.F$1;
                    f3 = transformableKt$detectZoom$1.F$0;
                    boolean z9 = transformableKt$detectZoom$1.Z$0;
                    Function1<? super Offset, Boolean> function14 = (Function1) transformableKt$detectZoom$1.L$2;
                    channel2 = (Channel) transformableKt$detectZoom$1.L$1;
                    AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) transformableKt$detectZoom$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z2 = z9;
                    function12 = function14;
                    awaitPointerEventScope2 = awaitPointerEventScope5;
                }
                transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
                transformableKt$detectZoom$1.L$1 = channel2;
                transformableKt$detectZoom$1.L$2 = function12;
                transformableKt$detectZoom$1.L$3 = null;
                transformableKt$detectZoom$1.Z$0 = z2;
                transformableKt$detectZoom$1.F$0 = f3;
                transformableKt$detectZoom$1.F$1 = f2;
                transformableKt$detectZoom$1.J$0 = j;
                transformableKt$detectZoom$1.I$0 = i3;
                transformableKt$detectZoom$1.F$2 = f;
                transformableKt$detectZoom$1.I$1 = i2;
                transformableKt$detectZoom$1.label = 2;
                obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$1, 1, null);
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                AwaitPointerEventScope awaitPointerEventScope6 = awaitPointerEventScope2;
                f4 = f3;
                channel3 = channel2;
                awaitPointerEventScope3 = awaitPointerEventScope6;
                PointerEvent pointerEvent22 = (PointerEvent) obj;
                List<PointerInputChange> changes32 = pointerEvent22.getChanges();
                size = changes32.size();
                int i162 = i2;
                i4 = 0;
                while (true) {
                    if (i4 >= size) {
                    }
                    i4++;
                }
                if (i5 != 0) {
                }
                PointerEventPass pointerEventPass2 = PointerEventPass.Final;
                TransformableKt$detectZoom$1 transformableKt$detectZoom$142 = transformableKt$detectZoom$12;
                transformableKt$detectZoom$142.L$0 = awaitPointerEventScope3;
                transformableKt$detectZoom$142.L$1 = channel3;
                transformableKt$detectZoom$142.L$2 = function12;
                transformableKt$detectZoom$142.L$3 = pointerEvent22;
                transformableKt$detectZoom$142.Z$0 = z2;
                transformableKt$detectZoom$142.F$0 = f4;
                transformableKt$detectZoom$142.F$1 = f5;
                transformableKt$detectZoom$142.J$0 = j2;
                transformableKt$detectZoom$142.I$0 = i8;
                transformableKt$detectZoom$142.F$2 = f;
                transformableKt$detectZoom$142.I$1 = i7;
                i9 = i6;
                transformableKt$detectZoom$142.I$2 = i9;
                transformableKt$detectZoom$142.label = 3;
                awaitPointerEvent = awaitPointerEventScope3.awaitPointerEvent(pointerEventPass2, transformableKt$detectZoom$142);
                if (awaitPointerEvent != coroutine_suspended) {
                }
            }
        }
        transformableKt$detectZoom$1 = new TransformableKt$detectZoom$1(continuation);
        obj = transformableKt$detectZoom$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = transformableKt$detectZoom$1.label;
        if (i != 0) {
        }
        transformableKt$detectZoom$1.L$0 = awaitPointerEventScope2;
        transformableKt$detectZoom$1.L$1 = channel2;
        transformableKt$detectZoom$1.L$2 = function12;
        transformableKt$detectZoom$1.L$3 = null;
        transformableKt$detectZoom$1.Z$0 = z2;
        transformableKt$detectZoom$1.F$0 = f3;
        transformableKt$detectZoom$1.F$1 = f2;
        transformableKt$detectZoom$1.J$0 = j;
        transformableKt$detectZoom$1.I$0 = i3;
        transformableKt$detectZoom$1.F$2 = f;
        transformableKt$detectZoom$1.I$1 = i2;
        transformableKt$detectZoom$1.label = 2;
        obj = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope2, null, transformableKt$detectZoom$1, 1, null);
        if (obj != coroutine_suspended) {
        }
    }

    public static final Object detectZoomByCtrlMouseScroll(PointerInputScope pointerInputScope, Channel<TransformEvent> channel, ScrollConfig scrollConfig, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new TransformableKt$detectZoomByCtrlMouseScroll$2(continuation.getContext(), scrollConfig, channel, null), continuation);
        return awaitPointerEventScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitPointerEventScope : Unit.INSTANCE;
    }
}
