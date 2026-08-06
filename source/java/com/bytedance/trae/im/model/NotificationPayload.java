package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/im/model/NotificationPayload;", "", "event", "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getEvent", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NotificationPayload {

    @SerializedName("data")
    @JsonAdapter(NullSafeJsonObjectAdapter.class)
    private final JsonObject data;

    @SerializedName("event")
    private final String event;

    /* JADX WARN: Multi-variable type inference failed */
    public NotificationPayload() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NotificationPayload copy$default(NotificationPayload notificationPayload, String str, JsonObject jsonObject, int i, Object obj) {
        if ((i & 1) != 0) {
            str = notificationPayload.event;
        }
        if ((i & 2) != 0) {
            jsonObject = notificationPayload.data;
        }
        return notificationPayload.copy(str, jsonObject);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEvent() {
        return this.event;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonObject getData() {
        return this.data;
    }

    public final NotificationPayload copy(String event, JsonObject data) {
        return new NotificationPayload(event, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationPayload)) {
            return false;
        }
        NotificationPayload notificationPayload = (NotificationPayload) other;
        return Intrinsics.areEqual(this.event, notificationPayload.event) && Intrinsics.areEqual(this.data, notificationPayload.data);
    }

    public int hashCode() {
        String str = this.event;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        JsonObject jsonObject = this.data;
        return hashCode + (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    public String toString() {
        return "NotificationPayload(event=" + this.event + ", data=" + this.data + ')';
    }

    public NotificationPayload(String str, JsonObject jsonObject) {
        this.event = str;
        this.data = jsonObject;
    }

    public /* synthetic */ NotificationPayload(String str, JsonObject jsonObject, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : jsonObject);
    }

    public final String getEvent() {
        return this.event;
    }

    public final JsonObject getData() {
        return this.data;
    }
}
