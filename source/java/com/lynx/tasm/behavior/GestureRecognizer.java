package com.lynx.tasm.behavior;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;

/* loaded from: classes7.dex */
public class GestureRecognizer {
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private OnDoubleTapListener mDoubleTapListener;
    private final Handler mHandler;
    private boolean mIgnoreMultitouch;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastMotionX;
    private float mLastMotionY;
    private final OnGestureListener mListener;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private static int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();

    /* loaded from: classes7.dex */
    public interface OnDoubleTapListener {
        boolean onDoubleTap(MotionEvent motionEvent);

        boolean onDoubleTapEvent(MotionEvent motionEvent);

        boolean onSingleTapConfirmed(MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public interface OnGestureListener {
        boolean onDown(MotionEvent motionEvent);

        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onLongPress(MotionEvent motionEvent);

        boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);

        void onShowPress(MotionEvent motionEvent);

        boolean onSingleTapUp(MotionEvent motionEvent);
    }

    /* loaded from: classes7.dex */
    public static class SimpleOnGestureListener implements OnGestureListener, OnDoubleTapListener {
        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return false;
        }

        @Override // com.lynx.tasm.behavior.GestureRecognizer.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    private class GestureHandler extends Handler {
        GestureHandler() {
        }

        GestureHandler(Handler handler) {
            super(handler.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GestureRecognizer.this.mListener.onShowPress(GestureRecognizer.this.mCurrentDownEvent);
                return;
            }
            if (i == 2) {
                GestureRecognizer.this.dispatchLongPress();
            } else {
                if (i == 3) {
                    if (GestureRecognizer.this.mDoubleTapListener == null || GestureRecognizer.this.mStillDown) {
                        return;
                    }
                    GestureRecognizer.this.mDoubleTapListener.onSingleTapConfirmed(GestureRecognizer.this.mCurrentDownEvent);
                    return;
                }
                throw new RuntimeException("Unknown message " + message);
            }
        }
    }

    @Deprecated
    public GestureRecognizer(OnGestureListener onGestureListener, Handler handler) {
        this(null, onGestureListener, handler);
    }

    @Deprecated
    public GestureRecognizer(OnGestureListener onGestureListener) {
        this(null, onGestureListener, null);
    }

    public GestureRecognizer(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureRecognizer(Context context, OnGestureListener onGestureListener, Handler handler) {
        this(context, onGestureListener, handler, context != null && context.getApplicationInfo().targetSdkVersion >= 8);
    }

    public GestureRecognizer(Context context, OnGestureListener onGestureListener, Handler handler, boolean z) {
        if (handler != null) {
            this.mHandler = new GestureHandler(handler);
        } else {
            this.mHandler = new GestureHandler();
        }
        this.mListener = onGestureListener;
        if (onGestureListener instanceof OnDoubleTapListener) {
            setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
        }
        init(context, z);
    }

    private void init(Context context, boolean z) {
        if (this.mListener == null) {
            throw new NullPointerException("OnGestureListener must not be null");
        }
        this.mIsLongpressEnabled = true;
        this.mIgnoreMultitouch = z;
        updateTouchSlop(context);
    }

    public void updateTouchSlop(Context context) {
        int scaledTouchSlop;
        if (context == null) {
            scaledTouchSlop = ViewConfiguration.getTouchSlop();
        } else {
            scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        }
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mDoubleTapListener = onDoubleTapListener;
    }

    public void setLongPressTimeout(int i) {
        LONGPRESS_TIMEOUT = i;
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mIsLongpressEnabled = z;
    }

    public boolean isLongpressEnabled() {
        return this.mIsLongpressEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        float x = motionEvent.getX();
        int i = action & 255;
        boolean z = false;
        if (i == 0) {
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            MotionEvent motionEvent2 = this.mCurrentDownEvent;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            if (this.mIsLongpressEnabled) {
                this.mHandler.removeMessages(2);
                this.mHandler.sendEmptyMessageAtTime(2, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT + LONGPRESS_TIMEOUT);
            }
            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + TAP_TIMEOUT);
            return false | this.mListener.onDown(motionEvent);
        }
        if (i == 1) {
            this.mStillDown = false;
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            if (!this.mIsDoubleTapping) {
                if (this.mInLongPress) {
                    this.mHandler.removeMessages(3);
                    this.mInLongPress = false;
                } else if (this.mAlwaysInTapRegion) {
                    z = this.mListener.onSingleTapUp(motionEvent);
                }
            }
            MotionEvent motionEvent3 = this.mPreviousUpEvent;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.mPreviousUpEvent = obtain;
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            return z;
        }
        if (i != 2) {
            if (i == 3) {
                cancel();
                return false;
            }
            if (i == 5) {
                if (!this.mIgnoreMultitouch) {
                    return false;
                }
                cancel();
                return false;
            }
            if (i != 6 || !this.mIgnoreMultitouch || motionEvent.getPointerCount() != 2) {
                return false;
            }
            int i2 = ((action & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8) != 0 ? 0 : 1;
            this.mLastMotionX = motionEvent.getX(i2);
            this.mLastMotionY = motionEvent.getY(i2);
            return false;
        }
        if (this.mInLongPress) {
            return false;
        }
        if (this.mIgnoreMultitouch && motionEvent.getPointerCount() > 1) {
            return false;
        }
        float f = this.mLastMotionX - x;
        float f2 = this.mLastMotionY - y;
        if (this.mIsDoubleTapping) {
            return false;
        }
        if (!this.mAlwaysInTapRegion) {
            if (Math.abs(f) < 1.0f && Math.abs(f2) < 1.0f) {
                return false;
            }
            boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f, f2);
            this.mLastMotionX = x;
            this.mLastMotionY = y;
            return onScroll;
        }
        int x2 = (int) (x - this.mCurrentDownEvent.getX());
        int y2 = (int) (y - this.mCurrentDownEvent.getY());
        if ((x2 * x2) + (y2 * y2) <= this.mTouchSlopSquare) {
            return false;
        }
        boolean onScroll2 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f, f2);
        this.mLastMotionX = x;
        this.mLastMotionY = y;
        this.mAlwaysInTapRegion = false;
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        return onScroll2;
    }

    private void cancel() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mStillDown = false;
        this.mAlwaysInTapRegion = false;
        this.mAlwaysInBiggerTapRegion = false;
        if (this.mInLongPress) {
            this.mInLongPress = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchLongPress() {
        this.mHandler.removeMessages(3);
        this.mInLongPress = true;
        this.mListener.onLongPress(this.mCurrentDownEvent);
    }
}
