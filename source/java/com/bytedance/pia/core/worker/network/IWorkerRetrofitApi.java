package com.bytedance.pia.core.worker.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;
import okhttp3.RequestBody;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IWorkerRetrofitApi {
    @DELETE
    @Streaming
    Call<TypedInput> deleteStreamRequest(@AddCommonParam boolean z, @Url String str, @HeaderList List<Header> list);

    @GET
    @Streaming
    Call<TypedInput> getStreamRequest(@AddCommonParam boolean z, @Url String str, @HeaderList List<Header> list);

    @HEAD
    @Streaming
    Call<TypedInput> headStreamRequest(@AddCommonParam boolean z, @Url String str, @HeaderList List<Header> list);

    @OPTIONS
    @Streaming
    Call<TypedInput> optionsStreamRequest(@AddCommonParam boolean z, @Url String str, @HeaderList List<Header> list);

    @PATCH
    @Streaming
    Call<TypedInput> patchStreamRequest(@AddCommonParam boolean z, @Url String str, @Body RequestBody requestBody, @HeaderList List<Header> list);

    @POST
    @Streaming
    Call<TypedInput> postStreamRequest(@AddCommonParam boolean z, @Url String str, @Body RequestBody requestBody, @HeaderList List<Header> list);

    @PUT
    @Streaming
    Call<TypedInput> putStreamRequest(@AddCommonParam boolean z, @Url String str, @Body RequestBody requestBody, @HeaderList List<Header> list);
}
