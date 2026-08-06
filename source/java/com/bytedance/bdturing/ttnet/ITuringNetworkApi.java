package com.bytedance.bdturing.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface ITuringNetworkApi {
    @GET
    Call<String> doGet(@AddCommonParam boolean z, @Url String str, @QueryMap Map<String, String> map, @HeaderList List<Header> list);

    @POST
    @Streaming
    Call<String> doPost(@Url String str, @QueryMap Map<String, String> map, @Body TypedOutput typedOutput, @HeaderList List<Header> list);
}
