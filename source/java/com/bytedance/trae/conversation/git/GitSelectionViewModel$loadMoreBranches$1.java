package com.bytedance.trae.conversation.git;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.GitBranch;
import com.bytedance.trae.conversation.network.GitRemoteRepository;
import com.bytedance.trae.conversation.network.ListBranchesData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.response.HttpDataResult;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$loadMoreBranches$1", f = "GitSelectionViewModel.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel$loadMoreBranches$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $pageToken;
    final /* synthetic */ String $repoUrl;
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$loadMoreBranches$1(GitSelectionViewModel gitSelectionViewModel, String str, String str2, Continuation<? super GitSelectionViewModel$loadMoreBranches$1> continuation) {
        super(2, continuation);
        this.this$0 = gitSelectionViewModel;
        this.$repoUrl = str;
        this.$pageToken = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$loadMoreBranches$1(this.this$0, this.$repoUrl, this.$pageToken, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ArrayList emptyList;
        List list;
        MutableLiveData mutableLiveData3;
        List<GitBranch> items;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._branchLoadingMore;
            mutableLiveData.setValue(Boxing.boxBoolean(true));
            this.label = 1;
            obj = GitRemoteRepository.INSTANCE.getInstance().listBranches(this.$repoUrl, Boxing.boxInt(50), this.$pageToken, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        mutableLiveData2 = this.this$0._branchLoadingMore;
        mutableLiveData2.setValue(Boxing.boxBoolean(false));
        if (success instanceof HttpDataResult.Success) {
            HttpDataResult.Success success2 = success;
            if (success2.getBizResp().isSuccess()) {
                ListBranchesData listBranchesData = (ListBranchesData) success2.getBizResp().getData();
                this.this$0.branchNextPageToken = listBranchesData != null ? listBranchesData.getNextPageToken() : null;
                if (listBranchesData == null || (items = listBranchesData.getItems()) == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    List<GitBranch> list2 = items;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    for (GitBranch gitBranch : list2) {
                        arrayList.add(new BranchItem(gitBranch.getName(), gitBranch.getName(), false, false, 12, null));
                    }
                    emptyList = arrayList;
                }
                GitSelectionViewModel gitSelectionViewModel = this.this$0;
                list = gitSelectionViewModel.cachedBranchItems;
                gitSelectionViewModel.cachedBranchItems = CollectionsKt.plus(list, emptyList);
                mutableLiveData3 = this.this$0._branchLoadMoreResult;
                mutableLiveData3.setValue(emptyList);
            }
        }
        return Unit.INSTANCE;
    }
}
