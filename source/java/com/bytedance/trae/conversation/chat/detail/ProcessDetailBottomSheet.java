package com.bytedance.trae.conversation.chat.detail;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.common.widget.TraeTitleBar;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProcessDetailBottomSheet.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010 J\b\u0010!\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "titleBar", "Lcom/bytedance/trae/common/widget/TraeTitleBar;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", "onDestroyView", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "createInitialFragment", "Landroidx/fragment/app/Fragment;", "navigateTo", "fragment", "setTitle", "title", "", "updateBackButtonVisibility", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ProcessDetailBottomSheet extends BottomSheetDialogFragment {
    private static final String ARG_BLOCK_KEY = "block_key";
    private static final String ARG_BLOCK_TYPE = "block_type";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ProcessDetailBottomSheet";
    private static final String TYPE_AGENT_DETAIL = "agent_detail";
    private static final String TYPE_TOOL_LIST = "tool_list";
    private BottomSheetBehavior<FrameLayout> behavior;
    private TraeTitleBar titleBar;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_dialog_process_detail, container, false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreateDialog$lambda$0;
                onCreateDialog$lambda$0 = ProcessDetailBottomSheet.onCreateDialog$lambda$0(ProcessDetailBottomSheet.this, dialogInterface, i, keyEvent);
                return onCreateDialog$lambda$0;
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ProcessDetailBottomSheet.onCreateDialog$lambda$2(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0(ProcessDetailBottomSheet processDetailBottomSheet, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || processDetailBottomSheet.getChildFragmentManager().getBackStackEntryCount() <= 0) {
            return false;
        }
        processDetailBottomSheet.getChildFragmentManager().popBackStack();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$2(BottomSheetDialog bottomSheetDialog, ProcessDetailBottomSheet processDetailBottomSheet, DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (frameLayout != null) {
            frameLayout.setBackground(new ColorDrawable(0));
            int i = (int) (processDetailBottomSheet.getResources().getDisplayMetrics().heightPixels * 0.9d);
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = i;
            frameLayout.setLayoutParams(layoutParams);
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
            processDetailBottomSheet.behavior = from;
            if (from != null) {
                from.setPeekHeight(i);
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = processDetailBottomSheet.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(3);
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = processDetailBottomSheet.behavior;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.setSkipCollapsed(true);
            }
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment createInitialFragment;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_24);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$onViewCreated$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View v, Outline outline) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(outline, "outline");
                int width = v.getWidth();
                int height = v.getHeight();
                int i = dimensionPixelSize;
                outline.setRoundRect(0, 0, width, height + i, i);
            }
        });
        view.setClipToOutline(true);
        TraeTitleBar traeTitleBar = (TraeTitleBar) view.findViewById(C0637R.id.title_bar);
        this.titleBar = traeTitleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setOnRightActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ProcessDetailBottomSheet.this.dismiss();
                }
            });
        }
        TraeTitleBar traeTitleBar2 = this.titleBar;
        if (traeTitleBar2 != null) {
            traeTitleBar2.setOnLeftActionClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ProcessDetailBottomSheet.onViewCreated$lambda$4(ProcessDetailBottomSheet.this, view2);
                }
            });
        }
        getChildFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() { // from class: com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet$$ExternalSyntheticLambda4
            public final void onBackStackChanged() {
                ProcessDetailBottomSheet.this.updateBackButtonVisibility();
            }
        });
        if (savedInstanceState == null && (createInitialFragment = createInitialFragment()) != null) {
            getChildFragmentManager().beginTransaction().setCustomAnimations(C0637R.anim.trae_slide_in_right, C0637R.anim.trae_slide_out_left, C0637R.anim.trae_slide_in_left, C0637R.anim.trae_slide_out_right).replace(C0637R.id.detail_fragment_container, createInitialFragment).commit();
        }
        updateBackButtonVisibility();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(ProcessDetailBottomSheet processDetailBottomSheet, View view) {
        if (processDetailBottomSheet.getChildFragmentManager().getBackStackEntryCount() > 0) {
            processDetailBottomSheet.getChildFragmentManager().popBackStack();
        } else {
            processDetailBottomSheet.dismiss();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        DetailBlockStore.INSTANCE.clear();
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DetailBlockStore.INSTANCE.clear();
    }

    private final Fragment createInitialFragment() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_BLOCK_TYPE) : null;
        if (string == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString(ARG_BLOCK_KEY) : null;
        String str = string2 != null ? string2 : "";
        if (Intrinsics.areEqual(string, TYPE_TOOL_LIST)) {
            return ToolListFragment.INSTANCE.newInstance(str);
        }
        if (Intrinsics.areEqual(string, TYPE_AGENT_DETAIL)) {
            return AgentDetailFragment.INSTANCE.newInstance(str);
        }
        return null;
    }

    public final void navigateTo(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        getChildFragmentManager().beginTransaction().setCustomAnimations(C0637R.anim.trae_slide_in_right, C0637R.anim.trae_slide_out_left, C0637R.anim.trae_slide_in_left, C0637R.anim.trae_slide_out_right).replace(C0637R.id.detail_fragment_container, fragment).addToBackStack((String) null).commit();
    }

    public final void setTitle(String title) {
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setTitle(title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBackButtonVisibility() {
        boolean z = getChildFragmentManager().getBackStackEntryCount() > 0;
        TraeTitleBar traeTitleBar = this.titleBar;
        if (traeTitleBar != null) {
            traeTitleBar.setLeftActionVisible(z);
        }
    }

    /* compiled from: ProcessDetailBottomSheet.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "ARG_BLOCK_TYPE", "ARG_BLOCK_KEY", "TYPE_TOOL_LIST", "TYPE_AGENT_DETAIL", "showToolList", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "showAgentDetail", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showToolList(FragmentManager fragmentManager, AgentContentBlock.ToolcallGroup block) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(block, "block");
            if (fragmentManager.isDestroyed()) {
                return;
            }
            String put = DetailBlockStore.INSTANCE.put(block);
            ProcessDetailBottomSheet processDetailBottomSheet = new ProcessDetailBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(ProcessDetailBottomSheet.ARG_BLOCK_TYPE, ProcessDetailBottomSheet.TYPE_TOOL_LIST);
            bundle.putString(ProcessDetailBottomSheet.ARG_BLOCK_KEY, put);
            processDetailBottomSheet.setArguments(bundle);
            try {
                processDetailBottomSheet.show(fragmentManager, ProcessDetailBottomSheet.TAG);
            } catch (Exception unused) {
            }
        }

        public final void showAgentDetail(FragmentManager fragmentManager, AgentContentBlock.SubAgentGroup block) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(block, "block");
            if (fragmentManager.isDestroyed()) {
                return;
            }
            String put = DetailBlockStore.INSTANCE.put(block);
            ProcessDetailBottomSheet processDetailBottomSheet = new ProcessDetailBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putString(ProcessDetailBottomSheet.ARG_BLOCK_TYPE, ProcessDetailBottomSheet.TYPE_AGENT_DETAIL);
            bundle.putString(ProcessDetailBottomSheet.ARG_BLOCK_KEY, put);
            processDetailBottomSheet.setArguments(bundle);
            try {
                processDetailBottomSheet.show(fragmentManager, ProcessDetailBottomSheet.TAG);
            } catch (Exception unused) {
            }
        }
    }
}
