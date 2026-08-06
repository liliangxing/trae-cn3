package com.bytedance.ies.bullet.service.base.impl;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBulletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0004H\u0016J)\u0010\t\u001a\u0004\u0018\u0001H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004X\u0084D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "()V", "bid", "", "subModule", "getSubModule", "()Ljava/lang/String;", "getBid", "getDependency", "T", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "clazz", "Ljava/lang/Class;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Ljava/lang/Class;)Ljava/lang/Object;", "getService", "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "onRegister", "", "onUnRegister", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseBulletService implements IBulletService {
    public static final String TAG = "bullet";
    private String bid = "default_bid";
    private final String subModule = "Service";

    @Override // com.bytedance.ies.bullet.service.base.api.IBulletService
    public void onUnRegister() {
    }

    protected final String getSubModule() {
        return this.subModule;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IBulletService
    public void onRegister(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.bid = bid;
    }

    public final <T> T getDependency(IServiceToken token, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) token.getServiceContext().getDependency(clazz);
    }

    public final <T extends IBulletService> T getService(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) ServiceCenter.INSTANCE.instance().get(this.bid, clazz);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IBulletService
    public String getBid() {
        return this.bid;
    }
}
