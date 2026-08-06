package com.lynx.tasm.behavior;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.core.JSProxy;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxIntersectionObserverManager extends LynxObserverManager implements EventEmitter.LynxEventObserver {
    private final String TAG;
    private final WeakReference<LynxContext> mContext;
    private boolean mEnableNewIntersectionObserver;
    private final WeakReference<JSProxy> mJSProxy;
    private final ArrayList<LynxIntersectionObserver> mObservers;

    public LynxIntersectionObserverManager(LynxContext lynxContext, JSProxy jSProxy) {
        super("Lynx.IntersectionObserver");
        this.TAG = "Lynx.IntersectionObserver";
        TraceEvent.beginSection("LynxIntersectionObserverManager initialized");
        this.mContext = new WeakReference<>(lynxContext);
        this.mRootBodyRef = new WeakReference<>(lynxContext.getUIBody());
        this.mJSProxy = new WeakReference<>(jSProxy);
        this.mObservers = new ArrayList<>();
        this.mEnableNewIntersectionObserver = false;
        TraceEvent.endSection("LynxIntersectionObserverManager initialized");
    }

    public LynxContext getContext() {
        return this.mContext.get();
    }

    public void sendIntersectionObserverEvent(final int i, final JavaOnlyMap javaOnlyMap) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.1
            @Override // java.lang.Runnable
            public void run() {
                EventEmitter eventEmitter;
                LynxCustomEvent lynxCustomEvent = new LynxCustomEvent(i, "intersection", javaOnlyMap);
                LynxContext lynxContext = (LynxContext) LynxIntersectionObserverManager.this.mContext.get();
                if (lynxContext == null || (eventEmitter = lynxContext.getEventEmitter()) == null) {
                    return;
                }
                eventEmitter.sendCustomEvent(lynxCustomEvent);
            }
        });
    }

    public void callIntersectionObserver(final int i, final int i2, final JavaOnlyMap javaOnlyMap) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.2
            @Override // java.lang.Runnable
            public void run() {
                JSProxy jSProxy = (JSProxy) LynxIntersectionObserverManager.this.mJSProxy.get();
                if (jSProxy != null) {
                    jSProxy.callIntersectionObserver(i, i2, javaOnlyMap);
                }
            }
        });
    }

    public void addIntersectionObserver(final LynxIntersectionObserver lynxIntersectionObserver) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (LynxIntersectionObserverManager.this.mObservers.contains(lynxIntersectionObserver)) {
                    return;
                }
                LynxIntersectionObserverManager.this.mObservers.add(lynxIntersectionObserver);
                if (LynxIntersectionObserverManager.this.mObservers.size() == 1) {
                    LynxContext context = lynxIntersectionObserver.getContext();
                    if (context != null) {
                        LynxIntersectionObserverManager.this.updateWindowSize(context);
                        LynxIntersectionObserverManager.this.mEnableNewIntersectionObserver = context.getEnableNewIntersectionObserver();
                    }
                    if (LynxIntersectionObserverManager.this.mEnableNewIntersectionObserver) {
                        LynxIntersectionObserverManager.this.addToObserverTree();
                    }
                }
            }
        });
    }

    public void removeIntersectionObserver(final int i) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = LynxIntersectionObserverManager.this.mObservers.iterator();
                while (it.hasNext()) {
                    LynxIntersectionObserver lynxIntersectionObserver = (LynxIntersectionObserver) it.next();
                    if (lynxIntersectionObserver.getObserverId() == i) {
                        LynxIntersectionObserverManager.this.mObservers.remove(lynxIntersectionObserver);
                        if (LynxIntersectionObserverManager.this.mEnableNewIntersectionObserver && LynxIntersectionObserverManager.this.mObservers.isEmpty()) {
                            LynxIntersectionObserverManager.this.destroy();
                            return;
                        }
                        return;
                    }
                }
            }
        });
    }

    public void removeAttachedIntersectionObserver(final LynxBaseUI lynxBaseUI) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = LynxIntersectionObserverManager.this.mObservers.iterator();
                while (it.hasNext()) {
                    LynxIntersectionObserver lynxIntersectionObserver = (LynxIntersectionObserver) it.next();
                    if (lynxIntersectionObserver.getAttachedUI() == lynxBaseUI) {
                        LynxIntersectionObserverManager.this.mObservers.remove(lynxIntersectionObserver);
                        if (LynxIntersectionObserverManager.this.mEnableNewIntersectionObserver && LynxIntersectionObserverManager.this.mObservers.isEmpty()) {
                            LynxIntersectionObserverManager.this.destroy();
                            return;
                        }
                        return;
                    }
                }
            }
        });
    }

    public LynxIntersectionObserver getObserverById(int i) {
        Iterator<LynxIntersectionObserver> it = this.mObservers.iterator();
        while (it.hasNext()) {
            LynxIntersectionObserver next = it.next();
            if (next.getObserverId() == i) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0030, code lost:
    
        if ("scrolltolower".equals(r3) == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLynxEvent(EventEmitter.LynxEventType lynxEventType, LynxEvent lynxEvent) {
        if (this.mObservers.size() == 0) {
            return;
        }
        boolean z = true;
        if (lynxEventType != EventEmitter.LynxEventType.kLynxEventTypeLayoutEvent) {
            if (lynxEventType == EventEmitter.LynxEventType.kLynxEventTypeCustomEvent) {
                String name = lynxEvent.getName();
                if (!"scroll".equals(name)) {
                    if (!"scrolltoupper".equals(name)) {
                    }
                }
            }
            z = false;
        }
        if (z) {
            notifyObservers();
        }
    }

    public void notifyObservers() {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = LynxIntersectionObserverManager.this.mObservers.iterator();
                while (it.hasNext()) {
                    LynxIntersectionObserver lynxIntersectionObserver = (LynxIntersectionObserver) it.next();
                    if (lynxIntersectionObserver == null) {
                        LLog.e("Lynx.IntersectionObserver", "LynxIntersectionObserverManager.notifyObservers failed, because observer is null");
                        return;
                    }
                    lynxIntersectionObserver.checkForIntersections();
                }
            }
        });
    }

    @Override // com.lynx.tasm.behavior.LynxObserverManager
    protected void observerHandlerInner() {
        if (!this.mRootViewPainted) {
            LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView not draw");
        } else if (getRootView() == null) {
            LLog.e("Lynx.IntersectionObserver", "Lynx intersectionObserverHandler failed since rootView is null");
        } else {
            notifyObservers();
        }
    }

    public void clear() {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.LynxIntersectionObserverManager.7
            @Override // java.lang.Runnable
            public void run() {
                LynxIntersectionObserverManager.this.mObservers.clear();
                LynxIntersectionObserverManager.this.destroy();
            }
        });
    }
}
