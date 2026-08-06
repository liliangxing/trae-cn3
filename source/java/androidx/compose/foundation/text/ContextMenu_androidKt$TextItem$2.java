package androidx.compose.foundation.text;

import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ContextMenu.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextMenu_androidKt$TextItem$2 implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $operation;
    final /* synthetic */ ContextMenuState $state;

    public ContextMenu_androidKt$TextItem$2(Function0<Unit> function0, ContextMenuState contextMenuState) {
        this.$operation = function0;
        this.$state = contextMenuState;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1529invoke();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m1529invoke() {
        this.$operation.invoke();
        ContextMenuState_androidKt.close(this.$state);
    }
}
