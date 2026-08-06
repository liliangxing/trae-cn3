package com.bytedance.crash.upload;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Global;
import com.bytedance.crash.anr.AnrManager;
import com.bytedance.crash.anr.AnrSummary;
import com.bytedance.crash.config.LogPathConfig;
import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.crash.CrashManager;
import com.bytedance.crash.crash.CustomJavaHandler;
import com.bytedance.crash.crash.JavaCrashHandler;
import com.bytedance.crash.crash.JavaCrashSummary;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.dart.DartCrash;
import com.bytedance.crash.event.EnsureDeliverer;
import com.bytedance.crash.game.GameCrash;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.resource.ResourceMonitor;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.util.App;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.FileUtils;
import com.bytedance.crash.util.JSONUtils;
import com.bytedance.crash.util.NpthLog;
import java.io.File;
import java.io.FilenameFilter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class NetworkDisasterManager {
    static final String KEY_ALOG_QUOTA = "Alog_quota";
    static final String KEY_DELAY = "delay";
    static final String KEY_MESSAGE = "message";
    static final String KEY_QUOTA_STATE = "quota_status";
    static final String KEY_REDIRECT = "redirect";
    static final long MAX_RETREAT_TIME = 1800000;
    static final String MSG_DROP_ALL_DATA = "drop all data";
    static final String MSG_DROP_DATA = "drop data";
    static final String MSG_IGNORE_DATA = "ignore data";
    static final String MSG_LONG_ESCAPE = "long escape";
    static final String MSG_SUCCESS = "success";
    static final int TS_DELAY = 1;
    static final int TS_LONG_ESCAPE = 3;
    static final int TS_LONG_ESCAPE_DROP = 4;
    static final int TS_LONG_ESCAPE_DROP_ALL = 5;
    static final int TS_NORMAL = 0;
    static final int TS_NO_UPDATE = -2;
    static final int TS_UNKNOWN_ERROR = -1;
    private static boolean disableNetDisaster;
    private static NetworkDisasterManager obj;
    private final File mFile;
    private File mFileLock;
    private FileObserver mFileObserver;
    private final ConcurrentHashMap<String, NetState> mNetStateMap;
    private boolean mbQuotaPathError;
    private volatile boolean mbUpdatingFile;

    private long longBackOff(int i) {
        if (i <= 0) {
            i = 0;
        }
        if (i <= 6) {
            return i * 5 * 60 * 1000;
        }
        return 1800000L;
    }

    public static void init() {
        NetworkDisasterManager networkDisasterManager = get();
        if (networkDisasterManager != null) {
            networkDisasterManager.syncNetworkStateFromFile();
            if (networkDisasterManager.hasDisasterItem()) {
                networkDisasterManager.checkDisableDisaster();
                networkDisasterManager.postCheckNetworkRestore();
            }
            networkDisasterManager.startObserver();
        }
    }

    public static void setDisableNetDisaster(boolean z) {
        disableNetDisaster = z;
    }

    private void checkDisableDisaster() {
        if (disableNetDisaster) {
            NpthLog.m233i("Disaster:disable network disaster!!!");
            restoreAllNetworkState();
        }
    }

    private static NetworkDisasterManager get() {
        synchronized (NetworkDisasterManager.class) {
            if (obj == null) {
                obj = new NetworkDisasterManager();
            }
        }
        return obj;
    }

    public static String getNetKeyId(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : str + "_" + str2;
    }

    private NetworkDisasterManager() {
        NpthLog.m233i("Disaster:init");
        File createDirectory = FileSystemUtils.createDirectory(new File(Global.getRootDirectory(), "network_disaster"));
        File file = new File(createDirectory, "networkStatef");
        this.mFile = file;
        this.mNetStateMap = new ConcurrentHashMap<>();
        this.mbQuotaPathError = false;
        this.mbUpdatingFile = false;
        try {
            this.mFileObserver = new FileObserver(file.getAbsolutePath(), 1032) { // from class: com.bytedance.crash.upload.NetworkDisasterManager.1
                @Override // android.os.FileObserver
                public void onEvent(int i, String str) {
                    NpthLog.m233i("disaster: FileObserver event=" + i);
                    if ((i & 8) == 0 && (i & 1024) == 0) {
                        return;
                    }
                    if (NetworkDisasterManager.this.mbUpdatingFile) {
                        NpthLog.m233i("disaster: current process updating file");
                        NetworkDisasterManager.this.mbUpdatingFile = false;
                    } else {
                        DefaultWorkThread.postDelayed(new Runnable() { // from class: com.bytedance.crash.upload.NetworkDisasterManager.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                NetworkDisasterManager.this.syncNetworkStateByObserver();
                            }
                        }, 100L);
                    }
                }
            };
        } catch (Throwable th) {
            NpthLog.m232e(th);
        }
        this.mFileLock = new File(createDirectory, "disasterLock");
    }

    private void startObserver() {
        FileSystemUtils.createNewFile(this.mFile);
        FileObserver fileObserver = this.mFileObserver;
        if (fileObserver != null) {
            fileObserver.startWatching();
        }
    }

    private boolean hasDisasterItem() {
        return this.mNetStateMap.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void syncNetworkStateByObserver() {
        syncNetworkStateFromFile();
    }

    private void writeToFile(JSONArray jSONArray) {
        int lockFile;
        NpthLog.m233i("disaster: writeToFile");
        boolean z = true;
        int i = 0;
        while (z && i < 20) {
            i++;
            try {
                lockFile = lockFile();
            } catch (Throwable unused) {
            }
            if (lockFile == -1) {
                NpthLog.m233i("disaster:write did not got flock, sleep 50ms and retry");
                Thread.sleep(50L);
                z = true;
            } else {
                NpthLog.m233i("disaster:write got flock");
                this.mbUpdatingFile = true;
                FileUtils.safeWriteFile(this.mFile, jSONArray, false);
                unlockFile(lockFile);
                NpthLog.m233i("disaster:write unlock flock");
                boolean z2 = true;
                int i2 = 0;
                do {
                    if (this.mbUpdatingFile) {
                        NpthLog.m233i("disaster:waiting 20ms");
                        Thread.sleep(20L);
                        i2++;
                    } else {
                        NpthLog.m233i("disaster: breakout");
                        z2 = false;
                    }
                    if (!z2) {
                        break;
                    }
                } while (i2 < 50);
                z = false;
            }
        }
        this.mbUpdatingFile = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[EDGE_INSN: B:15:0x0037->B:12:0x0037 BREAK  A[LOOP:0: B:2:0x0009->B:14:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String readFromFile() {
        int lockFile;
        NpthLog.m233i("disaster: readFromFile");
        String str = "";
        int i = 0;
        do {
            boolean z = true;
            i++;
            try {
                lockFile = lockFile();
            } catch (Throwable unused) {
            }
            if (lockFile > 0) {
                NpthLog.m233i("disaster: read got flock");
                str = FileUtils.readFile(this.mFile);
                unlockFile(lockFile);
                NpthLog.m233i("disaster: read unlock flock");
                z = false;
                if (z) {
                    break;
                }
            } else {
                NpthLog.m233i("disaster:read did not got flock, sleep 500ms and retry");
                Thread.sleep(50L);
                if (z) {
                }
            }
        } while (i < 10);
        return str;
    }

    private void syncNetworkStateFromFile() {
        try {
            if (this.mFile.exists() && this.mFile.length() != 0) {
                JSONArray jSONArray = new JSONArray(readFromFile());
                NpthLog.m233i("Disaster:syncNetworkStateFromFile mJsonArray=" + jSONArray.toString());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String next = jSONObject.keys().next();
                    this.mNetStateMap.put(next, new NetState(jSONObject.getJSONObject(next)));
                    notifyDisasterState();
                }
                return;
            }
            this.mNetStateMap.clear();
            notifyDisasterState();
        } catch (Throwable th) {
            this.mNetStateMap.clear();
            notifyDisasterState();
            writeToFile(null);
            NpthLog.m232e(th);
        }
    }

    private void notifyDisasterState() {
        if (checkDropData(null, NetConfig.PATH_JAVA_CRASH)) {
            AnrManager.setDropData(true);
            JavaCrashHandler.setDropData(true);
            CustomJavaHandler.setDropData(true);
            GameCrash.setDropData(true);
            DartCrash.setDropData(true);
        } else {
            AnrManager.setDropData(false);
            CustomJavaHandler.setDropData(false);
            GameCrash.setDropData(false);
            DartCrash.setDropData(false);
            JavaCrashHandler.setDropData(false);
        }
        EnsureDeliverer.setDropData(checkDropData(null, "/monitor/collect/c/exception"));
        NativeBridge.setDropDataState(checkDropData(null, NetConfig.PATH_NATIVE_CRASH) ? 1 : 0);
    }

    private void syncNetworkStateToFile() {
        synchronized (this.mNetStateMap) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (Map.Entry<String, NetState> entry : this.mNetStateMap.entrySet()) {
                    if (entry != null) {
                        jSONArray.put(entry.getValue().toJson());
                    }
                }
                if (jSONArray.length() <= 0) {
                    this.mNetStateMap.clear();
                    notifyDisasterState();
                    writeToFile(null);
                    NpthLog.m233i("Disaster:syncNetworkStateToFile delete strategy file");
                } else {
                    writeToFile(jSONArray);
                    NpthLog.m233i("Disaster:syncNetworkStateToFile mJsonArray=" + jSONArray.toString());
                }
            } catch (Throwable unused) {
                this.mNetStateMap.clear();
                notifyDisasterState();
                writeToFile(null);
            }
        }
    }

    public static boolean checkDropData(String str, String str2) {
        NetworkDisasterManager networkDisasterManager = get();
        if (networkDisasterManager == null) {
            return false;
        }
        return networkDisasterManager.checkDropDataInner(str, str2);
    }

    private boolean checkDropDataInner(String str, String str2) {
        if (!hasDisasterItem() || disableNetDisaster) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = MonitorManager.getAppMonitor().getAppId();
            }
            int networkState = getNetworkState(getNetKeyId(str, str2));
            return networkState == 4 || networkState == 5;
        } catch (Throwable th) {
            NpthLog.m232e(th);
            return false;
        }
    }

    public static long checkPermission(String str, URL url) {
        NetworkDisasterManager networkDisasterManager = get();
        if (networkDisasterManager == null) {
            return 0L;
        }
        return networkDisasterManager.checkPermissionInner(str, url);
    }

    private long checkPermissionInner(String str, URL url) {
        long j = 0;
        if (hasDisasterItem() && !disableNetDisaster) {
            NpthLog.m233i("Disaster:checkPermission url=" + url);
            try {
                if (TextUtils.isEmpty(str)) {
                    str = getQueryParams(url, "aid");
                }
            } catch (Throwable th) {
                NpthLog.m232e(th);
            }
            if (TextUtils.isEmpty(str)) {
                NpthLog.m233i("Disaster:checkPermission aid==null");
                return -1L;
            }
            NetState netState = this.mNetStateMap.get(getNetKeyId(str, url.getPath()));
            if (netState == null) {
                NpthLog.m233i("Disaster:checkPermission normal");
                return 0L;
            }
            j = getRetreatTimeout(netState);
            NpthLog.m233i("Disaster:checkPermission return timeout=" + j);
        }
        return j;
    }

    public static int updateNetworkState(URL url, Response response) {
        NetworkDisasterManager networkDisasterManager = get();
        if (networkDisasterManager == null || disableNetDisaster) {
            return 0;
        }
        if (url == null || response == null) {
            NpthLog.m235w("Disaster:updateNetworkState param is invalid");
            return -1;
        }
        NpthLog.m235w("Disaster:updateNetworkState url=" + url);
        try {
            String queryParams = getQueryParams(url, "aid");
            String path = url.getPath();
            if (TextUtils.isEmpty(queryParams)) {
                return -1;
            }
            return networkDisasterManager.updateNetworkStateInner(queryParams, path, response);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00fb A[Catch: all -> 0x0152, TryCatch #0 {all -> 0x0152, blocks: (B:7:0x0017, B:9:0x0021, B:12:0x0029, B:16:0x003e, B:19:0x0083, B:21:0x0090, B:23:0x00b2, B:26:0x00b9, B:29:0x00c1, B:32:0x00cb, B:35:0x00f2, B:37:0x00fb, B:43:0x0121, B:45:0x0129, B:47:0x0138, B:51:0x00d3, B:54:0x00dd, B:57:0x00e7), top: B:6:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int updateNetworkStateInner(String str, String str2, Response response) {
        long j;
        int i;
        int i2;
        int i3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || response == null) {
            NpthLog.m235w("Disaster:updateNetworkStateInner param is invalid");
            return -1;
        }
        try {
            String netKeyId = getNetKeyId(str, str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                int i4 = 0;
                if (str2.equals(new URL(NetConfig.getApmConfigUrl()).getPath())) {
                    return 0;
                }
                NpthLog.m235w("Disaster:updateNetworkStateInner keyId:" + netKeyId + " rsp:" + response.toString());
                int networkState = getNetworkState(netKeyId);
                int serverErrorCode = response.serverErrorCode();
                JSONObject serverJson = response.getServerJson();
                boolean equals = str2.equals(new URL(NetConfig.getQuotaStateUrl()).getPath());
                int i5 = 3;
                if (serverErrorCode != 200) {
                    if (500 > serverErrorCode || serverErrorCode > 600) {
                        j = 0;
                        i5 = -2;
                    } else {
                        j = 0;
                    }
                    i = 0;
                } else {
                    if (serverJson == null) {
                        setStrategy(str, str2, 0, 0L, 0);
                        return 0;
                    }
                    String optString = serverJson.optString("message");
                    String optString2 = serverJson.optString("redirect");
                    j = serverJson.optLong("delay");
                    String optString3 = serverJson.optString(KEY_ALOG_QUOTA);
                    String optString4 = serverJson.optString(KEY_QUOTA_STATE);
                    if (!equals && !TextUtils.isEmpty(optString4)) {
                        optString = optString4;
                    }
                    if (!TextUtils.isEmpty(optString) && !"success".equals(optString)) {
                        if ("long escape".equals(optString)) {
                            i2 = 3;
                        } else {
                            if (!MSG_IGNORE_DATA.equals(optString)) {
                                if ("drop data".equals(optString)) {
                                    i2 = 4;
                                } else if ("drop all data".equals(optString)) {
                                    i2 = 5;
                                }
                            }
                            i2 = -2;
                        }
                        TextUtils.isEmpty(optString2);
                        if (!TextUtils.isEmpty(optString3)) {
                            i3 = 0;
                            i4 = 0;
                        } else if ("long escape".equals(optString3)) {
                            i3 = 1;
                            i4 = 3;
                        } else {
                            i3 = 1;
                        }
                        i5 = i2;
                        i = i4;
                        i4 = i3;
                    }
                    i2 = 0;
                    TextUtils.isEmpty(optString2);
                    if (!TextUtils.isEmpty(optString3)) {
                    }
                    i5 = i2;
                    i = i4;
                    i4 = i3;
                }
                if (i5 == -2) {
                    if (equals) {
                        NpthLog.m235w("Disaster:quota path error!!!");
                        this.mbQuotaPathError = true;
                    }
                    return networkState;
                }
                setStrategy(str, str2, i5, j, i);
                if (i4 != 0) {
                    setStrategy(str, new URL(NetConfig.getAlogUploadUrl()).getPath(), i, j, i);
                }
                return i5;
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    private void setStrategy(String str, String str2, int i, long j, int i2) {
        String netKeyId = getNetKeyId(str, str2);
        if (TextUtils.isEmpty(netKeyId)) {
            return;
        }
        synchronized (this) {
            if (i == 0) {
                if (this.mNetStateMap.containsKey(netKeyId)) {
                    restoreNetworkState(netKeyId);
                    reportEvent(str, str2, true, -1);
                }
            } else {
                NetState netState = this.mNetStateMap.get(netKeyId);
                if (netState == null) {
                    reportEvent(str, str2, false, i);
                    netState = new NetState(str, str2);
                }
                netState.setStrategy(i);
                netState.setAlogStrategy(i2);
                if (i == 1) {
                    netState.setDelayTime(j);
                }
                if (i == 5) {
                    clearCacheLog(str2);
                }
                netState.setUpdateTime(System.currentTimeMillis());
                this.mNetStateMap.put(netKeyId, netState);
                notifyDisasterState();
                syncNetworkStateToFile();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void clearCacheLog(String str) {
        int lockFile;
        NpthLog.m233i("disaster: clearCacheLog");
        int i = 0;
        do {
            boolean z = true;
            i++;
            try {
                lockFile = lockFile();
            } catch (Throwable unused) {
            }
            if (lockFile > 0) {
                NpthLog.m233i("disaster: got flock");
                deleteCrashLog(str);
                unlockFile(lockFile);
                z = false;
                if (z) {
                    return;
                }
            } else {
                NpthLog.m233i("disaster: did not got flock, sleep 500ms and retry");
                Thread.sleep(50L);
                if (z) {
                }
            }
        } while (i < 10);
    }

    private void syncNetworkStateByNet(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            NpthLog.m235w("Disaster:syncNetworkStateByNet aid or path is null");
            return;
        }
        NpthLog.m233i("Disaster:syncNetworkStateByNet path=" + str2);
        Response syncNetworkStateByNetInner = syncNetworkStateByNetInner(str, str2);
        NpthLog.m233i("Disaster:syncNetworkStateByNet rsp=" + syncNetworkStateByNetInner.toString());
        updateNetworkStateInner(str, str2, syncNetworkStateByNetInner);
        if (this.mbQuotaPathError || syncNetworkStateByNetInner.errorCode() != 0) {
            this.mbQuotaPathError = false;
            restoreAllNetworkState();
            NpthLog.m233i("disaster:syncNetworkStateByNet, quota path error");
        }
    }

    private Response syncNetworkStateByNetInner(String str, String str2) {
        String quotaStateUrl = NetConfig.getQuotaStateUrl();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aid", Integer.valueOf(str));
            jSONObject.put("os", "Android");
            jSONObject.put("path", str2);
            return CrashUploader.getQuotaState(quotaStateUrl, jSONObject.toString());
        } catch (JSONException e) {
            NpthLog.m232e(e);
            return new Response(Constants.UPLOAD_HTTP_ERROR);
        }
    }

    private void postCheckNetworkRestore() {
        if (!App.isMainProcess(Global.getContext())) {
            NpthLog.m233i("disaster:not main process");
        } else {
            DefaultWorkThread.post(new Runnable() { // from class: com.bytedance.crash.upload.NetworkDisasterManager.2
                @Override // java.lang.Runnable
                public void run() {
                    NetworkDisasterManager.this.checkNetworkRestore();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNetworkRestore() {
        NetState value;
        NpthLog.m233i("disaster:checkNetworkRestore");
        try {
            if (this.mNetStateMap.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, NetState> entry : this.mNetStateMap.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null && getRetreatTimeout(value) <= 0) {
                    hashMap.put(value.getAid(), value.getPath());
                }
            }
            for (Map.Entry entry2 : hashMap.entrySet()) {
                syncNetworkStateByNet((String) entry2.getKey(), (String) entry2.getValue());
            }
        } catch (Throwable unused) {
        }
    }

    private void restoreNetworkState(String str) {
        synchronized (this) {
            try {
                if (this.mNetStateMap.containsKey(str)) {
                    this.mNetStateMap.remove(str);
                    notifyDisasterState();
                    syncNetworkStateToFile();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void restoreAllNetworkState() {
        try {
            synchronized (this) {
                if (this.mNetStateMap.size() > 0) {
                    this.mNetStateMap.clear();
                    notifyDisasterState();
                    syncNetworkStateToFile();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private int lockFile() {
        try {
            this.mFileLock.createNewFile();
            return NativeBridge.fLock(this.mFileLock.getAbsolutePath());
        } catch (Throwable unused) {
            return -1;
        }
    }

    private void unlockFile(int i) {
        if (i > 0) {
            NativeBridge.unFlock(i);
        }
    }

    private int getNetworkState(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            NetState netState = this.mNetStateMap.get(str);
            if (netState == null) {
                return 0;
            }
            return netState.getStrategy();
        }
    }

    private long getRetreatTime(NetState netState) {
        if (netState == null) {
            return 0L;
        }
        int strategy = netState.getStrategy();
        if (strategy == 1) {
            return netState.getDelayTime();
        }
        if (strategy == 3 || strategy == 4 || strategy == 5) {
            return longBackOff(netState.getRetreatCount());
        }
        return 0L;
    }

    private void adjustUpdateTime(long j) {
        synchronized (this) {
            for (Map.Entry<String, NetState> entry : this.mNetStateMap.entrySet()) {
                if (entry != null) {
                    entry.getValue().setUpdateTime(j);
                }
            }
        }
    }

    private long getRetreatTimeout(NetState netState) {
        long currentTimeMillis = System.currentTimeMillis();
        long updateTime = netState.getUpdateTime();
        long retreatTime = getRetreatTime(netState);
        if (retreatTime == 0) {
            return 0L;
        }
        if (currentTimeMillis < updateTime) {
            adjustUpdateTime(currentTimeMillis);
            syncNetworkStateToFile();
            updateTime = currentTimeMillis;
        }
        long j = currentTimeMillis - updateTime;
        if (j < retreatTime) {
            return retreatTime - j;
        }
        return 0L;
    }

    private static String getQueryParams(URL url, String str) {
        String str2 = "";
        try {
            String query = url.getQuery();
            if (query != null && query.contains("&") && query.contains("=")) {
                for (String str3 : query.split("&")) {
                    String[] split = str3.split("=");
                    if (split != null && split.length >= 2) {
                        try {
                            if (URLDecoder.decode(split[0], UrlUtils.UTF_8).equals(str)) {
                                str2 = URLDecoder.decode(split[1], UrlUtils.UTF_8);
                                NpthLog.m233i("getQueryParams value = " + str2);
                                break;
                            }
                            continue;
                        } catch (UnsupportedEncodingException e) {
                            NpthLog.m232e(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            NpthLog.m232e(th);
        }
        return str2;
    }

    private static void reportEvent(String str, String str2, boolean z, int i) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !str.equals("2010")) {
                String netKeyId = getNetKeyId(str, str2);
                String curProcessName = App.getCurProcessName(Global.getContext());
                JSONObject jSONObject = new JSONObject();
                JSONUtils.put(jSONObject, "path", netKeyId);
                if (z) {
                    JSONUtils.put(jSONObject, "state", "exit");
                } else {
                    JSONUtils.put(jSONObject, "state", "enter");
                }
                JSONUtils.put(jSONObject, "strategy", String.valueOf(i));
                JSONUtils.put(jSONObject, "pname", curProcessName);
                NpthLog.m233i("disaster:reportEvent aid=" + str + " path=" + str2 + " isRestore" + z + " strategy=" + i);
            }
        } catch (Throwable unused) {
        }
    }

    public static void deleteCrashLog(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            NpthLog.m235w("deleteCrashLog:" + str);
            if (new URL(NetConfig.getJavaCrashUploadUrl()).getPath().equals(str)) {
                dropCrashLog(CrashType.JAVA);
                dropCrashLog(CrashType.ANR);
            } else {
                if (new URL(NetConfig.getLaunchCrashUploadUrl()).getPath().equals(str)) {
                    ResourceMonitor.deleteCrashLog();
                    File coreDumpPath = LogPathConfig.getCoreDumpPath();
                    if (coreDumpPath != null) {
                        FileUtils.deleteFile(coreDumpPath);
                    }
                    dropCrashLog(CrashType.LAUNCH);
                    return;
                }
                if (new URL(NetConfig.getNativeCrashUploadUrl()).getPath().equals(str)) {
                    dropCrashLog(CrashType.NATIVE);
                }
            }
        } catch (Throwable th) {
            NpthLog.m232e(th);
        }
    }

    public static void dropCrashLog(CrashType crashType) {
        List<File> listFiles;
        ArrayList arrayList;
        if (crashType == CrashType.JAVA) {
            listFiles = listFiles(JavaCrashSummary.FILE_NAME);
            if (listFiles != null) {
                arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (!new File(file, "launch").exists()) {
                        arrayList.add(file);
                    }
                }
                listFiles = arrayList;
            }
            if (listFiles != null || listFiles.size() <= 0) {
            }
            for (File file2 : listFiles) {
                if (!file2.isFile()) {
                    FileUtils.deleteFile(file2);
                }
            }
            return;
        }
        if (crashType == CrashType.LAUNCH) {
            listFiles = listFiles(JavaCrashSummary.FILE_NAME);
            if (listFiles != null) {
                arrayList = new ArrayList();
                for (File file3 : listFiles) {
                    if (new File(file3, "launch").exists()) {
                        arrayList.add(file3);
                    }
                }
                listFiles = arrayList;
            }
        } else if (crashType == CrashType.NATIVE) {
            listFiles = listFiles(NativeCrashSummary.FILE_NAME);
        } else if (crashType != CrashType.ANR) {
            return;
        } else {
            listFiles = listFiles(AnrSummary.FILE_NAME);
        }
        if (listFiles != null) {
        }
    }

    private static List<File> listFiles(final String str) {
        File[] listFiles;
        File rootDirectory = CrashManager.getRootDirectory();
        if (rootDirectory == null || (listFiles = rootDirectory.listFiles()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file.listFiles(new FilenameFilter() { // from class: com.bytedance.crash.upload.NetworkDisasterManager.3
                @Override // java.io.FilenameFilter
                public boolean accept(File file2, String str2) {
                    return str2.endsWith(str);
                }
            }) == null) {
                return null;
            }
            arrayList.add(file);
        }
        return arrayList;
    }
}
