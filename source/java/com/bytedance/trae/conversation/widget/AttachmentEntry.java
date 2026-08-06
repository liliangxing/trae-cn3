package com.bytedance.trae.conversation.widget;

import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.conversation.widget.ChatAttachmentDialog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatAttachmentConfig.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012b\u0010\b\u001a^\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003Je\u0010 \u001a^\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0003J\u0097\u0001\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052d\b\u0002\u0010\b\u001a^\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\tHÆ\u0001J\u0013\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018Rm\u0010\b\u001a^\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/trae/conversation/widget/AttachmentEntry;", "", DBData.FIELD_TYPE, "Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;", "viewIdRes", "", "iconRes", "labelRes", "isVisible", "Lkotlin/Function4;", "Lcom/bytedance/trae/conversation/widget/ChatMode;", "Lkotlin/ParameterName;", "name", "mode", "", "isLocal", "isIde", "", "ideVersion", "<init>", "(Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;IIILkotlin/jvm/functions/Function4;)V", "getType", "()Lcom/bytedance/trae/conversation/widget/ChatAttachmentDialog$AttachmentType;", "getViewIdRes", "()I", "getIconRes", "getLabelRes", "()Lkotlin/jvm/functions/Function4;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class AttachmentEntry {
    private final int iconRes;
    private final Function4<ChatMode, Boolean, Boolean, String, Boolean> isVisible;
    private final int labelRes;
    private final ChatAttachmentDialog.AttachmentType type;
    private final int viewIdRes;

    public static /* synthetic */ AttachmentEntry copy$default(AttachmentEntry attachmentEntry, ChatAttachmentDialog.AttachmentType attachmentType, int i, int i2, int i3, Function4 function4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            attachmentType = attachmentEntry.type;
        }
        if ((i4 & 2) != 0) {
            i = attachmentEntry.viewIdRes;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = attachmentEntry.iconRes;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = attachmentEntry.labelRes;
        }
        int i7 = i3;
        if ((i4 & 16) != 0) {
            function4 = attachmentEntry.isVisible;
        }
        return attachmentEntry.copy(attachmentType, i5, i6, i7, function4);
    }

    /* renamed from: component1, reason: from getter */
    public final ChatAttachmentDialog.AttachmentType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final int getViewIdRes() {
        return this.viewIdRes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLabelRes() {
        return this.labelRes;
    }

    public final Function4<ChatMode, Boolean, Boolean, String, Boolean> component5() {
        return this.isVisible;
    }

    public final AttachmentEntry copy(ChatAttachmentDialog.AttachmentType type, int viewIdRes, int iconRes, int labelRes, Function4<? super ChatMode, ? super Boolean, ? super Boolean, ? super String, Boolean> isVisible) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(isVisible, "isVisible");
        return new AttachmentEntry(type, viewIdRes, iconRes, labelRes, isVisible);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttachmentEntry)) {
            return false;
        }
        AttachmentEntry attachmentEntry = (AttachmentEntry) other;
        return this.type == attachmentEntry.type && this.viewIdRes == attachmentEntry.viewIdRes && this.iconRes == attachmentEntry.iconRes && this.labelRes == attachmentEntry.labelRes && Intrinsics.areEqual(this.isVisible, attachmentEntry.isVisible);
    }

    public int hashCode() {
        return (((((((this.type.hashCode() * 31) + Integer.hashCode(this.viewIdRes)) * 31) + Integer.hashCode(this.iconRes)) * 31) + Integer.hashCode(this.labelRes)) * 31) + this.isVisible.hashCode();
    }

    public String toString() {
        return "AttachmentEntry(type=" + this.type + ", viewIdRes=" + this.viewIdRes + ", iconRes=" + this.iconRes + ", labelRes=" + this.labelRes + ", isVisible=" + this.isVisible + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AttachmentEntry(ChatAttachmentDialog.AttachmentType attachmentType, int i, int i2, int i3, Function4<? super ChatMode, ? super Boolean, ? super Boolean, ? super String, Boolean> function4) {
        Intrinsics.checkNotNullParameter(attachmentType, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(function4, "isVisible");
        this.type = attachmentType;
        this.viewIdRes = i;
        this.iconRes = i2;
        this.labelRes = i3;
        this.isVisible = function4;
    }

    public final ChatAttachmentDialog.AttachmentType getType() {
        return this.type;
    }

    public final int getViewIdRes() {
        return this.viewIdRes;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final Function4<ChatMode, Boolean, Boolean, String, Boolean> isVisible() {
        return this.isVisible;
    }
}
