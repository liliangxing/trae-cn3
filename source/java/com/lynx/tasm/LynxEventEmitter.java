package com.lynx.tasm;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.trace.TraceEventDef;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxIntersectionObserverManager;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxEventEmitter extends EventEmitter {
    private static final String TAG = "EventEmitter";
    LynxEngineProxyWrapper mEngineProxy;
    private EventEmitter.ITestTapTrack mTrack;
    private long mEventID = 0;
    private boolean mInPreLoad = false;
    final ArrayList<EventEmitter.LynxEventObserver> mEventObservers = new ArrayList<>();
    final Handler mHandler = new Handler(Looper.getMainLooper());
    private WeakReference<EventEmitter.LynxEventReporter> mEventReporter = new WeakReference<>(null);
    private WeakReference<EventEmitter.LynxEventFallback> mEventFallback = new WeakReference<>(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LynxEngineProxyWrapper {
        private LynxEngineProxy mEngineProxy;

        public LynxEngineProxyWrapper(LynxEngineProxy lynxEngineProxy) {
            this.mEngineProxy = lynxEngineProxy;
        }

        void sendTouchEvent(LynxTouchEvent lynxTouchEvent) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.sendTouchEvent(lynxTouchEvent);
            }
        }

        void sendMultiTouchEvent(LynxTouchEvent lynxTouchEvent) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.sendMultiTouchEvent(lynxTouchEvent);
            }
        }

        void sendCustomEvent(LynxCustomEvent lynxCustomEvent) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.sendCustomEvent(lynxCustomEvent);
            }
        }

        void sendGestureEvent(String str, int i, int i2, ByteBuffer byteBuffer, int i3) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.sendGestureEvent(str, i, i2, byteBuffer, i3);
            }
        }

        void onPseudoStatusChanged(int i, int i2, int i3) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.onPseudoStatusChanged(i, i2, i3);
            }
        }

        void startEventGenerate(LynxEvent lynxEvent) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.startEventGenerate(lynxEvent);
            }
        }

        void startEventCapture(long j) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.startEventCapture(j);
            }
        }

        void startEventBubble(long j) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.startEventBubble(j);
            }
        }

        void startEventFire(boolean z, long j) {
            LynxEngineProxy lynxEngineProxy = this.mEngineProxy;
            if (lynxEngineProxy != null) {
                lynxEngineProxy.startEventFire(z, j);
            }
        }
    }

    public LynxEventEmitter(LynxEngineProxy lynxEngineProxy) {
        this.mEngineProxy = new LynxEngineProxyWrapper(lynxEngineProxy);
    }

    @Override // com.lynx.tasm.EventEmitter
    public void sendTouchEvent(LynxTouchEvent lynxTouchEvent) {
        String name = lynxTouchEvent.getName();
        if (this.mEngineProxy != null && !this.mInPreLoad) {
            if (onLynxEvent(lynxTouchEvent)) {
                return;
            }
            if (this.mTrack != null && "tap".equals(name)) {
                this.mTrack.onTap();
            }
            EventTarget target = lynxTouchEvent.getTarget();
            if (target != null && (target.getParentLynxPageUI() != null || target.getChildrenLynxPageUI() != null)) {
                if (target.getParentLynxPageUI() == null) {
                    this.mEventID = (this.mEventID + 1) % 9223372036854775806L;
                }
                lynxTouchEvent.setEventID(this.mEventID);
                target.setEventID(this.mEventID);
                LLog.m2578i("LynxEventEmitter", "TouchEventHandler " + lynxTouchEvent.getName() + " " + lynxTouchEvent.getEventID() + " " + this);
                startEventGenerate(lynxTouchEvent);
                if (target.getChildrenLynxPageUI() == null || target.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(target))) == null) {
                    target.getRootLynxPageUI().startEventCapture(this.mEventID);
                    return;
                }
                return;
            }
            this.mEngineProxy.sendTouchEvent(lynxTouchEvent);
            return;
        }
        LLog.m2577e(TAG, "sendTouchEvent event: " + name + " failed since mEngineProxy is null or in preload.");
    }

    @Override // com.lynx.tasm.EventEmitter
    public boolean onLynxEvent(LynxEvent lynxEvent) {
        EventEmitter.LynxEventReporter lynxEventReporter = this.mEventReporter.get();
        if (lynxEventReporter != null) {
            return lynxEventReporter.onLynxEvent(lynxEvent);
        }
        LLog.m2577e(TAG, "onLynxEvent event: " + lynxEvent.getName() + " failed since mEventReporter is null.");
        return false;
    }

    @Override // com.lynx.tasm.EventEmitter
    public void sendMultiTouchEvent(LynxTouchEvent lynxTouchEvent) {
        if (this.mEngineProxy != null && !this.mInPreLoad) {
            if (onLynxEvent(lynxTouchEvent)) {
                return;
            }
            EventTarget target = lynxTouchEvent.getTarget();
            if (target != null && (target.getParentLynxPageUI() != null || target.getChildrenLynxPageUI() != null)) {
                if (target.getParentLynxPageUI() == null) {
                    this.mEventID = (this.mEventID + 1) % 9223372036854775806L;
                }
                lynxTouchEvent.setEventID(this.mEventID);
                target.setEventID(this.mEventID);
                LLog.m2578i("LynxEventEmitter", "TouchEventHandler " + lynxTouchEvent.getName() + " " + lynxTouchEvent.getEventID() + " " + this);
                startEventGenerate(lynxTouchEvent);
                if (target.getChildrenLynxPageUI() == null || target.getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(target))) == null) {
                    target.getRootLynxPageUI().startEventCapture(this.mEventID);
                    return;
                }
                return;
            }
            this.mEngineProxy.sendMultiTouchEvent(lynxTouchEvent);
            return;
        }
        LLog.m2577e(TAG, "sendMultiTouchEvent event: " + lynxTouchEvent.getName() + " failed since mEngineProxy is null or in preload.");
    }

    @Override // com.lynx.tasm.EventEmitter
    public void sendCustomEvent(final LynxCustomEvent lynxCustomEvent) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxEventEmitter.1
            @Override // java.lang.Runnable
            public void run() {
                lynxCustomEvent.getName();
                if (LynxEventEmitter.this.mEngineProxy != null && !LynxEventEmitter.this.mInPreLoad) {
                    if (LynxEventEmitter.this.onLynxEvent(lynxCustomEvent)) {
                        return;
                    }
                    LynxCustomEvent lynxCustomEvent2 = lynxCustomEvent;
                    lynxCustomEvent2.addDetail(TraceEventDef.TIMING_TIMESTAMP, Long.valueOf(lynxCustomEvent2.getTimestamp()));
                    if (LynxEventEmitter.this.mEventFallback != null && LynxEventEmitter.this.mEventFallback.get() != null) {
                        ((EventEmitter.LynxEventFallback) LynxEventEmitter.this.mEventFallback.get()).checkFallbackForLynxEvent(false);
                        LynxEventEmitter.this.mEngineProxy.sendCustomEvent(lynxCustomEvent);
                    } else {
                        LLog.m2577e(LynxEventEmitter.TAG, "checkFallbackForLynxEvent event: " + lynxCustomEvent.getName() + " failed since mEventFallback is null.");
                        return;
                    }
                } else {
                    LLog.m2577e(LynxEventEmitter.TAG, "sendCustomEvent event: " + lynxCustomEvent.getName() + " failed since mEngineProxy is null or in preload.");
                }
                LynxEventEmitter.this.notifyEventObservers(EventEmitter.LynxEventType.kLynxEventTypeCustomEvent, lynxCustomEvent);
            }
        });
    }

    @Override // com.lynx.tasm.EventEmitter
    public void sendGestureEvent(int i, LynxCustomEvent lynxCustomEvent) {
        String name = lynxCustomEvent.getName();
        if (this.mEngineProxy != null && !this.mInPreLoad) {
            ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(lynxCustomEvent.eventParams());
            this.mEngineProxy.sendGestureEvent(name, lynxCustomEvent.getTag(), i, encodeMessage, encodeMessage == null ? 0 : encodeMessage.position());
        } else {
            LLog.m2577e(TAG, "sendGestureEvent event: " + name + " failed since mEngineProxy is null or in preload.");
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void onPseudoStatusChanged(int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        LynxEngineProxyWrapper lynxEngineProxyWrapper = this.mEngineProxy;
        if (lynxEngineProxyWrapper != null) {
            lynxEngineProxyWrapper.onPseudoStatusChanged(i, i2, i3);
        } else {
            LLog.m2577e(TAG, "onPseudoStatusChanged id: " + i + " failed since mEngineProxy is null.");
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void setTestTapTracker(EventEmitter.ITestTapTrack iTestTapTrack) {
        this.mTrack = iTestTapTrack;
    }

    @Override // com.lynx.tasm.EventEmitter
    public void sendLayoutEvent() {
        notifyEventObservers(EventEmitter.LynxEventType.kLynxEventTypeLayoutEvent, null);
    }

    @Override // com.lynx.tasm.EventEmitter
    public void setInPreLoad(boolean z) {
        this.mInPreLoad = z;
    }

    @Override // com.lynx.tasm.EventEmitter
    public void addObserver(EventEmitter.LynxEventObserver lynxEventObserver) {
        if (this.mEventObservers.contains(lynxEventObserver)) {
            return;
        }
        this.mEventObservers.add(lynxEventObserver);
    }

    @Override // com.lynx.tasm.EventEmitter
    public void removeObserver(EventEmitter.LynxEventObserver lynxEventObserver) {
        if (this.mEventObservers.contains(lynxEventObserver)) {
            this.mEventObservers.remove(lynxEventObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyEventObservers(final EventEmitter.LynxEventType lynxEventType, final LynxEvent lynxEvent) {
        Runnable runnable = new Runnable() { // from class: com.lynx.tasm.LynxEventEmitter.2
            @Override // java.lang.Runnable
            public void run() {
                LynxContext context;
                Iterator<EventEmitter.LynxEventObserver> it = LynxEventEmitter.this.mEventObservers.iterator();
                while (it.hasNext()) {
                    LynxIntersectionObserverManager lynxIntersectionObserverManager = (EventEmitter.LynxEventObserver) it.next();
                    if (!(lynxIntersectionObserverManager instanceof LynxIntersectionObserverManager) || (context = lynxIntersectionObserverManager.getContext()) == null || !context.getEnableNewIntersectionObserver()) {
                        lynxIntersectionObserverManager.onLynxEvent(lynxEventType, lynxEvent);
                    }
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void registerEventReporter(EventEmitter.LynxEventReporter lynxEventReporter) {
        this.mEventReporter = new WeakReference<>(lynxEventReporter);
    }

    @Override // com.lynx.tasm.EventEmitter
    public void registerEventFallback(EventEmitter.LynxEventFallback lynxEventFallback) {
        this.mEventFallback = new WeakReference<>(lynxEventFallback);
    }

    @Override // com.lynx.tasm.EventEmitter
    public void startEventGenerate(LynxEvent lynxEvent) {
        LynxEngineProxyWrapper lynxEngineProxyWrapper = this.mEngineProxy;
        if (lynxEngineProxyWrapper != null) {
            lynxEngineProxyWrapper.startEventGenerate(lynxEvent);
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void setEventID(long j) {
        this.mEventID = j;
    }

    @Override // com.lynx.tasm.EventEmitter
    public void startEventCapture(long j) {
        LynxEngineProxyWrapper lynxEngineProxyWrapper = this.mEngineProxy;
        if (lynxEngineProxyWrapper != null) {
            lynxEngineProxyWrapper.startEventCapture(j);
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void startEventBubble(long j) {
        LynxEngineProxyWrapper lynxEngineProxyWrapper = this.mEngineProxy;
        if (lynxEngineProxyWrapper != null) {
            lynxEngineProxyWrapper.startEventBubble(j);
        }
    }

    @Override // com.lynx.tasm.EventEmitter
    public void startEventFire(boolean z, long j) {
        LynxEngineProxyWrapper lynxEngineProxyWrapper = this.mEngineProxy;
        if (lynxEngineProxyWrapper != null) {
            lynxEngineProxyWrapper.startEventFire(z, j);
        }
    }
}
