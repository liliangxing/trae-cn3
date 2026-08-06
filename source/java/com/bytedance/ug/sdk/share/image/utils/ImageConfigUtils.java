package com.bytedance.ug.sdk.share.image.utils;

import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.constant.ShareConfigConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageConfigUtils {
    private static final int DEFAULT_MAX_MEDIA_SIZE = 10485760;

    public static boolean hideSaveImagePreviewDialog() {
        return ((Boolean) ShareConfigManager.getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_HIDE_SAVE_IMAGE_PREVIEW_DIALOG, false)).booleanValue();
    }

    public static boolean isEnableImageTokenShareOpt() {
        return ((Boolean) ShareConfigManager.getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_OPT_IMAGE_TOKEN_SHARE, false)).booleanValue();
    }

    public static int getCheckAlbumImageNum() {
        return ((Integer) ShareConfigManager.getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_CHECK_ALBUM_IMAGE_NUM, 5)).intValue();
    }

    public static int getMediaParseMaxTime() {
        return ((Integer) ShareConfigManager.getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_MEDIA_PARSE_MAX_TIME, -1)).intValue();
    }

    public static int getMediaParseMaxSize() {
        return ((Integer) ShareConfigManager.getInstance().getExtraConfigByKey(ShareConfigConstants.KEY_MEDIA_PARSE_MAX_SIZE, Integer.valueOf(DEFAULT_MAX_MEDIA_SIZE))).intValue();
    }
}
