package com.bytedance.ies.bullet.service.base.utils;

import android.net.Uri;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletLoadUriIdentifier.kt */
@Deprecated(level = DeprecationLevel.WARNING, message = "not recommend", replaceWith = @ReplaceWith(expression = "BulletLoadUriIdentifier", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/BulletUriIdentifier;", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "realUri", "getIdentifierUrl", "", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletUriIdentifier extends Identifier {
    private final Uri realUri;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletUriIdentifier(Uri uri) {
        super(uri);
        Object obj;
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (!Intrinsics.areEqual(uri.getScheme(), "https") && !Intrinsics.areEqual(uri.getScheme(), "http")) {
            try {
                Result.Companion companion = Result.Companion;
                String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "url");
                obj = Result.constructor-impl(safeGetQueryParameter != null ? Uri.parse(safeGetQueryParameter) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            uri = (Uri) (Result.isFailure-impl(obj) ? null : obj);
        }
        this.realUri = uri;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.Identifier
    public String getIdentifierUrl() {
        Uri uri = this.realUri;
        if (uri == null) {
            return "";
        }
        if (Intrinsics.areEqual(uri.getAuthority(), "channel") && getKitType() == KitType.LYNX) {
            String cDN$default = ExtKt.getCDN$default(uri, null, 1, null);
            if (cDN$default != null) {
                uri = Uri.parse(cDN$default);
                Intrinsics.checkNotNullExpressionValue(uri, "parse(it)");
            }
            return ExtKt.removeQuery(uri);
        }
        String uri2 = new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "{\n                Uri.Bu….toString()\n            }");
        return uri2;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.Identifier
    public KitType getKitType() {
        Uri uri = this.realUri;
        String scheme = uri != null ? uri.getScheme() : null;
        if (scheme != null) {
            int hashCode = scheme.hashCode();
            if (hashCode != -1772600516) {
                if (hashCode != 3213448) {
                    if (hashCode == 99617003 && scheme.equals("https")) {
                        return KitType.WEB;
                    }
                } else if (scheme.equals("http")) {
                    return KitType.WEB;
                }
            } else if (scheme.equals("lynxview")) {
                return KitType.LYNX;
            }
        }
        return KitType.UNKNOWN;
    }
}
