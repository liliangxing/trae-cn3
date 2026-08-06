package com.bytedance.trae.conversation.git;

import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitSelectionViewModel$loadBranchesAndAutoSelect$1", f = "GitSelectionViewModel.kt", i = {}, l = {249, ReducerConstants.REQUEST_CODE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel$loadBranchesAndAutoSelect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $repoUrl;
    int label;
    final /* synthetic */ GitSelectionViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitSelectionViewModel$loadBranchesAndAutoSelect$1(GitSelectionViewModel gitSelectionViewModel, String str, Continuation<? super GitSelectionViewModel$loadBranchesAndAutoSelect$1> continuation) {
        super(2, continuation);
        this.this$0 = gitSelectionViewModel;
        this.$repoUrl = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitSelectionViewModel$loadBranchesAndAutoSelect$1(this.this$0, this.$repoUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        HttpDataResult httpDataResult;
        ArrayList emptyList;
        List<GitBranch> items;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.branchNextPageToken = null;
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
                        arrayList.add(new BranchItem(gitBranch.getName(), gitBranch.getName(), false, false, 12, null));
                    }
                    emptyList = arrayList;
                }
                this.this$0.cachedBranchItems = emptyList;
                this.this$0.selectDefaultBranch(emptyList);
            }
        }
        return Unit.INSTANCE;
    }
}
