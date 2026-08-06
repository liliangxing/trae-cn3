package com.optimize.statistics;

import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class ImageMonitorUtils {
    private static final int CACHE_CHOICE_DEFAULT = 0;
    private static final int CACHE_CHOICE_SMALL = 1;
    private static final int DECODE = 300;
    private static final int DECODE_ARGUMENT_BYTEBUFFER = 301;
    private static final int DECODE_ARGUMENT_DEMUXER = 302;
    private static final int DECODE_ARGUMENT_EXIST_BITMAP = 304;
    private static final int DECODE_ARGUMENT_NEGATIVE = 303;
    private static final int DECODE_RUNTIME_MALFORMED = 317;
    private static final int DECODE_RUNTIME_PIXEL = 318;
    private static final int DECODE_STATE_BAD_BITMAP = 310;
    private static final int DECODE_STATE_DIMENSIONS = 305;
    private static final int DECODE_STATE_DISPOSED = 308;
    private static final int DECODE_STATE_FORMAT = 312;
    private static final int DECODE_STATE_FRAME = 315;
    private static final int DECODE_STATE_GET_FAME = 309;
    private static final int DECODE_STATE_NO_FAMES = 307;
    private static final int DECODE_STATE_SLURP = 306;
    private static final int DECODE_STATE_SMALL = 311;
    private static final int DECODE_STATE_WEBP_FACTORY = 316;
    private static final int DECODE_STATE_WEBP_FEATURES = 314;
    private static final int DECODE_STATE_WEBP_INIT = 313;
    static final int IMAGE_ORIGIN_UNKNOWN = 7;

    /* renamed from: IO */
    private static final int f28IO = 200;
    private static final int IO_EXCEPTION = 201;
    private static final int NETWORK = 100;
    private static final int OTHER = 600;
    private static final int OTHER_MEMORY = 602;
    private static final int OTHER_TOOMANYBITMAPS_EXCEPTION = 601;
    private static final int STATUS_CANCEL = 2;
    private static final int STATUS_ERROR = 1;
    private static final int STATUS_NETWORK_NOT_AVAILABLE = 3;
    static final int STATUS_SUCCESS = 0;
    private static final int THREAD = 500;
    private static final int THREAD_INTERRUPTED_EXCEPTION = 501;
    private static final int TRANSCODE = 400;
    private static final int TRANSCODE_PIXEL = 401;
    private static final int TRANSCODE_SCANLINE = 402;
    private static final int UNKNOWN = 700;

    ImageMonitorUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getImageLoadErrorCode(Throwable th, boolean z) {
        if (th == null) {
            return 700;
        }
        String message = th.getMessage();
        if (z) {
            return 100;
        }
        if (th instanceof IOException) {
            return 201;
        }
        if (th instanceof InterruptedException) {
            return 501;
        }
        if (th instanceof TooManyBitmapsException) {
            return 601;
        }
        if (th instanceof IllegalArgumentException) {
            if (message.contains("ByteBuffer must be direct")) {
                return 301;
            }
            if (message.contains("Failed to create demuxer")) {
                return 302;
            }
            if (message.contains("Width or height is negative")) {
                return 303;
            }
            return message.contains("Problem decoding into existing bitmap") ? 304 : 700;
        }
        if (th instanceof IllegalStateException) {
            if (message.contains("Invalid dimensions")) {
                return 305;
            }
            if (message.contains("Failed to slurp image")) {
                return 306;
            }
            if (message.contains("No fames in image")) {
                return 307;
            }
            if (message.contains("Already disposed")) {
                return 308;
            }
            if (message.contains("unable to get frame")) {
                return 309;
            }
            if (message.contains("Bad bitmap")) {
                return 310;
            }
            if (message.contains("Width or height is too small")) {
                return 311;
            }
            if (message.contains("Wrong color format")) {
                return 312;
            }
            if (message.contains("WebPInitDecoderConfig failed")) {
                return 313;
            }
            if (message.contains("WebPGetFeatures failed")) {
                return 314;
            }
            if (message.contains("Failed to decode frame. VP8StatusCode:")) {
                return 315;
            }
            return message.contains("WebpBitmapFactory is null") ? 316 : 700;
        }
        if (!(th instanceof RuntimeException)) {
            return 700;
        }
        if (message.contains("Could not create WebPDemux from image. This webp might be malformed")) {
            return 317;
        }
        if (message.contains("unrecognized pixel format")) {
            return 318;
        }
        if (message.contains("Wrong pixel format for jpeg encoding")) {
            return 401;
        }
        if (message.contains("Could not write scanline")) {
            return 402;
        }
        return message.contains("could not allocate memory") ? 602 : 700;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getImageMonitorDataStatus(Throwable th) {
        String message;
        if (th == null || (message = th.getMessage()) == null || message.length() == 0) {
            return 1;
        }
        if (message.contains("canceled") || message.contains("Canceled")) {
            return 2;
        }
        return message.contains("network not available") ? 3 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mapCacheChoiceToDiskCacheType(ImageRequest.CacheChoice cacheChoice) {
        return cacheChoice.equals(ImageRequest.CacheChoice.DEFAULT) ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int mapProducerNameToImageMonitorOrigin(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1914072202:
                if (str.equals("BitmapMemoryCacheGetProducer")) {
                    c = 0;
                    break;
                }
                break;
            case -1307634203:
                if (str.equals("EncodedMemoryCacheProducer")) {
                    c = 1;
                    break;
                }
                break;
            case -1224383234:
                if (str.equals("NetworkFetchProducer")) {
                    c = 2;
                    break;
                }
                break;
            case 656304759:
                if (str.equals("DiskCacheProducer")) {
                    c = 3;
                    break;
                }
                break;
            case 957714404:
                if (str.equals("BitmapMemoryCacheProducer")) {
                    c = 4;
                    break;
                }
                break;
            case 1023071510:
                if (str.equals("PostprocessedBitmapMemoryCacheProducer")) {
                    c = 5;
                    break;
                }
                break;
            case 2109593398:
                if (str.equals("PartialDiskCacheProducer")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 4:
                return 5;
            case 1:
                return 4;
            case 2:
                return 1;
            case 3:
                return 3;
            case 5:
                return 6;
            case 6:
                return 2;
            default:
                return 7;
        }
    }
}
