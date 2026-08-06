package com.bytedance.trae.login.traeauth;

import com.bytedance.perf.monitor.ReportConst;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceOverLimitDialogManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager", f = "DeviceOverLimitDialogManager.kt", i = {0, 0, 0}, l = {34, 36}, m = "showWhenReady", n = {"listResult", ReportConst.KEY_SCENE, "callback"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialogManager$showWhenReady$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceOverLimitDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialogManager$showWhenReady$1(DeviceOverLimitDialogManager deviceOverLimitDialogManager, Continuation<? super DeviceOverLimitDialogManager$showWhenReady$1> continuation) {
        super(continuation);
        this.this$0 = deviceOverLimitDialogManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showWhenReady(null, null, null, (Continuation) this);
    }
}
