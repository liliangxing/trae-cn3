package com.bytedance.router.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.facebook.cache.disk.DefaultDiskStorage;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class ClassUtils {
    private static final String EXTRACTED_NAME_EXT = ".classes";
    private static final String EXTRACTED_SUFFIX = ".zip";
    private static final String KEY_DEX_NUMBER = "dex.number";
    private static final String PREFS_FILE = "multidex.version";
    private static final String SECONDARY_FOLDER_NAME = "code_cache" + File.separator + "secondary-dexes";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;

    private static SharedPreferences getMultiDexPreferences(Context context) {
        return context.getSharedPreferences(PREFS_FILE, 4);
    }

    public static List<String> getFileNameByPackageName(Context context, String str) throws PackageManager.NameNotFoundException, IOException {
        DexFile dexFile;
        ArrayList arrayList = new ArrayList();
        for (String str2 : getSourcePaths(context)) {
            if (str2.endsWith(EXTRACTED_SUFFIX)) {
                dexFile = DexFile.loadDex(str2, str2 + DefaultDiskStorage.FileType.TEMP, 0);
            } else {
                dexFile = new DexFile(str2);
            }
            Enumeration<String> entries = dexFile.entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (nextElement.contains(str)) {
                    arrayList.add(nextElement);
                }
            }
        }
        Log.d("galaxy", "Filter " + arrayList.size() + " classes by packageName <" + str + ">");
        return arrayList;
    }

    public static List<String> getSourcePaths(Context context) throws PackageManager.NameNotFoundException, IOException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        File file = new File(applicationInfo.sourceDir);
        ArrayList arrayList = new ArrayList();
        arrayList.add(applicationInfo.sourceDir);
        String str = file.getName() + EXTRACTED_NAME_EXT;
        if (!isVMMultidexCapable()) {
            int i = getMultiDexPreferences(context).getInt(KEY_DEX_NUMBER, 1);
            File file2 = new File(applicationInfo.dataDir, SECONDARY_FOLDER_NAME);
            for (int i2 = 2; i2 <= i; i2++) {
                File file3 = new File(file2, str + i2 + EXTRACTED_SUFFIX);
                if (file3.isFile()) {
                    arrayList.add(file3.getAbsolutePath());
                } else {
                    throw new IOException("Missing extracted secondary dex file '" + file3.getPath() + "'");
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004f, code lost:
    
        if (r2 < 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (java.lang.Integer.valueOf(java.lang.System.getProperty("ro.build.version.sdk")).intValue() >= 21) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isVMMultidexCapable() {
        boolean z = false;
        String str = null;
        if (!isYunOS()) {
            str = "'Android'";
            String property = System.getProperty("java.vm.version");
            if (property != null) {
                Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(property);
                if (matcher.matches()) {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt <= 2) {
                        if (parseInt == 2) {
                        }
                    }
                    z = true;
                }
            }
            Log.i("galaxy", "VM with name " + str + (!z ? " has multidex support" : " does not have multidex support"));
            return z;
        }
        str = "'YunOS'";
        Log.i("galaxy", "VM with name " + str + (!z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean isYunOS() {
        try {
            String property = System.getProperty("ro.yunos.version");
            String property2 = System.getProperty("java.vm.name");
            if (property2 == null || !property2.toLowerCase().contains("lemur")) {
                if (property == null) {
                    return false;
                }
                if (property.trim().length() <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
