package com.lynx.tasm.behavior;

import com.lynx.tasm.behavior.p000ui.LynxFlattenUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.frame.UIFrame;
import com.lynx.tasm.behavior.p000ui.list.UIList;
import com.lynx.tasm.behavior.p000ui.list.UIListItem;
import com.lynx.tasm.behavior.p000ui.list.container.UIListContainer;
import com.lynx.tasm.behavior.p000ui.scroll.UIBounceView;
import com.lynx.tasm.behavior.p000ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.p000ui.text.FlattenUIText;
import com.lynx.tasm.behavior.p000ui.text.UIText;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.p000ui.view.UIView;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.InlineTruncationShadowNode;
import com.lynx.tasm.behavior.shadow.text.RawTextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BuiltInBehavior implements BehaviorBundle {
    @Override // com.lynx.tasm.behavior.BehaviorBundle
    public List<Behavior> create() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        arrayList.add(new Behavior("view", z, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.1
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIView(lynxContext, obj);
            }

            @Override // com.lynx.tasm.behavior.Behavior
            public LynxFlattenUI createFlattenUIWithParams(LynxContext lynxContext, Object obj) {
                return new LynxFlattenUI(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior(PropsConstants.TEXT, z, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.2
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIText(lynxContext, obj);
            }

            @Override // com.lynx.tasm.behavior.Behavior
            public LynxFlattenUI createFlattenUIWithParams(LynxContext lynxContext, Object obj) {
                return new FlattenUIText(lynxContext, obj);
            }

            @Override // com.lynx.tasm.behavior.Behavior
            public ShadowNode createShadowNode() {
                return new TextShadowNode();
            }
        });
        boolean z2 = false;
        arrayList.add(new Behavior("raw-text", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.3
            @Override // com.lynx.tasm.behavior.Behavior
            public ShadowNode createShadowNode() {
                return new RawTextShadowNode();
            }
        });
        arrayList.add(new Behavior("inline-text", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.4
            @Override // com.lynx.tasm.behavior.Behavior
            public ShadowNode createShadowNode() {
                return new InlineTextShadowNode();
            }
        });
        arrayList.add(new Behavior(InlineTruncationShadowNode.TAG_NAME, z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.5
            @Override // com.lynx.tasm.behavior.Behavior
            public ShadowNode createShadowNode() {
                return new InlineTruncationShadowNode();
            }
        });
        arrayList.add(new Behavior("scroll-view", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.6
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIScrollView(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior("bounce-view", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.7
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIBounceView(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior("component", z, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.8
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIComponent(lynxContext, obj);
            }

            @Override // com.lynx.tasm.behavior.Behavior
            public LynxFlattenUI createFlattenUIWithParams(LynxContext lynxContext, Object obj) {
                return new LynxFlattenUI(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior(PropsConstants.LIST, z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.9
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIList(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior("list-item", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.10
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIListItem(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior("list-container", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.11
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIListContainer(lynxContext, obj);
            }
        });
        arrayList.add(new Behavior("frame", z2, z) { // from class: com.lynx.tasm.behavior.BuiltInBehavior.12
            @Override // com.lynx.tasm.behavior.Behavior
            public LynxUI createUIWithParams(LynxContext lynxContext, Object obj) {
                return new UIFrame(lynxContext, obj);
            }
        });
        return arrayList;
    }
}
