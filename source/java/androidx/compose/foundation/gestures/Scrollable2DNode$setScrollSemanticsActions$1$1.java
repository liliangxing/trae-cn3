package androidx.compose.foundation.gestures;

import androidx.compose.p002ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Scrollable2D.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$setScrollSemanticsActions$1$1", f = "Scrollable2D.kt", i = {}, l = {286}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class Scrollable2DNode$setScrollSemanticsActions$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: $x */
    final /* synthetic */ float f41$x;

    /* renamed from: $y */
    final /* synthetic */ float f42$y;
    int label;
    final /* synthetic */ Scrollable2DNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Scrollable2DNode$setScrollSemanticsActions$1$1(Scrollable2DNode scrollable2DNode, float f, float f2, Continuation<? super Scrollable2DNode$setScrollSemanticsActions$1$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollable2DNode;
        this.f41$x = f;
        this.f42$y = f2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Scrollable2DNode$setScrollSemanticsActions$1$1(this.this$0, this.f41$x, this.f42$y, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ScrollingLogic2D scrollingLogic2D;
        Object m769semanticsScrollByd4ec7I;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            scrollingLogic2D = this.this$0.scrollingLogic;
            float f = this.f41$x;
            float f2 = this.f42$y;
            long floatToRawIntBits = Float.floatToRawIntBits(f);
            long floatToRawIntBits2 = Float.floatToRawIntBits(f2);
            this.label = 1;
            m769semanticsScrollByd4ec7I = Scrollable2DKt.m769semanticsScrollByd4ec7I(scrollingLogic2D, Offset.m4585constructorimpl((floatToRawIntBits << 32) | (floatToRawIntBits2 & 4294967295L)), (Continuation) this);
            if (m769semanticsScrollByd4ec7I == coroutine_suspended) {
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
}
