package androidx.compose.foundation.text.input.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidTextInputSession.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt", f = "AndroidTextInputSession.android.kt", i = {}, l = {59}, m = "platformSpecificTextInputSession", n = {}, s = {})
/* renamed from: androidx.compose.foundation.text.input.internal.AndroidTextInputSession_androidKt$platformSpecificTextInputSession$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class C0456x52e2384e extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0456x52e2384e(Continuation<? super C0456x52e2384e> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AndroidTextInputSession_androidKt.platformSpecificTextInputSession(null, null, null, null, null, null, null, null, null, (Continuation) this);
    }
}
