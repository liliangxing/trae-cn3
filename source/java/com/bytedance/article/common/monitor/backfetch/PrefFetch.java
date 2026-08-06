package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PrefFetch {
    private static final String PREFS_SUFFIX = ".xml";
    public static final String SP_FILE_BACK_TYPE = "sp_file_back";
    private static long lastFetchTime;

    public static List<String> getSharedPreferenceTags(Context context) {
        ArrayList arrayList = new ArrayList();
        File file = new File(context.getApplicationInfo().dataDir + "/shared_prefs");
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                String name = file2.getName();
                if (name.endsWith(PREFS_SUFFIX)) {
                    arrayList.add(name.substring(0, name.length() - 4));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String versionName = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        return TextUtils.isEmpty(versionName) ? String.format("%s_sp.zip", simpleDateFormat.format(new Date(System.currentTimeMillis()))) : String.format("%s_sp_%s.zip", simpleDateFormat.format(new Date(System.currentTimeMillis())), versionName);
    }
}
