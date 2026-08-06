package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m42f = "Deprecated.kt", m43i = {0, 0, 1, 1}, m44l = {179, 182}, m45m = "singleOrNull", m46n = {"$this$consume$iv", "iterator", "$this$consume$iv", "single"}, m47s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ChannelsKt__DeprecatedKt$singleOrNull$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$singleOrNull$1(Continuation<? super ChannelsKt__DeprecatedKt$singleOrNull$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object singleOrNull;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        singleOrNull = ChannelsKt__DeprecatedKt.singleOrNull(null, this);
        return singleOrNull;
    }
}
