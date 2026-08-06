package com.facebook.imageutils;

import android.media.ExifInterface;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class DngExifUtil {
    public static final String TAG = "DngExifUtil";

    public static int getOrientation(InputStream inputStream) {
        return DngExifUtilAndroidN.getOrientation(inputStream);
    }

    /* loaded from: classes6.dex */
    private static class DngExifUtilAndroidN {
        private DngExifUtilAndroidN() {
        }

        static int getOrientation(InputStream inputStream) {
            try {
                return new ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            } catch (IOException e) {
                FLog.d(DngExifUtil.TAG, "Failed reading Dng Exif orientation -> ignoring", (Throwable) e);
                return 0;
            }
        }
    }
}
