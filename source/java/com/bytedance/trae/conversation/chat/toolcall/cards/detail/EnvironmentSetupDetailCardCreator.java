package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
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
import org.json.JSONObject;

/* compiled from: EnvironmentSetupDetailCardCreator.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "findBottomSheet", "Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class EnvironmentSetupDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: EnvironmentSetupDetailCardCreator.kt */
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

    /* compiled from: EnvironmentSetupDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/EnvironmentSetupDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, final ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        int i;
        int i2;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (!z2) {
            String string = context.getString(C0637R.string.trae_chat_tool_env_setting_up);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = string;
            i = C0637R.drawable.environment_repair;
            z = true;
            i2 = 0;
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_env_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str = string2;
            i = C0637R.drawable.warning;
            i2 = C0591R.color.trae_status_warning_default;
            z = false;
        } else {
            String string3 = context.getString(C0637R.string.trae_chat_tool_env_set_up);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            str = string3;
            i = C0637R.drawable.environment_repair;
            i2 = 0;
            z = false;
        }
        Function1 function1 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.EnvironmentSetupDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onCreateDetail$lambda$5;
                onCreateDetail$lambda$5 = EnvironmentSetupDetailCardCreator.onCreateDetail$lambda$5(EnvironmentSetupDetailCardCreator.this, toolCallInfo, (View) obj);
                return onCreateDetail$lambda$5;
            }
        };
        FLogger.INSTANCE.i("AgentTool", "[EnvironmentSetupCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString);
        return new ToolDetailCard("", i, i2, str, null, null, null, fromString, z, function1, 64, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if (r0 != null) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit onCreateDetail$lambda$5(EnvironmentSetupDetailCardCreator environmentSetupDetailCardCreator, ParsedToolCallInfo parsedToolCallInfo, View view) {
        String str;
        String str2;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String asString;
        ToolResultDetailFragment newInstance;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(view, "v");
        FLogger.INSTANCE.i("AgentTool", "[EnvironmentSetupCard] onDetailClick");
        IApplog.Companion companion = IApplog.INSTANCE;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tool_name", parsedToolCallInfo.getName());
        Unit unit = Unit.INSTANCE;
        companion.reportEvent("tool_call_click", jSONObject);
        Context context = view.getContext();
        String str3 = null;
        ProcessDetailBottomSheet findBottomSheet = environmentSetupDetailCardCreator.findBottomSheet(context instanceof FragmentActivity ? (FragmentActivity) context : null);
        if (findBottomSheet != null) {
            ParsedToolCallResult result = parsedToolCallInfo.getResult();
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
                    String str4 = asString;
                    if (str4.length() == 0) {
                        str4 = null;
                    }
                    str = str4;
                    if (str == null) {
                        if (data != null && (jsonElement = data.get("stderr")) != null) {
                            if (!jsonElement.isJsonPrimitive()) {
                                jsonElement = null;
                            }
                            if (jsonElement != null) {
                                str3 = jsonElement.getAsString();
                            }
                        }
                        str2 = str3;
                        newInstance = ToolResultDetailFragment.INSTANCE.newInstance(null, str2, null, view.getContext().getString(C0637R.string.trae_chat_tool_fallback_output), null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
                        findBottomSheet.navigateTo(newInstance);
                    }
                    str2 = str;
                    newInstance = ToolResultDetailFragment.INSTANCE.newInstance(null, str2, null, view.getContext().getString(C0637R.string.trae_chat_tool_fallback_output), null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
                    findBottomSheet.navigateTo(newInstance);
                }
            }
            str = null;
            if (str == null) {
            }
            str2 = str;
            newInstance = ToolResultDetailFragment.INSTANCE.newInstance(null, str2, null, view.getContext().getString(C0637R.string.trae_chat_tool_fallback_output), null, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
            findBottomSheet.navigateTo(newInstance);
        }
        return Unit.INSTANCE;
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (!z) {
            String string = context.getString(C0637R.string.trae_chat_tool_env_setting_up);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            card.setTitle(string);
            card.setIconResId(C0637R.drawable.environment_repair);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_env_failed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            card.setTitle(string2);
            card.setIconResId(C0637R.drawable.warning);
            card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
            card.setShimmerTitle(false);
        } else {
            String string3 = context.getString(C0637R.string.trae_chat_tool_env_set_up);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            card.setTitle(string3);
            card.setIconResId(C0637R.drawable.environment_repair);
            card.setIconTintColorRes(0);
            card.setShimmerTitle(false);
        }
        card.setSubtitle(null);
        card.setBadgeText(null);
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[EnvironmentSetupCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString);
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
