package com.lynx.tasm.behavior.p000ui.swiper;

import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollView;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BehaviorGenerator {
    public static List<Behavior> getBehaviors() {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        arrayList.add(new Behavior("scroll-view-new-arch", z, z, z) { // from class: com.lynx.tasm.behavior.ui.swiper.BehaviorGenerator.1
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUI(LynxContext lynxContext) {
                return new LynxUIScrollView(lynxContext);
            }
        });
        arrayList.add(new Behavior("swiper", z, true, z) { // from class: com.lynx.tasm.behavior.ui.swiper.BehaviorGenerator.2
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new XSwiperUI(lynxContext, obj);
            }

            @Override // com.lynx.tasm.behavior.Behavior
            public ShadowNode createShadowNode() {
                return new SwiperShadowNode();
            }
        });
        return arrayList;
    }
}
