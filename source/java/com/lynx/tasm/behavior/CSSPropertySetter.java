package com.lynx.tasm.behavior;

import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.mapbuffer.DynamicFromMapBuffer;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBufferWrapper;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.list.AbsLynxList;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CSSPropertySetter {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class UIPaintStyles {
        ReadableArray mBackgroundClip;
        ReadableArray mBackgroundImage;
        ReadableArray mBackgroundOrigin;
        ReadableArray mBackgroundPosition;
        ReadableArray mBackgroundRepeat;
        ReadableArray mBackgroundSize;
        Integer mBorderBottomColor;
        ReadableArray mBorderBottomLeftRadius;
        ReadableArray mBorderBottomRightRadius;
        int mBorderBottomWidth;
        Integer mBorderColor;
        Integer mBorderLeftColor;
        int mBorderLeftWidth;
        ReadableArray mBorderRadius;
        Integer mBorderRightColor;
        int mBorderRightWidth;
        Integer mBorderTopColor;
        ReadableArray mBorderTopLeftRadius;
        ReadableArray mBorderTopRightRadius;
        int mBorderTopWidth;
        int mBorderWidth;
        ReadableArray mBoxShadow;
        ReadableArray mClipPath;
        ReadableArray mFilter;
        float mFontSize;
        int mImageRendering;
        double mLayoutAnimationCreateDelay;
        double mLayoutAnimationCreateDuration;
        int mLayoutAnimationCreateProperty;
        ReadableArray mLayoutAnimationCreateTimingFunction;
        double mLayoutAnimationDeleteDelay;
        double mLayoutAnimationDeleteDuration;
        int mLayoutAnimationDeleteProperty;
        ReadableArray mLayoutAnimationDeleteTimingFunction;
        double mLayoutAnimationUpdateDelay;
        double mLayoutAnimationUpdateDuration;
        ReadableArray mLayoutAnimationUpdateTimingFunction;
        ReadableArray mMaskClip;
        ReadableArray mMaskImage;
        ReadableArray mMaskOrigin;
        ReadableArray mMaskPosition;
        ReadableArray mMaskRepeat;
        ReadableArray mMaskSize;
        float mOpacity;
        int mOutlineStyle;
        float mOutlineWidth;
        Integer mOverflow;
        Integer mOverflowX;
        Integer mOverflowY;
        ReadableArray mPerspective;
        ReadableArray mTransform;
        ReadableArray mTransformOrigin;
        int mVisibility;
        int mBackgroundColor = 0;
        int mBorderStyle = -1;
        int mBorderLeftStyle = -1;
        int mBorderRightStyle = -1;
        int mBorderTopStyle = -1;
        int mBorderBottomStyle = -1;
        int mOutlineColor = -16777216;
        int mDirection = 3;
    }

    public static void updateStyles(LynxBaseUI lynxBaseUI, MapBuffer mapBuffer) {
        UIPaintStyles orCreateUIPaintStyles;
        if (mapBuffer == null || (orCreateUIPaintStyles = lynxBaseUI.getOrCreateUIPaintStyles()) == null) {
            return;
        }
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            if (key != 5) {
                if (key != 7) {
                    if (key == 76) {
                        ReadableMapBufferWrapper readableMapBufferWrapper = new ReadableMapBufferWrapper(entry.getMapBuffer());
                        lynxBaseUI.setBoxShadow(readableMapBufferWrapper);
                        orCreateUIPaintStyles.mBoxShadow = readableMapBufferWrapper;
                    } else if (key == 77) {
                        ReadableMapBufferWrapper readableMapBufferWrapper2 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                        lynxBaseUI.setTransformOrigin(readableMapBufferWrapper2);
                        orCreateUIPaintStyles.mTransformOrigin = readableMapBufferWrapper2;
                    } else if (key == 120) {
                        int i = entry.getInt();
                        lynxBaseUI.setOverflowX(Integer.valueOf(i));
                        orCreateUIPaintStyles.mOverflowX = Integer.valueOf(i);
                    } else if (key == 121) {
                        int i2 = entry.getInt();
                        lynxBaseUI.setOverflowY(Integer.valueOf(i2));
                        orCreateUIPaintStyles.mOverflowY = Integer.valueOf(i2);
                    } else if (key == 129) {
                        lynxBaseUI.setCaretColor(entry.getString());
                    } else if (key == 130) {
                        int i3 = entry.getInt();
                        lynxBaseUI.setLynxDirection(i3);
                        orCreateUIPaintStyles.mDirection = i3;
                    } else if (key != 142) {
                        if (key != 143) {
                            switch (key) {
                                case 7:
                                    break;
                                case 8:
                                    int i4 = entry.getInt();
                                    lynxBaseUI.setBorderColor(0, Integer.valueOf(i4));
                                    orCreateUIPaintStyles.mBorderLeftColor = Integer.valueOf(i4);
                                    continue;
                                case 9:
                                    int i5 = entry.getInt();
                                    lynxBaseUI.setBorderColor(1, Integer.valueOf(i5));
                                    orCreateUIPaintStyles.mBorderRightColor = Integer.valueOf(i5);
                                    continue;
                                case 10:
                                    int i6 = entry.getInt();
                                    lynxBaseUI.setBorderColor(2, Integer.valueOf(i6));
                                    orCreateUIPaintStyles.mBorderTopColor = Integer.valueOf(i6);
                                    continue;
                                case 11:
                                    int i7 = entry.getInt();
                                    lynxBaseUI.setBorderColor(3, Integer.valueOf(i7));
                                    orCreateUIPaintStyles.mBorderBottomColor = Integer.valueOf(i7);
                                    continue;
                                case 12:
                                    ReadableMapBufferWrapper readableMapBufferWrapper3 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBorderRadius(0, (ReadableArray) readableMapBufferWrapper3);
                                    orCreateUIPaintStyles.mBorderRadius = readableMapBufferWrapper3;
                                    continue;
                                case 13:
                                    ReadableMapBufferWrapper readableMapBufferWrapper4 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBorderRadius(1, (ReadableArray) readableMapBufferWrapper4);
                                    orCreateUIPaintStyles.mBorderTopLeftRadius = readableMapBufferWrapper4;
                                    continue;
                                case 14:
                                    ReadableMapBufferWrapper readableMapBufferWrapper5 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBorderRadius(4, (ReadableArray) readableMapBufferWrapper5);
                                    orCreateUIPaintStyles.mBorderBottomLeftRadius = readableMapBufferWrapper5;
                                    continue;
                                case 15:
                                    ReadableMapBufferWrapper readableMapBufferWrapper6 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBorderRadius(2, (ReadableArray) readableMapBufferWrapper6);
                                    orCreateUIPaintStyles.mBorderTopRightRadius = readableMapBufferWrapper6;
                                    continue;
                                case 16:
                                    ReadableMapBufferWrapper readableMapBufferWrapper7 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBorderRadius(3, (ReadableArray) readableMapBufferWrapper7);
                                    orCreateUIPaintStyles.mBorderBottomRightRadius = readableMapBufferWrapper7;
                                    continue;
                                case 17:
                                    int i8 = (int) entry.getDouble();
                                    lynxBaseUI.setBorderWidth(0, i8);
                                    orCreateUIPaintStyles.mBorderWidth = i8;
                                    continue;
                                case 18:
                                    int i9 = (int) entry.getDouble();
                                    lynxBaseUI.setBorderWidth(1, i9);
                                    orCreateUIPaintStyles.mBorderLeftWidth = i9;
                                    continue;
                                case 19:
                                    int i10 = (int) entry.getDouble();
                                    lynxBaseUI.setBorderWidth(2, i10);
                                    orCreateUIPaintStyles.mBorderRightWidth = i10;
                                    continue;
                                case 20:
                                    int i11 = (int) entry.getDouble();
                                    lynxBaseUI.setBorderWidth(3, i11);
                                    orCreateUIPaintStyles.mBorderTopWidth = i11;
                                    continue;
                                case 21:
                                    int i12 = (int) entry.getDouble();
                                    lynxBaseUI.setBorderWidth(4, i12);
                                    orCreateUIPaintStyles.mBorderBottomWidth = i12;
                                    continue;
                                case 23:
                                    if (lynxBaseUI instanceof LynxUI) {
                                        float f = entry.getInt();
                                        ((LynxUI) lynxBaseUI).setAlpha(f);
                                        orCreateUIPaintStyles.mOpacity = f;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 25:
                                    int i13 = entry.getInt();
                                    lynxBaseUI.setOverflow(i13);
                                    orCreateUIPaintStyles.mOverflow = Integer.valueOf(i13);
                                    continue;
                                case 47:
                                    float f2 = entry.getInt();
                                    lynxBaseUI.setFontSize(f2);
                                    orCreateUIPaintStyles.mFontSize = f2;
                                    continue;
                                case 63:
                                    if (lynxBaseUI instanceof LynxUI) {
                                        ReadableArray readableMapBufferWrapper8 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                        ((LynxUI) lynxBaseUI).setTransform(readableMapBufferWrapper8);
                                        orCreateUIPaintStyles.mTransform = readableMapBufferWrapper8;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 74:
                                    int i14 = entry.getInt();
                                    lynxBaseUI.setBorderStyle(0, i14);
                                    orCreateUIPaintStyles.mBorderStyle = i14;
                                    continue;
                                case 104:
                                    if (lynxBaseUI instanceof LynxUI) {
                                        int i15 = entry.getInt();
                                        ((LynxUI) lynxBaseUI).setVisibility(i15);
                                        orCreateUIPaintStyles.mVisibility = i15;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 123:
                                    ReadableMapBufferWrapper readableMapBufferWrapper9 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setBackgroundClip(readableMapBufferWrapper9);
                                    orCreateUIPaintStyles.mBackgroundClip = readableMapBufferWrapper9;
                                    continue;
                                case 147:
                                    if (lynxBaseUI instanceof UIComponent) {
                                        ((UIComponent) lynxBaseUI).setZIndex(entry.getInt());
                                        break;
                                    } else {
                                        continue;
                                    }
                                case PropertyIDConstants.MaskImage /* 170 */:
                                    ReadableMapBufferWrapper readableMapBufferWrapper10 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskImage(readableMapBufferWrapper10);
                                    orCreateUIPaintStyles.mMaskImage = readableMapBufferWrapper10;
                                    continue;
                                case 190:
                                    ReadableMapBufferWrapper readableMapBufferWrapper11 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setPerspective(readableMapBufferWrapper11);
                                    orCreateUIPaintStyles.mPerspective = readableMapBufferWrapper11;
                                    continue;
                                case 193:
                                    if (lynxBaseUI instanceof LynxUI) {
                                        ReadableArray readableMapBufferWrapper12 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                        ((LynxUI) lynxBaseUI).setClipPath(readableMapBufferWrapper12);
                                        orCreateUIPaintStyles.mClipPath = readableMapBufferWrapper12;
                                        break;
                                    } else {
                                        continue;
                                    }
                                case 200:
                                    ReadableMapBufferWrapper readableMapBufferWrapper13 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskRepeat(readableMapBufferWrapper13);
                                    orCreateUIPaintStyles.mMaskRepeat = readableMapBufferWrapper13;
                                    continue;
                                case 201:
                                    ReadableMapBufferWrapper readableMapBufferWrapper14 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskPosition(readableMapBufferWrapper14);
                                    orCreateUIPaintStyles.mMaskPosition = readableMapBufferWrapper14;
                                    continue;
                                case 202:
                                    ReadableMapBufferWrapper readableMapBufferWrapper15 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskClip(readableMapBufferWrapper15);
                                    orCreateUIPaintStyles.mMaskClip = readableMapBufferWrapper15;
                                    continue;
                                case 203:
                                    ReadableMapBufferWrapper readableMapBufferWrapper16 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskOrigin(readableMapBufferWrapper16);
                                    orCreateUIPaintStyles.mMaskOrigin = readableMapBufferWrapper16;
                                    continue;
                                case 204:
                                    ReadableMapBufferWrapper readableMapBufferWrapper17 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                    lynxBaseUI.setMaskSize(readableMapBufferWrapper17);
                                    orCreateUIPaintStyles.mMaskSize = readableMapBufferWrapper17;
                                    continue;
                                case 208:
                                    int i16 = entry.getInt();
                                    lynxBaseUI.setImageRendering(i16);
                                    orCreateUIPaintStyles.mImageRendering = i16;
                                    continue;
                                default:
                                    switch (key) {
                                        case 83:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                double d = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationCreateDuration(d);
                                                orCreateUIPaintStyles.mLayoutAnimationCreateDuration = d;
                                                break;
                                            }
                                        case 84:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                ReadableArray readableMapBufferWrapper18 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationCreateTimingFunc(readableMapBufferWrapper18);
                                                orCreateUIPaintStyles.mLayoutAnimationCreateTimingFunction = readableMapBufferWrapper18;
                                                break;
                                            }
                                        case 85:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                double d2 = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationCreateDelay(d2);
                                                orCreateUIPaintStyles.mLayoutAnimationCreateDelay = d2;
                                                break;
                                            }
                                        case 86:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                int i17 = entry.getInt();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationCreateProperty(i17);
                                                orCreateUIPaintStyles.mLayoutAnimationCreateProperty = i17;
                                                break;
                                            }
                                        case 87:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                double d3 = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationDeleteDuration(d3);
                                                orCreateUIPaintStyles.mLayoutAnimationDeleteDuration = d3;
                                                break;
                                            }
                                        case 88:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                ReadableArray readableMapBufferWrapper19 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationDeleteTimingFunc(readableMapBufferWrapper19);
                                                orCreateUIPaintStyles.mLayoutAnimationDeleteTimingFunction = readableMapBufferWrapper19;
                                                break;
                                            }
                                        case 89:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                double d4 = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationDeleteDelay(d4);
                                                orCreateUIPaintStyles.mLayoutAnimationDeleteDelay = d4;
                                                break;
                                            }
                                        case 90:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                int i18 = entry.getInt();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationDeleteProperty(i18);
                                                orCreateUIPaintStyles.mLayoutAnimationDeleteProperty = i18;
                                                break;
                                            }
                                        case 91:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                double d5 = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationUpdateDuration(d5);
                                                orCreateUIPaintStyles.mLayoutAnimationUpdateDuration = d5;
                                                break;
                                            }
                                        case 92:
                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                break;
                                            } else {
                                                ReadableArray readableMapBufferWrapper20 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationUpdateTimingFunc(readableMapBufferWrapper20);
                                                orCreateUIPaintStyles.mLayoutAnimationUpdateTimingFunction = readableMapBufferWrapper20;
                                                break;
                                            }
                                        case 93:
                                            if (lynxBaseUI instanceof LynxUI) {
                                                double d6 = entry.getDouble();
                                                ((LynxUI) lynxBaseUI).setLayoutAnimationUpdateDelay(d6);
                                                orCreateUIPaintStyles.mLayoutAnimationUpdateDelay = d6;
                                                break;
                                            } else {
                                                continue;
                                            }
                                        default:
                                            switch (key) {
                                                case 98:
                                                    ReadableMapBufferWrapper readableMapBufferWrapper21 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                    lynxBaseUI.setBackgroundImage(readableMapBufferWrapper21);
                                                    orCreateUIPaintStyles.mBackgroundImage = readableMapBufferWrapper21;
                                                    break;
                                                case 99:
                                                    ReadableMapBufferWrapper readableMapBufferWrapper22 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                    lynxBaseUI.setBackgroundPosition(readableMapBufferWrapper22);
                                                    orCreateUIPaintStyles.mBackgroundPosition = readableMapBufferWrapper22;
                                                    break;
                                                case 100:
                                                    ReadableMapBufferWrapper readableMapBufferWrapper23 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                    lynxBaseUI.setBackgroundOrigin(readableMapBufferWrapper23);
                                                    orCreateUIPaintStyles.mBackgroundOrigin = readableMapBufferWrapper23;
                                                    break;
                                                case 101:
                                                    ReadableMapBufferWrapper readableMapBufferWrapper24 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                    lynxBaseUI.setBackgroundRepeat(readableMapBufferWrapper24);
                                                    orCreateUIPaintStyles.mBackgroundRepeat = readableMapBufferWrapper24;
                                                    break;
                                                case 102:
                                                    ReadableMapBufferWrapper readableMapBufferWrapper25 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                    lynxBaseUI.setBackgroundSize(readableMapBufferWrapper25);
                                                    orCreateUIPaintStyles.mBackgroundSize = readableMapBufferWrapper25;
                                                    break;
                                                default:
                                                    switch (key) {
                                                        case 115:
                                                            int i19 = entry.getInt();
                                                            lynxBaseUI.setBorderStyle(1, i19);
                                                            orCreateUIPaintStyles.mBorderLeftStyle = i19;
                                                            break;
                                                        case 116:
                                                            int i20 = entry.getInt();
                                                            lynxBaseUI.setBorderStyle(2, i20);
                                                            orCreateUIPaintStyles.mBorderRightStyle = i20;
                                                            break;
                                                        case 117:
                                                            int i21 = entry.getInt();
                                                            lynxBaseUI.setBorderStyle(3, i21);
                                                            orCreateUIPaintStyles.mBorderTopStyle = i21;
                                                            break;
                                                        case 118:
                                                            int i22 = entry.getInt();
                                                            lynxBaseUI.setBorderStyle(4, i22);
                                                            orCreateUIPaintStyles.mBorderBottomStyle = i22;
                                                            break;
                                                        default:
                                                            switch (key) {
                                                                case 125:
                                                                    int i23 = entry.getInt();
                                                                    lynxBaseUI.setOutlineColor(entry.getInt());
                                                                    orCreateUIPaintStyles.mOutlineColor = i23;
                                                                    break;
                                                                case 126:
                                                                    int i24 = entry.getInt();
                                                                    lynxBaseUI.setOutlineStyle(i24);
                                                                    orCreateUIPaintStyles.mOutlineStyle = i24;
                                                                    break;
                                                                case PropertyIDConstants.OutlineWidth /* 127 */:
                                                                    float f3 = (float) entry.getDouble();
                                                                    lynxBaseUI.setOutlineWidth(f3);
                                                                    orCreateUIPaintStyles.mOutlineWidth = f3;
                                                                    break;
                                                                default:
                                                                    switch (key) {
                                                                        case 186:
                                                                            if (!(lynxBaseUI instanceof LynxUI)) {
                                                                                break;
                                                                            } else {
                                                                                ReadableArray readableMapBufferWrapper26 = new ReadableMapBufferWrapper(entry.getMapBuffer());
                                                                                ((LynxUI) lynxBaseUI).setFilter(readableMapBufferWrapper26);
                                                                                orCreateUIPaintStyles.mFilter = readableMapBufferWrapper26;
                                                                                break;
                                                                            }
                                                                        case 187:
                                                                            if (!(lynxBaseUI instanceof AbsLynxList)) {
                                                                                break;
                                                                            } else {
                                                                                ((AbsLynxList) lynxBaseUI).setMainAxisGap((float) entry.getDouble());
                                                                                break;
                                                                            }
                                                                        case 188:
                                                                            if (!(lynxBaseUI instanceof AbsLynxList)) {
                                                                                break;
                                                                            } else {
                                                                                ((AbsLynxList) lynxBaseUI).setCrossAxisGap((float) entry.getDouble());
                                                                                break;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                            }
                                    }
                            }
                        } else if (lynxBaseUI instanceof LynxUI) {
                            ((LynxUI) lynxBaseUI).setExitTransitionName(new ReadableMapBufferWrapper(entry.getMapBuffer()));
                        }
                    } else if (lynxBaseUI instanceof LynxUI) {
                        ((LynxUI) lynxBaseUI).setEnterTransitionName(new ReadableMapBufferWrapper(entry.getMapBuffer()));
                    }
                }
                int i25 = entry.getInt();
                lynxBaseUI.setBackgroundColor(i25);
                orCreateUIPaintStyles.mBackgroundColor = i25;
            } else {
                lynxBaseUI.setCSSPosition(entry.getInt());
            }
        }
    }

    public static void updateUIPaintStyle(LynxBaseUI lynxBaseUI, UIPaintStyles uIPaintStyles) {
        if (lynxBaseUI == null || uIPaintStyles == null) {
            return;
        }
        lynxBaseUI.setBackgroundClip(uIPaintStyles.mBackgroundClip);
        lynxBaseUI.setBackgroundColor(uIPaintStyles.mBackgroundColor);
        lynxBaseUI.setBackgroundImage(uIPaintStyles.mBackgroundImage);
        lynxBaseUI.setBackgroundOrigin(uIPaintStyles.mBackgroundOrigin);
        lynxBaseUI.setBackgroundPosition(uIPaintStyles.mBackgroundPosition);
        lynxBaseUI.setBackgroundRepeat(uIPaintStyles.mBackgroundRepeat);
        lynxBaseUI.setBackgroundSize(uIPaintStyles.mBackgroundSize);
        lynxBaseUI.setMaskImage(uIPaintStyles.mMaskImage);
        lynxBaseUI.setMaskOrigin(uIPaintStyles.mMaskOrigin);
        lynxBaseUI.setMaskRepeat(uIPaintStyles.mMaskRepeat);
        lynxBaseUI.setMaskSize(uIPaintStyles.mMaskSize);
        lynxBaseUI.setMaskPosition(uIPaintStyles.mMaskPosition);
        lynxBaseUI.setMaskClip(uIPaintStyles.mMaskClip);
        lynxBaseUI.setBorderRadius(0, uIPaintStyles.mBorderRadius);
        lynxBaseUI.setBorderRadius(1, uIPaintStyles.mBorderTopLeftRadius);
        lynxBaseUI.setBorderRadius(2, uIPaintStyles.mBorderTopRightRadius);
        lynxBaseUI.setBorderRadius(3, uIPaintStyles.mBorderBottomRightRadius);
        lynxBaseUI.setBorderRadius(4, uIPaintStyles.mBorderBottomLeftRadius);
        lynxBaseUI.setOverflow(uIPaintStyles.mOverflow);
        lynxBaseUI.setOverflowX(uIPaintStyles.mOverflowX);
        lynxBaseUI.setOverflowY(uIPaintStyles.mOverflowY);
        lynxBaseUI.setBorderStyle(0, uIPaintStyles.mBorderStyle);
        lynxBaseUI.setBorderStyle(1, uIPaintStyles.mBorderLeftStyle);
        lynxBaseUI.setBorderStyle(2, uIPaintStyles.mBorderRightStyle);
        lynxBaseUI.setBorderStyle(3, uIPaintStyles.mBorderTopStyle);
        lynxBaseUI.setBorderStyle(4, uIPaintStyles.mBorderBottomStyle);
        lynxBaseUI.setBorderWidth(0, uIPaintStyles.mBorderWidth);
        lynxBaseUI.setBorderWidth(1, uIPaintStyles.mBorderLeftWidth);
        lynxBaseUI.setBorderWidth(2, uIPaintStyles.mBorderRightWidth);
        lynxBaseUI.setBorderWidth(3, uIPaintStyles.mBorderTopWidth);
        lynxBaseUI.setBorderWidth(4, uIPaintStyles.mBorderBottomWidth);
        lynxBaseUI.setBorderColor(0, uIPaintStyles.mBorderLeftColor);
        lynxBaseUI.setBorderColor(1, uIPaintStyles.mBorderRightColor);
        lynxBaseUI.setBorderColor(2, uIPaintStyles.mBorderTopColor);
        lynxBaseUI.setBorderColor(3, uIPaintStyles.mBorderBottomColor);
        lynxBaseUI.setOutlineColor(uIPaintStyles.mOutlineColor);
        lynxBaseUI.setOutlineWidth(uIPaintStyles.mOutlineWidth);
        lynxBaseUI.setOutlineStyle(uIPaintStyles.mOutlineStyle);
        lynxBaseUI.setFontSize(uIPaintStyles.mFontSize);
        lynxBaseUI.setLynxDirection(uIPaintStyles.mDirection);
        lynxBaseUI.setTransformOrigin(uIPaintStyles.mTransformOrigin);
        lynxBaseUI.setPerspective(uIPaintStyles.mPerspective);
        lynxBaseUI.setBoxShadow(uIPaintStyles.mBoxShadow);
        lynxBaseUI.setImageRendering(uIPaintStyles.mImageRendering);
        if (lynxBaseUI instanceof LynxUI) {
            LynxUI lynxUI = (LynxUI) lynxBaseUI;
            lynxUI.setClipPath(uIPaintStyles.mClipPath);
            lynxUI.setFilter(uIPaintStyles.mFilter);
            lynxUI.setLayoutAnimationCreateDelay(uIPaintStyles.mLayoutAnimationCreateDelay);
            lynxUI.setLayoutAnimationCreateDuration(uIPaintStyles.mLayoutAnimationCreateDuration);
            lynxUI.setLayoutAnimationCreateProperty(uIPaintStyles.mLayoutAnimationCreateProperty);
            lynxUI.setLayoutAnimationCreateTimingFunc(uIPaintStyles.mLayoutAnimationCreateTimingFunction);
            lynxUI.setLayoutAnimationDeleteDelay(uIPaintStyles.mLayoutAnimationDeleteDelay);
            lynxUI.setLayoutAnimationDeleteDuration(uIPaintStyles.mLayoutAnimationDeleteDuration);
            lynxUI.setLayoutAnimationDeleteProperty(uIPaintStyles.mLayoutAnimationDeleteProperty);
            lynxUI.setLayoutAnimationDeleteTimingFunc(uIPaintStyles.mLayoutAnimationDeleteTimingFunction);
            lynxUI.setLayoutAnimationUpdateDelay(uIPaintStyles.mLayoutAnimationUpdateDelay);
            lynxUI.setLayoutAnimationUpdateDuration(uIPaintStyles.mLayoutAnimationUpdateDuration);
            lynxUI.setLayoutAnimationUpdateTimingFunc(uIPaintStyles.mLayoutAnimationUpdateTimingFunction);
            lynxUI.setAlpha(uIPaintStyles.mOpacity);
            lynxUI.setVisibility(uIPaintStyles.mVisibility);
            lynxUI.setTransform(uIPaintStyles.mTransform);
        }
    }

    public static <T extends ShadowNode> void updateStyles(T t, MapBuffer mapBuffer) {
        if (mapBuffer == null || !(t instanceof BaseTextShadowNode)) {
            return;
        }
        BaseTextShadowNode baseTextShadowNode = (BaseTextShadowNode) t;
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            if (key == 22) {
                baseTextShadowNode.setColor((Dynamic) new DynamicFromMapBuffer(new ReadableMapBufferWrapper(mapBuffer), 22));
            } else if (key == 73) {
                baseTextShadowNode.setLineSpacing((float) entry.getDouble());
            } else if (key == 122) {
                baseTextShadowNode.setWordBreakStrategy(entry.getInt());
            } else if (key == 130) {
                baseTextShadowNode.setDirection(entry.getInt());
            } else if (key == 192) {
                baseTextShadowNode.setTextIndent(new ReadableMapBufferWrapper(entry.getMapBuffer()));
            } else if (key == 61) {
                baseTextShadowNode.setFontFamily(entry.getString());
            } else if (key == 62) {
                baseTextShadowNode.setFontStyle(entry.getInt());
            } else if (key == 96) {
                baseTextShadowNode.setTextDecoration((ReadableArray) new ReadableMapBufferWrapper(entry.getMapBuffer()));
            } else if (key == 97) {
                baseTextShadowNode.setTextShadow(new ReadableMapBufferWrapper(entry.getMapBuffer()));
            } else if (key == 195) {
                baseTextShadowNode.setTextStrokeWidth((float) entry.getDouble());
            } else if (key == 196) {
                baseTextShadowNode.setTextStrokeColor(new DynamicFromMapBuffer(new ReadableMapBufferWrapper(mapBuffer), 196));
            } else {
                switch (key) {
                    case 42:
                        baseTextShadowNode.setWhiteSpace(entry.getInt());
                        break;
                    case 43:
                        baseTextShadowNode.setLetterSpacing((float) entry.getDouble());
                        break;
                    case 44:
                        baseTextShadowNode.setTextAlign(entry.getInt());
                        break;
                    case 45:
                        baseTextShadowNode.setLineHeight((float) entry.getDouble());
                        break;
                    case 46:
                        baseTextShadowNode.setTextOverflow(entry.getInt());
                        break;
                    case 47:
                        baseTextShadowNode.setFontSize((float) entry.getDouble());
                        break;
                    case 48:
                        baseTextShadowNode.setFontWeight(entry.getInt());
                        break;
                }
            }
        }
    }
}
