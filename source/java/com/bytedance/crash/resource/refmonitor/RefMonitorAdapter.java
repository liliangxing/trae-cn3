package com.bytedance.crash.resource.refmonitor;

import com.bytedance.crash.Global;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RefMonitorAdapter extends ResourceMonitorAdapter {
    private static final String TAG = "RefMonitorAdapter: ";
    private static final int kGlobal = 2;
    private static final int kLocal = 1;
    private static final int kWeakGlobal = 3;
    private static RefMonitorAdapter mInstance;
    private RefMonitorConfig mConfig;

    public static RefMonitorAdapter get() {
        if (mInstance == null) {
            synchronized (RefMonitorAdapter.class) {
                if (mInstance == null) {
                    mInstance = new RefMonitorAdapter();
                }
            }
        }
        return mInstance;
    }

    public static void updateConfig(RefMonitorConfig refMonitorConfig) {
        RefMonitorAdapter refMonitorAdapter = get();
        refMonitorAdapter.mConfig = refMonitorConfig;
        refMonitorAdapter.startMonitor(refMonitorConfig);
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class RefMonitorUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        static final String SIGNAL_LINE_STR = "Signal 6(SIGABRT), Code -12(SI_REF_LEAK)\n";

        public RefMonitorUploader(AppMonitor appMonitor, File file) {
            super(appMonitor, file);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            String str;
            String str2;
            String str3;
            String str4 = SIGNAL_LINE_STR;
            File file2 = new File(file, "ref_table.txt");
            if (!file2.exists()) {
                return false;
            }
            try {
                if (FileUtils.readFileArray(file2.getAbsolutePath()) == null) {
                    NpthLog.m234i(RefMonitorAdapter.TAG, "refContent is null");
                    return false;
                }
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                String str5 = "";
                String str6 = null;
                char c = 0;
                boolean z = false;
                String str7 = "";
                String str8 = str7;
                String str9 = str8;
                String str10 = str9;
                String str11 = str10;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        BufferedReader bufferedReader2 = bufferedReader;
                        if (readLine == null) {
                            str = str4;
                            str2 = str10;
                            break;
                        }
                        if (str5.equals(readLine)) {
                            str3 = str5;
                        } else {
                            str3 = str5;
                            try {
                                char charAt = readLine.charAt(0);
                                String trim = readLine.trim();
                                if (trim.length() != 0) {
                                    str = str4;
                                    if (charAt < 'a' || charAt > 'z') {
                                        str2 = str10;
                                        if (c == 1) {
                                            if (charAt >= '0' && charAt <= '9') {
                                                String[] split = readLine.split("\\s+");
                                                if (split.length != 2) {
                                                    NpthLog.m227d("something is wrong with ref info title");
                                                    break;
                                                }
                                                str10 = split[0];
                                                str9 = split[1];
                                            } else {
                                                if (trim.startsWith("Summary")) {
                                                    str10 = str2;
                                                }
                                                str10 = str2;
                                            }
                                            c = 2;
                                        } else {
                                            if (c == 2) {
                                                if (trim.startsWith("#")) {
                                                    sb.append(readLine);
                                                    sb.append("\n");
                                                } else if (trim.startsWith("at")) {
                                                    sb2.append(readLine);
                                                    sb2.append("\n");
                                                    if (!z) {
                                                        str10 = str2;
                                                        z = true;
                                                    }
                                                } else {
                                                    if (z) {
                                                        break;
                                                    }
                                                    char charAt2 = trim.charAt(0);
                                                    if (charAt2 > '0' && charAt2 <= '9') {
                                                        String[] split2 = trim.split("\\s+");
                                                        if (split2.length >= 3) {
                                                            str8 = split2[0];
                                                            str7 = split2[2];
                                                        }
                                                        str10 = str2;
                                                        c = 0;
                                                    }
                                                }
                                            }
                                            str10 = str2;
                                        }
                                    } else {
                                        if (str6 == null) {
                                            try {
                                                str6 = readLine.split(" ")[0];
                                            } catch (Throwable unused) {
                                                return false;
                                            }
                                        } else {
                                            try {
                                                Matcher matcher = Pattern.compile("^.*:\\s+(\\S+),.*:\\s+(.*),.*:\\s+(\\S+).*$").matcher(readLine);
                                                if (matcher.find()) {
                                                    str11 = matcher.group(1);
                                                    uploaderData.mTid = Long.decode((String) Objects.requireNonNull(matcher.group(2))).longValue();
                                                    uploaderData.mThreadName = matcher.group(3);
                                                }
                                            } catch (Throwable unused2) {
                                            }
                                        }
                                        c = 1;
                                    }
                                    bufferedReader = bufferedReader2;
                                    str5 = str3;
                                    str4 = str;
                                }
                            } catch (Throwable unused3) {
                                return false;
                            }
                        }
                        bufferedReader = bufferedReader2;
                        str5 = str3;
                    } catch (Throwable unused4) {
                    }
                }
                String sb3 = sb.toString();
                uploaderData.mJavaStack = sb2.toString();
                String str12 = str;
                uploaderData.mNativeStack = str12 + sb3;
                createStackFile(file, "tombstone.txt", ("pid: 1234, tid: " + uploaderData.mTid + ", ThreadName: " + uploaderData.mThreadName + "  >>> " + Global.getContext().getPackageName() + " <<<\n") + str12 + ("abort message: " + str6 + " ref leak type: " + str7 + "(count: " + str8 + "), backtrace type: " + str9 + "(count: " + str2 + ")\n") + "backtrace: \n" + sb3);
                createStackFile(file, "javastack.txt", uploaderData.mJavaStack);
                uploaderData.filterData.put("has_ref_leak_log", "true");
                uploaderData.filterData.put("ref_leak_type", str6);
                try {
                    uploaderData.filterData.put(str6 + "_ref_range", getRefNumRange(str11));
                    uploaderData.filterData.put(str6 + "_ref_top_type", str7);
                    return true;
                } catch (Throwable unused5) {
                    return false;
                }
            } catch (Throwable unused6) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> map, ResourceMonitorAdapter.UploaderData uploaderData) {
            super.packFilterData(map, uploaderData);
            map.put("is_root", GeneralInfoManager.isRoot() ? "true" : "false");
        }

        private static String getCountRange(int i) {
            if (i <= 100) {
                return "[0, 100]";
            }
            if (i <= 200) {
                return "(100, 200]";
            }
            if (i <= 500) {
                return "(200, 500]";
            }
            if (i <= 1000) {
                return "(500, 1000]";
            }
            if (i <= 5000) {
                return "(1000, 5000]";
            }
            if (i <= 10000) {
                return "(5000, 10000]";
            }
            int i2 = i / 10000;
            return "(" + i2 + "0000, " + (i2 + 1) + "0000]";
        }

        String getRefNumRange(String str) {
            try {
                return getCountRange(Integer.parseInt(str));
            } catch (Throwable unused) {
                return "0";
            }
        }

        private static void createStackFile(File file, String str, String str2) {
            if (str2 == null || "".equals(str2)) {
                return;
            }
            File file2 = new File(file, str);
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                FileUtils.writeFile(file2, str2, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new RefMonitorUploader(appMonitor, LogPath.getRefMonitorPath()).uploadAll();
        } catch (Throwable th) {
            NpthLog.m229e(TAG, "upload exception:" + th);
        }
    }
}
