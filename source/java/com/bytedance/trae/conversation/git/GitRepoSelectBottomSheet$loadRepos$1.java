package com.bytedance.trae.conversation.git;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.bytedance.trae.conversation.network.GitRemoteRepository;
import com.bytedance.trae.conversation.network.GitRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.bytedance.trae.multilanguage.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GitRepoSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$loadRepos$1", f = "GitRepoSelectBottomSheet.kt", i = {1, 1}, l = {266, 270}, m = "invokeSuspend", n = {"result", "searchRepo"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRepoSelectBottomSheet$loadRepos$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GitRepoSelectBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GitRepoSelectBottomSheet$loadRepos$1(GitRepoSelectBottomSheet gitRepoSelectBottomSheet, Continuation<? super GitRepoSelectBottomSheet$loadRepos$1> continuation) {
        super(2, continuation);
        this.this$0 = gitRepoSelectBottomSheet;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GitRepoSelectBottomSheet$loadRepos$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0211, code lost:
    
        if (r1 != false) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object fetchReposPage;
        ProgressBar progressBar;
        View view;
        List list;
        GitRepoItemAdapter gitRepoItemAdapter;
        List list2;
        GitRemoteRepository.Result result;
        Ref.ObjectRef objectRef;
        Object searchRepos;
        Ref.ObjectRef objectRef2;
        View view2;
        ProgressBar progressBar2;
        Long errorCode;
        View view3;
        ArrayList arrayList;
        List list3;
        GitRepoItemAdapter gitRepoItemAdapter2;
        List list4;
        GitSelectionViewModel gitSelectionViewModel;
        GitSelectionViewModel gitSelectionViewModel2;
        boolean z;
        View view4;
        View view5;
        GitRemoteRepository.Result result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                List<GitRepository> cachedRepos = GitRemoteRepository.INSTANCE.getInstance().getCachedRepos();
                if (!cachedRepos.isEmpty()) {
                    progressBar = this.this$0.progressBar;
                    if (progressBar != null) {
                        progressBar.setVisibility(8);
                    }
                    view = this.this$0.contentView;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    GitRepoSelectBottomSheet gitRepoSelectBottomSheet = this.this$0;
                    List<GitRepository> list5 = cachedRepos;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    for (GitRepository gitRepository : list5) {
                        String repoId = gitRepository.getRepoId();
                        String fullName = gitRepository.getFullName();
                        String name = gitRepository.getName();
                        String url = gitRepository.getUrl();
                        String repoId2 = gitRepository.getRepoId();
                        GitRepoItem selectedRepo = gitRepoSelectBottomSheet.getSelectedRepo();
                        arrayList2.add(new GitRepoItem(repoId, fullName, name, url, Intrinsics.areEqual(repoId2, selectedRepo != null ? selectedRepo.getId() : null), false, 32, null));
                    }
                    gitRepoSelectBottomSheet.repoItems = arrayList2;
                    GitRepoSelectBottomSheet gitRepoSelectBottomSheet2 = this.this$0;
                    list = gitRepoSelectBottomSheet2.repoItems;
                    gitRepoSelectBottomSheet2.fullRepoItems = list;
                    gitRepoItemAdapter = this.this$0.adapter;
                    if (gitRepoItemAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        gitRepoItemAdapter = null;
                    }
                    list2 = this.this$0.repoItems;
                    gitRepoItemAdapter.submitList(list2);
                }
            }
            this.label = 1;
            fetchReposPage = GitRemoteRepository.INSTANCE.getInstance().fetchReposPage(50, null, (Continuation) this);
            if (fetchReposPage == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) this.L$1;
                result = (GitRemoteRepository.Result) this.L$0;
                ResultKt.throwOnFailure(obj);
                searchRepos = obj;
                result2 = (GitRemoteRepository.Result) searchRepos;
                if (result2.getSuccess() && (!result2.getItems().isEmpty())) {
                    GitRepository gitRepository2 = result2.getItems().get(0);
                    objectRef2.element = new GitRepoItem(gitRepository2.getRepoId(), gitRepository2.getFullName(), gitRepository2.getName(), gitRepository2.getUrl(), true, false, 32, null);
                }
                objectRef = objectRef2;
                view2 = this.this$0.contentView;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                progressBar2 = this.this$0.progressBar;
                if (progressBar2 != null) {
                    progressBar2.setVisibility(8);
                }
                if (!result.getSuccess()) {
                    if (!result.getItems().isEmpty() || objectRef.element != null) {
                        view3 = this.this$0.emptyStateView;
                        if (view3 != null) {
                            view3.setVisibility(8);
                        }
                        if (objectRef.element != null) {
                            List<GitRepository> items = result.getItems();
                            if (!(items instanceof Collection) || !items.isEmpty()) {
                                Iterator<T> it = items.iterator();
                                while (it.hasNext()) {
                                    if (Intrinsics.areEqual(((GitRepository) it.next()).getRepoId(), ((GitRepoItem) objectRef.element).getId())) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                        }
                        z2 = false;
                        GitRepoSelectBottomSheet gitRepoSelectBottomSheet3 = this.this$0;
                        if (z2 || objectRef.element == null) {
                            List<GitRepository> items2 = result.getItems();
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items2, 10));
                            for (GitRepository gitRepository3 : items2) {
                                String repoId3 = gitRepository3.getRepoId();
                                String fullName2 = gitRepository3.getFullName();
                                String name2 = gitRepository3.getName();
                                String url2 = gitRepository3.getUrl();
                                String repoId4 = gitRepository3.getRepoId();
                                GitRepoItem gitRepoItem = (GitRepoItem) objectRef.element;
                                arrayList3.add(new GitRepoItem(repoId3, fullName2, name2, url2, Intrinsics.areEqual(repoId4, gitRepoItem != null ? gitRepoItem.getId() : null), false, 32, null));
                            }
                            arrayList = arrayList3;
                        } else {
                            List listOf = CollectionsKt.listOf(objectRef.element);
                            List<GitRepository> items3 = result.getItems();
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(items3, 10));
                            for (GitRepository gitRepository4 : items3) {
                                arrayList4.add(new GitRepoItem(gitRepository4.getRepoId(), gitRepository4.getFullName(), gitRepository4.getName(), gitRepository4.getUrl(), false, false, 32, null));
                            }
                            arrayList = CollectionsKt.plus(listOf, arrayList4);
                        }
                        gitRepoSelectBottomSheet3.repoItems = arrayList;
                        GitRepoSelectBottomSheet gitRepoSelectBottomSheet4 = this.this$0;
                        list3 = gitRepoSelectBottomSheet4.repoItems;
                        gitRepoSelectBottomSheet4.fullRepoItems = list3;
                        gitRepoItemAdapter2 = this.this$0.adapter;
                        if (gitRepoItemAdapter2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("adapter");
                            gitRepoItemAdapter2 = null;
                        }
                        list4 = this.this$0.repoItems;
                        gitRepoItemAdapter2.submitList(list4);
                        gitSelectionViewModel = this.this$0.gitViewModel;
                        if (gitSelectionViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                            gitSelectionViewModel2 = null;
                        } else {
                            gitSelectionViewModel2 = gitSelectionViewModel;
                        }
                        gitSelectionViewModel2.setRepoNextPageToken(result.getNextPageToken());
                    } else {
                        view4 = this.this$0.contentView;
                        if (view4 != null) {
                            view4.setVisibility(8);
                        }
                        view5 = this.this$0.emptyStateView;
                        if (view5 != null) {
                            view5.setVisibility(0);
                        }
                    }
                } else {
                    Long errorCode2 = result.getErrorCode();
                    if ((errorCode2 != null && errorCode2.longValue() == GitRemoteRepository.CODE_GIT_DISCONNECTED) || ((errorCode = result.getErrorCode()) != null && errorCode.longValue() == GitRemoteRepository.CODE_GIT_TOKEN_EXPIRE)) {
                        this.this$0.dismissAllowingStateLoss();
                        Function0<Unit> onAuthFailed = this.this$0.getOnAuthFailed();
                        if (onAuthFailed != null) {
                            onAuthFailed.invoke();
                        }
                    } else {
                        Toast.makeText(this.this$0.requireContext(), R.string.trae_conversation_network_retry, 0).show();
                    }
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            fetchReposPage = obj;
        }
        result = (GitRemoteRepository.Result) fetchReposPage;
        objectRef = new Ref.ObjectRef();
        GitRepoItem selectedRepo2 = this.this$0.getSelectedRepo();
        String title = selectedRepo2 != null ? selectedRepo2.getTitle() : null;
        if (!(title == null || title.length() == 0)) {
            GitRemoteRepository companion = GitRemoteRepository.INSTANCE.getInstance();
            GitRepoItem selectedRepo3 = this.this$0.getSelectedRepo();
            Intrinsics.checkNotNull(selectedRepo3);
            this.L$0 = result;
            this.L$1 = objectRef;
            this.label = 2;
            searchRepos = companion.searchRepos(selectedRepo3.getTitle(), (Continuation) this);
            if (searchRepos == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef2 = objectRef;
            result2 = (GitRemoteRepository.Result) searchRepos;
            if (result2.getSuccess()) {
                GitRepository gitRepository22 = result2.getItems().get(0);
                objectRef2.element = new GitRepoItem(gitRepository22.getRepoId(), gitRepository22.getFullName(), gitRepository22.getName(), gitRepository22.getUrl(), true, false, 32, null);
            }
            objectRef = objectRef2;
        }
        view2 = this.this$0.contentView;
        if (view2 != null) {
        }
        progressBar2 = this.this$0.progressBar;
        if (progressBar2 != null) {
        }
        if (!result.getSuccess()) {
        }
        return Unit.INSTANCE;
    }
}
