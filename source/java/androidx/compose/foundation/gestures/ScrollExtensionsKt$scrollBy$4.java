package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: ScrollExtensions.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollExtensionsKt$scrollBy$4", f = "ScrollExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class ScrollExtensionsKt$scrollBy$4 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $consumed;
    final /* synthetic */ long $value;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollExtensionsKt$scrollBy$4(Ref.LongRef longRef, long j, Continuation<? super ScrollExtensionsKt$scrollBy$4> continuation) {
        super(2, continuation);
        this.$consumed = longRef;
        this.$value = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> scrollExtensionsKt$scrollBy$4 = new ScrollExtensionsKt$scrollBy$4(this.$consumed, this.$value, continuation);
        scrollExtensionsKt$scrollBy$4.L$0 = obj;
        return scrollExtensionsKt$scrollBy$4;
    }

    public final Object invoke(Scroll2DScope scroll2DScope, Continuation<? super Unit> continuation) {
        return create(scroll2DScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Scroll2DScope scroll2DScope = (Scroll2DScope) this.L$0;
        this.$consumed.element = scroll2DScope.mo656scrollByMKHz9U(this.$value);
        return Unit.INSTANCE;
    }
}
