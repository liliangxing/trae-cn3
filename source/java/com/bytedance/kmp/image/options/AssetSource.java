package com.bytedance.kmp.image.options;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.kmp.image.options.KImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImageSource.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\u0006\u0010\u000b\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/kmp/image/options/AssetSource;", "Lcom/bytedance/kmp/image/options/KImageSource;", "uri", "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "", "getFileUri", "getType", "", "hashCode", "toString", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AssetSource implements KImageSource {
    public static final int $stable = 0;
    private final String uri;

    /* renamed from: component1, reason: from getter */
    private final String getUri() {
        return this.uri;
    }

    public static /* synthetic */ AssetSource copy$default(AssetSource assetSource, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assetSource.uri;
        }
        return assetSource.copy(str);
    }

    public final AssetSource copy(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return new AssetSource(uri);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AssetSource) && Intrinsics.areEqual(this.uri, ((AssetSource) other).uri);
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public int getType() {
        return 3;
    }

    public int hashCode() {
        return this.uri.hashCode();
    }

    public String toString() {
        return "AssetSource(uri=" + this.uri + ')';
    }

    public AssetSource(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
    }

    @Override // com.bytedance.kmp.image.options.KImageSource
    public boolean isLocalSource() {
        return KImageSource.DefaultImpls.isLocalSource(this);
    }

    public final String getFileUri() {
        return this.uri;
    }
}
