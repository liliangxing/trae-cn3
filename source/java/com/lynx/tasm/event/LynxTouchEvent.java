package com.lynx.tasm.event;

import android.graphics.Rect;
import android.view.MotionEvent;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.event.EventTargetBase;
import com.lynx.tasm.event.LynxEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class LynxTouchEvent extends LynxEvent {
    public static final String EVENT_CLICK = "click";
    public static final String EVENT_LONG_PRESS = "longpress";
    public static final String EVENT_TAP = "tap";
    public static final String EVENT_TOUCH_CANCEL = "touchcancel";
    public static final String EVENT_TOUCH_END = "touchend";
    public static final String EVENT_TOUCH_MOVE = "touchmove";
    public static final String EVENT_TOUCH_START = "touchstart";
    public static final int kPseudoStateActive = 8;
    public static final int kPseudoStateActiveTransition = 16;
    public static final int kPseudoStateAll = -1;
    public static final int kPseudoStateFocus = 64;
    public static final int kPseudoStateFocusTransition = 128;
    public static final int kPseudoStateHover = 1;
    public static final int kPseudoStateHoverTransition = 2;
    public static final int kPseudoStateNone = 0;
    private HashMap<Integer, EventTargetBase> mActiveTargetMap;
    private Point mClientPoint;
    private boolean mIsMultiTouch;
    private MotionEvent mMotionEvent;
    private Point mPagePoint;
    private Map<Integer, Point> mTouchMap;
    private JavaOnlyMap mUITouchMap;
    private Point mViewPoint;

    /* loaded from: classes7.dex */
    public static class Point {
        float x;
        float y;

        public Point() {
            this.x = 0.0f;
            this.y = 0.0f;
        }

        public Point(float f, float f2) {
            this.x = f;
            this.y = f2;
        }

        public float getX() {
            return this.x;
        }

        public void setX(float f) {
            this.x = f;
        }

        public float getY() {
            return this.y;
        }

        public void setY(float f) {
            this.y = f;
        }

        public Point convert(Rect rect, Rect rect2) {
            return new Point((rect.left - rect2.left) + this.x, (rect.top - rect2.top) + this.y);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }
            Point point = (Point) obj;
            return Float.compare(point.x, this.x) == 0 && Float.compare(point.y, this.y) == 0;
        }

        public int hashCode() {
            return Arrays.hashCode(new float[]{this.x, this.y});
        }

        public String toString() {
            return "Point{x=" + this.x + ", y=" + this.y + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public LynxTouchEvent(int i, String str) {
        super(i, str, LynxEvent.LynxEventType.kTouch);
    }

    public LynxTouchEvent(int i, String str, float f, float f2) {
        super(i, str, LynxEvent.LynxEventType.kTouch);
        Point point = new Point(f, f2);
        this.mClientPoint = point;
        this.mPagePoint = point;
        this.mViewPoint = point;
    }

    public LynxTouchEvent(int i, String str, Point point, Point point2, Point point3) {
        super(i, str, LynxEvent.LynxEventType.kTouch);
        this.mClientPoint = point;
        this.mPagePoint = point2;
        this.mViewPoint = point3;
    }

    public LynxTouchEvent(int i, String str, Map<Integer, Point> map) {
        super(i, str, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mTouchMap = map;
    }

    public LynxTouchEvent(String str, JavaOnlyMap javaOnlyMap) {
        super(-1, str, LynxEvent.LynxEventType.kTouch);
        this.mIsMultiTouch = true;
        this.mUITouchMap = javaOnlyMap;
    }

    public Point getClientPoint() {
        return this.mClientPoint;
    }

    public Point getPagePoint() {
        return this.mPagePoint;
    }

    public Point getViewPoint() {
        return this.mViewPoint;
    }

    public boolean getIsMultiTouch() {
        return this.mIsMultiTouch;
    }

    public Map<Integer, Point> getTouchMap() {
        return this.mTouchMap;
    }

    public JavaOnlyMap getUITouchMap() {
        return this.mUITouchMap;
    }

    public void setMotionEvent(MotionEvent motionEvent) {
        this.mMotionEvent = motionEvent;
    }

    public MotionEvent getMotionEvent() {
        return this.mMotionEvent;
    }

    public void setActiveTargetMap(HashMap<Integer, EventTargetBase> hashMap) {
        this.mActiveTargetMap = hashMap;
    }

    public HashMap<Integer, EventTargetBase> getActiveTargetMap() {
        return this.mActiveTargetMap;
    }

    @Override // com.lynx.tasm.event.LynxEvent
    public ArrayList<Object> getEventParams() {
        ArrayList<Object> eventParams = super.getEventParams();
        ArrayList arrayList = new ArrayList();
        arrayList.add(Boolean.valueOf(this.mIsMultiTouch));
        if (this.mIsMultiTouch) {
            arrayList.add(this.mUITouchMap);
        } else {
            arrayList.add(Float.valueOf(this.mClientPoint.x));
            arrayList.add(Float.valueOf(this.mClientPoint.y));
            arrayList.add(Float.valueOf(this.mPagePoint.x));
            arrayList.add(Float.valueOf(this.mPagePoint.y));
            arrayList.add(Float.valueOf(this.mViewPoint.x));
            arrayList.add(Float.valueOf(this.mViewPoint.y));
        }
        eventParams.add(arrayList);
        return eventParams;
    }
}
