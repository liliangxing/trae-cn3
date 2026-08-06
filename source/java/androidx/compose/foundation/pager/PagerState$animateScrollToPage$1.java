package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0}, l = {612, 619}, m = "animateScrollToPage", n = {"animationSpec", "page", "pageOffsetFraction"}, s = {"L$0", "I$0", "F$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PagerState$animateScrollToPage$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PagerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PagerState$animateScrollToPage$1(PagerState pagerState, Continuation<? super PagerState$animateScrollToPage$1> continuation) {
        super(continuation);
        this.this$0 = pagerState;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.animateScrollToPage(0, 0.0f, null, (Continuation) this);
    }
}
