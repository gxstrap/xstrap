<!DOCTYPE html>
<!-- saved from url=(0042)/user/10391/teach -->
<html lang="zh_CN"><!--<![endif]-->
<#include "../common/head.ftl">
<body class="userpage bg-blank" onbeforeunload="return CheckUnsave();">
<div id="nTalk_post_hiddenElement" style="left: -10px; top: -10px; visibility: hidden; display: none; width: 1px; height: 1px;"></div>

<div class="es-wrap">
    <#include "../common/alert-notice.ftl">
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
    <#--<#include "../common/header-login.ftl">-->
    <#include "../common/header.ftl">

    <div class="user-center-header has-blurr"
         data-href="${(user.titleImgUrl)!}" data-sharpness="40"
         style="height: 220px; overflow: hidden; position: relative;">
        <div class="blurr-bg" style="background: url(&quot;${(user.titleImgUrl)!}&quot;) center center / 150%; left: 0px; right: 0px; top: -50px; bottom: -50px; width: 1349px; filter: blur(60px); transform: translateZ(0px); position: absolute;"></div>
        <div class="container clearfix" style="position: absolute; left: 0px; right: 0px; z-index: 1;">
            <div class="user-avatar">
                <div class="avatar-wrap">
                    <img class="avatar-lg" src="${(user.titleImgUrl)!}">
                    <span class="icon-user-status icon-md">
                        <i class="es-icon es-icon-school"></i>
                    </span>
                </div>
                <div class="name">
                    ${(user.username)!}
                </div>
                <div class="position">
                    <span class="mrm">${(user.title)!'暂无头衔'}</span>
                </div>
                <div class="mates">
                    <span class="mrm">${(user.fansCount)!}</span>粉丝
                    <span class="mlm mrm">｜</span>
                    <span class="mrm">${(user.followCount)!}</span>关注
                </div>
                <div class="actions">
                    <a class="btn btn-primary follow-btn mrl" href="javascript:;" data-url="/user/${(user.id)!}/follow">关注</a>
                    <a class="btn btn-default unfollow-btn mrl" href="javascript:;" data-url="/user/${(user.id)!}/unfollow"
                       style="display:none;">已关注</a>
                    <button class="btn btn-ghost-white" data-toggle="modal" data-backdrop="static" data-target="#modal"
                            data-url="/message/create/${(user.id)!}">私信
                    </button>
                </div>
            </div>
            <div class="user-about hidden-sm hidden-xs">
                <div class="user-about-content">
                    ${(user.signature)!'暂无签名'}
                </div>
            </div>
        </div>
        <div class="mask" style="position: absolute; left: 0px; right: 0px; z-index: 1;"></div>
    </div>

    <div id="content-container" class="container">
        <#include "user-tabs.ftl">
        <div class="course-list">
            <div class="row">
                <#list courseList as course>
                    <div class="col-lg-3 col-md-4 col-xs-6">
                        <div class="course-item">
                            <div class="course-img">
                                <a href="/course/${(user.id)!}" target="_blank">
                                    <span class="tags">
                                        <span class="tag-live"></span>
                                    </span>
                                    <img class="img-responsive" src="${(course.courseImgUrl)!}" alt="${(course.courseTitle)!}">
                                </a>
                            </div>
                            <div class="course-info">
                                <div class="title">
                                    <a class="link-dark" href="/course/${(user.id)!}" target="_blank">
                                    ${(course.courseTitle)!}
                                    </a>
                                </div>
                                <div class="metas clearfix">
                                    <span class="num">
                                        <i class="es-icon es-icon-people"></i>231
                                    </span>
                                    <span class="comment">
                                        <i class="es-icon es-icon-textsms"></i>0
                                    </span>
                                    <span class="course-price-widget">
                                        <span class="price" style="font-size: 24px">${(course.coursePrice)!}</span>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
                <#--<div class="col-lg-3 col-md-4 col-xs-6">
                    <div class="course-item">
                        <div class="course-img">
                            <a href="/course/946" target="_blank">
                                <img class="img-responsive" src="./teach.tml_files/141316c2a046749346.png" alt="从零开始爬取Wikipedia">
                            </a>
                        </div>
                        <div class="course-info">
                            <div class="title">
                                <a class="link-dark" href="/course/946" target="_blank">
                                    从零开始爬取Wikipedia
                                </a>
                            </div>
                            <div class="metas clearfix">
                                <span class="num">
                                    <i class="es-icon es-icon-people"></i>1336
                                </span>
                                <span class="comment">
                                    <i class="es-icon es-icon-textsms"></i>1
                                </span>
                                <span class="course-price-widget">
                                    <span class="price" style="font-size: 24px">
                                        <span class="text-danger" style="font-size: 16px">免费</span>
                                    </span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-xs-6">
                    <div class="course-item">
                        <div class="course-img">
                            <a href="/course/944" target="_blank">
                                <img class="img-responsive" src="./teach.tml_files/154534e50b32241984.png" alt="《分布式爬虫实战》第二期">
                            </a>
                        </div>
                        <div class="course-info">
                            <div class="title">
                                <a class="link-dark" href="/course/944" target="_blank">
                                    《分布式爬虫实战》第二期
                                </a>
                            </div>
                            <div class="metas clearfix">
                                <span class="num">
                                    <i class="es-icon es-icon-people"></i>840
                                </span>
                                <span class="comment">
                                    <i class="es-icon es-icon-textsms"></i>2
                                </span>
                                <span class="course-price-widget">
                                    <span class="price" style="font-size: 24px">899.00</span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-xs-6">
                    <div class="course-item">
                        <div class="course-img">
                            <a href="/course/826" target="_blank">
                                <img class="img-responsive" src="./teach.tml_files/1140331e5afb252364.jpg" alt="Python爬虫的代码实践">
                            </a>
                        </div>
                        <div class="course-info">
                            <div class="title">
                                <a class="link-dark" href="/course/826" target="_blank">
                                    Python爬虫的代码实践
                                </a>
                            </div>
                            <div class="metas clearfix">
                                <span class="num">
                                    <i class="es-icon es-icon-people"></i>1637
                                </span>
                                <span class="comment">
                                    <i class="es-icon es-icon-textsms"></i>2
                                </span>
                                <span class="course-price-widget">
                                    <span class="price" style="font-size: 24px">
                                        <span class="text-danger" style="font-size: 16px">免费</span>
                                    </span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 col-md-4 col-xs-6">
                    <div class="course-item">
                        <div class="course-img">
                            <a href="/course/822" target="_blank">
                                <img class="img-responsive" src="./teach.tml_files/11565795421d061504.png" alt="《分布式爬虫实战》">
                            </a>
                        </div>
                        <div class="course-info">
                            <div class="title">
                                <a class="link-dark" href="/course/822" target="_blank">
                                    《分布式爬虫实战》
                                </a>
                            </div>
                            <div class="metas clearfix">
                                <span class="num"><i class="es-icon es-icon-people"></i>1269</span>
                                <span class="comment"><i class="es-icon es-icon-textsms"></i>4</span>
                                <span class="course-price-widget">
                                    <span class="price" style="font-size: 24px">899.00</span>
                                </span>
                            </div>
                        </div>
                    </div>
                </div>-->
            </div>
        </div>
        <nav class="text-center">
            <nav class=" text-center">
                <ul class="pagination" style="margin: 0">
                    <li><a href="/user/1?page=1">首页</a></li>
                    <li><a href="/user/1?page=1">上一页</a></li>
                    <li><a href="/user/1?page=1">1</a></li>
                    <li class="active"><a href="/user/1?page=2">2</a></li>
                    <li><a href="/user/1?page=3">3</a></li>
                    <li><a href="/user/1?page=3">下一页</a></li>
                    <li><a href="/user/1?page=3">尾页</a></li>
                </ul>
            </nav>
        </nav>
    </div>
    <#include "../common/footer.ftl">
</div>

<!-- 侧边栏快捷操作 -->
<#include "../common/sidebar.ftl">

<script language="javascript" type="text/javascript">
    var avatarUrl = 'http://scb1a9q0-sb.qiqiuyun.net/files/2015/05-08/largeavatar8b2f154d.jpg',
            avatarPic = avatarUrl.replace('http:', 'http://' + window.location.host)
    zhuge.identify('', {
        name: '',
        avatar: avatarPic
    });
    zhuge.track('页面打开', {
        '页面名称': document.title
    });
    function zhugeTrack(evName, obj) {
        zhuge.track(evName, obj)
    }
</script>

<#include "../common/login-modal.ftl">

</body>
</html>