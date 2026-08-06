package com.lynx.tasm.behavior;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class XElementBehavior implements BehaviorBundle {
    public static final HashSet<String> GENERATOR_FILE_NAME_SETS = new HashSet<String>() { // from class: com.lynx.tasm.behavior.XElementBehavior.1
        {
            add("com.bytedance.ies.xelement.audio");
            add("com.bytedance.ies.xelement.audiott");
            add("com.lynx.tasm.behavior.ui.swiper");
            add("com.bytedance.ies.xelement.alphavideo");
            add("com.bytedance.ies.xelement.banner");
            add("com.bytedance.ies.xelement.blockevent");
            add("com.bytedance.ies.xelement.bytedlottie");
            add("com.bytedance.ies.xelement.input");
            add("com.bytedance.ies.xelement.nested.scrollview");
            add("com.bytedance.ies.xelement.overlay");
            add("com.bytedance.ies.xelement.overlay.ng");
            add("com.bytedance.ies.xelement.viewpager.childitem");
            add("com.lynx.maskimage.ui");
            add("com.bytedance.ies.xelement.nested.scrollview");
            add("com.bytedance.ies.xelement.picker");
            add("com.bytedance.ies.xelement.pickview");
            add("com.bytedance.ies.xelement.pullrefreshlite");
            add("com.bytedance.ies.xelement.refresh");
            add("com.bytedance.ies.xelement.scroll");
            add("com.lynx.component.svg");
            add("com.bytedance.ies.xelement.text.text");
            add("com.bytedance.ies.xelement.video.pro");
            add("com.bytedance.ies.xelement.video");
            add("com.bytedance.ies.xelement.live");
            add("com.bytedance.ies.xelement.blur");
            add("com.bytedance.ies.xelement.markdown");
            add("com.bytedance.lynx.map.ng");
            add("com.bytedance.lynx.media");
            add("com.bytedance.ies.xelement.webview.api");
            add("com.lynx.xelement.input");
        }
    };
    private static final String TAG = "XElementBehavior";
    private static volatile List<Behavior> sCacheBehaviors;

    @Override // com.lynx.tasm.behavior.BehaviorBundle
    public List<Behavior> create() {
        synchronized (XElementBehavior.class) {
            if (sCacheBehaviors != null && !sCacheBehaviors.isEmpty()) {
                return new ArrayList(sCacheBehaviors);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = GENERATOR_FILE_NAME_SETS.iterator();
            while (it.hasNext()) {
                arrayList.addAll(getModuleBehaviors(it.next()));
            }
            sCacheBehaviors = arrayList;
            return new ArrayList(arrayList);
        }
    }

    private List<Behavior> getModuleBehaviors(String str) {
        try {
            return (List) Class.forName(str + ".BehaviorGenerator").getMethod("getBehaviors", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }
}
