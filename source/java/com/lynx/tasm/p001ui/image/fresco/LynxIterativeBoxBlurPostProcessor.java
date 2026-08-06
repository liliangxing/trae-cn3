package com.lynx.tasm.p001ui.image.fresco;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxIterativeBoxBlurPostProcessor extends IterativeBoxBlurPostProcessor {
    private WeakReference<LynxContext> mLynxContextRef;

    public LynxIterativeBoxBlurPostProcessor(int i, LynxContext lynxContext) {
        super(i);
        this.mLynxContextRef = new WeakReference<>(lynxContext);
    }

    public void process(Bitmap bitmap) {
        try {
            super.process(bitmap);
        } catch (UnsatisfiedLinkError unused) {
            UIThreadUtils.runOnUiThread(new Runnable() { // from class: com.lynx.tasm.ui.image.fresco.LynxIterativeBoxBlurPostProcessor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (LynxIterativeBoxBlurPostProcessor.this.mLynxContextRef == null || LynxIterativeBoxBlurPostProcessor.this.mLynxContextRef.get() == null) {
                        return;
                    }
                    ((LynxContext) LynxIterativeBoxBlurPostProcessor.this.mLynxContextRef.get()).handleLynxError(new LynxError(220301, "blur-radius/drop-shadow is not supported in this app and it will crash in lower versions", "Please remove blur-radius/drop-shadow props in image/filter-image.", "error", -3));
                }
            });
        }
    }
}
