package com.bytedance.trae.home.solo.setting.data;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: NotificationRepository.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tR\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;", "", "unreadCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "getUnreadCount", "()Lkotlinx/coroutines/flow/StateFlow;", "refresh", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NotificationRepository {
    StateFlow<Integer> getUnreadCount();

    Object refresh(Continuation<? super Unit> continuation);
}
