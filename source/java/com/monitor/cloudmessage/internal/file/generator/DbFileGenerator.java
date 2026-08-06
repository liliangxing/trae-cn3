package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.text.TextUtils;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;

/* loaded from: classes7.dex */
public class DbFileGenerator {
    private static final String DB_BACKUP_DIR_NAME = "dbFiles";
    private static final String DB_SOURCE_DIR_NAME = "databases";
    private static final String DB_SUFFIX = ".db";
    private static boolean fetchSpecificFile = false;
    private static String specificFileName = null;
    private static String uploadFileName = "db.zip";

    public static File copyDbFiles(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            fetchSpecificFile = true;
            specificFileName = str;
        }
        String str2 = context.getApplicationInfo().dataDir + File.separator + DB_SOURCE_DIR_NAME;
        String str3 = context.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME;
        String str4 = str3 + File.separator + "/tmp";
        File file = new File(str2);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name.endsWith(".db") && !fetchSpecificFile && !FileUtils.copyFile(file2.getAbsolutePath(), str4, name)) {
                    return null;
                }
                if (fetchSpecificFile && !TextUtils.isEmpty(specificFileName) && specificFileName.equals(name) && !FileUtils.copyFile(file2.getAbsolutePath(), str4, name)) {
                    return null;
                }
            }
        }
        try {
            FileUtils.zip(str4, str3 + File.separator + uploadFileName);
            FileUtils.removeDir(str4);
            return new File(str3 + File.separator + uploadFileName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkSize(File file) {
        return !file.exists() || file.length() <= 52428800;
    }

    public static void clearData(Context context) {
        FileUtils.removeDir(context.getApplicationInfo().dataDir + File.separator + DB_BACKUP_DIR_NAME);
    }
}
