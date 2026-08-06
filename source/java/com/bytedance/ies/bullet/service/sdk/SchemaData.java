package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.service.schema.IParam;
import com.bytedance.ies.bullet.service.schema.ISchemaMonitor;
import com.bytedance.ies.bullet.service.schema.ISchemaMutableData;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaMonitorEvent;
import com.bytedance.ies.bullet.service.sdk.param.StringListParam;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SchemaData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 _2\u00020\u0001:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ \u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0007H\u0016J\u0010\u0010I\u001a\u00020D2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u0006\u0010J\u001a\u00020DJ\u000e\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020\fJ\u0010\u0010M\u001a\u0004\u0018\u00010\f2\u0006\u0010E\u001a\u00020\fJ\b\u0010N\u001a\u00020\u0007H\u0016J\u000e\u0010O\u001a\u00020D2\u0006\u0010P\u001a\u00020\fJ\u0016\u0010Q\u001a\u00020D2\u0006\u0010L\u001a\u00020\f2\u0006\u0010P\u001a\u00020\fJ\u0016\u0010R\u001a\u00020D2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fJ\u0006\u0010S\u001a\u00020DJ\u0010\u0010T\u001a\u00020D2\b\b\u0002\u0010U\u001a\u00020\u0007J\u0010\u0010V\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0016J\u0006\u0010W\u001a\u00020DJ\u000e\u0010X\u001a\u00020D2\u0006\u0010L\u001a\u00020\fJ\u000e\u0010Y\u001a\u00020D2\u0006\u0010L\u001a\u00020\fJ\u0010\u0010Z\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010[\u001a\u00020D2\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u0010\\\u001a\u00020D2\u0006\u0010;\u001a\u00020\fH\u0016J\u0016\u0010]\u001a\u00020D2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fJ\u001e\u0010]\u001a\u00020D2\u0006\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\f2\u0006\u0010^\u001a\u00020\u0014R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u001c\u0010%\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010*\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010(R\u001c\u0010-\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\"\"\u0004\b/\u0010(R\u0014\u00100\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00103\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001fR\u0016\u00106\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\"R\"\u00108\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010;\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010\"R\u0014\u0010=\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u00102R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006`"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/SchemaData;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMutableData;", "uri", "Landroid/net/Uri;", "schemaMonitor", "Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;", "withOutMonitor", "", "(Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;Z)V", "(Landroid/net/Uri;Lcom/bytedance/ies/bullet/service/schema/ISchemaMonitor;)V", "_convertTimeStamp", "", "", "", "_errorConverters", "_errorValues", "_generateTimeStamp", "_innerBundle", "Landroid/os/Bundle;", "_levelData", "", "_schemaInfo", "", "_sourceData", SchemaConstants.QUERY_KEY_BUNDLE, "getBundle", "()Landroid/os/Bundle;", "convertEndTimeStamp", "getConvertEndTimeStamp", "()J", "setConvertEndTimeStamp", "(J)V", "fragment", "getFragment", "()Ljava/lang/String;", "host", "getHost", "innerFragment", "getInnerFragment", "setInnerFragment", "(Ljava/lang/String;)V", "innerOriginUrl", "innerPath", "getInnerPath", "setInnerPath", "innerScheme", "getInnerScheme", "setInnerScheme", "originUrl", "getOriginUrl", "()Landroid/net/Uri;", "parseTimeStamp", "getParseTimeStamp", "setParseTimeStamp", "path", "getPath", "queryItems", "getQueryItems", "()Ljava/util/Map;", "scheme", "getScheme", "url", "getUrl", "getWithOutMonitor", "()Z", "setWithOutMonitor", "(Z)V", "addParam", "", "key", "value", "Lcom/bytedance/ies/bullet/service/schema/IParam;", "cover", "appendBundle", "generateModelBegin", "generateModelEnd", "name", "getStringValue", "isWeb", IFrontierMonitor.KEY_LOG, "message", "markConvertError", "markValueError", "parseUrlBegin", "parseUrlEnd", "error", "removeParam", "reportConvertResult", "runInterceptorBegin", "runInterceptorEnd", "setOriginUrl", "setPath", "setScheme", "setStringValue", "level", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SchemaData implements ISchemaMutableData {
    private static final String PATH_REACTNATIVE = "reactnative";
    private static final String PATH_WEBVIEW = "webview";
    private static final String SCHEME_HTTP = "http";
    private static final String SCHEME_HTTPS = "https";
    private Map<String, Long> _convertTimeStamp;
    private Map<String, String> _errorConverters;
    private Map<String, String> _errorValues;
    private long _generateTimeStamp;
    private Bundle _innerBundle;
    private Map<String, Integer> _levelData;
    private final Map<String, String> _schemaInfo;
    private Map<String, String> _sourceData;
    private long convertEndTimeStamp;
    private String innerFragment;
    private Uri innerOriginUrl;
    private String innerPath;
    private String innerScheme;
    private long parseTimeStamp;
    private final ISchemaMonitor schemaMonitor;
    private boolean withOutMonitor;

    public SchemaData(Uri uri, ISchemaMonitor iSchemaMonitor) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(iSchemaMonitor, "schemaMonitor");
        this.schemaMonitor = iSchemaMonitor;
        this.innerOriginUrl = uri;
        this._schemaInfo = MapsKt.mapOf(TuplesKt.to("schema", uri.toString()));
        this._convertTimeStamp = new LinkedHashMap();
        this._errorConverters = new LinkedHashMap();
        this._errorValues = new LinkedHashMap();
        this._levelData = new LinkedHashMap();
        this._sourceData = new LinkedHashMap();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SchemaData(Uri uri, ISchemaMonitor iSchemaMonitor, boolean z) {
        this(uri, iSchemaMonitor);
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(iSchemaMonitor, "schemaMonitor");
        this.withOutMonitor = z;
    }

    public final String getInnerScheme() {
        return this.innerScheme;
    }

    public final void setInnerScheme(String str) {
        this.innerScheme = str;
    }

    public final String getInnerPath() {
        return this.innerPath;
    }

    public final void setInnerPath(String str) {
        this.innerPath = str;
    }

    public final String getInnerFragment() {
        return this.innerFragment;
    }

    public final void setInnerFragment(String str) {
        this.innerFragment = str;
    }

    public final boolean getWithOutMonitor() {
        return this.withOutMonitor;
    }

    public final void setWithOutMonitor(boolean z) {
        this.withOutMonitor = z;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public long getParseTimeStamp() {
        return this.parseTimeStamp;
    }

    public void setParseTimeStamp(long j) {
        this.parseTimeStamp = j;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public long getConvertEndTimeStamp() {
        return this.convertEndTimeStamp;
    }

    public void setConvertEndTimeStamp(long j) {
        this.convertEndTimeStamp = j;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    /* renamed from: getBundle, reason: from getter */
    public Bundle get_innerBundle() {
        return this._innerBundle;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    /* renamed from: getOriginUrl, reason: from getter */
    public Uri getInnerOriginUrl() {
        return this.innerOriginUrl;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public String getScheme() {
        return this.innerScheme;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public String getHost() {
        String str = this.innerPath;
        if (str == null) {
            return null;
        }
        int indexOf$default = StringsKt.indexOf$default(str, "/", 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return str;
        }
        String substring = str.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public String getPath() {
        return this.innerPath;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public Map<String, String> getQueryItems() {
        return this._sourceData;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    /* renamed from: getFragment, reason: from getter */
    public String getInnerFragment() {
        return this.innerFragment;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public Uri getUrl() {
        Uri uri;
        String str = this.innerScheme;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str).append("://").append(this.innerPath);
            boolean z = true;
            if (!this._sourceData.isEmpty()) {
                sb.append('?');
                for (Map.Entry<String, String> entry : this._sourceData.entrySet()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append('&');
                    }
                    sb.append(entry.getKey()).append('=').append(Uri.encode(entry.getValue()));
                }
            }
            String str2 = this.innerFragment;
            if (str2 != null) {
                sb.append('#').append(str2);
            }
            uri = Uri.parse(sb.toString());
        } else {
            uri = null;
        }
        if (uri != null) {
            return uri;
        }
        Uri uri2 = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri2, "EMPTY");
        return uri2;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaData
    public boolean isWeb() {
        if (Intrinsics.areEqual(this.innerScheme, "http") || Intrinsics.areEqual(this.innerScheme, "https")) {
            return true;
        }
        String str = this.innerPath;
        if (str != null && StringsKt.contains$default(str, PATH_REACTNATIVE, false, 2, (Object) null)) {
            return true;
        }
        String str2 = this.innerPath;
        return str2 != null && StringsKt.contains$default(str2, "webview", false, 2, (Object) null);
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void appendBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, SchemaConstants.QUERY_KEY_BUNDLE);
        Bundle bundle2 = this._innerBundle;
        if (bundle2 == null) {
            this._innerBundle = bundle;
        } else if (bundle2 != null) {
            bundle2.putAll(bundle);
        }
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void addParam(String key, IParam value, boolean cover) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (cover || this._sourceData.get(key) == null) {
            this._sourceData.put(key, value.valueToString());
        }
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void removeParam(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this._sourceData.remove(key);
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void setOriginUrl(Uri uri) {
        String substring;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        String str = uri2;
        int indexOf$default = StringsKt.indexOf$default(str, '?', 0, false, 6, (Object) null);
        if (indexOf$default == -1) {
            return;
        }
        int i = indexOf$default + 1;
        int indexOf$default2 = StringsKt.indexOf$default(str, '#', i, false, 4, (Object) null);
        if (indexOf$default2 == -1) {
            substring = uri2.substring(i, uri2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        } else {
            substring = uri2.substring(i, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        }
        Iterator it = StringsKt.split$default(substring, new char[]{'&'}, false, 0, 6, (Object) null).iterator();
        while (it.hasNext()) {
            List split$default = StringsKt.split$default((String) it.next(), new char[]{'='}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                String decode = Uri.decode((String) split$default.get(0));
                String decode2 = Uri.decode((String) split$default.get(1));
                if (decode != null && decode2 != null && this._sourceData.get(decode) == null) {
                    this._sourceData.put(decode, decode2);
                }
            }
        }
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void setScheme(String scheme) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        this.innerScheme = scheme;
    }

    @Override // com.bytedance.ies.bullet.service.schema.ISchemaMutableData
    public void setPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.innerPath = path;
    }

    public final String getStringValue(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this._sourceData.get(key);
    }

    public final void setStringValue(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (this._sourceData.get(key) == null) {
            this._sourceData.put(key, value);
        }
    }

    public final void setStringValue(String key, String value, int level) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Integer num = this._levelData.get(key);
        if (num == null || num.intValue() < level) {
            this._levelData.put(key, Integer.valueOf(level));
            this._sourceData.put(key, value);
        }
    }

    public final void parseUrlBegin() {
        setParseTimeStamp(System.currentTimeMillis());
    }

    public static /* synthetic */ void parseUrlEnd$default(SchemaData schemaData, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        schemaData.parseUrlEnd(z);
    }

    public final void parseUrlEnd(boolean error) {
        this._convertTimeStamp.put("parse_duration", Long.valueOf(System.currentTimeMillis() - getParseTimeStamp()));
        if (error) {
            this._errorConverters.put("parse_error", "invalid url");
            reportConvertResult();
        }
    }

    public final void markConvertError(String name, String message) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(message, "message");
        this._errorConverters.put(name, message);
    }

    public final void runInterceptorBegin(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this._convertTimeStamp.put(name, Long.valueOf(System.currentTimeMillis()));
    }

    public final void runInterceptorEnd(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Long l = this._convertTimeStamp.get(name);
        if (l != null) {
            this._convertTimeStamp.put(name, Long.valueOf(System.currentTimeMillis() - l.longValue()));
        }
    }

    public final void reportConvertResult() {
        Map<String, String> mapOf;
        setConvertEndTimeStamp(System.currentTimeMillis());
        if (this._errorConverters.isEmpty()) {
            mapOf = null;
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : this._errorConverters.entrySet()) {
                sb.append(entry.getKey()).append(StringListParam.SPLIT_DELIMITER);
                sb2.append(entry.getValue()).append(StringListParam.SPLIT_DELIMITER);
            }
            mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_converter_names", sb.toString()), TuplesKt.to("error_converter_msg", sb2.toString())});
        }
        this.schemaMonitor.report(SchemaMonitorEvent.CONVERT, this, this._schemaInfo, mapOf, this._convertTimeStamp);
        this._errorConverters.clear();
        this._convertTimeStamp.clear();
    }

    public final void markValueError(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this._errorValues.put(key, value);
    }

    public final void generateModelBegin() {
        this._generateTimeStamp = System.currentTimeMillis();
    }

    public final void generateModelEnd(String name) {
        Map<String, String> mapOf;
        Intrinsics.checkNotNullParameter(name, "name");
        long currentTimeMillis = System.currentTimeMillis() - this._generateTimeStamp;
        Map<String, String> plus = MapsKt.plus(this._schemaInfo, MapsKt.mapOf(TuplesKt.to("model_name", name)));
        if (this._errorValues.isEmpty()) {
            mapOf = null;
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : this._errorValues.entrySet()) {
                sb.append(entry.getKey()).append(StringListParam.SPLIT_DELIMITER);
                sb2.append(entry.getValue()).append(StringListParam.SPLIT_DELIMITER);
            }
            mapOf = MapsKt.mapOf(new Pair[]{TuplesKt.to("error_param_names", sb.toString()), TuplesKt.to("error_param_msg", sb2.toString())});
        }
        Map<String, String> map = mapOf;
        if (!this.withOutMonitor) {
            this.schemaMonitor.report(SchemaMonitorEvent.GENERATE, this, plus, map, MapsKt.mapOf(TuplesKt.to(LynxTimingPerformanceReportProcessor.KEY_DURATION, Long.valueOf(currentTimeMillis))));
        }
        this._errorValues.clear();
    }

    public final void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.schemaMonitor.log(message);
    }
}
