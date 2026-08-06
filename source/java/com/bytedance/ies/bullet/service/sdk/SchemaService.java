package com.bytedance.ies.bullet.service.sdk;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.schema.ISchemaInterceptor;
import com.bytedance.ies.bullet.service.schema.ISchemaModel;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SchemaService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\bJ\"\u0010\u0018\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u0012J \u0010\u001a\u001a\u00020\u001b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\tJ/\u0010\u001c\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\f2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u001d0!¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010%R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/SchemaService;", "", "()V", "_configForBid", "", "", "Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;", "_configForUrl", "Landroid/net/Uri;", "Lcom/bytedance/ies/bullet/service/sdk/SchemaConfig;", "_schemaDataCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", "_schemaMonitor", "Lcom/bytedance/ies/bullet/service/sdk/DefaultSchemaMonitor;", "_urlParser", "Lcom/bytedance/ies/bullet/service/sdk/UrlParser;", "bindConfig", "", "url", "schemaConfig", "bid", "globalSchemaConfig", "containsConfig", "generateSchemaData", "withOutMonitor", "generateSchemaDataInCache", "", "generateSchemaModel", "T", "Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "schemaData", "type", "Ljava/lang/Class;", "(Lcom/bytedance/ies/bullet/service/schema/ISchemaData;Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/schema/ISchemaModel;", "getSchemaDataFromCache", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SchemaService {
    public static final String DEFAULT_BID = "default_bid";
    private Map<String, GlobalSchemaConfig> _configForBid;
    private Map<Uri, SchemaConfig> _configForUrl;
    private ConcurrentHashMap<Uri, ISchemaData> _schemaDataCache;
    private final DefaultSchemaMonitor _schemaMonitor;
    private final UrlParser _urlParser;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<SchemaService> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SchemaService>() { // from class: com.bytedance.ies.bullet.service.sdk.SchemaService$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SchemaService m587invoke() {
            return new SchemaService(null);
        }
    });

    public /* synthetic */ SchemaService(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: SchemaService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/sdk/SchemaService$Companion;", "", "()V", "DEFAULT_BID", "", "instance", "Lcom/bytedance/ies/bullet/service/sdk/SchemaService;", "getInstance", "()Lcom/bytedance/ies/bullet/service/sdk/SchemaService;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SchemaService getInstance() {
            return (SchemaService) SchemaService.instance$delegate.getValue();
        }
    }

    private SchemaService() {
        this._schemaMonitor = new DefaultSchemaMonitor();
        this._urlParser = new UrlParser();
        this._configForBid = new LinkedHashMap();
        this._configForUrl = new LinkedHashMap();
        this._schemaDataCache = new ConcurrentHashMap<>();
    }

    public final boolean containsConfig(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        return this._configForBid.containsKey(bid);
    }

    public final boolean bindConfig(String bid, GlobalSchemaConfig globalSchemaConfig) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(globalSchemaConfig, "globalSchemaConfig");
        if (this._configForBid.containsKey(bid)) {
            return false;
        }
        this._configForBid.put(bid, globalSchemaConfig);
        return true;
    }

    public final boolean bindConfig(Uri url, SchemaConfig schemaConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(schemaConfig, "schemaConfig");
        if (Intrinsics.areEqual(url, Uri.EMPTY)) {
            return false;
        }
        SchemaConfig schemaConfig2 = this._configForUrl.get(url);
        if (schemaConfig2 != null) {
            schemaConfig2.addInterceptors(schemaConfig.getInterceptors());
            return false;
        }
        this._configForUrl.put(url, schemaConfig);
        return true;
    }

    public final ISchemaData generateSchemaData(String bid, Uri url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return generateSchemaData(bid, url, false);
    }

    public static /* synthetic */ ISchemaData generateSchemaData$default(SchemaService schemaService, String str, Uri uri, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return schemaService.generateSchemaData(str, uri, z);
    }

    public final ISchemaData generateSchemaData(String bid, Uri url, boolean withOutMonitor) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (Intrinsics.areEqual(url, Uri.EMPTY)) {
            return new SchemaData(url, this._schemaMonitor, withOutMonitor);
        }
        ArrayList arrayList = new ArrayList();
        SchemaConfig remove = this._configForUrl.remove(url);
        if (remove != null) {
            arrayList.addAll(remove.getInterceptors());
        }
        DefaultSchemaMonitor defaultSchemaMonitor = null;
        if (bid != null) {
            GlobalSchemaConfig globalSchemaConfig = this._configForBid.get(bid);
            if (globalSchemaConfig == null) {
                globalSchemaConfig = this._configForBid.get("default_bid");
            }
            if (globalSchemaConfig != null) {
                defaultSchemaMonitor = globalSchemaConfig.getMonitor();
                arrayList.addAll(globalSchemaConfig.getInterceptors());
            }
        }
        UrlParser urlParser = this._urlParser;
        if (defaultSchemaMonitor == null) {
            defaultSchemaMonitor = this._schemaMonitor;
        }
        return urlParser.generateDataWithConfig(url, arrayList, defaultSchemaMonitor, withOutMonitor);
    }

    public final void generateSchemaDataInCache(String bid, Uri url, SchemaConfig schemaConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(schemaConfig, "schemaConfig");
        DefaultSchemaMonitor defaultSchemaMonitor = null;
        if (bid != null) {
            GlobalSchemaConfig globalSchemaConfig = this._configForBid.get(bid);
            if (globalSchemaConfig == null) {
                globalSchemaConfig = this._configForBid.get("default_bid");
            }
            if (globalSchemaConfig != null) {
                defaultSchemaMonitor = globalSchemaConfig.getMonitor();
                schemaConfig.addInterceptors(globalSchemaConfig.getInterceptors());
            }
        }
        ConcurrentHashMap<Uri, ISchemaData> concurrentHashMap = this._schemaDataCache;
        UrlParser urlParser = this._urlParser;
        List<ISchemaInterceptor> interceptors = schemaConfig.getInterceptors();
        if (defaultSchemaMonitor == null) {
            defaultSchemaMonitor = this._schemaMonitor;
        }
        concurrentHashMap.put(url, UrlParser.generateDataWithConfig$default(urlParser, url, interceptors, defaultSchemaMonitor, false, 8, null));
    }

    public final ISchemaData getSchemaDataFromCache(Uri url, Bundle bundle) {
        Intrinsics.checkNotNullParameter(url, "url");
        ISchemaData remove = this._schemaDataCache.remove(url);
        if (bundle != null) {
            SchemaData schemaData = remove instanceof SchemaData ? (SchemaData) remove : null;
            if (schemaData != null && schemaData.get_innerBundle() == null) {
                schemaData.appendBundle(bundle);
            }
        }
        return remove;
    }

    public final <T extends ISchemaModel> T generateSchemaModel(ISchemaData schemaData, Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(schemaData, "schemaData");
        Intrinsics.checkNotNullParameter(type, "type");
        if (!ISchemaModel.class.isAssignableFrom(type)) {
            return null;
        }
        try {
            SchemaData schemaData2 = (SchemaData) schemaData;
            schemaData2.generateModelBegin();
            T newInstance = type.newInstance();
            newInstance.initWithData(schemaData);
            String simpleName = type.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "type.simpleName");
            schemaData2.generateModelEnd(simpleName);
            return newInstance;
        } catch (Exception unused) {
            return null;
        }
    }
}
