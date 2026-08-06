package com.lynx.tasm.behavior.p000ui.scroll;

import android.view.ViewGroup;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsLynxUIScroll<T extends ViewGroup> extends UISimpleView<T> {
    public static final int SCROLL_DOWN = 1;
    public static final int SCROLL_LEFT = 2;
    public static final int SCROLL_RIGHT = 3;
    public static final int SCROLL_UP = 0;

    public boolean canScroll(int i) {
        return false;
    }

    public void flingX(double d) {
    }

    public void flingY(double d) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return true;
    }

    public void scrollByX(double d) {
    }

    public void scrollByY(double d) {
    }

    public void scrollInto(LynxBaseUI lynxBaseUI, boolean z, String str, String str2) {
    }

    public void scrollInto(LynxBaseUI lynxBaseUI, boolean z, String str, String str2, int i) {
    }

    @LynxProp(defaultInt = 0, name = "scroll-to-index")
    public abstract void scrollToIndex(int i);

    public abstract void sendCustomEvent(int i, int i2, int i3, int i4, String str);

    @LynxProp(defaultBoolean = false, name = "block-descendant-focusability")
    public void setBlockDescendantFocusability(boolean z) {
    }

    @LynxProp(defaultBoolean = false, name = "enable-new-nested")
    public void setEnableNewNested(boolean z) {
    }

    @LynxProp(defaultBoolean = true, name = "enable-scroll")
    public void setEnableScroll(boolean z) {
    }

    @LynxProp(defaultBoolean = false, name = "forbid-fling-focus-change")
    public void setForbidFlingFocusChange(boolean z) {
    }

    @LynxProp(defaultInt = 0, name = "lower-threshold")
    public abstract void setLowerThreshole(int i);

    @LynxProp(defaultBoolean = false, name = "scroll-bar-enable")
    public abstract void setScrollBarEnable(boolean z);

    @LynxProp(defaultInt = 0, name = "scroll-left")
    public abstract void setScrollLeft(int i);

    @LynxProp(defaultBoolean = false, name = "scroll-tap")
    public abstract void setScrollTap(boolean z);

    @LynxProp(defaultInt = 0, name = "scroll-top")
    public abstract void setScrollTop(int i);

    public abstract void setScrollX(boolean z);

    public abstract void setScrollY(boolean z);

    @LynxProp(defaultInt = 0, name = "upper-threshold")
    public abstract void setUpperThreshole(int i);

    public AbsLynxUIScroll(LynxContext lynxContext) {
        this(lynxContext, null);
    }

    public AbsLynxUIScroll(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }

    @LynxProp(name = "scroll-y")
    public void setScrollY(Dynamic dynamic) {
        if (dynamic == null) {
            setScrollY(true);
            return;
        }
        int i = C01211.$SwitchMap$com$lynx$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            setScrollY(dynamic.asBoolean());
        } else {
            if (i != 2) {
                return;
            }
            setScrollY("true".equals(dynamic.asString()));
        }
    }

    /* renamed from: com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    static /* synthetic */ class C01211 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$react$bridge$ReadableType;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $SwitchMap$com$lynx$react$bridge$ReadableType = iArr;
            try {
                iArr[ReadableType.Boolean.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$react$bridge$ReadableType[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @LynxProp(name = "scroll-x")
    public void setScrollX(Dynamic dynamic) {
        if (dynamic == null) {
            setScrollX(false);
            return;
        }
        int i = C01211.$SwitchMap$com$lynx$react$bridge$ReadableType[dynamic.getType().ordinal()];
        if (i == 1) {
            setScrollX(dynamic.asBoolean());
        } else {
            if (i != 2) {
                return;
            }
            setScrollX("true".equals(dynamic.asString()));
        }
    }
}
