package com.bytedance.trae.login.bytecloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager", f = "BytecloudAuthManager.kt", i = {}, l = {234}, m = "checkIntranetRealTime", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager$checkIntranetRealTime$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BytecloudAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$checkIntranetRealTime$1(BytecloudAuthManager bytecloudAuthManager, Continuation<? super BytecloudAuthManager$checkIntranetRealTime$1> continuation) {
        super(continuation);
        this.this$0 = bytecloudAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkIntranetRealTime((Continuation) this);
    }
}
