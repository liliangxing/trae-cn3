package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.task.FilterOption;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lcom/bytedance/trae/home/solo/task/TaskModel;", "allTasks", "filter", "Lcom/bytedance/trae/home/solo/task/FilterOption;", "isSearchMode", "", "query", "", "searchResults"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$tasks$1", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class TaskViewModel$tasks$1 extends SuspendLambda implements Function6<List<? extends TaskModel>, FilterOption, Boolean, String, List<? extends TaskModel>, Continuation<? super List<? extends TaskModel>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$tasks$1(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$tasks$1> continuation) {
        super(6, continuation);
        this.this$0 = taskViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke((List<TaskModel>) obj, (FilterOption) obj2, ((Boolean) obj3).booleanValue(), (String) obj4, (List<TaskModel>) obj5, (Continuation<? super List<TaskModel>>) obj6);
    }

    public final Object invoke(List<TaskModel> list, FilterOption filterOption, boolean z, String str, List<TaskModel> list2, Continuation<? super List<TaskModel>> continuation) {
        TaskViewModel$tasks$1 taskViewModel$tasks$1 = new TaskViewModel$tasks$1(this.this$0, continuation);
        taskViewModel$tasks$1.L$0 = list;
        taskViewModel$tasks$1.L$1 = filterOption;
        taskViewModel$tasks$1.Z$0 = z;
        taskViewModel$tasks$1.L$2 = str;
        taskViewModel$tasks$1.L$3 = list2;
        return taskViewModel$tasks$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List sortedForTaskList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ArrayList arrayList = (List) this.L$0;
        FilterOption filterOption = (FilterOption) this.L$1;
        boolean z = this.Z$0;
        String str = (String) this.L$2;
        List list = (List) this.L$3;
        String obj2 = StringsKt.trim(str).toString();
        if (z) {
            if ((obj2.length() > 0) && list != null) {
                return list;
            }
        }
        if (!(filterOption instanceof FilterOption.All)) {
            if (!(filterOption instanceof FilterOption.Cloud)) {
                if (!(filterOption instanceof FilterOption.Device)) {
                    throw new NoWhenBranchMatchedException();
                }
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : arrayList) {
                    if (Intrinsics.areEqual(((TaskModel) obj3).getCliId(), ((FilterOption.Device) filterOption).getCliId())) {
                        arrayList2.add(obj3);
                    }
                }
                arrayList = arrayList2;
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj4 : arrayList) {
                    if (!((TaskModel) obj4).isLocal()) {
                        arrayList3.add(obj4);
                    }
                }
                arrayList = arrayList3;
            }
        }
        sortedForTaskList = this.this$0.sortedForTaskList(arrayList);
        return sortedForTaskList;
    }
}
