package com.bytedance.ies.bullet.lynx.init;

import android.util.AndroidRuntimeException;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.ReportInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.lynx.service.image.LynxImageService;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.notification.Constants;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.sdk.xbridge.cn.utils.UGLogger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.lynx.tasm.base.AbsLogDelegate;
import com.lynx.tasm.base.LogSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: LynxKitALogDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u001c\u0010\u001a\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u001b\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxKitALogDelegate;", "Lcom/lynx/tasm/base/AbsLogDelegate;", "serviceToken", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "aLogEnable", "", "monitorService", "Lcom/bytedance/ies/bullet/service/base/IMonitorReportService;", "d", "", Constants.NOTIFICATION_TAG, "", "msg", "e", "getMinimumLoggingLevel", "", "i", "isLoggable", EventConstants.PARAM_SOURCE, "Lcom/lynx/tasm/base/LogSource;", "level", "k", IFrontierMonitor.KEY_LOG, LynxImageService.PRIORITY_KEY, "type", "v", "w", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxKitALogDelegate extends AbsLogDelegate {
    private static long ALOGREF;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LYNX_TAG = LynxMonitorService.DEFAULT_PID;
    private boolean aLogEnable;
    private final IMonitorReportService monitorService;
    private final IServiceToken serviceToken;

    public int getMinimumLoggingLevel() {
        return 2;
    }

    public void log(int priority, String tag, String msg) {
    }

    public int type() {
        return 1;
    }

    public LynxKitALogDelegate(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "serviceToken");
        this.serviceToken = iServiceToken;
        this.monitorService = (IMonitorReportService) iServiceToken.getService(IMonitorReportService.class);
        try {
            ALOGREF = UGLogger.INSTANCE.getALog().getALogSimpleWriteFuncAddr();
            this.aLogEnable = true;
        } catch (Throwable unused) {
            new AndroidRuntimeException("Just warning log, No ALog dependency found").printStackTrace();
        }
    }

    public boolean isLoggable(LogSource source, int level) {
        Intrinsics.checkNotNullParameter(source, EventConstants.PARAM_SOURCE);
        return (source == LogSource.JAVA && level >= this.mMinimumLoggingLevel) || (source == LogSource.Native && level == 8);
    }

    /* renamed from: v */
    public void m31v(String tag, String msg) {
        BulletLogger.INSTANCE.printLog(tag + '_' + msg, LogLevel.V, LYNX_TAG);
    }

    /* renamed from: d */
    public void m27d(String tag, String msg) {
        BulletLogger.INSTANCE.printLog(tag + '_' + msg, LogLevel.D, LYNX_TAG);
    }

    /* renamed from: i */
    public void m29i(String tag, String msg) {
        BulletLogger.INSTANCE.printLog(tag + '_' + msg, LogLevel.I, LYNX_TAG);
    }

    /* renamed from: w */
    public void m32w(String tag, String msg) {
        BulletLogger.INSTANCE.printLog(tag + '_' + msg, LogLevel.W, LYNX_TAG);
    }

    /* renamed from: e */
    public void m28e(String tag, String msg) {
        BulletLogger.INSTANCE.printLog(tag + '_' + msg, LogLevel.E, LYNX_TAG);
    }

    /* renamed from: k */
    public void m30k(String tag, String msg) {
        IMonitorReportService iMonitorReportService = this.monitorService;
        if (iMonitorReportService != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", msg);
            Unit unit = Unit.INSTANCE;
            iMonitorReportService.report(new ReportInfo("LynxLog", null, null, jSONObject, null, null, null, null, 246, null));
        }
    }

    /* compiled from: LynxKitALogDelegate.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/LynxKitALogDelegate$Companion;", "", "()V", "ALOGREF", "", "getALOGREF", "()J", "setALOGREF", "(J)V", "LYNX_TAG", "", "getLYNX_TAG", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getLYNX_TAG() {
            return LynxKitALogDelegate.LYNX_TAG;
        }

        public final long getALOGREF() {
            return LynxKitALogDelegate.ALOGREF;
        }

        public final void setALOGREF(long j) {
            LynxKitALogDelegate.ALOGREF = j;
        }
    }
}
