package com.bytedance.ies.bullet.lynx.init;

import android.app.Application;
import com.lynx.tasm.INativeLibraryLoader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILynxCanvasConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R,\u0010\u0003\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/ILynxCanvasConfig;", "", "()V", "lynxCanvasServiceMap", "", "Ljava/lang/Class;", "getLynxCanvasServiceMap", "()Ljava/util/Map;", "setLynxCanvasServiceMap", "(Ljava/util/Map;)V", "init", "", "context", "Landroid/app/Application;", "_libraryLoader", "Lcom/lynx/tasm/INativeLibraryLoader;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ILynxCanvasConfig {
    private Map<Class<?>, ? extends Object> lynxCanvasServiceMap;

    public void init(Application context, INativeLibraryLoader _libraryLoader) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public Map<Class<?>, Object> getLynxCanvasServiceMap() {
        return this.lynxCanvasServiceMap;
    }

    public void setLynxCanvasServiceMap(Map<Class<?>, ? extends Object> map) {
        this.lynxCanvasServiceMap = map;
    }
}
