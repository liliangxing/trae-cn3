package bytedance.util;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import bytedance.core.FileManagerService;
import com.bytedance.ies.bullet.container.utils.BdMediaFileUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class DtfsUtils {
    public static boolean isAndroidJB2OrLater() {
        return true;
    }

    public static boolean isAndroidNOrLater() {
        return true;
    }

    public static Bundle createQueryBundle(String str, String[] strArr, int i, int i2) {
        return createQueryBundle(str, strArr, i, i2, null);
    }

    public static Bundle createQueryBundle(String str, String[] strArr, int i, int i2, String str2) {
        Bundle bundle = new Bundle();
        if (isAndroidQOrLater()) {
            bundle.putString("android:query-arg-sql-selection", str);
            bundle.putStringArray("android:query-arg-sql-selection-args", strArr);
            if (TextUtils.isEmpty(str2)) {
                bundle.putString("android:query-arg-sql-sort-order", "_id DESC");
            } else {
                bundle.putString("android:query-arg-sql-sort-order", str2);
            }
            if (isAndroidQOrLater() && i > 0) {
                bundle.putString(BdMediaFileUtils.QUERY_ARG_SQL_LIMIT, i + " offset " + i2);
            }
        }
        return bundle;
    }

    public static void uploadEvent(int i) {
        if (FileManagerService.getDefault().mBdFileEventCallBack != null) {
            FileManagerService.getDefault().mBdFileEventCallBack.uploadEvent(i);
        }
    }

    public static boolean isAndroidQOrLater() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isAndroidROrLater() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static void closeQuietly(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
        }
    }

    public static void closeQuietly(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused) {
        }
    }

    public static String removeDupSlash(String str) {
        int length = str.length();
        char[] charArray = str.toCharArray();
        int i = 0;
        char c = 0;
        int i2 = 0;
        while (i < length) {
            char c2 = charArray[i];
            if (c2 != '/' || c != '/') {
                charArray[i2] = c2;
                i2++;
            }
            i++;
            c = c2;
        }
        if (c == '/' && length > 1) {
            i2--;
        }
        return i2 != length ? new String(charArray, 0, i2) : str;
    }
}
