package com.lynx.tasm.animation.layout;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import com.lynx.tasm.event.LynxCustomEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LayoutAnimationManager {
    private int mBorderBottomWidth;
    private int mBorderLeftWidth;
    private int mBorderRightWidth;
    private int mBorderTopWidth;
    private Rect mBound;
    private int mHeight;
    private AbstractLayoutAnimation mLayoutCreateAnimation;
    private AbstractLayoutAnimation mLayoutDeleteAnimation;
    private AbstractLayoutAnimation mLayoutUpdateAnimation;
    private int mMarginBottom;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMarginTop;
    private LynxOnAttachStateChangeListener mOnAttachStateChangeListener;
    private int mPaddingBottom;
    private int mPaddingLeft;
    private int mPaddingRight;
    private int mPaddingTop;
    private WeakReference<LynxUI> mUI;
    private int mWidth;

    /* renamed from: mX */
    private int f2310mX;

    /* renamed from: mY */
    private int f2311mY;
    private final SparseArray<LayoutHandlingAnimation> mLayoutHandlers = new SparseArray<>(0);
    private float mOriginAlpha = -1.0f;
    private boolean mLayerTypeChanged = false;

    public void updateAlpha(float f) {
        this.mOriginAlpha = f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LynxUI getUI() {
        WeakReference<LynxUI> weakReference = this.mUI;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SparseArray<LayoutHandlingAnimation> getLayoutHandlers() {
        return this.mLayoutHandlers;
    }

    public void applyLayoutUpdate(LynxUI lynxUI, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        int i17;
        int i18;
        View view = lynxUI.getView();
        this.mUI = new WeakReference<>(lynxUI);
        updateLatestLayoutInfo(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
        if (this.mOriginAlpha == -1.0f && view != null) {
            this.mOriginAlpha = view.getAlpha();
        }
        int sign = lynxUI.getSign();
        LayoutHandlingAnimation layoutHandlingAnimation = this.mLayoutHandlers.get(sign);
        if (layoutHandlingAnimation == null) {
            i17 = i3;
            i18 = i4;
        } else if (view != null && view.getAnimation() != null) {
            layoutHandlingAnimation.onLayoutUpdate(i, i2, i3, i4);
            return;
        } else {
            i17 = i3;
            i18 = i4;
            this.mLayoutHandlers.remove(sign);
        }
        AbstractLayoutAnimation abstractLayoutAnimation = (lynxUI.getWidth() == 0 && lynxUI.getHeight() == 0) ? this.mLayoutCreateAnimation : this.mLayoutUpdateAnimation;
        AbstractLayoutAnimation abstractLayoutAnimation2 = this.mLayoutDeleteAnimation;
        if (abstractLayoutAnimation2 != null && abstractLayoutAnimation2.isValid() && i17 == 0 && i18 == 0) {
            deleteView(lynxUI);
            return;
        }
        AbstractLayoutAnimation abstractLayoutAnimation3 = this.mLayoutDeleteAnimation;
        if ((abstractLayoutAnimation3 == null || !abstractLayoutAnimation3.isValid()) && i17 == 0 && i18 == 0) {
            lynxUI.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
            return;
        }
        Animation createAnimation = abstractLayoutAnimation != null ? abstractLayoutAnimation.createAnimation(lynxUI, i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect, this.mOriginAlpha) : null;
        if ((createAnimation instanceof TranslateAnimation) && (lynxUI.getParent() instanceof UIShadowProxy)) {
            view = lynxUI.getParent().getView();
        }
        View view2 = view;
        if (createAnimation == null) {
            float f = this.mOriginAlpha;
            if (f != -1.0f) {
                view2.setAlpha(f);
            }
            WeakReference<LynxUI> weakReference = this.mUI;
            if (weakReference != null) {
                weakReference.clear();
            }
            lynxUI.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
            return;
        }
        if (lynxUI.getWidth() == 0 && lynxUI.getHeight() == 0) {
            createAnimation.setAnimationListener(new LayoutAnimationListener(this, "layout-animation-create"));
            addOnAttachStateChangeListenerToView(view2, "layout-animation-create");
        } else {
            createAnimation.setAnimationListener(new LayoutAnimationListener(this, "layout-animation-update"));
            addOnAttachStateChangeListenerToView(view2, "layout-animation-update");
        }
        if (createAnimation instanceof LayoutHandlingAnimation) {
            lynxUI.requestLayout();
        } else {
            lynxUI.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, rect);
        }
        lynxUI.onBeforeAnimation(i, i2, i3, i4, i5, i6, i7, i8);
        view2.startAnimation(createAnimation);
    }

    public void applyLatestLayoutInfoToUI() {
        WeakReference<LynxUI> weakReference = this.mUI;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.mUI.get().updateLayout(this.f2310mX, this.f2311mY, this.mWidth, this.mHeight, this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom, this.mMarginLeft, this.mMarginTop, this.mMarginRight, this.mMarginBottom, this.mBorderLeftWidth, this.mBorderTopWidth, this.mBorderRightWidth, this.mBorderBottomWidth, this.mBound);
    }

    public void deleteView(LynxUI lynxUI) {
        View view = lynxUI.getView();
        if (view == null) {
            return;
        }
        this.mUI = new WeakReference<>(lynxUI);
        Animation createAnimation = this.mLayoutDeleteAnimation.createAnimation(lynxUI, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect(), this.mOriginAlpha);
        if (createAnimation == null) {
            lynxUI.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
            return;
        }
        createAnimation.setAnimationListener(new LayoutAnimationListener(this, "layout-animation-delete"));
        addOnAttachStateChangeListenerToView(view, "layout-animation-delete");
        view.startAnimation(createAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LayoutAnimationListenerUtils {
        private static final String EVENT_END = "animationend";
        private static final String EVENT_START = "animationstart";
        private static final String LAYOUT_ANIMATION_CREATE = "layout-animation-create";
        private static final String LAYOUT_ANIMATION_DELETE = "layout-animation-delete";
        private static final String LAYOUT_ANIMATION_UPDATE = "layout-animation-update";
        private static Map<String, Object> sEventParams;

        private LayoutAnimationListenerUtils() {
        }

        static {
            HashMap hashMap = new HashMap();
            sEventParams = hashMap;
            hashMap.put("animation_type", "");
        }

        public static void sendAnimationEvent(LynxUI lynxUI, String str, String str2) {
            if (lynxUI == null || lynxUI.getEvents() == null || !lynxUI.getEvents().containsKey(str)) {
                return;
            }
            sEventParams.put("animation_type", str2);
            lynxUI.getLynxContext().getEventEmitter().sendCustomEvent(new LynxCustomEvent(lynxUI.getSign(), str, sEventParams));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LayoutAnimationListener implements Animation.AnimationListener {
        private String mLayoutAnimationType;
        private WeakReference<LayoutAnimationManager> mManagerRef;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        public LayoutAnimationListener(LayoutAnimationManager layoutAnimationManager, String str) {
            this.mManagerRef = new WeakReference<>(layoutAnimationManager);
            this.mLayoutAnimationType = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            LynxUI ui;
            LayoutAnimationManager layoutAnimationManager = this.mManagerRef.get();
            if (layoutAnimationManager == null || (ui = layoutAnimationManager.getUI()) == null) {
                return;
            }
            View view = ui.getView();
            LayoutAnimationListenerUtils.sendAnimationEvent(ui, "animationstart", this.mLayoutAnimationType);
            String str = this.mLayoutAnimationType;
            if (str == "layout-animation-create" || str == "layout-animation-update") {
                if (animation instanceof LayoutHandlingAnimation) {
                    layoutAnimationManager.getLayoutHandlers().put(ui.getSign(), (LayoutHandlingAnimation) animation);
                    return;
                } else {
                    if ((animation instanceof OpacityAnimation) && view.getLayerType() == 0) {
                        layoutAnimationManager.mLayerTypeChanged = true;
                        view.setLayerType(2, null);
                        return;
                    }
                    return;
                }
            }
            if (str == "layout-animation-delete" && (animation instanceof OpacityAnimation) && view.getLayerType() == 0) {
                layoutAnimationManager.mLayerTypeChanged = true;
                view.setLayerType(2, null);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LynxUI ui;
            LayoutAnimationManager layoutAnimationManager = this.mManagerRef.get();
            if (layoutAnimationManager == null || (ui = layoutAnimationManager.getUI()) == null) {
                return;
            }
            View view = ui.getView();
            layoutAnimationManager.onAnimationEnd(this.mLayoutAnimationType);
            String str = this.mLayoutAnimationType;
            if (str != "layout-animation-create" && str != "layout-animation-update") {
                if (str == "layout-animation-delete") {
                    if ((animation instanceof OpacityAnimation) && layoutAnimationManager.mLayerTypeChanged) {
                        view.setLayerType(0, null);
                        layoutAnimationManager.mLayerTypeChanged = false;
                    }
                    ui.updateLayout(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, new Rect());
                    return;
                }
                return;
            }
            if (animation instanceof LayoutHandlingAnimation) {
                layoutAnimationManager.getLayoutHandlers().remove(ui.getSign());
            } else if ((animation instanceof OpacityAnimation) && layoutAnimationManager.mLayerTypeChanged) {
                if (view != null) {
                    view.setLayerType(0, null);
                }
                layoutAnimationManager.mLayerTypeChanged = false;
            }
        }
    }

    public AbstractLayoutAnimation getLayoutCreateAnimation() {
        if (this.mLayoutCreateAnimation == null) {
            this.mLayoutCreateAnimation = new LayoutCreateAnimation();
        }
        return this.mLayoutCreateAnimation;
    }

    public AbstractLayoutAnimation getLayoutUpdateAnimation() {
        if (this.mLayoutUpdateAnimation == null) {
            this.mLayoutUpdateAnimation = new LayoutUpdateAnimation();
        }
        return this.mLayoutUpdateAnimation;
    }

    public AbstractLayoutAnimation getLayoutDeleteAnimation() {
        if (this.mLayoutDeleteAnimation == null) {
            this.mLayoutDeleteAnimation = new LayoutDeleteAnimation();
        }
        return this.mLayoutDeleteAnimation;
    }

    public boolean isValid() {
        AbstractLayoutAnimation abstractLayoutAnimation;
        AbstractLayoutAnimation abstractLayoutAnimation2;
        AbstractLayoutAnimation abstractLayoutAnimation3 = this.mLayoutCreateAnimation;
        return (abstractLayoutAnimation3 != null && abstractLayoutAnimation3.isValid()) || ((abstractLayoutAnimation = this.mLayoutDeleteAnimation) != null && abstractLayoutAnimation.isValid()) || ((abstractLayoutAnimation2 = this.mLayoutUpdateAnimation) != null && abstractLayoutAnimation2.isValid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LynxOnAttachStateChangeListener implements View.OnAttachStateChangeListener {
        public String mLayoutAnimationType;
        private WeakReference<LayoutAnimationManager> mManagerRef;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        public LynxOnAttachStateChangeListener(LayoutAnimationManager layoutAnimationManager, String str) {
            this.mManagerRef = new WeakReference<>(layoutAnimationManager);
            this.mLayoutAnimationType = str;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            LayoutAnimationManager layoutAnimationManager = this.mManagerRef.get();
            if (layoutAnimationManager != null) {
                layoutAnimationManager.onAnimationEnd(this.mLayoutAnimationType);
            }
        }
    }

    private void addOnAttachStateChangeListenerToView(View view, String str) {
        if (getUI() == null) {
            return;
        }
        LynxOnAttachStateChangeListener lynxOnAttachStateChangeListener = this.mOnAttachStateChangeListener;
        if (lynxOnAttachStateChangeListener == null || !lynxOnAttachStateChangeListener.mLayoutAnimationType.equals(str)) {
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.mOnAttachStateChangeListener;
            if (onAttachStateChangeListener != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            LynxOnAttachStateChangeListener lynxOnAttachStateChangeListener2 = new LynxOnAttachStateChangeListener(this, str);
            this.mOnAttachStateChangeListener = lynxOnAttachStateChangeListener2;
            view.addOnAttachStateChangeListener(lynxOnAttachStateChangeListener2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAnimationEnd(String str) {
        LynxUI ui = getUI();
        if (ui == null) {
            return;
        }
        View view = ui.getView();
        LynxOnAttachStateChangeListener lynxOnAttachStateChangeListener = this.mOnAttachStateChangeListener;
        if (lynxOnAttachStateChangeListener != null) {
            if (view != null) {
                view.removeOnAttachStateChangeListener(lynxOnAttachStateChangeListener);
            }
            this.mOnAttachStateChangeListener = null;
        }
        applyLatestLayoutInfoToUI();
        LayoutAnimationListenerUtils.sendAnimationEvent(ui, "animationend", str);
    }

    public void updateLatestLayoutInfo(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, Rect rect) {
        this.f2310mX = i;
        this.f2311mY = i2;
        this.mWidth = i3;
        this.mHeight = i4;
        this.mPaddingLeft = i5;
        this.mPaddingTop = i6;
        this.mPaddingRight = i7;
        this.mPaddingBottom = i8;
        this.mMarginLeft = i9;
        this.mMarginTop = i10;
        this.mMarginRight = i11;
        this.mMarginBottom = i12;
        this.mBorderLeftWidth = i13;
        this.mBorderTopWidth = i14;
        this.mBorderRightWidth = i15;
        this.mBorderBottomWidth = i16;
        this.mBound = rect;
    }

    private void endAnimation(String str) {
        WeakReference<LynxUI> weakReference;
        View view;
        LynxOnAttachStateChangeListener lynxOnAttachStateChangeListener = this.mOnAttachStateChangeListener;
        if (lynxOnAttachStateChangeListener == null || !lynxOnAttachStateChangeListener.mLayoutAnimationType.equals(str) || (weakReference = this.mUI) == null || weakReference.get() == null || (view = this.mUI.get().getView()) == null || view.getAnimation() == null) {
            return;
        }
        view.clearAnimation();
        applyLatestLayoutInfoToUI();
    }

    public void setLayoutAnimationCreateDuration(double d) {
        getLayoutCreateAnimation().setDuration((long) d);
        if (getLayoutCreateAnimation().isValid()) {
            return;
        }
        endAnimation("layout-animation-create");
    }

    public void setLayoutAnimationUpdateDuration(double d) {
        getLayoutUpdateAnimation().setDuration((long) d);
        if (getLayoutUpdateAnimation().isValid()) {
            return;
        }
        endAnimation("layout-animation-update");
    }

    public void setLayoutAnimationDeleteDuration(double d) {
        getLayoutDeleteAnimation().setDuration((long) d);
        if (getLayoutDeleteAnimation().isValid()) {
            return;
        }
        endAnimation("layout-animation-delete");
    }
}
