package com.bytedance.webx.seclink.request;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.util.List;

/* loaded from: classes6.dex */
public interface SecLinkVerifyApi {
    @POST
    Call<String> executePost(@Url String str, @Body TypedOutput typedOutput, @HeaderList List<Header> list);
}
