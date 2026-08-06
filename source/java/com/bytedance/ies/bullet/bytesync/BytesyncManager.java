package com.bytedance.ies.bullet.bytesync;

import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.sync.SyncBiz;
import com.bytedance.sync.SyncSDK;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BytesyncManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\bR)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\fj\b\u0012\u0004\u0012\u00020\u0005`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/bytesync/BytesyncManager;", "", "()V", "bulletContainerMap", "", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "getBulletContainerMap", "()Ljava/util/Map;", "businessIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "registerBusiness", "", "businessId", "bulletContainer", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytesyncManager {
    public static final BytesyncManager INSTANCE = new BytesyncManager();
    private static final ArrayList<Long> businessIds = new ArrayList<>();
    private static final Map<Long, List<WeakReference<IBulletContainer>>> bulletContainerMap = new LinkedHashMap();

    private BytesyncManager() {
    }

    public final Map<Long, List<WeakReference<IBulletContainer>>> getBulletContainerMap() {
        return bulletContainerMap;
    }

    public final void registerBusiness(long businessId, IBulletContainer bulletContainer) {
        List<WeakReference<IBulletContainer>> list;
        Intrinsics.checkNotNullParameter(bulletContainer, "bulletContainer");
        Map<Long, List<WeakReference<IBulletContainer>>> map = bulletContainerMap;
        if (map.get(Long.valueOf(businessId)) == null) {
            Long valueOf = Long.valueOf(businessId);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeakReference<>(bulletContainer));
            map.put(valueOf, arrayList);
        } else {
            List<WeakReference<IBulletContainer>> list2 = map.get(Long.valueOf(businessId));
            Object obj = null;
            if (list2 != null) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(((WeakReference) next).get(), bulletContainer)) {
                        obj = next;
                        break;
                    }
                }
                obj = (WeakReference) obj;
            }
            if (obj == null && (list = bulletContainerMap.get(Long.valueOf(businessId))) != null) {
                list.add(new WeakReference<>(bulletContainer));
            }
        }
        ArrayList<Long> arrayList2 = businessIds;
        if (arrayList2.contains(Long.valueOf(businessId))) {
            return;
        }
        SyncSDK.registerBusiness(new SyncBiz.Builder(businessId).addOnUpdateListener(new OnDataUpdateListenerImpl(businessId)).build());
        arrayList2.add(Long.valueOf(businessId));
    }
}
