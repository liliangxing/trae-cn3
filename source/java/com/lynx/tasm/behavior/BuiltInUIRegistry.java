package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.p000ui.image.InlineImageShadowNode;
import com.lynx.tasm.behavior.p000ui.image.UIImage;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.image.AutoSizeImage;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BuiltInUIRegistry {
    private static final String IMAGE_TAG = "image";
    private static final String INLINE_IMAGE_TAG = "inline-image";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class BehaviorHolder {
        static final Map<String, Behavior> mBehaviorsMap;

        private BehaviorHolder() {
        }

        static {
            HashMap hashMap = new HashMap();
            mBehaviorsMap = hashMap;
            boolean z = true;
            hashMap.put("image", new Behavior("image", z, z) { // from class: com.lynx.tasm.behavior.BuiltInUIRegistry.BehaviorHolder.1
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
            });
            hashMap.put("inline-image", new Behavior("inline-image", false, z) { // from class: com.lynx.tasm.behavior.BuiltInUIRegistry.BehaviorHolder.2
                @Override // com.lynx.tasm.behavior.Behavior
                public ShadowNode createShadowNode() {
                    return new InlineImageShadowNode();
                }
            });
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class Holder {
        static final BuiltInUIRegistry INSTANCE = new BuiltInUIRegistry();

        private Holder() {
        }
    }

    public static BuiltInUIRegistry getInstance() {
        return Holder.INSTANCE;
    }

    public Map<String, Behavior> getBuiltInUIBehaviors() {
        return BehaviorHolder.mBehaviorsMap;
    }
}
