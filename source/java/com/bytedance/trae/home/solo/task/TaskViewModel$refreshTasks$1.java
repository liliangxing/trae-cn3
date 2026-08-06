package com.bytedance.trae.home.solo.task;

import android.app.Activity;
import android.os.SystemClock;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.settings.ConversationListSettingsService;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IListConversationsService;
import com.bytedance.trae.im.service.ListConversationsResponse;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$refreshTasks$1", f = "TaskViewModel.kt", i = {}, l = {495, 507}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$refreshTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$refreshTasks$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$refreshTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$refreshTasks$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00f2 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:6:0x0017, B:8:0x00ee, B:10:0x00f2, B:11:0x0110, B:13:0x0116, B:16:0x0122, B:21:0x012a, B:25:0x014b, B:28:0x0026, B:30:0x0056, B:33:0x005e, B:35:0x006b, B:38:0x00b8, B:40:0x00c7, B:42:0x00cf, B:43:0x00d3, B:47:0x0153, B:49:0x0157, B:51:0x0162, B:53:0x016e, B:54:0x0173, B:55:0x01bf, B:56:0x01c4, B:58:0x0032), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x014b A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:6:0x0017, B:8:0x00ee, B:10:0x00f2, B:11:0x0110, B:13:0x0116, B:16:0x0122, B:21:0x012a, B:25:0x014b, B:28:0x0026, B:30:0x0056, B:33:0x005e, B:35:0x006b, B:38:0x00b8, B:40:0x00c7, B:42:0x00cf, B:43:0x00d3, B:47:0x0153, B:49:0x0157, B:51:0x0162, B:53:0x016e, B:54:0x0173, B:55:0x01bf, B:56:0x01c4, B:58:0x0032), top: B:2:0x0011 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object listConversationsRawCall;
        Activity currentActivity;
        Object withContext;
        MutableStateFlow mutableStateFlow2;
        Pair pair;
        Map map;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        Map map2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IListConversationsService.Companion companion = IListConversationsService.INSTANCE;
                int pageSize = ConversationListSettingsService.INSTANCE.getPageSize();
                this.label = 1;
                listConversationsRawCall = companion.listConversationsRawCall((r24 & 1) != 0 ? 300 : pageSize, (r24 & 2) != 0 ? 0 : 0, (r24 & 4) != 0 ? "updated_at" : null, (r24 & 8) != 0 ? "desc" : null, (r24 & 16) != 0, (r24 & 32) != 0 ? 1 : null, (r24 & 64) != 0 ? 1 : null, (r24 & 128) != 0 ? "" : null, (r24 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? null : null, (Continuation) this);
                if (listConversationsRawCall == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    withContext = obj;
                    pair = (Pair) withContext;
                    if (pair == null) {
                        List<Conversation> list = (List) pair.component1();
                        List list2 = (List) pair.component2();
                        map = this.this$0.conversationMap;
                        map.clear();
                        TaskViewModel taskViewModel = this.this$0;
                        for (Conversation conversation : list) {
                            String id = conversation.getId();
                            if (id != null) {
                                map2 = taskViewModel.conversationMap;
                                map2.put(id, conversation);
                            }
                        }
                        mutableStateFlow3 = this.this$0._allTasks;
                        mutableStateFlow3.setValue(list2);
                        mutableStateFlow4 = this.this$0._loadError;
                        mutableStateFlow4.setValue(Boxing.boxBoolean(false));
                        this.this$0.replaceAllConversations(list);
                        this.this$0.startPollingIfNeeded();
                    } else {
                        TraeLogUtil.INSTANCE.e("TaskViewModel", "refreshTasks: processedResult is null, cli types not fully resolved");
                    }
                    this.this$0.isLoadingTasks = false;
                    mutableStateFlow2 = this.this$0._isRefreshing;
                    mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                    this.this$0.lastLoadTime = SystemClock.elapsedRealtime();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                listConversationsRawCall = obj;
            }
            HttpDataResult.Success success = (HttpDataResult) listConversationsRawCall;
            if (success instanceof HttpDataResult.Success) {
                if (!success.getBizResp().isSuccess()) {
                    TraeLogUtil.INSTANCE.e("TaskViewModel", "refreshTasks biz error: code=" + success.getBizResp().getCode() + ", msg=" + success.getBizResp().getMsg());
                    return Unit.INSTANCE;
                }
                ListConversationsResponse listConversationsResponse = (ListConversationsResponse) success.getBizResp().getData();
                List<Conversation> conversations = listConversationsResponse != null ? listConversationsResponse.getConversations() : null;
                if (conversations == null) {
                    conversations = CollectionsKt.emptyList();
                }
                this.label = 2;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new TaskViewModel$refreshTasks$1$processedResult$1(conversations, this.this$0, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pair = (Pair) withContext;
                if (pair == null) {
                }
                this.this$0.isLoadingTasks = false;
                mutableStateFlow2 = this.this$0._isRefreshing;
                mutableStateFlow2.setValue(Boxing.boxBoolean(false));
                this.this$0.lastLoadTime = SystemClock.elapsedRealtime();
                return Unit.INSTANCE;
            }
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((HttpDataResult.Error) success).getCode() == 401 && (currentActivity = AppHost.INSTANCE.getActivityStackManager().getCurrentActivity()) != null) {
                ForceLogoutUtils.INSTANCE.performForceLogout(currentActivity);
            }
            TraeLogUtil.INSTANCE.e("TaskViewModel", "refreshTasks error: code=" + ((HttpDataResult.Error) success).getCode() + ", msg=" + ((HttpDataResult.Error) success).getMsg(), ((HttpDataResult.Error) success).getThrowable());
            this.this$0.isLoadingTasks = false;
            mutableStateFlow2 = this.this$0._isRefreshing;
            mutableStateFlow2.setValue(Boxing.boxBoolean(false));
            this.this$0.lastLoadTime = SystemClock.elapsedRealtime();
            return Unit.INSTANCE;
        } finally {
            this.this$0.isLoadingTasks = false;
            mutableStateFlow = this.this$0._isRefreshing;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            this.this$0.lastLoadTime = SystemClock.elapsedRealtime();
        }
    }
}
