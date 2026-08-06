package com.bytedance.trae.common.widget;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.widget.TextViewCompat;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.trae.common_ui.C0591R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TraeTitleBar.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Õ\u00012\u00020\u0001:\bÕ\u0001Ö\u0001×\u0001Ø\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010X\u001a\u00020Y2\u0006\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*J\u0006\u0010Z\u001a\u00020YJ\u0006\u0010[\u001a\u00020YJ\u0006\u0010\\\u001a\u00020YJ\u0010\u0010]\u001a\u00020Y2\b\u0010^\u001a\u0004\u0018\u00010_J\b\u0010`\u001a\u00020YH\u0014J\u0010\u0010a\u001a\u00020Y2\b\u0010b\u001a\u0004\u0018\u00010_J\u0010\u0010a\u001a\u00020Y2\b\b\u0001\u0010c\u001a\u00020\u0007J\u0006\u0010d\u001a\u00020_J\u0006\u0010e\u001a\u00020_J\u0010\u0010f\u001a\u00020Y2\b\u0010b\u001a\u0004\u0018\u00010_J$\u0010g\u001a\u00020Y2\b\u0010h\u001a\u0004\u0018\u00010_2\b\u0010i\u001a\u0004\u0018\u00010_2\b\b\u0001\u0010j\u001a\u00020\u0007J\u0010\u0010k\u001a\u00020Y2\b\b\u0001\u0010j\u001a\u00020\u0007J\u0006\u0010l\u001a\u00020_J\u0018\u0010m\u001a\u00020Y2\u0006\u0010n\u001a\u00020\u00072\b\b\u0002\u0010o\u001a\u00020*J\u0006\u0010p\u001a\u00020\u0007J@\u0010q\u001a\u00020Y28\u0010r\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110v¢\u0006\f\bt\u0012\b\bu\u0012\u0004\b\b(w\u0012\u0004\u0012\u00020Y\u0018\u00010sJ\u000e\u0010x\u001a\u00020Y2\u0006\u0010y\u001a\u00020*J\u0010\u0010z\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0010\u0010{\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0010\u0010|\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0010\u0010}\u001a\u00020Y2\b\b\u0001\u0010j\u001a\u00020\u0007J\u0010\u0010~\u001a\u00020Y2\b\b\u0001\u0010j\u001a\u00020\u0007J\u0010\u0010\u007f\u001a\u00020Y2\b\u0010b\u001a\u0004\u0018\u00010_J\u0010\u0010\u0080\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020*J_\u0010\u0082\u0001\u001a\u00020Y2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0087\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0088\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u00072\t\b\u0002\u0010\u008a\u0001\u001a\u00020\u0007J\u0007\u0010\u008b\u0001\u001a\u00020\u001dJ\u0007\u0010\u008c\u0001\u001a\u00020\u001dJ\u0010\u0010\u008d\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020*J\u0007\u0010\u008e\u0001\u001a\u00020*J\u0011\u0010\u008f\u0001\u001a\u00020Y2\b\b\u0001\u0010j\u001a\u00020\u0007J\u0010\u0010\u0090\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020*J\u000f\u0010\u0091\u0001\u001a\u00020Y2\u0006\u0010y\u001a\u00020*J\u0011\u0010\u0092\u0001\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0010\u0010\u0093\u0001\u001a\u00020Y2\u0007\u0010\u0094\u0001\u001a\u00020,J\u0010\u0010\u0095\u0001\u001a\u00020Y2\u0007\u0010\u0094\u0001\u001a\u00020,J\u0016\u0010\u0096\u0001\u001a\u00020Y2\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020,0.J\u0010\u0010\u0098\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020*J\u0010\u0010\u0099\u0001\u001a\u00020Y2\u0007\u0010\u0081\u0001\u001a\u00020*J\u0011\u0010\u009a\u0001\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0011\u0010\u009b\u0001\u001a\u00020Y2\b\u0010r\u001a\u0004\u0018\u000102J\u0019\u0010\u009b\u0001\u001a\u00020Y2\u0006\u0010n\u001a\u00020\u00072\b\u0010r\u001a\u0004\u0018\u000102J\u0018\u0010\u009c\u0001\u001a\u00020Y2\u0006\u0010n\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0017\u0010\u009e\u0001\u001a\u00020Y2\u0006\u0010n\u001a\u00020\u00072\u0006\u0010y\u001a\u00020*J\u0018\u0010\u009f\u0001\u001a\u00020Y2\u0006\u0010n\u001a\u00020\u00072\u0007\u0010\u009d\u0001\u001a\u00020\u0007J\u0019\u0010 \u0001\u001a\u00020Y2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\t\u0010¡\u0001\u001a\u00020YH\u0002J\t\u0010¢\u0001\u001a\u00020YH\u0002J\t\u0010£\u0001\u001a\u00020YH\u0002J\t\u0010¤\u0001\u001a\u00020YH\u0002J\t\u0010¥\u0001\u001a\u00020YH\u0002J\n\u0010¦\u0001\u001a\u00030§\u0001H\u0002J\t\u0010¨\u0001\u001a\u00020YH\u0002J\r\u0010©\u0001\u001a\u00020Y*\u00020\u000eH\u0002J\r\u0010ª\u0001\u001a\u00020Y*\u00020\u000eH\u0002J\r\u0010«\u0001\u001a\u00020Y*\u00020\u000eH\u0002J\t\u0010¬\u0001\u001a\u00020YH\u0002J\t\u0010\u00ad\u0001\u001a\u00020YH\u0002J\f\u0010®\u0001\u001a\u0005\u0018\u00010§\u0001H\u0002J\u000e\u0010¯\u0001\u001a\u00020**\u00030§\u0001H\u0002J\t\u0010°\u0001\u001a\u00020\u0007H\u0002J\t\u0010±\u0001\u001a\u00020\u0007H\u0002J\t\u0010²\u0001\u001a\u00020YH\u0002J\t\u0010³\u0001\u001a\u00020YH\u0002J\t\u0010´\u0001\u001a\u00020YH\u0002J\t\u0010µ\u0001\u001a\u00020YH\u0002J\u0018\u0010¶\u0001\u001a\u00020%2\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020,0.H\u0002J\u0012\u0010·\u0001\u001a\u00020\u000b2\u0007\u0010\u0094\u0001\u001a\u00020,H\u0002J\u001b\u0010¸\u0001\u001a\u00020\u000b2\u0007\u0010¹\u0001\u001a\u00020\u00072\u0007\u0010º\u0001\u001a\u00020\u0007H\u0002J\u001f\u0010»\u0001\u001a\u00020Y*\u00020\u000b2\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020\u0007H\u0002J(\u0010½\u0001\u001a\u00020Y*\u00020\u000b2\u0007\u0010¼\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020\u00072\u0007\u0010¾\u0001\u001a\u00020\u0007H\u0002J\u001b\u0010¿\u0001\u001a\u00020 2\u0007\u0010\u0094\u0001\u001a\u00020,2\u0007\u0010À\u0001\u001a\u00020*H\u0002J\u001c\u0010Á\u0001\u001a\u00030Â\u00012\u0007\u0010¹\u0001\u001a\u00020\u00072\u0007\u0010Ã\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010Ä\u0001\u001a\u00020v2\u0006\u0010n\u001a\u00020\u0007H\u0002J\u001e\u0010Å\u0001\u001a\u0004\u0018\u00010%2\t\u0010Æ\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010n\u001a\u00020\u0007H\u0002J\t\u0010Ç\u0001\u001a\u00020YH\u0002J\t\u0010È\u0001\u001a\u00020YH\u0002J\u0013\u0010É\u0001\u001a\u00020Y2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0002J\u0018\u0010Ì\u0001\u001a\u00020\u00072\r\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020,0.H\u0002J\u001c\u0010Í\u0001\u001a\u00030Î\u00012\u0007\u0010Ï\u0001\u001a\u00020\u00072\u0007\u0010Ð\u0001\u001a\u00020SH\u0002J\u0011\u0010Ñ\u0001\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0007H\u0002J\u0012\u0010Ò\u0001\u001a\u00020,2\u0007\u0010Ó\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010Ô\u0001\u001a\u0004\u0018\u00010%2\u0006\u0010n\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Ù\u0001"}, d2 = {"Lcom/bytedance/trae/common/widget/TraeTitleBar;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "grabberContainer", "Landroid/widget/FrameLayout;", "contentRow", "titleView", "Landroid/widget/TextView;", "detailTitleContainer", "detailTitleView", "detailSubtitleRow", "detailSubtitleIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "detailSubtitlePrimaryView", "detailSubtitleDotView", "detailSubtitleSecondaryView", "segmentedControl", "Lcom/bytedance/trae/common/widget/TitleBarSegmentedControl;", "taskTitleContainer", "taskTitleView", "taskTitleChevron", "taskOperationIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "taskActionContainer", "taskSearchButton", "Landroidx/appcompat/widget/AppCompatImageButton;", "taskAvatarContainer", "taskAvatarView", "taskAvatarBadge", "leftActionView", "Landroid/view/View;", "rightActionView", "mode", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "showGrabber", "", "leftAction", "Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "rightActions", "", "leftVisible", "rightVisible", "leftClickListener", "Landroid/view/View$OnClickListener;", "rightClickListeners", "taskOperationVisible", "shouldUseImplicitBackground", "mediaPreviewAppearance", "pageHeight", "taskHeaderHeight", "sheetContentHeight", "grabberContainerHeight", "grabberWidth", "grabberHeight", "horizontalPadding", "actionSize", "actionGap", "titleSideGap", "detailTitleGap", "detailSubtitleGap", "iconSize", "detailIconSize", "segmentWidth", "taskTitleIconSize", "taskTitleIconGap", "taskActionWidth", "taskActionPaddingHorizontal", "taskAvatarSize", "taskAvatarBadgeSize", "taskAvatarBadgeMarginEnd", "taskAvatarBadgeMarginBottom", "operationWidth", "operationHeight", "operationRadius", "operationMarginEnd", "actionOverflowDrawOrderZ", "", "actionShadowBlurRadius", "actionShadowOffsetY", "actionShadowPaddingTop", "actionShadowPaddingBottom", "setMode", "", "showConversationDetailHeader", "showNewConversationHeader", "showTaskListHeader", "showMediaPreviewHeader", "title", "", "onAttachedToWindow", "setTitle", "text", "resId", "getTitleText", "getDisplayedTitleText", "setConversationDetailTitle", "setConversationDetailSubtitle", "primary", "secondary", "iconRes", "setConversationDetailSubtitleIcon", "getConversationDetailSubtitleText", "setSegmentedSelectedIndex", "index", "animate", "getSegmentedSelectedIndex", "setOnSegmentedTabSelectedListener", "listener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "tab", "setInteractionEnabled", "enabled", "setOnTaskTitleClickListener", "setOnTaskSearchClickListener", "setOnTaskAvatarClickListener", "setTaskSearchIcon", "setTaskTitleTrailingIcon", "setTaskSearchContentDescription", "setTaskSearchButtonVisible", "visible", "setTaskHeaderViewIds", "titleContainerId", "titleTextId", "titleChevronId", "searchButtonId", "avatarContainerId", "avatarImageId", "avatarBadgeId", "operationIconId", "getTaskAvatarView", "getTaskOperationIconView", "setTaskOperationIconVisible", "isTaskOperationIconVisible", "setTaskAvatarBadgeImageResource", "setTaskAvatarBadgeVisible", "setTaskEnterpriseMode", "setOnTitleClickListener", "setLeftAction", "action", "setRightAction", "setRightActions", "actions", "setLeftActionVisible", "setRightActionsVisible", "setOnLeftActionClickListener", "setOnRightActionClickListener", "setRightActionViewId", "id", "setRightActionEnabled", "setRightActionResource", "applyAttrs", "setupGrabber", "setupContentRow", "setupTaskHeader", "setupTaskOperationIcon", "setupTaskActionContainer", "createTaskActionBackground", "Landroid/graphics/drawable/Drawable;", "setupDetailTitle", "applyTitleTextStyle", "applyTaskTitleTextStyle", "applySubtitleTextStyle", "applyMode", "applyImplicitBackground", "findParentSurfaceBackground", "isTransparentColor", "defaultBackgroundColorRes", "contentHeightForMode", "syncTaskHeaderVisibility", "allowActionShadowOverflow", "liftActionOverflowAboveSiblings", "rebuildActions", "createRightActionView", "createSingleActionButton", "createActionShadowContainer", "visualWidth", "backgroundColor", "addActionContent", ReportConstant.COMMON_CONTENT, "addShadowContent", "visualHeight", "createIconButton", "withBackground", "createActionLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "horizontalGravity", "actionViewTag", "findActionView", "view", "updateTitleMargins", "updateTaskTitleMargins", "tintTaskIcon", "imageView", "Landroid/widget/ImageView;", "rightActionsWidth", "roundedBackground", "Landroid/graphics/drawable/GradientDrawable;", "colorRes", "radius", "dimen", "actionFromValue", "value", "findRightActionClickTarget", "Companion", "Mode", "Action", "EmptyOutlineProvider", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeTitleBar extends LinearLayout {
    private static final float ACTION_DISABLED_ALPHA = 0.4f;
    private static final float ACTION_ENABLED_ALPHA = 1.0f;
    private static final float MEDIA_PREVIEW_ACTION_BACKGROUND_ALPHA = 0.2f;
    public static final int SEGMENT_INDEX_CODE = 1;
    public static final int SEGMENT_INDEX_WORK = 0;
    private final int actionGap;
    private final float actionOverflowDrawOrderZ;
    private final int actionShadowBlurRadius;
    private final int actionShadowOffsetY;
    private final int actionShadowPaddingBottom;
    private final int actionShadowPaddingTop;
    private final int actionSize;
    private final FrameLayout contentRow;
    private final int detailIconSize;
    private final TextView detailSubtitleDotView;
    private final int detailSubtitleGap;
    private final AppCompatImageView detailSubtitleIcon;
    private final TextView detailSubtitlePrimaryView;
    private final LinearLayout detailSubtitleRow;
    private final TextView detailSubtitleSecondaryView;
    private final LinearLayout detailTitleContainer;
    private final int detailTitleGap;
    private final TextView detailTitleView;
    private final FrameLayout grabberContainer;
    private final int grabberContainerHeight;
    private final int grabberHeight;
    private final int grabberWidth;
    private final int horizontalPadding;
    private final int iconSize;
    private Action leftAction;
    private View leftActionView;
    private View.OnClickListener leftClickListener;
    private boolean leftVisible;
    private boolean mediaPreviewAppearance;
    private Mode mode;
    private final int operationHeight;
    private final int operationMarginEnd;
    private final int operationRadius;
    private final int operationWidth;
    private final int pageHeight;
    private View rightActionView;
    private List<? extends Action> rightActions;
    private List<? extends View.OnClickListener> rightClickListeners;
    private boolean rightVisible;
    private final int segmentWidth;
    private final TitleBarSegmentedControl segmentedControl;
    private final int sheetContentHeight;
    private boolean shouldUseImplicitBackground;
    private boolean showGrabber;
    private final FrameLayout taskActionContainer;
    private final int taskActionPaddingHorizontal;
    private final int taskActionWidth;
    private final AppCompatImageView taskAvatarBadge;
    private final int taskAvatarBadgeMarginBottom;
    private final int taskAvatarBadgeMarginEnd;
    private final int taskAvatarBadgeSize;
    private final FrameLayout taskAvatarContainer;
    private final int taskAvatarSize;
    private final SimpleDraweeView taskAvatarView;
    private final int taskHeaderHeight;
    private final SimpleDraweeView taskOperationIcon;
    private boolean taskOperationVisible;
    private final AppCompatImageButton taskSearchButton;
    private final AppCompatImageView taskTitleChevron;
    private final LinearLayout taskTitleContainer;
    private final int taskTitleIconGap;
    private final int taskTitleIconSize;
    private final TextView taskTitleView;
    private final int titleSideGap;
    private final TextView titleView;

    /* compiled from: TraeTitleBar.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.CONVERSATION_DETAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.NEW_CONVERSATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.TASK_LIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Mode.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Mode.SHEET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TraeTitleBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TraeTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TraeTitleBar(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        this.grabberContainer = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.contentRow = frameLayout2;
        this.titleView = new TextView(context);
        this.detailTitleContainer = new LinearLayout(context);
        this.detailTitleView = new TextView(context);
        this.detailSubtitleRow = new LinearLayout(context);
        this.detailSubtitleIcon = new AppCompatImageView(context);
        this.detailSubtitlePrimaryView = new TextView(context);
        this.detailSubtitleDotView = new TextView(context);
        this.detailSubtitleSecondaryView = new TextView(context);
        this.segmentedControl = new TitleBarSegmentedControl(context, null, 0, 6, null);
        this.taskTitleContainer = new LinearLayout(context);
        this.taskTitleView = new TextView(context);
        this.taskTitleChevron = new AppCompatImageView(context);
        this.taskOperationIcon = new SimpleDraweeView(context);
        this.taskActionContainer = new FrameLayout(context);
        this.taskSearchButton = new AppCompatImageButton(context);
        this.taskAvatarContainer = new FrameLayout(context);
        this.taskAvatarView = new SimpleDraweeView(context);
        this.taskAvatarBadge = new AppCompatImageView(context);
        this.mode = Mode.PAGE;
        this.leftAction = Action.NONE;
        this.rightActions = CollectionsKt.emptyList();
        this.leftVisible = true;
        this.rightVisible = true;
        this.rightClickListeners = CollectionsKt.emptyList();
        this.shouldUseImplicitBackground = getBackground() == null;
        this.pageHeight = dimen(C0591R.dimen.trae_title_bar_page_height);
        this.taskHeaderHeight = dimen(C0591R.dimen.trae_title_bar_task_height);
        this.sheetContentHeight = dimen(C0591R.dimen.trae_title_bar_sheet_content_height);
        this.grabberContainerHeight = dimen(C0591R.dimen.trae_title_bar_grabber_container_height);
        this.grabberWidth = dimen(C0591R.dimen.trae_title_bar_grabber_width);
        this.grabberHeight = dimen(C0591R.dimen.trae_title_bar_grabber_height);
        this.horizontalPadding = dimen(C0591R.dimen.trae_title_bar_horizontal_padding);
        this.actionSize = dimen(C0591R.dimen.trae_title_bar_action_size);
        this.actionGap = dimen(C0591R.dimen.trae_title_bar_action_gap);
        this.titleSideGap = dimen(C0591R.dimen.trae_title_bar_title_side_gap);
        this.detailTitleGap = dimen(C0591R.dimen.trae_title_bar_detail_title_gap);
        this.detailSubtitleGap = dimen(C0591R.dimen.trae_title_bar_detail_subtitle_gap);
        this.iconSize = dimen(C0591R.dimen.trae_title_bar_icon_size);
        this.detailIconSize = dimen(C0591R.dimen.trae_title_bar_detail_icon_size);
        this.segmentWidth = dimen(C0591R.dimen.trae_title_bar_segment_width);
        this.taskTitleIconSize = dimen(C0591R.dimen.trae_title_bar_task_title_icon_size);
        this.taskTitleIconGap = dimen(C0591R.dimen.trae_title_bar_task_title_icon_gap);
        this.taskActionWidth = dimen(C0591R.dimen.trae_title_bar_task_action_width);
        this.taskActionPaddingHorizontal = dimen(C0591R.dimen.trae_title_bar_task_action_padding_horizontal);
        this.taskAvatarSize = dimen(C0591R.dimen.trae_title_bar_task_avatar_size);
        this.taskAvatarBadgeSize = dimen(C0591R.dimen.trae_title_bar_task_avatar_badge_size);
        this.taskAvatarBadgeMarginEnd = dimen(C0591R.dimen.trae_title_bar_task_avatar_badge_margin_end);
        this.taskAvatarBadgeMarginBottom = dimen(C0591R.dimen.trae_title_bar_task_avatar_badge_margin_bottom);
        this.operationWidth = dimen(C0591R.dimen.trae_title_bar_operation_width);
        this.operationHeight = dimen(C0591R.dimen.trae_title_bar_operation_height);
        this.operationRadius = dimen(C0591R.dimen.trae_title_bar_operation_radius);
        this.operationMarginEnd = dimen(C0591R.dimen.trae_title_bar_operation_margin_end);
        this.actionOverflowDrawOrderZ = getResources().getDimension(C0591R.dimen.trae_title_bar_elevation);
        int dimen = dimen(C0591R.dimen.trae_title_bar_shadow_blur_radius);
        this.actionShadowBlurRadius = dimen;
        int dimen2 = dimen(C0591R.dimen.trae_title_bar_shadow_offset_y);
        this.actionShadowOffsetY = dimen2;
        this.actionShadowPaddingTop = RangesKt.coerceAtLeast(dimen - dimen2, 0);
        this.actionShadowPaddingBottom = dimen + dimen2;
        setOrientation(1);
        setGravity(1);
        setClipToPadding(false);
        setClipChildren(false);
        setupGrabber();
        setupContentRow();
        addView(frameLayout);
        addView(frameLayout2);
        if (attributeSet != null) {
            applyAttrs(attributeSet, i);
        }
        applyMode();
        applyImplicitBackground();
        rebuildActions();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TraeTitleBar.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE", "SHEET", "CONVERSATION_DETAIL", "NEW_CONVERSATION", "TASK_LIST", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode PAGE = new Mode("PAGE", 0);
        public static final Mode SHEET = new Mode("SHEET", 1);
        public static final Mode CONVERSATION_DETAIL = new Mode("CONVERSATION_DETAIL", 2);
        public static final Mode NEW_CONVERSATION = new Mode("NEW_CONVERSATION", 3);
        public static final Mode TASK_LIST = new Mode("TASK_LIST", 4);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{PAGE, SHEET, CONVERSATION_DETAIL, NEW_CONVERSATION, TASK_LIST};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        private Mode(String str, int i) {
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: TraeTitleBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;", "", "iconRes", "", "primary", "", "<init>", "(Ljava/lang/String;IIZ)V", "getIconRes", "()I", "getPrimary", "()Z", "NONE", "BACK", "CLOSE", "MORE", "CONFIRM", "CHAT_NEW", "DOWNLOAD", "SETTINGS", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Action {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        private final int iconRes;
        private final boolean primary;
        public static final Action NONE = new Action("NONE", 0, 0, false);
        public static final Action BACK = new Action("BACK", 1, C0591R.drawable.trae_ic_title_bar_chevron_left, false);
        public static final Action CLOSE = new Action("CLOSE", 2, C0591R.drawable.trae_ic_title_bar_close, false);
        public static final Action MORE = new Action("MORE", 3, C0591R.drawable.trae_ic_title_bar_more, false);
        public static final Action CONFIRM = new Action("CONFIRM", 4, C0591R.drawable.trae_ic_title_bar_checkmark, true);
        public static final Action CHAT_NEW = new Action("CHAT_NEW", 5, C0591R.drawable.trae_ic_title_bar_chat_new, false);
        public static final Action DOWNLOAD = new Action("DOWNLOAD", 6, C0591R.drawable.trae_ic_title_bar_download, false);
        public static final Action SETTINGS = new Action("SETTINGS", 7, C0591R.drawable.trae_ic_title_bar_settings, false);

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{NONE, BACK, CLOSE, MORE, CONFIRM, CHAT_NEW, DOWNLOAD, SETTINGS};
        }

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        private Action(String str, int i, int i2, boolean z) {
            this.iconRes = i2;
            this.primary = z;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        public final boolean getPrimary() {
            return this.primary;
        }

        static {
            Action[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ void setMode$default(TraeTitleBar traeTitleBar, Mode mode, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = mode == Mode.SHEET;
        }
        traeTitleBar.setMode(mode, z);
    }

    public final void setMode(Mode mode, boolean showGrabber) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.mode = mode;
        this.showGrabber = showGrabber;
        applyMode();
        rebuildActions();
    }

    public final void showConversationDetailHeader() {
        setMode(Mode.CONVERSATION_DETAIL, false);
        setLeftAction(Action.BACK);
        setRightActions(CollectionsKt.listOf(new Action[]{Action.CHAT_NEW, Action.MORE}));
    }

    public final void showNewConversationHeader() {
        setMode(Mode.NEW_CONVERSATION, false);
        setLeftAction(Action.BACK);
        setRightActions(CollectionsKt.emptyList());
    }

    public final void showTaskListHeader() {
        setMode(Mode.TASK_LIST, false);
        setLeftAction(Action.NONE);
        setRightActions(CollectionsKt.emptyList());
    }

    public final void showMediaPreviewHeader(CharSequence title) {
        this.mediaPreviewAppearance = true;
        this.shouldUseImplicitBackground = false;
        setBackgroundColor(0);
        this.mode = Mode.PAGE;
        this.showGrabber = false;
        this.leftAction = Action.BACK;
        this.rightActions = CollectionsKt.listOf(Action.DOWNLOAD);
        this.leftVisible = true;
        this.rightVisible = true;
        setTitle(title);
        applyMode();
        applyTitleTextStyle(this.titleView);
        rebuildActions();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        applyImplicitBackground();
        allowActionShadowOverflow();
        liftActionOverflowAboveSiblings();
    }

    public final void setTitle(CharSequence text) {
        this.titleView.setText(text);
        this.taskTitleView.setText(text);
    }

    public final void setTitle(int resId) {
        this.titleView.setText(resId);
        this.taskTitleView.setText(resId);
    }

    public final CharSequence getTitleText() {
        return getDisplayedTitleText();
    }

    public final CharSequence getDisplayedTitleText() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1) {
            CharSequence text = this.detailTitleView.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            return text;
        }
        if (i == 2) {
            return this.segmentedControl.getSelectedTab();
        }
        if (i == 3) {
            CharSequence text2 = this.taskTitleView.getText();
            Intrinsics.checkNotNullExpressionValue(text2, "getText(...)");
            return text2;
        }
        CharSequence text3 = this.titleView.getText();
        Intrinsics.checkNotNullExpressionValue(text3, "getText(...)");
        return text3;
    }

    public final void setConversationDetailTitle(CharSequence text) {
        this.detailTitleView.setText(text);
    }

    public final void setConversationDetailSubtitle(CharSequence primary, CharSequence secondary, int iconRes) {
        this.detailSubtitleIcon.setImageResource(iconRes);
        this.detailSubtitleIcon.setVisibility(iconRes == 0 ? 8 : 0);
        this.detailSubtitlePrimaryView.setText(primary);
        boolean z = true;
        this.detailSubtitlePrimaryView.setVisibility(primary == null || primary.length() == 0 ? 8 : 0);
        this.detailSubtitleDotView.setText("·");
        this.detailSubtitleDotView.setVisibility(!(secondary == null || secondary.length() == 0) ? 0 : 8);
        this.detailSubtitleSecondaryView.setText(secondary);
        TextView textView = this.detailSubtitleSecondaryView;
        if (secondary != null && secondary.length() != 0) {
            z = false;
        }
        textView.setVisibility(z ? 8 : 0);
    }

    public final void setConversationDetailSubtitleIcon(int iconRes) {
        this.detailSubtitleIcon.setImageResource(iconRes);
        this.detailSubtitleIcon.setVisibility(iconRes == 0 ? 8 : 0);
    }

    public final CharSequence getConversationDetailSubtitleText() {
        String[] strArr = new String[2];
        CharSequence text = this.detailSubtitlePrimaryView.getText();
        String obj = text != null ? text.toString() : null;
        if (obj == null) {
            obj = "";
        }
        strArr[0] = obj;
        CharSequence text2 = this.detailSubtitleSecondaryView.getText();
        String obj2 = text2 != null ? text2.toString() : null;
        strArr[1] = obj2 != null ? obj2 : "";
        List listOf = CollectionsKt.listOf(strArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj3 : listOf) {
            if (((String) obj3).length() > 0) {
                arrayList.add(obj3);
            }
        }
        return CollectionsKt.joinToString$default(arrayList, " · ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ void setSegmentedSelectedIndex$default(TraeTitleBar traeTitleBar, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        traeTitleBar.setSegmentedSelectedIndex(i, z);
    }

    public final void setSegmentedSelectedIndex(int index, boolean animate) {
        this.segmentedControl.setSelectedIndex(index, animate);
    }

    public final int getSegmentedSelectedIndex() {
        return this.segmentedControl.getSelectedIndex();
    }

    public final void setOnSegmentedTabSelectedListener(Function2<? super Integer, ? super String, Unit> listener) {
        this.segmentedControl.setOnTabSelected(listener);
    }

    public final void setInteractionEnabled(boolean enabled) {
        setEnabled(enabled);
        this.segmentedControl.setEnabled(enabled);
        this.taskTitleContainer.setEnabled(enabled);
        this.taskSearchButton.setEnabled(enabled);
        this.taskAvatarContainer.setEnabled(enabled);
        this.taskOperationIcon.setEnabled(enabled);
        View view = this.leftActionView;
        if (view != null) {
            view.setEnabled(enabled);
        }
        View view2 = this.leftActionView;
        if (view2 != null) {
            view2.setClickable(enabled);
        }
        View view3 = this.rightActionView;
        if (view3 != null) {
            view3.setEnabled(enabled);
        }
        View view4 = this.rightActionView;
        if (view4 != null) {
            view4.setClickable(enabled);
        }
        if (this.rightActions.size() > 1) {
            IntIterator it = CollectionsKt.getIndices(this.rightActions).iterator();
            while (it.hasNext()) {
                View findActionView = findActionView(this.rightActionView, it.nextInt());
                if (findActionView != null) {
                    findActionView.setEnabled(enabled);
                    findActionView.setClickable(enabled);
                }
            }
        }
    }

    public final void setOnTaskTitleClickListener(View.OnClickListener listener) {
        this.taskTitleContainer.setOnClickListener(listener);
        this.taskTitleContainer.setClickable(listener != null);
        this.taskTitleContainer.setFocusable(listener != null);
    }

    public final void setOnTaskSearchClickListener(View.OnClickListener listener) {
        this.taskSearchButton.setOnClickListener(listener);
    }

    public final void setOnTaskAvatarClickListener(View.OnClickListener listener) {
        this.taskAvatarContainer.setOnClickListener(listener);
        this.taskAvatarContainer.setClickable(listener != null);
        this.taskAvatarContainer.setFocusable(listener != null);
    }

    public final void setTaskSearchIcon(int iconRes) {
        this.taskSearchButton.setImageResource(iconRes);
        tintTaskIcon((ImageView) this.taskSearchButton);
    }

    public final void setTaskTitleTrailingIcon(int iconRes) {
        if (iconRes == 0) {
            this.taskTitleChevron.setImageDrawable((Drawable) null);
            this.taskTitleChevron.setVisibility(8);
        } else {
            this.taskTitleChevron.setImageResource(iconRes);
            this.taskTitleChevron.setVisibility(0);
            tintTaskIcon((ImageView) this.taskTitleChevron);
        }
        updateTaskTitleMargins();
    }

    public final void setTaskSearchContentDescription(CharSequence text) {
        this.taskSearchButton.setContentDescription(text);
    }

    public final void setTaskSearchButtonVisible(boolean visible) {
        this.taskSearchButton.setVisibility(visible ? 0 : 8);
        this.taskActionContainer.setBackground(visible ? createTaskActionBackground() : null);
    }

    public static /* synthetic */ void setTaskHeaderViewIds$default(TraeTitleBar traeTitleBar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i = -1;
        }
        if ((i9 & 2) != 0) {
            i2 = -1;
        }
        if ((i9 & 4) != 0) {
            i3 = -1;
        }
        if ((i9 & 8) != 0) {
            i4 = -1;
        }
        if ((i9 & 16) != 0) {
            i5 = -1;
        }
        if ((i9 & 32) != 0) {
            i6 = -1;
        }
        if ((i9 & 64) != 0) {
            i7 = -1;
        }
        if ((i9 & 128) != 0) {
            i8 = -1;
        }
        traeTitleBar.setTaskHeaderViewIds(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public final void setTaskHeaderViewIds(int titleContainerId, int titleTextId, int titleChevronId, int searchButtonId, int avatarContainerId, int avatarImageId, int avatarBadgeId, int operationIconId) {
        this.taskTitleContainer.setId(titleContainerId);
        this.taskTitleView.setId(titleTextId);
        this.taskTitleChevron.setId(titleChevronId);
        this.taskSearchButton.setId(searchButtonId);
        this.taskAvatarContainer.setId(avatarContainerId);
        this.taskAvatarView.setId(avatarImageId);
        this.taskAvatarBadge.setId(avatarBadgeId);
        this.taskOperationIcon.setId(operationIconId);
    }

    public final SimpleDraweeView getTaskAvatarView() {
        return this.taskAvatarView;
    }

    /* renamed from: getTaskOperationIconView, reason: from getter */
    public final SimpleDraweeView getTaskOperationIcon() {
        return this.taskOperationIcon;
    }

    public final void setTaskOperationIconVisible(boolean visible) {
        this.taskOperationVisible = visible;
        syncTaskHeaderVisibility();
        updateTaskTitleMargins();
    }

    /* renamed from: isTaskOperationIconVisible, reason: from getter */
    public final boolean getTaskOperationVisible() {
        return this.taskOperationVisible;
    }

    public final void setTaskAvatarBadgeImageResource(int iconRes) {
        this.taskAvatarBadge.setImageResource(iconRes);
    }

    public final void setTaskAvatarBadgeVisible(boolean visible) {
        this.taskAvatarBadge.setVisibility(visible ? 0 : 8);
    }

    public final void setTaskEnterpriseMode(boolean enabled) {
        if (enabled) {
            float f = getResources().getDisplayMetrics().density;
            int i = (int) (36 * f);
            int i2 = (int) (5 * f);
            this.taskSearchButton.setVisibility(8);
            this.taskActionContainer.setBackground(null);
            this.taskAvatarView.setLayoutParams(new FrameLayout.LayoutParams(i, i, 17));
            this.taskActionContainer.removeAllViews();
            ViewParent parent = this.taskAvatarContainer.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(this.taskAvatarContainer);
            }
            this.taskActionContainer.addView(this.taskAvatarContainer, new FrameLayout.LayoutParams(i, i, 17));
            ViewGroup.LayoutParams layoutParams = this.taskActionContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = i;
            layoutParams2.height = i;
            layoutParams2.topMargin = (this.taskHeaderHeight - i) / 2;
            layoutParams2.rightMargin = i2;
            layoutParams2.gravity = 8388661;
            this.taskActionContainer.setLayoutParams(layoutParams2);
        }
    }

    public final void setOnTitleClickListener(View.OnClickListener listener) {
        this.titleView.setOnClickListener(listener);
        this.titleView.setClickable(listener != null);
        this.titleView.setFocusable(listener != null);
    }

    public final void setLeftAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.leftAction = action;
        this.leftVisible = action != Action.NONE;
        rebuildActions();
    }

    public final void setRightAction(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        setRightActions(action == Action.NONE ? CollectionsKt.emptyList() : CollectionsKt.listOf(action));
    }

    public final void setRightActions(List<? extends Action> actions) {
        Intrinsics.checkNotNullParameter(actions, "actions");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = actions.iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((Action) next) != Action.NONE) {
                    arrayList.add(next);
                }
            } else {
                this.rightActions = arrayList;
                this.rightVisible = !r0.isEmpty();
                this.rightClickListeners = CollectionsKt.take(this.rightClickListeners, this.rightActions.size());
                rebuildActions();
                return;
            }
        }
    }

    public final void setLeftActionVisible(boolean visible) {
        this.leftVisible = visible;
        View view = this.leftActionView;
        if (view != null) {
            view.setVisibility(visible ? 0 : 4);
        }
    }

    public final void setRightActionsVisible(boolean visible) {
        this.rightVisible = visible;
        View view = this.rightActionView;
        if (view != null) {
            view.setVisibility(visible ? 0 : 4);
        }
    }

    public final void setOnLeftActionClickListener(View.OnClickListener listener) {
        this.leftClickListener = listener;
        View view = this.leftActionView;
        if (view != null) {
            view.setOnClickListener(listener);
        }
    }

    public final void setOnRightActionClickListener(View.OnClickListener listener) {
        setOnRightActionClickListener(0, listener);
    }

    public final void setOnRightActionClickListener(int index, View.OnClickListener listener) {
        View view;
        List<? extends View.OnClickListener> mutableList = CollectionsKt.toMutableList(this.rightClickListeners);
        while (mutableList.size() <= index) {
            mutableList.add(null);
        }
        mutableList.set(index, listener);
        this.rightClickListeners = mutableList;
        View findActionView = findActionView(this.rightActionView, index);
        if (findActionView != null) {
            findActionView.setOnClickListener(listener);
        }
        if (index != 0 || (view = this.rightActionView) == null) {
            return;
        }
        view.setOnClickListener(listener);
    }

    public final void setRightActionViewId(int index, int id) {
        View findRightActionClickTarget = findRightActionClickTarget(index);
        if (findRightActionClickTarget != null) {
            findRightActionClickTarget.setId(id);
        }
    }

    public final void setRightActionEnabled(int index, boolean enabled) {
        View findRightActionClickTarget = findRightActionClickTarget(index);
        if (findRightActionClickTarget == null) {
            return;
        }
        findRightActionClickTarget.setEnabled(enabled);
        findRightActionClickTarget.setAlpha(enabled ? ACTION_ENABLED_ALPHA : ACTION_DISABLED_ALPHA);
        View findActionView = findActionView(this.rightActionView, index);
        if (findActionView != null) {
            findActionView.setEnabled(enabled);
        }
    }

    public final void setRightActionResource(int index, int id) {
        if (findRightActionClickTarget(index) == null) {
            return;
        }
        View view = this.rightActionView;
        if (view instanceof ViewGroup) {
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view2 = this.rightActionView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                AppCompatImageButton childAt = ((ViewGroup) view2).getChildAt(i);
                if (childAt instanceof AppCompatImageButton) {
                    childAt.setImageResource(id);
                    return;
                }
            }
        }
    }

    private final void applyAttrs(AttributeSet attrs, int defStyleAttr) {
        Mode mode;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C0591R.styleable.TraeTitleBar, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            CharSequence text = obtainStyledAttributes.getText(C0591R.styleable.TraeTitleBar_trae_titleText);
            this.titleView.setText(text);
            this.taskTitleView.setText(text);
            int i = obtainStyledAttributes.getInt(C0591R.styleable.TraeTitleBar_trae_titleBarMode, 0);
            if (i == 1) {
                mode = Mode.SHEET;
            } else if (i == 2) {
                mode = Mode.CONVERSATION_DETAIL;
            } else if (i == 3) {
                mode = Mode.NEW_CONVERSATION;
            } else if (i == 4) {
                mode = Mode.TASK_LIST;
            } else {
                mode = Mode.PAGE;
            }
            this.mode = mode;
            this.showGrabber = obtainStyledAttributes.getBoolean(C0591R.styleable.TraeTitleBar_trae_titleBarShowGrabber, this.mode == Mode.SHEET);
            this.leftAction = actionFromValue(obtainStyledAttributes.getInt(C0591R.styleable.TraeTitleBar_trae_titleBarLeftAction, 0));
            Action actionFromValue = actionFromValue(obtainStyledAttributes.getInt(C0591R.styleable.TraeTitleBar_trae_titleBarRightAction, 0));
            this.rightActions = actionFromValue == Action.NONE ? CollectionsKt.emptyList() : CollectionsKt.listOf(actionFromValue);
            this.leftVisible = this.leftAction != Action.NONE;
            this.rightVisible = this.rightActions.isEmpty() ? false : true;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void setupGrabber() {
        this.grabberContainer.setLayoutParams(new LinearLayout.LayoutParams(this.grabberWidth, this.grabberContainerHeight));
        View view = new View(getContext());
        view.setBackground(roundedBackground(C0591R.color.trae_title_bar_grabber, this.grabberHeight / 2.0f));
        this.grabberContainer.addView(view, new FrameLayout.LayoutParams(this.grabberWidth, this.grabberHeight, 17));
    }

    private final void setupContentRow() {
        this.contentRow.setClipToPadding(false);
        this.contentRow.setClipChildren(false);
        FrameLayout frameLayout = this.contentRow;
        int i = this.horizontalPadding;
        frameLayout.setPadding(i, 0, i, 0);
        TextView textView = this.titleView;
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        applyTitleTextStyle(textView);
        setupDetailTitle();
        setupTaskHeader();
        this.contentRow.addView(this.titleView, new FrameLayout.LayoutParams(-1, -1, 17));
        this.contentRow.addView(this.detailTitleContainer, new FrameLayout.LayoutParams(-1, -1, 17));
        this.contentRow.addView(this.segmentedControl, new FrameLayout.LayoutParams(this.segmentWidth, this.pageHeight, 17));
    }

    private final void setupTaskHeader() {
        LinearLayout linearLayout = this.taskTitleContainer;
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(8);
        linearLayout.setClipToPadding(false);
        linearLayout.setClipChildren(false);
        TextView textView = this.taskTitleView;
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        applyTaskTitleTextStyle(textView);
        this.taskTitleContainer.addView(this.taskTitleView, new LinearLayout.LayoutParams(-2, -2));
        AppCompatImageView appCompatImageView = this.taskTitleChevron;
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        appCompatImageView.setVisibility(8);
        LinearLayout linearLayout2 = this.taskTitleContainer;
        View view = (View) this.taskTitleChevron;
        int i = this.taskTitleIconSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.leftMargin = this.taskTitleIconGap;
        Unit unit = Unit.INSTANCE;
        linearLayout2.addView(view, layoutParams);
        this.contentRow.addView(this.taskTitleContainer, new FrameLayout.LayoutParams(-1, -1, 8388627));
        setupTaskOperationIcon();
        setupTaskActionContainer();
        FrameLayout frameLayout = this.contentRow;
        View view2 = (View) this.taskOperationIcon;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.operationWidth, this.operationHeight, 8388629);
        layoutParams2.rightMargin = this.taskActionWidth + this.operationMarginEnd;
        Unit unit2 = Unit.INSTANCE;
        frameLayout.addView(view2, layoutParams2);
        FrameLayout frameLayout2 = this.contentRow;
        FrameLayout frameLayout3 = this.taskActionContainer;
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(this.taskActionWidth + (this.actionShadowBlurRadius * 2), this.actionSize + this.actionShadowPaddingTop + this.actionShadowPaddingBottom, 8388661);
        layoutParams3.topMargin = ((this.taskHeaderHeight - this.actionSize) / 2) - this.actionShadowPaddingTop;
        layoutParams3.rightMargin = -this.actionShadowBlurRadius;
        Unit unit3 = Unit.INSTANCE;
        frameLayout2.addView(frameLayout3, layoutParams3);
        this.contentRow.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.trae.common.widget.TraeTitleBar$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                TraeTitleBar.this.updateTaskTitleMargins();
            }
        });
    }

    private final void setupTaskOperationIcon() {
        SimpleDraweeView simpleDraweeView = this.taskOperationIcon;
        simpleDraweeView.setVisibility(8);
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        simpleDraweeView.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(this.operationRadius));
    }

    private final void setupTaskActionContainer() {
        FrameLayout frameLayout = this.taskActionContainer;
        frameLayout.setVisibility(8);
        frameLayout.setClipToPadding(false);
        frameLayout.setClipChildren(false);
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        frameLayout.setBackground(createTaskActionBackground());
        AppCompatImageButton appCompatImageButton = this.taskSearchButton;
        appCompatImageButton.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageButton.setBackground((Drawable) null);
        appCompatImageButton.setClickable(true);
        appCompatImageButton.setFocusable(true);
        appCompatImageButton.setStateListAnimator((StateListAnimator) null);
        SimpleDraweeView simpleDraweeView = this.taskAvatarView;
        simpleDraweeView.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        simpleDraweeView.getHierarchy().setPlaceholderImage(C0591R.drawable.bg_solo_avatar_placeholder);
        simpleDraweeView.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        FrameLayout frameLayout2 = this.taskAvatarContainer;
        frameLayout2.setClickable(true);
        frameLayout2.setFocusable(true);
        frameLayout2.setClipChildren(false);
        frameLayout2.setClipToPadding(false);
        FrameLayout frameLayout3 = this.taskAvatarContainer;
        View view = (View) this.taskAvatarView;
        int i = this.taskAvatarSize;
        frameLayout3.addView(view, new FrameLayout.LayoutParams(i, i, 17));
        AppCompatImageView appCompatImageView = this.taskAvatarBadge;
        appCompatImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        appCompatImageView.setVisibility(8);
        FrameLayout frameLayout4 = this.taskAvatarContainer;
        View view2 = (View) this.taskAvatarBadge;
        int i2 = this.taskAvatarBadgeSize;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i2, 8388693);
        layoutParams.rightMargin = this.taskAvatarBadgeMarginEnd;
        layoutParams.bottomMargin = this.taskAvatarBadgeMarginBottom;
        Unit unit = Unit.INSTANCE;
        frameLayout4.addView(view2, layoutParams);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setClipToPadding(false);
        linearLayout.setClipChildren(false);
        int i3 = this.taskActionPaddingHorizontal;
        linearLayout.setPadding(i3, 0, i3, 0);
        View view3 = (View) this.taskSearchButton;
        int i4 = this.actionSize;
        linearLayout.addView(view3, new LinearLayout.LayoutParams(i4, i4));
        FrameLayout frameLayout5 = this.taskAvatarContainer;
        int i5 = this.actionSize;
        linearLayout.addView(frameLayout5, new LinearLayout.LayoutParams(i5, i5));
        addShadowContent(this.taskActionContainer, linearLayout, this.taskActionWidth, this.actionSize);
    }

    private final Drawable createTaskActionBackground() {
        int color = ContextCompat.getColor(getContext(), C0591R.color.trae_title_bar_action_bg);
        int color2 = ContextCompat.getColor(getContext(), C0591R.color.trae_title_bar_shadow);
        float f = this.actionSize / 2.0f;
        float f2 = this.actionShadowBlurRadius;
        float f3 = this.actionShadowOffsetY;
        int i = this.actionShadowBlurRadius;
        return new TitleBarActionShadowDrawable(color, color2, f, f2, f3, new Rect(i, this.actionShadowPaddingTop, i, this.actionShadowPaddingBottom));
    }

    private final void setupDetailTitle() {
        LinearLayout linearLayout = this.detailTitleContainer;
        linearLayout.setOrientation(1);
        linearLayout.setGravity(16);
        linearLayout.setVisibility(8);
        linearLayout.setClipToPadding(false);
        linearLayout.setClipChildren(false);
        TextView textView = this.detailTitleView;
        textView.setGravity(8388611);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        applyTitleTextStyle(textView);
        this.detailTitleContainer.addView(this.detailTitleView, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C0591R.dimen.trae_body_body_base_line_height_dp)));
        LinearLayout linearLayout2 = this.detailSubtitleRow;
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        linearLayout2.setClipToPadding(false);
        linearLayout2.setClipChildren(false);
        this.detailSubtitleIcon.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        LinearLayout linearLayout3 = this.detailSubtitleRow;
        View view = (View) this.detailSubtitleIcon;
        int i = this.detailIconSize;
        linearLayout3.addView(view, new LinearLayout.LayoutParams(i, i));
        applySubtitleTextStyle(this.detailSubtitlePrimaryView);
        applySubtitleTextStyle(this.detailSubtitleDotView);
        applySubtitleTextStyle(this.detailSubtitleSecondaryView);
        LinearLayout linearLayout4 = this.detailSubtitleRow;
        TextView textView2 = this.detailSubtitlePrimaryView;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.detailSubtitleGap;
        Unit unit = Unit.INSTANCE;
        linearLayout4.addView(textView2, layoutParams);
        LinearLayout linearLayout5 = this.detailSubtitleRow;
        TextView textView3 = this.detailSubtitleDotView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = this.detailSubtitleGap;
        Unit unit2 = Unit.INSTANCE;
        linearLayout5.addView(textView3, layoutParams2);
        LinearLayout linearLayout6 = this.detailSubtitleRow;
        TextView textView4 = this.detailSubtitleSecondaryView;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, ACTION_ENABLED_ALPHA);
        layoutParams3.leftMargin = this.detailSubtitleGap;
        Unit unit3 = Unit.INSTANCE;
        linearLayout6.addView(textView4, layoutParams3);
        this.detailTitleContainer.addView(this.detailSubtitleRow, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelSize(C0591R.dimen.trae_caption_caption_xs_line_height_dp)));
    }

    private final void applyTitleTextStyle(TextView textView) {
        int i;
        int i2;
        boolean z = this.mediaPreviewAppearance;
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), z ? C0591R.color.trae_special_white : C0591R.color.trae_text_text_default));
        textView.setTypeface(Typeface.create(z ? "sans-serif" : "sans-serif-medium", 0));
        Resources resources = textView.getResources();
        if (z) {
            i = C0591R.dimen.trae_video_preview_title_font_size_sp;
        } else {
            i = C0591R.dimen.trae_body_body_base_font_size_sp;
        }
        textView.setTextSize(0, resources.getDimension(i));
        Resources resources2 = textView.getResources();
        if (z) {
            i2 = C0591R.dimen.trae_video_preview_title_line_height_dp;
        } else {
            i2 = C0591R.dimen.trae_body_body_base_line_height_dp;
        }
        TextViewCompat.setLineHeight(textView, resources2.getDimensionPixelSize(i2));
    }

    private final void applyTaskTitleTextStyle(TextView textView) {
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_text_text_default));
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setLetterSpacing(0.0146f);
        textView.setTextSize(0, textView.getResources().getDimension(C0591R.dimen.trae_heading_heading_2xl_strong_font_size_sp));
        TextViewCompat.setLineHeight(textView, textView.getResources().getDimensionPixelSize(C0591R.dimen.trae_heading_heading_2xl_strong_line_height_dp));
    }

    private final void applySubtitleTextStyle(TextView textView) {
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), C0591R.color.trae_text_text_tertiary));
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setTextSize(0, textView.getResources().getDimension(C0591R.dimen.trae_caption_caption_xs_font_size_sp));
        TextViewCompat.setLineHeight(textView, textView.getResources().getDimensionPixelSize(C0591R.dimen.trae_caption_caption_xs_line_height_dp));
    }

    private final void applyMode() {
        int i;
        this.grabberContainer.setVisibility((this.mode == Mode.SHEET && this.showGrabber) ? 0 : 8);
        this.titleView.setVisibility((this.mode == Mode.PAGE || this.mode == Mode.SHEET) ? 0 : 8);
        this.detailTitleContainer.setVisibility(this.mode == Mode.CONVERSATION_DETAIL ? 0 : 8);
        this.segmentedControl.setVisibility(this.mode != Mode.NEW_CONVERSATION ? 8 : 0);
        syncTaskHeaderVisibility();
        this.contentRow.setLayoutParams(new LinearLayout.LayoutParams(-1, contentHeightForMode()));
        if (this.mode == Mode.SHEET && this.showGrabber) {
            i = this.sheetContentHeight + this.grabberContainerHeight;
        } else if (this.mode == Mode.SHEET) {
            i = this.sheetContentHeight;
        } else {
            i = this.mode == Mode.TASK_LIST ? this.taskHeaderHeight : this.pageHeight;
        }
        setMinimumHeight(i);
        applyImplicitBackground();
        requestLayout();
    }

    private final void applyImplicitBackground() {
        if (this.shouldUseImplicitBackground) {
            GradientDrawable findParentSurfaceBackground = findParentSurfaceBackground();
            if (findParentSurfaceBackground == null) {
                findParentSurfaceBackground = roundedBackground(defaultBackgroundColorRes(), 0.0f);
            }
            setBackground(findParentSurfaceBackground);
        }
    }

    private final Drawable findParentSurfaceBackground() {
        Drawable background;
        Drawable newDrawable;
        Drawable mutate;
        Object parent = getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null || (background = view.getBackground()) == null || isTransparentColor(background)) {
            return null;
        }
        Drawable.ConstantState constantState = background.getConstantState();
        if (constantState != null && (newDrawable = constantState.newDrawable(getResources())) != null && (mutate = newDrawable.mutate()) != null) {
            return mutate;
        }
        Drawable mutate2 = background.mutate();
        Intrinsics.checkNotNullExpressionValue(mutate2, "mutate(...)");
        return mutate2;
    }

    private final boolean isTransparentColor(Drawable drawable) {
        return (drawable instanceof ColorDrawable) && ((ColorDrawable) drawable).getColor() == 0;
    }

    private final int defaultBackgroundColorRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return C0591R.color.trae_bg_bg_base_secondary;
        }
        if (i == 4 || i == 5) {
            return C0591R.color.trae_bg_bg_base_default;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int contentHeightForMode() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 3) {
            return this.taskHeaderHeight;
        }
        if (i == 5) {
            return this.sheetContentHeight;
        }
        return this.pageHeight;
    }

    private final void syncTaskHeaderVisibility() {
        boolean z = this.mode == Mode.TASK_LIST;
        this.taskTitleContainer.setVisibility(z ? 0 : 8);
        this.taskActionContainer.setVisibility(z ? 0 : 8);
        this.taskOperationIcon.setVisibility((z && this.taskOperationVisible) ? 0 : 8);
    }

    private final void allowActionShadowOverflow() {
        ViewParent parent = getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    private final void liftActionOverflowAboveSiblings() {
        setOutlineProvider(EmptyOutlineProvider.INSTANCE);
        if (getZ() < this.actionOverflowDrawOrderZ) {
            setTranslationZ(getTranslationZ() + (this.actionOverflowDrawOrderZ - getZ()));
        }
    }

    private final void rebuildActions() {
        View view = this.leftActionView;
        if (view != null) {
            this.contentRow.removeView(view);
        }
        View view2 = this.rightActionView;
        if (view2 != null) {
            this.contentRow.removeView(view2);
        }
        this.leftActionView = null;
        this.rightActionView = null;
        if (this.mode == Mode.TASK_LIST) {
            updateTaskTitleMargins();
            return;
        }
        if (this.leftAction != Action.NONE) {
            FrameLayout createSingleActionButton = createSingleActionButton(this.leftAction);
            createSingleActionButton.setVisibility(this.leftVisible ? 0 : 4);
            createSingleActionButton.setOnClickListener(this.leftClickListener);
            FrameLayout frameLayout = createSingleActionButton;
            this.contentRow.addView(frameLayout, createActionLayoutParams(this.actionSize, 8388611));
            this.leftActionView = frameLayout;
        }
        if (!this.rightActions.isEmpty()) {
            View createRightActionView = createRightActionView(this.rightActions);
            createRightActionView.setVisibility(this.rightVisible ? 0 : 4);
            this.contentRow.addView(createRightActionView, createActionLayoutParams(rightActionsWidth(this.rightActions), 8388613));
            this.rightActionView = createRightActionView;
        }
        updateTitleMargins();
    }

    private final View createRightActionView(List<? extends Action> actions) {
        if (actions.size() == 1) {
            FrameLayout createSingleActionButton = createSingleActionButton((Action) CollectionsKt.first(actions));
            createSingleActionButton.setOnClickListener((View.OnClickListener) CollectionsKt.getOrNull(this.rightClickListeners, 0));
            return createSingleActionButton;
        }
        int rightActionsWidth = rightActionsWidth(actions);
        FrameLayout createActionShadowContainer = createActionShadowContainer(rightActionsWidth, ContextCompat.getColor(getContext(), C0591R.color.trae_title_bar_action_bg));
        LinearLayout linearLayout = new LinearLayout(createActionShadowContainer.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        linearLayout.setClipToPadding(false);
        linearLayout.setClipChildren(false);
        int i = this.horizontalPadding;
        linearLayout.setPadding(i, 0, i, 0);
        int i2 = 0;
        for (Object obj : actions) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AppCompatImageButton createIconButton = createIconButton((Action) obj, false);
            createIconButton.setTag(actionViewTag(i2));
            createIconButton.setOnClickListener((View.OnClickListener) CollectionsKt.getOrNull(this.rightClickListeners, i2));
            View view = (View) createIconButton;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.iconSize, this.actionSize);
            if (i2 > 0) {
                layoutParams.leftMargin = this.actionGap;
            }
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(view, layoutParams);
            i2 = i3;
        }
        addActionContent(createActionShadowContainer, linearLayout, rightActionsWidth);
        return createActionShadowContainer;
    }

    private final FrameLayout createSingleActionButton(Action action) {
        int color;
        if (action.getPrimary()) {
            color = ContextCompat.getColor(getContext(), C0591R.color.trae_bg_bg_brand);
        } else if (this.mediaPreviewAppearance) {
            color = ColorUtils.setAlphaComponent(ContextCompat.getColor(getContext(), C0591R.color.trae_brand_brand_grey_500), MathKt.roundToInt(51.0f));
        } else {
            color = ContextCompat.getColor(getContext(), C0591R.color.trae_title_bar_action_bg);
        }
        FrameLayout createActionShadowContainer = createActionShadowContainer(this.actionSize, color);
        AppCompatImageButton createIconButton = createIconButton(action, false);
        createIconButton.setTag(actionViewTag(0));
        createIconButton.setClickable(false);
        createIconButton.setFocusable(false);
        Unit unit = Unit.INSTANCE;
        addActionContent(createActionShadowContainer, (View) createIconButton, this.actionSize);
        return createActionShadowContainer;
    }

    private final FrameLayout createActionShadowContainer(int visualWidth, int backgroundColor) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setClipToPadding(false);
        frameLayout.setClipChildren(false);
        frameLayout.setClickable(true);
        frameLayout.setFocusable(true);
        frameLayout.setLayerType(1, null);
        float f = this.actionShadowBlurRadius;
        float f2 = this.actionShadowOffsetY;
        int i = this.actionShadowBlurRadius;
        frameLayout.setBackground(new TitleBarActionShadowDrawable(backgroundColor, ContextCompat.getColor(frameLayout.getContext(), C0591R.color.trae_title_bar_shadow), this.actionSize / 2.0f, f, f2, new Rect(i, this.actionShadowPaddingTop, i, this.actionShadowPaddingBottom)));
        return frameLayout;
    }

    private final void addActionContent(FrameLayout frameLayout, View view, int i) {
        addShadowContent(frameLayout, view, i, this.actionSize);
    }

    private final void addShadowContent(FrameLayout frameLayout, View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = this.actionShadowBlurRadius;
        layoutParams.topMargin = this.actionShadowPaddingTop;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(view, layoutParams);
    }

    private final AppCompatImageButton createIconButton(Action action, boolean withBackground) {
        AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext());
        appCompatImageButton.setScaleType(ImageView.ScaleType.CENTER);
        appCompatImageButton.setImageResource(action.getIconRes());
        if (this.mediaPreviewAppearance) {
            appCompatImageButton.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(appCompatImageButton.getContext(), C0591R.color.trae_special_white)));
        }
        appCompatImageButton.setClickable(true);
        appCompatImageButton.setFocusable(true);
        appCompatImageButton.setStateListAnimator((StateListAnimator) null);
        if (withBackground) {
            appCompatImageButton.setBackground(roundedBackground(action.getPrimary() ? C0591R.color.trae_bg_bg_brand : C0591R.color.trae_title_bar_action_bg, this.actionSize / 2.0f));
        } else {
            appCompatImageButton.setBackground((Drawable) null);
        }
        return appCompatImageButton;
    }

    private final FrameLayout.LayoutParams createActionLayoutParams(int visualWidth, int horizontalGravity) {
        int contentHeightForMode = contentHeightForMode();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(visualWidth + (this.actionShadowBlurRadius * 2), this.actionSize + this.actionShadowPaddingTop + this.actionShadowPaddingBottom, horizontalGravity | 48);
        layoutParams.topMargin = ((contentHeightForMode - this.actionSize) / 2) - this.actionShadowPaddingTop;
        if (horizontalGravity == 8388611) {
            layoutParams.leftMargin = -this.actionShadowBlurRadius;
        } else {
            layoutParams.rightMargin = -this.actionShadowBlurRadius;
        }
        return layoutParams;
    }

    private final String actionViewTag(int index) {
        return "TraeTitleBar.action." + index;
    }

    private final View findActionView(View view, int index) {
        if (view == null) {
            return null;
        }
        if (Intrinsics.areEqual(view.getTag(), actionViewTag(index))) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findActionView = findActionView(viewGroup.getChildAt(i), index);
                if (findActionView != null) {
                    return findActionView;
                }
            }
        }
        return null;
    }

    private final void updateTitleMargins() {
        if (this.mode == Mode.TASK_LIST) {
            updateTaskTitleMargins();
            return;
        }
        int i = this.leftAction != Action.NONE ? this.actionSize : 0;
        int rightActionsWidth = rightActionsWidth(this.rightActions);
        ViewGroup.LayoutParams layoutParams = this.titleView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int max = Math.max(i, rightActionsWidth);
        int i2 = max == 0 ? 0 : max + this.titleSideGap;
        layoutParams2.leftMargin = i2;
        layoutParams2.rightMargin = i2;
        this.titleView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.detailTitleContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        int i3 = this.detailTitleGap + this.actionShadowBlurRadius;
        layoutParams4.leftMargin = i == 0 ? 0 : i + i3;
        layoutParams4.rightMargin = rightActionsWidth != 0 ? rightActionsWidth + i3 : 0;
        this.detailTitleContainer.setLayoutParams(layoutParams4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTaskTitleMargins() {
        ViewGroup.LayoutParams layoutParams = this.taskTitleContainer.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        int i = this.taskActionWidth + (this.taskOperationVisible ? this.operationWidth + this.operationMarginEnd : 0) + this.titleSideGap;
        if (layoutParams2.rightMargin != i) {
            layoutParams2.rightMargin = i;
            this.taskTitleContainer.setLayoutParams(layoutParams2);
        }
        int width = (((this.contentRow.getWidth() - this.contentRow.getPaddingLeft()) - this.contentRow.getPaddingRight()) - i) - (this.taskTitleChevron.getVisibility() == 0 ? this.taskTitleIconSize + this.taskTitleIconGap : 0);
        if (width <= 0 || this.taskTitleView.getMaxWidth() == width) {
            return;
        }
        this.taskTitleView.setMaxWidth(width);
    }

    private final void tintTaskIcon(ImageView imageView) {
        imageView.setColorFilter(ContextCompat.getColor(getContext(), C0591R.color.trae_icon_icon_default));
    }

    private final int rightActionsWidth(List<? extends Action> actions) {
        int size = actions.size();
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            return this.actionSize;
        }
        return (this.horizontalPadding * 2) + (this.iconSize * actions.size()) + (this.actionGap * (actions.size() - 1));
    }

    private final GradientDrawable roundedBackground(int colorRes, float radius) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ContextCompat.getColor(getContext(), colorRes));
        gradientDrawable.setCornerRadius(radius);
        return gradientDrawable;
    }

    private final int dimen(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }

    private final Action actionFromValue(int value) {
        List entries = Action.getEntries();
        boolean z = false;
        if (value >= 0 && value < entries.size()) {
            z = true;
        }
        return (Action) (z ? entries.get(value) : Action.NONE);
    }

    private final View findRightActionClickTarget(int index) {
        if (this.rightActions.size() == 1 && index == 0) {
            return this.rightActionView;
        }
        return findActionView(this.rightActionView, index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TraeTitleBar.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/common/widget/TraeTitleBar$EmptyOutlineProvider;", "Landroid/view/ViewOutlineProvider;", "<init>", "()V", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class EmptyOutlineProvider extends ViewOutlineProvider {
        public static final EmptyOutlineProvider INSTANCE = new EmptyOutlineProvider();

        private EmptyOutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setEmpty();
        }
    }
}
