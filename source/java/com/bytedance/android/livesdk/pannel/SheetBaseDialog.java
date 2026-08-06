package com.bytedance.android.livesdk.pannel;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import com.bytedance.android.livesdk.pannel.SheetPullUpProcessor;
import com.bytedance.android.livesdk.pannel.params.DialogUIParam;
import com.bytedance.android.livesdk.pannel.utils.DialogUIParamsParser;
import com.bytedance.android.livesdk.pannel.utils.StyleUtils;
import com.bytedance.android.livesdk.pannel.utils.UIUtils;
import com.bytedance.android.livesdk.pannel.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetBaseDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000 j2\u00020\u00012\u00020\u0002:\u0001jB+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\b\u00106\u001a\u000207H\u0002J\u0012\u00108\u001a\u0002072\b\u0010\u0012\u001a\u0004\u0018\u000109H\u0002J\b\u0010:\u001a\u000207H\u0016J\u0010\u0010;\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=J\u000e\u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020\u0006J\b\u0010@\u001a\u000207H\u0016J\u0018\u0010A\u001a\u0002072\u0006\u0010B\u001a\u00020(2\u0006\u0010C\u001a\u00020/H\u0016J\u0018\u0010D\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010E\u001a\u00020FH\u0002J\b\u0010G\u001a\u000207H\u0016J\u0012\u0010H\u001a\u0002072\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\b\u0010K\u001a\u000207H\u0016J\b\u0010L\u001a\u000207H\u0014J\u0010\u0010M\u001a\u00020\u00062\u0006\u0010E\u001a\u00020FH\u0016J\u0012\u0010N\u001a\u0002072\b\u0010O\u001a\u0004\u0018\u00010/H\u0016J\u000e\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u00020\u001fJ\u0010\u0010R\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0010\u0010S\u001a\u0002072\u0006\u0010:\u001a\u00020\u0006H\u0016J\u0010\u0010T\u001a\u0002072\u0006\u0010O\u001a\u00020/H\u0016J\u001a\u0010T\u001a\u0002072\u0006\u0010O\u001a\u00020/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u0012\u0010T\u001a\u0002072\b\b\u0001\u0010W\u001a\u000205H\u0016J\u001e\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020\u00062\u0006\u0010Z\u001a\u0002052\u0006\u0010[\u001a\u000205J\u000e\u0010\\\u001a\u0002072\u0006\u0010]\u001a\u00020\u0006J\u0010\u0010^\u001a\u0002072\b\u0010_\u001a\u0004\u0018\u00010*J\u000e\u0010`\u001a\u0002072\u0006\u0010a\u001a\u000205J\u000e\u0010b\u001a\u0002072\u0006\u0010c\u001a\u00020!J\u0010\u0010d\u001a\u0002072\b\u0010e\u001a\u0004\u0018\u00010,J\u000e\u0010f\u001a\u0002072\u0006\u0010U\u001a\u00020%J\b\u0010g\u001a\u00020\u0006H\u0002J\b\u0010h\u001a\u00020\u0006H\u0002J$\u0010i\u001a\u00020/2\u0006\u0010W\u001a\u0002052\b\u0010O\u001a\u0004\u0018\u00010/2\b\u0010U\u001a\u0004\u0018\u00010VH\u0002R$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\r\"\u0004\b\u001d\u0010\u000fR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR\u0010\u00103\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"Lcom/bytedance/android/livesdk/pannel/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/bytedance/android/livesdk/pannel/IInjectExitAnimatorDialog;", "context", "Landroid/content/Context;", "isLandscape", "", "isPad", "transStatusBar", "(Landroid/content/Context;ZZZ)V", StrategyConstants.VALUE, "applyCommonUI", "getApplyCommonUI", "()Z", "setApplyCommonUI", "(Z)V", "behavior", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior;", "bottomSheetView", "Lcom/bytedance/android/livesdk/pannel/view/RadiusLayout;", "cancelConfirm", "Lcom/bytedance/android/livesdk/pannel/CancelConfirm;", "getCancelConfirm", "()Lcom/bytedance/android/livesdk/pannel/CancelConfirm;", "setCancelConfirm", "(Lcom/bytedance/android/livesdk/pannel/CancelConfirm;)V", "cancelable", "disableTouchOutsideA11yFocus", "setLandscape", "setPad", "mBottomSheetPullUpProcessor", "Lcom/bytedance/android/livesdk/pannel/SheetPullUpProcessor;", "mBottomSheetSlideProcessor", "Lcom/bytedance/android/livesdk/pannel/SheetSlideProcessor;", "mCanceledOnTouchOutside", "mCanceledOnTouchOutsideSet", "mDialogUIParam", "Lcom/bytedance/android/livesdk/pannel/params/DialogUIParam;", "mEnablePullUp", "mExitAnimator", "Landroid/animation/Animator;", "mLiveBottomSheetOutsideListener", "Lcom/bytedance/android/livesdk/pannel/SheetOutsideListener;", "mSheetCallback", "Lcom/bytedance/android/livesdk/pannel/SheetBaseBehavior$SheetCallback;", "mStateCallback", "mTargetExitAnimationView", "Landroid/view/View;", "popupEnable", "getPopupEnable", "setPopupEnable", "touchOutsideView", "webViewCollapsedHeight", "", "adjustStatusBar", "", "applyDialogUI", "Landroid/view/ViewGroup;", "cancel", "cancelWithCloseType", "closeType", "Lcom/bytedance/android/livesdk/pannel/CloseType;", "disableTouchOutsizeA11yFocus", "disable", "dismiss", "injectExitAnimator", "animator", "targetView", "isOutOfBounds", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onStart", "onTouchEvent", "onViewCreated", "view", "setBottomSheetPullUpProcessor", "bottomSheetPullUpProcessor", "setCancelable", "setCanceledOnTouchOutside", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResId", "setEnablePullUp", "enablePullUp", "fullScreenHeight", "upOffsetHeight", "setHideAble", StrategyConstants.ENABLE, "setLiveBottomSheetOutsideListener", "liveBottomSheetOutsideListener", "setPeekHeight", "peekHeight", "setSheetSlideProcessor", "bottomSheetSlideProcessor", "setStateCallback", "stateCallback", "setUIParams", "shouldTransStatusBar", "shouldWindowCloseOnTouchOutside", "wrapInBottomSheet", "Companion", "panel_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SheetBaseDialog extends AppCompatDialog implements IInjectExitAnimatorDialog {
    public static final int HD_MAX_HEIGHT_DP = 700;
    public static final int HD_RADIUS_DP = 8;
    private boolean applyCommonUI;
    private SheetBaseBehavior<?> behavior;
    private RadiusLayout bottomSheetView;
    private CancelConfirm cancelConfirm;
    private boolean cancelable;
    private boolean disableTouchOutsideA11yFocus;
    private boolean isLandscape;
    private boolean isPad;
    private SheetPullUpProcessor mBottomSheetPullUpProcessor;
    private SheetSlideProcessor mBottomSheetSlideProcessor;
    private boolean mCanceledOnTouchOutside;
    private boolean mCanceledOnTouchOutsideSet;
    private DialogUIParam mDialogUIParam;
    private boolean mEnablePullUp;
    private Animator mExitAnimator;
    private SheetOutsideListener mLiveBottomSheetOutsideListener;
    private final SheetBaseBehavior.SheetCallback mSheetCallback;
    private SheetBaseBehavior.SheetCallback mStateCallback;
    private View mTargetExitAnimationView;
    private boolean popupEnable;
    private View touchOutsideView;
    private final boolean transStatusBar;
    private int webViewCollapsedHeight;

    public void onViewCreated(View view) {
    }

    /* renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    public final void setLandscape(boolean z) {
        this.isLandscape = z;
    }

    /* renamed from: isPad, reason: from getter */
    public final boolean getIsPad() {
        return this.isPad;
    }

    public final void setPad(boolean z) {
        this.isPad = z;
    }

    public /* synthetic */ SheetBaseDialog(Context context, boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SheetBaseDialog(Context context, boolean z, boolean z2, boolean z3) {
        super(context, r0);
        int appCompatStandardTheme;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object value = SettingUtil.getValue("", "live_panel_enable_appcompattheme", Boolean.TYPE, true);
        Intrinsics.checkExpressionValueIsNotNull(value, "SettingUtil.getValue(\"\",…oolean::class.java, true)");
        if (((Boolean) value).booleanValue()) {
            StringBuilder sb = new StringBuilder("context = ");
            String simpleName = context.getClass().getSimpleName();
            Log.d(com.bytedance.android.anniex.container.popup.SheetBaseDialog.TAG, sb.append(simpleName != null ? simpleName : "null").append(" live_panel_enable_appcompattheme = true").toString());
            appCompatStandardTheme = StyleUtils.INSTANCE.getStandardTheme(z, z2);
        } else {
            StringBuilder sb2 = new StringBuilder("new theme context = ");
            String simpleName2 = context.getClass().getSimpleName();
            Log.d(com.bytedance.android.anniex.container.popup.SheetBaseDialog.TAG, sb2.append(simpleName2 != null ? simpleName2 : "null").append(" live_panel_enable_appcompattheme = false").toString());
            appCompatStandardTheme = StyleUtils.INSTANCE.getAppCompatStandardTheme(z, z2);
        }
        this.isLandscape = z;
        this.isPad = z2;
        this.transStatusBar = z3;
        this.cancelable = true;
        this.popupEnable = true;
        this.mCanceledOnTouchOutside = true;
        this.mBottomSheetSlideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$mBottomSheetSlideProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean disableDragDown() {
                return !SheetBaseDialog.this.getPopupEnable() || SheetBaseDialog.this.getIsPad();
            }
        };
        this.mBottomSheetPullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$mBottomSheetPullUpProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.DefaultImpls.disableNestedChildScroll(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.DefaultImpls.enableToFull(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.DefaultImpls.enableToHalf(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent motionEvent) {
                Intrinsics.checkParameterIsNotNull(motionEvent, NotificationCompat.CATEGORY_EVENT);
                return SheetPullUpProcessor.DefaultImpls.inIgnoreArea(this, motionEvent);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.DefaultImpls.isWebViewReachTop(this);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enablePullUp() {
                return !SheetBaseDialog.this.getPopupEnable();
            }
        };
        this.webViewCollapsedHeight = (int) UIUtils.dip2Px(context, 484);
        this.mDialogUIParam = DialogUIParam.INSTANCE.getStandardParam(context);
        this.mSheetCallback = new SheetBaseBehavior.SheetCallback() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$mSheetCallback$1
            @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.SheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                SheetBaseBehavior.SheetCallback sheetCallback;
                SheetBaseBehavior.SheetCallback sheetCallback2;
                Intrinsics.checkParameterIsNotNull(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    SheetBaseDialog.this.cancelWithCloseType(CloseType.PullDown);
                }
                sheetCallback = SheetBaseDialog.this.mStateCallback;
                if (sheetCallback != null) {
                    sheetCallback2 = SheetBaseDialog.this.mStateCallback;
                    if (sheetCallback2 == null) {
                        Intrinsics.throwNpe();
                    }
                    sheetCallback2.onStateChanged(bottomSheet, newState);
                }
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetBaseBehavior.SheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                SheetBaseBehavior.SheetCallback sheetCallback;
                SheetBaseBehavior.SheetCallback sheetCallback2;
                Intrinsics.checkParameterIsNotNull(bottomSheet, "bottomSheet");
                sheetCallback = SheetBaseDialog.this.mStateCallback;
                if (sheetCallback != null) {
                    sheetCallback2 = SheetBaseDialog.this.mStateCallback;
                    if (sheetCallback2 == null) {
                        Intrinsics.throwNpe();
                    }
                    sheetCallback2.onSlide(bottomSheet, slideOffset);
                }
            }
        };
    }

    public boolean getPopupEnable() {
        return this.popupEnable;
    }

    public void setPopupEnable(boolean z) {
        this.popupEnable = z;
    }

    public final CancelConfirm getCancelConfirm() {
        return this.cancelConfirm;
    }

    public final void setCancelConfirm(CancelConfirm cancelConfirm) {
        this.cancelConfirm = cancelConfirm;
    }

    public final boolean getApplyCommonUI() {
        return this.applyCommonUI;
    }

    public final void setApplyCommonUI(boolean z) {
        this.applyCommonUI = z;
        if (z) {
            applyDialogUI(this.bottomSheetView);
        }
    }

    public final void setPeekHeight(int peekHeight) {
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            if (sheetBaseBehavior == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior.setPeekHeight(peekHeight);
        }
    }

    public void setContentView(int layoutResId) {
        super.setContentView(wrapInBottomSheet(layoutResId, null, null));
    }

    public void setContentView(View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        super.setContentView(wrapInBottomSheet(0, view, params));
    }

    public void setCancelable(boolean cancelable) {
        super.setCancelable(cancelable);
        if (this.cancelable != cancelable) {
            this.cancelable = cancelable;
            SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
            if (sheetBaseBehavior != null) {
                if (sheetBaseBehavior == null) {
                    Intrinsics.throwNpe();
                }
                sheetBaseBehavior.setHideAble(cancelable);
            }
        }
    }

    public final void setHideAble(boolean enable) {
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            if (sheetBaseBehavior == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior.setHideAble(enable);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adjustStatusBar();
    }

    private final void adjustStatusBar() {
        if (shouldTransStatusBar()) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(Integer.MIN_VALUE);
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            }
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setStatusBarColor(0);
            }
            Window window4 = getWindow();
            if (window4 != null) {
                window4.clearFlags(1024);
            }
        }
    }

    private final boolean shouldTransStatusBar() {
        return this.isPad || this.transStatusBar;
    }

    protected void onStart() {
        super.onStart();
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            if (sheetBaseBehavior == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior.setState(3);
            if (this.mEnablePullUp) {
                SheetBaseBehavior<?> sheetBaseBehavior2 = this.behavior;
                if (sheetBaseBehavior2 == null) {
                    Intrinsics.throwNpe();
                }
                sheetBaseBehavior2.setState(4);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean cancel) {
        super.setCanceledOnTouchOutside(cancel);
        if (cancel && !this.cancelable) {
            this.cancelable = true;
        }
        this.mCanceledOnTouchOutside = cancel;
        this.mCanceledOnTouchOutsideSet = true;
        View view = this.touchOutsideView;
        if (view != null) {
            if (cancel && !this.disableTouchOutsideA11yFocus) {
                view.setImportantForAccessibility(1);
                view.setFocusable(true);
            } else {
                view.setImportantForAccessibility(2);
                view.setFocusable(false);
            }
        }
    }

    public final void disableTouchOutsizeA11yFocus(boolean disable) {
        this.disableTouchOutsideA11yFocus = disable;
        View view = this.touchOutsideView;
        if (view != null) {
            if (disable) {
                view.setFocusable(false);
                view.setImportantForAccessibility(2);
            } else {
                view.setFocusable(true);
                view.setImportantForAccessibility(1);
            }
        }
    }

    private final View wrapInBottomSheet(int layoutResId, View view, ViewGroup.LayoutParams params) {
        View inflate;
        if (this.isPad) {
            inflate = View.inflate(getContext(), C0890R.layout.ttlive_standard_design_right_sheet_dialog_hd, null);
        } else if (this.isLandscape) {
            inflate = View.inflate(getContext(), C0890R.layout.ttlive_standard_design_right_sheet_dialog, null);
        } else {
            inflate = View.inflate(getContext(), C0890R.layout.ttlive_standard_design_bottom_sheet_dialog, null);
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate.findViewById(C0890R.id.ttlive_coordinator);
        if (layoutResId != 0 && view == null) {
            view = getLayoutInflater().inflate(layoutResId, (ViewGroup) coordinatorLayout, false);
        }
        RadiusLayout radiusLayout = (RadiusLayout) coordinatorLayout.findViewById(C0890R.id.ttlive_design_bottom_sheet);
        this.bottomSheetView = radiusLayout;
        if (this.isPad) {
            if (radiusLayout != null) {
                radiusLayout.setRoundDp(8);
            }
            RadiusLayout radiusLayout2 = this.bottomSheetView;
            if (radiusLayout2 != null) {
                radiusLayout2.setMaxHeight((int) UIUtils.dip2Px(getContext(), 700));
            }
        }
        SheetBaseBehavior<?> from = SheetBaseBehavior.INSTANCE.from(this.bottomSheetView);
        this.behavior = from;
        if (from == null) {
            Intrinsics.throwNpe();
        }
        from.setBottomSheetCallback(this.mSheetCallback);
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior == null) {
            Intrinsics.throwNpe();
        }
        sheetBaseBehavior.setHideAble(this.cancelable);
        if (this.mEnablePullUp) {
            SheetBaseBehavior<?> sheetBaseBehavior2 = this.behavior;
            if (sheetBaseBehavior2 == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior2.setPeekHeight(this.webViewCollapsedHeight);
            SheetBaseBehavior<?> sheetBaseBehavior3 = this.behavior;
            if (sheetBaseBehavior3 == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior3.setSkipCollapsed(false);
        } else {
            SheetBaseBehavior<?> sheetBaseBehavior4 = this.behavior;
            if (sheetBaseBehavior4 == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior4.setSkipCollapsed(true);
        }
        SheetBaseBehavior<?> sheetBaseBehavior5 = this.behavior;
        if (sheetBaseBehavior5 == null) {
            Intrinsics.throwNpe();
        }
        sheetBaseBehavior5.slideProcessor = this.mBottomSheetSlideProcessor;
        SheetBaseBehavior<?> sheetBaseBehavior6 = this.behavior;
        if (sheetBaseBehavior6 == null) {
            Intrinsics.throwNpe();
        }
        sheetBaseBehavior6.pullUpProcessor = this.mBottomSheetPullUpProcessor;
        if (params == null) {
            if (view == null) {
                Intrinsics.throwNpe();
            }
            if (view.getLayoutParams() != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
                layoutParams.gravity = 8388693;
                RadiusLayout radiusLayout3 = this.bottomSheetView;
                if (radiusLayout3 == null) {
                    Intrinsics.throwNpe();
                }
                radiusLayout3.addView(view, layoutParams);
            } else {
                Window window = getWindow();
                if (window != null) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Intrinsics.checkExpressionValueIsNotNull(attributes, "it.attributes");
                    RadiusLayout radiusLayout4 = this.bottomSheetView;
                    if (radiusLayout4 == null) {
                        Intrinsics.throwNpe();
                    }
                    radiusLayout4.addView(view, new FrameLayout.LayoutParams(attributes.width, attributes.height, attributes.gravity));
                } else {
                    RadiusLayout radiusLayout5 = this.bottomSheetView;
                    if (radiusLayout5 == null) {
                        Intrinsics.throwNpe();
                    }
                    radiusLayout5.addView(view);
                }
            }
        } else {
            RadiusLayout radiusLayout6 = this.bottomSheetView;
            if (radiusLayout6 == null) {
                Intrinsics.throwNpe();
            }
            radiusLayout6.addView(view, params);
        }
        onViewCreated(this.bottomSheetView);
        View findViewById = coordinatorLayout.findViewById(C0890R.id.ttlive_touch_outside);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$wrapInBottomSheet$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SheetBaseDialog.this.cancelWithCloseType(CloseType.MaskClick);
            }
        });
        this.touchOutsideView = findViewById;
        RadiusLayout radiusLayout7 = this.bottomSheetView;
        if (radiusLayout7 == null) {
            Intrinsics.throwNpe();
        }
        ViewCompat.setAccessibilityDelegate(radiusLayout7, new AccessibilityDelegateCompat() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$wrapInBottomSheet$4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                boolean z;
                Intrinsics.checkParameterIsNotNull(host, "host");
                Intrinsics.checkParameterIsNotNull(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                z = SheetBaseDialog.this.cancelable;
                if (z) {
                    info.addAction(1048576);
                    info.setDismissable(true);
                } else {
                    info.setDismissable(false);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public boolean performAccessibilityAction(View host, int action, Bundle args) {
                boolean z;
                Intrinsics.checkParameterIsNotNull(host, "host");
                if (action == 1048576) {
                    z = SheetBaseDialog.this.cancelable;
                    if (z) {
                        SheetBaseDialog.this.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(host, action, args);
            }
        });
        RadiusLayout radiusLayout8 = this.bottomSheetView;
        if (radiusLayout8 == null) {
            Intrinsics.throwNpe();
        }
        radiusLayout8.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$wrapInBottomSheet$5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        if (shouldTransStatusBar()) {
            Intrinsics.checkExpressionValueIsNotNull(inflate, "container");
            inflate.setFitsSystemWindows(false);
            Intrinsics.checkExpressionValueIsNotNull(coordinatorLayout, "coordinator");
            coordinatorLayout.setFitsSystemWindows(false);
            RadiusLayout radiusLayout9 = this.bottomSheetView;
            if (radiusLayout9 != null) {
                radiusLayout9.setFitsSystemWindows(false);
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(inflate, "container");
        return inflate;
    }

    private final void applyDialogUI(ViewGroup bottomSheetView) {
        DialogUIParam dialogUIParam;
        Drawable parseUiParams;
        if (!this.applyCommonUI || (dialogUIParam = this.mDialogUIParam) == null || (parseUiParams = DialogUIParamsParser.INSTANCE.parseUiParams(dialogUIParam)) == null || bottomSheetView == null) {
            return;
        }
        bottomSheetView.setBackground(parseUiParams);
    }

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
        if (this.mLiveBottomSheetOutsideListener != null && 1 == event.getAction()) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "getContext()");
            if (isOutOfBounds(context, event)) {
                SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
                if (sheetOutsideListener == null) {
                    Intrinsics.throwNpe();
                }
                sheetOutsideListener.onOutsideClick(shouldWindowCloseOnTouchOutside());
                SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
                if (sheetOutsideListener2 == null) {
                    Intrinsics.throwNpe();
                }
                sheetOutsideListener2.onOutsideClickWithCloseType(shouldWindowCloseOnTouchOutside(), CloseType.MaskClick);
            }
        }
        return super.onTouchEvent(event);
    }

    private final boolean isOutOfBounds(Context context, MotionEvent event) {
        int i;
        int x = (int) event.getX();
        int y = (int) event.getY();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkExpressionValueIsNotNull(viewConfiguration, "ViewConfiguration.get(context)");
        int scaledWindowTouchSlop = viewConfiguration.getScaledWindowTouchSlop();
        if (getWindow() == null) {
            return true;
        }
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        return decorView == null || x < (i = -scaledWindowTouchSlop) || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }

    private final boolean shouldWindowCloseOnTouchOutside() {
        if (!this.mCanceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.windowCloseOnTouchOutside});
            Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "getContext().obtainStyle…ndowCloseOnTouchOutside))");
            this.mCanceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            Log.d(com.bytedance.android.anniex.container.popup.SheetBaseDialog.TAG, "mCanceledOnTouchOutside = StyledAttributes = " + this.mCanceledOnTouchOutside);
            obtainStyledAttributes.recycle();
            this.mCanceledOnTouchOutsideSet = true;
        }
        Log.d(com.bytedance.android.anniex.container.popup.SheetBaseDialog.TAG, "mCanceledOnTouchOutside = " + this.mCanceledOnTouchOutside);
        return this.mCanceledOnTouchOutside;
    }

    public final void setStateCallback(SheetBaseBehavior.SheetCallback stateCallback) {
        this.mStateCallback = stateCallback;
    }

    public final void setSheetSlideProcessor(final SheetSlideProcessor bottomSheetSlideProcessor) {
        Intrinsics.checkParameterIsNotNull(bottomSheetSlideProcessor, "bottomSheetSlideProcessor");
        this.mBottomSheetSlideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$setSheetSlideProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean disableDragDown() {
                return bottomSheetSlideProcessor.disableDragDown() || !SheetBaseDialog.this.getPopupEnable() || SheetBaseDialog.this.getIsPad();
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean shouldInterceptSlide(int touchY) {
                return bottomSheetSlideProcessor.shouldInterceptSlide(touchY);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetSlideProcessor
            public boolean inIndicatorArea(MotionEvent event) {
                return bottomSheetSlideProcessor.inIndicatorArea(event);
            }
        };
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            if (sheetBaseBehavior == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior.slideProcessor = this.mBottomSheetSlideProcessor;
        }
    }

    public final void setBottomSheetPullUpProcessor(final SheetPullUpProcessor bottomSheetPullUpProcessor) {
        Intrinsics.checkParameterIsNotNull(bottomSheetPullUpProcessor, "bottomSheetPullUpProcessor");
        this.mBottomSheetPullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$setBottomSheetPullUpProcessor$1
            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enablePullUp() {
                return bottomSheetPullUpProcessor.enablePullUp() && SheetBaseDialog.this.getPopupEnable();
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToHalf() {
                return bottomSheetPullUpProcessor.enablePullUp() && bottomSheetPullUpProcessor.enableToHalf();
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean enableToFull() {
                return bottomSheetPullUpProcessor.enablePullUp() && bottomSheetPullUpProcessor.enableToFull();
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return bottomSheetPullUpProcessor.isWebViewReachTop();
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent event) {
                Intrinsics.checkParameterIsNotNull(event, NotificationCompat.CATEGORY_EVENT);
                return bottomSheetPullUpProcessor.inIgnoreArea(event);
            }

            @Override // com.bytedance.android.livesdk.pannel.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return bottomSheetPullUpProcessor.disableNestedChildScroll();
            }
        };
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            if (sheetBaseBehavior == null) {
                Intrinsics.throwNpe();
            }
            sheetBaseBehavior.pullUpProcessor = this.mBottomSheetPullUpProcessor;
        }
    }

    public final void setLiveBottomSheetOutsideListener(SheetOutsideListener liveBottomSheetOutsideListener) {
        this.mLiveBottomSheetOutsideListener = liveBottomSheetOutsideListener;
    }

    public final void setEnablePullUp(boolean enablePullUp, int fullScreenHeight, int upOffsetHeight) {
        this.mEnablePullUp = enablePullUp;
        if (upOffsetHeight > 0) {
            this.webViewCollapsedHeight = (int) UIUtils.dip2Px(getContext(), fullScreenHeight - upOffsetHeight);
        }
    }

    public void dismiss() {
        Animator animator = this.mExitAnimator;
        if (animator == null) {
            super.dismiss();
            return;
        }
        if (animator == null) {
            Intrinsics.throwNpe();
        }
        if (animator.isRunning()) {
            return;
        }
        Animator animator2 = this.mExitAnimator;
        if (animator2 == null) {
            Intrinsics.throwNpe();
        }
        animator2.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$dismiss$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkParameterIsNotNull(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                View view;
                View view2;
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                view = SheetBaseDialog.this.mTargetExitAnimationView;
                if (view != null) {
                    view2 = SheetBaseDialog.this.mTargetExitAnimationView;
                    if (view2 == null) {
                        Intrinsics.throwNpe();
                    }
                    view2.setVisibility(8);
                }
                super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                View view;
                View view2;
                Intrinsics.checkParameterIsNotNull(animation, "animation");
                view = SheetBaseDialog.this.mTargetExitAnimationView;
                if (view != null) {
                    view2 = SheetBaseDialog.this.mTargetExitAnimationView;
                    if (view2 == null) {
                        Intrinsics.throwNpe();
                    }
                    view2.setVisibility(8);
                }
                super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
            }
        });
        Animator animator3 = this.mExitAnimator;
        if (animator3 == null) {
            Intrinsics.throwNpe();
        }
        animator3.start();
    }

    @Override // com.bytedance.android.livesdk.pannel.IInjectExitAnimatorDialog
    public void injectExitAnimator(Animator animator, View targetView) {
        Intrinsics.checkParameterIsNotNull(animator, "animator");
        Intrinsics.checkParameterIsNotNull(targetView, "targetView");
        this.mExitAnimator = animator;
        this.mTargetExitAnimationView = targetView;
    }

    public void cancel() {
        if (this.cancelable && isShowing() && shouldWindowCloseOnTouchOutside()) {
            CancelConfirm cancelConfirm = this.cancelConfirm;
            if (cancelConfirm != null) {
                cancelConfirm.onCancel(new Function0<Unit>() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$cancel$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3475invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m3475invoke() {
                        super/*androidx.appcompat.app.AppCompatDialog*/.cancel();
                    }
                });
                return;
            } else {
                super.cancel();
                return;
            }
        }
        SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener != null) {
            if (sheetOutsideListener == null) {
                Intrinsics.throwNpe();
            }
            sheetOutsideListener.onOutsideClick(false);
            SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
            if (sheetOutsideListener2 == null) {
                Intrinsics.throwNpe();
            }
            sheetOutsideListener2.onOutsideClickWithCloseType(false, CloseType.UnKnown);
        }
    }

    public final void cancelWithCloseType(CloseType closeType) {
        Log.d(com.bytedance.android.anniex.container.popup.SheetBaseDialog.TAG, "cancelWithCloseType");
        if (this.cancelable && isShowing() && shouldWindowCloseOnTouchOutside()) {
            CancelConfirm cancelConfirm = this.cancelConfirm;
            if (cancelConfirm != null) {
                cancelConfirm.onCancel(new Function0<Unit>() { // from class: com.bytedance.android.livesdk.pannel.SheetBaseDialog$cancelWithCloseType$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m3476invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m3476invoke() {
                        super/*androidx.appcompat.app.AppCompatDialog*/.cancel();
                    }
                });
                return;
            } else {
                super.cancel();
                return;
            }
        }
        SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener != null) {
            if (sheetOutsideListener == null) {
                Intrinsics.throwNpe();
            }
            sheetOutsideListener.onOutsideClick(false);
        }
        SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener2 == null || closeType == null) {
            return;
        }
        if (sheetOutsideListener2 == null) {
            Intrinsics.throwNpe();
        }
        sheetOutsideListener2.onOutsideClickWithCloseType(shouldWindowCloseOnTouchOutside(), closeType);
    }

    public void onBackPressed() {
        cancelWithCloseType(CloseType.SystemBack);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mExitAnimator;
        if (animator != null) {
            if (animator == null) {
                Intrinsics.throwNpe();
            }
            animator.removeAllListeners();
            Animator animator2 = this.mExitAnimator;
            if (animator2 == null) {
                Intrinsics.throwNpe();
            }
            animator2.cancel();
            this.mExitAnimator = null;
        }
    }

    public final void setUIParams(DialogUIParam params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        this.mDialogUIParam = params;
    }
}
