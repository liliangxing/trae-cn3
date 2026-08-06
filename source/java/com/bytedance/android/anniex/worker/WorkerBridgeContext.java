package com.bytedance.android.anniex.worker;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.BaseBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.service.JSEventDelegate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkerBridgeContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/anniex/worker/WorkerBridgeContext;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/BaseBDXBridgeContext;", "containerID", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "jsEventDelegate", "Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "namespace", "(Ljava/lang/String;Landroid/view/View;Landroid/content/Context;Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "getJsEventDelegate", "()Lcom/bytedance/sdk/xbridge/cn/service/JSEventDelegate;", "platformType", "Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "getPlatformType", "()Lcom/bytedance/sdk/xbridge/cn/PlatformType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class WorkerBridgeContext extends BaseBDXBridgeContext {
    private final Context context;
    private final JSEventDelegate jsEventDelegate;
    private final PlatformType platformType;

    public /* synthetic */ WorkerBridgeContext(String str, View view, Context context, JSEventDelegate jSEventDelegate, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, view, context, jSEventDelegate, (i & 16) != 0 ? "" : str2);
    }

    public final Context getContext() {
        return this.context;
    }

    public JSEventDelegate getJsEventDelegate() {
        return this.jsEventDelegate;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerBridgeContext(String str, View view, Context context, JSEventDelegate jSEventDelegate, String str2) {
        super(str, view, str2);
        Intrinsics.checkNotNullParameter(str, "containerID");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jSEventDelegate, "jsEventDelegate");
        Intrinsics.checkNotNullParameter(str2, "namespace");
        this.context = context;
        this.jsEventDelegate = jSEventDelegate;
        this.platformType = PlatformType.WORKER;
    }

    public PlatformType getPlatformType() {
        return this.platformType;
    }
}
