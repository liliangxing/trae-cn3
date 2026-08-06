package com.bytedance.realx.video;

import com.bytedance.realx.video.GlGenericDrawer;

/* loaded from: classes4.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    /* loaded from: classes4.dex */
    private static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader shader) {
        }

        @Override // com.bytedance.realx.video.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader shader, float[] texMatrix, int frameWidth, int frameHeight, int viewportWidth, int viewportHeight) {
        }

        private ShaderCallbacks() {
        }
    }

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks());
    }
}
