package com.lynx.tasm.behavior.p000ui;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.event.LynxTouchEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAccessibilityNodeProvider extends AccessibilityNodeProvider {
    private static String TAG = "LynxAccessibilityNodeProvider";
    private final AccessibilityManager mAccessibilityManager;
    private final UIGroup mHost;
    private final View mHostView;
    private LynxAccessibilityNodeInfo mLastHoveredChild;
    private int mPixelPerSection;
    private boolean mSendingHoverAccessibilityEvents;
    private final int SECTION_COUNT = 50;
    private final ArrayList<LynxAccessibilityNodeInfo> mChildren = new ArrayList<>();
    private boolean mHasHierarchyElement = false;
    boolean mEnableAccessibilityElement = true;
    boolean mEnableOverlapForAccessibilityElement = true;

    public LynxAccessibilityNodeProvider(UIGroup uIGroup) {
        this.mHost = uIGroup;
        this.mHostView = uIGroup.getRealParentView();
        this.mAccessibilityManager = (AccessibilityManager) uIGroup.mContext.getSystemService("accessibility");
        this.mPixelPerSection = uIGroup.getLynxContext().getScreenMetrics().heightPixels / 50;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
        LLog.i(TAG, "createAccessibilityNodeInfo: " + i);
        if (i == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.mHostView);
            findAllAccessibilityNodeOfLynx();
            this.mHostView.onInitializeAccessibilityNodeInfo(obtain);
            for (int i2 = 0; i2 < this.mChildren.size(); i2++) {
                obtain.addChild(this.mHostView, i2);
            }
            Rect rect = new Rect();
            getLeftAndTopOfBoundsInScreen(this.mHostView, rect);
            rect.set(rect.left, rect.top, rect.left + this.mHost.getWidth(), rect.top + this.mHost.getHeight());
            return obtain;
        }
        if (i < 0 || i >= this.mChildren.size()) {
            return null;
        }
        LynxAccessibilityNodeInfo lynxAccessibilityNodeInfo = this.mChildren.get(i);
        AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(this.mHostView, i);
        this.mHostView.onInitializeAccessibilityNodeInfo(obtain2);
        if (lynxAccessibilityNodeInfo.mUI != null) {
            lynxAccessibilityNodeInfo.mRectOnScreen = getBoundsOnScreenOfLynxBaseUI(lynxAccessibilityNodeInfo.mUI);
            obtain2.setBoundsInScreen(lynxAccessibilityNodeInfo.mRectOnScreen);
            obtain2.setClassName(lynxAccessibilityNodeInfo.mUI.getClass().getName());
            String accessibilityLabelWithChild = getAccessibilityLabelWithChild(lynxAccessibilityNodeInfo.mUI);
            obtain2.setContentDescription(accessibilityLabelWithChild);
            obtain2.setText(accessibilityLabelWithChild);
            obtain2.setScrollable(lynxAccessibilityNodeInfo.mUI.isScrollable());
            obtain2.setLongClickable(lynxAccessibilityNodeInfo.mUI.isLongClickable());
            obtain2.setFocusable(lynxAccessibilityNodeInfo.mUI.isFocusable());
            obtain2.setClickable(isUIClickable(lynxAccessibilityNodeInfo.mUI));
            LLog.i(TAG, "Label for UI: " + i + ", " + accessibilityLabelWithChild);
            if (lynxAccessibilityNodeInfo.mUI.getAccessibilityEnableTap() && isUIClickable(lynxAccessibilityNodeInfo.mUI)) {
                obtain2.addAction(16);
            }
        } else if (lynxAccessibilityNodeInfo.mView != null && ViewCompat.isAttachedToWindow(lynxAccessibilityNodeInfo.mView)) {
            lynxAccessibilityNodeInfo.mView.onInitializeAccessibilityNodeInfo(obtain2);
            obtain2.setSource(this.mHostView, i);
        }
        obtain2.setParent(this.mHostView);
        obtain2.addAction(this.mLastHoveredChild != lynxAccessibilityNodeInfo ? 64 : 128);
        obtain2.setAccessibilityFocused(this.mLastHoveredChild == lynxAccessibilityNodeInfo);
        obtain2.setFocused(this.mLastHoveredChild == lynxAccessibilityNodeInfo);
        obtain2.addAction(4096);
        obtain2.addAction(8192);
        obtain2.setVisibleToUser(true);
        return obtain2;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
        LynxBaseUI lynxBaseUI;
        String accessibilityLabel;
        String accessibilityLabel2;
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String lowerCase = str.toLowerCase();
        if (i == -1) {
            for (int i2 = 0; i2 < this.mChildren.size(); i2++) {
                if (this.mChildren.get(i2).mUI != null && (accessibilityLabel2 = getAccessibilityLabel(this.mChildren.get(i2).mUI)) != null && accessibilityLabel2.toString().toLowerCase().contains(lowerCase)) {
                    arrayList.add(createAccessibilityNodeInfo(i2));
                }
            }
        } else if (i > 0 && i < this.mChildren.size() && (lynxBaseUI = this.mChildren.get(i).mUI) != null && (accessibilityLabel = getAccessibilityLabel(lynxBaseUI)) != null && accessibilityLabel.toString().toLowerCase().contains(lowerCase)) {
            arrayList.add(createAccessibilityNodeInfo(i));
        }
        return arrayList;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i, int i2, Bundle bundle) {
        LynxAccessibilityNodeInfo lynxAccessibilityNodeInfo;
        LynxBaseUI lynxBaseUI;
        LLog.i(TAG, "performAction on virtualViewId " + i + " action " + i2);
        if (i != -1 && i >= 0 && i < this.mChildren.size()) {
            if (i2 != 16) {
                if (i2 == 64) {
                    sendAccessibilityEventForLynxUI(i, 32768);
                    sendAccessibilityEventForLynxUI(i, 4);
                    return true;
                }
                if (i2 == 128) {
                    sendAccessibilityEventForLynxUI(i, 65536);
                    return true;
                }
            } else if (i >= 0 && (lynxBaseUI = (lynxAccessibilityNodeInfo = this.mChildren.get(i)).mUI) != null && lynxBaseUI.getLynxContext() != null && lynxBaseUI.getLynxContext().getEventEmitter() != null && lynxBaseUI.getAccessibilityEnableTap()) {
                Rect rect = lynxAccessibilityNodeInfo.mRectOnScreen;
                LynxTouchEvent.Point point = new LynxTouchEvent.Point(rect.centerX(), rect.centerY());
                LynxTouchEvent.Point point2 = new LynxTouchEvent.Point(rect.centerX() - rect.left, rect.centerY() - rect.top);
                if (lynxBaseUI.mEvents != null) {
                    if (lynxBaseUI.mEvents.containsKey(LynxTouchEvent.EVENT_TAP)) {
                        lynxBaseUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxBaseUI.getSign(), LynxTouchEvent.EVENT_TAP, point2, point2, point));
                    } else if (lynxBaseUI.mEvents.containsKey(LynxTouchEvent.EVENT_CLICK)) {
                        lynxBaseUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxBaseUI.getSign(), LynxTouchEvent.EVENT_CLICK, point2, point2, point));
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean onHover(View view, MotionEvent motionEvent) {
        EventTarget hitTest = this.mHost.hitTest((int) motionEvent.getX(), (int) motionEvent.getY());
        LLog.i(TAG, "onHover with target = " + hitTest + " event: [" + ((int) motionEvent.getX()) + ", " + ((int) motionEvent.getY()) + "]");
        while (hitTest != null && !(hitTest instanceof LynxBaseUI)) {
            hitTest = hitTest.parent();
        }
        if (hitTest == null || !(hitTest instanceof LynxBaseUI)) {
            return false;
        }
        LynxBaseUI lynxBaseUI = (LynxBaseUI) hitTest;
        while (!isAccessibilityElement(lynxBaseUI)) {
            lynxBaseUI = lynxBaseUI.getParentBaseUI();
            if (lynxBaseUI == null) {
                return false;
            }
        }
        int size = this.mChildren.size() - 1;
        while (true) {
            if (size < 0) {
                size = -1;
                break;
            }
            if (this.mChildren.get(size).mUI == lynxBaseUI) {
                break;
            }
            size--;
        }
        Rect rect = new Rect();
        getLeftAndTopOfBoundsInScreen(this.mHostView, rect);
        int x = ((int) motionEvent.getX()) + rect.left;
        int y = ((int) motionEvent.getY()) + rect.top;
        int size2 = this.mChildren.size() - 1;
        while (true) {
            if (size2 < size || size2 < 0) {
                break;
            }
            if (this.mChildren.get(size2).mRectOnScreen.contains(x, y)) {
                size = size2;
                break;
            }
            size2--;
        }
        if (size < 0) {
            return false;
        }
        LLog.i(TAG, "onHover confirm virtualViewId = " + size);
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 9) {
                motionEvent.setAction(9);
                onHoverLynxUI(size, motionEvent);
                this.mLastHoveredChild = null;
            } else if (action == 10) {
                this.mLastHoveredChild = null;
                onHoverLynxUI(size, motionEvent);
            }
        } else if (this.mLastHoveredChild == null) {
            onHoverLynxUI(size, motionEvent);
        } else {
            motionEvent.setAction(9);
            onHoverLynxUI(size, motionEvent);
            this.mLastHoveredChild = null;
        }
        return true;
    }

    private void onHoverLynxUI(int i, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mSendingHoverAccessibilityEvents) {
            if (action == 10 || action == 7) {
                this.mSendingHoverAccessibilityEvents = false;
                sendAccessibilityEventForLynxUI(i, 256);
            }
        } else if (action == 9 || action == 7) {
            sendAccessibilityEventForLynxUI(i, 128);
            this.mSendingHoverAccessibilityEvents = true;
        }
        if (action == 9) {
            this.mHostView.setHovered(true);
        } else {
            if (action != 10) {
                return;
            }
            this.mHostView.setHovered(false);
        }
    }

    private void sendAccessibilityEventForLynxUI(int i, int i2) {
        if (this.mAccessibilityManager.isTouchExplorationEnabled()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
            if (i >= 0) {
                LynxAccessibilityNodeInfo lynxAccessibilityNodeInfo = this.mChildren.get(i);
                if (lynxAccessibilityNodeInfo.mUI != null) {
                    obtain.setPackageName(this.mHostView.getContext().getPackageName());
                    obtain.setClassName(lynxAccessibilityNodeInfo.mUI.getClass().getName());
                    obtain.setEnabled(true);
                    obtain.setContentDescription(getAccessibilityLabelWithChild(lynxAccessibilityNodeInfo.mUI));
                } else if (lynxAccessibilityNodeInfo.mView == null) {
                    return;
                } else {
                    lynxAccessibilityNodeInfo.mView.onInitializeAccessibilityEvent(obtain);
                }
                obtain.setSource(this.mHostView, i);
                this.mHostView.invalidate();
                if (this.mHostView.getParent() == null) {
                    LLog.e(TAG, "sendAccessibilityEventForLynxUI failed, parent is null.");
                } else {
                    this.mHostView.getParent().requestSendAccessibilityEvent(this.mHostView, obtain);
                }
            }
        }
    }

    private void findAllAccessibilityNodeOfLynxDeep(LynxBaseUI lynxBaseUI, List<Rect> list) {
        boolean z = true;
        if (lynxBaseUI.getAccessibilityElements() != null) {
            LynxAccessibilityNodeInfo lynxAccessibilityNodeInfo = new LynxAccessibilityNodeInfo(lynxBaseUI, getBoundsOnScreenOfLynxBaseUI(lynxBaseUI));
            lynxAccessibilityNodeInfo.mIsHierarchy = true;
            this.mChildren.add(lynxAccessibilityNodeInfo);
            this.mHasHierarchyElement = true;
            return;
        }
        for (int size = lynxBaseUI.getChildren().size() - 1; size >= 0; size--) {
            LynxBaseUI lynxBaseUI2 = lynxBaseUI.getChildren().get(size);
            if ((!(lynxBaseUI2 instanceof LynxUI) || ViewCompat.isAttachedToWindow(((LynxUI) lynxBaseUI2).getView())) && !(lynxBaseUI2 instanceof LynxViewVisibleHelper)) {
                findAllAccessibilityNodeOfLynxDeep(lynxBaseUI2, list);
            }
        }
        if (lynxBaseUI != this.mHost) {
            if (lynxBaseUI instanceof UIShadowProxy) {
                lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
            }
            if (isAccessibilityElement(lynxBaseUI)) {
                Rect boundsOnScreenOfLynxBaseUI = getBoundsOnScreenOfLynxBaseUI(lynxBaseUI);
                if (!this.mEnableOverlapForAccessibilityElement) {
                    Iterator<Rect> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().contains(boundsOnScreenOfLynxBaseUI)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.mChildren.add(new LynxAccessibilityNodeInfo(lynxBaseUI, boundsOnScreenOfLynxBaseUI));
                    }
                    list.add(boundsOnScreenOfLynxBaseUI);
                } else {
                    this.mChildren.add(new LynxAccessibilityNodeInfo(lynxBaseUI, boundsOnScreenOfLynxBaseUI));
                }
            }
            if ((lynxBaseUI instanceof LynxUI) && lynxBaseUI.mChildren.isEmpty()) {
                LynxUI lynxUI = (LynxUI) lynxBaseUI;
                if (lynxUI.getView() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) lynxUI.getView();
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        findAllAccessibilityNodeOfViews(viewGroup.getChildAt(i));
                    }
                }
            }
        }
    }

    private void findAllAccessibilityNodeOfHierarchy() {
        ArrayList arrayList = new ArrayList();
        Iterator<LynxAccessibilityNodeInfo> it = this.mChildren.iterator();
        while (it.hasNext()) {
            LynxAccessibilityNodeInfo next = it.next();
            if (next.mUI != null && next.mIsHierarchy) {
                ArrayList<String> accessibilityElements = next.mUI.getAccessibilityElements();
                if (accessibilityElements != null && this.mHost.getLynxContext() != null && this.mHost.getLynxContext().getLynxUIOwner() != null) {
                    LynxUIOwner lynxUIOwner = this.mHost.getLynxContext().getLynxUIOwner();
                    Iterator<String> it2 = accessibilityElements.iterator();
                    while (it2.hasNext()) {
                        LynxBaseUI findLynxUIByIdSelector = lynxUIOwner.findLynxUIByIdSelector(it2.next());
                        if (findLynxUIByIdSelector != null && (!(findLynxUIByIdSelector instanceof LynxUI) || ViewCompat.isAttachedToWindow(((LynxUI) findLynxUIByIdSelector).getView()))) {
                            if (findLynxUIByIdSelector instanceof UIShadowProxy) {
                                findLynxUIByIdSelector = ((UIShadowProxy) findLynxUIByIdSelector).getChild();
                            }
                            if (isAccessibilityElement(findLynxUIByIdSelector)) {
                                arrayList.add(new LynxAccessibilityNodeInfo(findLynxUIByIdSelector, getBoundsOnScreenOfLynxBaseUI(findLynxUIByIdSelector)));
                            }
                        }
                    }
                }
            } else {
                arrayList.add(next);
            }
        }
        this.mChildren.clear();
        this.mChildren.addAll(arrayList);
    }

    private void findAllAccessibilityNodeOfLynx() {
        this.mChildren.clear();
        findAllAccessibilityNodeOfLynxDeep(this.mHost, new ArrayList());
        Collections.sort(this.mChildren, new Comparator() { // from class: com.lynx.tasm.behavior.ui.LynxAccessibilityNodeProvider.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                int i;
                int i2;
                Rect rect = ((LynxAccessibilityNodeInfo) obj).mRectOnScreen;
                Rect rect2 = ((LynxAccessibilityNodeInfo) obj2).mRectOnScreen;
                if (LynxAccessibilityNodeProvider.this.mPixelPerSection == 0) {
                    i = rect.top;
                    i2 = rect2.top;
                } else {
                    i = rect.top / LynxAccessibilityNodeProvider.this.mPixelPerSection;
                    i2 = rect2.top / LynxAccessibilityNodeProvider.this.mPixelPerSection;
                }
                int i3 = i - i2;
                return i3 == 0 ? rect.left - rect2.left : i3;
            }
        });
        if (this.mHasHierarchyElement) {
            findAllAccessibilityNodeOfHierarchy();
            this.mHasHierarchyElement = false;
        }
    }

    private void findAllAccessibilityNodeOfViews(View view) {
        boolean z = true;
        boolean z2 = view.getVisibility() == 0;
        if (view.getImportantForAccessibility() != 1 && (view.getImportantForAccessibility() == 2 || TextUtils.isEmpty(view.getContentDescription()))) {
            z = false;
        }
        if (z2 && z) {
            Rect rect = new Rect();
            getLeftAndTopOfBoundsInScreen(view, rect);
            this.mChildren.add(new LynxAccessibilityNodeInfo(view, rect));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                findAllAccessibilityNodeOfViews(viewGroup.getChildAt(i));
            }
        }
    }

    private static void getLeftAndTopOfBoundsInScreen(View view, Rect rect) {
        rect.set(0, 0, view.getRight() - view.getLeft(), view.getBottom() - view.getTop());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
    }

    private Rect getBoundsOnScreenOfLynxBaseUI(LynxBaseUI lynxBaseUI) {
        Rect rect = new Rect();
        if (lynxBaseUI instanceof LynxUI) {
            View view = ((LynxUI) lynxBaseUI).getView();
            if (lynxBaseUI instanceof UIShadowProxy) {
                LynxBaseUI child = ((UIShadowProxy) lynxBaseUI).getChild();
                if (child instanceof LynxUI) {
                    view = ((LynxUI) child).getView();
                }
            }
            getLeftAndTopOfBoundsInScreen(view, rect);
            rect.set(rect.left, rect.top, rect.left + lynxBaseUI.getWidth(), rect.top + lynxBaseUI.getHeight());
        } else if (lynxBaseUI instanceof LynxFlattenUI) {
            LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
            while (parentBaseUI != null && !(parentBaseUI instanceof LynxUI)) {
                parentBaseUI = parentBaseUI.getParentBaseUI();
            }
            if (parentBaseUI != null) {
                View view2 = ((LynxUI) parentBaseUI).getView();
                if (parentBaseUI instanceof UIGroup) {
                    view2 = ((UIGroup) parentBaseUI).getRealParentView();
                }
                getLeftAndTopOfBoundsInScreen(view2, rect);
                rect.offset(-view2.getScrollX(), -view2.getScrollY());
                rect.offset(lynxBaseUI.getLeft(), lynxBaseUI.getTop());
                rect.set(rect.left, rect.top, rect.left + lynxBaseUI.getWidth(), rect.top + lynxBaseUI.getHeight());
            }
        }
        return rect;
    }

    private static String getAccessibilityLabel(LynxBaseUI lynxBaseUI) {
        CharSequence accessibilityLabel = lynxBaseUI.getAccessibilityLabel();
        if (accessibilityLabel == null) {
            accessibilityLabel = "";
        }
        return accessibilityLabel.toString();
    }

    private String getAccessibilityLabelWithChild(LynxBaseUI lynxBaseUI) {
        if (!isAccessibilityElement(lynxBaseUI)) {
            return "";
        }
        String accessibilityLabel = getAccessibilityLabel(lynxBaseUI);
        if (TextUtils.isEmpty(accessibilityLabel)) {
            Iterator<LynxBaseUI> it = lynxBaseUI.mChildren.iterator();
            while (it.hasNext()) {
                accessibilityLabel = ((Object) accessibilityLabel) + getAccessibilityLabel(it.next());
            }
        }
        return accessibilityLabel.toString();
    }

    private boolean isUIClickable(LynxBaseUI lynxBaseUI) {
        return (lynxBaseUI == null || lynxBaseUI.mEvents == null || (!lynxBaseUI.mEvents.containsKey(LynxTouchEvent.EVENT_CLICK) && !lynxBaseUI.mEvents.containsKey(LynxTouchEvent.EVENT_TAP))) ? false : true;
    }

    private boolean isAccessibilityElement(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null) {
            return false;
        }
        if (lynxBaseUI.getAccessibilityElementStatus() == -1) {
            return this.mEnableAccessibilityElement;
        }
        return lynxBaseUI.getAccessibilityElementStatus() == 1;
    }

    public void setConfigEnableAccessibilityElement(boolean z) {
        this.mEnableAccessibilityElement = z;
    }

    public void setConfigEnableOverlapForAccessibilityElement(boolean z) {
        this.mEnableOverlapForAccessibilityElement = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxAccessibilityNodeInfo {
        boolean mIsHierarchy;
        Rect mRectOnScreen;
        LynxBaseUI mUI;
        View mView;

        public LynxAccessibilityNodeInfo(LynxBaseUI lynxBaseUI, Rect rect) {
            this.mUI = lynxBaseUI;
            this.mView = null;
            this.mRectOnScreen = rect;
        }

        public LynxAccessibilityNodeInfo(View view, Rect rect) {
            this.mUI = null;
            this.mView = view;
            this.mRectOnScreen = rect;
        }
    }
}
