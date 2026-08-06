package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet;
import com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: RunCommandDetailCardCreator.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J:\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "resolveStatus", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;", "confirmInfo", "Lcom/bytedance/trae/im/model/ConfirmInfo;", "buildOutputText", "", "resolveDetailCommand", "command", "buildDetailClick", "Lkotlin/Function1;", "Landroid/view/View;", "outputText", "findBottomSheet", "Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunCommandDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: RunCommandDetailCardCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolExecutionStatus.values().length];
            try {
                iArr[ToolExecutionStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolExecutionStatus.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: RunCommandDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunCommandDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        JsonElement jsonElement;
        String str;
        boolean z;
        String str2;
        boolean z2;
        int i;
        int i2;
        String string;
        int i3;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z3 = toolCallInfo.getResult() != null;
        ConfirmInfo confirmInfo2 = planItemContext != null ? planItemContext.getConfirmInfo() : null;
        boolean z4 = confirmInfo2 != null && confirmInfo2.isEnterpriseCommandBlacklist();
        ToolExecutionStatus resolveStatus = resolveStatus(toolCallInfo, confirmInfo2);
        JsonObject params = toolCallInfo.getParams();
        if (params == null || (jsonElement = params.get("command")) == null) {
            JsonObject params2 = toolCallInfo.getParams();
            jsonElement = params2 != null ? params2.get("cmd") : null;
        }
        if (jsonElement != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
                if (resolveStatus == ToolExecutionStatus.PENDING) {
                    if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                        z = true;
                        if (z4) {
                            String string2 = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            int i4 = C0637R.drawable.ic_tool_terminal;
                            I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                            Resources resources = context.getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                            r6 = i18nTextProvider.getString(resources, R.string.trae_enterprise_command_blocked, new Object[0]);
                            str2 = string2;
                            i2 = i4;
                        } else {
                            if (!z3 || z) {
                                String string3 = context.getString(C0637R.string.trae_chat_tool_cmd_running);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                int i5 = C0637R.drawable.ic_tool_terminal;
                                r6 = z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null;
                                str2 = string3;
                                z2 = true;
                                i = 0;
                                i2 = i5;
                            } else {
                                int i6 = WhenMappings.$EnumSwitchMapping$0[resolveStatus.ordinal()];
                                if (i6 != 1) {
                                    if (i6 == 2) {
                                        string = context.getString(C0637R.string.trae_chat_tool_cmd_ran);
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        i3 = C0637R.drawable.ic_tool_terminal;
                                    } else {
                                        string = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        i3 = C0637R.drawable.ic_tool_terminal;
                                    }
                                    str2 = string;
                                    i2 = i3;
                                } else {
                                    String string4 = context.getString(C0637R.string.trae_chat_tool_cmd_failed);
                                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                    str2 = string4;
                                    i2 = C0637R.drawable.warning;
                                    i = C0591R.color.trae_status_warning_default;
                                    z2 = false;
                                }
                            }
                            Function1<View, Unit> buildDetailClick = buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2);
                            FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                            return new ToolDetailCard("", i2, i, str2, str, r6, null, resolveStatus, z2, buildDetailClick, 64, null);
                        }
                        i = 0;
                        z2 = false;
                        Function1<View, Unit> buildDetailClick2 = buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2);
                        FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                        return new ToolDetailCard("", i2, i, str2, str, r6, null, resolveStatus, z2, buildDetailClick2, 64, null);
                    }
                }
                z = false;
                if (z4) {
                }
                i = 0;
                z2 = false;
                Function1<View, Unit> buildDetailClick22 = buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2);
                FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                return new ToolDetailCard("", i2, i, str2, str, r6, null, resolveStatus, z2, buildDetailClick22, 64, null);
            }
        }
        str = null;
        if (resolveStatus == ToolExecutionStatus.PENDING) {
        }
        z = false;
        if (z4) {
        }
        i = 0;
        z2 = false;
        Function1<View, Unit> buildDetailClick222 = buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2);
        FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
        return new ToolDetailCard("", i2, i, str2, str, r6, null, resolveStatus, z2, buildDetailClick222, 64, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e6  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        JsonElement jsonElement;
        String str;
        boolean z;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ConfirmInfo confirmInfo2 = planItemContext != null ? planItemContext.getConfirmInfo() : null;
        boolean z3 = confirmInfo2 != null && confirmInfo2.isEnterpriseCommandBlacklist();
        ToolExecutionStatus resolveStatus = resolveStatus(toolCallInfo, confirmInfo2);
        JsonObject params = toolCallInfo.getParams();
        if (params == null || (jsonElement = params.get("command")) == null) {
            JsonObject params2 = toolCallInfo.getParams();
            jsonElement = params2 != null ? params2.get("cmd") : null;
        }
        if (jsonElement != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
                if (resolveStatus == ToolExecutionStatus.PENDING) {
                    if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                        z = true;
                        FLogger.INSTANCE.d("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                        if (z3) {
                            String string = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            card.setTitle(string);
                            card.setSubtitle(str);
                            card.setIconResId(C0637R.drawable.ic_tool_terminal);
                            card.setIconTintColorRes(0);
                            card.setShimmerTitle(false);
                            I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                            Resources resources = context.getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                            card.setBadgeText(i18nTextProvider.getString(resources, R.string.trae_enterprise_command_blocked, new Object[0]));
                        } else if (!z2 || z) {
                            String string2 = context.getString(C0637R.string.trae_chat_tool_cmd_running);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            card.setTitle(string2);
                            card.setSubtitle(str);
                            card.setIconResId(C0637R.drawable.ic_tool_terminal);
                            card.setIconTintColorRes(0);
                            card.setShimmerTitle(true);
                            card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                        } else {
                            int i = WhenMappings.$EnumSwitchMapping$0[resolveStatus.ordinal()];
                            if (i == 1) {
                                String string3 = context.getString(C0637R.string.trae_chat_tool_cmd_failed);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                card.setTitle(string3);
                                card.setSubtitle(str);
                                card.setIconResId(C0637R.drawable.warning);
                                card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                                card.setShimmerTitle(false);
                                card.setBadgeText(null);
                            } else if (i == 2) {
                                String string4 = context.getString(C0637R.string.trae_chat_tool_cmd_ran);
                                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                card.setTitle(string4);
                                card.setSubtitle(str);
                                card.setIconResId(C0637R.drawable.ic_tool_terminal);
                                card.setIconTintColorRes(0);
                                card.setShimmerTitle(false);
                                card.setBadgeText(null);
                            } else {
                                String string5 = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                                card.setTitle(string5);
                                card.setSubtitle(str);
                                card.setIconResId(C0637R.drawable.ic_tool_terminal);
                                card.setIconTintColorRes(0);
                                card.setShimmerTitle(false);
                                card.setBadgeText(null);
                            }
                        }
                        card.setStatus(resolveStatus);
                        card.setOnDetailClick(buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2));
                        FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                    }
                }
                z = false;
                FLogger.INSTANCE.d("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
                if (z3) {
                }
                card.setStatus(resolveStatus);
                card.setOnDetailClick(buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2));
                FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
            }
        }
        str = null;
        if (resolveStatus == ToolExecutionStatus.PENDING) {
        }
        z = false;
        FLogger.INSTANCE.d("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
        if (z3) {
        }
        card.setStatus(resolveStatus);
        card.setOnDetailClick(buildDetailClick(toolCallInfo, str, buildOutputText(toolCallInfo), confirmInfo2));
        FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + resolveStatus + ", command=" + str);
    }

    private final ToolExecutionStatus resolveStatus(ParsedToolCallInfo toolCallInfo, ConfirmInfo confirmInfo) {
        boolean z = false;
        if (confirmInfo != null && confirmInfo.isEnterpriseCommandBlacklist()) {
            z = true;
        }
        if (z) {
            return ToolExecutionStatus.SKIPPED;
        }
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        return companion.fromString(result != null ? result.getStatus() : null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String buildOutputText(ParsedToolCallInfo toolCallInfo) {
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String asString;
        JsonElement jsonElement3;
        ParsedToolCallResult result = toolCallInfo.getResult();
        JsonObject data = result != null ? result.getData() : null;
        if (data != null && (jsonElement3 = data.get("output")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
            }
        }
        if (data != null && (jsonElement2 = data.get("stdout")) != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                String str2 = asString;
                if (str2.length() == 0) {
                    str2 = null;
                }
                str = str2;
                if (str == null) {
                    if (data == null || (jsonElement = data.get("stderr")) == null) {
                        return null;
                    }
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        return jsonElement.getAsString();
                    }
                    return null;
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        return str;
    }

    private final String resolveDetailCommand(String command, ConfirmInfo confirmInfo) {
        ArrayList arrayList;
        String joinToString$default;
        List<String> blockCommandList;
        if (confirmInfo == null || (blockCommandList = confirmInfo.getBlockCommandList()) == null) {
            arrayList = null;
        } else {
            List<String> list = blockCommandList;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(StringsKt.trim((String) it.next()).toString());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (((String) obj).length() > 0) {
                    arrayList3.add(obj);
                }
            }
            arrayList = arrayList3;
        }
        if (arrayList == null) {
            arrayList = CollectionsKt.emptyList();
        }
        List list2 = true ^ arrayList.isEmpty() ? arrayList : null;
        return (list2 == null || (joinToString$default = CollectionsKt.joinToString$default(list2, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)) == null) ? command : joinToString$default;
    }

    private final Function1<View, Unit> buildDetailClick(final ParsedToolCallInfo toolCallInfo, final String command, final String outputText, final ConfirmInfo confirmInfo) {
        return new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunCommandDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit buildDetailClick$lambda$10;
                buildDetailClick$lambda$10 = RunCommandDetailCardCreator.buildDetailClick$lambda$10(command, this, confirmInfo, outputText, toolCallInfo, (View) obj);
                return buildDetailClick$lambda$10;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0057, code lost:
    
        if (r18.isEnterpriseCommandBlacklist() == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit buildDetailClick$lambda$10(String str, RunCommandDetailCardCreator runCommandDetailCardCreator, ConfirmInfo confirmInfo, String str2, ParsedToolCallInfo parsedToolCallInfo, View view) {
        boolean z;
        ToolResultDetailFragment newInstance;
        Intrinsics.checkNotNullParameter(view, "v");
        FLogger.INSTANCE.i("AgentTool", "[RunCommandCard] onDetailClick: command=" + str);
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", parsedToolCallInfo.getName());
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("tool_call_click", jSONObject);
        Context context = view.getContext();
        ProcessDetailBottomSheet findBottomSheet = runCommandDetailCardCreator.findBottomSheet(context instanceof FragmentActivity ? (FragmentActivity) context : null);
        if (findBottomSheet != null) {
            if (confirmInfo != null) {
                z = true;
            }
            z = false;
            if (z) {
                ToolResultDetailFragment.Companion companion2 = ToolResultDetailFragment.INSTANCE;
                String resolveDetailCommand = runCommandDetailCardCreator.resolveDetailCommand(str, confirmInfo);
                String string = view.getContext().getString(C0637R.string.trae_chat_tool_cmd_command);
                String string2 = view.getContext().getString(C0637R.string.trae_chat_tool_cmd_output);
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                Resources resources = view.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                String string3 = i18nTextProvider.getString(resources, R.string.trae_enterprise_command_high_risk_detected, new Object[0]);
                I18nTextProvider i18nTextProvider2 = I18nTextProvider.INSTANCE;
                Resources resources2 = view.getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                newInstance = companion2.newInstance(resolveDetailCommand, str2, string, string2, null, string3, i18nTextProvider2.getString(resources2, R.string.trae_enterprise_command_blacklist_warning, new Object[0]));
            } else {
                newInstance = ToolResultDetailFragment.INSTANCE.newInstance(str, str2);
            }
            findBottomSheet.navigateTo(newInstance);
        }
        return Unit.INSTANCE;
    }

    private final ProcessDetailBottomSheet findBottomSheet(FragmentActivity activity) {
        if (activity == null) {
            return null;
        }
        ProcessDetailBottomSheet findFragmentByTag = activity.getSupportFragmentManager().findFragmentByTag(ProcessDetailBottomSheet.TAG);
        if (findFragmentByTag instanceof ProcessDetailBottomSheet) {
            return findFragmentByTag;
        }
        return null;
    }
}
