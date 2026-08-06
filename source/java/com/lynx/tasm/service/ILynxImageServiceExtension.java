package com.lynx.tasm.service;

import android.content.Context;
import com.lynx.tasm.behavior.ui.background.BackgroundLayerDrawable;

/* loaded from: classes7.dex */
public interface ILynxImageServiceExtension extends IServiceExtension {
    BackgroundLayerDrawable createBackgroundImageDrawable(Context context, String str);

    void onLynxEnvSetup();
}
