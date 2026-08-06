package com.bytedance.ies.bullet.service.base.bridge;

import com.bytedance.bdinstall.Api;
import com.bytedance.ies.bullet.service.base.IReleasable;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.Metadata;

/* compiled from: BridgeMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod;", "Lcom/bytedance/ies/bullet/service/base/IReleasable;", Api.KEY_ACCESS, "Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "getAccess", "()Lcom/bytedance/ies/bullet/service/base/bridge/IBridgeMethod$Access;", "name", "", "getName", "()Ljava/lang/String;", "needCallback", "", "getNeedCallback", "()Z", "ICallback", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IGenericBridgeMethod extends IReleasable {

    /* compiled from: BridgeMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/bridge/IGenericBridgeMethod$ICallback;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public interface ICallback {
    }

    IBridgeMethod.Access getAccess();

    String getName();

    boolean getNeedCallback();
}
