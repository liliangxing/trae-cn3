package com.bytedance.webx.blankdetect.screenshot;

import android.view.View;

/* loaded from: classes6.dex */
public interface IScreenShot {
    void release(View view);

    ShotResult shot(View view);
}
