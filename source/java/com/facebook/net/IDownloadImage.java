package com.facebook.net;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public interface IDownloadImage {
    @GET
    @Priority(2)
    @Streaming
    Call<TypedInput> downloadFileForHigh(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(3)
    @Streaming
    Call<TypedInput> downloadFileForImmediate(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(0)
    @Streaming
    Call<TypedInput> downloadFileForLow(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);

    @GET
    @Priority(1)
    @Streaming
    Call<TypedInput> downloadFileForNormal(@AddCommonParam boolean z, @MaxLength int i, @Url String str, @QueryMap(encode = true) Map<String, String> map, @HeaderList List<Header> list, @ExtraInfo Object obj);
}
