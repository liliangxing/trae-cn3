package com.lynx.tasm;

import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxInternalEvent;
import com.lynx.tasm.event.LynxTouchEvent;

/* loaded from: classes6.dex */
public abstract class EventEmitter {
    private static final String TAG = "EventEmitter";

    /* loaded from: classes6.dex */
    public interface ITestTapTrack {
        void onTap();
    }

    /* loaded from: classes6.dex */
    public interface LynxEventFallback {
        void checkFallbackForLynxEvent(boolean z);
    }

    /* loaded from: classes6.dex */
    public interface LynxEventObserver {
        void onLynxEvent(LynxEventType lynxEventType, LynxEvent lynxEvent);
    }

    /* loaded from: classes6.dex */
    public interface LynxEventReporter {
        void onInternalEvent(LynxInternalEvent lynxInternalEvent);

        boolean onLynxEvent(LynxEvent lynxEvent);
    }

    /* loaded from: classes6.dex */
    public enum LynxEventType {
        kLynxEventTypeTouchEvent,
        kLynxEventTypeCustomEvent,
        kLynxEventTypeLayoutEvent
    }

    public abstract void addObserver(LynxEventObserver lynxEventObserver);

    public void onInternalEvent(LynxInternalEvent lynxInternalEvent) {
    }

    public abstract boolean onLynxEvent(LynxEvent lynxEvent);

    public abstract void onPseudoStatusChanged(int i, int i2, int i3);

    public abstract void registerEventFallback(LynxEventFallback lynxEventFallback);

    public abstract void registerEventReporter(LynxEventReporter lynxEventReporter);

    public abstract void removeObserver(LynxEventObserver lynxEventObserver);

    public abstract void sendCustomEvent(LynxCustomEvent lynxCustomEvent);

    public abstract void sendGestureEvent(int i, LynxCustomEvent lynxCustomEvent);

    public void sendInternalEvent(LynxInternalEvent lynxInternalEvent) {
    }

    public abstract void sendLayoutEvent();

    public abstract void sendMultiTouchEvent(LynxTouchEvent lynxTouchEvent);

    public abstract void sendTouchEvent(LynxTouchEvent lynxTouchEvent);

    public void setEventID(long j) {
    }

    public abstract void setInPreLoad(boolean z);

    public abstract void setTestTapTracker(ITestTapTrack iTestTapTrack);

    public void startEventBubble(long j) {
    }

    public void startEventCapture(long j) {
    }

    public void startEventFire(boolean z, long j) {
    }

    public void startEventGenerate(LynxEvent lynxEvent) {
    }
}
