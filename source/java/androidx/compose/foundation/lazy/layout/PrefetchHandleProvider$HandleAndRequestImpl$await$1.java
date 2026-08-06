package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.PrefetchHandleProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyLayoutPrefetchState.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl", f = "LazyLayoutPrefetchState.kt", i = {}, l = {564, 565}, m = "await", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PrefetchHandleProvider$HandleAndRequestImpl$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrefetchHandleProvider.HandleAndRequestImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrefetchHandleProvider$HandleAndRequestImpl$await$1(PrefetchHandleProvider.HandleAndRequestImpl handleAndRequestImpl, Continuation<? super PrefetchHandleProvider$HandleAndRequestImpl$await$1> continuation) {
        super(continuation);
        this.this$0 = handleAndRequestImpl;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await((Continuation) this);
    }
}
