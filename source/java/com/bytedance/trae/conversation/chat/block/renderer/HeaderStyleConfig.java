package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleMarkdownTextView.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0010\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "", "sizesSp", "", "", "", "color", "<init>", "(Ljava/util/Map;Ljava/lang/Integer;)V", "getSizesSp", "()Ljava/util/Map;", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/util/Map;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HeaderStyleConfig {
    private final Integer color;
    private final Map<Integer, Float> sizesSp;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HeaderStyleConfig copy$default(HeaderStyleConfig headerStyleConfig, Map map, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            map = headerStyleConfig.sizesSp;
        }
        if ((i & 2) != 0) {
            num = headerStyleConfig.color;
        }
        return headerStyleConfig.copy(map, num);
    }

    public final Map<Integer, Float> component1() {
        return this.sizesSp;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getColor() {
        return this.color;
    }

    public final HeaderStyleConfig copy(Map<Integer, Float> sizesSp, Integer color) {
        return new HeaderStyleConfig(sizesSp, color);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HeaderStyleConfig)) {
            return false;
        }
        HeaderStyleConfig headerStyleConfig = (HeaderStyleConfig) other;
        return Intrinsics.areEqual(this.sizesSp, headerStyleConfig.sizesSp) && Intrinsics.areEqual(this.color, headerStyleConfig.color);
    }

    public int hashCode() {
        Map<Integer, Float> map = this.sizesSp;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Integer num = this.color;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "HeaderStyleConfig(sizesSp=" + this.sizesSp + ", color=" + this.color + ')';
    }

    public HeaderStyleConfig(Map<Integer, Float> map, Integer num) {
        this.sizesSp = map;
        this.color = num;
    }

    public final Map<Integer, Float> getSizesSp() {
        return this.sizesSp;
    }

    public final Integer getColor() {
        return this.color;
    }
}
