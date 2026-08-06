package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.CpuTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SystemTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUFFIX = "/cpufreq/stats/time_in_state";
    private int cpuNum;
    private List<File> fileList;

    public SystemTimeInStateFile(String str) {
        super(str);
        this.cpuNum = CpuUtils.getCpuCoreNum();
        this.fileList = new ArrayList();
    }

    public SystemTimeInStateFile() {
        super("");
        this.cpuNum = CpuUtils.getCpuCoreNum();
        this.fileList = new ArrayList();
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (this.fileList.isEmpty()) {
            for (int i = 0; i != this.cpuNum; i++) {
                this.fileList.add(new File(PATH_PREFIX + i + PATH_SUFFIX));
            }
        }
        this.mLastInfo = doRead(this.fileList);
        return this.mLastInfo;
    }

    private FileStatInfo doRead(List<File> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        CpuTimeStatInfo cpuTimeStatInfo = new CpuTimeStatInfo();
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            LinkedHashMap<Long, Long> parseFile = parseFile(it.next());
            if (parseFile != null) {
                cpuTimeStatInfo.putFreqTimeMap(parseFile);
            }
        }
        return cpuTimeStatInfo;
    }

    private LinkedHashMap<Long, Long> parseFile(File file) {
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
                    String[] split = readLine.trim().split(" ");
                    if (split.length <= 1) {
                        break;
                    }
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap<>();
                    }
                    linkedHashMap.put(Long.valueOf(Long.parseLong(split[0])), Long.valueOf(Long.parseLong(split[1]) * 10));
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
