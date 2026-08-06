package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.repository.ConversationDetailCacheRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$searchLocalTasks$2", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$searchLocalTasks$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends TaskModel>>, Object> {
    final /* synthetic */ String $query;
    final /* synthetic */ List<TaskModel> $tasksSnapshot;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$searchLocalTasks$2(List<TaskModel> list, String str, TaskViewModel taskViewModel, Continuation<? super TaskViewModel$searchLocalTasks$2> continuation) {
        super(2, continuation);
        this.$tasksSnapshot = list;
        this.$query = str;
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$searchLocalTasks$2(this.$tasksSnapshot, this.$query, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<TaskModel>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        TaskLocalSearch taskLocalSearch = TaskLocalSearch.INSTANCE;
        List<TaskModel> list = this.$tasksSnapshot;
        String str = this.$query;
        final TaskViewModel taskViewModel = this.this$0;
        return taskLocalSearch.search(list, str, new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda0
            public final Object invoke(Object obj2) {
                List invokeSuspend$lambda$2;
                invokeSuspend$lambda$2 = TaskViewModel$searchLocalTasks$2.invokeSuspend$lambda$2(TaskViewModel.this, (TaskModel) obj2);
                return invokeSuspend$lambda$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List invokeSuspend$lambda$2(TaskViewModel taskViewModel, TaskModel taskModel) {
        ConversationDetailCacheRepository conversationDetailCacheRepository;
        conversationDetailCacheRepository = taskViewModel.conversationDetailCacheRepository;
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(conversationDetailCacheRepository.loadCachedMessages(taskModel.getId(), 2000)), new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                boolean isUserMessage;
                isUserMessage = ((ParsedChatMessage) obj).isUserMessage();
                return Boolean.valueOf(isUserMessage);
            }
        }), new Function1() { // from class: com.bytedance.trae.home.solo.task.TaskViewModel$searchLocalTasks$2$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                String invokeSuspend$lambda$2$lambda$1;
                invokeSuspend$lambda$2$lambda$1 = TaskViewModel$searchLocalTasks$2.invokeSuspend$lambda$2$lambda$1((ParsedChatMessage) obj);
                return invokeSuspend$lambda$2$lambda$1;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String invokeSuspend$lambda$2$lambda$1(ParsedChatMessage parsedChatMessage) {
        return TaskLocalSearch.INSTANCE.userQueryText(parsedChatMessage.getQuery());
    }
}
