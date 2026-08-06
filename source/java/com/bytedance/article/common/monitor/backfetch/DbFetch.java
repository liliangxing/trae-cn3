package com.bytedance.article.common.monitor.backfetch;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DbFetch {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    public static final String DB_FILE_BACK_TYPE = "db_file_back";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile;
    private static long lastFetchTime;
    private static String specificFileName;
    private static String uploadFileName;

    public static boolean checkSize(File file) {
        return !file.exists() || file.length() <= 52428800;
    }

    public static boolean generateErrorFile(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            new File(str, String.format("DbFileError: %s", str2)).createNewFile();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private static String generateUploadFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String versionName = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        return TextUtils.isEmpty(versionName) ? String.format("%s_db.zip", simpleDateFormat.format(new Date(System.currentTimeMillis()))) : String.format("%s_db_%s.zip", simpleDateFormat.format(new Date(System.currentTimeMillis())), versionName);
    }
}
