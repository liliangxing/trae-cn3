package com.bytedance.ug.sdk.deeplink;

import android.content.ClipData;
import android.net.Uri;
import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UriCacheHandler {
    private static CopyOnWriteArrayList<Uri> schemeCache;

    public static void cacheScheme(Uri uri) {
        if (schemeCache == null) {
            schemeCache = new CopyOnWriteArrayList<>();
        }
        if (uri != null) {
            schemeCache.add(uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void clearSchemeCache() {
        CopyOnWriteArrayList<Uri> copyOnWriteArrayList = schemeCache;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
    }

    public static boolean isRepeatedScheme(ClipData clipData, String str) {
        CopyOnWriteArrayList<Uri> copyOnWriteArrayList = schemeCache;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0 || TextUtils.isEmpty(str) || !str.startsWith("ttcb")) {
            return false;
        }
        ClipboardCompat.clearClipBoard(GlobalContext.INSTANCE.getApplication(), str, clipData);
        return true;
    }

    public static boolean isRepeatedScheme(ClipData clipData, String str, Uri uri) {
        boolean z;
        String str2;
        String str3;
        CopyOnWriteArrayList<Uri> copyOnWriteArrayList = schemeCache;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0 && uri != null && !TextUtils.isEmpty(str)) {
            try {
                String queryParameter = uri.getQueryParameter(CommonConstants.ZLINK);
                String queryParameter2 = uri.getQueryParameter("zlink_click_time");
                if (!TextUtils.isEmpty(queryParameter2) && !TextUtils.isEmpty(queryParameter)) {
                    for (int i = 0; i < schemeCache.size(); i++) {
                        Uri uri2 = schemeCache.get(i);
                        String queryParameter3 = uri2.getQueryParameter("scheme");
                        if (TextUtils.isEmpty(queryParameter3)) {
                            str2 = null;
                            str3 = null;
                        } else {
                            Uri parse = Uri.parse(queryParameter3);
                            str2 = parse.getQueryParameter(CommonConstants.ZLINK);
                            str3 = parse.getQueryParameter("zlink_click_time");
                        }
                        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                            str2 = uri2.getQueryParameter(CommonConstants.ZLINK);
                            str3 = uri2.getQueryParameter("zlink_click_time");
                        }
                        if (queryParameter2.equalsIgnoreCase(str3) && queryParameter.equalsIgnoreCase(str2)) {
                            schemeCache.remove(i);
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                boolean z2 = z;
                if (z) {
                    ClipboardCompat.clearClipBoard(GlobalContext.INSTANCE.getApplication(), str, clipData);
                }
                return z2;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean isRepeatedOrInvalid(ClipData clipData, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        try {
            return isRepeatedScheme(clipData, str, Uri.parse(str2));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject getCustomParamsFromScheme(String str) {
        String queryParameter;
        Uri parse = !TextUtils.isEmpty(str) ? Uri.parse(str) : null;
        if (parse != null) {
            try {
                queryParameter = parse.getQueryParameter(CommonConstants.ZLINK_DATA);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(queryParameter)) {
                return null;
            }
            try {
                return new JSONObject(queryParameter);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        queryParameter = null;
        if (!TextUtils.isEmpty(queryParameter)) {
        }
    }
}
