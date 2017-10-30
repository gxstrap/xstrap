<style>
    .nav.nav-tabs > li > a {
        padding: 5px 30px 15px;
    }

    @media (max-width: 1199px) {
        .nav.nav-tabs > li > a {
            padding: 5px 10px 10px;
            font-size: 14px;
        }
    }
</style>
<ul class="nav nav-tabs clearfix">
    <li class="active"><a href="/user/${(user.id)!}/about">个人介绍</a></li>
    <li><a href="/user/${(user.id)!}/teach">在教课程</a></li>

    <li><a href="/user/${(user.id)!}/teaching/classrooms">在教班级</a></li>
    <li><a href="/user/${(user.id)!}/learn">在学课程</a></li>
    <li><a href="/user/${(user.id)!}/learning/classrooms">在学班级</a></li>


    <li><a href="/user/${(user.id)!}/favorited">收藏课程</a></li>
    <li><a href="/user/${(user.id)!}/group">加入小组</a></li>
    <li><a href="/user/${(user.id)!}/following">关注&nbsp;/&nbsp;粉丝</a></li>
    <li class="highlight" style="left: 248px; width: 124px;"></li>
</ul>