package org.jetbrains.compose.resources.vector;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.vector.BuildContext;
import org.jetbrains.compose.resources.vector.xmldom.Element;
import org.jetbrains.compose.resources.vector.xmldom.Node;

/* compiled from: XmlVectorParser.kt */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001c\u0010\u000e\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000f\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u001c\u0010\u0011\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u0005H\u0002\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u00020\u0005H\u0002\u001a\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0005H\u0002\u001a\f\u0010\u0019\u001a\u00020\u0016*\u00020\u0005H\u0002\u001a\f\u0010\u001a\u001a\u00020\u0016*\u00020\u0005H\u0002\u001a#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d0\u001c*\u00020\u0005H\u0002¢\u0006\u0002\u0010 \u001a\"\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d*\u00020\u00052\u0006\u0010\"\u001a\u00020\u001eH\u0002\u001a\u001e\u0010#\u001a\u0004\u0018\u00010\u0001*\u00020\u00052\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a\u001e\u0010&\u001a\u0004\u0018\u00010\u0005*\u00020\u00052\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"ANDROID_NS", "", "AAPT_NS", "toImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Lorg/jetbrains/compose/resources/vector/xmldom/Element;", "density", "Landroidx/compose/ui/unit/Density;", "parseVectorNodes", "", "builder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "context", "Lorg/jetbrains/compose/resources/vector/BuildContext;", "parseVectorNode", "parsePath", "parseClipPath", "parseGroup", "parseStringBrush", "Landroidx/compose/ui/graphics/SolidColor;", "str", "parseElementBrush", "Landroidx/compose/ui/graphics/Brush;", "parseGradient", "parseLinearGradient", "parseRadialGradient", "parseSweepGradient", "parseColorStops", "", "Lkotlin/Pair;", "", "Landroidx/compose/ui/graphics/Color;", "(Lorg/jetbrains/compose/resources/vector/xmldom/Element;)[Lkotlin/Pair;", "parseColorStop", "defaultOffset", "attributeOrNull", "namespace", "name", "apptAttr", "childrenSequence", "Lkotlin/sequences/Sequence;", "Lorg/jetbrains/compose/resources/vector/xmldom/Node;", "getChildrenSequence", "(Lorg/jetbrains/compose/resources/vector/xmldom/Element;)Lkotlin/sequences/Sequence;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class XmlVectorParserKt {
    private static final String AAPT_NS = "http://schemas.android.com/aapt";
    private static final String ANDROID_NS = "http://schemas.android.com/apk/res/android";

    public static final ImageVector toImageVector(Element element, Density density) {
        Intrinsics.checkNotNullParameter(element, "<this>");
        Intrinsics.checkNotNullParameter(density, "density");
        BuildContext buildContext = new BuildContext();
        float parseDp = ValueParsersKt.parseDp(attributeOrNull(element, ANDROID_NS, "width"), density);
        float parseDp2 = ValueParsersKt.parseDp(attributeOrNull(element, ANDROID_NS, "height"), density);
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "viewportWidth");
        float parseFloat = attributeOrNull != null ? Float.parseFloat(attributeOrNull) : 0.0f;
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "viewportHeight");
        ImageVector.Builder builder = new ImageVector.Builder((String) null, parseDp, parseDp2, parseFloat, attributeOrNull2 != null ? Float.parseFloat(attributeOrNull2) : 0.0f, 0L, 0, false, 225, (DefaultConstructorMarker) null);
        parseVectorNodes(element, builder, buildContext);
        return builder.build();
    }

    private static final void parseVectorNodes(Element element, ImageVector.Builder builder, BuildContext buildContext) {
        Sequence filter = SequencesKt.filter(getChildrenSequence(element), new Function1<Object, Boolean>() { // from class: org.jetbrains.compose.resources.vector.XmlVectorParserKt$parseVectorNodes$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m6invoke(Object obj) {
                return Boolean.valueOf(obj instanceof Element);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        while (it.hasNext()) {
            parseVectorNode((Element) it.next(), builder, buildContext);
        }
    }

    private static final void parseVectorNode(Element element, ImageVector.Builder builder, BuildContext buildContext) {
        String nodeName = element.getNodeName();
        int hashCode = nodeName.hashCode();
        if (hashCode == -1649314686) {
            if (nodeName.equals("clip-path")) {
                parseClipPath(element, builder, buildContext);
            }
        } else if (hashCode == 3433509) {
            if (nodeName.equals("path")) {
                parsePath(element, builder);
            }
        } else if (hashCode == 98629247 && nodeName.equals("group")) {
            parseGroup(element, builder, buildContext);
        }
    }

    private static final void parsePath(Element element, ImageVector.Builder builder) {
        Brush parseElementBrush;
        Brush parseElementBrush2;
        SolidColor parseStringBrush;
        SolidColor parseStringBrush2;
        List addPathNodes = VectorKt.addPathNodes(attributeOrNull(element, ANDROID_NS, "pathData"));
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "fillType");
        int parseFillType = attributeOrNull != null ? ValueParsersKt.parseFillType(attributeOrNull) : PathFillType.Companion.getNonZero-Rg-k1Os();
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "name");
        if (attributeOrNull2 == null) {
            attributeOrNull2 = "";
        }
        String str = attributeOrNull2;
        String attributeOrNull3 = attributeOrNull(element, ANDROID_NS, "fillColor");
        if (attributeOrNull3 == null || (parseStringBrush2 = parseStringBrush(attributeOrNull3)) == null) {
            Element apptAttr = apptAttr(element, ANDROID_NS, "fillColor");
            parseElementBrush = apptAttr != null ? parseElementBrush(apptAttr) : null;
        } else {
            parseElementBrush = (Brush) parseStringBrush2;
        }
        String attributeOrNull4 = attributeOrNull(element, ANDROID_NS, "fillAlpha");
        float parseFloat = attributeOrNull4 != null ? Float.parseFloat(attributeOrNull4) : 1.0f;
        String attributeOrNull5 = attributeOrNull(element, ANDROID_NS, "strokeColor");
        if (attributeOrNull5 == null || (parseStringBrush = parseStringBrush(attributeOrNull5)) == null) {
            Element apptAttr2 = apptAttr(element, ANDROID_NS, "strokeColor");
            parseElementBrush2 = apptAttr2 != null ? parseElementBrush(apptAttr2) : null;
        } else {
            parseElementBrush2 = (Brush) parseStringBrush;
        }
        String attributeOrNull6 = attributeOrNull(element, ANDROID_NS, "strokeAlpha");
        float parseFloat2 = attributeOrNull6 != null ? Float.parseFloat(attributeOrNull6) : 1.0f;
        String attributeOrNull7 = attributeOrNull(element, ANDROID_NS, "strokeWidth");
        float parseFloat3 = attributeOrNull7 != null ? Float.parseFloat(attributeOrNull7) : 1.0f;
        String attributeOrNull8 = attributeOrNull(element, ANDROID_NS, "strokeLineCap");
        int parseStrokeCap = attributeOrNull8 != null ? ValueParsersKt.parseStrokeCap(attributeOrNull8) : StrokeCap.Companion.getButt-KaPHkGw();
        String attributeOrNull9 = attributeOrNull(element, ANDROID_NS, "strokeLineJoin");
        int parseStrokeJoin = attributeOrNull9 != null ? ValueParsersKt.parseStrokeJoin(attributeOrNull9) : StrokeJoin.Companion.getMiter-LxFBmk8();
        String attributeOrNull10 = attributeOrNull(element, ANDROID_NS, "strokeMiterLimit");
        float parseFloat4 = attributeOrNull10 != null ? Float.parseFloat(attributeOrNull10) : 1.0f;
        String attributeOrNull11 = attributeOrNull(element, ANDROID_NS, "trimPathStart");
        float parseFloat5 = attributeOrNull11 != null ? Float.parseFloat(attributeOrNull11) : 0.0f;
        String attributeOrNull12 = attributeOrNull(element, ANDROID_NS, "trimPathEnd");
        float parseFloat6 = attributeOrNull12 != null ? Float.parseFloat(attributeOrNull12) : 1.0f;
        String attributeOrNull13 = attributeOrNull(element, ANDROID_NS, "trimPathOffset");
        builder.addPath-oIyEayM(addPathNodes, parseFillType, str, parseElementBrush, parseFloat, parseElementBrush2, parseFloat2, parseFloat3, parseStrokeCap, parseStrokeJoin, parseFloat4, parseFloat5, parseFloat6, attributeOrNull13 != null ? Float.parseFloat(attributeOrNull13) : 0.0f);
    }

    private static final void parseClipPath(Element element, ImageVector.Builder builder, BuildContext buildContext) {
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "name");
        if (attributeOrNull == null) {
            attributeOrNull = "";
        }
        ImageVector.Builder.addGroup$default(builder, attributeOrNull, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, VectorKt.addPathNodes(attributeOrNull(element, ANDROID_NS, "pathData")), 254, (Object) null);
        buildContext.getCurrentGroups().add(BuildContext.Group.Virtual);
    }

    private static final void parseGroup(Element element, ImageVector.Builder builder, BuildContext buildContext) {
        BuildContext.Group group;
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "name");
        if (attributeOrNull == null) {
            attributeOrNull = "";
        }
        String str = attributeOrNull;
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "rotation");
        float parseFloat = attributeOrNull2 != null ? Float.parseFloat(attributeOrNull2) : 0.0f;
        String attributeOrNull3 = attributeOrNull(element, ANDROID_NS, "pivotX");
        float parseFloat2 = attributeOrNull3 != null ? Float.parseFloat(attributeOrNull3) : 0.0f;
        String attributeOrNull4 = attributeOrNull(element, ANDROID_NS, "pivotY");
        float parseFloat3 = attributeOrNull4 != null ? Float.parseFloat(attributeOrNull4) : 0.0f;
        String attributeOrNull5 = attributeOrNull(element, ANDROID_NS, "scaleX");
        float parseFloat4 = attributeOrNull5 != null ? Float.parseFloat(attributeOrNull5) : 1.0f;
        String attributeOrNull6 = attributeOrNull(element, ANDROID_NS, "scaleY");
        float parseFloat5 = attributeOrNull6 != null ? Float.parseFloat(attributeOrNull6) : 1.0f;
        String attributeOrNull7 = attributeOrNull(element, ANDROID_NS, "translateX");
        float parseFloat6 = attributeOrNull7 != null ? Float.parseFloat(attributeOrNull7) : 0.0f;
        String attributeOrNull8 = attributeOrNull(element, ANDROID_NS, "translateY");
        builder.addGroup(str, parseFloat, parseFloat2, parseFloat3, parseFloat4, parseFloat5, parseFloat6, attributeOrNull8 != null ? Float.parseFloat(attributeOrNull8) : 0.0f, VectorKt.getEmptyPath());
        buildContext.getCurrentGroups().add(BuildContext.Group.Real);
        parseVectorNodes(element, builder, buildContext);
        do {
            group = (BuildContext.Group) CollectionsKt.removeLastOrNull(buildContext.getCurrentGroups());
            builder.clearGroup();
        } while (group == BuildContext.Group.Virtual);
    }

    private static final SolidColor parseStringBrush(String str) {
        return new SolidColor(ColorKt.Color(ValueParsersKt.parseColorValue(str)), (DefaultConstructorMarker) null);
    }

    private static final Brush parseElementBrush(Element element) {
        Object obj;
        Sequence filter = SequencesKt.filter(getChildrenSequence(element), new Function1<Object, Boolean>() { // from class: org.jetbrains.compose.resources.vector.XmlVectorParserKt$parseElementBrush$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m5invoke(Object obj2) {
                return Boolean.valueOf(obj2 instanceof Element);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Element) obj).getNodeName(), "gradient")) {
                break;
            }
        }
        Element element2 = (Element) obj;
        if (element2 != null) {
            return parseGradient(element2);
        }
        return null;
    }

    private static final Brush parseGradient(Element element) {
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "type");
        if (attributeOrNull != null) {
            int hashCode = attributeOrNull.hashCode();
            if (hashCode != -1102672091) {
                if (hashCode != -938579425) {
                    if (hashCode == 109850348 && attributeOrNull.equals("sweep")) {
                        return parseSweepGradient(element);
                    }
                } else if (attributeOrNull.equals("radial")) {
                    return parseRadialGradient(element);
                }
            } else if (attributeOrNull.equals("linear")) {
                return parseLinearGradient(element);
            }
        }
        return null;
    }

    private static final Brush parseLinearGradient(Element element) {
        Brush.Companion companion = Brush.Companion;
        Pair<Float, Color>[] parseColorStops = parseColorStops(element);
        Pair[] pairArr = (Pair[]) Arrays.copyOf(parseColorStops, parseColorStops.length);
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "startX");
        float parseFloat = attributeOrNull != null ? Float.parseFloat(attributeOrNull) : 0.0f;
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "startY");
        long Offset = OffsetKt.Offset(parseFloat, attributeOrNull2 != null ? Float.parseFloat(attributeOrNull2) : 0.0f);
        String attributeOrNull3 = attributeOrNull(element, ANDROID_NS, "endX");
        float parseFloat2 = attributeOrNull3 != null ? Float.parseFloat(attributeOrNull3) : 0.0f;
        String attributeOrNull4 = attributeOrNull(element, ANDROID_NS, "endY");
        long Offset2 = OffsetKt.Offset(parseFloat2, attributeOrNull4 != null ? Float.parseFloat(attributeOrNull4) : 0.0f);
        String attributeOrNull5 = attributeOrNull(element, ANDROID_NS, "tileMode");
        return companion.linearGradient-mHitzGk(pairArr, Offset, Offset2, attributeOrNull5 != null ? ValueParsersKt.parseTileMode(attributeOrNull5) : TileMode.Companion.getClamp-3opZhB0());
    }

    private static final Brush parseRadialGradient(Element element) {
        Brush.Companion companion = Brush.Companion;
        Pair<Float, Color>[] parseColorStops = parseColorStops(element);
        Pair[] pairArr = (Pair[]) Arrays.copyOf(parseColorStops, parseColorStops.length);
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "centerX");
        float parseFloat = attributeOrNull != null ? Float.parseFloat(attributeOrNull) : 0.0f;
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "centerY");
        long Offset = OffsetKt.Offset(parseFloat, attributeOrNull2 != null ? Float.parseFloat(attributeOrNull2) : 0.0f);
        String attributeOrNull3 = attributeOrNull(element, ANDROID_NS, "gradientRadius");
        float parseFloat2 = attributeOrNull3 != null ? Float.parseFloat(attributeOrNull3) : 0.0f;
        String attributeOrNull4 = attributeOrNull(element, ANDROID_NS, "tileMode");
        return companion.radialGradient-P_Vx-Ks(pairArr, Offset, parseFloat2, attributeOrNull4 != null ? ValueParsersKt.parseTileMode(attributeOrNull4) : TileMode.Companion.getClamp-3opZhB0());
    }

    private static final Brush parseSweepGradient(Element element) {
        Brush.Companion companion = Brush.Companion;
        Pair<Float, Color>[] parseColorStops = parseColorStops(element);
        Pair[] pairArr = (Pair[]) Arrays.copyOf(parseColorStops, parseColorStops.length);
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "centerX");
        float parseFloat = attributeOrNull != null ? Float.parseFloat(attributeOrNull) : 0.0f;
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "centerY");
        return companion.sweepGradient-Uv8p0NA(pairArr, OffsetKt.Offset(parseFloat, attributeOrNull2 != null ? Float.parseFloat(attributeOrNull2) : 0.0f));
    }

    private static final Pair<Float, Color>[] parseColorStops(Element element) {
        Sequence filter = SequencesKt.filter(getChildrenSequence(element), new Function1<Object, Boolean>() { // from class: org.jetbrains.compose.resources.vector.XmlVectorParserKt$parseColorStops$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m4invoke(Object obj) {
                return Boolean.valueOf(obj instanceof Element);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        List list = SequencesKt.toList(SequencesKt.filter(filter, new Function1() { // from class: org.jetbrains.compose.resources.vector.XmlVectorParserKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean parseColorStops$lambda$10;
                parseColorStops$lambda$10 = XmlVectorParserKt.parseColorStops$lambda$10((Element) obj);
                return Boolean.valueOf(parseColorStops$lambda$10);
            }
        }));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair<Float, Color> parseColorStop = parseColorStop((Element) obj, i / RangesKt.coerceAtLeast(CollectionsKt.getLastIndex(list), 1));
            if (parseColorStop != null) {
                arrayList.add(parseColorStop);
            }
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            String attributeOrNull = attributeOrNull(element, ANDROID_NS, "startColor");
            Integer valueOf = attributeOrNull != null ? Integer.valueOf(ValueParsersKt.parseColorValue(attributeOrNull)) : null;
            String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "centerColor");
            Integer valueOf2 = attributeOrNull2 != null ? Integer.valueOf(ValueParsersKt.parseColorValue(attributeOrNull2)) : null;
            String attributeOrNull3 = attributeOrNull(element, ANDROID_NS, "endColor");
            Integer valueOf3 = attributeOrNull3 != null ? Integer.valueOf(ValueParsersKt.parseColorValue(attributeOrNull3)) : null;
            if (valueOf != null) {
                arrayList2.add(TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(ColorKt.Color(valueOf.intValue()))));
            }
            if (valueOf2 != null) {
                arrayList2.add(TuplesKt.to(Float.valueOf(0.5f), Color.box-impl(ColorKt.Color(valueOf2.intValue()))));
            }
            if (valueOf3 != null) {
                arrayList2.add(TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(ColorKt.Color(valueOf3.intValue()))));
            }
        }
        return (Pair[]) arrayList2.toArray(new Pair[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseColorStops$lambda$10(Element element) {
        Intrinsics.checkNotNullParameter(element, "it");
        return Intrinsics.areEqual(element.getNodeName(), "item");
    }

    private static final Pair<Float, Color> parseColorStop(Element element, float f) {
        String attributeOrNull = attributeOrNull(element, ANDROID_NS, "offset");
        if (attributeOrNull != null) {
            f = Float.parseFloat(attributeOrNull);
        }
        String attributeOrNull2 = attributeOrNull(element, ANDROID_NS, "color");
        if (attributeOrNull2 == null) {
            return null;
        }
        return TuplesKt.to(Float.valueOf(f), Color.box-impl(ColorKt.Color(ValueParsersKt.parseColorValue(attributeOrNull2))));
    }

    private static final String attributeOrNull(Element element, String str, String str2) {
        String attributeNS = element.getAttributeNS(str, str2);
        if (!StringsKt.isBlank(attributeNS)) {
            return attributeNS;
        }
        return null;
    }

    private static final Element apptAttr(Element element, String str, String str2) {
        Object obj;
        String lookupPrefix = element.lookupPrefix(str);
        Sequence filter = SequencesKt.filter(getChildrenSequence(element), new Function1<Object, Boolean>() { // from class: org.jetbrains.compose.resources.vector.XmlVectorParserKt$apptAttr$$inlined$filterIsInstance$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m3invoke(Object obj2) {
                return Boolean.valueOf(obj2 instanceof Element);
            }
        });
        Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        Iterator it = filter.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Element element2 = (Element) obj;
            if (Intrinsics.areEqual(element2.getNamespaceURI(), AAPT_NS) && Intrinsics.areEqual(element2.getLocalName(), "attr") && Intrinsics.areEqual(element2.getAttribute("name"), new StringBuilder().append(lookupPrefix).append(":").append(str2).toString())) {
                break;
            }
        }
        return (Element) obj;
    }

    private static final Sequence<Node> getChildrenSequence(Element element) {
        return SequencesKt.sequence(new XmlVectorParserKt$childrenSequence$1(element, null));
    }
}
