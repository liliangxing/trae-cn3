package com.lynx.tasm.behavior;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.mapbuffer.CompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.PropBundle;
import com.lynx.tasm.behavior.p000ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.shadow.TextLayout;
import com.lynx.tasm.behavior.utils.LynxUIMethodsExecutor;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.gesture.detector.GestureDetector;
import com.lynx.tasm.performance.PerformanceController;
import com.lynx.tasm.utils.UIThreadUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.appdownloader.util.parser.manifest.TypedValue;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class PaintingContext implements IPaintingContext {
    private static final String TAG = "lynx_PaintingContext";
    private long mNativePaintingContextPtr;
    private TextLayout mTextLayout;
    private final LynxUIOwner mUIOwner;
    private boolean mDestroyed = false;
    private ConcurrentHashMap<String, Boolean> mNeedCreateNodeAsyncCache = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> mNeedProcessDirectionCache = new ConcurrentHashMap<>();

    private float[] getScrollDefaultResult(float f, float f2) {
        return new float[]{0.0f, 0.0f, f, f2};
    }

    private native long nativeCreatePaintingContext(Object obj, Object obj2, int i, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeInvokeCallback(long j, int i, WritableArray writableArray);

    public PaintingContext(LynxUIOwner lynxUIOwner, int i) {
        this.mNativePaintingContextPtr = 0L;
        this.mUIOwner = lynxUIOwner;
        if (lynxUIOwner.getContext().isLayoutInElementModeOn()) {
            this.mTextLayout = new TextLayout(lynxUIOwner);
        }
        this.mNativePaintingContextPtr = nativeCreatePaintingContext(this, this.mTextLayout, i, lynxUIOwner.isContextFree());
    }

    @Override // com.lynx.tasm.behavior.IPaintingContext
    public void destroy() {
        this.mDestroyed = true;
    }

    @Override // com.lynx.tasm.behavior.IPaintingContext
    public long getNativePaintingContextPtr() {
        return this.mNativePaintingContextPtr;
    }

    public void rebuildViewTree() {
        this.mUIOwner.rebuildViewTree();
    }

    public void updateLayout(int i, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float[] fArr, float[] fArr2, float f17, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Rect rect;
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        int i8 = (int) f;
        int i9 = (int) f2;
        int i10 = (int) f3;
        int i11 = (int) f4;
        int i12 = (int) f5;
        int i13 = (int) f6;
        int i14 = (int) f7;
        int i15 = (int) f8;
        int i16 = (int) f9;
        int i17 = (int) f10;
        int i18 = (int) f11;
        int i19 = (int) f12;
        int i20 = (int) f13;
        int i21 = (int) f14;
        int i22 = (int) f15;
        int i23 = (int) f16;
        if (fArr != null) {
            i4 = i23;
            i3 = i22;
            i7 = i20;
            i6 = i19;
            i5 = i18;
            rect = new Rect((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        } else {
            i3 = i22;
            i4 = i23;
            i5 = i18;
            i6 = i19;
            i7 = i20;
            rect = null;
        }
        lynxUIOwner.updateLayout(i, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i5, i6, i7, i21, i3, i4, rect, fArr2, f17, i2);
    }

    public void updateProps(int i, boolean z, PropBundle propBundle, ReadableMapBuffer readableMapBuffer) {
        ReadableMap props = propBundle != null ? propBundle.getProps() : null;
        this.mUIOwner.updateProperties(i, z, props != null ? new StylesDiffMap(props, readableMapBuffer) : null, EventsListener.convertEventListeners(propBundle != null ? propBundle.getEventHandlers() : null), GestureDetector.convertGestureDetectors(propBundle != null ? propBundle.getGestures() : null));
    }

    public Object createNode(final int i, final String str, final PropBundle propBundle, final ReadableMapBuffer readableMapBuffer, final boolean z, final int i2) {
        if (needCreateNodeAsync(str, i2)) {
            ReadableMap props = propBundle != null ? propBundle.getProps() : null;
            ReadableArray eventHandlers = propBundle != null ? propBundle.getEventHandlers() : null;
            final ReadableArray gestures = propBundle != null ? propBundle.getGestures() : null;
            final Future<Runnable> createNodeAsync = createNodeAsync(i, str, props, readableMapBuffer, eventHandlers, z, i2, gestures);
            final ReadableMap readableMap = props;
            final ReadableArray readableArray = eventHandlers;
            return new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext.1
                @Override // java.lang.Runnable
                public void run() {
                    PaintingContext.this.executeFuture(createNodeAsync, i, str, readableMap, readableMapBuffer, readableArray, z, i2, gestures);
                    PaintingContext.this.mUIOwner.reportCreateViewConfig(i, str, true);
                }
            };
        }
        return new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext.2
            @Override // java.lang.Runnable
            public void run() {
                PaintingContext.this.createPaintingNodeSync(i, str, propBundle, readableMapBuffer, z, i2);
            }
        };
    }

    private boolean needCreateNodeAsync(String str, int i) {
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        boolean z = false;
        if (lynxUIOwner != null && lynxUIOwner.getContext() != null && this.mUIOwner.getContext().isFallbackProcess() && this.mUIOwner.getContext().getUIBodyView().containsViewForNodeIndex(i)) {
            return false;
        }
        if (this.mNeedCreateNodeAsyncCache.containsKey(str)) {
            return this.mNeedCreateNodeAsyncCache.get(str).booleanValue();
        }
        if (LynxEnv.inst().getCreateViewAsync() && this.mUIOwner.getEnableCreateViewAsync()) {
            z = this.mUIOwner.behaviorSupportCreateAsync(str);
        }
        this.mNeedCreateNodeAsyncCache.put(str, Boolean.valueOf(z));
        return z;
    }

    private boolean needProcessDirection(String str) {
        if (this.mNeedProcessDirectionCache.containsKey(str)) {
            return this.mNeedProcessDirectionCache.get(str).booleanValue();
        }
        boolean behaviorNeedProcessDirection = this.mUIOwner.behaviorNeedProcessDirection(str);
        this.mNeedProcessDirectionCache.put(str, Boolean.valueOf(behaviorNeedProcessDirection));
        return behaviorNeedProcessDirection;
    }

    public void createPaintingNodeSync(int i, String str, PropBundle propBundle, ReadableMapBuffer readableMapBuffer, boolean z, int i2) {
        this.mUIOwner.createView(i, str, propBundle != null ? propBundle.getProps() : null, readableMapBuffer, propBundle != null ? propBundle.getEventHandlers() : null, z, i2, propBundle != null ? propBundle.getGestures() : null);
        this.mUIOwner.reportCreateViewConfig(i, str, false);
    }

    public Future<Runnable> createNodeAsync(int i, String str, ReadableMap readableMap, ReadableMapBuffer readableMapBuffer, ReadableArray readableArray, boolean z, int i2, ReadableArray readableArray2) {
        return this.mUIOwner.createViewAsync(i, str, readableMap != null ? new StylesDiffMap(readableMap, readableMapBuffer) : null, EventsListener.convertEventListeners(readableArray), z, i2, GestureDetector.convertGestureDetectors(readableArray2));
    }

    public Object createPaintingNodeAsync(int i, String str, PropBundle propBundle, ReadableMapBuffer readableMapBuffer, boolean z, int i2) {
        return this.mUIOwner.createViewAsyncRunnable(i, str, propBundle != null ? propBundle.getProps() : null, readableMapBuffer, propBundle != null ? propBundle.getEventHandlers() : null, z, i2, propBundle != null ? propBundle.getGestures() : null);
    }

    public void setNeedMarkPaintEndTiming(String str) {
        LynxContext context;
        PerformanceController perfController;
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        if (lynxUIOwner == null || (context = lynxUIOwner.getContext()) == null || (perfController = context.getPerfController()) == null) {
            return;
        }
        perfController.setNeedMarkPaintEndTiming(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean executeFuture(Future<Runnable> future, int i, String str, ReadableMap readableMap, ReadableMapBuffer readableMapBuffer, ReadableArray readableArray, boolean z, int i2, ReadableArray readableArray2) {
        int i3;
        Runnable runnable = null;
        if (!future.isDone()) {
            i3 = !future.cancel(true) ? 1 : 0;
            LLog.i(TAG, "createViewAsync not done, will create on ui thread, tagName:" + str);
        } else {
            try {
                runnable = future.get();
                i3 = 2;
            } catch (InterruptedException | ExecutionException e) {
                String str2 = "createViewAsync failed, tagName:" + str + ", error:" + e;
                LLog.e(TAG, str2);
                this.mUIOwner.getContext().handleException(new Exception(str2));
                i3 = 3;
            }
        }
        if (runnable != null) {
            runnable.run();
            this.mUIOwner.reportCreateAsyncSuccessEvent(i, str, true, i3);
            return true;
        }
        this.mUIOwner.createView(i, str, readableMap, readableMapBuffer, readableArray, z, i2, readableArray2);
        this.mUIOwner.reportCreateAsyncSuccessEvent(i, str, false, i3);
        return false;
    }

    public void insertNode(int i, int i2, int i3) {
        this.mUIOwner.insert(i, i2, i3);
    }

    public void removeNode(int i, int i2) {
        this.mUIOwner.remove(i, i2);
    }

    public void destroyNode(int i, int i2) {
        this.mUIOwner.destroy(i, i2);
    }

    private void flushUIOperationBatch(ReadableCompactArrayBuffer readableCompactArrayBuffer) {
        if (readableCompactArrayBuffer == null) {
            return;
        }
        Iterator it = readableCompactArrayBuffer.iterator();
        while (it.hasNext()) {
            int i = ((CompactArrayBuffer.Entry) it.next()).getInt();
            int i2 = 0;
            switch (i) {
                case 0:
                    insertNode(((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt());
                    break;
                case 1:
                    removeNode(((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt());
                    break;
                case 2:
                    destroyNode(((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getInt());
                    break;
                case 3:
                    int i3 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    int[] iArr = new int[i3];
                    while (i2 < i3) {
                        iArr[i2] = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        i2++;
                    }
                    updateNodeReadyPatching(iArr);
                    break;
                case 4:
                    int i4 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    int[] iArr2 = new int[i4];
                    while (i2 < i4) {
                        iArr2[i2] = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        i2++;
                    }
                    updateNodeRemovePatching(iArr2);
                    break;
                case 5:
                    int i5 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    int[] iArr3 = new int[i5];
                    for (int i6 = 0; i6 < i5; i6++) {
                        iArr3[i6] = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    }
                    int i7 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    int[] iArr4 = new int[i7];
                    for (int i8 = 0; i8 < i7; i8++) {
                        iArr4[i8] = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    }
                    int i9 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    float[] fArr = new float[i9];
                    for (int i10 = 0; i10 < i9; i10++) {
                        fArr[i10] = (float) ((CompactArrayBuffer.Entry) it.next()).getDouble();
                    }
                    int i11 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    float[] fArr2 = new float[i11];
                    for (int i12 = 0; i12 < i11; i12++) {
                        fArr2[i12] = (float) ((CompactArrayBuffer.Entry) it.next()).getDouble();
                    }
                    int i13 = ((CompactArrayBuffer.Entry) it.next()).getInt();
                    int[] iArr5 = new int[i13];
                    while (i2 < i13) {
                        iArr5[i2] = ((CompactArrayBuffer.Entry) it.next()).getInt();
                        i2++;
                    }
                    UpdateLayoutPatching(iArr3, iArr4, fArr, fArr2, iArr5);
                    break;
                case 6:
                    finishTasmOperation(((CompactArrayBuffer.Entry) it.next()).getLong());
                    break;
                case 7:
                    FinishLayoutOperation(((CompactArrayBuffer.Entry) it.next()).getInt(), ((CompactArrayBuffer.Entry) it.next()).getLong(), true);
                    break;
                default:
                    LLog.e(TAG, "flushUIOperationBatch with unknown UIOperationType: " + i);
                    return;
            }
        }
    }

    public void updateFlattenStatus(int i, boolean z) {
        this.mUIOwner.updateFlatten(i, z);
    }

    public void setKeyframes(PropBundle propBundle) {
        if (propBundle == null || propBundle.getProps() == null) {
            return;
        }
        this.mUIOwner.getContext().removeAnimationKeyframe(propBundle.getProps().getString("removeKeyframe"));
        this.mUIOwner.getContext().setKeyframes(propBundle.getProps().getMap("keyframes"));
    }

    public void SetGestureDetectorState(int i, int i2, int i3) {
        this.mUIOwner.setGestureDetectorState(i, i2, i3);
    }

    public void consumeGesture(int i, int i2, ReadableMap readableMap) {
        this.mUIOwner.consumeGesture(i, i2, readableMap);
    }

    public void validate(int i) {
        this.mUIOwner.validate(i);
    }

    private void finishTasmOperation(long j) {
        this.mUIOwner.onTasmFinish(j);
    }

    public void FinishLayoutOperation(int i, long j, boolean z) {
        this.mUIOwner.onLayoutFinish(i, j);
    }

    public void updateExtraData(int i, Object obj) {
        this.mUIOwner.updateViewExtraData(i, obj);
    }

    public float[] getBoundingClientOrigin(int i) {
        float[] fArr = {0.0f, 0.0f};
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node != null) {
            Rect boundingClientRect = node.getBoundingClientRect();
            fArr[0] = boundingClientRect.left;
            fArr[1] = boundingClientRect.top;
        }
        return fArr;
    }

    public void scrollIntoView(int i) {
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node == null) {
            return;
        }
        node.scrollIntoView(false, "center", "center", null);
    }

    public float[] getWindowSize(int i) {
        float[] fArr = new float[2];
        WindowManager windowManager = (WindowManager) this.mUIOwner.getContext().getContext().getSystemService("window");
        if (windowManager == null) {
            return null;
        }
        windowManager.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        fArr[0] = r1.widthPixels;
        fArr[1] = r1.heightPixels;
        return fArr;
    }

    public float[] getRectToWindow(int i) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node != null) {
            Rect rectToWindow = node.getRectToWindow();
            fArr[0] = rectToWindow.left;
            fArr[1] = rectToWindow.top;
            fArr[2] = rectToWindow.width();
            fArr[3] = rectToWindow.height();
        }
        return fArr;
    }

    public float[] getRectToLynxView(int i) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node != null) {
            Rect boundingClientRect = node.getBoundingClientRect();
            fArr[0] = boundingClientRect.left;
            fArr[1] = boundingClientRect.top;
            fArr[2] = boundingClientRect.width();
            fArr[3] = boundingClientRect.height();
        }
        return fArr;
    }

    public float[] scrollBy(final int i, final float f, final float f2) {
        if (UIThreadUtils.isOnUiThread()) {
            LynxBaseUI node = this.mUIOwner.getNode(i);
            if (node != null) {
                return node.scrollBy(f, f2);
            }
            return getScrollDefaultResult(f, f2);
        }
        UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PaintingContext.this.m4122lambda$scrollBy$0$comlynxtasmbehaviorPaintingContext(i, f, f2);
            }
        });
        return getScrollDefaultResult(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$scrollBy$0$com-lynx-tasm-behavior-PaintingContext, reason: not valid java name */
    public /* synthetic */ void m4122lambda$scrollBy$0$comlynxtasmbehaviorPaintingContext(int i, float f, float f2) {
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node != null) {
            node.scrollBy(f, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.lynx.tasm.behavior.PaintingContext$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class RunnableC00433 implements Runnable {
        final /* synthetic */ int val$callback;
        final /* synthetic */ long val$context;
        final /* synthetic */ String val$method;
        final /* synthetic */ ReadableMap val$params;
        final /* synthetic */ int val$sign;

        RunnableC00433(long j, int i, int i2, String str, ReadableMap readableMap) {
            this.val$context = j;
            this.val$callback = i;
            this.val$sign = i2;
            this.val$method = str;
            this.val$params = readableMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cb, reason: merged with bridge method [inline-methods] */
        public void m4124lambda$null$1$comlynxtasmbehaviorPaintingContext$3(final Object... objArr) {
            if (PaintingContext.this.mDestroyed || PaintingContext.this.mUIOwner.getContext() == null) {
                return;
            }
            LynxContext context = PaintingContext.this.mUIOwner.getContext();
            final long j = this.val$context;
            final int i = this.val$callback;
            context.runOnTasmThread(new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext$3$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PaintingContext.RunnableC00433.this.m4123lambda$cb$0$comlynxtasmbehaviorPaintingContext$3(j, i, objArr);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$cb$0$com-lynx-tasm-behavior-PaintingContext$3, reason: not valid java name */
        public /* synthetic */ void m4123lambda$cb$0$comlynxtasmbehaviorPaintingContext$3(long j, int i, Object[] objArr) {
            PaintingContext.this.nativeInvokeCallback(j, i, JavaOnlyArray.of(objArr));
        }

        @Override // java.lang.Runnable
        public void run() {
            LynxBaseUI node = PaintingContext.this.mUIOwner.getNode(this.val$sign);
            if (node != null) {
                LynxUIMethodsExecutor.invokeMethod(node, this.val$method, this.val$params, new Callback() { // from class: com.lynx.tasm.behavior.PaintingContext$3$$ExternalSyntheticLambda0
                    public final void invoke(Object[] objArr) {
                        PaintingContext.RunnableC00433.this.m4125lambda$run$2$comlynxtasmbehaviorPaintingContext$3(objArr);
                    }
                });
            } else {
                m4124lambda$null$1$comlynxtasmbehaviorPaintingContext$3(6, String.format("Worklet: node %d does not have a LynxUI", Integer.valueOf(this.val$sign)));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$run$2$com-lynx-tasm-behavior-PaintingContext$3, reason: not valid java name */
        public /* synthetic */ void m4125lambda$run$2$comlynxtasmbehaviorPaintingContext$3(final Object[] objArr) {
            UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext$3$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    PaintingContext.RunnableC00433.this.m4124lambda$null$1$comlynxtasmbehaviorPaintingContext$3(objArr);
                }
            });
        }
    }

    public void invoke(int i, String str, ReadableMap readableMap, long j, int i2) {
        UIThreadUtils.runOnUiThreadImmediately(new RunnableC00433(j, i2, i, str, readableMap));
    }

    private void setLayoutData(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, Rect rect, float[] fArr, int i18, int i19) {
        this.mUIOwner.updateLayout(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, rect, fArr, i18, i19);
    }

    public void UpdateLayoutPatching(int[] iArr, int[] iArr2, float[] fArr, float[] fArr2, int[] iArr3) {
        Rect rect;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 19;
            float[] fArr3 = null;
            if (iArr2[i4 + 16] != 0) {
                int i5 = i * 4;
                i++;
                rect = new Rect((int) fArr[i5], (int) fArr[i5 + 1], (int) fArr[i5 + 2], (int) fArr[i5 + 3]);
            } else {
                rect = null;
            }
            if (iArr2[i4 + 17] != 0) {
                int i6 = i2 * 4;
                fArr3 = new float[]{fArr2[i6], fArr2[i6 + 1], fArr2[i6 + 2], fArr2[i6 + 3]};
                i2++;
            }
            setLayoutData(iArr[i3], iArr2[i4 + 0], iArr2[i4 + 1], iArr2[i4 + 2], iArr2[i4 + 3], iArr2[i4 + 4], iArr2[i4 + 5], iArr2[i4 + 6], iArr2[i4 + 7], iArr2[i4 + 8], iArr2[i4 + 9], iArr2[i4 + 10], iArr2[i4 + 11], iArr2[i4 + 12], iArr2[i4 + 13], iArr2[i4 + 14], iArr2[i4 + 15], rect, fArr3, iArr2[i4 + 18], iArr3[i3]);
        }
    }

    public void updateNodeReadyPatching(int[] iArr, int[] iArr2) {
        updateNodeReadyPatching(iArr);
        updateNodeRemovePatching(iArr2);
    }

    private void updateNodeReadyPatching(int[] iArr) {
        for (int i : iArr) {
            this.mUIOwner.onNodeReady(i);
        }
    }

    private void updateNodeRemovePatching(int[] iArr) {
        for (int i : iArr) {
            this.mUIOwner.onNodeRemoved(i);
        }
    }

    public void updateEventInfo(boolean z) {
        this.mUIOwner.setHasTouchPseudo(z);
    }

    public void updateNodeReloadPatching(int[] iArr) {
        for (int i : iArr) {
            this.mUIOwner.onNodeReload(i);
        }
    }

    public void reuseListNode(int i, String str) {
        this.mUIOwner.reuseListNode(i, str);
    }

    public void listCellDisappear(int i, boolean z, String str) {
        this.mUIOwner.listCellDisappear(i, Boolean.valueOf(z), str);
    }

    public void listCellAppear(int i, String str) {
        this.mUIOwner.listCellAppear(i, str);
    }

    public void requestLayout() {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.behavior.PaintingContext.4
            @Override // java.lang.Runnable
            public void run() {
                if (PaintingContext.this.mUIOwner.getRootUI() != null) {
                    PaintingContext.this.mUIOwner.getRootUI().requestLayout();
                }
            }
        });
    }

    public int getTagInfo(String str) {
        int tagInfo = this.mUIOwner.getTagInfo(str);
        if ((tagInfo & 2) > 0) {
            return tagInfo & TypedValue.DENSITY_NONE;
        }
        return ((needProcessDirection(str) ? 1 : 0) << 17) | ((needCreateNodeAsync(str, -1) ? 1 : 0) << 16) | (tagInfo & TypedValue.DENSITY_NONE);
    }

    public void removeListItemNode(int i, int i2) {
        String str;
        if (TraceEvent.isTracingStarted()) {
            str = "PaintingContext.removeListItemNode." + i + RomUtils.SEPARATOR + i2;
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        LynxBaseUI node = this.mUIOwner.getNode(i);
        LynxBaseUI node2 = this.mUIOwner.getNode(i2);
        if ((node instanceof UIListContainer) && (node2 instanceof UIComponent)) {
            ((UIListContainer) node).removeView(node2);
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    public void insertListItemNode(int i, int i2) {
        String str;
        if (TraceEvent.isTracingStarted()) {
            str = "PaintingContext.insertListItemNode." + i + RomUtils.SEPARATOR + i2;
            TraceEvent.beginSection(str);
        } else {
            str = null;
        }
        LynxBaseUI node = this.mUIOwner.getNode(i);
        LynxBaseUI node2 = this.mUIOwner.getNode(i2);
        if ((node instanceof UIListContainer) && (node2 instanceof UIComponent)) {
            ((UIListContainer) node).insertListItemNode(node2);
        }
        if (TraceEvent.isTracingStarted()) {
            TraceEvent.endSection(str);
        }
    }

    public void updateContentSizeAndOffset(int i, float f, float f2, float f3) {
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node instanceof UIListContainer) {
            ((UIListContainer) node).updateContentSizeAndOffset(f, f2, f3);
        }
    }

    public void updateScrollInfo(int i, boolean z, float f, boolean z2) {
        LynxBaseUI node = this.mUIOwner.getNode(i);
        if (node instanceof UIListContainer) {
            ((UIListContainer) node).updateScrollInfo(z, f, z2);
        }
    }

    private void setFrameAppBundle(int i, TemplateBundle templateBundle) {
        this.mUIOwner.setFrameAppBundle(i, templateBundle);
    }

    private void markUIOperationQueueFlushForRecreateEngine(boolean z) {
        LynxUIOwner lynxUIOwner = this.mUIOwner;
        if (lynxUIOwner == null || lynxUIOwner.getContext() == null) {
            return;
        }
        this.mUIOwner.getContext().markFallbackProcess(z);
    }
}
