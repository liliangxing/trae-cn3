package com.lynx.tasm.behavior.event;

import android.graphics.Matrix;
import android.view.MotionEvent;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.gesture.detector.GestureDetector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface EventTarget extends EventTargetBase {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum EnableStatus {
        Enable,
        Disable,
        Undefined
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum PointerEventsValue {
        Auto,
        None,
        Unset
    }

    boolean blockNativeEvent(MotionEvent motionEvent);

    boolean consumeSlideEvent(float f);

    boolean containsPoint(float f, float f2);

    boolean containsPoint(float f, float f2, boolean z);

    boolean dispatchEvent(LynxEventDetail lynxEventDetail);

    boolean dispatchTouch(MotionEvent motionEvent);

    boolean enableTouchPseudoPropagation();

    boolean eventThrough(float f, float f2);

    HashMap<String, EventTarget> getChildrenLynxPageUI();

    Map<String, EventsListener> getEvents();

    int getGestureArenaMemberId();

    Map<Integer, GestureDetector> getGestureDetectorMap();

    EventTarget getParentLynxPageUI();

    int getPseudoStatus();

    EventTarget getRootLynxPageUI();

    int getSign();

    Matrix getTransformMatrix();

    boolean hasConsumeSlideEventAngles();

    EventTarget hitTest(float f, float f2);

    EventTarget hitTest(float f, float f2, boolean z);

    boolean ignoreFocus();

    boolean isClickable();

    boolean isFocusable();

    boolean isLongClickable();

    boolean isOnResponseChain();

    boolean isScrollable();

    boolean isUserInteractionEnabled();

    void offResponseChain();

    void onEventBubble(boolean z, long j);

    void onEventCapture(boolean z, long j);

    void onEventFire(boolean z, long j);

    void onFocusChanged(boolean z, boolean z2);

    void onPseudoStatusChanged(int i, int i2);

    void onResponseChain();

    EventTarget parent();

    PointerEventsValue pointerEvents();

    void setChildrenLynxPageUI(HashMap<String, EventTarget> hashMap);

    void setEventID(long j);

    void setParentLynxPageUI(EventTarget eventTarget);

    void startEventBubble(long j);

    void startEventCapture(long j);

    void startEventFire(boolean z, long j);
}
