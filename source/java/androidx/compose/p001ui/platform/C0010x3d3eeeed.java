package androidx.compose.p001ui.platform;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat", f = "AndroidComposeViewAccessibilityDelegateCompat.android.kt", i = {0, 1}, l = {2096, 2131}, m = "boundsUpdatesEventLoop$ui_release", n = {"subtreeChangedSemanticsNodesIds", "subtreeChangedSemanticsNodesIds"}, s = {"L$0", "L$0"})
/* renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0010x3d3eeeed extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0010x3d3eeeed(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, Continuation<? super C0010x3d3eeeed> continuation) {
        super(continuation);
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.boundsUpdatesEventLoop$ui_release((Continuation) this);
    }
}
