package com.bytedance.ies.bullet.service.schema;

import com.bytedance.annie.pro.schema.AnnieProInterceptor;
import com.bytedance.ies.bullet.service.schema.interceptor.BulletInterceptor;
import com.bytedance.ies.bullet.service.schema.interceptor.BulletPadAdapterInterceptor;
import com.bytedance.ies.bullet.service.schema.interceptor.FallbackUrlInterceptor;
import com.bytedance.ies.bullet.service.sdk.GlobalSchemaConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletSchemaConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/service/schema/BulletGlobalSchemaConfig;", "Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;", "bid", "", "(Ljava/lang/String;)V", "setPadConfig", "", "padRatio", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletGlobalSchemaConfig extends GlobalSchemaConfig {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BulletGlobalSchemaConfig() {
        this(r0, 1, r0);
        String str = null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletGlobalSchemaConfig(String str) {
        super(new BulletSchemaMonitor(str));
        Intrinsics.checkNotNullParameter(str, "bid");
        addInterceptor((ISchemaInterceptor) new AnnieProInterceptor());
        addInterceptor(new BulletInterceptor(str));
        addInterceptor(new FallbackUrlInterceptor());
    }

    public /* synthetic */ BulletGlobalSchemaConfig(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "default_bid" : str);
    }

    public final void setPadConfig(double padRatio) {
        addInterceptorAtFront(new BulletPadAdapterInterceptor(Double.valueOf(padRatio)));
    }
}
