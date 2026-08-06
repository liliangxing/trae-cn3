package com.bytedance.timonbase.config;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.TMInjection;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TMLocalSettingLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0002X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/config/TMLocalSettingLoader;", "Lkotlin/Function1;", "", "Lcom/google/gson/JsonObject;", "Lcom/bytedance/timonbase/scene/SettingFetcher;", "()V", "TIMON_CONFIG", "invoke", "key", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMLocalSettingLoader implements Function1<String, JsonObject> {
    private final String TIMON_CONFIG = "timon_config.json";

    public JsonObject invoke(String key) {
        InputStream inputStream;
        Resources resources;
        AssetManager assets;
        Intrinsics.checkParameterIsNotNull(key, "key");
        InputStream inputStream2 = null;
        if (!Intrinsics.areEqual(key, "timon_config")) {
            return null;
        }
        try {
            Application application = TMEnv.INSTANCE.getApplication();
            inputStream = (application == null || (resources = application.getResources()) == null || (assets = resources.getAssets()) == null) ? null : assets.open(this.TIMON_CONFIG);
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            JsonObject jsonObject = (JsonObject) TMInjection.INSTANCE.getGson().fromJson(TextStreamsKt.readText(new BufferedReader(new InputStreamReader(inputStream))), JsonObject.class);
            if (inputStream != null) {
                inputStream.close();
            }
            return jsonObject;
        } catch (IOException unused2) {
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            inputStream2 = inputStream;
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }
}
