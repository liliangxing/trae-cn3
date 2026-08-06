package com.lynx.tasm.behavior.ui.accessibility;

import android.view.accessibility.AccessibilityManager;
import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* loaded from: classes7.dex */
public class LynxAccessibilityStateHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "LynxAccessibilityStateHelper";
    private AccessibilityManager mAccessibilityManager;
    private LynxAccessibilityStateChangeListener mLynxAccessibilityStateChangeListener;
    private LynxTouchExplorationStateChangeListener mLynxTouchExplorationStateChangeListener;

    /* loaded from: classes7.dex */
    public interface OnStateListener {
        void onAccessibilityEnable(boolean z);

        void onTouchExplorationEnable(boolean z);
    }

    public LynxAccessibilityStateHelper(AccessibilityManager accessibilityManager, OnStateListener onStateListener) {
        this.mAccessibilityManager = null;
        this.mLynxAccessibilityStateChangeListener = null;
        this.mLynxTouchExplorationStateChangeListener = null;
        if (accessibilityManager == null || onStateListener == null) {
            return;
        }
        this.mAccessibilityManager = accessibilityManager;
        boolean isEnabled = accessibilityManager.isEnabled();
        boolean isTouchExplorationEnabled = this.mAccessibilityManager.isTouchExplorationEnabled();
        onStateListener.onAccessibilityEnable(isEnabled);
        onStateListener.onTouchExplorationEnable(isTouchExplorationEnabled);
        LynxAccessibilityStateChangeListener lynxAccessibilityStateChangeListener = new LynxAccessibilityStateChangeListener(onStateListener);
        this.mLynxAccessibilityStateChangeListener = lynxAccessibilityStateChangeListener;
        this.mAccessibilityManager.addAccessibilityStateChangeListener(lynxAccessibilityStateChangeListener);
        LynxTouchExplorationStateChangeListener lynxTouchExplorationStateChangeListener = new LynxTouchExplorationStateChangeListener(onStateListener);
        this.mLynxTouchExplorationStateChangeListener = lynxTouchExplorationStateChangeListener;
        this.mAccessibilityManager.addTouchExplorationStateChangeListener(lynxTouchExplorationStateChangeListener);
    }

    public void removeAllListeners() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        if (accessibilityManager != null) {
            LynxAccessibilityStateChangeListener lynxAccessibilityStateChangeListener = this.mLynxAccessibilityStateChangeListener;
            if (lynxAccessibilityStateChangeListener != null) {
                accessibilityManager.removeAccessibilityStateChangeListener(lynxAccessibilityStateChangeListener);
            }
            LynxTouchExplorationStateChangeListener lynxTouchExplorationStateChangeListener = this.mLynxTouchExplorationStateChangeListener;
            if (lynxTouchExplorationStateChangeListener != null) {
                this.mAccessibilityManager.removeTouchExplorationStateChangeListener(lynxTouchExplorationStateChangeListener);
            }
        }
    }

    /* loaded from: classes7.dex */
    private static class LynxAccessibilityStateChangeListener implements AccessibilityManager.AccessibilityStateChangeListener {
        private WeakReference<OnStateListener> mStateListenerRef;

        public LynxAccessibilityStateChangeListener(OnStateListener onStateListener) {
            this.mStateListenerRef = new WeakReference<>(onStateListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            LLog.i(LynxAccessibilityStateHelper.TAG, "onAccessibilityStateChanged: " + z);
            WeakReference<OnStateListener> weakReference = this.mStateListenerRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mStateListenerRef.get().onAccessibilityEnable(z);
        }
    }

    /* loaded from: classes7.dex */
    private static class LynxTouchExplorationStateChangeListener implements AccessibilityManager.TouchExplorationStateChangeListener {
        private WeakReference<OnStateListener> mStateListenerRef;

        public LynxTouchExplorationStateChangeListener(OnStateListener onStateListener) {
            this.mStateListenerRef = new WeakReference<>(onStateListener);
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            LLog.i(LynxAccessibilityStateHelper.TAG, "onTouchExplorationStateChanged: " + z);
            WeakReference<OnStateListener> weakReference = this.mStateListenerRef;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.mStateListenerRef.get().onTouchExplorationEnable(z);
        }
    }
}
