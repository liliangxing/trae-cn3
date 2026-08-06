package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxFlattenUI$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FlattenUIImage$$PropsSetter extends LynxFlattenUI$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.LynxFlattenUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        FlattenUIImage flattenUIImage = (FlattenUIImage) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1937917490:
                if (str.equals(PropsConstants.CAP_INSETS_SCALE)) {
                    c = 0;
                    break;
                }
                break;
            case -1900756664:
                if (str.equals("enable-super-resolution")) {
                    c = 1;
                    break;
                }
                break;
            case -1492006372:
                if (str.equals(PropsConstants.ENABLE_RESOURCE_HINT)) {
                    c = 2;
                    break;
                }
                break;
            case -1338903714:
                if (str.equals(PropsConstants.SKIP_REDIRECTION)) {
                    c = 3;
                    break;
                }
                break;
            case -1320385523:
                if (str.equals("async-redirect")) {
                    c = 4;
                    break;
                }
                break;
            case -1138223116:
                if (str.equals(PropsConstants.IAMGE_CONFIG)) {
                    c = 5;
                    break;
                }
                break;
            case -934531685:
                if (str.equals(PropsConstants.REPEAT)) {
                    c = 6;
                    break;
                }
                break;
            case -931992873:
                if (str.equals(PropsConstants.ANDROID_IMAGE_SIMPLE_KEY)) {
                    c = 7;
                    break;
                }
                break;
            case -629825370:
                if (str.equals(PropsConstants.LOOP_COUNT)) {
                    c = '\b';
                    break;
                }
                break;
            case -602643660:
                if (str.equals(PropsConstants.FRESCO_NINE_PATCH)) {
                    c = '\t';
                    break;
                }
                break;
            case -320982203:
                if (str.equals(PropsConstants.DISABLE_DEFAULT_RESIZE)) {
                    c = '\n';
                    break;
                }
                break;
            case -256430480:
                if (str.equals(PropsConstants.PRE_FETCH_WIDTH)) {
                    c = 11;
                    break;
                }
                break;
            case 114148:
                if (str.equals(PropsConstants.SRC)) {
                    c = '\f';
                    break;
                }
                break;
            case 3357091:
                if (str.equals(PropsConstants.MODE)) {
                    c = '\r';
                    break;
                }
                break;
            case 108305470:
                if (str.equals(PropsConstants.ENABLE_IMAGE_ASYNC_REQUEST)) {
                    c = 14;
                    break;
                }
                break;
            case 207594941:
                if (str.equals(PropsConstants.PRE_FETCH_HEIGHT)) {
                    c = 15;
                    break;
                }
                break;
            case 259555579:
                if (str.equals("super-resolution-scale")) {
                    c = 16;
                    break;
                }
                break;
            case 263914060:
                if (str.equals(PropsConstants.IMAGE_CACHE_CHOICE)) {
                    c = 17;
                    break;
                }
                break;
            case 516005201:
                if (str.equals(PropsConstants.CAP_INSETS_BACKUP)) {
                    c = 18;
                    break;
                }
                break;
            case 598246771:
                if (str.equals(PropsConstants.PLACEHOLDER)) {
                    c = 19;
                    break;
                }
                break;
            case 681292984:
                if (str.equals(PropsConstants.BLUR_RADIUS)) {
                    c = 20;
                    break;
                }
                break;
            case 828761943:
                if (str.equals(PropsConstants.IMAGE_PRIORITY)) {
                    c = 21;
                    break;
                }
                break;
            case 893413739:
                if (str.equals(PropsConstants.IMAGE_TRANSITION_STYLE)) {
                    c = 22;
                    break;
                }
                break;
            case 902281110:
                if (str.equals(PropsConstants.SUSPENDABLE)) {
                    c = 23;
                    break;
                }
                break;
            case 1338737543:
                if (str.equals(PropsConstants.IMAGE_PLACE_HOLDER_HASH_CONFIG)) {
                    c = 24;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals(PropsConstants.AUTO_PLAY)) {
                    c = 25;
                    break;
                }
                break;
            case 1515751784:
                if (str.equals(PropsConstants.CAP_INSETS)) {
                    c = 26;
                    break;
                }
                break;
            case 1615092063:
                if (str.equals(PropsConstants.AUTO_SIZE)) {
                    c = 27;
                    break;
                }
                break;
            case 1739487650:
                if (str.equals(PropsConstants.DEFER_SRC_INVALIDATION)) {
                    c = 28;
                    break;
                }
                break;
            case 1856274660:
                if (str.equals("additional-custom-info")) {
                    c = 29;
                    break;
                }
                break;
            case 1860054545:
                if (str.equals(PropsConstants.TINT_COLOR)) {
                    c = 30;
                    break;
                }
                break;
            case 1998893929:
                if (str.equals(PropsConstants.ENABLE_CUSTOM_GIF_DECODER)) {
                    c = 31;
                    break;
                }
                break;
            case 2141225912:
                if (str.equals(PropsConstants.EXTRA_LOAD_INFO)) {
                    c = ' ';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                flattenUIImage.setCapInsetsScale(stylesDiffMap.getString(str));
                return;
            case 1:
                flattenUIImage.setImageSR(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                flattenUIImage.setEnableResourceHint(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                flattenUIImage.setSkipRedirection(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                flattenUIImage.setAsyncRedirect(stylesDiffMap.getBoolean(str, false));
                return;
            case 5:
                flattenUIImage.setImageConfig(stylesDiffMap.getString(str));
                return;
            case 6:
                flattenUIImage.setRepeat(stylesDiffMap.getBoolean(str, false));
                return;
            case 7:
                flattenUIImage.setSimpleCacheKey(stylesDiffMap.getBoolean(str, false));
                return;
            case '\b':
                flattenUIImage.setLoopCount(stylesDiffMap.getInt(str, 0));
                return;
            case '\t':
                flattenUIImage.setFrescoNinePatch(stylesDiffMap.getBoolean(str, false));
                return;
            case '\n':
                flattenUIImage.setDisableDefaultResize(stylesDiffMap.getBoolean(str, false));
                return;
            case 11:
                flattenUIImage.setPreFetchWidth(stylesDiffMap.getString(str));
                return;
            case '\f':
                flattenUIImage.setSource(stylesDiffMap.getString(str));
                return;
            case '\r':
                flattenUIImage.setObjectFit(stylesDiffMap.getString(str));
                return;
            case 14:
                flattenUIImage.setAsyncRequest(stylesDiffMap.getBoolean(str, false));
                return;
            case 15:
                flattenUIImage.setPreFetchHeight(stylesDiffMap.getString(str));
                return;
            case 16:
                flattenUIImage.setImageSRScale(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 17:
                flattenUIImage.setImageCacheChoice(stylesDiffMap.getString(str));
                return;
            case 18:
                flattenUIImage.setCapInsetsBackUp(stylesDiffMap.getString(str));
                return;
            case 19:
                flattenUIImage.setPlaceholder(stylesDiffMap.getString(str));
                return;
            case 20:
                flattenUIImage.setBlurRadius(stylesDiffMap.getString(str));
                return;
            case 21:
                flattenUIImage.setImageRequestPriority(stylesDiffMap.getString(str));
                return;
            case 22:
                flattenUIImage.setImageTransitionStyle(stylesDiffMap.getString(str));
                return;
            case 23:
                flattenUIImage.setSuspendable(stylesDiffMap.getDynamic(str));
                return;
            case 24:
                flattenUIImage.setImagePlaceHolderHashConfig(stylesDiffMap.getMap(str));
                return;
            case 25:
                flattenUIImage.setAutoPlay(stylesDiffMap.getBoolean(str, true));
                return;
            case 26:
                flattenUIImage.setCapInsets(stylesDiffMap.getString(str));
                return;
            case 27:
                flattenUIImage.setAutoSize(stylesDiffMap.getBoolean(str, false));
                return;
            case 28:
                flattenUIImage.setDeferInvalidation(stylesDiffMap.getBoolean(str, false));
                return;
            case 29:
                flattenUIImage.setCustomParams(stylesDiffMap.getMap(str));
                return;
            case 30:
                flattenUIImage.setTintColor(stylesDiffMap.getString(str));
                return;
            case 31:
                flattenUIImage.setEnableCustomGifDecoder(stylesDiffMap.getBoolean(str, false));
                return;
            case ' ':
                flattenUIImage.setExtraLoadInfo(stylesDiffMap.getBoolean(str, false));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
