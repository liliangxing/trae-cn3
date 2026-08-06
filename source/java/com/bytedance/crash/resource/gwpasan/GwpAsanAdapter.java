package com.bytedance.crash.resource.gwpasan;

import android.os.Build;
import com.bytedance.crash.Global;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.resource.ResourceMonitorAdapter;
import com.bytedance.crash.resource.utils.LogPath;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.NpthLog;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class GwpAsanAdapter extends ResourceMonitorAdapter {
    private static final String GWP_ASAN_ALLOC_LIB = "gwp_asan_allocated_lib";
    private static final String GWP_ASAN_APP = "gwp_asan_app";
    private static final String GWP_ASAN_FATAL_LIB = "gwp_asan_fatal_lib";
    private static final String GWP_ASAN_FREE_LIB = "gwp_asan_deallocated_lib";
    private static final String GWP_ASAN_TYPE = "gwp_asan_type";
    private static final String HAS_GWP_ASAN = "has_gwp_asan";
    private static final String TAG = "NPTH_XASAN: ";
    private static GwpAsanAdapter mInstance = null;
    private static final String mLocalTestConfig = "1#1#40960#2000#0#all#all#0#";
    private GwpAsanConfig mConfig;

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected void executeMonitor() {
    }

    public static GwpAsanAdapter get() {
        if (mInstance == null) {
            synchronized (GwpAsanAdapter.class) {
                if (mInstance == null) {
                    mInstance = new GwpAsanAdapter();
                }
            }
        }
        return mInstance;
    }

    public static void GwpAsanInit() {
        try {
            if (!NativeBridge.is64BitRuntime()) {
                NpthLog.m227d("xasan 32bit app Not supported");
                return;
            }
            GwpAsanAdapter gwpAsanAdapter = get();
            if (gwpAsanAdapter.mHasInited) {
                NpthLog.m227d("xasan has init");
                return;
            }
            if (Build.VERSION.SDK_INT <= 34) {
                String str = LogPath.getGwpAsanLogPath().getAbsolutePath() + "/" + CrashManager.getProcessDirectoryName();
                if (!LogPath.getGwpAsanLogPath().exists()) {
                    LogPath.getGwpAsanLogPath().mkdirs();
                }
                String configDir = Global.getConfigDir();
                File file = new File(configDir, "xasan.config");
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileUtils.writeFile(file, new GwpAsanConfig(AppMonitorConfigService.getGwpAsanConfig()).toString(), false);
                NativeResourceMonitor.StartXasanInit(Build.VERSION.SDK_INT, str, configDir);
                gwpAsanAdapter.mHasInited = true;
            }
        } catch (IOException e) {
            NpthLog.m229e(TAG, "GwpAsanStart err:" + e);
        }
    }

    @Override // com.bytedance.crash.resource.ResourceMonitorAdapter
    protected boolean initBeforeSoLoad() {
        return NativeBridge.is64BitRuntime();
    }

    public static void updateConfig(GwpAsanConfig gwpAsanConfig) {
        GwpAsanAdapter gwpAsanAdapter = get();
        gwpAsanAdapter.mConfig = gwpAsanConfig;
        gwpAsanAdapter.startMonitor(gwpAsanConfig);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class GwpAsanUploader extends ResourceMonitorAdapter.ResourceMonitorUploader {
        protected GwpAsanUploader(AppMonitor appMonitor, File file) {
            super(appMonitor, file);
        }

        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        protected boolean parseReport(File file, ResourceMonitorAdapter.UploaderData uploaderData) {
            String str;
            String str2;
            String str3;
            String[] split;
            String str4;
            String[] split2;
            String str5;
            String[] split3;
            String[] split4;
            String str6 = "Invalid Free";
            String str7 = GwpAsanAdapter.TAG;
            File file2 = new File(file, "tombstone.txt");
            int i = 0;
            if (!file2.exists()) {
                return false;
            }
            try {
                JSONArray readFileArray = FileUtils.readFileArray(file2.getAbsolutePath());
                if (readFileArray == null) {
                    NpthLog.m229e(GwpAsanAdapter.TAG, "parseReport  native stack is null");
                    return false;
                }
                int lineIndex = getLineIndex(readFileArray, 0, "pid:");
                if (lineIndex < 0) {
                    NpthLog.m229e(GwpAsanAdapter.TAG, "parseReport  pid index err");
                    return false;
                }
                String[] split5 = readFileArray.optString(lineIndex, null).trim().split("\\s");
                int i2 = 0;
                while (i2 < split5.length) {
                    String str8 = split5[i2];
                    if ("pid:".equals(str8)) {
                        String str9 = split5[i2 + 1];
                        uploaderData.mPid = Long.decode(str9.substring(i, str9.length() - 1)).intValue();
                    } else if ("tid:".equals(str8)) {
                        String str10 = split5[i2 + 1];
                        uploaderData.mTid = Long.decode(str10.substring(0, str10.length() - 1)).intValue();
                    } else if ("name:".equals(str8)) {
                        String str11 = split5[i2 + 1];
                        uploaderData.mThreadName = str11.substring(0, str11.length() - 1);
                    }
                    i2++;
                    i = 0;
                }
                uploaderData.mProcessName = split5[split5.length - 2];
                StringBuilder sb = new StringBuilder();
                int lineIndex2 = getLineIndex(readFileArray, lineIndex + 1, "Signal ");
                if (lineIndex2 < 0) {
                    NpthLog.m229e(GwpAsanAdapter.TAG, "parseReport  signal index err");
                    return false;
                }
                sb.append(readFileArray.optString(lineIndex2, null)).append('\n');
                int lineIndex3 = getLineIndex(readFileArray, lineIndex2 + 1, "GWP-ASan message:");
                if (lineIndex3 < 0) {
                    NpthLog.m229e(GwpAsanAdapter.TAG, "parseReport abort msg index err");
                    return false;
                }
                String replace = readFileArray.optString(lineIndex3, null).replace("GWP-ASan message:", "abort message:");
                sb.append(replace).append('\n');
                if (replace.contains("Use After Free")) {
                    str6 = "Use After Free";
                } else if (replace.contains("Double Free")) {
                    str6 = "Double Free";
                } else if (replace.contains("Buffer Overflow")) {
                    str6 = "Buffer Overflow";
                } else if (replace.contains("Buffer Underflow")) {
                    str6 = "Buffer Underflow";
                } else if (!replace.contains("Invalid Free")) {
                    str6 = "Unknown";
                }
                int lineIndex4 = getLineIndex(readFileArray, lineIndex3 + 1, "backtrace:");
                if (lineIndex4 < 0) {
                    NpthLog.m229e(GwpAsanAdapter.TAG, "parseReport backtrace index err");
                    return false;
                }
                String str12 = "    #00";
                int i3 = lineIndex4 + 1;
                String str13 = "None";
                String str14 = "None";
                while (true) {
                    String str15 = str12;
                    str2 = "==/lib/";
                    str3 = str13;
                    if (i3 >= readFileArray.length()) {
                        break;
                    }
                    String optString = readFileArray.optString(i3, null);
                    if (!optString.startsWith("    #")) {
                        break;
                    }
                    str = str7;
                    try {
                        sb.append(optString.trim()).append('\n');
                        String str16 = "Double Free".equals(str6) ? "    #03" : str15;
                        if (!optString.endsWith("libc.so") && !optString.endsWith("libc++_shared.so")) {
                            if (optString.startsWith(str16) && (split4 = cutSubString(optString, "==/lib/", ".so").trim().split("/")) != null && split4.length > 1) {
                                String str17 = split4[1];
                                str14 = str17.substring(str17.lastIndexOf(47) + 1);
                            }
                        } else if (optString.startsWith("    #01") && (split3 = cutSubString(optString, "==/lib/", ".so").trim().split("/")) != null && split3.length > 1) {
                            String str18 = split3[1];
                            str14 = str18.substring(str18.lastIndexOf(47) + 1);
                        }
                        i3++;
                        str12 = str16;
                        str13 = str3;
                        str7 = str;
                    } catch (IOException e) {
                        e = e;
                        NpthLog.m229e(str, "parseReport :" + e);
                        return false;
                    } catch (JSONException e2) {
                        e = e2;
                        NpthLog.m229e(str, "parseReport :" + e);
                        return false;
                    }
                }
                str = str7;
                uploaderData.mNativeStack = sb.toString();
                int lineIndex5 = getLineIndex(readFileArray, i3, "deallocated by thread") + 1;
                String str19 = str3;
                while (true) {
                    if (lineIndex5 >= readFileArray.length()) {
                        break;
                    }
                    String optString2 = readFileArray.optString(lineIndex5, null);
                    if ((!optString2.startsWith("    #01") && !optString2.startsWith("    #02")) || optString2.endsWith("libnpth_xasan.so") || optString2.endsWith("libc++_shared.so") || (split2 = cutSubString(optString2, "==/lib/", ".so").trim().split("/")) == null) {
                        str5 = str19;
                    } else {
                        str5 = str19;
                        if (split2.length > 1) {
                            String str20 = split2[1];
                            String substring = str20.substring(str20.lastIndexOf(47) + 1);
                            if (substring.length() >= 1 && !substring.isEmpty()) {
                                str19 = substring;
                                break;
                            }
                            str19 = substring;
                            lineIndex5++;
                        }
                    }
                    str19 = str5;
                    lineIndex5++;
                }
                int lineIndex6 = getLineIndex(readFileArray, lineIndex5, "allocated by thread") + 1;
                while (lineIndex6 < readFileArray.length()) {
                    String optString3 = readFileArray.optString(lineIndex6, null);
                    if (!(optString3.startsWith("    #01") || optString3.startsWith("    #02")) || optString3.endsWith("libnpth_xasan.so") || optString3.endsWith("libc++_shared.so") || (split = cutSubString(optString3, str2, ".so").trim().split("/")) == null) {
                        str4 = str2;
                    } else {
                        str4 = str2;
                        if (split.length > 1) {
                            String str21 = split[1];
                            str3 = str21.substring(str21.lastIndexOf(47) + 1);
                            if (str3.length() >= 1 && !str3.isEmpty()) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                    lineIndex6++;
                    str2 = str4;
                }
                String str22 = str3;
                int lineIndex7 = getLineIndex(readFileArray, lineIndex6, "build id:");
                if (lineIndex7 > 0) {
                    for (int i4 = lineIndex7 + 1; i4 < readFileArray.length(); i4++) {
                        String optString4 = readFileArray.optString(i4, null);
                        if (optString4.startsWith("    /")) {
                            String[] split6 = optString4.trim().split("\\s");
                            if (split6.length >= 3) {
                                String str23 = split6[0];
                                uploaderData.mSoUUID.put(new JSONObject().put(CrashBody.LIB_NAME, str23.substring(str23.lastIndexOf(47) + 1)).put(CrashBody.LIB_UUID, buildIDToUUID(split6[split6.length - 1].substring(0, split6[split6.length - 1].length() - 1))));
                            }
                        }
                    }
                }
                uploaderData.filterData.put(GwpAsanAdapter.GWP_ASAN_TYPE, str6);
                uploaderData.filterData.put(GwpAsanAdapter.GWP_ASAN_FATAL_LIB, str14);
                uploaderData.filterData.put(GwpAsanAdapter.GWP_ASAN_FREE_LIB, str19);
                uploaderData.filterData.put(GwpAsanAdapter.GWP_ASAN_ALLOC_LIB, str22);
                return true;
            } catch (IOException | JSONException e3) {
                e = e3;
                str = GwpAsanAdapter.TAG;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.crash.resource.ResourceMonitorAdapter.ResourceMonitorUploader
        public void packFilterData(Map<String, String> map, ResourceMonitorAdapter.UploaderData uploaderData) {
            super.packFilterData(map, uploaderData);
            map.put(GwpAsanAdapter.HAS_GWP_ASAN, !uploaderData.mNativeStack.isEmpty() ? "true" : "false");
            map.put(GwpAsanAdapter.GWP_ASAN_APP, Global.getContext().getPackageName());
        }

        private static String cutSubString(String str, String str2, String str3) {
            int indexOf = str.indexOf(str2);
            int indexOf2 = str.indexOf(str3);
            return (indexOf >= 0 && indexOf2 >= 0) ? str.substring(indexOf, indexOf2).substring(str2.length()) : ArgusConstants.NULL_PLACE_HOLDER;
        }
    }

    public static void upload(AppMonitor appMonitor) {
        try {
            new GwpAsanUploader(appMonitor, LogPath.getGwpAsanLogPath()).uploadAll();
        } catch (Throwable th) {
            NpthLog.m229e(TAG, "upload exception:" + th);
        }
    }
}
