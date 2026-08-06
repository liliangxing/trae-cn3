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
/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$1$1", f = "Scrollable.kt", i = {}, l = {528}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScrollableNode$setScrollSemanticsActions$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: $x */
    final /* synthetic */ float f43$x;

    /* renamed from: $y */
    final /* synthetic */ float f44$y;
    int label;
    final /* synthetic */ ScrollableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableNode$setScrollSemanticsActions$1$1(ScrollableNode scrollableNode, float f, float f2, Continuation<? super ScrollableNode$setScrollSemanticsActions$1$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollableNode;
        this.f43$x = f;
        this.f44$y = f2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ScrollableNode$setScrollSemanticsActions$1$1(this.this$0, this.f43$x, this.f44$y, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Object m775semanticsScrollByd4ec7I;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            scrollingLogic = this.this$0.scrollingLogic;
            float f = this.f43$x;
            float f2 = this.f44$y;
            long floatToRawIntBits = Float.floatToRawIntBits(f);
            long floatToRawIntBits2 = Float.floatToRawIntBits(f2);
            this.label = 1;
            m775semanticsScrollByd4ec7I = ScrollableKt.m775semanticsScrollByd4ec7I(scrollingLogic, Offset.m4585constructorimpl((floatToRawIntBits << 32) | (floatToRawIntBits2 & 4294967295L)), (Continuation) this);
            if (m775semanticsScrollByd4ec7I == coroutine_suspended) {
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
