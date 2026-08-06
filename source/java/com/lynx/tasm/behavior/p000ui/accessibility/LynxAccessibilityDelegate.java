package com.lynx.tasm.behavior.p000ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewParentCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxNodeProvider;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAccessibilityDelegate extends AccessibilityDelegateCompat {
    public static final boolean DEBUG = false;
    public static final int HOST_NODE_ID = -1;
    public static final int INVALID_NODE_ID = Integer.MIN_VALUE;
    public static final String TAG = "LynxA11yDelegate";
    private final AccessibilityManager mAccessibilityManager;
    private LynxBaseUI mFocusedUI;
    private final UIGroup mHostUI;
    private final View mHostView;
    private LynxNodeProvider mNodeProvider;
    private int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualId = Integer.MIN_VALUE;
    protected boolean mEnableAccessibilityElement = true;

    public LynxAccessibilityDelegate(UIGroup uIGroup) {
        if (uIGroup == null || uIGroup.getAccessibilityHostView() == null) {
            throw new IllegalArgumentException("host ui or host view is null");
        }
        this.mHostUI = uIGroup;
        View accessibilityHostView = uIGroup.getAccessibilityHostView();
        this.mHostView = accessibilityHostView;
        this.mAccessibilityManager = (AccessibilityManager) uIGroup.getLynxContext().getSystemService("accessibility");
        this.mNodeProvider = new LynxNodeProvider(this);
        accessibilityHostView.setFocusable(true);
        if (ViewCompat.getImportantForAccessibility(accessibilityHostView) == 0) {
            ViewCompat.setImportantForAccessibility(accessibilityHostView, 1);
        }
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new LynxNodeProvider(this);
        }
        return this.mNodeProvider;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!isSystemAccessibilityEnable()) {
            return false;
        }
        EventTarget hitTest = this.mHostUI.hitTest((int) motionEvent.getX(), (int) motionEvent.getY());
        while (hitTest != null && !(hitTest instanceof LynxBaseUI)) {
            hitTest = hitTest.parent();
        }
        if (hitTest == null || !(hitTest instanceof LynxBaseUI)) {
            return false;
        }
        LynxBaseUI lynxBaseUI = (LynxBaseUI) hitTest;
        while (!this.mNodeProvider.isAccessibilityElement(lynxBaseUI)) {
            lynxBaseUI = lynxBaseUI.getParentBaseUI();
            if (lynxBaseUI == null) {
                return false;
            }
        }
        int findVirtualViewIdByUi = this.mNodeProvider.findVirtualViewIdByUi(lynxBaseUI);
        if (findVirtualViewIdByUi == -1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 9) {
            if (action != 10) {
                return false;
            }
            if (this.mHoveredVirtualId != Integer.MIN_VALUE) {
                updateHoveredVirtualView(Integer.MIN_VALUE);
            }
            return true;
        }
        if (this.mHoveredVirtualId != findVirtualViewIdByUi) {
            sendEventForVirtualView(findVirtualViewIdByUi, 128);
            sendEventForVirtualView(this.mHoveredVirtualId, 256);
            this.mHoveredVirtualId = findVirtualViewIdByUi;
        }
        return true;
    }

    private void updateHoveredVirtualView(int i) {
        if (this.mHoveredVirtualId == i) {
            return;
        }
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(this.mHoveredVirtualId, 256);
        this.mHoveredVirtualId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean performActionForHost(int i, Bundle bundle) {
        return ViewCompat.performAccessibilityAction(this.mHostView, i, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean performActionForChild(int i, LynxBaseUI lynxBaseUI, int i2, Bundle bundle) {
        if (i2 == 16) {
            return fireActionClick(i);
        }
        if (i2 == 64) {
            return requestAccessibilityFocus(i);
        }
        if (i2 == 128) {
            return clearAccessibilityFocus(i);
        }
        if (i2 != 16908342) {
            return false;
        }
        return requestUIRectOnScreen(lynxBaseUI, true, i2, bundle);
    }

    private boolean fireActionClick(int i) {
        LynxNodeProvider.LynxCustomNodeInfo lynxCustomNodeInfo;
        LynxBaseUI lynxBaseUI;
        if (i < 0 || (lynxBaseUI = (lynxCustomNodeInfo = this.mNodeProvider.mVirtualChildren.get(i)).mUI) == null || lynxBaseUI.getLynxContext() == null || lynxBaseUI.getLynxContext().getEventEmitter() == null || !lynxBaseUI.getAccessibilityEnableTap()) {
            return false;
        }
        Rect rect = lynxCustomNodeInfo.mRectOnScreen;
        LynxTouchEvent.Point point = new LynxTouchEvent.Point(rect.centerX(), rect.centerY());
        LynxTouchEvent.Point point2 = new LynxTouchEvent.Point(rect.centerX() - rect.left, rect.centerY() - rect.top);
        if (lynxBaseUI.getEvents() == null) {
            return true;
        }
        Map<String, EventsListener> events = lynxBaseUI.getEvents();
        if (events.containsKey(LynxTouchEvent.EVENT_TAP)) {
            lynxBaseUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxBaseUI.getSign(), LynxTouchEvent.EVENT_TAP, point2, point2, point));
        }
        if (!events.containsKey(LynxTouchEvent.EVENT_CLICK)) {
            return true;
        }
        lynxBaseUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxBaseUI.getSign(), LynxTouchEvent.EVENT_CLICK, point2, point2, point));
        return true;
    }

    private boolean requestUIRectOnScreen(LynxBaseUI lynxBaseUI, boolean z, int i, Bundle bundle) {
        boolean z2 = false;
        if (lynxBaseUI == null) {
            return false;
        }
        if (lynxBaseUI instanceof LynxUI) {
            return ((LynxUI) lynxBaseUI).getView().performAccessibilityAction(i, bundle);
        }
        if (lynxBaseUI instanceof LynxFlattenUI) {
            LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
            Rect rect = new Rect(0, 0, lynxBaseUI.getWidth(), lynxBaseUI.getHeight());
            Rect rect2 = new Rect();
            while (true) {
                LynxBaseUI lynxBaseUI2 = parentBaseUI;
                LynxBaseUI lynxBaseUI3 = lynxBaseUI;
                lynxBaseUI = lynxBaseUI2;
                if (lynxBaseUI == null || lynxBaseUI == this.mHostUI) {
                    break;
                }
                rect2.set(rect);
                z2 |= lynxBaseUI.requestChildUIRectangleOnScreen(lynxBaseUI3, rect2, z);
                rect.offset(lynxBaseUI3.getOriginLeft() - lynxBaseUI3.getScrollX(), lynxBaseUI3.getOriginTop() - lynxBaseUI3.getScrollY());
                parentBaseUI = lynxBaseUI.getParentBaseUI();
            }
        }
        return z2;
    }

    public boolean requestAccessibilityFocus(LynxBaseUI lynxBaseUI) {
        int findVirtualViewIdByUi;
        if (lynxBaseUI == null || !isSystemAccessibilityEnable() || !this.mNodeProvider.isAccessibilityElement(lynxBaseUI) || (findVirtualViewIdByUi = this.mNodeProvider.findVirtualViewIdByUi(lynxBaseUI)) == -1) {
            return false;
        }
        return requestAccessibilityFocus(findVirtualViewIdByUi);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (!isSystemAccessibilityEnable() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mFocusedUI = this.mNodeProvider.mVirtualChildren.get(this.mAccessibilityFocusedVirtualViewId).mUI;
        this.mHostView.invalidate();
        sendEventForVirtualView(i, 32768);
        LynxAccessibilityWrapper lynxAccessibilityWrapper = getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper == null) {
            return true;
        }
        lynxAccessibilityWrapper.onAccessibilityFocused(this.mAccessibilityFocusedVirtualViewId, this.mFocusedUI);
        return true;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHostView.invalidate();
        this.mFocusedUI = null;
        sendEventForVirtualView(i, 65536);
        return true;
    }

    private final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !isSystemAccessibilityEnable() || (parent = this.mHostView.getParent()) == null) {
            return false;
        }
        return ViewParentCompat.requestSendAccessibilityEvent(parent, this.mHostView, createEvent(i, i2));
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i == -1) {
            return createEventForHost(i2);
        }
        return createEventForChild(i, i2);
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHostView.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        AccessibilityNodeInfoCompat createNodeForChild = this.mNodeProvider.createNodeForChild(i);
        if (createNodeForChild != null) {
            obtain.getText().add(createNodeForChild.getText());
            obtain.setContentDescription(createNodeForChild.getContentDescription());
            obtain.setScrollable(createNodeForChild.isScrollable());
            obtain.setPassword(createNodeForChild.isPassword());
            obtain.setEnabled(createNodeForChild.isEnabled());
            obtain.setChecked(createNodeForChild.isChecked());
            obtain.setClassName(createNodeForChild.getClassName());
        }
        AccessibilityRecordCompat.setSource(obtain, this.mHostView, i);
        obtain.setPackageName(this.mHostView.getContext().getPackageName());
        return obtain;
    }

    private boolean isSystemAccessibilityEnable() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            return lynxAccessibilityWrapper.isSystemAccessibilityEnable();
        }
        return false;
    }

    private LynxAccessibilityWrapper getLynxAccessibilityWrapper() {
        UIGroup uIGroup = this.mHostUI;
        if (uIGroup == null || uIGroup.getLynxContext() == null) {
            return null;
        }
        return this.mHostUI.getLynxContext().getLynxAccessibilityWrapper();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UIGroup getHostUI() {
        return this.mHostUI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getHostView() {
        return this.mHostView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LynxBaseUI getFocusedUI() {
        return this.mFocusedUI;
    }

    public void setConfigEnableAccessibilityElement(boolean z) {
        this.mEnableAccessibilityElement = z;
    }
}
