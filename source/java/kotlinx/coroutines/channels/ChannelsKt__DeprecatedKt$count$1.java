package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m42f = "Deprecated.kt", m43i = {0, 0}, m44l = {517}, m45m = "count", m46n = {"count", "$this$consume$iv$iv"}, m47s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ChannelsKt__DeprecatedKt$count$1<E> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$count$1(Continuation<? super ChannelsKt__DeprecatedKt$count$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object count;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        count = ChannelsKt__DeprecatedKt.count(null, this);
        return count;
    }
}
