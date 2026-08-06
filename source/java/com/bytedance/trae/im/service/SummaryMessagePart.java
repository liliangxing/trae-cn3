package com.bytedance.trae.im.service;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICreateAgentTask.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/service/SummaryMessagePart;", "", DBData.FIELD_TYPE, "", "data", "Lcom/bytedance/trae/im/service/SummaryMessageData;", "<init>", "(Ljava/lang/String;Lcom/bytedance/trae/im/service/SummaryMessageData;)V", ReportConstant.COMMON_CONTENT, "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getData", "()Lcom/bytedance/trae/im/service/SummaryMessageData;", "toJsonArray", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SummaryMessagePart {

    @SerializedName("data")
    private final SummaryMessageData data;

    @SerializedName(DBData.FIELD_TYPE)
    private final String type;

    public static /* synthetic */ SummaryMessagePart copy$default(SummaryMessagePart summaryMessagePart, String str, SummaryMessageData summaryMessageData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = summaryMessagePart.type;
        }
        if ((i & 2) != 0) {
            summaryMessageData = summaryMessagePart.data;
        }
        return summaryMessagePart.copy(str, summaryMessageData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final SummaryMessageData getData() {
        return this.data;
    }

    public final SummaryMessagePart copy(String type, SummaryMessageData data) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(data, "data");
        return new SummaryMessagePart(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SummaryMessagePart)) {
            return false;
        }
        SummaryMessagePart summaryMessagePart = (SummaryMessagePart) other;
        return Intrinsics.areEqual(this.type, summaryMessagePart.type) && Intrinsics.areEqual(this.data, summaryMessagePart.data);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.data.hashCode();
    }

    public String toString() {
        return "SummaryMessagePart(type=" + this.type + ", data=" + this.data + ')';
    }

    public SummaryMessagePart(String str, SummaryMessageData summaryMessageData) {
        Intrinsics.checkNotNullParameter(str, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(summaryMessageData, "data");
        this.type = str;
        this.data = summaryMessageData;
    }

    public /* synthetic */ SummaryMessagePart(String str, SummaryMessageData summaryMessageData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "text" : str, summaryMessageData);
    }

    public final String getType() {
        return this.type;
    }

    public final SummaryMessageData getData() {
        return this.data;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SummaryMessagePart(String str) {
        this(r1, new SummaryMessageData(str), 1, r1);
        Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
        String str2 = null;
    }

    public final String toJsonArray() {
        String json = new Gson().toJson(CollectionsKt.listOf(this));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }
}
