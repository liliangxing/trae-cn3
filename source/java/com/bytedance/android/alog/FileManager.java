package com.bytedance.android.alog;

import android.text.TextUtils;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
class FileManager {
    private static final String FETCH_TIME_INVALID = "time interval is invalid";
    private static final String LOG_DIR_INVALID = "log dir not exists";
    private static final String LOG_FILE_NOT_FOUND = "log file not found";
    private static final String LOG_FILE_SUFFIX = ".alog.hot";
    private static final int SUFFIX_LEN = 9;
    private static long sFetchEndTs;
    private static String sFetchFailReason;
    private static long sFetchStartTs;
    private static ArrayList<String> sLastFetchFileLists;

    FileManager() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static File[] getLogs(String str, String str2, String str3, final long j, final long j2) {
        sFetchStartTs = j;
        sFetchEndTs = j2;
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        if (j > j2) {
            sFetchFailReason = FETCH_TIME_INVALID;
            return new File[0];
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            sFetchFailReason = LOG_DIR_INVALID;
            return new File[0];
        }
        if (!TextUtils.isEmpty(str2)) {
            str2 = str2.replace(AbstractJsonLexerKt.COLON, '-');
        }
        final Pattern compile = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__" + (TextUtils.isEmpty(str2) ? "\\S+" : Pattern.quote(str2)) + "__" + (TextUtils.isEmpty(str3) ? "\\S+" : Pattern.quote(str3)) + "\\.alog\\.hot$");
        final ArrayList<String> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles(new FilenameFilter() { // from class: com.bytedance.android.alog.FileManager.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str4) {
                String group;
                arrayList.add(str4);
                Matcher matcher = compile.matcher(str4);
                if (!matcher.find() || matcher.groupCount() != 1 || (group = matcher.group(1)) == null) {
                    return false;
                }
                long parseLong = Long.parseLong(group);
                if (parseLong > 0 && parseLong <= j2) {
                    long lastModified = new File(file2, str4).lastModified();
                    if (lastModified > 0 && lastModified >= j) {
                        return true;
                    }
                }
                return false;
            }
        });
        if (listFiles == null || listFiles.length == 0) {
            sFetchFailReason = LOG_FILE_NOT_FOUND;
            sLastFetchFileLists = arrayList;
        }
        return listFiles == null ? new File[0] : listFiles;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap<String, String> getLastErrorInfo() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("start", Long.toString(sFetchStartTs));
        hashMap.put("end", Long.toString(sFetchEndTs));
        hashMap.put("reason", sFetchFailReason);
        if (sLastFetchFileLists != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = sLastFetchFileLists.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next.endsWith(LOG_FILE_SUFFIX)) {
                    next = next.substring(0, next.length() - SUFFIX_LEN);
                }
                sb.append(next).append(";");
            }
            hashMap.put("file", sb.toString());
        }
        sFetchFailReason = null;
        sLastFetchFileLists = null;
        return hashMap;
    }
}
