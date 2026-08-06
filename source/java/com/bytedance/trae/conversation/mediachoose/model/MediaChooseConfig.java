package com.bytedance.trae.conversation.mediachoose.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MediaChooseConfig.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\rHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0007HÆ\u0001J\u0006\u0010+\u001a\u00020\u0003J\u0013\u0010,\u001a\u00020\u00072\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\rHÖ\u0001J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;", "Landroid/os/Parcelable;", "maxSelectCount", "", "mediaType", "Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;", "singleVideo", "", "showCamera", "enablePreview", "showOrigin", "keepOriginDefault", "actionText", "", "columnCount", "showSingleSelector", "<init>", "(ILcom/bytedance/trae/conversation/mediachoose/model/MediaType;ZZZZZLjava/lang/String;IZ)V", "getMaxSelectCount", "()I", "getMediaType", "()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;", "getSingleVideo", "()Z", "getShowCamera", "getEnablePreview", "getShowOrigin", "getKeepOriginDefault", "getActionText", "()Ljava/lang/String;", "getColumnCount", "getShowSingleSelector", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "describeContents", "equals", PreloadConfig.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", RouterConstants.QUERY_KEY_FLAGS, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MediaChooseConfig implements Parcelable {
    public static final Parcelable.Creator<MediaChooseConfig> CREATOR = new Creator();
    private final String actionText;
    private final int columnCount;
    private final boolean enablePreview;
    private final boolean keepOriginDefault;
    private final int maxSelectCount;
    private final MediaType mediaType;
    private final boolean showCamera;
    private final boolean showOrigin;
    private final boolean showSingleSelector;
    private final boolean singleVideo;

    /* compiled from: MediaChooseConfig.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Creator implements Parcelable.Creator<MediaChooseConfig> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaChooseConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MediaChooseConfig(parcel.readInt(), MediaType.valueOf(parcel.readString()), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MediaChooseConfig[] newArray(int i) {
            return new MediaChooseConfig[i];
        }
    }

    public MediaChooseConfig() {
        this(0, null, false, false, false, false, false, null, 0, false, 1023, null);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getShowSingleSelector() {
        return this.showSingleSelector;
    }

    /* renamed from: component2, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSingleVideo() {
        return this.singleVideo;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShowCamera() {
        return this.showCamera;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getEnablePreview() {
        return this.enablePreview;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getShowOrigin() {
        return this.showOrigin;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getKeepOriginDefault() {
        return this.keepOriginDefault;
    }

    /* renamed from: component8, reason: from getter */
    public final String getActionText() {
        return this.actionText;
    }

    /* renamed from: component9, reason: from getter */
    public final int getColumnCount() {
        return this.columnCount;
    }

    public final MediaChooseConfig copy(int maxSelectCount, MediaType mediaType, boolean singleVideo, boolean showCamera, boolean enablePreview, boolean showOrigin, boolean keepOriginDefault, String actionText, int columnCount, boolean showSingleSelector) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        return new MediaChooseConfig(maxSelectCount, mediaType, singleVideo, showCamera, enablePreview, showOrigin, keepOriginDefault, actionText, columnCount, showSingleSelector);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaChooseConfig)) {
            return false;
        }
        MediaChooseConfig mediaChooseConfig = (MediaChooseConfig) other;
        return this.maxSelectCount == mediaChooseConfig.maxSelectCount && this.mediaType == mediaChooseConfig.mediaType && this.singleVideo == mediaChooseConfig.singleVideo && this.showCamera == mediaChooseConfig.showCamera && this.enablePreview == mediaChooseConfig.enablePreview && this.showOrigin == mediaChooseConfig.showOrigin && this.keepOriginDefault == mediaChooseConfig.keepOriginDefault && Intrinsics.areEqual(this.actionText, mediaChooseConfig.actionText) && this.columnCount == mediaChooseConfig.columnCount && this.showSingleSelector == mediaChooseConfig.showSingleSelector;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.maxSelectCount) * 31) + this.mediaType.hashCode()) * 31) + Boolean.hashCode(this.singleVideo)) * 31) + Boolean.hashCode(this.showCamera)) * 31) + Boolean.hashCode(this.enablePreview)) * 31) + Boolean.hashCode(this.showOrigin)) * 31) + Boolean.hashCode(this.keepOriginDefault)) * 31) + this.actionText.hashCode()) * 31) + Integer.hashCode(this.columnCount)) * 31) + Boolean.hashCode(this.showSingleSelector);
    }

    public String toString() {
        return "MediaChooseConfig(maxSelectCount=" + this.maxSelectCount + ", mediaType=" + this.mediaType + ", singleVideo=" + this.singleVideo + ", showCamera=" + this.showCamera + ", enablePreview=" + this.enablePreview + ", showOrigin=" + this.showOrigin + ", keepOriginDefault=" + this.keepOriginDefault + ", actionText=" + this.actionText + ", columnCount=" + this.columnCount + ", showSingleSelector=" + this.showSingleSelector + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.maxSelectCount);
        dest.writeString(this.mediaType.name());
        dest.writeInt(this.singleVideo ? 1 : 0);
        dest.writeInt(this.showCamera ? 1 : 0);
        dest.writeInt(this.enablePreview ? 1 : 0);
        dest.writeInt(this.showOrigin ? 1 : 0);
        dest.writeInt(this.keepOriginDefault ? 1 : 0);
        dest.writeString(this.actionText);
        dest.writeInt(this.columnCount);
        dest.writeInt(this.showSingleSelector ? 1 : 0);
    }

    public MediaChooseConfig(int i, MediaType mediaType, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String actionText, int i2, boolean z6) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        this.maxSelectCount = i;
        this.mediaType = mediaType;
        this.singleVideo = z;
        this.showCamera = z2;
        this.enablePreview = z3;
        this.showOrigin = z4;
        this.keepOriginDefault = z5;
        this.actionText = actionText;
        this.columnCount = i2;
        this.showSingleSelector = z6;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public /* synthetic */ MediaChooseConfig(int i, MediaType mediaType, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, int i2, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 5 : i, (i3 & 2) != 0 ? MediaType.IMAGE : mediaType, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? true : z3, (i3 & 32) == 0 ? z4 : true, (i3 & 64) != 0 ? false : z5, (i3 & 128) != 0 ? "" : str, (i3 & 256) != 0 ? 3 : i2, (i3 & 512) == 0 ? z6 : false);
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final boolean getSingleVideo() {
        return this.singleVideo;
    }

    public final boolean getShowCamera() {
        return this.showCamera;
    }

    public final boolean getEnablePreview() {
        return this.enablePreview;
    }

    public final boolean getShowOrigin() {
        return this.showOrigin;
    }

    public final boolean getKeepOriginDefault() {
        return this.keepOriginDefault;
    }

    public final String getActionText() {
        return this.actionText;
    }

    public final int getColumnCount() {
        return this.columnCount;
    }

    public final boolean getShowSingleSelector() {
        return this.showSingleSelector;
    }
}
