package com.bytedance.android.anniex.lite;

import android.content.Context;
import android.net.Uri;
import android.util.LruCache;
import bolts.Task;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.api.AnnieXLiteForestInterceptor;
import com.bytedance.android.anniex.web.api.AnnieXLiteGlobalPropsInterceptor;
import com.bytedance.android.anniex.web.api.AnnieXWebApi;
import com.bytedance.android.anniex.web.api.AnnieXWebModelBuilder;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.bytedance.ies.bullet.service.sdk.SchemaConfig;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXProcessCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\u0005J\u001e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J \u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0005J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/lite/AnnieXProcessCenter;", "", "()V", "schemaDataLruCache", "Landroid/util/LruCache;", "", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "webModelLruCache", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "createWebModel", "bid", "sessionId", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "getOrCreateEnginView", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "context", "Landroid/content/Context;", "getOrCreateSchemaData", "getOrCreateWebModel", "preCreateWebModel", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXProcessCenter {
    public static final AnnieXProcessCenter INSTANCE = new AnnieXProcessCenter();
    private static final LruCache<String, AnnieXWebModel> webModelLruCache = new LruCache<>(10);
    private static final LruCache<String, SchemaModelUnion> schemaDataLruCache = new LruCache<>(10);

    private AnnieXProcessCenter() {
    }

    public static /* synthetic */ AnnieXWebKit getOrCreateEnginView$default(AnnieXProcessCenter annieXProcessCenter, Context context, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "default_bid";
        }
        return annieXProcessCenter.getOrCreateEnginView(context, str);
    }

    public final AnnieXWebKit getOrCreateEnginView(Context context, String bid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bid, "bid");
        return AnnieXWebApi.INSTANCE.createWebView(context, bid);
    }

    public final SchemaModelUnion getOrCreateSchemaData(String bid, Uri schema, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        LruCache<String, SchemaModelUnion> lruCache = schemaDataLruCache;
        SchemaModelUnion schemaModelUnion = lruCache.get(sessionId);
        if (schemaModelUnion != null) {
            return schemaModelUnion;
        }
        SchemaService companion = SchemaService.Companion.getInstance();
        SchemaConfig schemaConfig = new SchemaConfig();
        schemaConfig.addInterceptor(new AnnieXLiteGlobalPropsInterceptor(bid));
        schemaConfig.addInterceptor(new AnnieXLiteForestInterceptor());
        Unit unit = Unit.INSTANCE;
        companion.bindConfig(schema, schemaConfig);
        SchemaModelUnion schemaModelUnion2 = new SchemaModelUnion(SchemaService.Companion.getInstance().generateSchemaData(bid, schema, true));
        lruCache.put(sessionId, schemaModelUnion2);
        MonitorManager monitorManager = MonitorManager.INSTANCE;
        String str = (String) schemaModelUnion2.getSchemaData().getQueryItems().get(StreamTrafficObservable.STREAM_URL);
        if (str == null) {
            str = schema.toString();
            Intrinsics.checkNotNullExpressionValue(str, "schema.toString()");
        }
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(this.schemaData.qu…_URL]?:schema.toString())");
        monitorManager.updateUriIdentifier(sessionId, parse);
        return schemaModelUnion2;
    }

    public static /* synthetic */ AnnieXWebModel getOrCreateWebModel$default(AnnieXProcessCenter annieXProcessCenter, String str, Uri uri, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return annieXProcessCenter.getOrCreateWebModel(str, uri, str2);
    }

    public final AnnieXWebModel getOrCreateWebModel(String bid, Uri schema, String sessionId) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        AnnieXWebModel annieXWebModel = webModelLruCache.get(sessionId);
        return annieXWebModel == null ? createWebModel(bid, sessionId, schema) : annieXWebModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AnnieXWebModel createWebModel(String bid, String sessionId, Uri schema) {
        MonitorManager.INSTANCE.onWebModelCreateBegin(bid, sessionId, null);
        AnnieXWebModel build$anniex_release$default = AnnieXWebModelBuilder.build$anniex_release$default(new AnnieXWebModelBuilder(null, bid, null, 5, null), sessionId, schema, getOrCreateSchemaData(bid, schema, sessionId), true, true, null, false, false, null, 480, null);
        webModelLruCache.put(sessionId, build$anniex_release$default);
        return build$anniex_release$default;
    }

    public final void preCreateWebModel(final String bid, final String sessionId, final Uri schema) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        if (webModelLruCache.get(sessionId) != null) {
            return;
        }
        Task.callInBackground(new Callable() { // from class: com.bytedance.android.anniex.lite.AnnieXProcessCenter$preCreateWebModel$1
            @Override // java.util.concurrent.Callable
            public final AnnieXWebModel call() {
                AnnieXWebModel createWebModel;
                LruCache lruCache;
                LruCache lruCache2;
                createWebModel = AnnieXProcessCenter.INSTANCE.createWebModel(bid, sessionId, schema);
                lruCache = AnnieXProcessCenter.schemaDataLruCache;
                lruCache.put(sessionId, createWebModel.getSchemaModelUnion());
                lruCache2 = AnnieXProcessCenter.webModelLruCache;
                return (AnnieXWebModel) lruCache2.put(sessionId, createWebModel);
            }
        });
    }
}
