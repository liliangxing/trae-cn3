package com.bytedance.android.anniex.lite.flow.base;

import android.os.Bundle;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import java.util.List;
import kotlin.Metadata;

/* compiled from: FlowDispatchConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/lite/flow/base/FlowDispatchConfig;", "", "()V", "bundle", "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "interceptors", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class FlowDispatchConfig {
    private Bundle bundle;
    private List<? extends ISchemaInterceptor> interceptors;

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public final List<ISchemaInterceptor> getInterceptors() {
        return this.interceptors;
    }

    public final void setInterceptors(List<? extends ISchemaInterceptor> list) {
        this.interceptors = list;
    }
}
