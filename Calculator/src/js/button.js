/*
YUI 3.16.0 (build 76f0e08)
Copyright 2014 Yahoo! Inc. All rights reserved.
Licensed under the BSD License.
http://yuilibrary.com/license/
*/

YUI.add("escape",function(e,t){var n={"&":"&amp;","<":"&lt;",">":"&gt;",'"':"&quot;","'":"&#x27;","/":"&#x2F;","`":"&#x60;"},r={html:function(e){return(e+"").replace(/[&<>"'\/`]/g,r._htmlReplacer)},regex:function(e){return(e+"").replace(/[\-$\^*()+\[\]{}|\\,.?\s]/g,"\\$&")},_htmlReplacer:function(e){return n[e]}};r.regexp=r.regex,e.Escape=r},"3.16.0",{requires:["yui-base"]});
/*
YUI 3.16.0 (build 76f0e08)
Copyright 2014 Yahoo! Inc. All rights reserved.
Licensed under the BSD License.
http://yuilibrary.com/license/
*/

YUI.add("button-core",function(e,t){function i(e){this.initializer(e)}var n=e.ClassNameManager.getClassName,r=e.AttributeCore;i.prototype={TEMPLATE:"<button/>",constructor:i,initializer:function(e){this._initNode(e),this._initAttributes(e),this._renderUI(e)},_initNode:function(t){t.host?this._host=e.one(t.host):this._host=e.Node.create(this.TEMPLATE)},_initAttributes:function(e){r.call(this,i.ATTRS,e)},_renderUI:function(){var e=this.getNode(),t=e.get("nodeName").toLowerCase();e.addClass(i.CLASS_NAMES.BUTTON),t!=="button"&&t!=="input"&&e.set("role","button")},enable:function(){this.set("disabled",!1)},disable:function(){this.set("disabled",!0)},getNode:function(){return this._host||(this._host=this.get("boundingBox")),this._host},_getLabel:function(){var e=this.getNode(),t=i._getTextLabelFromNode(e);return t},_getLabelHTML:function(){var e=this.getNode(),t=i._getHTMLFromNode(e);return t},_setLabel:function(t,n,r){var i=e.Escape.html(t);return(!r||r.src!=="internal")&&this.set("labelHTML",i,{src:"internal"}),i},_setLabelHTML:function(e,t,n){var r=this.getNode(),s=i._getLabelNodeFromParent(r),o=r.get("nodeName").toLowerCase();return o==="input"?s.set("value",e):s.setHTML(e),(!n||n.src!=="internal")&&this.set("label",e,{src:"internal"}),e},_setDisabled:function(e){var t=this.getNode();return t.getDOMNode().disabled=e,t.toggleClass(i.CLASS_NAMES.DISABLED,e),e}},e.mix(i.prototype,r.prototype),i.ATTRS={label:{setter:"_setLabel",getter:"_getLabel",lazyAdd:!1},labelHTML:{setter:"_setLabelHTML",getter:"_getLabelHTML",lazyAdd:!1},disabled:{value:!1,setter:"_setDisabled",lazyAdd:!1}},i.NAME="button",i.CLASS_NAMES={BUTTON:n("button"),DISABLED:n("button","disabled"),SELECTED:n("button","selected"),LABEL:n("button","label")},i.ARIA_STATES={PRESSED:"aria-pressed",CHECKED:"aria-checked"},i.ARIA_ROLES={BUTTON:"button",CHECKBOX:"checkbox",TOGGLE:"toggle"},i._getLabelNodeFromParent=function(e){var t=e.one("."+i.CLASS_NAMES.LABEL)||e;return t},i._getTextLabelFromNode=function(e){var t=i._getLabelNodeFromParent(e),n=t.get("nodeName").toLowerCase(),r=t.get(n==="input"?"value":"text");return r},i._getHTMLFromNode=function(e){var t=i._getLabelNodeFromParent(e),n=t.getHTML();return n},i._getDisabledFromNode=function(e){return e.get("disabled")},e.ButtonCore=i},"3.16.0",{requires:["attribute-core","classnamemanager","node-base","escape"]});
/*
YUI 3.16.0 (build 76f0e08)
Copyright 2014 Yahoo! Inc. All rights reserved.
Licensed under the BSD License.
http://yuilibrary.com/license/
*/

YUI.add("button",function(e,t){function o(){o.superclass.constructor.apply(this,arguments)}function u(){o.superclass.constructor.apply(this,arguments)}var n=e.ButtonCore,r=n.CLASS_NAMES,i=n.ARIA_STATES,s=n.ARIA_ROLES;e.extend(o,e.Widget,{BOUNDING_TEMPLATE:n.prototype.TEMPLATE,CONTENT_TEMPLATE:null},{NAME:n.NAME,ATTRS:n.ATTRS,HTML_PARSER:{labelHTML:n._getHTMLFromNode,disabled:n._getDisabledFromNode},CLASS_NAMES:r}),e.mix(o.prototype,n.prototype),e.extend(u,o,{trigger:"click",selectedAttrName:"",initializer:function(e){var t=this,n=t.get("type"),r=n==="checkbox"?"checked":"pressed",i=e[r]||!1;t.addAttr(r,{value:i}),t.selectedAttrName=r},destructor:function(){delete this.selectedAttrName},bindUI:function(){var e=this,t=e.get("contentBox");u.superclass.bindUI.call(e),t.on(e.trigger,e.toggle,e),e.after(e.selectedAttrName+"Change",e._afterSelectedChange)},syncUI:function(){var e=this,t=e.get("contentBox"),n=e.get("type"),r=u.ARIA_ROLES,i=n==="checkbox"?r.CHECKBOX:r.TOGGLE,s=e.selectedAttrName;u.superclass.syncUI.call(e),t.set("role",i),e._uiSetSelected(e.get(s))},_afterSelectedChange:function(e){this._uiSetSelected(e.newVal)},_uiSetSelected:function(e){var t=this,n=t.get("contentBox"),r=u.ARIA_STATES,i=t.get("type"),s=i==="checkbox"?r.CHECKED:r.PRESSED;n.toggleClass(o.CLASS_NAMES.SELECTED,e),n.set(s,e)},toggle:function(){var e=this;e._set(e.selectedAttrName,!e.get(e.selectedAttrName))}},{NAME:"toggleButton",ATTRS:{type:{value:"toggle",writeOnce:"initOnly"}},HTML_PARSER:{checked:function(e){return e.hasClass(r.SELECTED)},pressed:function(e){return e.hasClass(r.SELECTED)}},ARIA_STATES:i,ARIA_ROLES:s,CLASS_NAMES:r}),e.Button=o,e.ToggleButton=u},"3.16.0",{requires:["button-core","cssbutton","widget"]});
