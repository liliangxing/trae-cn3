package com.bytedance.trae.conversation;

import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceCountEventTracker.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\t\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\r\u001a\u00020\u0005R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/DeviceCountEventTracker;", "", "onReport", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/DeviceCountSnapshot;", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "lastSnapshot", "onFetchSucceeded", "clis", "", "Lcom/bytedance/trae/im/service/Cli;", "onFetchFailed", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceCountEventTracker {
    private DeviceCountSnapshot lastSnapshot;
    private final Function1<DeviceCountSnapshot, Unit> onReport;

    public final void onFetchFailed() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DeviceCountEventTracker(Function1<? super DeviceCountSnapshot, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onReport");
        this.onReport = function1;
    }

    public final synchronized void onFetchSucceeded(List<Cli> clis) {
        int i;
        Intrinsics.checkNotNullParameter(clis, "clis");
        int size = clis.size();
        List<Cli> list = clis;
        int i2 = 0;
        if ((list instanceof Collection) && list.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((Cli) it.next()).getType(), CliType.LOCAL.getValue()) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        List<Cli> list2 = clis;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(((Cli) it2.next()).getType(), CliType.IDE.getValue()) && (i2 = i2 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        DeviceCountSnapshot deviceCountSnapshot = new DeviceCountSnapshot(size, i, i2);
        if (Intrinsics.areEqual(deviceCountSnapshot, this.lastSnapshot)) {
            return;
        }
        this.lastSnapshot = deviceCountSnapshot;
        this.onReport.invoke(deviceCountSnapshot);
    }
}
