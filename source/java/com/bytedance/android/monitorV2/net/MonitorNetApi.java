package com.bytedance.android.monitorV2.net;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.JsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public interface MonitorNetApi {
    @Headers({"Content-Type: application/json"})
    @POST("/monitor_web/settings/hybrid-settings")
    Call<String> doPost(@HeaderList List<Header> list, @Body JsonObject jsonObject);
}
