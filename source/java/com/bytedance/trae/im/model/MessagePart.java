package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/im/model/MessagePart;", "", "type", "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getType", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MessagePart {
    public static final String TYPE_ATTACHMENT = "attachment";
    public static final String TYPE_CODE = "code";
    public static final String TYPE_CREATE_MR = "agent_review_marker";
    public static final String TYPE_DOC = "doc";
    public static final String TYPE_FIGMA = "figma";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_FOLDER = "folder";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_LINT_ERROR = "lint_error";
    public static final String TYPE_LOG = "log";
    public static final String TYPE_PROBLEM_FILE = "problem_file";
    public static final String TYPE_PROBLEM_ITEM = "problem_item";
    public static final String TYPE_RULE = "rule";
    public static final String TYPE_SLASH_COMMAND = "slash_command";
    public static final String TYPE_TERMINAL = "terminal";
    public static final String TYPE_TEXT = "text";
    public static final String TYPE_WEBVIEW = "webview";
    public static final String TYPE_WEB_ELEMENT = "web_element";
    public static final String TYPE_WEB_PAGE = "web_page";
    public static final String TYPE_WEB_SEARCH = "web_search";
    public static final String TYPE_WORKSPACE = "workspace";

    @SerializedName("data")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject data;

    @SerializedName("type")
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public MessagePart() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessagePart copy$default(MessagePart messagePart, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messagePart.type;
        }
        if ((i & 2) != 0) {
            jsonObject = messagePart.data;
        }
        return messagePart.copy(str, jsonObject);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonObject getData() {
        return this.data;
    }

    public final MessagePart copy(String type, JsonObject data) {
        return new MessagePart(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessagePart)) {
            return false;
        }
        MessagePart messagePart = (MessagePart) other;
        return Intrinsics.areEqual(this.type, messagePart.type) && Intrinsics.areEqual(this.data, messagePart.data);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        JsonObject jsonObject = this.data;
        return hashCode + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "MessagePart(type=" + this.type + ", data=" + this.data + ')';
    }

    public MessagePart(String str, JsonObject jsonObject) {
        this.type = str;
        this.data = jsonObject;
    }

    public /* synthetic */ MessagePart(String str, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jsonObject);
    }

    public final String getType() {
        return this.type;
    }

    public final JsonObject getData() {
        return this.data;
    }
}
