package com.ss.android.common.util;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Pair;
import android.webkit.CookieManager;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.IMetricsCollect;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.IRequestHolder;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.common.NetworkResponseInfo;
import com.ss.android.http.legacy.HeaderElement;
import com.ss.android.http.legacy.NameValuePair;
import com.ss.android.http.legacy.message.BasicHeader;
import com.ss.android.http.legacy.message.BasicNameValuePair;
import com.ss.android.http.legacy.message.HeaderGroup;
import com.ss.android.http.legacy.params.HttpProtocolParams;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.http.legacy.utils.URLEncodedUtils;
import com.ss.android.pushmanager.PushCommonConstants;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.token.TTTokenMonitor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import org.apache.http.params.HttpParams;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    private static final boolean DEBUG_MOBILE = false;
    public static final long DEFAULT_CONN_POOL_TIMEOUT = 15000;
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 4;
    private static final String ENAME_MAX_AGE = "max-age";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-snssdk.remoteaddr";
    public static final int SOCKET_BUFFER_SIZE = 8192;
    private static final String TAG = "NetworkUtils";
    public static final boolean USE_KEEP_ALIVE = true;
    public static final boolean USE_PROXY = false;
    private static volatile boolean mAllowKeepAlive = true;
    private static Context sAppContext;
    private static volatile boolean sHasRebuildSsl;
    private static NetworkTypeInterceptor sNetworkTypeInterceptor;
    private static volatile boolean sPostContainsL0;
    public static final String[] L0_PARAM_LIST = {"mac_address", PushCommonConstants.KEY_OAID, "openudid", "uuid", "imei"};
    private static volatile int sUseDnsMapping = -1;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface NetworkTypeInterceptor {
        NetworkUtils.NetworkType getNetworkType();
    }

    public byte[] tryGunzipContent(byte[] bArr) {
        return null;
    }

    public static void setPostContainsL0(boolean z) {
        sPostContainsL0 = z;
    }

    private static void removeL0Params(List<BasicNameValuePair> list, Map<String, String> map) {
        boolean z;
        if (map == null || sPostContainsL0) {
            return;
        }
        for (String str : L0_PARAM_LIST) {
            if (str != null && map.containsKey(str)) {
                if (list == null || list.isEmpty()) {
                    z = false;
                } else {
                    Iterator<BasicNameValuePair> it = list.iterator();
                    z = false;
                    while (it.hasNext()) {
                        if (str.equals(it.next().getName())) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    map.remove(str);
                }
            }
        }
    }

    public static boolean is2G(Context context) {
        return com.bytedance.common.utility.NetworkUtils.is2G(context);
    }

    public static boolean isWifi(Context context) {
        return com.bytedance.common.utility.NetworkUtils.isWifi(context);
    }

    public static boolean isNetworkAvailable(Context context) {
        return com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(context);
    }

    public static String getMacAddress(Context context) {
        return com.bytedance.common.utility.NetworkUtils.getMacAddress(context);
    }

    public static NetworkUtils.NetworkType getNetworkTypeFast(Context context) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkTypeFast(context);
    }

    public static NetworkUtils.NetworkType getNetworkType(Context context) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkType(context);
    }

    public static String getNetworkAccessType(Context context) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkAccessType(context);
    }

    public static String getNetworkAccessType(NetworkUtils.NetworkType networkType) {
        return com.bytedance.common.utility.NetworkUtils.getNetworkAccessType(networkType);
    }

    public static void setMonitorProcessHook(NetworkParams.MonitorProcessHook monitorProcessHook) {
        NetworkParams.setMonitorProcessHook(monitorProcessHook);
    }

    public static void setOldMonitorProcessHook(NetworkParams.OldMonitorProcessHook oldMonitorProcessHook) {
        NetworkParams.setOldMonitorProcessHook(oldMonitorProcessHook);
    }

    public static void setNetworkTypeInterceptor(NetworkTypeInterceptor networkTypeInterceptor) {
        sNetworkTypeInterceptor = networkTypeInterceptor;
    }

    public static void setAppContext(Context context) {
        sAppContext = context;
    }

    public static Context getAppContext() {
        return sAppContext;
    }

    public static void setApiRequestInterceptor(NetworkParams.ApiRequestInterceptor apiRequestInterceptor) {
        NetworkParams.setApiRequestInterceptor(apiRequestInterceptor);
    }

    public static NetworkParams.ApiRequestInterceptor getApiRequestInterceptor() {
        return NetworkParams.getApiRequestInterceptor();
    }

    public static void setApiProcessHook(NetworkParams.ApiProcessHook apiProcessHook) {
        NetworkParams.setApiProcessHook(apiProcessHook);
    }

    public static void setDefaultUserAgent(String str) {
        NetworkParams.setDefaultUserAgent(str);
    }

    public static String getUserAgent() {
        return NetworkParams.getUserAgent();
    }

    public static void setUserAgent(HttpParams httpParams) {
        if (httpParams == null) {
            return;
        }
        String userAgent = NetworkParams.getUserAgent();
        if (StringUtils.isEmpty(userAgent)) {
            return;
        }
        HttpProtocolParams.setUserAgent(httpParams, userAgent);
    }

    public static void setAllowKeepAlive(boolean z) {
        mAllowKeepAlive = z;
    }

    public static boolean getAllowKeepAlive() {
        return mAllowKeepAlive;
    }

    public static void setHasRebuildSsl(boolean z) {
        sHasRebuildSsl = z;
    }

    public static boolean getHasRebuildSsl() {
        return sHasRebuildSsl;
    }

    public static String filterUrl(String str) {
        return filterUrl(str, null);
    }

    public static String filterUrl(String str, RequestContext requestContext) {
        return NetworkParams.filterUrl(str, requestContext);
    }

    public static String tryDnsMapping(String str, String[] strArr) {
        int i;
        NetworkParams.ApiRequestInterceptor apiRequestInterceptor;
        if (sUseDnsMapping <= 0 || strArr == null || strArr.length <= 0 || (str != null && str.startsWith("https://"))) {
            return str;
        }
        Context context = sAppContext;
        NetworkUtils.NetworkType networkType = context != null ? getNetworkType(context.getApplicationContext()) : null;
        if (networkType == null) {
            return str;
        }
        if (NetworkUtils.NetworkType.WIFI == networkType) {
            i = 1;
        } else if (NetworkUtils.NetworkType.MOBILE_3G == networkType || NetworkUtils.NetworkType.MOBILE_4G == networkType) {
            i = 2;
        } else {
            i = (NetworkUtils.NetworkType.MOBILE == networkType || NetworkUtils.NetworkType.MOBILE_2G == networkType) ? 4 : 0;
        }
        if ((i & sUseDnsMapping) != 0 && (apiRequestInterceptor = NetworkParams.getApiRequestInterceptor()) != null) {
            String tryDnsMapping = apiRequestInterceptor.tryDnsMapping(str, strArr);
            if (!StringUtils.isEmpty(tryDnsMapping)) {
                return tryDnsMapping;
            }
            strArr[0] = null;
            return str;
        }
        return str;
    }

    public static void setUseDnsMapping(int i) {
        sUseDnsMapping = i;
    }

    public static boolean getUseDnsMapping() {
        return sUseDnsMapping != 0;
    }

    public static String addCommonParams(String str, boolean z) {
        return NetworkParams.addCommonParams(str, z);
    }

    private static String joinCommonParams(String str, List<BasicNameValuePair> list) {
        if (StringUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(URLEncodedUtils.format(list, HTTP.UTF_8));
        return sb.toString();
    }

    public static void putCommonParams(List<BasicNameValuePair> list, boolean z) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        NetworkParams.putCommonParams(linkedHashMap, z);
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry != null && !StringUtils.isEmpty((String) entry.getKey()) && !StringUtils.isEmpty((String) entry.getValue())) {
                list.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
        }
    }

    private static void getOutIp(BaseHttpRequestInfo baseHttpRequestInfo, List<Header> list, Exception exc) {
        String str = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (Header header : list) {
                        if (PNAME_REMOTE_ADDRESS.equalsIgnoreCase(header.getName())) {
                            str = header.getValue();
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (StringUtils.isEmpty(str)) {
            str = RetrofitUtils.getHostAddress(exc);
        }
        if (StringUtils.isEmpty(str) || baseHttpRequestInfo == null) {
            return;
        }
        baseHttpRequestInfo.remoteIp = str;
        if (baseHttpRequestInfo.reqContext != null) {
            baseHttpRequestInfo.reqContext.remoteIp = str;
        }
    }

    /* JADX WARN: Not initialized variable reg: 18, insn: 0x013b: MOVE (r5 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:116:0x0138 */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016f A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:96:0x00f4, B:72:0x0169, B:74:0x016f, B:76:0x0178, B:78:0x017c, B:80:0x0187, B:81:0x018a, B:83:0x018e, B:84:0x0194, B:86:0x019d, B:88:0x01a5, B:89:0x01a7, B:91:0x01ad, B:92:0x01b8, B:93:0x01c3, B:111:0x0116, B:112:0x011d, B:113:0x011e, B:114:0x0136), top: B:26:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0178 A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:96:0x00f4, B:72:0x0169, B:74:0x016f, B:76:0x0178, B:78:0x017c, B:80:0x0187, B:81:0x018a, B:83:0x018e, B:84:0x0194, B:86:0x019d, B:88:0x01a5, B:89:0x01a7, B:91:0x01ad, B:92:0x01b8, B:93:0x01c3, B:111:0x0116, B:112:0x011d, B:113:0x011e, B:114:0x0136), top: B:26:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187 A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:96:0x00f4, B:72:0x0169, B:74:0x016f, B:76:0x0178, B:78:0x017c, B:80:0x0187, B:81:0x018a, B:83:0x018e, B:84:0x0194, B:86:0x019d, B:88:0x01a5, B:89:0x01a7, B:91:0x01ad, B:92:0x01b8, B:93:0x01c3, B:111:0x0116, B:112:0x011d, B:113:0x011e, B:114:0x0136), top: B:26:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x018e A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:96:0x00f4, B:72:0x0169, B:74:0x016f, B:76:0x0178, B:78:0x017c, B:80:0x0187, B:81:0x018a, B:83:0x018e, B:84:0x0194, B:86:0x019d, B:88:0x01a5, B:89:0x01a7, B:91:0x01ad, B:92:0x01b8, B:93:0x01c3, B:111:0x0116, B:112:0x011d, B:113:0x011e, B:114:0x0136), top: B:26:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x019d A[Catch: all -> 0x01c4, TryCatch #1 {all -> 0x01c4, blocks: (B:96:0x00f4, B:72:0x0169, B:74:0x016f, B:76:0x0178, B:78:0x017c, B:80:0x0187, B:81:0x018a, B:83:0x018e, B:84:0x0194, B:86:0x019d, B:88:0x01a5, B:89:0x01a7, B:91:0x01ad, B:92:0x01b8, B:93:0x01c3, B:111:0x0116, B:112:0x011d, B:113:0x011e, B:114:0x0136), top: B:26:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0175  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] downloadFile(int i, final String str) throws Exception {
        LinkedHashMap linkedHashMap;
        Pair parseUrl;
        InputStream inputStream;
        long j;
        Exception exc;
        List list;
        BaseHttpRequestInfo baseHttpRequestInfo;
        Object requestInfo;
        List list2;
        IMetricsCollect iMetricsCollect = null;
        if (StringUtils.isEmpty(str) || (parseUrl = UrlUtils.parseUrl(str, (linkedHashMap = new LinkedHashMap()))) == null) {
            return null;
        }
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        if (iNetworkApi == null) {
            return null;
        }
        boolean z = false;
        try {
            final IMetricsCollect downloadFile = iNetworkApi.downloadFile(false, i, str3, linkedHashMap);
            try {
                if (!com.bytedance.common.utility.NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext())) {
                    try {
                        StreamParser.safeClose((Closeable) null);
                        if (downloadFile != null) {
                            downloadFile.cancel();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                NetworkParams.CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook = NetworkParams.getCdnConnectionQualitySamplerHook();
                if (cdnConnectionQualitySamplerHook != null && cdnConnectionQualitySamplerHook.cdnShouldSampling(str)) {
                    CdnDeviceBandwidthSampler.getInstance().startSampling();
                    z = true;
                }
                boolean z2 = z;
                try {
                    SsResponse execute = downloadFile.execute();
                    try {
                        if (execute == null) {
                            if (z2) {
                                CdnDeviceBandwidthSampler.getInstance().stopSampling();
                            }
                            try {
                                StreamParser.safeClose((Closeable) null);
                                if (downloadFile != null) {
                                    downloadFile.cancel();
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            return null;
                        }
                        try {
                            j = System.currentTimeMillis();
                            try {
                                Object extraInfo = execute.raw().getExtraInfo();
                                baseHttpRequestInfo = extraInfo instanceof BaseHttpRequestInfo ? (BaseHttpRequestInfo) extraInfo : null;
                                try {
                                    TypedInput typedInput = (TypedInput) execute.body();
                                    InputStream in = typedInput != null ? typedInput.in() : null;
                                    try {
                                        try {
                                            list = execute.headers();
                                            try {
                                                IMetricsCollect headerValueIgnoreCase = RetrofitUtils.getHeaderValueIgnoreCase(list, TTTokenMonitor.TT_LOGID_KEY);
                                                try {
                                                    getOutIp(baseHttpRequestInfo, list, null);
                                                    int code = execute.code();
                                                    if (baseHttpRequestInfo != null) {
                                                        try {
                                                            baseHttpRequestInfo.completeReadResponse = j;
                                                        } catch (Exception e) {
                                                            e = e;
                                                            iMetricsCollect = headerValueIgnoreCase;
                                                            exc = e;
                                                            if (StringUtils.isEmpty(iMetricsCollect)) {
                                                            }
                                                            if (baseHttpRequestInfo == null) {
                                                            }
                                                            if (downloadFile instanceof IMetricsCollect) {
                                                            }
                                                            getOutIp(baseHttpRequestInfo, list, exc);
                                                            long currentTimeMillis2 = System.currentTimeMillis();
                                                            if (baseHttpRequestInfo != null) {
                                                            }
                                                            IMetricsCollect iMetricsCollect2 = r8;
                                                            Exception exc2 = exc;
                                                            NetworkParams.monitorApiError(currentTimeMillis2 - currentTimeMillis, currentTimeMillis, str, iMetricsCollect2, baseHttpRequestInfo, exc2);
                                                            throw exc2;
                                                        }
                                                    }
                                                    try {
                                                        if (code != 200 || typedInput == null) {
                                                            if (code == 200 && typedInput == null) {
                                                                throw new IllegalArgumentException("HTTP TypedInput may not be null");
                                                            }
                                                            throw new HttpResponseException(code, "get url = " + str + " exception");
                                                        }
                                                        byte[] stream2ByteArray = StreamParser.stream2ByteArray(i, in, typedInput.length(), new RequestHandler() { // from class: com.ss.android.common.util.NetworkUtils.1
                                                            public URI getURI() {
                                                                return URI.create(str);
                                                            }

                                                            public void abort() {
                                                                try {
                                                                    Call call = downloadFile;
                                                                    if (call != null) {
                                                                        call.cancel();
                                                                    }
                                                                } catch (Throwable unused) {
                                                                }
                                                            }
                                                        });
                                                        if (downloadFile instanceof IMetricsCollect) {
                                                            downloadFile.doCollect();
                                                        }
                                                        long currentTimeMillis3 = System.currentTimeMillis();
                                                        if (baseHttpRequestInfo != null) {
                                                            baseHttpRequestInfo.requestEnd = currentTimeMillis3;
                                                        }
                                                        InputStream inputStream2 = in;
                                                        NetworkParams.monitorApiSample(currentTimeMillis3 - currentTimeMillis, currentTimeMillis, str, headerValueIgnoreCase, baseHttpRequestInfo);
                                                        if (z2) {
                                                            CdnDeviceBandwidthSampler.getInstance().stopSampling();
                                                        }
                                                        try {
                                                            StreamParser.safeClose(inputStream2);
                                                            if (downloadFile != null) {
                                                                downloadFile.cancel();
                                                            }
                                                        } catch (Throwable th3) {
                                                            th3.printStackTrace();
                                                        }
                                                        return stream2ByteArray;
                                                    } catch (Exception e2) {
                                                        exc = e2;
                                                        iMetricsCollect = headerValueIgnoreCase;
                                                        list = list2;
                                                        IMetricsCollect headerValueIgnoreCase2 = StringUtils.isEmpty(iMetricsCollect) ? RetrofitUtils.getHeaderValueIgnoreCase(list, TTTokenMonitor.TT_LOGID_KEY) : iMetricsCollect;
                                                        if (baseHttpRequestInfo == null && (downloadFile instanceof IRequestInfo)) {
                                                            requestInfo = ((IRequestInfo) downloadFile).getRequestInfo();
                                                            if (requestInfo instanceof BaseHttpRequestInfo) {
                                                                baseHttpRequestInfo = (BaseHttpRequestInfo) requestInfo;
                                                            }
                                                        }
                                                        if (downloadFile instanceof IMetricsCollect) {
                                                            downloadFile.doCollect();
                                                        }
                                                        getOutIp(baseHttpRequestInfo, list, exc);
                                                        long currentTimeMillis22 = System.currentTimeMillis();
                                                        if (baseHttpRequestInfo != null) {
                                                            if (baseHttpRequestInfo.completeReadResponse <= 0) {
                                                                baseHttpRequestInfo.completeReadResponse = j;
                                                            }
                                                            baseHttpRequestInfo.requestEnd = currentTimeMillis22;
                                                            if (baseHttpRequestInfo.extraInfo != null) {
                                                                baseHttpRequestInfo.extraInfo.put("ex", exc.getMessage());
                                                            }
                                                        }
                                                        IMetricsCollect iMetricsCollect22 = headerValueIgnoreCase2;
                                                        Exception exc22 = exc;
                                                        NetworkParams.monitorApiError(currentTimeMillis22 - currentTimeMillis, currentTimeMillis, str, iMetricsCollect22, baseHttpRequestInfo, exc22);
                                                        throw exc22;
                                                    }
                                                } catch (Exception e3) {
                                                    exc = e3;
                                                    iMetricsCollect = headerValueIgnoreCase;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                            }
                                        } catch (Exception e5) {
                                            exc = e5;
                                            list = null;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        inputStream = in;
                                        iMetricsCollect = downloadFile;
                                        z = z2;
                                        try {
                                            if (th instanceof Exception) {
                                                throw th;
                                            }
                                            throw new Exception(th.getMessage(), th.getCause());
                                        } finally {
                                        }
                                    }
                                } catch (Exception e6) {
                                    exc = e6;
                                    list = null;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                exc = e;
                                list = null;
                                baseHttpRequestInfo = null;
                                if (StringUtils.isEmpty(iMetricsCollect)) {
                                }
                                if (baseHttpRequestInfo == null) {
                                    requestInfo = ((IRequestInfo) downloadFile).getRequestInfo();
                                    if (requestInfo instanceof BaseHttpRequestInfo) {
                                    }
                                }
                                if (downloadFile instanceof IMetricsCollect) {
                                }
                                getOutIp(baseHttpRequestInfo, list, exc);
                                long currentTimeMillis222 = System.currentTimeMillis();
                                if (baseHttpRequestInfo != null) {
                                }
                                IMetricsCollect iMetricsCollect222 = headerValueIgnoreCase2;
                                Exception exc222 = exc;
                                NetworkParams.monitorApiError(currentTimeMillis222 - currentTimeMillis, currentTimeMillis, str, iMetricsCollect222, baseHttpRequestInfo, exc222);
                                throw exc222;
                            }
                        } catch (Exception e8) {
                            e = e8;
                            j = -1;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                iMetricsCollect = downloadFile;
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    @Deprecated
    public static boolean downloadFile(int i, String str, String str2, String str3, String str4, IDownloadPublisher<String> iDownloadPublisher, String str5, TaskInfo taskInfo, List<BasicNameValuePair> list, String[] strArr, int[] iArr) throws Exception {
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            for (BasicNameValuePair basicNameValuePair : list) {
                linkedList.add(new Header(basicNameValuePair.getName(), basicNameValuePair.getValue()));
            }
        }
        return RetrofitUtils.downloadFile(i, str, str2, str3, str4, iDownloadPublisher, str5, taskInfo, linkedList, strArr, iArr);
    }

    @Deprecated
    public static String executeGet(int i, String str) throws Exception {
        return executeGet(i, str, true, true);
    }

    @Deprecated
    public static String executeGet(int i, String str, boolean z) throws Exception {
        return executeGet(i, str, z, true);
    }

    @Deprecated
    public static String executeGet(int i, String str, boolean z, boolean z2) throws Exception {
        return executeGet(i, str, z, z2, null, null, true, null);
    }

    @Deprecated
    public static String executeGet(int i, String str, boolean z, boolean z2, List<com.ss.android.http.legacy.Header> list, HeaderGroup headerGroup, boolean z3, RequestContext requestContext) throws Exception {
        NetworkResponseInfo executeGetResult = executeGetResult(i, str, z, z2, list, headerGroup, z3, requestContext);
        if (executeGetResult != null) {
            return executeGetResult.getResult();
        }
        return null;
    }

    @Deprecated
    public static NetworkResponseInfo executeGetResult(int i, String str, boolean z, boolean z2, List<com.ss.android.http.legacy.Header> list, HeaderGroup headerGroup, boolean z3, RequestContext requestContext) throws Exception {
        List<Header> headers;
        NetworkResponseInfo networkResponseInfo = new NetworkResponseInfo();
        if (StringUtils.isEmpty(str)) {
            networkResponseInfo.setResult(null);
            return networkResponseInfo;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        if (parseUrl == null) {
            networkResponseInfo.setResult(null);
            return networkResponseInfo;
        }
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            for (com.ss.android.http.legacy.Header header : list) {
                linkedList.add(new Header(header.getName(), header.getValue()));
            }
        }
        if (iNetworkApi != null) {
            SsResponse execute = iNetworkApi.doGet(z2, i, str3, linkedHashMap, linkedList, requestContext).execute();
            if (headerGroup != null && (headers = execute.headers()) != null && !headers.isEmpty()) {
                for (Header header2 : headers) {
                    String name = header2.getName();
                    if (HNAME_ETAG.equalsIgnoreCase(name) || "Last-Modified".equalsIgnoreCase(name) || "Cache-Control".equalsIgnoreCase(name)) {
                        headerGroup.addHeader(new BasicHeader(header2.getName(), header2.getValue()));
                    }
                }
            }
            networkResponseInfo.setResult((String) execute.body());
            networkResponseInfo.setResultCode(execute.code());
        }
        return networkResponseInfo;
    }

    @Deprecated
    public static String executePost(int i, String str, List<BasicNameValuePair> list) throws Exception {
        return executePost(i, str, list, (IRequestHolder[]) null, (RequestContext) null);
    }

    @Deprecated
    public static String executePost(int i, String str, List<BasicNameValuePair> list, IRequestHolder[] iRequestHolderArr) throws Exception {
        return executePost(i, str, list, iRequestHolderArr, (RequestContext) null);
    }

    @Deprecated
    public static String executePost(int i, String str, List<BasicNameValuePair> list, IRequestHolder[] iRequestHolderArr, RequestContext requestContext) throws Exception {
        LinkedHashMap linkedHashMap;
        Pair parseUrl;
        if (StringUtils.isEmpty(str) || (parseUrl = UrlUtils.parseUrl(str, (linkedHashMap = new LinkedHashMap()))) == null) {
            return null;
        }
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            for (BasicNameValuePair basicNameValuePair : list) {
                linkedHashMap2.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
            }
        }
        NetworkParams.putCommonParams(linkedHashMap2, true);
        removeL0Params(list, linkedHashMap2);
        if (iNetworkApi == null) {
            return null;
        }
        final Call doPost = iNetworkApi.doPost(i, str3, linkedHashMap, linkedHashMap2, (List) null, requestContext);
        if (iRequestHolderArr != null && iRequestHolderArr.length > 0) {
            iRequestHolderArr[0] = new IRequestHolder() { // from class: com.ss.android.common.util.NetworkUtils.2
                public void abort() {
                    doPost.cancel();
                }
            };
        }
        return (String) doPost.execute().body();
    }

    @Deprecated
    public static String postFile(int i, String str, String str2, String str3, Map<String, String> map, IRequestHolder[] iRequestHolderArr) throws Exception {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), new TypedString(entry.getValue()));
            }
        }
        linkedHashMap.put(str2, new TypedFile((String) null, new File(str3)));
        return executePost(i, str, linkedHashMap, iRequestHolderArr, new com.ss.android.http.legacy.Header[0]);
    }

    @Deprecated
    public static String postData(int i, String str, String str2, byte[] bArr, String str3, Map<String, String> map, IRequestHolder[] iRequestHolderArr, com.ss.android.http.legacy.Header... headerArr) throws Exception {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), new TypedString(entry.getValue()));
            }
        }
        linkedHashMap.put(str2, new TypedByteArray((String) null, bArr, new String[]{str3}));
        return executePost(i, str, linkedHashMap, iRequestHolderArr, headerArr);
    }

    @Deprecated
    public static String postFile(int i, String str, String str2, String str3) throws Exception {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(str2, new TypedFile((String) null, new File(str3)));
        return executePost(i, str, linkedHashMap, (IRequestHolder[]) null, new com.ss.android.http.legacy.Header[0]);
    }

    @Deprecated
    public static String executePost(int i, String str, Map<String, TypedOutput> map) throws Exception {
        return executePost(i, str, map, (IRequestHolder[]) null, new com.ss.android.http.legacy.Header[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public static String executePost(int i, String str, Map<String, TypedOutput> map, IRequestHolder[] iRequestHolderArr, com.ss.android.http.legacy.Header... headerArr) throws Exception {
        LinkedHashMap linkedHashMap;
        Pair parseUrl;
        if (StringUtils.isEmpty(str) || (parseUrl = UrlUtils.parseUrl(str, (linkedHashMap = new LinkedHashMap()))) == null) {
            return null;
        }
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedList linkedList = new LinkedList();
        if (headerArr != null && headerArr.length != 0) {
            for (com.ss.android.http.legacy.Header header : headerArr) {
                linkedList.add(new Header(header.getName(), header.getValue()));
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        NetworkParams.putCommonParams(linkedHashMap2, true);
        removeL0Params(null, linkedHashMap2);
        if (!linkedHashMap2.isEmpty()) {
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                if (entry != null) {
                    map.put(entry.getKey(), new TypedString((String) entry.getValue()));
                }
            }
        }
        if (iNetworkApi == null) {
            return null;
        }
        final Call postMultiPart = iNetworkApi.postMultiPart(i, str3, linkedHashMap, map, linkedList);
        if (iRequestHolderArr != null && iRequestHolderArr.length > 0) {
            iRequestHolderArr[0] = new IRequestHolder() { // from class: com.ss.android.common.util.NetworkUtils.3
                public void abort() {
                    postMultiPart.cancel();
                }
            };
        }
        return (String) postMultiPart.execute().body();
    }

    @Deprecated
    public static String executePost(int i, String str, byte[] bArr, NetworkUtils.CompressType compressType, String str2) throws Exception {
        Pair<byte[], String> tryCompressData;
        if (StringUtils.isEmpty(str) || (tryCompressData = tryCompressData(bArr, compressType)) == null) {
            return null;
        }
        byte[] bArr2 = (byte[]) tryCompressData.first;
        String str3 = (String) tryCompressData.second;
        ArrayList arrayList = new ArrayList();
        if (str3 != null) {
            arrayList.add(new Header("Content-Encoding", str3));
        }
        if (str2 != null && str2.length() > 0) {
            arrayList.add(new Header("Content-Type", str2));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        if (parseUrl == null) {
            return null;
        }
        String str4 = (String) parseUrl.first;
        String str5 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str4, INetworkApi.class);
        if (iNetworkApi != null) {
            return (String) iNetworkApi.postBody(i, str5, linkedHashMap, new TypedByteArray((String) null, bArr2, new String[0]), arrayList).execute().body();
        }
        return null;
    }

    public static Pair<byte[], String> tryCompressData(byte[] bArr, NetworkUtils.CompressType compressType) throws IOException {
        int length;
        String str = null;
        if (bArr == null) {
            new Pair(bArr, null);
        }
        if (bArr == null) {
            length = 0;
        } else {
            try {
                length = bArr.length;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (NetworkUtils.CompressType.GZIP == compressType && length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                str = DownloadHelper.GZIP;
            } catch (Throwable th2) {
                try {
                    Logger.w(TAG, "compress with gzip exception: " + th2);
                    return new Pair<>(bArr, null);
                } finally {
                    gZIPOutputStream.close();
                }
            }
        } else if (NetworkUtils.CompressType.DEFLATER == compressType && length > 128) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(8192);
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr2 = new byte[8192];
            while (!deflater.finished()) {
                byteArrayOutputStream2.write(bArr2, 0, deflater.deflate(bArr2));
            }
            deflater.end();
            bArr = byteArrayOutputStream2.toByteArray();
            str = "deflate";
        }
        return new Pair<>(bArr, str);
    }

    public static byte[] executeRequestForGetPost(String str, List<BasicNameValuePair> list, Map<String, String> map, Map<String, String> map2, IRequestHolder[] iRequestHolderArr) throws Throwable {
        final Call doPost;
        List<Header> headers;
        if (StringUtils.isEmpty(str)) {
            return new byte[0];
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        if (parseUrl == null) {
            return new byte[0];
        }
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        if (iNetworkApi == null) {
            return new byte[0];
        }
        LinkedList linkedList = new LinkedList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        if (list == null) {
            doPost = iNetworkApi.doGet(true, -1, str3, linkedHashMap, linkedList, (Object) null);
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            if (list != null && !list.isEmpty()) {
                for (BasicNameValuePair basicNameValuePair : list) {
                    linkedHashMap2.put(basicNameValuePair.getName(), basicNameValuePair.getValue());
                }
            }
            NetworkParams.putCommonParams(linkedHashMap2, true);
            removeL0Params(list, linkedHashMap2);
            doPost = iNetworkApi.doPost(-1, str3, linkedHashMap, linkedHashMap2, linkedList, (Object) null);
        }
        if (iRequestHolderArr != null && iRequestHolderArr.length > 0) {
            iRequestHolderArr[0] = new IRequestHolder() { // from class: com.ss.android.common.util.NetworkUtils.4
                public void abort() {
                    doPost.cancel();
                }
            };
        }
        SsResponse execute = doPost.execute();
        if (map2 != null && (headers = execute.headers()) != null && headers.size() > 0) {
            for (Header header : headers) {
                map2.put(header.getName(), header.getValue());
            }
        }
        String str4 = (String) execute.body();
        return str4 == null ? new byte[0] : str4.getBytes();
    }

    public static CookieManager tryNecessaryInit() {
        return NetworkParams.tryNecessaryInit();
    }

    public static void monitorApiError(long j, long j2, String str, String str2, HttpRequestInfo httpRequestInfo, Throwable th) {
        NetworkParams.monitorApiError(j, j2, str, str2, httpRequestInfo, th);
    }

    public static void monitorApiSample(long j, long j2, String str, String str2, HttpRequestInfo httpRequestInfo) {
        NetworkParams.monitorApiSample(j, j2, str, str2, httpRequestInfo);
    }

    public static String getNetworkOperatorCode(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "unkown";
        }
    }

    public static void addCacheValidationHeaders(List<com.ss.android.http.legacy.Header> list, String str, String str2) {
        if (list == null) {
            return;
        }
        if (!StringUtils.isEmpty(str)) {
            list.add(new BasicHeader("If-None-Match", str));
        }
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        list.add(new BasicHeader(HNAME_IF_MODIFIED_SINCE, str2));
    }

    public static Pair<String, String> parseContentType(String str) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        HeaderElement[] elements = new BasicHeader("Content-Type", str).getElements();
        if (elements.length == 0) {
            return null;
        }
        int i = 0;
        HeaderElement headerElement = elements[0];
        String name = headerElement.getName();
        NameValuePair[] parameters = headerElement.getParameters();
        if (parameters != null) {
            int length = parameters.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                NameValuePair nameValuePair = parameters[i];
                if ("charset".equalsIgnoreCase(nameValuePair.getName())) {
                    str2 = nameValuePair.getValue();
                    break;
                }
                i++;
            }
        }
        return new Pair<>(name, str2);
    }

    public static String getEtag(HeaderGroup headerGroup) {
        com.ss.android.http.legacy.Header firstHeader;
        if (headerGroup == null || (firstHeader = headerGroup.getFirstHeader(HNAME_ETAG)) == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public static String getLastModified(HeaderGroup headerGroup) {
        com.ss.android.http.legacy.Header firstHeader;
        if (headerGroup == null || (firstHeader = headerGroup.getFirstHeader("Last-Modified")) == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public static long extractMaxAge(HeaderGroup headerGroup) {
        com.ss.android.http.legacy.Header firstHeader;
        if (headerGroup == null || (firstHeader = headerGroup.getFirstHeader("Cache-Control")) == null) {
            return -1L;
        }
        try {
            HeaderElement[] elements = firstHeader.getElements();
            if (elements != null) {
                for (HeaderElement headerElement : elements) {
                    if (ENAME_MAX_AGE.equals(headerElement.getName())) {
                        String value = headerElement.getValue();
                        if (value != null) {
                            return Long.parseLong(value);
                        }
                        return -1L;
                    }
                }
            }
        } catch (Exception e) {
            Logger.w(TAG, "extract max-age exception: " + e);
        }
        return -1L;
    }

    public static void setTimeout(URLConnection uRLConnection) {
        if (uRLConnection != null) {
            uRLConnection.setConnectTimeout(15000);
            uRLConnection.setReadTimeout(15000);
        }
    }
}
