package com.bytedance.ies.bullet.service.base.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.push.interfaze.IPushService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletLoadUriIdentifier.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/utils/BulletLoadUriIdentifier;", "Lcom/bytedance/ies/bullet/service/base/utils/Identifier;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "getIdentifierUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletLoadUriIdentifier extends Identifier {
    private String sessionId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BulletLoadUriIdentifier(Uri uri) {
        super(uri);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.sessionId = "";
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final void setSessionId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.Identifier
    public String getIdentifierUrl() {
        String str;
        try {
            if (getKitType() == KitType.LYNX && Intrinsics.areEqual(getUri().getAuthority(), "channel")) {
                Uri uri = getUri();
                String cDN$default = ExtKt.getCDN$default(getUri(), null, 1, null);
                if (cDN$default != null) {
                    uri = Uri.parse(cDN$default);
                    Intrinsics.checkNotNullExpressionValue(uri, "parse(it)");
                }
                str = ExtKt.removeQuery(uri);
            } else {
                if (!Intrinsics.areEqual(getUri().getScheme(), "sslocal") && !Intrinsics.areEqual(getUri().getScheme(), "aweme")) {
                    str = new Uri.Builder().scheme(getUri().getScheme()).authority(getUri().getAuthority()).path(getUri().getPath()).build().toString();
                    Intrinsics.checkNotNullExpressionValue(str, "{\n                // lyn….toString()\n            }");
                }
                str = getUri().toString();
                Intrinsics.checkNotNullExpressionValue(str, "{\n                // awe….toString()\n            }");
            }
        } catch (Exception e) {
            BulletLogger.INSTANCE.printReject(e, "BulletLoadUriIdentifier schema", IPushService.TAG_PUSH_MONITOR);
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String uri2 = getUri().toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return uri2;
    }

    @Override // com.bytedance.ies.bullet.service.base.utils.Identifier
    public KitType getKitType() {
        String scheme = getUri().getScheme();
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
