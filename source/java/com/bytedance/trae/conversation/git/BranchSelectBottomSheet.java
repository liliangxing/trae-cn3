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
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.login.bytecloud.BytecloudAuthManager;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: BranchSelectBottomSheet.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u001d2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R*\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onBranchSelected", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/git/BranchItem;", "", "getOnBranchSelected", "()Lkotlin/jvm/functions/Function1;", "setOnBranchSelected", "(Lkotlin/jvm/functions/Function1;)V", "adapter", "Lcom/bytedance/trae/conversation/git/BranchItemAdapter;", "gitViewModel", "Lcom/bytedance/trae/conversation/git/GitSelectionViewModel;", "branchItems", "", "fullBranchItems", "isLoadingMore", "", "searchJob", "Lkotlinx/coroutines/Job;", "isSearching", "selectedBranchId", "", "tvSearchEmpty", "Landroid/widget/TextView;", "emptyStateView", "Landroid/view/View;", "contentView", "btnGoToGithub", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BranchSelectBottomSheet extends BottomSheetDialogFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "BranchSelectBottomSheet";
    private BranchItemAdapter adapter;
    private TextView btnGoToGithub;
    private View contentView;
    private View emptyStateView;
    private GitSelectionViewModel gitViewModel;
    private boolean isLoadingMore;
    private boolean isSearching;
    private Function1<? super BranchItem, Unit> onBranchSelected;
    private Job searchJob;
    private String selectedBranchId;
    private TextView tvSearchEmpty;
    private List<BranchItem> branchItems = CollectionsKt.emptyList();
    private List<BranchItem> fullBranchItems = CollectionsKt.emptyList();

    public final Function1<BranchItem, Unit> getOnBranchSelected() {
        return this.onBranchSelected;
    }

    public final void setOnBranchSelected(Function1<? super BranchItem, Unit> function1) {
        this.onBranchSelected = function1;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda9
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                BranchSelectBottomSheet.onCreateDialog$lambda$1(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(BottomSheetDialog bottomSheetDialog, BranchSelectBottomSheet branchSelectBottomSheet, DialogInterface dialogInterface) {
        View findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (findViewById != null) {
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
            int i = (branchSelectBottomSheet.getResources().getDisplayMetrics().heightPixels * 9) / 10;
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
        return inflater.inflate(C0637R.layout.trae_dialog_branch_select, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewModelStoreOwner requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        this.gitViewModel = (GitSelectionViewModel) new ViewModelProvider(requireActivity).get(GitSelectionViewModel.class);
        final RecyclerView findViewById = view.findViewById(C0637R.id.rv_branches);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(C0637R.id.pb_loading_more);
        final ProgressBar progressBar2 = (ProgressBar) view.findViewById(C0637R.id.progress_bar);
        final EditText editText = (EditText) view.findViewById(C0637R.id.et_search);
        final ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_search_clear);
        this.tvSearchEmpty = (TextView) view.findViewById(C0637R.id.tv_search_empty);
        this.emptyStateView = view.findViewById(C0637R.id.layout_empty_state);
        this.contentView = view.findViewById(C0637R.id.layout_content);
        this.btnGoToGithub = (TextView) view.findViewById(C0637R.id.btn_go_to_github);
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            TextView textView = this.btnGoToGithub;
            if (textView != null) {
                textView.setText(com.bytedance.trae.multilanguage.R.string.trae_git_go_to_bits_code);
            }
        } else {
            TextView textView2 = this.btnGoToGithub;
            if (textView2 != null) {
                textView2.setText(com.bytedance.trae.multilanguage.R.string.trae_git_go_to_github);
            }
        }
        TextView textView3 = (TextView) view.findViewById(C0637R.id.tv_empty_hint);
        if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
            if (textView3 != null) {
                textView3.setText(com.bytedance.trae.multilanguage.R.string.trae_bits_code_branch_empty_hint);
            }
        } else if (textView3 != null) {
            textView3.setText(com.bytedance.trae.multilanguage.R.string.trae_git_repo_empty_hint);
        }
        TextView textView4 = this.btnGoToGithub;
        if (textView4 != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    BranchSelectBottomSheet.onViewCreated$lambda$2(BranchSelectBottomSheet.this, view2);
                }
            });
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        progressBar2.setVisibility(0);
        findViewById.setVisibility(8);
        View view2 = this.contentView;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        traeTitleBar.setRightActionsVisible(false);
        final RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        findViewById.setLayoutManager(linearLayoutManager);
        RecyclerView.Adapter branchItemAdapter = new BranchItemAdapter(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = BranchSelectBottomSheet.onViewCreated$lambda$3(objectRef, this, (BranchItem) obj);
                return onViewCreated$lambda$3;
            }
        });
        this.adapter = branchItemAdapter;
        findViewById.setAdapter(branchItemAdapter);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                BranchSelectBottomSheet.onViewCreated$lambda$4(editText, view3);
            }
        });
        editText.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$onViewCreated$4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                List list;
                TextView textView5;
                BranchItemAdapter branchItemAdapter2;
                List list2;
                TextView textView6;
                TextView textView7;
                List list3;
                BranchItemAdapter branchItemAdapter3;
                List list4;
                Job job;
                BranchItemAdapter branchItemAdapter4 = null;
                String obj = s != null ? s.toString() : null;
                if (obj == null) {
                    obj = "";
                }
                String str = obj;
                String str2 = str;
                imageView.setVisibility(str2.length() > 0 ? 0 : 8);
                if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                    job = this.searchJob;
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    LifecycleOwner lifecycleOwner = this;
                    ((BranchSelectBottomSheet) lifecycleOwner).searchJob = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new BranchSelectBottomSheet$onViewCreated$4$afterTextChanged$1(str, this, findViewById, objectRef, null), 3, (Object) null);
                    return;
                }
                if (str2.length() == 0) {
                    this.isSearching = false;
                    findViewById.setVisibility(0);
                    textView7 = this.tvSearchEmpty;
                    if (textView7 != null) {
                        textView7.setVisibility(8);
                    }
                    BranchSelectBottomSheet branchSelectBottomSheet = this;
                    list3 = branchSelectBottomSheet.fullBranchItems;
                    List<BranchItem> list5 = list3;
                    Ref.ObjectRef<BranchItem> objectRef2 = objectRef;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                    for (BranchItem branchItem : list5) {
                        String id = branchItem.getId();
                        BranchItem branchItem2 = (BranchItem) objectRef2.element;
                        arrayList.add(BranchItem.copy$default(branchItem, null, null, Intrinsics.areEqual(id, branchItem2 != null ? branchItem2.getId() : null), false, 11, null));
                    }
                    branchSelectBottomSheet.branchItems = arrayList;
                    branchItemAdapter3 = this.adapter;
                    if (branchItemAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    } else {
                        branchItemAdapter4 = branchItemAdapter3;
                    }
                    list4 = this.branchItems;
                    branchItemAdapter4.submitList(list4);
                    return;
                }
                this.isSearching = false;
                list = this.fullBranchItems;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (StringsKt.contains(((BranchItem) obj2).getName(), str2, true)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList<BranchItem> arrayList3 = arrayList2;
                Ref.ObjectRef<BranchItem> objectRef3 = objectRef;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (BranchItem branchItem3 : arrayList3) {
                    String id2 = branchItem3.getId();
                    BranchItem branchItem4 = (BranchItem) objectRef3.element;
                    arrayList4.add(BranchItem.copy$default(branchItem3, null, null, Intrinsics.areEqual(id2, branchItem4 != null ? branchItem4.getId() : null), false, 11, null));
                }
                ArrayList arrayList5 = arrayList4;
                if (arrayList5.isEmpty()) {
                    findViewById.setVisibility(8);
                    textView6 = this.tvSearchEmpty;
                    if (textView6 != null) {
                        textView6.setVisibility(0);
                    }
                } else {
                    findViewById.setVisibility(0);
                    textView5 = this.tvSearchEmpty;
                    if (textView5 != null) {
                        textView5.setVisibility(8);
                    }
                }
                this.branchItems = arrayList5;
                branchItemAdapter2 = this.adapter;
                if (branchItemAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                } else {
                    branchItemAdapter4 = branchItemAdapter2;
                }
                list2 = this.branchItems;
                branchItemAdapter4.submitList(list2);
            }
        });
        GitSelectionViewModel gitSelectionViewModel = this.gitViewModel;
        GitSelectionViewModel gitSelectionViewModel2 = null;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        gitSelectionViewModel.getBranchSearchResult().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$6;
                onViewCreated$lambda$6 = BranchSelectBottomSheet.onViewCreated$lambda$6(BranchSelectBottomSheet.this, findViewById, objectRef, (List) obj);
                return onViewCreated$lambda$6;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel3 = this.gitViewModel;
        if (gitSelectionViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel3 = null;
        }
        gitSelectionViewModel3.fetchBranchesFromServer();
        GitSelectionViewModel gitSelectionViewModel4 = this.gitViewModel;
        if (gitSelectionViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel4 = null;
        }
        gitSelectionViewModel4.getBranchLoading().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$7;
                onViewCreated$lambda$7 = BranchSelectBottomSheet.onViewCreated$lambda$7(progressBar2, findViewById, this, (Boolean) obj);
                return onViewCreated$lambda$7;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel5 = this.gitViewModel;
        if (gitSelectionViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel5 = null;
        }
        gitSelectionViewModel5.getBranchRefreshResult().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$10;
                onViewCreated$lambda$10 = BranchSelectBottomSheet.onViewCreated$lambda$10(BranchSelectBottomSheet.this, progressBar2, findViewById, objectRef, (List) obj);
                return onViewCreated$lambda$10;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel6 = this.gitViewModel;
        if (gitSelectionViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel6 = null;
        }
        gitSelectionViewModel6.getBranchLoadError().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$11;
                onViewCreated$lambda$11 = BranchSelectBottomSheet.onViewCreated$lambda$11(progressBar2, this, (String) obj);
                return onViewCreated$lambda$11;
            }
        }));
        findViewById.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$onViewCreated$9
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                boolean z;
                boolean z2;
                GitSelectionViewModel gitSelectionViewModel7;
                GitSelectionViewModel gitSelectionViewModel8;
                GitSelectionViewModel gitSelectionViewModel9;
                GitSelectionViewModel gitSelectionViewModel10;
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (dy <= 0) {
                    return;
                }
                int itemCount = linearLayoutManager.getItemCount();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                z = this.isLoadingMore;
                if (!z && findLastVisibleItemPosition >= itemCount - 3) {
                    z2 = this.isSearching;
                    GitSelectionViewModel gitSelectionViewModel11 = null;
                    if (z2) {
                        gitSelectionViewModel9 = this.gitViewModel;
                        if (gitSelectionViewModel9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                            gitSelectionViewModel9 = null;
                        }
                        if (gitSelectionViewModel9.getHasMoreSearchResults()) {
                            gitSelectionViewModel10 = this.gitViewModel;
                            if (gitSelectionViewModel10 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                            } else {
                                gitSelectionViewModel11 = gitSelectionViewModel10;
                            }
                            gitSelectionViewModel11.loadMoreSearchResults();
                            return;
                        }
                        return;
                    }
                    gitSelectionViewModel7 = this.gitViewModel;
                    if (gitSelectionViewModel7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                        gitSelectionViewModel7 = null;
                    }
                    if (gitSelectionViewModel7.getHasMoreBranches()) {
                        gitSelectionViewModel8 = this.gitViewModel;
                        if (gitSelectionViewModel8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
                        } else {
                            gitSelectionViewModel11 = gitSelectionViewModel8;
                        }
                        gitSelectionViewModel11.loadMoreBranches();
                    }
                }
            }
        });
        GitSelectionViewModel gitSelectionViewModel7 = this.gitViewModel;
        if (gitSelectionViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel7 = null;
        }
        gitSelectionViewModel7.getBranchLoadingMore().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda7
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$12;
                onViewCreated$lambda$12 = BranchSelectBottomSheet.onViewCreated$lambda$12(BranchSelectBottomSheet.this, progressBar, (Boolean) obj);
                return onViewCreated$lambda$12;
            }
        }));
        GitSelectionViewModel gitSelectionViewModel8 = this.gitViewModel;
        if (gitSelectionViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
        } else {
            gitSelectionViewModel2 = gitSelectionViewModel8;
        }
        gitSelectionViewModel2.getBranchLoadMoreResult().observe(getViewLifecycleOwner(), new BranchSelectBottomSheet$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.bytedance.trae.conversation.git.BranchSelectBottomSheet$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$14;
                onViewCreated$lambda$14 = BranchSelectBottomSheet.onViewCreated$lambda$14(BranchSelectBottomSheet.this, objectRef, (List) obj);
                return onViewCreated$lambda$14;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(BranchSelectBottomSheet branchSelectBottomSheet, View view) {
        try {
            if (BytecloudAuthManager.INSTANCE.isBytecloudLogin()) {
                branchSelectBottomSheet.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://code.byted.org/repository/new")));
            } else {
                branchSelectBottomSheet.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://github.com")));
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(Ref.ObjectRef objectRef, BranchSelectBottomSheet branchSelectBottomSheet, BranchItem branchItem) {
        Intrinsics.checkNotNullParameter(branchItem, "branch");
        BranchItem branchItem2 = (BranchItem) objectRef.element;
        if (Intrinsics.areEqual(branchItem2 != null ? branchItem2.getId() : null, branchItem.getId())) {
            Function1<? super BranchItem, Unit> function1 = branchSelectBottomSheet.onBranchSelected;
            if (function1 != null) {
                function1.invoke((Object) null);
            }
        } else {
            Function1<? super BranchItem, Unit> function12 = branchSelectBottomSheet.onBranchSelected;
            if (function12 != null) {
                function12.invoke(branchItem);
            }
        }
        branchSelectBottomSheet.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(EditText editText, View view) {
        editText.getText().clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$6(BranchSelectBottomSheet branchSelectBottomSheet, RecyclerView recyclerView, Ref.ObjectRef objectRef, List list) {
        if (branchSelectBottomSheet.isSearching) {
            if (list.isEmpty()) {
                recyclerView.setVisibility(8);
                TextView textView = branchSelectBottomSheet.tvSearchEmpty;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            } else {
                recyclerView.setVisibility(0);
                TextView textView2 = branchSelectBottomSheet.tvSearchEmpty;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
            }
            BranchItem branchItem = (BranchItem) objectRef.element;
            BranchItemAdapter branchItemAdapter = null;
            String id = branchItem != null ? branchItem.getId() : null;
            Intrinsics.checkNotNull(list);
            List<BranchItem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (BranchItem branchItem2 : list2) {
                arrayList.add(BranchItem.copy$default(branchItem2, null, null, Intrinsics.areEqual(branchItem2.getId(), id), false, 11, null));
            }
            branchSelectBottomSheet.branchItems = arrayList;
            BranchItemAdapter branchItemAdapter2 = branchSelectBottomSheet.adapter;
            if (branchItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                branchItemAdapter = branchItemAdapter2;
            }
            branchItemAdapter.submitList(branchSelectBottomSheet.branchItems);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$7(ProgressBar progressBar, RecyclerView recyclerView, BranchSelectBottomSheet branchSelectBottomSheet, Boolean bool) {
        if (bool.booleanValue()) {
            progressBar.setVisibility(0);
            recyclerView.setVisibility(8);
            TextView textView = branchSelectBottomSheet.tvSearchEmpty;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view = branchSelectBottomSheet.emptyStateView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = branchSelectBottomSheet.contentView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$10(BranchSelectBottomSheet branchSelectBottomSheet, ProgressBar progressBar, RecyclerView recyclerView, Ref.ObjectRef objectRef, List list) {
        Object obj;
        GitSelectionViewModel gitSelectionViewModel = branchSelectBottomSheet.gitViewModel;
        BranchItemAdapter branchItemAdapter = null;
        if (gitSelectionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gitViewModel");
            gitSelectionViewModel = null;
        }
        if (Intrinsics.areEqual(gitSelectionViewModel.getBranchLoading().getValue(), true)) {
            return Unit.INSTANCE;
        }
        progressBar.setVisibility(8);
        if (list.isEmpty()) {
            View view = branchSelectBottomSheet.contentView;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = branchSelectBottomSheet.emptyStateView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        } else {
            View view3 = branchSelectBottomSheet.emptyStateView;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = branchSelectBottomSheet.contentView;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            recyclerView.setVisibility(0);
            TextView textView = branchSelectBottomSheet.tvSearchEmpty;
            if (textView != null) {
                textView.setVisibility(8);
            }
            String str = branchSelectBottomSheet.selectedBranchId;
            Intrinsics.checkNotNull(list);
            List<BranchItem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (BranchItem branchItem : list2) {
                arrayList.add(BranchItem.copy$default(branchItem, null, null, Intrinsics.areEqual(branchItem.getId(), str), false, 11, null));
            }
            ArrayList arrayList2 = arrayList;
            branchSelectBottomSheet.branchItems = arrayList2;
            branchSelectBottomSheet.fullBranchItems = arrayList2;
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((BranchItem) obj).isSelected()) {
                    break;
                }
            }
            objectRef.element = obj;
            BranchItemAdapter branchItemAdapter2 = branchSelectBottomSheet.adapter;
            if (branchItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                branchItemAdapter = branchItemAdapter2;
            }
            branchItemAdapter.submitList(branchSelectBottomSheet.branchItems);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$11(ProgressBar progressBar, BranchSelectBottomSheet branchSelectBottomSheet, String str) {
        progressBar.setVisibility(8);
        View view = branchSelectBottomSheet.emptyStateView;
        if (view != null) {
            view.setVisibility(8);
        }
        Toast.makeText(branchSelectBottomSheet.requireContext(), branchSelectBottomSheet.getString(com.bytedance.trae.multilanguage.R.string.trae_conversation_network_retry), 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$12(BranchSelectBottomSheet branchSelectBottomSheet, ProgressBar progressBar, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        branchSelectBottomSheet.isLoadingMore = bool.booleanValue();
        progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14(BranchSelectBottomSheet branchSelectBottomSheet, Ref.ObjectRef objectRef, List list) {
        Intrinsics.checkNotNull(list);
        if ((!list.isEmpty()) && !branchSelectBottomSheet.isSearching) {
            BranchItem branchItem = (BranchItem) objectRef.element;
            BranchItemAdapter branchItemAdapter = null;
            String id = branchItem != null ? branchItem.getId() : null;
            List<BranchItem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (BranchItem branchItem2 : list2) {
                arrayList.add(BranchItem.copy$default(branchItem2, null, null, Intrinsics.areEqual(branchItem2.getId(), id), false, 11, null));
            }
            List<BranchItem> plus = CollectionsKt.plus(branchSelectBottomSheet.branchItems, arrayList);
            branchSelectBottomSheet.branchItems = plus;
            branchSelectBottomSheet.fullBranchItems = plus;
            BranchItemAdapter branchItemAdapter2 = branchSelectBottomSheet.adapter;
            if (branchItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                branchItemAdapter = branchItemAdapter2;
            }
            branchItemAdapter.submitList(branchSelectBottomSheet.branchItems);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: BranchSelectBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/conversation/git/BranchSelectBottomSheet;", "selectedBranchId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ BranchSelectBottomSheet newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newInstance(str);
        }

        public final BranchSelectBottomSheet newInstance(String selectedBranchId) {
            BranchSelectBottomSheet branchSelectBottomSheet = new BranchSelectBottomSheet();
            branchSelectBottomSheet.selectedBranchId = selectedBranchId;
            return branchSelectBottomSheet;
        }
    }
}
