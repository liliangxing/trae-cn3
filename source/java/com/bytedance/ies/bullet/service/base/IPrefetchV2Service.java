package com.bytedance.ies.bullet.service.base;

import android.net.Uri;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Collection;
import kotlin.Metadata;

/* compiled from: IPrefetchV2Service.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH&J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IPrefetchV2Service;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getCacheBySchemeV2", "", "Lcom/bytedance/ies/bullet/service/base/PrefetchV2Data;", "scheme", "Landroid/net/Uri;", "identifierUrl", "", "memOnly", "", "bulletContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "log", "", "message", ErrorType.PREFETCH, "schemaUri", "bid", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IPrefetchV2Service extends IBulletService {
    Collection<PrefetchV2Data> getCacheBySchemeV2(Uri scheme, String identifierUrl, boolean memOnly, BulletContext bulletContext);

    void log(String message);

    void prefetch(Uri schemaUri, String bid, BulletContext bulletContext);

    /* compiled from: IPrefetchV2Service.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void prefetch$default(IPrefetchV2Service iPrefetchV2Service, Uri uri, String str, BulletContext bulletContext, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: prefetch");
            }
            if ((i & 2) != 0) {
                str = "default_bid";
            }
            iPrefetchV2Service.prefetch(uri, str, bulletContext);
        }
    }
}
