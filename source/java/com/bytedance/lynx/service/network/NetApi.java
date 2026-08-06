package com.bytedance.lynx.service.network;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public interface NetApi {
    @GET
    Call<TypedInput> doGet(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(2)
    Call<TypedInput> doGetHigh(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(3)
    Call<TypedInput> doGetImmediate(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(0)
    Call<TypedInput> doGetLow(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Streaming
    Call<TypedInput> doGetStreaming(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @POST
    @Streaming
    Call<TypedInput> doPost(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @Body TypedOutput typedOutput, @ExtraInfo Object obj);

    @POST
    @Priority(2)
    @Streaming
    Call<TypedInput> doPostHigh(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @Body TypedOutput typedOutput, @ExtraInfo Object obj);

    @POST
    @Priority(3)
    @Streaming
    Call<TypedInput> doPostImmediate(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @Body TypedOutput typedOutput, @ExtraInfo Object obj);

    @POST
    @Priority(0)
    @Streaming
    Call<TypedInput> doPostLow(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @Body TypedOutput typedOutput, @ExtraInfo Object obj);

    @POST
    @Streaming
    Call<TypedInput> doPostStreaming(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @Body TypedOutput typedOutput, @ExtraInfo Object obj);
}
