package com.bytedance.pitaya.api.feature.store;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;

/* compiled from: PTYFeatureChangeCallback.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/pitaya/api/feature/store/PTYFeatureChangeCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "onChange", "", "groupName", "", "featureName", "value", "extra", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public interface PTYFeatureChangeCallback extends ReflectionCall {
    void onChange(String groupName, String featureName, String value, String extra);
}
