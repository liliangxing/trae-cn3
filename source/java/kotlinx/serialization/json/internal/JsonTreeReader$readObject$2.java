package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonTreeReader.kt */
@Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
@DebugMetadata(m41c = "kotlinx.serialization.json.internal.JsonTreeReader", m42f = "JsonTreeReader.kt", m43i = {0, 0, 0, 0}, m44l = {24}, m45m = "readObject", m46n = {"$this$readObject", "this_$iv", "result$iv", "key$iv"}, m47s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ JsonTreeReader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readObject$2> continuation) {
        super(continuation);
        this.this$0 = jsonTreeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object readObject;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        readObject = this.this$0.readObject(null, this);
        return readObject;
    }
}
