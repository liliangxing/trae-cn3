package com.lynx.tasm.gesture.handler;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.common.GestureExtraBundle;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.utils.PixelUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TapGestureHandler extends BaseGestureHandler {
    private final Runnable mDelayFailRunnable;
    private Handler mHandler;
    private boolean mIsInvokedEnd;
    private float mLastX;
    private float mLastY;
    private LynxTouchEvent mLynxTouchEvent;
    private float mMaxDistance;
    private long mMaxDuration;
    private float mStartX;
    private float mStartY;

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle) {
    }

    public TapGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        super(i, lynxContext, gestureDetector, gestureArenaMember);
        this.mMaxDistance = PixelUtils.dipToPx(10.0f);
        this.mMaxDuration = 500L;
        this.mStartX = 0.0f;
        this.mStartY = 0.0f;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mIsInvokedEnd = false;
        this.mLynxTouchEvent = null;
        this.mHandler = null;
        this.mDelayFailRunnable = new Runnable() { // from class: com.lynx.tasm.gesture.handler.TapGestureHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TapGestureHandler.this.fail();
            }
        };
        handleConfigMap(gestureDetector.getConfigMap());
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void handleConfigMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        this.mMaxDuration = readableMap.getLong(GestureConstants.MAX_DURATION, 500L);
        this.mMaxDistance = PixelUtils.dipToPx((float) readableMap.getLong(GestureConstants.MAX_DISTANCE, 10L));
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        this.mLynxTouchEvent = lynxTouchEvent;
        if (motionEvent == null) {
            ignore();
            endTap();
            return;
        }
        if (this.mStatus >= 3) {
            endTap();
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            this.mIsInvokedEnd = false;
            begin();
            onBegin(this.mStartX, this.mStartY, lynxTouchEvent);
            startTap();
            return;
        }
        if (actionMasked != 1) {
            if (actionMasked != 2) {
                return;
            }
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            if (shouldFail()) {
                fail();
                return;
            }
            return;
        }
        this.mLastX = motionEvent.getX();
        this.mLastY = motionEvent.getY();
        if (this.mStatus >= 3) {
            fail();
        } else {
            activate();
            onStart(this.mLastX, this.mLastY, lynxTouchEvent);
            onEnd(this.mLastX, this.mLastY, lynxTouchEvent);
        }
        endTap();
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void fail() {
        if (this.mStatus != 3) {
            this.mStatus = 3;
            onEnd(this.mLastX, this.mLastY, this.mLynxTouchEvent);
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void end() {
        if (this.mStatus != 4) {
            this.mStatus = 4;
            onEnd(this.mLastX, this.mLastY, this.mLynxTouchEvent);
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    public void reset() {
        super.reset();
        this.mIsInvokedEnd = false;
    }

    private void startTap() {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler.postDelayed(this.mDelayFailRunnable, this.mMaxDuration);
    }

    private void endTap() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    private boolean shouldFail() {
        float abs = Math.abs(this.mLastX - this.mStartX);
        float abs2 = Math.abs(this.mLastY - this.mStartY);
        float f = this.mMaxDistance;
        return abs > f || abs2 > f;
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onBegin(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnBeginEnable()) {
            sendGestureEvent(GestureConstants.ON_BEGIN, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onStart(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (isOnStartEnable()) {
            sendGestureEvent(GestureConstants.ON_START, getEventParamsFromTouchEvent(lynxTouchEvent));
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onEnd(float f, float f2, LynxTouchEvent lynxTouchEvent) {
        if (!isOnEndEnable() || this.mIsInvokedEnd) {
            return;
        }
        this.mIsInvokedEnd = true;
        sendGestureEvent(GestureConstants.ON_END, getEventParamsFromTouchEvent(lynxTouchEvent));
    }
}
