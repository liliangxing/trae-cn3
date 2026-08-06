package com.lynx.tasm.event;

import android.view.MotionEvent;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTargetBase;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxEventDetail {
    private static String TAG = "LynxEventDetail";
    private LynxEvent mEvent;
    private EventTargetBase mEventTarget;
    private LynxView mLynxView;
    private MotionEvent mMotionEvent = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum EVENT_TYPE {
        TOUCH_EVENT,
        CUSTOM_EVENT
    }

    public LynxEventDetail(LynxEvent lynxEvent, EventTargetBase eventTargetBase, LynxView lynxView) {
        this.mEvent = lynxEvent;
        this.mEventTarget = eventTargetBase;
        this.mLynxView = lynxView;
    }

    public LynxView getLynxView() {
        return this.mLynxView;
    }

    public EventTargetBase getEventTarget() {
        return this.mEventTarget;
    }

    public String getEventName() {
        return this.mEvent.getName();
    }

    /* renamed from: com.lynx.tasm.event.LynxEventDetail$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C01751 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$tasm$event$LynxEvent$LynxEventType;

        static {
            int[] iArr = new int[LynxEvent.LynxEventType.values().length];
            $SwitchMap$com$lynx$tasm$event$LynxEvent$LynxEventType = iArr;
            try {
                iArr[LynxEvent.LynxEventType.kTouch.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public EVENT_TYPE getEventType() {
        if (C01751.$SwitchMap$com$lynx$tasm$event$LynxEvent$LynxEventType[this.mEvent.getType().ordinal()] == 1) {
            return EVENT_TYPE.TOUCH_EVENT;
        }
        return EVENT_TYPE.CUSTOM_EVENT;
    }

    public void setMotionEvent(MotionEvent motionEvent) {
        this.mMotionEvent = motionEvent;
    }

    public MotionEvent getMotionEvent() {
        if (this.mEvent.getType() != LynxEvent.LynxEventType.kTouch) {
            LLog.w(TAG, "getMotionEvent error, event type is not touch event. type is " + this.mEvent.getType());
        }
        return this.mMotionEvent;
    }

    public LynxTouchEvent.Point getTargetPoint() {
        if (this.mEvent.getType() != LynxEvent.LynxEventType.kTouch) {
            LLog.w(TAG, "getTargetPoint error, event type is not touch event. type is " + this.mEvent.getType());
            return new LynxTouchEvent.Point(0.0f, 0.0f);
        }
        LynxTouchEvent.Point viewPoint = ((LynxTouchEvent) this.mEvent).getViewPoint();
        return viewPoint == null ? new LynxTouchEvent.Point(0.0f, 0.0f) : viewPoint;
    }

    public boolean getIsMultiTouch() {
        if (this.mEvent.getType() != LynxEvent.LynxEventType.kTouch) {
            LLog.w(TAG, "getIsMultiTouch error, event type is not touch event. type is " + this.mEvent.getType());
            return false;
        }
        return ((LynxTouchEvent) this.mEvent).getIsMultiTouch();
    }

    public HashMap<Integer, LynxTouchEvent.Point> getTargetPointMap() {
        boolean isMultiTouch = ((LynxTouchEvent) this.mEvent).getIsMultiTouch();
        if (this.mEvent.getType() != LynxEvent.LynxEventType.kTouch || !isMultiTouch) {
            LLog.w(TAG, "getTargetPointMap error, event type is not touch event. type is " + this.mEvent.getType() + ", isMultiTouch:" + isMultiTouch);
            return new HashMap<>();
        }
        HashMap<Integer, LynxTouchEvent.Point> hashMap = (HashMap) ((LynxTouchEvent) this.mEvent).getTouchMap();
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public HashMap<String, Object> getEventParams() {
        if (this.mEvent.getType() != LynxEvent.LynxEventType.kCustom) {
            LLog.w(TAG, "getEventParams error, event type is not custom event. type is" + this.mEvent.getType());
            return new HashMap<>();
        }
        HashMap<String, Object> hashMap = (HashMap) ((LynxCustomEvent) this.mEvent).eventParams();
        return hashMap == null ? new HashMap<>() : hashMap;
    }
}
