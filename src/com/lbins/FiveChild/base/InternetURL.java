package com.lbins.FiveChild.base;

/**
 * Created by liuzwei on 2015/1/12.
 */
public class InternetURL {
    public static final String INTERNAL = "http://zzb.apptech.space/";

    //1 获得秘钥
    public static final String GET_TOKEN_URL = INTERNAL + "json/user/auth";
    //2注册--发送验证码
    public static final String REG_SEND_CODE_URL = INTERNAL + "json/user/sendCode";
    //2注册-校验验证码
    public static final String REG_VERITY_CODE_URL = INTERNAL + "json/user/verifyCode";
    //2注册
    public static final String REG__URL = INTERNAL + "json/user/register";
    //3.登陆
    public static final String LOGIN__URL = INTERNAL + "json/user/login";
    //4.找回密码
    public static final String FORGET_PWR__URL = INTERNAL + "json/user/forgetPassword";
    //5、个人信息 (memberInfo
    public static final String MEMBER__URL = INTERNAL + "json/user/memberInfo";
    //6费用
    public static final String GET_FEE__URL = INTERNAL + "json/fee/lists";

    //学校
    // 1.获取 学校 列表 （l l ist
    public static final String GET_SCHOOL_LISTS__URL = INTERNAL + "json/school/lists";
    //2.学校详细
    public static final String GET_DETAIL_SCHOOL__URL = INTERNAL + "json/school/detail";
    //3.搜索 学校 （s s earch
    public static final String SEARCH_SCHOOL_LISTS__URL = INTERNAL + "json/school/search";
    //4校园动态
    public static final String GET_DYNAMIC_SCHOOL__URL = INTERNAL + "json/school/dynamic";
    //5.求知展示
    public static final String GET_SHOW_SCHOOL__URL = INTERNAL + "json/school/show";
    //6.校园新闻
    public static final String GET_NEWS_SCHOOL__URL = INTERNAL + "json/school/news";
    //7求知
    public static final String GET_QIUZHI__URL = INTERNAL + "json/show/knowledge";
    //8.展示
    public static final String GET_SHOW__URL = INTERNAL + "json/show/show";

    //班级
    // 1.获取 班级 列表 （l l ists
    public static final String GET_CLASS_LISTS__URL = INTERNAL + "json/class/lists";
    //2.获取班级 公告
    public static final String GET_NOTICE__URL = INTERNAL + "json/class/notice";
    //3.获取教师列表
    public static final String GET_TEACHER__URL = INTERNAL + "json/class/teacherList";
    //4.家长联系
    public static final String GET_CLASS_CONTACT__URL = INTERNAL + "json/class/contact";

    //学生
    //成绩
    public static final String GET_RESULT__URL = INTERNAL + "json/child/result";

    //首页
    //1.首页.广告
    public static final String GET_AD__URL = INTERNAL + "json/index/adv";
    //2.签到 (
    public static final String GET_SIGN__URL = INTERNAL + "json/index/signIn";


    //通信
//    1 1 、聊天( ( 环信) )
//    应用标识(AppKey): wqx888aqct# zhangzhongbao
//    注册用户名：登陆返回 uid
//    注册密码：123456
//            2 2 、 获取用户信息列表( (getAllInfo) )
//    方式：POST
//    http://zzb.apptech.space/json/chat/getAllInfo?
    // 获取用户信息列表( (getAllInfo) )
    public static final String GET_HUANXIN__URL = "http://zzb.apptech.space/json/chat/getAllInfo";




    //2多媒体文件获取
    public static final String UPLOAD_FILE_URL = INTERNAL + "json.php/user.api-uploadfile/";
    //3注册
    public static final String REG_URL = INTERNAL + "json.php/user.api-regist/";
    //4发送验证码
    public static final String REG_CARD_URL = INTERNAL + "json.php/user.api-sendCode";
    //5登陆
    public static final String LOGIN_URL = INTERNAL + "json.php/user.api-login";
    //6第三方登陆
    public static final String LOGIN_OTHER_URL = INTERNAL + "json.php/user.api-otherlogin";
    //7找回密码
    public static final String FIND_PWR_URL = INTERNAL + "json.php/user.api-findpasswd";
    //8修改密码
    public static final String UPDATE_PWR_URL = INTERNAL + "json.php/member.api-updatepasswd";
    //9获取会员信息
    public static final String GET_MEMBER_URL = INTERNAL + "json.php/member.api-getBaseInfonByUid";
    //10更新会员个人信息
    public static final String UPDATE_MEMBER_URL = INTERNAL + "json.php/member.api-updateBaseInfoByUid";
    //11轮播图
    public static final String GET_AD_URL = INTERNAL + "json.php/community.api-indexad";
    //12分类列表
    public static final String GET_TYPE_URL = INTERNAL + "json.php/product.api-types";
    //13商城主页
    public static final String GET_SHOP_INDEX_URL = INTERNAL + "json.php/shop.api-index";
    //14商品列表
    public static final String GET_SHOP_PRODUCT_URL = INTERNAL + "json.php/product.api-productList";
    //15产品详情
    public static final String GET_SHOP_PRODUCT_DETAIL_URL = INTERNAL + "json.php/product.api-detail";
    //16下订单
    public static final String SET_ORDER_URL = INTERNAL + "json.php/order.api-order";
    //17取消订单
    public static final String CANCEL_ORDER_URL = INTERNAL + "json.php/order.api-ordercancel";
    //18订单列表
    public static final String LIST_ORDER_URL = INTERNAL + "json.php/order.api-orderlist";
    //19我的关注
    public static final String MINE_GUANZHU_URL = INTERNAL + "json.php/member.api-myfollow";
    //朋友圈发布
    public static final String ADD_RECORD_URL = INTERNAL + "index/ServiceJson/pypush";
    //朋友圈首页
    public static final String LIST_RECORD_URL = INTERNAL + "index/ServiceJson/pylist";
    //朋友圈喜爱操作
    public static final String ADD_FAVOUR_RECORD_URL = INTERNAL + "index/ServiceJson/toFavour";
    //朋友圈评论
    public static final String ADD_COMMENT_RECORD_URL = INTERNAL + "index/ServiceJson/tocomment";
    //查询好友
    public static final String FIND_MEMBER_URL = INTERNAL + "json.php/friends.api-searchByName";
    //收藏产品
    public static final String FAVOUR_LOVE_URL = INTERNAL + "json.php/product.api-love";
    //.添加或修改收获地址
    public static final String ADDRESS_ADD_UPDATE_URL = INTERNAL + "json.php/member.api-addAddress";
    //收获地址列表
    public static final String ADDRESS_LIST_URL = INTERNAL + "json.php/member.api-addresses";
    //
//    public static final String ADD_COMMENT_RECORD_URL = INTERNAL + "index/ServiceJson/tocomment";


}
