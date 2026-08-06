package com.lynx.devtoolwrapper;

import android.graphics.Bitmap;
import com.lynx.react.bridge.ReadableMap;

/* loaded from: classes6.dex */
public interface IDevToolDelegate {
    String getActualScreenshotMode();

    Bitmap getBitmapOfView();

    int getNodeForLocation(float f, float f2, String str);

    float[] getTransformValue(int i, float[] fArr);

    void onDispatchMessageEvent(ReadableMap readableMap);

    void scrollIntoViewFromUI(int i);

    void takeScreenshot(ScreenshotBitmapHandler screenshotBitmapHandler, String str);
}
