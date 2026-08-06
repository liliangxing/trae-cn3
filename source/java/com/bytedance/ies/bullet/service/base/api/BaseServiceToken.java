package com.bytedance.ies.bullet.service.base.api;

import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u0003X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/BaseServiceToken;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "businessId", "", "serviceContext", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "(Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;)V", "getBusinessId", "()Ljava/lang/String;", "getServiceContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "submodule", "getSubmodule", "getBid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseServiceToken implements IServiceToken {
    private final String businessId;
    private final IServiceContext serviceContext;
    private final String submodule;

    public BaseServiceToken(String businessId, IServiceContext serviceContext) {
        Intrinsics.checkNotNullParameter(businessId, "businessId");
        Intrinsics.checkNotNullParameter(serviceContext, "serviceContext");
        this.businessId = businessId;
        this.serviceContext = serviceContext;
        this.submodule = "Token";
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public Map<Class<?>, Object> getAllDependency() {
        return IServiceToken.DefaultImpls.getAllDependency(this);
    }

    public final String getBusinessId() {
        return this.businessId;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T> T getDependency(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getDependency(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public <T extends IBulletService> T getService(Class<T> cls) {
        return (T) IServiceToken.DefaultImpls.getService(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    public IServiceContext getServiceContext() {
        return this.serviceContext;
    }

    public final String getSubmodule() {
        return this.submodule;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceToken
    /* renamed from: getBid, reason: from getter */
    public String getBusinessId() {
        return this.businessId;
    }
}
