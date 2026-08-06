package com.huawei.hms.adapter;

import android.content.Context;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: classes6.dex */
public class OuterBinderAdapter extends BinderAdapter {
    private static final Object j = new Object();
    private static BinderAdapter k;
    private static String l;
    private static String m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0030 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:4:0x000a, B:6:0x000e, B:7:0x0047, B:8:0x0049, B:12:0x001a, B:14:0x0022, B:19:0x0030), top: B:3:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BinderAdapter getInstance(Context context, String str, String str2) {
        boolean z;
        BinderAdapter binderAdapter;
        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance.");
        synchronized (j) {
            if (k == null) {
                l = str;
                m = str2;
                k = new OuterBinderAdapter(context, str, str2);
            } else {
                if (Objects.equal(l, str) && Objects.equal(m, str2)) {
                    z = false;
                    if (z) {
                        HMSLog.i("OuterBinderAdapter", "OuterBinderAdapter getInstance refresh adapter");
                        l = str;
                        m = str2;
                        k.unBind();
                        k = new OuterBinderAdapter(context, str, str2);
                    }
                }
                z = true;
                if (z) {
                }
            }
            binderAdapter = k;
        }
        return binderAdapter;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return 1002;
    }
}
