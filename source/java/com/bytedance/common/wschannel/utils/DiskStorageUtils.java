package com.bytedance.common.wschannel.utils;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.librarian.LibrarianImpl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;

/* loaded from: classes3.dex */
public class DiskStorageUtils {
    private static final String FILE_NAME_SUFFIX = "_frontier.bin";
    private static final String TAG = "DiskStorageUtils";
    private static final String WORKING_DIR_NAME = "wschannel";
    private static File sPersistentFile;
    private static File sWorkingDirectory;

    private static File getWorkingDirectory(Context context) {
        File file = sWorkingDirectory;
        if (file != null) {
            return file;
        }
        File file2 = new File(context.getFilesDir(), WORKING_DIR_NAME);
        sWorkingDirectory = file2;
        if (!file2.exists()) {
            sWorkingDirectory.mkdirs();
        }
        return sWorkingDirectory;
    }

    public static synchronized File getPersistentFile(Context context) {
        synchronized (DiskStorageUtils.class) {
            File file = sPersistentFile;
            if (file != null) {
                return file;
            }
            try {
                File file2 = new File(getWorkingDirectory(context), Utils.getCurProcessName(context).replace(LibrarianImpl.Constants.DOT, "_").replace(Constants.COLON_SEPARATOR, Constants.ACCEPT_TIME_SEPARATOR_SERVER) + FILE_NAME_SUFFIX);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                sPersistentFile = file2;
                if (Logger.debug()) {
                    Logger.d(TAG, "prepare PersistentFile success. fileName=" + sPersistentFile);
                }
            } catch (Exception e) {
                Logger.e(TAG, "prepare PersistentFile fail.", e);
            }
            return sPersistentFile;
        }
    }
}
