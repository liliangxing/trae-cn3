package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContextMenu.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt", f = "ContextMenu.android.kt", i = {0}, l = {240}, m = "getContextMenuItemsAvailability", n = {"$this$getContextMenuItemsAvailability"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextMenu_androidKt$getContextMenuItemsAvailability$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContextMenu_androidKt$getContextMenuItemsAvailability$2(Continuation<? super ContextMenu_androidKt$getContextMenuItemsAvailability$2> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ContextMenu_androidKt.getContextMenuItemsAvailability((TextFieldSelectionManager) null, (Continuation<? super MenuItemsAvailability>) this);
    }
}
