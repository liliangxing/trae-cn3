package com.bytedance.pitaya.api;

import com.bytedance.bdturing.methods.JsCallParser;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PitayaFE.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/pitaya/api/PitayaFE;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "registerApplogRunEventCallback", "", "business", "", JsCallParser.VALUE_CALLBACK, "Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "registerMessageHandler", "businessName", "handler", "Lcom/bytedance/pitaya/api/PTYMessageHandler;", "removeApplogRunEventCallback", "removeMessageHandler", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PitayaFE extends ReflectionCall {
    void registerApplogRunEventCallback(String business, PTYTaskResultCallback callback);

    void registerMessageHandler(String businessName, PTYMessageHandler handler);

    void removeApplogRunEventCallback(String business);

    void removeMessageHandler(String business);
}
