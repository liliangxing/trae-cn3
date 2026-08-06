package com.bytedance.android.anniex.detect;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.base.utils.Identifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXBlankDetectorManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/anniex/detect/BlankDetectorItemConfig;", "", "bdhmBid", "", "urlBase", "identifier", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "originUri", "Landroid/net/Uri;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/utils/Identifier;Landroid/net/Uri;)V", "getBdhmBid", "()Ljava/lang/String;", "getIdentifier", "()Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "getOriginUri", "()Landroid/net/Uri;", "getUrlBase", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BlankDetectorItemConfig {
    private final String bdhmBid;
    private final Identifier identifier;
    private final Uri originUri;
    private final String urlBase;

    public static /* synthetic */ BlankDetectorItemConfig copy$default(BlankDetectorItemConfig blankDetectorItemConfig, String str, String str2, Identifier identifier, Uri uri, int i, Object obj) {
        if ((i & 1) != 0) {
            str = blankDetectorItemConfig.bdhmBid;
        }
        if ((i & 2) != 0) {
            str2 = blankDetectorItemConfig.urlBase;
        }
        if ((i & 4) != 0) {
            identifier = blankDetectorItemConfig.identifier;
        }
        if ((i & 8) != 0) {
            uri = blankDetectorItemConfig.originUri;
        }
        return blankDetectorItemConfig.copy(str, str2, identifier, uri);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBdhmBid() {
        return this.bdhmBid;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrlBase() {
        return this.urlBase;
    }

    /* renamed from: component3, reason: from getter */
    public final Identifier getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component4, reason: from getter */
    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final BlankDetectorItemConfig copy(String bdhmBid, String urlBase, Identifier identifier, Uri originUri) {
        Intrinsics.checkNotNullParameter(bdhmBid, "bdhmBid");
        Intrinsics.checkNotNullParameter(urlBase, "urlBase");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(originUri, "originUri");
        return new BlankDetectorItemConfig(bdhmBid, urlBase, identifier, originUri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlankDetectorItemConfig)) {
            return false;
        }
        BlankDetectorItemConfig blankDetectorItemConfig = (BlankDetectorItemConfig) other;
        return Intrinsics.areEqual(this.bdhmBid, blankDetectorItemConfig.bdhmBid) && Intrinsics.areEqual(this.urlBase, blankDetectorItemConfig.urlBase) && Intrinsics.areEqual(this.identifier, blankDetectorItemConfig.identifier) && Intrinsics.areEqual(this.originUri, blankDetectorItemConfig.originUri);
    }

    public int hashCode() {
        return (((((this.bdhmBid.hashCode() * 31) + this.urlBase.hashCode()) * 31) + this.identifier.hashCode()) * 31) + this.originUri.hashCode();
    }

    public BlankDetectorItemConfig(String bdhmBid, String urlBase, Identifier identifier, Uri originUri) {
        Intrinsics.checkNotNullParameter(bdhmBid, "bdhmBid");
        Intrinsics.checkNotNullParameter(urlBase, "urlBase");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(originUri, "originUri");
        this.bdhmBid = bdhmBid;
        this.urlBase = urlBase;
        this.identifier = identifier;
        this.originUri = originUri;
    }

    public final String getBdhmBid() {
        return this.bdhmBid;
    }

    public final Identifier getIdentifier() {
        return this.identifier;
    }

    public final Uri getOriginUri() {
        return this.originUri;
    }

    public final String getUrlBase() {
        return this.urlBase;
    }

    public String toString() {
        return "BlankDetectorItemConfig bdhmBid=" + this.bdhmBid + ", urlBase=" + this.urlBase;
    }
}
