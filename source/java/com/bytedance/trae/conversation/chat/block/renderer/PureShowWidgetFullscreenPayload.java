package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PureShowWidgetFullscreenActivity.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;", "", "widgetCode", "", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getWidgetCode", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PureShowWidgetFullscreenPayload {
    private final String title;
    private final String widgetCode;

    public static /* synthetic */ PureShowWidgetFullscreenPayload copy$default(PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pureShowWidgetFullscreenPayload.widgetCode;
        }
        if ((i & 2) != 0) {
            str2 = pureShowWidgetFullscreenPayload.title;
        }
        return pureShowWidgetFullscreenPayload.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getWidgetCode() {
        return this.widgetCode;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final PureShowWidgetFullscreenPayload copy(String widgetCode, String title) {
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        return new PureShowWidgetFullscreenPayload(widgetCode, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PureShowWidgetFullscreenPayload)) {
            return false;
        }
        PureShowWidgetFullscreenPayload pureShowWidgetFullscreenPayload = (PureShowWidgetFullscreenPayload) other;
        return Intrinsics.areEqual(this.widgetCode, pureShowWidgetFullscreenPayload.widgetCode) && Intrinsics.areEqual(this.title, pureShowWidgetFullscreenPayload.title);
    }

    public int hashCode() {
        int hashCode = this.widgetCode.hashCode() * 31;
        String str = this.title;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "PureShowWidgetFullscreenPayload(widgetCode=" + this.widgetCode + ", title=" + this.title + ')';
    }

    public PureShowWidgetFullscreenPayload(String widgetCode, String str) {
        Intrinsics.checkNotNullParameter(widgetCode, "widgetCode");
        this.widgetCode = widgetCode;
        this.title = str;
    }

    public final String getWidgetCode() {
        return this.widgetCode;
    }

    public final String getTitle() {
        return this.title;
    }
}
