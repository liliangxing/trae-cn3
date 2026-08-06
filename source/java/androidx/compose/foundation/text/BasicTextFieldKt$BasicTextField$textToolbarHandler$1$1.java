package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"androidx/compose/foundation/text/BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1", "Landroidx/compose/foundation/text/input/internal/selection/TextToolbarHandler;", "showTextToolbar", "", "selectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hideTextToolbar", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 implements TextToolbarHandler {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ TextToolbar $currentTextToolbar;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(TextToolbar textToolbar, CoroutineScope coroutineScope) {
        this.$currentTextToolbar = textToolbar;
        this.$coroutineScope = coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object showTextToolbar(final TextFieldSelectionState textFieldSelectionState, Rect rect, Continuation<? super Unit> continuation) {
        C0386x4001b59 c0386x4001b59;
        int i;
        Rect rect2;
        TextToolbar textToolbar;
        final CoroutineScope coroutineScope;
        if (continuation instanceof C0386x4001b59) {
            c0386x4001b59 = (C0386x4001b59) continuation;
            if ((c0386x4001b59.label & Integer.MIN_VALUE) != 0) {
                c0386x4001b59.label -= Integer.MIN_VALUE;
                Object obj = c0386x4001b59.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0386x4001b59.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    TextToolbar textToolbar2 = this.$currentTextToolbar;
                    CoroutineScope coroutineScope2 = this.$coroutineScope;
                    c0386x4001b59.L$0 = rect;
                    c0386x4001b59.L$1 = textToolbar2;
                    c0386x4001b59.L$2 = coroutineScope2;
                    c0386x4001b59.L$3 = textFieldSelectionState;
                    c0386x4001b59.label = 1;
                    if (textFieldSelectionState.updateClipboardEntry(c0386x4001b59) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rect2 = rect;
                    textToolbar = textToolbar2;
                    coroutineScope = coroutineScope2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    textFieldSelectionState = (TextFieldSelectionState) c0386x4001b59.L$3;
                    coroutineScope = (CoroutineScope) c0386x4001b59.L$2;
                    TextToolbar textToolbar3 = (TextToolbar) c0386x4001b59.L$1;
                    Rect rect3 = (Rect) c0386x4001b59.L$0;
                    ResultKt.throwOnFailure(obj);
                    rect2 = rect3;
                    textToolbar = textToolbar3;
                }
                boolean canCopy = textFieldSelectionState.canCopy();
                final TextToolbarState textToolbarState = TextToolbarState.None;
                Function0<Unit> function0 = canCopy ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$1
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1498invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1498invoke() {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0387x857ff834(textFieldSelectionState, null), 1, (Object) null);
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState);
                    }
                };
                boolean canPaste = textFieldSelectionState.canPaste();
                final TextToolbarState textToolbarState2 = TextToolbarState.None;
                Function0<Unit> function02 = canPaste ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1499invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1499invoke() {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0388x857ffbf5(textFieldSelectionState, null), 1, (Object) null);
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState2);
                    }
                };
                boolean canCut = textFieldSelectionState.canCut();
                final TextToolbarState textToolbarState3 = TextToolbarState.None;
                Function0<Unit> function03 = canCut ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$3
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1500invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1500invoke() {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0389x857fffb6(textFieldSelectionState, null), 1, (Object) null);
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState3);
                    }
                };
                boolean canSelectAll = textFieldSelectionState.canSelectAll();
                final TextToolbarState textToolbarState4 = TextToolbarState.Selection;
                Function0<Unit> function04 = canSelectAll ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$4
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1501invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1501invoke() {
                        textFieldSelectionState.selectAll();
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState4);
                    }
                };
                boolean canAutofill = textFieldSelectionState.canAutofill();
                final TextToolbarState textToolbarState5 = TextToolbarState.None;
                textToolbar.showMenu(rect2, function0, function02, function03, function04, canAutofill ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$5
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1502invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1502invoke() {
                        textFieldSelectionState.autofill();
                        TextFieldSelectionState.this.updateTextToolbarState(textToolbarState5);
                    }
                });
                return Unit.INSTANCE;
            }
        }
        c0386x4001b59 = new C0386x4001b59(this, continuation);
        Object obj2 = c0386x4001b59.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0386x4001b59.label;
        if (i != 0) {
        }
        boolean canCopy2 = textFieldSelectionState.canCopy();
        final TextToolbarState textToolbarState6 = TextToolbarState.None;
        if (canCopy2) {
        }
        boolean canPaste2 = textFieldSelectionState.canPaste();
        final TextToolbarState textToolbarState22 = TextToolbarState.None;
        if (canPaste2) {
        }
        boolean canCut2 = textFieldSelectionState.canCut();
        final TextToolbarState textToolbarState32 = TextToolbarState.None;
        if (canCut2) {
        }
        boolean canSelectAll2 = textFieldSelectionState.canSelectAll();
        final TextToolbarState textToolbarState42 = TextToolbarState.Selection;
        if (canSelectAll2) {
        }
        boolean canAutofill2 = textFieldSelectionState.canAutofill();
        final TextToolbarState textToolbarState52 = TextToolbarState.None;
        textToolbar.showMenu(rect2, function0, function02, function03, function04, canAutofill2 ? null : new Function0<Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1$showTextToolbar$lambda$5$$inlined$menuItem$5
            public /* bridge */ /* synthetic */ Object invoke() {
                m1502invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1502invoke() {
                textFieldSelectionState.autofill();
                TextFieldSelectionState.this.updateTextToolbarState(textToolbarState52);
            }
        });
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextToolbarHandler
    public void hideTextToolbar() {
        if (this.$currentTextToolbar.getStatus() == TextToolbarStatus.Shown) {
            this.$currentTextToolbar.hide();
        }
    }
}
