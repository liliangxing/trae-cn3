package com.bytedance.crash.protector;

import com.bytedance.crash.Global;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashProtector {
    private static final String CONFIG_FILE = "crash_protector.config";
    private static final String LOG_TAG = "NPTH_PROT";

    public static void addDefaultConfig() {
    }

    public static synchronized boolean addConfig(JSONObject jSONObject) {
        synchronized (CrashProtector.class) {
            CrashProtectorConfig crashProtectorConfig = new CrashProtectorConfig();
            if (!CrashProtectorConfig.addConfig(jSONObject)) {
                return false;
            }
            crashProtectorConfig.parse();
            if (!crashProtectorConfig.isConfigEnabled(jSONObject)) {
                return false;
            }
            return updateConfigFile(crashProtectorConfig.getConfigData(), crashProtectorConfig.getConfigSize());
        }
    }

    public static synchronized void updateConfig(JSONObject jSONObject) {
        synchronized (CrashProtector.class) {
            CrashProtectorConfig crashProtectorConfig = new CrashProtectorConfig();
            CrashProtectorConfig.updateConfig(jSONObject);
            crashProtectorConfig.parse();
            updateConfigFile(crashProtectorConfig.getConfigData(), crashProtectorConfig.getConfigSize());
        }
    }

    private static boolean updateConfigFile(byte[] bArr, int i) {
        File file;
        FileOutputStream fileOutputStream;
        try {
            file = new File(Global.getConfigDir(), CONFIG_FILE);
        } catch (Throwable unused) {
        }
        if (compareFileContent(file, bArr, i)) {
            NpthLog.m234i(LOG_TAG, "config not changed");
            return true;
        }
        if (file.exists()) {
            file.delete();
        }
        if (bArr != null && i > 0) {
            File file2 = new File(Global.getConfigDir(), "crash_protector.config.tmp");
            if (!file2.exists() && !file2.createNewFile()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(bArr, 0, i);
                fileOutputStream.flush();
                FileSystemUtils.close(fileOutputStream);
                if (file2.renameTo(file)) {
                    NpthLog.m234i(LOG_TAG, "update config file done");
                    return true;
                }
                NpthLog.m229e(LOG_TAG, "failed to update config file");
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                FileSystemUtils.close(fileOutputStream2);
                throw th;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x004c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean compareFileContent(File file, byte[] bArr, int i) {
        int i2;
        FileInputStream fileInputStream;
        int i3;
        int i4;
        if (bArr == null || i <= 0 || !file.exists() || file.length() != i) {
            return false;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr2 = new byte[4096];
                i3 = 0;
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr2);
                        if (read <= 0 || (i4 = i3 + read) > i) {
                            break;
                        }
                        for (int i5 = 0; i5 < read; i5++) {
                            if (bArr2[i5] != bArr[i3 + i5]) {
                                fileInputStream.close();
                                return false;
                            }
                        }
                        i3 = i4;
                    } catch (Exception unused) {
                        i2 = i3;
                        fileInputStream2 = fileInputStream;
                        fileInputStream = fileInputStream2;
                        i3 = i2;
                        FileSystemUtils.close(fileInputStream);
                        if (i3 != i) {
                        }
                    }
                }
            } catch (Exception unused2) {
                i2 = 0;
            }
        } catch (Exception unused3) {
            i2 = 0;
        }
        FileSystemUtils.close(fileInputStream);
        return i3 != i;
    }

    public static synchronized void updateConfigFromLocalFile(String str) {
        String str2;
        synchronized (CrashProtector.class) {
            if (str != null) {
                if (!str.isEmpty()) {
                    try {
                        str2 = readAllFromFile(new File(str));
                    } catch (Throwable unused) {
                        str2 = null;
                    }
                    if (str2 == null) {
                        return;
                    }
                    try {
                        JSONObject optJSONObject = new JSONObject(str2).optJSONObject("protector");
                        if (optJSONObject != null) {
                            CrashProtectorConfig crashProtectorConfig = new CrashProtectorConfig();
                            CrashProtectorConfig.updateConfig(optJSONObject);
                            crashProtectorConfig.parse();
                            updateConfigFile(crashProtectorConfig.getConfigData(), crashProtectorConfig.getConfigSize());
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    private static String readAllFromFile(File file) {
        if (file == null) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return byteArrayOutputStream.toString();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
