package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.IReleasable;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: Bridge3Registry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/core/kit/bridge/IBridge3Registry;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", "handle", "", "methodName", "", "params", "Lorg/json/JSONObject;", "callBack", "Lcom/bytedance/ies/bullet/core/kit/bridge/Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBridge3Registry extends IReleasable {
    void handle(String methodName, JSONObject params, Callback callBack);
}
