package com.bytedance.upc.common.log;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.upc.BuildConfig;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/upc/common/log/DefaultLog;", "Lcom/bytedance/upc/common/log/ILog;", "()V", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "", "tag", "", "msg", "e", RXScreenCaptureService.KEY_INDEX, BaseSwitches.V, "w", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes6.dex */
public final class DefaultLog implements ILog {
    @Override // com.bytedance.upc.common.log.ILog
    public void v(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (msg == null) {
            msg = "";
        }
        Log.v(tag, msg);
    }

    @Override // com.bytedance.upc.common.log.ILog
    public void d(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (msg == null) {
            msg = "";
        }
        Log.d(tag, msg);
    }

    @Override // com.bytedance.upc.common.log.ILog
    public void i(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (msg == null) {
            msg = "";
        }
        Log.i(tag, msg);
    }

    @Override // com.bytedance.upc.common.log.ILog
    public void e(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (msg == null) {
            msg = "";
        }
        Log.e(tag, msg);
    }

    @Override // com.bytedance.upc.common.log.ILog
    public void w(String tag, String msg) {
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        if (msg == null) {
            msg = "";
        }
        Log.w(tag, msg);
    }
}
