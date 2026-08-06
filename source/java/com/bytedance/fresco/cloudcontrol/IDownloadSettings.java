package com.bytedance.fresco.cloudcontrol;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;

/* loaded from: classes2.dex */
public interface IDownloadSettings {
    @GET
    @Priority(2)
    @Streaming
    Call<TypedInput> fetchSetting(@Url String str, @QueryMap Map<String, String> map);
}
