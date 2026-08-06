package com.bytedance.trae.conversation.git;

import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
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
import kotlinx.coroutines.DelayKt;

/* compiled from: GitRepoSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1", f = "GitRepoSelectBottomSheet.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ String $tempSelectedRepo;
    int label;
    final /* synthetic */ GitRepoSelectBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1(String str, GitRepoSelectBottomSheet gitRepoSelectBottomSheet, String str2, Continuation<? super GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1> continuation) {
        super(2, continuation);
        this.$keyword = str;
        this.this$0 = gitRepoSelectBottomSheet;
        this.$tempSelectedRepo = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1(this.$keyword, this.this$0, this.$tempSelectedRepo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object obj) {
        ProgressBar progressBar;
        RecyclerView recyclerView;
        TextView textView;
        GitSelectionViewModel gitSelectionViewModel;
        ProgressBar progressBar2;
        RecyclerView recyclerView2;
        TextView textView2;
        List list;
        GitRepoItemAdapter gitRepoItemAdapter;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(300L, (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GitSelectionViewModel gitSelectionViewModel2 = null;
        GitRepoItemAdapter gitRepoItemAdapter2 = null;
        if ((this.$keyword.length() == 0) != false) {
            this.this$0.isSearching = false;
            progressBar2 = this.this$0.searchLoadingBar;
            if (progressBar2 != null) {
                progressBar2.setVisibility(8);
            }
            recyclerView2 = this.this$0.rvRepositories;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            textView2 = this.this$0.tvSearchEmpty;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            GitRepoSelectBottomSheet gitRepoSelectBottomSheet = this.this$0;
            list = gitRepoSelectBottomSheet.fullRepoItems;
            List<GitRepoItem> list3 = list;
            String str = this.$tempSelectedRepo;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            for (GitRepoItem gitRepoItem : list3) {
                arrayList.add(GitRepoItem.copy$default(gitRepoItem, null, null, null, null, Intrinsics.areEqual(gitRepoItem.getId(), str), false, 47, null));
            }
            gitRepoSelectBottomSheet.repoItems = arrayList;
            gitRepoItemAdapter = this.this$0.adapter;
            if (gitRepoItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                gitRepoItemAdapter2 = gitRepoItemAdapter;
            }
            list2 = this.this$0.repoItems;
            gitRepoItemAdapter2.submitList(list2);
        } else {
            this.this$0.isSearching = true;
            progressBar = this.this$0.searchLoadingBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            recyclerView = this.this$0.rvRepositories;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            textView = this.this$0.tvSearchEmpty;
            if (textView != null) {
                textView.setVisibility(8);
            }
            gitSelectionViewModel = this.this$0.gitViewModel;
            if (gitSelectionViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            } else {
                gitSelectionViewModel2 = gitSelectionViewModel;
            }
            gitSelectionViewModel2.searchRepos(this.$keyword);
        }
        return Unit.INSTANCE;
    }
}
