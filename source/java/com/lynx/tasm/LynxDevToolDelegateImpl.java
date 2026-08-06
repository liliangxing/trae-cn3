package com.lynx.tasm;

import android.graphics.Bitmap;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.devtoolwrapper.ScreenshotMode;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.ILynxUIRenderer;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxDevToolDelegateImpl implements IDevToolDelegate {
    private int mInstanceId;
    private WeakReference<LynxTemplateRender> mRender;

    public LynxDevToolDelegateImpl(LynxTemplateRender lynxTemplateRender) {
        LynxContext lynxContext;
        this.mRender = null;
        this.mInstanceId = -1;
        this.mRender = new WeakReference<>(lynxTemplateRender);
        if (lynxTemplateRender == null || (lynxContext = lynxTemplateRender.getLynxContext()) == null) {
            return;
        }
        this.mInstanceId = lynxContext.getInstanceId();
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public void onDispatchMessageEvent(final ReadableMap readableMap) {
        UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxDevToolDelegateImpl.1
            @Override // java.lang.Runnable
            public void run() {
                UIThreadUtils.runOnUiThreadImmediately(new Runnable() { // from class: com.lynx.tasm.LynxDevToolDelegateImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LynxTemplateRender lynxTemplateRender = (LynxTemplateRender) LynxDevToolDelegateImpl.this.mRender.get();
                        if (lynxTemplateRender == null) {
                            return;
                        }
                        lynxTemplateRender.dispatchMessageEvent(readableMap);
                    }
                });
            }
        });
    }

    private ILynxUIRenderer getLynxUIRenderer() {
        LynxTemplateRender lynxTemplateRender = this.mRender.get();
        if (lynxTemplateRender != null) {
            return lynxTemplateRender.lynxUIRenderer();
        }
        return null;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler, String str) {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.takeScreenshot(screenshotBitmapHandler, str);
        } else if (LynxEnv.inst().isLynxDebugEnabled()) {
            LynxEventReporter.onEvent("lynxsdk_screencast_takeScreenshot_failed", this.mInstanceId, new LynxEventReporter.PropsBuilder() { // from class: com.lynx.tasm.LynxDevToolDelegateImpl$$ExternalSyntheticLambda0
                public final Map build() {
                    return LynxDevToolDelegateImpl.lambda$takeScreenshot$0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$takeScreenshot$0() {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", "LynxDevToolDelegateImpl getLynxUIRenderer failed");
        return hashMap;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public void scrollIntoViewFromUI(int i) {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        if (lynxUIRenderer != null) {
            lynxUIRenderer.scrollIntoViewFromUI(i);
        }
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public String getActualScreenshotMode() {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        return lynxUIRenderer != null ? lynxUIRenderer.getActualScreenshotMode() : ScreenshotMode.SCREEN_SHOT_MODE_FULL_SCREEN;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public int getNodeForLocation(float f, float f2, String str) {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        if (lynxUIRenderer != null) {
            return lynxUIRenderer.getNodeForLocation(f, f2, str);
        }
        return 0;
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public float[] getTransformValue(int i, float[] fArr) {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        return lynxUIRenderer != null ? lynxUIRenderer.getTransformValue(i, fArr) : new float[0];
    }

    @Override // com.lynx.devtoolwrapper.IDevToolDelegate
    public Bitmap getBitmapOfView() {
        ILynxUIRenderer lynxUIRenderer = getLynxUIRenderer();
        if (lynxUIRenderer != null) {
            return lynxUIRenderer.getBitmapOfView();
        }
        return null;
    }
}
