package com.bytedance.trae.kmp.cmp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.kmp.base.C0811R;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeCmpBottomSheetFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b'\u0018\u0000 '2\u00020\u0001:\u0001'B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH$J\b\u0010\u0013\u001a\u00020\bH\u0014J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010!\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\u001fJ\u0006\u0010%\u001a\u00020\u001fJ\b\u0010&\u001a\u00020\u001fH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8eX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0010X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006("}, d2 = {"Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "contentGestureStartedWhileScrolled", "", "fragmentContainerId", "", "getFragmentContainerId", "()I", "createRootFragment", "Landroidx/fragment/app/Fragment;", "sheetHeightRatio", "", "getSheetHeightRatio", "()F", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "", "view", "onCmpSheetViewCreated", "onContentGestureStarted", "startedWhileContentCanScrollUp", "onContentGestureEnded", "dismissSafely", "applyContentGestureState", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class TraeCmpBottomSheetFragment extends BottomSheetDialogFragment {

    @Deprecated
    public static final float DEFAULT_SHEET_HEIGHT_RATIO = 0.95f;
    private BottomSheetBehavior<FrameLayout> behavior;
    private boolean contentGestureStartedWhileScrolled;
    private final float sheetHeightRatio = 0.95f;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    protected abstract Fragment createRootFragment();

    protected abstract int getFragmentContainerId();

    protected boolean onBackPressed() {
        return false;
    }

    protected void onCmpSheetViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    protected float getSheetHeightRatio() {
        return this.sheetHeightRatio;
    }

    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(C0811R.layout.trae_fragment_cmp_bottom_sheet, container, false);
        ((FrameLayout) inflate.findViewById(C0811R.id.trae_cmp_fragment_container)).setId(getFragmentContainerId());
        Intrinsics.checkNotNullExpressionValue(inflate, "also(...)");
        return inflate;
    }

    public final Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean onCreateDialog$lambda$1;
                onCreateDialog$lambda$1 = TraeCmpBottomSheetFragment.onCreateDialog$lambda$1(TraeCmpBottomSheetFragment.this, dialogInterface, i, keyEvent);
                return onCreateDialog$lambda$1;
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                TraeCmpBottomSheetFragment.onCreateDialog$lambda$4(dialog, this, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$1(TraeCmpBottomSheetFragment traeCmpBottomSheetFragment, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4 && keyEvent.getAction() == 1 && traeCmpBottomSheetFragment.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$4(BottomSheetDialog bottomSheetDialog, TraeCmpBottomSheetFragment traeCmpBottomSheetFragment, DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        if (frameLayout == null) {
            return;
        }
        frameLayout.setBackground(new ColorDrawable(0));
        int sheetHeightRatio = (int) (traeCmpBottomSheetFragment.getResources().getDisplayMetrics().heightPixels * traeCmpBottomSheetFragment.getSheetHeightRatio());
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = sheetHeightRatio;
        frameLayout.setLayoutParams(layoutParams);
        BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
        from.setPeekHeight(sheetHeightRatio);
        from.setState(3);
        from.setSkipCollapsed(true);
        traeCmpBottomSheetFragment.behavior = from;
        traeCmpBottomSheetFragment.applyContentGestureState();
    }

    public final void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0811R.dimen.trae_cmp_sheet_corner_radius);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment$onViewCreated$1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View target, Outline outline) {
                Intrinsics.checkNotNullParameter(target, "target");
                Intrinsics.checkNotNullParameter(outline, "outline");
                int width = target.getWidth();
                int height = target.getHeight();
                int i = dimensionPixelSize;
                outline.setRoundRect(0, 0, width, height + i, i);
            }
        });
        view.setClipToOutline(true);
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction().replace(getFragmentContainerId(), createRootFragment()).commit();
        }
        onCmpSheetViewCreated(view, savedInstanceState);
    }

    public final void onContentGestureStarted(boolean startedWhileContentCanScrollUp) {
        this.contentGestureStartedWhileScrolled = startedWhileContentCanScrollUp;
        applyContentGestureState();
    }

    public final void onContentGestureEnded() {
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    TraeCmpBottomSheetFragment.onContentGestureEnded$lambda$5(TraeCmpBottomSheetFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onContentGestureEnded$lambda$5(TraeCmpBottomSheetFragment traeCmpBottomSheetFragment) {
        traeCmpBottomSheetFragment.contentGestureStartedWhileScrolled = false;
        traeCmpBottomSheetFragment.applyContentGestureState();
    }

    public final void dismissSafely() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.kmp.cmp.TraeCmpBottomSheetFragment$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TraeCmpBottomSheetFragment.this.dismissSafely();
                }
            });
            return;
        }
        if (!isAdded() || isRemoving()) {
            return;
        }
        if (getParentFragmentManager().isStateSaved()) {
            dismissAllowingStateLoss();
        } else {
            dismiss();
        }
    }

    private final void applyContentGestureState() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.behavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setHideable(!this.contentGestureStartedWhileScrolled);
        }
        if (this.contentGestureStartedWhileScrolled) {
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior3 = this.behavior;
            if ((bottomSheetBehavior3 != null && bottomSheetBehavior3.getState() == 3) || (bottomSheetBehavior = this.behavior) == null) {
                return;
            }
            bottomSheetBehavior.setState(3);
        }
    }

    /* compiled from: TraeCmpBottomSheetFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/kmp/cmp/TraeCmpBottomSheetFragment$Companion;", "", "<init>", "()V", "DEFAULT_SHEET_HEIGHT_RATIO", "", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
