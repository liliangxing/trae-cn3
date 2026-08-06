package com.bytedance.vcloud.uniplayer;

import com.bytedance.applog.AppLog;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.TeaLog;
import com.ss.vcbkit.VLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AppLogImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0007J\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/AppLogImpl;", "", "()V", "isAppLogLoaded", "", "isBDTrackerLoaded", "applogEvent", "", "e", "", "j", "Lorg/json/JSONObject;", "bdTrackerEvent", "onEvent", "event", "json", LynxTemplateRender.RENDER_PHASE_SETUP, "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class AppLogImpl {
    public static final AppLogImpl INSTANCE;
    private static boolean isAppLogLoaded;
    private static boolean isBDTrackerLoaded;

    private AppLogImpl() {
    }

    static {
        AppLogImpl appLogImpl = new AppLogImpl();
        INSTANCE = appLogImpl;
        appLogImpl.setup();
    }

    public final void setup() {
        if (isBDTrackerLoaded) {
            return;
        }
        try {
            AppLog.getAppId();
            isBDTrackerLoaded = true;
        } catch (Throwable unused) {
            isBDTrackerLoaded = false;
        }
        try {
            TeaLog.Task.i("applog");
            isAppLogLoaded = true;
        } catch (Throwable unused2) {
            isAppLogLoaded = false;
        }
    }

    private final void bdTrackerEvent(String e, JSONObject j) {
        AppLog.onEventV3(e, j);
    }

    private final void applogEvent(String e, JSONObject j) {
        AppLogNewUtils.onEventV3(e, j);
    }

    @JvmStatic
    public static final void onEvent(String event, String json) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(json, "json");
        if (isBDTrackerLoaded || isAppLogLoaded) {
            try {
                JSONObject jSONObject = new JSONObject(json);
                if (isBDTrackerLoaded && AppLog.hasStarted()) {
                    AppLog.onEventV3(event, jSONObject);
                } else if (isAppLogLoaded) {
                    AppLogNewUtils.onEventV3(event, jSONObject);
                }
            } catch (Throwable th) {
                VLog.w("unip", "jsonErr:" + th.getMessage());
            }
        }
    }
}
