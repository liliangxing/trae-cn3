package com.lynx.tasm.behavior;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.ClayDelegate;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.LynxPageLoadListener;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.shadow.LayoutTick;
import com.lynx.tasm.utils.ClayInitUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIRendererClay implements ILynxUIRenderer {
    private static final String TAG = "LynxUIRendererClay";
    private static boolean mIsClayInited;
    WeakReference<BehaviorRegistry> mBehaviorRegistry;
    private ClayDelegate mClayDelegate;
    private LynxUIRendererClayConfig mConfig;
    WeakReference<LynxContext> mLynxContext;
    private LynxUIRenderer mLynxUIRenderer;
    WeakReference<NativeFacade> mNativeFacade;
    private UIBody mUIBody;
    WeakReference<UIBody.UIBodyView> mUIBodyView;

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void attachBodyView(UIBody.UIBodyView uIBodyView, LynxContext lynxContext, Context context) {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean disableBindDrawChildHook() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void drawViewToBitmap(View view, Bitmap bitmap, Canvas canvas) {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean enableTimingCollector() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public String getActualScreenshotMode() {
        return "lynxview";
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public DisplayMetrics getScreenMetrics() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean isAccessibilityDisabled() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxUIOwner lynxUIOwner() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean needHandleDispatchKeyEvent() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDestroyTemplateRenderer() {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void scrollIntoViewFromUI(int i) {
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean shouldInvokeNativeViewMethod() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean useInvokeUIMethod() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryInitClaySo() {
        if (mIsClayInited) {
            return;
        }
        if (!LynxEnv.inst().isNativeLibraryLoaded()) {
            LLog.e(TAG, "LynxEnv has not been inited, clay so init failed");
        } else {
            mIsClayInited = ClayInitUtils.initClaySo(LynxEnv.inst().getAppContext(), LynxEnv.inst().getLibraryLoader(), LynxEnv.inst().getResProvider());
        }
    }

    public static boolean isClayInited() {
        return mIsClayInited;
    }

    public LynxUIRendererClay(LynxUIRendererClayConfig lynxUIRendererClayConfig) {
        this.mConfig = lynxUIRendererClayConfig;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onInitBodyView(UIBody.UIBodyView uIBodyView, Context context, LynxGroup lynxGroup) {
        if (!(uIBodyView instanceof LynxView)) {
            LLog.e(TAG, "support LynxView only");
        } else {
            this.mClayDelegate = ClayInitUtils.initClayDelegateForLynxView((LynxView) uIBodyView, context, this, lynxGroup != null ? lynxGroup.getID() : null);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void attachNativeFacade(NativeFacade nativeFacade) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.attachNativeFacade(nativeFacade);
        } else {
            this.mNativeFacade = new WeakReference<>(nativeFacade);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onInitLynxTemplateRender(LynxContext lynxContext, BehaviorRegistry behaviorRegistry, UIBody.UIBodyView uIBodyView, LynxBooleanOption lynxBooleanOption) {
        UIBody uIBody = new UIBody(lynxContext, uIBodyView);
        this.mUIBody = uIBody;
        lynxContext.setUIBody(uIBody);
        this.mLynxContext = new WeakReference<>(lynxContext);
        this.mBehaviorRegistry = new WeakReference<>(behaviorRegistry);
        this.mUIBodyView = new WeakReference<>(uIBodyView);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onCreateTemplateRenderer(LynxContext lynxContext, LynxPageLoadListener lynxPageLoadListener, ThreadStrategyForRendering threadStrategyForRendering, BehaviorRegistry behaviorRegistry, LayoutTick layoutTick) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate == null) {
            return;
        }
        clayDelegate.onCreateTemplateRenderer(lynxContext);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public long getUIDelegatePtr() {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            return clayDelegate.getUIDelegatePtr();
        }
        return 0L;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onReloadAndInitUIThreadPart() {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            clayDelegate.reloadAndInit();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onReloadAndInitAnyThreadPart() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onReloadAndInitAnyThreadPart();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onPageConfigDecoded(PageConfig pageConfig) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            clayDelegate.onPageConfigDecoded(pageConfig);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterForeground() {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            clayDelegate.onEnterForeground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterBackground() {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            clayDelegate.onEnterBackground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDestroy() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onDestroy();
            this.mLynxUIRenderer = null;
        }
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            clayDelegate.onDestroy();
            this.mClayDelegate = null;
        }
    }

    public LynxUIOwner lynxUIOwnerForNativeRendering() {
        if (this.mLynxUIRenderer == null) {
            WeakReference<LynxContext> weakReference = this.mLynxContext;
            LynxContext lynxContext = weakReference != null ? weakReference.get() : null;
            WeakReference<BehaviorRegistry> weakReference2 = this.mBehaviorRegistry;
            BehaviorRegistry behaviorRegistry = weakReference2 != null ? weakReference2.get() : null;
            WeakReference<UIBody.UIBodyView> weakReference3 = this.mUIBodyView;
            UIBody.UIBodyView uIBodyView = weakReference3 != null ? weakReference3.get() : null;
            if (lynxContext == null || behaviorRegistry == null) {
                LLog.e(TAG, "LynxUIRendererClay delay init LynxUIOwner failed");
                return null;
            }
            LLog.i(TAG, "LynxUIRendererClay delay init LynxUIOwner");
            LynxUIRenderer lynxUIRenderer = new LynxUIRenderer();
            this.mLynxUIRenderer = lynxUIRenderer;
            lynxUIRenderer.onInitLynxTemplateRender(lynxContext, behaviorRegistry, uIBodyView, null);
            WeakReference<NativeFacade> weakReference4 = this.mNativeFacade;
            NativeFacade nativeFacade = weakReference4 != null ? weakReference4.get() : null;
            if (nativeFacade != null) {
                this.mLynxUIRenderer.attachNativeFacade(nativeFacade);
            }
        }
        return this.mLynxUIRenderer.lynxUIOwner();
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public UIGroup<UIBody.UIBodyView> getLynxRootUI() {
        return this.mUIBody;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void pauseRootLayoutAnimation() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.pauseRootLayoutAnimation();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void resumeRootLayoutAnimation() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.resumeRootLayoutAnimation();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onAttach() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onAttach();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onDetach() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onDetach();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterForegroundInternal() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onEnterForeground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onEnterBackgroundInternal() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onEnterBackground();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void setContextFree(boolean z) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.setContextFree(z);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void setFirstLayout() {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.setFirstLayout();
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByName(String str) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return null;
        }
        return lynxUIRenderer.findLynxUIByName(str);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByIdSelector(String str) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return null;
        }
        return lynxUIRenderer.findLynxUIByIdSelector(str);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public LynxBaseUI findLynxUIByIndex(int i) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return null;
        }
        return lynxUIRenderer.findLynxUIByIndex(i);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean onTouchEvent(MotionEvent motionEvent, UIGroup uIGroup) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return false;
        }
        return lynxUIRenderer.onTouchEvent(motionEvent, uIGroup);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean consumeSlideEvent(MotionEvent motionEvent) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return false;
        }
        return lynxUIRenderer.consumeSlideEvent(motionEvent);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean blockNativeEvent(MotionEvent motionEvent) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer == null) {
            return false;
        }
        return lynxUIRenderer.blockNativeEvent(motionEvent);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public ThreadStrategyForRendering getSupportedThreadStrategy(ThreadStrategyForRendering threadStrategyForRendering) {
        if (threadStrategyForRendering != ThreadStrategyForRendering.MULTI_THREADS && threadStrategyForRendering != ThreadStrategyForRendering.PART_ON_LAYOUT) {
            return threadStrategyForRendering;
        }
        LLog.e(TAG, "Clay don't support MULTI_THREADS and PART_ON_LAYOUT currently, change to ALL_ON_UI");
        return ThreadStrategyForRendering.ALL_ON_UI;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void performInnerMeasure(int i, int i2) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.performInnerMeasure(i, i2);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LynxUIRenderer lynxUIRenderer = this.mLynxUIRenderer;
        if (lynxUIRenderer != null) {
            lynxUIRenderer.onLayout(z, i, i2, i3, i4);
        }
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            return clayDelegate.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler, String str) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate == null) {
            return;
        }
        clayDelegate.takeScreenshot(screenshotBitmapHandler);
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public Bitmap getBitmapOfView() {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate == null) {
            return null;
        }
        return clayDelegate.getBitmapOfView();
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public int getNodeForLocation(float f, float f2, String str) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        if (clayDelegate != null) {
            return clayDelegate.getNodeForLocation((int) f, (int) f2);
        }
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ILynxUIRenderer
    public float[] getTransformValue(int i, float[] fArr) {
        ClayDelegate clayDelegate = this.mClayDelegate;
        return clayDelegate != null ? clayDelegate.getTransformValue(i, fArr) : new float[0];
    }

    public int getLowEndImageTextureCacheMaxLimit() {
        return this.mConfig.getLowEndImageTextureCacheMaxLimit();
    }

    public int getImageTextureCacheMaxLimit() {
        return this.mConfig.getImageTextureCacheMaxLimit();
    }

    public boolean enableTextureViewInRenderkitMode() {
        return this.mConfig.isEnableTextureViewWithRenderkitMode();
    }

    public boolean enableGLFunctorInRenderkitMode() {
        return this.mConfig.isEnableGLFunctorWithRenderkitMode();
    }

    public boolean enableDelegateInRenderkitMode() {
        return this.mConfig.isEnableDelegateWithRenderkitMode();
    }

    public boolean enableClayRecycleEngine() {
        return this.mConfig.isEnableClayRecycleEngine();
    }

    public boolean enableClayCompatMode() {
        return this.mConfig.isEnableClayCompatMode();
    }
}
