package com.bytedance.ies.bullet.assembler.data;

import android.content.Context;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequest;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.prefetchv2.PrefetchV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostExternalStorageDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.storage.bridge.INativeStorageExtensionsKt;
import com.bytedance.sdk.xbridge.cn.storage.utils.INativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.IUserDomainNativeStorage;
import com.bytedance.sdk.xbridge.cn.storage.utils.NativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainNativeProviderFactory;
import com.bytedance.sdk.xbridge.cn.utils.RuntimeHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCenterService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/assembler/data/DataCenterService;", "", "()V", "clearNativeStorage", "", "context", "Landroid/content/Context;", "storageKeys", "", "", "bid", "clearPrefetchData", "prefetchUrls", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DataCenterService {
    public static final DataCenterService INSTANCE = new DataCenterService();

    private DataCenterService() {
    }

    public static /* synthetic */ void clearNativeStorage$default(DataCenterService dataCenterService, Context context, List list, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        dataCenterService.clearNativeStorage(context, list, str);
    }

    public final void clearNativeStorage(Context context, List<String> storageKeys, String bid) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageKeys, "storageKeys");
        HybridLogger.i$default(HybridLogger.INSTANCE, "XView", "clearNativeStorage called by business", null, null, 12, null);
        IHostExternalStorageDepend externalStorageDependInstance = RuntimeHelper.INSTANCE.getExternalStorageDependInstance();
        INativeStorage providerNativeStorage = NativeProviderFactory.providerNativeStorage(context);
        IHostUserDepend hostUserDepend = XBaseRuntime.INSTANCE.getHostUserDepend();
        String userId = hostUserDepend != null ? hostUserDepend.getUserId() : null;
        IUserDomainNativeStorage providerUserDomainNativeStorage = UserDomainNativeProviderFactory.providerUserDomainNativeStorage(context);
        for (String str : storageKeys) {
            if (externalStorageDependInstance != null) {
                externalStorageDependInstance.removeStorageValue(str);
            }
            INativeStorageExtensionsKt.tryRemoveBizStorageItem(providerNativeStorage, bid, str);
            String str2 = userId;
            if (!(str2 == null || str2.length() == 0)) {
                providerUserDomainNativeStorage.removeUserDomainStorageItem(userId, str);
            }
        }
    }

    public final void clearPrefetchData(List<String> prefetchUrls) {
        Intrinsics.checkNotNullParameter(prefetchUrls, "prefetchUrls");
        HybridLogger.i$default(HybridLogger.INSTANCE, "XView", "clearPrefetchData called by business", null, null, 12, null);
        Iterator<T> it = prefetchUrls.iterator();
        while (it.hasNext()) {
            PrefetchV2.INSTANCE.deleteCache$anniex_release(new PrefetchRequest((String) it.next(), PrefetchRequestConfig.METHOD_GET, null, null, null, false));
        }
    }
}
