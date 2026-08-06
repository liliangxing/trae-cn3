package com.bytedance.watson.assist.utils;

import android.util.Log;
import com.bytedance.watson.assist.utils.FileUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class CpuUtils {
    private static List<Integer> CLUSTER_AFFECT_CPU_NUM = null;
    private static final String CPU_CLUSTER_DIR = "/sys/devices/system/cpu/cpufreq";
    private static List<CpuClusterInfo> CPU_CLUSTER_INFO_LIST = null;
    private static int CPU_CORE_NUM = -1;
    private static final String CPU_CUR_FREQ_PATH = "/scaling_cur_freq";
    private static final String CPU_DIR = "/sys/devices/system/cpu";
    private static String CPU_HARDWARE = null;
    private static String CPU_HARDWARE_FROM_PROP = null;
    private static final String CPU_HARDWARE_PROP = "ro.board.platform";
    private static final String CPU_IDLE_PREFIX_DIR = "/sys/devices/system/cpu/cpu";
    private static List<Integer> CPU_IDLE_STATE_NUM_LIST = null;
    private static final String CPU_IDLE_SUFFIX_DIR = "/cpuidle";
    private static final String CPU_SCALING_MAX_FREQ_PATH = "/scaling_max_freq";
    private static final String CPU_SCALING_MIN_FREQ_PATH = "/scaling_min_freq";
    private static final String PROC_CPU_PATH = "/proc/cpuinfo";
    public static final int kClockTicksMs = 10;

    public static int getCpuCoreNum() {
        if (CPU_CORE_NUM == -1) {
            File[] listFiles = new File(CPU_DIR).listFiles(new FilenameFilter() { // from class: com.bytedance.watson.assist.utils.CpuUtils.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return Pattern.matches("cpu[0-9]", str);
                }
            });
            CPU_CORE_NUM = listFiles == null ? 1 : listFiles.length;
        }
        return CPU_CORE_NUM;
    }

    public static synchronized List<Integer> getCpuIdleStateNumList() {
        synchronized (CpuUtils.class) {
            List<Integer> list = CPU_IDLE_STATE_NUM_LIST;
            if (list != null) {
                return list;
            }
            int cpuCoreNum = getCpuCoreNum();
            if (cpuCoreNum == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < cpuCoreNum; i++) {
                File[] listFiles = new File(CPU_IDLE_PREFIX_DIR + i + CPU_IDLE_SUFFIX_DIR).listFiles(new FilenameFilter() { // from class: com.bytedance.watson.assist.utils.CpuUtils.2
                    @Override // java.io.FilenameFilter
                    public boolean accept(File file, String str) {
                        return Pattern.matches("state[0-9]", str);
                    }
                });
                arrayList.add(Integer.valueOf(listFiles == null ? 0 : listFiles.length));
            }
            CPU_IDLE_STATE_NUM_LIST = arrayList;
            return arrayList;
        }
    }

    public static int getCpuIdleStateNum(int i) {
        if (CPU_IDLE_STATE_NUM_LIST == null) {
            getCpuIdleStateNumList();
            if (CPU_IDLE_STATE_NUM_LIST == null) {
                return -1;
            }
        }
        if (i >= CPU_IDLE_STATE_NUM_LIST.size()) {
            return -1;
        }
        return CPU_IDLE_STATE_NUM_LIST.get(i).intValue();
    }

    public static String getCpuHardware() {
        String str = CPU_HARDWARE;
        if (str != null) {
            return str;
        }
        FileUtils.readFile(PROC_CPU_PATH, new FileUtils.ReadLineCallback() { // from class: com.bytedance.watson.assist.utils.CpuUtils.3
            @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
            public boolean onReadLine(String str2) {
                if (str2 == null || !str2.contains("Hardware")) {
                    return true;
                }
                String[] split = str2.split(Constants.COLON_SEPARATOR);
                if (split.length <= 1) {
                    return false;
                }
                String unused = CpuUtils.CPU_HARDWARE = split[1].trim();
                return false;
            }
        });
        return CPU_HARDWARE;
    }

    public static String getCpuHardwareFromProp() {
        String str = CPU_HARDWARE_FROM_PROP;
        if (str != null) {
            return str;
        }
        String str2 = SystemProperties.get(CPU_HARDWARE_PROP, "");
        CPU_HARDWARE_FROM_PROP = str2;
        return str2;
    }

    public static synchronized List<CpuClusterInfo> getCpuClusterInfoList() {
        synchronized (CpuUtils.class) {
            List<CpuClusterInfo> list = CPU_CLUSTER_INFO_LIST;
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            File[] listFiles = new File(CPU_CLUSTER_DIR).listFiles(new FilenameFilter() { // from class: com.bytedance.watson.assist.utils.CpuUtils.4
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str) {
                    return Pattern.matches("policy[0-9]", str);
                }
            });
            if (listFiles != null && listFiles.length > 0) {
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.watson.assist.utils.CpuUtils.5
                    @Override // java.util.Comparator
                    public int compare(File file, File file2) {
                        return file.getName().compareTo(file2.getName());
                    }
                });
                for (File file : listFiles) {
                    CpuClusterInfo cpuClusterInfo = new CpuClusterInfo(file.getName());
                    final ArrayList arrayList2 = new ArrayList();
                    final ArrayList arrayList3 = new ArrayList();
                    FileUtils.readFile(file.getAbsolutePath() + "/scaling_available_frequencies", new FileUtils.ReadLineCallback() { // from class: com.bytedance.watson.assist.utils.CpuUtils.6
                        @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
                        public boolean onReadLine(String str) {
                            if (str != null && !str.isEmpty()) {
                                for (String str2 : str.split(" ")) {
                                    arrayList2.add(Long.valueOf(Long.parseLong(str2)));
                                }
                            }
                            return true;
                        }
                    });
                    FileUtils.readFile(file.getAbsolutePath() + "/affected_cpus", new FileUtils.ReadLineCallback() { // from class: com.bytedance.watson.assist.utils.CpuUtils.7
                        @Override // com.bytedance.watson.assist.utils.FileUtils.ReadLineCallback
                        public boolean onReadLine(String str) {
                            if (str != null && !str.isEmpty()) {
                                for (String str2 : str.split(" ")) {
                                    arrayList3.add(Integer.valueOf(Integer.parseInt(str2)));
                                }
                            }
                            return true;
                        }
                    });
                    cpuClusterInfo.setFreqList(arrayList2);
                    cpuClusterInfo.setAffectedCpuList(arrayList3);
                    arrayList.add(cpuClusterInfo);
                }
            }
            CPU_CLUSTER_INFO_LIST = arrayList;
            return arrayList;
        }
    }

    public static synchronized List<Integer> getClusterCpuNum() {
        synchronized (CpuUtils.class) {
            List<Integer> list = CLUSTER_AFFECT_CPU_NUM;
            if (list != null) {
                return list;
            }
            List<CpuClusterInfo> cpuClusterInfoList = getCpuClusterInfoList();
            ArrayList arrayList = new ArrayList();
            Iterator<CpuClusterInfo> it = cpuClusterInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().getAffectedCpuList().size()));
            }
            CLUSTER_AFFECT_CPU_NUM = arrayList;
            return arrayList;
        }
    }

    public static boolean isClusterLockFreq(int i) {
        long clusterMaxFreq = getClusterMaxFreq(i);
        long clusterMinFreq = getClusterMinFreq(i);
        return (clusterMaxFreq == -1 || clusterMinFreq == -1 || clusterMaxFreq != clusterMinFreq) ? false : true;
    }

    public static long getClusterCurrentFreq(int i) {
        return getClusterFreq(i, CPU_CUR_FREQ_PATH);
    }

    public static long getClusterMinFreq(int i) {
        return getClusterFreq(i, CPU_SCALING_MIN_FREQ_PATH);
    }

    public static long getClusterMaxFreq(int i) {
        return getClusterFreq(i, CPU_SCALING_MAX_FREQ_PATH);
    }

    public static int getClusterCurrentFreqLevel(int i) {
        return getFreqLevel(i, getClusterFreq(i, CPU_CUR_FREQ_PATH));
    }

    public static int getClusterMinFreqLevelLevel(int i) {
        return getFreqLevel(i, getClusterFreq(i, CPU_SCALING_MIN_FREQ_PATH));
    }

    public static int getClusterMaxFreqLevel(int i) {
        return getFreqLevel(i, getClusterFreq(i, CPU_SCALING_MAX_FREQ_PATH));
    }

    private static long getClusterFreq(int i, String str) {
        Long l = -1L;
        if (i < 0 || str == null) {
            return l.longValue();
        }
        List<CpuClusterInfo> cpuClusterInfoList = getCpuClusterInfoList();
        String str2 = "/";
        if (cpuClusterInfoList != null && cpuClusterInfoList.size() > i) {
            str2 = "/" + cpuClusterInfoList.get(i).getName();
        }
        BufferedReader openFile = FileUtils.openFile(new File(CPU_CLUSTER_DIR + str2 + str));
        if (openFile == null) {
            return l.longValue();
        }
        try {
            try {
                String readLine = openFile.readLine();
                if (readLine != null) {
                    l = Long.valueOf(Long.parseLong(readLine));
                }
            } catch (Exception e) {
                DebugLog.w("get cluster freq error : " + str + Log.getStackTraceString(e));
            }
            return l.longValue();
        } finally {
            FileUtils.closeFile(openFile);
        }
    }

    public static int getFreqLevel(int i, long j) {
        List<CpuClusterInfo> cpuClusterInfoList;
        CpuClusterInfo cpuClusterInfo;
        if (i >= 0 && j > 0 && (cpuClusterInfoList = getCpuClusterInfoList()) != null && cpuClusterInfoList.size() >= i + 1 && (cpuClusterInfo = cpuClusterInfoList.get(i)) != null && cpuClusterInfo.getFreqList() != null) {
            int size = cpuClusterInfo.getFreqList().size();
            for (int i2 = 0; i2 < size; i2++) {
                if (cpuClusterInfo.getFreqList().get(i2).longValue() == j) {
                    if (size < 4) {
                        return i2;
                    }
                    int i3 = i2 / (size / 4);
                    if (i3 > 3) {
                        return 3;
                    }
                    return i3;
                }
            }
        }
        return -1;
    }

    /* loaded from: classes6.dex */
    public static class CpuClusterInfo {
        private List<Integer> affectedCpuList = new ArrayList();
        private List<Long> freqList = new ArrayList();
        private String name;

        public CpuClusterInfo(String str) {
            this.name = str;
        }

        public String getName() {
            return this.name;
        }

        public List<Integer> getAffectedCpuList() {
            return this.affectedCpuList;
        }

        public void setAffectedCpuList(List<Integer> list) {
            this.affectedCpuList = list;
        }

        public List<Long> getFreqList() {
            return this.freqList;
        }

        public void setFreqList(List<Long> list) {
            this.freqList = list;
        }

        public String toString() {
            return "CpuClusterInfo{name='" + this.name + "', affectedCpuList=" + this.affectedCpuList + ", freqList=" + this.freqList + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
