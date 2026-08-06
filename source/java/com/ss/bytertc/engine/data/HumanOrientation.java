package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public class HumanOrientation {
    public Orientation forward;
    public Orientation right;
    public Orientation up;

    public HumanOrientation(Orientation forward, Orientation right, Orientation up) {
        this.forward = forward;
        this.right = right;
        this.up = up;
    }

    public HumanOrientation() {
        this.forward = new Orientation(1.0f, 0.0f, 0.0f);
        this.right = new Orientation(0.0f, 1.0f, 0.0f);
        this.up = new Orientation(0.0f, 0.0f, 1.0f);
    }
}
