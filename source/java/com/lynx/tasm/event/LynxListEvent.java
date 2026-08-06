package com.lynx.tasm.event;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.utils.PixelUtils;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxListEvent extends LynxDetailEvent {
    public static final String EVENT_LAYOUT_COMPLETE = "layoutcomplete";
    public static final String EVENT_NODE_APPEAR = "nodeappear";
    public static final String EVENT_NODE_DISAPPEAR = "nodedisappear";
    public static final String EVENT_SCROLL = "scroll";
    public static final String EVENT_SCROLL_STATE_CHANGE = "scrollstatechange";
    public static final String EVENT_SCROLL_TOLOWER = "scrolltolower";
    public static final String EVENT_SCROLL_TOUPPER = "scrolltoupper";
    public static final int SCROLL_STATE_DRAGGING = 2;
    public static final int SCROLL_STATE_IDLE = 1;
    public static final int SCROLL_STATE_SETTLING = 3;

    public LynxListEvent(int i, String str) {
        super(i, str);
    }

    public static LynxListEvent createListEvent(int i, String str) {
        return new LynxListEvent(i, str);
    }

    public void setCellParams(int i) {
        addDetail(PropsConstants.POSITION, Integer.valueOf(i));
    }

    public void setScrollParams(int i, int i2, int i3, int i4, JavaOnlyArray javaOnlyArray) {
        addDetail("scrollLeft", Float.valueOf(PixelUtils.pxToDip(i)));
        addDetail("scrollTop", Float.valueOf(PixelUtils.pxToDip(i2)));
        addDetail("deltaX", Float.valueOf(PixelUtils.pxToDip(i3)));
        addDetail("deltaY", Float.valueOf(PixelUtils.pxToDip(i4)));
        addAttachCells(javaOnlyArray);
    }

    private void addAttachCells(JavaOnlyArray javaOnlyArray) {
        if (javaOnlyArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (javaOnlyArray != null) {
            for (int i = 0; i < javaOnlyArray.size(); i++) {
                JavaOnlyMap map = javaOnlyArray.getMap(i);
                if (map != null && !map.isEmpty()) {
                    arrayList.add(map);
                }
            }
        }
        addDetail("attachedCells", arrayList);
    }

    public void setListScrollStateChangeParams(int i, JavaOnlyArray javaOnlyArray) {
        addDetail("state", Integer.valueOf(i));
        if (javaOnlyArray != null) {
            addAttachCells(javaOnlyArray);
        }
    }
}
