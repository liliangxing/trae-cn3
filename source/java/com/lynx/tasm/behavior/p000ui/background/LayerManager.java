package com.lynx.tasm.behavior.p000ui.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.p000ui.LynxBaseUI;
import com.lynx.tasm.service.ILynxImageService;
import com.lynx.tasm.service.ILynxImageServiceExtension;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.PixelUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class LayerManager implements Drawable.Callback {
    protected LynxContext mContext;
    protected float mCurFontSize;
    protected Drawable mDrawable;
    private ILynxImageService mImageService;
    private ILynxImageServiceExtension mLynxImageService;
    protected Bitmap.Config mBitmapConfig = null;
    protected boolean mEnableBitmapGradient = false;
    protected List<BackgroundLayerDrawable> mImageLayerDrawableList = new ArrayList();
    protected List<BackgroundPosition> mImagePosList = new ArrayList();
    protected List<Integer> mImageOriginList = new ArrayList();
    protected List<Integer> mImageClipList = new ArrayList();
    protected List<BackgroundRepeat> mImageRepeatList = new ArrayList();
    protected List<BackgroundSize> mImageSizeList = new ArrayList();

    protected abstract boolean isMask();

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
    }

    public LayerManager(LynxContext lynxContext, Drawable drawable, float f) {
        this.mImageService = null;
        this.mLynxImageService = null;
        this.mContext = lynxContext;
        this.mDrawable = drawable;
        this.mCurFontSize = f;
        ILynxImageService iLynxImageService = (ILynxImageService) LynxServiceCenter.inst().getService(ILynxImageService.class);
        this.mImageService = iLynxImageService;
        this.mLynxImageService = iLynxImageService instanceof ILynxImageServiceExtension ? (ILynxImageServiceExtension) iLynxImageService : null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0133, code lost:
    
        if (r13 < r4) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0135, code lost:
    
        r12 = r17 * r4;
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0139, code lost:
    
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0145, code lost:
    
        if (r13 > r4) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, RectF rectF, RectF rectF2, RectF rectF3, RectF rectF4, Path path, Path path2, boolean z) {
        Path path3;
        boolean z2;
        float imageHeight;
        float imageWidth;
        RectF rectF5;
        RectF rectF6;
        double d;
        RectF rectF7;
        RectF rectF8;
        int i;
        BackgroundSize backgroundSize;
        BackgroundSize backgroundSize2;
        LayerManager layerManager = this;
        if (layerManager.mImageLayerDrawableList.isEmpty()) {
            return;
        }
        int i2 = 1;
        int size = layerManager.mImageLayerDrawableList.size() - 1;
        RectF rectF9 = rectF4;
        while (size >= 0) {
            if (layerManager.mImageLayerDrawableList.get(size).isReady()) {
                RectF rectF10 = isMask() ? rectF : rectF2;
                if (!layerManager.mImageOriginList.isEmpty()) {
                    int intValue = layerManager.mImageOriginList.get(size % layerManager.mImageOriginList.size()).intValue();
                    if (intValue == 0) {
                        rectF10 = rectF2;
                    } else if (intValue == i2) {
                        rectF10 = rectF;
                    } else if (intValue == 2) {
                        rectF10 = rectF3;
                    }
                }
                if (!layerManager.mImageClipList.isEmpty()) {
                    int intValue2 = layerManager.mImageClipList.get(size % layerManager.mImageClipList.size()).intValue();
                    if (intValue2 == 0) {
                        rectF9 = rectF2;
                    } else if (intValue2 == i2) {
                        rectF9 = rectF;
                    } else if (intValue2 != 2) {
                        path3 = null;
                        BackgroundLayerDrawable backgroundLayerDrawable = layerManager.mImageLayerDrawableList.get(size);
                        backgroundLayerDrawable.onAttach();
                        z2 = backgroundLayerDrawable instanceof BackgroundGradientLayer;
                        if (z2) {
                            imageWidth = rectF10.width();
                            imageHeight = rectF10.height();
                        } else {
                            float dipToPx = PixelUtils.dipToPx(1.0f);
                            imageHeight = dipToPx * layerManager.mImageLayerDrawableList.get(size).getImageHeight();
                            imageWidth = layerManager.mImageLayerDrawableList.get(size).getImageWidth() * dipToPx;
                        }
                        if (!layerManager.mImageSizeList.isEmpty() && layerManager.mImageSizeList.size() >= 2) {
                            i = size * 2;
                            if (i < layerManager.mImageSizeList.size()) {
                                List<BackgroundSize> list = layerManager.mImageSizeList;
                                backgroundSize = list.get(list.size() - 2);
                                backgroundSize2 = layerManager.mImageSizeList.get(r15.size() - 1);
                            } else {
                                BackgroundSize backgroundSize3 = layerManager.mImageSizeList.get(i);
                                BackgroundSize backgroundSize4 = layerManager.mImageSizeList.get(i + 1);
                                backgroundSize = backgroundSize3;
                                backgroundSize2 = backgroundSize4;
                            }
                            float width = rectF10.width();
                            float height = rectF10.height();
                            float f = imageWidth / imageHeight;
                            if (!backgroundSize.isCover()) {
                                imageHeight = width / f;
                            } else if (backgroundSize.isContain()) {
                                imageHeight = width / f;
                            } else {
                                imageWidth = backgroundSize.apply(width, imageWidth);
                                imageHeight = backgroundSize2.apply(height, imageHeight);
                                if (backgroundSize.isAuto()) {
                                    imageWidth = z2 ? rectF10.width() : f * imageHeight;
                                }
                                if (backgroundSize2.isAuto()) {
                                    imageHeight = z2 ? rectF10.height() : imageWidth / f;
                                }
                            }
                        }
                        if (!Double.valueOf(imageHeight).isNaN()) {
                            double d2 = imageWidth;
                            if (!Double.valueOf(d2).isNaN() && imageWidth >= 1.0f && imageHeight >= 1.0f) {
                                float f2 = rectF10.left;
                                float f3 = rectF10.top;
                                if (isMask()) {
                                    d = d2;
                                    if (layerManager.mImagePosList.size() < 2) {
                                        rectF6 = rectF9;
                                        f3 = (float) (f3 + ((rectF10.height() - imageHeight) * 0.5d));
                                        f2 = (float) (f2 + ((rectF10.width() - imageWidth) * 0.5d));
                                    } else {
                                        rectF6 = rectF9;
                                    }
                                } else {
                                    rectF6 = rectF9;
                                    d = d2;
                                }
                                if (layerManager.mImagePosList.size() >= 2) {
                                    int size2 = size % (layerManager.mImagePosList.size() / 2);
                                    float width2 = rectF10.width() - imageWidth;
                                    rectF8 = rectF6;
                                    float height2 = rectF10.height() - imageHeight;
                                    rectF7 = rectF10;
                                    int i3 = size2 * 2;
                                    BackgroundPosition backgroundPosition = layerManager.mImagePosList.get(i3);
                                    BackgroundPosition backgroundPosition2 = layerManager.mImagePosList.get(i3 + 1);
                                    f2 += backgroundPosition.apply(width2);
                                    f3 += backgroundPosition2.apply(height2);
                                } else {
                                    rectF7 = rectF10;
                                    rectF8 = rectF6;
                                }
                                BackgroundRepeat backgroundRepeat = BackgroundRepeat.REPEAT;
                                BackgroundRepeat backgroundRepeat2 = BackgroundRepeat.REPEAT;
                                if (layerManager.mImageRepeatList.size() >= 2) {
                                    int size3 = (size % (layerManager.mImageRepeatList.size() / 2)) * 2;
                                    BackgroundRepeat backgroundRepeat3 = layerManager.mImageRepeatList.get(size3);
                                    backgroundRepeat2 = layerManager.mImageRepeatList.get(size3 + 1);
                                    backgroundRepeat = backgroundRepeat3;
                                }
                                backgroundLayerDrawable.setEnableBitmapGradient(layerManager.mEnableBitmapGradient);
                                backgroundLayerDrawable.setBounds(new Rect(0, 0, Math.round(imageWidth), Math.round(imageHeight)));
                                if (path != null && z2 && !z) {
                                    backgroundLayerDrawable.setPathEffect(path);
                                }
                                int save = canvas.save();
                                if (path3 != null && z) {
                                    canvas.clipPath(path3);
                                    rectF5 = rectF8;
                                } else {
                                    rectF5 = rectF8;
                                    canvas.clipRect(rectF5);
                                }
                                if (backgroundRepeat == BackgroundRepeat.NO_REPEAT && backgroundRepeat2 == BackgroundRepeat.NO_REPEAT) {
                                    canvas.save();
                                    canvas.translate(f2, f3);
                                    backgroundLayerDrawable.draw(canvas);
                                    canvas.restore();
                                } else {
                                    RectF rectF11 = rectF7;
                                    float max = (int) Math.max(rectF11.right, rectF5.right);
                                    float max2 = (int) Math.max(rectF11.bottom, rectF5.bottom);
                                    if (backgroundRepeat == BackgroundRepeat.REPEAT || backgroundRepeat == BackgroundRepeat.REPEAT_X) {
                                        f2 -= ((int) Math.ceil(f2 / d)) * imageWidth;
                                    }
                                    if (backgroundRepeat2 == BackgroundRepeat.REPEAT || backgroundRepeat2 == BackgroundRepeat.REPEAT_Y) {
                                        f3 -= ((int) Math.ceil(f3 / r14)) * imageHeight;
                                    }
                                    canvas.save();
                                    canvas.clipRect(rectF5);
                                    while (f2 < max) {
                                        for (float f4 = f3; f4 < max2; f4 += imageHeight) {
                                            canvas.save();
                                            canvas.translate(f2, f4);
                                            backgroundLayerDrawable.draw(canvas);
                                            canvas.restore();
                                            if (backgroundRepeat2 == BackgroundRepeat.NO_REPEAT) {
                                                break;
                                            }
                                        }
                                        if (backgroundRepeat == BackgroundRepeat.NO_REPEAT) {
                                            break;
                                        } else {
                                            f2 += imageWidth;
                                        }
                                    }
                                    canvas.restore();
                                }
                                canvas.restoreToCount(save);
                                rectF9 = rectF5;
                            }
                        }
                        rectF5 = rectF9;
                        rectF9 = rectF5;
                    } else {
                        rectF9 = rectF3;
                    }
                    path3 = path2;
                    BackgroundLayerDrawable backgroundLayerDrawable2 = layerManager.mImageLayerDrawableList.get(size);
                    backgroundLayerDrawable2.onAttach();
                    z2 = backgroundLayerDrawable2 instanceof BackgroundGradientLayer;
                    if (z2) {
                    }
                    if (!layerManager.mImageSizeList.isEmpty()) {
                        i = size * 2;
                        if (i < layerManager.mImageSizeList.size()) {
                        }
                        float width3 = rectF10.width();
                        float height3 = rectF10.height();
                        float f5 = imageWidth / imageHeight;
                        if (!backgroundSize.isCover()) {
                        }
                    }
                    if (!Double.valueOf(imageHeight).isNaN()) {
                    }
                    rectF5 = rectF9;
                    rectF9 = rectF5;
                }
                path3 = path;
                BackgroundLayerDrawable backgroundLayerDrawable22 = layerManager.mImageLayerDrawableList.get(size);
                backgroundLayerDrawable22.onAttach();
                z2 = backgroundLayerDrawable22 instanceof BackgroundGradientLayer;
                if (z2) {
                }
                if (!layerManager.mImageSizeList.isEmpty()) {
                }
                if (!Double.valueOf(imageHeight).isNaN()) {
                }
                rectF5 = rectF9;
                rectF9 = rectF5;
            }
            size--;
            i2 = 1;
            layerManager = this;
        }
    }

    public void reset() {
        resetLayers();
    }

    public void resetLayers() {
        this.mImageLayerDrawableList.clear();
        this.mImagePosList.clear();
        this.mImageSizeList.clear();
        this.mImageOriginList.clear();
        this.mImageRepeatList.clear();
        this.mImageClipList.clear();
    }

    public boolean hasImageLayers() {
        return !this.mImageLayerDrawableList.isEmpty();
    }

    public void setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        List<BackgroundLayerDrawable> list = this.mImageLayerDrawableList;
        if (list == null) {
            return;
        }
        for (BackgroundLayerDrawable backgroundLayerDrawable : list) {
            if (backgroundLayerDrawable != null) {
                backgroundLayerDrawable.setBitmapConfig(this.mBitmapConfig);
            }
        }
    }

    public void setLayerImage(ReadableArray readableArray, LynxBaseUI lynxBaseUI) {
        BackgroundLayerDrawable createBackgroundImageDrawable;
        Iterator<BackgroundLayerDrawable> it = this.mImageLayerDrawableList.iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
        this.mImageLayerDrawableList.clear();
        if (readableArray == null) {
            return;
        }
        Rect bounds = this.mDrawable.getBounds();
        int size = readableArray.size();
        int i = 0;
        while (i < size) {
            int i2 = (int) readableArray.getLong(i);
            if (i2 == 1) {
                i++;
                if (this.mLynxImageService != null && !this.mContext.isEmbeddedModeOn() && (createBackgroundImageDrawable = this.mLynxImageService.createBackgroundImageDrawable(this.mContext, readableArray.getString(i))) != null) {
                    createBackgroundImageDrawable.setLynxUI(lynxBaseUI);
                    createBackgroundImageDrawable.setCallback(this);
                    this.mImageLayerDrawableList.add(createBackgroundImageDrawable);
                }
                i++;
            } else if (i2 == 2) {
                i++;
                this.mImageLayerDrawableList.add(new BackgroundLinearGradientLayer(readableArray.getArray(i)));
            } else if (i2 == 3) {
                i++;
                this.mImageLayerDrawableList.add(new BackgroundRadialGradientLayer(readableArray.getArray(i)));
            } else if (i2 == 0) {
                i++;
                this.mImageLayerDrawableList.add(new BackgroundNoneLayer());
            }
            if (!bounds.isEmpty()) {
                List<BackgroundLayerDrawable> list = this.mImageLayerDrawableList;
                list.get(list.size() - 1).onSizeChanged(bounds.width(), bounds.height());
            }
            i++;
        }
    }

    public void setLayerPosition(ReadableArray readableArray) {
        this.mImagePosList.clear();
        if (readableArray == null || readableArray.size() % 2 != 0) {
            return;
        }
        for (int i = 0; i < readableArray.size(); i += 2) {
            this.mImagePosList.add(new BackgroundPosition(readableArray.getDynamic(i), readableArray.getInt(i + 1)));
        }
    }

    public void setLayerOrigin(ReadableArray readableArray) {
        this.mImageOriginList.clear();
        if (readableArray == null) {
            return;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            int i2 = readableArray.getInt(i);
            if (i2 < 0 || i2 > 2) {
                i2 = 1;
            }
            this.mImageOriginList.add(Integer.valueOf(i2));
        }
    }

    public void setLayerRepeat(ReadableArray readableArray) {
        this.mImageRepeatList.clear();
        if (readableArray == null) {
            return;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            this.mImageRepeatList.add(BackgroundRepeat.valueOf(readableArray.getInt(i)));
        }
    }

    public void setLayerClip(ReadableArray readableArray) {
        this.mImageClipList.clear();
        if (readableArray == null) {
            return;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            int i2 = readableArray.getInt(i);
            if (i2 < 0 || i2 > 2) {
                this.mImageClipList.add(1);
            } else {
                this.mImageClipList.add(Integer.valueOf(i2));
            }
        }
    }

    public int getLayerClip() {
        if (this.mImageClipList.isEmpty()) {
            return 1;
        }
        List<Integer> list = this.mImageClipList;
        return list.get(list.size() - 1).intValue();
    }

    public void setLayerSize(ReadableArray readableArray) {
        this.mImageSizeList.clear();
        if (readableArray == null || readableArray.size() % 2 != 0) {
            return;
        }
        int size = readableArray.size();
        for (int i = 0; i < size; i += 2) {
            this.mImageSizeList.add(new BackgroundSize(readableArray.getDynamic(i), readableArray.getInt(i + 1)));
        }
    }

    public void onAttach() {
        Iterator<BackgroundLayerDrawable> it = this.mImageLayerDrawableList.iterator();
        while (it.hasNext()) {
            it.next().onAttach();
        }
    }

    public void onDetach() {
        Iterator<BackgroundLayerDrawable> it = this.mImageLayerDrawableList.iterator();
        while (it.hasNext()) {
            it.next().onDetach();
        }
    }

    public void configureBounds(Rect rect) {
        Iterator<BackgroundLayerDrawable> it = this.mImageLayerDrawableList.iterator();
        while (it.hasNext()) {
            it.next().onSizeChanged(rect.width(), rect.height());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        this.mDrawable.invalidateSelf();
    }

    public void setEnableBitmapGradient(boolean z) {
        this.mEnableBitmapGradient = z;
    }
}
