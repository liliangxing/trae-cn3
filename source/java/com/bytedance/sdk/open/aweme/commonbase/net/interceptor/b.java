package com.bytedance.sdk.open.aweme.commonbase.net.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.open.aweme.common.constants.OpenConstants;
import com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;
import com.bytedance.sdk.open.aweme.core.net.OpenHostResponse;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;

/* loaded from: classes5.dex */
public class b implements OpenInterceptor {
    @Override // com.bytedance.sdk.open.aweme.commonbase.net.interceptor.OpenInterceptor
    public OpenHostResponse intercept(OpenInterceptor.Chain chain) throws Exception {
        OpenHostRequest request = chain.request();
        OpenHostRequest.Builder builder = new OpenHostRequest.Builder(request);
        String url = request.getUrl();
        if (DouYinSdkContext.inst().isBoe() && !TextUtils.isEmpty(url) && url != null) {
            if (request.getUrl().startsWith(OpenConstants.OPEN_DOMAIN)) {
                url = url.replaceFirst(OpenConstants.OPEN_DOMAIN, OpenConstants.BOE_OPEN_DOMAIN);
            } else if (request.getUrl().startsWith(OpenConstants.CLIENT_DOMAIN)) {
                url = url.replaceFirst(OpenConstants.CLIENT_DOMAIN, OpenConstants.BOE_CLIENT_DOMAIN);
            }
        }
        if (!TextUtils.isEmpty(url)) {
            try {
                Uri.Builder buildUpon = Uri.parse(url).buildUpon();
                buildUpon.appendQueryParameter("sdk_version", "5.21.1-rc.0");
                url = buildUpon.build().toString();
            } catch (Exception unused) {
            }
        }
        builder.url(url);
        return chain.proceed(builder.build());
    }
}
