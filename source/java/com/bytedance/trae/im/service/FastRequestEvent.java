package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J8\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/im/service/FastRequestEvent;", "", "type", "", "buttons", "", "Lcom/bytedance/trae/im/service/FastRequestButton;", "refunded", "", "<init>", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;)V", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getButtons", "()Ljava/util/List;", "getRefunded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/FastRequestEvent;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FastRequestEvent {

    @SerializedName("buttons")
    private final List<FastRequestButton> buttons;

    @SerializedName("refunded")
    private final Boolean refunded;

    @SerializedName("type")
    private Integer type;

    public FastRequestEvent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FastRequestEvent copy$default(FastRequestEvent fastRequestEvent, Integer num, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = fastRequestEvent.type;
        }
        if ((i & 2) != 0) {
            list = fastRequestEvent.buttons;
        }
        if ((i & 4) != 0) {
            bool = fastRequestEvent.refunded;
        }
        return fastRequestEvent.copy(num, list, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getType() {
        return this.type;
    }

    public final List<FastRequestButton> component2() {
        return this.buttons;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getRefunded() {
        return this.refunded;
    }

    public final FastRequestEvent copy(Integer type, List<FastRequestButton> buttons, Boolean refunded) {
        return new FastRequestEvent(type, buttons, refunded);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FastRequestEvent)) {
            return false;
        }
        FastRequestEvent fastRequestEvent = (FastRequestEvent) other;
        return Intrinsics.areEqual(this.type, fastRequestEvent.type) && Intrinsics.areEqual(this.buttons, fastRequestEvent.buttons) && Intrinsics.areEqual(this.refunded, fastRequestEvent.refunded);
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<FastRequestButton> list = this.buttons;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.refunded;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "FastRequestEvent(type=" + this.type + ", buttons=" + this.buttons + ", refunded=" + this.refunded + ')';
    }

    public FastRequestEvent(Integer num, List<FastRequestButton> list, Boolean bool) {
        this.type = num;
        this.buttons = list;
        this.refunded = bool;
    }

    public /* synthetic */ FastRequestEvent(Integer num, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool);
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final List<FastRequestButton> getButtons() {
        return this.buttons;
    }

    public final Boolean getRefunded() {
        return this.refunded;
    }
}
