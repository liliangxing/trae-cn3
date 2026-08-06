package com.bytedance.iesgurd;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IESGurdObserver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/iesgurd/IESGurdObserver;", "", "onResAccess", "", "info", "Lcom/bytedance/iesgurd/IESGurdObserverAccessInfo;", "onResClean", "Lcom/bytedance/iesgurd/IESGurdObserverCleanInfo;", "onResUpdate", "Lcom/bytedance/iesgurd/IESGurdObserverUpdateInfo;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public interface IESGurdObserver {

    /* compiled from: IESGurdObserver.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void onResAccess(IESGurdObserver iESGurdObserver, IESGurdObserverAccessInfo info) {
            Intrinsics.checkParameterIsNotNull(info, "info");
        }

        public static void onResClean(IESGurdObserver iESGurdObserver, IESGurdObserverCleanInfo info) {
            Intrinsics.checkParameterIsNotNull(info, "info");
        }

        public static void onResUpdate(IESGurdObserver iESGurdObserver, IESGurdObserverUpdateInfo info) {
            Intrinsics.checkParameterIsNotNull(info, "info");
        }
    }

    void onResAccess(IESGurdObserverAccessInfo info);

    void onResClean(IESGurdObserverCleanInfo info);

    void onResUpdate(IESGurdObserverUpdateInfo info);
}
