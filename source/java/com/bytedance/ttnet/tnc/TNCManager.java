package com.bytedance.ttnet.tnc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3TncBridge;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.OkHttp3TTPSandBoxInterceptor;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionBridge;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.AbsOptionalTTNetDepend;
import com.bytedance.ttnet.BuildConfig;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.cronet.CronetDataStorageAccess;
import com.bytedance.ttnet.http.GetDomainContext;
import com.bytedance.ttnet.http.HttpURLConnClient;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TNCManager implements Ok3TncBridge {
    private static final int MSG_UPDATE_REMOTE = 10000;
    private static final String TAG = "TNCManager";
    public static final String TNC_ABTEST_NAME = "ttnet_tnc_abtest";
    public static final String TNC_CONFIG_KEY_NAME = "data";
    public static final String TNC_CONFIG_STR = "tnc_config_str";
    public static final String TNC_ETAG_NAME = "ttnet_tnc_etag";
    public static final String TNC_IS_FULL_CONFIG = "is_full_config";
    private static final int TNC_PROBE_CMD_GET_DOMAIN = 10000;
    private static final int TNC_PROBE_CMD_TEST = 1000;
    private static final String TNC_PROBE_HEADER = "tt-idc-switch";
    private static final String TNC_PROBE_HEADER_SECEPTOR = "@";
    public static final String TNC_SP_NAME = "ttnet_tnc_config";
    private static String mGetDomainDefaultJson;
    private static TNCManager sInstance;
    private Context mContext;
    private volatile long mRequestStartTime;
    private TNCConfigHandler mTNCConfigHandler;
    private String mTncCanary;
    private String mTncConfigId;
    private long mLastDoUpdateTime = 0;
    private volatile long mLastProbeSendTime = 0;
    private volatile long mLastProbeGetTime = 0;
    private TNCUpdateSource mTNCSource = TNCUpdateSource.TTCACHE;
    private volatile long mConfigUpdateTime = 0;
    private volatile boolean mColdStartFinish = false;
    private volatile boolean mConfigUpdateSuccess = false;
    private AtomicBoolean mCronetFailedTncSent = new AtomicBoolean(false);
    private boolean mInited = false;
    private volatile int mTncProbeCmd = 0;
    private volatile long mTncProbeVersion = 0;
    private volatile long mTncProbeSuccessVersion = 0;
    private int mReqToCnt = 0;
    private HashMap<String, Integer> mReqToApiMap = new HashMap<>();
    private HashMap<String, Integer> mReqToIpMap = new HashMap<>();
    private int mReqErrorCnt = 0;
    private HashMap<String, Integer> mReqErrApiMap = new HashMap<>();
    private HashMap<String, Integer> mReqErrIpMap = new HashMap<>();
    private boolean mIsMainProcess = true;
    Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.ttnet.tnc.TNCManager.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            boolean z = message.arg1 != 0;
            TNCManager tNCManager = TNCManager.this;
            tNCManager.doUpdateRemote(z, tNCManager.transInt2Enum(message.arg2));
        }
    };
    private volatile ITncSandBox mSandBox = null;
    OkHttp3TTPSandBoxInterceptor.ITncSandBox okTNCSandBox = new OkHttp3TTPSandBoxInterceptor.ITncSandBox() { // from class: com.bytedance.ttnet.tnc.TNCManager.3
        public boolean isTncRequestProceed(String str, String str2, Map<String, List<String>> map, String str3) {
            return TNCManager.this.mSandBox.isTncRequestProceed(str, str2, TNCManager.this.multiHeaderMap2List(map), str3);
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ITncSandBox {
        boolean isTncRequestProceed(String str, String str2, List<Header> list, String str3);

        boolean isTncResponseProceed(String str, String str2, List<Header> list, String str3);
    }

    private boolean isHttpRespCodeOk(int i) {
        return i >= 200 && i < 400;
    }

    @Deprecated
    public Map<String, String> getTNCHostReplaceMap() {
        return null;
    }

    public void handleRequestResult() {
    }

    public static void initStoreRegionModule(final ICronetAppProvider iCronetAppProvider) {
        String carrierRegion = iCronetAppProvider.getCarrierRegion();
        String sysRegion = iCronetAppProvider.getSysRegion();
        String region = iCronetAppProvider.getRegion();
        if (TextUtils.isEmpty(carrierRegion)) {
            carrierRegion = !TextUtils.isEmpty(sysRegion) ? sysRegion : region;
        }
        StoreRegionManager.inst().initStoreRegionRuleConfig(carrierRegion, iCronetAppProvider.getStoreIdcRuleJSON(), iCronetAppProvider.getAppInitialRegionInfo(), TTNetInit.getTTNetDepend().getContext(), new StoreRegionBridge() { // from class: com.bytedance.ttnet.tnc.TNCManager.1
            public void sendFeedbackLog(String str, String str2) {
                iCronetAppProvider.sendAppMonitorEvent(str, str2);
            }

            public void onStoreIdcChanged(String str, String str2, String str3, String str4, String str5, String str6) {
                CronetDataStorageAccess.inst().onStoreIdcChanged(str, str2, str3, str4, str5, str6);
            }

            public boolean updateTncConfig(JSONObject jSONObject, String str, String str2, boolean z) {
                return TNCManager.getInstance().handleTncConfigFromRegion(jSONObject, str, str2, z);
            }
        });
        if (!TextUtils.isEmpty(carrierRegion)) {
            mGetDomainDefaultJson = TTNetInit.getGetDomainConfigByRegion(carrierRegion);
        }
        if (TextUtils.isEmpty(mGetDomainDefaultJson)) {
            mGetDomainDefaultJson = iCronetAppProvider.getGetDomainDefaultJSON();
        }
        if (Logger.debug()) {
            Logger.d(TAG, "region: " + carrierRegion + " json: " + mGetDomainDefaultJson);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getGetDomainDefaultJson() {
        return mGetDomainDefaultJson;
    }

    public static synchronized TNCManager getInstance() {
        TNCManager tNCManager;
        synchronized (TNCManager.class) {
            if (sInstance == null) {
                sInstance = new TNCManager();
            }
            tNCManager = sInstance;
        }
        return tNCManager;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum TNCUpdateSource {
        TTRESUME(-2),
        TTHardCode(-1),
        TTCACHE(0),
        TTSERVER(1),
        TTERROR(2),
        TTPOLL(3),
        TTTNC(4),
        PORTRETRY(7),
        TTREGION(10),
        TTCRONET(20),
        TTCRONETFAILED(30);

        public final int mValue;

        TNCUpdateSource(int i) {
            this.mValue = i;
        }
    }

    private TNCManager() {
    }

    public synchronized void initTnc(Context context, boolean z) {
        if (!this.mInited) {
            this.mContext = context;
            this.mIsMainProcess = z;
            this.mTNCConfigHandler = new TNCConfigHandler(context, z);
            if (z) {
                loadProbeInfo();
            }
            if (Logger.debug()) {
                Logger.d(TAG, "initTnc, isMainProc: " + z + " probeCmd: " + this.mTncProbeCmd + " probeVersion: " + this.mTncProbeVersion);
            }
            this.mInited = true;
        }
    }

    private void loadProbeInfo() {
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(TNC_SP_NAME, 0);
        this.mTncProbeCmd = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.mTncProbeVersion = sharedPreferences.getLong("tnc_probe_version", 0L);
    }

    public TNCConfig getTNCConfig() {
        TNCConfigHandler tNCConfigHandler = this.mTNCConfigHandler;
        if (tNCConfigHandler != null) {
            return tNCConfigHandler.getTNCConfig();
        }
        return null;
    }

    public TNCConfigHandler getTNCConfigHandler() {
        return this.mTNCConfigHandler;
    }

    public boolean handleTncConfigFromRegion(JSONObject jSONObject, String str, String str2, boolean z) {
        boolean z2;
        if (Logger.debug()) {
            Logger.d(TAG, "data: " + jSONObject + " etag: " + str + " tncAttr: " + str2 + " needUpdateTnc: " + z);
        }
        if (jSONObject != null) {
            TNCConfigHandler tNCConfigHandler = this.mTNCConfigHandler;
            if (tNCConfigHandler != null) {
                tNCConfigHandler.setTncAbTest("");
                z2 = this.mTNCConfigHandler.handleConfigChanged(jSONObject, TNCUpdateSource.TTSERVER, str, str2, System.currentTimeMillis());
            } else {
                z2 = false;
            }
            if (z2) {
                StoreRegionManager.inst().setReceivedTNCRegionConfig();
            }
        } else {
            z2 = false;
        }
        if (!z || z2) {
            return false;
        }
        Logger.d(TAG, "doUpdateRemote tnc");
        doUpdateRemote(true, TNCUpdateSource.TTREGION);
        return true;
    }

    @Deprecated
    public String handleHostMapping(String str) {
        return URLDispatcher.inst().handleHostMapping(str);
    }

    public synchronized void onOk3Response(Request request, Response response) {
        if (request == null || response == null) {
            return;
        }
        if (this.mIsMainProcess) {
            if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                HttpUrl url = request.url();
                String scheme = url.scheme();
                String host = url.host();
                String encodedPath = url.encodedPath();
                int code = response.code();
                if ("http".equals(scheme) || "https".equals(scheme)) {
                    if (TextUtils.isEmpty(host)) {
                        return;
                    }
                    if (response.networkResponse() == null) {
                        return;
                    }
                    if (Logger.debug()) {
                        Logger.d(TAG, "onOk3Response, url: " + scheme + "://" + host + "#" + code);
                    }
                    TNCConfig tNCConfig = getTNCConfig();
                    if (tNCConfig != null && tNCConfig.probeEnable) {
                        handleTncProbe(response, host);
                    }
                    if (tNCConfig != null && tNCConfig.localEnable) {
                        if (tNCConfig.localHostFilterList != null && tNCConfig.localHostFilterList.size() > 0 && tNCConfig.localHostFilterList.containsKey(host)) {
                            if (Logger.debug()) {
                                Logger.d(TAG, "onOk3Response, url matched: " + scheme + "://" + host + "#" + code + " " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());
                            }
                            if (code > 0) {
                                if (isHttpRespCodeOk(code)) {
                                    if (this.mReqToCnt > 0 || this.mReqErrorCnt > 0) {
                                        resetTNCControlState();
                                    }
                                } else if (!isHttpRespCodeInBlack(code)) {
                                    this.mReqErrorCnt++;
                                    this.mReqErrApiMap.put(encodedPath, 0);
                                    this.mReqErrIpMap.put(host, 0);
                                    if (this.mReqErrorCnt >= tNCConfig.reqErrCnt && this.mReqErrApiMap.size() >= tNCConfig.reqErrApiCnt && this.mReqErrIpMap.size() >= tNCConfig.reqErrIpCnt) {
                                        if (Logger.debug()) {
                                            Logger.d(TAG, "onOk3Response, url doUpdate: " + scheme + "://" + host + "#" + code);
                                        }
                                        sendUpdateMsg(false, 0L, TNCUpdateSource.TTERROR);
                                        resetTNCControlState();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public synchronized void onOk3Timeout(Request request, Exception exc) {
        if (request == null || exc == null) {
            return;
        }
        if (this.mIsMainProcess) {
            if (NetworkUtils.isNetworkAvailable(this.mContext)) {
                HttpUrl url = request.url();
                String scheme = url.scheme();
                String host = url.host();
                String encodedPath = url.encodedPath();
                String exceptionStr = getExceptionStr(exc);
                if ("http".equals(scheme) || "https".equals(scheme)) {
                    if (TextUtils.isEmpty(host)) {
                        return;
                    }
                    if (!TextUtils.isEmpty(exceptionStr) && exceptionStr.contains(EventConstants.PARAM_TIME_OUT) && exceptionStr.contains("time out") && !exceptionStr.contains("unreachable")) {
                        TNCConfig tNCConfig = getTNCConfig();
                        if (tNCConfig != null && tNCConfig.localEnable) {
                            if (tNCConfig.localHostFilterList != null && tNCConfig.localHostFilterList.size() > 0 && tNCConfig.localHostFilterList.containsKey(host)) {
                                if (Logger.debug()) {
                                    Logger.d(TAG, "onOk3Timeout, url matched: " + scheme + "://" + host + "#" + exceptionStr + " " + this.mReqToCnt + "#" + this.mReqToApiMap.size() + "#" + this.mReqToIpMap.size() + " " + this.mReqErrorCnt + "#" + this.mReqErrApiMap.size() + "#" + this.mReqErrIpMap.size());
                                }
                                this.mReqToCnt++;
                                this.mReqToApiMap.put(encodedPath, 0);
                                this.mReqToIpMap.put(host, 0);
                                if (this.mReqToCnt >= tNCConfig.reqToCnt && this.mReqToApiMap.size() >= tNCConfig.reqToApiCnt && this.mReqToIpMap.size() >= tNCConfig.reqToIpCnt) {
                                    if (Logger.debug()) {
                                        Logger.d(TAG, "onOk3Timeout, url doUpate: " + scheme + "://" + host);
                                    }
                                    sendUpdateMsg(false, 0L, TNCUpdateSource.TTERROR);
                                    resetTNCControlState();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public JSONObject getTNCInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("update_time", this.mConfigUpdateTime);
            jSONObject2.put(EventConstants.PARAM_SOURCE, this.mTNCSource.mValue);
            int i = 1;
            jSONObject2.put("cold_start", this.mColdStartFinish ? 1 : 0);
            if (!this.mConfigUpdateSuccess) {
                i = 0;
            }
            jSONObject2.put("config_updated", i);
            if (!TextUtils.isEmpty(this.mTncConfigId)) {
                jSONObject2.put("config", this.mTncConfigId);
            }
            if (!TextUtils.isEmpty(this.mTncCanary)) {
                jSONObject2.put("canary", this.mTncCanary);
            }
            jSONObject2.put("local_probe_version", this.mTncProbeSuccessVersion);
            String tncRules = AppConfig.getInstance(this.mContext).getTncRules();
            if (!TextUtils.isEmpty(tncRules)) {
                jSONObject2.put("rules", tncRules);
            }
            TNCConfigHandler tNCConfigHandler = this.mTNCConfigHandler;
            if (tNCConfigHandler != null && !TextUtils.isEmpty(tNCConfigHandler.getRegion()) && !TextUtils.isEmpty(this.mTNCConfigHandler.getRegionSrc())) {
                jSONObject2.put("region", this.mTNCConfigHandler.getRegion());
                jSONObject2.put(CronetDataStorageAccess.REGION_SOURCE, this.mTNCConfigHandler.getRegionSrc());
            }
            jSONObject.put("data", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IPiaCacheProvider.CacheConfig.FIELD_VERSION, this.mTncProbeVersion);
            jSONObject3.put("cmd", this.mTncProbeCmd);
            jSONObject3.put("send_time", this.mLastProbeSendTime);
            jSONObject3.put("get_time", this.mLastProbeGetTime);
            jSONObject.put("probe", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("probe_version", this.mTncProbeSuccessVersion);
            jSONObject4.put(EventConstants.PARAM_SOURCE, this.mTNCSource.mValue);
            jSONObject4.put("start_time", this.mRequestStartTime);
            jSONObject.put("request", jSONObject4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleTncProbe(Response response, String str) {
        int i;
        long j;
        TNCConfig tNCConfig;
        if (response != null && this.mIsMainProcess) {
            String header = response.header(TNC_PROBE_HEADER, (String) null);
            if (TextUtils.isEmpty(header)) {
                if (Logger.debug()) {
                    Logger.d(TAG, "handleTncProbe, no probeProto, " + str);
                    return;
                }
                return;
            }
            String[] split = header.split(TNC_PROBE_HEADER_SECEPTOR);
            if (split == null || split.length != 2) {
                if (Logger.debug()) {
                    Logger.d(TAG, "handleTncProbe, probeProto err, " + str);
                    return;
                }
                return;
            }
            try {
                i = Integer.parseInt(split[0]);
                try {
                    j = Long.parseLong(split[1]);
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (Logger.debug()) {
                        Logger.d(TAG, "handleTncProbe, probeProto except, " + str);
                    }
                    j = 0;
                    if (Logger.debug()) {
                    }
                    if (j > this.mTncProbeVersion) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                i = 0;
            }
            if (Logger.debug()) {
                Logger.d(TAG, "handleTncProbe, local: " + this.mTncProbeCmd + TNC_PROBE_HEADER_SECEPTOR + this.mTncProbeVersion + " svr: " + i + TNC_PROBE_HEADER_SECEPTOR + j + " " + str);
            }
            if (j > this.mTncProbeVersion) {
                return;
            }
            this.mTncProbeCmd = i;
            this.mTncProbeVersion = j;
            this.mLastProbeGetTime = System.currentTimeMillis();
            this.mContext.getSharedPreferences(TNC_SP_NAME, 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
            if (this.mTncProbeCmd != 10000 || (tNCConfig = getTNCConfig()) == null) {
                return;
            }
            long nextInt = tNCConfig.updateRandomRange > 0 ? new Random(System.currentTimeMillis()).nextInt(tNCConfig.updateRandomRange) * 1000 : 0L;
            if (Logger.debug()) {
                Logger.d(TAG, "handleTncProbe, updateConfig delay: " + nextInt + " " + str);
            }
            sendUpdateMsg(true, nextInt, TNCUpdateSource.TTTNC);
        }
    }

    public void handleCronetInitFailed() {
        if (getTNCConfig() != null && ProcessUtils.isMainProcessByProcessFlag(this.mContext) && this.mCronetFailedTncSent.compareAndSet(false, true)) {
            sendUpdateMsg(true, 0L, TNCUpdateSource.TTCRONETFAILED);
        }
    }

    private void sendUpdateMsg(boolean z, long j, TNCUpdateSource tNCUpdateSource) {
        if (this.mHandler.hasMessages(10000)) {
            return;
        }
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 10000;
        obtainMessage.arg1 = z ? 1 : 0;
        obtainMessage.arg2 = tNCUpdateSource.mValue;
        if (j > 0) {
            this.mHandler.sendMessageDelayed(obtainMessage, j);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doUpdateRemote(boolean z, TNCUpdateSource tNCUpdateSource) {
        if (getTNCConfig() == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "doUpdateRemote, " + z);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.mLastDoUpdateTime + (r0.updateInterval * 1000) > elapsedRealtime) {
            if (Logger.debug()) {
                Logger.d(TAG, "doUpdateRemote, time limit");
            }
        } else {
            this.mLastDoUpdateTime = elapsedRealtime;
            if (tNCUpdateSource == TNCUpdateSource.TTTNC) {
                this.mLastProbeSendTime = System.currentTimeMillis();
            }
            AppConfig.getInstance(this.mContext).doRefresh(tNCUpdateSource, false);
        }
    }

    private void resetTNCControlState() {
        if (Logger.debug()) {
            Logger.d(TAG, "resetTNCControlState");
        }
        this.mReqToCnt = 0;
        this.mReqToApiMap.clear();
        this.mReqToIpMap.clear();
        this.mReqErrorCnt = 0;
        this.mReqErrApiMap.clear();
        this.mReqErrIpMap.clear();
    }

    private String getExceptionStr(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().toLowerCase();
    }

    private boolean isHttpRespCodeInBlack(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        TNCConfig tNCConfig = getTNCConfig();
        return (tNCConfig == null || TextUtils.isEmpty(tNCConfig.httpCodeBlack) || !tNCConfig.httpCodeBlack.contains(new StringBuilder("").append(i).toString())) ? false : true;
    }

    public boolean getDomainInternal(Context context, boolean z, TNCUpdateSource tNCUpdateSource, String str) {
        List<Header> headers;
        String body;
        if (Logger.debug()) {
            Logger.d(TAG, "getdomain internal, use retrofit okhttp: " + z + ", tnc source: " + tNCUpdateSource);
        }
        ArrayList<String> arrayList = new ArrayList();
        if (AppConfig.getInstance(context).getTncHostArrays() != null && AppConfig.getInstance(context).getTncHostArrays().size() != 0) {
            arrayList.addAll(AppConfig.getInstance(context).getTncHostArrays());
            for (String str2 : AppConfig.getInstance(context).getConfigServers()) {
                if (!arrayList.contains(str2)) {
                    arrayList.add(str2);
                }
            }
        } else {
            arrayList.addAll(Arrays.asList(AppConfig.getInstance(context).getConfigServers()));
        }
        this.mTNCSource = tNCUpdateSource;
        this.mRequestStartTime = System.currentTimeMillis();
        for (String str3 : arrayList) {
            StringBuilder sb = new StringBuilder("https://");
            sb.append(str3).append("/get_domains/v5/");
            UrlBuilder urlBuilder = new UrlBuilder(sb.toString());
            try {
                urlBuilder.addParam("abi", Build.SUPPORTED_ABIS[0]);
                urlBuilder.addParam("tnc_src", tNCUpdateSource.mValue);
                urlBuilder.addParam("okhttp_version", BuildConfig.VERSION_NAME);
                if (StoreRegionManager.inst().isStoreRegionRuleEnabled()) {
                    urlBuilder.addParam("use_store_region_cookie", "1");
                }
                addTNCExtraParam(urlBuilder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            HashMap hashMap = new HashMap();
            StoreRegionManager.inst().addStoreIdcHeaderForGetDomain(hashMap);
            boolean z2 = !TextUtils.isEmpty(StoreRegionManager.inst().getStoreRegion());
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("x-tt-tnc-summary", str);
            }
            if (!z) {
                GetDomainContext getDomainContext = new GetDomainContext();
                getDomainContext.url = urlBuilder.toString();
                getDomainContext.useHttps = true;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    if (!isTncRequestProceed("GET", getDomainContext.url, hashMap, "")) {
                        return false;
                    }
                    HashMap hashMap2 = new HashMap();
                    String executeGet = HttpURLConnClient.executeGet(getDomainContext.url, hashMap, hashMap2, getDomainContext);
                    if (!isTncResponseProceed("GET", getDomainContext.url, hashMap2, executeGet)) {
                        return false;
                    }
                    getDomainContext.queryTime = System.currentTimeMillis() - currentTimeMillis;
                    this.mTncCanary = getDomainContext.tncCanary;
                    this.mTncConfigId = getDomainContext.tncConfigId;
                    if (getInstance().handleTncResponse(context, tNCUpdateSource, executeGet, getDomainContext.tncControl, getDomainContext.tncEtag, getDomainContext.tncAbTest, z2)) {
                        return true;
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } else {
                urlBuilder.addParam(CommonConstants.KEY_AID, TTNetInit.getTTNetDepend().getAppId());
                urlBuilder.addParam(CommonConstants.KEY_DEVICE_PLATFORM, "android");
                if (TTNetInit.getCronetProvider() != null) {
                    urlBuilder.addParam("version_code", TTNetInit.getCronetProvider().getVersionCode());
                    urlBuilder.addParam("channel", TTNetInit.getCronetProvider().getChannel());
                }
                ArrayList arrayList2 = new ArrayList();
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        arrayList2.add(new Header(entry.getKey(), entry.getValue()));
                    }
                }
                String urlBuilder2 = urlBuilder.toString();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                try {
                    Pair parseUrl = UrlUtils.parseUrl(urlBuilder2, linkedHashMap);
                    String str4 = (String) parseUrl.first;
                    String str5 = (String) parseUrl.second;
                    INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str4, INetworkApi.class);
                    if (iNetworkApi == null) {
                        continue;
                    } else {
                        Call<String> doGet = iNetworkApi.doGet(true, -1, str5, linkedHashMap, arrayList2, null);
                        try {
                            SsResponse<String> execute = doGet.execute();
                            headers = execute.headers();
                            body = execute.body();
                        } finally {
                            try {
                                if (doGet != null) {
                                    doGet.cancel();
                                }
                            } finally {
                            }
                        }
                        if (this.mSandBox != null && !this.mSandBox.isTncResponseProceed("GET", doGet.request().getUrl(), headers, body)) {
                            if (doGet != null) {
                                doGet.cancel();
                            }
                            return false;
                        }
                        String headerValueIgnoreCase = RetrofitUtils.getHeaderValueIgnoreCase(headers, "x-ss-etag");
                        String headerValueIgnoreCase2 = RetrofitUtils.getHeaderValueIgnoreCase(headers, "x-tt-tnc-abtest");
                        String headerValueIgnoreCase3 = RetrofitUtils.getHeaderValueIgnoreCase(headers, "x-tt-tnc-control");
                        this.mTncConfigId = RetrofitUtils.getHeaderValueIgnoreCase(headers, "x-tt-tnc-config");
                        this.mTncCanary = RetrofitUtils.getHeaderValueIgnoreCase(headers, "x-ss-canary");
                        if (getInstance().handleTncResponse(context, tNCUpdateSource, body, headerValueIgnoreCase3, headerValueIgnoreCase, headerValueIgnoreCase2, z2)) {
                            if (doGet != null) {
                                doGet.cancel();
                            }
                            return true;
                        }
                        if (doGet != null) {
                            doGet.cancel();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    private boolean handleTncResponse(Context context, TNCUpdateSource tNCUpdateSource, String str, String str2, String str3, String str4, boolean z) {
        try {
            if (Logger.debug()) {
                Logger.d(TAG, "okhttp tnc response success, etag is " + str3 + ", tnc control " + str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                AppConfig.getInstance(context).setTncEtag(str3);
            }
            getInstance().mTNCConfigHandler.setTncAbTest(str4);
            if (!TextUtils.isEmpty(str2) && str2.equals("1")) {
                return true;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(str);
            ClientKeyManager.inst().OnNetConfigChanged(str);
            boolean handleResponse = AppConfig.getInstance(context).handleResponse(jSONObject, tNCUpdateSource, System.currentTimeMillis(), z);
            if (handleResponse) {
                this.mConfigUpdateTime = System.currentTimeMillis();
                if (!this.mColdStartFinish) {
                    this.mColdStartFinish = true;
                }
                this.mConfigUpdateSuccess = true;
                if (tNCUpdateSource == TNCUpdateSource.TTTNC) {
                    this.mTncProbeSuccessVersion = this.mTncProbeVersion;
                }
            }
            return handleResponse;
        } catch (Exception unused) {
            return false;
        }
    }

    private static void addTNCExtraParam(UrlBuilder urlBuilder) {
        Map<String, String> tNCExtraParam;
        Object tTNetDepend = TTNetInit.getTTNetDepend();
        if (tTNetDepend == null || !(tTNetDepend instanceof AbsOptionalTTNetDepend) || (tNCExtraParam = ((AbsOptionalTTNetDepend) tTNetDepend).getTNCExtraParam()) == null || tNCExtraParam.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : tNCExtraParam.entrySet()) {
            urlBuilder.addParam(entry.getKey(), entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TNCUpdateSource transInt2Enum(int i) {
        if (i == 7) {
            return TNCUpdateSource.PORTRETRY;
        }
        if (i == 10) {
            return TNCUpdateSource.TTREGION;
        }
        if (i == 20) {
            return TNCUpdateSource.TTCRONET;
        }
        if (i != 30) {
            switch (i) {
                case -2:
                    return TNCUpdateSource.TTRESUME;
                case -1:
                    return TNCUpdateSource.TTHardCode;
                case 0:
                    return TNCUpdateSource.TTCACHE;
                case 1:
                    return TNCUpdateSource.TTSERVER;
                case 2:
                    return TNCUpdateSource.TTERROR;
                case 3:
                    return TNCUpdateSource.TTPOLL;
                case 4:
                    return TNCUpdateSource.TTTNC;
                default:
                    return TNCUpdateSource.TTSERVER;
            }
        }
        return TNCUpdateSource.TTCRONETFAILED;
    }

    public void setTncSandbox(ITncSandBox iTncSandBox) {
        this.mSandBox = iTncSandBox;
        OkHttp3TTPSandBoxInterceptor.setTncSandbox(this.okTNCSandBox);
    }

    public boolean isTncRequestProceed(String str, String str2, Map<String, String> map, String str3) {
        if (this.mSandBox == null) {
            return true;
        }
        if (str3 == null) {
            str3 = "";
        }
        return this.mSandBox.isTncRequestProceed(str, str2, headerMap2List(map), str3);
    }

    public boolean isTncResponseProceed(String str, String str2, Map<String, List<String>> map, String str3) {
        if (this.mSandBox == null) {
            return true;
        }
        return this.mSandBox.isTncResponseProceed(str, str2, multiHeaderMap2List(map), str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Header> multiHeaderMap2List(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            List<String> list = map.get(str);
            if (list != null) {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new Header(str, it.next()));
                }
            }
        }
        return arrayList;
    }

    private List<Header> headerMap2List(Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                arrayList.add(new Header(str, str2));
            }
        }
        return arrayList;
    }
}
