package com.bytedance.trae.conversation.debug;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.widget.CustomToast;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversationDebugInfoCopier.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fJ\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u001d\u001a\u00020\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;", "", "<init>", "()V", "CLIP_LABEL_AVATAR", "", "CLIP_LABEL_VOICE_DISCUSSION", "prettyGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "buildInfo", "Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;", "createdAt", "", "messageId", "replyToMessageId", "sessionId", "voiceDiscussion", "Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;", "buildJsonFields", "", "info", "buildJsonString", "copy", "", "context", "Landroid/content/Context;", "label", "uploadALog", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDebugInfoCopier {
    public static final String CLIP_LABEL_AVATAR = "avatar_debug_info";
    public static final String CLIP_LABEL_VOICE_DISCUSSION = "voice_discussion_debug_info";
    public static final ConversationDebugInfoCopier INSTANCE = new ConversationDebugInfoCopier();
    private static final Gson prettyGson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    private ConversationDebugInfoCopier() {
    }

    public final ConversationDebugLogInfo buildInfo(long createdAt, String messageId, String replyToMessageId, String sessionId, VoiceDiscussionDebugLogInfo voiceDiscussion) {
        AccountInfo accountInfo;
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Intrinsics.checkNotNullParameter(replyToMessageId, "replyToMessageId");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        String userId = (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null) ? null : accountInfo.getUserId();
        if (userId == null) {
            userId = "";
        }
        return new ConversationDebugLogInfo(createdAt, messageId, replyToMessageId, sessionId, IApplog.INSTANCE.getDeviceId(), userId, AppHost.INSTANCE.isOversea() ? "Oversea" : "CN", voiceDiscussion);
    }

    public final Map<String, Object> buildJsonFields(ConversationDebugLogInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("createdAt", Long.valueOf(info.getCreatedAt()));
        linkedHashMap.put("messageId", info.getMessageId());
        linkedHashMap.put("replyToMessageId", info.getReplyToMessageId());
        linkedHashMap.put("sessionId", info.getSessionId());
        linkedHashMap.put("deviceid", info.getDeviceId());
        linkedHashMap.put("userId", info.getUserId());
        linkedHashMap.put("location", info.getLocation());
        VoiceDiscussionDebugLogInfo voiceDiscussion = info.getVoiceDiscussion();
        if (voiceDiscussion != null) {
            linkedHashMap.put("voiceRoomId", voiceDiscussion.getVoiceRoomId());
            linkedHashMap.put("voiceTaskId", voiceDiscussion.getVoiceTaskId());
            linkedHashMap.put("subTaskSessionId", voiceDiscussion.getSubTaskSessionId());
            linkedHashMap.put("subTaskParentSessionId", voiceDiscussion.getSubTaskParentSessionId());
            linkedHashMap.put("subTaskSourceTaskId", voiceDiscussion.getSubTaskSourceTaskId());
            linkedHashMap.put("subTaskLocalTaskId", voiceDiscussion.getSubTaskLocalTaskId());
            linkedHashMap.put("subTaskState", voiceDiscussion.getSubTaskState());
        }
        return linkedHashMap;
    }

    public final String buildJsonString(ConversationDebugLogInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        String json = prettyGson.toJson(buildJsonFields(info));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public final void copy(Context context, String label, ConversationDebugLogInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(info, "info");
        Object systemService = context.getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText(label, buildJsonString(info)));
        }
        CustomToast.showLong(context, R.string.trae_conversation_copied);
        uploadALog();
    }

    public final void uploadALog() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        FLogger.INSTANCE.uploadALog("feedback", currentTimeMillis - 18000, currentTimeMillis, (Function1) null);
    }
}
