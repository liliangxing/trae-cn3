package com.bytedance.ies.bullet.web.pia;

import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import kotlin.Metadata;

/* compiled from: PiaRetrofit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/web/pia/PiaRetrofit;", "Lcom/bytedance/pia/core/api/network/IPiaRetrofit;", "()V", "create", "T", "baseUrl", "", "api", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PiaRetrofit implements IPiaRetrofit {
    @Override // com.bytedance.pia.core.api.network.IPiaRetrofit
    public <T> T create(String baseUrl, Class<T> api) {
        return (T) RetrofitUtils.createSsService(baseUrl, api);
    }
}
