package com.bytedance.trae.applog.impl;

import android.util.Log;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.bdinstall.ILogger;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppLogLogger.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/applog/impl/AppLogLogger;", "Lcom/bytedance/bdinstall/ILogger;", "tag", "", "<init>", "(Ljava/lang/String;)V", BaseSwitches.V, "", "msg", "t", "", AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE, "w", RXScreenCaptureService.KEY_INDEX, "e", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppLogLogger implements ILogger {
    private final String tag;

    public AppLogLogger(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    @Override // com.bytedance.bdinstall.ILogger
    public void v(String msg, Throwable t) {
        if (t != null) {
            Log.w(this.tag, msg, t);
        } else {
            Log.v(this.tag, String.valueOf(msg));
        }
    }

    @Override // com.bytedance.bdinstall.ILogger
    public void d(String msg, Throwable t) {
        if (t != null) {
            Log.w(this.tag, msg, t);
        } else {
            Log.d(this.tag, String.valueOf(msg));
        }
    }

    @Override // com.bytedance.bdinstall.ILogger
    public void w(String msg, Throwable t) {
        Log.w(this.tag, msg, t);
    }

    @Override // com.bytedance.bdinstall.ILogger
    public void i(String msg, Throwable t) {
        if (t != null) {
            Log.w(this.tag, msg, t);
        } else {
            Log.i(this.tag, String.valueOf(msg));
        }
    }

    @Override // com.bytedance.bdinstall.ILogger
    public void e(String msg, Throwable t) {
        Log.e(this.tag, msg, t);
    }
}
