package com.lynx.tasm.behavior.p000ui.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.RemoteException;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.lynx.R;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.shadow.text.TextHelper;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import com.lynx.tasm.event.LynxDetailEvent;
import com.lynx.tasm.service.ILynxSystemInvokeService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AndroidText extends AndroidView implements ActionMode.Callback {
    private static final int DEFAULT_TEXT_HANDLE_COLOR = -16614661;
    private static final int DEFAULT_TEXT_HANDLE_SIZE = 15;
    private static final int DEFAULT_TEXT_SELECTION_COLOR = 1714664933;
    private static final int ID_COPY = 65534;
    private static final int ID_SELECT_ALL = 65533;
    private static final float RESPONSE_TOUCH_RADIUS = 50.0f;
    protected static final String SELECTION_CHANGE_EVENT = "selectionchange";
    private static WeakReference<AndroidText> sWeakSelectingAndroidText;
    private ActionMode mActionMode;
    private CheckForLongPress mCheckForLongPress;
    private int mDefaultHandlePlatformLength;
    private boolean mEnableCustomContextMenu;
    private boolean mEnableCustomTextSelection;
    private boolean mEnableTextSelection;
    private final PointF mEndHandlerPos;
    private int mHandleSize;
    protected boolean mHasImage;
    private Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mIsAdjustEndPos;
    private boolean mIsAdjustStartPos;
    private boolean mIsBindSelectionChange;
    private boolean mIsForward;
    private boolean mIsInSelection;
    protected boolean mIsJustify;
    private boolean mIsShowEndHandle;
    private boolean mIsShowStartHandle;
    private int mLastSelectEnd;
    private int mLastSelectStart;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private int mOverflow;
    private Picture mOverflowPicture;
    private boolean mOverflowPictureDirty;
    private int mSelectEnd;
    private final PointF mSelectEndPos;
    private int mSelectStart;
    private final PointF mSelectStartPos;
    private Drawable mSelectionLeftCursor;
    private Drawable mSelectionRightCursor;
    private boolean mShouldResponseMove;
    private int mSign;
    private final PointF mStartHandlerPos;
    protected Layout mTextLayout;
    private int mTextSelectionColor;
    private int mTextSelectionHandleColor;
    protected PointF mTextTranslateOffset;
    protected TextUpdateBundle mTextUpdateBundle;

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void setTextGradient(ReadableArray readableArray) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public final class CheckForLongPress implements Runnable {

        /* renamed from: mX */
        private final float f10mX;

        /* renamed from: mY */
        private final float f11mY;

        public CheckForLongPress(float f, float f2) {
            this.f10mX = f;
            this.f11mY = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AndroidText.this.mIsInSelection = true;
            AndroidText.this.mSelectStartPos.set(this.f10mX, this.f11mY);
            AndroidText.this.mSelectEndPos.set(this.f10mX, this.f11mY);
            AndroidText androidText = AndroidText.this;
            androidText.mSelectEnd = androidText.mSelectStart = androidText.getOffsetForPosition(this.f10mX, this.f11mY);
            AndroidText.this.mIsAdjustEndPos = true;
            AndroidText.this.requestDisallowInterceptTouchEvent(true);
            AndroidText.this.mCheckForLongPress = null;
        }
    }

    public AndroidText(Context context) {
        super(context);
        this.mNeedDrawStroke = false;
        this.mIsBindSelectionChange = false;
        this.mSign = 0;
        this.mIsForward = true;
        this.mEnableTextSelection = false;
        this.mEnableCustomContextMenu = false;
        this.mEnableCustomTextSelection = false;
        this.mActionMode = null;
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        this.mSelectStartPos = new PointF(-1.0f, -1.0f);
        this.mSelectEndPos = new PointF(-1.0f, -1.0f);
        this.mStartHandlerPos = new PointF(-1.0f, -1.0f);
        this.mEndHandlerPos = new PointF(-1.0f, -1.0f);
        this.mIsInSelection = false;
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mCheckForLongPress = null;
        this.mShouldResponseMove = false;
        this.mIsShowStartHandle = true;
        this.mIsShowEndHandle = true;
        this.mOverflowPicture = new Picture();
        this.mOverflow = 0;
        this.mOverflowPictureDirty = true;
        setFocusable(true);
        setWillNotDraw(false);
        this.mTextSelectionColor = DEFAULT_TEXT_SELECTION_COLOR;
        this.mTextSelectionHandleColor = DEFAULT_TEXT_HANDLE_COLOR;
        int round = Math.round(((LynxContext) context).getScreenMetrics().density * 15.0f);
        this.mDefaultHandlePlatformLength = round;
        this.mHandleSize = round;
    }

    public void setTextBundle(TextUpdateBundle textUpdateBundle) {
        dispatchDetachImageSpan();
        this.mTextUpdateBundle = textUpdateBundle;
        this.mTextLayout = generateTextLayout(textUpdateBundle);
        this.mTextTranslateOffset = textUpdateBundle.getTextTranslateOffset();
        this.mHasImage = textUpdateBundle.hasImages();
        this.mNeedDrawStroke = textUpdateBundle.getNeedDrawStroke();
        this.mIsJustify = textUpdateBundle.isJustify();
        this.mOriginText = textUpdateBundle.getOriginText();
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), this);
        }
        if (this.mIsInSelection) {
            clearSelection();
        } else {
            resetSelectionState();
        }
        setContentDescription(this.mTextLayout.getText());
        invalidate();
        this.mOverflowPictureDirty = true;
    }

    private void resetSelectionState() {
        this.mLastSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mSelectEnd = -1;
        this.mSelectStart = -1;
        this.mShouldResponseMove = false;
        this.mIsAdjustEndPos = false;
        this.mIsAdjustStartPos = false;
        this.mIsInSelection = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    protected Layout generateTextLayout(TextUpdateBundle textUpdateBundle) {
        return textUpdateBundle.getTextLayout();
    }

    @Deprecated
    public void setTextGradient(String str) {
        LLog.e("text-gradient", "setTextGradient(String) is deprecated, call this function has no effect");
    }

    public void setEnableTextSelection(boolean z) {
        this.mEnableTextSelection = z;
    }

    public void updateSelectionBackgroundColor(int i) {
        if (i == 0) {
            i = DEFAULT_TEXT_SELECTION_COLOR;
        }
        this.mTextSelectionColor = i;
    }

    public void updateSelectionHandleColor(int i) {
        if (i == 0) {
            i = DEFAULT_TEXT_HANDLE_COLOR;
        }
        this.mTextSelectionHandleColor = i;
    }

    public void updateSelectionHandleSize(int i) {
        if (i <= 0) {
            i = this.mDefaultHandlePlatformLength;
        }
        this.mHandleSize = i;
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mTextLayout == null || !this.mEnableTextSelection || this.mEnableCustomTextSelection) {
            return super.onTouchEvent(motionEvent);
        }
        float x = motionEvent.getX() - getPaddingLeft();
        float y = motionEvent.getY() - getPaddingTop();
        if (motionEvent.getAction() == 0) {
            performBeginSelection(x, y);
        } else if (motionEvent.getAction() == 2) {
            performMovingSelection(x, y);
        } else if (motionEvent.getAction() == 1) {
            performEndSelection(x, y);
        } else if (this.mShouldResponseMove) {
            performEndSelection(x, y);
        } else {
            removeCheckLongPressCallback();
        }
        invalidate();
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mTextLayout != null) {
            canvas.save();
            canvas.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
            if (this.mOverflow != 0) {
                drawHighlight(canvas);
                drawOverflowPicture();
                canvas.drawPicture(this.mOverflowPicture);
            } else {
                drawText(canvas);
            }
            canvas.restore();
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Path path;
        super.dispatchDraw(canvas);
        if (!this.mIsInSelection || (path = this.mHighlightPath) == null || path.isEmpty()) {
            return;
        }
        canvas.save();
        canvas.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        drawSelectHandle(canvas);
        canvas.restore();
    }

    private void drawTextOnCanvas(Canvas canvas) {
        if (this.mIsJustify && Build.VERSION.SDK_INT < 26) {
            TextHelper.drawText(canvas, this.mTextLayout, (getWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.mTextLayout.draw(canvas);
        }
    }

    private void drawHighlight(Canvas canvas) {
        Path path;
        if (!this.mIsInSelection || (path = this.mHighlightPath) == null || this.mHighlightPaint == null) {
            return;
        }
        path.reset();
        this.mTextLayout.getSelectionPath(Math.min(this.mSelectStart, this.mSelectEnd), Math.max(this.mSelectStart, this.mSelectEnd), this.mHighlightPath);
        if (this.mHighlightPath.isEmpty()) {
            return;
        }
        canvas.drawPath(this.mHighlightPath, this.mHighlightPaint);
    }

    private void drawText(Canvas canvas) {
        drawHighlight(canvas);
        drawTextOnCanvas(canvas);
        if (this.mNeedDrawStroke) {
            TextHelper.drawTextStroke(this.mTextLayout, canvas);
        }
        TextHelper.drawLine(canvas, this.mTextLayout);
    }

    public ArrayList<RectF> getTextBoundingBoxes(int i, int i2) {
        ArrayList<RectF> arrayList = new ArrayList<>();
        Layout layout = this.mTextLayout;
        if (layout != null && layout.getText().length() >= i2 && i <= i2 && i >= 0) {
            if (i == i2) {
                int lineForOffset = this.mTextLayout.getLineForOffset(i);
                arrayList.add(new RectF(0.0f, 0.0f, 0.0f, this.mTextLayout.getLineBottom(lineForOffset) - this.mTextLayout.getLineTop(lineForOffset)));
            } else {
                int lineForOffset2 = this.mTextLayout.getLineForOffset(i);
                int lineForOffset3 = this.mTextLayout.getLineForOffset(i2);
                for (int i3 = lineForOffset2; i3 <= lineForOffset3; i3++) {
                    Rect rect = new Rect();
                    this.mTextLayout.getLineBounds(i3, rect);
                    if (i3 == lineForOffset2 || i3 == lineForOffset3) {
                        rect.left = (int) Math.max(rect.left, this.mTextLayout.getSecondaryHorizontal(i));
                        rect.right = (int) Math.min(rect.right, this.mTextLayout.getSecondaryHorizontal(i2));
                    }
                    rect.left = (int) (rect.left - this.mTextTranslateOffset.x);
                    rect.right = (int) (rect.right - this.mTextTranslateOffset.x);
                    rect.top = (int) (rect.top - this.mTextTranslateOffset.y);
                    rect.bottom = (int) (rect.bottom - this.mTextTranslateOffset.y);
                    arrayList.add(new RectF(rect));
                }
            }
        }
        return arrayList;
    }

    public void setBindSelectionChange(boolean z, int i) {
        this.mIsBindSelectionChange = z;
        this.mSign = i;
    }

    private void onSelectionChange() {
        if (this.mIsBindSelectionChange && (getContext() instanceof LynxContext)) {
            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(this.mSign, SELECTION_CHANGE_EVENT);
            lynxDetailEvent.addDetail("start", Integer.valueOf(this.mSelectStart));
            lynxDetailEvent.addDetail("end", Integer.valueOf(this.mSelectEnd));
            lynxDetailEvent.addDetail(PropsConstants.DRIECTION, this.mIsForward ? "forward" : "backward");
            ((LynxContext) getContext()).getEventEmitter().sendCustomEvent(lynxDetailEvent);
        }
    }

    public void setCustomContextMenu(boolean z) {
        this.mEnableCustomContextMenu = z;
    }

    public void setCustomTextSelection(boolean z) {
        this.mEnableCustomTextSelection = z;
    }

    public ArrayList<RectF> setTextSelection(float f, float f2, float f3, float f4, boolean z, boolean z2) {
        invalidate();
        if (f < 0.0f || f2 < 0.0f || f3 < 0.0f || f4 < 0.0f) {
            clearSelection();
            return new ArrayList<>();
        }
        int offsetForPosition = getOffsetForPosition(f, f2);
        int offsetForPosition2 = getOffsetForPosition(f3, f4);
        if (offsetForPosition < 0 || offsetForPosition2 < 0) {
            clearSelection();
            return new ArrayList<>();
        }
        if (offsetForPosition == offsetForPosition2) {
            PointF centerPositionForOffset = getCenterPositionForOffset(offsetForPosition);
            if (offsetForPosition == this.mTextLayout.getText().length() || (offsetForPosition > 0 && f < centerPositionForOffset.x)) {
                offsetForPosition--;
            } else {
                offsetForPosition2++;
            }
        }
        this.mIsShowStartHandle = z;
        this.mIsShowEndHandle = z2;
        this.mIsInSelection = true;
        updateSelectionRange(offsetForPosition, offsetForPosition2);
        updateSelectStartEnd();
        return getTextBoundingBoxes(this.mSelectStart, this.mSelectEnd);
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (!this.mIsInSelection) {
            return new ArrayList[0];
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        arrayList.add(Float.valueOf(this.mStartHandlerPos.x));
        arrayList.add(Float.valueOf(this.mStartHandlerPos.y));
        arrayList.add(Float.valueOf(50.0f));
        ArrayList<Float> arrayList2 = new ArrayList<>();
        arrayList2.add(Float.valueOf(this.mEndHandlerPos.x));
        arrayList2.add(Float.valueOf(this.mEndHandlerPos.y));
        arrayList2.add(Float.valueOf(50.0f));
        return new ArrayList[]{arrayList, arrayList2};
    }

    public String getSelectedText() {
        int i;
        int i2 = this.mSelectStart;
        return (i2 < 0 || (i = this.mSelectEnd) <= 0 || i <= i2 || i > this.mTextLayout.getText().length()) ? "" : this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd).toString();
    }

    private void drawSelectHandle(Canvas canvas) {
        if (this.mIsShowStartHandle) {
            drawSelectStartCursor(canvas);
        }
        if (this.mIsShowEndHandle) {
            drawSelectEndCursor(canvas);
        }
    }

    private void drawSelectStartCursor(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mStartHandlerPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mStartHandlerPos.y - (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mSelectionLeftCursor.draw(canvas);
        canvas.restore();
    }

    private void drawSelectEndCursor(Canvas canvas) {
        canvas.save();
        canvas.translate(this.mEndHandlerPos.x - (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mEndHandlerPos.y - (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        this.mSelectionRightCursor.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        if (this.mHasImage && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                if (absInlineImageSpan.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (UIThreadUtils.isOnUiThread()) {
            if (this.mHasImage && (getText() instanceof Spanned)) {
                Spanned spanned = (Spanned) getText();
                for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                    if (absInlineImageSpan.getDrawable() == drawable) {
                        invalidate();
                        this.mOverflowPictureDirty = true;
                    }
                }
            }
            super.invalidateDrawable(drawable);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispatchDetachImageSpan();
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                absInlineImageSpan.onDetachedFromWindow();
                absInlineImageSpan.setCallback(null);
            }
        }
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mHasImage && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                absInlineImageSpan.onStartTemporaryDetach();
            }
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.view.AndroidView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), this);
        }
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mHasImage && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (AbsInlineImageSpan absInlineImageSpan : (AbsInlineImageSpan[]) spanned.getSpans(0, spanned.length(), AbsInlineImageSpan.class)) {
                absInlineImageSpan.onFinishTemporaryDetach();
            }
        }
    }

    public CharSequence getText() {
        Layout layout = this.mTextLayout;
        if (layout != null) {
            return layout.getText();
        }
        return null;
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public void setOverflow(int i) {
        this.mOverflow = i;
    }

    private void drawOverflowPicture() {
        if (!this.mOverflowPictureDirty || this.mTextLayout == null) {
            return;
        }
        Picture picture = this.mOverflowPicture;
        if (picture == null) {
            this.mOverflowPicture = new Picture();
        } else {
            picture.endRecording();
        }
        Canvas beginRecording = this.mOverflowPicture.beginRecording(this.mTextLayout.getWidth(), this.mTextLayout.getHeight());
        beginRecording.save();
        if (getClipBounds() != null) {
            beginRecording.clipRect(getClipBounds());
        }
        drawTextOnCanvas(beginRecording);
        if (this.mNeedDrawStroke) {
            TextHelper.drawTextStroke(this.mTextLayout, beginRecording);
        }
        beginRecording.restore();
        this.mOverflowPicture.endRecording();
        this.mOverflowPictureDirty = false;
    }

    public void release() {
        if (this.mHasImage && (getText() instanceof Spanned)) {
            AbsInlineImageSpan.possiblyUpdateInlineImageSpans((Spanned) getText(), null);
        }
    }

    private void initSelectionCursor(Context context) {
        this.mSelectionLeftCursor = context.getResources().getDrawable(R.drawable.lynx_text_select_handle_left_material);
        this.mSelectionRightCursor = context.getResources().getDrawable(R.drawable.lynx_text_select_handle_right_material);
        Paint paint = new Paint();
        this.mHighlightPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mHighlightPath = new Path();
    }

    private void updateSelectionStyle() {
        Drawable drawable = this.mSelectionLeftCursor;
        int i = this.mHandleSize;
        drawable.setBounds(0, 0, i, i);
        Drawable drawable2 = this.mSelectionRightCursor;
        int i2 = this.mHandleSize;
        drawable2.setBounds(0, 0, i2, i2);
        this.mSelectionLeftCursor.setTint(this.mTextSelectionHandleColor);
        this.mSelectionRightCursor.setTint(this.mTextSelectionHandleColor);
        this.mHighlightPaint.setColor(this.mTextSelectionColor);
    }

    private int getLineAtCoordinate(float f) {
        return this.mTextLayout.getLineForVertical((int) Math.min(getHeight() - 1, Math.max(0.0f, f)));
    }

    private int getOffsetAtCoordinate(int i, float f) {
        int offsetForHorizontal = this.mTextLayout.getOffsetForHorizontal(i, Math.min(getWidth() - 1, Math.max(0.0f, f)));
        float secondaryHorizontal = this.mTextLayout.getSecondaryHorizontal(offsetForHorizontal);
        return ((double) f) > ((double) secondaryHorizontal) + (((double) (this.mTextLayout.getLineRight(i) - secondaryHorizontal)) / 2.0d) ? this.mTextLayout.getLineEnd(i) : offsetForHorizontal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getOffsetForPosition(float f, float f2) {
        if (this.mTextLayout == null) {
            return -1;
        }
        return getOffsetAtCoordinate(getLineAtCoordinate(f2), f);
    }

    private PointF getBottomPositionForOffset(int i, boolean z) {
        float primaryHorizontal = this.mTextLayout.getPrimaryHorizontal(i);
        int lineForOffset = this.mTextLayout.getLineForOffset(i);
        float lineBottom = this.mTextLayout.getLineBottom(lineForOffset);
        if (i == this.mTextLayout.getLineStart(lineForOffset) && lineForOffset > 0 && !z) {
            primaryHorizontal = this.mTextLayout.getWidth();
            lineBottom = this.mTextLayout.getLineBottom(lineForOffset - 1);
        }
        return new PointF(primaryHorizontal, lineBottom);
    }

    private void showToolbar() {
        if (this.mEnableCustomContextMenu) {
            return;
        }
        startActionMode(this, 1);
    }

    private void hideToolbar() {
        ActionMode actionMode;
        if (this.mEnableCustomContextMenu || (actionMode = this.mActionMode) == null) {
            return;
        }
        actionMode.finish();
        this.mActionMode = null;
    }

    private void updateSelectionRange(int i, int i2) {
        int i3;
        if (this.mSelectionLeftCursor == null) {
            initSelectionCursor(getContext());
        }
        updateSelectionStyle();
        int i4 = this.mLastSelectStart;
        this.mIsForward = i4 != -1 ? i4 < i || this.mLastSelectEnd < i2 : i2 > i;
        this.mLastSelectStart = this.mSelectStart;
        this.mLastSelectEnd = this.mSelectEnd;
        this.mSelectStart = i;
        this.mSelectEnd = i2;
        if (i >= 0 && i <= this.mTextLayout.getText().length() && (i3 = this.mSelectEnd) >= 0 && i3 <= this.mTextLayout.getText().length()) {
            if (this.mTextLayout.getText() instanceof Spannable) {
                Selection.setSelection((Spannable) this.mTextLayout.getText(), Math.min(this.mSelectStart, this.mSelectEnd), Math.max(this.mSelectStart, this.mSelectEnd));
            }
            this.mSelectStartPos.set(getBottomPositionForOffset(Math.min(this.mSelectStart, this.mSelectEnd), true));
            this.mSelectEndPos.set(getBottomPositionForOffset(Math.max(this.mSelectStart, this.mSelectEnd), false));
            this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
            this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
            clearOtherSelection();
            return;
        }
        if (this.mTextLayout.getText() instanceof Spannable) {
            Selection.removeSelection((Spannable) this.mTextLayout.getText());
        }
    }

    private void clearOtherSelection() {
        AndroidText androidText;
        if (this.mEnableCustomTextSelection) {
            return;
        }
        WeakReference<AndroidText> weakReference = sWeakSelectingAndroidText;
        if (weakReference != null && (androidText = weakReference.get()) != null && androidText != this) {
            androidText.clearSelection();
            androidText.invalidate();
        }
        sWeakSelectingAndroidText = new WeakReference<>(this);
    }

    private void updateSelectStartEnd() {
        int min = Math.min(this.mSelectStart, this.mSelectEnd);
        this.mSelectEnd = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mSelectStart = min;
        onSelectionChange();
        this.mSelectStartPos.set(getBottomPositionForOffset(this.mSelectStart, true));
        this.mSelectEndPos.set(getBottomPositionForOffset(this.mSelectEnd, false));
    }

    private void performBeginSelection(float f, float f2) {
        hideToolbar();
        if (this.mIsInSelection) {
            this.mShouldResponseMove = true;
            if (distanceBetweenPoints(this.mStartHandlerPos, f, f2) < 50.0d) {
                adjustStartPosition(f, f2);
                requestDisallowInterceptTouchEvent(true);
            } else if (distanceBetweenPoints(this.mEndHandlerPos, f, f2) < 50.0d) {
                adjustEndPosition(f, f2);
                requestDisallowInterceptTouchEvent(true);
            } else {
                this.mShouldResponseMove = false;
            }
        }
        if (this.mIsAdjustEndPos || this.mIsAdjustStartPos) {
            return;
        }
        removeCheckLongPressCallback();
        CheckForLongPress checkForLongPress = new CheckForLongPress(f, f2);
        this.mCheckForLongPress = checkForLongPress;
        postDelayed(checkForLongPress, ViewConfiguration.getLongPressTimeout());
    }

    private void adjustStartPosition(float f, float f2) {
        this.mIsAdjustStartPos = true;
        int offsetForPosition = getOffsetForPosition(f, f2);
        if (this.mSelectEnd == offsetForPosition) {
            offsetForPosition = (offsetForPosition == this.mTextLayout.getText().length() || (f < this.mSelectEndPos.x && offsetForPosition > 0)) ? offsetForPosition - 1 : offsetForPosition + 1;
        }
        updateSelectionRange(offsetForPosition, this.mSelectEnd);
    }

    private void adjustEndPosition(float f, float f2) {
        this.mIsAdjustEndPos = true;
        int offsetForPosition = getOffsetForPosition(f, f2);
        if (offsetForPosition == this.mSelectStart) {
            offsetForPosition = (offsetForPosition == this.mTextLayout.getText().length() || (f < this.mSelectStartPos.x && offsetForPosition > 0)) ? offsetForPosition - 1 : offsetForPosition + 1;
        }
        updateSelectionRange(this.mSelectStart, offsetForPosition);
    }

    private PointF getCenterPositionForOffset(int i) {
        if (i < 0 || i > this.mTextLayout.getText().length()) {
            return new PointF(0.0f, 0.0f);
        }
        int lineForOffset = this.mTextLayout.getLineForOffset(i);
        return new PointF(this.mTextLayout.getPrimaryHorizontal(i), (this.mTextLayout.getLineTop(lineForOffset) + this.mTextLayout.getLineBottom(lineForOffset)) / 2.0f);
    }

    private void performMovingSelection(float f, float f2) {
        CheckForLongPress checkForLongPress = this.mCheckForLongPress;
        if (checkForLongPress != null && (Math.abs(f - checkForLongPress.f10mX) > 1.0f || Math.abs(f2 - this.mCheckForLongPress.f11mY) > 1.0f)) {
            removeCheckLongPressCallback();
        }
        if (this.mIsAdjustStartPos) {
            adjustStartPosition(f, f2);
        } else if (this.mIsAdjustEndPos) {
            adjustEndPosition(f, f2);
        }
    }

    private void performEndSelection(float f, float f2) {
        requestDisallowInterceptTouchEvent(false);
        if (!this.mIsInSelection) {
            removeCheckLongPressCallback();
            return;
        }
        boolean z = this.mIsAdjustEndPos;
        if (!z && !this.mIsAdjustStartPos) {
            clearSelection();
            return;
        }
        if (this.mIsAdjustStartPos) {
            adjustStartPosition(f, f2);
            updateSelectStartEnd();
        } else if (z) {
            adjustEndPosition(f, f2);
            updateSelectStartEnd();
        }
        showToolbar();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
    }

    private void clearSelection() {
        removeCheckLongPressCallback();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        if (this.mIsInSelection) {
            onSelectionChange();
        }
        this.mIsInSelection = false;
        updateSelectionRange(this.mSelectStart, this.mSelectEnd);
        hideToolbar();
        this.mShouldResponseMove = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        Path path = this.mHighlightPath;
        if (path != null) {
            path.reset();
        }
    }

    private double distanceBetweenPoints(PointF pointF, float f, float f2) {
        return Math.sqrt(Math.pow(pointF.x - f, 2.0d) + Math.pow(pointF.y - f2, 2.0d));
    }

    private void removeCheckLongPressCallback() {
        CheckForLongPress checkForLongPress = this.mCheckForLongPress;
        if (checkForLongPress == null) {
            return;
        }
        removeCallbacks(checkForLongPress);
        this.mCheckForLongPress = null;
    }

    private void performCopy() {
        int i;
        int i2 = this.mSelectStart;
        if (i2 >= 0 && (i = this.mSelectEnd) > i2 && i <= this.mTextLayout.getText().length()) {
            ClipData newPlainText = ClipData.newPlainText("Lynx-clipboard", this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd));
            ILynxSystemInvokeService iLynxSystemInvokeService = (ILynxSystemInvokeService) LynxServiceCenter.inst().getService(ILynxSystemInvokeService.class);
            if (iLynxSystemInvokeService != null) {
                try {
                    iLynxSystemInvokeService.setPrimaryClip(newPlainText);
                } catch (RemoteException e) {
                    LLog.e("AndroidText", "A RemoteException was encountered while calling systemInvokeService. " + e.getMessage());
                }
            } else {
                ((ClipboardManager) getContext().getSystemService(ClipboardManager.class)).setPrimaryClip(newPlainText);
            }
        }
        clearSelection();
    }

    private void performSelectAll() {
        updateSelectionRange(0, this.mTextLayout.getText().length());
        updateSelectStartEnd();
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        menu.add(0, ID_COPY, 0, R.string.copy);
        menu.add(0, ID_SELECT_ALL, 1, R.string.selectAll);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        this.mActionMode = actionMode;
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() == ID_COPY) {
            performCopy();
        } else if (menuItem.getItemId() == ID_SELECT_ALL) {
            performSelectAll();
        }
        invalidate();
        return true;
    }
}
