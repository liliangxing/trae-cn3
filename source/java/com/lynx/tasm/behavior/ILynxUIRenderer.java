package com.lynx.tasm.behavior;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxGroup;
import com.lynx.tasm.NativeFacade;
import com.lynx.tasm.PageConfig;
import com.lynx.tasm.ThreadStrategyForRendering;
import com.lynx.tasm.base.LynxPageLoadListener;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.UIBody;
import com.lynx.tasm.behavior.p000ui.UIGroup;
import com.lynx.tasm.behavior.shadow.LayoutTick;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface ILynxUIRenderer {
    void attachBodyView(UIBody.UIBodyView uIBodyView, LynxContext lynxContext, Context context);

    void attachNativeFacade(NativeFacade nativeFacade);

    boolean blockNativeEvent(MotionEvent motionEvent);

    boolean consumeSlideEvent(MotionEvent motionEvent);

    boolean disableBindDrawChildHook();

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    void drawViewToBitmap(View view, Bitmap bitmap, Canvas canvas);

    boolean enableTimingCollector();

    LynxBaseUI findLynxUIByIdSelector(String str);

    LynxBaseUI findLynxUIByIndex(int i);

    LynxBaseUI findLynxUIByName(String str);

    String getActualScreenshotMode();

    Bitmap getBitmapOfView();

    UIGroup<UIBody.UIBodyView> getLynxRootUI();

    int getNodeForLocation(float f, float f2, String str);

    DisplayMetrics getScreenMetrics();

    ThreadStrategyForRendering getSupportedThreadStrategy(ThreadStrategyForRendering threadStrategyForRendering);

    float[] getTransformValue(int i, float[] fArr);

    long getUIDelegatePtr();

    boolean isAccessibilityDisabled();

    LynxUIOwner lynxUIOwner();

    boolean needHandleDispatchKeyEvent();

    void onAttach();

    void onCreateTemplateRenderer(LynxContext lynxContext, LynxPageLoadListener lynxPageLoadListener, ThreadStrategyForRendering threadStrategyForRendering, BehaviorRegistry behaviorRegistry, LayoutTick layoutTick);

    void onDestroy();

    void onDestroyTemplateRenderer();

    void onDetach();

    void onEnterBackground();

    void onEnterBackgroundInternal();

    void onEnterForeground();

    void onEnterForegroundInternal();

    void onInitBodyView(UIBody.UIBodyView uIBodyView, Context context, LynxGroup lynxGroup);

    void onInitLynxTemplateRender(LynxContext lynxContext, BehaviorRegistry behaviorRegistry, UIBody.UIBodyView uIBodyView, LynxBooleanOption lynxBooleanOption);

    void onLayout(boolean z, int i, int i2, int i3, int i4);

    void onPageConfigDecoded(PageConfig pageConfig);

    void onReloadAndInitAnyThreadPart();

    void onReloadAndInitUIThreadPart();

    boolean onTouchEvent(MotionEvent motionEvent, UIGroup uIGroup);

    void pauseRootLayoutAnimation();

    void performInnerMeasure(int i, int i2);

    void resumeRootLayoutAnimation();

    void scrollIntoViewFromUI(int i);

    void setContextFree(boolean z);

    void setFirstLayout();

    boolean shouldInvokeNativeViewMethod();

    void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler, String str);

    boolean useInvokeUIMethod();
}
