package com.bytedance.trae.network;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.platform.model.HttpEnvConfig;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevConfig.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ&\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/network/DevConfig;", "", "<init>", "()V", "flagFile", "Ljava/io/File;", "opaqueDataEnable", "", "initHttpEnv", "Lcom/bytedance/trae/platform/model/HttpEnvConfig;", "updateHttpEnv", "", "boeEnable", "boeEnv", "", "ppeEnable", "ppeEnv", "getOpaqueDataEnable", "updateOpaqueDataEnable", "enable", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DevConfig {
    public static final DevConfig INSTANCE = new DevConfig();
    private static final File flagFile;
    private static final boolean opaqueDataEnable;

    public final void updateHttpEnv(boolean boeEnable, String boeEnv, boolean ppeEnable, String ppeEnv) {
        Intrinsics.checkNotNullParameter(boeEnv, "boeEnv");
        Intrinsics.checkNotNullParameter(ppeEnv, "ppeEnv");
    }

    private DevConfig() {
    }

    static {
        File file = new File(AppHost.Companion.getApplication().getFilesDir().getAbsolutePath() + "/enable_opaque_data.flag");
        flagFile = file;
        opaqueDataEnable = file.exists();
    }

    public final HttpEnvConfig initHttpEnv() {
        String ppeEnv = DebugSettings.INSTANCE.getPpeEnv();
        if (ppeEnv.length() > 0) {
            return new HttpEnvConfig(false, null, true, ppeEnv, 3, null);
        }
        return new HttpEnvConfig(false, null, false, null, 15, null);
    }

    public final boolean getOpaqueDataEnable() {
        return opaqueDataEnable;
    }

    public final void updateOpaqueDataEnable(boolean enable) {
        Boolean valueOf;
        try {
            Result.Companion companion = Result.Companion;
            DevConfig devConfig = this;
            File file = flagFile;
            if (enable && !file.exists()) {
                valueOf = Boolean.valueOf(file.createNewFile());
            } else {
                valueOf = (enable || !file.exists()) ? Unit.INSTANCE : Boolean.valueOf(file.delete());
            }
            Result.constructor-impl(valueOf);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
