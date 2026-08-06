package androidx.compose.foundation.text.selection;

import androidx.compose.p002ui.geometry.Offset;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectionContainer.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
final class C0518xf8ffea21 implements OffsetProvider, FunctionAdapter {
    private final /* synthetic */ Function0 function;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0518xf8ffea21(Function0 function0) {
        this.function = function0;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof OffsetProvider) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    public final Function<?> getFunctionDelegate() {
        return this.function;
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.compose.foundation.text.selection.OffsetProvider
    /* renamed from: provide-F1C5BW0 */
    public final /* synthetic */ long mo1503provideF1C5BW0() {
        return ((Offset) this.function.invoke()).m4603unboximpl();
    }
}
