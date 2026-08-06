package com.bytedance.ttnet.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.connectionclass.CdnDeviceBandwidthSampler;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.RequestHandler;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.parser.CacheControlParser;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.RequestVertifyInterceptor;
import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.frameworks.baselib.network.http.retrofit.converter.gson.GsonConverterFactory;
import com.bytedance.frameworks.baselib.network.http.util.IDownloadPublisher;
import com.bytedance.frameworks.baselib.network.http.util.LRUCache;
import com.bytedance.frameworks.baselib.network.http.util.TaskInfo;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallAdapter;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.IRequestInfo;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
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
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RetrofitUtils {
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String CONTENT_TYPE_JSON = "application/json; charset=utf-8";
    public static final String HNAME_CACHE_CONTROL = "Cache-Control";
    public static final String HNAME_ETAG = "ETag";
    public static final String HNAME_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HNAME_IF_NONE_MATCH = "If-None-Match";
    public static final String HNAME_LAST_MODIFIED = "Last-Modified";
    public static final int IO_TIMEOUT = 15000;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    private static final String TAG = "RetrofitUtils";
    private static volatile CopyOnWriteArrayList<Interceptor> sInterceptors = new CopyOnWriteArrayList<>();
    private static LRUCache<String, Retrofit> sOKRetrofitCache;
    private static LRUCache<String, Retrofit> sRetrofitCache;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum CompressType {
        NONE(0),
        GZIP(1),
        DEFLATER(2);

        final int nativeInt;

        CompressType(int i) {
            this.nativeInt = i;
        }
    }

    private static void getOutIp(BaseHttpRequestInfo baseHttpRequestInfo, String[] strArr, List<Header> list, RequestContext requestContext, Exception exc) {
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
        if (StringUtils.isEmpty(str) && requestContext != null) {
            str = requestContext.remoteIp;
        }
        if (StringUtils.isEmpty(str)) {
            str = getHostAddress(exc);
        }
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (strArr != null && strArr.length > 0) {
            strArr[0] = str;
        }
        if (baseHttpRequestInfo != null) {
            baseHttpRequestInfo.remoteIp = str;
            if (baseHttpRequestInfo.reqContext != null) {
                baseHttpRequestInfo.reqContext.remoteIp = str;
            }
        }
    }

    public static String getHostAddress(Exception exc) {
        if (exc == null) {
            return "";
        }
        try {
            String[] split = exc.getMessage().split("\\|");
            if (split != null && split.length >= 2) {
                if (Logger.debug()) {
                    Logger.d(TAG, "getHostAddress remoteIp = " + split[0]);
                }
                return split[0];
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "";
    }

    public static String getHeaderValueIgnoreCase(List<Header> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        for (Header header : list) {
            if (str.equalsIgnoreCase(header.getName())) {
                return header.getValue();
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0187 A[Catch: all -> 0x0199, TryCatch #8 {all -> 0x0199, blocks: (B:92:0x0183, B:94:0x0187, B:97:0x0198, B:96:0x018a), top: B:91:0x0183 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018a A[Catch: all -> 0x0199, TryCatch #8 {all -> 0x0199, blocks: (B:92:0x0183, B:94:0x0187, B:97:0x0198, B:96:0x018a), top: B:91:0x0183 }] */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean downloadFile(int i, final String str, String str2, String str3, String str4, IDownloadPublisher<String> iDownloadPublisher, String str5, TaskInfo taskInfo, List<Header> list, String[] strArr, int[] iArr) throws Exception {
        Map<String, String> linkedHashMap;
        Pair parseUrl;
        InputStream inputStream;
        boolean z;
        TypedInput body;
        List<Header> headers;
        boolean z2 = false;
        if (StringUtils.isEmpty(str) || (parseUrl = UrlUtils.parseUrl(str, (linkedHashMap = new LinkedHashMap<>()))) == null) {
            return false;
        }
        String str6 = (String) parseUrl.first;
        String str7 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) createSsService(str6, INetworkApi.class);
        RequestContext requestContext = new RequestContext();
        if (iNetworkApi == null) {
            return false;
        }
        Call<TypedInput> call = null;
        r13 = null;
        List<Header> list2 = null;
        try {
            final Call<TypedInput> downloadFile = iNetworkApi.downloadFile(false, i, str7, linkedHashMap, list, requestContext);
            if (taskInfo != null) {
                try {
                    if (taskInfo.isCanceled()) {
                        try {
                            StreamParser.safeClose((Closeable) null);
                            if (downloadFile != null) {
                                downloadFile.cancel();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = null;
                    call = downloadFile;
                    try {
                        if (th instanceof Exception) {
                        }
                    } finally {
                    }
                }
            }
            if (!NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext())) {
                try {
                    StreamParser.safeClose((Closeable) null);
                    if (downloadFile != null) {
                        downloadFile.cancel();
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return false;
            }
            BaseHttpRequestInfo createHttpRequestInfo = BaseHttpRequestInfo.createHttpRequestInfo();
            NetworkParams.CdnConnectionQualitySamplerHook cdnConnectionQualitySamplerHook = NetworkParams.getCdnConnectionQualitySamplerHook();
            if (cdnConnectionQualitySamplerHook == null || !cdnConnectionQualitySamplerHook.cdnShouldSampling(str)) {
                z = false;
            } else {
                CdnDeviceBandwidthSampler.getInstance().startSampling();
                z = true;
            }
            try {
                SsResponse<TypedInput> execute = downloadFile.execute();
                if (execute == null) {
                    if (z) {
                        CdnDeviceBandwidthSampler.getInstance().stopSampling();
                    }
                    try {
                        StreamParser.safeClose((Closeable) null);
                        if (downloadFile != null) {
                            downloadFile.cancel();
                        }
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    return false;
                }
                try {
                    Object extraInfo = execute.raw().getExtraInfo();
                    if (extraInfo instanceof BaseHttpRequestInfo) {
                        createHttpRequestInfo = (BaseHttpRequestInfo) extraInfo;
                    }
                    body = execute.body();
                    inputStream = body != null ? body.mo349in() : null;
                } catch (Exception e) {
                    e = e;
                }
                try {
                    try {
                        headers = execute.headers();
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        getOutIp(createHttpRequestInfo, strArr, headers, requestContext, null);
                        int code = execute.code();
                        if (code != 200 || body == null) {
                            if (code == 200 && body == null) {
                                throw new IllegalArgumentException("HTTP TypedInput may not be null");
                            }
                            throw new HttpResponseException(code, "get url = " + str + " exception");
                        }
                        long length = body.length();
                        if (iArr != null && iArr.length > 0) {
                            iArr[0] = 0;
                            if (length <= 2147483647L) {
                                iArr[0] = (int) length;
                            }
                        }
                        boolean stream2File = StreamParser.stream2File(inputStream, body.length(), new RequestHandler() { // from class: com.bytedance.ttnet.utils.RetrofitUtils.1
                            public URI getURI() {
                                try {
                                    return URIUtils.safeCreateUri(str);
                                } catch (RuntimeException unused) {
                                    return null;
                                }
                            }

                            public void abort() {
                                try {
                                    Call call2 = downloadFile;
                                    if (call2 != null) {
                                        call2.cancel();
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }, i, str2, str3, str4, iDownloadPublisher, str5, taskInfo);
                        if (z) {
                            CdnDeviceBandwidthSampler.getInstance().stopSampling();
                        }
                        try {
                            StreamParser.safeClose(inputStream);
                            if (downloadFile != null) {
                                downloadFile.cancel();
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        return stream2File;
                    } catch (Exception e3) {
                        e = e3;
                        list2 = headers;
                        if (createHttpRequestInfo == null && (downloadFile instanceof IRequestInfo)) {
                            Object requestInfo = ((IRequestInfo) downloadFile).getRequestInfo();
                            if (requestInfo instanceof BaseHttpRequestInfo) {
                                createHttpRequestInfo = (BaseHttpRequestInfo) requestInfo;
                            }
                        }
                        getOutIp(createHttpRequestInfo, strArr, list2, requestContext, e);
                        if (createHttpRequestInfo != null && createHttpRequestInfo.extraInfo != null) {
                            createHttpRequestInfo.extraInfo.put("ex", e.getMessage());
                        }
                        throw e;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    call = downloadFile;
                    z2 = z;
                    if (th instanceof Exception) {
                        throw th;
                    }
                    throw new Exception(th.getMessage(), th.getCause());
                }
            } catch (Throwable th7) {
                th = th7;
                z2 = z;
                inputStream = null;
                call = downloadFile;
                if (th instanceof Exception) {
                }
            }
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
        }
    }

    public static Pair<byte[], String> tryCompressData(byte[] bArr, CompressType compressType) throws IOException {
        String str;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        if (CompressType.GZIP == compressType && length > 128) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                str = "gzip";
            } catch (Throwable th) {
                try {
                    Logger.w(TAG, "compress with gzip exception: " + th);
                    return null;
                } finally {
                    gZIPOutputStream.close();
                }
            }
        } else if (CompressType.DEFLATER != compressType || length <= 128) {
            str = null;
        } else {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(8192);
            Deflater deflater = new Deflater();
            deflater.setInput(bArr);
            deflater.finish();
            byte[] bArr3 = new byte[8192];
            while (!deflater.finished()) {
                byteArrayOutputStream2.write(bArr3, 0, deflater.deflate(bArr3));
            }
            deflater.end();
            bArr2 = byteArrayOutputStream2.toByteArray();
            str = "deflate";
        }
        return new Pair<>(bArr2, str);
    }

    public static void addCacheValidationHeaders(List<Header> list, String str, String str2) {
        if (list == null) {
            return;
        }
        if (!StringUtils.isEmpty(str)) {
            list.add(new Header(HNAME_IF_NONE_MATCH, str));
        }
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        list.add(new Header(HNAME_IF_MODIFIED_SINCE, str2));
    }

    public static Pair<String, String> parseContentType(String str) {
        String str2;
        String str3 = null;
        if (str == null) {
            return null;
        }
        try {
            MimeType mimeType = new MimeType(str);
            str2 = mimeType.getBaseType();
            try {
                str3 = mimeType.getParameter("charset");
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return new Pair<>(str2, str3);
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
        return new Pair<>(str2, str3);
    }

    public static String getEtag(List<Header> list) {
        Header firstHeader;
        if (list == null || (firstHeader = getFirstHeader(list, HNAME_ETAG)) == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public static String getLastModified(List<Header> list) {
        Header firstHeader;
        if (list == null || (firstHeader = getFirstHeader(list, HNAME_LAST_MODIFIED)) == null) {
            return null;
        }
        return firstHeader.getValue();
    }

    public static Header getFirstHeader(List<Header> list, String str) {
        if (list != null && !StringUtils.isEmpty(str)) {
            for (Header header : list) {
                if (str.equalsIgnoreCase(header.getName())) {
                    return header;
                }
            }
        }
        return null;
    }

    public static long extractMaxAge(List<Header> list) {
        Header firstHeader;
        if (list == null || (firstHeader = getFirstHeader(list, HNAME_CACHE_CONTROL)) == null) {
            return -1L;
        }
        try {
            String value = new CacheControlParser(firstHeader.getValue()).getValue(CacheControlParser.Directive.MAXAGE);
            if (value != null) {
                return Long.parseLong(value);
            }
            return -1L;
        } catch (Exception e) {
            Logger.w(TAG, "extract max-age exception: " + e);
            return -1L;
        }
    }

    public static void setTimeout(URLConnection uRLConnection) {
        if (uRLConnection != null) {
            uRLConnection.setConnectTimeout(15000);
            uRLConnection.setReadTimeout(15000);
        }
    }

    static {
        Retrofit.setCommonInterceptor(sInterceptors);
        sRetrofitCache = new LRUCache<>(10);
        sOKRetrofitCache = new LRUCache<>(10);
    }

    public static synchronized void addInterceptor(Interceptor interceptor) {
        synchronized (RetrofitUtils.class) {
            if (interceptor == null) {
                return;
            }
            if (!sInterceptors.contains(interceptor)) {
                sInterceptors.add(interceptor);
            }
            TtnetUtil.safeAddInterceptorInRetrofitCache(sRetrofitCache, interceptor);
            TtnetUtil.safeAddInterceptorInRetrofitCache(sOKRetrofitCache, interceptor);
        }
    }

    public static synchronized void removeInterceptor(Interceptor interceptor) {
        synchronized (RetrofitUtils.class) {
            if (interceptor == null) {
                return;
            }
            if (sInterceptors.contains(interceptor)) {
                sInterceptors.remove(interceptor);
                TtnetUtil.safeRemoveInterceptorInRetrofitCache(sRetrofitCache, interceptor);
                TtnetUtil.safeRemoveInterceptorInRetrofitCache(sOKRetrofitCache, interceptor);
            }
        }
    }

    public static synchronized Retrofit getSsRetrofit(String str) {
        synchronized (RetrofitUtils.class) {
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            Retrofit retrofit = (Retrofit) sRetrofitCache.get(str);
            if (retrofit != null) {
                return retrofit;
            }
            Retrofit createSsRetrofit = createSsRetrofit(str, null, null, null);
            sRetrofitCache.put(str, createSsRetrofit);
            return createSsRetrofit;
        }
    }

    public static synchronized Retrofit createSsRetrofit(String str, List<Interceptor> list, Converter.Factory factory) {
        Retrofit createSsRetrofit;
        synchronized (RetrofitUtils.class) {
            createSsRetrofit = createSsRetrofit(str, list, factory, null);
        }
        return createSsRetrofit;
    }

    public static synchronized Retrofit createSsRetrofit(String str, List<Interceptor> list, Converter.Factory factory, CallAdapter.Factory factory2) {
        Retrofit createRetrofit;
        synchronized (RetrofitUtils.class) {
            createRetrofit = createRetrofit(str, list, factory, factory2, new Client.Provider() { // from class: com.bytedance.ttnet.utils.RetrofitUtils.2
                @Override // com.bytedance.retrofit2.client.Client.Provider
                public Client get() {
                    return new SsRetrofitClient();
                }
            });
        }
        return createRetrofit;
    }

    public static synchronized Retrofit createTTNetRetrofit(String str, List<Interceptor> list, List<Converter.Factory> list2, List<CallAdapter.Factory> list3) {
        Retrofit createRetrofit;
        synchronized (RetrofitUtils.class) {
            createRetrofit = createRetrofit(list, list2, list3, new Client.Provider() { // from class: com.bytedance.ttnet.utils.RetrofitUtils.3
                @Override // com.bytedance.retrofit2.client.Client.Provider
                public Client get() {
                    return new SsRetrofitClient();
                }
            }, str);
        }
        return createRetrofit;
    }

    @Deprecated
    public static synchronized Retrofit getOkRetrofit(String str) {
        synchronized (RetrofitUtils.class) {
            if (StringUtils.isEmpty(str)) {
                return null;
            }
            Retrofit retrofit = (Retrofit) sOKRetrofitCache.get(str);
            if (retrofit != null) {
                return retrofit;
            }
            Retrofit createOkRetrofit = createOkRetrofit(str, null, null, null);
            sOKRetrofitCache.put(str, createOkRetrofit);
            return createOkRetrofit;
        }
    }

    @Deprecated
    public static synchronized Retrofit createOkRetrofit(String str, List<Interceptor> list, Converter.Factory factory, CallAdapter.Factory factory2) {
        Retrofit createRetrofit;
        synchronized (RetrofitUtils.class) {
            createRetrofit = createRetrofit(str, list, factory, factory2, new Client.Provider() { // from class: com.bytedance.ttnet.utils.RetrofitUtils.4
                @Override // com.bytedance.retrofit2.client.Client.Provider
                public Client get() {
                    return new SsRetrofitClient();
                }
            });
        }
        return createRetrofit;
    }

    public static synchronized Retrofit createRetrofit(String str, List<Interceptor> list, Converter.Factory factory, CallAdapter.Factory factory2, Client.Provider provider) {
        ArrayList arrayList;
        Retrofit createRetrofit;
        synchronized (RetrofitUtils.class) {
            ArrayList arrayList2 = null;
            if (factory != null) {
                try {
                    arrayList = new ArrayList();
                    arrayList.add(factory);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                arrayList = null;
            }
            if (factory2 != null) {
                arrayList2 = new ArrayList();
                arrayList2.add(factory2);
            }
            createRetrofit = createRetrofit(list, arrayList, arrayList2, provider, str);
        }
        return createRetrofit;
    }

    public static synchronized Retrofit createRetrofit(List<Interceptor> list, List<Converter.Factory> list2, List<CallAdapter.Factory> list3, Client.Provider provider, String str) {
        boolean z;
        Retrofit build;
        synchronized (RetrofitUtils.class) {
            if (provider == null) {
                provider = new Client.Provider() { // from class: com.bytedance.ttnet.utils.RetrofitUtils.5
                    @Override // com.bytedance.retrofit2.client.Client.Provider
                    public Client get() {
                        return new SsRetrofitClient();
                    }
                };
            }
            Retrofit.Builder httpExecutor = new Retrofit.Builder().setEndpoint(str).client(provider).httpExecutor(new SsHttpExecutor());
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            if (list2.isEmpty()) {
                list2.add(GsonConverterFactory.create());
            }
            Iterator<Converter.Factory> it = list2.iterator();
            while (it.hasNext()) {
                httpExecutor.addConverterFactory(it.next());
            }
            if (list3 != null && !list3.isEmpty()) {
                Iterator<CallAdapter.Factory> it2 = list3.iterator();
                while (it2.hasNext()) {
                    httpExecutor.addCallAdapterFactory(it2.next());
                }
            }
            LinkedList linkedList = new LinkedList();
            if (list == null || list.size() <= 0) {
                z = false;
            } else {
                z = false;
                for (Interceptor interceptor : list) {
                    if (interceptor instanceof SsInterceptor) {
                        if (!z) {
                            linkedList.add(interceptor);
                            z = true;
                            linkedList.add(interceptor);
                        }
                    } else if (!(interceptor instanceof RequestVertifyInterceptor)) {
                        linkedList.add(interceptor);
                    }
                }
            }
            if (!z) {
                linkedList.add(0, new SsInterceptor());
            }
            if (sInterceptors != null && sInterceptors.size() > 0) {
                linkedList.addAll(sInterceptors);
            }
            linkedList.add(new RequestVertifyInterceptor());
            Iterator it3 = linkedList.iterator();
            while (it3.hasNext()) {
                httpExecutor.addInterceptor((Interceptor) it3.next());
            }
            build = httpExecutor.build();
        }
        return build;
    }

    public static synchronized <S> S createSsService(String str, Class<S> cls) {
        S s;
        synchronized (RetrofitUtils.class) {
            s = (S) createService(getSsRetrofit(str), cls);
        }
        return s;
    }

    public static synchronized <S> S createOkService(String str, Class<S> cls) {
        S s;
        synchronized (RetrofitUtils.class) {
            s = (S) createService(getOkRetrofit(str), cls);
        }
        return s;
    }

    public static synchronized <S> S createService(Retrofit retrofit, Class<S> cls) {
        synchronized (RetrofitUtils.class) {
            if (retrofit == null) {
                return null;
            }
            return (S) retrofit.create(cls);
        }
    }
}
