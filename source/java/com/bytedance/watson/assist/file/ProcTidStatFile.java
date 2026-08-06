package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.ThreadStatInfo;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class ProcTidStatFile extends ProcPidStatFile {
    public ProcTidStatFile(long j) {
        super("proc/self/task/" + j + "/stat");
    }

    @Override // com.bytedance.watson.assist.file.ProcPidStatFile, com.bytedance.watson.assist.file.BaseStatFile
    protected FileStatInfo doRead(File file) {
        return parseFile(file, (ThreadStatInfo) null);
    }

    protected FileStatInfo parseFile(File file, ThreadStatInfo threadStatInfo) {
        BufferedReader openFile = FileUtils.openFile(file);
        if (openFile == null) {
            return null;
        }
        try {
            try {
                String readLine = openFile.readLine();
                if (readLine != null && !readLine.isEmpty()) {
                    String trim = readLine.trim();
                    String trim2 = trim.substring(0, trim.indexOf(SPLIT_PROC_NAME_RIGHT.charValue())).trim();
                    String trim3 = trim.substring(trim.indexOf(SPLIT_PROC_NAME_RIGHT.charValue()) + 1, trim.length()).trim();
                    String[] split = trim2.split("\\(");
                    String[] split2 = trim3.split(" ");
                    if (split.length > 1 && split2.length > 14) {
                        if (threadStatInfo == null) {
                            threadStatInfo = new ThreadStatInfo();
                        }
                        threadStatInfo.setPid(Integer.parseInt(split[0].trim()));
                        threadStatInfo.setProcessName(split[1].trim());
                        threadStatInfo.setCpuTime((Integer.parseInt(split2[11]) + Integer.parseInt(split2[12])) * 10);
                        FileUtils.closeFile(openFile);
                        return threadStatInfo;
                    }
                    FileUtils.closeFile(openFile);
                    return threadStatInfo;
                }
                FileUtils.closeFile(openFile);
                return threadStatInfo;
            } catch (Exception e) {
                DebugLog.m28e(Log.getStackTraceString(e));
                FileUtils.closeFile(openFile);
                return threadStatInfo;
            }
        } catch (Throwable unused) {
            FileUtils.closeFile(openFile);
            return threadStatInfo;
        }
    }
}
