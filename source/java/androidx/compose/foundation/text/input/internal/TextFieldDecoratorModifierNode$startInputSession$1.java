package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNodeKt;
import androidx.compose.ui.platform.PlatformTextInputSession;
import androidx.compose.ui.platform.PlatformTextInputSessionScope;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {771}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldDecoratorModifierNode$startInputSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
    int label;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldDecoratorModifierNode$startInputSession$1(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, Continuation<? super TextFieldDecoratorModifierNode$startInputSession$1> continuation) {
        super(2, continuation);
        this.this$0 = textFieldDecoratorModifierNode;
        this.$receiveContentConfiguration = receiveContentConfiguration;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldDecoratorModifierNode$startInputSession$1(this.this$0, this.$receiveContentConfiguration, continuation);
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
            if (PlatformTextInputModifierNodeKt.establishTextInputSession(this.this$0, new C04751(this.this$0, this.$receiveContentConfiguration, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TextFieldDecoratorModifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/PlatformTextInputSessionScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {772}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C04751 extends SuspendLambda implements Function2<PlatformTextInputSessionScope, Continuation<?>, Object> {
        final /* synthetic */ ReceiveContentConfiguration $receiveContentConfiguration;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TextFieldDecoratorModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04751(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ReceiveContentConfiguration receiveContentConfiguration, Continuation<? super C04751> continuation) {
            super(2, continuation);
            this.this$0 = textFieldDecoratorModifierNode;
            this.$receiveContentConfiguration = receiveContentConfiguration;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c04751 = new C04751(this.this$0, this.$receiveContentConfiguration, continuation);
            c04751.L$0 = obj;
            return c04751;
        }

        public final Object invoke(PlatformTextInputSessionScope platformTextInputSessionScope, Continuation<?> continuation) {
            return create(platformTextInputSessionScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PlatformTextInputSession platformTextInputSession = (PlatformTextInputSessionScope) this.L$0;
                TransformedTextFieldState textFieldState = this.this$0.getTextFieldState();
                TextLayoutState textLayoutState = this.this$0.getTextLayoutState();
                ImeOptions imeOptions$foundation_release = this.this$0.getKeyboardOptions().toImeOptions$foundation_release(this.this$0.getSingleLine());
                ReceiveContentConfiguration receiveContentConfiguration = this.$receiveContentConfiguration;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
                final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
                this.label = 1;
                if (AndroidTextInputSession_androidKt.platformSpecificTextInputSession(platformTextInputSession, textFieldState, textLayoutState, imeOptions$foundation_release, receiveContentConfiguration, anonymousClass1, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = TextFieldDecoratorModifierNode$startInputSession$1.C04751.invokeSuspend$lambda$0(TextFieldDecoratorModifierNode.this);
                        return invokeSuspend$lambda$0;
                    }
                }, this.this$0.getStylusHandwritingTrigger(), (ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this.this$0, CompositionLocalsKt.getLocalViewConfiguration()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TextFieldDecoratorModifier.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$startInputSession$1$1$1, reason: invalid class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
        public /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function1<ImeAction, Unit> {
            AnonymousClass1(Object obj) {
                super(1, obj, TextFieldDecoratorModifierNode.class, "onImeActionPerformed", "onImeActionPerformed-KlQnJC8(I)Z", 8);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1867invokeKlQnJC8(((ImeAction) obj).unbox-impl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m1867invokeKlQnJC8(int i) {
                ((TextFieldDecoratorModifierNode) this.receiver).m1864onImeActionPerformedKlQnJC8(i);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
            textFieldDecoratorModifierNode.getTextFieldSelectionState().updateTextToolbarState(TextToolbarState.Selection);
            return Unit.INSTANCE;
        }
    }
}
