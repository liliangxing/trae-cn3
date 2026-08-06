package androidx.compose.foundation.text;

import androidx.compose.p002ui.focus.FocusDirection;
import androidx.compose.p002ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardActionRunner.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "<init>", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "runAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "runAction-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "defaultKeyboardAction", "", "defaultKeyboardAction-KlQnJC8", "(I)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public static final int $stable = 8;
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;

    public KeyboardActionRunner(SoftwareKeyboardController softwareKeyboardController) {
        this.keyboardController = softwareKeyboardController;
    }

    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    public final void setKeyboardActions(KeyboardActions keyboardActions) {
        this.keyboardActions = keyboardActions;
    }

    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    public final void setFocusManager(FocusManager focusManager) {
        this.focusManager = focusManager;
    }

    /* renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final boolean m1545runActionKlQnJC8(int imeAction) {
        Function1<KeyboardActionScope, Unit> function1;
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDone-eUduSuo())) {
            function1 = getKeyboardActions().getOnDone();
        } else if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getGo-eUduSuo())) {
            function1 = getKeyboardActions().getOnGo();
        } else if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNext-eUduSuo())) {
            function1 = getKeyboardActions().getOnNext();
        } else if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getPrevious-eUduSuo())) {
            function1 = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSearch-eUduSuo())) {
            function1 = getKeyboardActions().getOnSearch();
        } else if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSend-eUduSuo())) {
            function1 = getKeyboardActions().getOnSend();
        } else {
            if (!ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo()) && !ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNone-eUduSuo())) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            function1 = null;
        }
        if (function1 != null) {
            function1.invoke(this);
            return true;
        }
        return m1543defaultKeyboardActionWithResultKlQnJC8(imeAction);
    }

    /* renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    private final boolean m1543defaultKeyboardActionWithResultKlQnJC8(int imeAction) {
        SoftwareKeyboardController softwareKeyboardController;
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNext-eUduSuo())) {
            getFocusManager().mo4476moveFocus3ESFkO8(FocusDirection.INSTANCE.m4468getNextdhqQ8s());
            return true;
        }
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getPrevious-eUduSuo())) {
            getFocusManager().mo4476moveFocus3ESFkO8(FocusDirection.INSTANCE.m4469getPreviousdhqQ8s());
            return true;
        }
        if (!ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDone-eUduSuo()) || (softwareKeyboardController = this.keyboardController) == null) {
            return false;
        }
        softwareKeyboardController.hide();
        return true;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo1544defaultKeyboardActionKlQnJC8(int imeAction) {
        m1543defaultKeyboardActionWithResultKlQnJC8(imeAction);
    }
}
