package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2", f = "TextFieldSelectionState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionState$cursorHandleGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$cursorHandleGestures$2(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super TextFieldSelectionState$cursorHandleGestures$2> continuation) {
        super(2, continuation);
        this.this$0 = textFieldSelectionState;
        this.$this_cursorHandleGestures = pointerInputScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> textFieldSelectionState$cursorHandleGestures$2 = new TextFieldSelectionState$cursorHandleGestures$2(this.this$0, this.$this_cursorHandleGestures, continuation);
        textFieldSelectionState$cursorHandleGestures$2.L$0 = obj;
        return textFieldSelectionState$cursorHandleGestures$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1", f = "TextFieldSelectionState.kt", i = {}, l = {395}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04901(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super C04901> continuation) {
            super(2, continuation);
            this.this$0 = textFieldSelectionState;
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04901(this.this$0, this.$this_cursorHandleGestures, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.detectTouchMode(this.$this_cursorHandleGestures, (Continuation) this) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C04901(this.this$0, this.$this_cursorHandleGestures, null), 1, (Object) null);
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C04912(this.this$0, this.$this_cursorHandleGestures, null), 1, (Object) null);
        return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C04923(this.$this_cursorHandleGestures, this.this$0, null), 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2", f = "TextFieldSelectionState.kt", i = {}, l = {396}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04912(TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, Continuation<? super C04912> continuation) {
            super(2, continuation);
            this.this$0 = textFieldSelectionState;
            this.$this_cursorHandleGestures = pointerInputScope;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04912(this.this$0, this.$this_cursorHandleGestures, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object detectCursorHandleDragGestures;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                detectCursorHandleDragGestures = this.this$0.detectCursorHandleDragGestures(this.$this_cursorHandleGestures, (Continuation) this);
                if (detectCursorHandleDragGestures == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3", f = "TextFieldSelectionState.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04923 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PointerInputScope $this_cursorHandleGestures;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04923(PointerInputScope pointerInputScope, TextFieldSelectionState textFieldSelectionState, Continuation<? super C04923> continuation) {
            super(2, continuation);
            this.$this_cursorHandleGestures = pointerInputScope;
            this.this$0 = textFieldSelectionState;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04923(this.$this_cursorHandleGestures, this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PointerInputScope pointerInputScope = this.$this_cursorHandleGestures;
                final TextFieldSelectionState textFieldSelectionState = this.this$0;
                this.label = 1;
                if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$cursorHandleGestures$2$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj2) {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TextFieldSelectionState$cursorHandleGestures$2.C04923.invokeSuspend$lambda$0(TextFieldSelectionState.this, (Offset) obj2);
                        return invokeSuspend$lambda$0;
                    }
                }, (Continuation) this, 7, null) == coroutine_suspended) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(TextFieldSelectionState textFieldSelectionState, Offset offset) {
            TextToolbarState textToolbarState;
            textToolbarState = textFieldSelectionState.getTextToolbarState();
            textFieldSelectionState.setTextToolbarState(textToolbarState == TextToolbarState.Cursor ? TextToolbarState.None : TextToolbarState.Cursor);
            return Unit.INSTANCE;
        }
    }
}
