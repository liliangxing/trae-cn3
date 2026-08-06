package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.IPrefetchV2Service;
import com.bytedance.ies.bullet.service.base.PrefetchV2Data;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrefetchV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/PrefetchV2Service;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/IPrefetchV2Service;", "()V", "getCacheBySchemeV2", "", "Lcom/bytedance/ies/bullet/service/base/PrefetchV2Data;", "scheme", "Landroid/net/Uri;", "identifierUrl", "", "memOnly", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", IFrontierMonitor.KEY_LOG, "", "message", ErrorType.PREFETCH, "schemaUri", "bid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PrefetchV2Service extends BaseBulletService implements IPrefetchV2Service {
    @Override // com.bytedance.ies.bullet.service.base.IPrefetchV2Service
    public void prefetch(Uri schemaUri, String bid, BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(schemaUri, "schemaUri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        if (PrefetchV2Kt.usePrefetchV2(bulletContext.getSchemaData())) {
            PrefetchV2.prefetchBySchemaUriInternal$anniex_release$default(PrefetchV2.INSTANCE, schemaUri, null, bid, bulletContext.getSchemaData(), bulletContext.getUriIdentifier(), bulletContext.getSessionId(), 2, null);
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchV2Service
    public Collection<PrefetchV2Data> getCacheBySchemeV2(Uri scheme, String identifierUrl, boolean memOnly, BulletContext bulletContext) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(bulletContext, "bulletContext");
        if (!PrefetchV2Kt.usePrefetchV2(bulletContext.getSchemaData())) {
            return CollectionsKt.emptyList();
        }
        PrefetchV2 prefetchV2 = PrefetchV2.INSTANCE;
        ISchemaData schemaData = bulletContext.getSchemaModelUnion().getSchemaData();
        String bid = bulletContext.getBid();
        if (bid == null) {
            bid = "default_bid";
        }
        List<PrefetchResult> cacheBySchemaUri = prefetchV2.getCacheBySchemaUri(scheme, identifierUrl, memOnly, schemaData, bid);
        ArrayList arrayList = new ArrayList();
        List<PrefetchResult> list = cacheBySchemaUri;
        if (list == null || list.isEmpty()) {
            return arrayList;
        }
        for (PrefetchResult prefetchResult : cacheBySchemaUri) {
            arrayList.add(new PrefetchV2Data(prefetchResult.getGlobalPropsName(), prefetchResult.getBody()));
        }
        return arrayList;
    }

    @Override // com.bytedance.ies.bullet.service.base.IPrefetchV2Service
    public void log(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        PrefetchLogger.INSTANCE.m38i(message);
    }
}
