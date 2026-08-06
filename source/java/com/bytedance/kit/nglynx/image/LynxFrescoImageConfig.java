package com.bytedance.kit.nglynx.image;

import android.content.Context;
import com.bytedance.ies.bullet.lynx.init.ILynxImageConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.ui.background.BackgroundImageLoader;
import com.lynx.tasm.ui.image.FrescoBackgroundImageLoader;
import com.lynx.tasm.ui.image.LynxImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxFrescoImageConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/kit/nglynx/image/LynxFrescoImageConfig;", "Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;", "application", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplication", "()Landroid/content/Context;", "getBackgroundImageLoader", "Lcom/lynx/tasm/behavior/ui/background/BackgroundImageLoader;", "getImageBehaviors", "", "Lcom/lynx/tasm/behavior/Behavior;", "initFresco", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxFrescoImageConfig extends ILynxImageConfig {
    private final Context application;

    public LynxFrescoImageConfig(Context context) {
        Intrinsics.checkNotNullParameter(context, "application");
        this.application = context;
    }

    public final Context getApplication() {
        return this.application;
    }

    @Override // com.bytedance.ies.bullet.lynx.init.ILynxImageConfig
    public BackgroundImageLoader getBackgroundImageLoader() {
        initFresco();
        return new FrescoBackgroundImageLoader();
    }

    @Override // com.bytedance.ies.bullet.lynx.init.ILynxImageConfig
    public List<Behavior> getImageBehaviors() {
        initFresco();
        List<Behavior> create = LynxImage.imageBehaviorBundle().create();
        Intrinsics.checkNotNullExpressionValue(create, "imageBehaviorBundle().create()");
        return create;
    }

    private final void initFresco() {
        if (Fresco.hasBeenInitialized()) {
            return;
        }
        Fresco.initialize(this.application);
    }
}
