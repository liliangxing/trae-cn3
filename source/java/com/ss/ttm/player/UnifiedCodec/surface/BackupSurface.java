package com.ss.ttm.player.UnifiedCodec.surface;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes7.dex */
public final class BackupSurface extends Surface {
    private final SurfaceTexture mSurfaceTexture;

    public BackupSurface(SurfaceTexture surfaceTexture) {
        super(surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
    }

    public final SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }
}
