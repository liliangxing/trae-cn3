package com.lynx.tasm.behavior.p000ui.accessibility;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAccessibilityHelper {
    private static final String TAG = "LynxAccessibilityHelper";
    private ArrayList<WeakReference<LynxBaseUI>> mAccessibilityElementsA11yUI;
    private ArrayList<WeakReference<LynxBaseUI>> mAccessibilityElementsUI;
    private boolean mConfigEnableAccessibilityElement = false;
    private HashMap<Integer, WeakReference<LynxBaseUI>> mExclusiveUIMap;
    private WeakReference<UIGroup> mWeakHostUI;

    /* renamed from: com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C00781 {

        /* renamed from: $SwitchMap$com$lynx$tasm$behavior$ui$accessibility$LynxAccessibilityHelper$LynxAccessibilityTraits */
        static final /* synthetic */ int[] f3x2d64c016;

        static {
            int[] iArr = new int[LynxAccessibilityTraits.values().length];
            f3x2d64c016 = iArr;
            try {
                iArr[LynxAccessibilityTraits.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3x2d64c016[LynxAccessibilityTraits.BUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum LynxAccessibilityTraits {
        NONE,
        IMAGE,
        BUTTON;

        private static String TRAITS_CLASS_NONE = "android.view.View";
        private static String TRAITS_CLASS_IMAGE = "android.widget.ImageView";
        private static String TRAITS_CLASS_BUTTON = "android.widget.Button";

        public static String getValue(LynxAccessibilityTraits lynxAccessibilityTraits) {
            int i = C00781.f3x2d64c016[lynxAccessibilityTraits.ordinal()];
            if (i == 1) {
                return TRAITS_CLASS_IMAGE;
            }
            if (i == 2) {
                return TRAITS_CLASS_BUTTON;
            }
            return TRAITS_CLASS_NONE;
        }

        public static LynxAccessibilityTraits fromValue(String str) {
            if (str != null) {
                for (LynxAccessibilityTraits lynxAccessibilityTraits : values()) {
                    if (lynxAccessibilityTraits.name().equalsIgnoreCase(str)) {
                        return lynxAccessibilityTraits;
                    }
                }
            }
            return NONE;
        }
    }

    public LynxAccessibilityHelper(UIGroup uIGroup) {
        this.mAccessibilityElementsUI = null;
        this.mAccessibilityElementsA11yUI = null;
        this.mExclusiveUIMap = null;
        if (uIGroup == null || uIGroup.getView() == 0) {
            LLog.e(TAG, "Construct LynxAccessibilityHelper with null host ui or view");
            return;
        }
        this.mWeakHostUI = new WeakReference<>(uIGroup);
        this.mAccessibilityElementsA11yUI = new ArrayList<>();
        this.mAccessibilityElementsUI = new ArrayList<>();
        this.mExclusiveUIMap = new HashMap<>();
    }

    public boolean requestAccessibilityFocus(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI instanceof LynxUI) {
            LynxUI lynxUI = (LynxUI) lynxBaseUI;
            if (lynxUI.getView() == null || !isImportantForAccessibility(lynxBaseUI)) {
                return false;
            }
            lynxUI.getView().sendAccessibilityEvent(128);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyAccessibilityElements() {
        if (!this.mAccessibilityElementsA11yUI.isEmpty()) {
            Iterator<WeakReference<LynxBaseUI>> it = this.mAccessibilityElementsA11yUI.iterator();
            while (it.hasNext()) {
                WeakReference<LynxBaseUI> next = it.next();
                if (next != null && next.get() != null) {
                    setAccessibilityElementsInternal(next.get());
                }
            }
            this.mAccessibilityElementsA11yUI.clear();
        }
        if (this.mAccessibilityElementsUI.isEmpty()) {
            return;
        }
        Iterator<WeakReference<LynxBaseUI>> it2 = this.mAccessibilityElementsUI.iterator();
        while (it2.hasNext()) {
            WeakReference<LynxBaseUI> next2 = it2.next();
            if (next2 != null && next2.get() != null) {
                setAccessibilityElementsInternal(next2.get());
            }
        }
        this.mAccessibilityElementsUI.clear();
    }

    public void setConfigEnableAccessibilityElement(boolean z) {
        this.mConfigEnableAccessibilityElement = z;
    }

    private void setAccessibilityElementsInternal(LynxBaseUI lynxBaseUI) {
        boolean z;
        LynxBaseUI findLynxUIByIdSelector;
        LynxUIOwner lynxUIOwner = getLynxUIOwner();
        if (lynxBaseUI == null || lynxUIOwner == null) {
            return;
        }
        if (lynxBaseUI.getAccessibilityElementsA11y() == null && lynxBaseUI.getAccessibilityElements() == null) {
            return;
        }
        setChildrenNoImportantForAccessibility(lynxBaseUI);
        ArrayList<String> accessibilityElementsA11y = lynxBaseUI.getAccessibilityElementsA11y();
        int i = 0;
        if (accessibilityElementsA11y == null) {
            accessibilityElementsA11y = lynxBaseUI.getAccessibilityElements();
            z = false;
        } else {
            z = true;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = accessibilityElementsA11y.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next != null) {
                if (z) {
                    findLynxUIByIdSelector = lynxUIOwner.findLynxUIByA11yId(next);
                } else {
                    findLynxUIByIdSelector = lynxUIOwner.findLynxUIByIdSelector(next);
                }
                if (findLynxUIByIdSelector instanceof LynxUI) {
                    LynxUI lynxUI = (LynxUI) findLynxUIByIdSelector;
                    if (lynxUI.getView() != null) {
                        ViewCompat.setImportantForAccessibility(lynxUI.getView(), 1);
                        arrayList.add(lynxUI);
                    }
                }
            }
        }
        if (arrayList.isEmpty() || arrayList.size() == 1) {
            return;
        }
        int size = arrayList.size();
        while (i < size - 1) {
            LynxUI lynxUI2 = (LynxUI) arrayList.get(i);
            i++;
            LynxUI lynxUI3 = (LynxUI) arrayList.get(i);
            View view = lynxUI2.getView();
            View view2 = lynxUI3.getView();
            view.setId(lynxUI2.getSign());
            view2.setId(lynxUI3.getSign());
            view.setAccessibilityTraversalBefore(lynxUI3.getSign());
        }
    }

    private void setChildrenNoImportantForAccessibility(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null || lynxBaseUI.getChildren() == null) {
            return;
        }
        int size = lynxBaseUI.getChildren().size();
        for (int i = 0; i < size; i++) {
            LynxBaseUI childAt = lynxBaseUI.getChildAt(i);
            if (childAt instanceof LynxUI) {
                ViewCompat.setImportantForAccessibility(((LynxUI) childAt).getView(), 2);
            }
            setChildrenNoImportantForAccessibility(childAt);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAccessibilityElementsUI(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI != null) {
            this.mAccessibilityElementsUI.add(new WeakReference<>(lynxBaseUI));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addAccessibilityElementsA11yUI(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI != null) {
            this.mAccessibilityElementsA11yUI.add(new WeakReference<>(lynxBaseUI));
        }
    }

    public void addUIToExclusiveMap(LynxBaseUI lynxBaseUI) {
        this.mExclusiveUIMap.put(Integer.valueOf(lynxBaseUI.getSign()), new WeakReference<>(lynxBaseUI));
    }

    public void removeUIFromExclusiveMap(LynxBaseUI lynxBaseUI) {
        LynxBaseUI lynxBaseUI2;
        int sign = lynxBaseUI.getSign();
        HashMap<Integer, WeakReference<LynxBaseUI>> hashMap = this.mExclusiveUIMap;
        if (hashMap == null || hashMap.get(Integer.valueOf(sign)) == null || (lynxBaseUI2 = this.mExclusiveUIMap.get(Integer.valueOf(sign)).get()) == null || lynxBaseUI2 != lynxBaseUI) {
            return;
        }
        this.mExclusiveUIMap.remove(Integer.valueOf(sign));
    }

    public boolean isImportantForAccessibility(int i) {
        if (i == -1) {
            return this.mConfigEnableAccessibilityElement;
        }
        return i == 1;
    }

    public boolean isImportantForAccessibility(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null) {
            return false;
        }
        boolean isImportantForAccessibility = isImportantForAccessibility(lynxBaseUI.getAccessibilityElementStatus());
        UIGroup hostUI = getHostUI();
        if (!isImportantForAccessibility || lynxBaseUI == null || hostUI == null || this.mExclusiveUIMap.isEmpty()) {
            return isImportantForAccessibility;
        }
        while (lynxBaseUI != null && lynxBaseUI != hostUI) {
            if (this.mExclusiveUIMap.containsKey(Integer.valueOf(lynxBaseUI.getSign()))) {
                return true;
            }
            lynxBaseUI = lynxBaseUI.getParentBaseUI();
        }
        return false;
    }

    private LynxUIOwner getLynxUIOwner() {
        UIGroup uIGroup;
        WeakReference<UIGroup> weakReference = this.mWeakHostUI;
        if (weakReference == null || weakReference.get() == null || (uIGroup = this.mWeakHostUI.get()) == null || uIGroup.getLynxContext() == null) {
            return null;
        }
        return uIGroup.getLynxContext().getLynxUIOwner();
    }

    private UIGroup getHostUI() {
        WeakReference<UIGroup> weakReference = this.mWeakHostUI;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
