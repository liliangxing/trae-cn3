package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.ISchemaMonitor;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UrlParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/UrlParser;", "", "()V", "generateDataWithConfig", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "url", "Landroid/net/Uri;", "interceptors", "", "Lcom/bytedance/ies/bullet/service/schema/ISchemaInterceptor;", "schemaMonitor", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "withOutMonitor", "", "parseQuery", "", "urlString", "parseQueryInLoop", "", "query", "schemaData", "Lcom/bytedance/ies/bullet/service/sdk/SchemaData;", "level", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UrlParser {
    public static /* synthetic */ ISchemaData generateDataWithConfig$default(UrlParser urlParser, Uri uri, List list, ISchemaMonitor iSchemaMonitor, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return urlParser.generateDataWithConfig(uri, list, iSchemaMonitor, z);
    }

    public final ISchemaData generateDataWithConfig(Uri url, List<? extends ISchemaInterceptor> interceptors, ISchemaMonitor schemaMonitor, boolean withOutMonitor) {
        Object obj;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        Intrinsics.checkNotNullParameter(schemaMonitor, "schemaMonitor");
        SchemaData schemaData = new SchemaData(url, schemaMonitor, withOutMonitor);
        schemaData.parseUrlBegin();
        String uri = url.toString();
        Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
        String str = uri;
        int indexOf$default = StringsKt.indexOf$default(str, "://", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            schemaData.parseUrlEnd(true);
            schemaData.log("invalid url");
            return schemaData;
        }
        int length = uri.length();
        String substring = uri.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        schemaData.setInnerScheme(substring);
        int i = indexOf$default + 3;
        String str2 = null;
        int indexOf$default2 = StringsKt.indexOf$default(str, '?', i, false, 4, (Object) null);
        if (indexOf$default2 == -1) {
            String substring2 = uri.substring(i, length);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            schemaData.setInnerPath(substring2);
            obj = null;
        } else {
            String substring3 = uri.substring(i, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            schemaData.setInnerPath(substring3);
            int i2 = indexOf$default2 + 1;
            obj = null;
            int indexOf$default3 = StringsKt.indexOf$default(str, '#', i2, false, 4, (Object) null);
            if (indexOf$default3 == -1) {
                str2 = uri.substring(i2, length);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                str2 = uri.substring(i2, indexOf$default3);
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring4 = uri.substring(indexOf$default3 + 1, length);
                Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                schemaData.setInnerFragment(substring4);
            }
        }
        if (str2 != null) {
            parseQueryInLoop(str2, schemaData, 0);
        }
        SchemaData.parseUrlEnd$default(schemaData, false, 1, obj);
        for (ISchemaInterceptor iSchemaInterceptor : interceptors) {
            schemaData.runInterceptorBegin(iSchemaInterceptor.getName());
            boolean convert = iSchemaInterceptor.convert(schemaData);
            schemaData.runInterceptorEnd(iSchemaInterceptor.getName());
            if (!convert) {
                schemaData.markConvertError(iSchemaInterceptor.getName(), iSchemaInterceptor.errorMessage());
                schemaData.log(iSchemaInterceptor.getName() + ':' + iSchemaInterceptor.errorMessage());
            }
        }
        if (!schemaData.getWithOutMonitor()) {
            schemaData.reportConvertResult();
        }
        return schemaData;
    }

    private final String parseQuery(String urlString) {
        int indexOf$default;
        String str = urlString;
        int indexOf$default2 = StringsKt.indexOf$default(str, "://", 0, false, 6, (Object) null);
        if (indexOf$default2 == -1 || (indexOf$default = StringsKt.indexOf$default(str, '?', indexOf$default2 + 3, false, 4, (Object) null)) == -1) {
            return null;
        }
        int i = indexOf$default + 1;
        int indexOf$default3 = StringsKt.indexOf$default(str, '#', i, false, 4, (Object) null);
        if (indexOf$default3 != -1) {
            if (urlString == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = urlString.substring(i, indexOf$default3);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }
        int length = urlString.length();
        if (urlString == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = urlString.substring(i, length);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008d, code lost:
    
        r6 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void parseQueryInLoop(String query, SchemaData schemaData, int level) {
        String parseQuery;
        Iterator it = StringsKt.split$default(query, new char[]{'&'}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            List split$default = StringsKt.split$default((String) it.next(), new char[]{'='}, false, 2, 2, (Object) null);
            if (split$default.size() == 2) {
                String decode = Uri.decode((String) split$default.get(0));
                String decode2 = Uri.decode((String) split$default.get(1));
                if (decode != null && decode2 != null) {
                    boolean z = IConditionCallKt.enableSchemaNotParseLoop() ? true : true;
                    if (z) {
                        schemaData.setStringValue(decode, decode2);
                    } else {
                        schemaData.setStringValue(decode, decode2, level);
                    }
                    if (z && !Intrinsics.areEqual(decode, SchemaConstants.QUERY_KEY_FALLBACK_URL) && (parseQuery = parseQuery(decode2)) != null) {
                        parseQueryInLoop(parseQuery, schemaData, level + 1);
                    }
                }
            }
        }
    }
}
