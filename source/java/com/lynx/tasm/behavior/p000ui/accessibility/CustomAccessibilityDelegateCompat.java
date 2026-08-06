package com.lynx.tasm.behavior.p000ui.accessibility;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Switch;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.lynx.R;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.service.LynxMemoryInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    private static final boolean DEBUG = false;
    private static final String TAG = "CustomAccessibilityDelegateCompat";
    private static List<Integer> idList;
    static final Map<String, String> mClassNameMap = new HashMap<String, String>() { // from class: com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat.1
        {
            put("button", Button.class.getName());
            put("switch", Switch.class.getName());
            put("checkbox", CheckBox.class.getName());
            put(LynxMemoryInfo.TYPE_IMAGE, ImageView.class.getName());
            put("progressbar", ProgressBar.class.getName());
        }
    };
    private Rect mGlobalBoundRect = new Rect(LynxAccessibilityWrapper.INVALID_BOUNDS);
    private Rect mParentBoundRect = new Rect(LynxAccessibilityWrapper.INVALID_BOUNDS);
    private WeakReference<LynxUI> mWeakUI;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    public CustomAccessibilityDelegateCompat(LynxUI lynxUI) {
        if (lynxUI == null || lynxUI.getView() == null) {
            LLog.e(TAG, "Construct with null ui or view");
            return;
        }
        this.mWeakUI = new WeakReference<>(lynxUI);
        LynxAccessibilityHelper lynxAccessibilityHelper = getLynxAccessibilityHelper();
        ViewCompat.setImportantForAccessibility(lynxUI.getView(), (int) (lynxAccessibilityHelper != null ? lynxAccessibilityHelper.isImportantForAccessibility(-1) : 0));
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        WeakReference<LynxUI> weakReference;
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        LynxAccessibilityWrapper lynxAccessibilityWrapper = getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper == null || (weakReference = this.mWeakUI) == null || weakReference.get() == null || !lynxAccessibilityWrapper.enableHelper()) {
            return;
        }
        LynxUI lynxUI = this.mWeakUI.get();
        boolean isImportantForAccessibility = getLynxAccessibilityHelper().isImportantForAccessibility(lynxUI);
        CharSequence accessibilityLabel = lynxUI.getAccessibilityLabel();
        boolean isClickableUI = isClickableUI();
        accessibilityNodeInfoCompat.setScreenReaderFocusable(isImportantForAccessibility);
        accessibilityNodeInfoCompat.setContentDescription(isImportantForAccessibility ? concatA11yStatusAndLabel(lynxUI.getAccessibilityStatus(), accessibilityLabel) : null);
        if (!isImportantForAccessibility) {
            accessibilityLabel = null;
        }
        accessibilityNodeInfoCompat.setText(accessibilityLabel);
        accessibilityNodeInfoCompat.setClickable(isClickableUI);
        ArrayList<String> accessibilityActions = lynxUI.getAccessibilityActions();
        if (accessibilityActions != null) {
            Iterator<String> it = accessibilityActions.iterator();
            int i = 0;
            while (it.hasNext()) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(genA11yCustomActionID(i), it.next()));
                i++;
            }
        } else {
            Iterator it2 = accessibilityNodeInfoCompat.getActionList().iterator();
            while (it2.hasNext()) {
                accessibilityNodeInfoCompat.removeAction((AccessibilityNodeInfoCompat.AccessibilityActionCompat) it2.next());
            }
        }
        if (isClickableUI) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        } else {
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        if (!isImportantForAccessibility) {
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
            accessibilityNodeInfoCompat.setVisibleToUser(false);
        }
        accessibilityNodeInfoCompat.getBoundsInScreen(this.mGlobalBoundRect);
        accessibilityNodeInfoCompat.getBoundsInParent(this.mParentBoundRect);
        setTraversalOrder(lynxUI, accessibilityNodeInfoCompat);
        setTraitsIfNeeded(lynxUI, accessibilityNodeInfoCompat);
        setRoleDescriptionIfNeeded(lynxUI, accessibilityNodeInfoCompat);
    }

    private String concatA11yStatusAndLabel(CharSequence charSequence, CharSequence charSequence2) {
        StringBuilder sb = new StringBuilder();
        if (charSequence != null) {
            sb.append(charSequence);
        }
        if (charSequence2 != null) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(charSequence2);
        }
        return sb.toString();
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        boolean performAccessibilityAction = super.performAccessibilityAction(view, i, bundle);
        if (i == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK.getId()) {
            return fireActionClick();
        }
        if (i == AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS.getId() && getLynxAccessibilityWrapper() != null) {
            getLynxAccessibilityWrapper().onAccessibilityFocused(-1, this.mWeakUI.get());
            return performAccessibilityAction;
        }
        ArrayList<String> accessibilityActions = this.mWeakUI.get().getAccessibilityActions();
        if (accessibilityActions == null) {
            return performAccessibilityAction;
        }
        Iterator<String> it = accessibilityActions.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            int i3 = i2 + 1;
            if (i == genA11yCustomActionID(i2)) {
                LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mWeakUI.get().getSign(), "accessibilityaction");
                lynxDetailEvent.addDetail("name", next);
                this.mWeakUI.get().getLynxContext().getEventEmitter().sendCustomEvent(lynxDetailEvent);
                return performAccessibilityAction;
            }
            i2 = i3;
        }
        return performAccessibilityAction;
    }

    private int genA11yCustomActionID(int i) {
        if (idList == null) {
            idList = new ArrayList(Arrays.asList(Integer.valueOf(R.id.custom_reserved_a11y_action_0_id), Integer.valueOf(R.id.custom_reserved_a11y_action_1_id), Integer.valueOf(R.id.custom_reserved_a11y_action_2_id), Integer.valueOf(R.id.custom_reserved_a11y_action_3_id), Integer.valueOf(R.id.custom_reserved_a11y_action_4_id), Integer.valueOf(R.id.custom_reserved_a11y_action_5_id), Integer.valueOf(R.id.custom_reserved_a11y_action_6_id), Integer.valueOf(R.id.custom_reserved_a11y_action_7_id), Integer.valueOf(R.id.custom_reserved_a11y_action_8_id), Integer.valueOf(R.id.custom_reserved_a11y_action_9_id), Integer.valueOf(R.id.custom_reserved_a11y_action_10_id), Integer.valueOf(R.id.custom_reserved_a11y_action_11_id), Integer.valueOf(R.id.custom_reserved_a11y_action_12_id), Integer.valueOf(R.id.custom_reserved_a11y_action_13_id), Integer.valueOf(R.id.custom_reserved_a11y_action_14_id), Integer.valueOf(R.id.custom_reserved_a11y_action_15_id), Integer.valueOf(R.id.custom_reserved_a11y_action_16_id), Integer.valueOf(R.id.custom_reserved_a11y_action_17_id), Integer.valueOf(R.id.custom_reserved_a11y_action_18_id), Integer.valueOf(R.id.custom_reserved_a11y_action_19_id), Integer.valueOf(R.id.custom_reserved_a11y_action_20_id), Integer.valueOf(R.id.custom_reserved_a11y_action_21_id), Integer.valueOf(R.id.custom_reserved_a11y_action_22_id), Integer.valueOf(R.id.custom_reserved_a11y_action_23_id), Integer.valueOf(R.id.custom_reserved_a11y_action_24_id), Integer.valueOf(R.id.custom_reserved_a11y_action_25_id), Integer.valueOf(R.id.custom_reserved_a11y_action_26_id), Integer.valueOf(R.id.custom_reserved_a11y_action_27_id), Integer.valueOf(R.id.custom_reserved_a11y_action_28_id), Integer.valueOf(R.id.custom_reserved_a11y_action_29_id)));
        }
        return idList.get(i).intValue();
    }

    private void setTraitsIfNeeded(LynxUI lynxUI, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (lynxUI == null || accessibilityNodeInfoCompat == null) {
            return;
        }
        LynxAccessibilityHelper.LynxAccessibilityTraits accessibilityTraits = lynxUI.getAccessibilityTraits();
        accessibilityNodeInfoCompat.setClassName(LynxAccessibilityHelper.LynxAccessibilityTraits.getValue(accessibilityTraits));
        if (accessibilityTraits == LynxAccessibilityHelper.LynxAccessibilityTraits.NONE) {
            accessibilityNodeInfoCompat.setRoleDescription("");
        }
    }

    private void setRoleDescriptionIfNeeded(LynxUI lynxUI, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        String accessibilityRoleDescription;
        if (lynxUI == null || accessibilityNodeInfoCompat == null || (accessibilityRoleDescription = lynxUI.getAccessibilityRoleDescription()) == null) {
            return;
        }
        Map<String, String> map = mClassNameMap;
        if (map.containsKey(accessibilityRoleDescription)) {
            accessibilityNodeInfoCompat.setClassName(map.get(accessibilityRoleDescription));
        } else {
            accessibilityNodeInfoCompat.setRoleDescription(accessibilityRoleDescription);
        }
    }

    private void setTraversalOrder(LynxUI lynxUI, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        LynxContext lynxContext = lynxUI.getLynxContext();
        View view = lynxUI.getView();
        if (lynxContext == null || view == null || lynxContext.getUIBody() == null) {
            return;
        }
        UIBody.UIBodyView bodyView = lynxContext.getUIBody().getBodyView();
        for (ViewParent parent = view.getParent(); bodyView != null && parent != null && parent != bodyView; parent = parent.getParent()) {
            if (parent instanceof UIShadowProxy.ShadowView) {
                UIShadowProxy.ShadowView shadowView = (UIShadowProxy.ShadowView) parent;
                if (shadowView.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) shadowView.getParent();
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt == shadowView) {
                            return;
                        }
                        if (childAt != null) {
                            accessibilityNodeInfoCompat.setTraversalAfter(childAt);
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    private boolean fireActionClick() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = getLynxAccessibilityWrapper();
        WeakReference<LynxUI> weakReference = this.mWeakUI;
        boolean z = false;
        if (weakReference != null && weakReference.get() != null && lynxAccessibilityWrapper != null && lynxAccessibilityWrapper.enableHelper()) {
            LynxUI lynxUI = this.mWeakUI.get();
            if (!this.mGlobalBoundRect.equals(LynxAccessibilityWrapper.INVALID_BOUNDS) && !this.mParentBoundRect.equals(LynxAccessibilityWrapper.INVALID_BOUNDS)) {
                LynxTouchEvent.Point point = new LynxTouchEvent.Point(this.mGlobalBoundRect.centerX(), this.mGlobalBoundRect.centerY());
                LynxTouchEvent.Point point2 = new LynxTouchEvent.Point(this.mParentBoundRect.centerX(), this.mParentBoundRect.centerY());
                if (lynxUI.getEvents() != null) {
                    Map<String, EventsListener> events = lynxUI.getEvents();
                    if (events.containsKey(LynxTouchEvent.EVENT_TAP)) {
                        lynxUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxUI.getSign(), LynxTouchEvent.EVENT_TAP, point2, point2, point));
                        z = true;
                    }
                    if (!events.containsKey(LynxTouchEvent.EVENT_CLICK)) {
                        return z;
                    }
                    lynxUI.getLynxContext().getEventEmitter().sendTouchEvent(new LynxTouchEvent(lynxUI.getSign(), LynxTouchEvent.EVENT_CLICK, point2, point2, point));
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isClickableUI() {
        LynxUI lynxUI = getLynxUI();
        return (lynxUI == null || lynxUI.getEvents() == null || (!lynxUI.getEvents().containsKey(LynxTouchEvent.EVENT_CLICK) && !lynxUI.getEvents().containsKey(LynxTouchEvent.EVENT_TAP))) ? false : true;
    }

    private LynxAccessibilityHelper getLynxAccessibilityHelper() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            return lynxAccessibilityWrapper.getLynxAccessibilityHelper();
        }
        return null;
    }

    private LynxAccessibilityWrapper getLynxAccessibilityWrapper() {
        LynxContext lynxContext;
        if (getLynxUI() == null || (lynxContext = getLynxUI().getLynxContext()) == null) {
            return null;
        }
        return lynxContext.getLynxAccessibilityWrapper();
    }

    private LynxUI getLynxUI() {
        WeakReference<LynxUI> weakReference = this.mWeakUI;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.mWeakUI.get();
    }
}
