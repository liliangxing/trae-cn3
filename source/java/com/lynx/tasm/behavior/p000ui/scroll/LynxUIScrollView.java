package com.lynx.tasm.behavior.p000ui.scroll;

import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxBehavior;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxGeneratorName;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;

@LynxBehavior(tagName = {"scroll-view-new-arch"})
@LynxGeneratorName(packageName = "com.lynx.tasm.behavior.ui.scroll")
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxUIScrollView extends LynxUIScrollViewInternal {
    public LynxUIScrollView(LynxContext lynxContext) {
        super(lynxContext);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "scroll-orientation")
    public void setScrollOrientation(String str) {
        super.setScrollOrientation(str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "enable-scroll")
    public void setEnableScroll(boolean z) {
        super.setEnableScroll(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "bounces")
    public void setBounces(boolean z) {
        super.setBounces(z);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "forwards-nested-scroll")
    public void setForwardsNestedScroll(int i) {
        super.setForwardsNestedScroll(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "backwards-nested-scroll")
    public void setBackwardsNestedScroll(int i) {
        super.setBackwardsNestedScroll(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "initial-scroll-index")
    public void setInitialScrollIndex(int i) {
        super.setInitialScrollIndex(i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "initial-scroll-offset")
    public void setInitialScrollOffset(String str) {
        super.setInitialScrollOffset(str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "lower-threshold")
    public void setLowerThreshold(String str) {
        super.setLowerThreshold(str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "upper-threshold")
    public void setUpperThreshold(String str) {
        super.setUpperThreshold(str);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxProp(name = "scroll-event-throttle")
    public void setScrollEventThrottle(float f) {
        super.setScrollEventThrottle(f);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxUIMethod
    public void scrollTo(ReadableMap readableMap, Callback callback) {
        super.scrollTo(readableMap, callback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxUIMethod
    public void scrollBy(ReadableMap readableMap, Callback callback) {
        super.scrollBy(readableMap, callback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.LynxUIScrollViewInternal
    @LynxUIMethod
    public void autoScroll(ReadableMap readableMap, Callback callback) {
        super.autoScroll(readableMap, callback);
    }
}
