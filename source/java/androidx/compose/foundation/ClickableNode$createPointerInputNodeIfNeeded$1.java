package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: Clickable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class ClickableNode$createPointerInputNodeIfNeeded$1 implements PointerInputEventHandler {
    final /* synthetic */ ClickableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClickableNode$createPointerInputNodeIfNeeded$1(ClickableNode clickableNode) {
        this.this$0 = clickableNode;
    }

    /* compiled from: Clickable.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "offset", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1$1", f = "Clickable.kt", i = {}, l = {959}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    static final class C02311 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ClickableNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02311(ClickableNode clickableNode, Continuation<? super C02311> continuation) {
            super(3, continuation);
            this.this$0 = clickableNode;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m458invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m4603unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I, reason: not valid java name */
        public final Object m458invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            C02311 c02311 = new C02311(this.this$0, continuation);
            c02311.L$0 = pressGestureScope;
            c02311.J$0 = j;
            return c02311.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                if (this.this$0.getEnabled()) {
                    this.label = 1;
                    if (this.this$0.m357handlePressInteractiond4ec7I(pressGestureScope, j, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
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

    @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        C02311 c02311 = new C02311(this.this$0, null);
        final ClickableNode clickableNode = this.this$0;
        Object detectTapAndPress = TapGestureDetectorKt.detectTapAndPress(pointerInputScope, c02311, new Function1() { // from class: androidx.compose.foundation.ClickableNode$createPointerInputNodeIfNeeded$1$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit invoke$lambda$0;
                invoke$lambda$0 = ClickableNode$createPointerInputNodeIfNeeded$1.invoke$lambda$0(ClickableNode.this, (Offset) obj);
                return invoke$lambda$0;
            }
        }, continuation);
        return detectTapAndPress == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectTapAndPress : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$0(ClickableNode clickableNode, Offset offset) {
        if (clickableNode.getEnabled()) {
            clickableNode.getOnClick().invoke();
        }
        return Unit.INSTANCE;
    }
}
