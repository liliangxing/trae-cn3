package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import me.ele.lancet.base.annotations.ClassOf;
import org.bouncycastle.asn1.eac.EACTags;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Deprecated.kt */
@Metadata(m6k = 3, m7mv = {1, 9, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt", m42f = "Deprecated.kt", m43i = {0, 0, 0}, m44l = {EACTags.APPLICATION_IMAGE}, m45m = "elementAt", m46n = {"$this$consume$iv", ClassOf.INDEX, "count"}, m47s = {"L$0", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ChannelsKt__DeprecatedKt$elementAt$1<E> extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChannelsKt__DeprecatedKt$elementAt$1(Continuation<? super ChannelsKt__DeprecatedKt$elementAt$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object elementAt;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        elementAt = ChannelsKt__DeprecatedKt.elementAt(null, 0, this);
        return elementAt;
    }
}
