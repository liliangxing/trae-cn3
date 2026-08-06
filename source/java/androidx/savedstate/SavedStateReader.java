package androidx.savedstate;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.location.LocationRequestCompat;
import androidx.core.os.BundleCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;

/* compiled from: SavedStateReader.android.kt */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010$\n\u0002\b\n\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0001\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\"\u0010 J\u0015\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u0004\u0018\u00010$2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u0004\u0018\u00010+2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u0002022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u0004\u0018\u0001022\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b6\u00107J\u0015\u00108\u001a\u0002092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0004\u0018\u0001092\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b=\u0010>J-\u0010?\u001a\u0002H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bD\u0010EJ$\u0010?\u001a\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bD\u0010FJ/\u0010G\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bH\u0010EJ&\u0010G\u001a\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bH\u0010FJ-\u0010I\u001a\u0002H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bL\u0010MJ$\u0010I\u001a\u0002H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bL\u0010NJ/\u0010O\u001a\u0004\u0018\u0001H@\"\b\b\u0000\u0010@*\u00020J2\u0006\u0010\t\u001a\u00020\n2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\bP\u0010MJ&\u0010O\u001a\u0004\u0018\u0001H@\"\n\b\u0000\u0010@\u0018\u0001*\u00020J2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\bP\u0010NJ\u0015\u0010Q\u001a\u00020R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bS\u0010TJ\u0017\u0010U\u001a\u0004\u0018\u00010R2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bV\u0010TJ\u0015\u0010W\u001a\u00020X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u0004\u0018\u00010X2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\\\u0010ZJ\u001f\u0010]\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b_\u0010`J!\u0010a\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bb\u0010`J\u0015\u0010c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bg\u0010eJ\u001b\u0010h\u001a\b\u0012\u0004\u0012\u0002020i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bj\u0010kJ\u001d\u0010l\u001a\n\u0012\u0004\u0012\u000202\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bm\u0010kJ\u001b\u0010n\u001a\b\u0012\u0004\u0012\u00020\u001e0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bo\u0010kJ\u001d\u0010p\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bq\u0010kJ\u001f\u0010r\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bs\u0010kJ!\u0010t\u001a\u000e\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bu\u0010kJ\u001b\u0010v\u001a\b\u0012\u0004\u0012\u00020\n0i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\bw\u0010kJ\u001d\u0010x\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010i2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\by\u0010kJ3\u0010z\u001a\b\u0012\u0004\u0012\u0002H@0i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b{\u0010|J*\u0010z\u001a\b\u0012\u0004\u0012\u0002H@0i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\b{\u0010kJ5\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0004\b~\u0010|J,\u0010}\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010i\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0004\b~\u0010kJ\u0018\u0010\u007f\u001a\u00030\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0084\u0001\u0010\u0082\u0001J\u0019\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001b\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008a\u0001\u0010\u0088\u0001J\u001e\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J \u0010\u008e\u0001\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u008f\u0001\u0010\u008d\u0001J\u0019\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0091\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0095\u0001\u0010\u0093\u0001J\u0019\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u001b\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u009b\u0001\u0010\u0099\u0001J\u0019\u0010\u009c\u0001\u001a\u00030\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u001b\u0010 \u0001\u001a\u0005\u0018\u00010\u009d\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¡\u0001\u0010\u009f\u0001J\u0019\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u001b\u0010¦\u0001\u001a\u0005\u0018\u00010£\u00012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b§\u0001\u0010¥\u0001J\u001e\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\n0^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b©\u0001\u0010ª\u0001J \u0010«\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010^2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¬\u0001\u0010ª\u0001J6\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u0002H@0^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b®\u0001\u0010¯\u0001J-\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u0002H@0^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b®\u0001\u0010°\u0001J8\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b²\u0001\u0010¯\u0001J/\u0010±\u0001\u001a\n\u0012\u0004\u0012\u0002H@\u0018\u00010^\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b²\u0001\u0010°\u0001J7\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\bµ\u0001\u0010¶\u0001J.\u0010³\u0001\u001a\t\u0012\u0004\u0012\u0002H@0´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\bµ\u0001\u0010·\u0001J9\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\b\b\u0000\u0010@*\u00020A2\u0006\u0010\t\u001a\u00020\n2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H@0C¢\u0006\u0006\b¹\u0001\u0010¶\u0001J0\u0010¸\u0001\u001a\u000b\u0012\u0004\u0012\u0002H@\u0018\u00010´\u0001\"\n\b\u0000\u0010@\u0018\u0001*\u00020A2\u0006\u0010\t\u001a\u00020\nH\u0086\b¢\u0006\u0006\b¹\u0001\u0010·\u0001J\u001c\u0010º\u0001\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b»\u0001\u0010¼\u0001J \u0010½\u0001\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010\t\u001a\u00020\n¢\u0006\u0006\b¾\u0001\u0010¼\u0001J\u0010\u0010¿\u0001\u001a\u000202¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0010¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001J\u0017\u0010Å\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n¢\u0006\u0005\bÆ\u0001\u0010\u0012J\u001a\u0010Ç\u0001\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0005\bÈ\u0001\u0010\u0012J\u001d\u0010É\u0001\u001a\u00020\u00102\u000b\u0010Ê\u0001\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0006\bË\u0001\u0010Ì\u0001J\u0010\u0010Í\u0001\u001a\u000202¢\u0006\u0006\bÎ\u0001\u0010Á\u0001J\u0010\u0010Ï\u0001\u001a\u00020\n¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001f\u0010Ò\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010Ó\u0001¢\u0006\u0006\bÔ\u0001\u0010Õ\u0001J\u001e\u0010Ö\u0001\u001a\u00020\u00102\t\u0010Ê\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b×\u0001\u0010Ø\u0001J\u0013\u0010Ù\u0001\u001a\u000202HÖ\u0001¢\u0006\u0006\bÚ\u0001\u0010Á\u0001J\u0013\u0010Û\u0001\u001a\u00020\nHÖ\u0001¢\u0006\u0006\bÜ\u0001\u0010Ñ\u0001R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006Ý\u0001"}, d2 = {"Landroidx/savedstate/SavedStateReader;", "", "source", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "constructor-impl", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "getBinder", "Landroid/os/IBinder;", "key", "", "getBinder-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/IBinder;", "getBinderOrNull", "getBinderOrNull-impl", "getBoolean", "", "getBoolean-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Z", "getBooleanOrNull", "getBooleanOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "getChar", "", "getChar-impl", "(Landroid/os/Bundle;Ljava/lang/String;)C", "getCharOrNull", "getCharOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Character;", "getCharSequence", "", "getCharSequence-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/CharSequence;", "getCharSequenceOrNull", "getCharSequenceOrNull-impl", "getDouble", "", "getDouble-impl", "(Landroid/os/Bundle;Ljava/lang/String;)D", "getDoubleOrNull", "getDoubleOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Double;", "getFloat", "", "getFloat-impl", "(Landroid/os/Bundle;Ljava/lang/String;)F", "getFloatOrNull", "getFloatOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Float;", "getInt", "", "getInt-impl", "(Landroid/os/Bundle;Ljava/lang/String;)I", "getIntOrNull", "getIntOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "", "getLong-impl", "(Landroid/os/Bundle;Ljava/lang/String;)J", "getLongOrNull", "getLongOrNull-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Long;", "getParcelable", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/os/Parcelable;", "parcelableClass", "Lkotlin/reflect/KClass;", "getParcelable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Parcelable;", "getParcelableOrNull", "getParcelableOrNull-impl", "getJavaSerializable", "Ljava/io/Serializable;", "serializableClass", "getJavaSerializable-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/io/Serializable;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/io/Serializable;", "getJavaSerializableOrNull", "getJavaSerializableOrNull-impl", "getSize", "Landroid/util/Size;", "getSize-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/Size;", "getSizeOrNull", "getSizeOrNull-impl", "getSizeF", "Landroid/util/SizeF;", "getSizeF-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SizeF;", "getSizeFOrNull", "getSizeFOrNull-impl", "getSavedStateArray", "", "getSavedStateArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Bundle;", "getSavedStateArrayOrNull", "getSavedStateArrayOrNull-impl", "getString", "getString-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "getStringOrNull", "getStringOrNull-impl", "getIntList", "", "getIntList-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/util/List;", "getIntListOrNull", "getIntListOrNull-impl", "getCharSequenceList", "getCharSequenceList-impl", "getCharSequenceListOrNull", "getCharSequenceListOrNull-impl", "getSavedStateList", "getSavedStateList-impl", "getSavedStateListOrNull", "getSavedStateListOrNull-impl", "getStringList", "getStringList-impl", "getStringListOrNull", "getStringListOrNull-impl", "getParcelableList", "getParcelableList-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/util/List;", "getParcelableListOrNull", "getParcelableListOrNull-impl", "getBooleanArray", "", "getBooleanArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Z", "getBooleanArrayOrNull", "getBooleanArrayOrNull-impl", "getCharArray", "", "getCharArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[C", "getCharArrayOrNull", "getCharArrayOrNull-impl", "getCharSequenceArray", "getCharSequenceArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/CharSequence;", "getCharSequenceArrayOrNull", "getCharSequenceArrayOrNull-impl", "getDoubleArray", "", "getDoubleArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[D", "getDoubleArrayOrNull", "getDoubleArrayOrNull-impl", "getFloatArray", "", "getFloatArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[F", "getFloatArrayOrNull", "getFloatArrayOrNull-impl", "getIntArray", "", "getIntArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[I", "getIntArrayOrNull", "getIntArrayOrNull-impl", "getLongArray", "", "getLongArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[J", "getLongArrayOrNull", "getLongArrayOrNull-impl", "getStringArray", "getStringArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;)[Ljava/lang/String;", "getStringArrayOrNull", "getStringArrayOrNull-impl", "getParcelableArray", "getParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)[Landroid/os/Parcelable;", "(Landroid/os/Bundle;Ljava/lang/String;)[Landroid/os/Parcelable;", "getParcelableArrayOrNull", "getParcelableArrayOrNull-impl", "getSparseParcelableArray", "Landroid/util/SparseArray;", "getSparseParcelableArray-impl", "(Landroid/os/Bundle;Ljava/lang/String;Lkotlin/reflect/KClass;)Landroid/util/SparseArray;", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/util/SparseArray;", "getSparseParcelableArrayOrNull", "getSparseParcelableArrayOrNull-impl", "getSavedState", "getSavedState-impl", "(Landroid/os/Bundle;Ljava/lang/String;)Landroid/os/Bundle;", "getSavedStateOrNull", "getSavedStateOrNull-impl", "size", "size-impl", "(Landroid/os/Bundle;)I", "isEmpty", "isEmpty-impl", "(Landroid/os/Bundle;)Z", "isNull", "isNull-impl", "contains", "contains-impl", "contentDeepEquals", "other", "contentDeepEquals-impl", "(Landroid/os/Bundle;Landroid/os/Bundle;)Z", "contentDeepHashCode", "contentDeepHashCode-impl", "contentDeepToString", "contentDeepToString-impl", "(Landroid/os/Bundle;)Ljava/lang/String;", "toMap", "", "toMap-impl", "(Landroid/os/Bundle;)Ljava/util/Map;", "equals", "equals-impl", "(Landroid/os/Bundle;Ljava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "toString-impl", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SavedStateReader {
    private final Bundle source;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SavedStateReader m3022boximpl(Bundle bundle) {
        return new SavedStateReader(bundle);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static Bundle m3023constructorimpl(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "source");
        return bundle;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3028equalsimpl(Bundle bundle, Object obj) {
        return (obj instanceof SavedStateReader) && Intrinsics.areEqual(bundle, ((SavedStateReader) obj).getSource());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3029equalsimpl0(Bundle bundle, Bundle bundle2) {
        return Intrinsics.areEqual(bundle, bundle2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3100hashCodeimpl(Bundle bundle) {
        return bundle.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3105toStringimpl(Bundle bundle) {
        return "SavedStateReader(source=" + bundle + ')';
    }

    public boolean equals(Object obj) {
        return m3028equalsimpl(this.source, obj);
    }

    public int hashCode() {
        return m3100hashCodeimpl(this.source);
    }

    public String toString() {
        return m3105toStringimpl(this.source);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ Bundle getSource() {
        return this.source;
    }

    private /* synthetic */ SavedStateReader(Bundle bundle) {
        this.source = bundle;
    }

    /* renamed from: getBinder-impl, reason: not valid java name */
    public static final IBinder m3030getBinderimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        IBinder binder = bundle.getBinder(str);
        if (binder != null) {
            return binder;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getBinderOrNull-impl, reason: not valid java name */
    public static final IBinder m3031getBinderOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getBinder(str);
    }

    /* renamed from: getBoolean-impl, reason: not valid java name */
    public static final boolean m3032getBooleanimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        boolean z = bundle.getBoolean(str, false);
        if (z || !bundle.getBoolean(str, true)) {
            return z;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getBooleanOrNull-impl, reason: not valid java name */
    public static final Boolean m3035getBooleanOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        boolean z = bundle.getBoolean(str, false);
        if (!z) {
            if (bundle.getBoolean(str, true)) {
                return null;
            }
        }
        return Boolean.valueOf(z);
    }

    /* renamed from: getChar-impl, reason: not valid java name */
    public static final char m3036getCharimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        char c = bundle.getChar(str, (char) 0);
        if (c != 0 || bundle.getChar(str, (char) 65535) != 65535) {
            return c;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getCharOrNull-impl, reason: not valid java name */
    public static final Character m3039getCharOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        char c = bundle.getChar(str, (char) 0);
        if (c == 0 && bundle.getChar(str, (char) 65535) == 65535) {
            return null;
        }
        return Character.valueOf(c);
    }

    /* renamed from: getCharSequence-impl, reason: not valid java name */
    public static final CharSequence m3040getCharSequenceimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        CharSequence charSequence = bundle.getCharSequence(str);
        if (charSequence != null) {
            return charSequence;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getCharSequenceOrNull-impl, reason: not valid java name */
    public static final CharSequence m3045getCharSequenceOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getCharSequence(str);
    }

    /* renamed from: getDouble-impl, reason: not valid java name */
    public static final double m3046getDoubleimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        double d = bundle.getDouble(str, Double.MIN_VALUE);
        if (d == Double.MIN_VALUE) {
            if (bundle.getDouble(str, Double.MAX_VALUE) == Double.MAX_VALUE) {
                SavedStateReaderKt.keyOrValueNotFoundError(str);
                throw new KotlinNothingValueException();
            }
        }
        return d;
    }

    /* renamed from: getDoubleOrNull-impl, reason: not valid java name */
    public static final Double m3049getDoubleOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        double d = bundle.getDouble(str, Double.MIN_VALUE);
        if (d == Double.MIN_VALUE) {
            if (bundle.getDouble(str, Double.MAX_VALUE) == Double.MAX_VALUE) {
                return null;
            }
        }
        return Double.valueOf(d);
    }

    /* renamed from: getFloat-impl, reason: not valid java name */
    public static final float m3050getFloatimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        float f = bundle.getFloat(str, Float.MIN_VALUE);
        if (f == Float.MIN_VALUE) {
            if (bundle.getFloat(str, Float.MAX_VALUE) == Float.MAX_VALUE) {
                SavedStateReaderKt.keyOrValueNotFoundError(str);
                throw new KotlinNothingValueException();
            }
        }
        return f;
    }

    /* renamed from: getFloatOrNull-impl, reason: not valid java name */
    public static final Float m3053getFloatOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        float f = bundle.getFloat(str, Float.MIN_VALUE);
        if (f == Float.MIN_VALUE) {
            if (bundle.getFloat(str, Float.MAX_VALUE) == Float.MAX_VALUE) {
                return null;
            }
        }
        return Float.valueOf(f);
    }

    /* renamed from: getInt-impl, reason: not valid java name */
    public static final int m3054getIntimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int i = bundle.getInt(str, Integer.MIN_VALUE);
        if (i != Integer.MIN_VALUE || bundle.getInt(str, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
            return i;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getIntOrNull-impl, reason: not valid java name */
    public static final Integer m3059getIntOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int i = bundle.getInt(str, Integer.MIN_VALUE);
        if (i == Integer.MIN_VALUE && bundle.getInt(str, Integer.MAX_VALUE) == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(i);
    }

    /* renamed from: getLong-impl, reason: not valid java name */
    public static final long m3064getLongimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j != Long.MIN_VALUE || bundle.getLong(str, LocationRequestCompat.PASSIVE_INTERVAL) != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getLongOrNull-impl, reason: not valid java name */
    public static final Long m3067getLongOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        long j = bundle.getLong(str, Long.MIN_VALUE);
        if (j == Long.MIN_VALUE && bundle.getLong(str, LocationRequestCompat.PASSIVE_INTERVAL) == LocationRequestCompat.PASSIVE_INTERVAL) {
            return null;
        }
        return Long.valueOf(j);
    }

    /* renamed from: getParcelable-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m3069getParcelableimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        T t = (T) BundleCompat.getParcelable(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
        if (t != null) {
            return t;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getParcelable-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m3068getParcelableimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m3069getParcelableimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T m3079getParcelableOrNullimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        return (T) BundleCompat.getParcelable(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
    }

    /* renamed from: getParcelableOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T m3078getParcelableOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m3079getParcelableOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final <T extends Serializable> T m3061getJavaSerializableimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "serializableClass");
        T t = (T) BundleCompat.getSerializable(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
        if (t != null) {
            return t;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getJavaSerializable-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m3060getJavaSerializableimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m3061getJavaSerializableimpl(bundle, str, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    /* renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final <T extends Serializable> T m3063getJavaSerializableOrNullimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "serializableClass");
        return (T) BundleCompat.getSerializable(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
    }

    /* renamed from: getJavaSerializableOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Serializable> T m3062getJavaSerializableOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) m3063getJavaSerializableOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Serializable.class));
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static final Size m3086getSizeimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Size size = bundle.getSize(str);
        if (size != null) {
            return size;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getSizeOrNull-impl, reason: not valid java name */
    public static final Size m3089getSizeOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getSize(str);
    }

    /* renamed from: getSizeF-impl, reason: not valid java name */
    public static final SizeF m3087getSizeFimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        SizeF sizeF = bundle.getSizeF(str);
        if (sizeF != null) {
            return sizeF;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getSizeFOrNull-impl, reason: not valid java name */
    public static final SizeF m3088getSizeFOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getSizeF(str);
    }

    /* renamed from: getString-impl, reason: not valid java name */
    public static final String m3094getStringimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String string = bundle.getString(str);
        if (string != null) {
            return string;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getStringOrNull-impl, reason: not valid java name */
    public static final String m3099getStringOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getString(str);
    }

    /* renamed from: getIntList-impl, reason: not valid java name */
    public static final List<Integer> m3057getIntListimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getIntListOrNull-impl, reason: not valid java name */
    public static final List<Integer> m3058getIntListOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getIntegerArrayList(str);
    }

    /* renamed from: getCharSequenceList-impl, reason: not valid java name */
    public static final List<CharSequence> m3043getCharSequenceListimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ArrayList<CharSequence> charSequenceArrayList = bundle.getCharSequenceArrayList(str);
        if (charSequenceArrayList != null) {
            return charSequenceArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getCharSequenceListOrNull-impl, reason: not valid java name */
    public static final List<CharSequence> m3044getCharSequenceListOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getCharSequenceArrayList(str);
    }

    /* renamed from: getStringList-impl, reason: not valid java name */
    public static final List<String> m3097getStringListimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        ArrayList<String> stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList != null) {
            return stringArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getStringListOrNull-impl, reason: not valid java name */
    public static final List<String> m3098getStringListOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getStringArrayList(str);
    }

    /* renamed from: getParcelableList-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m3075getParcelableListimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        ArrayList parcelableArrayList = BundleCompat.getParcelableArrayList(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
        if (parcelableArrayList != null) {
            return parcelableArrayList;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getParcelableList-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m3074getParcelableListimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m3075getParcelableListimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> List<T> m3077getParcelableListOrNullimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        return BundleCompat.getParcelableArrayList(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
    }

    /* renamed from: getParcelableListOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> List<T> m3076getParcelableListOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m3077getParcelableListOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getBooleanArray-impl, reason: not valid java name */
    public static final boolean[] m3033getBooleanArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        boolean[] booleanArray = bundle.getBooleanArray(str);
        if (booleanArray != null) {
            return booleanArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getBooleanArrayOrNull-impl, reason: not valid java name */
    public static final boolean[] m3034getBooleanArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getBooleanArray(str);
    }

    /* renamed from: getCharArray-impl, reason: not valid java name */
    public static final char[] m3037getCharArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        char[] charArray = bundle.getCharArray(str);
        if (charArray != null) {
            return charArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getCharArrayOrNull-impl, reason: not valid java name */
    public static final char[] m3038getCharArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getCharArray(str);
    }

    /* renamed from: getCharSequenceArray-impl, reason: not valid java name */
    public static final CharSequence[] m3041getCharSequenceArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(str);
        if (charSequenceArray != null) {
            return charSequenceArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getCharSequenceArrayOrNull-impl, reason: not valid java name */
    public static final CharSequence[] m3042getCharSequenceArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getCharSequenceArray(str);
    }

    /* renamed from: getDoubleArray-impl, reason: not valid java name */
    public static final double[] m3047getDoubleArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        double[] doubleArray = bundle.getDoubleArray(str);
        if (doubleArray != null) {
            return doubleArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getDoubleArrayOrNull-impl, reason: not valid java name */
    public static final double[] m3048getDoubleArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getDoubleArray(str);
    }

    /* renamed from: getFloatArray-impl, reason: not valid java name */
    public static final float[] m3051getFloatArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        float[] floatArray = bundle.getFloatArray(str);
        if (floatArray != null) {
            return floatArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getFloatArrayOrNull-impl, reason: not valid java name */
    public static final float[] m3052getFloatArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getFloatArray(str);
    }

    /* renamed from: getIntArray-impl, reason: not valid java name */
    public static final int[] m3055getIntArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        int[] intArray = bundle.getIntArray(str);
        if (intArray != null) {
            return intArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getIntArrayOrNull-impl, reason: not valid java name */
    public static final int[] m3056getIntArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getIntArray(str);
    }

    /* renamed from: getLongArray-impl, reason: not valid java name */
    public static final long[] m3065getLongArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        long[] longArray = bundle.getLongArray(str);
        if (longArray != null) {
            return longArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getLongArrayOrNull-impl, reason: not valid java name */
    public static final long[] m3066getLongArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getLongArray(str);
    }

    /* renamed from: getStringArray-impl, reason: not valid java name */
    public static final String[] m3095getStringArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String[] stringArray = bundle.getStringArray(str);
        if (stringArray != null) {
            return stringArray;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getStringArrayOrNull-impl, reason: not valid java name */
    public static final String[] m3096getStringArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getStringArray(str);
    }

    /* renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m3071getParcelableArrayimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        T[] tArr = (T[]) m3073getParcelableArrayOrNullimpl(bundle, str, kClass);
        if (tArr != null) {
            return tArr;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getParcelableArray-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m3070getParcelableArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) m3071getParcelableArrayimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> T[] m3073getParcelableArrayOrNullimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        T[] tArr = (T[]) BundleCompat.getParcelableArray(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
        if (tArr instanceof Parcelable[]) {
            return tArr;
        }
        return null;
    }

    /* renamed from: getParcelableArrayOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> T[] m3072getParcelableArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T[]) m3073getParcelableArrayOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m3091getSparseParcelableArrayimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        SparseArray<T> m3093getSparseParcelableArrayOrNullimpl = m3093getSparseParcelableArrayOrNullimpl(bundle, str, kClass);
        if (m3093getSparseParcelableArrayOrNullimpl != null) {
            return m3093getSparseParcelableArrayOrNullimpl;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getSparseParcelableArray-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m3090getSparseParcelableArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m3091getSparseParcelableArrayimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final <T extends Parcelable> SparseArray<T> m3093getSparseParcelableArrayOrNullimpl(Bundle bundle, String str, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "parcelableClass");
        return BundleCompat.getSparseParcelableArray(bundle, str, JvmClassMappingKt.getJavaClass(kClass));
    }

    /* renamed from: getSparseParcelableArrayOrNull-impl, reason: not valid java name */
    public static final /* synthetic */ <T extends Parcelable> SparseArray<T> m3092getSparseParcelableArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return m3093getSparseParcelableArrayOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Parcelable.class));
    }

    /* renamed from: getSavedState-impl, reason: not valid java name */
    public static final Bundle m3080getSavedStateimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        SavedStateReaderKt.keyOrValueNotFoundError(str);
        throw new KotlinNothingValueException();
    }

    /* renamed from: getSavedStateOrNull-impl, reason: not valid java name */
    public static final Bundle m3085getSavedStateOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.getBundle(str);
    }

    /* renamed from: size-impl, reason: not valid java name */
    public static final int m3103sizeimpl(Bundle bundle) {
        return bundle.size();
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m3101isEmptyimpl(Bundle bundle) {
        return bundle.isEmpty();
    }

    /* renamed from: isNull-impl, reason: not valid java name */
    public static final boolean m3102isNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return m3024containsimpl(bundle, str) && bundle.get(str) == null;
    }

    /* renamed from: contains-impl, reason: not valid java name */
    public static final boolean m3024containsimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return bundle.containsKey(str);
    }

    /* renamed from: contentDeepEquals-impl, reason: not valid java name */
    public static final boolean m3025contentDeepEqualsimpl(Bundle bundle, Bundle bundle2) {
        boolean contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt;
        Intrinsics.checkNotNullParameter(bundle2, "other");
        contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt = SavedStateReaderKt__SavedStateReader_androidKt.contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt(bundle, bundle2);
        return contentDeepEquals$SavedStateReaderKt__SavedStateReader_androidKt;
    }

    /* renamed from: contentDeepHashCode-impl, reason: not valid java name */
    public static final int m3026contentDeepHashCodeimpl(Bundle bundle) {
        int m76x4f1a1420;
        m76x4f1a1420 = SavedStateReaderKt__SavedStateReader_androidKt.m76x4f1a1420(bundle);
        return m76x4f1a1420;
    }

    /* renamed from: contentDeepToString-impl, reason: not valid java name */
    public static final String m3027contentDeepToStringimpl(Bundle bundle) {
        StringBuilder sb = new StringBuilder((RangesKt.coerceAtMost(bundle.size(), 429496729) * 5) + 2);
        SavedStateReaderKt__SavedStateReader_androidKt.m77x56e5e5af(bundle, sb, new ArrayList());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* renamed from: toMap-impl, reason: not valid java name */
    public static final Map<String, Object> m3104toMapimpl(Bundle bundle) {
        Map createMapBuilder = MapsKt.createMapBuilder(bundle.size());
        for (String str : bundle.keySet()) {
            Intrinsics.checkNotNull(str);
            createMapBuilder.put(str, bundle.get(str));
        }
        return MapsKt.build(createMapBuilder);
    }

    /* renamed from: getSavedStateArray-impl, reason: not valid java name */
    public static final Bundle[] m3081getSavedStateArrayimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Bundle[]) m3071getParcelableArrayimpl(bundle, str, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* renamed from: getSavedStateArrayOrNull-impl, reason: not valid java name */
    public static final Bundle[] m3082getSavedStateArrayOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Bundle[]) m3073getParcelableArrayOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* renamed from: getSavedStateList-impl, reason: not valid java name */
    public static final List<Bundle> m3083getSavedStateListimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return m3075getParcelableListimpl(bundle, str, Reflection.getOrCreateKotlinClass(Bundle.class));
    }

    /* renamed from: getSavedStateListOrNull-impl, reason: not valid java name */
    public static final List<Bundle> m3084getSavedStateListOrNullimpl(Bundle bundle, String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return m3077getParcelableListOrNullimpl(bundle, str, Reflection.getOrCreateKotlinClass(Bundle.class));
    }
}
