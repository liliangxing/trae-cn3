package com.bytedance.crash.entity;

import android.text.TextUtils;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.apm.entity.UploadInfo;
import com.bytedance.crash.TagService;
import com.bytedance.crash.alog.AlogManager;
import com.bytedance.crash.config.NpthBuildConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.dumper.CustomFilter;
import com.bytedance.crash.dumper.ProcInfo;
import com.bytedance.crash.dumper.ProtectorInfo;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.crash.dumper.ViewTree;
import com.bytedance.crash.general.GeneralInfoManager;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.crash.util.AppInfoUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NumRanges;
import io.reactivex.annotations.SchedulerSupport;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashFilter {
    public static final String FILTERS = "filters";
    public static final String IS_64_RUNTIME = "is_64_runtime";
    public static final String IS_ROOT = "is_root";
    public static final String IS_X86_DEVICES = "is_x86_devices";

    private static String getHeapUsage(long j, long j2) {
        float f = (float) j2;
        float f2 = (float) j;
        return f > 0.95f * f2 ? "(95% - 100%]" : f > 0.9f * f2 ? "(90% - 95%]" : f > 0.8f * f2 ? "(80% - 90%]" : f > 0.7f * f2 ? "(70% - 80%]" : f > 0.6f * f2 ? "(60% - 70%]" : f > f2 * 0.5f ? "(50% - 60%]" : "(0% - 50%]";
    }

    private static String millisToReadable(long j) {
        return j < 0 ? "( - 0s)" : j < 60000 ? "(0s - 1m)" : j < UploadInfo.DEFAULT_SEND_DURATION ? "[1m - 10m)" : j < 3600000 ? "[10m - 1h)" : j < 10800000 ? "[1h - 3h)" : j < 43200000 ? "[3h - 12h)" : j < 86400000 ? "[12h - 1d)" : j < 259200000 ? "[1d - 3d)" : j < 604800000 ? "[3d - 7d)" : j < 1209600000 ? "[7d - 14d)" : j < 2592000000L ? "[14d - 30d)" : "[30d - )";
    }

    private static boolean validFile(File file, String str, int i) {
        File file2 = new File(file, str);
        return file2.exists() && file2.length() > ((long) i);
    }

    public static void appendCommonFilter(JSONObject jSONObject, JSONObject jSONObject2, File file) {
        JSONObject jSONObject3 = JSONUtils.get(jSONObject2, "filters");
        CustomFilter.pushTo(jSONObject2, file);
        CustomFilter.pushCustomReasonTo(jSONObject2, file);
        JSONUtils.append(jSONObject3, Constants.HAS_DUMP, (Object) true);
        JSONUtils.append(jSONObject3, "is_root", Boolean.valueOf(GeneralInfoManager.isRoot()));
        JSONUtils.append(jSONObject3, "alog_inited", Boolean.valueOf(AlogManager.isInit()));
        JSONUtils.append(jSONObject3, "sdk_version", NpthBuildConfig.VERSION_NAME);
        JSONUtils.append(jSONObject3, CrashBody.CRASH_THREAD_NAME, jSONObject2.optString(CrashBody.CRASH_THREAD_NAME, "unknown"));
        JSONUtils.append(jSONObject3, "is_64_runtime", Boolean.valueOf(NativeBridge.is64BitRuntime()));
        JSONUtils.append(jSONObject3, Constants.IS_HM_OS, jSONObject.optString(Constants.IS_HM_OS));
        JSONUtils.append(jSONObject3, "version_type", jSONObject.optString("version_type"));
        JSONUtils.append(jSONObject3, "kernel_version", jSONObject.optString("kernel_version"));
        JSONUtils.append(jSONObject3, "app_version_exact", jSONObject.optString("app_version_exact"));
        JSONUtils.append(jSONObject3, "crash_md5", jSONObject2.optString("crash_md5"));
        JSONUtils.append(jSONObject3, HardwareInfo.KEY_HW_CPU_MODEL, jSONObject.optString(HardwareInfo.KEY_HW_CPU_MODEL));
        JSONUtils.append(jSONObject3, HardwareInfo.KEY_HW_CPU_HARDWARE, jSONObject.optString(HardwareInfo.KEY_HW_CPU_HARDWARE));
        JSONUtils.append(jSONObject3, HardwareInfo.KEY_HW_RAM_SIZE, jSONObject.optString(HardwareInfo.KEY_HW_RAM_SIZE));
        JSONUtils.append(jSONObject3, ActivityLifecycle.LAST_RESUME_ACTIVITY, ActivityLifecycle.getLastResumedActivityFromBody(jSONObject2));
        String loadNativeCrashAbortReason = NativeBridge.loadNativeCrashAbortReason(file.getAbsolutePath());
        if (loadNativeCrashAbortReason != null) {
            JSONUtils.append(jSONObject3, CrashBody.ABORT_REASON, loadNativeCrashAbortReason);
        }
        JSONObject optJSONObject = jSONObject2.optJSONObject(Scraps.STORAGE);
        if (optJSONObject != null) {
            JSONUtils.append(jSONObject3, Scraps.INNER_TOTAL, optJSONObject.optString(Scraps.INNER_TOTAL));
            JSONUtils.append(jSONObject3, Scraps.INNER_FREE, optJSONObject.optString(Scraps.INNER_FREE));
        }
        String optString = jSONObject.optString("cpu_abi");
        if (!TextUtils.isEmpty(optString)) {
            boolean contains = optString.contains("64");
            JSONUtils.append(jSONObject3, "is_x86_devices", Boolean.valueOf(optString.contains("86")));
            JSONUtils.append(jSONObject3, Constants.IS_64_DEVICES, Boolean.valueOf(contains));
            appendVmFilter(jSONObject3, jSONObject2, file, contains);
        }
        appendTimeRelated(jSONObject3, jSONObject, jSONObject2);
        AppInfoUtils.expandFilters(jSONObject3);
        appendThread(jSONObject3, file);
        appendFd(jSONObject3, file);
        appendPthreadKey(jSONObject3, file);
        appendDumpFiles(jSONObject3, file);
        appendNpthDumperStatus(jSONObject3, file);
        appendProtectorInfo(jSONObject3, file);
        appendLogcatFilter(jSONObject3, jSONObject2);
        appendMemoryInfo(jSONObject3, jSONObject2);
        ResourceMonitor.appendResourceMonitorTags(jSONObject3, file);
        appendCombineSinceCrashed(jSONObject3, jSONObject2);
        appendCrashSinceUpdated(jSONObject3, jSONObject, jSONObject2);
        appendImportTags(jSONObject3, jSONObject2);
    }

    private static void appendTimeRelated(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        long optLong = jSONObject3.optLong("crash_time");
        long optLong2 = jSONObject3.optLong("app_start_time");
        if (optLong != 0 && optLong2 != 0) {
            JSONUtils.append(jSONObject, "use_time", Long.valueOf((optLong - optLong2) / 1000));
        }
        long optLong3 = jSONObject2.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        if (optLong3 == 0) {
            return;
        }
        if (optLong2 != 0) {
            JSONUtils.append(jSONObject, "valid_app_info", optLong2 > optLong3 ? "true" : "false");
        }
        long lastUpdateTime = GeneralInfoManager.getLastUpdateTime(0L);
        if (lastUpdateTime == 0) {
            return;
        }
        JSONUtils.append(jSONObject, "crash_same_upload", optLong3 == lastUpdateTime ? "true" : "false");
        if (optLong3 == lastUpdateTime || optLong == 0) {
            return;
        }
        long lastUpdateTime2 = GeneralInfoManager.getLastUpdateTime(optLong);
        if (lastUpdateTime2 != 0) {
            JSONUtils.append(jSONObject, "crash_when_update", optLong3 == lastUpdateTime2 ? "false" : "true");
        }
    }

    private static void appendImportTags(JSONObject jSONObject, JSONObject jSONObject2) {
        String optString = jSONObject2.optString("process_name");
        long optLong = jSONObject2.optLong("app_start_time");
        if (TextUtils.isEmpty(optString) || optLong == 0) {
            return;
        }
        TagService.dumpImportTags(jSONObject, optLong, optString);
    }

    private static void appendCrashSinceUpdated(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        long optLong = jSONObject2.optLong(Header.KEY_APP_LAST_UPDATE_TIME);
        long optLong2 = jSONObject3.optLong("crash_time");
        if (optLong > 0) {
            JSONUtils.append(jSONObject, "crash_since_updated", millisToReadable(optLong2 - optLong));
        }
    }

    private static void appendCombineSinceCrashed(JSONObject jSONObject, JSONObject jSONObject2) {
        long optLong = jSONObject2.optLong("crash_time");
        long currentTimeMillis = System.currentTimeMillis();
        if (optLong <= 0 || currentTimeMillis <= optLong) {
            return;
        }
        JSONUtils.append(jSONObject, "crash_length", millisToReadable(currentTimeMillis - optLong));
    }

    private static void appendLogcatFilter(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONUtils.append(jSONObject, "has_logcat", Boolean.valueOf(!JSONUtils.isEmpty(jSONObject2.optJSONArray(Constants.LOGCAT))));
    }

    private static void appendDumpFiles(JSONObject jSONObject, File file) {
        JSONUtils.append(jSONObject, "has_tombstone_file", Boolean.valueOf(validFile(file, "tombstone.txt", 10)));
        JSONUtils.append(jSONObject, "has_dlog_file", Boolean.valueOf(validFile(file, "dlog.txt", 10)));
        JSONUtils.append(jSONObject, "has_logcat_file", Boolean.valueOf(validFile(file, "logcat.txt", 512)));
        JSONUtils.append(jSONObject, "has_logcat_file_os", Boolean.valueOf(validFile(file, "logcat_os.txt", 512)));
        JSONUtils.append(jSONObject, "has_malloc_file", Boolean.valueOf(validFile(file, "malloc.txt", 64)));
        JSONUtils.append(jSONObject, "has_meminfo_file", Boolean.valueOf(validFile(file, "meminfo.txt", 64)));
        JSONUtils.append(jSONObject, "has_maps_file", Boolean.valueOf(validFile(file, "maps.txt", 1024)));
        JSONUtils.append(jSONObject, "has_smaps_file", Boolean.valueOf(validFile(file, "smaps.txt", 1024)));
        JSONUtils.append(jSONObject, "has_pthreads_file", Boolean.valueOf(validFile(file, "pthreads.txt", 64)));
        JSONUtils.append(jSONObject, "has_threads_file", Boolean.valueOf(validFile(file, "threads.txt", 64)));
        JSONUtils.append(jSONObject, "has_fds_file", Boolean.valueOf(validFile(file, "fds.txt", 64)));
        JSONUtils.append(jSONObject, "has_view_tree", Boolean.valueOf(validFile(file, ViewTree.FILE_NAME, 64)));
        JSONUtils.append(jSONObject, "has_pthread_key_map_file", Boolean.valueOf(validFile(file, "pthread_key_map.txt", 10)));
        JSONUtils.append(jSONObject, "has_pthread_key_file", Boolean.valueOf(validFile(file, "pthread_key_info.txt", 10)));
        JSONUtils.append(jSONObject, "has_routine_file", Boolean.valueOf(validFile(file, "rountines.txt", 64)));
        JSONUtils.append(jSONObject, "has_gfx_file", Boolean.valueOf(validFile(file, "gfxinfo.txt", 64)));
        JSONUtils.append(jSONObject, "has_os_memory", Boolean.valueOf(validFile(file, "os_memory.txt", 64)));
        JSONUtils.append(jSONObject, "has_environ", Boolean.valueOf(validFile(file, "environ.txt", 64)));
        JSONUtils.append(jSONObject, "has_signal_monitor_file", Boolean.valueOf(validFile(file, "signal_monitor.txt", 64)));
        JSONUtils.append(jSONObject, "has_heaptrack_file", Boolean.valueOf(validFile(file, "leak_heap.txt", 64)));
        JSONUtils.append(jSONObject, "has_setpriority_file", Boolean.valueOf(validFile(file, "priority_stack.txt", 64)));
        JSONUtils.append(jSONObject, "has_setpriority_file", Boolean.valueOf(validFile(file, "priority_jstack.txt", 64)));
        JSONUtils.append(jSONObject, "has_memtrack_dump", Boolean.valueOf(validFile(file, "sys_memtrack.txt", 16)));
    }

    private static void appendMemoryReasonFilter(JSONObject jSONObject, File file) {
        String[] oOMReason = NativeBridge.getOOMReason(file.getAbsolutePath());
        if (oOMReason == null || oOMReason.length != 5) {
            return;
        }
        JSONUtils.append(jSONObject, "native_oom_reason", oOMReason[0]);
        JSONUtils.append(jSONObject, "vma_leak_reason", oOMReason[1]);
        JSONUtils.append(jSONObject, "mem_rss_reason", oOMReason[2]);
        JSONUtils.append(jSONObject, "mem_pss_reason", oOMReason[3]);
        JSONUtils.append(jSONObject, "mem_ref_reason", oOMReason[4]);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void appendVmFilter(JSONObject jSONObject, JSONObject jSONObject2, File file, boolean z) {
        boolean z2;
        long vmSizeKb;
        long vmRssKb;
        boolean is64BitRuntime = NativeBridge.is64BitRuntime();
        long vmPeakKb = ProcInfo.getVmPeakKb(file);
        boolean isVmaCountLeak = ProcInfo.isVmaCountLeak(ProcInfo.getVmaCount(file));
        JSONUtils.append(jSONObject, "vma_leak", Boolean.valueOf(isVmaCountLeak));
        if (vmPeakKb > 0) {
            if (is64BitRuntime) {
                JSONUtils.append(jSONObject, "vm_peak_range", ProcInfo.getVmRange64(vmPeakKb));
            } else {
                JSONUtils.append(jSONObject, "vm_peak_usage", ProcInfo.getVmUsage32(vmPeakKb, z));
                z2 = ProcInfo.isMemoryLeak32(vmPeakKb, z);
                JSONUtils.append(jSONObject, "memory_leak", Boolean.valueOf(z2));
                vmSizeKb = ProcInfo.getVmSizeKb(file);
                if (vmSizeKb > 0) {
                    JSONUtils.append(jSONObject, "vmsize_range", "(0 - 0)");
                } else if (is64BitRuntime) {
                    JSONUtils.append(jSONObject, "vmsize_range", ProcInfo.getVmRange64(vmSizeKb));
                } else {
                    JSONUtils.append(jSONObject, "vmsize_range", ProcInfo.getVmUsage32(vmSizeKb, z));
                }
                JSONUtils.appendLong(jSONObject2, "memory_size", vmSizeKb);
                vmRssKb = ProcInfo.getVmRssKb(file);
                JSONUtils.appendLong(jSONObject2, "rss", vmRssKb);
                boolean isRssExcess = ProcInfo.isRssExcess(1024 * vmRssKb);
                if (vmRssKb > 0) {
                    JSONUtils.append(jSONObject, "rss_size_range", ProcInfo.getVmRssRange(vmRssKb));
                }
                if (!z2 || isVmaCountLeak || isRssExcess) {
                    appendMemoryReasonFilter(jSONObject, file);
                }
                return;
            }
        }
        z2 = false;
        vmSizeKb = ProcInfo.getVmSizeKb(file);
        if (vmSizeKb > 0) {
        }
        JSONUtils.appendLong(jSONObject2, "memory_size", vmSizeKb);
        vmRssKb = ProcInfo.getVmRssKb(file);
        JSONUtils.appendLong(jSONObject2, "rss", vmRssKb);
        boolean isRssExcess2 = ProcInfo.isRssExcess(1024 * vmRssKb);
        if (vmRssKb > 0) {
        }
        if (z2) {
        }
        appendMemoryReasonFilter(jSONObject, file);
    }

    private static void appendThread(JSONObject jSONObject, File file) {
        int threadCount = ProcInfo.getThreadCount(file);
        if (threadCount != 0) {
            JSONUtils.append(jSONObject, "thread_count_range", ProcInfo.getThreadCountRange(threadCount));
            boolean isThreadLeak = ProcInfo.isThreadLeak(threadCount);
            JSONUtils.append(jSONObject, "threads_leak", Boolean.valueOf(isThreadLeak));
            if (isThreadLeak) {
                JSONUtils.append(jSONObject, "threads_leak_name", NativeBridge.getThreadLeakName(file));
                JSONUtils.append(jSONObject, "threads_leak_library", NativeBridge.getThreadLeakLibrary(file));
            }
        }
    }

    private static void appendFd(JSONObject jSONObject, File file) {
        int fdCount = ProcInfo.getFdCount(file);
        if (fdCount != 0) {
            JSONUtils.append(jSONObject, "fd_count_range", ProcInfo.getFdCountRange(fdCount));
            boolean isFdLeak = ProcInfo.isFdLeak(fdCount);
            JSONUtils.append(jSONObject, "fd_leak", Boolean.valueOf(isFdLeak));
            if (isFdLeak) {
                JSONUtils.append(jSONObject, "fd_leak_reason", NativeBridge.getFdLeakReason(file));
            }
        }
    }

    private static void appendPthreadKey(JSONObject jSONObject, File file) {
        int pthreadKeyCount = ProcInfo.getPthreadKeyCount(file);
        if (pthreadKeyCount != 0) {
            JSONUtils.append(jSONObject, "pthread_key_range", ProcInfo.getPthreadKeyCountRange(pthreadKeyCount));
            JSONUtils.append(jSONObject, "has_pthread_key_leak", Boolean.valueOf(ProcInfo.isPthreadKeyLeak(pthreadKeyCount)));
            if (ProcInfo.isPthreadKeyLeak(pthreadKeyCount)) {
                JSONUtils.append(jSONObject, "pthread_key_leak_lib", NativeBridge.getPthreadKeyLeakLibrary(file));
            }
        }
    }

    private static void appendNpthDumperStatus(JSONObject jSONObject, File file) {
        boolean z;
        int lastIndexOf;
        File file2 = new File(file, "dlog.txt");
        boolean exists = file2.exists();
        boolean z2 = false;
        String str = SchedulerSupport.NONE;
        if (exists && file2.length() > 0) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
                z = false;
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.contains("[dumper] onload")) {
                            z2 = true;
                        } else if (readLine.contains("[dumper] exit status:") && (lastIndexOf = readLine.lastIndexOf(58)) != -1) {
                            str = readLine.substring(lastIndexOf + 1).trim();
                            z = str.equals("0");
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
            JSONUtils.append(jSONObject, "dumper_loaded", Boolean.valueOf(z2));
            JSONUtils.append(jSONObject, "dumper_exit_code", str);
            JSONUtils.append(jSONObject, "npth_dumper_success", Boolean.valueOf(z));
        }
        z = false;
        JSONUtils.append(jSONObject, "dumper_loaded", Boolean.valueOf(z2));
        JSONUtils.append(jSONObject, "dumper_exit_code", str);
        JSONUtils.append(jSONObject, "npth_dumper_success", Boolean.valueOf(z));
    }

    private static void appendProtectorInfo(JSONObject jSONObject, File file) {
        ProtectorInfo protectorInfo = new ProtectorInfo(file);
        if (protectorInfo.init()) {
            JSONUtils.append(jSONObject, "has_protector_history", Boolean.valueOf(protectorInfo.hasHistory()));
            if (protectorInfo.hasHistory()) {
                JSONUtils.append(jSONObject, "protector_sid", protectorInfo.getSid());
                JSONUtils.append(jSONObject, "protector_performed_count", Integer.valueOf(protectorInfo.getPerformedCount()));
                JSONUtils.append(jSONObject, "protector_total_performed_count", Integer.valueOf(protectorInfo.getTotalPerformedCount()));
                JSONUtils.append(jSONObject, "protector_performed", Boolean.valueOf(protectorInfo.isPerformed()));
                JSONUtils.append(jSONObject, "protector_final_performed", Boolean.valueOf(protectorInfo.isFinalPerformed()));
                JSONUtils.append(jSONObject, "protector_origin_scope", protectorInfo.getOriginScope());
                JSONUtils.append(jSONObject, "protector_previous_scope", protectorInfo.getPreviousScope());
                if (protectorInfo.isPerformed()) {
                    JSONUtils.append(jSONObject, "protector_scope", protectorInfo.getScope());
                }
                protectorInfo.dump();
            }
        }
    }

    private static void appendMemoryInfo(JSONObject jSONObject, JSONObject jSONObject2) {
        appendJavaHeapFilters(jSONObject, jSONObject2);
        JSONObject optJSONObject = jSONObject2.optJSONObject("app_memory_info");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("native_heap_size");
            JSONUtils.append(jSONObject, "native_heap_range", getNativeHeapRange(optLong));
            if (optLong > 0) {
                JSONUtils.append(jSONObject, "native_heap_range", getNativeHeapRange(optLong));
                JSONUtils.append(jSONObject, "native_heap_leak", Boolean.valueOf(optLong > 268435456));
                long optLong2 = optJSONObject.optLong("native_heap_alloc_size");
                if (optLong2 > 0) {
                    JSONUtils.append(jSONObject, "native_heap_alloc_leak", Boolean.valueOf(optLong2 > 268435456));
                    JSONUtils.append(jSONObject, "native_heap_alloc_usage", getHeapUsage(optLong, optLong2));
                }
            }
        }
        JSONObject optJSONObject2 = jSONObject2.optJSONObject(MonitorConstant.BLANK_MEMORY_INFO);
        if (optJSONObject2 != null) {
            long optLong3 = optJSONObject2.optLong("totalPss");
            if (optLong3 > 0) {
                JSONUtils.append(jSONObject, "total_pss_range", getNativeHeapRange(optLong3));
            }
        }
    }

    private static String getJavaHeapRange(long j) {
        NumRanges numRanges = new NumRanges("MB");
        numRanges.set(0L, 512L, 64L);
        return numRanges.get(j);
    }

    private static String getNativeHeapRange(long j) {
        NumRanges numRanges = new NumRanges("MB");
        numRanges.set(new Long[]{0L, 1L, 64L, 128L, 256L, 384L, 512L, 768L, 1024L, 1536L});
        return numRanges.get(j);
    }

    public static void appendJavaHeapFilters(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject optJSONObject = jSONObject2.optJSONObject("app_memory_info");
        if (optJSONObject != null) {
            long optLong = optJSONObject.optLong("max_memory");
            long optLong2 = optJSONObject.optLong("free_memory");
            long optLong3 = optJSONObject.optLong("total_memory");
            long j = optLong3 - optLong2;
            if (j > 0) {
                JSONUtils.append(jSONObject, "java_heap_range", getJavaHeapRange(j / 1048576));
                if (optLong > j) {
                    JSONUtils.append(jSONObject, "java_heap_alloc_usage", getHeapUsage(optLong3, j));
                    JSONUtils.append(jSONObject, "java_heap_usage", getHeapUsage(optLong, optLong3));
                }
            }
            JSONUtils.append(jSONObject, "java_heap_leak", String.valueOf(((float) j) > ((float) optLong) * 0.95f));
        }
    }
}
