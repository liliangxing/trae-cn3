package com.lynx.tasm.behavior.shadow.text;

import android.graphics.Matrix;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.event.EventTargetBase;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.detector.GestureDetector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EventTargetSpan extends ClickableSpan implements EventTarget {
    private ReadableMap mDataset;
    private boolean mEnableTouchPseudoPropagation;
    private EventTarget.EnableStatus mEventThrough;
    private Map<String, EventsListener> mEvents;
    private EventTarget.EnableStatus mIgnoreFocus;
    private EventTarget.PointerEventsValue mPointerEvents;
    private int mPseudoStatus;
    private int mSign;
    private Matrix mTransformMatrix = new Matrix();
    private WeakReference<EventTarget> mParent = null;

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean blockNativeEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean consumeSlideEvent(float f) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float f, float f2, boolean z) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchEvent(LynxEventDetail lynxEventDetail) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean dispatchTouch(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getGestureArenaMemberId() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<Integer, GestureDetector> getGestureDetectorMap() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getRootLynxPageUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean hasConsumeSlideEventAngles() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2, boolean z) {
        return this;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isFocusable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isOnResponseChain() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void offResponseChain() {
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventBubble(boolean z, long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventCapture(boolean z, long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventFire(boolean z, long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean z, boolean z2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onResponseChain() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> hashMap) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setEventID(long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget eventTarget) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventBubble(long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventCapture(long j) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventFire(boolean z, long j) {
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }

    public EventTargetSpan(int i, Map<String, EventsListener> map, EventTarget.EnableStatus enableStatus, boolean z, EventTarget.EnableStatus enableStatus2, EventTarget.PointerEventsValue pointerEventsValue, ReadableMap readableMap) {
        this.mDataset = new JavaOnlyMap();
        this.mSign = i;
        this.mIgnoreFocus = enableStatus;
        this.mEventThrough = enableStatus2;
        this.mPointerEvents = pointerEventsValue;
        this.mDataset = readableMap;
        this.mEnableTouchPseudoPropagation = z;
        if (map != null) {
            HashMap hashMap = new HashMap();
            this.mEvents = hashMap;
            hashMap.putAll(map);
            return;
        }
        this.mEvents = null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getSign() {
        return this.mSign;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getPseudoStatus() {
        return this.mPseudoStatus;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float f, float f2) {
        return hitTest(f, f2, false);
    }

    public void setParent(EventTarget eventTarget) {
        this.mParent = new WeakReference<>(eventTarget);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget parent() {
        return this.mParent.get();
    }

    @Override // com.lynx.tasm.behavior.event.EventTargetBase
    public EventTargetBase parentResponder() {
        WeakReference<EventTarget> weakReference = this.mParent;
        if (weakReference instanceof EventTargetBase) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTargetBase
    public ReadableMap getDataset() {
        return this.mDataset;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<String, EventsListener> getEvents() {
        return this.mEvents;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        this.mTransformMatrix.reset();
        return this.mTransformMatrix;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean ignoreFocus() {
        if (this.mIgnoreFocus == EventTarget.EnableStatus.Enable) {
            return true;
        }
        if (this.mIgnoreFocus == EventTarget.EnableStatus.Disable || parent() == null) {
            return false;
        }
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isClickable() {
        Map<String, EventsListener> map = this.mEvents;
        return map != null && map.containsKey(LynxTouchEvent.EVENT_TAP);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isLongClickable() {
        Map<String, EventsListener> map = this.mEvents;
        return map != null && map.containsKey(LynxTouchEvent.EVENT_LONG_PRESS);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean enableTouchPseudoPropagation() {
        return this.mEnableTouchPseudoPropagation;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onPseudoStatusChanged(int i, int i2) {
        this.mPseudoStatus = i2;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float f, float f2) {
        EventTarget parent;
        if (this.mEventThrough == EventTarget.EnableStatus.Enable) {
            return true;
        }
        if (this.mEventThrough == EventTarget.EnableStatus.Disable || (parent = parent()) == null) {
            return false;
        }
        return parent.eventThrough(f, f2);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PointerEventsValue pointerEvents() {
        if (this.mPointerEvents != EventTarget.PointerEventsValue.Unset) {
            return this.mPointerEvents;
        }
        if (parent() != null) {
            return parent().pointerEvents();
        }
        return EventTarget.PointerEventsValue.Auto;
    }
}
