package com.bytedance.mobsec.matrix.utils.m;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* loaded from: classes4.dex */
public interface TN {
    @POST
    @Streaming
    Call<TypedInput> p1(@Url String str, @HeaderList List<Header> list, @Body TypedByteArray typedByteArray);

    @GET
    @Streaming
    Call<TypedInput> p2(@Url String str, @HeaderList List<Header> list);
}
