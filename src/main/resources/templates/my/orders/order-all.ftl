<!DOCTYPE html>
<!-- saved from url=(0035)http://www.chinahadoop.cn/my/orders -->
<html lang="zh_CN"><!--<![endif]-->
<#include "../../common/head.ftl">
<body onbeforeunload="return CheckUnsave();" class="">
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
<#include "../../common/header-login.ftl">

    <div id="content-container" class="container">
        <div class="row">
            <#include "../../common/account-sidenav.ftl">
            <div class="col-md-9">
                <div class="es-section h400">
                    <div class="section-header"><h3>我的订单</h3></div>
                    <ul class="nav nav-pills" role="tablist">
                        <li role="presentation" class="active">
                            <a href="http://www.chinahadoop.cn/my/orders?status=">全部订单</a>
                        </li>
                        <li role="presentation">
                            <a href="http://www.chinahadoop.cn/my/orders?status=created">待付款
                                <span class="badge">0</span>
                            </a>
                        </li>
                        <li role="presentation">
                            <a href="http://www.chinahadoop.cn/my/orders?status=paid">已付款</a>
                        </li>
                    </ul>
                    <br>

                    <form id="user-search-form" class="form-inline well well-sm" action="http://www.chinahadoop.cn/my/orders" method="get" novalidate="">
                        <input type="hidden" name="status" value="">
                        <div class="form-group">
                            <select class="form-control" name="lastHowManyMonths" onchange="submit();">
                                <option value="oneWeek">最近一周</option>
                                <option value="twoWeeks">最近两周</option>
                                <option value="oneMonth">最近一个月</option>
                                <option value="twoMonths">最近两个月</option>
                                <option value="threeMonths">最近三个月</option>
                                <option value="" selected="selected">全部记录</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select class="form-control" name="payWays" onchange="submit();">
                                <option value="alipay">支付宝</option>
                                <option value="wxpay">微信支付</option>
                                <option value="heepay">网银支付</option>
                                <option value="quickpay">快捷支付</option>
                                <option value="llpay">连连支付</option>
                                <option value="bankpay">银行直付</option>
                                <option value="none">其他支付</option>
                                <option value="" selected="selected">支付方式</option>
                            </select>
                        </div>
                    </form>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover" id="orders-table">
                            <thead>
                            <tr>
                                <th>订单名称</th>
                                <th>创建时间</th>
                                <th>状态</th>
                                <th>实付(元)</th>
                                <th>支付方式
                                    <span data-toggle="popover" class="glyphicon glyphicon-question-sign color-gray text-sm js-pay-way-popover"></span>
                                    <div class="popover-content hidden" style="width:100px;">
                                        <div class="popover-item">
                                            <div class="content">站外支付为该笔订单是通过导入或者手动添加的方式产生的，故为站外支付</div>
                                        </div>
                                    </div>
                                </th>
                                <th style="min-width:100px">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr id="order-table-180648" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/526" target="_blank">
                                        <strong>购买课程《面试算法中的字符串——邹博》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017102115434353224</span>
                                </td>
                                <td><span class="text-muted text-sm">2017-10-21 15:43:43</span></td>
                                <td><span class="text-muted">已关闭</span>
                                </td>
                                <td><span class="money-text">9.90</span></td>
                                <td>
                                    --
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/180648/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-180647" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/1049" target="_blank">
                                        <strong>购买课程《《用Python进行员工离职原因分析及预测》》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017102115423020729</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-21 15:42:30</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td>
                                    <span class="money-text">0.00</span>
                                </td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-21 15:42:30</span>
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/180647/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-180646" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/1040" target="_blank">
                                        <strong>购买课程《零基础Python入门》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017102115400293793</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-21 15:40:02</span>
                                </td>
                                <td>
                                    <span class="text-muted">已关闭</span>
                                </td>
                                <td>
                                    <span class="money-text">299.00</span>
                                </td>
                                <td>
                                    --
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/180646/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-175220" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/4" target="_blank">
                                        <strong>购买课程《手把手教你玩转小米Minos——小米武泽胜》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017101020540218952</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-10 20:54:02</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td>
                                    <span class="money-text">0.00</span>
                                </td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-10 20:54:02</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/175220/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-173868" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/136" target="_blank">
                                        <strong>购买课程《机器智能和2%的人类——吴军》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017100913444538997</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-09 13:44:45</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td>
                                    <span class="money-text">0.00</span>
                                </td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-09 13:44:45</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/173868/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-173867" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/528" target="_blank">
                                        <strong>购买课程《备战数学建模地区赛》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017100913425564564</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-09 13:42:55</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td><span class="money-text">0.00</span></td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-09 13:42:55</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/173867/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-173252" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/12" target="_blank">
                                        <strong>购买课程《Hadoop/HBase实践及修改——冼茂源》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017100614404038685</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-06 14:40:40</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td><span class="money-text">0.00</span></td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-06 14:40:40</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal"
                                           data-target="#modal" data-url="/my/order/173252/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-173251" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/1017" target="_blank">
                                        <strong>购买课程《普通程序员如何转型到人工智能领域》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017100614401037217</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-10-06 14:40:10</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td>
                                    <span class="money-text">0.00</span></td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-10-06 14:40:10</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/173251/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-144835" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/986" target="_blank">
                                        <strong>购买课程《实用机器学习方法——集成学习》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：C2017080501504386132</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-8-05 01:50:43</span>
                                </td>
                                <td>
                                    <span class="label label-success">已付款</span>
                                </td>
                                <td>
                                    <span class="money-text">0.00</span>
                                </td>
                                <td>
                                    --
                                    <br>
                                    <span class="text-muted text-sm">2017-8-05 01:50:43</span>
                                </td>
                                <td>

                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/144835/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            <tr id="order-table-144834" style="word-break: break-all;word-wrap: break-word;">
                                <td>
                                    <a href="http://www.chinahadoop.cn/course/993" target="_blank">
                                        <strong>购买班级《《CTA投资与程序化交易》第一期》</strong>
                                    </a>
                                    <br>
                                    <span class="text-muted text-sm">订单号：CR2017080501445247453</span>
                                </td>
                                <td>
                                    <span class="text-muted text-sm">2017-8-05 01:44:52</span>
                                </td>
                                <td>
                                    <span class="text-muted">已关闭</span>
                                </td>
                                <td>
                                    <span class="money-text">899.00</span>
                                </td>
                                <td>
                                    --
                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a href="javascript:;" class="btn btn-sm btn-default" data-toggle="modal" data-target="#modal" data-url="/my/order/144834/detail">详情</a>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>

<#include "../../common/footer.ftl">
</div>
<!-- 侧边栏快捷操作 -->
<#include "../../common/sidebar.ftl">

<script language="javascript" type="text/javascript">
    var avatarUrl = 'http://scb1a9q0-sb.qiqiuyun.net/files/user/2017/10-28/144327f261a2577162.jpg',
            avatarPic = avatarUrl.replace('http:', 'http://' + window.location.host)
    zhuge.identify('60992', {
        name: 'xuebusi',
        avatar: avatarPic
    });
    zhuge.track('页面打开', {
        '页面名称': document.title
    });
    function zhugeTrack(evName, obj) {
        zhuge.track(evName, obj)
    }
</script>

<div id="login-modal" class="modal" data-url="/login/ajax"></div>
<div id="modal" class="modal" aria-hidden="true" style="display: none;">
    <div class="modal-dialog ">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h2 class="modal-title">订单详情</h2>
            </div>
            <div class="modal-body">


                <div class="tab-content">

                    <div class="tab-pane fade active in" id="detail">
                        <table class="table table-striped order-table">
                            <tbody>
                            <tr>
                                <th width="25%">订单号</th>
                                <td width="75%">C2017102115434353224</td>
                            </tr>
                            <tr>
                                <th width="25%">订单状态</th>
                                <td width="75%">
                                    已关闭
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">订单名称</th>
                                <td width="75%">
                                    购买课程《面试算法中的字符串——邹博》
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">购买者</th>
                                <td width="75%">
                                    <strong> <a href="javascript:;" role="show-user" data-toggle="modal"
                                                data-target="#modal"
                                                data-url="http://www.chinahadoop.cn/admin/user/60992">xuebusi</a>
                                    </strong>
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">购买者绑定手机号</th>
                                <td width="75%">
                                    暂无
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">购买者邮箱</th>
                                <td width="75%">
                                    2753686693@qq.com
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">订单价格</th>
                                <td width="75%">
                                    <span class="money-text">9.90</span>
                                    元
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">优惠码</th>
                                <td width="75%">
                                    无
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">优惠金额</th>
                                <td width="75%">
                                    <span class="money-text">0.00</span>
                                    元
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">
                                    金币支付
                                </th>
                                <td width="75%">
                                    <span class="money-text">0.00</span> 金币
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">现金支付</th>
                                <td width="75%">
                                    <span class="money-text">9.90</span> 元
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">支付方式</th>
                                <td width="75%">
                                    微信支付
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">银行编号</th>
                                <td width="75%">
                                    暂无
                                </td>
                            </tr>
                            <tr>
                                <th width="25%">创建时间</th>
                                <td width="75%">2017-10-21 15:43:43</td>
                            </tr>
                            <tr>
                                <th width="25%">特殊操作</th>
                                <td width="75%">--</td>
                            </tr>
                            <tr>
                                <th width="25%">操作备注</th>
                                <td width="75%">--</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                    <div class="tab-pane fade" id="log">
                        <table class="table">
                            <thead>
                            <tr>
                                <th width="50%">日志信息</th>
                                <th width="25%">操作人</th>
                                <th width="25%">创建时间</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>
                                    创建订单
                                    <br>
                                    <span class="text-muted text-sm">created</span>
                                </td>
                                <td>
                                    <a href="javascript:;" role="show-user" data-toggle="modal" data-target="#modal"
                                       data-url="http://www.chinahadoop.cn/admin/user/60992">xuebusi</a>

                                </td>
                                <td>
                                    2017-10-21 15:43
                                    <br>
                                    <span class="text-muted text-sm">123.119.223.206</span>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    系统自动取消
                                    <br>
                                    <span class="text-muted text-sm">cancelled</span>
                                </td>
                                <td>
                                    <a href="javascript:;" role="show-user" data-toggle="modal" data-target="#modal"
                                       data-url="http://www.chinahadoop.cn/admin/user/102306">祺少17o</a>

                                </td>
                                <td>
                                    2017-10-23 15:41
                                    <br>
                                    <span class="text-muted text-sm">113.108.186.130</span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>

            </div>
            <div class="modal-footer">
                <div>
                    <button type="button" class="btn btn-primary" data-dismiss="modal">关闭</button>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="attachment-modal" class="modal"></div>

<script>
    var app = {};
    app.debug = false;
    app.version = '11.0.2.5';
    app.httpHost = 'http://www.chinahadoop.cn';
    app.basePath = '//scb1a9q0-sb.qiqiuyun.net';
    app.theme = 'jianmo';
    app.themeGlobalScript = 'theme/global-script';
    app.jsPaths = {
        "common": "common",
        "theme": "\/\/scb1a9q0-sb.qiqiuyun.net\/themes\/jianmo\/js",
        "schoolgatebundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/schoolgate\/js",
        "discountbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/discount\/js",
        "moneycardbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/moneycard\/js",
        "chargecoinbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/chargecoin\/js",
        "homeworkbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/homework\/js",
        "userimporterbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/userimporter\/js",
        "gracefulthemebundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/gracefultheme\/js",
        "questionplusbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/questionplus\/js",
        "vipbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/vip\/js",
        "couponbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/coupon\/js",
        "customwebbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/customweb\/js",
        "customadminbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/customadmin\/js",
        "topxiawebbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/topxiaweb\/js",
        "topxiaadminbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/topxiaadmin\/js",
        "classroombundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/classroom\/js",
        "materiallibbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/materiallib\/js",
        "sensitivewordbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/sensitiveword\/js",
        "permissionbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/permission\/js",
        "orgbundle": "\/\/scb1a9q0-sb.qiqiuyun.net\/bundles\/org\/js"
    };

    app.crontab = '/common/crontab';

    var CKEDITOR_BASEPATH = app.basePath + '/assets/libs/ckeditor/4.6.7/';
    var CLOUD_FILE_SERVER = "";

    app.config = {
        "api": {
            "weibo": {"key": "3735672790"},
            "qq": {"key": "101291257"},
            "douban": {"key": ""},
            "renren": {"key": ""}
        },
        "cloud": {
            "video_player": "http:\/\/cdn.staticfile.org\/GrindPlayerCN\/1.0.2\/GrindPlayer.swf",
            "video_player_watermark_plugin": "http:\/\/cdn.staticfile.org\/GrindPlayerCN\/1.0.2\/Watermake-1.0.3.swf",
            "video_player_fingerprint_plugin": "http:\/\/cdn.staticfile.org\/GrindPlayerCN\/1.0.2\/Fingerprint-1.0.1.swf"
        },
        "loading_img_path": "\/\/scb1a9q0-sb.qiqiuyun.net\/assets\/img\/default\/loading.gif?11.0.2.5"
    };

    app.arguments = {};
    app.controller = 'my/orders';

    app.scripts = ["default\/header.js", "es-bar\/index", "notification\/notification"];

    app.uploadUrl = '/file/upload';
    app.imgCropUrl = '/file/img/crop';
    app.lessonCopyEnabled = '1';
    app.cloudSdkCdn = '';
    app.mainScript = '//scb1a9q0-sb.qiqiuyun.net/bundles/topxiaweb/js/app.js?11.0.2.5';
    app.lang = 'zh_CN';
</script>
<script src="./orders_files/translator.min.js.下载"></script>
<script src="./orders_files/js"></script>
<script src="./orders_files/sea.js.下载"></script>
<script src="./orders_files/seajs-style.js.下载"></script>
<script src="./orders_files/seajs-text.min.js.下载"></script>
<script src="./orders_files/seajs-global-config.js.下载"></script>
<script>
    seajs.use(app.mainScript);
</script>

</body>
</html>