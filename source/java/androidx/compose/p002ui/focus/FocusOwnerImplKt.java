package androidx.compose.p002ui.focus;

import kotlin.Metadata;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"is1dFocusSearch", "", "Landroidx/compose/ui/focus/FocusDirection;", "is1dFocusSearch-3ESFkO8", "(I)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusOwnerImplKt {
    /* renamed from: is1dFocusSearch-3ESFkO8, reason: not valid java name */
    public static final boolean m4491is1dFocusSearch3ESFkO8(int i) {
        return FocusDirection.m4460equalsimpl0(i, FocusDirection.INSTANCE.m4468getNextdhqQ8s()) || FocusDirection.m4460equalsimpl0(i, FocusDirection.INSTANCE.m4469getPreviousdhqQ8s());
    }
}
