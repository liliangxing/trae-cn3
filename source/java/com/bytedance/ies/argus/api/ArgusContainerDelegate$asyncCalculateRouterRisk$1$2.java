package com.bytedance.ies.argus.api;

import com.bytedance.ies.argus.bean.AspectContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ArgusContainerDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ArgusContainerDelegate$asyncCalculateRouterRisk$1$2 extends Lambda implements Function0<JSONObject> {
    final /* synthetic */ AspectContext $context;
    final /* synthetic */ ArgusContainerDelegate this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArgusContainerDelegate$asyncCalculateRouterRisk$1$2(ArgusContainerDelegate argusContainerDelegate, AspectContext aspectContext) {
        super(0);
        this.this$0 = argusContainerDelegate;
        this.$context = aspectContext;
    }

    public final JSONObject invoke() {
        return this.this$0.getArgusContext().toMonitorObject(this.$context.getVerifyResult().getAction());
    }
}
