package com.lynx.tasm.behavior.p000ui;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IProcessViewInfoHook {
    void afterDispatchProcessViewInfo(ViewInfo viewInfo);

    void afterProcessChildViewInfo(ViewInfo viewInfo, View view, long j);

    void afterProcessViewInfo(ViewInfo viewInfo);

    void beforeDispatchProcessViewInfo(ViewInfo viewInfo);

    void beforeProcessChildViewInfo(ViewInfo viewInfo, View view, long j);

    void beforeProcessViewInfo(ViewInfo viewInfo);

    void dispatchProcessViewInfo();

    void processChildViewInfo(IProcessViewInfoHook iProcessViewInfoHook);

    void processLayoutChildren();

    void processMeasureChildren();

    void processViewInfo();
}
