package com.bytedance.trae.conversation.model;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: QueryItem.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/model/QueryItem;", "", DBData.FIELD_TYPE, "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class QueryItem {
    private static final String COMMAND_TYPE_PLUGIN = "plugin";
    private static final String COMMAND_TYPE_SKILL = "skill";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TYPE_ATTACHMENT = "attachment";
    public static final String TYPE_IMAGE = "image";
    public static final String TYPE_SLASH_COMMAND = "slash_command";
    public static final String TYPE_TEXT = "text";

    @SerializedName("data")
    private final Object data;

    @SerializedName(DBData.FIELD_TYPE)
    private final String type;

    public static /* synthetic */ QueryItem copy$default(QueryItem queryItem, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = queryItem.type;
        }
        if ((i & 2) != 0) {
            obj = queryItem.data;
        }
        return queryItem.copy(str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final Object getData() {
        return this.data;
    }

    public final QueryItem copy(String type, Object data) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(data, "data");
        return new QueryItem(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueryItem)) {
            return false;
        }
        QueryItem queryItem = (QueryItem) other;
        return Intrinsics.areEqual(this.type, queryItem.type) && Intrinsics.areEqual(this.data, queryItem.data);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "QueryItem(type=" + this.type + ", data=" + this.data + ')';
    }

    public QueryItem(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(obj, "data");
        this.type = str;
        this.data = obj;
    }

    public final String getType() {
        return this.type;
    }

    public final Object getData() {
        return this.data;
    }

    /* compiled from: QueryItem.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J,\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005J \u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005J.\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/conversation/model/QueryItem$Companion;", "", "<init>", "()V", "TYPE_TEXT", "", "TYPE_ATTACHMENT", "TYPE_IMAGE", "TYPE_SLASH_COMMAND", "COMMAND_TYPE_SKILL", "COMMAND_TYPE_PLUGIN", "text", "Lcom/bytedance/trae/conversation/model/QueryItem;", ReportConstant.COMMON_CONTENT, "attachment", "uri", "filename", "file_size", "", "chatSessionId", "image", "imageUri", QueryItem.COMMAND_TYPE_SKILL, "id", "name", QueryItem.COMMAND_TYPE_PLUGIN, "displayName", "iconUrl", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final QueryItem text(String content) {
            Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
            return new QueryItem("text", new TextData(content));
        }

        public static /* synthetic */ QueryItem attachment$default(Companion companion, String str, String str2, long j, String str3, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            long j2 = j;
            if ((i & 8) != 0) {
                str3 = null;
            }
            return companion.attachment(str, str2, j2, str3);
        }

        public final QueryItem attachment(String uri, String filename, long file_size, String chatSessionId) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(filename, "filename");
            return new QueryItem("attachment", new AttachmentData(uri, filename, file_size, (chatSessionId == null || !(StringsKt.isBlank(chatSessionId) ^ true)) ? null : chatSessionId));
        }

        public static /* synthetic */ QueryItem image$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            return companion.image(str, str2);
        }

        public final QueryItem image(String uri, String chatSessionId) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            if (chatSessionId == null || !(!StringsKt.isBlank(chatSessionId))) {
                chatSessionId = null;
            }
            return new QueryItem("image", new ImageData(uri, chatSessionId));
        }

        public static /* synthetic */ QueryItem imageUri$default(Companion companion, String str, String str2, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            return companion.imageUri(str, str2, j);
        }

        public final QueryItem imageUri(String uri, String filename, long file_size) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(filename, "filename");
            return new QueryItem("image", new ImageUriData(uri, filename, file_size));
        }

        public final QueryItem skill(String id, String name) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new QueryItem("slash_command", new SlashCommandData(id, name, null, null, QueryItem.COMMAND_TYPE_SKILL, null, null, null, 236, null));
        }

        public static /* synthetic */ QueryItem plugin$default(Companion companion, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            return companion.plugin(str, str2, str3, str4);
        }

        public final QueryItem plugin(String id, String name, String displayName, String iconUrl) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            return new QueryItem("slash_command", new SlashCommandData(id, name, displayName, iconUrl, QueryItem.COMMAND_TYPE_PLUGIN, null, null, null, 224, null));
        }
    }
}
