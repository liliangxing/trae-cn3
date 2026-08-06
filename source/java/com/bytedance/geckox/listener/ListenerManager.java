package com.bytedance.geckox.listener;

import com.bytedance.applog.GameReportHelper;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.model.LocalPackageModel;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import java.io.File;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ListenerManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0017\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/geckox/listener/ListenerManager;", "", "()V", "listeners", "", "Lcom/bytedance/geckox/listener/GeckoUpdateListener;", "getListeners", "()Ljava/util/Set;", "callUpdateFailed", "", "listener", "pack", "Lcom/bytedance/geckox/model/UpdatePackage;", "t", "", "callUpdateSuccess", "callVersionExist", "accessKey", "", "channel", "version", "", GameReportHelper.REGISTER, "unregister", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ListenerManager {
    public static final ListenerManager INSTANCE = new ListenerManager();
    private static final Set<GeckoUpdateListener> listeners = new CopyOnWriteArraySet();

    private ListenerManager() {
    }

    public final Set<GeckoUpdateListener> getListeners() {
        return listeners;
    }

    public final void register(GeckoUpdateListener listener) {
        if (listener != null) {
            listeners.add(listener);
        }
    }

    public final void unregister(GeckoUpdateListener listener) {
        if (listener != null) {
            listeners.remove(listener);
        }
    }

    public final void callVersionExist(GeckoUpdateListener listener, String accessKey, String channel, long version) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        if (listener != null) {
            GeckoGlobalManager inst = GeckoGlobalManager.inst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
            String channelPath = ResLoadUtils.getChannelPath(new File(inst.getAccessKeyDirs().get(accessKey)), accessKey, channel, version);
            LocalPackageModel localPackageModel = new LocalPackageModel(accessKey, channel);
            localPackageModel.setLatestVersion(version);
            localPackageModel.setChannelPath(channelPath);
            listener.onLocalNewestVersion(localPackageModel);
        }
    }

    public final void callUpdateSuccess(GeckoUpdateListener listener, UpdatePackage pack) {
        Intrinsics.checkParameterIsNotNull(pack, "pack");
        if (listener != null) {
            listener.onUpdateSuccess(pack, pack.getVersion());
            listener.onUpdateSuccess(pack.getChannel(), pack.getVersion());
        }
    }

    public final void callUpdateFailed(GeckoUpdateListener listener, UpdatePackage pack, Throwable t) {
        Intrinsics.checkParameterIsNotNull(pack, "pack");
        Intrinsics.checkParameterIsNotNull(t, "t");
        if (listener != null) {
            listener.onUpdateFailed(pack, t);
            listener.onUpdateFailed(pack.getChannel(), t);
        }
    }
}
