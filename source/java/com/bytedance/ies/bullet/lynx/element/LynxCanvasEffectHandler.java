package com.bytedance.ies.bullet.lynx.element;

import com.bytedance.ies.bullet.core.BulletEnv;
import com.heytap.mcssdk.constant.b;
import com.lynx.canvas.KryptonEffectConfigService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: LynxCanvasEffectHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasEffectHandler;", "Lcom/lynx/canvas/KryptonEffectConfigService;", "()V", "accessKey", "", b.u, "effectHost", "effectResourcePath", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxCanvasEffectHandler extends KryptonEffectConfigService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile LynxCanvasEffectHandler instance;

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String accessKey() {
        return "68d32050064f11e891efe7cc07299bc5";
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String effectHost() {
        return "https://effect.snssdk.com/";
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String effectResourcePath() {
        return "https://lf3-developer.bytemastatic.com/obj/developer/misc/EffectFaceResource.zip";
    }

    /* compiled from: LynxCanvasEffectHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasEffectHandler$Companion;", "", "()V", "instance", "Lcom/bytedance/ies/bullet/lynx/element/LynxCanvasEffectHandler;", "getInstance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LynxCanvasEffectHandler getInstance() {
            LynxCanvasEffectHandler lynxCanvasEffectHandler = LynxCanvasEffectHandler.instance;
            if (lynxCanvasEffectHandler == null) {
                synchronized (this) {
                    lynxCanvasEffectHandler = new LynxCanvasEffectHandler();
                    Companion companion = LynxCanvasEffectHandler.INSTANCE;
                    LynxCanvasEffectHandler.instance = lynxCanvasEffectHandler;
                }
            }
            return lynxCanvasEffectHandler;
        }
    }

    @Override // com.lynx.canvas.KryptonEffectConfigService
    public String appID() {
        String appId = BulletEnv.INSTANCE.getInstance().getAppId();
        return appId == null ? "" : appId;
    }
}
