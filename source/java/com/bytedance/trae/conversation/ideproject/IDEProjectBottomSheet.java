package com.bytedance.trae.conversation.ideproject;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigator;
import com.bytedance.trae.conversation.devices.flow.DeviceFlowNavigatorKt;
import com.bytedance.trae.conversation.network.ProjectItem;
import com.bytedance.trae.conversation.tracker.DeviceTracker;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IDEProjectBottomSheet.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0002*+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u0016\u0010$\u001a\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u00152\f\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "onProjectSelected", "Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;", "getOnProjectSelected", "()Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;", "setOnProjectSelected", "(Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;)V", "adapter", "Lcom/bytedance/trae/conversation/ideproject/IDEProjectAdapter;", "progressLoading", "Landroid/widget/ProgressBar;", "rvProjects", "Landroidx/recyclerview/widget/RecyclerView;", "layoutEmpty", "Landroid/view/View;", "tvFooterHint", "Landroid/widget/TextView;", "setProjectSelected", "", "l", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "fetchProjects", "showLoading", "showContent", "projects", "", "Lcom/bytedance/trae/conversation/network/ProjectItem;", "showEmpty", "trackPageView", "OnProjectSelectedListener", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDEProjectBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_CLI_ID = "arg_cli_id";
    private static final String ARG_PROJECT_ID = "arg_project_id";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "IDEProjectBottomSheet";
    private IDEProjectAdapter adapter;
    private View layoutEmpty;
    private OnProjectSelectedListener onProjectSelected;
    private ProgressBar progressLoading;
    private RecyclerView rvProjects;
    private TextView tvFooterHint;

    /* compiled from: IDEProjectBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$OnProjectSelectedListener;", "", "onProjectSelected", "", "node", "Lcom/bytedance/trae/conversation/network/ProjectItem;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnProjectSelectedListener {
        void onProjectSelected(ProjectItem node);
    }

    public final OnProjectSelectedListener getOnProjectSelected() {
        return this.onProjectSelected;
    }

    public final void setOnProjectSelected(OnProjectSelectedListener onProjectSelectedListener) {
        this.onProjectSelected = onProjectSelectedListener;
    }

    public final void setProjectSelected(OnProjectSelectedListener l) {
        this.onProjectSelected = l;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int i = (int) (getResources().getDisplayMetrics().heightPixels * 0.9d);
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                IDEProjectBottomSheet.onCreateDialog$lambda$1(IDEProjectBottomSheet.this, i, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(IDEProjectBottomSheet iDEProjectBottomSheet, int i, DialogInterface dialogInterface) {
        View findViewById;
        if (iDEProjectBottomSheet.isAdded()) {
            BottomSheetDialog bottomSheetDialog = dialogInterface instanceof BottomSheetDialog ? (BottomSheetDialog) dialogInterface : null;
            if (bottomSheetDialog == null || (findViewById = bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) == null) {
                return;
            }
            findViewById.setBackgroundResource(android.R.color.transparent);
            BottomSheetBehavior from = BottomSheetBehavior.from(findViewById);
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
        return inflater.inflate(C0637R.layout.trae_dialog_ide_project, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.progressLoading = (ProgressBar) view.findViewById(C0637R.id.progress_loading);
        this.rvProjects = view.findViewById(C0637R.id.rv_projects);
        this.layoutEmpty = view.findViewById(C0637R.id.layout_empty);
        this.tvFooterHint = (TextView) view.findViewById(C0637R.id.tv_footer_hint);
        ((TraeTitleBar) view.findViewById(C0637R.id.title_bar)).setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IDEProjectBottomSheet.onViewCreated$lambda$2(IDEProjectBottomSheet.this, view2);
            }
        });
        this.adapter = new IDEProjectAdapter(new Function1() { // from class: com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = IDEProjectBottomSheet.onViewCreated$lambda$3(IDEProjectBottomSheet.this, (ProjectItem) obj);
                return onViewCreated$lambda$3;
            }
        });
        RecyclerView recyclerView = this.rvProjects;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        RecyclerView recyclerView2 = this.rvProjects;
        if (recyclerView2 != null) {
            IDEProjectAdapter iDEProjectAdapter = this.adapter;
            if (iDEProjectAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                iDEProjectAdapter = null;
            }
            recyclerView2.setAdapter((RecyclerView.Adapter) iDEProjectAdapter);
        }
        fetchProjects();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(IDEProjectBottomSheet iDEProjectBottomSheet, View view) {
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) iDEProjectBottomSheet);
        if (deviceFlowNavigator != null) {
            deviceFlowNavigator.onRouteBack();
        } else {
            iDEProjectBottomSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(IDEProjectBottomSheet iDEProjectBottomSheet, ProjectItem projectItem) {
        Intrinsics.checkNotNullParameter(projectItem, "project");
        DeviceFlowNavigator deviceFlowNavigator = DeviceFlowNavigatorKt.deviceFlowNavigator((Fragment) iDEProjectBottomSheet);
        OnProjectSelectedListener onProjectSelectedListener = iDEProjectBottomSheet.onProjectSelected;
        if (onProjectSelectedListener != null) {
            onProjectSelectedListener.onProjectSelected(projectItem);
        }
        if (deviceFlowNavigator == null) {
            iDEProjectBottomSheet.dismiss();
        }
        return Unit.INSTANCE;
    }

    private final void fetchProjects() {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString(ARG_CLI_ID)) == null) {
            return;
        }
        showLoading();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new IDEProjectBottomSheet$fetchProjects$1(this, string, null), 3, (Object) null);
    }

    private final void showLoading() {
        ProgressBar progressBar = this.progressLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        RecyclerView recyclerView = this.rvProjects;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.layoutEmpty;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.tvFooterHint;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showContent(List<ProjectItem> projects) {
        ProgressBar progressBar = this.progressLoading;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        RecyclerView recyclerView = this.rvProjects;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        View view = this.layoutEmpty;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView = this.tvFooterHint;
        if (textView != null) {
            textView.setVisibility(0);
        }
        IDEProjectAdapter iDEProjectAdapter = this.adapter;
        IDEProjectAdapter iDEProjectAdapter2 = null;
        if (iDEProjectAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            iDEProjectAdapter = null;
        }
        iDEProjectAdapter.submitList(projects);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_PROJECT_ID) : null;
        String str = string;
        if (!(str == null || str.length() == 0)) {
            IDEProjectAdapter iDEProjectAdapter3 = this.adapter;
            if (iDEProjectAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                iDEProjectAdapter2 = iDEProjectAdapter3;
            }
            iDEProjectAdapter2.setSelectedProjectId(string);
        }
        trackPageView(projects);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmpty() {
        ProgressBar progressBar = this.progressLoading;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        RecyclerView recyclerView = this.rvProjects;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        View view = this.layoutEmpty;
        if (view != null) {
            view.setVisibility(0);
        }
        TextView textView = this.tvFooterHint;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private final void trackPageView(List<ProjectItem> projects) {
        int i;
        DeviceTracker deviceTracker = DeviceTracker.INSTANCE;
        int size = projects.size();
        List<ProjectItem> list = projects;
        boolean z = list instanceof Collection;
        int i2 = 0;
        if (z && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ProjectItem) it.next()).getWorkspaceType(), "multi_root") && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (!z || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((ProjectItem) it2.next()).getWorkspaceType(), "unsaved_multi_root") && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        deviceTracker.trackIdeProjectPageView(size, i, i2);
    }

    /* compiled from: IDEProjectBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_CLI_ID", "ARG_PROJECT_ID", "newInstance", "Lcom/bytedance/trae/conversation/ideproject/IDEProjectBottomSheet;", "cliId", "projectId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ IDEProjectBottomSheet newInstance$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.newInstance(str, str2);
        }

        public final IDEProjectBottomSheet newInstance(String cliId, String projectId) {
            Intrinsics.checkNotNullParameter(cliId, "cliId");
            IDEProjectBottomSheet iDEProjectBottomSheet = new IDEProjectBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(IDEProjectBottomSheet.ARG_CLI_ID, cliId);
            if (projectId != null) {
                bundle.putString(IDEProjectBottomSheet.ARG_PROJECT_ID, projectId);
            }
            iDEProjectBottomSheet.setArguments(bundle);
            return iDEProjectBottomSheet;
        }
    }
}
