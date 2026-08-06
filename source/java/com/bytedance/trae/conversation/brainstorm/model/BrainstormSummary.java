package com.bytedance.trae.conversation.brainstorm.model;

import com.bytedance.forest.model.PreloadConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormSummary.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003JG\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormSummary;", "", "title", "", "keyPoints", "", "actionItems", "duration", "messageCount", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;I)V", "getTitle", "()Ljava/lang/String;", "getKeyPoints", "()Ljava/util/List;", "getActionItems", "getDuration", "getMessageCount", "()I", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BrainstormSummary {
    private final List<String> actionItems;
    private final String duration;
    private final List<String> keyPoints;
    private final int messageCount;
    private final String title;

    public static /* synthetic */ BrainstormSummary copy$default(BrainstormSummary brainstormSummary, String str, List list, List list2, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = brainstormSummary.title;
        }
        if ((i2 & 2) != 0) {
            list = brainstormSummary.keyPoints;
        }
        List list3 = list;
        if ((i2 & 4) != 0) {
            list2 = brainstormSummary.actionItems;
        }
        List list4 = list2;
        if ((i2 & 8) != 0) {
            str2 = brainstormSummary.duration;
        }
        String str3 = str2;
        if ((i2 & 16) != 0) {
            i = brainstormSummary.messageCount;
        }
        return brainstormSummary.copy(str, list3, list4, str3, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final List<String> component2() {
        return this.keyPoints;
    }

    public final List<String> component3() {
        return this.actionItems;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMessageCount() {
        return this.messageCount;
    }

    public final BrainstormSummary copy(String title, List<String> keyPoints, List<String> actionItems, String duration, int messageCount) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(keyPoints, "keyPoints");
        Intrinsics.checkNotNullParameter(actionItems, "actionItems");
        Intrinsics.checkNotNullParameter(duration, "duration");
        return new BrainstormSummary(title, keyPoints, actionItems, duration, messageCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrainstormSummary)) {
            return false;
        }
        BrainstormSummary brainstormSummary = (BrainstormSummary) other;
        return Intrinsics.areEqual(this.title, brainstormSummary.title) && Intrinsics.areEqual(this.keyPoints, brainstormSummary.keyPoints) && Intrinsics.areEqual(this.actionItems, brainstormSummary.actionItems) && Intrinsics.areEqual(this.duration, brainstormSummary.duration) && this.messageCount == brainstormSummary.messageCount;
    }

    public int hashCode() {
        return (((((((this.title.hashCode() * 31) + this.keyPoints.hashCode()) * 31) + this.actionItems.hashCode()) * 31) + this.duration.hashCode()) * 31) + Integer.hashCode(this.messageCount);
    }

    public String toString() {
        return "BrainstormSummary(title=" + this.title + ", keyPoints=" + this.keyPoints + ", actionItems=" + this.actionItems + ", duration=" + this.duration + ", messageCount=" + this.messageCount + ')';
    }

    public BrainstormSummary(String title, List<String> keyPoints, List<String> actionItems, String duration, int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(keyPoints, "keyPoints");
        Intrinsics.checkNotNullParameter(actionItems, "actionItems");
        Intrinsics.checkNotNullParameter(duration, "duration");
        this.title = title;
        this.keyPoints = keyPoints;
        this.actionItems = actionItems;
        this.duration = duration;
        this.messageCount = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<String> getKeyPoints() {
        return this.keyPoints;
    }

    public final List<String> getActionItems() {
        return this.actionItems;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final int getMessageCount() {
        return this.messageCount;
    }
}
