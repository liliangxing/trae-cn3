package com.bytedance.fresco.cloudcontrol;

import android.util.Pair;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.RequestBuilder;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class NetworkFetcher {
    private final String TAG = "NetworkFetcher";
    private IDownloadSettings iDownloadSettingsApi;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface Callback {
        void onCancellation();

        void onFailure(Throwable th);

        void onResponse(InputStream inputStream, int i) throws IOException;
    }

    public void fetch(String str, final Callback callback, Map<String, String> map) {
        try {
            Pair<String, String> parseUrl = UrlUtils.parseUrl(str, new LinkedHashMap());
            String str2 = (String) parseUrl.first;
            String str3 = (String) parseUrl.second;
            IDownloadSettings iDownloadSettings = (IDownloadSettings) RetrofitUtils.createService(RetrofitUtils.createSsRetrofit(str2, (List) null, (Converter.Factory) null), IDownloadSettings.class);
            this.iDownloadSettingsApi = iDownloadSettings;
            iDownloadSettings.fetchSetting(str3, map).enqueue(new ExpandCallback<TypedInput>() { // from class: com.bytedance.fresco.cloudcontrol.NetworkFetcher.1
                public void onAsyncPreRequest(RequestBuilder requestBuilder) {
                }

                public void onResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                }

                public void onAsyncResponse(Call<TypedInput> call, SsResponse<TypedInput> ssResponse) {
                    if (ssResponse == null) {
                        return;
                    }
                    try {
                        if (!ssResponse.isSuccessful()) {
                            FLog.e("NetworkFetcher", "fetch settings error, unexpected HTTP code " + ssResponse.code());
                        } else {
                            callback.onResponse(((TypedInput) ssResponse.body()).in(), -1);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        callback.onFailure(e);
                    }
                }

                public void onFailure(Call<TypedInput> call, Throwable th) {
                    callback.onFailure(th);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
