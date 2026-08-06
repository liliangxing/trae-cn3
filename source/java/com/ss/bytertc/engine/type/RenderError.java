package com.ss.bytertc.engine.type;

/* loaded from: classes7.dex */
public enum RenderError {
    RENDER_ERROR_OK(0),
    RENDER_ERROR_USING_INTERNAL_SURFACE(-1),
    RENDER_ERROR_USING_SOFTWARE_DECODER(-2);

    private int value;

    RenderError(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    public static RenderError fromId(int id) {
        for (RenderError renderError : values()) {
            if (renderError.value() == id) {
                return renderError;
            }
        }
        return RENDER_ERROR_OK;
    }
}
