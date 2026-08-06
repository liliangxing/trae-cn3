package com.bytedance.frameworks.baselib.network.http.cronet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface ICronetClient {

    /* loaded from: classes2.dex */
    public interface ICronetBootFailureCheckerProvider {
        boolean isCronetBootFailureExpected();
    }

    /* loaded from: classes2.dex */
    public interface ICronetThreadStackOptFailureCheckerProvider {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    void addClientOpaqueData(String[] strArr, byte[] bArr, byte[] bArr2, long j, long j2);

    void bindBigCore(TTNetThreadConfig.ThreadType threadType) throws Exception;

    void bindLittleCore(TTNetThreadConfig.ThreadType threadType) throws Exception;

    void clearClientOpaqueData();

    void enableTTBizHttpDns(boolean z, String str, String str2, String str3, boolean z2, String str4) throws Exception;

    int getCronetInternalErrorCode(HttpURLConnection httpURLConnection);

    String getCronetVersion();

    int getEffectiveConnectionType() throws Exception;

    int getEffectiveHttpRttMs() throws Exception;

    int getEffectiveRxThroughputKbps() throws Exception;

    int getEffectiveTransportRttMs() throws Exception;

    Map<String, NetworkQuality> getGroupRttEstimates() throws Exception;

    void getMappingRequestState(String str);

    NetworkQuality getNetworkQuality() throws Exception;

    int getNetworkQualityLevel() throws Exception;

    PacketLossMetrics getPacketLossRateMetrics(int i) throws Exception;

    boolean isCronetHttpURLConnection(HttpURLConnection httpURLConnection);

    void notifyStoreRegionUpdated(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) throws Exception;

    void notifyTNCConfigUpdated(String str, String str2, String str3, String str4, String str5, String str6) throws Exception;

    HttpURLConnection openConnection(Context context, String str, boolean z, String str2, BaseHttpRequestInfo baseHttpRequestInfo, ICronetAppProvider iCronetAppProvider) throws IOException;

    void preconnectUrl(String str, Map<String, String> map) throws Exception;

    void removeClientOpaqueData(String str);

    void reportNetDiagnosisUserLog(String str) throws Exception;

    void resetCoreBind(TTNetThreadConfig.ThreadType threadType) throws Exception;

    void runInBackGround(boolean z);

    void setAlogFuncAddr(long j) throws Exception;

    void setAppStartUpState(int i) throws Exception;

    void setBestHostWithRouteSelectionName(String str, String str2) throws Exception;

    void setCookieInitCompleted();

    void setCronetBootFailureCheckerProvider(ICronetBootFailureCheckerProvider iCronetBootFailureCheckerProvider);

    void setCronetThreadStackOptFailureCheckerProvider(ICronetThreadStackOptFailureCheckerProvider iCronetThreadStackOptFailureCheckerProvider);

    void setHostResolverRules(String str) throws Exception;

    void setHttpDnsForTesting(boolean z, boolean z2, boolean z3) throws Exception;

    void setProxy(String str) throws Exception;

    void setSlaSamplingSetting(JSONObject jSONObject) throws Exception;

    void setZstdFuncAddr(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) throws Exception;

    void startThrottle(String[] strArr, int i, long j);

    void stopThrottle(String[] strArr, int i);

    void triggerGetDomain(boolean z);

    void tryCreateCronetEngine(Context context, boolean z, boolean z2, boolean z3, boolean z4, String str, boolean z5, ICronetAppProvider iCronetAppProvider);

    void tryStartNetDetect(String[] strArr, int i, int i2) throws Exception;

    void ttDnsResolve(String str, int i, String str2, Map<String, String> map) throws Exception;

    TTDispatchResult ttUrlDispatch(String str, int i, boolean z) throws Exception;
}
