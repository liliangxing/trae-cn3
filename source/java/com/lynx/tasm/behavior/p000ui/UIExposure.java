package com.lynx.tasm.behavior.p000ui;

import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.Choreographer;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxObserverManager;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.UnitUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIExposure extends LynxObserverManager {
    private final String TAG;
    private final String UIAPPEAREVENT;
    private final String UIDISAPPEAREVENT;
    private final CallBack mCallBack;
    private ICallBack mCallback;
    private final HashMap<String, UIExposureDetail> mExposureDetailMap;
    private boolean mIsStopExposure;
    private HashSet<UIExposureDetail> mUiInWindowBefore;
    private HashSet<UIExposureDetail> mUiInWindowNow;
    private RectF mWindowRect;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ICallBack {
        boolean canSendGlobalEvent();

        LynxBaseUI findNode(int i);

        void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ExposureCallback implements ICallBack {
        private final WeakReference<LynxContext> mWeakContext;

        public ExposureCallback(WeakReference<LynxContext> weakReference) {
            this.mWeakContext = weakReference;
        }

        @Override // com.lynx.tasm.behavior.ui.UIExposure.ICallBack
        public boolean canSendGlobalEvent() {
            LynxContext lynxContext = this.mWeakContext.get();
            if (lynxContext == null) {
                LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxContext.");
                return true;
            }
            LynxView lynxView = lynxContext.getLynxView();
            if (lynxView != null) {
                return lynxView.enableJSRuntime() || lynxView.enableAirStrictMode();
            }
            LLog.e("UIExposure", "canSendGlobalEvent check failed since can not get LynxView.");
            return true;
        }

        @Override // com.lynx.tasm.behavior.ui.UIExposure.ICallBack
        public void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
            LynxContext lynxContext = this.mWeakContext.get();
            if (lynxContext == null) {
                LLog.e("UIExposure", "sendGlobalEvent failed since can not get LynxContext.");
                return;
            }
            LynxView lynxView = lynxContext.getLynxView();
            if (lynxView == null) {
                LLog.e("UIExposure", "sendGlobalEvent failed since can not get LynxView.");
            } else {
                lynxView.sendGlobalEvent(str, javaOnlyArray);
            }
        }

        @Override // com.lynx.tasm.behavior.ui.UIExposure.ICallBack
        public LynxBaseUI findNode(int i) {
            LynxContext lynxContext = this.mWeakContext.get();
            if (lynxContext == null) {
                LLog.e("UIExposure", "findNode failed since can not get LynxContext.");
                return null;
            }
            if (lynxContext.getLynxUIOwner() == null) {
                LLog.e("UIExposure", "findNode failed since can not get LynxUIOwner.");
                return null;
            }
            return lynxContext.getLynxUIOwner().getNode(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class CallBack implements Choreographer.FrameCallback {
        private final WeakReference<UIExposure> mExposure;

        private CallBack(UIExposure uIExposure) {
            this.mExposure = new WeakReference<>(uIExposure);
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            UIExposure uIExposure = this.mExposure.get();
            if (uIExposure != null) {
                uIExposure.observerHandlerInner();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class UIExposureDetail {
        private final ReadableMap mDataSet;
        private final String mExposureID;
        private final String mExposureScene;
        private final JavaOnlyMap mExtraData;
        private final int mSign;
        private final WeakReference<LynxBaseUI> mUI;
        private final String mUniqueID;
        private final JavaOnlyMap mUseOptions;

        UIExposureDetail(LynxBaseUI lynxBaseUI, String str, JavaOnlyMap javaOnlyMap, JavaOnlyMap javaOnlyMap2) {
            this.mUI = new WeakReference<>(lynxBaseUI);
            if (lynxBaseUI.getExposureID() == null) {
                this.mExposureID = "";
            } else {
                this.mExposureID = lynxBaseUI.getExposureID();
            }
            if (lynxBaseUI.getExposureScene() == null) {
                this.mExposureScene = "";
            } else {
                this.mExposureScene = lynxBaseUI.getExposureScene();
            }
            this.mSign = lynxBaseUI.getSign();
            this.mDataSet = lynxBaseUI.getDataset();
            this.mUniqueID = str == null ? "" : str;
            this.mExtraData = javaOnlyMap != null ? JavaOnlyMap.from(javaOnlyMap) : new JavaOnlyMap();
            this.mUseOptions = javaOnlyMap2;
        }

        public int getSign() {
            return this.mSign;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UIExposureDetail uIExposureDetail = (UIExposureDetail) obj;
            return this.mSign == uIExposureDetail.mSign && this.mExposureScene.equals(uIExposureDetail.mExposureScene) && this.mExposureID.equals(uIExposureDetail.mExposureID) && this.mUniqueID.equals(uIExposureDetail.mUniqueID);
        }

        public int hashCode() {
            LynxBaseUI lynxBaseUI = this.mUI.get();
            if (lynxBaseUI != null) {
                return lynxBaseUI.hashCode();
            }
            return 0;
        }

        public HashMap<String, Object> toMap() {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(PropsConstants.EXPOSURE_ID, this.mExposureID);
            hashMap.put(PropsConstants.EXPOSURE_SCENE, this.mExposureScene);
            hashMap.put(PropsConstants.DATASET, this.mDataSet);
            hashMap.put("unique-id", this.mUniqueID);
            hashMap.put("extra-data", this.mExtraData);
            return hashMap;
        }
    }

    public UIExposure() {
        super("Lynx.UIExposure");
        this.mWindowRect = null;
        this.mCallback = null;
        this.TAG = "Lynx.UIExposure";
        this.UIAPPEAREVENT = "uiappear";
        this.UIDISAPPEAREVENT = "uidisappear";
        this.mExposureDetailMap = new HashMap<>();
        this.mUiInWindowBefore = new HashSet<>();
        this.mUiInWindowNow = new HashSet<>();
        this.mRootBodyRef = new WeakReference<>(null);
        this.mCallBack = new CallBack();
    }

    public void setCallback(ICallBack iCallBack) {
        this.mCallback = iCallBack;
    }

    boolean canSendGlobalEvent() {
        ICallBack iCallBack = this.mCallback;
        if (iCallBack == null) {
            LLog.e("Lynx.UIExposure", "canSendGlobalEvent check failed since mCallback is null.");
            return true;
        }
        return iCallBack.canSendGlobalEvent();
    }

    void sendGlobalEvent(String str, JavaOnlyArray javaOnlyArray) {
        ICallBack iCallBack = this.mCallback;
        if (iCallBack == null) {
            LLog.e("Lynx.UIExposure", "sendEvent failed since mCallback is null.");
        } else {
            iCallBack.sendGlobalEvent(str, javaOnlyArray);
        }
    }

    LynxBaseUI findNode(int i) {
        ICallBack iCallBack = this.mCallback;
        if (iCallBack == null) {
            LLog.e("Lynx.UIExposure", "findNode failed since mCallback is null.");
            return null;
        }
        return iCallBack.findNode(i);
    }

    private float getIntersectionAreaRatio(RectF rectF, RectF rectF2) {
        RectF rectF3 = new RectF();
        if (!rectF3.setIntersect(rectF, rectF2)) {
            return 0.0f;
        }
        return (rectF3.height() * rectF3.width()) / (rectF.height() * rectF.width());
    }

    private boolean checkIntersect(RectF rectF, RectF rectF2, float f) {
        if (f != 0.0f) {
            return getIntersectionAreaRatio(rectF, rectF2) >= f;
        }
        return RectF.intersects(rectF, rectF2);
    }

    private RectF getUIRect(LynxBaseUI lynxBaseUI) {
        RectF boundsOnScreenOfLynxBaseUI = getBoundsOnScreenOfLynxBaseUI(lynxBaseUI);
        if (lynxBaseUI.getEnableExposureUIMargin()) {
            float width = boundsOnScreenOfLynxBaseUI.width();
            float height = boundsOnScreenOfLynxBaseUI.height();
            DisplayMetrics screenMetrics = lynxBaseUI.getLynxContext().getScreenMetrics();
            float pxWithDisplayMetrics = UnitUtils.toPxWithDisplayMetrics(lynxBaseUI.getExposureUIMarginLeft(), 0.0f, 0.0f, 0.0f, 0.0f, width, 0.0f, screenMetrics);
            float pxWithDisplayMetrics2 = UnitUtils.toPxWithDisplayMetrics(lynxBaseUI.getExposureUIMarginRight(), 0.0f, 0.0f, 0.0f, 0.0f, width, 0.0f, screenMetrics);
            float pxWithDisplayMetrics3 = UnitUtils.toPxWithDisplayMetrics(lynxBaseUI.getExposureUIMarginTop(), 0.0f, 0.0f, 0.0f, 0.0f, height, 0.0f, screenMetrics);
            float pxWithDisplayMetrics4 = UnitUtils.toPxWithDisplayMetrics(lynxBaseUI.getExposureUIMarginBottom(), 0.0f, 0.0f, 0.0f, 0.0f, height, 0.0f, screenMetrics);
            if (width + pxWithDisplayMetrics + pxWithDisplayMetrics2 <= 0.0f || height + pxWithDisplayMetrics3 + pxWithDisplayMetrics4 <= 0.0f) {
                return new RectF();
            }
            boundsOnScreenOfLynxBaseUI.left -= pxWithDisplayMetrics;
            boundsOnScreenOfLynxBaseUI.top -= pxWithDisplayMetrics3;
            boundsOnScreenOfLynxBaseUI.right += pxWithDisplayMetrics2;
            boundsOnScreenOfLynxBaseUI.bottom += pxWithDisplayMetrics4;
        } else {
            boundsOnScreenOfLynxBaseUI.left -= lynxBaseUI.getExposureScreenMarginRight() > 0.0f ? lynxBaseUI.getExposureScreenMarginRight() : 0.0f;
            boundsOnScreenOfLynxBaseUI.right += lynxBaseUI.getExposureScreenMarginLeft() > 0.0f ? lynxBaseUI.getExposureScreenMarginLeft() : 0.0f;
            boundsOnScreenOfLynxBaseUI.top -= lynxBaseUI.getExposureScreenMarginBottom() > 0.0f ? lynxBaseUI.getExposureScreenMarginBottom() : 0.0f;
            boundsOnScreenOfLynxBaseUI.bottom += lynxBaseUI.getExposureScreenMarginTop() > 0.0f ? lynxBaseUI.getExposureScreenMarginTop() : 0.0f;
        }
        return boundsOnScreenOfLynxBaseUI;
    }

    private RectF getBorderOfWindowRect(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI.getEnableExposureUIMargin()) {
            if (this.mWindowRect == null) {
                this.mWindowRect = getWindowRect(lynxBaseUI.getLynxContext());
            }
            RectF rectF = new RectF(this.mWindowRect);
            if (rectF.width() + lynxBaseUI.getExposureScreenMarginLeft() + lynxBaseUI.getExposureScreenMarginRight() <= 0.0f || rectF.height() + lynxBaseUI.getExposureScreenMarginTop() + lynxBaseUI.getExposureScreenMarginBottom() <= 0.0f) {
                return new RectF();
            }
            rectF.left -= lynxBaseUI.getExposureScreenMarginLeft();
            rectF.top -= lynxBaseUI.getExposureScreenMarginTop();
            rectF.right += lynxBaseUI.getExposureScreenMarginRight();
            rectF.bottom += lynxBaseUI.getExposureScreenMarginBottom();
            return rectF;
        }
        return new RectF(this.mWindowRect.left - ((int) (lynxBaseUI.getExposureScreenMarginLeft() < 0.0f ? lynxBaseUI.getExposureScreenMarginLeft() : 0.0f)), this.mWindowRect.top - ((int) (lynxBaseUI.getExposureScreenMarginTop() < 0.0f ? lynxBaseUI.getExposureScreenMarginTop() : 0.0f)), this.mWindowRect.right + ((int) (lynxBaseUI.getExposureScreenMarginRight() < 0.0f ? lynxBaseUI.getExposureScreenMarginRight() : 0.0f)), this.mWindowRect.bottom + ((int) (lynxBaseUI.getExposureScreenMarginBottom() < 0.0f ? lynxBaseUI.getExposureScreenMarginBottom() : 0.0f)));
    }

    private boolean inWindow(LynxBaseUI lynxBaseUI) {
        boolean z;
        if (lynxBaseUI.getHeight() == 0 || lynxBaseUI.getWidth() == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (LynxBaseUI lynxBaseUI2 = lynxBaseUI; lynxBaseUI2 != null && lynxBaseUI2 != this.mRootBodyRef.get(); lynxBaseUI2 = (LynxBaseUI) lynxBaseUI2.getParent()) {
            if ((lynxBaseUI2 instanceof LynxUI) && !((LynxUI) lynxBaseUI2).isVisible()) {
                return false;
            }
            if (lynxBaseUI2.getEnableExposureUIClip() == EventTarget.EnableStatus.Enable || (lynxBaseUI2.getEnableExposureUIClip() == EventTarget.EnableStatus.Undefined && lynxBaseUI2.isScrollContainer())) {
                arrayList.add(lynxBaseUI2);
            }
            if (lynxBaseUI2.isOverlay()) {
                z = true;
                break;
            }
        }
        z = false;
        RectF uIRect = getUIRect(lynxBaseUI);
        float px = UnitUtils.toPx(lynxBaseUI.getExposureArea());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!checkIntersect(uIRect, getBoundsOnScreenOfLynxBaseUI((LynxBaseUI) it.next()), px)) {
                return false;
            }
        }
        RectF boundsOnScreenOfLynxBaseUI = getBoundsOnScreenOfLynxBaseUI(this.mRootBodyRef.get());
        if (this.mWindowRect == null) {
            this.mWindowRect = getWindowRect(lynxBaseUI.getLynxContext());
        }
        boolean checkIntersect = !z ? checkIntersect(uIRect, boundsOnScreenOfLynxBaseUI, px) : true;
        if (this.mWindowRect == null) {
            return checkIntersect;
        }
        RectF borderOfWindowRect = getBorderOfWindowRect(lynxBaseUI);
        return checkIntersect && checkIntersect(uIRect, borderOfWindowRect, px) && checkIntersect(boundsOnScreenOfLynxBaseUI, borderOfWindowRect, 0.0f);
    }

    @Override // com.lynx.tasm.behavior.LynxObserverManager
    protected void observerHandlerInner() {
        if (this.mIsStopExposure) {
            LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since lynx.stopExposure() is called");
            didObserveInner();
            return;
        }
        if (!this.mRootViewPainted) {
            LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView not draw");
            didObserveInner();
            return;
        }
        UIBody.UIBodyView rootView = getRootView();
        if (rootView == null) {
            LLog.e("Lynx.UIExposure", "Lynx exposureHandler failed since rootView is null");
            didObserveInner();
            return;
        }
        if (!rootView.isShown()) {
            if (this.mEnableDisexposureWhenLynxHidden) {
                sendEvent(new HashSet<>(this.mUiInWindowBefore), "disexposure");
                this.mUiInWindowBefore.clear();
            }
            didObserveInner();
            return;
        }
        if (!this.mEnableExposureWhenLayout && rootView.isLayoutRequested()) {
            postHandlerCallBackDelay(this.mCallBack);
            return;
        }
        this.mWindowRect = getWindowRect(this.mRootBodyRef.get().getLynxContext());
        for (UIExposureDetail uIExposureDetail : this.mExposureDetailMap.values()) {
            LynxBaseUI lynxBaseUI = (LynxBaseUI) uIExposureDetail.mUI.get();
            if (lynxBaseUI != null && inWindow(lynxBaseUI)) {
                this.mUiInWindowNow.add(uIExposureDetail);
            }
        }
        HashSet<UIExposureDetail> hashSet = new HashSet<>();
        hashSet.addAll(this.mUiInWindowBefore);
        hashSet.removeAll(this.mUiInWindowNow);
        HashSet<UIExposureDetail> hashSet2 = new HashSet<>();
        hashSet2.addAll(this.mUiInWindowNow);
        hashSet2.removeAll(this.mUiInWindowBefore);
        this.mUiInWindowBefore = this.mUiInWindowNow;
        this.mUiInWindowNow = new HashSet<>();
        sendEvent(hashSet, "disexposure");
        sendEvent(hashSet2, "exposure");
        didObserveInner();
    }

    public void stopExposure(HashMap<String, Object> hashMap) {
        LLog.i("Lynx.UIExposure", "stopExposure");
        this.mIsStopExposure = true;
        destroy();
        if (hashMap == null || (hashMap.containsKey("sendEvent") && ((Boolean) hashMap.get("sendEvent")).booleanValue())) {
            sendEvent(this.mUiInWindowBefore, "disexposure");
            this.mUiInWindowBefore.clear();
        }
    }

    public void resumeExposure() {
        LLog.i("Lynx.UIExposure", "resumeExposure");
        this.mIsStopExposure = false;
        addToObserverTree();
    }

    protected void sendEvent(HashSet<UIExposureDetail> hashSet, String str) {
        if (getRootView() == null || hashSet.isEmpty()) {
            return;
        }
        if (canSendGlobalEvent()) {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            HashMap<LynxBaseUI, HashMap<String, ArrayList<UIExposureDetail>>> hashMap = new HashMap<>();
            Iterator<UIExposureDetail> it = hashSet.iterator();
            while (it.hasNext()) {
                UIExposureDetail next = it.next();
                if (next.mUseOptions != null && next.mUseOptions.containsKey("sendCustom") && next.mUseOptions.getBoolean("sendCustom")) {
                    if (!next.mUseOptions.containsKey("specifyTarget") || !next.mUseOptions.getBoolean("specifyTarget")) {
                        LynxBaseUI lynxBaseUI = (LynxBaseUI) next.mUI.get();
                        String str2 = str == "exposure" ? "uiappear" : "uidisappear";
                        if (lynxBaseUI != null && lynxBaseUI.getEvents() != null && lynxBaseUI.getEvents().containsKey(str2)) {
                            lynxBaseUI.getLynxContext().getEventEmitter().sendCustomEvent(new LynxDetailEvent(lynxBaseUI.getSign(), str2, next.toMap()));
                        }
                    } else {
                        addDetailToCustomParamMap(hashMap, next);
                    }
                } else {
                    javaOnlyArray.pushMap(createResult(next));
                }
            }
            sendCustomParamMapEvent(hashMap, str);
            if (javaOnlyArray.size() > 0) {
                JavaOnlyArray javaOnlyArray2 = new JavaOnlyArray();
                javaOnlyArray2.add(javaOnlyArray);
                sendGlobalEvent(str, javaOnlyArray2);
                return;
            }
            return;
        }
        Iterator<UIExposureDetail> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            UIExposureDetail next2 = it2.next();
            LynxBaseUI findNode = findNode(next2.getSign());
            if (findNode != null && findNode.getEvents() != null && findNode.getEvents().containsKey(str)) {
                findNode.getLynxContext().getEventEmitter().sendCustomEvent(new LynxDetailEvent(findNode.getSign(), str, next2.toMap()));
            }
        }
    }

    private void sendCustomParamMapEvent(HashMap<LynxBaseUI, HashMap<String, ArrayList<UIExposureDetail>>> hashMap, String str) {
        if (hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<LynxBaseUI, HashMap<String, ArrayList<UIExposureDetail>>> entry : hashMap.entrySet()) {
            LynxBaseUI key = entry.getKey();
            for (Map.Entry<String, ArrayList<UIExposureDetail>> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                Iterator<UIExposureDetail> it = entry2.getValue().iterator();
                while (it.hasNext()) {
                    javaOnlyArray.pushMap(createChildUIResult(it.next()));
                }
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                javaOnlyMap.put("isExposure", Boolean.valueOf(str == "exposure"));
                javaOnlyMap.put("childrenInfo", javaOnlyArray);
                key.getLynxContext().getEventEmitter().sendCustomEvent(new LynxDetailEvent(key.getSign(), key2, javaOnlyMap));
            }
        }
    }

    private void addDetailToCustomParamMap(HashMap<LynxBaseUI, HashMap<String, ArrayList<UIExposureDetail>>> hashMap, UIExposureDetail uIExposureDetail) {
        LynxBaseUI lynxBaseUI = (LynxBaseUI) uIExposureDetail.mUI.get();
        if (lynxBaseUI == null) {
            return;
        }
        LynxBaseUI exposeReceiveTarget = lynxBaseUI.getExposeReceiveTarget();
        String string = uIExposureDetail.mUseOptions.getString("bindEventName");
        if (exposeReceiveTarget == null || exposeReceiveTarget.getEvents() == null || string == null || !exposeReceiveTarget.getEvents().containsKey(string)) {
            return;
        }
        if (hashMap.containsKey(exposeReceiveTarget)) {
            HashMap<String, ArrayList<UIExposureDetail>> hashMap2 = hashMap.get(exposeReceiveTarget);
            if (hashMap2.containsKey(string)) {
                hashMap2.get(string).add(uIExposureDetail);
                return;
            } else {
                hashMap2.put(string, new ArrayList<>());
                hashMap2.get(string).add(uIExposureDetail);
                return;
            }
        }
        HashMap<String, ArrayList<UIExposureDetail>> hashMap3 = new HashMap<>();
        ArrayList<UIExposureDetail> arrayList = new ArrayList<>();
        arrayList.add(uIExposureDetail);
        hashMap3.put(string, arrayList);
        hashMap.put(exposeReceiveTarget, hashMap3);
    }

    public void addUIToExposedMap(final LynxBaseUI lynxBaseUI, final String str, final JavaOnlyMap javaOnlyMap, final JavaOnlyMap javaOnlyMap2) {
        String str2;
        if (str == null && lynxBaseUI.getExposureID() == null) {
            return;
        }
        if (str != null) {
            str2 = str + RomUtils.SEPARATOR + lynxBaseUI.getExposureScene() + RomUtils.SEPARATOR + lynxBaseUI.getExposureID();
        } else {
            str2 = lynxBaseUI.getExposureScene() + RomUtils.SEPARATOR + lynxBaseUI.getExposureID() + RomUtils.SEPARATOR + lynxBaseUI.getSign();
        }
        final String str3 = str2;
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.UIExposure.1
            @Override // java.lang.Runnable
            public void run() {
                if (!UIExposure.this.mIsStopExposure && UIExposure.this.mExposureDetailMap.isEmpty()) {
                    UIExposure.this.addToObserverTree();
                }
                UIExposure.this.mExposureDetailMap.put(str3, new UIExposureDetail(lynxBaseUI, str, javaOnlyMap, javaOnlyMap2));
            }
        });
    }

    public void removeUIFromExposedMap(LynxBaseUI lynxBaseUI, String str) {
        final String str2;
        if (str == null && lynxBaseUI.getExposureID() == null) {
            return;
        }
        if (str != null) {
            str2 = str + RomUtils.SEPARATOR + lynxBaseUI.getExposureScene() + RomUtils.SEPARATOR + lynxBaseUI.getExposureID();
        } else {
            str2 = lynxBaseUI.getExposureScene() + RomUtils.SEPARATOR + lynxBaseUI.getExposureID() + RomUtils.SEPARATOR + lynxBaseUI.getSign();
        }
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.UIExposure.2
            @Override // java.lang.Runnable
            public void run() {
                if (UIExposure.this.mExposureDetailMap.get(str2) == null) {
                    return;
                }
                if (((LynxBaseUI) ((UIExposureDetail) UIExposure.this.mExposureDetailMap.get(str2)).mUI.get()) != null) {
                    UIExposure.this.mExposureDetailMap.remove(str2);
                }
                if (UIExposure.this.mExposureDetailMap.isEmpty()) {
                    UIExposure.this.clear();
                }
            }
        });
    }

    public void setRootUI(UIBody uIBody) {
        this.mRootBodyRef = new WeakReference<>(uIBody);
    }

    private JavaOnlyMap createResult(UIExposureDetail uIExposureDetail) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put(PropsConstants.EXPOSURE_ID, uIExposureDetail.mExposureID);
        javaOnlyMap.put("exposureID", uIExposureDetail.mExposureID);
        javaOnlyMap.put(PropsConstants.EXPOSURE_SCENE, uIExposureDetail.mExposureScene);
        javaOnlyMap.put("exposureScene", uIExposureDetail.mExposureScene);
        javaOnlyMap.put("sign", String.valueOf(uIExposureDetail.mSign));
        javaOnlyMap.put("dataSet", uIExposureDetail.mDataSet);
        javaOnlyMap.put(PropsConstants.DATASET, uIExposureDetail.mDataSet);
        javaOnlyMap.put("unique-id", uIExposureDetail.mUniqueID);
        javaOnlyMap.put("extra-data", uIExposureDetail.mExtraData);
        return javaOnlyMap;
    }

    private JavaOnlyMap createChildUIResult(UIExposureDetail uIExposureDetail) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("extra-data", uIExposureDetail.mExtraData);
        return javaOnlyMap;
    }

    public void clear() {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.ui.UIExposure.3
            @Override // java.lang.Runnable
            public void run() {
                UIExposure.this.destroy();
                UIExposure.this.mExposureDetailMap.clear();
                UIExposure uIExposure = UIExposure.this;
                uIExposure.sendEvent(uIExposure.mUiInWindowBefore, "disexposure");
                UIExposure.this.mUiInWindowBefore.clear();
            }
        });
    }
}
