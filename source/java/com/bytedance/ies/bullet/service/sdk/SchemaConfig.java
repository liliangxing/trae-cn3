package com.bytedance.ies.bullet.service.sdk;

import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0014\u0010\u000e\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/SchemaConfig;", "", "()V", "_interceptors", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "interceptors", "", "getInterceptors", "()Ljava/util/List;", "addInterceptor", "", "interceptor", "addInterceptorAtFront", "addInterceptors", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SchemaConfig {
    private List<ISchemaInterceptor> _interceptors = new ArrayList();

    public final List<ISchemaInterceptor> getInterceptors() {
        return this._interceptors;
    }

    public final void addInterceptor(ISchemaInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this._interceptors.add(interceptor);
    }

    public final void addInterceptors(List<? extends ISchemaInterceptor> interceptors) {
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this._interceptors.addAll(interceptors);
    }

    public final void addInterceptorAtFront(ISchemaInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this._interceptors.add(0, interceptor);
    }
}
