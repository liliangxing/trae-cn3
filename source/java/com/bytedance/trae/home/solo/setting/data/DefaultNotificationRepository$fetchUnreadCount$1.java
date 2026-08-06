package com.bytedance.trae.home.solo.setting.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationRepository.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultNotificationRepository", f = "NotificationRepository.kt", i = {}, l = {37}, m = "fetchUnreadCount", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultNotificationRepository$fetchUnreadCount$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DefaultNotificationRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultNotificationRepository$fetchUnreadCount$1(DefaultNotificationRepository defaultNotificationRepository, Continuation<? super DefaultNotificationRepository$fetchUnreadCount$1> continuation) {
        super(continuation);
        this.this$0 = defaultNotificationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        Object fetchUnreadCount;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchUnreadCount = this.this$0.fetchUnreadCount((Continuation) this);
        return fetchUnreadCount;
    }
}
