package com.lynx.tasm.behavior.p000ui.list.container;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIListContainer$$PropsSetter extends UISimpleView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        UIListContainer uIListContainer = (UIListContainer) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2062142952:
                if (str.equals("update-animation-fade-in-duration")) {
                    c = 0;
                    break;
                }
                break;
            case -1741552957:
                if (str.equals("enable-fade-in-animation")) {
                    c = 1;
                    break;
                }
                break;
            case -1512080424:
                if (str.equals("experimental-recycle-sticky-item")) {
                    c = 2;
                    break;
                }
                break;
            case -1305579111:
                if (str.equals("enable-nested-scroll")) {
                    c = 3;
                    break;
                }
                break;
            case -892259863:
                if (str.equals("sticky")) {
                    c = 4;
                    break;
                }
                break;
            case -858113201:
                if (str.equals("enable-insert-platform-view-operation")) {
                    c = 5;
                    break;
                }
                break;
            case -773140599:
                if (str.equals("list-container-info")) {
                    c = 6;
                    break;
                }
                break;
            case -711580976:
                if (str.equals("scroll-orientation")) {
                    c = 7;
                    break;
                }
                break;
            case -169901481:
                if (str.equals("enable-scroll")) {
                    c = '\b';
                    break;
                }
                break;
            case 954804946:
                if (str.equals("experimental-max-fling-distance-ratio")) {
                    c = '\t';
                    break;
                }
                break;
            case 1013897100:
                if (str.equals("force-can-scroll")) {
                    c = '\n';
                    break;
                }
                break;
            case 1276968466:
                if (str.equals("experimental-batch-render-strategy")) {
                    c = 11;
                    break;
                }
                break;
            case 1296520439:
                if (str.equals("sticky-offset")) {
                    c = '\f';
                    break;
                }
                break;
            case 1844261742:
                if (str.equals("experimental-update-sticky-for-diff")) {
                    c = '\r';
                    break;
                }
                break;
            case 2069690902:
                if (str.equals("need-visible-item-info")) {
                    c = 14;
                    break;
                }
                break;
            case 2083253753:
                if (str.equals("vertical-orientation")) {
                    c = 15;
                    break;
                }
                break;
            case 2107607620:
                if (str.equals("item-snap")) {
                    c = 16;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                uIListContainer.setUpdateAnimationFadeInDuration(stylesDiffMap.getInt(str, 100));
                return;
            case 1:
                uIListContainer.setEnableFadeInAnimation(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                uIListContainer.setEnableRecycleStickyItem(stylesDiffMap.getBoolean(str, true));
                return;
            case 3:
                uIListContainer.setEnableNestedScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 4:
                uIListContainer.setEnableListSticky(stylesDiffMap.getBoolean(str, true));
                return;
            case 5:
                uIListContainer.setEnableInsertPlatformViewOperation(stylesDiffMap.getBoolean(str, false));
                return;
            case 6:
                uIListContainer.setDiffInfo(stylesDiffMap.getMap(str));
                return;
            case 7:
                uIListContainer.setScrollOrientation(stylesDiffMap.getString(str));
                return;
            case '\b':
                uIListContainer.setEnableScroll(stylesDiffMap.getBoolean(str, true));
                return;
            case '\t':
                uIListContainer.setMaxFlingDistanceRatio(stylesDiffMap.getDynamic(str));
                return;
            case '\n':
                uIListContainer.setForceCanScroll(stylesDiffMap.getBoolean(str, false));
                return;
            case 11:
                uIListContainer.setBatchRenderStrategy(stylesDiffMap.getInt(str, 0));
                return;
            case '\f':
                uIListContainer.setStickyOffset(stylesDiffMap.getDynamic(str));
                return;
            case '\r':
                uIListContainer.setUpdateStickyForDiff(stylesDiffMap.getBoolean(str, true));
                return;
            case 14:
                uIListContainer.setNeedVisibleItemInfo(stylesDiffMap.getBoolean(str, false));
                return;
            case 15:
                uIListContainer.setVerticalOrientation(stylesDiffMap.getBoolean(str, false));
                return;
            case 16:
                uIListContainer.setPagingAlignment(stylesDiffMap.getMap(str));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
