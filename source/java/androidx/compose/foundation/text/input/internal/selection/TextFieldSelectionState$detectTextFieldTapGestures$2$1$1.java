package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1", f = "TextFieldSelectionState.kt", i = {}, l = {516, 524}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionState$detectTextFieldTapGestures$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PressGestureScope $$this$detectTapAndPress;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ long $offset;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TextFieldSelectionState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(PressGestureScope pressGestureScope, TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super TextFieldSelectionState$detectTextFieldTapGestures$2$1$1> continuation) {
        super(2, continuation);
        this.$$this$detectTapAndPress = pressGestureScope;
        this.this$0 = textFieldSelectionState;
        this.$offset = j;
        this.$interactionSource = mutableInteractionSource;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> textFieldSelectionState$detectTextFieldTapGestures$2$1$1 = new TextFieldSelectionState$detectTextFieldTapGestures$2$1$1(this.$$this$detectTapAndPress, this.this$0, this.$offset, this.$interactionSource, continuation);
        textFieldSelectionState$detectTextFieldTapGestures$2$1$1.L$0 = obj;
        return textFieldSelectionState$detectTextFieldTapGestures$2$1$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldSelectionState.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1", f = "TextFieldSelectionState.kt", i = {1}, l = {508, 513}, m = "invokeSuspend", n = {"press"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState$detectTextFieldTapGestures$2$1$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ long $offset;
        Object L$0;
        int label;
        final /* synthetic */ TextFieldSelectionState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04931(TextFieldSelectionState textFieldSelectionState, long j, MutableInteractionSource mutableInteractionSource, Continuation<? super C04931> continuation) {
            super(2, continuation);
            this.this$0 = textFieldSelectionState;
            this.$offset = j;
            this.$interactionSource = mutableInteractionSource;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C04931(this.this$0, this.$offset, this.$interactionSource, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0065 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            PressInteraction.Press press;
            TextFieldSelectionState textFieldSelectionState;
            PressInteraction.Press press2;
            PressInteraction.Press press3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                press = this.this$0.pressInteraction;
                if (press != null) {
                    MutableInteractionSource mutableInteractionSource = this.$interactionSource;
                    TextFieldSelectionState textFieldSelectionState2 = this.this$0;
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    this.L$0 = textFieldSelectionState2;
                    this.label = 1;
                    if (mutableInteractionSource.emit(cancel, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionState = textFieldSelectionState2;
                }
                press2 = new PressInteraction.Press(this.$offset, null);
                this.L$0 = press2;
                this.label = 2;
                if (this.$interactionSource.emit(press2, (Continuation) this) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                press3 = press2;
                this.this$0.pressInteraction = press3;
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                press3 = (PressInteraction.Press) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.pressInteraction = press3;
                return Unit.INSTANCE;
            }
            textFieldSelectionState = (TextFieldSelectionState) this.L$0;
            ResultKt.throwOnFailure(obj);
            textFieldSelectionState.pressInteraction = null;
            press2 = new PressInteraction.Press(this.$offset, null);
            this.L$0 = press2;
            this.label = 2;
            if (this.$interactionSource.emit(press2, (Continuation) this) != coroutine_suspended) {
            }
        }
    }

    public final Object invokeSuspend(Object obj) {
        PressInteraction.Press press;
        PressInteraction.Cancel cancel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BuildersKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new C04931(this.this$0, this.$offset, this.$interactionSource, null), 3, (Object) null);
            this.label = 1;
            obj = this.$$this$detectTapAndPress.tryAwaitRelease((Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.pressInteraction = null;
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        press = this.this$0.pressInteraction;
        if (press != null) {
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            if (booleanValue) {
                cancel = new PressInteraction.Release(press);
            } else {
                cancel = new PressInteraction.Cancel(press);
            }
            this.label = 2;
            if (mutableInteractionSource.emit(cancel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.pressInteraction = null;
        return Unit.INSTANCE;
    }
}
