package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDObjectUploaderListener {
    int objectUploadCheckNetState(int i, int i2);

    void onLog(int i, int i2, String str);

    void onNotify(int i, long j, BDObjectInfo bDObjectInfo);
}
