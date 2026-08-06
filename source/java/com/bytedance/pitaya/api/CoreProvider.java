package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;

/* compiled from: CoreProvider.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pitaya/api/CoreProvider;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "getCore", "Lcom/bytedance/pitaya/api/IPitayaCore;", CommonConstants.KEY_AID, "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface CoreProvider extends ReflectionCall {
    IPitayaCore getCore(String aid);
}
