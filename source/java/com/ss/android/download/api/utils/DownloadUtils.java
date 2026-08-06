package com.ss.android.download.api.utils;

/* loaded from: classes7.dex */
public class DownloadUtils {
    public static int translateStatusFromDownloadInfo(int i) {
        if (i == -3) {
            return 8;
        }
        if (i != -2) {
            return (i == 1 || i == 2 || i == 3 || i == 4 || i == 5) ? 2 : 16;
        }
        return 4;
    }
}
