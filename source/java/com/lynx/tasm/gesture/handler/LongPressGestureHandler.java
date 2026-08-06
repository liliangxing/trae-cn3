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
public class LongPressGestureHandler extends BaseGestureHandler {
    private final Runnable mDelayActivateRunnable;
    private Handler mHandler;
    private boolean mIsInvokedEnd;
    private float mLastX;
    private float mLastY;
    private LynxTouchEvent mLynxTouchEvent;
    private float mMaxDistance;
    private long mMinDuration;
    private float mStartX;
    private float mStartY;

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onUpdate(float f, float f2, LynxTouchEvent lynxTouchEvent, GestureExtraBundle gestureExtraBundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-lynx-tasm-gesture-handler-LongPressGestureHandler */
    public /* synthetic */ void m12x16a9ed30() {
        if (this.mStatus == 3 || this.mStatus == 2) {
            return;
        }
        activate();
        onStart(this.mLastX, this.mLastY, this.mLynxTouchEvent);
    }

    public LongPressGestureHandler(int i, LynxContext lynxContext, GestureDetector gestureDetector, GestureArenaMember gestureArenaMember) {
        super(i, lynxContext, gestureDetector, gestureArenaMember);
        this.mMinDuration = 500L;
        this.mMaxDistance = PixelUtils.dipToPx(10.0f);
        this.mHandler = null;
        this.mStartX = 0.0f;
        this.mStartY = 0.0f;
        this.mLastX = 0.0f;
        this.mLastY = 0.0f;
        this.mLynxTouchEvent = null;
        this.mIsInvokedEnd = false;
        this.mDelayActivateRunnable = new Runnable() { // from class: com.lynx.tasm.gesture.handler.LongPressGestureHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LongPressGestureHandler.this.m12x16a9ed30();
            }
        };
        handleConfigMap(gestureDetector.getConfigMap());
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void handleConfigMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        this.mMinDuration = readableMap.getLong(GestureConstants.MIN_DURATION, 500L);
        this.mMaxDistance = PixelUtils.dipToPx((float) readableMap.getLong(GestureConstants.MAX_DISTANCE, 10L));
    }

    private void startLongPress() {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.mHandler.postDelayed(this.mDelayActivateRunnable, this.mMinDuration);
    }

    private void endLongPress() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    @Override // com.lynx.tasm.gesture.handler.BaseGestureHandler
    protected void onHandle(MotionEvent motionEvent, LynxTouchEvent lynxTouchEvent, float f, float f2, boolean z, GestureExtraBundle gestureExtraBundle) {
        this.mLynxTouchEvent = lynxTouchEvent;
        if (motionEvent == null) {
            ignore();
            return;
        }
        if (this.mStatus >= 3) {
            endLongPress();
            return;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mStartX = motionEvent.getX();
            this.mStartY = motionEvent.getY();
            this.mIsInvokedEnd = false;
            begin();
            onBegin(this.mStartX, this.mStartY, lynxTouchEvent);
            startLongPress();
            return;
        }
        if (actionMasked == 1) {
            endLongPress();
            fail();
        } else {
            if (actionMasked != 2) {
                return;
            }
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            if (shouldFail()) {
                fail();
                endLongPress();
            }
        }
    }

    private boolean shouldFail() {
        float abs = Math.abs(this.mLastX - this.mStartX);
        float abs2 = Math.abs(this.mLastY - this.mStartY);
        float f = this.mMaxDistance;
        return abs > f || abs2 > f;
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
