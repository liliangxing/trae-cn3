package com.bytedance.article.common.network;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SSNetworkClient extends NetworkClient {
    private static List<Header> convertHeaders(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new Header(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Pair<String, String> parseUrl(String str) throws Exception {
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        String scheme = parse.getScheme();
        String host = parse.getHost();
        int port = parse.getPort();
        if (host != null) {
            if (scheme != null) {
                sb.append(scheme);
                sb.append("://");
            }
            sb.append(host);
            if (port > 0) {
                sb.append(':');
                sb.append(port);
            }
        }
        String sb2 = sb.toString();
        String path = parse.getPath();
        String query = parse.getQuery();
        if (query != null) {
            path = path + "?" + query;
        }
        return new Pair<>(sb2, path);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String str, Map<String, String> map, NetworkClient.ReqContext reqContext) throws Exception {
        Pair<String, String> parseUrl = parseUrl(str);
        String str2 = (String) parseUrl.first;
        return (String) ((ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class)).get(-1, (String) parseUrl.second, convertHeaders(map), reqContext != null ? reqContext.addCommonParams : false).execute().body();
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String str, List<Pair<String, String>> list, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str2 = (String) parseUrl.first;
            String str3 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str2, ICommonApi.class);
            List<Header> convertHeaders = convertHeaders(map);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (list != null) {
                for (Pair<String, String> pair : list) {
                    linkedHashMap.put(pair.first, pair.second);
                }
            }
            return (String) iCommonApi.postForm(-1, str3, linkedHashMap, convertHeaders, reqContext != null ? reqContext.addCommonParams : false).execute().body();
        } catch (Exception e) {
            if (e instanceof HttpResponseException) {
                throw new CommonHttpException(e.getStatusCode(), e.getMessage());
            }
            throw new CommonHttpException(0, e.getMessage());
        }
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        String str2;
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str3 = (String) parseUrl.first;
            String str4 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str3, ICommonApi.class);
            if (map != null) {
                str2 = map.get("Content-Type");
                map.remove("Content-Type");
            } else {
                str2 = null;
            }
            return (String) iCommonApi.postData(-1, str4, new TypedByteArray(str2, bArr, new String[0]), convertHeaders(map), reqContext != null ? reqContext.addCommonParams : false).execute().body();
        } catch (Exception e) {
            if (e instanceof HttpResponseException) {
                throw new CommonHttpException(e.getStatusCode(), e.getMessage());
            }
            throw new CommonHttpException(0, e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.common.utility.NetworkClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] postDataStream(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        InputStream inputStream = null;
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str3 = (String) parseUrl.first;
            String str4 = (String) parseUrl.second;
            ICommonApi iCommonApi = (ICommonApi) RetrofitUtils.createSsService(str3, ICommonApi.class);
            if (map != null) {
                str2 = map.get("Content-Type");
                map.remove("Content-Type");
            } else {
                str2 = null;
            }
            InputStream in = ((TypedInput) iCommonApi.postDataStream(-1, str4, new TypedByteArray(str2, bArr, new String[0]), convertHeaders(map), reqContext != null ? reqContext.addCommonParams : false).execute().body()).in();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
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
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return byteArray;
                } catch (Exception e3) {
                    inputStream = in;
                    e = e3;
                    try {
                        if (e instanceof HttpResponseException) {
                            throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
                        }
                        throw new CommonHttpException(0, e.getMessage());
                    } catch (Throwable th) {
                        th = th;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (byteArrayOutputStream == null) {
                            try {
                                byteArrayOutputStream.close();
                                throw th;
                            } catch (IOException e5) {
                                e5.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    inputStream = in;
                    th = th2;
                    if (inputStream != null) {
                    }
                    if (byteArrayOutputStream == null) {
                    }
                }
            } catch (Exception e6) {
                inputStream = in;
                e = e6;
                byteArrayOutputStream = null;
            } catch (Throwable th3) {
                inputStream = in;
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
        }
    }
}
