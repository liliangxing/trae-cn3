package com.bytedance.trae.conversation.git;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: GitRepoSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u00010$2\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u001a\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020$2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\b\u0010=\u001a\u00020\u0007H\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onRepoSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "", "getOnRepoSelected", "()Lkotlin/jvm/functions/Function1;", "setOnRepoSelected", "(Lkotlin/jvm/functions/Function1;)V", "onAuthFailed", "Lkotlin/Function0;", "getOnAuthFailed", "()Lkotlin/jvm/functions/Function0;", "setOnAuthFailed", "(Lkotlin/jvm/functions/Function0;)V", "selectedRepo", "getSelectedRepo", "()Lcom/bytedance/trae/conversation/git/GitRepoItem;", "setSelectedRepo", "(Lcom/bytedance/trae/conversation/git/GitRepoItem;)V", "adapter", "Lcom/bytedance/trae/conversation/git/GitRepoItemAdapter;", "gitViewModel", "Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "repoItems", "", "fullRepoItems", "isLoadingMore", "", "progressBar", "Landroid/widget/ProgressBar;", "searchLoadingBar", "contentView", "Landroid/view/View;", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "searchJob", "Lkotlinx/coroutines/Job;", "isSearching", "ivSearchClear", "Landroid/widget/ImageView;", "rvRepositories", "Landroidx/recyclerview/widget/RecyclerView;", "tvSearchEmpty", "Landroid/widget/TextView;", "emptyStateView", "btnGoToGithub", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "loadRepos", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class GitRepoSelectBottomSheet extends BottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int PAGE_SIZE = 50;
    public static final String TAG = "GitRepoSelectBottomSheet";
    private GitRepoItemAdapter adapter;
    private TextView btnGoToGithub;
    private View contentView;
    private View emptyStateView;
    private GitSelectionViewModel gitViewModel;
    private boolean isLoadingMore;
    private boolean isSearching;
    private ImageView ivSearchClear;
    private Function0<Unit> onAuthFailed;
    private Function1<? super GitRepoItem, Unit> onRepoSelected;
    private ProgressBar progressBar;
    private RecyclerView rvRepositories;
    private Job searchJob;
    private ProgressBar searchLoadingBar;
    private GitRepoItem selectedRepo;
    private TraeTitleBar titleBar;
    private TextView tvSearchEmpty;
    private List<GitRepoItem> repoItems = CollectionsKt.emptyList();
    private List<GitRepoItem> fullRepoItems = CollectionsKt.emptyList();

    public final Function1<GitRepoItem, Unit> getOnRepoSelected() {
        return this.onRepoSelected;
    }

    public final void setOnRepoSelected(Function1<? super GitRepoItem, Unit> function1) {
        this.onRepoSelected = function1;
    }

    public final Function0<Unit> getOnAuthFailed() {
        return this.onAuthFailed;
    }

    public final void setOnAuthFailed(Function0<Unit> function0) {
        this.onAuthFailed = function0;
    }

    public final GitRepoItem getSelectedRepo() {
        return this.selectedRepo;
    }

    public final void setSelectedRepo(GitRepoItem gitRepoItem) {
        this.selectedRepo = gitRepoItem;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                GitRepoSelectBottomSheet.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, GitRepoSelectBottomSheet gitRepoSelectBottomSheet, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int i = (gitRepoSelectBottomSheet.getResources().getDisplayMetrics().heightPixels * 9) / 10;
            from.setPeekHeight(i);
            from.setState(3);
            from.setSkipCollapsed(true);
            from.setHideable(true);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_dialog_git_repo_select, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.gitViewModel = (GitSelectionViewModel) new ViewModelProvider(requireActivity).get(GitSelectionViewModel.class);
        this.rvRepositories = view.findViewById(C0637R.id.rv_repositories);
        final EditText editText = (EditText) view.findViewById(C0637R.id.et_search);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(C0637R.id.pb_loading_more);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        this.titleBar = traeTitleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setRightActionsVisible(false);
        }
        this.progressBar = (ProgressBar) view.findViewById(C0637R.id.progress_bar);
        this.contentView = view.findViewById(C0637R.id.layout_container);
        this.searchLoadingBar = (ProgressBar) view.findViewById(C0637R.id.pb_search_loading);
        this.ivSearchClear = (ImageView) view.findViewById(C0637R.id.iv_search_clear);
        this.tvSearchEmpty = (TextView) view.findViewById(C0637R.id.tv_search_empty);
        this.emptyStateView = view.findViewById(C0637R.id.layout_empty_state);
        this.btnGoToGithub = (TextView) view.findViewById(C0637R.id.btn_go_to_github);
        TextView textView = (TextView) view.findViewById(C0637R.id.tv_empty_hint);
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            if (textView != null) {
                textView.setText(com.bytedance.trae.multilanguage.R.string.trae_bits_code_branch_empty_hint);
            }
        } else if (textView != null) {
            textView.setText(com.bytedance.trae.multilanguage.R.string.trae_git_repo_empty_hint);
        }
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            TextView textView2 = this.btnGoToGithub;
            if (textView2 != null) {
                textView2.setText(com.bytedance.trae.multilanguage.R.string.trae_git_go_to_bits_code);
            }
        } else {
            TextView textView3 = this.btnGoToGithub;
            if (textView3 != null) {
                textView3.setText(com.bytedance.trae.multilanguage.R.string.trae_git_go_to_github);
            }
        }
        TextView textView4 = this.btnGoToGithub;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GitRepoSelectBottomSheet.onViewCreated$lambda$2(GitRepoSelectBottomSheet.this, view2);
                }
            });
        }
        GitRepoItem gitRepoItem = this.selectedRepo;
        GitSelectionViewModel gitSelectionViewModel = null;
        final String id = gitRepoItem != null ? gitRepoItem.getId() : null;
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = this.rvRepositories;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        RecyclerView.Adapter gitRepoItemAdapter = new GitRepoItemAdapter(new Function1() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = GitRepoSelectBottomSheet.onViewCreated$lambda$3(id, this, (GitRepoItem) obj);
                return onViewCreated$lambda$3;
            }
        });
        this.adapter = gitRepoItemAdapter;
        RecyclerView recyclerView2 = this.rvRepositories;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(gitRepoItemAdapter);
        }
        ImageView imageView = this.ivSearchClear;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GitRepoSelectBottomSheet.onViewCreated$lambda$4(editText, view2);
                }
            });
        }
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$onViewCreated$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                ImageView imageView2;
                Job job;
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                imageView2 = GitRepoSelectBottomSheet.this.ivSearchClear;
                if (imageView2 != null) {
                    imageView2.setVisibility(obj.length() > 0 ? 0 : 8);
                }
                job = GitRepoSelectBottomSheet.this.searchJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                LifecycleOwner lifecycleOwner = GitRepoSelectBottomSheet.this;
                ((GitRepoSelectBottomSheet) lifecycleOwner).searchJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new GitRepoSelectBottomSheet$onViewCreated$4$afterTextChanged$1(obj, GitRepoSelectBottomSheet.this, id, null), 3, (Object) null);
            }
        });
        GitSelectionViewModel gitSelectionViewModel2 = this.gitViewModel;
        if (gitSelectionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel2 = null;
        }
        gitSelectionViewModel2.getRepoSearchResult().observe(getViewLifecycleOwner(), new GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$6;
                onViewCreated$lambda$6 = GitRepoSelectBottomSheet.onViewCreated$lambda$6(GitRepoSelectBottomSheet.this, id, (List) obj);
                return onViewCreated$lambda$6;
            }
        }));
        RecyclerView recyclerView3 = this.rvRepositories;
        if (recyclerView3 != null) {
            recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$onViewCreated$6
                public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                    boolean z;
                    boolean z2;
                    GitSelectionViewModel gitSelectionViewModel3;
                    GitSelectionViewModel gitSelectionViewModel4;
                    Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                    if (dy <= 0) {
                        return;
                    }
                    int itemCount = linearLayoutManager.getItemCount();
                    int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    z = this.isLoadingMore;
                    if (!z && findLastVisibleItemPosition >= itemCount - 3) {
                        z2 = this.isSearching;
                        if (z2) {
                            return;
                        }
                        gitSelectionViewModel3 = this.gitViewModel;
                        GitSelectionViewModel gitSelectionViewModel5 = null;
                        if (gitSelectionViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                            gitSelectionViewModel3 = null;
                        }
                        if (gitSelectionViewModel3.getHasMoreRepos()) {
                            gitSelectionViewModel4 = this.gitViewModel;
                            if (gitSelectionViewModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                            } else {
                                gitSelectionViewModel5 = gitSelectionViewModel4;
                            }
                            gitSelectionViewModel5.loadMoreRepos();
                        }
                    }
                }
            });
        }
        GitSelectionViewModel gitSelectionViewModel3 = this.gitViewModel;
        if (gitSelectionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel3 = null;
        }
        gitSelectionViewModel3.getRepoLoadingMore().observe(getViewLifecycleOwner(), new GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = GitRepoSelectBottomSheet.onViewCreated$lambda$7(GitRepoSelectBottomSheet.this, progressBar, (Boolean) obj);
                return onViewCreated$lambda$7;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel4 = this.gitViewModel;
        if (gitSelectionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
        } else {
            gitSelectionViewModel = gitSelectionViewModel4;
        }
        gitSelectionViewModel.getRepoLoadMoreResult().observe(getViewLifecycleOwner(), new GitRepoSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.GitRepoSelectBottomSheet$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$9;
                onViewCreated$lambda$9 = GitRepoSelectBottomSheet.onViewCreated$lambda$9(GitRepoSelectBottomSheet.this, id, (List) obj);
                return onViewCreated$lambda$9;
            }
        }));
        loadRepos();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(GitRepoSelectBottomSheet gitRepoSelectBottomSheet, View view) {
        try {
            if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                gitRepoSelectBottomSheet.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://code.byted.org/repository/new")));
            } else {
                gitRepoSelectBottomSheet.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com")));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(String str, GitRepoSelectBottomSheet gitRepoSelectBottomSheet, GitRepoItem gitRepoItem) {
        Intrinsics.checkNotNullParameter(gitRepoItem, "repo");
        int i = !Intrinsics.areEqual(str, gitRepoItem.getId()) ? 1 : 0;
        InputTracker.INSTANCE.trackSelectRepositoryClick(i);
        if (i == 0) {
            Function1<? super GitRepoItem, Unit> function1 = gitRepoSelectBottomSheet.onRepoSelected;
            if (function1 != null) {
                function1.invoke(new GitRepoItem("", "", "", null, false, false, 56, null));
            }
        } else {
            Function1<? super GitRepoItem, Unit> function12 = gitRepoSelectBottomSheet.onRepoSelected;
            if (function12 != null) {
                function12.invoke(gitRepoItem);
            }
        }
        gitRepoSelectBottomSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(EditText editText, View view) {
        editText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(GitRepoSelectBottomSheet gitRepoSelectBottomSheet, String str, List list) {
        ProgressBar progressBar = gitRepoSelectBottomSheet.searchLoadingBar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (list.isEmpty()) {
            RecyclerView recyclerView = gitRepoSelectBottomSheet.rvRepositories;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            TextView textView = gitRepoSelectBottomSheet.tvSearchEmpty;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            RecyclerView recyclerView2 = gitRepoSelectBottomSheet.rvRepositories;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            TextView textView2 = gitRepoSelectBottomSheet.tvSearchEmpty;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        Intrinsics.checkNotNull(list);
        List<GitRepoItem> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (GitRepoItem gitRepoItem : list2) {
            arrayList.add(GitRepoItem.copy$default(gitRepoItem, null, null, null, null, Intrinsics.areEqual(gitRepoItem.getId(), str), false, 47, null));
        }
        gitRepoSelectBottomSheet.repoItems = arrayList;
        GitRepoItemAdapter gitRepoItemAdapter = gitRepoSelectBottomSheet.adapter;
        if (gitRepoItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            gitRepoItemAdapter = null;
        }
        gitRepoItemAdapter.submitList(gitRepoSelectBottomSheet.repoItems);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(GitRepoSelectBottomSheet gitRepoSelectBottomSheet, ProgressBar progressBar, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        gitRepoSelectBottomSheet.isLoadingMore = bool.booleanValue();
        progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$9(GitRepoSelectBottomSheet gitRepoSelectBottomSheet, String str, List list) {
        Intrinsics.checkNotNull(list);
        if ((!list.isEmpty()) && !gitRepoSelectBottomSheet.isSearching) {
            List<GitRepoItem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (GitRepoItem gitRepoItem : list2) {
                arrayList.add(GitRepoItem.copy$default(gitRepoItem, null, null, null, null, Intrinsics.areEqual(gitRepoItem.getId(), str), false, 47, null));
            }
            List<GitRepoItem> plus = CollectionsKt.plus(gitRepoSelectBottomSheet.repoItems, arrayList);
            gitRepoSelectBottomSheet.repoItems = plus;
            gitRepoSelectBottomSheet.fullRepoItems = plus;
            GitRepoItemAdapter gitRepoItemAdapter = gitRepoSelectBottomSheet.adapter;
            if (gitRepoItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                gitRepoItemAdapter = null;
            }
            gitRepoItemAdapter.submitList(gitRepoSelectBottomSheet.repoItems);
        }
        return Unit.INSTANCE;
    }

    private final void loadRepos() {
        ProgressBar progressBar = this.progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        View view = this.contentView;
        if (view != null) {
            view.setVisibility(8);
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new GitRepoSelectBottomSheet$loadRepos$1(this, null), 3, (Object) null);
    }

    /* compiled from: GitRepoSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "newInstance", "Lcom/bytedance/trae/conversation/git/GitRepoSelectBottomSheet;", "selectRepo", "Lcom/bytedance/trae/conversation/git/GitRepoItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ GitRepoSelectBottomSheet newInstance$default(Companion companion, GitRepoItem gitRepoItem, int i, Object obj) {
            if ((i & 1) != 0) {
                gitRepoItem = null;
            }
            return companion.newInstance(gitRepoItem);
        }

        public final GitRepoSelectBottomSheet newInstance(GitRepoItem selectRepo) {
            GitRepoSelectBottomSheet gitRepoSelectBottomSheet = new GitRepoSelectBottomSheet();
            gitRepoSelectBottomSheet.setSelectedRepo(selectRepo);
            return gitRepoSelectBottomSheet;
        }
    }
}
