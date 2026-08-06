package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitRemoteRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.GitRemoteRepository", f = "GitRemoteRepository.kt", i = {0, 0, 0, 1, 1}, l = {408, 276}, m = "fetchRepos", n = {"this", "$this$withLock_u24default$iv", "forceFetch", "this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRemoteRepository$fetchRepos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GitRemoteRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitRemoteRepository$fetchRepos$1(GitRemoteRepository gitRemoteRepository, Continuation<? super GitRemoteRepository$fetchRepos$1> continuation) {
        super(continuation);
        this.this$0 = gitRemoteRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchRepos(false, (Continuation) this);
    }
}
