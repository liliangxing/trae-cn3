package com.bytedance.trae.home.solo.task;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.CliListRepository;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.im.service.IRenameConversationService;
import com.bytedance.trae.im.service.RenameConversationRequest;
import com.bytedance.trae.im.service.RenameConversationResponse;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Map;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$renameConversation$1", f = "TaskViewModel.kt", i = {2}, l = {826, 830, 833, 861}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$renameConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $newTitle;
    Object L$0;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$renameConversation$1(String str, String str2, TaskViewModel taskViewModel, Continuation<? super TaskViewModel$renameConversation$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.$newTitle = str2;
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$renameConversation$1(this.$conversationId, this.$newTitle, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object renameConversationRawCall;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        HttpDataResult httpDataResult;
        MutableSharedFlow mutableSharedFlow3;
        Conversation conversation;
        Map map;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        String str;
        ArrayList arrayList;
        TaskModel taskModel;
        TaskModel copy;
        Conversation copy2;
        Map map2;
        TaskModel taskModel2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        Map map3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            renameConversationRawCall = IRenameConversationService.INSTANCE.renameConversationRawCall(new RenameConversationRequest(this.$conversationId, this.$newTitle), (Continuation) this);
            if (renameConversationRawCall == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        httpDataResult = (HttpDataResult) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        RenameConversationResponse renameConversationResponse = (RenameConversationResponse) ((HttpDataResult.Success) httpDataResult).getBizResp().getData();
                        conversation = renameConversationResponse == null ? renameConversationResponse.getConversation() : null;
                        if (conversation != null) {
                            map = this.this$0.conversationMap;
                            Conversation conversation2 = (Conversation) map.get(this.$conversationId);
                            if (conversation2 != null) {
                                String str2 = this.$newTitle;
                                TaskViewModel taskViewModel = this.this$0;
                                String str3 = this.$conversationId;
                                copy2 = conversation2.copy((r44 & 1) != 0 ? conversation2.id : null, (r44 & 2) != 0 ? conversation2.parentConversationId : null, (r44 & 4) != 0 ? conversation2.hiddenStatus : null, (r44 & 8) != 0 ? conversation2.cliConversationId : null, (r44 & 16) != 0 ? conversation2.userId : null, (r44 & 32) != 0 ? conversation2.cliId : null, (r44 & 64) != 0 ? conversation2.title : str2, (r44 & 128) != 0 ? conversation2.workspace : null, (r44 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? conversation2.gitUri : null, (r44 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? conversation2.mode : null, (r44 & 1024) != 0 ? conversation2.status : null, (r44 & 2048) != 0 ? conversation2.environment : null, (r44 & 4096) != 0 ? conversation2.latestTaskId : null, (r44 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? conversation2.latestTaskStatus : null, (r44 & 16384) != 0 ? conversation2.latestTaskUpdateTime : null, (r44 & 32768) != 0 ? conversation2.createdAt : null, (r44 & 65536) != 0 ? conversation2.updatedAt : null, (r44 & 131072) != 0 ? conversation2.source : null, (r44 & 262144) != 0 ? conversation2.iconType : null, (r44 & FConstants.SLICE_SIZE) != 0 ? conversation2.cliConversationStatus : null, (r44 & 1048576) != 0 ? conversation2.ownerProjectId : null, (r44 & 2097152) != 0 ? conversation2.latestProjectId : null, (r44 & 4194304) != 0 ? conversation2.ownerProjectAbsolutePath : null, (r44 & 8388608) != 0 ? conversation2.ownerProjectWorkSpaceStatus : null, (r44 & 16777216) != 0 ? conversation2.isPinned : null, (r44 & 33554432) != 0 ? conversation2.pinnedAt : null);
                                map2 = taskViewModel.conversationMap;
                                map2.put(str3, copy2);
                                taskViewModel.persistConversations(CollectionsKt.listOf(copy2));
                            }
                            mutableStateFlow = this.this$0._allTasks;
                            mutableStateFlow2 = this.this$0._allTasks;
                            Iterable<TaskModel> iterable = (Iterable) mutableStateFlow2.getValue();
                            String str4 = this.$conversationId;
                            String str5 = this.$newTitle;
                            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                            for (TaskModel taskModel3 : iterable) {
                                if (Intrinsics.areEqual(taskModel3.getId(), str4)) {
                                    ArrayList arrayList3 = arrayList2;
                                    str = str5;
                                    copy = taskModel3.copy((r40 & 1) != 0 ? taskModel3.id : null, (r40 & 2) != 0 ? taskModel3.initial : null, (r40 & 4) != 0 ? taskModel3.title : str5, (r40 & 8) != 0 ? taskModel3.status : null, (r40 & 16) != 0 ? taskModel3.tag : null, (r40 & 32) != 0 ? taskModel3.location : null, (r40 & 64) != 0 ? taskModel3.time : null, (r40 & 128) != 0 ? taskModel3.updatedAt : null, (r40 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? taskModel3.cliId : null, (r40 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? taskModel3.mode : null, (r40 & 1024) != 0 ? taskModel3.isUnread : false, (r40 & 2048) != 0 ? taskModel3.isPinned : false, (r40 & 4096) != 0 ? taskModel3.pinnedAt : null, (r40 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? taskModel3.supportsPin : false, (r40 & 16384) != 0 ? taskModel3.isLocal : false, (r40 & 32768) != 0 ? taskModel3.isDeviceOnline : false, (r40 & 65536) != 0 ? taskModel3.cliType : null, (r40 & 131072) != 0 ? taskModel3.iconType : null, (r40 & 262144) != 0 ? taskModel3.searchSnippet : null, (r40 & FConstants.SLICE_SIZE) != 0 ? taskModel3.searchQuery : null, (r40 & 1048576) != 0 ? taskModel3.searchHighlightKeywords : null, (r40 & 2097152) != 0 ? taskModel3.searchAnchorCreatedAtMs : null);
                                    taskModel = copy;
                                    arrayList = arrayList3;
                                } else {
                                    str = str5;
                                    arrayList = arrayList2;
                                    taskModel = taskModel3;
                                }
                                arrayList.add(taskModel);
                                arrayList2 = arrayList;
                                str5 = str;
                            }
                            mutableStateFlow.setValue(arrayList2);
                        } else {
                            if (!Intrinsics.areEqual(conversation.getEnvironment(), CliType.REMOTE.getValue())) {
                                conversation.setEnvironment(CliListRepository.INSTANCE.getInstance().getCliTypeById(conversation.getCliId()));
                            }
                            String id = conversation.getId();
                            if (id != null) {
                                map3 = this.this$0.conversationMap;
                                map3.put(id, conversation);
                            }
                            this.this$0.persistConversations(CollectionsKt.listOf(conversation));
                            taskModel2 = this.this$0.toTaskModel(conversation);
                            mutableStateFlow3 = this.this$0._allTasks;
                            mutableStateFlow4 = this.this$0._allTasks;
                            Iterable<TaskModel> iterable2 = (Iterable) mutableStateFlow4.getValue();
                            String str6 = this.$conversationId;
                            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                            for (TaskModel taskModel4 : iterable2) {
                                if (Intrinsics.areEqual(taskModel4.getId(), str6)) {
                                    taskModel4 = taskModel2;
                                }
                                arrayList4.add(taskModel4);
                            }
                            mutableStateFlow3.setValue(arrayList4);
                        }
                        return Unit.INSTANCE;
                    }
                    if (i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            renameConversationRawCall = obj;
        }
        HttpDataResult httpDataResult2 = (HttpDataResult) renameConversationRawCall;
        if (!(httpDataResult2 instanceof HttpDataResult.Success)) {
            if (!(httpDataResult2 instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            HttpDataResult.Error error = (HttpDataResult.Error) httpDataResult2;
            TraeLogUtil.INSTANCE.e("TaskViewModel", "renameConversation error: code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
            mutableSharedFlow = this.this$0._toastMessage;
            this.label = 4;
            if (mutableSharedFlow.emit(Boxing.boxInt(C0820R.string.solo_toast_rename_failed), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (((HttpDataResult.Success) httpDataResult2).getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
            mutableSharedFlow3 = this.this$0._toastMessage;
            this.label = 2;
            if (mutableSharedFlow3.emit(Boxing.boxInt(R.string.trae_conversation_device_offline), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            TraeLogUtil.INSTANCE.d("TaskViewModel", "renameConversation success");
            mutableSharedFlow2 = this.this$0._toastMessage;
            this.L$0 = httpDataResult2;
            this.label = 3;
            if (mutableSharedFlow2.emit(Boxing.boxInt(C0820R.string.solo_toast_rename_success), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpDataResult = httpDataResult2;
            RenameConversationResponse renameConversationResponse2 = (RenameConversationResponse) ((HttpDataResult.Success) httpDataResult).getBizResp().getData();
            if (renameConversationResponse2 == null) {
            }
            if (conversation != null) {
            }
        }
        return Unit.INSTANCE;
    }
}
