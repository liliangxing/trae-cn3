package com.bytedance.ies.bullet.service.base.api;

import android.os.Bundle;
import com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001a\u0010)\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u000f\"\u0004\b+\u0010\u0011¨\u0006,"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/UIShowConfig;", "", "()V", "animationBundle", "Landroid/os/Bundle;", "getAnimationBundle", "()Landroid/os/Bundle;", "setAnimationBundle", "(Landroid/os/Bundle;)V", "bundle", "getBundle", "setBundle", "callId", "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", RouterConstants.QUERY_KEY_FLAGS, "", "getFlags", "()Ljava/lang/Integer;", "setFlags", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "interceptors", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "getInterceptors", "()Ljava/util/List;", "setInterceptors", "(Ljava/util/List;)V", "lifecycleListener", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "getLifecycleListener", "()Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "setLifecycleListener", "(Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;)V", "requestCode", "getRequestCode", "setRequestCode", "sessionId", "getSessionId", "setSessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class UIShowConfig {
    private Bundle animationBundle;
    private Integer flags;
    private List<? extends ISchemaInterceptor> interceptors;
    private Integer requestCode;
    private String sessionId = "";
    private String callId = "";
    private Bundle bundle = new Bundle();
    private IBulletUILifecycleListener lifecycleListener = new IBulletUILifecycleListener.Base();

    public final Integer getFlags() {
        return this.flags;
    }

    public final void setFlags(Integer num) {
        this.flags = num;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final void setCallId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callId = str;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.bundle = bundle;
    }

    public final Bundle getAnimationBundle() {
        return this.animationBundle;
    }

    public final void setAnimationBundle(Bundle bundle) {
        this.animationBundle = bundle;
    }

    public final Integer getRequestCode() {
        return this.requestCode;
    }

    public final void setRequestCode(Integer num) {
        this.requestCode = num;
    }

    public final IBulletUILifecycleListener getLifecycleListener() {
        return this.lifecycleListener;
    }

    public final void setLifecycleListener(IBulletUILifecycleListener iBulletUILifecycleListener) {
        Intrinsics.checkNotNullParameter(iBulletUILifecycleListener, "<set-?>");
        this.lifecycleListener = iBulletUILifecycleListener;
    }

    public final List<ISchemaInterceptor> getInterceptors() {
        return this.interceptors;
    }

    public final void setInterceptors(List<? extends ISchemaInterceptor> list) {
        this.interceptors = list;
    }
}
