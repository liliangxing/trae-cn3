package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import com.monitor.cloudmessage.utils.FileUtils;
import java.io.File;

/* loaded from: classes7.dex */
public class PrefFileGenerator {
    private static final String PREFS_SUFFIX = ".xml";

    public static File copySPFiles(Context context) {
        String str = context.getApplicationInfo().dataDir + "/shared_prefs";
        String str2 = context.getApplicationInfo().dataDir + "/spFiles";
        String str3 = str2 + File.separator + "/tmp";
        File file = new File(str);
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name.endsWith(PREFS_SUFFIX) && !FileUtils.copyFile(file2.getAbsolutePath(), str3, name)) {
                    return null;
                }
            }
        }
        try {
            FileUtils.zip(str3, str2 + File.separator + "sp.zip");
            FileUtils.removeDir(str3);
            return new File(str2 + File.separator + "sp.zip");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
