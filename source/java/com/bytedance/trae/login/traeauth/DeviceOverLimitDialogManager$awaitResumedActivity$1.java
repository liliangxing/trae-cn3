package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeviceOverLimitDialogManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.traeauth.DeviceOverLimitDialogManager", f = "DeviceOverLimitDialogManager.kt", i = {}, l = {62, 123}, m = "awaitResumedActivity", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DeviceOverLimitDialogManager$awaitResumedActivity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceOverLimitDialogManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeviceOverLimitDialogManager$awaitResumedActivity$1(DeviceOverLimitDialogManager deviceOverLimitDialogManager, Continuation<? super DeviceOverLimitDialogManager$awaitResumedActivity$1> continuation) {
        super(continuation);
        this.this$0 = deviceOverLimitDialogManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object awaitResumedActivity;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        awaitResumedActivity = this.this$0.awaitResumedActivity((Continuation) this);
        return awaitResumedActivity;
    }
}
