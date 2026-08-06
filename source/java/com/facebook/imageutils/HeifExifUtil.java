package com.facebook.imageutils;

import android.media.ExifInterface;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class HeifExifUtil {
    public static final String TAG = "HeifExifUtil";

    public static int getOrientation(InputStream inputStream) {
        return HeifExifUtilAndroidN.getOrientation(inputStream);
    }

    /* loaded from: classes6.dex */
    private static class HeifExifUtilAndroidN {
        private HeifExifUtilAndroidN() {
        }

        static int getOrientation(InputStream inputStream) {
            try {
                return new ExifInterface(inputStream).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            } catch (IOException e) {
                FLog.d(HeifExifUtil.TAG, "Failed reading Heif Exif orientation -> ignoring", (Throwable) e);
                return 0;
            } catch (Throwable th) {
                FLog.d(HeifExifUtil.TAG, "System api err, Failed reading Heif Exif orientation -> ignoring", th);
                return 0;
            }
        }
    }
}
