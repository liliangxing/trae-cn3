package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.CpuTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SystemPolicyTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpufreq/";
    private static final String PATH_SUFFIX = "/stats/time_in_state";
    private List<Integer> cpuNumList;
    private List<File> fileList;

    public SystemPolicyTimeInStateFile(String str) {
        super(str);
        this.fileList = new ArrayList();
        this.cpuNumList = new ArrayList();
    }

    public SystemPolicyTimeInStateFile() {
        super("");
        this.fileList = new ArrayList();
        this.cpuNumList = new ArrayList();
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (this.fileList.isEmpty()) {
            List<CpuUtils.CpuClusterInfo> cpuClusterInfoList = CpuUtils.getCpuClusterInfoList();
            if (cpuClusterInfoList == null) {
                return null;
            }
            for (CpuUtils.CpuClusterInfo cpuClusterInfo : cpuClusterInfoList) {
                this.fileList.add(new File(PATH_PREFIX + cpuClusterInfo.getName() + PATH_SUFFIX));
                this.cpuNumList.add(Integer.valueOf(cpuClusterInfo.getAffectedCpuList().size()));
            }
        }
        this.mLastInfo = doRead(this.fileList, this.cpuNumList);
        return this.mLastInfo;
    }

    private FileStatInfo doRead(List<File> list, List<Integer> list2) {
        if (list == null || list.isEmpty() || list2 == null || list2.isEmpty() || list.size() != list2.size()) {
            return null;
        }
        CpuTimeStatInfo cpuTimeStatInfo = new CpuTimeStatInfo();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            LinkedHashMap<Long, Long> parseFile = parseFile(list.get(i), list2.get(i).intValue());
            if (parseFile != null) {
                cpuTimeStatInfo.putFreqTimeMap(parseFile);
            }
        }
        return cpuTimeStatInfo;
    }

    private LinkedHashMap<Long, Long> parseFile(File file, int i) {
        BufferedReader openFile = FileUtils.openFile(file);
        LinkedHashMap<Long, Long> linkedHashMap = null;
        if (openFile == null) {
            return null;
        }
        while (true) {
            try {
                try {
                    String readLine = openFile.readLine();
                    if (readLine == null || readLine.isEmpty()) {
                        break;
                    }
                    String[] split = readLine.split(" ");
                    if (split.length <= 1) {
                        break;
                    }
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap<>();
                    }
                    linkedHashMap.put(Long.valueOf(Long.parseLong(split[0])), Long.valueOf(i * 10 * Long.parseLong(split[1])));
                } catch (Exception e) {
                    DebugLog.m28e(Log.getStackTraceString(e));
                    FileUtils.closeFile(openFile);
                    return linkedHashMap;
                }
            } catch (Throwable unused) {
                FileUtils.closeFile(openFile);
                return linkedHashMap;
            }
        }
        FileUtils.closeFile(openFile);
        return linkedHashMap;
    }
}
