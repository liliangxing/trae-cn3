package com.bytedance.android.anniex.web.api;

import android.net.Uri;
import androidx.webkit.ProxyConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.schema.model.BDXWebKitModel;
import com.bytedance.ies.bullet.service.sdk.param.BooleanParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebModelBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\f\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u00020\u0006¨\u0006\b"}, d2 = {"isCompactMode", "", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "getIdentifierUrl", "", "Landroid/net/Uri;", "getSubUrl", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebModelBuilderKt {
    public static final boolean isCompactMode(SchemaModelUnion schemaModelUnion) {
        BooleanParam compactMode;
        Boolean bool;
        ISchemaModel kitModel = schemaModelUnion != null ? schemaModelUnion.getKitModel() : null;
        BDXWebKitModel bDXWebKitModel = kitModel instanceof BDXWebKitModel ? (BDXWebKitModel) kitModel : null;
        if (bDXWebKitModel == null || (compactMode = bDXWebKitModel.getCompactMode()) == null || (bool = (Boolean) compactMode.getValue()) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public static final String getSubUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), ProxyConfig.MATCH_HTTPS)) {
            return uri.toString();
        }
        String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "a_surl");
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "surl");
        return safeGetQueryParameter2 == null ? ExtKt.safeGetQueryParameter(uri, StreamTrafficObservable.STREAM_URL) : safeGetQueryParameter2;
    }

    public static final String getIdentifierUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String subUrl = getSubUrl(uri);
        if (subUrl == null) {
            subUrl = "";
        }
        String str = subUrl;
        if (str.length() == 0) {
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(uri, "channel");
            String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "bundle");
            String str2 = safeGetQueryParameter;
            if (!(str2 == null || str2.length() == 0)) {
                String str3 = safeGetQueryParameter2;
                if (!(str3 == null || str3.length() == 0)) {
                    return safeGetQueryParameter + '_' + safeGetQueryParameter2;
                }
            }
            if (!(str.length() == 0)) {
                return subUrl;
            }
            String uri2 = uri.toString();
            Intrinsics.checkNotNullExpressionValue(uri2, "this.toString()");
            return uri2;
        }
        String builder = Uri.parse(subUrl).buildUpon().clearQuery().toString();
        Intrinsics.checkNotNullExpressionValue(builder, "parse(result).buildUpon().clearQuery().toString()");
        return builder;
    }
}
