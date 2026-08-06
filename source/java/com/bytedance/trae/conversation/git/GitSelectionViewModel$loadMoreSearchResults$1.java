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
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$loadMoreSearchResults$1", f = "GitSelectionViewModel.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel$loadMoreSearchResults$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $pageToken;
    final /* synthetic */ String $repoUrl;
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$loadMoreSearchResults$1(GitSelectionViewModel gitSelectionViewModel, String str, String str2, String str3, Continuation<? super GitSelectionViewModel$loadMoreSearchResults$1> continuation) {
        super(2, continuation);
        this.this$0 = gitSelectionViewModel;
        this.$repoUrl = str;
        this.$keyword = str2;
        this.$pageToken = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$loadMoreSearchResults$1(this.this$0, this.$repoUrl, this.$keyword, this.$pageToken, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        ArrayList emptyList;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        List<GitBranch> items;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._branchLoadingMore;
            mutableLiveData.setValue(Boxing.boxBoolean(true));
            this.label = 1;
            obj = GitRemoteRepository.INSTANCE.getInstance().fetchBranches(this.$repoUrl, this.$keyword, Boxing.boxInt(50), this.$pageToken, (Continuation) this);
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
                this.this$0.searchNextPageToken = listBranchesData != null ? listBranchesData.getNextPageToken() : null;
                if (listBranchesData == null || (items = listBranchesData.getItems()) == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    List<GitBranch> list = items;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (GitBranch gitBranch : list) {
                        arrayList.add(new BranchItem(gitBranch.getName(), gitBranch.getName(), false, false, 12, null));
                    }
                    emptyList = arrayList;
                }
                mutableLiveData3 = this.this$0._branchSearchResult;
                mutableLiveData4 = this.this$0._branchSearchResult;
                List list2 = (List) mutableLiveData4.getValue();
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                mutableLiveData3.setValue(CollectionsKt.plus(list2, emptyList));
            }
        }
        return Unit.INSTANCE;
    }
}
