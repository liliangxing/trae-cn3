package com.lynx.tasm.gesture.handler;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.common.GestureExtraBundle;
import com.lynx.tasm.gesture.detector.GestureDetector;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultGestureHandler extends BaseGestureHandler {
    private final HashMap<String, Object> mEventParams;
    private boolean mIsInvokedBegin;
    private boolean mIsInvokedEnd;
    private boolean mIsInvokedStart;
    private LynxTouchEvent mLastTouchEvent;
    private float mLastX;
    private float mLastY;
    private int mTapSlop;

    public DefaultGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        super(i, lynxContext, gestureDetector, gestureArenaMember);
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mIsInvokedBegin = false;
        this.mIsInvokedStart = false;
        this.mIsInvokedEnd = false;
        this.mTapSlop = 3;
        handleConfigMap(gestureDetector.getConfigMap());
        this.mEventParams = new HashMap<>();
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void handleConfigMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        this.mTapSlop = readableMap.getInt(GestureConstants.TAP_SLOP, 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009c  */
    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        this.mLastTouchEvent = lynxTouchEvent;
        if (z && gestureExtraBundle != null) {
            if (!gestureExtraBundle.isNeedConsumedSimultaneousGesture() || this.mGestureArenaMember == null) {
                return;
            }
            this.mGestureArenaMember.onGestureScrollBy(gestureExtraBundle.getSimultaneousDeltaX(), gestureExtraBundle.getSimultaneousDeltaY());
            this.mGestureArenaMember.onInvalidate();
            return;
        }
        if (this.mStatus >= 3) {
            onEnd(this.mLastX, this.mLastY, this.mLastTouchEvent);
            return;
        }
        float f3 = 0.0f;
        if (motionEvent != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                this.mIsInvokedEnd = false;
                begin();
                onBegin(this.mLastX, this.mLastY, lynxTouchEvent);
                return;
            }
            if (actionMasked == 1) {
                if (this.mStatus == 2 && f == Float.MIN_VALUE && f2 == Float.MIN_VALUE) {
                    fail();
                    onEnd(0.0f, 0.0f, null);
                    return;
                }
                return;
            }
            if (actionMasked != 2) {
                return;
            }
            float x = this.mLastX - motionEvent.getX();
            float y = this.mLastY - motionEvent.getY();
            if (x == 0.0f && y == 0.0f) {
                return;
            }
            if (gestureExtraBundle != null && gestureExtraBundle.getGestureDirection() == 0) {
                gestureExtraBundle.setGestureDirection(Math.abs(x) > Math.abs(y) ? -1 : 1);
            }
            if (gestureExtraBundle != null && gestureExtraBundle.getGestureDirection() != 0) {
                if (gestureExtraBundle.getGestureDirection() == -1) {
                    y = 0.0f;
                }
                if (this.mStatus != 0) {
                    onBegin(this.mLastX, this.mLastY, lynxTouchEvent);
                    if (this.mStatus <= 1) {
                        activate();
                    }
                } else if (shouldFail(f3, y, gestureExtraBundle)) {
                    if (this.mGestureArenaMember != null && !this.mGestureArenaMember.isAtBorder(true) && !this.mGestureArenaMember.isAtBorder(false)) {
                        onUpdate(f3, y, lynxTouchEvent, gestureExtraBundle);
                    }
                    fail();
                    onEnd(this.mLastX, this.mLastY, lynxTouchEvent);
                } else {
                    activate();
                    onUpdate(f3, y, lynxTouchEvent, gestureExtraBundle);
                }
                this.mLastX = motionEvent.getX();
                this.mLastY = motionEvent.getY();
                return;
            }
            f3 = x;
            if (this.mStatus != 0) {
            }
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            return;
        }
        if (this.mGestureArenaMember != null) {
            this.mGestureArenaMember.onInvalidate();
        }
        if (this.mStatus == 2 && f == Float.MIN_VALUE && f2 == Float.MIN_VALUE) {
            fail();
            onEnd(0.0f, 0.0f, null);
            return;
        }
        if (gestureExtraBundle != null && gestureExtraBundle.getGestureDirection() != 0) {
            if (gestureExtraBundle.getGestureDirection() == -1) {
                f2 = 0.0f;
            } else {
                f = 0.0f;
            }
        }
        if (shouldFail(f, f2, gestureExtraBundle)) {
            if (this.mGestureArenaMember != null && !this.mGestureArenaMember.isAtBorder(true) && !this.mGestureArenaMember.isAtBorder(false)) {
                onUpdate(f, f2, null, gestureExtraBundle);
            }
            fail();
            onEnd(f, f2, null);
        } else {
            if (this.mStatus == 0) {
                onBegin(this.mLastX, this.mLastY, lynxTouchEvent);
                if (this.mStatus <= 1) {
                    activate();
                }
            }
            onUpdate(f, f2, null, gestureExtraBundle);
        }
        if (this.mGestureArenaMember != null) {
            this.mGestureArenaMember.onInvalidate();
        }
    }

    private boolean shouldFail(float f, float f2, GestureExtraBundle gestureExtraBundle) {
        if (gestureExtraBundle != null && this.mGestureArenaMember != null) {
            if (gestureExtraBundle.getGestureDirection() == -1 && this.mGestureArenaMember.getScrollContainerDirection() != -1) {
                return true;
            }
            if (gestureExtraBundle.getGestureDirection() == 1 && this.mGestureArenaMember.getScrollContainerDirection() != 1) {
                return true;
            }
        }
        return !this.mGestureArenaMember.canConsumeGesture(f, f2);
    }

    protected HashMap<String, Object> getEventParamsInActive(float f, float f2) {
        this.mEventParams.put("scrollX", Integer.valueOf(px2dip(this.mGestureArenaMember.getMemberScrollX())));
        this.mEventParams.put("scrollY", Integer.valueOf(px2dip(this.mGestureArenaMember.getMemberScrollY())));
        this.mEventParams.put("deltaX", Integer.valueOf(px2dip(f)));
        this.mEventParams.put("deltaY", Integer.valueOf(px2dip(f2)));
        this.mEventParams.put("isAtStart", Boolean.valueOf(this.mGestureArenaMember.isAtBorder(true)));
        this.mEventParams.put("isAtEnd", Boolean.valueOf(this.mGestureArenaMember.isAtBorder(false)));
        return this.mEventParams;
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void fail() {
        super.fail();
        LynxTouchEvent lynxTouchEvent = this.mLastTouchEvent;
        if (lynxTouchEvent == null) {
            onEnd(0.0f, 0.0f, null);
        } else {
            onEnd(this.mLastX, this.mLastY, lynxTouchEvent);
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void activate() {
        super.activate();
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void end() {
        super.end();
        LynxTouchEvent lynxTouchEvent = this.mLastTouchEvent;
        if (lynxTouchEvent == null) {
            onEnd(0.0f, 0.0f, null);
        } else {
            onEnd(this.mLastX, this.mLastY, lynxTouchEvent);
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void reset() {
        super.reset();
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mIsInvokedBegin = false;
        this.mIsInvokedStart = false;
        this.mIsInvokedEnd = false;
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onBegin(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (!isOnBeginEnable() || this.mIsInvokedBegin) {
            return;
        }
        this.mIsInvokedBegin = true;
        sendGestureEvent(GestureConstants.ON_BEGIN, getEventParamsInActive(0.0f, 0.0f));
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle) {
        if (this.mGestureArenaMember != null) {
            this.mGestureArenaMember.onGestureScrollBy(f, f2);
        }
        if (gestureExtraBundle != null) {
            gestureExtraBundle.setNeedConsumedSimultaneousGesture(true);
            gestureExtraBundle.setSimultaneousDeltaX(f);
            gestureExtraBundle.setSimultaneousDeltaY(f2);
        }
        if (Math.abs((int) f) > this.mTapSlop || Math.abs((int) f2) > this.mTapSlop) {
            this.mLynxContext.onGestureRecognized(this.mSign);
        }
        if (isOnUpdateEnable()) {
            sendGestureEvent(GestureConstants.ON_UPDATE, getEventParamsInActive(f, f2));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onStart(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnStartEnable() && !this.mIsInvokedStart && this.mIsInvokedBegin) {
            this.mIsInvokedStart = true;
            sendGestureEvent(GestureConstants.ON_START, getEventParamsInActive(f, f2));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onEnd(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnEndEnable() && !this.mIsInvokedEnd && this.mIsInvokedBegin) {
            this.mIsInvokedEnd = true;
            sendGestureEvent(GestureConstants.ON_END, getEventParamsInActive(0.0f, 0.0f));
        }
    }
}
