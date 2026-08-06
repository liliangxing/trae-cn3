package com.bytedance.trae.home.solo.task;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.trae.home.C0820R;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TaskContextMenuBottomSheet.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "taskId", "", "currentTitle", "listener", "Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onCreateDialog", "Landroid/app/Dialog;", "setOnMenuItemClickListener", "OnMenuItemClickListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskContextMenuBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_CURRENT_TITLE = "arg_current_title";
    private static final String ARG_TASK_ID = "arg_task_id";
    public static final String TAG = "TaskContextMenuBottomSheet";
    private OnMenuItemClickListener listener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private String taskId = "";
    private String currentTitle = "";

    /* compiled from: TaskContextMenuBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;", "", "onRenameClick", "", "taskId", "", "currentTitle", "onDeleteClick", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnMenuItemClickListener {
        void onDeleteClick(String taskId);

        void onRenameClick(String taskId, String currentTitle);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString(ARG_TASK_ID, "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.taskId = string;
            String string2 = arguments.getString(ARG_CURRENT_TITLE, "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.currentTitle = string2;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.bottom_sheet_context_menu, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((LinearLayout) view.findViewById(C0820R.id.ll_rename)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskContextMenuBottomSheet.onViewCreated$lambda$1(TaskContextMenuBottomSheet.this, view2);
            }
        });
        ((LinearLayout) view.findViewById(C0820R.id.ll_delete)).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TaskContextMenuBottomSheet.onViewCreated$lambda$2(TaskContextMenuBottomSheet.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(TaskContextMenuBottomSheet taskContextMenuBottomSheet, View view) {
        OnMenuItemClickListener onMenuItemClickListener = taskContextMenuBottomSheet.listener;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onRenameClick(taskContextMenuBottomSheet.taskId, taskContextMenuBottomSheet.currentTitle);
        }
        taskContextMenuBottomSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(TaskContextMenuBottomSheet taskContextMenuBottomSheet, View view) {
        OnMenuItemClickListener onMenuItemClickListener = taskContextMenuBottomSheet.listener;
        if (onMenuItemClickListener != null) {
            onMenuItemClickListener.onDeleteClick(taskContextMenuBottomSheet.taskId);
        }
        taskContextMenuBottomSheet.dismiss();
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                TaskContextMenuBottomSheet.onCreateDialog$lambda$4(dialog, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4(BottomSheetDialog bottomSheetDialog, DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
            BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
            from.setState(3);
            from.setSkipCollapsed(true);
        }
    }

    public final void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    /* compiled from: TaskContextMenuBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_TASK_ID", "ARG_CURRENT_TITLE", "newInstance", "Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;", "taskId", "currentTitle", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TaskContextMenuBottomSheet newInstance(String taskId, String currentTitle) {
            Intrinsics.checkNotNullParameter(taskId, "taskId");
            Intrinsics.checkNotNullParameter(currentTitle, "currentTitle");
            TaskContextMenuBottomSheet taskContextMenuBottomSheet = new TaskContextMenuBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(TaskContextMenuBottomSheet.ARG_TASK_ID, taskId);
            bundle.putString(TaskContextMenuBottomSheet.ARG_CURRENT_TITLE, currentTitle);
            taskContextMenuBottomSheet.setArguments(bundle);
            return taskContextMenuBottomSheet;
        }
    }
}
