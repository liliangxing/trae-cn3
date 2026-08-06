package com.bytedance.lynx.scc.cloudservice.network;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Method;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultNetAdapter implements INetAdapter {
    private static final String MIME_TYPE = "application/x-www-form-urlencoded; charset=UTF-8";
    private ISccNetworkFactory mNetowrkFactory;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface TTNetAdapterApi {
        @GET
        Call<TypedInput> doGet(@Url String relativePath, @AddCommonParam boolean param, @QueryMap(encode = true) Map<String, String> queryMap, @ExtraInfo Object extraInfo, @HeaderList List<Header> headerList);

        @HTTP(method = "{CUSTOM}")
        Call<TypedInput> send(@Method("CUSTOM") String method, @Url String url, @AddCommonParam boolean param, @QueryMap(encode = true) Map<String, String> params, @ExtraInfo Object extraInfo, @Body TypedOutput body, @HeaderList List<Header> headerList);
    }

    public DefaultNetAdapter() {
    }

    public DefaultNetAdapter(ISccNetworkFactory apiImpl) {
        this.mNetowrkFactory = apiImpl;
    }

    @Override // com.bytedance.lynx.scc.cloudservice.network.INetAdapter
    public UrlResponse sendSync(final UrlRequest request, final boolean needCommonParam) {
        TTNetAdapterApi tTNetAdapterApi;
        Call<TypedInput> send;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<Header> mapToHeader = mapToHeader(request.getParamMap());
        UrlResponse urlResponse = new UrlResponse();
        try {
            Pair parseUrl = UrlUtils.parseUrl(request.getUrl(), linkedHashMap);
            String str = (String) parseUrl.first;
            String str2 = (String) parseUrl.second;
            ISccNetworkFactory iSccNetworkFactory = this.mNetowrkFactory;
            if (iSccNetworkFactory != null) {
                tTNetAdapterApi = (TTNetAdapterApi) iSccNetworkFactory.create(str, TTNetAdapterApi.class);
            } else {
                tTNetAdapterApi = (TTNetAdapterApi) RetrofitUtils.createSsService(str, TTNetAdapterApi.class);
            }
            RequestContext requestContext = new RequestContext();
            requestContext.protect_timeout = request.getTimeoutMs();
            if (TextUtils.isEmpty(request.getMethod())) {
                send = tTNetAdapterApi.doGet(str2, true, linkedHashMap, requestContext, mapToHeader);
            } else {
                send = tTNetAdapterApi.send(request.getMethod(), str2, needCommonParam, linkedHashMap, requestContext, request.getBody() != null ? new TypedByteArray(MIME_TYPE, request.getBody().getBytes(), new String[0]) : null, mapToHeader);
            }
            SsResponse<TypedInput> execute = send != null ? send.execute() : null;
            if (execute != null) {
                urlResponse.setHeaders(headerToMap(execute.headers()));
                urlResponse.setStatusCode(execute.code());
                if (execute.isSuccessful()) {
                    urlResponse.setOriginalData(readInputStreamAsBytes(execute.body().mo349in()));
                } else {
                    urlResponse.setErrorMsg(new String(readInputStreamAsBytes(execute.body().mo349in())));
                }
            } else {
                urlResponse.setErrorMsg("Empty response body!");
            }
        } catch (Exception e) {
            Log.e(SccUtils.LOG_TAG, Log.getStackTraceString(e));
            urlResponse.setStatusCode(-1);
            urlResponse.setErrorMsg(e.getMessage());
        }
        return urlResponse;
    }

    private byte[] readInputStreamAsBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private Map<String, List<String>> headerToMap(List<Header> headersList) {
        if (headersList == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Header header : headersList) {
            String name = header.getName();
            String value = header.getValue();
            if (hashMap.containsKey(name)) {
                ((List) Objects.requireNonNull(hashMap.get(name))).add(value);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(value);
                hashMap.put(name, arrayList);
            }
        }
        return hashMap;
    }

    private List<Header> mapToHeader(Map<String, String> headersMap) {
        if (headersMap == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : headersMap.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }
}
