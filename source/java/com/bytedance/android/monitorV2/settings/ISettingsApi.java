package com.bytedance.android.monitorV2.settings;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: ISettingsApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\bg\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0001\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nH'¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/monitorV2/settings/ISettingsApi;", "", "doPost", "Lcom/bytedance/retrofit2/Call;", "", "url", "header", "", "Lcom/bytedance/retrofit2/client/Header;", "fieldMap", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public interface ISettingsApi {
    @FormUrlEncoded
    @POST
    Call<String> doPost(@Url String url, @HeaderList List<Header> header, @FieldMap Map<String, String> fieldMap);
}
