package com.bytedance.trae.home.solo.task;

import android.app.Activity;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$loadTasks$1", f = "TaskViewModel.kt", i = {}, l = {358, 380}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$loadTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$loadTasks$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$loadTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$loadTasks$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x01ab A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:6:0x0021, B:8:0x01a7, B:10:0x01ab, B:11:0x01c9, B:14:0x01d3, B:16:0x01df, B:18:0x01e6, B:21:0x0256, B:22:0x0264, B:24:0x026a, B:27:0x0276, B:32:0x027a, B:33:0x02a6, B:35:0x02ac, B:37:0x02ba, B:38:0x02d3, B:40:0x02d9, B:42:0x0338, B:44:0x0352, B:45:0x0380, B:52:0x0361, B:54:0x0373, B:57:0x0030, B:59:0x0065, B:62:0x007f, B:64:0x008c, B:66:0x00cd, B:67:0x00da, B:72:0x0106, B:74:0x015a, B:76:0x0162, B:77:0x0166, B:81:0x0386, B:83:0x038a, B:85:0x0395, B:87:0x03a1, B:88:0x03a6, B:90:0x03e6, B:91:0x0421, B:92:0x0426, B:94:0x003c), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x040d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0361 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:6:0x0021, B:8:0x01a7, B:10:0x01ab, B:11:0x01c9, B:14:0x01d3, B:16:0x01df, B:18:0x01e6, B:21:0x0256, B:22:0x0264, B:24:0x026a, B:27:0x0276, B:32:0x027a, B:33:0x02a6, B:35:0x02ac, B:37:0x02ba, B:38:0x02d3, B:40:0x02d9, B:42:0x0338, B:44:0x0352, B:45:0x0380, B:52:0x0361, B:54:0x0373, B:57:0x0030, B:59:0x0065, B:62:0x007f, B:64:0x008c, B:66:0x00cd, B:67:0x00da, B:72:0x0106, B:74:0x015a, B:76:0x0162, B:77:0x0166, B:81:0x0386, B:83:0x038a, B:85:0x0395, B:87:0x03a1, B:88:0x03a6, B:90:0x03e6, B:91:0x0421, B:92:0x0426, B:94:0x003c), top: B:2:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        boolean z;
        Object listConversationsRawCall;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        Activity currentActivity;
        Set set;
        Object withContext;
        MutableStateFlow mutableStateFlow4;
        MutableStateFlow mutableStateFlow5;
        boolean z2;
        MutableStateFlow mutableStateFlow6;
        Pair pair;
        MutableStateFlow mutableStateFlow7;
        MutableStateFlow mutableStateFlow8;
        Map map;
        Set set2;
        Set<String> set3;
        MutableStateFlow mutableStateFlow9;
        MutableStateFlow mutableStateFlow10;
        MutableStateFlow mutableStateFlow11;
        boolean z3;
        Map map2;
        Map map3;
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
                    if (pair != null) {
                        mutableStateFlow7 = this.this$0._allTasks;
                        if (((List) mutableStateFlow7.getValue()).isEmpty()) {
                            mutableStateFlow8 = this.this$0._loadError;
                            mutableStateFlow8.setValue(Boxing.boxBoolean(true));
                        }
                    } else {
                        List<Conversation> list = (List) pair.component1();
                        List list2 = (List) pair.component2();
                        map = this.this$0.conversationMap;
                        map.clear();
                        TaskViewModel taskViewModel = this.this$0;
                        for (Conversation conversation : list) {
                            String id = conversation.getId();
                            if (id != null) {
                                map3 = taskViewModel.conversationMap;
                                map3.put(id, conversation);
                            }
                            TraeLogUtil.INSTANCE.d("TaskViewModel", "loadTasks conv: id=" + conversation.getId() + ", title=" + conversation.getTitle() + ", status=" + conversation.getStatus() + ", environment=" + conversation.getEnvironment() + ", cliId=" + conversation.getCliId() + ", workspace=" + conversation.getWorkspace() + ", gitUri=" + conversation.getGitUri());
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            String id2 = ((Conversation) it.next()).getId();
                            if (id2 != null) {
                                arrayList.add(id2);
                            }
                        }
                        final Set set4 = CollectionsKt.toSet(arrayList);
                        set2 = this.this$0.pendingDeleteIds;
                        final Function1 function1 = new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$loadTasks$1$$ExternalSyntheticLambda0
                            public final Object invoke(Object obj2) {
                                boolean invokeSuspend$lambda$3;
                                invokeSuspend$lambda$3 = TaskViewModel$loadTasks$1.invokeSuspend$lambda$3(set4, (String) obj2);
                                return Boolean.valueOf(invokeSuspend$lambda$3);
                            }
                        };
                        set2.removeIf(new Predicate() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$loadTasks$1$$ExternalSyntheticLambda1
                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj2) {
                                boolean invokeSuspend$lambda$4;
                                invokeSuspend$lambda$4 = TaskViewModel$loadTasks$1.invokeSuspend$lambda$4(function1, obj2);
                                return invokeSuspend$lambda$4;
                            }
                        });
                        set3 = this.this$0.pendingDeleteIds;
                        Intrinsics.checkNotNullExpressionValue(set3, "access$getPendingDeleteIds$p(...)");
                        TaskViewModel taskViewModel2 = this.this$0;
                        for (String str : set3) {
                            map2 = taskViewModel2.conversationMap;
                            map2.remove(str);
                        }
                        mutableStateFlow9 = this.this$0._allTasks;
                        mutableStateFlow9.setValue(list2);
                        mutableStateFlow10 = this.this$0._allTasks;
                        for (TaskModel taskModel : (Iterable) mutableStateFlow10.getValue()) {
                            TraeLogUtil.INSTANCE.d("TaskViewModel", "loadTasks task: id=" + taskModel.getId() + ", title=" + taskModel.getTitle() + ", status=" + taskModel.getStatus().name() + '(' + taskModel.getStatus().getStatusCode() + "), isLocal=" + taskModel.isLocal());
                        }
                        this.this$0.replaceAllConversations(list);
                        mutableStateFlow11 = this.this$0._loadError;
                        mutableStateFlow11.setValue(Boxing.boxBoolean(false));
                        z3 = this.this$0.isFirstLoadCompleted;
                        if (!z3) {
                            this.this$0.isFirstLoadCompleted = true;
                            this.this$0.reportFirstLoadEvent(list.size());
                        }
                    }
                    this.this$0.startPollingIfNeeded();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                listConversationsRawCall = obj;
            }
            HttpDataResult.Success success = (HttpDataResult) listConversationsRawCall;
            TraeLogUtil.INSTANCE.d("TaskViewModel", "loadTasks result: " + success);
            if (success instanceof HttpDataResult.Success) {
                if (!success.getBizResp().isSuccess()) {
                    TraeLogUtil.INSTANCE.e("TaskViewModel", "loadTasks biz error: code=" + success.getBizResp().getCode() + ", msg=" + success.getBizResp().getMsg());
                    mutableStateFlow4 = this.this$0._allTasks;
                    if (((List) mutableStateFlow4.getValue()).isEmpty()) {
                        mutableStateFlow6 = this.this$0._loadError;
                        mutableStateFlow6.setValue(Boxing.boxBoolean(true));
                    }
                    Unit unit = Unit.INSTANCE;
                    this.this$0.isLoadingTasks = false;
                    mutableStateFlow5 = this.this$0._contentReady;
                    mutableStateFlow5.setValue(Boxing.boxBoolean(true));
                    z2 = this.this$0.pendingReload;
                    if (z2) {
                        this.this$0.pendingReload = false;
                        this.this$0.lastLoadTime = 0L;
                        this.this$0.loadTasks();
                    }
                    return unit;
                }
                TraeLogUtil.INSTANCE.d("TaskViewModel", "loadTasks success, code=" + success.getBizResp().getCode() + ", msg=" + success.getBizResp().getMsg() + ", data=" + success.getBizResp().getData());
                ListConversationsResponse listConversationsResponse = (ListConversationsResponse) success.getBizResp().getData();
                List<Conversation> conversations = listConversationsResponse != null ? listConversationsResponse.getConversations() : null;
                if (conversations == null) {
                    conversations = CollectionsKt.emptyList();
                }
                TraeLogUtil.INSTANCE.d("TaskViewModel", "loadTasks conversations count: " + conversations.size());
                set = this.this$0.pendingDeleteIds;
                Intrinsics.checkNotNullExpressionValue(set, "access$getPendingDeleteIds$p(...)");
                Set set5 = CollectionsKt.toSet(set);
                this.label = 2;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new TaskViewModel$loadTasks$1$processedResult$1(conversations, set5, this.this$0, null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pair = (Pair) withContext;
                if (pair != null) {
                }
                this.this$0.startPollingIfNeeded();
                return Unit.INSTANCE;
            }
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((HttpDataResult.Error) success).getCode() == 401 && (currentActivity = AppHost.INSTANCE.getActivityStackManager().getCurrentActivity()) != null) {
                ForceLogoutUtils.INSTANCE.performForceLogout(currentActivity);
            }
            TraeLogUtil.INSTANCE.e("TaskViewModel", "loadTasks error: code=" + ((HttpDataResult.Error) success).getCode() + ", msg=" + ((HttpDataResult.Error) success).getMsg(), ((HttpDataResult.Error) success).getThrowable());
            mutableStateFlow2 = this.this$0._allTasks;
            if (((List) mutableStateFlow2.getValue()).isEmpty()) {
                mutableStateFlow3 = this.this$0._loadError;
                mutableStateFlow3.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        } finally {
            this.this$0.isLoadingTasks = false;
            mutableStateFlow = this.this$0._contentReady;
            mutableStateFlow.setValue(Boxing.boxBoolean(true));
            z = this.this$0.pendingReload;
            if (z) {
                this.this$0.pendingReload = false;
                this.this$0.lastLoadTime = 0L;
                this.this$0.loadTasks();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$3(Set set, String str) {
        return !set.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$4(Function1 function1, Object obj) {
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }
}
