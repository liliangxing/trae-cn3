package com.bytedance.ies.bullet.service.base.api;

import android.content.Context;
import com.bytedance.ies.bullet.service.base.api.IServiceContext;
import com.bytedance.ies.bullet.service.base.impl.DefaultDependencyProvider;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: IServiceContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/BaseServiceContext;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceContext;", "context", "Landroid/content/Context;", "isDebug", "", "(Landroid/content/Context;Z)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "extra", "Lcom/bytedance/ies/bullet/service/base/impl/DefaultDependencyProvider;", "getExtra", "()Lcom/bytedance/ies/bullet/service/base/impl/DefaultDependencyProvider;", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BaseServiceContext implements IServiceContext {
    private Context context;
    private final DefaultDependencyProvider extra = new DefaultDependencyProvider();
    private final boolean isDebug;

    public BaseServiceContext(Context context, boolean z) {
        this.context = context;
        this.isDebug = z;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public Map<Class<?>, Object> getAllDependency() {
        return IServiceContext.DefaultImpls.getAllDependency(this);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public <T> T getDependency(Class<T> cls) {
        return (T) IServiceContext.DefaultImpls.getDependency(this, cls);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    /* renamed from: isDebug, reason: from getter */
    public boolean getIsDebug() {
        return this.isDebug;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public <T> void putDependency(Class<T> cls, T t) {
        IServiceContext.DefaultImpls.putDependency(this, cls, t);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceContext
    public DefaultDependencyProvider getExtra() {
        return this.extra;
    }
}
