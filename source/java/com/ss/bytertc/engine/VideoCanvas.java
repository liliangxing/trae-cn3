package com.ss.bytertc.engine;

import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.ss.bytertc.engine.data.VideoRotation;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
public class VideoCanvas {
    public static final int RENDER_MODE_FILL = 3;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public int backgroundColor;
    public int renderMode;
    public VideoRotation renderRotation;
    public Surface renderSurface;
    public View renderView;

    public VideoCanvas() {
        this.renderView = null;
        this.renderSurface = null;
        this.renderMode = 1;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(SurfaceView view, int renderMode) {
        this.renderView = view;
        this.renderSurface = null;
        this.renderMode = renderMode;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(TextureView view, int renderMode) {
        this.renderView = view;
        this.renderSurface = null;
        this.renderMode = renderMode;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(SurfaceView view, int renderMode, int backgroundColor) {
        this.renderView = view;
        this.renderSurface = null;
        this.renderMode = renderMode;
        this.backgroundColor = backgroundColor;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(TextureView view, int renderMode, int backgroundColor) {
        this.renderView = view;
        this.renderSurface = null;
        this.renderMode = renderMode;
        this.backgroundColor = backgroundColor;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(Surface surface, int renderMode) {
        this.renderSurface = surface;
        this.renderView = null;
        this.renderMode = renderMode;
        this.backgroundColor = 0;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public VideoCanvas(Surface surface, int renderMode, int backgroundColor) {
        this.renderSurface = surface;
        this.renderView = null;
        this.renderMode = renderMode;
        this.backgroundColor = backgroundColor;
        this.renderRotation = VideoRotation.VIDEO_ROTATION_0;
    }

    public String toString() {
        return "VideoCanvas{, textureView=" + this.renderView + ", surface=" + this.renderSurface + ", renderMode=" + this.renderMode + ", background_color=" + this.backgroundColor + ", renderRotation=" + this.renderRotation.value() + AbstractJsonLexerKt.END_OBJ;
    }
}
