package com.bytedance.ies.bullet.forest;

import com.bytedance.forest.model.PreloadType;
import com.bytedance.forest.model.Scene;
import kotlin.Metadata;

/* compiled from: ForestLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"toScene", "Lcom/bytedance/forest/model/Scene;", "Lcom/bytedance/forest/model/PreloadType;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ForestLoaderKt {

    /* compiled from: ForestLoader.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreloadType.values().length];
            try {
                iArr[PreloadType.WEB.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Scene toScene(PreloadType preloadType) {
        if (WhenMappings.$EnumSwitchMapping$0[preloadType.ordinal()] == 1) {
            return Scene.WEB_MAIN_DOCUMENT;
        }
        return Scene.LYNX_TEMPLATE;
    }
}
