package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class PositionInfo {
    public HumanOrientation orientation;
    public Position position;

    public PositionInfo(Position position, HumanOrientation orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public float getFieldPositionX() {
        return this.position.x;
    }

    public float getFieldPositionY() {
        return this.position.y;
    }

    public float getFieldPositionZ() {
        return this.position.z;
    }

    public float getFieldOrientationForwardX() {
        return this.orientation.forward.x;
    }

    public float getFieldOrientationForwardY() {
        return this.orientation.forward.y;
    }

    public float getFieldOrientationForwardZ() {
        return this.orientation.forward.z;
    }

    public float getFieldOrientationRightX() {
        return this.orientation.right.x;
    }

    public float getFieldOrientationRightY() {
        return this.orientation.right.y;
    }

    public float getFieldOrientationRightZ() {
        return this.orientation.right.z;
    }

    public float getFieldOrientationUpX() {
        return this.orientation.up.x;
    }

    public float getFieldOrientationUpY() {
        return this.orientation.up.y;
    }

    public float getFieldOrientationUpZ() {
        return this.orientation.up.z;
    }
}
