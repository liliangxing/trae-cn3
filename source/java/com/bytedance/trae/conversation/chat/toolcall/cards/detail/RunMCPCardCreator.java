package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
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
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: RunMCPCardCreator.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010\b\u001a\u00020\tH\u0002J$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0002J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\r0\u00162\u0006\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "buildDisplayName", "", "serverName", "toolName", "collectMcpToolNames", "", "buildMcpToolListView", "Lkotlin/Function1;", "Landroid/view/View;", "toolNames", "buildOnDetailClick", "findBottomSheet", "Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;", "activity", "Landroidx/fragment/app/FragmentActivity;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RunMCPCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: RunMCPCardCreator.kt */
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

    /* compiled from: RunMCPCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
    
        if (r9 != null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0085  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        JsonObject params;
        JsonObject params2;
        String str2;
        JsonElement jsonElement;
        boolean z;
        String str3;
        int i;
        boolean z2;
        int i2;
        String str4;
        String str5;
        Function1<View, Unit> function1;
        Function1<Context, View> buildMcpToolListView;
        ConfirmInfo confirmInfo;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        JsonObject params3 = toolCallInfo.getParams();
        if (params3 != null && (jsonElement3 = params3.get("server_name")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
                params = toolCallInfo.getParams();
                if (params != null && (jsonElement2 = params.get("tool_name")) != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                    }
                }
                params2 = toolCallInfo.getParams();
                if (params2 != null && (jsonElement = params2.get("name")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str2 = jsonElement.getAsString();
                        String buildDisplayName = buildDisplayName(str, str2);
                        if (fromString == ToolExecutionStatus.PENDING) {
                            if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                                z = true;
                                List<String> collectMcpToolNames = collectMcpToolNames(toolCallInfo);
                                if (!z3 && !z) {
                                    int i3 = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
                                    if (i3 == 1) {
                                        String string = context.getString(C0637R.string.trae_chat_tool_mcp_failed);
                                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                        str3 = string;
                                        i = C0637R.drawable.warning;
                                        i2 = C0591R.color.trae_status_warning_default;
                                        z2 = false;
                                        str4 = buildDisplayName;
                                        str5 = null;
                                        buildMcpToolListView = null;
                                        function1 = buildOnDetailClick(toolCallInfo);
                                    } else if (i3 == 2) {
                                        int size = collectMcpToolNames.size();
                                        String string2 = context.getString(C0637R.string.trae_chat_tool_mcp_called);
                                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                        String quantityString = size > 1 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_mcp_tool_count, size, Integer.valueOf(size)) : buildDisplayName;
                                        i = C0637R.drawable.ic_mcp_tool;
                                        str4 = quantityString;
                                        buildMcpToolListView = size > 1 ? buildMcpToolListView(collectMcpToolNames) : null;
                                        function1 = buildOnDetailClick(toolCallInfo);
                                        i2 = 0;
                                        z2 = false;
                                        str5 = null;
                                        str3 = string2;
                                    } else {
                                        String string3 = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                        str3 = string3;
                                        i = C0637R.drawable.ic_mcp_tool;
                                        i2 = 0;
                                        z2 = false;
                                        str4 = buildDisplayName;
                                        str5 = null;
                                        buildMcpToolListView = null;
                                        function1 = null;
                                    }
                                } else if (!z) {
                                    String string4 = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
                                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                    str5 = context.getString(C0637R.string.trae_chat_tool_mcp_waiting);
                                    str3 = string4;
                                    z2 = true;
                                    i2 = 0;
                                    str4 = null;
                                    function1 = null;
                                    i = C0637R.drawable.ic_mcp_tool;
                                    buildMcpToolListView = buildMcpToolListView(collectMcpToolNames);
                                } else {
                                    String string5 = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
                                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                                    str3 = string5;
                                    i = C0637R.drawable.ic_mcp_tool;
                                    z2 = true;
                                    i2 = 0;
                                    str4 = null;
                                    str5 = null;
                                    function1 = null;
                                    buildMcpToolListView = buildMcpToolListView(collectMcpToolNames);
                                }
                                FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName);
                                return new ToolDetailCard("", i, i2, str3, str4, str5, buildMcpToolListView, fromString, z2, function1);
                            }
                        }
                        z = false;
                        List<String> collectMcpToolNames2 = collectMcpToolNames(toolCallInfo);
                        if (!z3) {
                        }
                        if (!z) {
                        }
                        FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName);
                        return new ToolDetailCard("", i, i2, str3, str4, str5, buildMcpToolListView, fromString, z2, function1);
                    }
                }
                str2 = null;
                String buildDisplayName2 = buildDisplayName(str, str2);
                if (fromString == ToolExecutionStatus.PENDING) {
                }
                z = false;
                List<String> collectMcpToolNames22 = collectMcpToolNames(toolCallInfo);
                if (!z3) {
                }
                if (!z) {
                }
                FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName2);
                return new ToolDetailCard("", i, i2, str3, str4, str5, buildMcpToolListView, fromString, z2, function1);
            }
        }
        str = null;
        params = toolCallInfo.getParams();
        if (params != null) {
            if (!jsonElement2.isJsonPrimitive()) {
            }
            if (jsonElement2 != null) {
            }
        }
        params2 = toolCallInfo.getParams();
        if (params2 != null) {
            if (!jsonElement.isJsonPrimitive()) {
            }
            if (jsonElement != null) {
            }
        }
        str2 = null;
        String buildDisplayName22 = buildDisplayName(str, str2);
        if (fromString == ToolExecutionStatus.PENDING) {
        }
        z = false;
        List<String> collectMcpToolNames222 = collectMcpToolNames(toolCallInfo);
        if (!z3) {
        }
        if (!z) {
        }
        FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onCreateDetail: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName22);
        return new ToolDetailCard("", i, i2, str3, str4, str5, buildMcpToolListView, fromString, z2, function1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x006a, code lost:
    
        if (r6 != null) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0084  */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String str;
        JsonObject params;
        JsonObject params2;
        String str2;
        JsonElement jsonElement;
        boolean z;
        ConfirmInfo confirmInfo;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        JsonObject params3 = toolCallInfo.getParams();
        if (params3 != null && (jsonElement3 = params3.get("server_name")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
                params = toolCallInfo.getParams();
                if (params != null && (jsonElement2 = params.get("tool_name")) != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null) {
                        str2 = jsonElement2.getAsString();
                    }
                }
                params2 = toolCallInfo.getParams();
                if (params2 != null && (jsonElement = params2.get("name")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str2 = jsonElement.getAsString();
                        String buildDisplayName = buildDisplayName(str, str2);
                        if (fromString == ToolExecutionStatus.PENDING) {
                            if ((planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true) {
                                z = true;
                                List<String> collectMcpToolNames = collectMcpToolNames(toolCallInfo);
                                if (z2 || z) {
                                    String string = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
                                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                    card.setTitle(string);
                                    card.setSubtitle(null);
                                    card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                                    card.setIconResId(C0637R.drawable.ic_mcp_tool);
                                    card.setIconTintColorRes(0);
                                    card.setShimmerTitle(true);
                                } else {
                                    int i = WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()];
                                    if (i == 1) {
                                        String string2 = context.getString(C0637R.string.trae_chat_tool_mcp_failed);
                                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                                        card.setTitle(string2);
                                        card.setSubtitle(buildDisplayName);
                                        card.setBadgeText(null);
                                        card.setIconResId(C0637R.drawable.warning);
                                        card.setIconTintColorRes(C0591R.color.trae_status_warning_default);
                                        card.setShimmerTitle(false);
                                    } else if (i == 2) {
                                        int size = collectMcpToolNames.size();
                                        String string3 = context.getString(C0637R.string.trae_chat_tool_mcp_called);
                                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                                        card.setTitle(string3);
                                        card.setSubtitle(size > 1 ? context.getResources().getQuantityString(C0637R.plurals.trae_chat_tool_mcp_tool_count, size, Integer.valueOf(size)) : buildDisplayName);
                                        card.setBadgeText(null);
                                        card.setIconResId(C0637R.drawable.ic_mcp_tool);
                                        card.setIconTintColorRes(0);
                                        card.setShimmerTitle(false);
                                        card.setContentView(size > 1 ? buildMcpToolListView(collectMcpToolNames) : null);
                                    } else {
                                        String string4 = context.getString(C0637R.string.trae_chat_tool_cmd_canceled);
                                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                                        card.setTitle(string4);
                                        card.setSubtitle(buildDisplayName);
                                        card.setIconResId(C0637R.drawable.ic_mcp_tool);
                                        card.setShimmerTitle(false);
                                        card.setBadgeText(null);
                                    }
                                }
                                card.setStatus(fromString);
                                FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName);
                            }
                        }
                        z = false;
                        List<String> collectMcpToolNames2 = collectMcpToolNames(toolCallInfo);
                        if (z2) {
                        }
                        String string5 = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
                        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                        card.setTitle(string5);
                        card.setSubtitle(null);
                        card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                        card.setIconResId(C0637R.drawable.ic_mcp_tool);
                        card.setIconTintColorRes(0);
                        card.setShimmerTitle(true);
                        card.setStatus(fromString);
                        FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName);
                    }
                }
                str2 = null;
                String buildDisplayName2 = buildDisplayName(str, str2);
                if (fromString == ToolExecutionStatus.PENDING) {
                }
                z = false;
                List<String> collectMcpToolNames22 = collectMcpToolNames(toolCallInfo);
                if (z2) {
                }
                String string52 = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
                Intrinsics.checkNotNullExpressionValue(string52, "getString(...)");
                card.setTitle(string52);
                card.setSubtitle(null);
                card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                card.setIconResId(C0637R.drawable.ic_mcp_tool);
                card.setIconTintColorRes(0);
                card.setShimmerTitle(true);
                card.setStatus(fromString);
                FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName2);
            }
        }
        str = null;
        params = toolCallInfo.getParams();
        if (params != null) {
            if (!jsonElement2.isJsonPrimitive()) {
            }
            if (jsonElement2 != null) {
            }
        }
        params2 = toolCallInfo.getParams();
        if (params2 != null) {
            if (!jsonElement.isJsonPrimitive()) {
            }
            if (jsonElement != null) {
            }
        }
        str2 = null;
        String buildDisplayName22 = buildDisplayName(str, str2);
        if (fromString == ToolExecutionStatus.PENDING) {
        }
        z = false;
        List<String> collectMcpToolNames222 = collectMcpToolNames(toolCallInfo);
        if (z2) {
        }
        String string522 = context.getString(C0637R.string.trae_chat_tool_mcp_calling);
        Intrinsics.checkNotNullExpressionValue(string522, "getString(...)");
        card.setTitle(string522);
        card.setSubtitle(null);
        card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
        card.setIconResId(C0637R.drawable.ic_mcp_tool);
        card.setIconTintColorRes(0);
        card.setShimmerTitle(true);
        card.setStatus(fromString);
        FLogger.INSTANCE.i("AgentTool", "[RunMCPCard] onUpdateCard: name=" + toolCallInfo.getName() + ", status=" + fromString + ", mcpToolName=" + buildDisplayName22);
    }

    private final String buildDisplayName(String serverName, String toolName) {
        if (serverName == null && toolName == null) {
            return null;
        }
        return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{serverName, toolName}), " / ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> collectMcpToolNames(ParsedToolCallInfo toolCallInfo) {
        String str;
        JsonObject params;
        JsonObject params2;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String asString;
        JsonElement jsonElement3;
        JsonObject params3 = toolCallInfo.getParams();
        String str2 = null;
        if (params3 != null && (jsonElement3 = params3.get("server_name")) != null) {
            if (!jsonElement3.isJsonPrimitive()) {
                jsonElement3 = null;
            }
            if (jsonElement3 != null) {
                str = jsonElement3.getAsString();
                params = toolCallInfo.getParams();
                if (params != null && (jsonElement2 = params.get("tool_name")) != null) {
                    if (!jsonElement2.isJsonPrimitive()) {
                        jsonElement2 = null;
                    }
                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                        str2 = asString;
                        String buildDisplayName = buildDisplayName(str, str2);
                        return buildDisplayName == null ? CollectionsKt.listOf(buildDisplayName) : CollectionsKt.emptyList();
                    }
                }
                params2 = toolCallInfo.getParams();
                if (params2 != null && (jsonElement = params2.get("name")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        str2 = jsonElement.getAsString();
                    }
                }
                String buildDisplayName2 = buildDisplayName(str, str2);
                if (buildDisplayName2 == null) {
                }
            }
        }
        str = null;
        params = toolCallInfo.getParams();
        if (params != null) {
            if (!jsonElement2.isJsonPrimitive()) {
            }
            if (jsonElement2 != null) {
                str2 = asString;
                String buildDisplayName22 = buildDisplayName(str, str2);
                if (buildDisplayName22 == null) {
                }
            }
        }
        params2 = toolCallInfo.getParams();
        if (params2 != null) {
            if (!jsonElement.isJsonPrimitive()) {
            }
            if (jsonElement != null) {
            }
        }
        String buildDisplayName222 = buildDisplayName(str, str2);
        if (buildDisplayName222 == null) {
        }
    }

    private final Function1<Context, View> buildMcpToolListView(final List<String> toolNames) {
        if (toolNames.isEmpty()) {
            return null;
        }
        return new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                LinearLayout buildMcpToolListView$lambda$13;
                buildMcpToolListView$lambda$13 = RunMCPCardCreator.buildMcpToolListView$lambda$13(toolNames, (Context) obj);
                return buildMcpToolListView$lambda$13;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinearLayout buildMcpToolListView$lambda$13(List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            String str = (String) it.next();
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout2.setMinimumHeight((int) (24 * f));
            if (i > 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = (int) (4 * f);
                linearLayout2.setLayoutParams(layoutParams);
            }
            TextView textView = new TextView(context);
            textView.setText(str);
            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            textView.setTextSize(2, 13.0f);
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            linearLayout.addView(linearLayout2);
            i = i2;
        }
        return linearLayout;
    }

    private final Function1<View, Unit> buildOnDetailClick(final ParsedToolCallInfo toolCallInfo) {
        final String jsonObject;
        ParsedToolCallResult result = toolCallInfo.getResult();
        JsonObject data = result != null ? result.getData() : null;
        if (data != null) {
            try {
                jsonObject = new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement) data);
            } catch (Throwable unused) {
                jsonObject = data.toString();
            }
        } else {
            ParsedToolCallResult result2 = toolCallInfo.getResult();
            if (result2 == null || (jsonObject = result2.getErrorMessage()) == null) {
                jsonObject = "";
            }
        }
        return new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.RunMCPCardCreator$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit buildOnDetailClick$lambda$20;
                buildOnDetailClick$lambda$20 = RunMCPCardCreator.buildOnDetailClick$lambda$20(RunMCPCardCreator.this, toolCallInfo, jsonObject, (View) obj);
                return buildOnDetailClick$lambda$20;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit buildOnDetailClick$lambda$20(RunMCPCardCreator runMCPCardCreator, ParsedToolCallInfo parsedToolCallInfo, String str, View view) {
        String str2;
        JsonObject params;
        String str3;
        ProcessDetailBottomSheet findBottomSheet;
        JsonObject params2;
        String str4;
        JsonObject params3;
        JsonObject params4;
        JsonElement jsonElement;
        ToolResultDetailFragment newInstance;
        JsonElement jsonElement2;
        String asString;
        JsonElement jsonElement3;
        JsonElement jsonElement4;
        JsonElement jsonElement5;
        Intrinsics.checkNotNullParameter(view, "v");
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder sb = new StringBuilder("[RunMCPCard] onDetailClick: mcpToolName=");
        JsonObject params5 = parsedToolCallInfo.getParams();
        String str5 = null;
        if (params5 != null && (jsonElement5 = params5.get("server_name")) != null) {
            if (!jsonElement5.isJsonPrimitive()) {
                jsonElement5 = null;
            }
            if (jsonElement5 != null) {
                str2 = jsonElement5.getAsString();
                params = parsedToolCallInfo.getParams();
                if (params != null && (jsonElement4 = params.get("tool_name")) != null) {
                    if (!jsonElement4.isJsonPrimitive()) {
                        jsonElement4 = null;
                    }
                    if (jsonElement4 != null) {
                        str3 = jsonElement4.getAsString();
                        fLogger.i("AgentTool", sb.append(runMCPCardCreator.buildDisplayName(str2, str3)).toString());
                        IApplog.Companion companion = IApplog.INSTANCE;
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tool_name", parsedToolCallInfo.getName());
                        Unit unit = Unit.INSTANCE;
                        companion.reportEvent("tool_call_click", jSONObject);
                        Context context = view.getContext();
                        findBottomSheet = runMCPCardCreator.findBottomSheet(context instanceof FragmentActivity ? (FragmentActivity) context : null);
                        params2 = parsedToolCallInfo.getParams();
                        if (params2 != null && (jsonElement3 = params2.get("server_name")) != null) {
                            if (!jsonElement3.isJsonPrimitive()) {
                                jsonElement3 = null;
                            }
                            if (jsonElement3 != null) {
                                str4 = jsonElement3.getAsString();
                                params3 = parsedToolCallInfo.getParams();
                                if (params3 != null && (jsonElement2 = params3.get("tool_name")) != null) {
                                    if (!jsonElement2.isJsonPrimitive()) {
                                        jsonElement2 = null;
                                    }
                                    if (jsonElement2 != null && (asString = jsonElement2.getAsString()) != null) {
                                        str5 = asString;
                                        String buildDisplayName = runMCPCardCreator.buildDisplayName(str4, str5);
                                        if (findBottomSheet != null) {
                                            newInstance = ToolResultDetailFragment.INSTANCE.newInstance(null, str, null, view.getContext().getString(C0637R.string.trae_chat_tool_mcp_response), buildDisplayName, (r18 & 32) != 0 ? null : null, (r18 & 64) != 0 ? null : null);
                                            findBottomSheet.navigateTo(newInstance);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                                params4 = parsedToolCallInfo.getParams();
                                if (params4 != null && (jsonElement = params4.get("name")) != null) {
                                    if (!jsonElement.isJsonPrimitive()) {
                                        jsonElement = null;
                                    }
                                    if (jsonElement != null) {
                                        str5 = jsonElement.getAsString();
                                    }
                                }
                                String buildDisplayName2 = runMCPCardCreator.buildDisplayName(str4, str5);
                                if (findBottomSheet != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        str4 = null;
                        params3 = parsedToolCallInfo.getParams();
                        if (params3 != null) {
                            if (!jsonElement2.isJsonPrimitive()) {
                            }
                            if (jsonElement2 != null) {
                                str5 = asString;
                                String buildDisplayName22 = runMCPCardCreator.buildDisplayName(str4, str5);
                                if (findBottomSheet != null) {
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        params4 = parsedToolCallInfo.getParams();
                        if (params4 != null) {
                            if (!jsonElement.isJsonPrimitive()) {
                            }
                            if (jsonElement != null) {
                            }
                        }
                        String buildDisplayName222 = runMCPCardCreator.buildDisplayName(str4, str5);
                        if (findBottomSheet != null) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                str3 = null;
                fLogger.i("AgentTool", sb.append(runMCPCardCreator.buildDisplayName(str2, str3)).toString());
                IApplog.Companion companion2 = IApplog.INSTANCE;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("tool_name", parsedToolCallInfo.getName());
                Unit unit2 = Unit.INSTANCE;
                companion2.reportEvent("tool_call_click", jSONObject2);
                Context context2 = view.getContext();
                findBottomSheet = runMCPCardCreator.findBottomSheet(context2 instanceof FragmentActivity ? (FragmentActivity) context2 : null);
                params2 = parsedToolCallInfo.getParams();
                if (params2 != null) {
                    if (!jsonElement3.isJsonPrimitive()) {
                    }
                    if (jsonElement3 != null) {
                    }
                }
                str4 = null;
                params3 = parsedToolCallInfo.getParams();
                if (params3 != null) {
                }
                params4 = parsedToolCallInfo.getParams();
                if (params4 != null) {
                }
                String buildDisplayName2222 = runMCPCardCreator.buildDisplayName(str4, str5);
                if (findBottomSheet != null) {
                }
                return Unit.INSTANCE;
            }
        }
        str2 = null;
        params = parsedToolCallInfo.getParams();
        if (params != null) {
            if (!jsonElement4.isJsonPrimitive()) {
            }
            if (jsonElement4 != null) {
            }
        }
        str3 = null;
        fLogger.i("AgentTool", sb.append(runMCPCardCreator.buildDisplayName(str2, str3)).toString());
        IApplog.Companion companion22 = IApplog.INSTANCE;
        JSONObject jSONObject22 = new JSONObject();
        jSONObject22.put("tool_name", parsedToolCallInfo.getName());
        Unit unit22 = Unit.INSTANCE;
        companion22.reportEvent("tool_call_click", jSONObject22);
        Context context22 = view.getContext();
        findBottomSheet = runMCPCardCreator.findBottomSheet(context22 instanceof FragmentActivity ? (FragmentActivity) context22 : null);
        params2 = parsedToolCallInfo.getParams();
        if (params2 != null) {
        }
        str4 = null;
        params3 = parsedToolCallInfo.getParams();
        if (params3 != null) {
        }
        params4 = parsedToolCallInfo.getParams();
        if (params4 != null) {
        }
        String buildDisplayName22222 = runMCPCardCreator.buildDisplayName(str4, str5);
        if (findBottomSheet != null) {
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
