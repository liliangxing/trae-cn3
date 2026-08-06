package com.bytedance.trae.conversation.voice.subtask;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubTaskProtocol.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/voice/subtask/SubTaskTypeEnvelope;", "", "type", "", "<init>", "(Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final /* data */ class SubTaskTypeEnvelope {

    @SerializedName("type")
    private final String type;

    /* JADX WARN: Multi-variable type inference failed */
    public SubTaskTypeEnvelope() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SubTaskTypeEnvelope copy$default(SubTaskTypeEnvelope subTaskTypeEnvelope, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subTaskTypeEnvelope.type;
        }
        return subTaskTypeEnvelope.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final SubTaskTypeEnvelope copy(String type) {
        return new SubTaskTypeEnvelope(type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SubTaskTypeEnvelope) && Intrinsics.areEqual(this.type, ((SubTaskTypeEnvelope) other).type);
    }

    public int hashCode() {
        String str = this.type;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return "SubTaskTypeEnvelope(type=" + this.type + ')';
    }

    public SubTaskTypeEnvelope(String str) {
        this.type = str;
    }

    public /* synthetic */ SubTaskTypeEnvelope(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public final String getType() {
        return this.type;
    }
}
