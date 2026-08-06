package com.bytedance.ies.bullet.container.popup.p001ui.draggable;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bytedance.android.anniex.R;
import com.bytedance.android.anniex.container.view.RadiusFrameLayout;
import com.bytedance.ies.bullet.container.popup.p001ui.draggable.BottomSheetBehavior;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupFragment;
import com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: DraggablePopupMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006JK\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2+\b\u0002\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0019j\u0004\u0018\u0001`\u001dJ\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u000f\u0010$\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020-H\u0016J'\u0010.\u001a\u00020\u00132\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\r2\b\u00101\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u00102J\b\u00103\u001a\u00020\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ies/bullet/container/popup/ui/draggable/DraggablePopupMode;", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupMode;", "fragment", "Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;", "(Lcom/bytedance/ies/bullet/service/popup/ui/AbsPopupFragment;)V", "bottomSheetCallback", "Lcom/bytedance/ies/bullet/container/popup/ui/draggable/BottomSheetBehavior$BottomSheetCallback;", "callbacks", "", "enablePopupSizeChangeEvent", "", "Ljava/lang/Boolean;", "initGravity", "", "Ljava/lang/Integer;", "mBehavior", "Lcom/bytedance/ies/bullet/container/popup/ui/draggable/BottomSheetBehavior;", "Landroid/view/View;", "addCallback", "", "callback", "adjustHeight", "heightPercent", "animated", "draggable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Lcom/bytedance/ies/bullet/service/base/DragPopupCallback;", "constructUIBody", "dismissForever", "getCallbacks", "getEnterAnim", "Landroid/animation/ObjectAnimator;", "getExitAnim", "getGravity", "()Ljava/lang/Integer;", "getRadii", "", "getTitleBarBackImageRes", "getVisibleOffset", "", "hideAndWaitResume", "onCreateDialog", "Lcom/bytedance/ies/bullet/container/popup/ui/draggable/DraggableDialog;", "onKeyBoardChange", "keyboardVisible", "keyboardHeight", "windowVisibleHeight", "(ZILjava/lang/Integer;)V", "resumeWhenBack", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DraggablePopupMode extends AbsPopupMode {
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private List<BottomSheetBehavior.BottomSheetCallback> callbacks;
    private final Boolean enablePopupSizeChangeEvent;
    private Integer initGravity;
    private BottomSheetBehavior<View> mBehavior;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DraggablePopupMode(AbsPopupFragment absPopupFragment) {
        super(absPopupFragment);
        CommonConfig commonConfig;
        Intrinsics.checkNotNullParameter(absPopupFragment, "fragment");
        this.callbacks = new ArrayList();
        IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
        this.enablePopupSizeChangeEvent = (iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? null : commonConfig.getEnablePopupSizeChange();
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public DraggableDialog onCreateDialog() {
        return new DraggableDialog(getFragment().requireContext());
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void constructUIBody() {
        int intValue;
        if (getFragment().isContainerViewInitialized()) {
            RadiusFrameLayout findViewById = getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_round);
            if (findViewById != null) {
                findViewById.setRadius(getRadii());
            }
            Object dialog = getFragment().getDialog();
            DraggableDialog draggableDialog = dialog instanceof DraggableDialog ? (DraggableDialog) dialog : null;
            if (draggableDialog != null) {
                draggableDialog.setCanceledOnTouchOutside(getFragment().getConfig().getCloseByMask());
                Function0<Boolean> callbackIfMaskCancel = draggableDialog.getCallbackIfMaskCancel();
                if (callbackIfMaskCancel != null) {
                    draggableDialog.setCanceledOnTouchOutside(((Boolean) callbackIfMaskCancel.invoke()).booleanValue());
                }
                View findViewById2 = draggableDialog.findViewById(R.id.bullet_popup_bottom_sheet);
                Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.FrameLayout");
                FrameLayout frameLayout = (FrameLayout) findViewById2;
                CoordinatorLayout.LayoutParams layoutParams = frameLayout.getLayoutParams();
                if (getFragment().getConfig().getHeight() > 0 || getFragment().getConfig().getUniformStyleAdapter()) {
                    ((ViewGroup.LayoutParams) layoutParams).height = getFragment().getConfig().getHeight();
                }
                if (getFragment().getConfig().getWidth() > 0 || getFragment().getConfig().getUniformStyleAdapter()) {
                    ((ViewGroup.LayoutParams) layoutParams).width = getFragment().getConfig().getWidth();
                }
                if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                    if (this.initGravity == null) {
                        this.initGravity = Integer.valueOf(layoutParams.gravity);
                    }
                    Integer gravity = getGravity();
                    if (gravity != null) {
                        layoutParams.gravity = gravity.intValue();
                    }
                }
                Integer dragUppingThreshold = getFragment().getConfig().getDragUppingThreshold();
                if (dragUppingThreshold != null && (intValue = dragUppingThreshold.intValue()) > 0) {
                    ViewGroup.LayoutParams layoutParams2 = ((LinearLayout) getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                    marginLayoutParams.topMargin = intValue * (-1);
                    ((LinearLayout) getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).setLayoutParams(marginLayoutParams);
                }
                this.mBehavior = BottomSheetBehavior.from(frameLayout);
            }
            final BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
            if (bottomSheetBehavior != null) {
                Iterator<T> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    bottomSheetBehavior.addBottomSheetCallback((BottomSheetBehavior.BottomSheetCallback) it.next());
                }
                this.callbacks.clear();
                bottomSheetBehavior.setFitToContents(false);
                bottomSheetBehavior.setDraggable(getFragment().getConfig().getDragByGesture());
                bottomSheetBehavior.setHideable(getFragment().getConfig().getCloseByGesture());
                bottomSheetBehavior.mAnimController = getFragment().getAnimController();
                Boolean bool = this.enablePopupSizeChangeEvent;
                bottomSheetBehavior.enablePopupSizeChange = bool != null ? bool.booleanValue() : false;
                bottomSheetBehavior.compatCoordinateLayoutScollView = getFragment().getConfig().getCompatCoordinateLayoutScollView();
                if (getFragment().getConfig().getHeight() < 0) {
                    bottomSheetBehavior.dragHeight = getFragment().getConfig().getScreenHeight();
                    bottomSheetBehavior.setPeekHeight(getFragment().getConfig().getScreenHeight() - 1);
                    bottomSheetBehavior.setSkipCollapsed(true);
                    bottomSheetBehavior.state = 3;
                    return;
                }
                if (getFragment().getConfig().getDragHeight() > 0 && getFragment().getConfig().getHeight() >= getFragment().getConfig().getDragHeight()) {
                    bottomSheetBehavior.dragHeight = getFragment().getConfig().getHeight();
                    bottomSheetBehavior.setPeekHeight(getFragment().getConfig().getHeight() - 1);
                    bottomSheetBehavior.setSkipCollapsed(true);
                    bottomSheetBehavior.state = 3;
                    return;
                }
                bottomSheetBehavior.setPeekHeight(getFragment().getConfig().getHeight());
                if (getFragment().getConfig().getDragHeight() > 0) {
                    bottomSheetBehavior.dragHeight = getFragment().getConfig().getDragHeight();
                }
                bottomSheetBehavior.setSkipCollapsed(!getFragment().getConfig().getDragBack());
                bottomSheetBehavior.dragUpThreshold = getFragment().getConfig().getDragUpThreshold();
                bottomSheetBehavior.dragDownThreshold = getFragment().getConfig().getDragDownThreshold();
                bottomSheetBehavior.peekDownCloseThreshold = getFragment().getConfig().getPeekDownCloseThreshold();
                bottomSheetBehavior.dragDownCloseThreshold = getFragment().getConfig().getDragDownCloseThreshold();
                Integer dragUppingThreshold2 = getFragment().getConfig().getDragUppingThreshold();
                if (dragUppingThreshold2 != null) {
                    bottomSheetBehavior.dragUppingThreshold = dragUppingThreshold2.intValue();
                }
                bottomSheetBehavior.state = 4;
                if (this.bottomSheetCallback == null) {
                    BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggablePopupMode$constructUIBody$2$callback$1
                        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                        public void onBottomSheetSizeChanged(View bottomSheet) {
                            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        }

                        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                        public void onSlide(View bottomSheet, float slideOffset) {
                            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                        }

                        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                        public void onStateChanged(View bottomSheet, int newState) {
                            BottomSheetBehavior bottomSheetBehavior2;
                            String str;
                            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                            if (newState != 1) {
                                str = newState != 3 ? newState != 4 ? null : "enterHalfScreen" : "enterFullScreen";
                            } else {
                                bottomSheetBehavior2 = DraggablePopupMode.this.mBehavior;
                                str = bottomSheetBehavior2 != null && bottomSheetBehavior2.getPredState() == 3 ? "leaveFullScreen" : "leaveHalfScreen";
                            }
                            if (str != null) {
                                AbsPopupFragment fragment$anniex_release = DraggablePopupMode.this.getFragment();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("status", str);
                                Unit unit = Unit.INSTANCE;
                                fragment$anniex_release.sendEventToFE("popupStatusChange", jSONObject);
                            }
                        }

                        @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                        public void onBottomSheetChangeMarginTop(View bottomSheet, int dy) {
                            Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                            int i = bottomSheetBehavior.dragHeight - bottomSheetBehavior.dragUppingThreshold;
                            ViewGroup.LayoutParams layoutParams3 = ((LinearLayout) DraggablePopupMode.this.getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams3;
                            if (dy > 0) {
                                if (marginLayoutParams2.topMargin != bottomSheetBehavior.dragUppingThreshold * (-1)) {
                                    marginLayoutParams2.topMargin = bottomSheetBehavior.dragUppingThreshold * (-1);
                                    ((LinearLayout) DraggablePopupMode.this.getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).setLayoutParams(marginLayoutParams2);
                                    return;
                                }
                                return;
                            }
                            if (bottomSheet.getHeight() - dy == bottomSheetBehavior.dragHeight) {
                                marginLayoutParams2.topMargin = 0;
                                ((LinearLayout) DraggablePopupMode.this.getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).setLayoutParams(marginLayoutParams2);
                            } else if (bottomSheet.getHeight() - dy >= i) {
                                marginLayoutParams2.topMargin = (bottomSheetBehavior.dragHeight - (bottomSheet.getHeight() - dy)) * (-1);
                                ((LinearLayout) DraggablePopupMode.this.getFragment().getPopupContainerView().findViewById(R.id.bullet_popup_linear)).setLayoutParams(marginLayoutParams2);
                            }
                        }
                    };
                    this.bottomSheetCallback = bottomSheetCallback;
                    bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback);
                }
            }
        }
    }

    private final Integer getGravity() {
        if (isMeetUniformStyleAdapterCondition()) {
            return 8388613;
        }
        return this.initGravity;
    }

    public final void addCallback(BottomSheetBehavior.BottomSheetCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback(callback);
        } else {
            this.callbacks.add(callback);
        }
    }

    public final List<BottomSheetBehavior.BottomSheetCallback> getCallbacks() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        ArrayList<BottomSheetBehavior.BottomSheetCallback> bottomSheetCallbacks = bottomSheetBehavior != null ? bottomSheetBehavior.getBottomSheetCallbacks() : null;
        if (bottomSheetCallbacks == null) {
            bottomSheetCallbacks = new ArrayList<>();
        }
        return bottomSheetCallbacks;
    }

    private final float getVisibleOffset() {
        int dpToPx$anniex_release;
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior != null) {
            if (bottomSheetBehavior.state == 3) {
                dpToPx$anniex_release = bottomSheetBehavior.dragHeight;
            } else if (bottomSheetBehavior.state == 4) {
                dpToPx$anniex_release = bottomSheetBehavior.getPeekHeight();
            }
            return dpToPx$anniex_release;
        }
        dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(UIUtils.getDisplayMetrics$anniex_release(getFragment().getAct()).getHeight(), getFragment().getAct());
        return dpToPx$anniex_release;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getEnterAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "translationY", getVisibleOffset(), 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo…  getVisibleOffset(), 0f)");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public ObjectAnimator getExitAnim() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getFragment().getPopupContainerView(), "translationY", 0.0f, getVisibleOffset());
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(fragment.popupCo…  0f, getVisibleOffset())");
        return ofFloat;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public float[] getRadii() {
        return new float[]{getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), getFragment().getConfig().getRadius(), 0.0f, 0.0f, 0.0f, 0.0f};
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public int getTitleBarBackImageRes() {
        return R.drawable.ic_title_bar_close_normal;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void onKeyBoardChange(boolean keyboardVisible, int keyboardHeight, Integer windowVisibleHeight) {
        Dialog dialog = getFragment().getDialog();
        FrameLayout frameLayout = dialog != null ? (FrameLayout) dialog.findViewById(android.R.id.content) : null;
        FrameLayout frameLayout2 = frameLayout instanceof FrameLayout ? frameLayout : null;
        if (frameLayout2 != null) {
            frameLayout2.setPadding(0, 0, 0, keyboardHeight);
            frameLayout2.requestLayout();
        }
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void hideAndWaitResume() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.state = 5;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void dismissForever() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        boolean z = false;
        if (bottomSheetBehavior != null && bottomSheetBehavior.state == 5) {
            z = true;
        }
        if (z) {
            getFragment().dismiss();
            return;
        }
        BottomSheetBehavior<View> bottomSheetBehavior2 = this.mBehavior;
        if (bottomSheetBehavior2 == null) {
            return;
        }
        bottomSheetBehavior2.state = 5;
    }

    @Override // com.bytedance.ies.bullet.service.popup.p002ui.AbsPopupMode
    public void resumeWhenBack() {
        BottomSheetBehavior<View> bottomSheetBehavior = this.mBehavior;
        if (bottomSheetBehavior == null) {
            return;
        }
        bottomSheetBehavior.state = 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean adjustHeight$default(DraggablePopupMode draggablePopupMode, int i, boolean z, boolean z2, Function1 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function1 = null;
        }
        return draggablePopupMode.adjustHeight(i, z, z2, function1);
    }

    public final boolean adjustHeight(int heightPercent, boolean animated, final boolean draggable, final Function1<? super Boolean, Unit> callback) {
        final BottomSheetBehavior<View> bottomSheetBehavior;
        if (!(getFragment().getDialog() instanceof DraggableDialog) || (bottomSheetBehavior = this.mBehavior) == null) {
            if (callback != null) {
                callback.invoke(false);
            }
            return false;
        }
        if (bottomSheetBehavior != null) {
            final int i = bottomSheetBehavior.state;
            int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release((UIUtils.getDisplayMetrics$anniex_release(getFragment().getAct()).getHeight() * heightPercent) / 100, getFragment().getAct());
            bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.bytedance.ies.bullet.container.popup.ui.draggable.DraggablePopupMode$adjustHeight$1$1
                @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                public void onSlide(View bottomSheet, float slideOffset) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                public void onStateChanged(View bottomSheet, int newState) {
                    Intrinsics.checkNotNullParameter(bottomSheet, "bottomSheet");
                }

                @Override // com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior.BottomSheetCallback
                public void onStateUpdate(View bottomSheet, int newState) {
                    int i2;
                    if (newState == i) {
                        bottomSheetBehavior.removeBottomSheetCallback(this);
                        if (bottomSheet != null) {
                            int i3 = i;
                            BottomSheetBehavior<View> bottomSheetBehavior2 = bottomSheetBehavior;
                            if (i3 == 3) {
                                i2 = bottomSheetBehavior2.parentHeight - bottomSheetBehavior2.dragHeight;
                            } else if (i3 == 4) {
                                i2 = bottomSheetBehavior2.collapsedOffset;
                            } else {
                                i2 = bottomSheetBehavior2.getExpandedOffset();
                            }
                            bottomSheet.getLayoutParams().height = bottomSheetBehavior2.parentHeight - i2;
                            bottomSheet.requestLayout();
                        }
                        bottomSheetBehavior.setDraggable(draggable);
                        Function1<Boolean, Unit> function1 = callback;
                        if (function1 != null) {
                            function1.invoke(true);
                        }
                    }
                }
            });
            bottomSheetBehavior.setDraggable(true);
            if (i == 3) {
                bottomSheetBehavior.dragHeight = dpToPx$anniex_release;
            } else if (i == 4) {
                bottomSheetBehavior.setPeekHeight(dpToPx$anniex_release);
            }
            bottomSheetBehavior.settleToStatePendingLayout(i);
        }
        return true;
    }
}
