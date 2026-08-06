package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.applog.api.IApplog;
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
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: FallbackDetailCardCreator.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/FallbackDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "extractResultSummary", "", "formatJson", "jsonObject", "Lcom/google/gson/JsonObject;", "findBottomSheet", "Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class FallbackDetailCardCreator extends BaseToolDetailCardCreator {
    private static final int MAX_DISPLAY_LENGTH = 1000;
    private static final String TOOL_TAG = "AgentTool";

    /* compiled from: FallbackDetailCardCreator.kt */
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
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a5  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, final ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        String extractResultSummary;
        boolean z;
        String str2;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        String name = toolCallInfo.getName();
        if (name == null) {
            name = "Tool";
        }
        final String str3 = name;
        boolean z3 = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
        if (!z2) {
            String string = context.getString(C0637R.string.trae_chat_tool_fallback_calling);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str2 = z3 ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null;
            str = string;
            z = true;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_fallback_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str = string2;
            z = false;
            str2 = null;
        } else {
            String string3 = context.getString(C0637R.string.trae_chat_tool_fallback_called);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            str = string3;
            extractResultSummary = extractResultSummary(toolCallInfo);
            z = false;
            str2 = null;
            String formatJson = formatJson(toolCallInfo.getParams());
            final String take = formatJson == null ? StringsKt.take(formatJson, 1000) : null;
            ParsedToolCallResult result2 = toolCallInfo.getResult();
            String formatJson2 = formatJson(result2 == null ? result2.getData() : null);
            final String take2 = formatJson2 == null ? StringsKt.take(formatJson2, 1000) : null;
            Function1 function1 = (take == null || take2 != null) ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.FallbackDetailCardCreator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit onCreateDetail$lambda$1;
                    onCreateDetail$lambda$1 = FallbackDetailCardCreator.onCreateDetail$lambda$1(str3, this, take, take2, toolCallInfo, (View) obj);
                    return onCreateDetail$lambda$1;
                }
            } : null;
            FLogger.INSTANCE.i("AgentTool", "[FallbackCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", toolName=" + str3);
            return new ToolDetailCard("", C0637R.drawable.ic_tool_mcp, 0, str, extractResultSummary, str2, null, fromString, z, function1, 68, null);
        }
        extractResultSummary = str3;
        String formatJson3 = formatJson(toolCallInfo.getParams());
        if (formatJson3 == null) {
        }
        ParsedToolCallResult result22 = toolCallInfo.getResult();
        String formatJson22 = formatJson(result22 == null ? result22.getData() : null);
        if (formatJson22 == null) {
        }
        if (take == null) {
        }
        FLogger.INSTANCE.i("AgentTool", "[FallbackCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", toolName=" + str3);
        return new ToolDetailCard("", C0637R.drawable.ic_tool_mcp, 0, str, extractResultSummary, str2, null, fromString, z, function1, 68, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateDetail$lambda$1(String str, FallbackDetailCardCreator fallbackDetailCardCreator, String str2, String str3, ParsedToolCallInfo parsedToolCallInfo, View view) {
        ToolResultDetailFragment newInstance;
        Intrinsics.checkNotNullParameter(view, "v");
        FLogger.INSTANCE.i("AgentTool", "[FallbackCard] onDetailClick: toolName=" + str);
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", parsedToolCallInfo.getName());
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("tool_call_click", jSONObject);
        Context context = view.getContext();
        ProcessDetailBottomSheet findBottomSheet = fallbackDetailCardCreator.findBottomSheet(context instanceof FragmentActivity ? (FragmentActivity) context : null);
        if (findBottomSheet != null) {
            newInstance = ToolResultDetailFragment.INSTANCE.newInstance(str2, str3, view.getContext().getString(C0637R.string.trae_chat_tool_fallback_input), view.getContext().getString(C0637R.string.trae_chat_tool_fallback_output), str, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
            findBottomSheet.navigateTo(newInstance);
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        String name = toolCallInfo.getName();
        if (name == null) {
            name = "Tool";
        }
        boolean z2 = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
        if (!z) {
            String string = context.getString(C0637R.string.trae_chat_tool_fallback_calling);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            card.setTitle(string);
            card.setSubtitle(name);
            card.setBadgeText(z2 ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_fallback_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            card.setSubtitle(name);
            card.setShimmerTitle(false);
            card.setBadgeText(null);
        } else {
            String string3 = context.getString(C0637R.string.trae_chat_tool_fallback_called);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            card.setTitle(string3);
            card.setSubtitle(extractResultSummary(toolCallInfo));
            card.setShimmerTitle(false);
            card.setBadgeText(null);
        }
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[FallbackCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", toolName=" + name);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0025, code lost:
    
        if (r1 != null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractResultSummary(ParsedToolCallInfo toolCallInfo) {
        JsonObject data;
        String str;
        String asString;
        ParsedToolCallResult result = toolCallInfo.getResult();
        if (result == null || (data = result.getData()) == null) {
            return toolCallInfo.getName();
        }
        JsonElement jsonElement = data.get("output");
        String str2 = null;
        if (jsonElement != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        JsonElement jsonElement2 = data.get("stdout");
        if (jsonElement2 != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                String str3 = asString;
                if (str3.length() == 0) {
                    str3 = null;
                }
                str = str3;
                if (str == null) {
                    JsonElement jsonElement3 = data.get("stderr");
                    if (jsonElement3 != null) {
                        if (!jsonElement3.isJsonPrimitive()) {
                            jsonElement3 = null;
                        }
                        if (jsonElement3 != null) {
                            str = jsonElement3.getAsString();
                        }
                    }
                    str = null;
                }
                if (str == null) {
                    return StringsKt.take(str, 100);
                }
                JsonElement jsonElement4 = data.get("result");
                if (jsonElement4 != null) {
                    if (!jsonElement4.isJsonPrimitive()) {
                        jsonElement4 = null;
                    }
                    if (jsonElement4 != null) {
                        str2 = jsonElement4.getAsString();
                    }
                }
                if (str2 != null) {
                    return StringsKt.take(str2, 100);
                }
                return toolCallInfo.getName();
            }
        }
        str = null;
        if (str == null) {
        }
        if (str == null) {
        }
    }

    private final String formatJson(JsonObject jsonObject) {
        if (jsonObject == null || jsonObject.size() == 0) {
            return null;
        }
        try {
            return new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement) jsonObject);
        } catch (Throwable unused) {
            return jsonObject.toString();
        }
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
