package com.bytedance.trae.conversation.network;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ICustomActivityApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;", "", "data", "Lcom/bytedance/trae/conversation/network/GeneralActivityData;", "<init>", "(Lcom/bytedance/trae/conversation/network/GeneralActivityData;)V", "getData", "()Lcom/bytedance/trae/conversation/network/GeneralActivityData;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GeneralActivityResponse {

    @SerializedName("data")
    private final GeneralActivityData data;

    /* JADX WARN: Multi-variable type inference failed */
    public GeneralActivityResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GeneralActivityResponse copy$default(GeneralActivityResponse generalActivityResponse, GeneralActivityData generalActivityData, int i, Object obj) {
        if ((i & 1) != 0) {
            generalActivityData = generalActivityResponse.data;
        }
        return generalActivityResponse.copy(generalActivityData);
    }

    /* renamed from: component1, reason: from getter */
    public final GeneralActivityData getData() {
        return this.data;
    }

    public final GeneralActivityResponse copy(GeneralActivityData data) {
        return new GeneralActivityResponse(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GeneralActivityResponse) && Intrinsics.areEqual(this.data, ((GeneralActivityResponse) other).data);
    }

    public int hashCode() {
        GeneralActivityData generalActivityData = this.data;
        if (generalActivityData == null) {
            return 0;
        }
        return generalActivityData.hashCode();
    }

    public String toString() {
        return "GeneralActivityResponse(data=" + this.data + ')';
    }

    public GeneralActivityResponse(GeneralActivityData generalActivityData) {
        this.data = generalActivityData;
    }

    public /* synthetic */ GeneralActivityResponse(GeneralActivityData generalActivityData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : generalActivityData);
    }

    public final GeneralActivityData getData() {
        return this.data;
    }
}
