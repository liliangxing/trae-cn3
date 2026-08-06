package com.bytedance.ttnet.config;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareCookieHostsSync {
    private static final String TAG = "ShareCookieHostsSync";
    private static volatile ShareCookieHostsSync mInstance;

    public static ShareCookieHostsSync inst() {
        if (mInstance == null) {
            synchronized (ShareCookieHostsSync.class) {
                if (mInstance == null) {
                    mInstance = new ShareCookieHostsSync();
                }
            }
        }
        return mInstance;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ttnet.config.ShareCookieHostsSync$1] */
    public void onShareCookieHostsChanged(final String str, final String str2) {
        if (str2.equals(str)) {
            return;
        }
        new ThreadPlus("Sync-Cookie") { // from class: com.bytedance.ttnet.config.ShareCookieHostsSync.1
            public void run() {
                ShareCookieHostsSync.this.doSyncShareCookies(str, str2);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSyncShareCookies(String str, String str2) {
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler == null) {
            Logger.e(TAG, "Default CookieHandler is null.");
            return;
        }
        List<String> parseCookieHostListFromString = parseCookieHostListFromString(str);
        List<String> parseCookieHostListFromString2 = parseCookieHostListFromString(str2);
        ArrayList<String> arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        for (String str3 : parseCookieHostListFromString2) {
            if (TtnetUtil.inCookieHostList(str3, parseCookieHostListFromString)) {
                if (Logger.debug()) {
                    Logger.d(TAG, "kept hosts add: " + str3);
                }
                arrayList.add(str3);
            } else {
                if (Logger.debug()) {
                    Logger.d(TAG, "added hosts add: " + str3);
                }
                arrayList2.add(str3);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        if (arrayList.isEmpty()) {
            arrayList = arrayList2;
        }
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str4 : arrayList) {
            try {
                hashMap = cookieHandler.get(new URI("https://" + str4 + "/"), null);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (hashMap.size() > 0) {
                if (!Logger.debug()) {
                    break;
                }
                Logger.d(TAG, "Sync cookie from host: " + str4 + " sync cookies: " + hashMap.toString());
                break;
            }
            continue;
        }
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        List<String> list = hashMap.get("Cookie");
        if ((list == null || list.isEmpty()) && ((list = hashMap.get("cookie")) == null || list.isEmpty())) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> splitWebkitCookieStringToCookieList = splitWebkitCookieStringToCookieList(list);
        for (String str5 : arrayList2) {
            ArrayList arrayList3 = new ArrayList();
            try {
                URI uri = new URI("https://" + str5 + "/");
                for (String str6 : splitWebkitCookieStringToCookieList) {
                    if (!StringUtils.isEmpty(str6)) {
                        arrayList3.add(str6 + "; Domain=" + str5);
                    }
                }
                linkedHashMap.put("Set-Cookie", arrayList3);
                cookieHandler.put(uri, linkedHashMap);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private List<String> splitWebkitCookieStringToCookieList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            for (String str : it.next().split(";")) {
                if (!StringUtils.isEmpty(str)) {
                    arrayList.add(str.trim());
                }
            }
        }
        return arrayList;
    }

    private List<String> parseCookieHostListFromString(String str) {
        ArrayList arrayList = new ArrayList();
        if (StringUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String str2 : str.split(",")) {
            if (!StringUtils.isEmpty(str2)) {
                arrayList.add(str2.trim());
            }
        }
        return arrayList;
    }
}
