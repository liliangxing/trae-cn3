package com.bytedance.trae.conversation.chat.viewholder;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: UserMessageViewHolder.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\rH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\rH\u0000\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\rH\u0000\u001a\f\u0010\u0011\u001a\u00020\n*\u00020\rH\u0002\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u001a'\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00192\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001d\"\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"AGENT_TYPE_VOICE_SUMMARY", "", "USER_MESSAGE_ATTACHMENT_TAG", "REMOTE_RESOURCE_PREFIX", "USER_MESSAGE_REMOTE_RESOURCE_CACHE_DIR", "USER_MESSAGE_IMAGE_EXTENSIONS", "", "CHAT_SESSION_ID_KEYS", "", "isBrainstormMessage", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "previewChatSessionIdFromData", "Lcom/bytedance/trae/im/model/MessagePart;", "previewOidIdFromData", "previewImageItemFromData", "Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;", "isImageAttachmentPart", "normalizeRemoteResourceUri", AccountMonitorConstants.CommonParameter.RAW, "normalizeRemoteResourceId", "normalizeImageResourceId", "isImageFilename", "isLocalArtifactPath", "stringValue", "Lcom/google/gson/JsonObject;", "key", "firstStringValue", "keys", "", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/String;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class UserMessageViewHolderKt {
    private static final String AGENT_TYPE_VOICE_SUMMARY = "voice_summary";
    private static final String REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";
    private static final String USER_MESSAGE_ATTACHMENT_TAG = "UserMessageAttachment";
    private static final String USER_MESSAGE_REMOTE_RESOURCE_CACHE_DIR = "multi_image_remote_resource";
    private static final Set<String> USER_MESSAGE_IMAGE_EXTENSIONS = SetsKt.setOf(new String[]{"jpg", "jpeg", "png", "gif", "webp", "bmp", "heic", "heif"});
    private static final List<String> CHAT_SESSION_ID_KEYS = CollectionsKt.listOf(new String[]{"chat_session_id", "chatSessionId", "cli_conversation_id", "cliConversationId", "parent_chat_session_id", "parentChatSessionId", "voice_conversation_id", "voiceConversationId", "session_id", "sessionId", "session"});

    public static final boolean isBrainstormMessage(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<this>");
        return Intrinsics.areEqual(parsedChatMessage.getAgentType(), "voice_summary");
    }

    public static final String previewChatSessionIdFromData(MessagePart messagePart) {
        Intrinsics.checkNotNullParameter(messagePart, "<this>");
        JsonObject data = messagePart.getData();
        if (data == null) {
            return null;
        }
        Iterator<String> it = CHAT_SESSION_ID_KEYS.iterator();
        while (it.hasNext()) {
            String stringValue = stringValue(data, it.next());
            if (stringValue != null) {
                return stringValue;
            }
        }
        return null;
    }

    public static final String previewOidIdFromData(MessagePart messagePart) {
        Intrinsics.checkNotNullParameter(messagePart, "<this>");
        JsonObject data = messagePart.getData();
        if (data == null) {
            return "";
        }
        String stringValue = stringValue(data, "tos_oid");
        String stringValue2 = stringValue(data, "uri");
        String str = stringValue2 != null ? stringValue2 : "";
        String normalizeRemoteResourceUri = normalizeRemoteResourceUri(stringValue);
        return (normalizeRemoteResourceUri == null && (normalizeRemoteResourceUri = normalizeRemoteResourceUri(str)) == null) ? str : normalizeRemoteResourceUri;
    }

    public static final UserPreviewImageItem previewImageItemFromData(MessagePart messagePart) {
        String normalizeRemoteResourceId;
        Intrinsics.checkNotNullParameter(messagePart, "<this>");
        JsonObject data = messagePart.getData();
        if (data == null) {
            return null;
        }
        String type = messagePart.getType();
        if (Intrinsics.areEqual(type, "image")) {
            String firstStringValue = firstStringValue(data, "image_id", "imageId");
            if (firstStringValue == null && (firstStringValue = normalizeImageResourceId(firstStringValue(data, "uri"))) == null) {
                return null;
            }
            return new UserPreviewImageItem(UserPreviewImageKind.IMAGE_ID, firstStringValue, firstStringValue(data, "filename", "file_name", "name"));
        }
        if (!Intrinsics.areEqual(type, "attachment") || !isImageAttachmentPart(messagePart)) {
            return null;
        }
        String firstStringValue2 = firstStringValue(data, "uri");
        String normalizeRemoteResourceUri = normalizeRemoteResourceUri(firstStringValue(data, "tos_oid", "tosOid"));
        if (normalizeRemoteResourceUri == null || (normalizeRemoteResourceId = normalizeRemoteResourceId(normalizeRemoteResourceUri)) == null) {
            String normalizeRemoteResourceUri2 = normalizeRemoteResourceUri(firstStringValue2);
            normalizeRemoteResourceId = normalizeRemoteResourceUri2 != null ? normalizeRemoteResourceId(normalizeRemoteResourceUri2) : null;
        }
        String firstStringValue3 = firstStringValue(data, "filename", "file_name", "name");
        if (normalizeRemoteResourceId != null) {
            return new UserPreviewImageItem(UserPreviewImageKind.REMOTE_RESOURCE, normalizeRemoteResourceId, firstStringValue3);
        }
        if (!isLocalArtifactPath(firstStringValue2)) {
            return null;
        }
        UserPreviewImageKind userPreviewImageKind = UserPreviewImageKind.LOCAL_ARTIFACT;
        Intrinsics.checkNotNull(firstStringValue2);
        return new UserPreviewImageItem(userPreviewImageKind, StringsKt.trim(firstStringValue2).toString(), firstStringValue3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isImageAttachmentPart(MessagePart messagePart) {
        JsonObject data;
        if (Intrinsics.areEqual(messagePart.getType(), "image")) {
            return true;
        }
        boolean z = false;
        if (!Intrinsics.areEqual(messagePart.getType(), "attachment") || (data = messagePart.getData()) == null) {
            return false;
        }
        String firstStringValue = firstStringValue(data, "mime_type", "mimeType", "content_type", "contentType");
        if (firstStringValue != null) {
            String lowerCase = firstStringValue.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null && StringsKt.startsWith$default(lowerCase, "image/", false, 2, (Object) null)) {
                z = true;
            }
        }
        if (z || isImageFilename(firstStringValue(data, "filename", "file_name", "name"))) {
            return true;
        }
        return isImageFilename(firstStringValue(data, "uri", "tos_oid", "tosOid"));
    }

    private static final String normalizeRemoteResourceUri(String str) {
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        if (StringsKt.startsWith$default(obj, REMOTE_RESOURCE_PREFIX, false, 2, (Object) null)) {
            return obj;
        }
        if (StringsKt.startsWith$default(obj, "tos-", false, 2, (Object) null)) {
            return REMOTE_RESOURCE_PREFIX + obj;
        }
        return null;
    }

    private static final String normalizeRemoteResourceId(String str) {
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String removePrefix = StringsKt.removePrefix(obj, REMOTE_RESOURCE_PREFIX);
        if (!StringsKt.isBlank(removePrefix)) {
            return removePrefix;
        }
        return null;
    }

    private static final String normalizeImageResourceId(String str) {
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String removePrefix = StringsKt.removePrefix(obj, REMOTE_RESOURCE_PREFIX);
        if (StringsKt.startsWith$default(removePrefix, "tos-", false, 2, (Object) null)) {
            return removePrefix;
        }
        return null;
    }

    private static final boolean isImageFilename(String str) {
        String substringBefore$default;
        String substringAfterLast;
        String str2 = null;
        if (str != null && (substringBefore$default = StringsKt.substringBefore$default(str, '?', (String) null, 2, (Object) null)) != null && (substringAfterLast = StringsKt.substringAfterLast(substringBefore$default, '.', "")) != null) {
            str2 = substringAfterLast.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str2, "toLowerCase(...)");
        }
        return USER_MESSAGE_IMAGE_EXTENSIONS.contains(str2 != null ? str2 : "");
    }

    private static final boolean isLocalArtifactPath(String str) {
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        String str2 = obj;
        if (StringsKt.isBlank(str2) || StringsKt.startsWith$default(obj, "content://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "file://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(obj, "https://", false, 2, (Object) null)) {
            return false;
        }
        return StringsKt.startsWith$default(obj, "/", false, 2, (Object) null) || new Regex("^[A-Za-z]:[\\\\/].*").matches(str2);
    }

    private static final String stringValue(JsonObject jsonObject, String str) {
        String asString;
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonPrimitive()) {
            jsonElement = null;
        }
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || !(!StringsKt.isBlank(asString))) {
            return null;
        }
        return asString;
    }

    private static final String firstStringValue(JsonObject jsonObject, String... strArr) {
        for (String str : strArr) {
            String stringValue = stringValue(jsonObject, str);
            if (stringValue != null) {
                return stringValue;
            }
        }
        return null;
    }
}
