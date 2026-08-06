package com.lynx.tasm.event;

import com.lynx.tasm.utils.PixelUtils;

/* loaded from: classes7.dex */
public class LynxScrollEvent extends LynxDetailEvent {
    public static final String EVENT_SCROLL = "scroll";
    public static final String EVENT_SCROLL_END = "scrollend";
    public static final String EVENT_SCROLL_START = "scrollstart";
    public static final String EVENT_SCROLL_STATE_CHANGE = "scrollstatechange";
    public static final String EVENT_SCROLL_TOLOWER = "scrolltolower";
    public static final String EVENT_SCROLL_TOUPPER = "scrolltoupper";
    public static final String EVENT_SCROLL_TO_LOWER_EDGE = "scrolltoloweredge";
    public static final String EVENT_SCROLL_TO_NORMAL_STATE = "scrolltonormalstate";
    public static final String EVENT_SCROLL_TO_UPPER_EDGE = "scrolltoupperedge";

    public LynxScrollEvent(int i, String str) {
        super(i, str);
    }

    public static LynxScrollEvent createScrollEvent(int i, String str) {
        return new LynxScrollEvent(i, str);
    }

    public void setScrollParams(int i, int i2, int i3, int i4, int i5, int i6) {
        addDetail("scrollLeft", Float.valueOf(PixelUtils.pxToDip(i)));
        addDetail("scrollTop", Float.valueOf(PixelUtils.pxToDip(i2)));
        addDetail("scrollHeight", Float.valueOf(PixelUtils.pxToDip(i3)));
        addDetail("scrollWidth", Float.valueOf(PixelUtils.pxToDip(i4)));
        addDetail("deltaX", Float.valueOf(PixelUtils.pxToDip(i5)));
        addDetail("deltaY", Float.valueOf(PixelUtils.pxToDip(i6)));
    }
}
