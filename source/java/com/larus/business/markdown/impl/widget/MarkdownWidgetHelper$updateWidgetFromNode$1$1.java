package com.larus.business.markdown.impl.widget;

import android.view.ViewGroup;
import com.larus.business.markdown.api.widget.IMarkdownWidgetCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MarkdownWidgetHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.larus.business.markdown.impl.widget.MarkdownWidgetHelper$updateWidgetFromNode$1$1", f = "MarkdownWidgetHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
final class MarkdownWidgetHelper$updateWidgetFromNode$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMarkdownWidgetCallback $callback;
    final /* synthetic */ ViewGroup $currentParentViewGroup;
    final /* synthetic */ int $index;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarkdownWidgetHelper$updateWidgetFromNode$1$1(IMarkdownWidgetCallback iMarkdownWidgetCallback, int i, ViewGroup viewGroup, Continuation<? super MarkdownWidgetHelper$updateWidgetFromNode$1$1> continuation) {
        super(2, continuation);
        this.$callback = iMarkdownWidgetCallback;
        this.$index = i;
        this.$currentParentViewGroup = viewGroup;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MarkdownWidgetHelper$updateWidgetFromNode$1$1(this.$callback, this.$index, this.$currentParentViewGroup, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        IMarkdownWidgetCallback iMarkdownWidgetCallback = this.$callback;
        if (iMarkdownWidgetCallback != null) {
            iMarkdownWidgetCallback.updateHandle(this.$index, this.$currentParentViewGroup);
        }
        return Unit.INSTANCE;
    }
}
