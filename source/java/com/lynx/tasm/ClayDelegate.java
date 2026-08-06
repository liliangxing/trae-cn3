package com.lynx.tasm;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import com.lynx.devtoolwrapper.ScreenshotBitmapHandler;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface ClayDelegate {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum RenderMode {
        SURFACE,
        TEXTURE,
        SYNC,
        DELEGATE
    }

    boolean dispatchKeyEvent(KeyEvent keyEvent);

    Bitmap getBitmapOfView();

    int getNodeForLocation(int i, int i2);

    RenderMode getRenderMode();

    float[] getTransformValue(int i, float[] fArr);

    long getUIDelegatePtr();

    void onCreateTemplateRenderer(LynxContext lynxContext);

    void onDestroy();

    void onEnterBackground();

    void onEnterForeground();

    void onPageConfigDecoded(PageConfig pageConfig);

    void reloadAndInit();

    void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler);
}
