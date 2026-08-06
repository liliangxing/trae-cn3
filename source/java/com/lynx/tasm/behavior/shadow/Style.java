package com.lynx.tasm.behavior.shadow;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class Style {
    public static final int EDGE_BOTTOM = 3;
    public static final int EDGE_LEFT = 0;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 1;
    public static final int FLEX_DIRECTION_COLUMN = 0;
    public static final int FLEX_DIRECTION_COLUMN_REVERSE = 1;
    public static final int FLEX_DIRECTION_ROW = 2;
    public static final int FLEX_DIRECTION_ROW_REVERSE = 3;
    private LayoutNode mLayoutNode;

    public Style(LayoutNode layoutNode) {
        this.mLayoutNode = layoutNode;
    }

    public int getFlexDirection() {
        return this.mLayoutNode.getFlexDirection();
    }

    public float getWidth() {
        return this.mLayoutNode.getWidth();
    }

    public float getHeight() {
        return this.mLayoutNode.getHeight();
    }

    public int[] getPaddings() {
        return this.mLayoutNode.getPadding();
    }

    public int[] getMargins() {
        return this.mLayoutNode.getMargins();
    }
}
