package com.lynx.tasm.p001ui.image;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.image.AbsUIImage$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIImage$$PropsSetter extends AbsUIImage$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.image.AbsUIImage$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIImage uIImage = (UIImage) lynxBaseUI;
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
            case -931992873:
                if (str.equals(PropsConstants.ANDROID_IMAGE_SIMPLE_KEY)) {
                    c = 6;
                    break;
                }
                break;
            case -602643660:
                if (str.equals(PropsConstants.FRESCO_NINE_PATCH)) {
                    c = 7;
                    break;
                }
                break;
            case 259555579:
                if (str.equals("super-resolution-scale")) {
                    c = '\b';
                    break;
                }
                break;
            case 263914060:
                if (str.equals(PropsConstants.IMAGE_CACHE_CHOICE)) {
                    c = '\t';
                    break;
                }
                break;
            case 512852970:
                if (str.equals(PropsConstants.IMAGE_SUBSAMPLE)) {
                    c = '\n';
                    break;
                }
                break;
            case 516005201:
                if (str.equals(PropsConstants.CAP_INSETS_BACKUP)) {
                    c = 11;
                    break;
                }
                break;
            case 828761943:
                if (str.equals(PropsConstants.IMAGE_PRIORITY)) {
                    c = '\f';
                    break;
                }
                break;
            case 893413739:
                if (str.equals(PropsConstants.IMAGE_TRANSITION_STYLE)) {
                    c = '\r';
                    break;
                }
                break;
            case 902281110:
                if (str.equals(PropsConstants.SUSPENDABLE)) {
                    c = 14;
                    break;
                }
                break;
            case 1090746891:
                if (str.equals(PropsConstants.FRESCO_VISIBLE)) {
                    c = 15;
                    break;
                }
                break;
            case 1245269388:
                if (str.equals(PropsConstants.FRESCO_ATTACH)) {
                    c = 16;
                    break;
                }
                break;
            case 1338737543:
                if (str.equals(PropsConstants.IMAGE_PLACE_HOLDER_HASH_CONFIG)) {
                    c = 17;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals(PropsConstants.AUTO_PLAY)) {
                    c = 18;
                    break;
                }
                break;
            case 1672916293:
                if (str.equals(PropsConstants.FIX_FRESCO_BUG)) {
                    c = 19;
                    break;
                }
                break;
            case 1739487650:
                if (str.equals(PropsConstants.DEFER_SRC_INVALIDATION)) {
                    c = 20;
                    break;
                }
                break;
            case 1856274660:
                if (str.equals("additional-custom-info")) {
                    c = 21;
                    break;
                }
                break;
            case 1860054545:
                if (str.equals(PropsConstants.TINT_COLOR)) {
                    c = 22;
                    break;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    c = 23;
                    break;
                }
                break;
            case 1998893929:
                if (str.equals(PropsConstants.ENABLE_CUSTOM_GIF_DECODER)) {
                    c = 24;
                    break;
                }
                break;
            case 2141225912:
                if (str.equals(PropsConstants.EXTRA_LOAD_INFO)) {
                    c = 25;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIImage.setCapInsetsScale(stylesDiffMap.getString(str));
                return;
            case 1:
                uIImage.setImageSR(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                uIImage.setEnableResourceHint(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                uIImage.setSkipRedirection(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                uIImage.setAsyncRedirect(stylesDiffMap.getBoolean(str, false));
                return;
            case 5:
                uIImage.setImageConfig(stylesDiffMap.getString(str));
                return;
            case 6:
                uIImage.setSimpleCacheKey(stylesDiffMap.getBoolean(str, true));
                return;
            case 7:
                uIImage.setFrescoNinePatch(stylesDiffMap.getBoolean(str, false));
                return;
            case '\b':
                uIImage.setImageSRScale(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case '\t':
                uIImage.setImageCacheChoice(stylesDiffMap.getString(str));
                return;
            case '\n':
                uIImage.setSubSample(stylesDiffMap.getString(str));
                return;
            case 11:
                uIImage.setCapInsetsBackUp(stylesDiffMap.getString(str));
                return;
            case '\f':
                uIImage.setImageRequestPriority(stylesDiffMap.getString(str));
                return;
            case '\r':
                uIImage.setImageTransitionStyle(stylesDiffMap.getString(str));
                return;
            case 14:
                uIImage.setSuspendable(stylesDiffMap.getDynamic(str));
                return;
            case 15:
                uIImage.setFrescoVisible(stylesDiffMap.getString(str));
                return;
            case 16:
                uIImage.setFrescoAttach(stylesDiffMap.getString(str));
                return;
            case 17:
                uIImage.setImagePlaceHolderHashConfig(stylesDiffMap.getMap(str));
                return;
            case 18:
                uIImage.setAutoPlay(stylesDiffMap.getBoolean(str, true));
                return;
            case 19:
                uIImage.fixFrescoWebPBug(stylesDiffMap.getBoolean(str, false));
                return;
            case 20:
                uIImage.setDeferInvalidation(stylesDiffMap.getBoolean(str, false));
                return;
            case 21:
                uIImage.setCustomParams(stylesDiffMap.getMap(str));
                return;
            case 22:
                uIImage.setTintColor(stylesDiffMap.getString(str));
                return;
            case 23:
                uIImage.setVisibility(stylesDiffMap.getInt(str, 1));
                return;
            case 24:
                uIImage.setEnableCustomGifDecoder(stylesDiffMap.getBoolean(str, false));
                return;
            case 25:
                uIImage.setExtraLoadInfo(stylesDiffMap.getBoolean(str, false));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
