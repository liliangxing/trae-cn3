package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.ProcTimeInStateInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;

/* loaded from: classes6.dex */
public class ProcTimeInStateFile extends BaseStatFile {
    private static final int INDEX_FREQ = 0;
    private static final int INDEX_TIME = 1;
    private static final String PATH = "/proc/self/time_in_state";

    public ProcTimeInStateFile() {
        this(PATH);
    }

    public ProcTimeInStateFile(int i) {
        super("/proc/self/task/" + i + "/time_in_state");
    }

    public ProcTimeInStateFile(String str) {
        super(str);
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    protected FileStatInfo doRead(File file) {
        return parseFile(file);
    }

    private FileStatInfo parseFile(File file) {
        BufferedReader openFile = FileUtils.openFile(file);
        if (openFile == null) {
            return null;
        }
        ProcTimeInStateInfo procTimeInStateInfo = new ProcTimeInStateInfo();
        LinkedHashMap<Long, Long> linkedHashMap = null;
        long j = 0;
        while (true) {
            try {
                try {
                    String readLine = openFile.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (!readLine.isEmpty() && !readLine.contains("cpu")) {
                        String[] split = readLine.split(" ");
                        if (split.length <= 1) {
                            break;
                        }
                        long parseLong = Long.parseLong(split[0]);
                        long parseLong2 = Long.parseLong(split[1]) * 10;
                        if (j != 0 && parseLong < j) {
                            procTimeInStateInfo.addFreqTimeItem(linkedHashMap);
                            linkedHashMap = null;
                        }
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap<>();
                        }
                        linkedHashMap.put(Long.valueOf(parseLong), Long.valueOf(parseLong2));
                        j = parseLong;
                    }
                } catch (Exception e) {
                    DebugLog.e(Log.getStackTraceString(e));
                    FileUtils.closeFile(openFile);
                    return procTimeInStateInfo;
                }
            } catch (Throwable unused) {
                FileUtils.closeFile(openFile);
                return procTimeInStateInfo;
            }
        }
        procTimeInStateInfo.addFreqTimeItem(linkedHashMap);
        FileUtils.closeFile(openFile);
        return procTimeInStateInfo;
    }
}
