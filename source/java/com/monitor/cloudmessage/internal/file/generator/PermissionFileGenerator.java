package com.monitor.cloudmessage.internal.file.generator;

import android.content.Context;
import android.content.pm.PackageManager;
import com.monitor.cloudmessage.utils.FileUtils;
import com.monitor.cloudmessage.utils.PermissionUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class PermissionFileGenerator {
    private static String[] permissionList;

    public static Map<String, Boolean> checkAppPermissions(Context context) {
        HashMap hashMap = new HashMap();
        String[] strArr = permissionList;
        if (strArr != null) {
            for (String str : strArr) {
                hashMap.put(str, Boolean.valueOf(PermissionUtils.checkSelfPermission(context, str)));
            }
        }
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File writePermissionInfo(Context context) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            permissionList = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            String str = FileUtils.getCloudMsgDir(context).getAbsolutePath() + File.separator + "permissionInfo";
            String str2 = str + File.separator + "permission.txt";
            try {
                try {
                    File file = new File(str);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    fileWriter = new FileWriter(str + File.separator + "permission.txt");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter2 = str;
                }
            } catch (IOException e) {
                e = e;
                bufferedWriter = null;
                fileWriter = null;
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                bufferedWriter = new BufferedWriter(fileWriter);
                try {
                    for (Map.Entry<String, Boolean> entry : checkAppPermissions(context).entrySet()) {
                        bufferedWriter.write(String.format("permission: %s, result: %b\n", entry.getKey(), entry.getValue()));
                    }
                    try {
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return new File(str2);
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                bufferedWriter = null;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                        throw th;
                    }
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw th;
            }
        } catch (PackageManager.NameNotFoundException e7) {
            e7.printStackTrace();
            return null;
        }
    }
}
