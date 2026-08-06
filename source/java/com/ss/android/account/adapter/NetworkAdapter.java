package com.ss.android.account.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.sdk.account.INetWork;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.ss.android.TTHeader;
import com.ss.android.TTRequest;
import com.ss.android.TTResponse;
import com.vivo.push.PushClient;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class NetworkAdapter implements INetWork {
    private TTResponse convertResponse(Call<String> call) throws Exception {
        SsResponse execute;
        String str;
        int i;
        if (call == null || (execute = call.execute()) == null) {
            return null;
        }
        if (execute.raw() != null) {
            str = execute.raw().getUrl();
            i = execute.raw().getStatus();
        } else {
            str = "";
            i = -1;
        }
        TTResponse tTResponse = new TTResponse(str, i, parseHeaders(execute.headers()), (String) execute.body());
        if (call.request() != null) {
            tTResponse.setTtRequest(new TTRequest(call.request().getMaxLength(), call.request().getUrl(), parseHeaders(call.request().getHeaders())));
        }
        return tTResponse;
    }

    private List<TTHeader> parseHeaders(List<Header> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Header header : list) {
                if (header != null) {
                    arrayList.add(new TTHeader(header.getName(), header.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Call<String> doRealExecuteGet(int i, String str, List<TTHeader> list) throws Exception {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedList linkedList = new LinkedList();
        if (list != null && !list.isEmpty()) {
            for (TTHeader tTHeader : list) {
                if (tTHeader != null) {
                    linkedList.add(new Header(tTHeader.getName(), tTHeader.getValue()));
                }
            }
        }
        if (iNetworkApi != null) {
            return iNetworkApi.doGet(true, i, str3, linkedHashMap, linkedList, (Object) null);
        }
        return null;
    }

    private Call<String> doRealExecutePost(int i, String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() != 0) {
            for (TTHeader tTHeader : list) {
                if (tTHeader != null) {
                    linkedList.add(new Header(tTHeader.getName(), tTHeader.getValue()));
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (map != null && !map.isEmpty()) {
            linkedHashMap2.putAll(map);
        }
        if (!TextUtils.equals((CharSequence) linkedHashMap2.get("account_sdk_ignore_common_param"), PushClient.DEFAULT_REQUEST_ID)) {
            NetworkParams.putCommonParams(linkedHashMap2, true);
        }
        if (iNetworkApi != null) {
            return iNetworkApi.doPost(i, str3, linkedHashMap, linkedHashMap2, linkedList, (Object) null);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Call<String> doRealExecutePostFile(int i, String str, Map<String, TypedOutput> map, List<TTHeader> list) throws Exception {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Pair parseUrl = UrlUtils.parseUrl(str, linkedHashMap);
        String str2 = (String) parseUrl.first;
        String str3 = (String) parseUrl.second;
        INetworkApi iNetworkApi = (INetworkApi) RetrofitUtils.createSsService(str2, INetworkApi.class);
        LinkedList linkedList = new LinkedList();
        if (list != null && list.size() > 0) {
            for (TTHeader tTHeader : list) {
                linkedList.add(new Header(tTHeader.getName(), tTHeader.getValue()));
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        NetworkParams.putCommonParams(linkedHashMap2, true);
        if (!linkedHashMap2.isEmpty()) {
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                if (entry != null) {
                    map.put(entry.getKey(), new TypedString((String) entry.getValue()));
                }
            }
        }
        if (iNetworkApi != null) {
            return iNetworkApi.postMultiPart(i, str3, linkedHashMap, map, linkedList);
        }
        return null;
    }

    public TTResponse executeGet(int i, String str, List<TTHeader> list) throws Exception {
        return convertResponse(doRealExecuteGet(i, str, list));
    }

    public TTResponse executePost(int i, String str, Map<String, String> map, List<TTHeader> list) throws Exception {
        return convertResponse(doRealExecutePost(i, str, map, list));
    }

    public TTResponse postFile(int i, String str, Map<String, String> map, String str2, String str3, List<TTHeader> list) throws Exception {
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
        return convertResponse(doRealExecutePostFile(i, str, linkedHashMap, list));
    }

    public int checkResponseException(Context context, Throwable th) {
        try {
            if (th instanceof CronetIOException) {
                if (((CronetIOException) th).getCronetInternalErrorCode() == -555) {
                    return -27;
                }
                if (((CronetIOException) th).getStatusCode() == 429) {
                    return -26;
                }
            } else if ((th instanceof HttpResponseException) && ((HttpResponseException) th).getStatusCode() == 429) {
                return -26;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }
}
