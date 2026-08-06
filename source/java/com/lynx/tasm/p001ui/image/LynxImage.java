package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.BehaviorClassWarmer;
import com.lynx.tasm.behavior.Behavior;
import com.lynx.tasm.behavior.BehaviorBundle;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.AbsInlineImageShadowNode;
import com.lynx.tasm.image.AutoSizeImage;
import com.lynx.tasm.service.LynxMemoryInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxImage {
    public static BehaviorBundle imageBehaviorBundle() {
        return new BehaviorBundle() { // from class: com.lynx.tasm.ui.image.LynxImage.1
            @Override // com.lynx.tasm.behavior.BehaviorBundle
            public List<Behavior> create() {
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                arrayList.add(new Behavior(LynxMemoryInfo.TYPE_IMAGE, z, z) { // from class: com.lynx.tasm.ui.image.LynxImage.1.1
                    @Override // com.lynx.tasm.behavior.Behavior
                    public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                        return new UIImage(lynxContext, obj);
                    }

                    @Override // com.lynx.tasm.behavior.Behavior
                    public LynxFlattenUI createFlattenUIWithParams(LynxContext lynxContext, Object obj) {
                        return new FlattenUIImage(lynxContext, obj);
                    }

                    @Override // com.lynx.tasm.behavior.Behavior
                    public ShadowNode createShadowNode() {
                        return new AutoSizeImage();
                    }

                    @Override // com.lynx.tasm.behavior.Behavior
                    public BehaviorClassWarmer createClassWarmer() {
                        return new UIImageClassWarmer();
                    }
                });
                boolean z2 = false;
                arrayList.add(new Behavior("filter-image", z2, z) { // from class: com.lynx.tasm.ui.image.LynxImage.1.2
                    @Override // com.lynx.tasm.behavior.Behavior
                    public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                        return new UIFilterImage(lynxContext, obj);
                    }
                });
                arrayList.add(new Behavior(AbsInlineImageShadowNode.TAG_NAME, z2, z) { // from class: com.lynx.tasm.ui.image.LynxImage.1.3
                    @Override // com.lynx.tasm.behavior.Behavior
                    public ShadowNode createShadowNode() {
                        return new FrescoInlineImageShadowNode();
                    }
                });
                return arrayList;
            }
        };
    }
}
