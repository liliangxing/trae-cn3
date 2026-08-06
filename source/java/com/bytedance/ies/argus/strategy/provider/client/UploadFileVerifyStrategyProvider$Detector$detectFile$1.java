package com.bytedance.ies.argus.strategy.provider.client;

import com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UploadFileVerifyStrategyProvider.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.ies.argus.strategy.provider.client.UploadFileVerifyStrategyProvider$Detector", f = "UploadFileVerifyStrategyProvider.kt", i = {}, l = {293}, m = "detectFile", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UploadFileVerifyStrategyProvider$Detector$detectFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadFileVerifyStrategyProvider.Detector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadFileVerifyStrategyProvider$Detector$detectFile$1(UploadFileVerifyStrategyProvider.Detector detector, Continuation<? super UploadFileVerifyStrategyProvider$Detector$detectFile$1> continuation) {
        super(continuation);
        this.this$0 = detector;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.detectFile(null, (Continuation) this);
    }
}
