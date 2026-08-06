package com.bytedance.trae.conversation.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitRemoteRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.GitRemoteRepository", f = "GitRemoteRepository.kt", i = {}, l = {371}, m = "listRepositoriesFromServer", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRemoteRepository$listRepositoriesFromServer$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GitRemoteRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitRemoteRepository$listRepositoriesFromServer$1(GitRemoteRepository gitRemoteRepository, Continuation<? super GitRemoteRepository$listRepositoriesFromServer$1> continuation) {
        super(continuation);
        this.this$0 = gitRemoteRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object listRepositoriesFromServer;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        listRepositoriesFromServer = this.this$0.listRepositoriesFromServer(null, null, null, (Continuation) this);
        return listRepositoriesFromServer;
    }
}
