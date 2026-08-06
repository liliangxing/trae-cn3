package com.bytedance.trae.conversation.git;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThirdPartyTokenClient.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.ThirdPartyTokenClient", f = "ThirdPartyTokenClient.kt", i = {0}, l = {18, 19}, m = "exchangeCodeAndFetchGitHubToken", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThirdPartyTokenClient this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1(ThirdPartyTokenClient thirdPartyTokenClient, Continuation<? super ThirdPartyTokenClient$exchangeCodeAndFetchGitHubToken$1> continuation) {
        super(continuation);
        this.this$0 = thirdPartyTokenClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.exchangeCodeAndFetchGitHubToken(null, null, (Continuation) this);
    }
}
