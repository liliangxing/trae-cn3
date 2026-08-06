package com.bytedance.trae.home.solo.task;

import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.IListConversationsService;
import com.bytedance.trae.im.service.SearchConversationItem;
import com.bytedance.trae.im.service.SearchConversationsResponse;
import com.bytedance.trae.network.NetworkMonitor;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "trimmedQuery", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$scheduleSearch$3", f = "TaskViewModel.kt", i = {0, 1}, l = {605, 616}, m = "invokeSuspend", n = {"trimmedQuery", "trimmedQuery"}, s = {"L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$scheduleSearch$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$scheduleSearch$3(TaskViewModel taskViewModel, Continuation<? super TaskViewModel$scheduleSearch$3> continuation) {
        super(2, continuation);
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> taskViewModel$scheduleSearch$3 = new TaskViewModel$scheduleSearch$3(this.this$0, continuation);
        taskViewModel$scheduleSearch$3.L$0 = obj;
        return taskViewModel$scheduleSearch$3;
    }

    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return create(str, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0112  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        Object searchRawCall;
        String str;
        Object searchLocalTasks;
        String str2;
        MutableStateFlow mutableStateFlow5;
        MutableStateFlow mutableStateFlow6;
        MutableStateFlow mutableStateFlow7;
        MutableStateFlow mutableStateFlow8;
        MutableStateFlow mutableStateFlow9;
        MutableStateFlow mutableStateFlow10;
        MutableStateFlow mutableStateFlow11;
        MutableStateFlow mutableStateFlow12;
        MutableStateFlow mutableStateFlow13;
        MutableStateFlow mutableStateFlow14;
        TaskModel taskModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str3 = (String) this.L$0;
            mutableStateFlow = this.this$0._searchQuery;
            String obj2 = StringsKt.trim((String) mutableStateFlow.getValue()).toString();
            mutableStateFlow2 = this.this$0._isSearchMode;
            if (!((Boolean) mutableStateFlow2.getValue()).booleanValue() || !Intrinsics.areEqual(obj2, str3)) {
                return Unit.INSTANCE;
            }
            if (!NetworkMonitor.INSTANCE.isNetworkAvailable()) {
                this.L$0 = str3;
                this.label = 1;
                searchLocalTasks = this.this$0.searchLocalTasks(str3, (Continuation) this);
                if (searchLocalTasks == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str2 = str3;
                List list = (List) searchLocalTasks;
                mutableStateFlow5 = this.this$0._isSearchMode;
                if (((Boolean) mutableStateFlow5.getValue()).booleanValue()) {
                }
                return Unit.INSTANCE;
            }
            mutableStateFlow3 = this.this$0._isSearchLoading;
            mutableStateFlow3.setValue(Boxing.boxBoolean(true));
            mutableStateFlow4 = this.this$0._searchResults;
            mutableStateFlow4.setValue((Object) null);
            this.L$0 = str3;
            this.label = 2;
            searchRawCall = IListConversationsService.INSTANCE.searchRawCall(str3, (r19 & 2) != 0 ? 20 : 0, (r19 & 4) != 0 ? 0 : 0, (r19 & 8) != 0 ? 0L : 0L, (r19 & 16) != 0 ? 0L : 0L, (Continuation) this);
            if (searchRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = str3;
            HttpDataResult.Success success = (HttpDataResult) searchRawCall;
            mutableStateFlow9 = this.this$0._isSearchMode;
            if (((Boolean) mutableStateFlow9.getValue()).booleanValue()) {
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            str2 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
            searchLocalTasks = obj;
            List list2 = (List) searchLocalTasks;
            mutableStateFlow5 = this.this$0._isSearchMode;
            if (((Boolean) mutableStateFlow5.getValue()).booleanValue()) {
                mutableStateFlow6 = this.this$0._searchQuery;
                if (Intrinsics.areEqual(StringsKt.trim((String) mutableStateFlow6.getValue()).toString(), str2)) {
                    mutableStateFlow7 = this.this$0._searchResults;
                    mutableStateFlow7.setValue(list2);
                    mutableStateFlow8 = this.this$0._isSearchLoading;
                    mutableStateFlow8.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) this.L$0;
        ResultKt.throwOnFailure(obj);
        searchRawCall = obj;
        HttpDataResult.Success success2 = (HttpDataResult) searchRawCall;
        mutableStateFlow9 = this.this$0._isSearchMode;
        if (((Boolean) mutableStateFlow9.getValue()).booleanValue()) {
            mutableStateFlow10 = this.this$0._searchQuery;
            if (Intrinsics.areEqual(StringsKt.trim((String) mutableStateFlow10.getValue()).toString(), str)) {
                if (success2 instanceof HttpDataResult.Success) {
                    HttpDataResult.Success success3 = success2;
                    if (success3.getBizResp().isSuccess()) {
                        SearchConversationsResponse searchConversationsResponse = (SearchConversationsResponse) success3.getBizResp().getData();
                        List<SearchConversationItem> items = searchConversationsResponse != null ? searchConversationsResponse.getItems() : null;
                        if (items == null) {
                            items = CollectionsKt.emptyList();
                        }
                        SearchConversationsResponse searchConversationsResponse2 = (SearchConversationsResponse) success3.getBizResp().getData();
                        List<String> highlightKeywords = searchConversationsResponse2 != null ? searchConversationsResponse2.getHighlightKeywords() : null;
                        if (highlightKeywords == null) {
                            highlightKeywords = CollectionsKt.emptyList();
                        }
                        mutableStateFlow14 = this.this$0._searchResults;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj3 : items) {
                            SearchConversationItem searchConversationItem = (SearchConversationItem) obj3;
                            String cliId = searchConversationItem.getCliId();
                            if ((cliId == null || cliId.length() == 0) || CliListRepository.INSTANCE.getInstance().getCliTypeById(searchConversationItem.getCliId()) != null) {
                                arrayList.add(obj3);
                            }
                        }
                        TaskViewModel taskViewModel = this.this$0;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            taskModel = taskViewModel.toTaskModel((SearchConversationItem) it.next(), str, highlightKeywords);
                            if (taskModel != null) {
                                arrayList2.add(taskModel);
                            }
                        }
                        HashSet hashSet = new HashSet();
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj4 : arrayList2) {
                            if (hashSet.add(((TaskModel) obj4).getId())) {
                                arrayList3.add(obj4);
                            }
                        }
                        mutableStateFlow14.setValue(arrayList3);
                    } else {
                        TraeLogUtil.INSTANCE.e("TaskViewModel", "searchConversations biz error: code=" + success3.getBizResp().getCode() + ", msg=" + success3.getBizResp().getMsg());
                        mutableStateFlow13 = this.this$0._searchResults;
                        mutableStateFlow13.setValue(CollectionsKt.emptyList());
                    }
                } else {
                    if (!(success2 instanceof HttpDataResult.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    HttpDataResult.Error error = (HttpDataResult.Error) success2;
                    TraeLogUtil.INSTANCE.e("TaskViewModel", "searchConversations error: code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
                    mutableStateFlow11 = this.this$0._searchResults;
                    mutableStateFlow11.setValue(CollectionsKt.emptyList());
                }
                mutableStateFlow12 = this.this$0._isSearchLoading;
                mutableStateFlow12.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
