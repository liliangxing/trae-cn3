package com.lynx.tasm.behavior.p000ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.p000ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.p000ui.utils.MaskDrawable;
import com.lynx.tasm.event.LynxImpressionEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.LynxNewGestureDelegate;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.gesture.handler.BaseGestureHandler;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIView extends UISimpleView<AndroidView> implements GestureArenaMember, LynxNewGestureDelegate {
    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean canConsumeGesture(float f, float f2) {
        return true;
    }

    @LynxProp(name = "copyable")
    public void copyable(boolean z) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getMemberScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public boolean isAtBorder(boolean z) {
        return false;
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onGestureScrollBy(float f, float f2) {
    }

    @Deprecated
    public UIView(Context context) {
        super((LynxContext) context);
    }

    public UIView(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public UIView(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
        if (lynxContext.getDefaultOverflowVisible()) {
            this.mOverflow = 3;
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public int getInitialOverflowType() {
        return !this.mContext.getDefaultOverflowVisible() ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public AndroidView createView(Context context) {
        AndroidView onCreateView = onCreateView(context);
        onCreateView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.lynx.tasm.behavior.ui.view.UIView.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (view == UIView.this.getView() && UIView.this.mEvents != null && UIView.this.mEvents.containsKey(LynxImpressionEvent.EVENT_ATTACH)) {
                    LynxImpressionEvent createAttachEvent = LynxImpressionEvent.createAttachEvent(UIView.this.getSign());
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("impression_id", ((AndroidView) UIView.this.getView()).getImpressionId());
                    createAttachEvent.setParmas("params", hashMap);
                    if (UIView.this.getLynxContext().getEventEmitter() != null) {
                        UIView.this.getLynxContext().getEventEmitter().sendCustomEvent(createAttachEvent);
                    }
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (view == UIView.this.getView() && UIView.this.mEvents != null && UIView.this.mEvents.containsKey(LynxImpressionEvent.EVENT_DETACH)) {
                    LynxImpressionEvent createDetachEvent = LynxImpressionEvent.createDetachEvent(UIView.this.getSign());
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("impression_id", ((AndroidView) UIView.this.getView()).getImpressionId());
                    createDetachEvent.setParmas("params", hashMap);
                    if (UIView.this.getLynxContext().getEventEmitter() != null) {
                        UIView.this.getLynxContext().getEventEmitter().sendCustomEvent(createDetachEvent);
                    }
                }
            }
        });
        return onCreateView;
    }

    @LynxProp(name = "impression_id")
    public void setImpressionId(String str) {
        ((AndroidView) this.mView).setImpressionId(str);
    }

    protected AndroidView onCreateView(Context context) {
        return new AndroidView(context);
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onPropsUpdated() {
        if (this.mView != 0) {
            ((AndroidView) this.mView).setNativeInteractionEnabled(this.nativeInteractionEnabled);
            ((AndroidView) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
        }
        super.onPropsUpdated();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        if (this.mView != 0) {
            ViewCompat.setAccessibilityDelegate(this.mView, new CustomAccessibilityDelegateCompat(this));
        }
    }

    @LynxProp(defaultInt = 0, name = "blur-sampling")
    public void setBlurSampling(int i) {
        ((AndroidView) this.mView).setBlurSampling(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void interceptGesture(boolean z) {
        super.interceptGesture(z);
        ((AndroidView) this.mView).interceptGesture(z);
    }

    @Override // com.lynx.tasm.gesture.GestureArenaMember
    public void onInvalidate() {
        if (isEnableNewGesture()) {
            ViewCompat.postInvalidateOnAnimation(this.mView);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, GestureDetector> map) {
        super.setGestureDetectors(map);
        if (map == null || map.isEmpty()) {
            return;
        }
        ((AndroidView) this.mView).setGestureManager(getGestureArenaManager());
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.gesture.GestureArenaMember
    public Map<Integer, BaseGestureHandler> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void destroy() {
        super.destroy();
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.IDrawChildHook
    public void afterDraw(Canvas canvas) {
        super.afterDraw(canvas);
        if (getMaskDrawable() != null) {
            getMaskDrawable().setBounds(0, 0, getWidth(), getHeight());
            getMaskDrawable().draw(canvas);
        }
    }

    private MaskDrawable getMaskDrawable() {
        if (this.mLynxMask == null || this.mLynxMask.getDrawable() == null) {
            return null;
        }
        return this.mLynxMask.getDrawable();
    }
}
