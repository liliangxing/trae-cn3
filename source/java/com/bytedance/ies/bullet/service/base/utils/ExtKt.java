package com.bytedance.ies.bullet.service.base.utils;

import android.net.Uri;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.UrlParam;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* compiled from: Ext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000\u001a0\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\n\"\u0006\b\u0001\u0010\t\u0018\u0001*\u0002H\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH\u0086\b¢\u0006\u0002\u0010\r\u001a\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001\u001a\u001e\u0010\u000f\u001a\u00020\u0010*\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0003\u001a\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0018*\u00020\u0001¢\u0006\u0002\u0010\u0019\u001a\u001a\u0010\u001a\u001a\u00020\u0010*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bH\u0000¨\u0006\u001c"}, d2 = {"generateIdentifierBySchemaUri", "", "uri", "Landroid/net/Uri;", "bid", "getFileString", "ins", "Ljava/io/InputStream;", "castTo", "R", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;", "getCDN", "merge", "Lorg/json/JSONObject;", "other", "override", "", "removeQuery", "safeGetQueryParameter", "key", "safeToLong", "", "(Ljava/lang/String;)Ljava/lang/Long;", "toJSONObject", "", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ExtKt {
    public static final String getFileString(InputStream inputStream) {
        if (inputStream == null) {
            return "";
        }
        try {
            return new String(ByteStreamsKt.readBytes(inputStream), Charsets.UTF_8);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static final JSONObject toJSONObject(Map<String, String> map) {
        if (map == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static /* synthetic */ String generateIdentifierBySchemaUri$default(Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        return generateIdentifierBySchemaUri(uri, str);
    }

    public static final String generateIdentifierBySchemaUri(Uri uri, String str) {
        String identifierUrl;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(str, "bid");
        Uri value = new UrlParam(SchemaService.INSTANCE.getInstance().generateSchemaData(str, uri), "url", null).getValue();
        if (value != null && (identifierUrl = new BulletLoadUriIdentifier(value).getIdentifierUrl()) != null) {
            return identifierUrl;
        }
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        return uri2;
    }

    public static final String safeGetQueryParameter(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        try {
            return uri.getQueryParameter(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String removeQuery(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String builder = uri.buildUpon().clearQuery().toString();
        Intrinsics.checkNotNullExpressionValue(builder, "this.buildUpon().clearQuery().toString()");
        return builder;
    }

    public static /* synthetic */ String getCDN$default(Uri uri, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return getCDN(uri, str);
    }

    public static final String getCDN(Uri uri, String str) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(str, "bid");
        if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https")) {
            return uri.toString();
        }
        String safeGetQueryParameter = safeGetQueryParameter(uri, "a_surl");
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = safeGetQueryParameter(uri, SchemaConstants.QUERY_KEY_SURL);
        return safeGetQueryParameter2 == null ? safeGetQueryParameter(uri, "url") : safeGetQueryParameter2;
    }

    public static final Long safeToLong(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() == 0) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T, R> R castTo(T t, Class<R> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.reifiedOperationMarker(3, "R");
        if (t instanceof Object) {
            return t;
        }
        return null;
    }

    public static /* synthetic */ JSONObject merge$default(JSONObject jSONObject, JSONObject jSONObject2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return merge(jSONObject, jSONObject2, z);
    }

    public static final JSONObject merge(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "other.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject.has(next) || z) {
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
        }
        return jSONObject;
    }
}
