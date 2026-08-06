package com.github.alexzhirkevich.customqrgenerator.dsl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrBallShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrCanvasColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrCanvasColorKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrCanvasShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrCanvasShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrColor;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrFrameShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrHighlightingShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrHighlightingShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrLogoShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShape;
import com.github.alexzhirkevich.customqrgenerator.style.QrPixelShapeKt;
import com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifier;
import com.github.alexzhirkevich.customqrgenerator.style.QrShapeModifierFromPath;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KClass;

/* compiled from: DslExtensions.kt */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\b2\u0019\b\u0004\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u001af\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\f2C\b\b\u0010\u0000\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001al\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u00152A\u0010\u0000\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0016\u001af\u0010\t\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00172C\b\b\u0010\u0000\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u0007H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001al\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u00152A\u0010\u0000\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00060\r¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\u0019\u001a[\u0010\u001a\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\f2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2.\b\b\u0010\u001d\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\"\u001a_\u0010\u001a\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2,\u0010\u001d\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010#\u001a[\u0010\u001a\u001a\u0002H\n\"\n\b\u0000\u0010\n\u0018\u0001*\u00020\u000b*\u00020\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001c2.\b\b\u0010\u001d\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010$\u001a_\u0010\u001a\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u00172\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2,\u0010\u001d\u001a(\u0012\u0004\u0012\u00020\u001f\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010%\u001a9\u0010&\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020'2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u00152\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020)H\u0002¢\u0006\u0002\u0010*\u001a)\u0010&\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\n0\u0015H\u0002¢\u0006\u0002\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006,"}, d2 = {WebViewContainer.EVENT_draw, "Lcom/github/alexzhirkevich/customqrgenerator/style/QrColor;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrBackgroundBuilderScope;", "action", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrColorsBuilderScope;", "drawShape", "T", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;", "Lkotlin/Function3;", "Landroid/graphics/Paint;", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "drawPaint", "erasePaint", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;Lkotlin/jvm/functions/Function3;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "clazz", "Lkotlin/reflect/KClass;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function3;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;Lkotlin/jvm/functions/Function3;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function3;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "pathShape", "efficiency", "Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;", "builder", "Lkotlin/Function2;", "Landroid/graphics/Path;", "", "size", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;Lkotlin/jvm/functions/Function2;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrElementsShapesBuilderScope;Lkotlin/reflect/KClass;Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;Lkotlin/jvm/functions/Function2;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;Lkotlin/jvm/functions/Function2;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lcom/github/alexzhirkevich/customqrgenerator/dsl/QrLogoBuilderScope;Lkotlin/reflect/KClass;Lcom/github/alexzhirkevich/customqrgenerator/dsl/Efficiency;Lkotlin/jvm/functions/Function2;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "toTypedShapeModifier", "Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;", "padding", "", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrCanvasShape;Lkotlin/reflect/KClass;IF)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "(Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;Lkotlin/reflect/KClass;)Lcom/github/alexzhirkevich/customqrgenerator/style/QrShapeModifier;", "custom_qr_generator_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DslExtensionsKt {

    /* compiled from: DslExtensions.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Efficiency.values().length];
            iArr[Efficiency.Time.ordinal()] = 1;
            iArr[Efficiency.Memory.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final QrColor draw(QrColorsBuilderScope qrColorsBuilderScope, final Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(qrColorsBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        QrCanvasColor qrCanvasColor = new QrCanvasColor() { // from class: com.github.alexzhirkevich.customqrgenerator.dsl.DslExtensionsKt$draw$1
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrCanvasColor
            public final void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "canvas");
                function1.invoke(canvas);
            }
        };
        if (!(qrColorsBuilderScope instanceof InternalColorsBuilderScope)) {
            throw new NoWhenBranchMatchedException();
        }
        InternalColorsBuilderScope internalColorsBuilderScope = (InternalColorsBuilderScope) qrColorsBuilderScope;
        Pair pair = TuplesKt.to(Integer.valueOf(internalColorsBuilderScope.getBuilder().getWidth()), Integer.valueOf(internalColorsBuilderScope.getBuilder().getHeight()));
        return QrCanvasColorKt.toQrColor(qrCanvasColor, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue());
    }

    public static final QrColor draw(QrBackgroundBuilderScope qrBackgroundBuilderScope, final Function1<? super Canvas, Unit> function1) {
        Intrinsics.checkNotNullParameter(qrBackgroundBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        QrCanvasColor qrCanvasColor = new QrCanvasColor() { // from class: com.github.alexzhirkevich.customqrgenerator.dsl.DslExtensionsKt$draw$3
            @Override // com.github.alexzhirkevich.customqrgenerator.style.QrCanvasColor
            public final void draw(Canvas canvas) {
                Intrinsics.checkNotNullParameter(canvas, "it");
                function1.invoke(canvas);
            }
        };
        if (!(qrBackgroundBuilderScope instanceof InternalQrBackgroundBuilderScope)) {
            throw new NoWhenBranchMatchedException();
        }
        InternalQrBackgroundBuilderScope internalQrBackgroundBuilderScope = (InternalQrBackgroundBuilderScope) qrBackgroundBuilderScope;
        Pair pair = TuplesKt.to(Integer.valueOf(internalQrBackgroundBuilderScope.getBuilder().getWidth()), Integer.valueOf(internalQrBackgroundBuilderScope.getBuilder().getHeight()));
        return QrCanvasColorKt.toQrColor(qrCanvasColor, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue());
    }

    public static /* synthetic */ QrShapeModifier pathShape$default(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, Efficiency efficiency, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            efficiency = Efficiency.Time;
        }
        Intrinsics.checkNotNullParameter(qrElementsShapesBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        Intrinsics.reifiedOperationMarker(4, "T");
        return pathShape(qrElementsShapesBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), efficiency, (Function2<? super Path, ? super Integer, Unit>) function2);
    }

    public static final /* synthetic */ <T extends QrShapeModifier> T pathShape(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, Efficiency efficiency, Function2<? super Path, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(qrElementsShapesBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) pathShape(qrElementsShapesBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), efficiency, function2);
    }

    public static /* synthetic */ QrShapeModifier pathShape$default(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, KClass kClass, Efficiency efficiency, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            efficiency = Efficiency.Time;
        }
        return pathShape(qrElementsShapesBuilderScope, kClass, efficiency, (Function2<? super Path, ? super Integer, Unit>) function2);
    }

    public static final <T extends QrShapeModifier> T pathShape(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, KClass<T> kClass, Efficiency efficiency, final Function2<? super Path, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(qrElementsShapesBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        int i = WhenMappings.$EnumSwitchMapping$0[efficiency.ordinal()];
        if (i == 1) {
            return (T) drawShape(qrElementsShapesBuilderScope, kClass, new Function3<Canvas, Paint, Paint, Unit>() { // from class: com.github.alexzhirkevich.customqrgenerator.dsl.DslExtensionsKt$pathShape$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Canvas) obj, (Paint) obj2, (Paint) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(Canvas canvas, Paint paint, Paint paint2) {
                    Intrinsics.checkNotNullParameter(canvas, "$this$drawShape");
                    Intrinsics.checkNotNullParameter(paint, "drawPaint");
                    Intrinsics.checkNotNullParameter(paint2, "<anonymous parameter 1>");
                    Path path = new Path();
                    function2.invoke(path, Integer.valueOf(Math.min(canvas.getWidth(), canvas.getHeight())));
                    canvas.drawPath(path, paint);
                }
            });
        }
        if (i == 2) {
            return (T) toTypedShapeModifier(new QrShapeModifierFromPath(function2), kClass);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ QrShapeModifier pathShape$default(QrLogoBuilderScope qrLogoBuilderScope, Efficiency efficiency, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            efficiency = Efficiency.Time;
        }
        Intrinsics.checkNotNullParameter(qrLogoBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        Intrinsics.reifiedOperationMarker(4, "T");
        return pathShape(qrLogoBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), efficiency, (Function2<? super Path, ? super Integer, Unit>) function2);
    }

    public static final /* synthetic */ <T extends QrShapeModifier> T pathShape(QrLogoBuilderScope qrLogoBuilderScope, Efficiency efficiency, Function2<? super Path, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(qrLogoBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) pathShape(qrLogoBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), efficiency, function2);
    }

    public static /* synthetic */ QrShapeModifier pathShape$default(QrLogoBuilderScope qrLogoBuilderScope, KClass kClass, Efficiency efficiency, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            efficiency = Efficiency.Time;
        }
        return pathShape(qrLogoBuilderScope, kClass, efficiency, (Function2<? super Path, ? super Integer, Unit>) function2);
    }

    public static final <T extends QrShapeModifier> T pathShape(QrLogoBuilderScope qrLogoBuilderScope, KClass<T> kClass, Efficiency efficiency, final Function2<? super Path, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(qrLogoBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(efficiency, "efficiency");
        Intrinsics.checkNotNullParameter(function2, "builder");
        int i = WhenMappings.$EnumSwitchMapping$0[efficiency.ordinal()];
        if (i == 1) {
            return (T) drawShape(qrLogoBuilderScope, kClass, new Function3<Canvas, Paint, Paint, Unit>() { // from class: com.github.alexzhirkevich.customqrgenerator.dsl.DslExtensionsKt$pathShape$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Canvas) obj, (Paint) obj2, (Paint) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(Canvas canvas, Paint paint, Paint paint2) {
                    Intrinsics.checkNotNullParameter(canvas, "$this$drawShape");
                    Intrinsics.checkNotNullParameter(paint, "drawPaint");
                    Intrinsics.checkNotNullParameter(paint2, "<anonymous parameter 1>");
                    Path path = new Path();
                    function2.invoke(path, Integer.valueOf(Math.min(canvas.getWidth(), canvas.getHeight())));
                    canvas.drawPath(path, paint);
                }
            });
        }
        if (i == 2) {
            return (T) toTypedShapeModifier(new QrShapeModifierFromPath(function2), kClass);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pathShape instead", replaceWith = @ReplaceWith(expression = "pathShape", imports = {}))
    public static final /* synthetic */ <T extends QrShapeModifier> T drawShape(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, Function3<? super Canvas, ? super Paint, ? super Paint, Unit> function3) {
        Intrinsics.checkNotNullParameter(qrElementsShapesBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(function3, WebViewContainer.EVENT_draw);
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) drawShape(qrElementsShapesBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pathShape instead", replaceWith = @ReplaceWith(expression = "pathShape", imports = {}))
    public static final /* synthetic */ <T extends QrShapeModifier> T drawShape(QrLogoBuilderScope qrLogoBuilderScope, Function3<? super Canvas, ? super Paint, ? super Paint, Unit> function3) {
        Intrinsics.checkNotNullParameter(qrLogoBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(function3, WebViewContainer.EVENT_draw);
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) drawShape(qrLogoBuilderScope, Reflection.getOrCreateKotlinClass(QrShapeModifier.class), function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pathShape instead", replaceWith = @ReplaceWith(expression = "pathShape", imports = {}))
    public static final <T extends QrShapeModifier> T drawShape(QrElementsShapesBuilderScope qrElementsShapesBuilderScope, KClass<T> kClass, Function3<? super Canvas, ? super Paint, ? super Paint, Unit> function3) {
        Intrinsics.checkNotNullParameter(qrElementsShapesBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(function3, WebViewContainer.EVENT_draw);
        C0395xcaafd69f c0395xcaafd69f = new C0395xcaafd69f(function3);
        if (qrElementsShapesBuilderScope instanceof InternalQrElementsShapesBuilderScope) {
            InternalQrElementsShapesBuilderScope internalQrElementsShapesBuilderScope = (InternalQrElementsShapesBuilderScope) qrElementsShapesBuilderScope;
            Pair pair = TuplesKt.to(Integer.valueOf(Math.min(internalQrElementsShapesBuilderScope.getBuilder().getWidth(), internalQrElementsShapesBuilderScope.getBuilder().getHeight())), Float.valueOf(internalQrElementsShapesBuilderScope.getBuilder().getPadding()));
            return (T) toTypedShapeModifier(c0395xcaafd69f, kClass, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).floatValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pathShape instead", replaceWith = @ReplaceWith(expression = "pathShape", imports = {}))
    public static final <T extends QrShapeModifier> T drawShape(QrLogoBuilderScope qrLogoBuilderScope, KClass<T> kClass, Function3<? super Canvas, ? super Paint, ? super Paint, Unit> function3) {
        Intrinsics.checkNotNullParameter(qrLogoBuilderScope, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(function3, WebViewContainer.EVENT_draw);
        C0395xcaafd69f c0395xcaafd69f = new C0395xcaafd69f(function3);
        if (qrLogoBuilderScope instanceof InternalQrLogoBuilderScope) {
            InternalQrLogoBuilderScope internalQrLogoBuilderScope = (InternalQrLogoBuilderScope) qrLogoBuilderScope;
            Pair pair = TuplesKt.to(Integer.valueOf(Math.min(internalQrLogoBuilderScope.getWidth(), internalQrLogoBuilderScope.getHeight())), Float.valueOf(internalQrLogoBuilderScope.getCodePadding()));
            return (T) toTypedShapeModifier(c0395xcaafd69f, kClass, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).floatValue());
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final <T extends QrShapeModifier> T toTypedShapeModifier(QrShapeModifier qrShapeModifier, KClass<T> kClass) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrPixelShape.class))) {
            return QrPixelShapeKt.asPixelShape(qrShapeModifier);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrBallShape.class))) {
            return QrBallShapeKt.asBallShape(qrShapeModifier);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrFrameShape.class))) {
            return QrFrameShapeKt.asFrameShape(qrShapeModifier);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrLogoShape.class))) {
            return QrLogoShapeKt.asLogoShape(qrShapeModifier);
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrHighlightingShape.class))) {
            return QrHighlightingShapeKt.asHighlightingShape(qrShapeModifier);
        }
        throw new IllegalStateException("Only QrElementsShapes properties and QrLogoShape can be smart casted");
    }

    private static final <T extends QrShapeModifier> T toTypedShapeModifier(QrCanvasShape qrCanvasShape, KClass<T> kClass, int i, float f) {
        int i2;
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrPixelShape.class))) {
            i2 = 21;
        } else if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrBallShape.class))) {
            i2 = 7;
        } else {
            i2 = Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrFrameShape.class)) ? true : Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(QrLogoShape.class)) ? 3 : 1;
        }
        return (T) toTypedShapeModifier(QrCanvasShapeKt.toShapeModifier(qrCanvasShape, MathKt.roundToInt((i * (1 - f)) / i2)), kClass);
    }
}
