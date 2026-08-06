package com.bytedance.sync.p005v4.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface ISyncNetworkApi {
    @GET
    Call<String> get(@MaxLength int i, @Url String str, @HeaderList List<Header> list, @AddCommonParam boolean z);

    @POST
    Call<String> postData(@MaxLength int i, @Url String str, @Body TypedOutput typedOutput, @HeaderList List<Header> list, @AddCommonParam boolean z);

    @FormUrlEncoded
    @POST
    Call<String> postForm(@MaxLength int i, @Url String str, @FieldMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @AddCommonParam boolean z);
}
