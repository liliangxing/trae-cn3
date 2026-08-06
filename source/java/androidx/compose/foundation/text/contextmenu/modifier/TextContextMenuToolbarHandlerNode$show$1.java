package androidx.compose.foundation.text.contextmenu.modifier;

import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TextContextMenuToolbarHandlerModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode$show$1", f = "TextContextMenuToolbarHandlerModifier.kt", i = {}, l = {182, 183, 185, 185}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class TextContextMenuToolbarHandlerNode$show$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuProvider $provider;
    Object L$0;
    int label;
    final /* synthetic */ TextContextMenuToolbarHandlerNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextContextMenuToolbarHandlerNode$show$1(TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode, TextContextMenuProvider textContextMenuProvider, Continuation<? super TextContextMenuToolbarHandlerNode$show$1> continuation) {
        super(2, continuation);
        this.this$0 = textContextMenuToolbarHandlerNode;
        this.$provider = textContextMenuProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextContextMenuToolbarHandlerNode$show$1(this.this$0, this.$provider, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Throwable th;
        Function1<Continuation<? super Unit>, Object> onHide;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Throwable th2) {
            Function1<Continuation<? super Unit>, Object> onHide2 = this.this$0.getOnHide();
            if (onHide2 == null) {
                throw th2;
            }
            this.L$0 = th2;
            this.label = 4;
            if (onHide2.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            th = th2;
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Unit>, Object> onShow = this.this$0.getOnShow();
            if (onShow != null) {
                this.label = 1;
                if (onShow.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    onHide = this.this$0.getOnHide();
                    if (onHide != null) {
                        this.label = 3;
                        if (onHide.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.L$0;
                ResultKt.throwOnFailure(obj);
                throw th;
            }
            ResultKt.throwOnFailure(obj);
        }
        this.label = 2;
        if (this.$provider.showTextContextMenu(this.this$0, (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        onHide = this.this$0.getOnHide();
        if (onHide != null) {
        }
        return Unit.INSTANCE;
    }
}
