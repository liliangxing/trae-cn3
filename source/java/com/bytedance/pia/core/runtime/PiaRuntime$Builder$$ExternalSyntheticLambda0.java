package com.bytedance.pia.core.runtime;

import com.bytedance.pia.core.api.network.IPiaRetrofit;
import com.bytedance.ttnet.utils.RetrofitUtils;

/* compiled from: D8$$SyntheticClass */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* synthetic */ class PiaRuntime$Builder$$ExternalSyntheticLambda0 implements IPiaRetrofit {
    @Override // com.bytedance.pia.core.api.network.IPiaRetrofit
    public final Object create(String str, Class cls) {
        return RetrofitUtils.createSsService(str, cls);
    }
}
