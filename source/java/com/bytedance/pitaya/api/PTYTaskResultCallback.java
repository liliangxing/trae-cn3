package com.bytedance.pitaya.api;

import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PTYTaskResultCallback.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/bytedance/pitaya/api/PTYTaskResultCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "onResult", "", "success", "", "error", "Lcom/bytedance/pitaya/api/bean/PTYError;", "outputDataPTY", "Lcom/bytedance/pitaya/api/bean/PTYTaskData;", "packageInfo", "Lcom/bytedance/pitaya/api/bean/PTYPackageInfo;", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PTYTaskResultCallback extends ReflectionCall {
    void onResult(boolean success, PTYError error, PTYTaskData outputDataPTY, PTYPackageInfo packageInfo);
}
