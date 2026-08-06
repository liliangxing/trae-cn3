package com.bytedance.trae.conversation.network;

import com.bytedance.keva.Keva;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import com.bytedance.trae.conversation.AccountSettingsKeva;
import com.bytedance.trae.conversation.network.IGetTaskTemplatesApi;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* compiled from: TaskTemplateRepository.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000fJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0086@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\b\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u001c\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/network/TaskTemplateRepository;", "", "<init>", "()V", "KEVA_REPO_SUFFIX", "", "KEY_TEMPLATES", "getKeva", "Lcom/bytedance/keva/Keva;", "gson", "Lcom/google/gson/Gson;", "KEY_SEND_MESSAGE_COUNT", "isShow", "", "add", "", "count", "", OauthTokenTriggerScene.PRELOAD, "getCacheTaskTemplates", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/network/TaskTemplatesData;", "getTaskTemplates", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toTaskTemplateModels", "", "Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;", "Lcom/bytedance/trae/conversation/network/TaskTemplate;", "mode", "TaskTemplateModel", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TaskTemplateRepository {
    private static final String KEVA_REPO_SUFFIX = "task_templates";
    private static final String KEY_SEND_MESSAGE_COUNT = "send_showcase_count";
    private static final String KEY_TEMPLATES = "template_list";
    public static final TaskTemplateRepository INSTANCE = new TaskTemplateRepository();
    private static final Gson gson = new Gson();

    private TaskTemplateRepository() {
    }

    private final Keva getKeva() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        Keva repo = Keva.getRepo(str + KEVA_REPO_SUFFIX);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }

    public final boolean isShow() {
        return AccountSettingsKeva.INSTANCE.getKeva().getInt(KEY_SEND_MESSAGE_COUNT, 0) < 3;
    }

    public final void add(int count) {
        int i = AccountSettingsKeva.INSTANCE.getKeva().getInt(KEY_SEND_MESSAGE_COUNT, 0);
        if (i > 10) {
            return;
        }
        AccountSettingsKeva.INSTANCE.getKeva().storeInt(KEY_SEND_MESSAGE_COUNT, i + count);
    }

    public final void preload() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new TaskTemplateRepository$preload$1(null), 3, (Object) null);
    }

    public final HttpDataResult<TaskTemplatesData> getCacheTaskTemplates() {
        Object obj;
        String string = getKeva().getString(KEY_TEMPLATES, (String) null);
        String str = string;
        if (!(str == null || str.length() == 0)) {
            try {
                Result.Companion companion = Result.Companion;
                TaskTemplateRepository taskTemplateRepository = this;
                obj = Result.constructor-impl((TaskTemplatesData) gson.fromJson(string, TaskTemplatesData.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            TaskTemplatesData taskTemplatesData = (TaskTemplatesData) obj;
            if (taskTemplatesData != null) {
                return new HttpDataResult.Success<>(new BizResponse(0L, (String) null, (String) null, (String) null, taskTemplatesData, (String) null, 46, (DefaultConstructorMarker) null), (Throwable) null);
            }
        }
        return new HttpDataResult.Error<>(-1, "cache is empty", (Throwable) null, (String) null, 8, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getTaskTemplates(Continuation<? super HttpDataResult<TaskTemplatesData>> continuation) {
        TaskTemplateRepository$getTaskTemplates$1 taskTemplateRepository$getTaskTemplates$1;
        int i;
        Object obj;
        TaskTemplateRepository taskTemplateRepository;
        HttpDataResult.Success success;
        TaskTemplatesData taskTemplatesData;
        if (continuation instanceof TaskTemplateRepository$getTaskTemplates$1) {
            taskTemplateRepository$getTaskTemplates$1 = (TaskTemplateRepository$getTaskTemplates$1) continuation;
            if ((taskTemplateRepository$getTaskTemplates$1.label & Integer.MIN_VALUE) != 0) {
                taskTemplateRepository$getTaskTemplates$1.label -= Integer.MIN_VALUE;
                Object obj2 = taskTemplateRepository$getTaskTemplates$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = taskTemplateRepository$getTaskTemplates$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    String string = getKeva().getString(KEY_TEMPLATES, (String) null);
                    String str = string;
                    if (!(str == null || str.length() == 0)) {
                        try {
                            Result.Companion companion = Result.Companion;
                            TaskTemplateRepository taskTemplateRepository2 = this;
                            obj = Result.constructor-impl((TaskTemplatesData) gson.fromJson(string, TaskTemplatesData.class));
                        } catch (Throwable th) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th));
                        }
                        if (Result.isFailure-impl(obj)) {
                            obj = null;
                        }
                        TaskTemplatesData taskTemplatesData2 = (TaskTemplatesData) obj;
                        if (taskTemplatesData2 != null) {
                            return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, taskTemplatesData2, (String) null, 46, (DefaultConstructorMarker) null), (Throwable) null);
                        }
                    }
                    IGetTaskTemplatesApi.Companion companion3 = IGetTaskTemplatesApi.INSTANCE;
                    TaskTemplateRepository$getTaskTemplates$result$1 taskTemplateRepository$getTaskTemplates$result$1 = new TaskTemplateRepository$getTaskTemplates$result$1(null);
                    taskTemplateRepository$getTaskTemplates$1.L$0 = this;
                    taskTemplateRepository$getTaskTemplates$1.label = 1;
                    obj2 = companion3.safeCall(taskTemplateRepository$getTaskTemplates$result$1, taskTemplateRepository$getTaskTemplates$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    taskTemplateRepository = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    taskTemplateRepository = (TaskTemplateRepository) taskTemplateRepository$getTaskTemplates$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                success = (HttpDataResult) obj2;
                if ((success instanceof HttpDataResult.Success) && (taskTemplatesData = (TaskTemplatesData) success.getBizResp().getData()) != null) {
                    try {
                        Result.Companion companion4 = Result.Companion;
                        TaskTemplateRepository taskTemplateRepository3 = taskTemplateRepository;
                        taskTemplateRepository.getKeva().storeString(KEY_TEMPLATES, gson.toJson(taskTemplatesData));
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th2) {
                        Result.Companion companion5 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th2));
                    }
                }
                return success;
            }
        }
        taskTemplateRepository$getTaskTemplates$1 = new TaskTemplateRepository$getTaskTemplates$1(this, continuation);
        Object obj22 = taskTemplateRepository$getTaskTemplates$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = taskTemplateRepository$getTaskTemplates$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj22;
        if (success instanceof HttpDataResult.Success) {
            Result.Companion companion42 = Result.Companion;
            TaskTemplateRepository taskTemplateRepository32 = taskTemplateRepository;
            taskTemplateRepository.getKeva().storeString(KEY_TEMPLATES, gson.toJson(taskTemplatesData));
            Result.constructor-impl(Unit.INSTANCE);
        }
        return success;
    }

    /* compiled from: TaskTemplateRepository.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/network/TaskTemplateRepository$TaskTemplateModel;", "", "id", "", "title", "", "prompt", "gitPrompt", "icon", "mode", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "getPrompt", "getGitPrompt", "getIcon", "getMode", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TaskTemplateModel {
        private final String gitPrompt;
        private final String icon;
        private final int id;
        private final String mode;
        private final String prompt;
        private final String title;

        public static /* synthetic */ TaskTemplateModel copy$default(TaskTemplateModel taskTemplateModel, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = taskTemplateModel.id;
            }
            if ((i2 & 2) != 0) {
                str = taskTemplateModel.title;
            }
            String str6 = str;
            if ((i2 & 4) != 0) {
                str2 = taskTemplateModel.prompt;
            }
            String str7 = str2;
            if ((i2 & 8) != 0) {
                str3 = taskTemplateModel.gitPrompt;
            }
            String str8 = str3;
            if ((i2 & 16) != 0) {
                str4 = taskTemplateModel.icon;
            }
            String str9 = str4;
            if ((i2 & 32) != 0) {
                str5 = taskTemplateModel.mode;
            }
            return taskTemplateModel.copy(i, str6, str7, str8, str9, str5);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: component3, reason: from getter */
        public final String getPrompt() {
            return this.prompt;
        }

        /* renamed from: component4, reason: from getter */
        public final String getGitPrompt() {
            return this.gitPrompt;
        }

        /* renamed from: component5, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        /* renamed from: component6, reason: from getter */
        public final String getMode() {
            return this.mode;
        }

        public final TaskTemplateModel copy(int id, String title, String prompt, String gitPrompt, String icon, String mode) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(prompt, "prompt");
            Intrinsics.checkNotNullParameter(gitPrompt, "gitPrompt");
            Intrinsics.checkNotNullParameter(icon, "icon");
            Intrinsics.checkNotNullParameter(mode, "mode");
            return new TaskTemplateModel(id, title, prompt, gitPrompt, icon, mode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskTemplateModel)) {
                return false;
            }
            TaskTemplateModel taskTemplateModel = (TaskTemplateModel) other;
            return this.id == taskTemplateModel.id && Intrinsics.areEqual(this.title, taskTemplateModel.title) && Intrinsics.areEqual(this.prompt, taskTemplateModel.prompt) && Intrinsics.areEqual(this.gitPrompt, taskTemplateModel.gitPrompt) && Intrinsics.areEqual(this.icon, taskTemplateModel.icon) && Intrinsics.areEqual(this.mode, taskTemplateModel.mode);
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.prompt.hashCode()) * 31) + this.gitPrompt.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.mode.hashCode();
        }

        public String toString() {
            return "TaskTemplateModel(id=" + this.id + ", title=" + this.title + ", prompt=" + this.prompt + ", gitPrompt=" + this.gitPrompt + ", icon=" + this.icon + ", mode=" + this.mode + ')';
        }

        public TaskTemplateModel(int i, String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "prompt");
            Intrinsics.checkNotNullParameter(str3, "gitPrompt");
            Intrinsics.checkNotNullParameter(str4, "icon");
            Intrinsics.checkNotNullParameter(str5, "mode");
            this.id = i;
            this.title = str;
            this.prompt = str2;
            this.gitPrompt = str3;
            this.icon = str4;
            this.mode = str5;
        }

        public final int getId() {
            return this.id;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getPrompt() {
            return this.prompt;
        }

        public final String getGitPrompt() {
            return this.gitPrompt;
        }

        public final String getIcon() {
            return this.icon;
        }

        public final String getMode() {
            return this.mode;
        }
    }

    public final List<TaskTemplateModel> toTaskTemplateModels(List<TaskTemplate> list, String str) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(str, "mode");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : list) {
            Integer valueOf = Integer.valueOf(((TaskTemplate) obj).getId());
            Object obj2 = linkedHashMap.get(valueOf);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(valueOf, obj2);
            }
            ((List) obj2).add(obj);
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            List<TaskTemplate> list2 = (List) ((Map.Entry) it.next()).getValue();
            TaskTemplate taskTemplate = (TaskTemplate) CollectionsKt.first(list2);
            String str2 = "";
            String str3 = str2;
            for (TaskTemplate taskTemplate2 : list2) {
                String type = taskTemplate2.getType();
                if (Intrinsics.areEqual(type, "normal")) {
                    str2 = taskTemplate2.getPrompt();
                } else if (Intrinsics.areEqual(type, "git")) {
                    str3 = taskTemplate2.getPrompt();
                }
            }
            arrayList.add(new TaskTemplateModel(taskTemplate.getId(), taskTemplate.getTitle(), str2, str3, taskTemplate.getIcon(), taskTemplate.getMode()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (Intrinsics.areEqual(((TaskTemplateModel) obj3).getMode(), str)) {
                arrayList2.add(obj3);
            }
        }
        return arrayList2;
    }
}
