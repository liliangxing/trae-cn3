package com.ss.android.socialbase.downloader.exception;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Locale;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadOutOfSpaceException extends BaseException {
    private final long avaliableSpaceBytes;
    private final long requiredSpaceBytes;

    public DownloadOutOfSpaceException(long j, long j2) {
        super(1006, String.format(Locale.US, "space is not enough required space is : %d but available space is :%d", Long.valueOf(j2), Long.valueOf(DownloadUtils.getReportableSpaceMB(j) * 1048576)));
        this.avaliableSpaceBytes = j;
        this.requiredSpaceBytes = j2;
    }

    public long getAvaliableSpaceBytes() {
        return this.avaliableSpaceBytes;
    }

    public long getRequiredSpaceBytes() {
        return this.requiredSpaceBytes;
    }
}
