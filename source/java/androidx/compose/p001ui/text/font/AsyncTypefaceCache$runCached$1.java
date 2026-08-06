package androidx.compose.p001ui.text.font;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListFontFamilyTypefaceAdapter.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.text.font.AsyncTypefaceCache", f = "FontListFontFamilyTypefaceAdapter.kt", i = {0, 0}, l = {HttpStatus.SC_PRECONDITION_FAILED}, m = "runCached", n = {"key", "forever"}, s = {"L$0", "Z$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AsyncTypefaceCache$runCached$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AsyncTypefaceCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncTypefaceCache$runCached$1(AsyncTypefaceCache asyncTypefaceCache, Continuation<? super AsyncTypefaceCache$runCached$1> continuation) {
        super(continuation);
        this.this$0 = asyncTypefaceCache;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runCached(null, null, false, null, (Continuation) this);
    }
}
