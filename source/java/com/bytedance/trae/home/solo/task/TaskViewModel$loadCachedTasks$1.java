package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$loadCachedTasks$1", f = "TaskViewModel.kt", i = {}, l = {698}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$loadCachedTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$loadCachedTasks$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$loadCachedTasks$1> continuation) {
        super(2, continuation);
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> taskViewModel$loadCachedTasks$1 = new TaskViewModel$loadCachedTasks$1(this.this$0, continuation);
        taskViewModel$loadCachedTasks$1.L$0 = obj;
        return taskViewModel$loadCachedTasks$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        MutableStateFlow mutableStateFlow;
        List sortTasks;
        TaskModel taskModel;
        boolean isConversationDisplayable;
        ConversationDao conversationDao;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TaskViewModel taskViewModel = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                conversationDao = taskViewModel.conversationDao;
                obj2 = Result.constructor-impl(conversationDao.queryAll());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.exceptionOrNull-impl(obj2) != null) {
                obj2 = CollectionsKt.emptyList();
            }
            List list = (List) obj2;
            if (!list.isEmpty()) {
                mutableStateFlow = this.this$0._allTasks;
                if (((List) mutableStateFlow.getValue()).isEmpty()) {
                    TraeLogUtil.INSTANCE.d("TaskViewModel", "loadCachedTasks: loaded " + list.size() + " conversations from DB");
                    TaskViewModel taskViewModel2 = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : list) {
                        isConversationDisplayable = taskViewModel2.isConversationDisplayable((Conversation) obj3);
                        if (isConversationDisplayable) {
                            arrayList.add(obj3);
                        }
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList<Conversation> arrayList3 = arrayList2;
                    for (Conversation conversation : arrayList3) {
                        if (!Intrinsics.areEqual(conversation.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
                            conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
                        }
                    }
                    TaskViewModel taskViewModel3 = this.this$0;
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        taskModel = taskViewModel3.toTaskModel((Conversation) it.next());
                        arrayList4.add(taskModel);
                    }
                    sortTasks = taskViewModel3.sortTasks(arrayList4);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C08592(arrayList2, this.this$0, sortTasks, null), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$loadCachedTasks$1$2", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.task.TaskViewModel$loadCachedTasks$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08592 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<Conversation> $filtered;
        final /* synthetic */ List<TaskModel> $tasks;
        int label;
        final /* synthetic */ TaskViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08592(List<Conversation> list, TaskViewModel taskViewModel, List<TaskModel> list2, Continuation<? super C08592> continuation) {
            super(2, continuation);
            this.$filtered = list;
            this.this$0 = taskViewModel;
            this.$tasks = list2;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08592(this.$filtered, this.this$0, this.$tasks, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            MutableStateFlow mutableStateFlow2;
            MutableStateFlow mutableStateFlow3;
            Map map;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<Conversation> list = this.$filtered;
            TaskViewModel taskViewModel = this.this$0;
            for (Conversation conversation : list) {
                String id = conversation.getId();
                if (id != null) {
                    map = taskViewModel.conversationMap;
                    map.put(id, conversation);
                }
            }
            mutableStateFlow = this.this$0._allTasks;
            if (((List) mutableStateFlow.getValue()).isEmpty()) {
                mutableStateFlow2 = this.this$0._allTasks;
                mutableStateFlow2.setValue(this.$tasks);
                mutableStateFlow3 = this.this$0._contentReady;
                mutableStateFlow3.setValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
        }
    }
}
