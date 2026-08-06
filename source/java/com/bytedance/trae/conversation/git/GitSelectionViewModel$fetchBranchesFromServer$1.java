package com.bytedance.trae.conversation.git;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.network.GitBranch;
import com.bytedance.trae.conversation.network.GitRemoteRepository;
import com.bytedance.trae.conversation.network.ListBranchesData;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$fetchBranchesFromServer$1", f = "GitSelectionViewModel.kt", i = {}, l = {332, 338}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel$fetchBranchesFromServer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $repoUrl;
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$fetchBranchesFromServer$1(String str, GitSelectionViewModel gitSelectionViewModel, Continuation<? super GitSelectionViewModel$fetchBranchesFromServer$1> continuation) {
        super(2, continuation);
        this.$repoUrl = str;
        this.this$0 = gitSelectionViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$fetchBranchesFromServer$1(this.$repoUrl, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HttpDataResult httpDataResult;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        ArrayList emptyList;
        MutableLiveData mutableLiveData4;
        List<GitBranch> items;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                this.label = 2;
                obj = GitRemoteRepository.INSTANCE.getInstance().fetchBranches(this.$repoUrl, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpDataResult = (HttpDataResult) obj;
            } else {
                GitRemoteRepository companion = GitRemoteRepository.INSTANCE.getInstance();
                String str = this.$repoUrl;
                Integer boxInt = Boxing.boxInt(50);
                this.label = 1;
                obj = companion.fetchBranches(str, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : boxInt, (r13 & 8) != 0 ? null : "1", (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                httpDataResult = (HttpDataResult) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            httpDataResult = (HttpDataResult) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            httpDataResult = (HttpDataResult) obj;
        }
        mutableLiveData = this.this$0._branchLoading;
        mutableLiveData.setValue(Boxing.boxBoolean(false));
        if (httpDataResult instanceof HttpDataResult.Success) {
            HttpDataResult.Success success = (HttpDataResult.Success) httpDataResult;
            if (success.getBizResp().isSuccess()) {
                ListBranchesData listBranchesData = (ListBranchesData) success.getBizResp().getData();
                this.this$0.branchNextPageToken = listBranchesData != null ? listBranchesData.getNextPageToken() : null;
                if (listBranchesData == null || (items = listBranchesData.getItems()) == null) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    List<GitBranch> list = items;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (GitBranch gitBranch : list) {
                        arrayList.add(new BranchItem(gitBranch.getName(), gitBranch.getName(), Intrinsics.areEqual(gitBranch.isDefault(), Boxing.boxBoolean(true)), false, 8, null));
                    }
                    emptyList = arrayList;
                }
                this.this$0.cachedBranchItems = emptyList;
                mutableLiveData4 = this.this$0._branchRefreshResult;
                mutableLiveData4.setValue(emptyList);
                return Unit.INSTANCE;
            }
        }
        mutableLiveData2 = this.this$0._branchRefreshResult;
        mutableLiveData2.setValue(CollectionsKt.emptyList());
        mutableLiveData3 = this.this$0._branchLoadError;
        mutableLiveData3.setValue("");
        return Unit.INSTANCE;
    }
}
