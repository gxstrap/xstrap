<!-- 头像设置页面 -->
<!DOCTYPE html>
<!-- saved from url=(0041)http://www.xuebusi.cn/settings/avatar -->
<html lang="zh_CN"><!--<![endif]-->
<#include "../common/head.ftl">
<body onbeforeunload="return CheckUnsave();">
<div id="nTalk_post_hiddenElement"
     style="left: -10px; top: -10px; visibility: hidden; display: none; width: 1px; height: 1px;"></div>

<div class="es-wrap">

    <script type="text/javascript">
        /*function baidusearch(id) {
          var url = "http://zhannei.baidu.com/cse/search?s=83960727734992248&entry=1&q=" + encodeURIComponent(document.getElementById(id).value);
          window.open(url,"_blank");
        }*/
        function coursesearch(id) {
            var url = "/search" + "?q=" + encodeURIComponent(document.getElementById(id).value);
            window.open(url, "_self");
        }

        function baidusearch() {
            var sWords = window.location.href.split('=')[1] || '';
            var url = "http://zhannei.baidu.com/cse/search?s=83960727734992248&entry=1&q=" + sWords;
            window.open(url, "_blank");
        }
    </script>
    <script>
        window.onload = function () {

            var aLi = document.querySelectorAll('.topNav li')
            var aA = document.querySelectorAll('.topNav li a')
            var len = aLi.length;
            var curCategory = window.location.href.split('/')[3].toString()
            var index = 0;
            var data = {
                '': aA[0].innerText,
                'ai': aA[1].innerText,
                'bigdata': aA[2].innerText,
                'da': aA[3].innerText,
                'basic': aA[4].innerText,
            }
            for (var i = 0; i < 5; i++) {
                if (aA[i].innerText == data[curCategory]) {
                    index = i;
                }
            }
            /*      aA[index].style.borderBottom = '2px solid red';
                  aA[index].style.color = 'red'*/

            var borderStr = document.createElement('div')
            borderStr.innerHTML = '<div style="border-bottom: 4px solid red; margin-top: -2px; color: red; border-radius: 4px"></div>'

            aLi[index].appendChild(borderStr)

        }
    </script>
    <#include "../common/header.ftl">
    <div id="content-container" class="container">
        <div class="row">
            <div class="col-md-3">
                <div class="sidenav">
                    <ul class="list-group">
                        <li class="list-group-heading">个人设置</li>
                        <li class="list-group-item ">
                            <a href="/settings/">
                                <i class="glyphicon glyphicon-user"></i> 基础信息
                            </a>
                        </li>
                        <li class="list-group-item active">
                            <a href="/settings/avatar">
                                <i class="glyphicon glyphicon-picture"></i> 头像设置
                            </a>
                        </li>
                        <li class="list-group-item ">
                            <a href="/settings/approval/submit">
                                <i class="glyphicon glyphicon-registration-mark"></i> 实名认证
                            </a>
                        </li>
                        <li class="list-group-item ">
                            <a href="/settings/security">
                                <i class="glyphicon glyphicon-lock"></i> 安全设置
                            </a>
                        </li>
                        <li class="list-group-item ">
                            <a href="/settings/email">
                                <i class="glyphicon glyphicon-envelope"></i> 邮箱设置
                            </a>
                        </li>
                        <li class="list-group-item ">
                            <a href="/settings/binds">
                                <iclass="glyphicon glyphicon-circle-arrow-right"></i> 第三方登录
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <div class="col-md-9">
                <div class="panel panel-default panel-col">
                    <div class="panel-heading">头像设置</div>
                    <div class="panel-body">
                        <form id="settings-avatar-form" class="form-horizontal" method="post" action="/settings">
                            <div class="form-group">
                                <div class="col-md-2 control-label"><b>当前头像</b></div>
                                <div class="controls col-md-8 controls">
                                    <img src="/images/0548491aa7e5403534.jpg">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2 control-label">
                                </div>
                                <div class="controls col-md-8 controls">
                                    <p class="help-block">你可以上传JPG、GIF或PNG格式的文件，文件大小不能超过<strong>2M</strong>。</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2 control-label"></div>
                                <div class="controls col-md-8 controls">
                                    <a id="upload-picture-btn" class="btn btn-primary webuploader-container"
                                       data-upload-token="NjA5OTJ8dG1wfGltYWdlfDE1MDg2NzM0MTV8OWE4YWVhYjJlM2JhNjhjNzBjYjQ0ZmQ4MzdlOTdlY2Q"
                                       data-goto-url="/settings/avatar/crop" data-widget-cid="widget-1">

                                        <div class="webuploader-pick">上传新头像</div>
                                        <div id="rt_rt_1bt1dtg211ro11dl2p861ta71v3c1" style="position: absolute; top: 6px; left: 12px; width: 70px; height: 20px; overflow: hidden; bottom: auto; right: auto;">
                                            <input type="file" name="file" class="webuploader-element-invisible" accept="image/png,image/jpg,image/jpeg,imge/bmp,image/gif">
                                            <label style="opacity: 0; width: 100%; height: 100%; display: block; cursor: pointer; background: rgb(255, 255, 255);"></label>
                                        </div>
                                    </a>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#include "../common/footer.ftl">
</div>

<#include "../common/sidebar.ftl">
<#include "../common/login-modal.ftl">
</body>
</html>
