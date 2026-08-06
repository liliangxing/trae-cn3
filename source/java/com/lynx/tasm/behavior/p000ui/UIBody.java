package com.lynx.tasm.behavior.p000ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import androidx.core.util.Consumer;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.OnceTask;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.accessibility.LynxAccessibilityWrapper;
import com.lynx.tasm.behavior.p000ui.image.LynxImageManager;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.performance.longtasktiming.LynxLongTaskMonitor;
import com.lynx.tasm.performance.timing.ITimingCollector;
import com.lynx.tasm.performance.timing.TimingConstants;
import com.lynx.tasm.utils.SizeValue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIBody extends UIGroup<UIBodyView> {
    private static final String TAG = "UIBody";
    private LynxAccessibilityWrapper mA11yWrapper;
    private OnceTask<Void> mAttachTask;
    private UIBodyView mBodyView;
    private HashMap<String, EventTarget> mChildrenLynxPageUI;
    private ArrayList<LynxUI> mCreateViewUI;
    private OnceTask<Void> mDetachTask;
    private Consumer<Exception> mExceptionHandler;
    private EventTarget mParentLynxPageUI;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void createViewAsync() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public void ensureCreateView() {
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    protected void registerViewAccordingToNodeIndex() {
    }

    public UIBody(LynxContext lynxContext, UIBodyView uIBodyView) {
        super(lynxContext);
        this.mDetachTask = null;
        this.mAttachTask = null;
        this.mExceptionHandler = null;
        this.mBodyView = uIBodyView;
        initialize();
        this.mExceptionHandler = new Consumer<Exception>() { // from class: com.lynx.tasm.behavior.ui.UIBody.1
            public void accept(Exception exc) {
                if (UIBody.this.getLynxContext() != null) {
                    UIBody.this.getLynxContext().handleException(exc);
                }
            }
        };
    }

    public UIBodyView getBodyView() {
        return this.mBodyView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public UIBodyView getOrCreateView(Context context, Object obj) {
        return this.mBodyView;
    }

    public List<MeaningfulPaintingArea> getMeaningfulPaintingAreas() {
        tryRunDetachAndAttachTask();
        ArrayList<MeaningfulPaintingArea> arrayList = new ArrayList<>();
        convertToMeaningfulPaintingAreaRecursive(0, 0, arrayList);
        return arrayList;
    }

    public synchronized void attachUIBodyView(final UIBodyView uIBodyView, final LynxContext lynxContext) {
        OnceTask<Void> onceTask = new OnceTask<>(new Callable<Void>() { // from class: com.lynx.tasm.behavior.ui.UIBody.2
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                if (UIBody.this.mContext.isEnginePoolEnabled()) {
                    if (UIBody.this.mBodyView == uIBodyView) {
                        return null;
                    }
                    if (UIBody.this.mBodyView != null) {
                        UIBody.this.detachUIBodyView();
                    }
                }
                UIBody.this.mBodyView = uIBodyView;
                UIBody.this.initialize();
                if (!UIBody.this.mContext.isEnginePoolEnabled()) {
                    return null;
                }
                if (UIBody.this.mBodyView == null) {
                    LLog.e(UIBody.TAG, "attachUIBodyView failed since mBodyView is null.");
                    return null;
                }
                UIBody.this.mContext = lynxContext;
                UIBody.this.mContext.setUIBodyView(UIBody.this.mBodyView);
                TraceEvent.beginSection("UIBody.attachUIBodyView");
                UIBody.this.mContext.setUIBodyView(UIBody.this.mBodyView);
                UIBody.this.mCreateViewUI = new ArrayList();
                UIBody.this.attachToView(lynxContext);
                UIBody.this.mBodyView.markNeedRemoveExistingViews();
                TraceEvent.endSection("UIBody.attachUIBodyView");
                return null;
            }
        }, this.mExceptionHandler);
        this.mAttachTask = onceTask;
        if (this.mDetachTask == null) {
            onceTask.run();
        }
    }

    public synchronized void detachUIBodyView() {
        if (!this.mContext.isEnginePoolEnabled()) {
            LLog.w(TAG, "UIBody.detachUIBodyView should not be called when isEnginePoolEnabled == false.");
            return;
        }
        if (this.mBodyView == null) {
            return;
        }
        final boolean isLayoutRequested = ((UIBodyView) this.mView).isLayoutRequested();
        this.mBodyView.cacheLayoutInfo(getWidth(), getHeight());
        OnceTask<Void> onceTask = new OnceTask<>(new Callable<Void>() { // from class: com.lynx.tasm.behavior.ui.UIBody.3
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                TraceEvent.beginSection("UIBody.detachUIBodyView");
                UIBody.this.markDetachWithViewRecursively(true);
                if (isLayoutRequested) {
                    UIBody.this.performMeasureChildrenUI();
                    UIBody.this.performLayoutChildrenUI();
                }
                UIBody.this.processViewInfo();
                UIBody uIBody = UIBody.this;
                uIBody.detachWithViewInfo(uIBody.mViewInfo);
                UIBody.this.markDetachWithViewRecursively(false);
                TraceEvent.endSection("UIBody.detachUIBodyView");
                synchronized (this) {
                    if (UIBody.this.mAttachTask != null) {
                        UIBody.this.mAttachTask.run();
                    }
                }
                return null;
            }
        }, this.mExceptionHandler);
        this.mDetachTask = onceTask;
        LynxThreadPool.postUIOperationTask((Runnable) onceTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void detachWithViewInfo(ViewInfo viewInfo) {
        if (this.mViewInfo != null) {
            viewInfo = this.mViewInfo;
        }
        super.detachWithViewInfo(viewInfo);
        this.mBodyView = null;
    }

    public void appendUIWithCreateViewAsync(LynxUI lynxUI) {
        ArrayList<LynxUI> arrayList = this.mCreateViewUI;
        if (arrayList == null) {
            LLog.w(TAG, "UIBody.appendUIWithCreateViewAsync failed since mCreateViewUI is null.");
        } else {
            arrayList.add(lynxUI);
        }
    }

    public void rebuildViewTree() {
        if (this.mContext.isEnginePoolEnabled()) {
            TraceEvent.beginSection("UIBody.rebuildViewTree");
            synchronized (this) {
                OnceTask<Void> onceTask = this.mDetachTask;
                if (onceTask != null) {
                    onceTask.run();
                    this.mDetachTask.get();
                    this.mDetachTask = null;
                }
                OnceTask<Void> onceTask2 = this.mAttachTask;
                if (onceTask2 != null) {
                    onceTask2.run();
                    this.mAttachTask.get();
                    this.mAttachTask = null;
                }
            }
            UIBodyView uIBodyView = this.mBodyView;
            if (uIBodyView != null) {
                uIBodyView.removeExistingViews();
            }
            ArrayList<LynxUI> arrayList = this.mCreateViewUI;
            if (arrayList == null) {
                TraceEvent.endSection("UIBody.rebuildViewTree");
                return;
            }
            Iterator<LynxUI> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().ensureCreateView();
            }
            this.mCreateViewUI.clear();
            TraceEvent.endSection("UIBody.rebuildViewTree");
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onAttach() {
        if (this.mContext.isEnginePoolEnabled()) {
            tryRunDetachAndAttachTask();
        }
        super.onAttach();
    }

    public synchronized void tryRunDetachAndAttachTask() {
        if (this.mContext.isEnginePoolEnabled()) {
            OnceTask<Void> onceTask = this.mDetachTask;
            if (onceTask != null) {
                onceTask.run();
                this.mDetachTask.get();
            }
            OnceTask<Void> onceTask2 = this.mAttachTask;
            if (onceTask2 != null) {
                onceTask2.run();
                this.mAttachTask.get();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup, com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        initAccessibility();
    }

    protected void initAccessibility() {
        UIBodyView bodyView = getBodyView();
        if (bodyView == null || bodyView.isAccessibilityDisabled()) {
            return;
        }
        if (this.mA11yWrapper == null) {
            this.mA11yWrapper = new LynxAccessibilityWrapper(this);
        }
        this.mAccessibilityElementStatus = 1;
        bodyView.setLynxAccessibilityWrapper(this.mA11yWrapper);
    }

    public void onPageConfigDecoded(PageConfig pageConfig) {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mA11yWrapper;
        if (lynxAccessibilityWrapper != null) {
            lynxAccessibilityWrapper.onPageConfigDecoded(pageConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public View getRealParentView() {
        return this.mBodyView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public UIBodyView createView(Context context, Object obj) {
        return this.mBodyView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.p000ui.LynxUI
    public UIBodyView createView(Context context) {
        return this.mBodyView;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxUI, com.lynx.tasm.behavior.p000ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        UIBodyView uIBodyView = this.mBodyView;
        if (uIBodyView != null) {
            uIBodyView.notifyMeaningfulLayout();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float f, float f2) {
        boolean eventThrough = super.eventThrough(f, f2);
        if (!eventThrough) {
            eventThrough |= this.mContext.enableEventThrough();
        }
        if (this.mEventThroughActiveRegions == null) {
            return eventThrough;
        }
        float f3 = this.mContext.getResources().getDisplayMetrics().density;
        float f4 = f * f3;
        float f5 = f2 * f3;
        int i = 0;
        boolean z = false;
        while (true) {
            if (i >= this.mEventThroughActiveRegions.size()) {
                break;
            }
            ArrayList<SizeValue> arrayList = this.mEventThroughActiveRegions.get(i);
            if (arrayList != null && arrayList.size() == 4) {
                float convertToDevicePx = arrayList.get(0).convertToDevicePx(getWidth());
                float convertToDevicePx2 = arrayList.get(1).convertToDevicePx(getHeight());
                z = f4 >= convertToDevicePx && f4 < arrayList.get(2).convertToDevicePx((float) getWidth()) + convertToDevicePx && f5 >= convertToDevicePx2 && f5 < arrayList.get(3).convertToDevicePx((float) getHeight()) + convertToDevicePx2;
                if (z) {
                    LLog.i(TAG, "hit the event through active regions!");
                    break;
                }
            }
            i++;
        }
        return z ? eventThrough : !eventThrough;
    }

    @Override // com.lynx.tasm.behavior.p000ui.UIGroup
    public void removeAll() {
        super.removeAll();
        UIBodyView uIBodyView = this.mBodyView;
        if (uIBodyView != null) {
            uIBodyView.clearMeaningfulFlag();
        }
    }

    public boolean enableNewAccessibility() {
        LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mA11yWrapper;
        return lynxAccessibilityWrapper != null && lynxAccessibilityWrapper.enableDelegate();
    }

    public LynxAccessibilityWrapper getLynxAccessibilityWrapper() {
        return this.mA11yWrapper;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        return this.mParentLynxPageUI;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget eventTarget) {
        this.mParentLynxPageUI = eventTarget;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        return this.mChildrenLynxPageUI;
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> hashMap) {
        this.mChildrenLynxPageUI = hashMap;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class UIBodyView extends FrameLayout implements IDrawChildHook.IDrawChildHookBinding {
        protected LynxAccessibilityWrapper mA11yWrapper;
        private int mCacheHeight;
        private int mCacheWidth;
        private IDrawChildHook mDrawChildHook;
        private boolean mHasMeaningfulLayout;
        private boolean mHasMeaningfulPaint;
        private boolean mHasPendingRequestLayout;
        private ConcurrentHashMap<Integer, LynxImageManager> mImageMap;
        private int mInstanceId;
        private boolean mInterceptRequestLayout;
        private boolean mIsChildLynxPageUI;
        boolean mIsMeaningfulPaintingAreaInvalidate;
        protected ILynxUIRenderer mLynxUIRender;
        private long mMeaningfulPaintTiming;
        private boolean mNeedRemoveExistingViews;
        public int mSign;
        private WeakReference<ITimingCollector> mTimingCollector;
        private ConcurrentHashMap<Integer, View> mViewMap;

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public interface attachLynxPageUICallback {
            void attachLynxPageUI(WeakReference<Object> weakReference);
        }

        public LynxViewBuilder getLynxViewBuilder() {
            return null;
        }

        public boolean isAccessibilityDisabled() {
            return false;
        }

        public void runOnTasmThread(Runnable runnable) {
        }

        public void setAttachLynxPageUICallback(attachLynxPageUICallback attachlynxpageuicallback) {
        }

        public UIBodyView(Context context) {
            super(context);
            this.mViewMap = new ConcurrentHashMap<>();
            this.mImageMap = new ConcurrentHashMap<>();
            this.mTimingCollector = new WeakReference<>(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        public UIBodyView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mViewMap = new ConcurrentHashMap<>();
            this.mImageMap = new ConcurrentHashMap<>();
            this.mTimingCollector = new WeakReference<>(null);
            this.mInstanceId = -1;
            this.mNeedRemoveExistingViews = false;
            this.mIsMeaningfulPaintingAreaInvalidate = false;
        }

        public void cacheLayoutInfo(int i, int i2) {
            this.mCacheWidth = i;
            this.mCacheHeight = i2;
        }

        protected void onMeasureWhenDetach(int i, int i2) {
            performMeasure(i, this.mCacheWidth, i2, this.mCacheHeight);
            IDrawChildHook iDrawChildHook = this.mDrawChildHook;
            if (iDrawChildHook instanceof ViewInfo) {
                ((ViewInfo) iDrawChildHook).measure();
            }
        }

        protected void onLayoutWhenDetach() {
            IDrawChildHook iDrawChildHook = this.mDrawChildHook;
            if (iDrawChildHook instanceof ViewInfo) {
                ((ViewInfo) iDrawChildHook).layout();
            }
        }

        public void performMeasure(int i, int i2, int i3, int i4) {
            int i5;
            int i6;
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 0) {
                i5 = this.mCacheWidth;
            } else {
                i5 = View.MeasureSpec.getSize(i);
            }
            int mode2 = View.MeasureSpec.getMode(i3);
            if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
                i6 = this.mCacheHeight;
            } else {
                i6 = View.MeasureSpec.getSize(i3);
            }
            innerSetMeasuredDimension(i5, i6);
        }

        public boolean containsViewForNodeIndex(int i) {
            return this.mViewMap.containsKey(Integer.valueOf(i));
        }

        public View obtainViewAccordingToNodeIndex(int i) {
            View view = this.mViewMap.get(Integer.valueOf(i));
            this.mViewMap.remove(Integer.valueOf(i));
            return view;
        }

        public void registerViewAccordingToNodeIndex(int i, View view) {
            this.mViewMap.put(Integer.valueOf(i), view);
        }

        public void registerImageAccordingToNodeIndex(int i, LynxImageManager lynxImageManager) {
            this.mImageMap.put(Integer.valueOf(i), lynxImageManager);
        }

        public LynxImageManager obtainImageAccordingToNodeIndex(int i) {
            LynxImageManager lynxImageManager = this.mImageMap.get(Integer.valueOf(i));
            this.mImageMap.remove(Integer.valueOf(i));
            return lynxImageManager;
        }

        public void clearNodeIndexImageMap() {
            this.mImageMap.clear();
        }

        public void markNeedRemoveExistingViews() {
            this.mNeedRemoveExistingViews = true;
        }

        public void removeExistingViews() {
            if (this.mNeedRemoveExistingViews) {
                Iterator<Map.Entry<Integer, View>> it = this.mViewMap.entrySet().iterator();
                while (it.hasNext()) {
                    View value = it.next().getValue();
                    if (value.getParent() instanceof ViewGroup) {
                        ((ViewGroup) value.getParent()).removeView(value);
                    }
                }
                this.mViewMap.clear();
                this.mNeedRemoveExistingViews = false;
            }
        }

        @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
        public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
            this.mDrawChildHook = iDrawChildHook;
        }

        public void setLynxAccessibilityWrapper(LynxAccessibilityWrapper lynxAccessibilityWrapper) {
            this.mA11yWrapper = lynxAccessibilityWrapper;
        }

        @Override // android.view.View, android.view.ViewParent
        public void requestLayout() {
            if (this.mInterceptRequestLayout) {
                this.mHasPendingRequestLayout = true;
            } else {
                this.mHasPendingRequestLayout = false;
                super.requestLayout();
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.mIsMeaningfulPaintingAreaInvalidate = false;
            ITimingCollector iTimingCollector = this.mTimingCollector.get();
            if (iTimingCollector != null) {
                iTimingCollector.markHostPlatformTiming(TimingConstants.HOST_PLATFORM_DRAW_START);
            }
            boolean willProcessTask = LynxLongTaskMonitor.willProcessTask("LynxTemplateRender.Draw", this.mInstanceId, getLongTaskMonitorEnabled());
            IDrawChildHook iDrawChildHook = this.mDrawChildHook;
            if (iDrawChildHook != null) {
                iDrawChildHook.beforeDispatchDraw(canvas);
            }
            super.dispatchDraw(canvas);
            IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
            if (iDrawChildHook2 != null) {
                iDrawChildHook2.afterDispatchDraw(canvas);
            }
            if (this.mHasMeaningfulLayout && !this.mHasMeaningfulPaint) {
                TraceEvent.instant(1L, "FirstMeaningfulPaint");
                this.mMeaningfulPaintTiming = System.currentTimeMillis();
                this.mHasMeaningfulPaint = true;
            }
            if (iTimingCollector != null) {
                iTimingCollector.markHostPlatformTiming(TimingConstants.HOST_PLATFORM_DRAW_END);
                iTimingCollector.markPaintEndTimingIfNeeded();
            }
            if (willProcessTask) {
                LynxLongTaskMonitor.didProcessTask();
            }
        }

        void notifyMeaningfulLayout() {
            this.mHasMeaningfulLayout = true;
        }

        public long getMeaningfulPaintTiming() {
            return this.mMeaningfulPaintTiming;
        }

        void clearMeaningfulFlag() {
            this.mHasMeaningfulLayout = false;
            this.mHasMeaningfulPaint = false;
            this.mMeaningfulPaintTiming = 0L;
        }

        public void setTimingCollector(ITimingCollector iTimingCollector) {
            this.mTimingCollector = new WeakReference<>(iTimingCollector);
        }

        public void setInstanceId(int i) {
            this.mInstanceId = i;
        }

        @Override // android.view.ViewGroup
        protected boolean drawChild(Canvas canvas, View view, long j) {
            boolean drawChild;
            IDrawChildHook iDrawChildHook = this.mDrawChildHook;
            Rect beforeDrawChild = iDrawChildHook != null ? iDrawChildHook.beforeDrawChild(canvas, view, j) : null;
            if (beforeDrawChild != null) {
                canvas.save();
                canvas.clipRect(beforeDrawChild);
                drawChild = super.drawChild(canvas, view, j);
                canvas.restore();
            } else {
                drawChild = super.drawChild(canvas, view, j);
            }
            IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
            if (iDrawChildHook2 != null) {
                iDrawChildHook2.afterDrawChild(canvas, view, j);
            }
            return drawChild;
        }

        @Override // android.view.ViewGroup
        public void setChildrenDrawingOrderEnabled(boolean z) {
            super.setChildrenDrawingOrderEnabled(z);
        }

        @Override // android.view.ViewGroup
        protected int getChildDrawingOrder(int i, int i2) {
            IDrawChildHook iDrawChildHook = this.mDrawChildHook;
            if (iDrawChildHook != null) {
                return iDrawChildHook.getChildDrawingOrder(i, i2);
            }
            return super.getChildDrawingOrder(i, i2);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchHoverEvent(MotionEvent motionEvent) {
            if (isAccessibilityDisabled()) {
                return super.dispatchHoverEvent(motionEvent);
            }
            LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mA11yWrapper;
            if (lynxAccessibilityWrapper != null) {
                if (lynxAccessibilityWrapper.enableHelper()) {
                    return super.dispatchHoverEvent(motionEvent);
                }
                if (this.mA11yWrapper.onHoverEvent(this, motionEvent)) {
                    return true;
                }
            }
            return onHoverEvent(motionEvent);
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            if (isAccessibilityDisabled()) {
                return super.requestSendAccessibilityEvent(view, accessibilityEvent);
            }
            LynxAccessibilityWrapper lynxAccessibilityWrapper = this.mA11yWrapper;
            if (lynxAccessibilityWrapper != null && !lynxAccessibilityWrapper.enableHelper() && accessibilityEvent.getEventType() == 2048) {
                accessibilityEvent.setSource(this);
            }
            return super.requestSendAccessibilityEvent(view, accessibilityEvent);
        }

        public void setShouldInterceptRequestLayout(boolean z) {
            this.mInterceptRequestLayout = z;
        }

        public boolean HasPendingRequestLayout() {
            return this.mHasPendingRequestLayout;
        }

        public LynxBooleanOption getLongTaskMonitorEnabled() {
            LynxBooleanOption lynxBooleanOption = LynxBooleanOption.UNSET;
            Context context = getContext();
            return context instanceof LynxContext ? ((LynxContext) context).getLongTaskMonitorEnabled() : lynxBooleanOption;
        }

        public boolean isChildLynxPageUI() {
            return this.mIsChildLynxPageUI;
        }

        public void setIsChildLynxPageUI(boolean z) {
            this.mIsChildLynxPageUI = z;
        }

        public ILynxUIRenderer getLynxUIRendererInternal() {
            return this.mLynxUIRender;
        }

        public void setLynxUIRendererInternal(ILynxUIRenderer iLynxUIRenderer) {
            this.mLynxUIRender = iLynxUIRenderer;
        }

        public void innerSetMeasuredDimension(int i, int i2) {
            if (TraceEvent.isTracingStarted()) {
                HashMap hashMap = new HashMap();
                hashMap.put("width", String.valueOf(i));
                hashMap.put("height", String.valueOf(i2));
                TraceEvent.instant(0L, "UIBody.innerSetMeasuredDimension", hashMap);
            }
            setMeasuredDimension(i, i2);
        }

        public boolean isMeaningfulPaintingAreaInvalidate() {
            return this.mIsMeaningfulPaintingAreaInvalidate;
        }

        public void invalidateMeaningfulPaintingArea() {
            this.mIsMeaningfulPaintingAreaInvalidate = true;
        }

        public List<MeaningfulPaintingArea> getMeaningfulPaintingAreas() {
            if (!(this.mDrawChildHook instanceof ViewInfo)) {
                return null;
            }
            ArrayList<MeaningfulPaintingArea> arrayList = new ArrayList<>();
            ((ViewInfo) this.mDrawChildHook).generateMeaningfulPaintingArea(0, 0, arrayList);
            return arrayList;
        }
    }
}
