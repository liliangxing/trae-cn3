package com.lynx.tasm.navigator;

import com.lynx.tasm.LynxView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface LynxHolder {
    void createLynxView(LynxRoute lynxRoute, LynxViewCreationListener lynxViewCreationListener);

    void dismissLynxView(LynxView lynxView);

    void quit();

    void showLynxView(LynxView lynxView, String str);
}
