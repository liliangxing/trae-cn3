package com.bytedance.trae.kmp.player;

import android.content.Context;
import com.bytedance.trae.kmp.artifact.AndroidKmpArtifactIoKt;
import com.bytedance.vcloud.uniplayer.UniAbConfig;
import com.bytedance.vcloud.uniplayer.UniKitService;
import com.bytedance.vcloud.uniplayer.UniKitService_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidUniPlayerInitializer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/kmp/player/AndroidUniPlayerInitializer;", "", "<init>", "()V", "initialized", "", "initialize", "", "context", "Landroid/content/Context;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidUniPlayerInitializer {
    private static volatile boolean initialized;
    public static final AndroidUniPlayerInitializer INSTANCE = new AndroidUniPlayerInitializer();
    public static final int $stable = 8;

    private AndroidUniPlayerInitializer() {
    }

    public final void initialize(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (initialized) {
            return;
        }
        synchronized (this) {
            if (initialized) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            AndroidKmpArtifactIoKt.configureAndroidKmpArtifactIo(context);
            AndroidUniPlayerInitializerKt.initializeUniPlayer(new Function0() { // from class: com.bytedance.trae.kmp.player.AndroidUniPlayerInitializer$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit initialize$lambda$1$lambda$0;
                    initialize$lambda$1$lambda$0 = AndroidUniPlayerInitializer.initialize$lambda$1$lambda$0(context);
                    return initialize$lambda$1$lambda$0;
                }
            });
            initialized = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$1$lambda$0(Context context) {
        UniKitService_androidKt.initOnce$default(UniKitService.INSTANCE, context, (UniAbConfig) null, 2, (Object) null);
        return Unit.INSTANCE;
    }
}
