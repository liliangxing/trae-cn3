package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.CliListRefreshResult;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0001*\u00020\u0005H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lkotlin/Pair;", "", "Lcom/bytedance/trae/im/service/Conversation;", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$loadTasks$1$processedResult$1", f = "TaskViewModel.kt", i = {0, 0}, l = {390}, m = "invokeSuspend", n = {"cliListRepo", "allCliTypeFound"}, s = {"L$0", "I$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class TaskViewModel$loadTasks$1$processedResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends List<? extends Conversation>, ? extends List<? extends TaskModel>>>, Object> {
    final /* synthetic */ List<Conversation> $conversations;
    final /* synthetic */ Set<String> $deleteIdsSnapshot;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$loadTasks$1$processedResult$1(List<Conversation> list, Set<String> set, TaskViewModel taskViewModel, Continuation<? super TaskViewModel$loadTasks$1$processedResult$1> continuation) {
        super(2, continuation);
        this.$conversations = list;
        this.$deleteIdsSnapshot = set;
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$loadTasks$1$processedResult$1(this.$conversations, this.$deleteIdsSnapshot, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends List<Conversation>, ? extends List<TaskModel>>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[LOOP:5: B:101:0x003f->B:122:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[LOOP:0: B:13:0x00bb->B:34:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x010b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CliListRepository companion;
        boolean z;
        boolean z2;
        int i;
        List sortTasks;
        TaskModel taskModel;
        boolean z3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            companion = CliListRepository.INSTANCE.getInstance();
            List<Conversation> list = this.$conversations;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Conversation conversation : list) {
                    String cliId = conversation.getCliId();
                    String str = cliId;
                    if (!(str == null || str.length() == 0) && !Intrinsics.areEqual(conversation.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
                        String cliTypeById = companion.getCliTypeById(cliId);
                        if (cliTypeById == null || cliTypeById.length() == 0) {
                            z = true;
                            if (!z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            if (z2) {
                this.L$0 = companion;
                this.I$0 = 1;
                this.label = 1;
                obj = companion.refreshClisResult((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = 1;
            }
            i = 1;
            if (i != 0) {
                return null;
            }
            for (Conversation conversation2 : this.$conversations) {
                if (!Intrinsics.areEqual(conversation2.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
                    conversation2.setEnvironment(companion.getCliTypeById(conversation2.getCliId()));
                }
            }
            List<Conversation> list2 = this.$conversations;
            Set<String> set = this.$deleteIdsSnapshot;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list2) {
                String id = ((Conversation) obj2).getId();
                if (!(id != null && set.contains(id))) {
                    arrayList.add(obj2);
                }
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : arrayList) {
                if (hashSet.add(((Conversation) obj3).getId())) {
                    arrayList2.add(obj3);
                }
            }
            ArrayList arrayList3 = arrayList2;
            TaskViewModel taskViewModel = this.this$0;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                taskModel = taskViewModel.toTaskModel((Conversation) it.next());
                arrayList4.add(taskModel);
            }
            sortTasks = this.this$0.sortTasks(arrayList4);
            return new Pair(this.$conversations, sortTasks);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i = this.I$0;
        companion = (CliListRepository) this.L$0;
        ResultKt.throwOnFailure(obj);
        if (((CliListRefreshResult) obj).isSuccess()) {
            List<Conversation> list3 = this.$conversations;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                for (Conversation conversation3 : list3) {
                    String cliId2 = conversation3.getCliId();
                    String str2 = cliId2;
                    if (!(str2 == null || str2.length() == 0) && !Intrinsics.areEqual(conversation3.getDisplayEnvironment(), CliType.REMOTE.getValue())) {
                        String cliTypeById2 = companion.getCliTypeById(cliId2);
                        if (cliTypeById2 == null || cliTypeById2.length() == 0) {
                            z3 = false;
                            if (z3) {
                                i = 0;
                                break;
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                    }
                }
            }
            i = 1;
        }
        if (i != 0) {
        }
    }
}
