package com.bytedance.apm.alog;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class DefaultAlogUploadStrategy implements IAlogUploadStrategy {
    @Override // com.bytedance.apm.alog.IAlogUploadStrategy
    public List<String> getUploadAlogFiles(Context context, String str, long j, long j2) {
        final long j3 = j * 1000;
        final long j4 = j2 * 1000;
        if (j3 > j4 || str == null) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        final Pattern compile = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$");
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.apm.alog.DefaultAlogUploadStrategy.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str2) {
                String group;
                Matcher matcher = compile.matcher(str2);
                if (!matcher.find() || matcher.groupCount() != 1 || (group = matcher.group(1)) == null) {
                    return false;
                }
                long parseLong = Long.parseLong(group);
                if (parseLong <= 0 || parseLong > j4) {
                    return false;
                }
                long lastModified = new File(file2, str2).lastModified();
                return lastModified > 0 && lastModified >= j3;
            }
        });
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return null;
        }
        for (File file2 : listFiles) {
            arrayList.add(file2.getAbsolutePath());
        }
        return arrayList;
    }
}
