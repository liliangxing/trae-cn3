package com.lynx.canvas.telemetry;

import com.lynx.canvas.KryptonService;
import java.util.Map;

/* loaded from: classes6.dex */
public abstract class KryptonTelemetryService extends KryptonService {
    public abstract void reportEvent(String str, Map<String, String> map);
}
