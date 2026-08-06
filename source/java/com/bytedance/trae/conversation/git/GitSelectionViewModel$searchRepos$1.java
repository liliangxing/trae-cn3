package com.bytedance.trae.conversation.git;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.GitRemoteRepository;
import com.bytedance.trae.conversation.network.GitRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$searchRepos$1", f = "GitSelectionViewModel.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel$searchRepos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$searchRepos$1(String str, GitSelectionViewModel gitSelectionViewModel, Continuation<? super GitSelectionViewModel$searchRepos$1> continuation) {
        super(2, continuation);
        this.$keyword = str;
        this.this$0 = gitSelectionViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$searchRepos$1(this.$keyword, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = GitRemoteRepository.INSTANCE.getInstance().searchRepos(this.$keyword, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GitRemoteRepository.Result result = (GitRemoteRepository.Result) obj;
        if (result.getSuccess()) {
            mutableLiveData = this.this$0._selectedRepo;
            GitRepoItem gitRepoItem = (GitRepoItem) mutableLiveData.getValue();
            String id = gitRepoItem != null ? gitRepoItem.getId() : null;
            mutableLiveData2 = this.this$0._repoSearchResult;
            List<GitRepository> items = result.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (GitRepository gitRepository : items) {
                arrayList.add(new GitRepoItem(gitRepository.getRepoId(), gitRepository.getFullName(), gitRepository.getName(), gitRepository.getUrl(), Intrinsics.areEqual(gitRepository.getRepoId(), id), false, 32, null));
            }
            mutableLiveData2.setValue(arrayList);
        }
        return Unit.INSTANCE;
    }
}
