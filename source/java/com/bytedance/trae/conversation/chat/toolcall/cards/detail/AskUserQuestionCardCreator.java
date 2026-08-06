package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AskUserQuestionCardCreator.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "getQuestionCount", "", "buildQuestionsView", "Lkotlin/Function1;", "Landroid/view/View;", "buildOptionRow", "density", "", "label", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AskUserQuestionCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: AskUserQuestionCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/AskUserQuestionCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003b  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        ToolExecutionStatus fromString;
        boolean z2;
        String str;
        String str2;
        Function1<Context, View> function1;
        boolean z3;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        if (toolCallInfo.getResult() == null) {
            JsonObject params = toolCallInfo.getParams();
            if ((params != null ? params.get("answers") : null) == null) {
                z = false;
                ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
                ParsedToolCallResult result = toolCallInfo.getResult();
                fromString = companion.fromString(result == null ? result.getStatus() : null);
                int questionCount = getQuestionCount(toolCallInfo);
                if (fromString == ToolExecutionStatus.PENDING) {
                    if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                        z2 = true;
                        String str3 = "";
                        if (z2) {
                            String string = context.getString(C0637R.string.trae_chat_tool_asking_user);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            str = context.getString(C0637R.string.trae_chat_tool_mcp_waiting);
                            str2 = string;
                            function1 = null;
                            z3 = true;
                        } else {
                            if (fromString == ToolExecutionStatus.SUCCESS && z) {
                                String string2 = context.getString(C0637R.string.trae_chat_tool_asked_user);
                                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                if (questionCount > 0) {
                                    String quantityString = context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_ask_question_count, questionCount, Integer.valueOf(questionCount));
                                    Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
                                    str3 = quantityString;
                                }
                                function1 = buildQuestionsView(toolCallInfo);
                                str2 = string2;
                                str = null;
                            } else {
                                String string3 = context.getString(C0637R.string.trae_chat_tool_asked_user);
                                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                String string4 = context.getString(C0637R.string.trae_chat_tool_canceled);
                                fromString = ToolExecutionStatus.CANCELED;
                                str = string4;
                                str2 = string3;
                                function1 = null;
                            }
                            z3 = false;
                        }
                        String str4 = str3;
                        FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
                        return new ToolDetailCard("", C0637R.drawable.question, 0, str2, str4, str, function1, fromString, z3, null, 516, null);
                    }
                }
                z2 = false;
                String str32 = "";
                if (z2) {
                }
                String str42 = str32;
                FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
                return new ToolDetailCard("", C0637R.drawable.question, 0, str2, str42, str, function1, fromString, z3, null, 516, null);
            }
        }
        z = true;
        ToolExecutionStatus.Companion companion2 = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        fromString = companion2.fromString(result2 == null ? result2.getStatus() : null);
        int questionCount2 = getQuestionCount(toolCallInfo);
        if (fromString == ToolExecutionStatus.PENDING) {
        }
        z2 = false;
        String str322 = "";
        if (z2) {
        }
        String str422 = str322;
        FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
        return new ToolDetailCard("", C0637R.drawable.question, 0, str2, str422, str, function1, fromString, z3, null, 516, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x003a  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        ToolExecutionStatus fromString;
        boolean z2;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        if (toolCallInfo.getResult() == null) {
            JsonObject params = toolCallInfo.getParams();
            if ((params != null ? params.get("answers") : null) == null) {
                z = false;
                ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
                ParsedToolCallResult result = toolCallInfo.getResult();
                fromString = companion.fromString(result == null ? result.getStatus() : null);
                FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
                int questionCount = getQuestionCount(toolCallInfo);
                if (fromString == ToolExecutionStatus.PENDING) {
                    if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                        z2 = true;
                        if (z2) {
                            String string = context.getString(C0637R.string.trae_chat_tool_asking_user);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            card.setTitle(string);
                            card.setSubtitle("");
                            card.setBadgeText(context.getString(C0637R.string.trae_chat_tool_mcp_waiting));
                            card.setShimmerTitle(true);
                            card.setContentView(null);
                            card.setStatus(fromString);
                        } else if (fromString == ToolExecutionStatus.SUCCESS && z) {
                            String string2 = context.getString(C0637R.string.trae_chat_tool_asked_user);
                            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                            card.setTitle(string2);
                            card.setSubtitle(questionCount > 0 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_ask_question_count, questionCount, Integer.valueOf(questionCount)) : "");
                            card.setBadgeText(null);
                            card.setShimmerTitle(false);
                            card.setStatus(fromString);
                            card.setContentView(buildQuestionsView(toolCallInfo));
                        } else {
                            String string3 = context.getString(C0637R.string.trae_chat_tool_canceled);
                            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                            card.setTitle(string3);
                            card.setSubtitle("");
                            card.setBadgeText(context.getString(C0637R.string.trae_chat_tool_mcp_waiting));
                            card.setShimmerTitle(false);
                            card.setStatus(ToolExecutionStatus.CANCELED);
                            card.setContentView(null);
                        }
                        FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
                    }
                }
                z2 = false;
                if (z2) {
                }
                FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
            }
        }
        z = true;
        ToolExecutionStatus.Companion companion2 = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        fromString = companion2.fromString(result2 == null ? result2.getStatus() : null);
        FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
        int questionCount2 = getQuestionCount(toolCallInfo);
        if (fromString == ToolExecutionStatus.PENDING) {
        }
        z2 = false;
        if (z2) {
        }
        FLogger.INSTANCE.i("AgentTool", "[AskUserQuestionCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
    }

    private final int getQuestionCount(ParsedToolCallInfo toolCallInfo) {
        JsonObject params = toolCallInfo.getParams();
        JsonElement jsonElement = params != null ? params.get("questions") : null;
        if (jsonElement == null || !jsonElement.isJsonArray()) {
            return 0;
        }
        return jsonElement.getAsJsonArray().size();
    }

    private final Function1<Context, View> buildQuestionsView(ParsedToolCallInfo toolCallInfo) {
        JsonElement jsonElement;
        JsonObject params = toolCallInfo.getParams();
        final String str = null;
        final JsonElement jsonElement2 = params != null ? params.get("questions") : null;
        if (jsonElement2 == null || !jsonElement2.isJsonArray() || jsonElement2.getAsJsonArray().size() == 0) {
            return null;
        }
        JsonObject params2 = toolCallInfo.getParams();
        JsonElement jsonElement3 = params2 != null ? params2.get("answers") : null;
        final JsonArray asJsonArray = (jsonElement3 == null || !jsonElement3.isJsonArray()) ? null : jsonElement3.getAsJsonArray();
        JsonObject params3 = toolCallInfo.getParams();
        if (params3 != null && (jsonElement = params3.get("custom_input")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        return new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.AskUserQuestionCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                LinearLayout buildQuestionsView$lambda$21;
                buildQuestionsView$lambda$21 = AskUserQuestionCardCreator.buildQuestionsView$lambda$21(jsonElement2, str, asJsonArray, this, (Context) obj);
                return buildQuestionsView$lambda$21;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LinearLayout buildQuestionsView$lambda$21(JsonElement jsonElement, String str, JsonArray jsonArray, AskUserQuestionCardCreator askUserQuestionCardCreator, Context context) {
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        String asString;
        JsonObject jsonObject;
        JsonArray jsonArray2;
        String str2;
        ArrayList arrayList;
        JsonObject jsonObject2;
        JsonElement jsonElement3;
        String asString2;
        String asString3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        JsonElement jsonElement6;
        Intrinsics.checkNotNullParameter(context, "ctx");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        int i = 1;
        linearLayout.setOrientation(1);
        Iterable asJsonArray = jsonElement.getAsJsonArray();
        Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
        int i2 = 0;
        for (Object obj : asJsonArray) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            JsonElement jsonElement7 = (JsonElement) obj;
            if (jsonElement7 != null) {
                if (!jsonElement7.isJsonObject()) {
                    jsonElement7 = null;
                }
                if (jsonElement7 != null && (asJsonObject = jsonElement7.getAsJsonObject()) != null && (jsonElement2 = asJsonObject.get("question")) != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                        LinearLayout linearLayout2 = new LinearLayout(context);
                        linearLayout2.setOrientation(i);
                        if (i2 > 0) {
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                            layoutParams.topMargin = (int) (12 * f);
                            linearLayout2.setLayoutParams(layoutParams);
                        }
                        TextView textView = new TextView(context);
                        textView.setText(asString);
                        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                        textView.setTextSize(2, 13.0f);
                        textView.setTypeface(textView.getTypeface(), 1);
                        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-1, -2));
                        if (jsonArray != null && i2 < jsonArray.size() && (jsonElement6 = jsonArray.get(i2)) != null) {
                            if (!jsonElement6.isJsonObject()) {
                                jsonElement6 = null;
                            }
                            if (jsonElement6 != null) {
                                jsonObject = jsonElement6.getAsJsonObject();
                                if (jsonObject != null && (jsonElement5 = jsonObject.get("selected_options")) != null) {
                                    if (!jsonElement5.isJsonArray()) {
                                        jsonElement5 = null;
                                    }
                                    if (jsonElement5 != null) {
                                        jsonArray2 = jsonElement5.getAsJsonArray();
                                        if (jsonObject != null && (jsonElement4 = jsonObject.get("custom_input")) != null) {
                                            if (!jsonElement4.isJsonPrimitive()) {
                                                jsonElement4 = null;
                                            }
                                            if (jsonElement4 != null) {
                                                str2 = jsonElement4.getAsString();
                                                arrayList = new ArrayList();
                                                if (jsonArray2 != null) {
                                                    String str3 = str2;
                                                    if (!(str3 == null || StringsKt.isBlank(str3))) {
                                                        arrayList.add(str2);
                                                    }
                                                } else {
                                                    for (JsonElement jsonElement8 : (Iterable) jsonArray2) {
                                                        if (jsonElement8 != null) {
                                                            if (!jsonElement8.isJsonPrimitive()) {
                                                                jsonElement8 = null;
                                                            }
                                                            if (jsonElement8 != null && (asString3 = jsonElement8.getAsString()) != null) {
                                                                if (Intrinsics.areEqual(asString3, "__other__")) {
                                                                    String str4 = str2;
                                                                    if (!(str4 == null || StringsKt.isBlank(str4))) {
                                                                        String string = context.getString(C0637R.string.trae_chat_tool_ask_answer_other, str2);
                                                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                                                        arrayList.add(string);
                                                                    }
                                                                } else {
                                                                    arrayList.add(asString3);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                if (!(!arrayList.isEmpty())) {
                                                    LinearLayout linearLayout3 = new LinearLayout(context);
                                                    linearLayout3.setOrientation(1);
                                                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                                                    layoutParams2.topMargin = (int) (2 * f);
                                                    linearLayout3.setLayoutParams(layoutParams2);
                                                    Iterator it = arrayList.iterator();
                                                    while (it.hasNext()) {
                                                        linearLayout3.addView(askUserQuestionCardCreator.buildOptionRow(context, f, (String) it.next()));
                                                    }
                                                    linearLayout2.addView(linearLayout3);
                                                } else {
                                                    JsonElement jsonElement9 = asJsonObject.get("options");
                                                    if (jsonElement9 != null && jsonElement9.isJsonArray()) {
                                                        Iterable<JsonElement> asJsonArray2 = jsonElement9.getAsJsonArray();
                                                        Intrinsics.checkNotNullExpressionValue(asJsonArray2, "getAsJsonArray(...)");
                                                        for (JsonElement jsonElement10 : asJsonArray2) {
                                                            if (jsonElement10 != null) {
                                                                if (!jsonElement10.isJsonObject()) {
                                                                    jsonElement10 = null;
                                                                }
                                                                if (jsonElement10 != null) {
                                                                    jsonObject2 = jsonElement10.getAsJsonObject();
                                                                    if (jsonObject2 != null && (jsonElement3 = jsonObject2.get("label")) != null) {
                                                                        if (!jsonElement3.isJsonPrimitive()) {
                                                                            jsonElement3 = null;
                                                                        }
                                                                        if (jsonElement3 != null && (asString2 = jsonElement3.getAsString()) != null) {
                                                                            linearLayout2.addView(askUserQuestionCardCreator.buildOptionRow(context, f, asString2));
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            jsonObject2 = null;
                                                            if (jsonObject2 != null) {
                                                                if (!jsonElement3.isJsonPrimitive()) {
                                                                }
                                                                if (jsonElement3 != null) {
                                                                    linearLayout2.addView(askUserQuestionCardCreator.buildOptionRow(context, f, asString2));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                linearLayout.addView(linearLayout2);
                                            }
                                        }
                                        str2 = null;
                                        arrayList = new ArrayList();
                                        if (jsonArray2 != null) {
                                        }
                                        if (!(!arrayList.isEmpty())) {
                                        }
                                        linearLayout.addView(linearLayout2);
                                    }
                                }
                                jsonArray2 = null;
                                if (jsonObject != null) {
                                    if (!jsonElement4.isJsonPrimitive()) {
                                    }
                                    if (jsonElement4 != null) {
                                    }
                                }
                                str2 = null;
                                arrayList = new ArrayList();
                                if (jsonArray2 != null) {
                                }
                                if (!(!arrayList.isEmpty())) {
                                }
                                linearLayout.addView(linearLayout2);
                            }
                        }
                        jsonObject = null;
                        if (jsonObject != null) {
                            if (!jsonElement5.isJsonArray()) {
                            }
                            if (jsonElement5 != null) {
                            }
                        }
                        jsonArray2 = null;
                        if (jsonObject != null) {
                        }
                        str2 = null;
                        arrayList = new ArrayList();
                        if (jsonArray2 != null) {
                        }
                        if (!(!arrayList.isEmpty())) {
                        }
                        linearLayout.addView(linearLayout2);
                    }
                }
            }
            i2 = i3;
            i = 1;
        }
        String str5 = str;
        if (!(str5 == null || StringsKt.isBlank(str5))) {
            TextView textView2 = new TextView(context);
            textView2.setText(context.getString(C0637R.string.trae_chat_tool_ask_custom_input, str));
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            textView2.setTextSize(2, 13.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = (int) (12 * f);
            textView2.setLayoutParams(layoutParams3);
            linearLayout.addView(textView2);
        }
        return linearLayout;
    }

    private final View buildOptionRow(Context context, float density, String label) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (2 * density);
        linearLayout.setLayoutParams(layoutParams);
        int i = (int) (3 * density);
        linearLayout.setPadding(0, i, 0, i);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        int i2 = (int) (16 * density);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(i2, i2));
        View view = new View(context);
        int i3 = (int) (4 * density);
        view.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_icon_icon_tertiary));
        view.setBackground(gradientDrawable);
        linearLayout2.addView(view);
        linearLayout.addView(linearLayout2);
        TextView textView = new TextView(context);
        textView.setText(label);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(i3);
        textView.setLayoutParams(layoutParams2);
        linearLayout.addView(textView);
        return linearLayout;
    }
}
