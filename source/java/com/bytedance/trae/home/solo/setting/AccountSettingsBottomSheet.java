package com.bytedance.trae.home.solo.setting;

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
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.home.C0820R;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountSettingsBottomSheet.kt */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\r\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\u0011J\b\u0010%\u001a\u00020\u0011H\u0002J\u0010\u0010&\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u000bH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006)"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "behavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "contentCanScrollUp", "", "scrollableViews", "", "Landroid/view/View;", "childFragmentLifecycleCallbacks", "com/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1", "Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1;", "hasBackStack", "popChildBackStack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "view", "updateHideable", "scrollableView", "setContentCanScrollUp", "canScrollUp", "dismissSafely", "applyContentScrollState", "installScrollGuards", "registerScrollableView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountSettingsBottomSheet extends BottomSheetDialogFragment {
    public static final String TAG = "AccountSettingsBottomSheet";
    private BottomSheetBehavior<FrameLayout> behavior;
    private boolean contentCanScrollUp;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final Set<View> scrollableViews = new LinkedHashSet();
    private final AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1 childFragmentLifecycleCallbacks = new FragmentManager.FragmentLifecycleCallbacks() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$childFragmentLifecycleCallbacks$1
        public void onFragmentViewCreated(FragmentManager fm, Fragment f, View v, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(fm, "fm");
            Intrinsics.checkNotNullParameter(f, "f");
            Intrinsics.checkNotNullParameter(v, "v");
            AccountSettingsBottomSheet.this.installScrollGuards(v);
        }
    };

    private final boolean hasBackStack() {
        return getChildFragmentManager().getBackStackEntryCount() > 0;
    }

    private final void popChildBackStack() {
        getChildFragmentManager().popBackStack();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.childFragmentLifecycleCallbacks, false);
    }

    public void onDestroy() {
        getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this.childFragmentLifecycleCallbacks);
        super.onDestroy();
    }

    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(null);
        }
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setBottomSheetCallback((BottomSheetBehavior.BottomSheetCallback) null);
        }
        this.behavior = null;
        this.contentCanScrollUp = false;
        this.scrollableViews.clear();
        super.onDestroyView();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0820R.layout.fragment_account_settings, container, false);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        final Dialog dialog = (BottomSheetDialog) onCreateDialog;
        final int i = (int) (dialog.getContext().getResources().getDisplayMetrics().heightPixels * 0.95d);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                boolean onCreateDialog$lambda$0;
                onCreateDialog$lambda$0 = AccountSettingsBottomSheet.onCreateDialog$lambda$0(AccountSettingsBottomSheet.this, dialogInterface, i2, keyEvent);
                return onCreateDialog$lambda$0;
            }
        });
        dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                AccountSettingsBottomSheet.onCreateDialog$lambda$1(AccountSettingsBottomSheet.this, dialog, i, dialogInterface);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$0(AccountSettingsBottomSheet accountSettingsBottomSheet, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !accountSettingsBottomSheet.hasBackStack()) {
            return false;
        }
        accountSettingsBottomSheet.popChildBackStack();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$1(final AccountSettingsBottomSheet accountSettingsBottomSheet, BottomSheetDialog bottomSheetDialog, int i, DialogInterface dialogInterface) {
        FrameLayout frameLayout;
        if (accountSettingsBottomSheet.isAdded() && accountSettingsBottomSheet.getDialog() == bottomSheetDialog && (frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet)) != null) {
            frameLayout.setBackground(new ColorDrawable(0));
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = i;
            frameLayout.setLayoutParams(layoutParams);
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout);
            accountSettingsBottomSheet.behavior = from;
            if (from != null) {
                from.setPeekHeight(i);
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = accountSettingsBottomSheet.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setState(3);
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = accountSettingsBottomSheet.behavior;
            if (bottomSheetBehavior2 != null) {
                bottomSheetBehavior2.setSkipCollapsed(true);
            }
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior3 = accountSettingsBottomSheet.behavior;
            if (bottomSheetBehavior3 != null) {
                bottomSheetBehavior3.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$onCreateDialog$2$1
                    public void onSlide(View bottomSheet, float slideOffset) {
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:11:0x001a, code lost:
                    
                        r2 = r1.this$0.behavior;
                     */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void onStateChanged(View bottomSheet, int newState) {
                        boolean z;
                        BottomSheetBehavior bottomSheetBehavior4;
                        Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        if (newState != 4) {
                            if (newState != 5) {
                                return;
                            }
                            AccountSettingsBottomSheet.this.dismissSafely();
                        } else {
                            z = AccountSettingsBottomSheet.this.contentCanScrollUp;
                            if (!z || bottomSheetBehavior4 == null) {
                                return;
                            }
                            bottomSheetBehavior4.setState(3);
                        }
                    }
                });
            }
            accountSettingsBottomSheet.applyContentScrollState();
        }
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final int dimensionPixelSize = getResources().getDimensionPixelSize(C0820R.dimen.trae_setting_corner_radius);
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$onViewCreated$1
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
        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction().replace(C0820R.id.settings_fragment_container, SettingsMainFragment.INSTANCE.newInstance()).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHideable(View scrollableView) {
        Set<View> set = this.scrollableViews;
        boolean z = false;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                View view = (View) it.next();
                if (view.isShown() && view.canScrollVertically(-1)) {
                    z = true;
                    break;
                }
            }
        }
        setContentCanScrollUp(z);
    }

    public final void setContentCanScrollUp(boolean canScrollUp) {
        this.contentCanScrollUp = canScrollUp;
        applyContentScrollState();
    }

    public final void dismissSafely() {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AccountSettingsBottomSheet.this.dismissSafely();
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

    private final void applyContentScrollState() {
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior2 = this.behavior;
        if (bottomSheetBehavior2 != null) {
            bottomSheetBehavior2.setHideable(!this.contentCanScrollUp);
        }
        if (this.contentCanScrollUp) {
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior3 = this.behavior;
            if ((bottomSheetBehavior3 != null && bottomSheetBehavior3.getState() == 3) || (bottomSheetBehavior = this.behavior) == null) {
                return;
            }
            bottomSheetBehavior.setState(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installScrollGuards(View view) {
        if (view instanceof RecyclerView) {
            registerScrollableView(view);
            ((RecyclerView) view).addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$installScrollGuards$1
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                    AccountSettingsBottomSheet.this.updateHideable((View) recyclerView);
                }
            });
            updateHideable(view);
        } else if (view instanceof NestedScrollView) {
            registerScrollableView(view);
            ((NestedScrollView) view).setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$$ExternalSyntheticLambda2
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    AccountSettingsBottomSheet.installScrollGuards$lambda$3(AccountSettingsBottomSheet.this, nestedScrollView, i, i2, i3, i4);
                }
            });
            updateHideable(view);
        } else if (view instanceof ScrollView) {
            registerScrollableView(view);
            updateHideable(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                installScrollGuards(childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installScrollGuards$lambda$3(AccountSettingsBottomSheet accountSettingsBottomSheet, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(nestedScrollView, "v");
        accountSettingsBottomSheet.updateHideable((View) nestedScrollView);
    }

    private final void registerScrollableView(final View view) {
        if (this.scrollableViews.add(view)) {
            ViewCompat.setNestedScrollingEnabled(view, true);
            view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.trae.home.solo.setting.AccountSettingsBottomSheet$registerScrollableView$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    Set set;
                    if (view.isAttachedToWindow()) {
                        this.updateHideable(view);
                        return;
                    }
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    set = this.scrollableViews;
                    set.remove(view);
                }
            });
        }
    }

    /* compiled from: AccountSettingsBottomSheet.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AccountSettingsBottomSheet newInstance() {
            return new AccountSettingsBottomSheet();
        }
    }
}
