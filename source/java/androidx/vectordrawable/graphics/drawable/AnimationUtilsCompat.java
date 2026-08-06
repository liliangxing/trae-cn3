package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.core.util.ObjectsCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class AnimationUtilsCompat {
    public static Interpolator loadInterpolator(Context context, int i) throws Resources.NotFoundException {
        Interpolator loadInterpolator = AnimationUtils.loadInterpolator(context, i);
        ObjectsCompat.requireNonNull(loadInterpolator, "Failed to parse interpolator, no start tag found");
        return loadInterpolator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0105, code lost:
    
        throw new java.lang.RuntimeException("Failed to parse interpolator, no start tag found");
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x007b, code lost:
    
        if (r2.equals("accelerateInterpolator") == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x00fb, code lost:
    
        if (r1 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x00fd, code lost:
    
        return r1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:20:0x009e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Interpolator createInterpolatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator pathInterpolatorCompat;
        int depth = xmlPullParser.getDepth();
        Interpolator interpolator = null;
        while (true) {
            int next = xmlPullParser.next();
            char c = 3;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    String name = xmlPullParser.getName();
                    name.hashCode();
                    switch (name.hashCode()) {
                        case -2140409460:
                            if (name.equals("pathInterpolator")) {
                                c = 0;
                                break;
                            }
                            break;
                        case -2120889007:
                            if (name.equals("anticipateInterpolator")) {
                                c = 1;
                                break;
                            }
                            break;
                        case -1248486260:
                            if (name.equals("linearInterpolator")) {
                                c = 2;
                                break;
                            }
                            break;
                        case -935873468:
                            break;
                        case -425326737:
                            if (name.equals("bounceInterpolator")) {
                                c = 4;
                                break;
                            }
                            break;
                        case 1192587314:
                            if (name.equals("overshootInterpolator")) {
                                c = 5;
                                break;
                            }
                            break;
                        case 1472030440:
                            if (name.equals("anticipateOvershootInterpolator")) {
                                c = 6;
                                break;
                            }
                            break;
                        case 1962594083:
                            if (name.equals("decelerateInterpolator")) {
                                c = 7;
                                break;
                            }
                            break;
                        case 2019672672:
                            if (name.equals("accelerateDecelerateInterpolator")) {
                                c = '\b';
                                break;
                            }
                            break;
                        case 2038238413:
                            if (name.equals("cycleInterpolator")) {
                                c = '\t';
                                break;
                            }
                            break;
                    }
                    c = 65535;
                    switch (c) {
                        case 0:
                            pathInterpolatorCompat = new PathInterpolatorCompat(context, asAttributeSet, xmlPullParser);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case 1:
                            pathInterpolatorCompat = new AnticipateInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case 2:
                            interpolator = new LinearInterpolator();
                            break;
                        case 3:
                            pathInterpolatorCompat = new AccelerateInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case 4:
                            interpolator = new BounceInterpolator();
                            break;
                        case 5:
                            pathInterpolatorCompat = new OvershootInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case 6:
                            pathInterpolatorCompat = new AnticipateOvershootInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case 7:
                            pathInterpolatorCompat = new DecelerateInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        case '\b':
                            interpolator = new AccelerateDecelerateInterpolator();
                            break;
                        case '\t':
                            pathInterpolatorCompat = new CycleInterpolator(context, asAttributeSet);
                            interpolator = pathInterpolatorCompat;
                            break;
                        default:
                            throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                    }
                }
            }
        }
    }

    private AnimationUtilsCompat() {
    }
}
