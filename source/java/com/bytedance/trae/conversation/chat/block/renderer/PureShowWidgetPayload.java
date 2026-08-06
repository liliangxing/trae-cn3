package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PureShowWidgetInlineView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003JG\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "", "widgetCode", "", "widgetId", "title", "mode", "loadingMessages", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getWidgetCode", "()Ljava/lang/String;", "getWidgetId", "getTitle", "getMode", "getLoadingMessages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class PureShowWidgetPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> loadingMessages;
    private final String mode;
    private final String title;
    private final String widgetCode;
    private final String widgetId;

    public static /* synthetic */ PureShowWidgetPayload copy$default(PureShowWidgetPayload pureShowWidgetPayload, String str, String str2, String str3, String str4, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pureShowWidgetPayload.widgetCode;
        }
        if ((i & 2) != 0) {
            str2 = pureShowWidgetPayload.widgetId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = pureShowWidgetPayload.title;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = pureShowWidgetPayload.mode;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            list = pureShowWidgetPayload.loadingMessages;
        }
        return pureShowWidgetPayload.copy(str, str5, str6, str7, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getWidgetCode() {
        return this.widgetCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getWidgetId() {
        return this.widgetId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final List<String> component5() {
        return this.loadingMessages;
    }

    public final PureShowWidgetPayload copy(String widgetCode, String widgetId, String title, String mode, List<String> loadingMessages) {
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        Intrinsics.checkNotNullParameter(loadingMessages, "loadingMessages");
        return new PureShowWidgetPayload(widgetCode, widgetId, title, mode, loadingMessages);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PureShowWidgetPayload)) {
            return false;
        }
        PureShowWidgetPayload pureShowWidgetPayload = (PureShowWidgetPayload) other;
        return Intrinsics.areEqual(this.widgetCode, pureShowWidgetPayload.widgetCode) && Intrinsics.areEqual(this.widgetId, pureShowWidgetPayload.widgetId) && Intrinsics.areEqual(this.title, pureShowWidgetPayload.title) && Intrinsics.areEqual(this.mode, pureShowWidgetPayload.mode) && Intrinsics.areEqual(this.loadingMessages, pureShowWidgetPayload.loadingMessages);
    }

    public int hashCode() {
        int hashCode = this.widgetCode.hashCode() * 31;
        String str = this.widgetId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mode;
        return ((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.loadingMessages.hashCode();
    }

    public String toString() {
        return "PureShowWidgetPayload(widgetCode=" + this.widgetCode + ", widgetId=" + this.widgetId + ", title=" + this.title + ", mode=" + this.mode + ", loadingMessages=" + this.loadingMessages + ')';
    }

    public PureShowWidgetPayload(String str, String str2, String str3, String str4, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "widgetCode");
        Intrinsics.checkNotNullParameter(list, "loadingMessages");
        this.widgetCode = str;
        this.widgetId = str2;
        this.title = str3;
        this.mode = str4;
        this.loadingMessages = list;
    }

    public final String getWidgetCode() {
        return this.widgetCode;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMode() {
        return this.mode;
    }

    public final List<String> getLoadingMessages() {
        return this.loadingMessages;
    }

    /* compiled from: PureShowWidgetInlineView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PureShowWidgetPayload from(ParsedToolCallInfo toolCallInfo) {
            String readString;
            String readString2;
            String readString3;
            String readString4;
            List readStringArray;
            Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
            JsonObject params = toolCallInfo.getParams();
            readString = PureShowWidgetInlineViewKt.readString(params, "widget_code");
            if (readString == null) {
                readString = "";
            }
            String str = readString;
            readString2 = PureShowWidgetInlineViewKt.readString(params, "widget_id");
            String id = readString2 == null ? toolCallInfo.getId() : readString2;
            readString3 = PureShowWidgetInlineViewKt.readString(params, "title");
            readString4 = PureShowWidgetInlineViewKt.readString(params, "mode");
            readStringArray = PureShowWidgetInlineViewKt.readStringArray(params, "loading_messages");
            return new PureShowWidgetPayload(str, id, readString3, readString4, readStringArray);
        }
    }
}
