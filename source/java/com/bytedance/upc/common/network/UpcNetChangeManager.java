package com.bytedance.upc.common.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpcNetChangeManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/common/network/UpcNetChangeManager;", "Landroid/content/BroadcastReceiver;", "()V", "mListener", "", "Lcom/bytedance/upc/common/network/IUpcNetChangeListener;", "onReceive", "", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "registerNetChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterNetChangeListener", "Companion", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class UpcNetChangeManager extends BroadcastReceiver {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy mUpcNetChangeManager$delegate = LazyKt.lazy(new Function0<UpcNetChangeManager>() { // from class: com.bytedance.upc.common.network.UpcNetChangeManager$Companion$mUpcNetChangeManager$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final UpcNetChangeManager m2605invoke() {
            return new UpcNetChangeManager();
        }
    });
    private final List<IUpcNetChangeListener> mListener = new ArrayList();

    /* compiled from: UpcNetChangeManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/bytedance/upc/common/network/UpcNetChangeManager$Companion;", "", "()V", "mUpcNetChangeManager", "Lcom/bytedance/upc/common/network/UpcNetChangeManager;", "getMUpcNetChangeManager", "()Lcom/bytedance/upc/common/network/UpcNetChangeManager;", "mUpcNetChangeManager$delegate", "Lkotlin/Lazy;", "inst", "com.bytedance.upc"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class Companion {
        private final UpcNetChangeManager getMUpcNetChangeManager() {
            Lazy lazy = UpcNetChangeManager.mUpcNetChangeManager$delegate;
            Companion companion = UpcNetChangeManager.INSTANCE;
            return (UpcNetChangeManager) lazy.getValue();
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpcNetChangeManager inst() {
            return getMUpcNetChangeManager();
        }
    }

    public final void registerNetChangeListener(IUpcNetChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener.add(listener);
    }

    public final void unregisterNetChangeListener(IUpcNetChangeListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.mListener.remove(listener);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (Throwable unused) {
                return;
            }
        } else {
            action = null;
        }
        if (Intrinsics.areEqual(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
            Iterator<T> it = this.mListener.iterator();
            while (it.hasNext()) {
                ((IUpcNetChangeListener) it.next()).onAvailable();
            }
        }
    }
}
