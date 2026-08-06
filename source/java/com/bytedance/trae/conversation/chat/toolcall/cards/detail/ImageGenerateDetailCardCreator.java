package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageGenerateDetailCardCreator.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ImageGenerateDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageGenerateDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: ImageGenerateDetailCardCreator.kt */
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

    /* compiled from: ImageGenerateDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ImageGenerateDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0068  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        String string;
        int i;
        String str;
        int i2;
        int i3;
        boolean z2;
        JsonObject data;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        if (result2 != null && (data = result2.getData()) != null && (jsonElement = data.get("policy_violated")) != null) {
            JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
            if (jsonElement2 != null && jsonElement2.getAsBoolean()) {
                z = true;
                if (z3) {
                    String string2 = context.getString(C0637R.string.trae_chat_tool_image_generating);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    str = string2;
                    i2 = C0637R.drawable.attach_image;
                    z2 = true;
                    i3 = 0;
                } else {
                    if (z) {
                        string = context.getString(C0637R.string.trae_chat_tool_image_policy_violated);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        i = C0637R.drawable.warning_circle;
                    } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                        String string3 = context.getString(C0637R.string.trae_chat_tool_image_failed);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        str = string3;
                        i2 = C0637R.drawable.warning;
                        i3 = C0591R.color.trae_status_warning_default;
                        z2 = false;
                    } else {
                        string = context.getString(C0637R.string.trae_chat_tool_image_generated);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        i = C0637R.drawable.attach_image;
                    }
                    str = string;
                    i2 = i;
                    i3 = 0;
                    z2 = false;
                }
                FLogger.INSTANCE.i("AgentTool", "[ImageGenerateCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
                return new ToolDetailCard("", i2, i3, str, null, null, null, fromString, z2, null, 624, null);
            }
        }
        z = false;
        if (z3) {
        }
        FLogger.INSTANCE.i("AgentTool", "[ImageGenerateCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
        return new ToolDetailCard("", i2, i3, str, null, null, null, fromString, z2, null, 624, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        JsonObject data;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        ParsedToolCallResult result2 = toolCallInfo.getResult();
        if (result2 != null && (data = result2.getData()) != null && (jsonElement = data.get("policy_violated")) != null) {
            JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
            if (jsonElement2 != null && jsonElement2.getAsBoolean()) {
                z = true;
                if (z2) {
                    String string = context.getString(C0637R.string.trae_chat_tool_image_generating);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    card.setTitle(string);
                    card.setIconResId(C0637R.drawable.attach_image);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(true);
                } else if (z) {
                    String string2 = context.getString(C0637R.string.trae_chat_tool_image_policy_violated);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    card.setTitle(string2);
                    card.setIconResId(C0637R.drawable.warning_circle);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(false);
                } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                    String string3 = context.getString(C0637R.string.trae_chat_tool_image_failed);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    card.setTitle(string3);
                    card.setIconResId(C0637R.drawable.warning);
                    card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                    card.setShimmerTitle(false);
                } else {
                    String string4 = context.getString(C0637R.string.trae_chat_tool_image_generated);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    card.setTitle(string4);
                    card.setIconResId(C0637R.drawable.attach_image);
                    card.setIconTintColorRes(0);
                    card.setShimmerTitle(false);
                }
                card.setStatus(fromString);
                FLogger.INSTANCE.i("AgentTool", "[ImageGenerateCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
            }
        }
        z = false;
        if (z2) {
        }
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[ImageGenerateCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
    }
}
