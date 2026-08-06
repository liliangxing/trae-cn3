package com.bytedance.article.common.monitor.backfetch;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.PermissionUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PermissionFetch {
    public static final String PERMISSION_FILE_BACK_TYPE = "permission_back";
    private static long lastFetchTime;
    private static String[] permissionList;

    public static Map<String, Boolean> checkAppPermissions(Context context) {
        HashMap hashMap = new HashMap();
        String[] strArr = permissionList;
        if (strArr != null) {
            for (String str : strArr) {
                hashMap.put(str, Boolean.valueOf(PermissionUtils.checkSelfPermission(context, str)));
            }
        }
        return hashMap;
    }

    private static String generateUploadFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        String versionName = FetchUtils.getVersionName(ApmContext.getHeaderInner());
        return TextUtils.isEmpty(versionName) ? String.format("%s_permissionInfo", simpleDateFormat.format(new Date(System.currentTimeMillis()))) : String.format("%s_permissionInfo_%s", simpleDateFormat.format(new Date(System.currentTimeMillis())), versionName);
    }
}
