package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.ProcStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;

/* loaded from: classes6.dex */
public class ProcPidStatFile extends BaseStatFile {
    protected static final int INDEX_CS_TIME = 14;
    protected static final int INDEX_CU_TIME = 13;
    protected static final int INDEX_PID = 0;
    protected static final int INDEX_PROC_NAME = 1;
    protected static final int INDEX_S_TIME = 12;
    protected static final int INDEX_U_TIME = 11;
    private static final String PROC_PID_STAT_PATH = "proc/self/stat";
    protected static final Character SPLIT_PROC_NAME_RIGHT = ')';

    public ProcPidStatFile(String str) {
        super(str);
    }

    public ProcPidStatFile() {
        this(PROC_PID_STAT_PATH);
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    protected FileStatInfo doRead(File file) {
        return parseFile(file, null);
    }

    protected FileStatInfo parseFile(File file, ProcStatInfo procStatInfo) {
        BufferedReader openFile = FileUtils.openFile(file);
        try {
            if (openFile == null) {
                return null;
            }
            try {
                String readLine = openFile.readLine();
                if (readLine != null && !readLine.isEmpty()) {
                    String trim = readLine.trim();
                    Character ch = SPLIT_PROC_NAME_RIGHT;
                    String trim2 = trim.substring(0, trim.indexOf(ch.charValue())).trim();
                    String trim3 = trim.substring(trim.indexOf(ch.charValue()) + 1, trim.length()).trim();
                    String[] split = trim2.split("\\(");
                    String[] split2 = trim3.split(" ");
                    if (split.length > 1 && split2.length > 14) {
                        if (procStatInfo == null) {
                            procStatInfo = new ProcStatInfo();
                        }
                        procStatInfo.setPid(Integer.parseInt(split[0].trim()));
                        procStatInfo.setProcessName(split[1].trim());
                        procStatInfo.setCpuTime((Integer.parseInt(split2[11]) + Integer.parseInt(split2[12]) + Integer.parseInt(split2[13]) + Integer.parseInt(split2[14])) * 10);
                        FileUtils.closeFile(openFile);
                        return procStatInfo;
                    }
                    FileUtils.closeFile(openFile);
                    return procStatInfo;
                }
                FileUtils.closeFile(openFile);
                return procStatInfo;
            } catch (Exception e) {
                DebugLog.e(Log.getStackTraceString(e));
                FileUtils.closeFile(openFile);
                return procStatInfo;
            }
        } catch (Throwable unused) {
            FileUtils.closeFile(openFile);
            return procStatInfo;
        }
    }
}
