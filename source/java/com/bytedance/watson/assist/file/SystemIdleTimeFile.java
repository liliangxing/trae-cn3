package com.bytedance.watson.assist.file;

import android.util.Log;
import com.bytedance.watson.assist.core.cpu.CpuIdleTimeStatInfo;
import com.bytedance.watson.assist.utils.CpuUtils;
import com.bytedance.watson.assist.utils.DebugLog;
import com.bytedance.watson.assist.utils.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SystemIdleTimeFile extends BaseStatFile {
    private static final String PATH_PREFIX = "/sys/devices/system/cpu/cpu";
    private static final String PATH_SUB_PREFIX = "/cpuidle/state";
    private static final String PATH_SUFFIX = "/time";
    private int cpuNum;
    private List<List<File>> fileList;
    private List<Integer> idleStateNumList;
    private boolean inited;

    public SystemIdleTimeFile() {
        super("");
        this.inited = false;
        this.fileList = new ArrayList();
        this.cpuNum = -1;
    }

    public SystemIdleTimeFile(String str) {
        super(str);
        this.inited = false;
        this.fileList = new ArrayList();
        this.cpuNum = -1;
    }

    @Override // com.bytedance.watson.assist.file.BaseStatFile
    public FileStatInfo refresh() {
        if (!this.inited) {
            this.cpuNum = CpuUtils.getCpuCoreNum();
            this.idleStateNumList = CpuUtils.getCpuIdleStateNumList();
            this.inited = true;
        }
        if (this.idleStateNumList == null) {
            return null;
        }
        if (this.fileList.isEmpty()) {
            for (int i = 0; i < this.cpuNum; i++) {
                int intValue = this.idleStateNumList.get(i).intValue();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < intValue; i2++) {
                    arrayList.add(new File(PATH_PREFIX + i + PATH_SUB_PREFIX + i2 + PATH_SUFFIX));
                }
                this.fileList.add(arrayList);
            }
        }
        this.mLastInfo = doRead(this.fileList);
        return this.mLastInfo;
    }

    private FileStatInfo doRead(List<List<File>> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        CpuIdleTimeStatInfo cpuIdleTimeStatInfo = new CpuIdleTimeStatInfo();
        Iterator<List<File>> it = list.iterator();
        while (it.hasNext()) {
            List<Long> parseFile = parseFile(it.next());
            if (parseFile != null) {
                cpuIdleTimeStatInfo.putStateTimeList(parseFile);
            }
        }
        return cpuIdleTimeStatInfo;
    }

    private List<Long> parseFile(List<File> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            BufferedReader openFile = FileUtils.openFile(it.next());
            if (openFile == null) {
                return null;
            }
            while (true) {
                try {
                    try {
                        String readLine = openFile.readLine();
                        if (readLine != null && !readLine.isEmpty()) {
                            arrayList.add(Long.valueOf(Long.parseLong(readLine) / 1000));
                        }
                    } catch (Exception e) {
                        DebugLog.m28e(Log.getStackTraceString(e));
                    }
                } finally {
                    FileUtils.closeFile(openFile);
                }
            }
        }
        return arrayList;
    }
}
