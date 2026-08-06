package com.bytedance.sync.p005v4.ttnet;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncNetworkClient {
    public static SsResponse post(String str, byte[] bArr, Map<String, String> map, NetworkClient.ReqContext reqContext) throws CommonHttpException {
        String str2;
        try {
            Pair<String, String> parseUrl = parseUrl(str);
            String str3 = (String) parseUrl.first;
            String str4 = (String) parseUrl.second;
            ISyncNetworkApi iSyncNetworkApi = (ISyncNetworkApi) RetrofitUtils.createSsService(str3, ISyncNetworkApi.class);
            if (map != null) {
                str2 = map.get("Content-Type");
                map.remove("Content-Type");
            } else {
                str2 = null;
            }
            return iSyncNetworkApi.postData(-1, str4, new TypedByteArray(str2, bArr, new String[0]), convertHeaders(map), reqContext != null ? reqContext.addCommonParams : false).execute();
        } catch (Exception e) {
            if (e instanceof HttpResponseException) {
                throw new CommonHttpException(e.getStatusCode(), e.getMessage());
            }
            throw new CommonHttpException(0, e.getMessage());
        }
    }

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
}
