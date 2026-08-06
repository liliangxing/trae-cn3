package com.lynx.tasm.behavior;

import android.graphics.Rect;
import android.text.TextUtils;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.animation.keyframe.KeyframeManager;
import com.lynx.tasm.animation.transition.TransitionAnimationManager;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.p000ui.UIParams;
import com.lynx.tasm.behavior.p000ui.UIShadowProxy;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.p000ui.swiper.XSwiperUI;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextMeasurer;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.gesture.LynxNewGestureDelegate;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.p001ui.image.TraceEventDef;
import com.lynx.tasm.utils.LynxConstants;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.update.UpdateDialogNewBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIOwner {
    private static final String LYNXSDK_ASYNC_CREATE_CONFIG = "lynxsdk_async_create_config";
    private static final String LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT = "lynxsdk_async_create_success_event";
    private static final String LYNXSDK_COMPONENT_STATISTIC_EVENT = "lynxsdk_component_statistic";
    private static final String TAG = "LynxUIOwner";
    private static final Comparator<LynxBaseUI> translationZComparator = new Comparator<LynxBaseUI>() { // from class: com.lynx.tasm.behavior.LynxUIOwner.7
        @Override // java.util.Comparator
        public int compare(LynxBaseUI lynxBaseUI, LynxBaseUI lynxBaseUI2) {
            if (lynxBaseUI.getTranslationZ() > lynxBaseUI2.getTranslationZ()) {
                return 1;
            }
            return lynxBaseUI.getTranslationZ() == lynxBaseUI2.getTranslationZ() ? 0 : -1;
        }
    };
    private UIBody.UIBodyView.attachLynxPageUICallback mAttachLynxPageUICallback;
    private final BehaviorRegistry mBehaviorRegistry;
    private final HashSet<LynxBaseUI> mCachedBoundingClientRectUI;
    private final HashMap<String, Integer> mComponentIdToUiIdHolder;
    private final Set<String> mComponentSet;
    private LynxContext mContext;
    private HashMap<String, Boolean> mCreateNodeConfigHasReportedMark;
    private boolean mEnableReportCreateAsync;
    private final List<ForegroundListener> mForegroundListeners;
    private GestureArenaManager mGestureArenaManager;
    private boolean mHasTouchPseudo;
    private boolean mIsFirstLayout;
    private boolean mIsRootLayoutAnimationRunning;
    private WeakReference<NativeFacade> mNativeFacade;
    private int mRootSign;
    private final HashMap<Integer, LynxBaseUI> mTextChildUIHolder;
    private TextMeasurer mTextMeasurer;
    private final HashSet<LynxBaseUI> mTranslateZParentHolder;
    private UIBody mUIBody;
    private final HashMap<Integer, LynxBaseUI> mUIHolder;
    private boolean mIsContextFree = false;
    private Boolean mSettingsEnableNewImage = null;
    private final ConcurrentLinkedQueue<FutureTask<Runnable>> mCreateNodeAsyncTasks = new ConcurrentLinkedQueue<>();

    private int getSignFromOperationId(long j) {
        return (int) (j >>> 32);
    }

    public LynxUIOwner(LynxContext lynxContext, BehaviorRegistry behaviorRegistry, UIBody.UIBodyView uIBodyView) {
        TraceEvent.beginSection("LynxUIOwner initialized");
        this.mContext = lynxContext;
        this.mBehaviorRegistry = behaviorRegistry;
        this.mComponentSet = ConcurrentHashMap.newKeySet();
        this.mTranslateZParentHolder = new HashSet<>();
        this.mForegroundListeners = new ArrayList();
        this.mUIHolder = new HashMap<>();
        this.mTextChildUIHolder = new HashMap<>();
        this.mComponentIdToUiIdHolder = new HashMap<>();
        this.mRootSign = -1;
        UIBody uIBody = new UIBody(this.mContext, uIBodyView);
        this.mUIBody = uIBody;
        this.mContext.setUIBody(uIBody);
        this.mIsFirstLayout = true;
        this.mIsRootLayoutAnimationRunning = true;
        this.mCachedBoundingClientRectUI = new HashSet<>();
        this.mEnableReportCreateAsync = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_REPORT_CREATE_ASYNC_TAG, false);
        this.mCreateNodeConfigHasReportedMark = new HashMap<>();
        if (lynxContext.isLayoutInElementModeOn()) {
            this.mTextMeasurer = new TextMeasurer(lynxContext);
        }
        attachUIBodyView(uIBodyView);
        TraceEvent.endSection("LynxUIOwner initialized");
    }

    public void attachUIBodyView(UIBody.UIBodyView uIBodyView) {
        this.mUIBody.attachUIBodyView(uIBodyView, this.mContext);
        if (isContextFree()) {
            while (!this.mCreateNodeAsyncTasks.isEmpty()) {
                final FutureTask<Runnable> poll = this.mCreateNodeAsyncTasks.poll();
                if (poll != null) {
                    LynxThreadPool.postUIOperationTask(new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.1
                        @Override // java.lang.Runnable
                        public void run() {
                            poll.run();
                        }
                    });
                }
            }
        }
    }

    public void attachLynxContext(LynxContext lynxContext) {
        if (lynxContext != null) {
            this.mContext = lynxContext;
        }
    }

    public void attachNativeFacade(NativeFacade nativeFacade) {
        this.mNativeFacade = new WeakReference<>(nativeFacade);
    }

    public void updateProperties(int i, boolean z, StylesDiffMap stylesDiffMap, Map<String, EventsListener> map, Map<Integer, GestureDetector> map2) {
        String str;
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI == null) {
            return;
        }
        updateComponentIdToUiIdMapIfNeeded(i, lynxBaseUI.getTagName(), stylesDiffMap);
        if (TraceEvent.isTracingStarted()) {
            str = "UIOwner.updateProps." + lynxBaseUI.getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        if (map != null) {
            lynxBaseUI.setEvents(map);
        }
        if (map2 != null) {
            lynxBaseUI.setGestureDetectors(map2);
        }
        if (!z && lynxBaseUI.isFlatten()) {
            updateFlatten(i, false);
            lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        }
        if (stylesDiffMap != null && !stylesDiffMap.isEmpty()) {
            if (TransitionAnimationManager.hasTransitionAnimation(stylesDiffMap)) {
                if (lynxBaseUI instanceof UIShadowProxy) {
                    ((UIShadowProxy) lynxBaseUI).getChild().initTransitionAnimator(stylesDiffMap.mBackingMap);
                } else {
                    lynxBaseUI.initTransitionAnimator(stylesDiffMap.mBackingMap);
                }
            }
            if (KeyframeManager.hasKeyframeAnimation(stylesDiffMap)) {
                if (lynxBaseUI instanceof UIShadowProxy) {
                    ((UIShadowProxy) lynxBaseUI).getChild().setAnimation(stylesDiffMap.getArray(PropsConstants.ANIMATION));
                } else {
                    lynxBaseUI.setAnimation(stylesDiffMap.getArray(PropsConstants.ANIMATION));
                }
            }
            checkShadowOrOutline(stylesDiffMap, lynxBaseUI);
        }
        lynxBaseUI.updateProperties(stylesDiffMap);
        checkTranslateZ(lynxBaseUI);
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    public void initGestureArenaManager(LynxContext lynxContext) {
        if (this.mGestureArenaManager == null) {
            this.mGestureArenaManager = new GestureArenaManager();
        }
        this.mGestureArenaManager.init(true, lynxContext);
    }

    private void addShadowProxy(LynxBaseUI lynxBaseUI) {
        int i;
        LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
        if (parentBaseUI != null) {
            i = parentBaseUI.getIndex(lynxBaseUI);
            remove(parentBaseUI.getSign(), lynxBaseUI.getSign());
        } else {
            i = 0;
        }
        this.mContext.removeUIFromExposedMap(lynxBaseUI);
        UIShadowProxy uIShadowProxy = new UIShadowProxy(this.mContext, lynxBaseUI);
        this.mUIHolder.put(Integer.valueOf(lynxBaseUI.getSign()), uIShadowProxy);
        if (parentBaseUI != null) {
            insert(parentBaseUI.getSign(), uIShadowProxy.getSign(), i);
        }
    }

    private void checkShadowOrOutline(StylesDiffMap stylesDiffMap, LynxBaseUI lynxBaseUI) {
        if (hasShadowOrOutline(stylesDiffMap)) {
            if ((stylesDiffMap.getArray(PropsConstants.BOX_SHADOW) == null && stylesDiffMap.getInt(PropsConstants.OUTLINE_STYLE, -1) == -1) || (lynxBaseUI instanceof UIShadowProxy) || (lynxBaseUI.getParent() instanceof UIShadowProxy)) {
                return;
            }
            addShadowProxy(lynxBaseUI);
        }
    }

    public void updateViewExtraData(int i, Object obj) {
        String str;
        UIThreadUtils.assertOnUiThread();
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI != null) {
            if (TraceEvent.isTracingStarted()) {
                str = "UIOwner.updateViewExtraData." + lynxBaseUI.getTagName();
                TraceEvent.beginSection(str);
            } else {
                str = null;
            }
            lynxBaseUI.updateExtraData(obj);
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str);
            }
        }
    }

    public void pauseRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = false;
    }

    public void resumeRootLayoutAnimation() {
        this.mIsRootLayoutAnimationRunning = true;
    }

    public void rebuildViewTree() {
        String str;
        if (TraceEvent.isTracingStarted()) {
            str = "UIOwner.rebuildViewTree";
            TraceEvent.beginSection("UIOwner.rebuildViewTree");
        } else {
            str = null;
        }
        this.mUIBody.rebuildViewTree();
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    public void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Rect rect, float[] fArr, float f, int i18) {
        int i19;
        int i20;
        LynxBaseUI lynxBaseUI;
        String str;
        int i21;
        LynxBaseUI lynxBaseUI2 = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI2 == null) {
            LynxError lynxError = new LynxError(60301, "Can't find ui tag");
            lynxError.addCustomInfo("node_index", Integer.toString(i18));
            this.mContext.handleLynxError(lynxError);
            return;
        }
        boolean z = lynxBaseUI2 instanceof UIShadowProxy;
        if (z) {
            lynxBaseUI = ((UIShadowProxy) lynxBaseUI2).getChild();
            i19 = i4;
            i20 = i5;
        } else {
            i19 = i4;
            i20 = i5;
            lynxBaseUI = lynxBaseUI2;
        }
        lynxBaseUI.updateLayoutSize(i19, i20);
        if (lynxBaseUI2.getLayoutAnimator() != null) {
            lynxBaseUI2.getLayoutAnimator().updateLatestLayoutInfo(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, rect);
        }
        TransitionAnimationManager transitionAnimator = lynxBaseUI2.getTransitionAnimator();
        if (TraceEvent.isTracingStarted()) {
            str = "UIOwner.updateLayout." + lynxBaseUI2.getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        String str2 = str;
        if (transitionAnimator != null && transitionAnimator.containLayoutTransition() && !this.mIsFirstLayout && !lynxBaseUI2.isFirstAnimatedReady()) {
            transitionAnimator.applyLayoutTransition(z ? (LynxUI) ((UIShadowProxy) lynxBaseUI2).getChild() : (LynxUI) lynxBaseUI2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, rect);
            this.mUIBody.invalidate();
        } else if (lynxBaseUI2.enableLayoutAnimation() && !this.mIsFirstLayout && (i != (i21 = this.mRootSign) || (i == i21 && this.mIsRootLayoutAnimationRunning))) {
            lynxBaseUI2.getLayoutAnimator().applyLayoutUpdate(z ? (LynxUI) ((UIShadowProxy) lynxBaseUI2).getChild() : (LynxUI) lynxBaseUI2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, rect);
            this.mUIBody.invalidate();
        } else {
            lynxBaseUI2.updateLayout(i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, rect);
        }
        lynxBaseUI2.updateSticky(fArr);
        lynxBaseUI2.updateMaxHeight(f);
        insertA11yMutationEvent(3, lynxBaseUI2);
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str2);
        }
    }

    private void checkTranslateZ(LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI.getParentBaseUI() != null) {
            checkTranslateZ(lynxBaseUI.getSign(), lynxBaseUI.getParentBaseUI().getSign());
        }
    }

    private void checkTranslateZ(int i, int i2) {
        LynxBaseUI lynxBaseUI;
        if (!this.mContext.getEnableFlattenTranslateZ() || (lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i))) == null || lynxBaseUI.getTranslationZ() == lynxBaseUI.getLastTranslateZ()) {
            return;
        }
        LynxBaseUI lynxBaseUI2 = this.mUIHolder.get(Integer.valueOf(i2));
        if (lynxBaseUI2 != null && lynxBaseUI2.isFlatten()) {
            newUpdateFlatten(i2, false);
        }
        LynxBaseUI lynxBaseUI3 = this.mUIHolder.get(Integer.valueOf(i2));
        this.mTranslateZParentHolder.add(lynxBaseUI3);
        lynxBaseUI3.setNeedSortChildren(true);
        lynxBaseUI.setLastTranslateZ(lynxBaseUI.getTranslationZ());
    }

    public void setFirstLayout() {
        this.mIsFirstLayout = false;
    }

    public void onNodeReady(int i) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI != null) {
            if (lynxBaseUI instanceof UIShadowProxy) {
                lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
            }
            lynxBaseUI.onNodeReady();
        }
    }

    public void onNodeReload(int i) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI != null) {
            if (lynxBaseUI instanceof UIShadowProxy) {
                lynxBaseUI = ((UIShadowProxy) lynxBaseUI).getChild();
            }
            lynxBaseUI.onNodeReload();
        }
    }

    public void onNodeRemoved(int i) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI != null) {
            onNodeRemovedRecursively(lynxBaseUI);
        }
    }

    private void onNodeRemovedRecursively(LynxBaseUI lynxBaseUI) {
        boolean z = lynxBaseUI instanceof UIShadowProxy;
        (z ? ((UIShadowProxy) lynxBaseUI).getChild() : lynxBaseUI).onNodeRemoved();
        if (z) {
            return;
        }
        Iterator<LynxBaseUI> it = lynxBaseUI.getChildren().iterator();
        while (it.hasNext()) {
            onNodeRemovedRecursively(it.next());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf A[Catch: all -> 0x00fa, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x000f, B:6:0x0015, B:7:0x0028, B:14:0x004c, B:15:0x00c9, B:17:0x00cf, B:21:0x005c, B:27:0x00a7, B:28:0x00b7, B:32:0x00d7, B:33:0x00f9, B:34:0x00e7, B:25:0x0075), top: B:3:0x000f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void createViewInternal(int i, String str, StylesDiffMap stylesDiffMap, Map<String, EventsListener> map, boolean z, int i2, Map<Integer, GestureDetector> map2) {
        String str2;
        LynxBaseUI lynxBaseUI;
        if (TraceEvent.isTracingStarted()) {
            String str3 = "UIOwner.createView." + str;
            TraceEvent.beginSection(str3);
            str2 = str3;
        } else {
            str2 = null;
        }
        UIThreadUtils.assertOnUiThread();
        try {
            lynxBaseUI = createViewInterval(new UIParams(i, i2, z, str, stylesDiffMap, map, map2));
        } catch (Throwable th) {
            th = th;
            lynxBaseUI = null;
        }
        try {
            LynxBaseUI consumeInitialProps = consumeInitialProps(lynxBaseUI, stylesDiffMap);
            if (consumeInitialProps != null) {
                reportStatistic(str);
                updateComponentIdToUiIdMapIfNeeded(i, str, stylesDiffMap);
                this.mUIHolder.put(Integer.valueOf(i), consumeInitialProps);
            } else {
                LLog.e(TAG, "createUI got null ui for tag:" + str);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                RuntimeException runtimeException = new RuntimeException("createUI catch error while createUI for tag: " + str + ", " + th.getMessage(), th);
                runtimeException.setStackTrace(th.getStackTrace());
                this.mUIBody.getLynxContext().handleException(runtimeException);
                if (lynxBaseUI != null) {
                    reportStatistic(str);
                    updateComponentIdToUiIdMapIfNeeded(i, str, stylesDiffMap);
                    this.mUIHolder.put(Integer.valueOf(i), lynxBaseUI);
                } else {
                    LLog.e(TAG, "createUI got null ui for tag:" + str);
                }
                if (TraceEvent.isTracingStarted()) {
                }
            } catch (Throwable th3) {
                if (lynxBaseUI != null) {
                    reportStatistic(str);
                    updateComponentIdToUiIdMapIfNeeded(i, str, stylesDiffMap);
                    this.mUIHolder.put(Integer.valueOf(i), lynxBaseUI);
                } else {
                    LLog.e(TAG, "createUI got null ui for tag:" + str);
                }
                throw th3;
            }
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str2);
        }
    }

    public void createView(int i, String str, ReadableMap readableMap, ReadableMapBuffer readableMapBuffer, ReadableArray readableArray, boolean z, int i2, ReadableArray readableArray2) {
        StylesDiffMap stylesDiffMap = readableMap != null ? new StylesDiffMap(readableMap, readableMapBuffer) : null;
        Map<String, EventsListener> convertEventListeners = EventsListener.convertEventListeners(readableArray);
        Map<Integer, GestureDetector> convertGestureDetectors = GestureDetector.convertGestureDetectors(readableArray2);
        new UIParams(i, i2, z, str, stylesDiffMap, convertEventListeners, convertGestureDetectors);
        createViewInternal(i, str, stylesDiffMap, convertEventListeners, z, i2, convertGestureDetectors);
    }

    public Runnable createViewAsyncRunnable(final int i, final String str, final ReadableMap readableMap, final ReadableMapBuffer readableMapBuffer, final ReadableArray readableArray, final boolean z, final int i2, final ReadableArray readableArray2) {
        String str2;
        reportCreateViewConfig(i, str, true);
        StylesDiffMap stylesDiffMap = readableMap != null ? new StylesDiffMap(readableMap, readableMapBuffer) : null;
        final StylesDiffMap stylesDiffMap2 = stylesDiffMap;
        UIParams uIParams = new UIParams(i, i2, z, str, stylesDiffMap, EventsListener.convertEventListeners(readableArray), GestureDetector.convertGestureDetectors(readableArray2));
        try {
            if (TraceEvent.isTracingStarted()) {
                str2 = "UIOwner.createAsyncViewRunnable." + str;
                TraceEvent.beginSection(str2);
            } else {
                str2 = null;
            }
            LynxBaseUI createViewInterval = createViewInterval(uIParams);
            final LynxBaseUI[] lynxBaseUIArr = {createViewInterval};
            final UIShadowProxy consumeInitialPropsInterval = consumeInitialPropsInterval(createViewInterval, stylesDiffMap2);
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str2);
            }
            reportCreateAsyncSuccessEvent(i, str, true, 2);
            return new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.2
                @Override // java.lang.Runnable
                public void run() {
                    String str3;
                    if (TraceEvent.isTracingStarted()) {
                        str3 = "UIOwner.AfterCreateAsyncViewRunnable." + str;
                        TraceEvent.beginSection(str3);
                    } else {
                        str3 = null;
                    }
                    LynxBaseUI[] lynxBaseUIArr2 = lynxBaseUIArr;
                    lynxBaseUIArr2[0] = LynxUIOwner.this.afterConsumeInitialProps(lynxBaseUIArr2[0], consumeInitialPropsInterval, stylesDiffMap2);
                    LynxUIOwner.this.reportStatistic(str);
                    LynxUIOwner.this.updateComponentIdToUiIdMapIfNeeded(i, str, stylesDiffMap2);
                    LynxUIOwner.this.mUIHolder.put(Integer.valueOf(i), lynxBaseUIArr[0]);
                    if (TraceEvent.isTracingStarted()) {
                        TraceEvent.endSection(str3);
                    }
                }
            };
        } catch (Throwable th) {
            String str3 = "createViewAsync failed, tagName:" + str + ", error:" + th;
            LLog.e(TAG, str3);
            final Exception exc = new Exception(str3);
            exc.setStackTrace(th.getStackTrace());
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.3
                @Override // java.lang.Runnable
                public void run() {
                    LynxUIOwner.this.mContext.handleException(exc);
                }
            });
            Runnable runnable = new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.4
                @Override // java.lang.Runnable
                public void run() {
                    LynxUIOwner.this.createView(i, str, readableMap, readableMapBuffer, readableArray, z, i2, readableArray2);
                }
            };
            reportCreateAsyncSuccessEvent(i, str, false, 3);
            return runnable;
        }
    }

    public Future<Runnable> createViewAsync(final int i, final String str, final StylesDiffMap stylesDiffMap, final Map<String, EventsListener> map, final boolean z, final int i2, final Map<Integer, GestureDetector> map2) {
        Callable callable = new Callable() { // from class: com.lynx.tasm.behavior.LynxUIOwner$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LynxUIOwner.this.m4121lambda$createViewAsync$0$comlynxtasmbehaviorLynxUIOwner(str, i, i2, z, stylesDiffMap, map, map2);
            }
        };
        if (isContextFree()) {
            FutureTask<Runnable> futureTask = new FutureTask<>(callable);
            this.mCreateNodeAsyncTasks.add(futureTask);
            return futureTask;
        }
        return LynxThreadPool.postUIOperationTask((Callable<Runnable>) callable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createViewAsync$0$com-lynx-tasm-behavior-LynxUIOwner, reason: not valid java name */
    public /* synthetic */ Runnable m4121lambda$createViewAsync$0$comlynxtasmbehaviorLynxUIOwner(final String str, final int i, int i2, boolean z, final StylesDiffMap stylesDiffMap, Map map, Map map2) throws Exception {
        String str2;
        String str3;
        final LynxBaseUI[] lynxBaseUIArr;
        final UIShadowProxy consumeInitialPropsInterval;
        try {
            if (TraceEvent.isTracingStarted()) {
                str3 = "UIOwner.createViewAsync." + str;
                traceBeginWithInstanceId(str3);
            } else {
                str3 = null;
            }
            LynxBaseUI createViewInterval = createViewInterval(new UIParams(i, i2, z, str, stylesDiffMap, map, map2));
            lynxBaseUIArr = new LynxBaseUI[]{createViewInterval};
            consumeInitialPropsInterval = consumeInitialPropsInterval(createViewInterval, stylesDiffMap);
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str3);
            }
            str2 = str;
        } catch (Throwable th) {
            th = th;
            str2 = str;
        }
        try {
            return new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.5
                @Override // java.lang.Runnable
                public void run() {
                    String str4;
                    if (TraceEvent.isTracingStarted()) {
                        str4 = "UIOwner.AfterCreateViewAsync." + str;
                        LynxUIOwner.this.traceBeginWithInstanceId(str4);
                    } else {
                        str4 = null;
                    }
                    LynxBaseUI[] lynxBaseUIArr2 = lynxBaseUIArr;
                    lynxBaseUIArr2[0] = LynxUIOwner.this.afterConsumeInitialProps(lynxBaseUIArr2[0], consumeInitialPropsInterval, stylesDiffMap);
                    LynxUIOwner.this.reportStatistic(str);
                    LynxUIOwner.this.updateComponentIdToUiIdMapIfNeeded(i, str, stylesDiffMap);
                    LynxUIOwner.this.mUIHolder.put(Integer.valueOf(i), lynxBaseUIArr[0]);
                    if (TraceEvent.isTracingStarted()) {
                        TraceEvent.endSection(str4);
                    }
                }
            };
        } catch (Throwable th2) {
            th = th2;
            String str4 = "createViewAsync failed, tagName:" + str2 + ", error:" + th;
            LLog.e(TAG, str4);
            final Exception exc = new Exception(str4);
            exc.setStackTrace(th.getStackTrace());
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.LynxUIOwner.6
                @Override // java.lang.Runnable
                public void run() {
                    LynxUIOwner.this.mContext.handleException(exc);
                }
            });
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void traceBeginWithInstanceId(String str) {
        if (this.mContext != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(this.mContext.getInstanceId()));
            TraceEvent.beginSection(str, hashMap);
            return;
        }
        TraceEvent.beginSection(str);
    }

    private LynxBaseUI consumeInitialProps(LynxBaseUI lynxBaseUI, StylesDiffMap stylesDiffMap) {
        return afterConsumeInitialProps(lynxBaseUI, consumeInitialPropsInterval(lynxBaseUI, stylesDiffMap), stylesDiffMap);
    }

    private UIShadowProxy consumeInitialPropsInterval(LynxBaseUI lynxBaseUI, StylesDiffMap stylesDiffMap) {
        if (stylesDiffMap != null) {
            r0 = hasShadowOrOutline(stylesDiffMap) ? new UIShadowProxy(this.mContext, lynxBaseUI) : null;
            lynxBaseUI.updatePropertiesInterval(stylesDiffMap);
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public LynxBaseUI afterConsumeInitialProps(LynxBaseUI lynxBaseUI, UIShadowProxy uIShadowProxy, StylesDiffMap stylesDiffMap) {
        if (lynxBaseUI instanceof PatchFinishListener) {
            this.mContext.registerPatchFinishListener((PatchFinishListener) lynxBaseUI);
        }
        if (lynxBaseUI instanceof ForegroundListener) {
            registerForegroundListener((ForegroundListener) lynxBaseUI);
        }
        if (stylesDiffMap != null) {
            lynxBaseUI.afterPropsUpdated(stylesDiffMap);
            if (TransitionAnimationManager.hasTransitionAnimation(stylesDiffMap)) {
                lynxBaseUI.initTransitionAnimator(stylesDiffMap.mBackingMap);
            }
            if (KeyframeManager.hasKeyframeAnimation(stylesDiffMap)) {
                lynxBaseUI.setAnimation(stylesDiffMap.getArray(PropsConstants.ANIMATION));
            }
        }
        return uIShadowProxy != null ? uIShadowProxy : lynxBaseUI;
    }

    private LynxBaseUI createViewInterval(UIParams uIParams) {
        LynxBaseUI createUI;
        UIBody.UIBodyView.attachLynxPageUICallback attachlynxpageuicallback;
        if (this.mRootSign < 0 && uIParams.mTagName.equals(LynxConstants.ROOT_TAG_NAME)) {
            createUI = this.mUIBody;
            this.mRootSign = uIParams.mSign;
            if (createUI != null && (attachlynxpageuicallback = this.mAttachLynxPageUICallback) != null) {
                attachlynxpageuicallback.attachLynxPageUI(new WeakReference<>(createUI));
            }
        } else {
            createUI = createUI(uIParams.mTagName, uIParams.mIsFlatten, uIParams);
        }
        if (createUI == null) {
            return createUI;
        }
        createUI.setEvents(uIParams.mEventsListenerMap);
        createUI.setSign(uIParams.mSign, uIParams.mTagName);
        createUI.setNodeIndex(uIParams.mNodeIndex);
        createUI.setGestureDetectors(uIParams.mGestureDetectors);
        return createUI;
    }

    private boolean hasShadowOrOutline(StylesDiffMap stylesDiffMap) {
        return stylesDiffMap.hasKey(PropsConstants.BOX_SHADOW) || stylesDiffMap.hasKey(PropsConstants.OUTLINE_COLOR) || stylesDiffMap.hasKey(PropsConstants.OUTLINE_STYLE) || stylesDiffMap.hasKey(PropsConstants.OUTLINE_WIDTH);
    }

    public void updateFlatten(int i, boolean z) {
        newUpdateFlatten(i, z);
    }

    private void newUpdateFlatten(int i, boolean z) {
        String str;
        int i2;
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI == null) {
            return;
        }
        LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
        StylesDiffMap stylesDiffMap = new StylesDiffMap(lynxBaseUI.getProps());
        ArrayList<LynxBaseUI> arrayList = new ArrayList(lynxBaseUI.getChildren());
        if (TraceEvent.isTracingStarted()) {
            str = "UIOwner.updateFlatten." + lynxBaseUI.getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        int i3 = 0;
        if (parentBaseUI != null) {
            i2 = parentBaseUI.getIndex(lynxBaseUI);
            removeFromDrawList(lynxBaseUI);
            parentBaseUI.removeChild(lynxBaseUI);
        } else {
            i2 = 0;
        }
        if (!lynxBaseUI.isFlatten()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                removeFromDrawList((LynxBaseUI) it.next());
            }
        }
        for (int size = lynxBaseUI.getChildren().size() - 1; size >= 0; size--) {
            lynxBaseUI.removeChild(lynxBaseUI.getChildAt(size));
        }
        LynxBaseUI createUI = createUI(lynxBaseUI.getTagName(), z);
        lynxBaseUI.applyUIPaintStylesToTarget(createUI);
        createUI.setSign(lynxBaseUI.getSign(), lynxBaseUI.getTagName());
        consumeInitialProps(createUI, stylesDiffMap);
        this.mUIHolder.put(Integer.valueOf(lynxBaseUI.getSign()), createUI);
        if (this.mTranslateZParentHolder.contains(lynxBaseUI)) {
            this.mTranslateZParentHolder.remove(lynxBaseUI);
            this.mTranslateZParentHolder.add(createUI);
        }
        if (parentBaseUI != null) {
            parentBaseUI.insertChild(createUI, i2);
            insertIntoDrawList(parentBaseUI, createUI, i2);
        }
        for (LynxBaseUI lynxBaseUI2 : arrayList) {
            resetUIDrawingLayoutInfo(lynxBaseUI2);
            createUI.insertChild(lynxBaseUI2, i3);
            i3++;
        }
        insertChildIntoDrawListRecursive(createUI);
        createUI.updateLayoutInfo(lynxBaseUI);
        createUI.copyPropFromOldUiInUpdateFlatten(lynxBaseUI);
        createUI.measure();
        ((LynxUI) createUI).handleLayout();
        if (createUI instanceof UIGroup) {
            ((UIGroup) createUI).layoutChildren();
        }
        createUI.invalidate();
        lynxBaseUI.destroy();
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    private void resetUIDrawingLayoutInfo(LynxBaseUI lynxBaseUI) {
        lynxBaseUI.setBound(null);
        lynxBaseUI.setLeft(lynxBaseUI.getOriginLeft());
        lynxBaseUI.setTop(lynxBaseUI.getOriginTop());
    }

    private void insertChildIntoDrawListRecursive(LynxBaseUI lynxBaseUI) {
        int i = 0;
        for (LynxBaseUI lynxBaseUI2 : lynxBaseUI.getChildren()) {
            int i2 = i + 1;
            insertIntoDrawList(lynxBaseUI, lynxBaseUI2, i);
            if (lynxBaseUI2.isFlatten()) {
                insertChildIntoDrawListRecursive(lynxBaseUI2);
            }
            i = i2;
        }
    }

    public void insert(int i, int i2, int i3) {
        newInsert(i, i2, i3);
    }

    private void newInsert(int i, int i2, int i3) {
        if (this.mUIHolder.size() > 0) {
            if (this.mUIHolder.get(Integer.valueOf(i)) == null) {
                throw new RuntimeException("Insertion (new) failed due to unknown parent signature: " + i);
            }
            LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i2));
            if (lynxBaseUI == null) {
                throw new RuntimeException("Insertion (new) failed due to unknown child signature: " + i2);
            }
            checkTranslateZ(i2, i);
            LynxBaseUI lynxBaseUI2 = this.mUIHolder.get(Integer.valueOf(i));
            if (!lynxBaseUI2.canHaveFlattenChild() && lynxBaseUI.isFlatten()) {
                newUpdateFlatten(i2, false);
                lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i2));
            }
            if (i3 == -1) {
                i3 = lynxBaseUI2.getChildren().size();
            }
            lynxBaseUI2.insertChild(lynxBaseUI, i3);
            insertIntoDrawList(lynxBaseUI2, lynxBaseUI, i3);
            if (lynxBaseUI.isFlatten()) {
                lynxBaseUI2.flattenChildrenCountIncrement();
            }
            if (lynxBaseUI.isFlatten()) {
                insertChildIntoDrawListRecursive(lynxBaseUI);
                lynxBaseUI.requestLayout();
                lynxBaseUI.invalidate();
            }
            insertA11yMutationEvent(0, lynxBaseUI);
        }
    }

    private void insertIntoDrawList(LynxBaseUI lynxBaseUI, LynxBaseUI lynxBaseUI2, int i) {
        lynxBaseUI2.setNextDrawUI(null);
        LynxBaseUI drawParent = lynxBaseUI.isFlatten() ? lynxBaseUI.getDrawParent() : lynxBaseUI;
        if (drawParent == null) {
            return;
        }
        if (i == 0) {
            LynxUI lynxUI = (LynxUI) drawParent;
            if (!lynxBaseUI.isFlatten()) {
                lynxBaseUI = null;
            }
            lynxUI.insertDrawList(lynxBaseUI, lynxBaseUI2);
        } else {
            LynxBaseUI childAt = lynxBaseUI.getChildAt(i - 1);
            while (childAt.isFlatten() && !childAt.getChildren().isEmpty()) {
                childAt = childAt.getChildAt(childAt.getChildren().size() - 1);
            }
            ((LynxUI) drawParent).insertDrawList(childAt, lynxBaseUI2);
        }
        if (lynxBaseUI2.isFlatten()) {
            return;
        }
        UIGroup uIGroup = (UIGroup) drawParent;
        if (uIGroup.isInsertViewCalled()) {
            uIGroup.insertView((LynxUI) lynxBaseUI2);
        }
    }

    public void remove(int i, int i2) {
        newRemove(i, i2);
    }

    private void newRemove(int i, int i2) {
        String str;
        if (this.mUIHolder.size() > 0) {
            LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i2));
            if (lynxBaseUI == null) {
                throw new RuntimeException("Trying to remove unknown ui signature: " + i2);
            }
            LynxBaseUI parentBaseUI = i == -1 ? lynxBaseUI.getParentBaseUI() : this.mUIHolder.get(Integer.valueOf(i));
            if (parentBaseUI == null) {
                throw new RuntimeException("Trying to remove unknown ui signature: " + i2);
            }
            if (TraceEvent.isTracingStarted()) {
                str = "UIOwner.remove." + parentBaseUI.getTagName() + "." + lynxBaseUI.getTagName();
                TraceEvent.beginSection(str);
            } else {
                str = null;
            }
            removeFromDrawList(lynxBaseUI);
            parentBaseUI.removeChild(lynxBaseUI);
            resetUIDrawingLayoutInfo(lynxBaseUI);
            if (lynxBaseUI.isFlatten()) {
                parentBaseUI.flattenChildrenCountDecrement();
            }
            lynxBaseUI.removeChildrenExposureUI();
            insertA11yMutationEvent(1, lynxBaseUI);
            if (TraceEvent.isTracingStarted()) {
                TraceEvent.endSection(str);
            }
        }
    }

    private void removeFromDrawList(LynxBaseUI lynxBaseUI) {
        UIGroup uIGroup = (UIGroup) lynxBaseUI.getDrawParent();
        LynxBaseUI parentBaseUI = lynxBaseUI.getParentBaseUI();
        if (uIGroup == null || parentBaseUI == null) {
            return;
        }
        if (!lynxBaseUI.isFlatten()) {
            LynxBaseUI previousDrawUI = lynxBaseUI.getPreviousDrawUI();
            LynxBaseUI nextDrawUI = lynxBaseUI.getNextDrawUI();
            if (previousDrawUI != null) {
                previousDrawUI.setNextDrawUI(nextDrawUI);
                if (nextDrawUI != null) {
                    nextDrawUI.setPreviousDrawUI(previousDrawUI);
                }
            } else {
                uIGroup.setDrawHead(nextDrawUI);
                if (nextDrawUI != null) {
                    nextDrawUI.setPreviousDrawUI(null);
                }
            }
            if (parentBaseUI.isFlatten()) {
                uIGroup.removeView(lynxBaseUI);
            }
            lynxBaseUI.setNextDrawUI(null);
            lynxBaseUI.setPreviousDrawUI(null);
            lynxBaseUI.setDrawParent(null);
            return;
        }
        LynxBaseUI lynxBaseUI2 = lynxBaseUI;
        while (lynxBaseUI2.isFlatten() && !lynxBaseUI2.getChildren().isEmpty()) {
            lynxBaseUI2 = lynxBaseUI2.getChildAt(lynxBaseUI2.getChildren().size() - 1);
        }
        LynxBaseUI previousDrawUI2 = lynxBaseUI.getPreviousDrawUI();
        if (previousDrawUI2 != null) {
            previousDrawUI2.setNextDrawUI(lynxBaseUI2.getNextDrawUI());
            if (lynxBaseUI2.getNextDrawUI() != null) {
                lynxBaseUI2.getNextDrawUI().setPreviousDrawUI(previousDrawUI2);
            }
        } else {
            uIGroup.setDrawHead(lynxBaseUI2.getNextDrawUI());
            if (lynxBaseUI2.getNextDrawUI() != null) {
                lynxBaseUI2.getNextDrawUI().setPreviousDrawUI(null);
            }
        }
        lynxBaseUI.setPreviousDrawUI(null);
        for (LynxBaseUI nextDrawUI2 = lynxBaseUI.getNextDrawUI(); nextDrawUI2 != lynxBaseUI2.getNextDrawUI(); nextDrawUI2 = nextDrawUI2.getNextDrawUI()) {
            nextDrawUI2.getPreviousDrawUI().setNextDrawUI(null);
            nextDrawUI2.setPreviousDrawUI(null);
            uIGroup.removeView(nextDrawUI2);
            nextDrawUI2.setDrawParent(null);
        }
        lynxBaseUI2.setNextDrawUI(null);
        lynxBaseUI.setDrawParent(null);
        parentBaseUI.invalidate();
    }

    public void destroy(int i, int i2) {
        TraceEvent.beginSection("UIOwner.destroy.item");
        if (this.mUIHolder.size() > 0) {
            LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i2));
            if (lynxBaseUI == null) {
                TraceEvent.endSection("UIOwner.destroy.item");
                return;
            }
            this.mTranslateZParentHolder.remove(lynxBaseUI);
            removeFromDrawList(lynxBaseUI);
            this.mUIHolder.remove(Integer.valueOf(i2));
            this.mContext.removeUIFromExposedMap(lynxBaseUI);
            lynxBaseUI.destroy();
            insertA11yMutationEvent(2, lynxBaseUI);
            if (!this.mContext.getEnableFiberArch()) {
                destroyChildrenRecursively(lynxBaseUI);
            }
            LynxBaseUI parentBaseUI = i == -1 ? lynxBaseUI.getParentBaseUI() : this.mUIHolder.get(Integer.valueOf(i));
            if (parentBaseUI == null) {
                TraceEvent.endSection("UIOwner.destroy.item");
                return;
            }
            parentBaseUI.removeChild(lynxBaseUI);
        }
        TraceEvent.endSection("UIOwner.destroy.item");
    }

    public void reuseListNode(int i, String str) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI != null) {
            if ((lynxBaseUI.getParentBaseUI() instanceof UIList) || (lynxBaseUI.getParentBaseUI() instanceof UIListContainer)) {
                lynxBaseUI.onListCellPrepareForReuse(str, lynxBaseUI.getParentBaseUI());
            }
        }
    }

    public void listCellDisappear(int i, Boolean bool, String str) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI == null || !(lynxBaseUI.getParentBaseUI() instanceof UIListContainer)) {
            return;
        }
        lynxBaseUI.onListCellDisAppear(str, lynxBaseUI.getParentBaseUI(), bool.booleanValue());
    }

    public void listCellAppear(int i, String str) {
        LynxBaseUI lynxBaseUI = this.mUIHolder.get(Integer.valueOf(i));
        if (lynxBaseUI == null || !(lynxBaseUI.getParentBaseUI() instanceof UIListContainer)) {
            return;
        }
        lynxBaseUI.onListCellAppear(str, lynxBaseUI.getParentBaseUI());
    }

    public GestureArenaManager getGestureArenaManager() {
        return this.mGestureArenaManager;
    }

    public void destroy() {
        LynxBaseUI value;
        TraceEvent.beginSection("UIOwner.destroy");
        for (Map.Entry<Integer, LynxBaseUI> entry : this.mUIHolder.entrySet()) {
            if ((entry.getValue() instanceof LynxBaseUI) && (value = entry.getValue()) != null) {
                value.destroy();
            }
        }
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null) {
            lynxContext.destory();
        }
        GestureArenaManager gestureArenaManager = this.mGestureArenaManager;
        if (gestureArenaManager != null) {
            gestureArenaManager.onDestroy();
        }
        this.mCreateNodeAsyncTasks.clear();
        TraceEvent.endSection("UIOwner.destroy");
    }

    public void onTasmFinish(long j) {
        List<PatchFinishListener> patchFinishListeners = this.mContext.getPatchFinishListeners();
        if (patchFinishListeners != null) {
            Iterator<PatchFinishListener> it = patchFinishListeners.iterator();
            while (it.hasNext()) {
                it.next().onPatchFinish();
            }
        }
        if (this.mUIBody.getBodyView() == null || !this.mUIBody.getBodyView().HasPendingRequestLayout()) {
            return;
        }
        LLog.i(TAG, "onTasmFinish do force RequestLayout after UpdateData in PreLoad Mode!");
        this.mUIBody.getBodyView().requestLayout();
    }

    public void onLayoutFinish(int i, long j) {
        LynxBaseUI lynxBaseUI;
        String str;
        handleTranslateZUI();
        if (this.mUIBody.getLynxAccessibilityWrapper() != null) {
            this.mUIBody.getLynxAccessibilityWrapper().onLayoutFinish();
        }
        if (j == 0 || (lynxBaseUI = this.mUIHolder.get(Integer.valueOf(getSignFromOperationId(j)))) == null) {
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            str = "UIOwner.layoutFinish." + lynxBaseUI.getTagName();
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        lynxBaseUI.onLayoutFinish(j, this.mUIHolder.get(Integer.valueOf(i)));
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    private void destroyChildrenRecursively(LynxBaseUI lynxBaseUI) {
        for (int i = 0; i < lynxBaseUI.getChildren().size(); i++) {
            LynxBaseUI childAt = lynxBaseUI.getChildAt(i);
            childAt.destroy();
            this.mUIHolder.remove(Integer.valueOf(childAt.getSign()));
            this.mTranslateZParentHolder.remove(childAt);
            this.mContext.removeUIFromExposedMap(childAt);
            destroyChildrenRecursively(childAt);
        }
    }

    public void performMeasure() {
        this.mUIBody.measureChildren();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r12v0 ??, still in use, count: 1, list:
          (r12v0 ?? I:java.lang.Object) from 0x004c: INVOKE (r0v1 ?? I:java.util.HashMap), (r3v2 ?? I:java.lang.Object), (r12v0 ?? I:java.lang.Object) VIRTUAL call: java.util.HashMap.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:1194)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:88)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:87)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:72)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:54)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:34)
        */
    public java.util.HashMap<java.lang.String, com.lynx.tasm.performance.memory.MemoryRecord> getMemoryUsage() {
        /*
            r13 = this;
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r0 = r13.mUIHolder
            if (r0 != 0) goto L6
            r0 = 0
            return r0
        L6:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap<java.lang.Integer, com.lynx.tasm.behavior.ui.LynxBaseUI> r1 = r13.mUIHolder
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L15:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r2 = r2.getValue()
            com.lynx.tasm.behavior.ui.LynxBaseUI r2 = (com.lynx.tasm.behavior.p000ui.LynxBaseUI) r2
            if (r2 == 0) goto L71
            boolean r3 = r2 instanceof com.lynx.tasm.behavior.p000ui.LynxBaseUI
            if (r3 != 0) goto L2e
            goto L71
        L2e:
            java.lang.String r3 = r2.getTagName()
            if (r3 != 0) goto L35
            goto L15
        L35:
            long r10 = r2.getMemoryUsageBytes()
            java.lang.Object r4 = r0.get(r3)
            com.lynx.tasm.performance.memory.MemoryRecord r4 = (com.lynx.tasm.performance.memory.MemoryRecord) r4
            if (r4 != 0) goto L4f
            com.lynx.tasm.performance.memory.MemoryRecord r12 = new com.lynx.tasm.performance.memory.MemoryRecord
            r6 = 0
            r8 = 0
            r9 = 0
            r4 = r12
            r5 = r3
            r4.<init>(r5, r6, r8, r9)
            r0.put(r3, r12)
        L4f:
            int r3 = r4.mInstanceCount
            int r3 = r3 + 1
            r4.mInstanceCount = r3
            long r5 = r4.mSizeBytes
            long r5 = r5 + r10
            r4.mSizeBytes = r5
            java.util.Map r2 = r2.getMemoryUsageDetail()
            if (r2 == 0) goto L15
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.mDetail
            if (r3 != 0) goto L6b
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4.mDetail = r3
        L6b:
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.mDetail
            r3.putAll(r2)
            goto L15
        L71:
            java.lang.String r2 = "LynxUIOwner"
            java.lang.String r3 = "getMemoryUsage failed, the ui is null or not LynxBaseUI"
            com.lynx.tasm.base.LLog.e(r2, r3)
            goto L15
        L79:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lynx.tasm.behavior.LynxUIOwner.getMemoryUsage():java.util.HashMap");
    }

    public void performLayout() {
        this.mUIBody.layoutChildren();
        if (this.mUIBody.getLynxContext().getEventEmitter() != null) {
            this.mUIBody.getLynxContext().getEventEmitter().sendLayoutEvent();
        }
        didPerformLayout();
    }

    private void didPerformLayout() {
        if (this.mCachedBoundingClientRectUI.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet(this.mCachedBoundingClientRectUI);
        this.mCachedBoundingClientRectUI.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((LynxBaseUI) it.next()).uiOwnerDidPerformLayout();
        }
        didPerformLayout();
    }

    public void setHasTouchPseudo(boolean z) {
        this.mHasTouchPseudo = z;
    }

    public boolean getHasTouchPseudo() {
        return this.mHasTouchPseudo;
    }

    public int getRootWidth() {
        return this.mUIBody.getWidth();
    }

    public int getRootHeight() {
        return this.mUIBody.getHeight();
    }

    public UIBody getRootUI() {
        return this.mUIBody;
    }

    public LynxBaseUI getNode(int i) {
        HashMap<Integer, LynxBaseUI> hashMap = this.mUIHolder;
        if (hashMap != null) {
            return hashMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public LynxBaseUI findLynxUIByComponentId(String str) {
        int i;
        if (str.isEmpty() || LynxConstants.LYNX_DEFAULT_COMPONENT_ID.equals(str)) {
            return getRootUI();
        }
        if (this.mComponentIdToUiIdHolder.containsKey(str)) {
            i = this.mComponentIdToUiIdHolder.get(str).intValue();
        } else {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i = -1;
            }
        }
        if (i == -1) {
            return getRootUI();
        }
        return getNode(i);
    }

    public LynxBaseUI findLynxUIBySign(int i) {
        if (this.mUIHolder.get(Integer.valueOf(i)) instanceof UIShadowProxy) {
            return ((UIShadowProxy) this.mUIHolder.get(Integer.valueOf(i))).getChild();
        }
        return this.mUIHolder.get(Integer.valueOf(i));
    }

    public LynxBaseUI findLynxUIById(String str, LynxBaseUI lynxBaseUI) {
        LynxBaseUI findLynxUIById;
        if (lynxBaseUI != null && lynxBaseUI.getIdSelector() != null && lynxBaseUI.getIdSelector().equals(str)) {
            return lynxBaseUI;
        }
        if (!(lynxBaseUI instanceof UIGroup)) {
            return null;
        }
        UIGroup uIGroup = (UIGroup) lynxBaseUI;
        for (int i = 0; i < uIGroup.getChildCount(); i++) {
            LynxBaseUI childAt = uIGroup.getChildAt(i);
            if (childAt.getIdSelector() != null && childAt.getIdSelector().equals(str)) {
                return childAt;
            }
            if (!childAt.getTagName().equals("component") && (childAt instanceof UIGroup) && (findLynxUIById = findLynxUIById(str, childAt)) != null) {
                return findLynxUIById;
            }
        }
        return null;
    }

    private LynxBaseUI findLynxUIByIdWithGroup(String str, UIGroup uIGroup) {
        LynxBaseUI findLynxUIByIdWithGroup;
        for (int i = 0; i < uIGroup.getChildCount(); i++) {
            LynxBaseUI childAt = uIGroup.getChildAt(i);
            if (childAt.getIdSelector() != null && childAt.getIdSelector().equals(str)) {
                return childAt;
            }
            if (!childAt.getTagName().equals("component") && (childAt instanceof UIGroup) && (findLynxUIByIdWithGroup = findLynxUIByIdWithGroup(str, (UIGroup) childAt)) != null) {
                return findLynxUIByIdWithGroup;
            }
        }
        return null;
    }

    public LynxContext getContext() {
        return this.mContext;
    }

    public void reset() {
        this.mIsFirstLayout = true;
        this.mRootSign = -1;
        HashMap<Integer, LynxBaseUI> hashMap = this.mUIHolder;
        if (hashMap != null) {
            Iterator<LynxBaseUI> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().destroy();
            }
            this.mUIHolder.clear();
            this.mTranslateZParentHolder.clear();
        }
        UIBody uIBody = this.mUIBody;
        if (uIBody != null) {
            uIBody.removeAll();
        }
        HashMap<String, Integer> hashMap2 = this.mComponentIdToUiIdHolder;
        if (hashMap2 != null) {
            hashMap2.clear();
        }
        WeakReference<NativeFacade> weakReference = this.mNativeFacade;
        NativeFacade nativeFacade = weakReference != null ? weakReference.get() : null;
        if (nativeFacade != null) {
            nativeFacade.clearNativePipelineTimingInfo();
        }
    }

    public LynxBaseUI findLynxUIByName(String str) {
        for (LynxBaseUI lynxBaseUI : this.mUIHolder.values()) {
            if (lynxBaseUI != null && str.equals(lynxBaseUI.getName())) {
                return lynxBaseUI;
            }
        }
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelector(String str) {
        for (LynxBaseUI lynxBaseUI : this.mUIHolder.values()) {
            if (lynxBaseUI != null && str.equals(lynxBaseUI.getIdSelector())) {
                return lynxBaseUI;
            }
        }
        return null;
    }

    public LynxBaseUI findLynxUIByA11yId(String str) {
        if (str.isEmpty()) {
            return null;
        }
        Iterator<Integer> it = this.mUIHolder.keySet().iterator();
        while (it.hasNext()) {
            LynxBaseUI lynxBaseUI = this.mUIHolder.get(it.next());
            if (lynxBaseUI != null && str.equals(lynxBaseUI.getAccessibilityId())) {
                return lynxBaseUI;
            }
        }
        return null;
    }

    public void invokeUIMethod(String str, ReadableArray readableArray, String str2, ReadableMap readableMap, Callback callback) {
        LynxBaseUI findLynxUIByComponentId = findLynxUIByComponentId(str);
        String str3 = "component not found, nodes: " + readableArray.toString() + ", method: " + str2;
        if (findLynxUIByComponentId != null) {
            int i = 0;
            while (true) {
                if (i >= readableArray.size()) {
                    break;
                }
                String string = readableArray.getString(i);
                boolean z = readableMap != null && readableMap.size() > 0 && readableMap.hasKey("_isCallByRefId") && readableMap.getBoolean("_isCallByRefId");
                if (!string.startsWith("#") && !z) {
                    if (callback != null) {
                        callback.invoke(new Object[]{5, string + " not support, only support id selector currently"});
                        return;
                    }
                    return;
                }
                String substring = string.substring(1);
                findLynxUIByComponentId = z ? findLynxUIByRefId(string, findLynxUIByComponentId) : findLynxUIByIdSelector(substring, findLynxUIByComponentId);
                if (findLynxUIByComponentId == null) {
                    str3 = "not found " + string;
                    break;
                } else {
                    if (findLynxUIByComponentId.getIdSelector() != null) {
                        findLynxUIByComponentId.getIdSelector().equals(substring);
                    }
                    i++;
                }
            }
        }
        if (findLynxUIByComponentId != null) {
            LynxUIMethodsExecutor.invokeMethod(findLynxUIByComponentId, str2, readableMap, callback);
        } else if (callback != null) {
            callback.invoke(new Object[]{2, str3});
        }
    }

    public void invokeUIMethodForSelectorQuery(int i, String str, ReadableMap readableMap, Callback callback) {
        String str2;
        LynxBaseUI node = getNode(i);
        if (node == null) {
            if (callback != null) {
                callback.invoke(new Object[]{6, "node does not have a LynxUI"});
                return;
            }
            return;
        }
        if (TraceEvent.isTracingStarted()) {
            str2 = "UIOwner.invokeUIMethodForSelectorQuery." + node.getTagName() + "." + str;
            TraceEvent.beginSection(str2);
        } else {
            str2 = null;
        }
        LynxUIMethodsExecutor.invokeMethod(node, str, readableMap, callback);
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str2);
        }
    }

    public LynxBaseUI findLynxUIByIndex(int i) {
        return this.mUIHolder.get(Integer.valueOf(i));
    }

    public LynxBaseUI findLynxUIByIdSelectorSearchUp(String str, LynxBaseUI lynxBaseUI) {
        if (lynxBaseUI != null) {
            return (lynxBaseUI == null || lynxBaseUI.getIdSelector() == null || !lynxBaseUI.getIdSelector().equals(str)) ? findLynxUIByIdSelectorSearchUp(str, lynxBaseUI.getParentBaseUI()) : lynxBaseUI;
        }
        LLog.e(TAG, "findLynxUIByIdSelectorSearchUp failed, the ui is null for " + str + ".");
        return null;
    }

    public LynxBaseUI findLynxUIByIdSelector(String str, LynxBaseUI lynxBaseUI) {
        LynxBaseUI findLynxUIByIdSelector;
        if (lynxBaseUI != null && lynxBaseUI.getIdSelector() != null && lynxBaseUI.getIdSelector().equals(str)) {
            return lynxBaseUI;
        }
        if (lynxBaseUI == null) {
            return null;
        }
        for (LynxBaseUI lynxBaseUI2 : lynxBaseUI.getChildren()) {
            if (lynxBaseUI2.getIdSelector() != null && lynxBaseUI2.getIdSelector().equals(str)) {
                return lynxBaseUI2;
            }
            if (!(lynxBaseUI2 instanceof UIComponent) && (findLynxUIByIdSelector = findLynxUIByIdSelector(str, lynxBaseUI2)) != null) {
                return findLynxUIByIdSelector;
            }
        }
        return null;
    }

    public void setGestureDetectorState(int i, int i2, int i3) {
        LynxBaseUI node = getNode(i);
        if (node == null) {
            LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        } else if (node instanceof LynxNewGestureDelegate) {
            node.setGestureDetectorState(i2, i3);
        }
    }

    public void consumeGesture(int i, int i2, ReadableMap readableMap) {
        LynxBaseUI node = getNode(i);
        if (node == null) {
            LLog.e(TAG, "Attempted to set gesture detector state for a non-existing node");
        } else if (node instanceof LynxNewGestureDelegate) {
            node.consumeGesture(i2, readableMap);
        }
    }

    public void validate(int i) {
        LynxBaseUI node = getNode(i);
        if (node == null) {
            LLog.e(TAG, "try to validate a not-existing node");
        } else {
            node.renderIfNeeded();
        }
    }

    @Deprecated
    public Set<String> getComponentSet() {
        return new HashSet();
    }

    public void reportStatistic(String str) {
        if (LynxEnv.inst().enableComponentStatisticReport()) {
            componentStatistic(str);
        }
    }

    public void componentStatistic(final String str) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || !lynxContext.enableEventReporter() || this.mComponentSet.contains(str)) {
            return;
        }
        this.mComponentSet.add(str);
        LynxContext lynxContext2 = this.mContext;
        LynxEventReporter.onEvent(LYNXSDK_COMPONENT_STATISTIC_EVENT, lynxContext2 == null ? -1 : lynxContext2.getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIOwner$$ExternalSyntheticLambda1
            @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
            public final Map build() {
                return LynxUIOwner.lambda$componentStatistic$1(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$componentStatistic$1(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("component_name", str);
        return hashMap;
    }

    public LynxBaseUI createUI(String str, boolean z) {
        return createUI(str, z, null);
    }

    private LynxBaseUI createUI(String str, boolean z, Object obj) {
        LynxBaseUI createSwiperIfNeeded = this.mContext.isUseNewSwiper() ? createSwiperIfNeeded(str, null, obj) : null;
        if (createSwiperIfNeeded != null) {
            return createSwiperIfNeeded;
        }
        Behavior behavior = this.mBehaviorRegistry.get(str);
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mContext.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null && lynxAccessibilityWrapper.shouldCreateNoFlattenUI()) {
            z = false;
        }
        if (z && behavior.supportUIFlatten()) {
            createSwiperIfNeeded = behavior.createFlattenUIWithParams(this.mContext, obj);
        }
        return createSwiperIfNeeded == null ? behavior.createUIWithParams(this.mContext, obj) : createSwiperIfNeeded;
    }

    void dump(StringBuilder sb, LynxBaseUI lynxBaseUI, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
        sb.append("id: ").append(lynxBaseUI.getSign()).append(", tag: ").append(lynxBaseUI.getTagName()).append(", rect: [").append(lynxBaseUI.getLeft()).append(", ").append(lynxBaseUI.getTop()).append(", ").append(lynxBaseUI.getWidth()).append(", ").append(lynxBaseUI.getHeight()).append("]");
        if (lynxBaseUI.getLynxBackground() != null) {
            sb.append(", bg: 0x").append(Integer.toHexString(lynxBaseUI.getLynxBackground().getBackgroundColor()));
        }
        sb.append(UpdateDialogNewBase.TYPE);
    }

    void dumpTree(StringBuilder sb, LynxBaseUI lynxBaseUI, int i) {
        dump(sb, lynxBaseUI, i);
        for (int i2 = 0; i2 < lynxBaseUI.getChildren().size(); i2++) {
            dumpTree(sb, lynxBaseUI.getChildren().get(i2), i + 1);
        }
    }

    void dumpDrawList(StringBuilder sb, UIGroup uIGroup, int i) {
        dump(sb, uIGroup, i);
        for (LynxBaseUI drawHead = uIGroup.getDrawHead(); drawHead != null; drawHead = drawHead.getNextDrawUI()) {
            dump(sb, drawHead, i);
        }
    }

    public LynxBaseUI findLynxUIByRefId(String str, LynxBaseUI lynxBaseUI) {
        LynxBaseUI findLynxUIByRefId;
        if (lynxBaseUI != null && lynxBaseUI.getRefIdSelector() != null && lynxBaseUI.getRefIdSelector().equals(str)) {
            return lynxBaseUI;
        }
        if (lynxBaseUI == null) {
            return null;
        }
        for (LynxBaseUI lynxBaseUI2 : lynxBaseUI.getChildren()) {
            if (lynxBaseUI2.getRefIdSelector() != null && lynxBaseUI2.getRefIdSelector().equals(str)) {
                return lynxBaseUI2;
            }
            if (!lynxBaseUI2.getTagName().equals("component") && (findLynxUIByRefId = findLynxUIByRefId(str, lynxBaseUI2)) != null) {
                return findLynxUIByRefId;
            }
        }
        return null;
    }

    public boolean getEnableCreateViewAsync() {
        return this.mContext.getEnableCreateViewAsync();
    }

    public void setContextFree(boolean z) {
        this.mIsContextFree = z;
    }

    public boolean isContextFree() {
        return this.mIsContextFree;
    }

    private LynxBaseUI createSwiperIfNeeded(String str, LynxBaseUI lynxBaseUI, Object obj) {
        return ("swiper".equals(str) || "x-swiper".equals(str)) ? new XSwiperUI(this.mContext, obj) : lynxBaseUI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateComponentIdToUiIdMapIfNeeded(int i, String str, StylesDiffMap stylesDiffMap) {
        if (str.equals("component") && stylesDiffMap.hasKey("ComponentID")) {
            String string = stylesDiffMap.getString("ComponentID");
            if (string == null) {
                string = LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
            }
            this.mComponentIdToUiIdHolder.put(string, Integer.valueOf(i));
        }
    }

    private void sortTranslateZChildren(LynxBaseUI lynxBaseUI) {
        Iterator<LynxBaseUI> it = lynxBaseUI.getChildren().iterator();
        while (it.hasNext()) {
            removeFromDrawList(it.next());
        }
        try {
            Collections.sort(lynxBaseUI.getChildren(), translationZComparator);
        } catch (Exception e) {
            LLog.i(TAG, "Something went wrong during sort children by translation Z " + e.getStackTrace());
        }
        insertChildIntoDrawListRecursive(lynxBaseUI);
    }

    private void handleTranslateZUI() {
        if (this.mContext.getEnableFlattenTranslateZ()) {
            Iterator<LynxBaseUI> it = this.mTranslateZParentHolder.iterator();
            while (it.hasNext()) {
                LynxBaseUI next = it.next();
                if (next.flattenChildrenCount() > 0 && next.getNeedSortChildren()) {
                    sortTranslateZChildren(next);
                    next.setNeedSortChildren(false);
                }
            }
        }
    }

    public boolean behaviorSupportCreateAsync(String str) {
        Behavior behavior;
        if (str.equals(LynxConstants.ROOT_TAG_NAME) || (behavior = this.mBehaviorRegistry.get(str)) == null) {
            return false;
        }
        return behavior.supportCreateAsync();
    }

    public boolean behaviorNeedProcessDirection(String str) {
        Behavior behavior;
        if (str.equals(LynxConstants.ROOT_TAG_NAME) || (behavior = this.mBehaviorRegistry.get(str)) == null) {
            return false;
        }
        return behavior.needProcessDirection();
    }

    private void insertA11yMutationEvent(int i, LynxBaseUI lynxBaseUI) {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mUIBody.getLynxAccessibilityWrapper();
        if (lynxAccessibilityWrapper != null) {
            lynxAccessibilityWrapper.insertA11yMutationEvent(i, lynxBaseUI);
        }
    }

    public void registerBoundingClientRectUI(LynxBaseUI lynxBaseUI) {
        this.mCachedBoundingClientRectUI.add(lynxBaseUI);
    }

    public void onEnterForeground() {
        List<ForegroundListener> list = this.mForegroundListeners;
        if (list == null) {
            return;
        }
        Iterator<ForegroundListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onLynxViewEnterForeground();
        }
    }

    public void onEnterBackground() {
        List<ForegroundListener> list = this.mForegroundListeners;
        if (list == null) {
            return;
        }
        Iterator<ForegroundListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onLynxViewEnterBackground();
        }
    }

    void registerForegroundListener(ForegroundListener foregroundListener) {
        List<ForegroundListener> list = this.mForegroundListeners;
        if (list != null) {
            list.add(foregroundListener);
        }
    }

    public void unregisterForegroundListener(ForegroundListener foregroundListener) {
        List<ForegroundListener> list = this.mForegroundListeners;
        if (list != null) {
            list.remove(foregroundListener);
        }
    }

    public int getTagInfo(String str) {
        try {
            Behavior behavior = this.mBehaviorRegistry.get(str);
            ShadowNode createShadowNode = behavior != null ? behavior.createShadowNode() : null;
            if (createShadowNode != null) {
                return createShadowNode.isVirtual() ? 6 : 4;
            }
            return 1;
        } catch (RuntimeException unused) {
            return 0;
        }
    }

    public int getRootSign() {
        return this.mRootSign;
    }

    public void reportCreateAsyncSuccessEvent(int i, final String str, final boolean z, final int i2) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext != null && lynxContext.enableEventReporter() && this.mEnableReportCreateAsync) {
            LynxBaseUI node = getNode(i);
            final String simpleName = node != null ? node.getClass().getSimpleName() : null;
            LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_SUCCESS_EVENT, getContext().getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIOwner$$ExternalSyntheticLambda2
                @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
                public final Map build() {
                    return LynxUIOwner.lambda$reportCreateAsyncSuccessEvent$2(str, simpleName, z, i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$reportCreateAsyncSuccessEvent$2(String str, String str2, boolean z, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag_name", str);
        hashMap.put("class_name", str2);
        hashMap.put("success", Boolean.valueOf(z));
        hashMap.put("status", Integer.valueOf(i));
        return hashMap;
    }

    public void reportCreateViewConfig(int i, final String str, final boolean z) {
        LynxContext lynxContext = this.mContext;
        if (lynxContext == null || !lynxContext.enableEventReporter() || TextUtils.equals(str, LynxConstants.ROOT_TAG_NAME) || !this.mEnableReportCreateAsync || this.mCreateNodeConfigHasReportedMark.containsKey(str)) {
            return;
        }
        this.mCreateNodeConfigHasReportedMark.put(str, Boolean.valueOf(z));
        LynxBaseUI node = getNode(i);
        final String simpleName = node != null ? node.getClass().getSimpleName() : null;
        LynxEventReporter.onEvent(LYNXSDK_ASYNC_CREATE_CONFIG, getContext().getInstanceId(), new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.behavior.LynxUIOwner$$ExternalSyntheticLambda3
            @Override // com.lynx.tasm.eventreport.LynxEventReporter.PropsBuilder
            public final Map build() {
                return LynxUIOwner.lambda$reportCreateViewConfig$3(str, simpleName, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$reportCreateViewConfig$3(String str, String str2, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag_name", str);
        hashMap.put("class_name", str2);
        hashMap.put("enable_async", Boolean.valueOf(z));
        return hashMap;
    }

    public void setAttachLynxPageUICallback(UIBody.UIBodyView.attachLynxPageUICallback attachlynxpageuicallback) {
        this.mAttachLynxPageUICallback = attachlynxpageuicallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFrameAppBundle(int i, TemplateBundle templateBundle) {
        updateViewExtraData(i, templateBundle);
    }

    public void dispatchLayoutBefore(int i, ReadableCompactArrayBuffer readableCompactArrayBuffer) {
        this.mTextMeasurer.dispatchLayoutBefore(i, readableCompactArrayBuffer);
    }

    public float[] measureText(int i, float f, int i2, float f2, int i3, float[] fArr) {
        return this.mTextMeasurer.measureText(i, f, i2, f2, i3, fArr);
    }

    public Object takeTextLayout(int i) {
        TextMeasurer textMeasurer = this.mTextMeasurer;
        if (textMeasurer != null) {
            return textMeasurer.takeTextLayout(i);
        }
        return null;
    }

    public float[] align(int i) {
        return this.mTextMeasurer.align(i);
    }
}
