package com.bytedance.trae.conversation.skill;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.trae.conversation.ConversationViewModel;
import com.bytedance.trae.conversation.network.IGetSkillListApi;
import com.bytedance.trae.conversation.network.ListSkillsData;
import com.bytedance.trae.conversation.network.SkillItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CreateTaskCheckRequest;
import com.bytedance.trae.im.service.CreateTaskCheckResponse;
import com.bytedance.trae.im.service.ICreateTaskCheck;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SkillsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.skill.SkillsViewModel$fetchSkills$1", f = "SkillsViewModel.kt", i = {0, 0, 1, 2}, l = {65, 101, 103}, m = "invokeSuspend", n = {"context", "isHubApi", "isHubApi", "isHubApi"}, s = {"L$0", "Z$0", "Z$0", "Z$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillsViewModel$fetchSkills$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ SkillsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillsViewModel$fetchSkills$1(SkillsViewModel skillsViewModel, boolean z, Continuation<? super SkillsViewModel$fetchSkills$1> continuation) {
        super(2, continuation);
        this.this$0 = skillsViewModel;
        this.$isLoadMore = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SkillsViewModel$fetchSkills$1(this.this$0, this.$isLoadMore, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        SkillRequestContext skillRequestContext;
        boolean shouldUseHubApi;
        Object createTaskCheckRawCall;
        String str;
        Object safeCall;
        boolean z;
        Object listSkillsFromHub;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        MutableLiveData mutableLiveData4;
        HttpDataResult httpDataResult;
        MutableLiveData mutableLiveData5;
        boolean isDeviceOfflineError;
        MutableLiveData mutableLiveData6;
        MutableLiveData mutableLiveData7;
        MutableLiveData mutableLiveData8;
        MutableLiveData mutableLiveData9;
        MutableLiveData mutableLiveData10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            skillRequestContext = new SkillRequestContext(this.this$0.getCliId(), this.this$0.getWorkspaceFolder(), this.this$0.getProjectId(), this.this$0.getConfigName(), this.this$0.getAgentType());
            shouldUseHubApi = SkillRequestPolicy.INSTANCE.shouldUseHubApi(skillRequestContext);
            if (shouldUseHubApi) {
                String conversationId = this.this$0.getConversationId();
                if (!(conversationId == null || conversationId.length() == 0)) {
                    ICreateTaskCheck.Companion companion = ICreateTaskCheck.INSTANCE;
                    String conversationId2 = this.this$0.getConversationId();
                    Intrinsics.checkNotNull(conversationId2);
                    this.L$0 = skillRequestContext;
                    this.Z$0 = shouldUseHubApi;
                    this.label = 1;
                    createTaskCheckRawCall = companion.createTaskCheckRawCall(new CreateTaskCheckRequest(conversationId2), (Continuation) this);
                    if (createTaskCheckRawCall == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            SkillRequestPolicy skillRequestPolicy = SkillRequestPolicy.INSTANCE;
            str = this.this$0.nextPageToken;
            if (!this.$isLoadMore) {
                str = null;
            }
            Map<String, String> buildQuery = skillRequestPolicy.buildQuery(skillRequestContext, str);
            if (!shouldUseHubApi) {
                this.L$0 = null;
                this.Z$0 = shouldUseHubApi;
                this.label = 2;
                listSkillsFromHub = IGetSkillListApi.INSTANCE.listSkillsFromHub(buildQuery, (Continuation) this);
                if (listSkillsFromHub == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = shouldUseHubApi;
                httpDataResult = (HttpDataResult) listSkillsFromHub;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            }
            this.L$0 = null;
            this.Z$0 = shouldUseHubApi;
            this.label = 3;
            safeCall = IGetSkillListApi.INSTANCE.safeCall(MapsKt.emptyMap(), new SkillsViewModel$fetchSkills$1$result$1(buildQuery, null), (Continuation) this);
            if (safeCall == coroutine_suspended) {
                return coroutine_suspended;
            }
            z = shouldUseHubApi;
            httpDataResult = (HttpDataResult) safeCall;
            if (!(httpDataResult instanceof HttpDataResult.Success)) {
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                listSkillsFromHub = obj;
                httpDataResult = (HttpDataResult) listSkillsFromHub;
                if (!(httpDataResult instanceof HttpDataResult.Success)) {
                }
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            ResultKt.throwOnFailure(obj);
            safeCall = obj;
            httpDataResult = (HttpDataResult) safeCall;
            if (!(httpDataResult instanceof HttpDataResult.Success)) {
                BizResponse bizResp = ((HttpDataResult.Success) httpDataResult).getBizResp();
                if (bizResp.isSuccess() || (z && bizResp.getCode() == 200)) {
                    r6 = true;
                }
                if (!r6) {
                    mutableLiveData7 = this.this$0._error;
                    String msg = bizResp.getMsg();
                    mutableLiveData7.setValue(msg != null ? msg : "获取 Skill 列表失败");
                } else {
                    ListSkillsData listSkillsData = (ListSkillsData) bizResp.getData();
                    List<SkillItem> allItems = listSkillsData != null ? listSkillsData.getAllItems() : null;
                    if (allItems == null) {
                        allItems = CollectionsKt.emptyList();
                    }
                    this.this$0.nextPageToken = listSkillsData != null ? listSkillsData.getNextPageToken() : null;
                    if (this.$isLoadMore) {
                        mutableLiveData9 = this.this$0._skills;
                        mutableLiveData10 = this.this$0._skills;
                        List list = (List) mutableLiveData10.getValue();
                        if (list == null) {
                            list = CollectionsKt.emptyList();
                        }
                        mutableLiveData9.setValue(CollectionsKt.plus(list, allItems));
                    } else {
                        mutableLiveData8 = this.this$0._skills;
                        mutableLiveData8.setValue(allItems);
                    }
                }
            } else if (httpDataResult instanceof HttpDataResult.Error) {
                if (z) {
                    isDeviceOfflineError = this.this$0.isDeviceOfflineError(((HttpDataResult.Error) httpDataResult).getErrorBody());
                    if (isDeviceOfflineError) {
                        mutableLiveData6 = this.this$0._isDeviceOffline;
                        mutableLiveData6.setValue(Boxing.boxBoolean(true));
                    }
                }
                mutableLiveData5 = this.this$0._error;
                String msg2 = ((HttpDataResult.Error) httpDataResult).getMsg();
                mutableLiveData5.setValue(msg2.length() == 0 ? "获取 Skill 列表失败" : msg2);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return Unit.INSTANCE;
        }
        shouldUseHubApi = this.Z$0;
        skillRequestContext = (SkillRequestContext) this.L$0;
        ResultKt.throwOnFailure(obj);
        createTaskCheckRawCall = obj;
        HttpDataResult.Success success = (HttpDataResult) createTaskCheckRawCall;
        if (success instanceof HttpDataResult.Success) {
            HttpDataResult.Success success2 = success;
            if (success2.getBizResp().getCode() == ConversationViewModel.CODE_DEVICE_OFFLINE) {
                mutableLiveData4 = this.this$0._isDeviceOffline;
                mutableLiveData4.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            if (success2.getBizResp().getCode() == ConversationViewModel.CODE_IDE_DEVICE_OFFLINE) {
                mutableLiveData3 = this.this$0._isDeviceProjectOffline;
                mutableLiveData3.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            CreateTaskCheckResponse createTaskCheckResponse = (CreateTaskCheckResponse) success2.getBizResp().getData();
            if (!(createTaskCheckResponse != null ? createTaskCheckResponse.getAvailable() : false)) {
                mutableLiveData2 = this.this$0._isDeviceOffline;
                mutableLiveData2.setValue(Boxing.boxBoolean(true));
                return Unit.INSTANCE;
            }
            CreateTaskCheckResponse createTaskCheckResponse2 = (CreateTaskCheckResponse) success2.getBizResp().getData();
            if ((createTaskCheckResponse2 != null ? createTaskCheckResponse2.getProjectId() : null) != null) {
                CreateTaskCheckResponse createTaskCheckResponse3 = (CreateTaskCheckResponse) success2.getBizResp().getData();
                skillRequestContext.setProjectId(createTaskCheckResponse3 != null ? createTaskCheckResponse3.getProjectId() : null);
            }
            SkillRequestPolicy skillRequestPolicy2 = SkillRequestPolicy.INSTANCE;
            str = this.this$0.nextPageToken;
            if (!this.$isLoadMore) {
            }
            Map<String, String> buildQuery2 = skillRequestPolicy2.buildQuery(skillRequestContext, str);
            if (!shouldUseHubApi) {
            }
        } else {
            if (success instanceof HttpDataResult.Error) {
                mutableLiveData = this.this$0._error;
                String msg3 = ((HttpDataResult.Error) success).getMsg();
                mutableLiveData.setValue(msg3.length() == 0 ? "获取 Skill 列表失败" : msg3);
                return Unit.INSTANCE;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
