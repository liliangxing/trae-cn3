package com.lynx.tasm;

import com.lynx.react.bridge.JavaOnlyMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IListNodeInfoFetcher {
    JavaOnlyMap getPlatformInfo(int i);

    int obtainChild(int i, int i2, long j, boolean z);

    void obtainChildAsync(int i, int i2, long j);

    void recycleChild(int i, int i2);

    void recycleChildAsync(int i, int i2);

    void removeChild(int i, int i2);

    void renderChild(int i, int i2, long j);

    void scrollByListContainer(int i, float f, float f2, float f3, float f4);

    void scrollStopped(int i);

    void scrollToPosition(int i, int i2, float f, int i3, boolean z);

    void updateChild(int i, int i2, int i3, long j);
}
