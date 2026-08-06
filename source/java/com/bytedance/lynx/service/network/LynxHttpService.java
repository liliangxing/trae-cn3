package com.bytedance.lynx.service.network;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.http.RequestContext;
import com.lynx.jsbridge.network.HttpRequest;
import com.lynx.jsbridge.network.HttpResponse;
import com.lynx.jsbridge.network.HttpStreamingDelegate;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.service.ILynxHttpService;
import com.lynx.tasm.service.LynxHttpRequestCallback;
import com.lynx.tasm.utils.ReadableMapUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte$;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxHttpService implements ILynxHttpService {
    private static final String KEY_CLIENT_CODE = "clientCode";
    private static final String KEY_ERROR_MESSAGE = "errorMessage";
    private static final String KEY_NEED_COMMON_PARAMS = "needCommonParams";
    private static final String KEY_PRIORITY_LEVEL = "priorityLevel";
    private static final String KEY_URL_PARAMS = "params";
    private static final String TAG = "LynxHttpService";
    private static volatile LynxHttpService mInstance;

    private LynxHttpService() {
    }

    public static LynxHttpService getInstance() {
        if (mInstance == null) {
            synchronized (LynxHttpService.class) {
                if (mInstance == null) {
                    mInstance = new LynxHttpService();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class NetTask implements Runnable {
        LynxHttpRequestCallback mCallback;
        final AtomicBoolean mHasResponse = new AtomicBoolean(false);
        HttpRequest mRequest;
        final HttpStreamingDelegate mStreamingDelegate;
        final boolean mUseStreaming;

        NetTask(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback, HttpStreamingDelegate httpStreamingDelegate, boolean z) {
            this.mRequest = httpRequest;
            this.mCallback = lynxHttpRequestCallback;
            this.mUseStreaming = z;
            this.mStreamingDelegate = httpStreamingDelegate;
        }

        LynxIRetrofit getRetrofit(String str) {
            LynxIRetrofitFactory retrofitFactory = LynxNetConfig.getRetrofitFactory();
            if (retrofitFactory == null) {
                retrofitFactory = new DefaultRetrofitFactory();
            }
            return retrofitFactory.createRetrofit(str);
        }

        private byte[] getByteArrayFromInputStream(InputStream inputStream) throws IOException {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        }

        private List<Header> getHeaderList(Map<String, String> map) {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getValue() != null) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
            return arrayList;
        }

        private Call<TypedInput> getFromPriority(LynxIRetrofit lynxIRetrofit, int i, boolean z, String str, Map<String, String> map, List<Header> list, RequestContext requestContext, boolean z2) {
            if (z2) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doGetStreaming(z, -1, str, map, list, requestContext);
            }
            if (i == 0) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doGetLow(z, -1, str, map, list, requestContext);
            }
            if (i == 2) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doGetHigh(z, -1, str, map, list, requestContext);
            }
            if (i == 3) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doGetImmediate(z, -1, str, map, list, requestContext);
            }
            return ((NetApi) lynxIRetrofit.create(NetApi.class)).doGet(z, -1, str, map, list, requestContext);
        }

        private Call<TypedInput> postFromPriority(LynxIRetrofit lynxIRetrofit, boolean z, int i, String str, Map<String, String> map, List<Header> list, TypedByteArray typedByteArray, RequestContext requestContext, boolean z2) {
            if (z2) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doPostStreaming(z, -1, str, map, list, typedByteArray, requestContext);
            }
            if (i == 0) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doPostLow(z, -1, str, map, list, typedByteArray, requestContext);
            }
            if (i == 2) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doPostHigh(z, -1, str, map, list, typedByteArray, requestContext);
            }
            if (i == 3) {
                return ((NetApi) lynxIRetrofit.create(NetApi.class)).doPostImmediate(z, -1, str, map, list, typedByteArray, requestContext);
            }
            return ((NetApi) lynxIRetrofit.create(NetApi.class)).doPost(z, -1, str, map, list, typedByteArray, requestContext);
        }

        private Call<TypedInput> callFromNetApi(Pair<String, String> pair, String str, boolean z, int i, Map<String, String> map, List<Header> list, TypedByteArray typedByteArray, RequestContext requestContext) {
            LynxIRetrofit retrofit = getRetrofit((String) pair.first);
            String str2 = (String) pair.second;
            if (str.equalsIgnoreCase("GET")) {
                return getFromPriority(retrofit, i, z, str2, map, list, requestContext, this.mUseStreaming);
            }
            if (str.equalsIgnoreCase("POST")) {
                return postFromPriority(retrofit, z, i, str2, map, list, typedByteArray, requestContext, this.mUseStreaming);
            }
            throw new IllegalArgumentException("Unsupported HTTP Method.");
        }

        private Call<TypedInput> callFromRequest() {
            TypedByteArray typedByteArray;
            String httpMethod = this.mRequest.getHttpMethod();
            String url = this.mRequest.getUrl();
            JavaOnlyMap httpHeaders = this.mRequest.getHttpHeaders();
            if (url == null) {
                throw new IllegalArgumentException("Unsupported HTTP url. url is empty.");
            }
            JavaOnlyMap customConfig = this.mRequest.getCustomConfig();
            boolean z = customConfig.getBoolean(LynxHttpService.KEY_NEED_COMMON_PARAMS, true);
            ReadableMap map = customConfig.getMap(LynxHttpService.KEY_URL_PARAMS, new JavaOnlyMap());
            int i = customConfig.getInt(LynxHttpService.KEY_PRIORITY_LEVEL, 1);
            Map<String, String> ConvertReadableMapToStringStringMap = ReadableMapUtils.ConvertReadableMapToStringStringMap(map);
            try {
                Pair<String, String> parseUrl = UrlUtils.parseUrl(url, ConvertReadableMapToStringStringMap);
                String string = httpHeaders.getString(XBridgeAPIRequestUtils.CONTENT_TYPE);
                if (this.mRequest.getHttpBody() != null) {
                    typedByteArray = new TypedByteArray(string, this.mRequest.getHttpBody(), new String[0]);
                } else {
                    typedByteArray = new TypedByteArray(string, new byte[0], new String[0]);
                }
                List<Header> headerList = getHeaderList(ReadableMapUtils.ConvertReadableMapToStringStringMap(httpHeaders));
                RequestContext requestContext = new RequestContext();
                requestContext.isCustomizedCookie = this.mRequest.getHttpHeaders().hasKey("Cookie");
                return callFromNetApi(parseUrl, httpMethod, z, i, ConvertReadableMapToStringStringMap, headerList, typedByteArray, requestContext);
            } catch (IOException unused) {
                throw new IllegalArgumentException("Unsupported HTTP url. url is not valid.");
            }
        }

        private void fillResponseHeader(HttpResponse httpResponse, List<Header> list) {
            ArrayList arrayList = new ArrayList();
            JavaOnlyMap httpHeaders = httpResponse.getHttpHeaders();
            String str = "set-cookie";
            for (Header header : list) {
                if ("set-cookie".equalsIgnoreCase(header.getName())) {
                    str = header.getName();
                    arrayList.add(header.getValue());
                } else {
                    httpHeaders.putString(header.getName(), header.getValue());
                }
            }
            if (arrayList.size() > 0) {
                httpHeaders.putString(str, UByte$.ExternalSyntheticBackport0.m(", ", arrayList));
            }
        }

        private void fillResponseWithError(HttpResponse httpResponse, String str, int i, int i2) {
            httpResponse.setStatusText(str);
            httpResponse.setStatusCode(i);
            httpResponse.getCustomInfo().put(LynxHttpService.KEY_CLIENT_CODE, Integer.valueOf(i2));
            httpResponse.getCustomInfo().put(LynxHttpService.KEY_ERROR_MESSAGE, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRequestResponseStreaming(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
            Object obj;
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setUrl(this.mRequest.getUrl());
            TraceEvent.beginSection(TraceEventDef.NETWORK_MODULE_CALLBACK, new HashMap<String, String>(httpResponse, ssResponse) { // from class: com.bytedance.lynx.service.network.LynxHttpService.NetTask.1
                final /* synthetic */ SsResponse val$output;
                final /* synthetic */ HttpResponse val$response;

                {
                    this.val$response = httpResponse;
                    this.val$output = ssResponse;
                    put("url", httpResponse.getUrl());
                    put("httpCode", String.valueOf(ssResponse.code()));
                }
            });
            httpResponse.setStatusCode(ssResponse.code());
            fillResponseHeader(httpResponse, ssResponse.headers());
            TraceEvent.endSection(TraceEventDef.NETWORK_MODULE_CALLBACK);
            LynxNetConfig.getLynxHttpInterceptor().onResponse(this.mRequest, httpResponse);
            LLog.i("NetworkModule", "onRequestResponseStreaming");
            this.mCallback.invoke(httpResponse);
            JavaOnlyMap httpHeaders = httpResponse.getHttpHeaders();
            if (httpHeaders != null) {
                for (Map.Entry entry : httpHeaders.entrySet()) {
                    if (XBridgeAPIRequestUtils.CONTENT_TYPE.equalsIgnoreCase((String) entry.getKey())) {
                        obj = entry.getValue();
                        break;
                    }
                }
            }
            obj = null;
            boolean z = obj != null && "text/event-stream".equalsIgnoreCase(obj.toString());
            try {
                try {
                    InputStream mo349in = ssResponse.body().mo349in();
                    if (z) {
                        this.mStreamingDelegate.streamingBodySSE(mo349in);
                    } else {
                        this.mStreamingDelegate.streamingBody(mo349in);
                    }
                    this.mStreamingDelegate.onEnd();
                    if (call == null) {
                        return;
                    }
                } catch (Exception e) {
                    this.mStreamingDelegate.onError(e.toString());
                    this.mStreamingDelegate.onEnd();
                    if (call == null) {
                        return;
                    }
                }
                call.cancel();
            } catch (Throwable th) {
                this.mStreamingDelegate.onEnd();
                if (call != null) {
                    call.cancel();
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:10:0x008b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x006f, code lost:
        
            if (r5 == null) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0072, code lost:
        
            com.lynx.tasm.base.TraceEvent.endSection(com.bytedance.lynx.service.network.TraceEventDef.NETWORK_MODULE_CALLBACK);
            com.bytedance.lynx.service.network.LynxNetConfig.getLynxHttpInterceptor().onResponse(r4.mRequest, r1);
            com.lynx.tasm.base.LLog.i("NetworkModule", "onRequestResponse");
            r4.mCallback.invoke(r1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onRequestResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setUrl(this.mRequest.getUrl());
            try {
                try {
                    TraceEvent.beginSection(TraceEventDef.NETWORK_MODULE_CALLBACK, new HashMap<String, String>(httpResponse) { // from class: com.bytedance.lynx.service.network.LynxHttpService.NetTask.2
                        final /* synthetic */ HttpResponse val$response;

                        {
                            this.val$response = httpResponse;
                            put("url", httpResponse.getUrl());
                        }
                    });
                    httpResponse.setStatusCode(ssResponse.code());
                    fillResponseHeader(httpResponse, ssResponse.headers());
                    if (ssResponse.body() != null) {
                        httpResponse.setHttpBody(getByteArrayFromInputStream(ssResponse.body().mo349in()));
                    }
                } catch (Exception e) {
                    fillResponseWithError(httpResponse, e.getClass().getSimpleName() + ":" + e.getMessage(), 499, 0);
                }
            } finally {
                if (call != null) {
                    call.cancel();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onRequestFailure(Call<TypedInput> call, Throwable th) {
            HttpStreamingDelegate httpStreamingDelegate;
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.setUrl(this.mRequest.getUrl());
            if (th instanceof NetworkNotAvailabeException) {
                fillResponseWithError(httpResponse, th.getClass().getSimpleName() + ":" + th.getMessage(), 499, ((NetworkNotAvailabeException) th).getCronetInternalErrorCode());
            } else if (th instanceof CronetIOException) {
                StringBuilder append = new StringBuilder().append(th.getClass().getSimpleName()).append(":").append(th.getMessage()).append(",");
                CronetIOException cronetIOException = (CronetIOException) th;
                fillResponseWithError(httpResponse, append.append(cronetIOException.getStatusCode()).toString(), cronetIOException.getStatusCode(), cronetIOException.getCronetInternalErrorCode());
            } else if (th instanceof HttpResponseException) {
                StringBuilder append2 = new StringBuilder().append(th.getClass().getSimpleName()).append(":").append(th.getMessage()).append(",");
                HttpResponseException httpResponseException = (HttpResponseException) th;
                fillResponseWithError(httpResponse, append2.append(httpResponseException.getStatusCode()).toString(), httpResponseException.getStatusCode(), 0);
            } else if (th instanceof Exception) {
                fillResponseWithError(httpResponse, th.getClass().getSimpleName() + ":" + th.getMessage(), 499, 0);
            }
            LynxNetConfig.getLynxHttpInterceptor().onResponse(this.mRequest, httpResponse);
            LLog.i("NetworkModule", "onRequestFailure");
            this.mCallback.invoke(httpResponse);
            if (!this.mUseStreaming || (httpStreamingDelegate = this.mStreamingDelegate) == null) {
                return;
            }
            httpStreamingDelegate.onError(httpResponse.getStatusText());
            this.mStreamingDelegate.onEnd();
        }

        @Override // java.lang.Runnable
        public void run() {
            LynxNetConfig.getLynxHttpInterceptor().onRequest(this.mRequest);
            callFromRequest().enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.lynx.service.network.LynxHttpService.NetTask.3
                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                }

                @Override // com.bytedance.retrofit2.ExpandCallback
                public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                    if (NetTask.this.mHasResponse.compareAndSet(false, true)) {
                        if (NetTask.this.mUseStreaming) {
                            NetTask.this.onRequestResponseStreaming(call, ssResponse);
                        } else {
                            NetTask.this.onRequestResponse(call, ssResponse);
                        }
                    }
                }

                @Override // com.bytedance.retrofit2.Callback
                public void onFailure(Call<TypedInput> call, Throwable th) {
                    if (NetTask.this.mHasResponse.compareAndSet(false, true)) {
                        NetTask.this.onRequestFailure(call, th);
                    }
                }
            });
        }
    }

    private void doRequest(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback, HttpStreamingDelegate httpStreamingDelegate, boolean z) {
        LLog.i("NetworkModule", "call http request with url: " + httpRequest.getUrl());
        TraceEvent.beginSection(TraceEventDef.NETWORK_MODULE_CALL);
        HttpResponse interceptRequest = LynxNetConfig.getLynxHttpInterceptor().interceptRequest(httpRequest);
        if (interceptRequest != null) {
            lynxHttpRequestCallback.invoke(interceptRequest);
        } else {
            new NetTask(httpRequest, lynxHttpRequestCallback, httpStreamingDelegate, z).run();
        }
        TraceEvent.endSection(TraceEventDef.NETWORK_MODULE_CALL);
    }

    public void request(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback) {
        doRequest(httpRequest, lynxHttpRequestCallback, null, false);
    }

    public void requestStreaming(HttpRequest httpRequest, LynxHttpRequestCallback lynxHttpRequestCallback, HttpStreamingDelegate httpStreamingDelegate) {
        doRequest(httpRequest, lynxHttpRequestCallback, httpStreamingDelegate, true);
    }
}
