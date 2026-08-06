package com.bytedance.tobshadow.applog.util;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.tobshadow.applog.log.IAppLogLogger;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.AbstractC0479n4;
import com.bytedance.tobshadow.bdtracker.C0380a;
import com.bytedance.tobshadow.bdtracker.C0445i5;
import com.bytedance.tobshadow.bdtracker.C0453k;
import com.bytedance.tobshadow.bdtracker.C0467m;
import com.bytedance.tobshadow.bdtracker.C0528u4;
import com.bytedance.tracing.log.Fields;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class WebViewJsUtil {
    public static final String BUNDLE_WEB_INFO = "web_info";
    public static final String EMPTY_PAGE = "about:blank";
    public static final String JS_CODE_COLLECT = "!function(){\"use strict\";function t(t,e){if(!(t instanceof e))throw new TypeError(\"Cannot call a class as a function\")}function e(t,e){for(var n=0;n<e.length;n++){var r=e[n];r.enumerable=r.enumerable||!1,r.configurable=!0,\"value\"in r&&(r.writable=!0),Object.defineProperty(t,r.key,r)}}function n(t,n,r){return n&&e(t.prototype,n),r&&e(t,r),Object.defineProperty(t,\"prototype\",{writable:!1}),t}function r(t,e){if(\"function\"!=typeof e&&null!==e)throw new TypeError(\"Super expression must either be null or a function\");t.prototype=Object.create(e&&e.prototype,{constructor:{value:t,writable:!0,configurable:!0}}),Object.defineProperty(t,\"prototype\",{writable:!1}),e&&o(t,e)}function i(t){return i=Object.setPrototypeOf?Object.getPrototypeOf.bind():function(t){return t.__proto__||Object.getPrototypeOf(t)},i(t)}function o(t,e){return o=Object.setPrototypeOf?Object.setPrototypeOf.bind():function(t,e){return t.__proto__=e,t},o(t,e)}function a(t,e){if(e&&(\"object\"==typeof e||\"function\"==typeof e))return e;if(void 0!==e)throw new TypeError(\"Derived constructors may only return object or undefined\");return function(t){if(void 0===t)throw new ReferenceError(\"this hasn't been initialised - super() hasn't been called\");return t}(t)}function u(t){var e=function(){if(\"undefined\"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if(\"function\"==typeof Proxy)return!0;try{return Boolean.prototype.valueOf.call(Reflect.construct(Boolean,[],(function(){}))),!0}catch(t){return!1}}();return function(){var n,r=i(t);if(e){var o=i(this).constructor;n=Reflect.construct(r,arguments,o)}else n=r.apply(this,arguments);return a(this,n)}}function c(t,e){for(;!Object.prototype.hasOwnProperty.call(t,e)&&null!==(t=i(t)););return t}function s(){return s=\"undefined\"!=typeof Reflect&&Reflect.get?Reflect.get.bind():function(t,e,n){var r=c(t,e);if(!r)return;var i=Object.getOwnPropertyDescriptor(r,e);if(i.get)return i.get.call(arguments.length<3?t:n);return i.value},s.apply(this,arguments)}function l(t){if([\"LI\",\"TR\",\"DL\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaIdx\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-idx\"))return!0;return!1}function h(t){if(!t)return!1;if([\"A\",\"BUTTON\"].includes(t.nodeName))return!0;if(t.dataset&&t.dataset.hasOwnProperty(\"teaContainer\"))return!0;if(t.hasAttribute&&t.hasAttribute(\"data-tea-container\"))return!0;return!1}function f(t){for(var e=t;e&&!h(e);){if(\"HTML\"===e.nodeName||\"BODY\"===e.nodeName)return t;e=e.parentElement}return e||t}function d(t){for(var e=[];null!==t.parentElement;)e.push(t),t=t.parentElement;var n=[],r=[];return e.forEach((function(t){var e=function(t){if(null===t)return{str:\"\",index:0};var e=0,n=t.parentElement;if(n)for(var r=0;r<n.children.length&&n.children[r]!==t;r++)n.children[r].nodeName===t.nodeName&&e++;return{str:[t.nodeName.toLowerCase(),l(t)?\"[]\":\"\"].join(\"\"),index:e}}(t),i=e.str,o=e.index;n.unshift(i),r.unshift(o)})),{element_path:\"/\".concat(n.join(\"/\")),positions:r}}function p(t){var e={element_path:\"\",positions:[],texts:[]},n=d(t),r=n.element_path,i=n.positions,o=function(t){var e=f(t),n=[];return!function t(e){var r=function(t){var e=\"\";if(3===t.nodeType?e=t.textContent.trim():t.dataset&&t.dataset.hasOwnProperty(\"teaTitle\")||t.hasAttribute(\"data-tea-title\")?e=t.getAttribute(\"data-tea-title\"):t.hasAttribute(\"title\")?e=t.getAttribute(\"title\"):\"INPUT\"===t.nodeName&&[\"button\",\"submit\"].includes(t.getAttribute(\"type\"))?e=t.getAttribute(\"value\"):\"IMG\"===t.nodeName&&t.getAttribute(\"alt\")&&(e=t.getAttribute(\"alt\")),!e)return\"\";return e.slice(0,200)}(e);if(r&&-1===n.indexOf(r)&&n.push(r),e.childNodes.length>0)for(var i=e.childNodes,o=0;o<i.length;o++)8!==i[o].nodeType&&t(i[o])}(e),n}(t);e.element_path=r,e.positions=i.map((function(t){return\"\".concat(t)})),e.texts=o;var a=f(t);if(\"A\"===a.tagName&&(e.href=a.getAttribute(\"href\")),\"IMG\"===t.tagName){var u=t.getAttribute(\"src\");u&&0===u.trim().indexOf(\"data:\")&&(u=\"\"),e.src=u}return e.page_title=document.title,e.element_id=t.id,e.element_type=t.tagName,e}var v=function(){function e(n,r){var i=this;t(this,e),this.handler=function(t){var e=(t=i.getEvent(t)).target;if(!i.checkShouldTrackElement(e)||i.checkShouldIgnore(e))return;var n=i.getPositionData(e),r=i.getEventData(t,n),o=i.getElementData(e),a=i.getAllData(r,o,{element_width:Math.floor(n.element_width),element_height:Math.floor(n.element_height)});i.report(a)},this.info=n,this.autoTrack=r,this.listen()}return n(e,[{key:\"listen\",value:function(){this.autoTrack.root.addEventListener(this.info.eventType,this.handler,!0)}},{key:\"_checkShouldTrackElement\",value:function(t){return function(t){var e=window.innerHeight,n=window.innerWidth;if(1!==t.nodeType)return!1;if(function(t){for(var e=t.parentElement,n=!1;e;)\"svg\"===e.tagName.toLowerCase()?(e=null,n=!0):e=e.parentElement;return n}(t))return!1;if([\"HTML\",\"BODY\"].includes(t.tagName.toUpperCase()))return!1;var r=t;if(\"none\"===r.style.display)return!1;if(h(r))return!0;if(!function(t){if(t.children.length>0){var e=t.children;if([].slice.call(e).some((function(t){return t.children.length>0})))return!1;return!0}return!0}(r))return!1;if(r.clientHeight*r.clientWidth>.5*e*n)return!1;return!0}(t)}},{key:\"checkShouldTrackElement\",value:function(t){return!0}},{key:\"checkShouldIgnore\",value:function(t){return function(t){for(var e=t;e&&e.parentNode;){if(e.hasAttribute(\"data-tea-ignore\"))return!0;if(\"HTML\"===e.nodeName||\"body\"===e.nodeName)return!1;e=e.parentNode}return!1}(t)}},{key:\"getEvent\",value:function(t){return t}},{key:\"getEventData\",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=t.clientX,r=t.clientY,i=e.left,o=e.top;return{touch_x:Math.floor(n-i),touch_y:Math.floor(r-o)}}},{key:\"getElementData\",value:function(t){return p(t)}},{key:\"getPositionData\",value:function(t){if(!t)return;var e=t.getBoundingClientRect(),n=e.width,r=e.height;return{left:e.left,top:e.top,element_width:n,element_height:r}}},{key:\"getAllData\",value:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{},n=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{};return Object.assign(Object.assign(Object.assign(Object.assign({},t),e),n),{is_html:1,page_key:window.location.href})}},{key:\"report\",value:function(t){this.autoTrack.report(this.info.eventName,t)}},{key:\"destroy\",value:function(){this.autoTrack.root.removeEventListener(this.info.eventName,this.handler,!0),this.autoTrack=null}}]),e}(),y=function(e){r(a,e);var o=u(a);function a(e){var n;t(this,a),(n=o.call(this,{eventName:\"bav2b_page\"},e)).handler=function(t){if(n.checkHref())return;n._handler()},n._handler=function(){n.setHref();var t=n.getAllData();n.report(t)},n._listen();try{\"loading\"===document.readyState?document.addEventListener(\"DOMContentLoaded\",n._handler):setTimeout(n._handler)}catch(t){}return n}return n(a,[{key:\"listen\",value:function(){}},{key:\"_listen\",value:function(){var t=this;this._oldPushState=history.pushState,this._oldReplaceState=history.replaceState,history.pushState=function(){try{for(var e,n=arguments.length,r=new Array(n),i=0;i<n;i++)r[i]=arguments[i];return(e=t._oldPushState).call.apply(e,[history].concat(r))}finally{t._handler()}},history.replaceState=function(){try{for(var e,n=arguments.length,r=new Array(n),i=0;i<n;i++)r[i]=arguments[i];return(e=t._oldReplaceState).call.apply(e,[history].concat(r))}finally{t._handler()}},window.addEventListener(\"hashchange\",this.handler,!0),window.addEventListener(\"popstate\",this.handler,!0)}},{key:\"setHref\",value:function(t){this._currentHref=t||window.location.href}},{key:\"checkHref\",value:function(){return this._currentHref===window.location.href}},{key:\"getAllData\",value:function(){return Object.assign(Object.assign({},s(i(a.prototype),\"getAllData\",this).call(this)),{is_bav:1,page_key:this._currentHref,refer_page_key:document.referrer,page_title:document.title,page_path:this._currentHref,referrer_page_path:document.referrer})}},{key:\"destroy\",value:function(){window.removeEventListener(\"popstate\",this.handler,!0),window.removeEventListener(\"hashchange\",this.handler,!0),history.pushState=this._oldPushState,history.replaceState=this._oldReplaceState,this._oldPushState=null,this._oldReplaceState=null,this.autoTrack=null}}]),a}(v),g=function(e){r(a,e);var o=u(a);function a(e){return t(this,a),o.call(this,{eventType:\"click\",eventName:\"bav2b_click\"},e)}return n(a,[{key:\"checkShouldTrackElement\",value:function(t){return s(i(a.prototype),\"_checkShouldTrackElement\",this).call(this,t)}}]),a}(v),m=function(e){r(a,e);var o=u(a);function a(e){var n;return t(this,a),(n=o.call(this,{eventName:\"bav2b_click\"},e)).startHandler=function(t){var e=n.autoTrack.root,r=!1,i=function(){r=!0};e.addEventListener(\"touchmove\",i,!0),e.addEventListener(\"touchend\",(function t(o){r||n.handler(o),e.removeEventListener(\"touchmove\",i,!0),e.removeEventListener(\"touchend\",t,!0)}),!0)},n._listen(),n}return n(a,[{key:\"listen\",value:function(){}},{key:\"_listen\",value:function(){this.autoTrack.root.addEventListener(\"touchstart\",this.startHandler,!0)}},{key:\"getEvent\",value:function(t){return t.changedTouches[0]}},{key:\"checkShouldTrackElement\",value:function(t){if(!s(i(a.prototype),\"_checkShouldTrackElement\",this).call(this,t))return!1;if(\"input\"===t.nodeName.toLowerCase()&&[\"text\",\"password\",\"email\",\"tel\",\"number\",\"url\"].includes(t.type))return!1;return!0}},{key:\"destroy\",value:function(){this.autoTrack.root.removeEventListener(\"touchstart\",this.startHandler,!0),this.autoTrack=null}}]),a}(v),w=function(){function e(){t(this,e),this.version=\"1.2.2\",this.options={page:!1,touch:!1,click:!1},this.root=document,this.eventInstances=[],this.started=!1}return n(e,[{key:\"init\",value:function(t,e){this.options=Object.assign(Object.assign({},this.options),t),this.reportAdapter=e}},{key:\"start\",value:function(){if(this.started)return;this.started=!0;var t=this.options,e=t.page,n=t.click,r=t.touch;e&&this.eventInstances.push(new y(this)),n&&this.eventInstances.push(new g(this)),r&&this.eventInstances.push(new m(this))}},{key:\"stop\",value:function(){this.started=!1,this.eventInstances.forEach((function(t){return t.destroy()})),this.root=null}},{key:\"report\",value:function(){this.reportAdapter&&this.reportAdapter.apply(this,arguments)}}],[{key:\"getInstance\",value:function(){return e.instance||(e.instance=new e),e.instance}}]),e}();w.instance=null;var k,b,_;if(console.log(\"Winter Is Coming!\"),!window.TEAWebviewAutoTrack){var E=null,T=function(t){E||(E=window.TEANativeReport&&\"function\"==typeof window.TEANativeReport.postMessage?function(t){window.TEANativeReport.postMessage(t)}:window.TEANativeReport&&\"function\"==typeof window.TEANativeReport?function(t){window.TEANativeReport(t)}:window.webkit&&window.webkit.messageHandlers&&window.webkit.messageHandlers.TEANativeReport&&\"function\"==typeof window.webkit.messageHandlers.TEANativeReport.postMessage?function(t){window.webkit.messageHandlers.TEANativeReport.postMessage(t)}:function(t){}),E(t)},A=(k={page:!0,touch:!0,click:!1},b=function(){for(var t=arguments.length,e=new Array(t),n=0;n<t;n++)e[n]=arguments[n];var r=e[0],i=e[1],o=[{event:r,is_bav:1,local_time_ms:+new Date,params:i}];console.log(o[0]),T(JSON.stringify(o))},(_=w.getInstance()).init(k,b),_);A.start(),window.TEAWebviewAutoTrack=A}}();";
    public static final String JS_CODE_MARQUEE = "!function(){\"use strict\";function e(e){if([\"LI\",\"TR\",\"DL\"].includes(e.nodeName))return!0;if(e.dataset&&e.dataset.hasOwnProperty(\"teaIdx\"))return!0;if(e.hasAttribute&&e.hasAttribute(\"data-tea-idx\"))return!0;return!1}function n(n){for(var t=[];null!==n.parentElement;)t.push(n),n=n.parentElement;var r=[],i=[];return t.forEach((function(n){var t=function(n){if(null===n)return{str:\"\",index:0};var t=0,r=n.parentElement;if(r)for(var i=0;i<r.children.length&&r.children[i]!==n;i++)r.children[i].nodeName===n.nodeName&&t++;return{str:[n.nodeName.toLowerCase(),e(n)?\"[]\":\"\"].join(\"\"),index:t}}(n),o=t.str,a=t.index;r.unshift(o),i.unshift(a)})),{element_path:\"/\".concat(r.join(\"/\")),positions:i}}var t=window.__TEA_CHUNK_MAX__||524288;function r(e){try{return new Blob([e]).size}catch(i){for(var n=e.length,t=n-1;t>=0;t--){var r=e.charCodeAt(t);r>127&&r<=2047?n++:r>2047&&r<=65535&&(n+=2),r>=56320&&r<=57343&&t--}return n}}function i(e){if(r(e)<t)return[e];var n=encodeURIComponent(e),i=Math.ceil(r(n)/t);return new Array(i).fill(\"\").map((function(e,r){return n.substr(r*t,t)}))}var o=!1,a=1,u=window.innerWidth,c=window.innerHeight,f=new Set;var l=function(e){var n=e._element_path,t=e.positions,r=e.children;e._checkList=!0;var i=n.split(\"/\").length-2;if(e.fuzzy_positions||(e.fuzzy_positions=[].concat(t)),e.fuzzy_positions[i]=\"*\",r){!function e(n){n.forEach((function(n){n.fuzzy_positions||(n.fuzzy_positions=[].concat(n.positions)),n.fuzzy_positions[i]=\"*\",n.children&&e(n.children)}))}(r)}},s=function e(t){return Array.prototype.slice.call(t,0).reduce((function(t,r){if(!r)return t;var i=r.nodeName;if(function(e){return[\"script\",\"link\",\"style\",\"embed\"].includes(e)}(i=i.toLowerCase())||function(e){var n=getComputedStyle(e,null);if(\"none\"===n.getPropertyValue(\"display\"))return!0;if(\"0\"===n.getPropertyValue(\"opacity\"))return!0;return!1}(r))return t;var o={};if(!function(e){return[\"button\",\"select\"].includes(e)}(i)&&r.children){var s=e(r.children);s&&s.length&&(o={children:s})}var h=function(e){var n=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,t=e.getBoundingClientRect().toJSON();if(1===n)return t;return Object.keys(t).reduce((function(e,r){return e[r]=Math.ceil(t[r]*n),e}),{})}(r,a);if(!function(e,n){var t=e.left,r=e.right,i=e.top,o=e.bottom,a=e.width,u=e.height;if(!(a>0&&u>0))return!1;if(t>window.innerWidth||r<0||i>window.innerHeight||o<0)return!1;return!0}(h))return o.children&&o.children.forEach((function(e){return t.push(e)})),t;h=function(e){var n={x:e.left,y:e.top,width:e.width,height:e.height};return e.top<0&&(n.y=0,n.height+=e.top),e.bottom>c&&(n.height=c-n.y),e.left<0&&(n.x=0,n.width+=e.left),e.right>u&&(n.width=u-n.x),Object.keys(n).forEach((function(e){n[e]=Math.floor(n[e])})),n}(h);var d=function(e){var t=n(e),r=t.element_path,i=t.positions.map((function(e){return\"\".concat(e)})),o=[].concat(i).reverse(),a=!1;if(-1!==r.indexOf(\"[]\")){a=!0;var u=!1;r.split(\"/\").reverse().forEach((function(e,n){u||-1===e.indexOf(\"[]\")||(u=!0,o[n]=\"*\")}))}var c=e.id,f=e.tagName,l=[\"absolute\",\"fixed\"],s=0,h=getComputedStyle(e,null).getPropertyValue(\"z-index\");\"auto\"!==h&&(s=parseInt(String(h),10));for(var d=e.parentElement;d;){var p=getComputedStyle(d,null);if(l.includes(p.getPropertyValue(\"position\"))){s+=1e4;break}d=d.parentElement}return Object.assign({element_id:c,element_type:f,_element_path:r,element_path:\"\".concat(r,\"/*\"),positions:i.concat(\"*\"),zIndex:s},a?{fuzzy_positions:o.reverse().concat(\"*\")}:{})}(r),p=d._element_path,v=!1;if(f.has(p))v=!0;else{var m=r.parentElement;if(m){var g=m.children,w=Array.from(g).filter((function(e){return e.nodeName.toLowerCase()===i})),y=w.length;if(y>=3){var _=Array.from(r.classList),b=_.length,z=Array.from(r.children).map((function(e){return e.nodeName.toLowerCase()})).join(\",\"),A=0;Array.from(w).forEach((function(e){if(e===r)return A++,void 0;var n=!1;if(b){var t=Array.from(e.classList);_.length+t.length-new Set([].concat(t,_)).size>0&&(n=!0)}else n=!0;if(n){var i=!1;if(z){var o=Array.from(e.children).map((function(e){return e.nodeName.toLowerCase()})).join(\",\");o===z&&(i=!0)}else i=!0;i&&A++}})),A>=3&&A/y>=.5&&(v=!0),v&&f.add(p)}}}return d=Object.assign(Object.assign({nodeName:i,frame:h},d),o),v&&l(d),d.children&&d.children.forEach((function(e){var n=e._element_path,t=e._checkList;f.has(n)&&!t&&l(e)})),t.push(d),t}),[])},h=function(){if(o)return;o=!0,a=function(){try{var e=window.outerWidth/window.innerWidth;if(1===e)return 1;if(e)return e;var n=document.querySelector('meta[name=\"viewport\"]');if(n){var t=n.content.match(/initial-scale=(.*?)(,|$)/);if(t&&t[1]){var r=parseFloat(t[1]);if(r)return r}}}catch(e){return 1}return 1}(),u=window.innerWidth*a,c=window.innerHeight*a,f=new Set},d=function(e){return JSON.stringify(e)};if(!window.TEAWebviewInfo){var p=[],v=function(){var e=arguments.length>0&&void 0!==arguments[0]&&arguments[0];if(p.length)return console.log(p.length,p),d({value:p.shift(),done:!p.length});h();try{var n=s(document.querySelectorAll(\"body > *\")),t={page:window.location.href,info:n},r=d(t);if(console.log(r),!e)return r;if(1===(p=i(r)).length)return p.shift();return console.log(p.length,p),d({value:p.shift(),done:!1})}catch(e){console.log(e)}return\"\"};v.version=\"1.2.2\",window.TEAWebviewInfo=v}}();";
    public static final String JS_URL_PREFIX = "javascript:";
    public static final List<String> loggerTags = Collections.singletonList("WebViewJsUtil");

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0372a implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ Handler f422a;

        /* renamed from: b */
        public final /* synthetic */ WebView f423b;

        public C0372a(Handler handler, WebView webView) {
            this.f422a = handler;
            this.f423b = webView;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            String str2 = str;
            if (this.f422a != null) {
                if (TextUtils.isEmpty(str2)) {
                    LoggerImpl.global().debug(WebViewJsUtil.loggerTags, "WebViewJsUtil getWebInfo:null!", new Object[0]);
                }
                Message obtainMessage = this.f422a.obtainMessage();
                obtainMessage.obj = this.f423b;
                obtainMessage.getData().putString(WebViewJsUtil.BUNDLE_WEB_INFO, str2);
                this.f422a.sendMessage(obtainMessage);
            }
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0373b implements C0453k.e {
        @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
        /* renamed from: a */
        public boolean mo248a(C0467m c0467m) {
            return (!c0467m.isH5CollectEnable() || c0467m.getInitConfig() == null || c0467m.getInitConfig().getPicker() == null || TextUtils.isEmpty(c0467m.getInitConfig().getPicker().getMarqueeCookie())) ? false : true;
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0374c implements InterfaceC0378g {
        /* renamed from: a */
        public void m249a(String str) {
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0375d implements com.tencent.smtt.sdk.ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0378g f424a;

        public C0375d(InterfaceC0378g interfaceC0378g) {
            this.f424a = interfaceC0378g;
        }

        public void onReceiveValue(Object obj) {
            String str = (String) obj;
            InterfaceC0378g interfaceC0378g = this.f424a;
            if (interfaceC0378g != null) {
                ((C0374c) interfaceC0378g).m249a(str);
            }
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0376e implements ValueCallback<String> {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0378g f425a;

        public C0376e(InterfaceC0378g interfaceC0378g) {
            this.f425a = interfaceC0378g;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            String str2 = str;
            InterfaceC0378g interfaceC0378g = this.f425a;
            if (interfaceC0378g != null) {
                ((C0374c) interfaceC0378g).m249a(str2);
            }
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0377f implements C0453k.f {

        /* renamed from: a */
        public final /* synthetic */ String f426a;

        /* renamed from: b */
        public final /* synthetic */ String f427b;

        /* renamed from: c */
        public final /* synthetic */ boolean f428c;

        /* renamed from: d */
        public final /* synthetic */ JSONObject f429d;

        public C0377f(String str, String str2, boolean z, JSONObject jSONObject) {
            this.f426a = str;
            this.f427b = str2;
            this.f428c = z;
            this.f429d = jSONObject;
        }

        @Override // com.bytedance.tobshadow.bdtracker.C0453k.f
        /* renamed from: a */
        public AbstractC0479n4 mo250a() {
            return WebViewJsUtil.create(this.f426a, this.f427b, this.f428c, this.f429d);
        }
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$g */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface InterfaceC0378g {
    }

    /* renamed from: com.bytedance.tobshadow.applog.util.WebViewJsUtil$h */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0379h {
        public C0379h() {
        }

        public /* synthetic */ C0379h(C0372a c0372a) {
        }

        @JavascriptInterface
        public void postMessage(String str) {
            LoggerImpl.global().debug(WebViewJsUtil.loggerTags, C0380a.m251a("WebViewJsUtil postMessage to native: ", str), new Object[0]);
            WebViewJsUtil.sendWebClick(str);
        }
    }

    public static C0528u4 create(String str, String str2, boolean z, JSONObject jSONObject) {
        C0528u4 c0528u4 = new C0528u4(null, str, z, jSONObject != null ? jSONObject.toString() : null);
        if (!TextUtils.isEmpty(str)) {
            try {
                c0528u4.m573a(Long.parseLong(str2));
            } catch (NumberFormatException e) {
                LoggerImpl.global().debug(loggerTags, "Create eventV3 failed", e);
            }
        }
        return c0528u4;
    }

    public static void evaluateJavascript(View view, String str) {
        evaluateJavascript(view, str, new C0374c());
    }

    public static void evaluateJavascript(View view, String str, InterfaceC0378g interfaceC0378g) {
        if (C0445i5.m474a(view)) {
            if (C0445i5.m477b(view)) {
                ((com.tencent.smtt.sdk.WebView) view).evaluateJavascript(str, new C0375d(interfaceC0378g));
            } else {
                ((WebView) view).evaluateJavascript(str, new C0376e(interfaceC0378g));
            }
        }
    }

    public static String getJsCodeUrl(String str) {
        StringBuilder m252a = C0380a.m252a(JS_URL_PREFIX);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return m252a.append(str).toString();
    }

    public static void getWebInfo(WebView webView, Handler handler) {
        webView.evaluateJavascript(getJsCodeUrl("TEAWebviewInfo();"), new C0372a(handler, webView));
    }

    public static void injectCollectJs(View view, String str) {
        String str2;
        IAppLogLogger global = LoggerImpl.global();
        List<String> list = loggerTags;
        global.debug(list, "WebViewJsUtil collect js to: {}", view);
        if (C0453k.m497a(new C0373b())) {
            LoggerImpl.global().debug(list, "WebViewJsUtil 圈选", new Object[0]);
            str2 = JS_CODE_MARQUEE;
        } else {
            LoggerImpl.global().debug(list, "WebViewJsUtil 全埋点", new Object[0]);
            str2 = JS_CODE_COLLECT;
        }
        if (getJsCodeUrl(str2).equals(str)) {
            return;
        }
        evaluateJavascript(view, str2);
    }

    public static void injectNativeReportCallback(View view) {
        LoggerImpl.global().debug(loggerTags, "WebViewJsUtil add interface:TEANativeReport to: {}", view);
        C0379h c0379h = new C0379h(null);
        if (C0445i5.m474a(view)) {
            try {
                view.getClass().getMethod("addJavascriptInterface", Object.class, String.class).invoke(view, c0379h, "TEANativeReport");
            } catch (Throwable th) {
                LoggerImpl.global().error(Collections.singletonList("JavaScriptUtils"), "addJavascriptInterface failed", th, new Object[0]);
            }
        }
    }

    public static void loadData(View view, String str, String str2, String str3) {
        if (C0445i5.m474a(view)) {
            try {
                view.getClass().getMethod("loadData", String.class, String.class, String.class).invoke(view, str, str2, str3);
            } catch (Throwable th) {
                LoggerImpl.global().debug(loggerTags, "Reflect loadData failed", th);
            }
        }
    }

    public static void loadDataWithBaseURL(View view, String str, String str2, String str3, String str4, String str5) {
        if (C0445i5.m474a(view)) {
            try {
                view.getClass().getMethod("loadDataWithBaseURL", String.class, String.class, String.class, String.class, String.class).invoke(view, str, str2, str3, str4, str5);
            } catch (Throwable th) {
                LoggerImpl.global().debug(loggerTags, "Reflect loadDataWithBaseURL failed", th);
            }
        }
    }

    public static void loadUrl(View view, String str, Map<String, String> map) {
        if (C0445i5.m474a(view)) {
            try {
                view.getClass().getMethod("loadUrl", String.class, Map.class).invoke(view, str, map);
            } catch (Throwable th) {
                LoggerImpl.global().debug(loggerTags, "Reflect loadUrl failed", th);
            }
        }
    }

    public static void sendWebClick(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString(Fields.EVENT);
                String optString2 = jSONObject.optString("local_time_ms");
                boolean z = jSONObject.optInt("is_bav") == 1;
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                if (EMPTY_PAGE.equals(optJSONObject != null ? optJSONObject.optString("page_path") : "")) {
                    return;
                }
                if (!TextUtils.isEmpty(optString)) {
                    C0453k.m494a(new C0377f(optString, optString2, z, optJSONObject), C0453k.f710a);
                }
            }
        } catch (Throwable th) {
            LoggerImpl.global().debug(loggerTags, "sendWebClick failed", th);
        }
    }
}
