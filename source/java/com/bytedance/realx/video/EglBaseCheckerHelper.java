package com.bytedance.realx.video;

import com.bytedance.realx.video.EglBase;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class EglBaseCheckerHelper {
    protected static WeakReference<EglBase.EglContextChecker> eglContextChecker;

    public static void EglContextDestoryStart() {
        WeakReference<EglBase.EglContextChecker> weakReference = eglContextChecker;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        eglContextChecker.get().EglContextDestoryStart();
    }

    public static void EglContextDestoryEnd() {
        WeakReference<EglBase.EglContextChecker> weakReference = eglContextChecker;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        eglContextChecker.get().EglContextDestoryEnd();
    }

    public static void setEglContextChecker(EglBase.EglContextChecker contextChecker) {
        eglContextChecker = new WeakReference<>(contextChecker);
    }
}
