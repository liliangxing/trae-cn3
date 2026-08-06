package com.bytedance.ttnet.utils;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Callback;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTNetProtocolUtil {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface Service {
        @GET
        @Priority(3)
        Call<TypedInput> getCall(@Url String str, @QueryMap(encode = true) Map<String, String> map, @AddCommonParam boolean z, @HeaderList List<Header> list);
    }

    public static void sendTTNetProtocolRequest(String str, String str2, Map<String, String> map, Map<String, String> map2) throws IOException {
        String str3 = "https://" + str + str2;
        Pair parseUrl = UrlUtils.parseUrl(str3, map);
        String str4 = (String) parseUrl.first;
        String str5 = (String) parseUrl.second;
        Retrofit ssRetrofit = RetrofitUtils.getSsRetrofit(str4);
        if (ssRetrofit == null) {
            throw new IOException("Failed to get Retrofit instance for base URL: " + str4);
        }
        Service service = (Service) ssRetrofit.create(Service.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Header("x-ttnet-protocol-handler", "1"));
        arrayList.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        Call<TypedInput> call = service.getCall(str5, map, false, arrayList);
        try {
            try {
                call.execute();
            } catch (Exception e) {
                throw new IOException("TTNet-protocol request execution failed for URL: " + str3, e);
            }
        } finally {
            call.cancel();
        }
    }

    public static void sendTTNetProtocolRequestAsync(String str, String str2, Map<String, String> map, Map<String, String> map2, Callback<TypedInput> callback) throws IOException {
        Pair parseUrl = UrlUtils.parseUrl("https://" + str + str2, map);
        String str3 = (String) parseUrl.first;
        String str4 = (String) parseUrl.second;
        Retrofit ssRetrofit = RetrofitUtils.getSsRetrofit(str3);
        if (ssRetrofit == null) {
            throw new IOException("Failed to get Retrofit instance for base URL: " + str3);
        }
        Service service = (Service) ssRetrofit.create(Service.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Header("x-ttnet-protocol-handler", "1"));
        arrayList.add(new Header(Request.KEY_BYPASS_TTNET_FEATURES, "1"));
        if (map2 != null && !map2.isEmpty()) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                arrayList.add(new Header(entry.getKey(), entry.getValue()));
            }
        }
        service.getCall(str4, map, false, arrayList).enqueue(callback);
    }
}
