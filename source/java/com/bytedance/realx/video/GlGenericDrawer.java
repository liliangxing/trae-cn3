package com.bytedance.realx.video;

import android.opengl.GLES20;
import android.util.Log;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.video.RendererCommon;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: classes4.dex */
public class GlGenericDrawer implements RendererCommon.GlDrawer {
    private static final String DEFAULT_VERTEX_SHADER_STRING = "varying vec2 tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\nuniform mat4 tex_mat;\nvoid main() {\n  gl_Position = in_pos;\n  tc = (tex_mat * in_tc).xy;\n}\n";
    private static final FloatBuffer FULL_RECTANGLE_BUFFER = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer FULL_RECTANGLE_TEXTURE_BUFFER = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private static final String INPUT_TEXTURE_COORDINATE_NAME = "in_tc";
    private static final String INPUT_VERTEX_COORDINATE_NAME = "in_pos";
    private static final String ORI_TEX_SIZE_NAME = "ori_tex_size";
    private static final String TAR_TEX_SIZE_NAME = "tar_tex_size";
    private static final String TEXTURE_MATRIX_NAME = "tex_mat";
    private FilterType currentScaleFilter;
    private GlShader currentShader;
    private ShaderType currentShaderType;
    private int dstHeight;
    private int dstWidth;
    private int frameHeight;
    private int frameWidth;
    private final String genericFragmentSource;
    private int inPosLocation;
    private int inTcLocation;
    private FloatBuffer mPosCoordinate;
    private int oriTexSizeLocation;
    private final ShaderCallbacks shaderCallbacks;
    private int tarTexSizeLocation;
    private int texMatrixLocation;
    private final String vertexShader;

    /* loaded from: classes4.dex */
    public interface ShaderCallbacks {
        void onNewShader(GlShader shader);

        void onPrepareShader(GlShader shader, float[] texMatrix, int frameWidth, int frameHeight, int viewportWidth, int viewportHeight);
    }

    /* loaded from: classes4.dex */
    public enum ShaderType {
        OES,
        RGB,
        YUV
    }

    static String createFragmentShaderString(String genericFragmentSource, ShaderType shaderType, FilterType scaleFilter) {
        StringBuilder sb = new StringBuilder();
        if (shaderType == ShaderType.OES) {
            sb.append("#extension GL_OES_EGL_image_external : require\n");
        }
        sb.append("precision mediump float;\nvarying vec2 tc;\n");
        if (scaleFilter != FilterType.Origin) {
            sb.append("uniform vec2 tar_tex_size;\nuniform vec2 ori_tex_size;\n");
        }
        if (shaderType == ShaderType.YUV) {
            sb.append("uniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n");
            if (scaleFilter == FilterType.Bilinear) {
                sb.append("float bilinearTextureSample(sampler2D tex, vec2 p) {\n        vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    float C11 = texture2D(tex, p - c_onePixel).r;\n    float C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).r;\n    float C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n    float C22 = texture2D(tex, p + c_onePixel).r;\n    float x1 = mix(C11, C21, frac.x);\n    float x2 = mix(C12, C22, frac.x);\n    return mix(x1, x2, frac.y);\n}\nvec4 sample(vec2 p) {\n  float y = bilinearTextureSample(y_tex, p) * 1.16438;\n  float u = bilinearTextureSample(u_tex, p);\n  float v = bilinearTextureSample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
            } else if (scaleFilter == FilterType.Bicubic) {
                sb.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n\t  float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 bicubic_sample (sampler2D tex, , vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\nvec4 sample(vec2 p) {\n  float y = bicubic_sample(y_tex, p) * 1.16438;\n  float u = bicubic_sample(u_tex, p);\n  float v = bicubic_sample(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
            } else if (scaleFilter == FilterType.BOX) {
                sb.append("float box_filter(sampler2D tex, vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  float C11, C12, C13, C21, C22, C23, C31, C32, C33;\n  C11 = texture2D(tex, p - c_onePixel).r;\n  C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).r;\n  C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).r;\n  C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).r;\n  C22 = texture2D(tex, p).r;\n  C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).r;\n  C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).r;\n  C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).r;\n  C33 = texture2D(tex, p + c_onePixel).r;\n  return (C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0;\n}\nvec4 sample(vec2 p) {\n  float y = box_filter(y_tex, p) * 1.16438;\n  float u = box_filter(u_tex, p);\n  float v = box_filter(v_tex, p);\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
            } else {
                sb.append("vec4 sample(vec2 p) {\n  float y = texture2D(y_tex, p).r * 1.16438;\n  float u = texture2D(u_tex, p).r;\n  float v = texture2D(v_tex, p).r;\n  return vec4(y + 1.59603 * v - 0.874202,\n    y - 0.391762 * u - 0.812968 * v + 0.531668,\n    y + 2.01723 * u - 1.08563, 1);\n}\n");
            }
            sb.append(genericFragmentSource);
        } else {
            sb.append("uniform ").append(shaderType == ShaderType.OES ? "samplerExternalOES" : "sampler2D").append(" tex;\n");
            if (scaleFilter == FilterType.Bilinear) {
                sb.append("vec4 sample(vec2 p) {\n    vec2 c_onePixel =  vec2(1.0 / ori_tex_size.y - tar_tex_size.x + tar_tex_size.x, 1.0 / ori_tex_size.y);\n    vec2 frac = vec2(0.5, 0.5);\n    vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n    vec3 C21 = texture2D(tex, p + vec2( c_onePixel.x , -c_onePixel.y)).rgb;\n    vec3 C12 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n    vec3 C22 = texture2D(tex, p + c_onePixel).rgb;\n    vec3 x1 = mix(C11, C21, frac.x);\n    vec3 x2 = mix(C12, C22, frac.x);\n    return vec4(mix(x1, x2, frac.y), 1);\n}\n");
                sb.append(genericFragmentSource);
            } else if (scaleFilter == FilterType.Bicubic) {
                sb.append("vec3 cubic_hermite (vec3 A, vec3 B, vec3 C, vec3 D, float t) {\n\t  float t2 = t*t;\n    float t3 = t*t*t;\n    vec3 a = -A/2.0 + (3.0*B)/2.0 - (3.0*C)/2.0 + D/2.0;\n    vec3 b = A - (5.0*B)/2.0 + 2.0*C - D / 2.0;\n    vec3 c = -A/2.0 + C/2.0;\n   \tvec3 d = B;\n    return a*t3 + b*t2 + c*t + d;\n}\nvec4 sample (vec2 P) {\n    float c_onePixel_x = 1.0 / ori_tex_size.x - tar_tex_size.x + tar_tex_size.x;\n    float c_onePixel_y = 1.0 / ori_tex_size.y;\n    float c_twoPixels_x = 2.0 / ori_tex_size.x;\n    float c_twoPixels_y = 2.0 / ori_tex_size.y;\n    vec2 pixel = vec2(P.x * ori_tex_size.x, P.y * ori_tex_size.y) + 0.5;\n    vec2 frac = fract(pixel);\n    pixel = floor(pixel);\n    pixel = vec2(pixel.x / ori_tex_size.x, pixel.y / ori_tex_size.y) - vec2(c_onePixel_x, c_onePixel_y) / 2.0;\n    vec3 C00 = texture2D(tex, pixel + vec2(-c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C10 = texture2D(tex, pixel + vec2( 0.0        ,-c_onePixel_y)).rgb;\n    vec3 C20 = texture2D(tex, pixel + vec2( c_onePixel_x ,-c_onePixel_y)).rgb;\n    vec3 C30 = texture2D(tex, pixel + vec2( c_twoPixels_x,-c_onePixel_y)).rgb;\n    vec3 C01 = texture2D(tex, pixel + vec2(-c_onePixel_x , 0.0)).rgb;\n    vec3 C11 = texture2D(tex, pixel + vec2( 0.0        , 0.0)).rgb;\n    vec3 C21 = texture2D(tex, pixel + vec2( c_onePixel_x , 0.0)).rgb;\n    vec3 C31 = texture2D(tex, pixel + vec2( c_twoPixels_x, 0.0)).rgb;\n    vec3 C02 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C12 = texture2D(tex, pixel + vec2( 0.0        , c_onePixel_y)).rgb;\n    vec3 C22 = texture2D(tex, pixel + vec2( c_onePixel_x , c_onePixel_y)).rgb;\n    vec3 C32 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_onePixel_y)).rgb;\n    vec3 C03 = texture2D(tex, pixel + vec2(-c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C13 = texture2D(tex, pixel + vec2( 0.0        , c_twoPixels_y)).rgb;\n    vec3 C23 = texture2D(tex, pixel + vec2( c_onePixel_x , c_twoPixels_y)).rgb;\n    vec3 C33 = texture2D(tex, pixel + vec2( c_twoPixels_x, c_twoPixels_y)).rgb;  \n    vec3 CP0X = cubic_hermite(C00, C10, C20, C30, frac.x);\n    vec3 CP1X = cubic_hermite(C01, C11, C21, C31, frac.x);\n    vec3 CP2X = cubic_hermite(C02, C12, C22, C32, frac.x);\n    vec3 CP3X = cubic_hermite(C03, C13, C23, C33, frac.x);\n    return vec4(cubic_hermite(CP0X, CP1X, CP2X, CP3X, frac.y), 1.0);}\n");
                sb.append(genericFragmentSource);
            } else if (scaleFilter == FilterType.BOX) {
                sb.append("vec4 sample(vec2 p) {\n  vec2 c_onePixel =  1.0 / ori_tex_size;\n  vec3 C11 = texture2D(tex, p - c_onePixel).rgb;\n  vec3 C12 = texture2D(tex, p + vec2( 0, -c_onePixel.y)).rgb;\n  vec3 C13 = texture2D(tex, p + vec2( c_onePixel.x, -c_onePixel.y)).rgb;\n  vec3 C21 = texture2D(tex, p + vec2( -c_onePixel.x , 0)).rgb;\n  vec3 C22 = texture2D(tex, p).rgb;\n  vec3 C23 = texture2D(tex, p + vec2( c_onePixel.x , 0)).rgb;\n  vec3 C31 = texture2D(tex, p + vec2( -c_onePixel.x , c_onePixel.y)).rgb;\n  vec3 C32 = texture2D(tex, p + vec2( 0 , c_onePixel.y)).rgb;\n  vec3 C33 = texture2D(tex, p + c_onePixel).rgb;\n  return vec4((C11 + C12 + C13 + C21 + C22 + C23 + C31 + C32 + C33) / 9.0, 1.0);\n}\n");
                sb.append(genericFragmentSource);
            } else {
                sb.append(genericFragmentSource.replace("sample(", "texture2D(tex, "));
            }
        }
        return sb.toString();
    }

    public GlGenericDrawer(String genericFragmentSource, ShaderCallbacks shaderCallbacks) {
        this(DEFAULT_VERTEX_SHADER_STRING, genericFragmentSource, shaderCallbacks);
    }

    public GlGenericDrawer(String vertexShader, String genericFragmentSource, ShaderCallbacks shaderCallbacks) {
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        this.vertexShader = vertexShader;
        this.genericFragmentSource = genericFragmentSource;
        this.shaderCallbacks = shaderCallbacks;
    }

    GlShader createShader(ShaderType shaderType, FilterType scaleFilter) {
        return new GlShader(this.vertexShader, createFragmentShaderString(this.genericFragmentSource, shaderType, scaleFilter));
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawOes(int oesTextureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight) {
        drawOes(oesTextureId, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawRgb(int textureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight) {
        drawRgb(textureId, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawYuv(int[] yuvTextures, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight) {
        drawYuv(yuvTextures, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, FilterType.Origin, 0, 0);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawOes(int oesTextureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight, int dstWidth, int dstHeight) {
        prepareTexAndPosCoord(frameWidth, frameHeight, dstWidth, dstHeight);
        drawOes(oesTextureId, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawRgb(int textureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight, int dstWidth, int dstHeight) {
        prepareTexAndPosCoord(frameWidth, frameHeight, dstWidth, dstHeight);
        drawRgb(textureId, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawYuv(int[] yuvTextures, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight, int dstWidth, int dstHeight) {
        prepareTexAndPosCoord(frameWidth, frameHeight, dstWidth, dstHeight);
        drawYuv(yuvTextures, texMatrix, frameWidth, frameHeight, viewportX, viewportY, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawOes(int oesTextureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        prepareShader(ShaderType.OES, texMatrix, frameWidth, frameHeight, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, oesTextureId);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlGenericDrawer", "drawOes glBindTexture error: " + glGetError);
            RXLogging.e("GlGenericDrawer", "drawOes glBindTexture error: " + glGetError);
        } else {
            GLES20.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(36197, 0);
            GlUtil.checkNoGLES2Error("drawOes done");
        }
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawRgb(int textureId, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        prepareShader(ShaderType.RGB, texMatrix, frameWidth, frameHeight, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
        GlUtil.checkNoGLES2Error("after prepare shader");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, textureId);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlGenericDrawer", "drawRgb glBindTexture error: " + glGetError);
            RXLogging.e("GlGenericDrawer", "drawRgb glBindTexture error: " + glGetError);
        } else {
            GLES20.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glBindTexture(3553, 0);
            GlUtil.checkNoGLES2Error("drawRgb done");
        }
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void drawYuv(int[] yuvTextures, float[] texMatrix, int frameWidth, int frameHeight, int viewportX, int viewportY, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        prepareShader(ShaderType.YUV, texMatrix, frameWidth, frameHeight, viewportWidth, viewportHeight, scaleFilter, unscaleWidth, unscaleHeight);
        for (int i = 0; i < 3; i++) {
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, yuvTextures[i]);
        }
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GlGenericDrawer", "drawYuv glBindTexture error: " + glGetError);
            RXLogging.e("GlGenericDrawer", "drawYuv glBindTexture error: " + glGetError);
            return;
        }
        GLES20.glViewport(viewportX, viewportY, viewportWidth, viewportHeight);
        GLES20.glDrawArrays(5, 0, 4);
        for (int i2 = 0; i2 < 3; i2++) {
            GLES20.glActiveTexture(i2 + 33984);
            GLES20.glBindTexture(3553, 0);
        }
        GlUtil.checkNoGLES2Error("drawYuv done");
    }

    private void prepareShader(ShaderType shaderType, float[] texMatrix, int frameWidth, int frameHeight, int viewportWidth, int viewportHeight, FilterType scaleFilter, int unscaleWidth, int unscaleHeight) {
        FilterType filterType;
        int i;
        int i2;
        GlShader glShader;
        if (scaleFilter == null || unscaleWidth == 0 || unscaleHeight == 0) {
            filterType = FilterType.Origin;
            i = 0;
            i2 = 0;
        } else {
            filterType = scaleFilter;
            i = unscaleWidth;
            i2 = unscaleHeight;
        }
        if (shaderType.equals(this.currentShaderType) && filterType.equals(this.currentScaleFilter)) {
            glShader = this.currentShader;
        } else {
            this.currentShaderType = shaderType;
            GlShader glShader2 = this.currentShader;
            if (glShader2 != null) {
                glShader2.release();
            }
            GlShader createShader = createShader(shaderType, filterType);
            this.currentShader = createShader;
            this.currentScaleFilter = filterType;
            createShader.useProgram();
            if (shaderType == ShaderType.YUV) {
                GLES20.glUniform1i(createShader.getUniformLocation("y_tex"), 0);
                GLES20.glUniform1i(createShader.getUniformLocation("u_tex"), 1);
                GLES20.glUniform1i(createShader.getUniformLocation("v_tex"), 2);
            } else {
                GLES20.glUniform1i(createShader.getUniformLocation("tex"), 0);
            }
            GlUtil.checkNoGLES2Error("Create shader");
            this.shaderCallbacks.onNewShader(createShader);
            this.texMatrixLocation = createShader.getUniformLocation(TEXTURE_MATRIX_NAME);
            this.inPosLocation = createShader.getAttribLocation(INPUT_VERTEX_COORDINATE_NAME);
            this.inTcLocation = createShader.getAttribLocation(INPUT_TEXTURE_COORDINATE_NAME);
            glShader = createShader;
        }
        if (filterType != FilterType.Origin) {
            if (filterType != FilterType.BOX) {
                this.tarTexSizeLocation = glShader.getUniformLocation(TAR_TEX_SIZE_NAME);
            }
            this.oriTexSizeLocation = glShader.getUniformLocation(ORI_TEX_SIZE_NAME);
        }
        GlUtil.checkNoGLES2Error("before useProgram ");
        glShader.useProgram();
        GLES20.glEnableVertexAttribArray(this.inPosLocation);
        GLES20.glVertexAttribPointer(this.inPosLocation, 2, 5126, false, 0, (Buffer) this.mPosCoordinate);
        GLES20.glEnableVertexAttribArray(this.inTcLocation);
        GLES20.glVertexAttribPointer(this.inTcLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_TEXTURE_BUFFER);
        GLES20.glUniformMatrix4fv(this.texMatrixLocation, 1, false, texMatrix, 0);
        if (filterType != FilterType.Origin && i > 0 && i > 0) {
            int i3 = this.tarTexSizeLocation;
            if (i3 != 0) {
                GLES20.glUniform2f(i3, frameWidth, frameHeight);
            }
            int i4 = this.oriTexSizeLocation;
            if (i4 != 0) {
                GLES20.glUniform2f(i4, i, i2);
            }
        }
        this.shaderCallbacks.onPrepareShader(glShader, texMatrix, frameWidth, frameHeight, viewportWidth, viewportHeight);
        GlUtil.checkNoGLES2Error("Prepare shader");
    }

    private void prepareTexAndPosCoord(int srcWidth, int srcHeight, int dstWidth, int dstHeight) {
        if (dstWidth == 0 || dstHeight == 0 || srcWidth > dstWidth || srcHeight > dstHeight) {
            return;
        }
        if (this.frameWidth == srcWidth && this.frameHeight == srcHeight && this.dstWidth == dstWidth && this.dstHeight == dstHeight) {
            return;
        }
        this.frameWidth = srcWidth;
        this.frameHeight = srcHeight;
        this.dstWidth = dstWidth;
        this.dstHeight = dstHeight;
        float f = (((dstHeight - srcHeight) * 2.0f) / dstHeight) - 1.0f;
        float f2 = ((srcWidth * 2.0f) / dstWidth) - 1.0f;
        this.mPosCoordinate = GlUtil.createFloatBuffer(new float[]{-1.0f, f, f2, f, -1.0f, 1.0f, f2, 1.0f});
    }

    @Override // com.bytedance.realx.video.RendererCommon.GlDrawer
    public void release() {
        GlShader glShader = this.currentShader;
        if (glShader != null) {
            glShader.release();
            this.currentShader = null;
            this.currentShaderType = null;
        }
    }
}
