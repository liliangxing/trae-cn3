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
public class FlingGestureHandler extends BaseGestureHandler {
    private final HashMap<String, Object> mEventParams;
    private boolean mIsInvokedBegin;
    private boolean mIsInvokedEnd;
    private boolean mIsInvokedStart;

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void handleConfigMap(ReadableMap readableMap) {
    }

    public FlingGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        super(i, lynxContext, gestureDetector, gestureArenaMember);
        this.mIsInvokedBegin = false;
        this.mIsInvokedStart = false;
        this.mIsInvokedEnd = false;
        handleConfigMap(gestureDetector.getConfigMap());
        this.mEventParams = new HashMap<>();
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        if (this.mGestureArenaMember != null) {
            this.mGestureArenaMember.onInvalidate();
        }
        if (motionEvent != null && (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 2)) {
            ignore();
            return;
        }
        if (motionEvent != null && motionEvent.getActionMasked() == 1) {
            begin();
            onBegin(0.0f, 0.0f, null);
            return;
        }
        if (this.mStatus >= 3 && this.mStatus <= 4) {
            onEnd(0.0f, 0.0f, null);
            return;
        }
        if (f == Float.MIN_VALUE && f2 == Float.MIN_VALUE) {
            fail();
            onEnd(0.0f, 0.0f, null);
        } else {
            if (this.mStatus == 0 || this.mStatus == 5) {
                begin();
                activate();
                onBegin(0.0f, 0.0f, null);
                onStart(0.0f, 0.0f, null);
                return;
            }
            onUpdate(f, f2, null, gestureExtraBundle);
        }
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
        onEnd(0.0f, 0.0f, null);
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void end() {
        super.end();
        onEnd(0.0f, 0.0f, null);
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void reset() {
        super.reset();
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
        sendGestureEvent(GestureConstants.ON_BEGIN, getEventParamsInActive(f, f2));
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle) {
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
            sendGestureEvent(GestureConstants.ON_END, getEventParamsInActive(f, f2));
        }
    }
}
