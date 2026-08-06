package com.lynx.tasm;

/* loaded from: classes6.dex */
public interface ILynxEngine {
    void destroy();

    void loadTemplate(LynxLoadMeta lynxLoadMeta);

    void updateMetaData(LynxUpdateMeta lynxUpdateMeta);

    void updateViewport(int i, int i2);
}
