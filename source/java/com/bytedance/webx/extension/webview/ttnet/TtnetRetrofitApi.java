package com.bytedance.webx.extension.webview.ttnet;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.List;

/* loaded from: classes6.dex */
public interface TtnetRetrofitApi {
    @GET
    @Streaming
    Call<TypedInput> streamRequest(@Url String str, @HeaderList List<Header> list);
}
