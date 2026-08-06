package com.bytedance.trae.login.bytecloud;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BytecloudAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager", f = "BytecloudAuthManager.kt", i = {0}, l = {173}, m = "fetchEnableSsoFromHost", n = {"host"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudAuthManager$fetchEnableSsoFromHost$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BytecloudAuthManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$fetchEnableSsoFromHost$1(BytecloudAuthManager bytecloudAuthManager, Continuation<? super BytecloudAuthManager$fetchEnableSsoFromHost$1> continuation) {
        super(continuation);
        this.this$0 = bytecloudAuthManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchEnableSsoFromHost;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchEnableSsoFromHost = this.this$0.fetchEnableSsoFromHost(null, (Continuation) this);
        return fetchEnableSsoFromHost;
    }
}
