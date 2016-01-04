
if (navigator.platform == "Win32" && navigator.appName == "Microsoft Internet Explorer" && window.attachEvent) {
window.attachEvent("onload", enableAlphaImages);
}

function enableAlphaImages(){
var rslt = navigator.appVersion.match(/MSIE (\d+\.\d+)/, '');
var itsAllGood = (rslt != null && Number(rslt[1]) >= 5.5);
if (itsAllGood) {
for (var i=0; i<document.all.length; i++){
var obj = document.all[i];
var bg = obj.currentStyle.backgroundImage;
var img = document.images[i];
if (bg && bg.match(/\.png/i) != null) {
var img = bg.substring(5,bg.length-2);
var offset = obj.style["background-position"];
obj.style.filter =
"progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+img+"', sizingMethod='crop')";
obj.style.backgroundImage = "url("+contextpath+"/style/defaultStyle/images/spacer.gif')";//�滻͸��PNG��ͼƬ
obj.style["background-position"] = offset; // reapply
} else if (img && img.src.match(/\.png$/i) != null) {
var src = img.src;
img.style.width = img.width + "px";
img.style.height = img.height + "px";
img.style.filter =
"progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='crop')"
img.src = contextpath+"/style/defaultStyle/images/spacer.gif";//�滻͸��PNG��ͼƬ
}
}
}
}

function blurChangeColor(obj){
obj.style.color="#FF9900";
obj.style.fontWeight="bold";
}
function focusChangeColor(obj){

  objectIndex=obj.id;
 var con=document.getElementsByTagName("a");
 for(var i=0;i<con.length;i++){
con[i].style.color="#333333";
con[i].style.fontWeight="";
}
obj.style.color="#FF9900";
obj.style.fontWeight="bold";
obj.blur();

}
function mouseoverChangeColor(obj){
obj.style.color="#FF9900";
}
function mouseoutChangeColor(obj){

obj.style.color="#333333";

if(objectIndex!=""){
document.getElementById(objectIndex).style.color="#FF9900";
document.getElementById(objectIndex).style.fontWeight="bold";
}
}
function iFrameHeight() {
		var ifm= document.getElementById("iframepage");
		var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;
		if(ifm != null && subWeb != null) {
		   ifm.height = subWeb.body.scrollHeight;
		}
	}
function MM_showHideLayers() { //v9.0
  var i,p,v,obj,args=MM_showHideLayers.arguments;
  for (i=0; i<(args.length-2); i+=3)
  with (document) if (getElementById && ((obj=getElementById(args[i]))!=null)) { v=args[i+2];
    if (obj.style) { obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
    obj.visibility=v; }
}
function MM_popupMsg(msg) { //v1.0
  alert(msg);
}


/******************************************spin.js ****查询进度条************/
(function (t, e) {
    if (typeof exports == "object") module.exports = e();
    else if (typeof define == "function" && define.amd) define(e);
    else t.Spinner = e()
})(this, function () {
    "use strict";
    var t = ["webkit", "Moz", "ms", "O"],
        e = {}, i;

    function o(t, e) {
        var i = document.createElement(t || "div"),
            o;
        for (o in e) i[o] = e[o];
        return i
    }
    function n(t) {
        for (var e = 1, i = arguments.length; e < i; e++) t.appendChild(arguments[e]);
        return t
    }
    var r = function () {
        var t = o("style", {
            type: "text/css"
        });
        n(document.getElementsByTagName("head")[0], t);
        return t.sheet || t.styleSheet
    }();

    function s(t, o, n, s) {
        var a = ["opacity", o, ~~ (t * 100), n, s].join("-"),
            f = .01 + n / s * 100,
            l = Math.max(1 - (1 - t) / o * (100 - f), t),
            d = i.substring(0, i.indexOf("Animation")).toLowerCase(),
            u = d && "-" + d + "-" || "";
        if (!e[a]) {
            r.insertRule("@" + u + "keyframes " + a + "{" + "0%{opacity:" + l + "}" + f + "%{opacity:" + t + "}" + (f + .01) + "%{opacity:1}" + (f + o) % 100 + "%{opacity:" + t + "}" + "100%{opacity:" + l + "}" + "}", r.cssRules.length);
            e[a] = 1
        }
        return a
    }
    function a(e, i) {
        var o = e.style,
            n, r;
        if (o[i] !== undefined) return i;
        i = i.charAt(0).toUpperCase() + i.slice(1);
        for (r = 0; r < t.length; r++) {
            n = t[r] + i;
            if (o[n] !== undefined) return n
        }
    }
    function f(t, e) {
        for (var i in e) t.style[a(t, i) || i] = e[i];
        return t
    }
    function l(t) {
        for (var e = 1; e < arguments.length; e++) {
            var i = arguments[e];
            for (var o in i) if (t[o] === undefined) t[o] = i[o]
        }
        return t
    }
    function d(t) {
        var e = {
            x: t.offsetLeft,
            y: t.offsetTop
        };
        while (t = t.offsetParent) e.x += t.offsetLeft, e.y += t.offsetTop;
        return e
    }
    var u = {
        lines: 12,
        length: 7,
        width: 5,
        radius: 10,
        rotate: 0,
        corners: 1,
        color: "#000",
        direction: 1,
        speed: 1,
        trail: 100,
        opacity: 1 / 4,
        fps: 20,
        zIndex: 2e9,
        className: "spinner",
        top: "auto",
        left: "auto",
        position: "relative"
    };

    function p(t) {
        if (typeof this == "undefined") return new p(t);
        this.opts = l(t || {}, p.defaults, u)
    }
    p.defaults = {};
    l(p.prototype, {
        spin: function (t) {
            this.stop();
            var e = this,
                n = e.opts,
                r = e.el = f(o(0, {
                    className: n.className
                }), {
                    position: n.position,
                    width: 0,
                    zIndex: n.zIndex
                }),
                s = n.radius + n.length + n.width,
                a, l;
            if (t) {
                t.insertBefore(r, t.firstChild || null);
                l = d(t);
                a = d(r);
                f(r, {
                    left: (n.left == "auto" ? l.x - a.x + (t.offsetWidth >> 1) : parseInt(n.left, 10) + s) + "px",
                    top: (n.top == "auto" ? l.y - a.y + (t.offsetHeight >> 1) : parseInt(n.top, 10) + s) + "px"
                })
            }
            r.setAttribute("role", "progressbar");
            e.lines(r, e.opts);
            if (!i) {
                var u = 0,
                    p = (n.lines - 1) * (1 - n.direction) / 2,
                    c, h = n.fps,
                    m = h / n.speed,
                    y = (1 - n.opacity) / (m * n.trail / 100),
                    g = m / n.lines;
                (function v() {
                    u++;
                    for (var t = 0; t < n.lines; t++) {
                        c = Math.max(1 - (u + (n.lines - t) * g) % m * y, n.opacity);
                        e.opacity(r, t * n.direction + p, c, n)
                    }
                    e.timeout = e.el && setTimeout(v, ~~ (1e3 / h))
                })()
            }
            return e
        },
        stop: function () {
            var t = this.el;
            if (t) {
                clearTimeout(this.timeout);
                if (t.parentNode) t.parentNode.removeChild(t);
                this.el = undefined
            }
            return this
        },
        lines: function (t, e) {
            var r = 0,
                a = (e.lines - 1) * (1 - e.direction) / 2,
                l;

            function d(t, i) {
                return f(o(), {
                    position: "absolute",
                    width: e.length + e.width + "px",
                    height: e.width + "px",
                    background: t,
                    boxShadow: i,
                    transformOrigin: "left",
                    transform: "rotate(" + ~~(360 / e.lines * r + e.rotate) + "deg) translate(" + e.radius + "px" + ",0)",
                    borderRadius: (e.corners * e.width >> 1) + "px"
                })
            }
            for (; r < e.lines; r++) {
                l = f(o(), {
                    position: "absolute",
                    top: 1 + ~(e.width / 2) + "px",
                    transform: e.hwaccel ? "translate3d(0,0,0)" : "",
                    opacity: e.opacity,
                    animation: i && s(e.opacity, e.trail, a + r * e.direction, e.lines) + " " + 1 / e.speed + "s linear infinite"
                });
                if (e.shadow) n(l, f(d("#000", "0 0 4px " + "#000"), {
                        top: 2 + "px"
                    }));
                n(t, n(l, d(e.color, "0 0 1px rgba(0,0,0,.1)")))
            }
            return t
        },
        opacity: function (t, e, i) {
            if (e < t.childNodes.length) t.childNodes[e].style.opacity = i
        }
    });

    function c() {
        function t(t, e) {
            return o("<" + t + ' xmlns="urn:schemas-microsoft.com:vml" class="spin-vml">', e)
        }
        r.addRule(".spin-vml", "behavior:url(#default#VML)");
        p.prototype.lines = function (e, i) {
            var o = i.length + i.width,
                r = 2 * o;

            function s() {
                return f(t("group", {
                    coordsize: r + " " + r,
                    coordorigin: -o + " " + -o
                }), {
                    width: r,
                    height: r
                })
            }
            var a = -(i.width + i.length) * 2 + "px",
                l = f(s(), {
                    position: "absolute",
                    top: a,
                    left: a
                }),
                d;

            function u(e, r, a) {
                n(l, n(f(s(), {
                    rotation: 360 / i.lines * e + "deg",
                    left: ~~r
                }), n(f(t("roundrect", {
                    arcsize: i.corners
                }), {
                    width: o,
                    height: i.width,
                    left: i.radius,
                    top: -i.width >> 1,
                    filter: a
                }), t("fill", {
                    color: i.color,
                    opacity: i.opacity
                }), t("stroke", {
                    opacity: 0
                }))))
            }
            if (i.shadow) for (d = 1; d <= i.lines; d++) u(d, -2, "progid:DXImageTransform.Microsoft.Blur(pixelradius=2,makeshadow=1,shadowopacity=.3)");
            for (d = 1; d <= i.lines; d++) u(d);
            return n(e, l)
        };
        p.prototype.opacity = function (t, e, i, o) {
            var n = t.firstChild;
            o = o.shadow && o.lines || 0;
            if (n && e + o < n.childNodes.length) {
                n = n.childNodes[e + o];
                n = n && n.firstChild;
                n = n && n.firstChild;
                if (n) n.opacity = i
            }
        }
    }
    var h = f(o("group"), {
        behavior: "url(#default#VML)"
    });
    if (!a(h, "transform") && h.adj) c();
    else i = a(h, "animation");
    return p
});

var opts = {
		  lines: 9, // The number of lines to draw
		  length: 7, // The length of each line
		  width: 5, // The line thickness
		  radius: 8, // The radius of the inner circle
		  corners: 1, // Corner roundness (0..1)
		  rotate: 0, // The rotation offset
		  direction: 1, // 1: clockwise, -1: counterclockwise
		  color: '#000', // #rgb or #rrggbb
		  speed: 1, // Rounds per second
		  trail: 60, // Afterglow percentage
		  shadow: false, // Whether to render a shadow
		  hwaccel: false, // Whether to use hardware acceleration
		  className: 'spinner', // The CSS class to assign to the spinner
		  zIndex: 2e9, // The z-index (defaults to 2000000000)
		  top: 'auto', // Top position relative to parent in px
		  left: 'auto' // Left position relative to parent in px
		};