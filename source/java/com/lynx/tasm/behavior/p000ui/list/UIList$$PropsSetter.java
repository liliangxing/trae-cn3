package com.lynx.tasm.behavior.p000ui.list;

import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UIList$$PropsSetter extends AbsLynxList$$PropsSetter {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.lynx.tasm.behavior.p000ui.list.AbsLynxList$$PropsSetter, com.lynx.tasm.behavior.p000ui.view.UISimpleView$$PropsSetter, com.lynx.tasm.behavior.p000ui.UIGroup$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxUI$$PropsSetter, com.lynx.tasm.behavior.p000ui.LynxBaseUI$$PropsSetter, com.lynx.tasm.behavior.utils.LynxUISetter
    public void setProperty(LynxBaseUI lynxBaseUI, String str, StylesDiffMap stylesDiffMap) {
        char c;
        UIList uIList = (UIList) lynxBaseUI;
        str.hashCode();
        switch (str.hashCode()) {
            case -1836837422:
                if (str.equals("scroll-index")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1775291141:
                if (str.equals("android-stack-from-end")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1751296064:
                if (str.equals("android-new-scroll-top")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1498894801:
                if (str.equals("max-fling-velocity-percent")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1471202561:
                if (str.equals("android-enable-strict-scrollable")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1305579111:
                if (str.equals("enable-nested-scroll")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1232185977:
                if (str.equals("android-enable-gap-item-decoration")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1200045995:
                if (str.equals("use-old-sticky")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1042889767:
                if (str.equals("enable-async-list")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1035189822:
                if (str.equals("enable-new-exposure-strategy")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -942713210:
                if (str.equals("preload-buffer-count")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -529325351:
                if (str.equals("list-platform-info")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -505938823:
                if (str.equals("update-list-info")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 616977828:
                if (str.equals("android-preference-consume-gesture")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 626658734:
                if (str.equals("android-enable-overflow")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 821895493:
                if (str.equals("android-enable-item-prefetch")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 1458283840:
                if (str.equals("enable-size-cache")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1598314955:
                if (str.equals("scroll-upper-lower-switch")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1636003801:
                if (str.equals("enable-disappear")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 1683042429:
                if (str.equals("android-diffable")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1702184795:
                if (str.equals("android-trigger-sticky-layout")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1816872768:
                if (str.equals("auto-measure")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1836550134:
                if (str.equals("android-ignore-attach-for-binding")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1839496169:
                if (str.equals("android-enable-focus-search")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case 1852315393:
                if (str.equals("item-holder-type")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case 1892080416:
                if (str.equals("enable-rtl")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case 2083253753:
                if (str.equals("vertical-orientation")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                uIList.setScrollIndex(stylesDiffMap.getInt(str, -1));
                return;
            case 1:
                uIList.setStackFromEnd(stylesDiffMap.getBoolean(str, false));
                return;
            case 2:
                uIList.setListNewScrollTopSwitch(stylesDiffMap.getBoolean(str, false));
                return;
            case 3:
                uIList.setMaxFlingVelocityPercent(stylesDiffMap.getFloat(str, 0.0f));
                return;
            case 4:
                uIList.setEnableStrictScrollable(stylesDiffMap.getBoolean(str, false));
                return;
            case 5:
                uIList.enableNestedScroll(stylesDiffMap.getBoolean(str, true));
                return;
            case 6:
                uIList.setEnableGapItemDecoration(stylesDiffMap.getBoolean(str, false));
                return;
            case 7:
                uIList.setListOldStickySwitch(stylesDiffMap.getBoolean(str, true));
                return;
            case '\b':
                uIList.setEnableAsyncList(stylesDiffMap.getBoolean(str, false));
                return;
            case '\t':
                uIList.setNewAppear(stylesDiffMap.getBoolean(str, false));
                return;
            case '\n':
                uIList.setPreloadBufferCount(stylesDiffMap.getDynamic(str));
                return;
            case 11:
                uIList.setListPlatformInfo(stylesDiffMap.getMap(str));
                return;
            case '\f':
                uIList.updateListActionInfo(stylesDiffMap.getMap(str));
                return;
            case '\r':
                uIList.setPreferenceConsumeGesture(stylesDiffMap.getBoolean(str, false));
                return;
            case 14:
                uIList.setEnableOverflow(stylesDiffMap.getBoolean(str, false));
                return;
            case 15:
                uIList.setEnableItemPrefetch(stylesDiffMap.getBoolean(str, true));
                return;
            case 16:
                uIList.setEnableSizeCache(stylesDiffMap.getBoolean(str, false));
                return;
            case 17:
                uIList.setUpperLowerSwitch(stylesDiffMap.getBoolean(str, false));
                return;
            case 18:
                uIList.setEnableDisappear(stylesDiffMap.getBoolean(str, false));
                return;
            case 19:
                uIList.setDiffable(stylesDiffMap.getDynamic(str));
                return;
            case 20:
                uIList.setTriggerStickyLayout(stylesDiffMap.getBoolean(str, false));
                return;
            case 21:
                uIList.setAutoMeasure(stylesDiffMap.getDynamic(str));
                return;
            case 22:
                uIList.setAndroidIgnoreAttachForBinding(stylesDiffMap.getBoolean(str, false));
                return;
            case 23:
                uIList.setEnableFocusSearch(stylesDiffMap.getBoolean(str, true));
                return;
            case 24:
                uIList.setItemHolderType(stylesDiffMap.getDynamic(str));
                return;
            case 25:
                uIList.enableRtl(stylesDiffMap.getBoolean(str, false));
                return;
            case 26:
                uIList.setVerticalOrientation(stylesDiffMap.getBoolean(str, true));
                return;
            default:
                super.setProperty(lynxBaseUI, str, stylesDiffMap);
                return;
        }
    }
}
