package com.ss.bduploader;

/* loaded from: classes7.dex */
public interface BDVideoUploaderListener {
    public static final int EndTimeUploadStage1 = 1001;
    public static final int EndTimeUploadStage2 = 1002;
    public static final int EndTimeUploadStage3 = 1003;
    public static final int EndTimeUploadStage4 = 1004;
    public static final int EndTimeUploadStage5 = 1005;

    String getStringFromExtern(int i);

    void onLog(int i, int i2, String str);

    void onNotify(int i, long j, BDVideoInfo bDVideoInfo);

    void onUploadVideoStage(int i, long j);

    int videoUploadCheckNetState(int i, int i2);
}
