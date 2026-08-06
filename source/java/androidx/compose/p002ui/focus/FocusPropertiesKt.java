package androidx.compose.p002ui.focus;

import androidx.compose.p002ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FocusProperties.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001H\u0002\u001a#\u0010\u0007\u001a\u00020\b*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¨\u0006\u000b"}, d2 = {"toUsingEnterExitScope", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/focus/FocusDirection;", "Landroidx/compose/ui/focus/FocusRequester;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Landroidx/compose/ui/focus/FocusProperties;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusPropertiesKt {
    public static final Function1<FocusEnterExitScope, Unit> toUsingEnterExitScope(final Function1<? super FocusDirection, FocusRequester> function1) {
        return new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.focus.FocusPropertiesKt$toUsingEnterExitScope$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FocusEnterExitScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FocusEnterExitScope focusEnterExitScope) {
                FocusRequester focusRequester = (FocusRequester) function1.invoke(FocusDirection.m4457boximpl(focusEnterExitScope.getRequestedFocusDirection()));
                if (focusRequester == FocusRequester.INSTANCE.getCancel()) {
                    focusEnterExitScope.cancelFocusChange();
                } else if (focusRequester != FocusRequester.INSTANCE.getDefault()) {
                    FocusRequester.m4495requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                }
            }
        };
    }

    public static final Modifier focusProperties(Modifier modifier, Function1<? super FocusProperties, Unit> function1) {
        return modifier.then((Modifier) new FocusPropertiesElement(new C0758xfe8f9d59(function1)));
    }
}
