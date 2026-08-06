package com.bytedance.mobsec.matrix.utils.p004m;

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

/* renamed from: com.bytedance.mobsec.matrix.utils.m.TN */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface InterfaceC0328TN {
    @POST
    @Streaming
    /* renamed from: p1 */
    Call<TypedInput> m104p1(@Url String str, @HeaderList List<Header> list, @Body TypedByteArray typedByteArray);

    @GET
    @Streaming
    /* renamed from: p2 */
    Call<TypedInput> m105p2(@Url String str, @HeaderList List<Header> list);
}
