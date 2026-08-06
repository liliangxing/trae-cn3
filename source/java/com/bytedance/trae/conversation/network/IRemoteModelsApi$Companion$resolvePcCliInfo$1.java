package com.bytedance.trae.conversation.network;

import com.bytedance.trae.conversation.network.IRemoteModelsApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IRemoteModelsApi.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion", f = "IRemoteModelsApi.kt", i = {}, l = {346}, m = "resolvePcCliInfo", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IRemoteModelsApi$Companion$resolvePcCliInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IRemoteModelsApi.Companion this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IRemoteModelsApi$Companion$resolvePcCliInfo$1(IRemoteModelsApi.Companion companion, Continuation<? super IRemoteModelsApi$Companion$resolvePcCliInfo$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolvePcCliInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolvePcCliInfo = this.this$0.resolvePcCliInfo(null, (Continuation) this);
        return resolvePcCliInfo;
    }
}
