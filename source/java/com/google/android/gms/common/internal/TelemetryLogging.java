package com.google.android.gms.common.internal;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class TelemetryLogging {
    private TelemetryLogging() {
    }

    public static TelemetryLoggingClient getClient(Context context) {
        return getClient(context, TelemetryLoggingOptions.zaa);
    }

    public static TelemetryLoggingClient getClient(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        return new com.google.android.gms.common.internal.service.zao(context, telemetryLoggingOptions);
    }
}
