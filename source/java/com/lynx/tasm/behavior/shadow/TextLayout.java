package com.lynx.tasm.behavior.shadow;

import com.lynx.react.bridge.mapbuffer.ReadableCompactArrayBuffer;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxUIOwner;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TextLayout {
    final LynxUIOwner mUIOwner;

    public TextLayout(LynxUIOwner lynxUIOwner) {
        this.mUIOwner = lynxUIOwner;
    }

    public float[] measureText(int i, float f, int i2, float f2, int i3, float[] fArr) {
        TraceEvent.beginSection("TextLayout.measureText");
        float[] measureText = this.mUIOwner.measureText(i, f, i2, f2, i3, fArr);
        TraceEvent.endSection("TextLayout.measureText");
        return measureText;
    }

    public void dispatchLayoutBefore(int i, ReadableCompactArrayBuffer readableCompactArrayBuffer) {
        TraceEvent.beginSection("TextLayout.dispatchLayoutBefore");
        this.mUIOwner.dispatchLayoutBefore(i, readableCompactArrayBuffer);
        TraceEvent.endSection("TextLayout.dispatchLayoutBefore");
    }

    public float[] align(int i) {
        TraceEvent.beginSection("TextLayout.align");
        float[] align = this.mUIOwner.align(i);
        TraceEvent.endSection("TextLayout.align");
        return align;
    }
}
