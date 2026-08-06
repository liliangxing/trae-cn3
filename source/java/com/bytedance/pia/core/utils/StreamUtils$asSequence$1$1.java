package com.bytedance.pia.core.utils;

import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: StreamUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.pia.core.utils.StreamUtils$asSequence$1$1", f = "StreamUtils.kt", i = {0, 0}, l = {39}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class StreamUtils$asSequence$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super char[]>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ InputStreamReader $reader;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamUtils$asSequence$1$1(int i, InputStreamReader inputStreamReader, Continuation<? super StreamUtils$asSequence$1$1> continuation) {
        super(2, continuation);
        this.$chunkSize = i;
        this.$reader = inputStreamReader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> streamUtils$asSequence$1$1 = new StreamUtils$asSequence$1$1(this.$chunkSize, this.$reader, continuation);
        streamUtils$asSequence$1$1.L$0 = obj;
        return streamUtils$asSequence$1$1;
    }

    public final Object invoke(SequenceScope<? super char[]> sequenceScope, Continuation<? super Unit> continuation) {
        return create(sequenceScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0048 -> B:5:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SequenceScope sequenceScope;
        char[] cArr;
        int read;
        StreamUtils$asSequence$1$1 streamUtils$asSequence$1$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            cArr = new char[this.$chunkSize];
            read = this.$reader.read(cArr);
            streamUtils$asSequence$1$1 = this;
            if (read != -1) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cArr = (char[]) this.L$1;
            SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            streamUtils$asSequence$1$1 = this;
            sequenceScope = sequenceScope2;
            read = streamUtils$asSequence$1$1.$reader.read(cArr);
            if (read != -1) {
                streamUtils$asSequence$1$1.L$0 = sequenceScope;
                streamUtils$asSequence$1$1.L$1 = cArr;
                streamUtils$asSequence$1$1.label = 1;
                if (sequenceScope.yield(ArraysKt.copyOfRange(cArr, 0, read), (Continuation) streamUtils$asSequence$1$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                read = streamUtils$asSequence$1$1.$reader.read(cArr);
                if (read != -1) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
