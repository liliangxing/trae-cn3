package com.bytedance.ies.bullet.lynx.init;

import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.ui.background.BackgroundImageLoader;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ILynxImageConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/init/ILynxImageConfig;", "", "()V", "getBackgroundImageLoader", "Lcom/lynx/tasm/behavior/ui/background/BackgroundImageLoader;", "getImageBehaviors", "", "Lcom/lynx/tasm/behavior/Behavior;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class ILynxImageConfig {
    public abstract BackgroundImageLoader getBackgroundImageLoader();

    public abstract List<Behavior> getImageBehaviors();
}
