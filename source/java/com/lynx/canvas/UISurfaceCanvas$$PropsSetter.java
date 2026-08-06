package com.lynx.canvas;

import com.lynx.tasm.DefaultLogicExecutor;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UISurfaceCanvas$$PropsSetter extends LynxUI$.PropsSetter {
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UISurfaceCanvas uISurfaceCanvas = (UISurfaceCanvas) lynxBaseUI;
        str.hashCode();
        if (str.equals(DefaultLogicExecutor.GLOBAL_EVENT_NAME)) {
            uISurfaceCanvas.setName(stylesDiffMap.getString(str));
        } else {
            super.setProperty(lynxBaseUI, str, stylesDiffMap);
        }
    }
}
