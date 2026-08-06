package com.lynx.tasm.behavior.p000ui.swiper;

import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter;
import com.ss.ttm.player.MediaPlayer;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class XSwiperUI$$PropsSetter extends UISimpleView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        XSwiperUI xSwiperUI = (XSwiperUI) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2096030894:
                if (str.equals("enable-vice-loop")) {
                    c = 0;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c = 1;
                    break;
                }
                break;
            case -1984141450:
                if (str.equals("vertical")) {
                    c = 2;
                    break;
                }
                break;
            case -1860862959:
                if (str.equals("ignore-layout-update")) {
                    c = 3;
                    break;
                }
                break;
            case -1596393144:
                if (str.equals("indicator-dots")) {
                    c = 4;
                    break;
                }
                break;
            case -1498085729:
                if (str.equals("circular")) {
                    c = 5;
                    break;
                }
                break;
            case -1439500848:
                if (str.equals("orientation")) {
                    c = 6;
                    break;
                }
                break;
            case -1363870918:
                if (str.equals("min-x-scale")) {
                    c = 7;
                    break;
                }
                break;
            case -1029251878:
                if (str.equals("indicator-active-color")) {
                    c = '\b';
                    break;
                }
                break;
            case -842605868:
                if (str.equals("compatible")) {
                    c = '\t';
                    break;
                }
                break;
            case -686438324:
                if (str.equals("max-x-scale")) {
                    c = '\n';
                    break;
                }
                break;
            case -645426670:
                if (str.equals("enable-bounce")) {
                    c = 11;
                    break;
                }
                break;
            case -538499326:
                if (str.equals("bounce-begin-threshold")) {
                    c = '\f';
                    break;
                }
                break;
            case -509897868:
                if (str.equals("bounce-end-threshold")) {
                    c = '\r';
                    break;
                }
                break;
            case -476367237:
                if (str.equals("min-y-scale")) {
                    c = 14;
                    break;
                }
                break;
            case -111166008:
                if (str.equals("next-margin")) {
                    c = 15;
                    break;
                }
                break;
            case 3357091:
                if (str.equals(PropsConstants.MODE)) {
                    c = 16;
                    break;
                }
                break;
            case 24002884:
                if (str.equals("previous-margin")) {
                    c = 17;
                    break;
                }
                break;
            case 201065357:
                if (str.equals("max-y-scale")) {
                    c = 18;
                    break;
                }
                break;
            case 364166425:
                if (str.equals("touchable")) {
                    c = 19;
                    break;
                }
                break;
            case 433748736:
                if (str.equals("scroll-before-detached")) {
                    c = 20;
                    break;
                }
                break;
            case 487784663:
                if (str.equals("keep-item-view")) {
                    c = 21;
                    break;
                }
                break;
            case 570418373:
                if (str.equals("interval")) {
                    c = 22;
                    break;
                }
                break;
            case 873902905:
                if (str.equals("bounce-duration")) {
                    c = 23;
                    break;
                }
                break;
            case 1013897100:
                if (str.equals("force-can-scroll")) {
                    c = 24;
                    break;
                }
                break;
            case 1090700700:
                if (str.equals("norm-translation-factor")) {
                    c = 25;
                    break;
                }
                break;
            case 1126940025:
                if (str.equals("current")) {
                    c = 26;
                    break;
                }
                break;
            case 1439562083:
                if (str.equals(PropsConstants.AUTO_PLAY)) {
                    c = 27;
                    break;
                }
                break;
            case 1599847372:
                if (str.equals("smooth-scroll")) {
                    c = 28;
                    break;
                }
                break;
            case 1663357090:
                if (str.equals("transition-throttle")) {
                    c = 29;
                    break;
                }
                break;
            case 1665556140:
                if (str.equals("page-margin")) {
                    c = 30;
                    break;
                }
                break;
            case 1696908181:
                if (str.equals("finish-reset")) {
                    c = 31;
                    break;
                }
                break;
            case 1702954660:
                if (str.equals("handle-gesture")) {
                    c = ' ';
                    break;
                }
                break;
            case 1744363728:
                if (str.equals("enable-nested-child")) {
                    c = '!';
                    break;
                }
                break;
            case 2050488869:
                if (str.equals("indicator-color")) {
                    c = '\"';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                xSwiperUI.setEnableViceLoop(stylesDiffMap.getBoolean(str, true));
                return;
            case 1:
                xSwiperUI.setDuration(stylesDiffMap.getInt(str, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE));
                return;
            case 2:
                xSwiperUI.setVertical(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                xSwiperUI.setIgnoreLayoutUpdate(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                xSwiperUI.setIndicator(stylesDiffMap.getBoolean(str, false));
                return;
            case 5:
                xSwiperUI.setCircular(stylesDiffMap.getBoolean(str, false));
                return;
            case 6:
                xSwiperUI.setOrientation(stylesDiffMap.getString(str));
                return;
            case 7:
                xSwiperUI.setMinXScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case '\b':
                xSwiperUI.setIndicatorActiveColor(stylesDiffMap.getString(str));
                return;
            case '\t':
                xSwiperUI.setCompatible(stylesDiffMap.getBoolean(str, true));
                return;
            case '\n':
                xSwiperUI.setMaxXScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 11:
                xSwiperUI.setEnableBounce(stylesDiffMap.getBoolean(str, false));
                return;
            case '\f':
                xSwiperUI.setBounceBeginThreshold(stylesDiffMap.getFloat(str, 0.3f));
                return;
            case '\r':
                xSwiperUI.setBounceEndThreshold(stylesDiffMap.getFloat(str, 0.3f));
                return;
            case 14:
                xSwiperUI.setMinYScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 15:
                xSwiperUI.setNextMargin(stylesDiffMap.getDynamic(str));
                return;
            case 16:
                xSwiperUI.setMode(stylesDiffMap.getString(str));
                return;
            case 17:
                xSwiperUI.setPreviousMargin(stylesDiffMap.getDynamic(str));
                return;
            case 18:
                xSwiperUI.setMaxYScale(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 19:
                xSwiperUI.setTouchable(stylesDiffMap.getBoolean(str, false));
                return;
            case 20:
                xSwiperUI.setScrollBeforeDetached(stylesDiffMap.getBoolean(str, false));
                return;
            case 21:
                xSwiperUI.setKeepItemView(stylesDiffMap.getBoolean(str, false));
                return;
            case 22:
                xSwiperUI.setInterval(stylesDiffMap.getInt(str, 5000));
                return;
            case 23:
                xSwiperUI.setBounceDuration(stylesDiffMap.getInt(str, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE));
                return;
            case 24:
                xSwiperUI.setForceCanScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 25:
                xSwiperUI.setNormalTranslationFactor(stylesDiffMap.getDouble(str, 0.0d));
                return;
            case 26:
                xSwiperUI.setCurrentIndex(stylesDiffMap.getInt(str, 0));
                return;
            case 27:
                xSwiperUI.setAutoPlay(stylesDiffMap.getBoolean(str, false));
                return;
            case 28:
                xSwiperUI.setSmoothScroll(stylesDiffMap.getBoolean(str, true));
                return;
            case 29:
                xSwiperUI.setTransitionThrottle(stylesDiffMap.getInt(str, 0));
                return;
            case 30:
                xSwiperUI.setPageMargin(stylesDiffMap.getDynamic(str));
                return;
            case 31:
                xSwiperUI.setFinishReset(stylesDiffMap.getBoolean(str, false));
                return;
            case ' ':
                xSwiperUI.setHandleGesture(stylesDiffMap.getBoolean(str, true));
                return;
            case '!':
                xSwiperUI.setEnableNestedChild(stylesDiffMap.getBoolean(str, false));
                return;
            case '\"':
                xSwiperUI.setIndicatorColor(stylesDiffMap.getString(str));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
