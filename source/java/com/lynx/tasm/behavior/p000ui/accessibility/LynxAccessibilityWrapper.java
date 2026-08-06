package com.lynx.tasm.behavior.p000ui.accessibility;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxAccessibilityNodeProvider;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityStateHelper;
import com.lynx.tasm.behavior.p000ui.text.FlattenUIText;
import com.lynx.tasm.behavior.p000ui.text.UIText;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxAccessibilityWrapper implements LynxAccessibilityStateHelper.OnStateListener {
    public static final int ACCESSIBILITY_ELEMENT_DEFAULT = -1;
    public static final int ACCESSIBILITY_ELEMENT_FALSE = 0;
    public static final int ACCESSIBILITY_ELEMENT_TRUE = 1;
    public static final Rect INVALID_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final String TAG = "LynxAccessibilityWrapper";
    private AccessibilityManager mAccessibilityManager;
    private boolean mIsLazyInit;
    private LynxAccessibilityStateHelper mStateHelper;
    private WeakReference<UIBody> mWeakHostUI;
    private boolean mConfigEnableNewAccessibility = false;
    private boolean mConfigEnableA11y = false;
    private boolean mConfigEnableAccessibilityElement = false;
    private boolean mConfigEnableOverlap = false;
    private boolean mConfigEnableA11yIDMutationObserver = false;
    private boolean mAccessibilityEnable = false;
    private boolean mTouchExplorationEnable = false;
    private LynxAccessibilityMutationHelper mMutationHelper = null;
    private LynxAccessibilityNodeProvider mNodeProvider = null;
    private LynxAccessibilityDelegate mDelegate = null;
    private LynxAccessibilityHelper mHelper = null;

    public LynxAccessibilityWrapper(UIBody uIBody) {
        this.mWeakHostUI = null;
        this.mAccessibilityManager = null;
        this.mStateHelper = null;
        this.mIsLazyInit = false;
        if (uIBody == null || uIBody.getBodyView() == null) {
            LLog.e(TAG, "Construct LynxAccessibilityWrapper with null host");
            return;
        }
        this.mWeakHostUI = new WeakReference<>(uIBody);
        LynxContext lynxContext = uIBody.getLynxContext();
        if (lynxContext != null) {
            this.mIsLazyInit = lynxContext.isEmbeddedModeOn() || LynxEnv.inst().enableLazyInitA11y();
            this.mAccessibilityManager = (AccessibilityManager) uIBody.getLynxContext().getSystemService("accessibility");
        }
        if (this.mIsLazyInit) {
            this.mStateHelper = new LynxAccessibilityStateHelper(this.mAccessibilityManager, this);
        } else {
            LLog.i(TAG, "Construct LynxAccessibilityNodeProvider and set default delegate.");
            createDefaultA11yDelegate(uIBody);
        }
    }

    public void onPageConfigDecoded(PageConfig pageConfig) {
        if (pageConfig == null) {
            return;
        }
        this.mConfigEnableNewAccessibility = pageConfig.getEnableNewAccessibility();
        this.mConfigEnableA11y = pageConfig.getEnableA11y();
        this.mConfigEnableAccessibilityElement = pageConfig.getEnableAccessibilityElement();
        this.mConfigEnableOverlap = pageConfig.getEnableOverlapForAccessibilityElement();
        this.mConfigEnableA11yIDMutationObserver = pageConfig.getEnableA11yIDMutationObserver();
        if (this.mIsLazyInit) {
            createAccessibilityDelegateForLynxViewIfNeeded();
            return;
        }
        if (enableNodeProvider()) {
            this.mNodeProvider.setConfigEnableAccessibilityElement(this.mConfigEnableAccessibilityElement);
            this.mNodeProvider.setConfigEnableOverlapForAccessibilityElement(this.mConfigEnableOverlap);
            return;
        }
        UIBody uIBody = getUIBody();
        if (uIBody == null || uIBody.getBodyView() == null || this.mAccessibilityManager == null) {
            return;
        }
        if (this.mStateHelper == null) {
            this.mStateHelper = new LynxAccessibilityStateHelper(this.mAccessibilityManager, this);
        }
        if (this.mMutationHelper == null) {
            this.mMutationHelper = new LynxAccessibilityMutationHelper();
        }
        if (this.mConfigEnableA11y) {
            initHelperIfNeeded(uIBody, uIBody.getBodyView());
        } else if (this.mConfigEnableNewAccessibility) {
            initDelegateIfNeeded(uIBody);
        }
    }

    private void createAccessibilityDelegateForLynxViewIfNeeded() {
        UIBody uIBody;
        if (!isSystemAccessibilityEnable() || (uIBody = getUIBody()) == null || uIBody.getBodyView() == null) {
            return;
        }
        if (!this.mConfigEnableA11y && !this.mConfigEnableNewAccessibility) {
            createDefaultA11yDelegate(uIBody);
            if (enableNodeProvider()) {
                this.mNodeProvider.setConfigEnableAccessibilityElement(this.mConfigEnableAccessibilityElement);
                this.mNodeProvider.setConfigEnableOverlapForAccessibilityElement(this.mConfigEnableOverlap);
                return;
            }
            return;
        }
        if (this.mMutationHelper == null) {
            this.mMutationHelper = new LynxAccessibilityMutationHelper();
        }
        if (this.mConfigEnableA11y) {
            initHelperIfNeeded(uIBody, uIBody.getBodyView());
        } else if (this.mConfigEnableNewAccessibility) {
            initDelegateIfNeeded(uIBody);
        }
    }

    private void createDefaultA11yDelegate(UIBody uIBody) {
        if (this.mNodeProvider != null || uIBody == null) {
            return;
        }
        this.mNodeProvider = new LynxAccessibilityNodeProvider(uIBody);
        UIBody.UIBodyView bodyView = uIBody.getBodyView();
        if (bodyView != null) {
            bodyView.setAccessibilityDelegate(new View.AccessibilityDelegate() { // from class: com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityWrapper.1
                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    return LynxAccessibilityWrapper.this.mNodeProvider;
                }
            });
        }
    }

    private void initDelegateIfNeeded(UIBody uIBody) {
        LLog.i(TAG, "init LynxAccessibilityDelegate with " + this.mConfigEnableNewAccessibility + ", " + this.mConfigEnableA11y);
        if (this.mDelegate == null) {
            this.mDelegate = new LynxAccessibilityDelegate(uIBody);
        }
        this.mDelegate.setConfigEnableAccessibilityElement(this.mConfigEnableAccessibilityElement);
        ViewCompat.setAccessibilityDelegate(uIBody.getBodyView(), this.mDelegate);
    }

    private void initHelperIfNeeded(UIBody uIBody, View view) {
        LLog.i(TAG, "init LynxAccessibilityHelper with " + this.mConfigEnableNewAccessibility + ", " + this.mConfigEnableA11y);
        if (this.mHelper == null) {
            this.mHelper = new LynxAccessibilityHelper(uIBody);
        }
        this.mHelper.setConfigEnableAccessibilityElement(this.mConfigEnableAccessibilityElement);
        ViewCompat.setImportantForAccessibility(view, 2);
        ViewCompat.setAccessibilityDelegate(view, (AccessibilityDelegateCompat) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAccessibilityFocused(int i, LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null || lynxBaseUI.getLynxContext() == null) {
            return;
        }
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("element-id", Integer.valueOf(lynxBaseUI.getSign()));
        javaOnlyMap.put(PropsConstants.ACCESSIBILITY_ID, lynxBaseUI.getAccessibilityId());
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        javaOnlyArray.pushMap(javaOnlyMap);
        lynxBaseUI.getLynxContext().sendGlobalEvent("activeElement", javaOnlyArray);
    }

    public boolean onHoverEvent(UIBody.UIBodyView uIBodyView, MotionEvent motionEvent) {
        if (uIBodyView == null) {
            return false;
        }
        if (enableNodeProvider() && this.mNodeProvider.onHover(uIBodyView, motionEvent)) {
            return true;
        }
        return enableDelegate() && this.mDelegate.dispatchHoverEvent(motionEvent);
    }

    public void onDestroy() {
        LynxAccessibilityStateHelper lynxAccessibilityStateHelper = this.mStateHelper;
        if (lynxAccessibilityStateHelper != null) {
            lynxAccessibilityStateHelper.removeAllListeners();
        }
    }

    public void insertA11yMutationEvent(int i, LynxBaseUI lynxBaseUI) {
        if (this.mMutationHelper == null || !shouldHandleA11yMutation()) {
            return;
        }
        this.mMutationHelper.insertA11yMutationEvent(i, lynxBaseUI);
    }

    public void handleMutationStyleUpdate(LynxBaseUI lynxBaseUI, StylesDiffMap stylesDiffMap) {
        if (this.mMutationHelper == null || !shouldHandleA11yMutation() || lynxBaseUI == null || stylesDiffMap == null) {
            return;
        }
        ReadableMapKeySetIterator keySetIterator = stylesDiffMap.mBackingMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            this.mMutationHelper.insertA11yMutationEvent(4, lynxBaseUI, keySetIterator.nextKey());
        }
    }

    public void flushA11yMutationEvents() {
        if (this.mMutationHelper == null || !shouldHandleA11yMutation() || getUIBody() == null || getUIBody().getLynxContext() == null) {
            return;
        }
        this.mMutationHelper.flushA11yMutationEvents(getUIBody().getLynxContext());
    }

    public void registerMutationStyleInner(ReadableMap readableMap, JavaOnlyMap javaOnlyMap) {
        if (this.mMutationHelper == null || (!enableDelegate() && !enableHelper())) {
            javaOnlyMap.putString(IAssociationStartMonitorEventService.KEY_MSG, "Fail: init accessibility mutation env error");
            return;
        }
        ReadableArray array = readableMap.getArray("mutation_styles", (ReadableArray) null);
        if (array == null) {
            javaOnlyMap.putString(IAssociationStartMonitorEventService.KEY_MSG, "Fail: params error with keymutation_styles");
        } else {
            this.mMutationHelper.registerMutationStyle(array);
            javaOnlyMap.putString(IAssociationStartMonitorEventService.KEY_MSG, "Success: finish register");
        }
    }

    public void requestAccessibilityFocus(LynxBaseUI lynxBaseUI, Callback callback) {
        if (!isSystemAccessibilityEnable()) {
            callback.invoke(new Object[]{1, "System accessibility is disable!"});
            return;
        }
        if (lynxBaseUI == null) {
            callback.invoke(new Object[]{1, "Focus node is null!"});
            return;
        }
        if ((enableHelper() && this.mHelper.requestAccessibilityFocus(lynxBaseUI)) || (enableDelegate() && this.mDelegate.requestAccessibilityFocus(lynxBaseUI))) {
            callback.invoke(new Object[]{0, "Accessibility element on focused"});
        } else {
            callback.invoke(new Object[]{1, "Request accessibility focus fail!"});
        }
    }

    public void fetchAccessibilityTargets(LynxBaseUI lynxBaseUI, Callback callback) {
        if (lynxBaseUI != null) {
            if (enableDelegate() || enableHelper()) {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                fetchAccessibilityTargetsInternal(lynxBaseUI, false, javaOnlyArray);
                callback.invoke(new Object[]{0, javaOnlyArray});
                return;
            }
            callback.invoke(new Object[]{1, "fetch accessibility targets fail!"});
            return;
        }
        callback.invoke(new Object[]{1, "No accessibility element found!"});
    }

    public void innerText(LynxBaseUI lynxBaseUI, Callback callback) {
        if (lynxBaseUI != null) {
            if (enableDelegate() || enableHelper()) {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                fetchAccessibilityTargetsInternal(lynxBaseUI, true, javaOnlyArray);
                callback.invoke(new Object[]{0, javaOnlyArray});
                return;
            }
            callback.invoke(new Object[]{1, "fetch accessibility inner text fail!"});
            return;
        }
        callback.invoke(new Object[]{1, "No accessibility element found!"});
    }

    private void fetchAccessibilityTargetsInternal(LynxBaseUI lynxBaseUI, boolean z, JavaOnlyArray javaOnlyArray) {
        if (lynxBaseUI == null || javaOnlyArray == null) {
            return;
        }
        if (!z) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.putInt("element-id", lynxBaseUI.getSign());
            javaOnlyMap.putString(PropsConstants.ACCESSIBILITY_ID, lynxBaseUI.getAccessibilityId());
            javaOnlyArray.add(javaOnlyMap);
        } else {
            if (lynxBaseUI instanceof UIText) {
                CharSequence originText = ((UIText) lynxBaseUI).getOriginText();
                javaOnlyArray.pushString(originText != null ? originText.toString() : "");
            } else if (lynxBaseUI instanceof FlattenUIText) {
                CharSequence originText2 = ((FlattenUIText) lynxBaseUI).getOriginText();
                javaOnlyArray.pushString(originText2 != null ? originText2.toString() : "");
            }
        }
        for (int i = 0; i < lynxBaseUI.getChildren().size(); i++) {
            fetchAccessibilityTargetsInternal(lynxBaseUI.getChildren().get(i), z, javaOnlyArray);
        }
    }

    public boolean shouldHandleA11yMutation() {
        return this.mConfigEnableA11yIDMutationObserver && isSystemAccessibilityEnable() && (enableDelegate() || enableHelper());
    }

    public boolean isSystemAccessibilityEnable() {
        return this.mAccessibilityManager != null && this.mAccessibilityEnable && this.mTouchExplorationEnable;
    }

    public void onLayoutFinish() {
        flushA11yMutationEvents();
        if (enableHelper()) {
            this.mHelper.applyAccessibilityElements();
        }
    }

    public void addAccessibilityElementsUI(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null || !enableHelper()) {
            return;
        }
        this.mHelper.addAccessibilityElementsUI(lynxBaseUI);
    }

    public void addAccessibilityElementsA11yUI(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI == null || !enableHelper()) {
            return;
        }
        this.mHelper.addAccessibilityElementsA11yUI(lynxBaseUI);
    }

    public void addOrRemoveUIFromExclusiveMap(LynxBaseUI lynxBaseUI, boolean z) {
        if (enableHelper()) {
            if (z) {
                this.mHelper.addUIToExclusiveMap(lynxBaseUI);
            } else {
                this.mHelper.removeUIFromExclusiveMap(lynxBaseUI);
            }
        }
    }

    public boolean shouldCreateNoFlattenUI() {
        return enableHelper() && isSystemAccessibilityEnable();
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityStateHelper.OnStateListener
    public void onAccessibilityEnable(boolean z) {
        this.mAccessibilityEnable = z;
        if (this.mIsLazyInit) {
            createAccessibilityDelegateForLynxViewIfNeeded();
        }
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityStateHelper.OnStateListener
    public void onTouchExplorationEnable(boolean z) {
        this.mTouchExplorationEnable = z;
        if (this.mIsLazyInit) {
            createAccessibilityDelegateForLynxViewIfNeeded();
        }
    }

    private boolean enableNodeProvider() {
        return (this.mConfigEnableNewAccessibility || this.mConfigEnableA11y || this.mNodeProvider == null) ? false : true;
    }

    public boolean enableDelegate() {
        return (!this.mConfigEnableNewAccessibility || this.mConfigEnableA11y || this.mDelegate == null) ? false : true;
    }

    public boolean enableHelper() {
        return (this.mConfigEnableNewAccessibility || !this.mConfigEnableA11y || this.mHelper == null) ? false : true;
    }

    public LynxAccessibilityHelper getLynxAccessibilityHelper() {
        return this.mHelper;
    }

    private UIBody getUIBody() {
        WeakReference<UIBody> weakReference = this.mWeakHostUI;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
