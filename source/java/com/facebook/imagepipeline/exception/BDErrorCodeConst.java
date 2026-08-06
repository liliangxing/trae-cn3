package com.facebook.imagepipeline.exception;

/* loaded from: classes6.dex */
public final class BDErrorCodeConst {
    public static final int BD_ERROR_CODE_DATA_PARSE = 900001;
    public static final int BD_ERROR_CODE_EMPTY_PIXEL_DATA = 900002;
    public static final int BD_ERROR_CODE_IMAGE_FORMAT = 900007;
    public static final int BD_ERROR_CODE_OUT_OF_MEMORY = 900012;
    public static final int BD_ERROR_CODE_REQUEST_CANCELED = -999;
    public static final int BD_ERROR_CODE_SERVER_RESPONSE_ERROR = -1011;
    public static final String BD_ERROR_MSG_DATA_PARSE = "data cannot be parsed.";
    public static final String BD_ERROR_MSG_EMPTY_PIXEL_DATA = "internalDecode result is null,empty pixel data.";
    public static final String BD_ERROR_MSG_IMAGE_FORMAT = "image format error";
    public static final String BD_ERROR_MSG_OUT_OF_MEMORY = "decode out of memory";
    public static final String BD_ERROR_MSG_REQUEST_CANCELED = "request canceled";

    private BDErrorCodeConst() {
    }
}
