package com.bytedance.crash.alog;

import android.text.TextUtils;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.App;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultAlogUploadStrategy implements IAlogUploadStrategy {
    private String mProcessName;

    public DefaultAlogUploadStrategy(String str) {
        this.mProcessName = str;
    }

    public DefaultAlogUploadStrategy() {
    }

    @Override // com.bytedance.crash.alog.IAlogUploadStrategy
    public List<String> getUploadAlogFiles(String str, long j) {
        File[] listFiles;
        long parseLong;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            listFiles = new File(str).listFiles();
        } catch (Exception e) {
            NpthMonitor.reportInnerException(e);
        }
        if (listFiles == null) {
            return arrayList;
        }
        if (this.mProcessName == null) {
            this.mProcessName = App.getProcessName();
        }
        boolean z = !this.mProcessName.contains(":");
        String replace = this.mProcessName.contains(":") ? this.mProcessName.replace(":", "-") : this.mProcessName;
        File file = null;
        File file2 = null;
        long j2 = 0;
        long j3 = 0;
        for (File file3 : listFiles) {
            String name = file3.getName();
            if (name.endsWith(".hot") && ((!z || !file3.getName().contains("-")) && ((z || file3.getName().contains("-")) && name.contains(replace)))) {
                String[] split = name.split("_");
                if (split.length >= 4) {
                    parseLong = Long.parseLong(split[3]);
                } else {
                    parseLong = split.length > 1 ? Long.parseLong(split[0]) : -1L;
                }
                if (j <= 0 || parseLong <= j) {
                    if (j2 < parseLong) {
                        file = file2;
                        j3 = j2;
                        file2 = file3;
                        j2 = parseLong;
                    } else if (j3 < parseLong) {
                        j3 = parseLong;
                        file = file3;
                    }
                }
            }
        }
        if (file != null && file.length() > 0) {
            arrayList.add(file.getAbsolutePath());
        }
        if (file2 != null && file2.length() > 0) {
            arrayList.add(file2.getAbsolutePath());
        }
        return arrayList;
    }
}
