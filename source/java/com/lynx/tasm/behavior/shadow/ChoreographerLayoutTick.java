package com.lynx.tasm.behavior.shadow;

import android.view.Choreographer;
import com.lynx.tasm.behavior.LynxContext;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ChoreographerLayoutTick implements LayoutTick {
    private final LynxContext mLynxContext;

    public ChoreographerLayoutTick(LynxContext lynxContext) {
        this.mLynxContext = lynxContext;
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutTick
    public void request(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.lynx.tasm.behavior.shadow.ChoreographerLayoutTick.1
            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                if (ChoreographerLayoutTick.this.mLynxContext.hasLayoutThreadChanged()) {
                    ChoreographerLayoutTick.this.mLynxContext.runOnLayoutThread(runnable);
                } else {
                    runnable.run();
                }
            }
        });
    }
}
