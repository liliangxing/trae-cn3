package com.lynx.tasm.behavior.p000ui.list;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AbsLynxList$$PropsSetter extends UISimpleView$$PropsSetter {
    @Override // com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        AbsLynxList absLynxList = (AbsLynxList) lynxBaseUI;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1910309744:
                if (str.equals("internal-cell-disappear-notification")) {
                    c = 0;
                    break;
                }
                break;
            case -1866276358:
                if (str.equals("should-request-state-restore")) {
                    c = 1;
                    break;
                }
                break;
            case -1856561977:
                if (str.equals("no-invalidate")) {
                    c = 2;
                    break;
                }
                break;
            case -1571036001:
                if (str.equals("lower-threshold")) {
                    c = 3;
                    break;
                }
                break;
            case -1554128936:
                if (str.equals("column-count")) {
                    c = 4;
                    break;
                }
                break;
            case -1270238455:
                if (str.equals("list-type")) {
                    c = 5;
                    break;
                }
                break;
            case -892259863:
                if (str.equals("sticky")) {
                    c = 6;
                    break;
                }
                break;
            case -656627599:
                if (str.equals("component-init-measure")) {
                    c = 7;
                    break;
                }
                break;
            case -592430592:
                if (str.equals("paging-enabled")) {
                    c = '\b';
                    break;
                }
                break;
            case -505303290:
                if (str.equals("needs-visible-cells")) {
                    c = '\t';
                    break;
                }
                break;
            case -447418808:
                if (str.equals("internal-cell-appear-notification")) {
                    c = '\n';
                    break;
                }
                break;
            case -411446853:
                if (str.equals("initial-scroll-index")) {
                    c = 11;
                    break;
                }
                break;
            case -402166408:
                if (str.equals("scroll-x")) {
                    c = '\f';
                    break;
                }
                break;
            case -402166407:
                if (str.equals("scroll-y")) {
                    c = '\r';
                    break;
                }
                break;
            case -169901481:
                if (str.equals("enable-scroll")) {
                    c = 14;
                    break;
                }
                break;
            case -137292606:
                if (str.equals("upper-threshold-item-count")) {
                    c = 15;
                    break;
                }
                break;
            case 10993126:
                if (str.equals("over-scroll")) {
                    c = 16;
                    break;
                }
                break;
            case 409686694:
                if (str.equals("list-cross-axis-gap")) {
                    c = 17;
                    break;
                }
                break;
            case 660290816:
                if (str.equals("upper-threshold")) {
                    c = 18;
                    break;
                }
                break;
            case 693516932:
                if (str.equals("cache-queue-ratio")) {
                    c = 19;
                    break;
                }
                break;
            case 875338749:
                if (str.equals("scroll-event-throttle")) {
                    c = 20;
                    break;
                }
                break;
            case 913884495:
                if (str.equals("list-main-axis-gap")) {
                    c = 21;
                    break;
                }
                break;
            case 1191691203:
                if (str.equals("lower-threshold-item-count")) {
                    c = 22;
                    break;
                }
                break;
            case 1296520439:
                if (str.equals("sticky-offset")) {
                    c = 23;
                    break;
                }
                break;
            case 1367907611:
                if (str.equals("touch-scroll")) {
                    c = 24;
                    break;
                }
                break;
            case 1406408041:
                if (str.equals("internal-cell-prepare-for-reuse-notification")) {
                    c = 25;
                    break;
                }
                break;
            case 1861761406:
                if (str.equals("scroll-state-change-event-throttle")) {
                    c = 26;
                    break;
                }
                break;
            case 1883148160:
                if (str.equals("update-animation")) {
                    c = 27;
                    break;
                }
                break;
            case 2107607620:
                if (str.equals("item-snap")) {
                    c = 28;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                absLynxList.setInternalCellDisappearNotification(stylesDiffMap.getBoolean(str, false));
                return;
            case 1:
                absLynxList.setShouldRequestStateRestore(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                absLynxList.setNoInvalidate(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                absLynxList.setLowerThreshold(stylesDiffMap.getDynamic(str));
                return;
            case 4:
                absLynxList.setColumnCount(stylesDiffMap.getInt(str, 1));
                return;
            case 5:
                absLynxList.setListType(stylesDiffMap.getString(str));
                return;
            case 6:
                absLynxList.setEnableSticky(stylesDiffMap.getDynamic(str));
                return;
            case 7:
                absLynxList.setComponentInitMeasure(stylesDiffMap.getBoolean(str, false));
                return;
            case '\b':
                absLynxList.setEnablePagerSnap(stylesDiffMap.getDynamic(str));
                return;
            case '\t':
                absLynxList.setNeedVisibleCells(stylesDiffMap.getBoolean(str, false));
                return;
            case '\n':
                absLynxList.setInternalCellAppearNotification(stylesDiffMap.getBoolean(str, false));
                return;
            case 11:
                absLynxList.setInitialScrollIndex(stylesDiffMap.getDynamic(str));
                return;
            case '\f':
                absLynxList.setScrollX(stylesDiffMap.getDynamic(str));
                return;
            case '\r':
                absLynxList.setScrollY(stylesDiffMap.getDynamic(str));
                return;
            case 14:
                absLynxList.setScrollEnable(stylesDiffMap.getDynamic(str));
                return;
            case 15:
                absLynxList.setUpperThresholdItemCount(stylesDiffMap.getDynamic(str));
                return;
            case 16:
                absLynxList.setOverScroll(stylesDiffMap.getDynamic(str));
                return;
            case 17:
                absLynxList.setCrossAxisGap(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 18:
                absLynxList.setUpperThreshold(stylesDiffMap.getDynamic(str));
                return;
            case 19:
                absLynxList.setCacheQueueRatio(stylesDiffMap.getDynamic(str));
                return;
            case 20:
                absLynxList.setScrollEventThrottle(stylesDiffMap.getDynamic(str));
                return;
            case 21:
                absLynxList.setMainAxisGap(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 22:
                absLynxList.setLowerThresholdItemCount(stylesDiffMap.getDynamic(str));
                return;
            case 23:
                absLynxList.setStickyOffset(stylesDiffMap.getDynamic(str));
                return;
            case 24:
                absLynxList.setTouchScroll(stylesDiffMap.getDynamic(str));
                return;
            case 25:
                absLynxList.setInternalCellPrepareForReuseNotification(stylesDiffMap.getBoolean(str, false));
                return;
            case 26:
                absLynxList.setScrollStateChangeEventThrottle(stylesDiffMap.getString(str));
                return;
            case 27:
                absLynxList.setUpdateAnimation(stylesDiffMap.getString(str));
                return;
            case 28:
                absLynxList.setPagingAlignment(stylesDiffMap.getMap(str));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
