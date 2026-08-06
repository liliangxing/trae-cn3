package com.lynx.tasm.behavior.p000ui.image;

import android.content.Context;
import android.view.View;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.LynxUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbsUIImage<T extends View> extends LynxUI<T> {
    @LynxProp(name = PropsConstants.AUTO_SIZE)
    public void setAutoSize(boolean z) {
    }

    @LynxProp(name = PropsConstants.BLUR_RADIUS)
    public abstract void setBlurRadius(String str);

    @LynxProp(name = PropsConstants.CAP_INSETS)
    public abstract void setCapInsets(String str);

    @LynxProp(name = PropsConstants.CAP_INSETS_BACKUP)
    public void setCapInsetsBackUp(String str) {
    }

    @LynxProp(name = PropsConstants.CAP_INSETS_SCALE)
    public void setCapInsetsScale(String str) {
    }

    @LynxProp(defaultBoolean = false, name = PropsConstants.COVER_START)
    public abstract void setCoverStart(boolean z);

    @LynxProp(defaultBoolean = false, name = PropsConstants.DISABLE_DEFAULT_PLACEHOLDER)
    public void setDisableDefaultPlaceholder(boolean z) {
    }

    @LynxProp(name = PropsConstants.DISABLE_DEFAULT_RESIZE)
    public void setDisableDefaultResize(boolean z) {
    }

    @LynxProp(name = PropsConstants.LOOP_COUNT)
    public abstract void setLoopCount(int i);

    @LynxProp(name = PropsConstants.MODE)
    public abstract void setObjectFit(String str);

    @LynxProp(name = PropsConstants.PLACEHOLDER)
    public abstract void setPlaceholder(String str);

    @LynxProp(name = PropsConstants.PRE_FETCH_HEIGHT)
    public abstract void setPreFetchHeight(String str);

    @LynxProp(name = PropsConstants.PRE_FETCH_WIDTH)
    public abstract void setPreFetchWidth(String str);

    @LynxProp(defaultBoolean = false, name = PropsConstants.REPEAT)
    public abstract void setRepeat(boolean z);

    @LynxProp(name = PropsConstants.SRC)
    public abstract void setSource(String str);

    @Deprecated
    public AbsUIImage(Context context) {
        super(context);
    }

    public AbsUIImage(LynxContext lynxContext) {
        super(lynxContext);
    }

    public AbsUIImage(LynxContext lynxContext, Object obj) {
        super(lynxContext, obj);
    }
}
