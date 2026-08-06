package com.lynx.tasm.behavior.utils;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxUISetter<T extends LynxBaseUI> extends Settable {
    void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap);
}
