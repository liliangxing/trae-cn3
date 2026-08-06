package com.bytedance.trae.home.solo.task;

import androidx.lifecycle.ViewModelKt;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.im.database.ConversationDao;
import com.bytedance.trae.im.service.DeleteConversationRequest;
import com.bytedance.trae.im.service.IDeleteConversationService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.network.response.HttpDataResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TaskViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$deleteConversation$1", f = "TaskViewModel.kt", i = {}, l = {869, 873, 876, 887}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskViewModel$deleteConversation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    int label;
    final /* synthetic */ TaskViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskViewModel$deleteConversation$1(String str, TaskViewModel taskViewModel, Continuation<? super TaskViewModel$deleteConversation$1> continuation) {
        super(2, continuation);
        this.$conversationId = str;
        this.this$0 = taskViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TaskViewModel$deleteConversation$1(this.$conversationId, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        MutableSharedFlow mutableSharedFlow3;
        Map map;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IDeleteConversationService.INSTANCE.deleteConversationRawCall(new DeleteConversationRequest(this.$conversationId), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        map = this.this$0.conversationMap;
                        map.remove(this.$conversationId);
                        mutableStateFlow = this.this$0._allTasks;
                        mutableStateFlow2 = this.this$0._allTasks;
                        Iterable iterable = (Iterable) mutableStateFlow2.getValue();
                        String str = this.$conversationId;
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : iterable) {
                            if (!Intrinsics.areEqual(((TaskModel) obj2).getId(), str)) {
                                arrayList.add(obj2);
                            }
                        }
                        mutableStateFlow.setValue(arrayList);
                        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new C08582(this.this$0, this.$conversationId, null), 2, (Object) null);
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
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (!(success instanceof HttpDataResult.Success)) {
            if (!(success instanceof HttpDataResult.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            HttpDataResult.Error error = (HttpDataResult.Error) success;
            TraeLogUtil.INSTANCE.e("TaskViewModel", "deleteConversation error: code=" + error.getCode() + ", msg=" + error.getMsg(), error.getThrowable());
            mutableSharedFlow = this.this$0._toastMessage;
            this.label = 4;
            if (mutableSharedFlow.emit(Boxing.boxInt(C0820R.string.solo_toast_delete_failed), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (success.getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
            mutableSharedFlow3 = this.this$0._toastMessage;
            this.label = 2;
            if (mutableSharedFlow3.emit(Boxing.boxInt(R.string.trae_conversation_device_offline), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            TraeLogUtil.INSTANCE.d("TaskViewModel", "deleteConversation success");
            mutableSharedFlow2 = this.this$0._toastMessage;
            this.label = 3;
            if (mutableSharedFlow2.emit(Boxing.boxInt(C0820R.string.solo_toast_delete_success), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            map = this.this$0.conversationMap;
            map.remove(this.$conversationId);
            mutableStateFlow = this.this$0._allTasks;
            mutableStateFlow2 = this.this$0._allTasks;
            Iterable iterable2 = (Iterable) mutableStateFlow2.getValue();
            String str2 = this.$conversationId;
            ArrayList arrayList2 = new ArrayList();
            while (r0.hasNext()) {
            }
            mutableStateFlow.setValue(arrayList2);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), Dispatchers.getIO(), (CoroutineStart) null, new C08582(this.this$0, this.$conversationId, null), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TaskViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.home.solo.task.TaskViewModel$deleteConversation$1$2", f = "TaskViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.home.solo.task.TaskViewModel$deleteConversation$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C08582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $conversationId;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TaskViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08582(TaskViewModel taskViewModel, String str, Continuation<? super C08582> continuation) {
            super(2, continuation);
            this.this$0 = taskViewModel;
            this.$conversationId = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c08582 = new C08582(this.this$0, this.$conversationId, continuation);
            c08582.L$0 = obj;
            return c08582;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ConversationDao conversationDao;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TaskViewModel taskViewModel = this.this$0;
            String str = this.$conversationId;
            try {
                Result.Companion companion = Result.Companion;
                conversationDao = taskViewModel.conversationDao;
                conversationDao.deleteById(str);
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }
}
