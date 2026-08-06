package com.lynx.tasm.behavior.p000ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.LynxViewVisibleHelper;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxNodeProvider extends AccessibilityNodeProviderCompat {
    public static final int SECTION_COUNT = 50;
    private static final String TAG = "LynxA11yNodeProvider";
    private WeakReference<LynxAccessibilityDelegate> mDelegateWeakRef;
    private boolean mHasHierarchyElement;
    private UIGroup mHostUI;
    private View mHostView;
    protected ArrayList<LynxCustomNodeInfo> mVirtualChildren;
    private int mXPixelPerSection;
    private int mYPixelPerSection;

    public LynxNodeProvider(LynxAccessibilityDelegate lynxAccessibilityDelegate) {
        if (lynxAccessibilityDelegate != null) {
            LLog.i(TAG, "Create LynxNodeProvider for " + lynxAccessibilityDelegate.getHostUI());
            this.mDelegateWeakRef = new WeakReference<>(lynxAccessibilityDelegate);
            this.mHostUI = lynxAccessibilityDelegate.getHostUI();
            this.mHostView = lynxAccessibilityDelegate.getHostView();
            this.mVirtualChildren = new ArrayList<>();
            this.mXPixelPerSection = this.mHostUI.getLynxContext().getScreenMetrics().widthPixels / 50;
            this.mYPixelPerSection = this.mHostUI.getLynxContext().getScreenMetrics().heightPixels / 50;
        }
    }

    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
        try {
            if (-1 == i) {
                return AccessibilityNodeInfoCompat.obtain(createNodeForHost());
            }
            AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(createNodeForChild(i));
            setImportantForAccessibilityNo(i);
            return obtain;
        } catch (Exception e) {
            LLog.e(TAG, "createAccessibilityNodeInfo with virtual view id = " + i + " with virtual children size = " + this.mVirtualChildren.size() + ", and exception msg = " + e.getMessage());
            return AccessibilityNodeInfoCompat.obtain();
        }
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i < -1 || i >= this.mVirtualChildren.size()) {
            LLog.e(TAG, "performAction: check virtualViewId failed");
            return false;
        }
        WeakReference<LynxAccessibilityDelegate> weakReference = this.mDelegateWeakRef;
        if (weakReference == null || weakReference.get() == null) {
            return false;
        }
        LynxAccessibilityDelegate lynxAccessibilityDelegate = this.mDelegateWeakRef.get();
        if (i == -1) {
            return lynxAccessibilityDelegate.performActionForHost(i2, bundle);
        }
        return lynxAccessibilityDelegate.performActionForChild(i, this.mVirtualChildren.get(i).mUI, i2, bundle);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str, int i) {
        LynxBaseUI lynxBaseUI;
        String accessibilityLabel;
        String accessibilityLabel2;
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        String lowerCase = str.toLowerCase();
        if (i == -1) {
            for (int i2 = 0; i2 < this.mVirtualChildren.size(); i2++) {
                if (this.mVirtualChildren.get(i2).mUI != null && (accessibilityLabel2 = getAccessibilityLabel(this.mVirtualChildren.get(i2).mUI)) != null && accessibilityLabel2.toString().toLowerCase().contains(lowerCase)) {
                    arrayList.add(createAccessibilityNodeInfo(i2));
                }
            }
        } else if (i > -1 && i < this.mVirtualChildren.size() && (lynxBaseUI = this.mVirtualChildren.get(i).mUI) != null && (accessibilityLabel = getAccessibilityLabel(lynxBaseUI)) != null && accessibilityLabel.toString().toLowerCase().contains(lowerCase)) {
            arrayList.add(createAccessibilityNodeInfo(i));
        }
        return arrayList;
    }

    protected AccessibilityNodeInfoCompat createNodeForHost() {
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain(this.mHostView);
        ViewCompat.onInitializeAccessibilityNodeInfo(this.mHostView, obtain);
        findAllAccessibilityNode(this.mHostUI, this.mVirtualChildren);
        if (obtain.getChildCount() > 0 && this.mVirtualChildren.size() > 0) {
            LLog.e(TAG, "Views cannot have both real and virtual children, with real child count = " + obtain.getChildCount() + "and virtual child count = " + this.mVirtualChildren.size());
        }
        LLog.i(TAG, "createNodeForHost with child count = " + this.mVirtualChildren.size());
        for (int i = 0; i < this.mVirtualChildren.size(); i++) {
            obtain.addChild(this.mHostView, i);
        }
        LynxBaseUI focusedUI = this.mDelegateWeakRef.get().getFocusedUI();
        int accessibilityFocusedVirtualViewId = this.mDelegateWeakRef.get().getAccessibilityFocusedVirtualViewId();
        if (focusedUI != null && focusedUI.getAccessibilityKeepFocused() && accessibilityFocusedVirtualViewId != -1) {
            for (int i2 = 0; i2 < this.mVirtualChildren.size(); i2++) {
                LynxBaseUI lynxBaseUI = this.mVirtualChildren.get(i2).mUI;
                if (lynxBaseUI != null && lynxBaseUI == focusedUI && i2 != accessibilityFocusedVirtualViewId && getScreenVisibleRectOfUI(lynxBaseUI, new Rect())) {
                    performAction(i2, 64, null);
                }
            }
        }
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AccessibilityNodeInfoCompat createNodeForChild(int i) {
        View accessibilityHostView;
        AccessibilityNodeInfoCompat obtain = AccessibilityNodeInfoCompat.obtain();
        if (i == -1 || i >= this.mVirtualChildren.size()) {
            LLog.e(TAG, "createNodeForChild: check virtualViewId failed");
            return obtain;
        }
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        obtain.setClassName(this.mHostUI.getClass().getName());
        obtain.setBoundsInParent(LynxAccessibilityWrapper.INVALID_BOUNDS);
        obtain.setBoundsInScreen(LynxAccessibilityWrapper.INVALID_BOUNDS);
        obtain.setParent(this.mHostView);
        obtain.setSource(this.mHostView, i);
        obtain.setPackageName(this.mHostView.getContext().getPackageName());
        LynxCustomNodeInfo lynxCustomNodeInfo = this.mVirtualChildren.get(i);
        if (lynxCustomNodeInfo.mUI != null) {
            LynxBaseUI lynxBaseUI = lynxCustomNodeInfo.mUI;
            while (true) {
                if (lynxBaseUI != null && lynxBaseUI != this.mHostUI) {
                    if ((lynxBaseUI instanceof UIGroup) && lynxBaseUI.isScrollContainer() && (accessibilityHostView = ((UIGroup) lynxBaseUI).getAccessibilityHostView()) != null) {
                        obtain.setParent(accessibilityHostView);
                        break;
                    }
                    lynxBaseUI = (LynxBaseUI) lynxBaseUI.getParent();
                } else {
                    break;
                }
            }
            String accessibilityLabelWithChild = getAccessibilityLabelWithChild(lynxCustomNodeInfo.mUI);
            obtain.setText(accessibilityLabelWithChild);
            obtain.setContentDescription(accessibilityLabelWithChild);
            obtain.setClassName(lynxCustomNodeInfo.mUI.getClass().getName());
            obtain.setClickable(isUIClickable(lynxCustomNodeInfo.mUI));
            if (lynxCustomNodeInfo.mUI.getAccessibilityEnableTap()) {
                obtain.addAction(16);
            }
            obtain.setBoundsInParent(lynxCustomNodeInfo.mUI.getBoundingClientRect());
            Rect rect = new Rect();
            boolean screenVisibleRectOfUI = getScreenVisibleRectOfUI(lynxCustomNodeInfo.mUI, rect);
            obtain.setVisibleToUser(screenVisibleRectOfUI);
            if (screenVisibleRectOfUI) {
                obtain.setBoundsInScreen(rect);
            }
            if (this.mDelegateWeakRef.get().getAccessibilityFocusedVirtualViewId() == i) {
                obtain.setAccessibilityFocused(true);
                obtain.addAction(128);
            } else {
                obtain.setAccessibilityFocused(false);
                obtain.addAction(64);
            }
        }
        return obtain;
    }

    private void setImportantForAccessibilityNo(int i) {
        LynxCustomNodeInfo lynxCustomNodeInfo;
        if (i == -1 || i >= this.mVirtualChildren.size() || (lynxCustomNodeInfo = this.mVirtualChildren.get(i)) == null || !(lynxCustomNodeInfo.mUI instanceof LynxUI) || ((LynxUI) lynxCustomNodeInfo.mUI).getView() == null) {
            return;
        }
        ViewCompat.setImportantForAccessibility(((LynxUI) lynxCustomNodeInfo.mUI).getView(), 2);
    }

    private void findAllAccessibilityNode(final LynxBaseUI lynxBaseUI, ArrayList<LynxCustomNodeInfo> arrayList) {
        if (lynxBaseUI == null || arrayList == null) {
            return;
        }
        arrayList.clear();
        findAllAccessibilityNodeOfLynxDeepInternal(lynxBaseUI, arrayList);
        Collections.sort(arrayList, new Comparator() { // from class: com.lynx.tasm.behavior.ui.accessibility.LynxNodeProvider.1
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                int i;
                int i2;
                int i3;
                Rect rect = ((LynxCustomNodeInfo) obj).mRectOnScreen;
                Rect rect2 = ((LynxCustomNodeInfo) obj2).mRectOnScreen;
                if (!lynxBaseUI.isAccessibilityDirectionVertical()) {
                    if (LynxNodeProvider.this.mXPixelPerSection == 0) {
                        i = rect.left;
                        i2 = rect2.left;
                    } else {
                        i = rect.left / LynxNodeProvider.this.mXPixelPerSection;
                        i2 = rect2.left / LynxNodeProvider.this.mXPixelPerSection;
                    }
                    int i4 = i - i2;
                    return i4 == 0 ? rect.top - rect2.top : i4;
                }
                int i5 = rect.left - rect2.left;
                int i6 = LynxNodeProvider.this.mYPixelPerSection;
                int i7 = rect.top;
                if (i6 == 0) {
                    i3 = rect2.top;
                } else {
                    i7 /= LynxNodeProvider.this.mYPixelPerSection;
                    i3 = rect2.top / LynxNodeProvider.this.mYPixelPerSection;
                }
                int i8 = i7 - i3;
                return i8 == 0 ? i5 : i8;
            }
        });
        if (this.mHasHierarchyElement) {
            findAllAccessibilityNodeOfHierarchy(arrayList);
            this.mHasHierarchyElement = false;
        }
        findAllAccessibilityNodeOfContainerUI(lynxBaseUI, arrayList);
    }

    private void findAllAccessibilityNodeOfContainerUI(LynxBaseUI lynxBaseUI, ArrayList<LynxCustomNodeInfo> arrayList) {
        if (arrayList == null || lynxBaseUI == null) {
            return;
        }
        boolean z = lynxBaseUI instanceof UIList;
        if (z) {
            ((UIList) lynxBaseUI).initNodeInfo();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<LynxCustomNodeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LynxCustomNodeInfo next = it.next();
            if (next.mIsNodeContainer) {
                ArrayList<LynxCustomNodeInfo> arrayList3 = new ArrayList<>();
                findAllAccessibilityNode(next.mUI, arrayList3);
                LynxBaseUI lynxBaseUI2 = next.mUI;
                if ((lynxBaseUI2 instanceof UIComponent) && (lynxBaseUI2.getParent() instanceof UIList)) {
                    ((UIList) lynxBaseUI2.getParent()).updateNodeInfo(((UIComponent) lynxBaseUI2).getItemKey(), arrayList3);
                } else {
                    arrayList2.addAll(arrayList3);
                }
            } else {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        if (z) {
            UIList uIList = (UIList) lynxBaseUI;
            Iterator<String> it2 = uIList.getComponentAccessibilityOrder().iterator();
            while (it2.hasNext()) {
                arrayList2.addAll(uIList.getCustomNodeMap().get(it2.next()));
            }
        }
        arrayList.addAll(arrayList2);
    }

    private void findAllAccessibilityNodeOfLynxDeepInternal(LynxBaseUI lynxBaseUI, ArrayList<LynxCustomNodeInfo> arrayList) {
        if (arrayList == null || lynxBaseUI == null) {
            return;
        }
        if ((!(lynxBaseUI instanceof LynxUI) || ViewCompat.isAttachedToWindow(((LynxUI) lynxBaseUI).getView())) && !(lynxBaseUI instanceof LynxViewVisibleHelper)) {
            ArrayList<String> accessibilityElements = lynxBaseUI.getAccessibilityElements();
            ArrayList<String> accessibilityElementsA11y = lynxBaseUI.getAccessibilityElementsA11y();
            if (accessibilityElements != null || accessibilityElementsA11y != null) {
                LynxCustomNodeInfo lynxCustomNodeInfo = new LynxCustomNodeInfo(lynxBaseUI, this.mHostUI, getBoundsOnScreenOfLynxBaseUI(lynxBaseUI));
                lynxCustomNodeInfo.mIsHierarchy = true;
                arrayList.add(lynxCustomNodeInfo);
                this.mHasHierarchyElement = true;
                return;
            }
            for (int size = lynxBaseUI.getChildren().size() - 1; size >= 0; size--) {
                LynxBaseUI lynxBaseUI2 = lynxBaseUI.getChildren().get(size);
                boolean z = lynxBaseUI2 instanceof LynxUI;
                if (!z || ViewCompat.isAttachedToWindow(((LynxUI) lynxBaseUI2).getView())) {
                    if (z && lynxBaseUI2.isAccessibilityHostUI()) {
                        LynxCustomNodeInfo lynxCustomNodeInfo2 = new LynxCustomNodeInfo(lynxBaseUI2, this.mHostUI, getBoundsOnScreenOfLynxBaseUI(lynxBaseUI2));
                        lynxCustomNodeInfo2.mIsNodeContainer = true;
                        arrayList.add(lynxCustomNodeInfo2);
                    } else {
                        findAllAccessibilityNodeOfLynxDeepInternal(lynxBaseUI2, arrayList);
                    }
                }
            }
            insertNodeInfo(lynxBaseUI, arrayList);
        }
    }

    private void findAllAccessibilityNodeOfHierarchy(ArrayList<LynxCustomNodeInfo> arrayList) {
        boolean z;
        LynxBaseUI findLynxUIByIdSelector;
        ArrayList<LynxCustomNodeInfo> arrayList2 = new ArrayList<>();
        Iterator<LynxCustomNodeInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LynxCustomNodeInfo next = it.next();
            if (next.mUI != null && next.mIsHierarchy) {
                ArrayList<String> accessibilityElementsA11y = next.mUI.getAccessibilityElementsA11y();
                if (accessibilityElementsA11y == null) {
                    accessibilityElementsA11y = next.mUI.getAccessibilityElements();
                    z = false;
                } else {
                    z = true;
                }
                if (accessibilityElementsA11y != null && this.mHostUI.getLynxContext() != null && this.mHostUI.getLynxContext().getLynxUIOwner() != null) {
                    LynxUIOwner lynxUIOwner = this.mHostUI.getLynxContext().getLynxUIOwner();
                    Iterator<String> it2 = accessibilityElementsA11y.iterator();
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        if (z) {
                            findLynxUIByIdSelector = lynxUIOwner.findLynxUIByA11yId(next2);
                        } else {
                            findLynxUIByIdSelector = lynxUIOwner.findLynxUIByIdSelector(next2);
                        }
                        if (findLynxUIByIdSelector != null && (!(findLynxUIByIdSelector instanceof LynxUI) || ViewCompat.isAttachedToWindow(((LynxUI) findLynxUIByIdSelector).getView()))) {
                            insertNodeInfo(findLynxUIByIdSelector, arrayList2);
                        }
                    }
                }
            } else {
                arrayList2.add(next);
            }
        }
        arrayList.clear();
        arrayList.addAll(arrayList2);
    }

    private void insertNodeInfo(LynxBaseUI lynxBaseUI, ArrayList<LynxCustomNodeInfo> arrayList) {
        if (lynxBaseUI == null || lynxBaseUI == this.mHostUI) {
            return;
        }
        if (lynxBaseUI instanceof UIShadowProxy) {
            lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
        }
        if (isAccessibilityElement(lynxBaseUI)) {
            arrayList.add(new LynxCustomNodeInfo(lynxBaseUI, this.mHostUI, getBoundsOnScreenOfLynxBaseUI(lynxBaseUI)));
        }
    }

    private void findAllAccessibilityNodeOfViews(View view, ArrayList<LynxCustomNodeInfo> arrayList) {
        boolean z = view.getImportantForAccessibility() == 1 || !(view.getImportantForAccessibility() == 2 || TextUtils.isEmpty(view.getContentDescription()));
        boolean z2 = view.getVisibility() == 0;
        if (z && z2) {
            Rect rect = new Rect();
            getLeftAndTopOfBoundsInScreen(view, rect);
            arrayList.add(new LynxCustomNodeInfo(view, rect));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                findAllAccessibilityNodeOfViews(viewGroup.getChildAt(i), arrayList);
            }
        }
    }

    private static void getLeftAndTopOfBoundsInScreen(View view, Rect rect) {
        rect.set(0, 0, view.getRight() - view.getLeft(), view.getBottom() - view.getTop());
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.offset(iArr[0], iArr[1]);
    }

    private String getAccessibilityLabelWithChild(LynxBaseUI lynxBaseUI) {
        if (!isAccessibilityElement(lynxBaseUI)) {
            return "";
        }
        String accessibilityLabel = getAccessibilityLabel(lynxBaseUI);
        if (TextUtils.isEmpty(accessibilityLabel)) {
            Iterator<LynxBaseUI> it = lynxBaseUI.getChildren().iterator();
            while (it.hasNext()) {
                accessibilityLabel = ((Object) accessibilityLabel) + getAccessibilityLabel(it.next());
            }
        }
        return accessibilityLabel.toString();
    }

    private static String getAccessibilityLabel(LynxBaseUI lynxBaseUI) {
        CharSequence accessibilityLabel = lynxBaseUI.getAccessibilityLabel();
        if (accessibilityLabel == null) {
            accessibilityLabel = "";
        }
        return accessibilityLabel.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAccessibilityElement(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null) {
            return false;
        }
        if (lynxBaseUI.getAccessibilityElementStatus() != -1 || this.mDelegateWeakRef.get() == null) {
            return lynxBaseUI.getAccessibilityElementStatus() == 1;
        }
        return this.mDelegateWeakRef.get().mEnableAccessibilityElement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int findVirtualViewIdByUi(LynxBaseUI lynxBaseUI) {
        ArrayList<LynxCustomNodeInfo> arrayList;
        if (lynxBaseUI != null && (arrayList = this.mVirtualChildren) != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (this.mVirtualChildren.get(size).mUI == lynxBaseUI) {
                    return size;
                }
            }
        }
        return -1;
    }

    private boolean isUIClickable(LynxBaseUI lynxBaseUI) {
        return (lynxBaseUI == null || lynxBaseUI.getEvents() == null || (!lynxBaseUI.getEvents().containsKey(LynxTouchEvent.EVENT_CLICK) && !lynxBaseUI.getEvents().containsKey(LynxTouchEvent.EVENT_TAP))) ? false : true;
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
                    view2 = ((UIGroup) parentBaseUI).getAccessibilityHostView();
                }
                getLeftAndTopOfBoundsInScreen(view2, rect);
                rect.offset(-view2.getScrollX(), -view2.getScrollY());
                rect.offset(lynxBaseUI.getLeft(), lynxBaseUI.getTop());
                rect.set(rect.left, rect.top, rect.left + lynxBaseUI.getWidth(), rect.top + lynxBaseUI.getHeight());
            }
        }
        return rect;
    }

    private boolean getScreenVisibleRectOfUI(LynxBaseUI lynxBaseUI, Rect rect) {
        if (lynxBaseUI == null) {
            return false;
        }
        Rect rect2 = new Rect();
        if (lynxBaseUI instanceof LynxUI) {
            View view = ((LynxUI) lynxBaseUI).getView();
            if (lynxBaseUI instanceof UIShadowProxy) {
                LynxBaseUI child = ((UIShadowProxy) lynxBaseUI).getChild();
                if (child instanceof LynxUI) {
                    view = ((LynxUI) child).getView();
                }
            }
            if (view.getGlobalVisibleRect(rect)) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                rect.offset(iArr[0] - rect.left, iArr[1] - rect.top);
                return true;
            }
        } else if (lynxBaseUI instanceof LynxFlattenUI) {
            LynxBaseUI lynxBaseUI2 = lynxBaseUI;
            while ((lynxBaseUI2 instanceof LynxFlattenUI) && lynxBaseUI2 != this.mHostUI) {
                rect2.left += lynxBaseUI2.getOriginLeft();
                rect2.top += lynxBaseUI2.getOriginTop();
                lynxBaseUI2 = lynxBaseUI2.getParentBaseUI();
            }
            if (lynxBaseUI2 != null && (lynxBaseUI2 instanceof LynxUI)) {
                View view2 = ((LynxUI) lynxBaseUI2).getView();
                if (lynxBaseUI2 instanceof UIGroup) {
                    view2 = ((UIGroup) lynxBaseUI2).getAccessibilityHostView();
                }
                Rect rect3 = new Rect();
                int[] iArr2 = new int[2];
                if (view2.getLocalVisibleRect(rect3)) {
                    rect2.right = rect2.left + lynxBaseUI.getWidth();
                    rect2.bottom = rect2.top + lynxBaseUI.getHeight();
                    if (rect2.intersect(rect3)) {
                        view2.getLocationOnScreen(iArr2);
                        rect.set(rect2);
                        rect.offset(iArr2[0] - view2.getScrollX(), iArr2[1] - view2.getScrollY());
                        return true;
                    }
                }
            }
        }
        rect.set(0, 0, lynxBaseUI.getWidth(), lynxBaseUI.getHeight());
        return false;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class LynxCustomNodeInfo {
        UIGroup mHostUI;
        boolean mIsHierarchy;
        boolean mIsNodeContainer;
        Rect mRectOnScreen;
        LynxBaseUI mUI;
        View mView;

        public void invalid() {
            this.mUI = null;
            this.mHostUI = null;
            this.mView = null;
            this.mRectOnScreen = LynxAccessibilityWrapper.INVALID_BOUNDS;
        }

        public LynxCustomNodeInfo(LynxBaseUI lynxBaseUI, UIGroup uIGroup, Rect rect) {
            this.mUI = lynxBaseUI;
            this.mHostUI = uIGroup;
            this.mView = null;
            this.mRectOnScreen = rect;
        }

        public LynxCustomNodeInfo(View view, Rect rect) {
            this.mUI = null;
            this.mHostUI = null;
            this.mView = view;
            this.mRectOnScreen = rect;
        }
    }
}
