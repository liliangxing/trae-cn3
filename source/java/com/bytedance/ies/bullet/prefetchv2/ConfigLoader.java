package com.bytedance.ies.bullet.prefetchv2;

import android.net.Uri;
import kotlin.Metadata;

/* compiled from: ConfigLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/prefetchv2/ConfigLoader;", "", "loadConfig", "Lcom/bytedance/ies/bullet/prefetchv2/PrefetchConfig;", "pageUri", "Landroid/net/Uri;", "bid", "", "identifierUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ConfigLoader {
    PrefetchConfig loadConfig(Uri pageUri, String bid, String identifierUrl);

    /* compiled from: ConfigLoader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ PrefetchConfig loadConfig$default(ConfigLoader configLoader, Uri uri, String str, String str2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadConfig");
            }
            if ((i & 2) != 0) {
                str = "default_bid";
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return configLoader.loadConfig(uri, str, str2);
        }
    }
}
