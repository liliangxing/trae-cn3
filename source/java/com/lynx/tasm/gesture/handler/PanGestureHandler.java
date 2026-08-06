package com.lynx.tasm.gesture.handler;

import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.common.GestureExtraBundle;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.utils.PixelUtils;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PanGestureHandler extends BaseGestureHandler {
    private final HashMap<String, Object> mEventParams;
    private boolean mIsInvokedBegin;
    private boolean mIsInvokedEnd;
    private boolean mIsInvokedStart;
    private LynxTouchEvent mLastTouchEvent;
    private float mLastX;
    private float mLastY;
    private float mMinDistance;
    private float mStartX;
    private float mStartY;

    public PanGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        super(i, lynxContext, gestureDetector, gestureArenaMember);
        this.mMinDistance = PixelUtils.dipToPx(0.0f);
        this.mStartX = 0.0f;
        this.mStartY = 0.0f;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mIsInvokedBegin = false;
        this.mIsInvokedStart = false;
        this.mIsInvokedEnd = false;
        handleConfigMap(gestureDetector.getConfigMap());
        this.mEventParams = new HashMap<>();
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void handleConfigMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        this.mMinDistance = PixelUtils.dipToPx((float) readableMap.getLong(GestureConstants.MIN_DISTANCE, 0L), 0.0f);
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        if (lynxTouchEvent != null) {
            this.mLastTouchEvent = lynxTouchEvent;
        }
        if (motionEvent == null) {
            ignore();
            return;
        }
        if (this.mStatus >= 3) {
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            this.mIsInvokedEnd = false;
            begin();
            onBegin(this.mStartX, this.mStartY, lynxTouchEvent);
            return;
        }
        if (actionMasked == 1) {
            fail();
            onEnd(this.mLastX, this.mLastY, this.mLastTouchEvent);
            return;
        }
        if (actionMasked != 2) {
            return;
        }
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
        if (this.mStatus == 0) {
            begin();
            onBegin(this.mLastX, this.mLastY, lynxTouchEvent);
        }
        if (shouldActive()) {
            onStart(this.mLastX, this.mStartY, lynxTouchEvent);
            activate();
        }
        if (this.mStatus == 2) {
            onUpdate(this.mLastX, this.mLastY, lynxTouchEvent, gestureExtraBundle);
        } else if (this.mStatus >= 3) {
            onEnd(this.mLastX, this.mLastY, lynxTouchEvent);
        }
    }

    private boolean shouldActive() {
        if (this.mStatus >= 3) {
            return false;
        }
        float abs = Math.abs(this.mLastX - this.mStartX);
        float abs2 = Math.abs(this.mLastY - this.mStartY);
        float f = this.mMinDistance;
        return abs > f || abs2 > f;
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void fail() {
        super.fail();
        onEnd(this.mLastX, this.mLastY, this.mLastTouchEvent);
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void end() {
        super.end();
        onEnd(this.mLastX, this.mLastY, this.mLastTouchEvent);
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void reset() {
        super.reset();
        this.mIsInvokedBegin = false;
        this.mIsInvokedStart = false;
        this.mIsInvokedEnd = false;
    }

    protected HashMap<String, Object> getEventParamsInActive(LynxTouchEvent lynxTouchEvent) {
        this.mEventParams.put("scrollX", Integer.valueOf(px2dip(this.mGestureArenaMember.getMemberScrollX())));
        this.mEventParams.put("scrollY", Integer.valueOf(px2dip(this.mGestureArenaMember.getMemberScrollY())));
        this.mEventParams.put("isAtStart", Boolean.valueOf(this.mGestureArenaMember.isAtBorder(true)));
        this.mEventParams.put("isAtEnd", Boolean.valueOf(this.mGestureArenaMember.isAtBorder(false)));
        this.mEventParams.putAll(getEventParamsFromTouchEvent(lynxTouchEvent));
        return this.mEventParams;
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onBegin(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (!isOnBeginEnable() || this.mIsInvokedBegin) {
            return;
        }
        this.mIsInvokedBegin = true;
        sendGestureEvent(GestureConstants.ON_BEGIN, getEventParamsInActive(lynxTouchEvent));
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle) {
        if (isOnUpdateEnable()) {
            sendGestureEvent(GestureConstants.ON_UPDATE, getEventParamsInActive(lynxTouchEvent));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onStart(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnStartEnable() && !this.mIsInvokedStart && this.mIsInvokedBegin) {
            this.mIsInvokedStart = true;
            sendGestureEvent(GestureConstants.ON_START, getEventParamsInActive(lynxTouchEvent));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onEnd(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnEndEnable() && !this.mIsInvokedEnd && this.mIsInvokedBegin) {
            this.mIsInvokedEnd = true;
            sendGestureEvent(GestureConstants.ON_END, getEventParamsInActive(lynxTouchEvent));
        }
    }
}
