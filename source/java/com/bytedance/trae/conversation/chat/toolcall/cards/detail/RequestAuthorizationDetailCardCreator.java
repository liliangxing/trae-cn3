package com.bytedance.trae.conversation.chat.toolcall.cards.detail;

import android.content.Context;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.conversation.plugin.PluginListCache;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: RequestAuthorizationDetailCardCreator.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator;", "Lcom/bytedance/trae/conversation/chat/toolcall/BaseToolDetailCardCreator;", "<init>", "()V", "onCreateDetail", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "context", "Landroid/content/Context;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "onUpdateCard", "", "card", "extractPluginDisplayName", "", "localizedDisplayName", "value", "displayName", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class RequestAuthorizationDetailCardCreator extends BaseToolDetailCardCreator {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String SERVICE_SEPARATOR = "::";

    /* compiled from: RequestAuthorizationDetailCardCreator.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToolExecutionStatus.values().length];
            try {
                iArr[ToolExecutionStatus.PENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToolExecutionStatus.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToolExecutionStatus.FAILED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ToolExecutionStatus.SKIPPED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ToolExecutionStatus.CANCELED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ToolExecutionStatus.SUCCESS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0043. Please report as an issue. */
    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected ToolDetailCard onCreateDetail(Context context, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        boolean z;
        String str;
        String string;
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        boolean z2 = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
        String extractPluginDisplayName = extractPluginDisplayName(context, toolCallInfo);
        switch (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()]) {
            case 1:
            case 2:
                String string2 = context.getString(C0637R.string.trae_chat_tool_authorization_waiting);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                r4 = z2 ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null;
                z = true;
                str = string2;
                return new ToolDetailCard("", C0637R.drawable.explorer_file_authorization, 0, str, extractPluginDisplayName, r4, null, fromString, z, null, 580, null);
            case 3:
                string = context.getString(C0637R.string.trae_chat_tool_authorization_failed);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
                z = false;
                return new ToolDetailCard("", C0637R.drawable.explorer_file_authorization, 0, str, extractPluginDisplayName, r4, null, fromString, z, null, 580, null);
            case 4:
            case 5:
                string = context.getString(C0637R.string.trae_chat_tool_authorization_skipped);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
                z = false;
                return new ToolDetailCard("", C0637R.drawable.explorer_file_authorization, 0, str, extractPluginDisplayName, r4, null, fromString, z, null, 580, null);
            case 6:
                string = context.getString(C0637R.string.trae_chat_tool_authorization_completed);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                str = string;
                z = false;
                return new ToolDetailCard("", C0637R.drawable.explorer_file_authorization, 0, str, extractPluginDisplayName, r4, null, fromString, z, null, 580, null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.bytedance.trae.conversation.chat.toolcall.BaseToolDetailCardCreator
    protected void onUpdateCard(Context context, ToolDetailCard card, ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
        ConfirmInfo confirmInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
        ToolExecutionStatus.Companion companion = ToolExecutionStatus.INSTANCE;
        ParsedToolCallResult result = toolCallInfo.getResult();
        ToolExecutionStatus fromString = companion.fromString(result != null ? result.getStatus() : null);
        boolean z = (planItemContext == null || (confirmInfo = planItemContext.getConfirmInfo()) == null || !confirmInfo.isWaitingConfirm()) ? false : true;
        String extractPluginDisplayName = extractPluginDisplayName(context, toolCallInfo);
        switch (WhenMappings.$EnumSwitchMapping$0[fromString.ordinal()]) {
            case 1:
            case 2:
                String string = context.getString(C0637R.string.trae_chat_tool_authorization_waiting);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                card.setTitle(string);
                card.setBadgeText(z ? context.getString(C0637R.string.trae_chat_tool_mcp_waiting) : null);
                card.setShimmerTitle(true);
                break;
            case 3:
                String string2 = context.getString(C0637R.string.trae_chat_tool_authorization_failed);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                card.setTitle(string2);
                card.setBadgeText(null);
                card.setShimmerTitle(false);
                break;
            case 4:
            case 5:
                String string3 = context.getString(C0637R.string.trae_chat_tool_authorization_skipped);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                card.setTitle(string3);
                card.setBadgeText(null);
                card.setShimmerTitle(false);
                break;
            case 6:
                String string4 = context.getString(C0637R.string.trae_chat_tool_authorization_completed);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                card.setTitle(string4);
                card.setBadgeText(null);
                card.setShimmerTitle(false);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        card.setSubtitle(extractPluginDisplayName);
        card.setStatus(fromString);
    }

    private final String extractPluginDisplayName(Context context, ParsedToolCallInfo toolCallInfo) {
        Object obj;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.Companion;
            RequestAuthorizationDetailCardCreator requestAuthorizationDetailCardCreator = this;
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
            return "Authorization";
        }
        int indexOf$default = StringsKt.indexOf$default(str2, "::", 0, false, 6, (Object) null);
        if (indexOf$default > 0) {
            str = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "substring(...)");
        }
        String cachedLocalizedDisplayName = PluginListCache.INSTANCE.getCachedLocalizedDisplayName(str);
        String str3 = cachedLocalizedDisplayName;
        if (!(str3 == null || StringsKt.isBlank(str3))) {
            return cachedLocalizedDisplayName;
        }
        String localizedDisplayName = localizedDisplayName(context, StringsKt.substringAfterLast$default(str, ':', (String) null, 2, (Object) null));
        String str4 = StringsKt.isBlank(localizedDisplayName) ^ true ? localizedDisplayName : null;
        return str4 == null ? "Authorization" : str4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0062, code lost:
    
        if (r0.equals("lark") == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
    
        return "飞书";
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (r0.equals("feishu") == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String localizedDisplayName(Context context, String value) {
        String language = context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        String obj = StringsKt.trim(value).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(language, "zh")) {
            switch (lowerCase.hashCode()) {
                case -1278276362:
                    break;
                case 3314286:
                    break;
                case 113006579:
                    if (lowerCase.equals("wecom")) {
                        return "企业微信";
                    }
                    return displayName(value);
                case 133862058:
                    if (lowerCase.equals("dingtalk")) {
                        return "钉钉";
                    }
                    return displayName(value);
                default:
                    return displayName(value);
            }
        } else {
            return displayName(value);
        }
    }

    private final String displayName(String value) {
        String str = value;
        String obj = StringsKt.trim(str).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -1278276362:
                if (lowerCase.equals("feishu")) {
                    return "Feishu";
                }
                break;
            case 3314286:
                if (lowerCase.equals("lark")) {
                    return "Lark";
                }
                break;
            case 113006579:
                if (lowerCase.equals("wecom")) {
                    return "WeCom";
                }
                break;
            case 133862058:
                if (lowerCase.equals("dingtalk")) {
                    return "DingTalk";
                }
                break;
        }
        List split$default = StringsKt.split$default(StringsKt.trim(str).toString(), new char[]{'-', '_'}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : split$default) {
            if (!StringsKt.isBlank((String) obj2)) {
                arrayList.add(obj2);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.chat.toolcall.cards.detail.RequestAuthorizationDetailCardCreator$$ExternalSyntheticLambda0
            public final Object invoke(Object obj3) {
                CharSequence displayName$lambda$4;
                displayName$lambda$4 = RequestAuthorizationDetailCardCreator.displayName$lambda$4((String) obj3);
                return displayName$lambda$4;
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence displayName$lambda$4(String str) {
        String valueOf;
        Intrinsics.checkNotNullParameter(str, "word");
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                valueOf = CharsKt.titlecase(charAt, locale);
            } else {
                valueOf = String.valueOf(charAt);
            }
            StringBuilder append = sb.append((Object) valueOf);
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = append.append(substring).toString();
        }
        return str;
    }

    /* compiled from: RequestAuthorizationDetailCardCreator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RequestAuthorizationDetailCardCreator$Companion;", "", "<init>", "()V", "SERVICE_SEPARATOR", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
