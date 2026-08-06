package com.bytedance.trae.conversation.git;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitHubConnectorManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitHubConnectorManager", f = "GitHubConnectorManager.kt", i = {1}, l = {68, 72, 77}, m = "completeOAuthCallback", n = {"this"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitHubConnectorManager$completeOAuthCallback$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GitHubConnectorManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitHubConnectorManager$completeOAuthCallback$1(GitHubConnectorManager gitHubConnectorManager, Continuation<? super GitHubConnectorManager$completeOAuthCallback$1> continuation) {
        super(continuation);
        this.this$0 = gitHubConnectorManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.completeOAuthCallback(null, null, (Continuation) this);
    }
}
