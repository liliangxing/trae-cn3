package com.bytedance.trae.home.solo.setting.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SettingsCreditsRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository", f = "SettingsCreditsRepository.kt", i = {}, l = {88}, m = "fetchCreditsUsage", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultSettingsCreditsRepository$fetchCreditsUsage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultSettingsCreditsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultSettingsCreditsRepository$fetchCreditsUsage$1(DefaultSettingsCreditsRepository defaultSettingsCreditsRepository, Continuation<? super DefaultSettingsCreditsRepository$fetchCreditsUsage$1> continuation) {
        super(continuation);
        this.this$0 = defaultSettingsCreditsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchCreditsUsage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchCreditsUsage = this.this$0.fetchCreditsUsage((Continuation) this);
        return fetchCreditsUsage;
    }
}
