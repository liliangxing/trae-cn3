package com.bytedance.applog.priority.original;

import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.pia.core.plugins.BootPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Config.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/applog/priority/original/Config;", "", "context", "Landroid/content/Context;", "appId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", BootPlugin.RESULT_CONFIG_KEY, "getContext", "()Landroid/content/Context;", "keva", "Lcom/bytedance/keva/Keva;", "clear", "", "get", "Lorg/json/JSONObject;", "save", "json", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Config {
    private final String appId;
    private final String configKey;
    private final Context context;
    private final Keva keva;

    public Config(Context context, String appId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.context = context;
        this.appId = appId;
        this.configKey = "data";
        Keva repo = Keva.getRepo("applog_priority_origin@" + appId + "_config", 0);
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(\"applog_priority…ants.MODE_SINGLE_PROCESS)");
        this.keva = repo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Context getContext() {
        return this.context;
    }

    public final JSONObject get() {
        String stringJustDisk = this.keva.getStringJustDisk(this.configKey, "");
        Intrinsics.checkNotNullExpressionValue(stringJustDisk, "keva.getStringJustDisk(configKey, \"\")");
        if (stringJustDisk.length() == 0) {
            return null;
        }
        try {
            return new JSONObject(stringJustDisk);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void save(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.keva.storeStringJustDisk(this.configKey, json);
    }

    public final void clear() {
        this.keva.clear();
    }
}
