package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.conversation.products.PreviewWebViewActivity;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: OpenPreviewDetailCardCreator.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\"\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "openUrl", IWeixinService.ResponseConstants.URL, "", "extractPreviewUrl", "readString", "obj", "Lcom/google/gson/JsonObject;", "key", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class OpenPreviewDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: OpenPreviewDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/OpenPreviewDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, final ParsedToolCallInfo toolCallInfo, final PlanItemContext planItemContext) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        Function1 function1 = null;
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        final String extractPreviewUrl = extractPreviewUrl(toolCallInfo);
        boolean z = true;
        boolean z2 = fromString == ToolExecutionStatus.FAILED;
        boolean z3 = fromString == ToolExecutionStatus.SUCCESS;
        boolean z4 = (z3 || z2) ? false : true;
        if (z2) {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_failed);
        } else if (z3) {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_opened);
        } else {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_opening);
        }
        String str = string;
        Intrinsics.checkNotNull(str);
        boolean z5 = z3 || (fromString == ToolExecutionStatus.RUNNING);
        FLogger.INSTANCE.i("AgentTool", "[OpenPreviewCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", url=" + extractPreviewUrl);
        int i = z2 ? C0637R.drawable.ic_open_preview_web_fail : C0637R.drawable.ic_open_preview_web;
        if (z5) {
            String str2 = extractPreviewUrl;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z) {
                function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.OpenPreviewDetailCardCreator$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        Unit onCreateDetail$lambda$1;
                        onCreateDetail$lambda$1 = OpenPreviewDetailCardCreator.onCreateDetail$lambda$1(extractPreviewUrl, this, planItemContext, toolCallInfo, (View) obj);
                        return onCreateDetail$lambda$1;
                    }
                };
            }
        }
        return new ToolDetailCard("🌐", i, 0, str, extractPreviewUrl, null, null, fromString, z4, function1, 100, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateDetail$lambda$1(String str, OpenPreviewDetailCardCreator openPreviewDetailCardCreator, PlanItemContext planItemContext, ParsedToolCallInfo parsedToolCallInfo, View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        FLogger.INSTANCE.i("AgentTool", "[OpenPreviewCard] onDetailClick: url=" + str);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        openPreviewDetailCardCreator.openUrl(context, str, planItemContext);
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", parsedToolCallInfo.getName());
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("tool_call_click", jSONObject);
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        String extractPreviewUrl = extractPreviewUrl(toolCallInfo);
        boolean z = fromString == ToolExecutionStatus.FAILED;
        boolean z2 = fromString == ToolExecutionStatus.SUCCESS;
        if (z) {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_failed);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else if (z2) {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_opened);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        } else {
            string = context.getString(C0637R.string.trae_chat_artifact_preview_opening);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        card.setTitle(string);
        card.setSubtitle(extractPreviewUrl);
        card.setIconResId(z ? C0637R.drawable.ic_open_preview_web_fail : C0637R.drawable.ic_open_preview_web);
        card.setShimmerTitle((z2 || z) ? false : true);
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[OpenPreviewCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", url=" + extractPreviewUrl);
    }

    private final void openUrl(Context context, String url, PlanItemContext planItemContext) {
        try {
            try {
                PreviewWebViewActivity.INSTANCE.start(context, url, context.getString(C0637R.string.trae_chat_artifact_preview_web), planItemContext != null ? planItemContext.getChatSessionId() : null, planItemContext != null ? planItemContext.getEnvironment() : null);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    private final String extractPreviewUrl(ParsedToolCallInfo toolCallInfo) {
        ParsedToolCallResult result = toolCallInfo.getResult();
        JsonObject data = result != null ? result.getData() : null;
        JsonObject params = toolCallInfo.getParams();
        String readString = readString(data, "preview_url");
        if (readString != null) {
            return readString;
        }
        String readString2 = readString(data, IWeixinService.ResponseConstants.URL);
        return (readString2 == null && (readString2 = readString(params, "preview_url")) == null) ? readString(params, IWeixinService.ResponseConstants.URL) : readString2;
    }

    private final String readString(JsonObject obj, String key) {
        JsonElement jsonElement;
        String asString;
        String obj2;
        if (obj == null || (jsonElement = obj.get(key)) == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || (obj2 = StringsKt.trim(asString).toString()) == null) {
            return null;
        }
        if (obj2.length() > 0) {
            return obj2;
        }
        return null;
    }
}
