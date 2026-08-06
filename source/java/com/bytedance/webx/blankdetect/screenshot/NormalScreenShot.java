package com.bytedance.webx.blankdetect.screenshot;

import android.view.View;

/* loaded from: classes6.dex */
public class NormalScreenShot implements IScreenShot {
    @Override // com.bytedance.webx.blankdetect.screenshot.IScreenShot
    public ShotResult shot(View view) {
        ShotResult shotResult = new ShotResult();
        if (!view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        shotResult.bitmap = view.getDrawingCache();
        return shotResult;
    }

    @Override // com.bytedance.webx.blankdetect.screenshot.IScreenShot
    public void release(View view) {
        if (view.isDrawingCacheEnabled()) {
            return;
        }
        view.setDrawingCacheEnabled(false);
    }
}
