package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpClient;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetSsCallConfig;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SsCronetHttpClient extends BaseHttpClient implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {
    private static final String CONCURRENT_NO_RETRY_SWITCH = "no_retry=1";
    private static final String CRONET_CLIENT_CLASS = "org.chromium.CronetClient";
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MAX = 20971520;
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MIN = 8192;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX = 10485760;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MIN = 16384;
    private static final int INVALID_BUFFER_SIZE = 0;
    private static final String KEY_CRONET_INPUTSTREAM_BUFF_SIZE = "cronet_inputstream_buff_size";
    private static final String KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE = "post_body_buffer_size";
    private static final String KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE = "path_cronet_inputstream_buff_size";
    public static final String TAG = "SsCronetHttpClient";
    private static volatile boolean sBypassOfflineCheckEnabled = true;
    private static Context sContext = null;
    private static volatile ICronetAppProvider sCronetAppProvider = null;
    private static ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static ICronetClient sCronetClient = null;
    private static ICronetHttpDnsConfig sCronetHttpDnsConfig = null;
    private static volatile int sCronetInputstreamBuffSize = 0;
    private static ICronetThreadStackOptFailureChecker sCronetThreadOptFailureChecker = null;
    private static ITncInfoGet sCronetTncInfoGet = null;
    private static String sCustomCronetClientClass = "";
    private static volatile String sInputStreamBufferConfig;
    private static volatile SsCronetHttpClient sInstance;
    private static volatile String sPostBodyBufferConfig;
    private static ConcurrentHashMap<String, Integer> sCronetOutputStreamBufferMap = new ConcurrentHashMap<>();
    private static Map<String, Integer> sPathCronetInputStreamBufferSizeMap = new ConcurrentHashMap();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICronetHttpDnsConfig {
        boolean isCronetHttpDnsOpen();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ICronetThreadStackOptFailureChecker {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface ITncInfoGet {
        JSONObject getABTest();
    }

    protected static boolean isCronetInputStreamSizeValid(int i) {
        return i >= 8192 && i <= CRONET_INPUTSTREAM_BUFF_SIZE_MAX;
    }

    protected static boolean isCustomCronetInputStreamSizeValid(int i) {
        return i > 0 && i <= CRONET_INPUTSTREAM_BUFF_SIZE_MAX;
    }

    protected static boolean isValidCronetOutputstreamBufferSize(int i) {
        return i >= 16384 && i <= CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX;
    }

    public void setHttpDnsForTesting(boolean z, boolean z2, boolean z3) throws Exception {
    }

    public static void setCronetAppInfoProvider(ICronetAppProvider iCronetAppProvider) {
        sCronetAppProvider = iCronetAppProvider;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        ICronetBootFailureChecker iCronetBootFailureChecker = sCronetBootFailureChecker;
        if (iCronetBootFailureChecker == null) {
            return false;
        }
        return iCronetBootFailureChecker.isCronetBootFailureExpected();
    }

    public static void setCronetBootFailureChecker(ICronetBootFailureChecker iCronetBootFailureChecker) {
        sCronetBootFailureChecker = iCronetBootFailureChecker;
    }

    public static void setCronetHttpDnsConfig(ICronetHttpDnsConfig iCronetHttpDnsConfig) {
        sCronetHttpDnsConfig = iCronetHttpDnsConfig;
    }

    public static void setCronetThreadOptFailureChecker(ICronetThreadStackOptFailureChecker iCronetThreadStackOptFailureChecker) {
        sCronetThreadOptFailureChecker = iCronetThreadStackOptFailureChecker;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        ICronetThreadStackOptFailureChecker iCronetThreadStackOptFailureChecker = sCronetThreadOptFailureChecker;
        if (iCronetThreadStackOptFailureChecker == null) {
            return false;
        }
        return iCronetThreadStackOptFailureChecker.isCronetThreadStackOptFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        ICronetThreadStackOptFailureChecker iCronetThreadStackOptFailureChecker = sCronetThreadOptFailureChecker;
        if (iCronetThreadStackOptFailureChecker == null) {
            return null;
        }
        return iCronetThreadStackOptFailureChecker.getThreadStackInitReason();
    }

    public static void setCronetTncInfoGet(ITncInfoGet iTncInfoGet) {
        sCronetTncInfoGet = iTncInfoGet;
    }

    public static ITncInfoGet getCronetTncInfoGet() {
        return sCronetTncInfoGet;
    }

    public static void setCustomCronetClientClass(String str) {
        sCustomCronetClientClass = str;
    }

    public static void setBypassOfflineCheck(boolean z) {
        sBypassOfflineCheckEnabled = z;
    }

    public static boolean getGlobalBypassOfflineCheck() {
        return sBypassOfflineCheckEnabled;
    }

    public static SsCronetHttpClient inst(Context context) {
        if (sInstance == null) {
            synchronized (SsCronetHttpClient.class) {
                if (sInstance == null) {
                    sInstance = new SsCronetHttpClient(context);
                    tryResolveImpl();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getCronetInputstreamBuffSize(String str, BaseHttpRequestInfo baseHttpRequestInfo) {
        Integer num;
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize)) {
            return sCronetInputstreamBuffSize;
        }
        if (!TextUtils.isEmpty(str) && !sPathCronetInputStreamBufferSizeMap.isEmpty() && sPathCronetInputStreamBufferSizeMap.containsKey(str) && (num = sPathCronetInputStreamBufferSizeMap.get(str)) != null && isCronetInputStreamSizeValid(num.intValue())) {
            return num.intValue();
        }
        if (baseHttpRequestInfo == null || baseHttpRequestInfo.reqContext == 0) {
            return 0;
        }
        if (isCronetInputStreamSizeValid(baseHttpRequestInfo.reqContext.input_stream_buffer_size) || (baseHttpRequestInfo.reqContext.ignoreCheckMinInputStreamBufferSize && isCustomCronetInputStreamSizeValid(baseHttpRequestInfo.reqContext.input_stream_buffer_size))) {
            return baseHttpRequestInfo.reqContext.input_stream_buffer_size;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getCronetOutputStreamBufferSize(String str, int i) {
        if (!isValidCronetOutputstreamBufferSize(i)) {
            i = 0;
        }
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        if (sCronetOutputStreamBufferMap.containsKey(str)) {
            Integer num = sCronetOutputStreamBufferMap.get(str);
            i = num == null ? 0 : num.intValue();
        }
        if (isValidCronetOutputstreamBufferSize(i)) {
            return i;
        }
        return 0;
    }

    private static void updatePostBodyBufferConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sCronetOutputStreamBufferMap.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            int optInt = jSONObject.optInt(next);
            if (!TextUtils.isEmpty(next) && isValidCronetOutputstreamBufferSize(optInt)) {
                sCronetOutputStreamBufferMap.put(next, Integer.valueOf(optInt));
            }
        }
    }

    private static void updateInputStreamBufferConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        sPathCronetInputStreamBufferSizeMap.clear();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                int optInt = jSONObject.optInt(next);
                if (isCustomCronetInputStreamSizeValid(optInt)) {
                    sPathCronetInputStreamBufferSizeMap.put(next, Integer.valueOf(optInt));
                }
            }
        }
    }

    public static void tryUpdateBodyBufferSizeConfig(JSONObject jSONObject, SharedPreferences sharedPreferences) {
        if (jSONObject != null) {
            sCronetInputstreamBuffSize = jSONObject.optInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE);
                if (optJSONObject != null) {
                    updatePostBodyBufferConfig(optJSONObject);
                    sPostBodyBufferConfig = optJSONObject.toString();
                } else {
                    sCronetOutputStreamBufferMap.clear();
                    sPostBodyBufferConfig = "";
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE);
                if (optJSONObject2 != null) {
                    String jSONObject2 = optJSONObject2.toString();
                    if (sInputStreamBufferConfig != null && jSONObject2.equals(sInputStreamBufferConfig)) {
                        return;
                    }
                    updateInputStreamBufferConfig(optJSONObject2);
                    sInputStreamBufferConfig = jSONObject2;
                } else {
                    sPathCronetInputStreamBufferSizeMap.clear();
                    sInputStreamBufferConfig = "";
                }
            } catch (Throwable unused) {
            }
        }
        if (sharedPreferences != null) {
            sCronetInputstreamBuffSize = sharedPreferences.getInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
            String string = sharedPreferences.getString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    updatePostBodyBufferConfig(new JSONObject(string));
                } catch (Throwable unused2) {
                }
            }
            String string2 = sharedPreferences.getString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, "");
            if (TextUtils.isEmpty(string2)) {
                return;
            }
            try {
                updateInputStreamBufferConfig(new JSONObject(string2));
            } catch (Throwable unused3) {
            }
        }
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor editor) {
        editor.putInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, sCronetInputstreamBuffSize);
        if (sPostBodyBufferConfig != null) {
            editor.putString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, sPostBodyBufferConfig);
        }
        if (sInputStreamBufferConfig != null) {
            editor.putString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, sInputStreamBufferConfig);
        }
    }

    private SsCronetHttpClient(Context context) {
        sContext = context.getApplicationContext();
    }

    public SsCall newSsCall(Request request) throws IOException {
        CronetSsCallConfig.UrlMatchRule urlMatchRuleFromRequest;
        Request tryUseFormBodyModifyHook = tryUseFormBodyModifyHook(request);
        Request filterQuery = QueryFilterEngine.inst().filterQuery(tryUseFormBodyModifyHook);
        if (filterQuery != null) {
            tryUseFormBodyModifyHook = filterQuery;
        }
        if (CronetSsCallConfig.inst().isConcurrentRequestEnabled() && !tryUseFormBodyModifyHook.getUrl().contains(CONCURRENT_NO_RETRY_SWITCH) && (urlMatchRuleFromRequest = CronetSsCallConfig.inst().getUrlMatchRuleFromRequest(tryUseFormBodyModifyHook)) != null && urlMatchRuleFromRequest.getDomainList() != null && urlMatchRuleFromRequest.getDomainList().size() >= 2) {
            tryUseFormBodyModifyHook.getMetrics().networklib.misc.isConcurrentRequest = true;
            return new ConcurrentCronetSsCall(tryUseFormBodyModifyHook, urlMatchRuleFromRequest);
        }
        return new CronetSsCall(tryUseFormBodyModifyHook);
    }

    public Request tryUseFormBodyModifyHook(Request request) {
        FormUrlEncodedTypedOutput body = request.getBody();
        if (!(body instanceof FormUrlEncodedTypedOutput)) {
            return request;
        }
        FormUrlEncodedTypedOutput formUrlEncodedTypedOutput = body;
        formUrlEncodedTypedOutput.useFormBodyModifyHookAndConstructStream(request);
        return request.newBuilder().post(formUrlEncodedTypedOutput).build();
    }

    private static void tryResolveImpl() {
        if (sCronetClient == null) {
            String str = !StringUtils.isEmpty(sCustomCronetClientClass) ? sCustomCronetClientClass : CRONET_CLIENT_CLASS;
            Logger.w(TAG, "tryResolveImpl:" + str);
            try {
                Object newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof ICronetClient) {
                    sCronetClient = (ICronetClient) newInstance;
                }
            } catch (Throwable th) {
                Logger.w(TAG, "load CronetClient exception: " + th);
            }
        }
    }

    public void tryCreateCronetEngine(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, ICronetAppProvider iCronetAppProvider) {
        tryResolveImpl();
        ICronetClient iCronetClient = sCronetClient;
        if (iCronetClient != null) {
            iCronetClient.setCronetBootFailureCheckerProvider(this);
            sCronetClient.setCronetThreadStackOptFailureCheckerProvider(this);
            sCronetClient.tryCreateCronetEngine(sContext, z, z2, z3, z4, NetworkParams.getUserAgent(), z5, iCronetAppProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static HttpURLConnection openConnection(String str, BaseHttpRequestInfo baseHttpRequestInfo) throws IOException {
        tryResolveImpl();
        ICronetClient iCronetClient = sCronetClient;
        if (iCronetClient != null) {
            iCronetClient.setCronetBootFailureCheckerProvider(sInstance);
            sCronetClient.setCronetThreadStackOptFailureCheckerProvider(sInstance);
            ICronetClient iCronetClient2 = sCronetClient;
            Context context = sContext;
            ICronetHttpDnsConfig iCronetHttpDnsConfig = sCronetHttpDnsConfig;
            return iCronetClient2.openConnection(context, str, iCronetHttpDnsConfig == null ? false : iCronetHttpDnsConfig.isCronetHttpDnsOpen(), NetworkParams.getUserAgent(), baseHttpRequestInfo, sCronetAppProvider);
        }
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static Context getContext() {
        return sContext;
    }

    public static ICronetClient getCronetClient() {
        return sCronetClient;
    }

    private static void checkCronetClientCreated() {
        if (sCronetClient == null) {
            throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
        }
    }

    public static String getCronetVersion() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getCronetVersion();
    }

    public static int getCronetInternalErrorCode(HttpURLConnection httpURLConnection) {
        return sCronetClient.getCronetInternalErrorCode(httpURLConnection);
    }

    public void triggerGetDomain(boolean z) {
        if (sCronetClient != null && ProcessUtils.isMainProcessByProcessFlag(sContext)) {
            sCronetClient.triggerGetDomain(z);
        }
    }

    public void runInBackGround(boolean z) {
        if (sCronetClient != null && ProcessUtils.isMainProcessByProcessFlag(sContext)) {
            sCronetClient.runInBackGround(z);
        }
    }

    public void addClientOpaqueData(String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2, boolean z) {
        if (sCronetClient == null) {
            return;
        }
        if (z || ProcessUtils.isMainProcessByProcessFlag(sContext)) {
            sCronetClient.addClientOpaqueData(strArr, bArr, bArr2, j, j2);
        }
    }

    public void clearClientOpaqueData(boolean z) {
        if (sCronetClient == null) {
            return;
        }
        if (z || ProcessUtils.isMainProcessByProcessFlag(sContext)) {
            sCronetClient.clearClientOpaqueData();
        }
    }

    public void removeClientOpaqueData(String str, boolean z) {
        if (sCronetClient == null) {
            return;
        }
        if (z || ProcessUtils.isMainProcessByProcessFlag(sContext)) {
            sCronetClient.removeClientOpaqueData(str);
        }
    }

    public static TTDispatchResult ttUrlDispatch(String str, int i, boolean z) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.ttUrlDispatch(str, i, z);
    }

    public void preconnectUrl(String str, Map<String, String> map) throws Exception {
        checkCronetClientCreated();
        sCronetClient.preconnectUrl(str, map);
    }

    public void tryStartNetDetect(String[] strArr, int i, int i2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.tryStartNetDetect(strArr, i, i2);
    }

    public void ttDnsResolve(String str, int i, String str2, Map<String, String> map) throws Exception {
        checkCronetClientCreated();
        sCronetClient.ttDnsResolve(str, i, str2, map);
    }

    public void getMappingRequestState(String str) {
        checkCronetClientCreated();
        sCronetClient.getMappingRequestState(str);
    }

    public int getEffectiveConnectionType() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveConnectionType();
    }

    public void notifyTNCConfigUpdated(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyTNCConfigUpdated(str, str2, str3, str4, str5, str6);
    }

    public static void notifyStoreRegionUpdated(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyStoreRegionUpdated(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public void setProxy(String str) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setProxy(str);
    }

    public NetworkQuality getNetworkQuality() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQuality();
    }

    public PacketLossMetrics getPacketLossRateMetrics(int i) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getPacketLossRateMetrics(i);
    }

    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getGroupRttEstimates();
    }

    public void setHostResolverRules(String str) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setHostResolverRules(str);
    }

    public void setAlogFuncAddr(long j) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setAlogFuncAddr(j);
    }

    public void setZstdFuncAddr(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setZstdFuncAddr(j, j2, j3, j4, j5, j6, j7, j8);
    }

    public void startThrottle(String[] strArr, int i, long j) {
        checkCronetClientCreated();
        sCronetClient.startThrottle(strArr, i, j);
    }

    public void stopThrottle(String[] strArr, int i) {
        checkCronetClientCreated();
        sCronetClient.stopThrottle(strArr, i);
    }

    public static void setBestHostWithRouteSelectionName(String str, String str2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setBestHostWithRouteSelectionName(str, str2);
    }

    public void setCookieInitCompleted() {
        checkCronetClientCreated();
        sCronetClient.setCookieInitCompleted();
    }

    public int getNetworkQualityLevel() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQualityLevel();
    }

    public int getEffectiveHttpRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveHttpRttMs();
    }

    public int getEffectiveTransportRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveTransportRttMs();
    }

    public int getEffectiveRxThroughputKbps() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveRxThroughputKbps();
    }

    public void reportNetDiagnosisUserLog(String str) throws Exception {
        checkCronetClientCreated();
        sCronetClient.reportNetDiagnosisUserLog(str);
    }

    public void enableTTBizHttpDns(boolean z, String str, String str2, String str3, boolean z2, String str4) throws Exception {
        checkCronetClientCreated();
        sCronetClient.enableTTBizHttpDns(z, str, str2, str3, z2, str4);
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType threadType) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindBigCore(threadType);
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType threadType) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindLittleCore(threadType);
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType threadType) throws Exception {
        checkCronetClientCreated();
        sCronetClient.resetCoreBind(threadType);
    }

    public void setSlaSamplingSetting(JSONObject jSONObject) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setSlaSamplingSetting(jSONObject);
    }
}
