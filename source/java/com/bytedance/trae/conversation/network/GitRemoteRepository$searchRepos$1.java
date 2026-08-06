package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitRemoteRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.GitRemoteRepository", f = "GitRemoteRepository.kt", i = {0, 0, 0, 1}, l = {408, 302}, m = "searchRepos", n = {"this", "keyword", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRemoteRepository$searchRepos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GitRemoteRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitRemoteRepository$searchRepos$1(GitRemoteRepository gitRemoteRepository, Continuation<? super GitRemoteRepository$searchRepos$1> continuation) {
        super(continuation);
        this.this$0 = gitRemoteRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchRepos(null, (Continuation) this);
    }
}
