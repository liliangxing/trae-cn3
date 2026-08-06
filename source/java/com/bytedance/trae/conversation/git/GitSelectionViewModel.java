package com.bytedance.trae.conversation.git;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: GitSelectionViewModel.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u0000 c2\u00020\u0001:\u0001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020L2\u0006\u0010N\u001a\u00020\u000eJ\u0006\u0010O\u001a\u00020LJ\u000e\u0010P\u001a\u00020L2\u0006\u0010Q\u001a\u000202J\u0006\u0010R\u001a\u00020LJ\u0006\u0010S\u001a\u00020LJ\u000e\u0010T\u001a\u00020L2\u0006\u0010Q\u001a\u000202J\u0006\u0010U\u001a\u00020LJ\u0006\u0010V\u001a\u00020LJ\u0006\u0010W\u001a\u00020LJ\u0006\u0010X\u001a\u00020LJ\u0006\u0010Y\u001a\u00020LJ\u000e\u0010Z\u001a\u00020L2\u0006\u0010N\u001a\u00020\u000eJ\u0010\u0010[\u001a\u00020L2\b\u0010\\\u001a\u0004\u0018\u00010\u0012J\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00120\rJ\u0010\u0010_\u001a\u00020L2\b\u0010`\u001a\u0004\u0018\u000102J\u0016\u0010a\u001a\u00020L2\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00120\rH\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000bR\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000bR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\"0\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u000bR\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u000bR\u001a\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u000bR\u0016\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u000bR\u0016\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000bR\u001a\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\t¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000bR\u001a\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u000bR\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010A\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0010\u0010D\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010E\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bF\u0010CR\u0010\u0010G\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010I\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bJ\u0010C¨\u0006d"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_gitConnectionState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/trae/conversation/git/GitConnectionState;", "kotlin.jvm.PlatformType", "gitConnectionState", "Landroidx/lifecycle/LiveData;", "getGitConnectionState", "()Landroidx/lifecycle/LiveData;", "_repoListReady", "", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "repoListReady", "getRepoListReady", "_branchListReady", "Lcom/bytedance/trae/conversation/git/BranchItem;", "branchListReady", "getBranchListReady", "_branchLoadMoreResult", "branchLoadMoreResult", "getBranchLoadMoreResult", "_branchRefreshResult", "branchRefreshResult", "getBranchRefreshResult", "_selectedRepo", "selectedRepo", "getSelectedRepo", "_selectedBranch", "selectedBranch", "getSelectedBranch", "_repoLoading", "", "repoLoading", "getRepoLoading", "_branchLoading", "branchLoading", "getBranchLoading", "_branchLoadingMore", "branchLoadingMore", "getBranchLoadingMore", "_repoLoadingMore", "repoLoadingMore", "getRepoLoadingMore", "_repoLoadMoreResult", "repoLoadMoreResult", "getRepoLoadMoreResult", "_repoLoadError", "", "repoLoadError", "getRepoLoadError", "_branchLoadError", "branchLoadError", "getBranchLoadError", "_repoSearchResult", "repoSearchResult", "getRepoSearchResult", "_branchSearchResult", "branchSearchResult", "getBranchSearchResult", "cachedRepoItems", "cachedBranchItems", "branchNextPageToken", "hasMoreBranches", "getHasMoreBranches", "()Z", "repoNextPageToken", "hasMoreRepos", "getHasMoreRepos", "searchNextPageToken", "currentSearchKeyword", "hasMoreSearchResults", "getHasMoreSearchResults", "fetchRepos", "", "updateSelectRepo", "repo", "loadRepos", "searchRepos", "keyword", "fetchReposFromServer", "loadMoreRepos", "searchBranches", "loadBranches", "loadBranchesAndAutoSelect", "loadMoreBranches", "loadMoreSearchResults", "fetchBranchesFromServer", "selectRepo", "selectBranch", "branch", "getCachedRepoItems", "getCachedBranchItems", "setRepoNextPageToken", "token", "selectDefaultBranch", "branches", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitSelectionViewModel extends ViewModel {
    public static final String KEY_SELECTED_REPO = "selected_repo";
    private static final int PAGE_SIZE = 50;
    private final MutableLiveData<List<BranchItem>> _branchListReady;
    private final MutableLiveData<String> _branchLoadError;
    private final MutableLiveData<List<BranchItem>> _branchLoadMoreResult;
    private final MutableLiveData<Boolean> _branchLoading;
    private final MutableLiveData<Boolean> _branchLoadingMore;
    private final MutableLiveData<List<BranchItem>> _branchRefreshResult;
    private final MutableLiveData<List<BranchItem>> _branchSearchResult;
    private final MutableLiveData<GitConnectionState> _gitConnectionState;
    private final MutableLiveData<List<GitRepoItem>> _repoListReady;
    private final MutableLiveData<String> _repoLoadError;
    private final MutableLiveData<List<GitRepoItem>> _repoLoadMoreResult;
    private final MutableLiveData<Boolean> _repoLoading;
    private final MutableLiveData<Boolean> _repoLoadingMore;
    private final MutableLiveData<List<GitRepoItem>> _repoSearchResult;
    private final MutableLiveData<BranchItem> _selectedBranch;
    private final MutableLiveData<GitRepoItem> _selectedRepo;
    private final LiveData<List<BranchItem>> branchListReady;
    private final LiveData<String> branchLoadError;
    private final LiveData<List<BranchItem>> branchLoadMoreResult;
    private final LiveData<Boolean> branchLoading;
    private final LiveData<Boolean> branchLoadingMore;
    private String branchNextPageToken;
    private final LiveData<List<BranchItem>> branchRefreshResult;
    private final LiveData<List<BranchItem>> branchSearchResult;
    private List<BranchItem> cachedBranchItems;
    private List<GitRepoItem> cachedRepoItems;
    private String currentSearchKeyword;
    private final LiveData<GitConnectionState> gitConnectionState;
    private final LiveData<List<GitRepoItem>> repoListReady;
    private final LiveData<String> repoLoadError;
    private final LiveData<List<GitRepoItem>> repoLoadMoreResult;
    private final LiveData<Boolean> repoLoading;
    private final LiveData<Boolean> repoLoadingMore;
    private String repoNextPageToken;
    private final LiveData<List<GitRepoItem>> repoSearchResult;
    private String searchNextPageToken;
    private final LiveData<BranchItem> selectedBranch;
    private final LiveData<GitRepoItem> selectedRepo;

    public GitSelectionViewModel() {
        LiveData<GitConnectionState> mutableLiveData = new MutableLiveData<>(GitConnectionState.DISCONNECTED);
        this._gitConnectionState = mutableLiveData;
        this.gitConnectionState = mutableLiveData;
        LiveData<List<GitRepoItem>> mutableLiveData2 = new MutableLiveData<>();
        this._repoListReady = mutableLiveData2;
        this.repoListReady = mutableLiveData2;
        LiveData<List<BranchItem>> mutableLiveData3 = new MutableLiveData<>();
        this._branchListReady = mutableLiveData3;
        this.branchListReady = mutableLiveData3;
        LiveData<List<BranchItem>> mutableLiveData4 = new MutableLiveData<>();
        this._branchLoadMoreResult = mutableLiveData4;
        this.branchLoadMoreResult = mutableLiveData4;
        LiveData<List<BranchItem>> mutableLiveData5 = new MutableLiveData<>();
        this._branchRefreshResult = mutableLiveData5;
        this.branchRefreshResult = mutableLiveData5;
        LiveData<GitRepoItem> mutableLiveData6 = new MutableLiveData<>();
        this._selectedRepo = mutableLiveData6;
        this.selectedRepo = mutableLiveData6;
        LiveData<BranchItem> mutableLiveData7 = new MutableLiveData<>();
        this._selectedBranch = mutableLiveData7;
        this.selectedBranch = mutableLiveData7;
        LiveData<Boolean> mutableLiveData8 = new MutableLiveData<>();
        this._repoLoading = mutableLiveData8;
        this.repoLoading = mutableLiveData8;
        LiveData<Boolean> mutableLiveData9 = new MutableLiveData<>();
        this._branchLoading = mutableLiveData9;
        this.branchLoading = mutableLiveData9;
        LiveData<Boolean> mutableLiveData10 = new MutableLiveData<>();
        this._branchLoadingMore = mutableLiveData10;
        this.branchLoadingMore = mutableLiveData10;
        LiveData<Boolean> mutableLiveData11 = new MutableLiveData<>();
        this._repoLoadingMore = mutableLiveData11;
        this.repoLoadingMore = mutableLiveData11;
        LiveData<List<GitRepoItem>> mutableLiveData12 = new MutableLiveData<>();
        this._repoLoadMoreResult = mutableLiveData12;
        this.repoLoadMoreResult = mutableLiveData12;
        LiveData<String> mutableLiveData13 = new MutableLiveData<>();
        this._repoLoadError = mutableLiveData13;
        this.repoLoadError = mutableLiveData13;
        LiveData<String> mutableLiveData14 = new MutableLiveData<>();
        this._branchLoadError = mutableLiveData14;
        this.branchLoadError = mutableLiveData14;
        LiveData<List<GitRepoItem>> mutableLiveData15 = new MutableLiveData<>();
        this._repoSearchResult = mutableLiveData15;
        this.repoSearchResult = mutableLiveData15;
        LiveData<List<BranchItem>> mutableLiveData16 = new MutableLiveData<>();
        this._branchSearchResult = mutableLiveData16;
        this.branchSearchResult = mutableLiveData16;
        this.cachedRepoItems = CollectionsKt.emptyList();
        this.cachedBranchItems = CollectionsKt.emptyList();
    }

    public final LiveData<GitConnectionState> getGitConnectionState() {
        return this.gitConnectionState;
    }

    public final LiveData<List<GitRepoItem>> getRepoListReady() {
        return this.repoListReady;
    }

    public final LiveData<List<BranchItem>> getBranchListReady() {
        return this.branchListReady;
    }

    public final LiveData<List<BranchItem>> getBranchLoadMoreResult() {
        return this.branchLoadMoreResult;
    }

    public final LiveData<List<BranchItem>> getBranchRefreshResult() {
        return this.branchRefreshResult;
    }

    public final LiveData<GitRepoItem> getSelectedRepo() {
        return this.selectedRepo;
    }

    public final LiveData<BranchItem> getSelectedBranch() {
        return this.selectedBranch;
    }

    public final LiveData<Boolean> getRepoLoading() {
        return this.repoLoading;
    }

    public final LiveData<Boolean> getBranchLoading() {
        return this.branchLoading;
    }

    public final LiveData<Boolean> getBranchLoadingMore() {
        return this.branchLoadingMore;
    }

    public final LiveData<Boolean> getRepoLoadingMore() {
        return this.repoLoadingMore;
    }

    public final LiveData<List<GitRepoItem>> getRepoLoadMoreResult() {
        return this.repoLoadMoreResult;
    }

    public final LiveData<String> getRepoLoadError() {
        return this.repoLoadError;
    }

    public final LiveData<String> getBranchLoadError() {
        return this.branchLoadError;
    }

    public final LiveData<List<GitRepoItem>> getRepoSearchResult() {
        return this.repoSearchResult;
    }

    public final LiveData<List<BranchItem>> getBranchSearchResult() {
        return this.branchSearchResult;
    }

    public final boolean getHasMoreBranches() {
        String str = this.branchNextPageToken;
        return !(str == null || str.length() == 0);
    }

    public final boolean getHasMoreRepos() {
        String str = this.repoNextPageToken;
        return !(str == null || str.length() == 0);
    }

    public final boolean getHasMoreSearchResults() {
        String str = this.searchNextPageToken;
        return !(str == null || str.length() == 0);
    }

    public final void fetchRepos() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$fetchRepos$1(this, null), 3, (Object) null);
    }

    public final void updateSelectRepo(GitRepoItem repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        this._selectedRepo.setValue(repo);
    }

    public final void loadRepos() {
        if (Intrinsics.areEqual(this._repoLoading.getValue(), true)) {
            return;
        }
        this._repoLoading.setValue(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadRepos$1(this, null), 3, (Object) null);
    }

    public final void searchRepos(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$searchRepos$1(keyword, this, null), 3, (Object) null);
    }

    public final void fetchReposFromServer() {
        this.repoNextPageToken = null;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$fetchReposFromServer$1(this, null), 3, (Object) null);
    }

    public final void loadMoreRepos() {
        String str = this.repoNextPageToken;
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(this._repoLoadingMore.getValue(), true)) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadMoreRepos$1(this, str, null), 3, (Object) null);
    }

    public final void searchBranches(String keyword) {
        String repoUrl;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null) {
            return;
        }
        this.currentSearchKeyword = keyword;
        this.searchNextPageToken = null;
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$searchBranches$1(this, repoUrl, keyword, null), 3, (Object) null);
    }

    public final void loadBranches() {
        String repoUrl;
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadBranches$1(this, repoUrl, null), 3, (Object) null);
    }

    public final void loadBranchesAndAutoSelect() {
        String repoUrl;
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadBranchesAndAutoSelect$1(this, repoUrl, null), 3, (Object) null);
    }

    public final void loadMoreBranches() {
        String repoUrl;
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null) {
            return;
        }
        String str = this.branchNextPageToken;
        String str2 = str;
        if ((str2 == null || str2.length() == 0) || Intrinsics.areEqual(this._branchLoadingMore.getValue(), true)) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadMoreBranches$1(this, repoUrl, str, null), 3, (Object) null);
    }

    public final void loadMoreSearchResults() {
        String repoUrl;
        String str;
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null || (str = this.currentSearchKeyword) == null) {
            return;
        }
        String str2 = this.searchNextPageToken;
        String str3 = str2;
        if ((str3 == null || str3.length() == 0) || Intrinsics.areEqual(this._branchLoadingMore.getValue(), true)) {
            return;
        }
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$loadMoreSearchResults$1(this, repoUrl, str, str2, null), 3, (Object) null);
    }

    public final void fetchBranchesFromServer() {
        String repoUrl;
        GitRepoItem gitRepoItem = (GitRepoItem) this._selectedRepo.getValue();
        if (gitRepoItem == null || (repoUrl = gitRepoItem.getRepoUrl()) == null) {
            return;
        }
        this._branchLoading.setValue(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GitSelectionViewModel$fetchBranchesFromServer$1(repoUrl, this, null), 3, (Object) null);
    }

    public final void selectRepo(GitRepoItem repo) {
        Intrinsics.checkNotNullParameter(repo, "repo");
        GitRepoItem gitRepoItem = (GitRepoItem) this.selectedRepo.getValue();
        if (Intrinsics.areEqual(gitRepoItem != null ? gitRepoItem.getRepoUrl() : null, repo.getRepoUrl())) {
            this._selectedRepo.setValue(repo);
            return;
        }
        if (TextUtils.isEmpty(repo.getRepoUrl())) {
            this._selectedRepo.setValue((Object) null);
        } else {
            this._selectedRepo.setValue(repo);
        }
        this._selectedBranch.setValue((Object) null);
        this._branchRefreshResult.setValue(CollectionsKt.emptyList());
        this.cachedBranchItems = CollectionsKt.emptyList();
        List<GitRepoItem> list = this.cachedRepoItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (GitRepoItem gitRepoItem2 : list) {
            arrayList.add(GitRepoItem.copy$default(gitRepoItem2, null, null, null, null, Intrinsics.areEqual(gitRepoItem2.getId(), repo.getId()), false, 47, null));
        }
        this.cachedRepoItems = arrayList;
        if (TextUtils.isEmpty(repo.getRepoUrl())) {
            return;
        }
        loadBranchesAndAutoSelect();
    }

    public final void selectBranch(BranchItem branch) {
        this._selectedBranch.setValue(branch);
    }

    public final List<GitRepoItem> getCachedRepoItems() {
        return this.cachedRepoItems;
    }

    public final List<BranchItem> getCachedBranchItems() {
        return this.cachedBranchItems;
    }

    public final void setRepoNextPageToken(String token) {
        this.repoNextPageToken = token;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectDefaultBranch(List<BranchItem> branches) {
        Object obj;
        if (branches.isEmpty()) {
            return;
        }
        Iterator it = CollectionsKt.listOf(new String[]{"master", "main", "develop"}).iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            Iterator<T> it2 = branches.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((BranchItem) next).getName(), str)) {
                    obj = next;
                    break;
                }
            }
            obj = (BranchItem) obj;
        } while (obj == null);
        if (obj == null) {
            obj = (BranchItem) CollectionsKt.first(branches);
        }
        this._selectedBranch.setValue(obj);
    }
}
