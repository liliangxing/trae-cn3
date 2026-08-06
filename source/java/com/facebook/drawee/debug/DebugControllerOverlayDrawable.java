package com.facebook.drawee.debug;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.core.internal.view.SupportMenu;
import com.facebook.drawee.debug.listener.ImageLoadingTimeListener;
import com.facebook.drawee.drawable.ScalingUtils;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class DebugControllerOverlayDrawable extends Drawable implements ImageLoadingTimeListener {
    private static final int DEFAULT_LIMIT_BITMAP_CONTRAST = 2;
    private static final long DEFAULT_LIMIT_FILE_SIZE = 20971520;
    private static final long DEFAULT_LIMIT_RAM_SIZE;
    private static final float IMAGE_SIZE_THRESHOLD_NOT_OK = 0.5f;
    private static final float IMAGE_SIZE_THRESHOLD_OK = 0.1f;
    private static final int MAX_LINE_WIDTH_EM = 8;
    private static final int MAX_NUMBER_OF_LINES = 9;
    private static final int MAX_TEXT_SIZE_PX = 40;
    private static final int MIN_TEXT_SIZE_PX = 10;
    private static final String NO_CONTROLLER_ID = "none";
    private static final int OUTLINE_COLOR = -26624;
    private static final int OUTLINE_STROKE_WIDTH_PX = 2;
    static final int OVERLAY_COLOR_IMAGE_ALMOST_OK = 1728026624;
    static final int OVERLAY_COLOR_IMAGE_NOT_OK = 1727284022;
    static final int OVERLAY_COLOR_IMAGE_OK = 1716301648;
    private static final int TEXT_BACKGROUND_COLOR = 268435456;
    private static final int TEXT_COLOR = -1;
    private static final int TEXT_LINE_SPACING_PX = 8;
    private static final int TEXT_PADDING_PX = 10;
    private static boolean isShowAnim;
    private static boolean isShowBigImage;
    private static boolean isShowFormat;
    private static boolean isShowID;
    private static boolean isShowIDS;
    private static boolean isShowImageSize;
    private static boolean isShowImageWH;
    private static boolean isShowOrigin;
    private static boolean isShowScale;
    private static boolean isShowTimeCost;
    private static boolean isShowViewWH;
    private static float mPaintSizeRatio;
    private static int sLimitBitmapContrast;
    private static long sLimitFileSize;
    private static long sLimitRamSize;
    private String mBigReason;
    private String mControllerId;
    private int mCurrentTextXPx;
    private int mCurrentTextYPx;
    private long mFileSize;
    private long mFinalImageTimeMs;
    private int mFrameCount;
    private int mHeightPx;
    private String mImageFormat;
    private String mImageId;
    private int mImageSizeBytes;
    private boolean mIsBigImage;
    private int mLineIncrementPx;
    private int mLoopCount;
    private String mOrigin;
    private ScalingUtils.ScaleType mScaleType;
    private int mStartTextXPx;
    private int mStartTextYPx;
    private int mWidthPx;
    private int mTextGravity = 80;
    private final Paint mPaint = new Paint(1);
    private final Matrix mMatrix = new Matrix();
    private final Rect mRect = new Rect();
    private final RectF mRectF = new RectF();

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    static {
        long screenPixelMemory = getScreenPixelMemory();
        DEFAULT_LIMIT_RAM_SIZE = screenPixelMemory;
        sLimitBitmapContrast = 2;
        sLimitFileSize = 20971520L;
        sLimitRamSize = screenPixelMemory;
        isShowOrigin = true;
        isShowTimeCost = true;
        isShowScale = true;
        isShowImageSize = true;
        isShowFormat = true;
        isShowImageWH = true;
        isShowViewWH = true;
        isShowID = true;
        isShowIDS = true;
        isShowAnim = true;
        isShowBigImage = false;
        mPaintSizeRatio = 1.0f;
    }

    public DebugControllerOverlayDrawable() {
        reset();
    }

    public void reset() {
        this.mWidthPx = -1;
        this.mHeightPx = -1;
        this.mImageSizeBytes = -1;
        this.mFrameCount = -1;
        this.mLoopCount = -1;
        this.mImageFormat = null;
        setControllerId(null);
        this.mFinalImageTimeMs = -1L;
        this.mOrigin = null;
        invalidateSelf();
    }

    public static void showBigOverlayInfo(boolean z) {
        isShowBigImage = z;
    }

    public static void showOverlayInfo(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11) {
        isShowOrigin = z;
        isShowTimeCost = z2;
        isShowScale = z3;
        isShowImageSize = z4;
        isShowFormat = z5;
        isShowImageWH = z6;
        isShowViewWH = z7;
        isShowID = z8;
        isShowIDS = z9;
        isShowAnim = z10;
        isShowBigImage = z11;
    }

    private static long getScreenPixelMemory() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return displayMetrics.heightPixels * displayMetrics.widthPixels * 4;
    }

    public static void setLimit(int i, long j, long j2) {
        sLimitBitmapContrast = i;
        sLimitFileSize = j;
        sLimitRamSize = j2;
    }

    public static void setPaintSizeRatio(float f) {
        mPaintSizeRatio = f;
    }

    public void setTextGravity(int i) {
        this.mTextGravity = i;
        invalidateSelf();
    }

    public void setControllerId(@Nullable String str) {
        if (str == null) {
            str = "none";
        }
        this.mControllerId = str;
        invalidateSelf();
    }

    public void setImageId(@Nullable String str) {
        this.mImageId = str;
        invalidateSelf();
    }

    public void setDimensions(int i, int i2) {
        this.mWidthPx = i;
        this.mHeightPx = i2;
        invalidateSelf();
    }

    public void setAnimationInfo(int i, int i2) {
        this.mFrameCount = i;
        this.mLoopCount = i2;
        invalidateSelf();
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
        invalidateSelf();
    }

    public void setImageSize(int i) {
        this.mImageSizeBytes = i;
    }

    public void setFileSize(long j) {
        this.mFileSize = j;
    }

    public void setImageFormat(@Nullable String str) {
        this.mImageFormat = str;
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        prepareDebugTextParameters(rect, 9, 8);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setColor(OUTLINE_COLOR);
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(determineOverlayColor(this.mWidthPx, this.mHeightPx, this.mScaleType));
        canvas.drawRect(bounds.left, bounds.top, bounds.right, bounds.bottom, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setStrokeWidth(0.0f);
        this.mPaint.setColor(-1);
        this.mCurrentTextXPx = this.mStartTextXPx;
        this.mCurrentTextYPx = this.mStartTextYPx;
        String str = this.mImageId;
        if (str != null) {
            if (isShowIDS) {
                addDebugText(canvas, "IDs: %s, %s", this.mControllerId, str);
            }
        } else if (isShowID) {
            addDebugText(canvas, "ID: %s", this.mControllerId);
        }
        if (isShowViewWH) {
            addDebugText(canvas, "D: %dx%d", Integer.valueOf(bounds.width()), Integer.valueOf(bounds.height()));
        }
        if (isShowImageWH) {
            addDebugText(canvas, "I: %dx%d", Integer.valueOf(this.mWidthPx), Integer.valueOf(this.mHeightPx));
        }
        if (isShowImageSize) {
            addDebugText(canvas, "I: %d KiB", Integer.valueOf(this.mImageSizeBytes / 1024));
        }
        String str2 = this.mImageFormat;
        if (str2 != null && isShowFormat) {
            addDebugText(canvas, "i format: %s", str2);
        }
        int i = this.mFrameCount;
        if (i > 0 && isShowAnim) {
            addDebugText(canvas, "anim: f %d, l %d", Integer.valueOf(i), Integer.valueOf(this.mLoopCount));
        }
        ScalingUtils.ScaleType scaleType = this.mScaleType;
        if (scaleType != null && isShowScale) {
            addDebugText(canvas, "scale: %s", scaleType);
        }
        long j = this.mFinalImageTimeMs;
        if (j >= 0 && isShowTimeCost) {
            addDebugText(canvas, "t: %d ms", Long.valueOf(j));
        }
        String str3 = this.mOrigin;
        if (str3 != null && isShowOrigin) {
            addDebugText(canvas, "origin: %s", str3);
        }
        if (isShowBigImage) {
            this.mBigReason = "";
            if (this.mFileSize > sLimitFileSize) {
                this.mIsBigImage = true;
                this.mBigReason = "File,";
            }
            if (this.mImageSizeBytes > sLimitRamSize) {
                this.mIsBigImage = true;
                this.mBigReason += "Ram,";
            }
            if (this.mWidthPx > bounds.width() * sLimitBitmapContrast || this.mHeightPx > bounds.height() * sLimitBitmapContrast) {
                this.mIsBigImage = true;
                this.mBigReason += "WH";
            }
            boolean z = this.mIsBigImage;
            if (!z) {
                this.mBigReason = "Not Big";
            }
            addDebugTextWithColor(canvas, "isBigImg", this.mBigReason, z ? SupportMenu.CATEGORY_MASK : -16711936);
        }
    }

    private void prepareDebugTextParameters(Rect rect, int i, int i2) {
        this.mPaint.setTextSize(Math.min(40, Math.max(10, Math.min(rect.width() / i2, rect.height() / i))) * mPaintSizeRatio);
        int i3 = (int) ((r5 + 8) * mPaintSizeRatio);
        this.mLineIncrementPx = i3;
        if (this.mTextGravity == 80) {
            this.mLineIncrementPx = i3 * (-1);
        }
        this.mStartTextXPx = rect.left + 10;
        this.mStartTextYPx = this.mTextGravity == 80 ? rect.bottom - 10 : rect.top + 10 + 10;
    }

    private void addDebugText(Canvas canvas, String str, @Nullable Object... objArr) {
        if (objArr == null) {
            canvas.drawText(str, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        } else {
            canvas.drawText(String.format(str, objArr), this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        }
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    private void addDebugTextWithColor(Canvas canvas, String str, String str2, int i) {
        String str3 = str + ": ";
        float measureText = this.mPaint.measureText(str3);
        float measureText2 = this.mPaint.measureText(str2);
        this.mPaint.setColor(268435456);
        int i2 = this.mCurrentTextXPx;
        int i3 = this.mCurrentTextYPx;
        canvas.drawRect(i2 - 4, i3 + 8, i2 + measureText + measureText2 + 4.0f, i3 + this.mLineIncrementPx + 8, this.mPaint);
        this.mPaint.setColor(-1);
        canvas.drawText(str3, this.mCurrentTextXPx, this.mCurrentTextYPx, this.mPaint);
        this.mPaint.setColor(i);
        canvas.drawText(str2, this.mCurrentTextXPx + measureText, this.mCurrentTextYPx, this.mPaint);
        this.mCurrentTextYPx += this.mLineIncrementPx;
    }

    int determineOverlayColor(int i, int i2, @Nullable ScalingUtils.ScaleType scaleType) {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width > 0 && height > 0 && i > 0 && i2 > 0) {
            if (scaleType != null) {
                Rect rect = this.mRect;
                rect.top = 0;
                rect.left = 0;
                this.mRect.right = width;
                this.mRect.bottom = height;
                this.mMatrix.reset();
                scaleType.getTransform(this.mMatrix, this.mRect, i, i2, 0.0f, 0.0f);
                RectF rectF = this.mRectF;
                rectF.top = 0.0f;
                rectF.left = 0.0f;
                this.mRectF.right = i;
                this.mRectF.bottom = i2;
                this.mMatrix.mapRect(this.mRectF);
                int width2 = (int) this.mRectF.width();
                int height2 = (int) this.mRectF.height();
                width = Math.min(width, width2);
                height = Math.min(height, height2);
            }
            float f = width;
            float f2 = f * 0.1f;
            float f3 = f * 0.5f;
            float f4 = height;
            float f5 = 0.1f * f4;
            float f6 = f4 * 0.5f;
            int abs = Math.abs(i - width);
            int abs2 = Math.abs(i2 - height);
            float f7 = abs;
            if (f7 < f2 && abs2 < f5) {
                return OVERLAY_COLOR_IMAGE_OK;
            }
            if (f7 < f3 && abs2 < f6) {
                return OVERLAY_COLOR_IMAGE_ALMOST_OK;
            }
        }
        return OVERLAY_COLOR_IMAGE_NOT_OK;
    }

    public void setFinalImageTimeMs(long j) {
        this.mFinalImageTimeMs = j;
    }

    @Override // com.facebook.drawee.debug.listener.ImageLoadingTimeListener
    public void onFinalImageSet(long j) {
        this.mFinalImageTimeMs = j;
        invalidateSelf();
    }
}
