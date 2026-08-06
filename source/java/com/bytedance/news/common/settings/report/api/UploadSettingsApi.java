package com.bytedance.news.common.settings.report.api;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.google.gson.JsonObject;

/* loaded from: classes4.dex */
public interface UploadSettingsApi {
    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST
    Call<String> executePost(@Url String str, @Body JsonObject jsonObject);
}
