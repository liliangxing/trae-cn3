package com.bytedance.trae.conversation.chat.checkpoint;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.checkpoint.CheckpointDecision;
import com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet;
import com.bytedance.trae.conversation.plugin.PluginListCache;
import com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.service.ModelSelectionConstants;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CheckpointDialogManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eJ\u0016\u0010\u0019\u001a\u00020\u00102\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bJ$\u0010\u001b\u001a\u00020\u00102\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012J\u0006\u0010\u001d\u001a\u00020\u0010J:\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010&\u001a\u00020\u0005J\u0012\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020)H\u0002JF\u0010*\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\b\u0010%\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0016\u00103\u001a\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u00104\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0002JD\u0010:\u001a\u00020;2\u0006\u0010\u001f\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u0005H\u0002J \u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u0005H\u0002J\u001a\u0010A\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u0001082\u0006\u0010C\u001a\u00020\u0005H\u0002J \u0010D\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointDialogManager;", "", "<init>", "()V", "CHECK_POINT_TAG", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "interactionCallback", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointInteractionCallback;", "appContextProvider", "Lkotlin/Function0;", "Landroid/content/Context;", "containerId", "", "onDismissAction", "", "onFileClick", "Lkotlin/Function2;", "init", "contextProvider", "setInteractionCallback", "callback", "setContainerId", "id", "setOnDismissAction", "action", "setOnFileClick", "listener", "release", "showCheckpointDialog", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "planItem", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "taskId", "conversationId", "messageId", "mode", "extractPluginName", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "presentCheckpointDialog", "cb", "resolvedPluginDisplayName", "buildPages", "", "Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointPage;", "getStringRes", "resId", "fallback", "buildAskUserQuestionPages", "extractQuestionsJson", "getQuestionsArray", "Lcom/google/gson/JsonArray;", "params", "Lcom/google/gson/JsonObject;", "buildSimplePage", "tryBypassWithBottomSheet", "", "getProviderDisplayName", "provider", "getLocalizedProviderName", "context", "pluginName", "buildAuthorizationParams", "originalParams", PageDataManager.EXTRA_STATUS, "reportBypassAuthOutcome", "SERVICE_SEPARATOR", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CheckpointDialogManager {
    private static final String CHECK_POINT_TAG = "CheckPointDialog";
    private static final String SERVICE_SEPARATOR = "::";
    private static Function0<? extends Context> appContextProvider;
    private static int containerId;
    private static CheckpointInteractionCallback interactionCallback;
    private static Function0<Unit> onDismissAction;
    private static Function2<? super String, ? super String, Unit> onFileClick;
    public static final CheckpointDialogManager INSTANCE = new CheckpointDialogManager();
    private static CoroutineScope scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));

    private CheckpointDialogManager() {
    }

    public final void init(Function0<? extends Context> contextProvider) {
        Intrinsics.checkNotNullParameter(contextProvider, "contextProvider");
        appContextProvider = contextProvider;
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] init");
    }

    public final void setInteractionCallback(CheckpointInteractionCallback callback) {
        interactionCallback = callback;
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] setInteractionCallback: " + (callback != null));
    }

    public final void setContainerId(int id) {
        containerId = id;
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] setContainerId: " + id);
    }

    public final void setOnDismissAction(Function0<Unit> action) {
        onDismissAction = action;
    }

    public final void setOnFileClick(Function2<? super String, ? super String, Unit> listener) {
        onFileClick = listener;
    }

    public final void release() {
        CoroutineScopeKt.cancel$default(scope, (CancellationException) null, 1, (Object) null);
        scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        interactionCallback = null;
        appContextProvider = null;
        onDismissAction = null;
        onFileClick = null;
        containerId = 0;
    }

    public final void showCheckpointDialog(FragmentManager fragmentManager, ParsedPlanItem planItem, String taskId, String conversationId, String messageId, String mode) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(planItem, "planItem");
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        Intrinsics.checkNotNullParameter(mode, "mode");
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("[DialogManager] showCheckpointDialog: taskId=").append(taskId).append(", conversationId=").append(conversationId).append(", planItemId=").append(planItem.getId()).append(", toolName=");
        ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
        fLogger.i(CHECK_POINT_TAG, append.append(toolCallInfo != null ? toolCallInfo.getName() : null).toString());
        CheckpointInteractionCallback checkpointInteractionCallback = interactionCallback;
        if (checkpointInteractionCallback == null) {
            FLogger.INSTANCE.w(CHECK_POINT_TAG, "[DialogManager] ABORT: interactionCallback is null");
            PluginTracker.INSTANCE.trackAuthFail("checkpoint", "interaction_callback_null");
            Function0<Unit> function0 = onDismissAction;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        if (containerId == 0) {
            FLogger.INSTANCE.w(CHECK_POINT_TAG, "[DialogManager] ABORT: containerId is not set");
            PluginTracker.INSTANCE.trackAuthFail("checkpoint", "container_id_not_set");
            Function0<Unit> function02 = onDismissAction;
            if (function02 != null) {
                function02.invoke();
                return;
            }
            return;
        }
        ParsedToolCallInfo toolCallInfo2 = planItem.getToolCallInfo();
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] toolCallInfo: name=" + (toolCallInfo2 != null ? toolCallInfo2.getName() : null) + ", hasParams=" + ((toolCallInfo2 != null ? toolCallInfo2.getParams() : null) != null) + ", hasResult=" + ((toolCallInfo2 != null ? toolCallInfo2.getResult() : null) != null));
        if (tryBypassWithBottomSheet(fragmentManager, toolCallInfo2, planItem, taskId, conversationId, checkpointInteractionCallback, mode)) {
            return;
        }
        if (Intrinsics.areEqual(toolCallInfo2 != null ? toolCallInfo2.getName() : null, "RequestAuthorization")) {
            String extractPluginName = extractPluginName(toolCallInfo2);
            PluginTracker.INSTANCE.trackPluginInvoked(extractPluginName == null ? "" : extractPluginName, "plugin", ModelSelectionConstants.AUTO, mode);
            if (extractPluginName != null) {
                String cachedLocalizedDisplayName = PluginListCache.INSTANCE.getCachedLocalizedDisplayName(extractPluginName);
                if (cachedLocalizedDisplayName != null) {
                    presentCheckpointDialog(fragmentManager, planItem, taskId, conversationId, messageId, checkpointInteractionCallback, cachedLocalizedDisplayName);
                    return;
                } else {
                    BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, new CheckpointDialogManager$showCheckpointDialog$1(extractPluginName, fragmentManager, planItem, taskId, conversationId, messageId, checkpointInteractionCallback, null), 3, (Object) null);
                    return;
                }
            }
        }
        presentCheckpointDialog(fragmentManager, planItem, taskId, conversationId, messageId, checkpointInteractionCallback, null);
    }

    private final String extractPluginName(ParsedToolCallInfo toolCallInfo) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            CheckpointDialogManager checkpointDialogManager = this;
            JsonObject params = toolCallInfo.getParams();
            String asString = (params == null || (jsonElement = params.get(TracingConstants.KEY_TRACE_NAME)) == null) ? null : jsonElement.getAsString();
            if (asString == null) {
                asString = "";
            }
            obj = Result.constructor-impl(asString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str = (String) (Result.isFailure-impl(obj) ? "" : obj);
        String str2 = str;
        if (StringsKt.isBlank(str2)) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default(str2, "::", 0, false, 6, (Object) null);
        if (indexOf$default <= 0) {
            return str;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void presentCheckpointDialog(FragmentManager fragmentManager, ParsedPlanItem planItem, String taskId, String conversationId, final String messageId, CheckpointInteractionCallback cb, String resolvedPluginDisplayName) {
        List<CheckpointPage> listOf;
        ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
        if (toolCallInfo != null) {
            listOf = buildPages(toolCallInfo);
        } else {
            listOf = CollectionsKt.listOf(new CheckpointPage(getStringRes(C0637R.string.trae_checkpoint_fallback_title, "Action Required"), CollectionsKt.emptyList(), false, false, false, 24, null));
        }
        List<CheckpointPage> list = listOf;
        String extractQuestionsJson = extractQuestionsJson(toolCallInfo);
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] built " + list.size() + " pages, questionsJson.length=" + extractQuestionsJson.length());
        CheckpointDialog.INSTANCE.show(fragmentManager, containerId, planItem, taskId, conversationId, extractQuestionsJson, list, planItem.getConfirmInfo(), cb, new Function0() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit presentCheckpointDialog$lambda$1;
                presentCheckpointDialog$lambda$1 = CheckpointDialogManager.presentCheckpointDialog$lambda$1();
                return presentCheckpointDialog$lambda$1;
            }
        }, new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit presentCheckpointDialog$lambda$2;
                presentCheckpointDialog$lambda$2 = CheckpointDialogManager.presentCheckpointDialog$lambda$2(messageId, (String) obj);
                return presentCheckpointDialog$lambda$2;
            }
        }, resolvedPluginDisplayName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presentCheckpointDialog$lambda$1() {
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] onDismiss invoked");
        Function0<Unit> function0 = onDismissAction;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit presentCheckpointDialog$lambda$2(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "filePath");
        Function2<? super String, ? super String, Unit> function2 = onFileClick;
        if (function2 != null) {
            function2.invoke(str2, str);
        }
        return Unit.INSTANCE;
    }

    private final List<CheckpointPage> buildPages(ParsedToolCallInfo toolCallInfo) {
        String name = toolCallInfo.getName();
        if (name == null) {
            FLogger.INSTANCE.w(CHECK_POINT_TAG, "[DialogManager] buildPages: toolName is null, using simplePage");
            return CollectionsKt.listOf(buildSimplePage(toolCallInfo));
        }
        if (Intrinsics.areEqual(name, "AskUserQuestion")) {
            FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] buildPages: AskUserQuestion flow");
            return buildAskUserQuestionPages(toolCallInfo);
        }
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] buildPages: simplePage for tool=" + name);
        return CollectionsKt.listOf(buildSimplePage(toolCallInfo));
    }

    private final String getStringRes(int resId, String fallback) {
        Context context;
        try {
            Function0<? extends Context> function0 = appContextProvider;
            if (function0 == null || (context = (Context) function0.invoke()) == null) {
                return fallback;
            }
            String string = context.getString(resId);
            return string == null ? fallback : string;
        } catch (Exception unused) {
            return fallback;
        }
    }

    private final List<CheckpointPage> buildAskUserQuestionPages(ParsedToolCallInfo toolCallInfo) {
        CheckpointOption checkpointOption;
        String asString;
        String asString2;
        CheckpointPage checkpointPage;
        CheckpointOption checkpointOption2;
        String asString3;
        String asString4;
        JsonObject params = toolCallInfo.getParams();
        if (params == null) {
            return CollectionsKt.listOf(buildSimplePage(toolCallInfo));
        }
        Iterable<JsonObject> questionsArray = getQuestionsArray(params);
        if (questionsArray == null || questionsArray.size() <= 0) {
            String stringRes = getStringRes(C0637R.string.trae_checkpoint_ask_user_default_title, "Agent has a question");
            JsonElement jsonElement = params.get("question");
            String str = (jsonElement == null || (asString2 = jsonElement.getAsString()) == null) ? stringRes : asString2;
            JsonArray asJsonArray = params.getAsJsonArray("options");
            if (asJsonArray == null) {
                asJsonArray = new JsonArray();
            }
            JsonElement jsonElement2 = params.get("multiSelect");
            boolean asBoolean = jsonElement2 != null ? jsonElement2.getAsBoolean() : false;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (Object obj : (Iterable) asJsonArray) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                JsonObject jsonObject = (JsonElement) obj;
                JsonObject jsonObject2 = jsonObject instanceof JsonObject ? jsonObject : null;
                if (jsonObject2 == null) {
                    checkpointOption = null;
                } else {
                    String str2 = "opt_" + i;
                    JsonElement jsonElement3 = jsonObject2.get("label");
                    String str3 = (jsonElement3 == null || (asString = jsonElement3.getAsString()) == null) ? "" : asString;
                    JsonElement jsonElement4 = jsonObject2.get("description");
                    checkpointOption = new CheckpointOption(str2, str3, jsonElement4 != null ? jsonElement4.getAsString() : null, false, 8, null);
                }
                if (checkpointOption != null) {
                    arrayList.add(checkpointOption);
                }
                i = i2;
            }
            return CollectionsKt.listOf(new CheckpointPage(str, arrayList, true, asBoolean, false, 16, null));
        }
        ArrayList arrayList2 = new ArrayList();
        for (JsonObject jsonObject3 : questionsArray) {
            JsonObject jsonObject4 = jsonObject3 instanceof JsonObject ? jsonObject3 : null;
            if (jsonObject4 == null) {
                checkpointPage = null;
            } else {
                String stringRes2 = INSTANCE.getStringRes(C0637R.string.trae_checkpoint_default_question, "Question");
                JsonElement jsonElement5 = jsonObject4.get("question");
                String str4 = (jsonElement5 == null || (asString4 = jsonElement5.getAsString()) == null) ? stringRes2 : asString4;
                JsonElement jsonElement6 = jsonObject4.get("allowCustomInput");
                boolean asBoolean2 = jsonElement6 != null ? jsonElement6.getAsBoolean() : true;
                JsonElement jsonElement7 = jsonObject4.get("multiSelect");
                boolean asBoolean3 = jsonElement7 != null ? jsonElement7.getAsBoolean() : false;
                JsonArray asJsonArray2 = jsonObject4.getAsJsonArray("options");
                if (asJsonArray2 == null) {
                    asJsonArray2 = new JsonArray();
                }
                ArrayList arrayList3 = new ArrayList();
                int i3 = 0;
                for (Object obj2 : (Iterable) asJsonArray2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    JsonObject jsonObject5 = (JsonElement) obj2;
                    JsonObject jsonObject6 = jsonObject5 instanceof JsonObject ? jsonObject5 : null;
                    if (jsonObject6 == null) {
                        checkpointOption2 = null;
                    } else {
                        String str5 = "opt_" + i3;
                        JsonElement jsonElement8 = jsonObject6.get("label");
                        String str6 = (jsonElement8 == null || (asString3 = jsonElement8.getAsString()) == null) ? "" : asString3;
                        JsonElement jsonElement9 = jsonObject6.get("description");
                        checkpointOption2 = new CheckpointOption(str5, str6, jsonElement9 != null ? jsonElement9.getAsString() : null, false, 8, null);
                    }
                    if (checkpointOption2 != null) {
                        arrayList3.add(checkpointOption2);
                    }
                    i3 = i4;
                }
                checkpointPage = new CheckpointPage(str4, arrayList3, asBoolean2, asBoolean3, false, 16, null);
            }
            if (checkpointPage != null) {
                arrayList2.add(checkpointPage);
            }
        }
        ArrayList arrayList4 = arrayList2;
        return arrayList4.isEmpty() ? CollectionsKt.listOf(INSTANCE.buildSimplePage(toolCallInfo)) : arrayList4;
    }

    private final String extractQuestionsJson(ParsedToolCallInfo toolCallInfo) {
        JsonObject params;
        JsonArray questionsArray;
        String jsonArray;
        return (toolCallInfo == null || (params = toolCallInfo.getParams()) == null || (questionsArray = getQuestionsArray(params)) == null || (jsonArray = questionsArray.toString()) == null) ? "[]" : jsonArray;
    }

    private final JsonArray getQuestionsArray(JsonObject params) {
        JsonElement jsonElement = params.get("questions");
        if (jsonElement == null) {
            return null;
        }
        if (jsonElement.isJsonArray()) {
            return jsonElement.getAsJsonArray();
        }
        if (!jsonElement.isJsonPrimitive()) {
            return null;
        }
        try {
            JsonElement parseString = JsonParser.parseString(jsonElement.getAsString());
            if (parseString.isJsonArray()) {
                return parseString.getAsJsonArray();
            }
            return null;
        } catch (Exception e) {
            FLogger.INSTANCE.w(CHECK_POINT_TAG, "[DialogManager] getQuestionsArray: failed to parse string as JsonArray: " + e.getMessage());
            return null;
        }
    }

    private final CheckpointPage buildSimplePage(ParsedToolCallInfo toolCallInfo) {
        return new CheckpointPage("", CollectionsKt.emptyList(), false, false, false, 24, null);
    }

    private final boolean tryBypassWithBottomSheet(FragmentManager fragmentManager, final ParsedToolCallInfo toolCallInfo, final ParsedPlanItem planItem, final String taskId, final String conversationId, final CheckpointInteractionCallback cb, String mode) {
        Object obj;
        String str;
        String str2;
        Context context;
        JsonElement jsonElement;
        String str3 = null;
        if (!Intrinsics.areEqual(toolCallInfo != null ? toolCallInfo.getName() : null, "RequestAuthorization")) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            CheckpointDialogManager checkpointDialogManager = this;
            JsonObject params = toolCallInfo.getParams();
            if (params != null && (jsonElement = params.get(TracingConstants.KEY_TRACE_NAME)) != null) {
                str3 = jsonElement.getAsString();
            }
            if (str3 == null) {
                str3 = "";
            }
            obj = Result.constructor-impl(str3);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        String str4 = (String) (Result.isFailure-impl(obj) ? "" : obj);
        int indexOf$default = StringsKt.indexOf$default(str4, "::", 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            str = str4.substring(indexOf$default + 2);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        } else {
            str = str4;
        }
        if (!PluginConnectorOAuthManager.INSTANCE.isDesktopRedirectProvider(str)) {
            return false;
        }
        FLogger.INSTANCE.i(CHECK_POINT_TAG, "[DialogManager] bypass confirm card for desktop redirect provider: " + str);
        if (indexOf$default > 0) {
            str2 = str4.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str2, "substring(...)");
        } else {
            str2 = str4;
        }
        PluginTracker.INSTANCE.trackPluginInvoked(str2, "plugin", ModelSelectionConstants.AUTO, mode);
        Function0<? extends Context> function0 = appContextProvider;
        if (function0 == null || (context = (Context) function0.invoke()) == null) {
            return false;
        }
        String providerDisplayName = getProviderDisplayName(str);
        String localizedProviderName = getLocalizedProviderName(context, str, str2);
        PluginTracker.INSTANCE.trackAuthStart(str, "chat_hint");
        PluginAuthorizationBottomSheet newInstance = PluginAuthorizationBottomSheet.INSTANCE.newInstance(str, providerDisplayName, localizedProviderName, 1);
        final String str5 = str;
        final String str6 = str2;
        newInstance.setOnAuthResult(new Function1() { // from class: com.bytedance.trae.conversation.chat.checkpoint.CheckpointDialogManager$$ExternalSyntheticLambda2
            public final Object invoke(Object obj2) {
                Unit tryBypassWithBottomSheet$lambda$9;
                tryBypassWithBottomSheet$lambda$9 = CheckpointDialogManager.tryBypassWithBottomSheet$lambda$9(str5, str6, toolCallInfo, cb, planItem, taskId, conversationId, (String) obj2);
                return tryBypassWithBottomSheet$lambda$9;
            }
        });
        newInstance.show(fragmentManager, PluginAuthorizationBottomSheet.TAG);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit tryBypassWithBottomSheet$lambda$9(String str, String str2, ParsedToolCallInfo parsedToolCallInfo, CheckpointInteractionCallback checkpointInteractionCallback, ParsedPlanItem parsedPlanItem, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str5, PageDataManager.EXTRA_STATUS);
        CheckpointDialogManager checkpointDialogManager = INSTANCE;
        checkpointDialogManager.reportBypassAuthOutcome(str, str2, str5);
        String buildAuthorizationParams = checkpointDialogManager.buildAuthorizationParams(parsedToolCallInfo.getParams(), str5);
        String id = parsedPlanItem.getId();
        if (id == null) {
            id = "";
        }
        checkpointInteractionCallback.onDecision(new CheckpointDecision.Confirm(id, parsedToolCallInfo.getName(), str3, str4, buildAuthorizationParams));
        Function0<Unit> function0 = onDismissAction;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    private final String getProviderDisplayName(String provider) {
        String obj = StringsKt.trim(provider).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        return hashCode != 113006579 ? hashCode != 133862058 ? (hashCode == 136221635 && lowerCase.equals("tencent-docs")) ? "Tencent Docs" : provider : !lowerCase.equals("dingtalk") ? provider : "DingTalk" : lowerCase.equals("wecom") ? "WeCom" : provider;
    }

    private final String getLocalizedProviderName(Context context, String provider, String pluginName) {
        int i;
        String cachedLocalizedDisplayName = PluginListCache.INSTANCE.getCachedLocalizedDisplayName(pluginName);
        String str = cachedLocalizedDisplayName;
        if (!(str == null || StringsKt.isBlank(str))) {
            return cachedLocalizedDisplayName;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = provider.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int hashCode = lowerCase.hashCode();
        if (hashCode == 113006579) {
            if (lowerCase.equals("wecom")) {
                i = C0637R.string.trae_plugin_provider_name_wecom;
                String string = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            return getProviderDisplayName(provider);
        }
        if (hashCode == 133862058) {
            if (lowerCase.equals("dingtalk")) {
                i = C0637R.string.trae_plugin_provider_name_dingtalk;
                String string2 = context.getString(i);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            return getProviderDisplayName(provider);
        }
        if (hashCode == 136221635 && lowerCase.equals("tencent-docs")) {
            i = C0637R.string.trae_plugin_provider_name_tencent_docs;
            String string22 = context.getString(i);
            Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
            return string22;
        }
        return getProviderDisplayName(provider);
    }

    private final String buildAuthorizationParams(JsonObject originalParams, String status) {
        JsonObject jsonObject;
        if (originalParams == null || (jsonObject = originalParams.deepCopy()) == null) {
            jsonObject = new JsonObject();
        }
        JsonElement jsonObject2 = new JsonObject();
        jsonObject2.addProperty(PageDataManager.EXTRA_STATUS, status);
        jsonObject2.addProperty("auth_scope_mode", "all");
        jsonObject2.add("scope_results", new JsonArray());
        jsonObject.add("authorization_result", jsonObject2);
        String json = new Gson().toJson((JsonElement) jsonObject);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    private final void reportBypassAuthOutcome(String provider, String pluginName, String status) {
        long authDurationMs = PluginConnectorOAuthManager.INSTANCE.authDurationMs();
        PluginTracker.trackAuthResult$default(PluginTracker.INSTANCE, pluginName, provider, Intrinsics.areEqual(status, "success") ? "success" : "cancel", null, 8, null);
        if (Intrinsics.areEqual(status, "success")) {
            PluginTracker.INSTANCE.trackAuthSuccess(provider, authDurationMs, "desktop_redirect");
        } else {
            PluginTracker.INSTANCE.trackAuthFail(provider, status);
        }
    }
}
