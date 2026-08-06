package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: PTYPackageFilterCallback.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "getFilter", "Lorg/json/JSONObject;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PTYPackageFilterCallback extends ReflectionCall {
    JSONObject getFilter();
}
