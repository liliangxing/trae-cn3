package com.bytedance.android.anniex.detect.detection;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.PixelCopy;
import android.view.View;
import coil3.util.Utils_commonKt;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.android.anniex.detect.AnnieXBlankDetectorManager;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;

/* compiled from: DetectorUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0081@¢\u0006\u0002\u0010\t\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0013H\u0000\u001a$\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u0016H\u0000¨\u0006\u001d"}, d2 = {"captureAViewBitmap", "Landroid/graphics/Bitmap;", "view", "Landroid/view/View;", "scale", "", "log", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "(Landroid/view/View;FLjava/lang/StringBuilder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extractActivityFromContext", "Landroid/app/Activity;", "context", "Landroid/content/Context;", "getSnapShotScale", "maxQuality", "isPureColorBitmapProbability", "bitmap", "isViewSafeToCapture", "", "jsonArray2List", "Ljava/util/ArrayList;", "", "jsonArray", "Lorg/json/JSONArray;", "dropEmpty", "saveBitmapToGallery", "Landroid/net/Uri;", "displayName", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DetectorUtilsKt {
    public static final Object captureAViewBitmap(View view, float f, final StringBuilder sb, Continuation<? super Bitmap> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation continuation2 = safeContinuation;
        try {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            int coerceAtLeast = RangesKt.coerceAtLeast((int) (view.getWidth() * f), 1);
            int coerceAtLeast2 = RangesKt.coerceAtLeast((int) (view.getHeight() * f), 1);
            Rect rect = new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Activity extractActivityFromContext = extractActivityFromContext(context);
            if (extractActivityFromContext == null) {
                StringBuilder append = sb.append("PixelCopy error: Activity not found");
                Intrinsics.checkNotNullExpressionValue(append, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl((Object) null));
            } else {
                final Bitmap createBitmap = Bitmap.createBitmap(coerceAtLeast, coerceAtLeast2, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(scaledWidth… Bitmap.Config.ARGB_8888)");
                new Canvas(createBitmap).scale(f, f);
                PixelCopy.request(extractActivityFromContext.getWindow(), rect, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.bytedance.android.anniex.detect.detection.DetectorUtilsKt$captureAViewBitmap$2$1
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i3) {
                        if (i3 == 0) {
                            StringBuilder append2 = sb.append("PixelCopy SUCCESS and scaled at draw time");
                            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
                            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
                            Continuation<Bitmap> continuation3 = continuation2;
                            Result.Companion companion2 = Result.Companion;
                            continuation3.resumeWith(Result.constructor-impl(createBitmap));
                            return;
                        }
                        StringBuilder append3 = sb.append("PixelCopy FAILED: " + i3);
                        Intrinsics.checkNotNullExpressionValue(append3, "append(value)");
                        Intrinsics.checkNotNullExpressionValue(append3.append('\n'), "append('\\n')");
                        Continuation<Bitmap> continuation4 = continuation2;
                        Result.Companion companion3 = Result.Companion;
                        continuation4.resumeWith(Result.constructor-impl((Object) null));
                    }
                }, new Handler(Looper.getMainLooper()));
            }
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "captureAViewBitmap exception:" + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
            StringBuilder append2 = sb.append("PixelCopy EXCEPTION: " + e.getMessage());
            Intrinsics.checkNotNullExpressionValue(append2, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append2.append('\n'), "append('\\n')");
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.constructor-impl((Object) null));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Uri saveBitmapToGallery$default(Context context, Bitmap bitmap, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "AnnieX_Screenshot_" + System.currentTimeMillis();
        }
        return saveBitmapToGallery(context, bitmap, str);
    }

    public static final Uri saveBitmapToGallery(Context context, Bitmap bitmap, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "displayName");
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str + ".jpg");
        contentValues.put("mime_type", Utils_commonKt.MIME_TYPE_JPEG);
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + "/AnnieX");
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = context.getContentResolver();
        try {
            Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert == null) {
                return null;
            }
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            try {
                OutputStream outputStream = openOutputStream;
                Boolean valueOf = outputStream != null ? Boolean.valueOf(bitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (!valueOf.booleanValue()) {
                    throw new IOException("Bitmap compress failed");
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(openOutputStream, (Throwable) null);
                contentValues.put("is_pending", (Integer) 0);
                contentResolver.update(insert, contentValues, null, null);
                return insert;
            } finally {
            }
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, AnnieXBlankDetectorManager.BLANK_DETECTOR_TAG, "保存图片到相册失败: " + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
            return null;
        }
    }

    public static final float getSnapShotScale(float f, Context context) {
        Map<String, Object> pageGlobalPropsByActivity;
        if (f <= 0 || !(context instanceof Activity) || (pageGlobalPropsByActivity = GlobalPropsHelper.INSTANCE.getPageGlobalPropsByActivity(context)) == null) {
            return 1.0f;
        }
        Object obj = pageGlobalPropsByActivity.get("screenWidth");
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        Intrinsics.checkNotNull(pageGlobalPropsByActivity.get("screenHeight"), "null cannot be cast to non-null type kotlin.Int");
        return Math.min(f / Math.min(intValue, ((Integer) r5).intValue()), 1.0f);
    }

    public static final Activity extractActivityFromContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "ctx.baseContext");
        }
        return null;
    }

    public static final boolean isViewSafeToCapture(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return view.isAttachedToWindow() && view.getWidth() > 0 && view.getHeight() > 0;
    }

    public static final float isPureColorBitmapProbability(Bitmap bitmap) {
        int i;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int i2 = 0;
        int pixel = bitmap.getPixel(0, 0);
        IntProgression step = RangesKt.step(RangesKt.until(0, bitmap.getHeight()), 10);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            i = 0;
        } else {
            i = 0;
            int i3 = 0;
            while (true) {
                IntProgression step3 = RangesKt.step(RangesKt.until(0, bitmap.getWidth()), 10);
                int first2 = step3.getFirst();
                int last2 = step3.getLast();
                int step4 = step3.getStep();
                if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                    while (true) {
                        i++;
                        if (bitmap.getPixel(first2, first) == pixel) {
                            i3++;
                        }
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step4;
                    }
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
            i2 = i3;
        }
        return i2 / i;
    }

    public static /* synthetic */ ArrayList jsonArray2List$default(JSONArray jSONArray, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return jsonArray2List(jSONArray, z);
    }

    public static final ArrayList<String> jsonArray2List(JSONArray jSONArray, boolean z) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (jSONArray == null) {
            return arrayList;
        }
        if (z) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                String optString = jSONArray.optString(i);
                Intrinsics.checkNotNullExpressionValue(optString, "item");
                if (optString.length() > 0) {
                    arrayList.add(optString);
                }
            }
        } else {
            int length2 = jSONArray.length();
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList.add(jSONArray.optString(i2));
            }
        }
        return arrayList;
    }
}
