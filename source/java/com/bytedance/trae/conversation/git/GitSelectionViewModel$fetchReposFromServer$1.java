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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$fetchReposFromServer$1", f = "GitSelectionViewModel.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class GitSelectionViewModel$fetchReposFromServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$fetchReposFromServer$1(GitSelectionViewModel gitSelectionViewModel, Continuation<? super GitSelectionViewModel$fetchReposFromServer$1> continuation) {
        super(2, continuation);
        this.this$0 = gitSelectionViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$fetchReposFromServer$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._repoLoading;
            mutableLiveData.setValue(Boxing.boxBoolean(true));
            this.label = 1;
            obj = GitRemoteRepository.INSTANCE.getInstance().fetchReposPage(50, null, (Continuation) this);
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
        mutableLiveData2 = this.this$0._repoLoading;
        mutableLiveData2.setValue(Boxing.boxBoolean(false));
        if (result.getSuccess()) {
            this.this$0.repoNextPageToken = result.getNextPageToken();
            mutableLiveData4 = this.this$0._selectedRepo;
            GitRepoItem gitRepoItem = (GitRepoItem) mutableLiveData4.getValue();
            String id = gitRepoItem != null ? gitRepoItem.getId() : null;
            GitSelectionViewModel gitSelectionViewModel = this.this$0;
            List<GitRepository> items = result.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (GitRepository gitRepository : items) {
                arrayList.add(new GitRepoItem(gitRepository.getRepoId(), gitRepository.getFullName(), gitRepository.getName(), gitRepository.getUrl(), Intrinsics.areEqual(gitRepository.getRepoId(), id), false, 32, null));
            }
            gitSelectionViewModel.cachedRepoItems = arrayList;
            mutableLiveData5 = this.this$0._repoListReady;
            list = this.this$0.cachedRepoItems;
            mutableLiveData5.setValue(list);
        } else {
            mutableLiveData3 = this.this$0._repoLoadError;
            mutableLiveData3.setValue(result.getErrorMessage());
        }
        return Unit.INSTANCE;
    }
}
