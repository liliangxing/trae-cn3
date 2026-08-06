package com.bytedance.frameworks.baselib.network.http.impl;

import android.content.Context;
import android.text.TextUtils;
import coil3.disk.DiskLruCache;
import com.bytedance.android.live.core.setting.SettingVersionUtils;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.config.InsecureRequestControlConfig;
import com.bytedance.frameworks.baselib.network.config.TTCookieConfig;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.CookieManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SSCookieHandler extends CookieManager {
    public static final String COOKIE = "Cookie";
    private static final String GET_REQUEST_COOKIE_SOURCE_FLAG = "x-tt-get-cookie-source";
    public static final String REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG = "x-tt-cookie-backup-source=1";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String SS_COOKIE = "X-SS-Cookie";
    public static final String SS_SET_COOKIE = "X-SS-Set-Cookie";
    private static final String TAG = "SSCookieHandler";
    public static boolean USE_SS_COOKIE = false;
    public static final String WEBVIEW_COOKIE = "webview-origin-url";
    public static final String X_HEADER_NO_COOKIE = "X-SS-No-Cookie";
    private static final String event = "TTNET-COOKIE";
    private volatile CookieManagerWrap mBackupCookieMgr;
    private final ICookieEventHandler mCookieEventHandler;
    private final ArrayList<String> mCookieFlushPathList;
    private final android.webkit.CookieManager mCookieMgr;
    private final Pattern pattern = Pattern.compile("(?<=Domain=)([^;]*)", 2);

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICookieEventHandler {
        boolean enableSetCookieLog();

        void onEvent(String str, String str2, JSONObject jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private enum ReqCookieSource {
        UNKNOWN,
        APP_COOKIE_STORE,
        SHARE_INTERCEPTOR_MAIN,
        SHARE_INTERCEPTOR_BACKUP,
        MAIN,
        BACKUP
    }

    @Deprecated
    public static void setDebugAppCookieStore(boolean z) {
    }

    public SSCookieHandler(final Context context, int i, android.webkit.CookieManager cookieManager, ArrayList<String> arrayList, ICookieEventHandler iCookieEventHandler) {
        if (i > 0) {
            TTExecutors.getScheduledThreadPool().schedule(new Runnable() { // from class: com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    SSCookieHandler.this.mBackupCookieMgr = new CookieManagerWrap(context, CookiePolicy.ACCEPT_ALL);
                }
            }, i, TimeUnit.SECONDS);
        } else {
            this.mBackupCookieMgr = new CookieManagerWrap(context, CookiePolicy.ACCEPT_ALL);
        }
        this.mCookieMgr = cookieManager;
        this.mCookieFlushPathList = arrayList;
        if (iCookieEventHandler != null && iCookieEventHandler.enableSetCookieLog()) {
            this.mCookieEventHandler = iCookieEventHandler;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("init", "success");
            } catch (JSONException unused) {
            }
            this.mCookieEventHandler.onEvent(event, "init", jSONObject);
            return;
        }
        this.mCookieEventHandler = null;
    }

    private List<String> getHeaderListIgnoreCase(Map<String, List<String>> map, String str) {
        if (map == null || map.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        List<String> list = map.get(str);
        return (list == null || list.isEmpty()) ? map.get(str.toLowerCase()) : list;
    }

    private void flushCookiesIfPathMatched(String str, boolean z) {
        if (z) {
            android.webkit.CookieManager.getInstance().flush();
            if (Logger.debug()) {
                Logger.d(TAG, "Force flush cookie: " + str);
                return;
            }
            return;
        }
        ArrayList<String> arrayList = this.mCookieFlushPathList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<String> it = this.mCookieFlushPathList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                android.webkit.CookieManager.getInstance().flush();
                if (Logger.debug()) {
                    Logger.d(TAG, "Path match flush cookie: " + str);
                    return;
                }
                return;
            }
        }
    }

    private Map<String, List<String>> getCookieMap(List<String> list, Map<String, List<String>> map) {
        Map<String, List<String>> emptyMap = Collections.emptyMap();
        if (!USE_SS_COOKIE) {
            if (map != null) {
                List<String> headerListIgnoreCase = getHeaderListIgnoreCase(map, COOKIE);
                return (headerListIgnoreCase == null || headerListIgnoreCase.isEmpty()) ? Collections.singletonMap(COOKIE, list) : emptyMap;
            }
            return Collections.singletonMap(COOKIE, list);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null) {
            List<String> headerListIgnoreCase2 = getHeaderListIgnoreCase(map, COOKIE);
            if (headerListIgnoreCase2 == null || headerListIgnoreCase2.isEmpty()) {
                linkedHashMap.put(COOKIE, list);
            }
        } else {
            linkedHashMap.put(COOKIE, list);
        }
        if (map != null) {
            List<String> headerListIgnoreCase3 = getHeaderListIgnoreCase(map, SS_COOKIE);
            if (headerListIgnoreCase3 != null && !headerListIgnoreCase3.isEmpty()) {
                return linkedHashMap;
            }
            linkedHashMap.put(SS_COOKIE, list);
            return linkedHashMap;
        }
        linkedHashMap.put(SS_COOKIE, list);
        return linkedHashMap;
    }

    private static Map<String, List<String>> getCookieResultMap(boolean z, Map<String, List<String>> map, ReqCookieSource reqCookieSource) {
        if (!z) {
            return map;
        }
        if (map == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(GET_REQUEST_COOKIE_SOURCE_FLAG, Collections.singletonList(String.valueOf(reqCookieSource.ordinal())));
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.net.CookieManager, java.net.CookieHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) throws IOException {
        String str;
        Map<String, List<String>> map2;
        if (uri == null) {
            return Collections.emptyMap();
        }
        boolean z = false;
        try {
            str = uri.toString();
            if (map != null) {
                try {
                    if (!map.isEmpty()) {
                        z = map.containsKey(GET_REQUEST_COOKIE_SOURCE_FLAG);
                        List<String> headerListIgnoreCase = getHeaderListIgnoreCase(map, X_HEADER_NO_COOKIE);
                        if (headerListIgnoreCase != null && !headerListIgnoreCase.isEmpty()) {
                            for (String str2 : headerListIgnoreCase) {
                                if (str2 != null && Boolean.parseBoolean(str2)) {
                                    if (Logger.debug()) {
                                        Logger.v(TAG, "X-SS-No-Cookie " + str);
                                    }
                                    return Collections.emptyMap();
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (this.mCookieMgr != null) {
                    }
                }
            }
            NetworkParams.AppCookieStore appCookieStore = NetworkParams.getAppCookieStore();
            if (appCookieStore != null && (map2 = appCookieStore.get(uri, map)) != null && !map2.isEmpty() && (map2.containsKey(COOKIE) || map2.containsKey(SS_COOKIE))) {
                return getCookieResultMap(z, map2, ReqCookieSource.APP_COOKIE_STORE);
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        if (this.mCookieMgr != null) {
            return Collections.emptyMap();
        }
        try {
            NetworkParams.CookieShareInterceptor cookieShareInterceptor = NetworkParams.getCookieShareInterceptor();
            if (cookieShareInterceptor != null) {
                List<String> shareCookie = cookieShareInterceptor.getShareCookie(this.mCookieMgr, this.mBackupCookieMgr, uri);
                if (!Lists.isEmpty(shareCookie)) {
                    ReqCookieSource reqCookieSource = ReqCookieSource.SHARE_INTERCEPTOR_MAIN;
                    if (shareCookie.remove(REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG)) {
                        reqCookieSource = ReqCookieSource.SHARE_INTERCEPTOR_BACKUP;
                    }
                    return getCookieResultMap(z, getCookieMap(shareCookie, map), reqCookieSource);
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        try {
            String cookie = this.mCookieMgr.getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                if (Logger.debug()) {
                    Logger.v(TAG, "send cookie: " + str + " " + cookie);
                }
                return getCookieResultMap(z, getCookieMap(Collections.singletonList(cookie), map), ReqCookieSource.MAIN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mBackupCookieMgr == null) {
            return Collections.emptyMap();
        }
        try {
            Map<String, List<String>> map3 = this.mBackupCookieMgr.get(uri, map == null ? new LinkedHashMap<>() : map);
            if (map3 != null && !map3.isEmpty()) {
                return getCookieResultMap(z, getCookieMap(map3.get(COOKIE), map), ReqCookieSource.BACKUP);
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
        return Collections.emptyMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void putV2(URI uri, Map<String, List<String>> map) {
        Iterator<String> it;
        URI uri2 = uri;
        if (uri2 == null || map == null || map.isEmpty()) {
            return;
        }
        List<String> headerListIgnoreCase = getHeaderListIgnoreCase(map, "Set-Cookie");
        if (USE_SS_COOKIE && Lists.isEmpty(headerListIgnoreCase)) {
            headerListIgnoreCase = getHeaderListIgnoreCase(map, SS_SET_COOKIE);
        }
        if (Lists.isEmpty(headerListIgnoreCase)) {
            return;
        }
        NetworkParams.CookieShareInterceptor cookieShareInterceptor = NetworkParams.getCookieShareInterceptor();
        List<String> shareCookieHostList = cookieShareInterceptor != null ? cookieShareInterceptor.getShareCookieHostList(uri.getHost()) : null;
        JSONObject createReportSetCookieLogV2 = createReportSetCookieLogV2();
        if (createReportSetCookieLogV2 != null) {
            putSetCookieLogV2(createReportSetCookieLogV2, "version", SettingVersionUtils.VERSION_V2);
            putSetCookieLogV2(createReportSetCookieLogV2, StreamTrafficObservable.STREAM_URL, uri.toString());
            putSetCookieLogV2(createReportSetCookieLogV2, "shareHostList", shareCookieHostList == null ? "" : shareCookieHostList.toString());
            putSetCookieLogV2(createReportSetCookieLogV2, "responseHeaders", map.toString());
            putSetCookieLogV2(createReportSetCookieLogV2, "setCookieList", headerListIgnoreCase.toString());
        }
        if (InsecureRequestControlConfig.isDisableShareInsecureCookie() && "http".equalsIgnoreCase(uri.getScheme())) {
            if (shareCookieHostList != null) {
                shareCookieHostList.clear();
            }
            putSetCookieLogV2(createReportSetCookieLogV2, "disable_share_insecure_cookie", DiskLruCache.VERSION);
        }
        try {
            NetworkParams.AppCookieStore appCookieStore = NetworkParams.getAppCookieStore();
            if (appCookieStore != null) {
                appCookieStore.put(uri2, map);
            }
        } catch (Throwable unused) {
        }
        if (this.mCookieMgr == null) {
            reportCookieSaveLog(createReportSetCookieLogV2, "mCookieMgr is null", createReportSetCookieLogV2 != null);
            return;
        }
        HashSet hashSet = new HashSet();
        List<String> list = map.get(WEBVIEW_COOKIE);
        String str = Lists.isEmpty(list) ? null : list.get(0);
        if (!TextUtils.isEmpty(str)) {
            try {
                syncWebViewCookieV2(str, headerListIgnoreCase, hashSet);
            } catch (Throwable unused2) {
            }
        }
        final HashMap hashMap = new HashMap();
        hashMap.put(uri2, headerListIgnoreCase);
        ArrayList<String> arrayList = new ArrayList();
        Iterator<String> it2 = headerListIgnoreCase.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            String next = it2.next();
            if (Logger.debug()) {
                Logger.v(TAG, "receive cookie: " + uri2 + ", set-cookie:" + next);
            }
            if (!TextUtils.isEmpty(next)) {
                String trim = next.toLowerCase().trim();
                if (trim.contains("sessionid=")) {
                    z = true;
                }
                if (!z && TTCookieConfig.isEnableFlushCookieForRegion() && (trim.contains(StoreRegionManager.STORE_COUNTRY_CODE_COOKIE) || trim.contains(StoreRegionManager.STORE_REGION_COOKIE))) {
                    z = true;
                }
                if (!TTCookieConfig.isDisableCookieShare(next) && TextUtils.isEmpty(str) && !Lists.isEmpty(shareCookieHostList) && isDomainMatch(uri2, next)) {
                    if (TTCookieConfig.isEnableCookieShareBatch()) {
                        arrayList.add(next);
                    } else {
                        for (String str2 : shareCookieHostList) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!uri.getHost().endsWith(str2)) {
                                    String replaceFirst = this.pattern.matcher(next).replaceFirst(str2);
                                    if (!TextUtils.isEmpty(replaceFirst)) {
                                        it = it2;
                                        try {
                                            URI create = URI.create(uri.getScheme() + "://" + str2 + "/");
                                            List list2 = (List) hashMap.get(create);
                                            if (list2 == null) {
                                                ArrayList arrayList2 = new ArrayList();
                                                arrayList2.add(replaceFirst);
                                                hashMap.put(create, arrayList2);
                                            } else {
                                                list2.add(replaceFirst);
                                            }
                                        } catch (Throwable unused3) {
                                        }
                                        it2 = it;
                                    }
                                    it = it2;
                                    it2 = it;
                                }
                            }
                        }
                    }
                }
                uri2 = uri;
                it2 = it2;
            }
        }
        if (!arrayList.isEmpty() && !Lists.isEmpty(shareCookieHostList)) {
            for (String str3 : shareCookieHostList) {
                if (!TextUtils.isEmpty(str3)) {
                    if (!uri.getHost().endsWith(str3)) {
                        try {
                            ArrayList arrayList3 = new ArrayList();
                            for (String str4 : arrayList) {
                                if (!TextUtils.isEmpty(str4)) {
                                    String replaceFirst2 = this.pattern.matcher(str4).replaceFirst(str3);
                                    if (!TextUtils.isEmpty(replaceFirst2)) {
                                        arrayList3.add(replaceFirst2);
                                    }
                                }
                            }
                            hashMap.put(URI.create(uri.getScheme() + "://" + str3 + "/"), arrayList3);
                        } catch (Throwable unused4) {
                        }
                    }
                    while (r1.hasNext()) {
                    }
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            putToCookieManager(((URI) entry.getKey()).toString(), (List<String>) entry.getValue(), hashSet);
        }
        NetworkParams.CookieUpdateListener cookieUpdateListener = NetworkParams.getCookieUpdateListener();
        if (!hashSet.isEmpty() && cookieUpdateListener != null) {
            try {
                cookieUpdateListener.onCookieBatchUpdate(hashSet);
            } catch (Throwable unused5) {
            }
        }
        try {
            flushCookiesIfPathMatched(uri.getPath(), z);
        } catch (Throwable unused6) {
        }
        if (this.mBackupCookieMgr == null) {
            reportCookieSaveLog(createReportSetCookieLogV2, "mAppCookieMgr is null", createReportSetCookieLogV2 != null);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                SSCookieHandler.this.m1292x7ee9d206(hashMap);
            }
        };
        if (TTCookieConfig.isCookieBackupAsyncSaveEnabled()) {
            TTExecutors.getNormalExecutor().submit(runnable);
        } else {
            runnable.run();
        }
        reportCookieSaveLog(createReportSetCookieLogV2, "last return", createReportSetCookieLogV2 != null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$putV2$0$com-bytedance-frameworks-baselib-network-http-impl-SSCookieHandler */
    public /* synthetic */ void m1292x7ee9d206(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            try {
                this.mBackupCookieMgr.put((URI) entry.getKey(), (List<String>) entry.getValue());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:58|(2:147|(3:151|152|144))(1:62)|63|64|65|66|67|68|(9:71|(1:73)|(1:81)|82|(1:84)(5:88|89|90|(6:99|(6:102|103|104|(1:130)(4:106|107|108|(2:110|111)(5:113|(8:115|116|117|118|119|120|121|122)|127|121|122))|112|100)|133|134|(2:136|137)(1:138)|87)|92)|85|86|87|69)|141|142|143|144|56) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0305 A[Catch: all -> 0x0357, TryCatch #10 {all -> 0x0357, blocks: (B:193:0x02ee, B:202:0x02f2, B:203:0x02ff, B:205:0x0305, B:208:0x0312, B:211:0x0319, B:216:0x0329, B:225:0x032d), top: B:201:0x02f2 }] */
    /* JADX WARN: Type inference failed for: r27v0, types: [com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler] */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [int] */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.net.CookieManager, java.net.CookieHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void put(URI uri, Map<String, List<String>> map) throws IOException {
        String obj;
        String[] strArr;
        boolean z;
        JSONObject jSONObject;
        LinkedHashMap linkedHashMap;
        String str;
        String[] strArr2;
        List<String> list;
        String str2;
        JSONObject jSONObject2;
        String str3;
        boolean z2;
        String str4;
        JSONObject jSONObject3;
        String str5;
        JSONObject jSONObject4;
        Iterator<String> it;
        if (TTCookieConfig.isCookieSaveV2Enabled()) {
            putV2(uri, map);
            return;
        }
        NetworkParams.CookieShareInterceptor cookieShareInterceptor = NetworkParams.getCookieShareInterceptor();
        List<String> shareCookieHostList = (cookieShareInterceptor == null || uri == null) ? null : cookieShareInterceptor.getShareCookieHostList(uri.getHost());
        JSONObject jSONObject5 = new JSONObject();
        String str6 = "Set-Cookie";
        boolean z3 = map != null && (map.containsKey("Set-Cookie") || map.containsKey(SS_SET_COOKIE));
        String str7 = "";
        if (shareCookieHostList == null) {
            obj = "";
        } else {
            try {
                obj = shareCookieHostList.toString();
            } catch (JSONException unused) {
            }
        }
        jSONObject5.put("shareHostList", obj);
        if (z3) {
            jSONObject5.put("responseHeaders", map.toString());
        }
        if (uri != null) {
            str7 = uri.toString();
        }
        jSONObject5.put(StreamTrafficObservable.STREAM_URL, str7);
        if (uri != null && "http".equalsIgnoreCase(uri.getScheme()) && InsecureRequestControlConfig.isDisableShareInsecureCookie()) {
            if (shareCookieHostList != null) {
                shareCookieHostList.clear();
            }
            jSONObject5.put("disable_share_insecure_cookie", 1);
        }
        try {
            NetworkParams.AppCookieStore appCookieStore = NetworkParams.getAppCookieStore();
            if (appCookieStore != null) {
                appCookieStore.put(uri, map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str8 = WEBVIEW_COOKIE;
        boolean z4 = map != null && map.containsKey(WEBVIEW_COOKIE);
        if (uri == null || map == null || this.mCookieMgr == null) {
            reportCookieSaveLog(jSONObject5, "uri responseHeaders or mCookieMgr is null", z3);
            return;
        }
        HashSet hashSet = new HashSet();
        String uri2 = uri.toString();
        if (USE_SS_COOKIE) {
            strArr = new String[]{SS_SET_COOKIE, "Set-Cookie"};
        } else {
            strArr = new String[]{"Set-Cookie"};
        }
        int length = strArr.length;
        ?? r9 = 0;
        boolean z5 = false;
        boolean z6 = false;
        while (r9 < length) {
            int i = length;
            String str9 = strArr[r9];
            List<String> list2 = map.get(str9);
            if (list2 == null || list2.isEmpty()) {
                strArr2 = strArr;
                list = map.get(str9.toLowerCase());
                if (list == null || list.isEmpty()) {
                    str2 = str8;
                    jSONObject2 = jSONObject5;
                    str3 = str6;
                    z2 = z3;
                    str8 = str2;
                    length = i;
                    strArr = strArr2;
                    z3 = z2;
                    str6 = str3;
                    jSONObject5 = jSONObject2;
                    r9++;
                }
            } else {
                strArr2 = strArr;
                list = list2;
            }
            z2 = z3;
            str3 = str6;
            jSONObject5.put("cookieMgrList", list.toString());
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                Iterator<String> it3 = it2;
                if (next.toLowerCase().trim().contains("sessionid=")) {
                    z5 = true;
                }
                if (!z5 && TTCookieConfig.isEnableFlushCookieForRegion() && (next.toLowerCase().trim().contains(StoreRegionManager.STORE_COUNTRY_CODE_COOKIE) || next.toLowerCase().trim().contains(StoreRegionManager.STORE_REGION_COOKIE))) {
                    z5 = true;
                }
                putToCookieManager(uri2, next, hashSet);
                if (z4) {
                    syncWebviewCookie(map.get(str8).get(0), next, hashSet);
                } else if (!TTCookieConfig.isDisableCookieShare(next) && (!Lists.isEmpty(shareCookieHostList)) && isDomainMatch(uri, next)) {
                    Iterator<String> it4 = shareCookieHostList.iterator();
                    while (it4.hasNext()) {
                        String next2 = it4.next();
                        try {
                        } catch (Throwable unused2) {
                            str5 = str8;
                        }
                        if (!TextUtils.isEmpty(next2)) {
                            str5 = str8;
                            if (uri.getHost().endsWith(next2)) {
                                str8 = str5;
                            } else {
                                String replaceFirst = this.pattern.matcher(next).replaceFirst(next2);
                                if (!TextUtils.isEmpty(replaceFirst)) {
                                    it = it4;
                                    try {
                                        jSONObject4 = jSONObject5;
                                        try {
                                            putToCookieManager(uri.getScheme() + "://" + next2 + "/", replaceFirst, hashSet);
                                        } catch (Throwable unused3) {
                                        }
                                    } catch (Throwable unused4) {
                                        jSONObject4 = jSONObject5;
                                    }
                                    str8 = str5;
                                    it4 = it;
                                    jSONObject5 = jSONObject4;
                                }
                                jSONObject4 = jSONObject5;
                                it = it4;
                                str8 = str5;
                                it4 = it;
                                jSONObject5 = jSONObject4;
                            }
                        }
                    }
                    str4 = str8;
                    jSONObject3 = jSONObject5;
                    if (Logger.debug()) {
                        Logger.v(TAG, "receive cookie: " + uri2 + " " + str9 + ": " + next);
                    }
                    it2 = it3;
                    str8 = str4;
                    jSONObject5 = jSONObject3;
                }
                str4 = str8;
                jSONObject3 = jSONObject5;
                it2 = it3;
                str8 = str4;
                jSONObject5 = jSONObject3;
            }
            str2 = str8;
            jSONObject2 = jSONObject5;
            z6 = true;
            str8 = str2;
            length = i;
            strArr = strArr2;
            z3 = z2;
            str6 = str3;
            jSONObject5 = jSONObject2;
            r9++;
        }
        JSONObject jSONObject6 = jSONObject5;
        String str10 = str6;
        boolean z7 = z3;
        NetworkParams.CookieUpdateListener cookieUpdateListener = NetworkParams.getCookieUpdateListener();
        if (!hashSet.isEmpty() && cookieUpdateListener != null) {
            try {
                cookieUpdateListener.onCookieBatchUpdate(hashSet);
            } catch (Throwable unused5) {
            }
        }
        if (z6) {
            try {
                flushCookiesIfPathMatched(uri.getPath(), z5);
            } catch (Throwable unused6) {
            }
        }
        if (uri == null || map == null || this.mBackupCookieMgr == null) {
            reportCookieSaveLog(jSONObject6, "uri responseHeaders or mAppCookieMgr is null", z7);
            return;
        }
        try {
            linkedHashMap = new LinkedHashMap();
            if (USE_SS_COOKIE && map.containsKey(SS_SET_COOKIE)) {
                str = str10;
                if (!map.containsKey(str)) {
                    linkedHashMap.put(str, map.get(SS_SET_COOKIE));
                }
            } else {
                str = str10;
            }
            linkedHashMap.putAll(map);
            this.mBackupCookieMgr.put(uri, linkedHashMap);
        } catch (Throwable th2) {
            th = th2;
            z = z7;
            jSONObject = jSONObject6;
        }
        if ((!Lists.isEmpty(shareCookieHostList)) && !z4) {
            for (String str11 : shareCookieHostList) {
                try {
                } catch (Throwable unused7) {
                    z3 = z7;
                    r9 = jSONObject6;
                }
                if (!TextUtils.isEmpty(str11) && !uri.getHost().endsWith(str11)) {
                    List<String> list3 = map.get(str);
                    if (list3 == null) {
                        z3 = z7;
                        r9 = jSONObject6;
                        reportCookieSaveLog(r9, "cookieList is null", z3);
                        return;
                    }
                    try {
                        z3 = z7;
                        r9 = jSONObject6;
                        LinkedList linkedList = new LinkedList();
                        for (String str12 : list3) {
                            if (!TTCookieConfig.isDisableCookieShare(str12)) {
                                if (isDomainMatch(uri, str12)) {
                                    try {
                                        String replaceFirst2 = this.pattern.matcher(str12).replaceFirst(str11);
                                        if (!TextUtils.isEmpty(replaceFirst2)) {
                                            linkedList.add(replaceFirst2);
                                        }
                                    } catch (IllegalArgumentException unused8) {
                                    }
                                }
                                while (r8.hasNext()) {
                                }
                            }
                        }
                        linkedHashMap.put(str, linkedList);
                        this.mBackupCookieMgr.put(URI.create(uri.getScheme() + "://" + str11), linkedHashMap);
                    } catch (Throwable unused9) {
                    }
                    jSONObject6 = r9;
                    z7 = z3;
                    jSONObject6 = r9;
                    z7 = z3;
                }
            }
            z = z7;
            jSONObject = jSONObject6;
            reportCookieSaveLog(jSONObject, "last return", z);
        }
        z = z7;
        jSONObject = jSONObject6;
        try {
            reportCookieSaveLog(jSONObject, "isInShareCookieList is false", z);
        } catch (Throwable th3) {
            th = th3;
            th.printStackTrace();
            reportCookieSaveLog(jSONObject, "last return", z);
        }
    }

    private void reportCookieSaveLog(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || this.mCookieEventHandler == null || !z) {
            return;
        }
        try {
            jSONObject.put("return", str);
        } catch (JSONException unused) {
        }
        this.mCookieEventHandler.onEvent(event, "put", jSONObject);
    }

    private JSONObject createReportSetCookieLogV2() {
        ICookieEventHandler iCookieEventHandler = this.mCookieEventHandler;
        if (iCookieEventHandler == null || !iCookieEventHandler.enableSetCookieLog()) {
            return null;
        }
        return new JSONObject();
    }

    private static void putSetCookieLogV2(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                jSONObject.put(str, str2);
            } catch (JSONException unused) {
            }
        }
    }

    private void putToCookieManager(String str, List<String> list, Set<String> set) {
        if (TextUtils.isEmpty(str) || CollectionUtils.isEmpty(list)) {
            return;
        }
        set.add(str);
        boolean z = false;
        if (TTCookieConfig.isCookieBatchSaveEnabled()) {
            try {
                Method declaredMethod = this.mCookieMgr.getClass().getDeclaredMethod("setCookieList", String.class, List.class);
                declaredMethod.setAccessible(true);
                z = ((Boolean) declaredMethod.invoke(this.mCookieMgr, str, list)).booleanValue();
            } catch (Throwable th) {
                Logger.d(TAG, "Batch save cookie failed:" + th);
            }
        }
        NetworkParams.CookieUpdateListener cookieUpdateListener = NetworkParams.getCookieUpdateListener();
        if (z && cookieUpdateListener == null) {
            return;
        }
        for (String str2 : list) {
            if (!z) {
                this.mCookieMgr.setCookie(str, str2);
            }
            if (cookieUpdateListener != null) {
                try {
                    cookieUpdateListener.onCookieUpdate(str, str2);
                } catch (Throwable unused) {
                }
            }
        }
    }

    private void putToCookieManager(String str, String str2, Set<String> set) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        set.add(str);
        this.mCookieMgr.setCookie(str, str2);
        try {
            NetworkParams.CookieUpdateListener cookieUpdateListener = NetworkParams.getCookieUpdateListener();
            if (cookieUpdateListener != null) {
                cookieUpdateListener.onCookieUpdate(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean isDomainMatch(URI uri, String str) {
        if (uri != null && !TextUtils.isEmpty(str)) {
            try {
                String lowerCase = uri.getHost().toLowerCase();
                Matcher matcher = this.pattern.matcher(str);
                String lowerCase2 = matcher.find() ? matcher.group().toLowerCase() : "";
                if (TextUtils.isEmpty(lowerCase2)) {
                    return false;
                }
                return lowerCase.endsWith(lowerCase2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    @Deprecated
    private void syncWebviewCookie(String str, String str2, Set<String> set) {
        if (this.mCookieMgr == null || TextUtils.isEmpty(str)) {
            return;
        }
        String shouldSyncWebviewCookie = shouldSyncWebviewCookie(str, str2);
        if (TextUtils.isEmpty(shouldSyncWebviewCookie)) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, " Sync cookies for WebView request, original url: " + str);
        }
        putToCookieManager(str, shouldSyncWebviewCookie, set);
    }

    private void syncWebViewCookieV2(String str, List<String> list, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String shouldSyncWebviewCookie = shouldSyncWebviewCookie(str, it.next());
            if (!TextUtils.isEmpty(shouldSyncWebviewCookie)) {
                arrayList.add(shouldSyncWebviewCookie);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "Sync cookies list for WebView request, original url: " + str);
        }
        putToCookieManager(str, arrayList, set);
    }

    private String shouldSyncWebviewCookie(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Matcher matcher = this.pattern.matcher(str2);
            String lowerCase = matcher.find() ? matcher.group().toLowerCase() : null;
            if (TextUtils.isEmpty(lowerCase)) {
                return str2;
            }
            if (checkDomainLevel(lowerCase)) {
                return matcher.replaceFirst(str);
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean checkDomainLevel(String str) {
        if (str.length() < 2) {
            return false;
        }
        int i = 0;
        for (int i2 = 1; i2 < str.length() && (str.charAt(i2) != '.' || (i = i + 1) < 2); i2++) {
        }
        return i >= 2;
    }
}
