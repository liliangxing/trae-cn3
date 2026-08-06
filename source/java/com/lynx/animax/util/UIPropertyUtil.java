package com.lynx.animax.util;

import com.lynx.animax.ui.ObjectFit;
import com.lynx.animax.ui.ObjectPosition;

/* loaded from: classes6.dex */
public class UIPropertyUtil {
    public static ObjectFit convertStringToObjectFit(String str) {
        ObjectFit objectFit = ObjectFit.CONTAIN;
        if ("cover".equals(str)) {
            return ObjectFit.COVER;
        }
        if ("center".equals(str)) {
            return ObjectFit.CENTER;
        }
        if ("fill".equals(str)) {
            return ObjectFit.FILL;
        }
        return "scale-down".equals(str) ? ObjectFit.SCALE_DOWN : objectFit;
    }

    public static ObjectPosition convertStringToObjectPosition(String str) {
        ObjectPosition objectPosition = ObjectPosition.CENTER;
        if ("left".equals(str)) {
            return ObjectPosition.LEFT;
        }
        if ("right".equals(str)) {
            return ObjectPosition.RIGHT;
        }
        if ("top".equals(str)) {
            return ObjectPosition.TOP;
        }
        return "bottom".equals(str) ? ObjectPosition.BOTTOM : objectPosition;
    }
}
