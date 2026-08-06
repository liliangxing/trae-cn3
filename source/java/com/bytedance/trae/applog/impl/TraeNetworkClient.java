package com.bytedance.trae.applog.impl;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TraeNetworkClient extends SSNetworkClient {
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final int STREAM_BUFFER_SIZE = 1024;

    private static List<Header> convertHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static Pair<String, String> parseUrl(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        int port = parse.getPort();
        if (host == null) {
            throw new IllegalArgumentException("Invalid url, host is null: " + str);
        }
        StringBuilder sb = new StringBuilder();
        if (scheme != null) {
            sb.append(scheme).append("://");
        }
        sb.append(host);
        if (port > 0) {
            sb.append(':').append(port);
        }
        String ensureTrailingSlash = ensureTrailingSlash(sb.toString());
        String encodedPath = parse.getEncodedPath();
        if (encodedPath == null || encodedPath.length() == 0) {
            encodedPath = "/";
        }
        String encodedQuery = parse.getEncodedQuery();
        if (encodedQuery != null && !encodedQuery.isEmpty()) {
            encodedPath = encodedPath + "?" + encodedQuery;
        }
        return new Pair<>(ensureTrailingSlash, encodedPath);
    }

    private static String ensureTrailingSlash(String str) {
        return (str == null || str.isEmpty() || str.endsWith("/")) ? str : str + "/";
    }

    private static boolean shouldAddCommonParams(NetworkClient.ReqContext reqContext) {
        return reqContext != null && reqContext.addCommonParams;
    }

    private static Pair<String, Map<String, String>> splitContentType(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return new Pair<>(null, null);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        String str = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                if ("Content-Type".equalsIgnoreCase(key)) {
                    str = entry.getValue();
                } else {
                    linkedHashMap.put(key, entry.getValue());
                }
            }
        }
        return new Pair<>(str, linkedHashMap.isEmpty() ? null : linkedHashMap);
    }

    private static CommonHttpException wrapToCommonHttpException(Exception exc) {
        if (exc instanceof HttpResponseException) {
            return new CommonHttpException(((HttpResponseException) exc).getStatusCode(), safeMsg(exc));
        }
        if (exc instanceof NetworkNotAvailabeException) {
            return new CommonHttpException(((NetworkNotAvailabeException) exc).getCronetInternalErrorCode(), safeMsg(exc));
        }
        if (exc instanceof CronetIOException) {
            CronetIOException cronetIOException = (CronetIOException) exc;
            if (cronetIOException.getCronetInternalErrorCode() == -555) {
                return new CommonHttpException(cronetIOException.getCronetInternalErrorCode(), safeMsg(exc));
            }
            return new CommonHttpException(cronetIOException.getStatusCode(), safeMsg(exc));
        }
        return new CommonHttpException(0, safeMsg(exc));
    }

    private static String safeMsg(Exception exc) {
        String message = exc.getMessage();
        return message != null ? message : exc.getClass().getName();
    }

    public String get(String str, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str2 = (String) parseUrl.first;
            return (String) ((ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class)).get(-1, (String) parseUrl.second, convertHeaders(map), reqContext != null ? reqContext.addCommonParams : false).execute().body();
        } catch (Exception e) {
            throw wrapToCommonHttpException(e);
        }
    }

    public String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str2 = (String) parseUrl.first;
            String str3 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list != null) {
                for (Pair<String, String> pair : list) {
                    if (pair != null && pair.first != null) {
                        linkedHashMap.put((String) pair.first, (String) pair.second);
                    }
                }
            }
            return (String) iCommonApi.postForm(-1, str3, linkedHashMap, convertHeaders(map), shouldAddCommonParams(reqContext)).execute().body();
        } catch (Exception e) {
            throw wrapToCommonHttpException(e);
        }
    }

    public String post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str2 = (String) parseUrl.first;
            String str3 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class);
            Pair<String, Map<String, String>> splitContentType = splitContentType(map);
            String str4 = (String) splitContentType.first;
            return (String) iCommonApi.postData(-1, str3, new TypedByteArray(str4, bArr, new String[0]), convertHeaders((Map) splitContentType.second), shouldAddCommonParams(reqContext)).execute().body();
        } catch (Exception e) {
            throw wrapToCommonHttpException(e);
        }
    }

    public byte[] postDataStream(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str2 = (String) parseUrl.first;
            String str3 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class);
            Pair<String, Map<String, String>> splitContentType = splitContentType(map);
            String str4 = (String) splitContentType.first;
            TypedInput typedInput = (TypedInput) iCommonApi.postDataStream(-1, str3, new TypedByteArray(str4, bArr, new String[0]), convertHeaders((Map) splitContentType.second), shouldAddCommonParams(reqContext)).execute().body();
            if (typedInput == null) {
                return new byte[0];
            }
            InputStream in = typedInput.in();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int read = in.read(bArr2);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    if (in != null) {
                        in.close();
                    }
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            throw wrapToCommonHttpException(e);
        }
    }
}
