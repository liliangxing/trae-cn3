package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.interfaze.IFileDataCacheService;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BrowserActionDetailCardCreator.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J*\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J \u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0002¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "createBrowserActionCard", "createWaitingInteractionCard", "createHandOverCard", "onUpdateCard", "", "card", "extractDuration", "", "collectBrowserActions", "", "Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;", "buildActionsListView", "Landroid/view/View;", "actions", "buildActionRow", "density", "", "action", "Companion", "BrowserAction", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrowserActionDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TOOL_TAG = "AgentTool";

    /* compiled from: BrowserActionDetailCardCreator.kt */
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

    /* compiled from: BrowserActionDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$Companion;", "", "<init>", "()V", "TOOL_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        ToolDetailCard createWaitingInteractionCard;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        if (name == null) {
            name = "";
        }
        JsonObject params = toolCallInfo.getParams();
        String str = null;
        if (params != null && (jsonElement = params.get(IWeixinService.ResponseConstants.URL)) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        if (Intrinsics.areEqual(name, "BrowserHandOver")) {
            createWaitingInteractionCard = createHandOverCard(context, toolCallInfo);
        } else {
            createWaitingInteractionCard = Intrinsics.areEqual(name, "BrowserWaitingForUserInteraction") ? createWaitingInteractionCard(context, toolCallInfo, planItemContext) : createBrowserActionCard(context, toolCallInfo, planItemContext);
        }
        FLogger.INSTANCE.i("AgentTool", "[BrowserActionCard] onCreateDetail: name=" + name + ", result=" + createWaitingInteractionCard + ", url=" + str);
        return createWaitingInteractionCard;
    }

    private final ToolDetailCard createBrowserActionCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        ParsedToolCallInfo parsedToolCallInfo;
        boolean z;
        String string;
        int i;
        String str;
        int i2;
        boolean z2;
        String str2;
        ConfirmInfo confirmInfo;
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) {
            parsedToolCallInfo = toolCallInfo;
            z = false;
        } else {
            parsedToolCallInfo = toolCallInfo;
            z = true;
        }
        final List<BrowserAction> collectBrowserActions = collectBrowserActions(parsedToolCallInfo);
        if (z) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_browser_waiting_takeover);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int i3 = C0637R.drawable.browser_use;
            String string3 = context.getString(C0637R.string.trae_chat_tool_mcp_waiting);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            str2 = string3;
            str = string2;
            i2 = i3;
            z2 = true;
        } else {
            if (!z3) {
                String string4 = context.getString(C0637R.string.trae_chat_tool_browser_using);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                int i4 = C0637R.drawable.browser_use;
                r7 = collectBrowserActions.isEmpty() ^ true ? new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        View createBrowserActionCard$lambda$1;
                        createBrowserActionCard$lambda$1 = BrowserActionDetailCardCreator.createBrowserActionCard$lambda$1(BrowserActionDetailCardCreator.this, collectBrowserActions, (Context) obj);
                        return createBrowserActionCard$lambda$1;
                    }
                } : null;
                str = string4;
                i2 = i4;
                z2 = true;
            } else {
                if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                    string = context.getString(C0637R.string.trae_chat_tool_browser_failed);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    i = C0637R.drawable.browser_use;
                } else {
                    string = context.getString(C0637R.string.trae_chat_tool_browser_used);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    i = C0637R.drawable.browser_use;
                    if (true ^ collectBrowserActions.isEmpty()) {
                        r7 = new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.BrowserActionDetailCardCreator$$ExternalSyntheticLambda1
                            public final Object invoke(Object obj) {
                                View createBrowserActionCard$lambda$2;
                                createBrowserActionCard$lambda$2 = BrowserActionDetailCardCreator.createBrowserActionCard$lambda$2(BrowserActionDetailCardCreator.this, collectBrowserActions, (Context) obj);
                                return createBrowserActionCard$lambda$2;
                            }
                        };
                    }
                }
                str = string;
                i2 = i;
                z2 = false;
            }
            str2 = "";
        }
        return new ToolDetailCard("", i2, 0, str, null, str2, r7, fromString, z2, null, 528, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View createBrowserActionCard$lambda$1(BrowserActionDetailCardCreator browserActionDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return browserActionDetailCardCreator.buildActionsListView(context, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View createBrowserActionCard$lambda$2(BrowserActionDetailCardCreator browserActionDetailCardCreator, List list, Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return browserActionDetailCardCreator.buildActionsListView(context, list);
    }

    private final ToolDetailCard createWaitingInteractionCard(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        String string;
        int i;
        String str;
        int i2;
        boolean z;
        String str2;
        ConfirmInfo confirmInfo;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        boolean z2 = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
        int i3 = C0637R.drawable.browser_use;
        if (z2) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_browser_waiting_takeover);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str2 = context.getString(C0637R.string.trae_chat_tool_mcp_waiting);
            z = true;
            str = string2;
            i2 = i3;
        } else {
            if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
                string = context.getString(C0637R.string.trae_chat_tool_browser_failed);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                i = C0637R.drawable.browser_use;
            } else {
                string = context.getString(C0637R.string.trae_chat_tool_browser_used);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                i = C0637R.drawable.browser_use;
            }
            str = string;
            i2 = i;
            z = false;
            str2 = "";
        }
        return new ToolDetailCard("", i2, 0, str, null, str2, null, fromString, z, null, 596, null);
    }

    private final ToolDetailCard createHandOverCard(Context context, ParsedToolCallInfo toolCallInfo) {
        String string;
        String str;
        boolean z;
        boolean z2 = true;
        boolean z3 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        String str2 = null;
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (!z3) {
            String string2 = context.getString(C0637R.string.trae_chat_tool_browser_user_taking_over);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            str = string2;
            z = true;
        } else {
            if (fromString != ToolExecutionStatus.FAILED && fromString != ToolExecutionStatus.SKIPPED && fromString != ToolExecutionStatus.CANCELED) {
                z2 = false;
            }
            if (z2) {
                string = context.getString(C0637R.string.trae_chat_tool_browser_user_declined);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            } else {
                string = context.getString(C0637R.string.trae_chat_tool_browser_user_takeover);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str2 = extractDuration(toolCallInfo);
            }
            str = string;
            z = false;
        }
        return new ToolDetailCard("", C0637R.drawable.user_remove, 0, str, str2, null, null, fromString, z, null, 612, null);
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        ConfirmInfo confirmInfo;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        String name = toolCallInfo.getName();
        if (name == null) {
            name = "";
        }
        boolean z = true;
        boolean z2 = toolCallInfo.getResult() != null;
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        String str = null;
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        if (Intrinsics.areEqual(name, "BrowserHandOver")) {
            if (!z2) {
                String string = context.getString(C0637R.string.trae_chat_tool_browser_user_taking_over);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                card.setTitle(string);
                card.setSubtitle(null);
                card.setShimmerTitle(true);
            } else {
                if (fromString != ToolExecutionStatus.FAILED && fromString != ToolExecutionStatus.SKIPPED && fromString != ToolExecutionStatus.CANCELED) {
                    z = false;
                }
                if (z) {
                    String string2 = context.getString(C0637R.string.trae_chat_tool_browser_user_declined);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    card.setTitle(string2);
                    card.setSubtitle(null);
                } else {
                    String string3 = context.getString(C0637R.string.trae_chat_tool_browser_user_takeover);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    card.setTitle(string3);
                    card.setSubtitle(extractDuration(toolCallInfo));
                }
                card.setShimmerTitle(false);
            }
            card.setIconResId(C0637R.drawable.user_remove);
        } else if (Intrinsics.areEqual(name, "BrowserWaitingForUserInteraction")) {
            boolean z3 = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
            if (!z2) {
                String string4 = context.getString(C0637R.string.trae_chat_tool_browser_waiting_takeover);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                card.setTitle(string4);
                card.setBadgeText(z3 ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                card.setShimmerTitle(true);
            } else {
                String string5 = context.getString(C0637R.string.trae_chat_tool_browser_user_taking_over);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                card.setTitle(string5);
                card.setBadgeText(null);
                card.setShimmerTitle(false);
            }
            card.setIconResId(C0637R.drawable.user_remove);
        } else if (!z2) {
            String string6 = context.getString(C0637R.string.trae_chat_tool_browser_using);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            card.setTitle(string6);
            card.setIconResId(C0637R.drawable.browser_use);
            card.setShimmerTitle(true);
        } else if (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()] == 1) {
            String string7 = context.getString(C0637R.string.trae_chat_tool_browser_failed);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            card.setTitle(string7);
            card.setIconResId(C0637R.drawable.browser_use);
            card.setShimmerTitle(false);
        } else {
            String string8 = context.getString(C0637R.string.trae_chat_tool_browser_used);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            card.setTitle(string8);
            card.setIconResId(C0637R.drawable.browser_use);
            card.setShimmerTitle(false);
        }
        card.setStatus(fromString);
        FLogger fLogger = FLogger.INSTANCE;
        StringBuilder append = new StringBuilder("[BrowserActionCard] onUpdateCard: name=").append(name).append(", status=").append(fromString).append(", url=");
        JsonObject params = toolCallInfo.getParams();
        if (params != null && (jsonElement = params.get(IWeixinService.ResponseConstants.URL)) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null) {
                str = jsonElement.getAsString();
            }
        }
        fLogger.i("AgentTool", append.append(str).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String extractDuration(ParsedToolCallInfo toolCallInfo) {
        JsonObject data;
        String str;
        Long l;
        StringBuilder append;
        String str2;
        ParsedToolCallResult result = toolCallInfo.getResult();
        if (result != null && (data = result.getData()) != null) {
            JsonElement jsonElement = data.get(ReportConstant.COMMON_INIT_DURATION);
            if (jsonElement != null) {
                if (!jsonElement.isJsonPrimitive()) {
                    jsonElement = null;
                }
                if (jsonElement != null) {
                    str = jsonElement.getAsString();
                    if (str == null) {
                        return str;
                    }
                    JsonElement jsonElement2 = data.get("duration_seconds");
                    if (jsonElement2 != null) {
                        if (!jsonElement2.isJsonPrimitive()) {
                            jsonElement2 = null;
                        }
                        if (jsonElement2 != null) {
                            l = Long.valueOf(jsonElement2.getAsLong());
                            if (l != null) {
                                long longValue = l.longValue() / 60;
                                if (longValue > 0) {
                                    append = new StringBuilder().append(longValue);
                                    str2 = " minutes";
                                } else {
                                    append = new StringBuilder().append(l);
                                    str2 = " seconds";
                                }
                                return append.append(str2).toString();
                            }
                        }
                    }
                    l = null;
                    if (l != null) {
                    }
                }
            }
            str = null;
            if (str == null) {
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00d4, code lost:
    
        if (r5 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<BrowserAction> collectBrowserActions(ParsedToolCallInfo toolCallInfo) {
        JsonArray jsonArray;
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        String str2;
        String asString;
        String str3;
        JsonObject asJsonObject;
        JsonElement jsonElement3;
        String asString2;
        String str4;
        JsonObject data;
        JsonElement jsonElement4;
        ArrayList arrayList = new ArrayList();
        ParsedToolCallResult result = toolCallInfo.getResult();
        if (result != null && (data = result.getData()) != null && (jsonElement4 = data.get("steps")) != null) {
            if (!jsonElement4.isJsonArray()) {
                jsonElement4 = null;
            }
            if (jsonElement4 != null) {
                jsonArray = jsonElement4.getAsJsonArray();
                if (jsonArray == null) {
                    int size = jsonArray.size();
                    for (int i = 0; i < size; i++) {
                        JsonElement jsonElement5 = jsonArray.get(i);
                        if (jsonElement5 != null) {
                            if (!jsonElement5.isJsonObject()) {
                                jsonElement5 = null;
                            }
                            if (jsonElement5 != null && (asJsonObject = jsonElement5.getAsJsonObject()) != null && (jsonElement3 = asJsonObject.get("action")) != null) {
                                if (!jsonElement3.isJsonPrimitive()) {
                                    jsonElement3 = null;
                                }
                                if (jsonElement3 != null && (asString2 = jsonElement3.getAsString()) != null) {
                                    JsonElement jsonElement6 = asJsonObject.get("target");
                                    if (jsonElement6 != null) {
                                        if (!jsonElement6.isJsonPrimitive()) {
                                            jsonElement6 = null;
                                        }
                                        if (jsonElement6 != null) {
                                            str4 = jsonElement6.getAsString();
                                            arrayList.add(new BrowserAction(asString2, str4));
                                        }
                                    }
                                    str4 = null;
                                    arrayList.add(new BrowserAction(asString2, str4));
                                }
                            }
                        }
                    }
                    return arrayList;
                }
                String name = toolCallInfo.getName();
                String removePrefix = name != null ? StringsKt.removePrefix(name, "browser_") : null;
                JsonObject params = toolCallInfo.getParams();
                if (params != null && removePrefix != null) {
                    JsonElement jsonElement7 = params.get(IWeixinService.ResponseConstants.URL);
                    if (jsonElement7 != null) {
                        if (!jsonElement7.isJsonPrimitive()) {
                            jsonElement7 = null;
                        }
                        if (jsonElement7 != null) {
                            str = jsonElement7.getAsString();
                            jsonElement = params.get("selector");
                            if (jsonElement != null) {
                                if (!jsonElement.isJsonPrimitive()) {
                                    jsonElement = null;
                                }
                                if (jsonElement != null) {
                                    asString = jsonElement.getAsString();
                                }
                            }
                            jsonElement2 = params.get("element");
                            if (jsonElement2 != null) {
                                if (!jsonElement2.isJsonPrimitive()) {
                                    jsonElement2 = null;
                                }
                                if (jsonElement2 != null) {
                                    asString = jsonElement2.getAsString();
                                    str2 = asString;
                                    str3 = removePrefix;
                                    if (!StringsKt.contains(str3, "navigate", true) || StringsKt.contains(str3, "goto", true)) {
                                        arrayList.add(new BrowserAction("Navigated to", str));
                                    } else if (StringsKt.contains(str3, IFileDataCacheService.TYPE_SNAPSHOT, true) || StringsKt.contains(str3, "screenshot", true)) {
                                        arrayList.add(new BrowserAction("Captured snapshot", null));
                                    } else if (StringsKt.contains(str3, "get_attribute", true) || StringsKt.contains(str3, "getAttribute", true)) {
                                        arrayList.add(new BrowserAction("Getting attribute from", str2));
                                    } else if (StringsKt.contains(str3, "click", true)) {
                                        arrayList.add(new BrowserAction("Clicked", str2));
                                    } else if (StringsKt.contains(str3, DBData.FIELD_TYPE, true) || StringsKt.contains(str3, "input", true)) {
                                        arrayList.add(new BrowserAction("Typed in", str2));
                                    } else {
                                        String replace$default = StringsKt.replace$default(removePrefix, SyncConstants.SEPARATOR, " ", false, 4, (Object) null);
                                        if (replace$default.length() > 0) {
                                            char upperCase = Character.toUpperCase(replace$default.charAt(0));
                                            String substring = replace$default.substring(1);
                                            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                            replace$default = upperCase + substring;
                                        }
                                        if (str == null) {
                                            str = str2;
                                        }
                                        arrayList.add(new BrowserAction(replace$default, str));
                                    }
                                }
                            }
                            str2 = null;
                            str3 = removePrefix;
                            if (!StringsKt.contains(str3, "navigate", true)) {
                            }
                            arrayList.add(new BrowserAction("Navigated to", str));
                        }
                    }
                    str = null;
                    jsonElement = params.get("selector");
                    if (jsonElement != null) {
                    }
                    jsonElement2 = params.get("element");
                    if (jsonElement2 != null) {
                    }
                    str2 = null;
                    str3 = removePrefix;
                    if (!StringsKt.contains(str3, "navigate", true)) {
                    }
                    arrayList.add(new BrowserAction("Navigated to", str));
                }
                return arrayList;
            }
        }
        jsonArray = null;
        if (jsonArray == null) {
        }
    }

    private final View buildActionsListView(Context context, List<BrowserAction> actions) {
        float f = context.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Iterator<T> it = actions.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = i + 1;
            View buildActionRow = buildActionRow(context, f, (BrowserAction) it.next());
            if (i > 0) {
                ViewGroup.LayoutParams layoutParams = buildActionRow.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = (int) (4 * f);
                }
            }
            linearLayout.addView(buildActionRow);
            i = i2;
        }
        return linearLayout;
    }

    private final View buildActionRow(Context context, float density, BrowserAction action) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * density));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setText(action.getAction());
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        if (action.getTarget() != null) {
            int i = (int) (4 * density);
            int i2 = (int) (2 * density);
            TextView textView2 = new TextView(context);
            textView2.setText(action.getTarget());
            textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            textView2.setTextSize(2, 13.0f);
            textView2.setMaxLines(1);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setPadding(i, i2, i, i2);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1));
            gradientDrawable.setCornerRadius(30 * density);
            textView2.setBackground(gradientDrawable);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            layoutParams.setMarginStart((int) (6 * density));
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(textView2, layoutParams);
        }
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BrowserActionDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/BrowserActionDetailCardCreator$BrowserAction;", "", "action", "", "target", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getTarget", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class BrowserAction {
        private final String action;
        private final String target;

        public static /* synthetic */ BrowserAction copy$default(BrowserAction browserAction, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = browserAction.action;
            }
            if ((i & 2) != 0) {
                str2 = browserAction.target;
            }
            return browserAction.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        /* renamed from: component2, reason: from getter */
        public final String getTarget() {
            return this.target;
        }

        public final BrowserAction copy(String action, String target) {
            Intrinsics.checkNotNullParameter(action, "action");
            return new BrowserAction(action, target);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BrowserAction)) {
                return false;
            }
            BrowserAction browserAction = (BrowserAction) other;
            return Intrinsics.areEqual(this.action, browserAction.action) && Intrinsics.areEqual(this.target, browserAction.target);
        }

        public int hashCode() {
            int hashCode = this.action.hashCode() * 31;
            String str = this.target;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "BrowserAction(action=" + this.action + ", target=" + this.target + ')';
        }

        public BrowserAction(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "action");
            this.action = str;
            this.target = str2;
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTarget() {
            return this.target;
        }
    }
}
