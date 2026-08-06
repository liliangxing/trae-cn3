package com.bytedance.crash.crash;

import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.dumper.InnerCrashBodyDumper;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.entity.CustomLong;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.monitor.AppMonitorConfigService;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.JSONUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NpthCheckUtils {
    private static final String HAS_FDS_FILE = "has_fds_file";
    private static final String HAS_HEAPTRACK_FILE = "has_heaptrack_file";
    private static final String HAS_KEYMAP_FILE = "has_pthread_key_map_file";
    private static final String HAS_LOGCAT_FILE = "has_logcat_file";
    private static final String HAS_MALLOC_INFO_FILE = "has_malloc_file";
    private static final String HAS_MAPS_FILE = "has_maps_file";
    private static final String HAS_MEMINFO_FILE = "has_meminfo_file";
    private static final String HAS_PRIO_FILE = "has_setpriority_file";
    private static final String HAS_PTHREADKEY_FILE = "has_pthread_key_file";
    private static final String HAS_PTHREADS_FILE = "has_pthreads_file";
    private static final String HAS_THREADS_FILE = "has_threads_file";
    private static final String HAS_VIEW_TREE = "has_view_tree";

    public static void checkUploadData(CrashType crashType, File file, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        JSONUtils.put(jSONObject3, Header.KEY_CRASH_TYPE, crashType.getName());
        checkFileExist(jSONObject3, file);
        checkBodyInherentCommon(jSONObject, jSONObject3);
        checkHeaderCommon(jSONObject2, jSONObject3);
        new NpthMonitor.Event("crash_data_check", jSONObject3).upload();
    }

    private static void checkEquals(Object obj, Object obj2, String str, JSONObject jSONObject) {
        if (obj != obj2) {
            if (obj != null) {
                if (obj.equals(obj2)) {
                    return;
                }
                doErr("err_" + str + "_not_" + obj, jSONObject);
                return;
            }
            doErr("err_" + str + "_not_" + obj, jSONObject);
        }
    }

    private static void checkHeaderCommon(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        checkNotEmpty(jSONObject.optString("sdk_version_name"), "sdk_version_name", jSONObject2);
        checkNotEmpty(jSONObject.optString("sdk_version"), "sdk_version", jSONObject2);
        checkEquals("Android", jSONObject.optString("os"), "os", jSONObject2);
        checkNotEmpty(jSONObject.optString("os_version"), "os_version", jSONObject2);
        checkNotEmpty(jSONObject.optString("os_api"), "os_api", jSONObject2);
        checkNotEmpty(jSONObject.optString("device_model"), "device_model", jSONObject2);
        checkNotEmpty(jSONObject.optString("device_brand"), "device_brand", jSONObject2);
        checkNotEmpty(jSONObject.optString("device_manufacturer"), "device_manufacturer", jSONObject2);
        checkNotEmpty(jSONObject.optString("cpu_abi"), "cpu_abi", jSONObject2);
        checkNotEmpty(jSONObject.optString(Header.KEY_UNIQUE_KEY), Header.KEY_UNIQUE_KEY, jSONObject2);
    }

    private static void checkFileExist(JSONObject jSONObject, File file) {
        if (file == null) {
            return;
        }
        if (!new File(file, "logcat.txt").exists()) {
            doErr("has_logcat_file_false", jSONObject);
        }
        if (!new File(file, "maps.txt").exists()) {
            doErr("has_maps_file_false", jSONObject);
        }
        if (!new File(file, "threads.txt").exists()) {
            doErr("has_threads_file_false", jSONObject);
        }
        if (!new File(file, "fds.txt").exists()) {
            doErr("has_fds_file_false", jSONObject);
        }
        if (!new File(file, "meminfo.txt").exists()) {
            doErr("has_meminfo_file_false", jSONObject);
        }
        if (!new File(file, ViewTree.FILE_NAME).exists()) {
            doErr("has_view_tree_false", jSONObject);
        }
        if (!new File(file, "pthread_key_info.txt").exists()) {
            doErr("has_pthread_key_file_false", jSONObject);
        }
        if (!new File(file, "pthread_key_map.txt").exists()) {
            doErr("has_pthread_key_map_file_false", jSONObject);
        }
        if (!new File(file, "malloc.txt").exists()) {
            doErr("has_malloc_file_false", jSONObject);
        }
        if (!new File(file, "pthreads.txt").exists()) {
            doErr("has_pthreads_file_false", jSONObject);
        }
        if (!new File(file, "setpriority.txt").exists()) {
            doErr("has_setpriority_file_false", jSONObject);
        }
        if (new File(file, "leak_heap.txt").exists()) {
            return;
        }
        doErr("has_heaptrack_file_false", jSONObject);
    }

    private static void checkBodyInherentCommon(JSONObject jSONObject, JSONObject jSONObject2) {
        checkNotNull(jSONObject.opt("miniapp_info"), "miniapp_info", jSONObject2);
        checkNotNull(jSONObject.opt("plugin_info"), "plugin_info", jSONObject2);
        checkNotNull(jSONObject.opt("process_name"), "process_name", jSONObject2);
        checkNotNull(jSONObject.opt("battery"), "battery", jSONObject2);
        checkNotNull(jSONObject.opt(Constants.LOGCAT), Constants.LOGCAT, jSONObject2);
        checkNotNull(jSONObject.opt("crash_time"), "crash_time", jSONObject2);
        checkNotNull(jSONObject.opt(Scraps.STORAGE), Scraps.STORAGE, jSONObject2);
        checkNotNull(jSONObject.opt("filters"), "filters", jSONObject2);
        checkNotNull(jSONObject.opt(InnerCrashBodyDumper.PATCH_INFO), InnerCrashBodyDumper.PATCH_INFO, jSONObject2);
        checkNotNull(jSONObject.opt("pid"), "pid", jSONObject2);
        checkNotNull(jSONObject.opt(Constants.IS_BACKGROUND), Constants.IS_BACKGROUND, jSONObject2);
        checkNotNull(jSONObject.opt(ActivityLifecycle.ACTIVITY_TRACE), ActivityLifecycle.ACTIVITY_TRACE, jSONObject2);
        checkNotNull(jSONObject.opt(CustomLong.TAG), CustomLong.TAG, jSONObject2);
        if (AppMonitorConfigService.enableUserCustomData()) {
            checkNotNull(jSONObject.opt("custom"), "custom", jSONObject2);
        }
        if (jSONObject.optJSONObject(CustomLong.TAG) != null) {
            checkNotNull(jSONObject.optJSONObject(CustomLong.TAG).opt(ActivityLifecycle.ACTIVITY_TRACK), ActivityLifecycle.ACTIVITY_TRACK, jSONObject2);
        }
        if (jSONObject.opt("filters") != null) {
            checkNotNull(jSONObject.optJSONObject("filters").opt("sdk_version"), "filters:sdk_version", jSONObject2);
            checkNotNull(jSONObject.optJSONObject("filters").opt("sdk_version_name"), "filters:sdk_version_name", jSONObject2);
            checkNotNull(jSONObject.optJSONObject("filters").opt("is_root"), "filters:is_root", jSONObject2);
            checkNotNull(jSONObject.optJSONObject("filters").opt("is_x86_devices"), "filters:is_x86_devices", jSONObject2);
            checkNotNull(jSONObject.optJSONObject("filters").opt("is_64_runtime"), "filters:is_64_runtime", jSONObject2);
            checkNotNull(jSONObject.optJSONObject("filters").opt("kernel_version"), "filters:kernel_version", jSONObject2);
        }
    }

    public static boolean checkFileContainsString(File file, String str) {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return false;
                }
            } while (!readLine.contains(str));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void doErr(String str, JSONObject jSONObject) {
        try {
            jSONObject.put(str, 1);
        } catch (JSONException unused) {
        }
    }

    private static void checkNotEmpty(String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            doErr("err_empty_" + str2, jSONObject);
        }
    }

    private static void checkNotNull(Object obj, String str, JSONObject jSONObject) {
        if (obj == null) {
            doErr("err_null_" + str, jSONObject);
        }
    }
}
