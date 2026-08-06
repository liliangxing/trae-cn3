package com.bytedance.bmf_mods_lite_api.packageHandler;

/* loaded from: classes3.dex */
public class PackageEnum {

    /* loaded from: classes3.dex */
    public static class BMFGLTextureFormat {
        public static final int BMF_GLES_TEXTURE_RGBA = 0;
        public static final int BMF_GLES_TEXTURE_RGBA8UI = 1;
        public static final int BMF_GLES_TEXTURE_YUV = 2;
        public static final int BMF_GLES_TEXTURE_YV12 = 3;
    }

    /* loaded from: classes3.dex */
    public static class BMFMemoryType {
        public static final int BMF_MEMORY_AHardwareBuffer = 8;
        public static final int BMF_MEMORY_BYTE_MEMORY = 1;
        public static final int BMF_MEMORY_Bitmap = 11;
        public static final int BMF_MEMORY_OpenGLTexture2d = 3;
        public static final int BMF_MEMORY_OpenGLTextureExternalOes = 4;
        public static final int BMF_MEMORY_UNKNOWN = 0;
    }

    /* loaded from: classes3.dex */
    public static class BMFSuperSceneType {
        public static final int BMF_SUPER_RESOLUTION_SCENE_IMAGE = 1;
        public static final int BMF_SUPER_RESOLUTION_SCENE_VIDEO = 0;
    }

    /* loaded from: classes3.dex */
    public static class BmfAlgorithmBackend {
        public static final int BMF_CPU = 1;
        public static final int BMF_DSP = 4;
        public static final int BMF_OPENCL = 2;
        public static final int BMF_OPENGL = 3;
        public static final int BMF_VULKAN = 5;
    }

    /* loaded from: classes3.dex */
    public static class BmfAlgorithmType {
        public static final int BMF_ALGORITHM_DENOISE = 1;
        public static final int BMF_ALGORITHM_NOISE_LIVE = 3;
        public static final int BMF_ALGORITHM_SHARP = 2;
        public static final int BMF_ALGORITHM_SUPER_RESOLUTION = 0;
        public static final int BMF_ALGORITHM_VQSCORE = 4;
    }

    /* loaded from: classes3.dex */
    public static class BmfDenoiseAlgType {
        public static final int BMF_DENOISE_V4_1 = 5;
    }

    /* loaded from: classes3.dex */
    public static class BmfPackageAlgStatusEum {
        public static final int BMF_PACKAGE_ALG_STATUS_INITIALIZED = 2;
        public static final int BMF_PACKAGE_ALG_STATUS_INITIALIZING = 1;
        public static final int BMF_PACKAGE_ALG_STATUS_INIT_FAILED = 3;
        public static final int BMF_PACKAGE_ALG_STATUS_UNINIT = 0;
    }

    /* loaded from: classes3.dex */
    public static class BmfPackageIndex {
        public static final int BMF_PACKAGE_INDEX_IMAGE = 4;
        public static final int BMF_PACKAGE_INDEX_INCREASE = -100;
        public static final int BMF_PACKAGE_INDEX_LIVE = 2;
        public static final int BMF_PACKAGE_INDEX_RTC = 5;
        public static final int BMF_PACKAGE_INDEX_RTC_DENOISE = 100;
        public static final int BMF_PACKAGE_INDEX_RTC_SHARP = 101;
        public static final int BMF_PACKAGE_INDEX_RTC_SR = 102;
        public static final int BMF_PACKAGE_INDEX_VOD = 1;
        public static final int BMF_PACKAGE_INDEX_VOD_LIVE = 3;
    }

    /* loaded from: classes3.dex */
    public static class BmfParamKey {
        public static final int BMF_FLOAT = 900003;
        public static final int BMF_FLOAT_LIST = 900004;
        public static final int BMF_INT = 900001;
        public static final int BMF_INT_LIST = 900002;
        public static final int BMF_PARAM_DOWNLOAD_ACCESS_KEY = 1002;
        public static final int BMF_PARAM_DOWNLOAD_APP_CONTEXT = 1004;
        public static final int BMF_PARAM_DOWNLOAD_APP_ID = 1005;
        public static final int BMF_PARAM_DOWNLOAD_APP_VERSION = 1006;
        public static final int BMF_PARAM_DOWNLOAD_DEVICE_ID = 1007;
        public static final int BMF_PARAM_DOWNLOAD_GROUP_IDS = 12001;
        public static final int BMF_PARAM_DOWNLOAD_HOST = 1001;
        public static final int BMF_PARAM_DOWNLOAD_MODEL_NAME = 1003;
        public static final int BMF_PARAM_DOWNLOAD_MODEL_NAME_PREFIX = 12002;
        public static final int BMF_PARAM_DOWNLOAD_MODEL_PATH = 1031;
        public static final int BMF_PARAM_DOWNLOAD_RESULT = 1030;
        public static final int BMF_PARAM_HANDLER_NAME = 102;
        public static final int BMF_PARAM_INIT_ALG = 1101;
        public static final int BMF_PARAM_INIT_ALG_TYPE = 1102;
        public static final int BMF_PARAM_INIT_BACKEND = 1104;
        public static final int BMF_PARAM_INIT_G0 = 11105;
        public static final int BMF_PARAM_INIT_GROUPS = 12101;
        public static final int BMF_PARAM_INIT_LC_WEIGHT_THR = 11106;
        public static final int BMF_PARAM_INIT_LIBRARY_PATH = 1108;
        public static final int BMF_PARAM_INIT_MAX_HEIGHT = 1106;
        public static final int BMF_PARAM_INIT_MAX_WIDTH = 1105;
        public static final int BMF_PARAM_INIT_MIDDLE_ISO_TH = 13102;
        public static final int BMF_PARAM_INIT_MIDDLE_ISO_WEIGHT = 13105;
        public static final int BMF_PARAM_INIT_MODEL_NAME_PREFIX = 12102;
        public static final int BMF_PARAM_INIT_MODEL_PATH = 1109;
        public static final int BMF_PARAM_INIT_OVER_RATIO = 11103;
        public static final int BMF_PARAM_INIT_PROGRAM_CACHE_DIR = 1107;
        public static final int BMF_PARAM_INIT_SCALE_TYPE = 1103;
        public static final int BMF_PARAM_INIT_SR_DRAW_TO_SCREEN = 10102;
        public static final int BMF_PARAM_INIT_SR_SCENE = 10101;
        public static final int BMF_PARAM_INIT_STRONG_ISO_TH = 13101;
        public static final int BMF_PARAM_INIT_THRESHOLD = 11102;
        public static final int BMF_PARAM_INIT_USE_ADAPTIVE_CONTROL = 11104;
        public static final int BMF_PARAM_INIT_WEAK_ISO_TH = 13103;
        public static final int BMF_PARAM_INIT_WEAK_ISO_WEIGHT = 13104;
        public static final int BMF_PARAM_INIT_WEIGHT = 11101;
        public static final int BMF_PARAM_INSTANCE_SIZE = 302;
        public static final int BMF_PARAM_MAX_INSTANCE_SIZE = 104;
        public static final int BMF_PARAM_MAX_POOL_SIZE = 103;
        public static final int BMF_PARAM_PACKAGE_INDEX = 101;
        public static final int BMF_PARAM_POOL_SIZE = 301;
        public static final int BMF_PARAM_PROCESS_CM = 1202;
        public static final int BMF_PARAM_PROCESS_CO = 1203;
        public static final int BMF_PARAM_PROCESS_DISABLE_NON_IDENTITY_MATRIX_CVT = 10206;
        public static final int BMF_PARAM_PROCESS_ENABLE_OVERSHOOT_REDUCTION = 10203;
        public static final int BMF_PARAM_PROCESS_GROUP_INDEX = 12203;
        public static final int BMF_PARAM_PROCESS_INTERVAL = 12202;
        public static final int BMF_PARAM_PROCESS_ISO = 13201;
        public static final int BMF_PARAM_PROCESS_MIDDLE_VIDEO_CREATE = 1302;
        public static final int BMF_PARAM_PROCESS_MVP = 1201;
        public static final int BMF_PARAM_PROCESS_NEW_VIDEO = 1209;
        public static final int BMF_PARAM_PROCESS_OUTPUT_VIDEO_CREATE = 1301;
        public static final int BMF_PARAM_PROCESS_OVERSHOOT_COEFFICIENT = 10205;
        public static final int BMF_PARAM_PROCESS_OVERSHOOT_THRESHOLD = 10204;
        public static final int BMF_PARAM_PROCESS_PATH = 1303;
        public static final int BMF_PARAM_PROCESS_ROI_H = 1208;
        public static final int BMF_PARAM_PROCESS_ROI_H_START = 1206;
        public static final int BMF_PARAM_PROCESS_ROI_MODE = 1204;
        public static final int BMF_PARAM_PROCESS_ROI_W = 1207;
        public static final int BMF_PARAM_PROCESS_ROI_W_START = 1205;
        public static final int BMF_PARAM_PROCESS_SCALE_TYPE = 10201;
        public static final int BMF_PARAM_PROCESS_SHARP_G0 = 11205;
        public static final int BMF_PARAM_PROCESS_SHARP_LC_WEIGHT_THR = 11206;
        public static final int BMF_PARAM_PROCESS_SHARP_LEVEL = 10202;
        public static final int BMF_PARAM_PROCESS_SHARP_OVER_RATIO = 11203;
        public static final int BMF_PARAM_PROCESS_SHARP_THRESHOLD = 11202;
        public static final int BMF_PARAM_PROCESS_SHARP_USE_ADAPTIVE_CONTROL = 11204;
        public static final int BMF_PARAM_PROCESS_SHARP_WEIGHT = 11201;
        public static final int BMF_PARAM_PROCESS_SR_DRAW_TO_SCREEN = 10207;
        public static final int BMF_PARAM_PROCESS_SR_VIEWPORT = 10208;
        public static final int BMF_PARAM_RESERVED = 0;
        public static final int BMF_STRING = 900005;
        public static final int BMF_STRING_LIST = 900006;
    }

    /* loaded from: classes3.dex */
    public static class BmfSharpAlgType {
        public static final int BMF_SHARP_V1_2 = 1;
        public static final int BMF_SHARP_V2_1 = 2;
    }

    /* loaded from: classes3.dex */
    public static class BmfSuperAlgType {
        public static final int BMF_PACKAGE_SRHP_V1_3 = 10103;
        public static final int BMF_PACKAGE_SRHP_V1_4 = 10104;
        public static final int BMF_PACKAGE_SRHP_V2_2 = 10202;
        public static final int BMF_PACKAGE_SRHP_V3_6 = 10306;
        public static final int BMF_PACKAGE_SRHP_V4_1 = 10401;
        public static final int BMF_PACKAGE_SRLL_COMPOUND = 20301;
        public static final int BMF_PACKAGE_SRLL_V2_1 = 20201;
        public static final int BMF_SUPER_RESOLUTION_V1_4 = 4;
        public static final int BMF_SUPER_RESOLUTION_V3_6 = 14;
    }

    /* loaded from: classes3.dex */
    public static class BmfSuperScaleType {
        public static final int BMF_SUPER_RESOLUTION_SCALE_11X = 4;
        public static final int BMF_SUPER_RESOLUTION_SCALE_125X = 64;
        public static final int BMF_SUPER_RESOLUTION_SCALE_12X = 8;
        public static final int BMF_SUPER_RESOLUTION_SCALE_13X = 16;
        public static final int BMF_SUPER_RESOLUTION_SCALE_14X = 32;
        public static final int BMF_SUPER_RESOLUTION_SCALE_15X = 1;
        public static final int BMF_SUPER_RESOLUTION_SCALE_20X = 2;
        public static final int BMF_SUPER_RESOLUTION_SCALE_ALL = 32768;
    }

    /* loaded from: classes3.dex */
    public static class BmfWindowType {
        public static final int BMF_WINDOW_3X3_TYPE = 1;
        public static final int BMF_WINDOW_5X5_TYPE = 0;
    }
}
