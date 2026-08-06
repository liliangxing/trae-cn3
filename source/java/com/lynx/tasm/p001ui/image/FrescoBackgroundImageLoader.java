package com.lynx.tasm.p001ui.image;

import android.content.Context;
import com.lynx.tasm.behavior.p000ui.background.BackgroundImageLoader;
import com.lynx.tasm.behavior.p000ui.background.BackgroundLayerDrawable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FrescoBackgroundImageLoader implements BackgroundImageLoader {
    @Override // com.lynx.tasm.behavior.p000ui.background.BackgroundImageLoader
    public BackgroundLayerDrawable loadImage(Context context, String str) {
        return new FrescoBackgroundImageDrawable(context, str);
    }
}
