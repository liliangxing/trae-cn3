package com.bytedance.android.anniex.container.popup;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
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
import com.bytedance.android.anniex.C0840R;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import com.bytedance.android.anniex.container.popup.SheetPullUpProcessor;
import com.bytedance.android.anniex.container.popup.SheetSlideProcessor;
import com.bytedance.android.anniex.container.view.LimitedHeightFrameLayout;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SheetBaseDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 g2\u00020\u0001:\u0001gB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\"J\b\u00101\u001a\u00020/H\u0002J\b\u00102\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020/2\b\u00104\u001a\u0004\u0018\u000105J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020/H\u0016J\r\u00109\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010:J\b\u0010;\u001a\u00020/H\u0016J\u0016\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u001e2\u0006\u0010>\u001a\u00020%J\u0018\u0010?\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020/H\u0016J\u0012\u0010C\u001a\u00020/2\b\u0010D\u001a\u0004\u0018\u00010EH\u0014J\b\u0010F\u001a\u00020/H\u0016J\u0010\u0010G\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010H\u001a\u00020/H\u0014J\b\u0010I\u001a\u00020/H\u0014J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010K\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010%J\u0010\u0010M\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\"J\u000e\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020\u0017J\u0010\u0010P\u001a\u00020/2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010Q\u001a\u00020/2\u0006\u00102\u001a\u00020\u0005H\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010L\u001a\u00020%H\u0016J\u001a\u0010R\u001a\u00020/2\u0006\u0010L\u001a\u00020%2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010R\u001a\u00020/2\b\b\u0001\u0010U\u001a\u00020\nH\u0016J\u001e\u0010V\u001a\u00020/2\u0006\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020\n2\u0006\u0010Y\u001a\u00020\nJ\u0010\u0010Z\u001a\u00020/2\u0006\u0010[\u001a\u00020\u0005H\u0002J\u0010\u0010\\\u001a\u00020/2\b\u0010]\u001a\u0004\u0018\u00010 J\u000e\u0010^\u001a\u00020/2\u0006\u0010_\u001a\u00020\nJ\u000e\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020\u0019J\u0010\u0010b\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\"J\b\u0010c\u001a\u00020\u0005H\u0002J\b\u0010d\u001a\u00020\u0005H\u0002J\b\u0010e\u001a\u00020/H\u0016J$\u0010f\u001a\u00020%2\u0006\u0010U\u001a\u00020\n2\b\u0010L\u001a\u0004\u0018\u00010%2\b\u0010S\u001a\u0004\u0018\u00010TH\u0002R\u0014\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0012\"\u0004\b\u0015\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001e\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\"0*j\b\u0012\u0004\u0012\u00020\"`+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"Lcom/bytedance/android/anniex/container/popup/SheetBaseDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "isLandscape", "", "isPad", "transStatusBar", "uniformStyleAdapter", "initWindowWidth", "", "(Landroid/content/Context;ZZZZI)V", "behavior", "Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior;", "bottomSheetView", "Lcom/bytedance/android/anniex/container/view/LimitedHeightFrameLayout;", "cancelable", "disableTouchOutsideA11yFocus", "()Z", "setLandscape", "(Z)V", "setPad", "mBottomSheetPullUpProcessor", "Lcom/bytedance/android/anniex/container/popup/SheetPullUpProcessor;", "mBottomSheetSlideProcessor", "Lcom/bytedance/android/anniex/container/popup/SheetSlideProcessor;", "mCanceledOnTouchOutside", "mCanceledOnTouchOutsideSet", "mEnablePullUp", "mExitAnimator", "Landroid/animation/Animator;", "mLiveBottomSheetOutsideListener", "Lcom/bytedance/android/anniex/container/popup/SheetOutsideListener;", "mSheetCallback", "Lcom/bytedance/android/anniex/container/popup/SheetBaseBehavior$SheetCallback;", "mStateCallback", "mTargetExitAnimationView", "Landroid/view/View;", "popupEnable", "getPopupEnable", "setPopupEnable", "stateCallbackList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "touchOutsideView", "webViewCollapsedHeight", "addStateCallback", "", "stateCallback", "adjustStatusBar", "cancel", "cancelWithCloseType", "popupCloseType", "Lcom/bytedance/android/anniex/container/popup/PopupCloseType;", "disableTouchOutsizeA11yFocus", "disable", "dismiss", "getCollapsedPxHeight", "()Ljava/lang/Integer;", "hide", "injectExitAnimator", "animator", "targetView", "isOutOfBounds", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onRestoreInstanceState", "onStart", "onStop", "onTouchEvent", "onViewCreated", "view", "removeStateCallback", "setBottomSheetPullUpProcessor", "bottomSheetPullUpProcessor", "setCancelable", "setCanceledOnTouchOutside", "setContentView", "params", "Landroid/view/ViewGroup$LayoutParams;", "layoutResId", "setEnablePullUp", "enablePullUp", "fullScreenHeight", "upOffsetHeight", "setHideAble", StrategyConstants.ENABLE, "setLiveBottomSheetOutsideListener", "liveBottomSheetOutsideListener", "setPeekHeight", "peekHeight", "setSheetSlideProcessor", "bottomSheetSlideProcessor", "setStateCallback", "shouldTransStatusBar", "shouldWindowCloseOnTouchOutside", "show", "wrapInBottomSheet", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SheetBaseDialog extends AppCompatDialog {
    public static final int HD_MAX_HEIGHT_DP = 700;
    public static final int HD_RADIUS_DP = 8;
    public static final String TAG = "SheetBaseDialog";
    private SheetBaseBehavior<?> behavior;
    private LimitedHeightFrameLayout bottomSheetView;
    private boolean cancelable;
    private boolean disableTouchOutsideA11yFocus;
    private final int initWindowWidth;
    private boolean isLandscape;
    private boolean isPad;
    private SheetPullUpProcessor mBottomSheetPullUpProcessor;
    private SheetSlideProcessor mBottomSheetSlideProcessor;
    private boolean mCanceledOnTouchOutside;
    private boolean mCanceledOnTouchOutsideSet;
    private boolean mEnablePullUp;
    private Animator mExitAnimator;
    private SheetOutsideListener mLiveBottomSheetOutsideListener;
    private final SheetBaseBehavior.SheetCallback mSheetCallback;
    private SheetBaseBehavior.SheetCallback mStateCallback;
    private View mTargetExitAnimationView;
    private boolean popupEnable;
    private ArrayList<SheetBaseBehavior.SheetCallback> stateCallbackList;
    private View touchOutsideView;
    private final boolean transStatusBar;
    private final boolean uniformStyleAdapter;
    private int webViewCollapsedHeight;

    public /* synthetic */ SheetBaseDialog(Context context, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? false : z3, (i2 & 16) != 0 ? false : z4, (i2 & 32) == 0 ? i : 0);
    }

    /* renamed from: isLandscape, reason: from getter */
    public final boolean getIsLandscape() {
        return this.isLandscape;
    }

    /* renamed from: isPad, reason: from getter */
    public final boolean getIsPad() {
        return this.isPad;
    }

    public final void setLandscape(boolean z) {
        this.isLandscape = z;
    }

    public final void setPad(boolean z) {
        this.isPad = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SheetBaseDialog(Context context, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        super(context, StyleUtils.getAppCompatStandardTheme$default(StyleUtils.INSTANCE, false, false, 3, null));
        Intrinsics.checkNotNullParameter(context, "context");
        this.isLandscape = z;
        this.isPad = z2;
        this.transStatusBar = z3;
        this.uniformStyleAdapter = z4;
        this.initWindowWidth = i;
        this.cancelable = true;
        this.popupEnable = true;
        this.mCanceledOnTouchOutside = true;
        this.stateCallbackList = new ArrayList<>();
        this.mBottomSheetSlideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$mBottomSheetSlideProcessor$1
            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean inIndicatorArea(MotionEvent motionEvent) {
                return SheetSlideProcessor.DefaultImpls.inIndicatorArea(this, motionEvent);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean shouldInterceptSlide(int i2) {
                return SheetSlideProcessor.DefaultImpls.shouldInterceptSlide(this, i2);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean disableDragDown() {
                return !SheetBaseDialog.this.getPopupEnable() || SheetBaseDialog.this.getIsPad();
            }
        };
        this.mBottomSheetPullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$mBottomSheetPullUpProcessor$1
            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.DefaultImpls.disableNestedChildScroll(this);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.DefaultImpls.enableToFull(this);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.DefaultImpls.enableToHalf(this);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent motionEvent) {
                return SheetPullUpProcessor.DefaultImpls.inIgnoreArea(this, motionEvent);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.DefaultImpls.isWebViewReachTop(this);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enablePullUp() {
                return !SheetBaseDialog.this.getPopupEnable();
            }
        };
        this.webViewCollapsedHeight = UIUtils.dpToPx$anniex_release(484, context);
        this.mSheetCallback = new SheetBaseBehavior.SheetCallback() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$mSheetCallback$1
            @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                SheetBaseBehavior.SheetCallback sheetCallback;
                ArrayList arrayList;
                SheetBaseBehavior.SheetCallback sheetCallback2;
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    SheetBaseDialog.this.cancelWithCloseType(PopupCloseType.PULL_DOWN);
                }
                sheetCallback = SheetBaseDialog.this.mStateCallback;
                if (sheetCallback != null) {
                    sheetCallback2 = SheetBaseDialog.this.mStateCallback;
                    Intrinsics.checkNotNull(sheetCallback2);
                    sheetCallback2.onStateChanged(bottomSheet, newState);
                }
                arrayList = SheetBaseDialog.this.stateCallbackList;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((SheetBaseBehavior.SheetCallback) it.next()).onStateChanged(bottomSheet, newState);
                }
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.SheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                SheetBaseBehavior.SheetCallback sheetCallback;
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                sheetCallback = SheetBaseDialog.this.mStateCallback;
                if (sheetCallback != null) {
                    sheetCallback.onSlide(bottomSheet, slideOffset);
                }
                arrayList = SheetBaseDialog.this.stateCallbackList;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((SheetBaseBehavior.SheetCallback) it.next()).onSlide(bottomSheet, slideOffset);
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

    public final void setPeekHeight(int peekHeight) {
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            Intrinsics.checkNotNull(sheetBaseBehavior);
            sheetBaseBehavior.setPeekHeight(peekHeight);
        }
    }

    public void setContentView(int layoutResId) {
        super.setContentView(wrapInBottomSheet(layoutResId, null, null));
    }

    public void setContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(wrapInBottomSheet(0, view, null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.setContentView(wrapInBottomSheet(0, view, params));
    }

    public void setCancelable(boolean cancelable) {
        Object obj;
        super.setCancelable(cancelable);
        if (this.cancelable != cancelable) {
            this.cancelable = cancelable;
            SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
            if (sheetBaseBehavior != null) {
                Intrinsics.checkNotNull(sheetBaseBehavior);
                sheetBaseBehavior.setHideAble(cancelable);
            }
        }
        if (cancelable || !IConditionCallKt.enableAnnieXDialogHideAbleFix()) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            setHideAble(true);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Result.exceptionOrNull-impl(obj);
    }

    private final void setHideAble(boolean enable) {
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            Intrinsics.checkNotNull(sheetBaseBehavior);
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
            Intrinsics.checkNotNull(sheetBaseBehavior);
            sheetBaseBehavior.setState(3);
            if (this.mEnablePullUp) {
                SheetBaseBehavior<?> sheetBaseBehavior2 = this.behavior;
                Intrinsics.checkNotNull(sheetBaseBehavior2);
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
            if (IConditionCallKt.disableTouchOutsizeA11yFocusFix()) {
                if (cancel && !this.disableTouchOutsideA11yFocus) {
                    view.setImportantForAccessibility(1);
                    view.setFocusable(true);
                    return;
                } else {
                    view.setImportantForAccessibility(2);
                    view.setFocusable(false);
                    return;
                }
            }
            if (cancel) {
                view.setImportantForAccessibility(1);
                view.setFocusable(true);
            } else {
                view.setImportantForAccessibility(2);
                view.setFocusable(false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final View wrapInBottomSheet(int layoutResId, View view, ViewGroup.LayoutParams params) {
        View inflate;
        CoordinatorLayout coordinatorLayout;
        LimitedHeightFrameLayout limitedHeightFrameLayout;
        Unit unit = null;
        if (this.uniformStyleAdapter) {
            int i = this.initWindowWidth;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (i >= UIUtils.dpToPx$anniex_release(480, context)) {
                inflate = View.inflate(getContext(), C0840R.layout.annie_x_dialog_bottom_sheet, null);
                coordinatorLayout = (CoordinatorLayout) inflate.findViewById(C0840R.id.annie_x_bottom_sheet_coordinator);
                if (layoutResId != 0 && view == null) {
                    view = getLayoutInflater().inflate(layoutResId, (ViewGroup) coordinatorLayout, false);
                }
                limitedHeightFrameLayout = (LimitedHeightFrameLayout) coordinatorLayout.findViewById(C0840R.id.annie_x_bottom_sheet);
                this.bottomSheetView = limitedHeightFrameLayout;
                if (this.isPad && !this.uniformStyleAdapter && limitedHeightFrameLayout != null) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    limitedHeightFrameLayout.setMaxHeight(UIUtils.dpToPx$anniex_release(700, context2));
                }
                SheetBaseBehavior<?> from = SheetBaseBehavior.INSTANCE.from(this.bottomSheetView);
                this.behavior = from;
                Intrinsics.checkNotNull(from);
                from.setBottomSheetCallback(this.mSheetCallback);
                SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
                Intrinsics.checkNotNull(sheetBaseBehavior);
                sheetBaseBehavior.setHideAble(this.cancelable);
                if (!this.mEnablePullUp) {
                    SheetBaseBehavior<?> sheetBaseBehavior2 = this.behavior;
                    Intrinsics.checkNotNull(sheetBaseBehavior2);
                    sheetBaseBehavior2.setPeekHeight(this.webViewCollapsedHeight);
                    SheetBaseBehavior<?> sheetBaseBehavior3 = this.behavior;
                    Intrinsics.checkNotNull(sheetBaseBehavior3);
                    sheetBaseBehavior3.setSkipCollapsed(false);
                } else {
                    SheetBaseBehavior<?> sheetBaseBehavior4 = this.behavior;
                    Intrinsics.checkNotNull(sheetBaseBehavior4);
                    sheetBaseBehavior4.setSkipCollapsed(true);
                }
                SheetBaseBehavior<?> sheetBaseBehavior5 = this.behavior;
                Intrinsics.checkNotNull(sheetBaseBehavior5);
                sheetBaseBehavior5.slideProcessor = this.mBottomSheetSlideProcessor;
                SheetBaseBehavior<?> sheetBaseBehavior6 = this.behavior;
                Intrinsics.checkNotNull(sheetBaseBehavior6);
                sheetBaseBehavior6.pullUpProcessor = this.mBottomSheetPullUpProcessor;
                if (params != null) {
                    Intrinsics.checkNotNull(view);
                    if (view.getLayoutParams() != null) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getLayoutParams());
                        layoutParams.gravity = 8388693;
                        LimitedHeightFrameLayout limitedHeightFrameLayout2 = this.bottomSheetView;
                        Intrinsics.checkNotNull(limitedHeightFrameLayout2);
                        limitedHeightFrameLayout2.addView(view, layoutParams);
                    } else {
                        Window window = getWindow();
                        if (window != null) {
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            Intrinsics.checkNotNullExpressionValue(attributes, "it.attributes");
                            LimitedHeightFrameLayout limitedHeightFrameLayout3 = this.bottomSheetView;
                            Intrinsics.checkNotNull(limitedHeightFrameLayout3);
                            limitedHeightFrameLayout3.addView(view, new FrameLayout.LayoutParams(attributes.width, attributes.height, attributes.gravity));
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            LimitedHeightFrameLayout limitedHeightFrameLayout4 = this.bottomSheetView;
                            Intrinsics.checkNotNull(limitedHeightFrameLayout4);
                            limitedHeightFrameLayout4.addView(view);
                        }
                    }
                } else {
                    LimitedHeightFrameLayout limitedHeightFrameLayout5 = this.bottomSheetView;
                    Intrinsics.checkNotNull(limitedHeightFrameLayout5);
                    limitedHeightFrameLayout5.addView(view, params);
                }
                onViewCreated(this.bottomSheetView);
                View findViewById = coordinatorLayout.findViewById(C0840R.id.annie_x_bottom_sheet_outside);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$3$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SheetBaseDialog.this.cancelWithCloseType(PopupCloseType.CLICK_MASK);
                    }
                });
                this.touchOutsideView = findViewById;
                LimitedHeightFrameLayout limitedHeightFrameLayout6 = this.bottomSheetView;
                Intrinsics.checkNotNull(limitedHeightFrameLayout6);
                ViewCompat.setAccessibilityDelegate(limitedHeightFrameLayout6, new AccessibilityDelegateCompat() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$4
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                        boolean z;
                        Intrinsics.checkNotNullParameter(host, "host");
                        Intrinsics.checkNotNullParameter(info, "info");
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
                        Intrinsics.checkNotNullParameter(host, "host");
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
                LimitedHeightFrameLayout limitedHeightFrameLayout7 = this.bottomSheetView;
                Intrinsics.checkNotNull(limitedHeightFrameLayout7);
                limitedHeightFrameLayout7.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$5
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view2, MotionEvent motionEvent) {
                        return true;
                    }
                });
                if (shouldTransStatusBar()) {
                    inflate.setFitsSystemWindows(false);
                    coordinatorLayout.setFitsSystemWindows(false);
                    LimitedHeightFrameLayout limitedHeightFrameLayout8 = this.bottomSheetView;
                    if (limitedHeightFrameLayout8 != null) {
                        limitedHeightFrameLayout8.setFitsSystemWindows(false);
                    }
                }
                Intrinsics.checkNotNullExpressionValue(inflate, "container");
                return inflate;
            }
        }
        if (this.isPad && !this.uniformStyleAdapter) {
            inflate = View.inflate(getContext(), C0840R.layout.annie_x_dialog_right_sheet_hd, null);
        } else if (this.isLandscape) {
            inflate = View.inflate(getContext(), C0840R.layout.annie_x_dialog_right_sheet, null);
        } else {
            inflate = View.inflate(getContext(), C0840R.layout.annie_x_dialog_bottom_sheet, null);
        }
        coordinatorLayout = (CoordinatorLayout) inflate.findViewById(C0840R.id.annie_x_bottom_sheet_coordinator);
        if (layoutResId != 0) {
            view = getLayoutInflater().inflate(layoutResId, (ViewGroup) coordinatorLayout, false);
        }
        limitedHeightFrameLayout = (LimitedHeightFrameLayout) coordinatorLayout.findViewById(C0840R.id.annie_x_bottom_sheet);
        this.bottomSheetView = limitedHeightFrameLayout;
        if (this.isPad) {
            Context context22 = getContext();
            Intrinsics.checkNotNullExpressionValue(context22, "context");
            limitedHeightFrameLayout.setMaxHeight(UIUtils.dpToPx$anniex_release(700, context22));
        }
        SheetBaseBehavior<?> from2 = SheetBaseBehavior.INSTANCE.from(this.bottomSheetView);
        this.behavior = from2;
        Intrinsics.checkNotNull(from2);
        from2.setBottomSheetCallback(this.mSheetCallback);
        SheetBaseBehavior<?> sheetBaseBehavior7 = this.behavior;
        Intrinsics.checkNotNull(sheetBaseBehavior7);
        sheetBaseBehavior7.setHideAble(this.cancelable);
        if (!this.mEnablePullUp) {
        }
        SheetBaseBehavior<?> sheetBaseBehavior52 = this.behavior;
        Intrinsics.checkNotNull(sheetBaseBehavior52);
        sheetBaseBehavior52.slideProcessor = this.mBottomSheetSlideProcessor;
        SheetBaseBehavior<?> sheetBaseBehavior62 = this.behavior;
        Intrinsics.checkNotNull(sheetBaseBehavior62);
        sheetBaseBehavior62.pullUpProcessor = this.mBottomSheetPullUpProcessor;
        if (params != null) {
        }
        onViewCreated(this.bottomSheetView);
        View findViewById2 = coordinatorLayout.findViewById(C0840R.id.annie_x_bottom_sheet_outside);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$3$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SheetBaseDialog.this.cancelWithCloseType(PopupCloseType.CLICK_MASK);
            }
        });
        this.touchOutsideView = findViewById2;
        LimitedHeightFrameLayout limitedHeightFrameLayout62 = this.bottomSheetView;
        Intrinsics.checkNotNull(limitedHeightFrameLayout62);
        ViewCompat.setAccessibilityDelegate(limitedHeightFrameLayout62, new AccessibilityDelegateCompat() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                boolean z;
                Intrinsics.checkNotNullParameter(host, "host");
                Intrinsics.checkNotNullParameter(info, "info");
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
                Intrinsics.checkNotNullParameter(host, "host");
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
        LimitedHeightFrameLayout limitedHeightFrameLayout72 = this.bottomSheetView;
        Intrinsics.checkNotNull(limitedHeightFrameLayout72);
        limitedHeightFrameLayout72.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$wrapInBottomSheet$5
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return true;
            }
        });
        if (shouldTransStatusBar()) {
        }
        Intrinsics.checkNotNullExpressionValue(inflate, "container");
        return inflate;
    }

    public final void onViewCreated(View view) {
        if (view != null && this.isPad && !this.uniformStyleAdapter) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.LayoutParams layoutParams2 = (CoordinatorLayout.LayoutParams) layoutParams;
                layoutParams2.leftMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.bottomMargin = 0;
            }
            LimitedHeightFrameLayout limitedHeightFrameLayout = view instanceof LimitedHeightFrameLayout ? (LimitedHeightFrameLayout) view : null;
            if (limitedHeightFrameLayout != null) {
                limitedHeightFrameLayout.setMaxHeight(0);
            }
            layoutParams.width = -2;
            view.setLayoutParams(layoutParams);
        }
        if (IConditionCallKt.disableTouchOutsizeA11yFocusFix()) {
            disableTouchOutsizeA11yFocus(true);
        }
    }

    private final void disableTouchOutsizeA11yFocus(boolean disable) {
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

    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (this.mLiveBottomSheetOutsideListener != null && 1 == event.getAction()) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            if (isOutOfBounds(context, event)) {
                SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
                Intrinsics.checkNotNull(sheetOutsideListener);
                sheetOutsideListener.onOutsideClick(shouldWindowCloseOnTouchOutside());
                SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
                Intrinsics.checkNotNull(sheetOutsideListener2);
                sheetOutsideListener2.onOutsideClickWithCloseType(shouldWindowCloseOnTouchOutside(), PopupCloseType.CLICK_MASK);
            }
        }
        return super.onTouchEvent(event);
    }

    private final boolean isOutOfBounds(Context context, MotionEvent event) {
        int i;
        int x = (int) event.getX();
        int y = (int) event.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        if (getWindow() == null) {
            return true;
        }
        Window window = getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        return decorView == null || x < (i = -scaledWindowTouchSlop) || y < i || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }

    private final boolean shouldWindowCloseOnTouchOutside() {
        if (!this.mCanceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "getContext().obtainStyle…ndowCloseOnTouchOutside))");
            this.mCanceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.mCanceledOnTouchOutsideSet = true;
        }
        return this.mCanceledOnTouchOutside;
    }

    public final void setStateCallback(SheetBaseBehavior.SheetCallback stateCallback) {
        this.mStateCallback = stateCallback;
    }

    public final void addStateCallback(SheetBaseBehavior.SheetCallback stateCallback) {
        if (stateCallback == null || this.stateCallbackList.contains(stateCallback)) {
            return;
        }
        this.stateCallbackList.add(stateCallback);
    }

    public final void removeStateCallback(SheetBaseBehavior.SheetCallback stateCallback) {
        if (stateCallback == null || !this.stateCallbackList.contains(stateCallback)) {
            return;
        }
        this.stateCallbackList.remove(stateCallback);
    }

    public final void setSheetSlideProcessor(final SheetSlideProcessor bottomSheetSlideProcessor) {
        Intrinsics.checkNotNullParameter(bottomSheetSlideProcessor, "bottomSheetSlideProcessor");
        this.mBottomSheetSlideProcessor = new SheetSlideProcessor() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$setSheetSlideProcessor$1
            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean disableDragDown() {
                return SheetSlideProcessor.this.disableDragDown() || !this.getPopupEnable() || this.getIsPad();
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean shouldInterceptSlide(int touchY) {
                return SheetSlideProcessor.this.shouldInterceptSlide(touchY);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetSlideProcessor
            public boolean inIndicatorArea(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                return SheetSlideProcessor.this.inIndicatorArea(event);
            }
        };
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            Intrinsics.checkNotNull(sheetBaseBehavior);
            sheetBaseBehavior.slideProcessor = this.mBottomSheetSlideProcessor;
        }
    }

    public final void setBottomSheetPullUpProcessor(final SheetPullUpProcessor bottomSheetPullUpProcessor) {
        Intrinsics.checkNotNullParameter(bottomSheetPullUpProcessor, "bottomSheetPullUpProcessor");
        this.mBottomSheetPullUpProcessor = new SheetPullUpProcessor() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$setBottomSheetPullUpProcessor$1
            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enablePullUp() {
                return SheetPullUpProcessor.this.enablePullUp() && this.getPopupEnable();
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enableToHalf() {
                return SheetPullUpProcessor.this.enablePullUp() && SheetPullUpProcessor.this.enableToHalf();
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean enableToFull() {
                return SheetPullUpProcessor.this.enablePullUp() && SheetPullUpProcessor.this.enableToFull();
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean isWebViewReachTop() {
                return SheetPullUpProcessor.this.isWebViewReachTop();
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean inIgnoreArea(MotionEvent event) {
                Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
                return SheetPullUpProcessor.this.inIgnoreArea(event);
            }

            @Override // com.bytedance.android.anniex.container.popup.SheetPullUpProcessor
            public boolean disableNestedChildScroll() {
                return SheetPullUpProcessor.this.disableNestedChildScroll();
            }
        };
        SheetBaseBehavior<?> sheetBaseBehavior = this.behavior;
        if (sheetBaseBehavior != null) {
            Intrinsics.checkNotNull(sheetBaseBehavior);
            sheetBaseBehavior.pullUpProcessor = this.mBottomSheetPullUpProcessor;
        }
    }

    public final void setLiveBottomSheetOutsideListener(SheetOutsideListener liveBottomSheetOutsideListener) {
        this.mLiveBottomSheetOutsideListener = liveBottomSheetOutsideListener;
    }

    public final void setEnablePullUp(boolean enablePullUp, int fullScreenHeight, int upOffsetHeight) {
        this.mEnablePullUp = enablePullUp;
        if (upOffsetHeight > 0) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            this.webViewCollapsedHeight = UIUtils.dpToPx$anniex_release(fullScreenHeight - upOffsetHeight, context);
        }
    }

    public final Integer getCollapsedPxHeight() {
        if (this.mEnablePullUp) {
            return Integer.valueOf(this.webViewCollapsedHeight);
        }
        return null;
    }

    public void show() {
        super.show();
    }

    protected void onStop() {
        super.onStop();
    }

    public void hide() {
        super.hide();
    }

    public void dismiss() {
        Animator animator = this.mExitAnimator;
        if (animator != null) {
            Intrinsics.checkNotNull(animator);
            if (animator.isRunning()) {
                return;
            }
            Animator animator2 = this.mExitAnimator;
            Intrinsics.checkNotNull(animator2);
            animator2.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.android.anniex.container.popup.SheetBaseDialog$dismiss$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    View view;
                    View view2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view = SheetBaseDialog.this.mTargetExitAnimationView;
                    if (view != null) {
                        view2 = SheetBaseDialog.this.mTargetExitAnimationView;
                        Intrinsics.checkNotNull(view2);
                        view2.setVisibility(8);
                    }
                    super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    View view;
                    View view2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view = SheetBaseDialog.this.mTargetExitAnimationView;
                    if (view != null) {
                        view2 = SheetBaseDialog.this.mTargetExitAnimationView;
                        Intrinsics.checkNotNull(view2);
                        view2.setVisibility(8);
                    }
                    super/*androidx.appcompat.app.AppCompatDialog*/.dismiss();
                }
            });
            Animator animator3 = this.mExitAnimator;
            Intrinsics.checkNotNull(animator3);
            animator3.start();
            return;
        }
        super.dismiss();
    }

    public final void injectExitAnimator(Animator animator, View targetView) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.mExitAnimator = animator;
        this.mTargetExitAnimationView = targetView;
    }

    public void cancel() {
        if (this.cancelable && isShowing() && shouldWindowCloseOnTouchOutside()) {
            super.cancel();
            return;
        }
        SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener != null) {
            Intrinsics.checkNotNull(sheetOutsideListener);
            sheetOutsideListener.onOutsideClick(false);
            SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
            Intrinsics.checkNotNull(sheetOutsideListener2);
            sheetOutsideListener2.onOutsideClickWithCloseType(false, PopupCloseType.UNKNOWN);
        }
    }

    public final void cancelWithCloseType(PopupCloseType popupCloseType) {
        if (this.cancelable && isShowing() && shouldWindowCloseOnTouchOutside()) {
            super.cancel();
            return;
        }
        SheetOutsideListener sheetOutsideListener = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener != null) {
            Intrinsics.checkNotNull(sheetOutsideListener);
            sheetOutsideListener.onOutsideClick(false);
        }
        SheetOutsideListener sheetOutsideListener2 = this.mLiveBottomSheetOutsideListener;
        if (sheetOutsideListener2 == null || popupCloseType == null) {
            return;
        }
        Intrinsics.checkNotNull(sheetOutsideListener2);
        sheetOutsideListener2.onOutsideClickWithCloseType(shouldWindowCloseOnTouchOutside(), popupCloseType);
    }

    public void onBackPressed() {
        cancelWithCloseType(PopupCloseType.SYSTEM_BACK);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.mExitAnimator;
        if (animator != null) {
            animator.removeAllListeners();
            animator.cancel();
        }
        this.mExitAnimator = null;
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Object obj;
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        try {
            Result.Companion companion = Result.Companion;
            if (IConditionCallKt.enableDialogRestoreInstanceState()) {
                savedInstanceState.remove("android:dialogShowing");
                savedInstanceState.remove("android:dialogHierarchy");
            }
            super.onRestoreInstanceState(savedInstanceState);
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.INSTANCE.e(TAG, "onRestoreInstanceState error====" + th2.getMessage(), (Map) null, (LoggerContext) null);
        }
    }
}
