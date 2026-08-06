package com.bytedance.trae.conversation.brainstorm.adapter;

import com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HistorySubtitleAdapter.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J,\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"com/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged", "", "ts", "", "kindRank", "", "item", "Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "<init>", "(JILcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)V", "getTs", "()J", "getKindRank", "()I", "getItem", "()Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;", "component1", "component2", "component3", "copy", "(JILcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;)Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged;", "equals", "", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged {
    private final HistorySubtitleAdapter.SubtitleItem item;
    private final int kindRank;
    private final long ts;

    public static /* synthetic */ HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged copy$default(HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged historySubtitleAdapter$seedHistoryWithAttachments$Tagged, long j, int i, HistorySubtitleAdapter.SubtitleItem subtitleItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = historySubtitleAdapter$seedHistoryWithAttachments$Tagged.ts;
        }
        if ((i2 & 2) != 0) {
            i = historySubtitleAdapter$seedHistoryWithAttachments$Tagged.kindRank;
        }
        if ((i2 & 4) != 0) {
            subtitleItem = historySubtitleAdapter$seedHistoryWithAttachments$Tagged.item;
        }
        return historySubtitleAdapter$seedHistoryWithAttachments$Tagged.copy(j, i, subtitleItem);
    }

    /* renamed from: component1, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    /* renamed from: component2, reason: from getter */
    public final int getKindRank() {
        return this.kindRank;
    }

    /* renamed from: component3, reason: from getter */
    public final HistorySubtitleAdapter.SubtitleItem getItem() {
        return this.item;
    }

    public final HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged copy(long ts, int kindRank, HistorySubtitleAdapter.SubtitleItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return new HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged(ts, kindRank, item);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged)) {
            return false;
        }
        HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged historySubtitleAdapter$seedHistoryWithAttachments$Tagged = (HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged) other;
        return this.ts == historySubtitleAdapter$seedHistoryWithAttachments$Tagged.ts && this.kindRank == historySubtitleAdapter$seedHistoryWithAttachments$Tagged.kindRank && Intrinsics.areEqual(this.item, historySubtitleAdapter$seedHistoryWithAttachments$Tagged.item);
    }

    public int hashCode() {
        return (((Long.hashCode(this.ts) * 31) + Integer.hashCode(this.kindRank)) * 31) + this.item.hashCode();
    }

    public String toString() {
        return "Tagged(ts=" + this.ts + ", kindRank=" + this.kindRank + ", item=" + this.item + ')';
    }

    public HistorySubtitleAdapter$seedHistoryWithAttachments$Tagged(long j, int i, HistorySubtitleAdapter.SubtitleItem subtitleItem) {
        Intrinsics.checkNotNullParameter(subtitleItem, "item");
        this.ts = j;
        this.kindRank = i;
        this.item = subtitleItem;
    }

    public final HistorySubtitleAdapter.SubtitleItem getItem() {
        return this.item;
    }

    public final int getKindRank() {
        return this.kindRank;
    }

    public final long getTs() {
        return this.ts;
    }
}
