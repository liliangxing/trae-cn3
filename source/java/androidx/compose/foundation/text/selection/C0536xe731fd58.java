package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TextFieldSelectionManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextFieldSelectionManager", f = "TextFieldSelectionManager.kt", i = {}, l = {783}, m = "notifyPlatformSelectionBehaviorsOnShowContextMenu", n = {}, s = {})
/* renamed from: androidx.compose.foundation.text.selection.TextFieldSelectionManager$notifyPlatformSelectionBehaviorsOnShowContextMenu$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0536xe731fd58 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0536xe731fd58(TextFieldSelectionManager textFieldSelectionManager, Continuation<? super C0536xe731fd58> continuation) {
        super(continuation);
        this.this$0 = textFieldSelectionManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object notifyPlatformSelectionBehaviorsOnShowContextMenu;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        notifyPlatformSelectionBehaviorsOnShowContextMenu = this.this$0.notifyPlatformSelectionBehaviorsOnShowContextMenu((Continuation) this);
        return notifyPlatformSelectionBehaviorsOnShowContextMenu;
    }
}
