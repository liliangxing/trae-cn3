package com.lynx.tasm.core;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.common.LepusBuffer;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import java.nio.ByteBuffer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LynxEngineProxy {
    private static final String TAG = "LynxEngineProxy";
    private long mNativePtr;

    private native long nativeCreate(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDestroy(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeDispatchTaskToLynxEngine(long j, Runnable runnable);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInvokeLepusApiCallback(long j, int i, String str, Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPseudoStatusChanged(long j, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendCustomEvent(long j, String str, int i, ByteBuffer byteBuffer, int i2, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendGestureEvent(long j, String str, int i, int i2, ByteBuffer byteBuffer, int i3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendMultiTouchEvent(long j, String str, ByteBuffer byteBuffer, int i, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeSendTouchEvent(long j, String str, int i, float f, float f2, float f3, float f4, float f5, float f6, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStartEventBubble(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStartEventCapture(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStartEventFire(long j, boolean z, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeStartEventGenerate(long j, ByteBuffer byteBuffer, int i);

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public LynxEngineProxy(long j) {
        this.mNativePtr = nativeCreate(j);
    }

    public void destroy() {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.1
            @Override // java.lang.Runnable
            public void run() {
                LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                lynxEngineProxy.nativeDestroy(lynxEngineProxy.mNativePtr);
                LynxEngineProxy.this.mNativePtr = 0L;
            }
        });
    }

    public void dispatchTaskToLynxEngine(final Runnable runnable) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.2
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "DispatchTaskToLynxEngine failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeDispatchTaskToLynxEngine(lynxEngineProxy.mNativePtr, runnable);
                }
            }
        });
    }

    public void sendTouchEvent(final LynxTouchEvent lynxTouchEvent) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.3
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "sendTouchEvent failed since mNativePtr is null");
                    return;
                }
                LynxTouchEvent.Point clientPoint = lynxTouchEvent.getClientPoint();
                LynxTouchEvent.Point pagePoint = lynxTouchEvent.getPagePoint();
                LynxTouchEvent.Point viewPoint = lynxTouchEvent.getViewPoint();
                LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                lynxEngineProxy.nativeSendTouchEvent(lynxEngineProxy.mNativePtr, lynxTouchEvent.getName(), lynxTouchEvent.getTag(), clientPoint.getX(), clientPoint.getY(), pagePoint.getX(), pagePoint.getY(), viewPoint.getX(), viewPoint.getY(), lynxTouchEvent.getTimestamp());
            }
        });
    }

    public void sendMultiTouchEvent(final LynxTouchEvent lynxTouchEvent) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.4
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "sendMultiTouchEvent failed since mNativePtr is null");
                    return;
                }
                ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(lynxTouchEvent.getUITouchMap());
                int position = encodeMessage == null ? 0 : encodeMessage.position();
                LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                lynxEngineProxy.nativeSendMultiTouchEvent(lynxEngineProxy.mNativePtr, lynxTouchEvent.getName(), encodeMessage, position, lynxTouchEvent.getTimestamp());
            }
        });
    }

    public void sendCustomEvent(final LynxCustomEvent lynxCustomEvent) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.5
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "SendCustomEvent failed since mNativePtr is null");
                    return;
                }
                ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(lynxCustomEvent.eventParams());
                int position = encodeMessage == null ? 0 : encodeMessage.position();
                String paramsName = lynxCustomEvent.paramsName();
                LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                lynxEngineProxy.nativeSendCustomEvent(lynxEngineProxy.mNativePtr, lynxCustomEvent.getName(), lynxCustomEvent.getTag(), encodeMessage, position, paramsName);
            }
        });
    }

    public void sendGestureEvent(final String str, final int i, final int i2, final ByteBuffer byteBuffer, final int i3) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.6
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "sendGestureEvent failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeSendGestureEvent(lynxEngineProxy.mNativePtr, str, i, i2, byteBuffer, i3);
                }
            }
        });
    }

    public void onPseudoStatusChanged(final int i, final int i2, final int i3) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.7
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "OnPseudoStatusChanged failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeOnPseudoStatusChanged(lynxEngineProxy.mNativePtr, i, i2, i3);
                }
            }
        });
    }

    public void invokeLepusApiCallback(final int i, final String str, final Object obj) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.8
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "invokeLepusApiCallback failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeInvokeLepusApiCallback(lynxEngineProxy.mNativePtr, i, str, obj);
                }
            }
        });
    }

    public void startEventGenerate(final LynxEvent lynxEvent) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.9
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "startEventGenerate failed since mNativePtr is null");
                    return;
                }
                ByteBuffer encodeMessage = LepusBuffer.INSTANCE.encodeMessage(lynxEvent.getEventParams());
                int position = encodeMessage == null ? 0 : encodeMessage.position();
                LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                lynxEngineProxy.nativeStartEventGenerate(lynxEngineProxy.mNativePtr, encodeMessage, position);
            }
        });
    }

    public void startEventCapture(final long j) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.10
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "startEventCapture failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeStartEventCapture(lynxEngineProxy.mNativePtr, j);
                }
            }
        });
    }

    public void startEventBubble(final long j) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.11
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "startEventBubble failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeStartEventBubble(lynxEngineProxy.mNativePtr, j);
                }
            }
        });
    }

    public void startEventFire(final boolean z, final long j) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.core.LynxEngineProxy.12
            @Override // java.lang.Runnable
            public void run() {
                if (LynxEngineProxy.this.mNativePtr == 0) {
                    LLog.e(LynxEngineProxy.TAG, "startEventFire failed since mNativePtr is null");
                } else {
                    LynxEngineProxy lynxEngineProxy = LynxEngineProxy.this;
                    lynxEngineProxy.nativeStartEventFire(lynxEngineProxy.mNativePtr, z, j);
                }
            }
        });
    }

    private static void executeRunnable(Runnable runnable) {
        runnable.run();
    }
}
