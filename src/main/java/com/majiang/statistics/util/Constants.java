package com.majiang.statistics.util;

import static java.time.temporal.ChronoField.MILLI_OF_DAY;

import java.time.LocalDateTime;

/**
 * @author 朱礼
 * @Date 2019/4/15
 * @Desc
 */
public class Constants {

    public static final class Common {
        /**
         * 设备离线
         */
        public static final String OFFLINE = "offline";
        /**
         * 指令下行
         */
        public static final String DOWN = "down";
        /**
         * 指令上行
         */
        public static final String UPLINK = "uplink";
        public static final String UPLINK_ANALYSIS = "analysis";
        public static final String LOGIN = "login";

        /**
         * updatesSingleDevice 更新子设备缓存，方法中用到的常量
         */
        public static final String METHOD_GET = "get";
        public static final String METHOD_STRING = "class java.lang.String";
        public static final String METHOD_INTEGER = "class java.lang.Integer";
        public static final String METHOD_DOUBLE = "class java.lang.Double";
        public static final String METHOD_BOOLEAN = "class java.lang.Boolean";
        public static final String METHOD_DATE = "class java.util.Date";
        public static final String METHOD_SHORT = "class java.lang.Short";
        public static final String METHOD_LONG = "class java.lang.Long";
        public static final String METHOD_FLOAT = "class java.lang.Float";
        public static final String METHOD_LIST = "java.util.List<java.lang.String>";
        public static final String SPLIT = ",";
        public static final String FILE_TYPE_HTTP = "http";
        /**
         * 百分值
         */
        public static final int PERCENT_VALUE = 100;
        /**
         * 数字常量
         */
        public static final Integer INTEGER_4 = 4;
        public static final Integer INTEGER_2 = 2;
        public static final Integer INTEGER_3 = 3;
        public static final Integer INTEGER_5 = 5;
        public static final Integer INTEGER_6 = 6;
        public static final Integer INTEGER_14 = 14;
        public static final Integer INTEGER_80 = 80;
        public static final Integer INTEGER_400 = 400;
        public static final Integer INTEGER_16 = 16;
        /**
         * 失效时间60秒
         */
        public static final Integer EXPIRE_TIME = 120;
        /**
         * 文件下载地址
         */
        public static final String FILE_DOWNLOAD = "/screenFile/";
        public static final String CONTENT_HEAD = "Content-Length";
        public static final String HEAD = "HEAD";
    }

    public static final class ItcRes {
        public static final String ITC_COMMAND_STATUS = "send ok";
        public static final String ITC_PLAY_CONTROL_STATUS = "ok";
        public static final String CLOSE = "close";
        public static final String START = "start";
    }

    public static final class ItcApi {
        /**
         * 实时广播接口
         */
        public static final String REAL_CAST_API = "/v2/audio/call.json";
        /**
         * 媒体播放接口
         */
        public static final String MEDIA_PLAY = "/v2/audio/play_media.json";
        /**
         * 媒体播放控制接口
         */
        public static final String MEDIA_PLAY_CONTROL = "/v2/calls/play_control.json";
        /**
         * 临时媒体任务音量控制
         */
        public static final String MEDIA_VOLUME_CONTROL = "/v2/calls/change_volume.json";
        /**
         * 设备音量控制
         */
        public static final String CHANGE_VOLUME_CONTROL = "/v2/calls/change_terainml_vol.json";

        /**
         * 临时媒体任务更新接口
         */
        public static final String MEDIA_TASK_UPDATE = "/v2/calls/task_update.json";
        /**
         * 更新临时音乐音量的接口
         */
        public static final String MEDIA_VOL_CHANGE = "/v2/calls/change_volume.json";
        /**
         * 获取当前所有的会话信息列表
         */
        public static final String GET_ALL_CALLS = "/v2/calls.json";
        /**
         * 关闭实时音乐
         */
        public static final String CLOSE_BROADCAST_CALL = "/v2/audio/call_close.json";

        /**
         * 开启广播
         */
        public static final String START_BROADCAST_METHOD = "realCast";

        /**
         * 关闭广播
         */
        public static final String STOP_BROADCAST_METHOD = "closeBroadCast";

        /**
         * 音量控制
         */
        public static final String SET_SETTER_VOLUME = "setterVolume";

    }

    public static final class MingZhi {
        /**
         * 0时区的偏移量
         * 在设备推送所有信息时，巡检时间需要减去这个偏移量
         */
        public static final Long TIME_ZONE_8 = 28800000L;
        /**
         * 明智单灯1281端口
         */
        public static final String PORT_1281 = "1281";
        /**
         * 明智单灯成功ack码
         */
        public static final String SUCCESS_ACK = "00";
        public static final String VALUE_00 = "00";
        /**
         * 调光指令返回
         */
        public static final String CODE_HEX_26 = "26";
        /**
         * 设置天文时钟时控计划返回
         */
        public static final String CODE_HEX_10 = "10";
        /**
         * 单灯所有信息返回(数据上报)
         */
        public static final String CODE_HEX_3F = "3F";
        /**
         * 心跳返回
         */
        public static final String CODE_HEX_0A = "0A";
        /**
         * 删除集中器时控计划返回
         */
        public static final String CODE_HEX_14 = "14";
        /**
         * 时间同步设备返回
         */
        public static final String CODE_HEX_11 = "11";
        /**
         * 服务器与控台信息同步返回
         */
        public static final String CODE_HEX_BF = "BF";

        /**
         * 同步设备返回
         */
        public static final String CODE_HEX_C0 = "C0";

        public static final String TRUE = "true";
    }

    /**
     * 世邦平台url及参数定义
     */
    public static final class Spon {
        /**
         * 添加任务
         */
        public static final String TASK_ADD_CONTROL = "/php/addtaskinfo.php";
        /**
         * 修改任务
         */
        public static final String TASK_MODIFY_CONTROL = "/php/modifytaskinfo.php";
        /**
         * 世邦接口url 执行任务
         */
        public static final String TASK_CONTROL = "/php/exetaskcmd.php";
        /**
         * 添加终端
         */
        public static final String NEW_TERMINIAL_CONTROL = "/php/newterminal.php";
        /**
         * 删除终端
         */
        public static final String DELTERMINAL_CONTROL = "/php/delterminal.php";
        /**
         * 设置终端音量到设备
         */
        public static final String SETTERMINAL_CONTROL = "/php/setterminal.php";
        /**
         * 设置终端音量实时
         */
        public static final String REALTIME_SETTERMINAL_CONTROL = "/php/settervolume.php";
        /**
         * /**
         * 终端控制
         */
        public static final String TERIMINAL_CONTROL = "/php/exesdkcommand.php";

        public static final String EXE_REAL_PLAY_FILE = "/php/exeRealPlayFile.php";

        public static final Integer SET_VOLUME_ERROR = 100;
        public static final String SPON_RESPONSE = "1";
        public static final String SPON_RESPONSE_ERROR = "0";
        public static final String SPON_REGUX = "^[0-9]*$";
        public static final String SPON_PARAM_TID = "jsondata[tid]";
        public static final String SPON_PARAM_TRID = "jsondata[terid]";
        public static final String SPON_PARAM_TBCOUTV = "jsondata[tbcoutv]";
        public static final String SPON_PARAM_BCOUTV = "jsondata[bcoutv]";
        public static final String SPON_PARAM_TERMINAL_LEVEL = "jsondata[tterminallevel]";
        public static final String SPON_PARAM_TERMINAL_LEVEL_VALUE = "14";
        public static final String SPON_PARAM_TERMINAL_COMMAND = "jsondata[commands]";
        public static final String SPON_PARAM_DEL_TASKCOMMAND = "jsondata[taskCommand]";
        public static final String SPON_PARAM_DEL_TASKCOMMAND_VALUE = "deltaskinfo";
        public static final String SPON_PARAM_RTYPE = "jsondata[rtype]";
        public static final String SPON_PARAM_2 = "jsondata[param2]";
        public static final String SPON_PARAM_8 = "jsondata[param8]";
        public static final String SPON_TERMINAL_LEVEL_MAX_VALUE = "15";
        public static final String SPON_PARAM_BROADCAST_LEVEL = "jsondata[tbctlevel]";
        public static final String SPON_PARAM_TALKBACK_LEVEL = "jsondata[ttalklevel]";
        public static final String SPON_PARAM_MEETING_LEVEL = "jsondata[tmeetinglevel]";
        public static final String SPON_PARAM_MONITOR_LEVEL = "jsondata[tmonlevel]";
        public static final String SPON_BROADCAST_LEVEL_VALUE = "3";
        public static final String SPON_TALKBACK_LEVEL_VALUE = "4";
        public static final String SPON_MEETING_LEVEL_VALUE = "1";
        public static final String SPON_MONITOR_LEVEL_VALUE = "2";
        public static final String SPON_PARAM_ID = "jsondata[id]";
        /**
         * 世邦事件类型 设备注册
         */
        public static final String SPON_TYPE_1 = "1";
        /**
         * 世邦事件类型 设备对讲
         */
        public static final String SPON_TYPE_2 = "2";
        /**
         * 世邦事件类型 设备广播或播放音乐
         */
        public static final String SPON_TYPE_4 = "4";
        /**
         * 世邦是否为发起方:  1 发起方, 0接收方
         */
        public static final String SPON_ISHOST_1 = "1";

        public static final String SPON_STATUS_0 = "0";
        public static final String SPON_STATUS_1 = "1";
        public static final String SPON_STATUS_2 = "2";

        /**
         * 世邦登录
         */
        public static final String SPON_REGISTER_ON_LINE = "1";
        /**
         * 世邦注销
         */
        public static final String SPON_REGISTER_OFF_LINE = "2";
        /**
         * 世邦返回的状态(0：停止 2：接收广播中 3： 发起广播中)
         */
        public static final String SPON_RETURN_STATUS_STOP = "0";
        public static final String SPON_RETURN_STATUS_PLAYING = "2";
        public static final String SPON_RETURN_STATUS_INITIAING = "3";

        /**
         * 音源类型（0：文件；1：终端；
         * 2：声卡；3：文本）
         */
        public static final String SPON_VOICE_TYPE = "3";

        /**
         * startbct(开始广播)
         */
        public static final String SPON_RTYPE = "startbct";

        /**
         * 广播文本速度【-10 到10，默
         * 认为0，正常语速】（音源类型
         * 为“3”时有效）
         */
        public static final String SPON_BROADCAST_TEXT_SPEED = "-1,1.0,1.0";
    }

    public static final class Nova {
        /**
         * 文件续发成功
         */
        public static final String FILE_SEND_BLOCK_OK = "3";
        /**
         * 文件续发失败
         */
        public static final String FILE_SEND_BLOCK_ERROR = "4";
        /**
         * 文件推送到显示屏上的每条字节数
         */
        public static final Integer FILE_RATE = 500000;
        /**
         * 一次发送的字节大小
         */
        public static final int SCREEN_MAX_BLOCK_SIZE = 0xFFFF;
        /**
         * 同一个通道某一个所有文件下发完成
         */
        public static final String FILE_END_ALL = "2";
        /**
         * 同一个通道某一个文件下发完成继续下发下一个文件
         */
        public static final String FILE_END_NEXT = "1";
        public static final String DEVICE_BUSY = " 文件下发中，暂无法控制！";
        public static final String CHANNEL_NO_EXIST = " 设备断线，请稍后重试！";
    }

    /**
     * itc参数key
     */
    public static final class ItcParamKey {
        /**
         * 实时广播参数键
         */
        public static final String SEND_TERMINAL = "send_terminal";
        public static final String RECIVE_TERMINAL = "recive_terminal";
        public static final String ID = "id";

        /**
         * 临时媒体任务参数键
         */
        public static final String RAND = "rand";
        public static final String MEDIUM_IDS = "medium_ids";
        public static final String PLAY_MODE = "play_mode";
        public static final String VOL = "vol";
        public static final String DURATION = "duration";
        public static final String DIAL_NOS = "dial_nos";

        /**
         * 媒体控制参数键
         */
        public static final String INTERNAL_NAME = "internal_name";
        public static final String DATA_TYPE = "data_type";

        /**
         * 音量批量控制参数键
         */
        public static final String EXTEN = "exten";

        /**
         * 上线
         */
        public static final byte ON = 1;
        /**
         * 下线
         */
        public static final byte OFF = 2;
        /**
         * 对讲
         */
        public static final byte TALK_BACK = 3;
        /**
         * 求助
         */
        public static final byte FOE_HELP = 4;
        /**
         * 空闲
         */
        public static final byte IDLE = 5;
    }

    public static final class MonitorHoolink {

        /*** 升级默认时间戳,只做常量标志 */
        public static final Long UPGRADE_DEFAULT_TIME = LocalDateTime.MAX.getLong(MILLI_OF_DAY);

        /*** 升级版本的通配符 */
        public static final String UPGRADE_VERSION_PATTERN = "\\d+.\\d+.\\d+";

        /*** 升级包最大传输值 */
        public static final int UPGRADE_PACKAGE_MAX = 256;

        /*** .的转义字符 */
        public static final String POINT_ESCAPE = "\\.";

        /*** 登录返回帧头的长度 */
        public static final int LOGIN_BACK_FRAME_HEAD_LENGTH = 16;

        /*** 登录报文的最小长度 */
        public static final int LOGIN_FRAME_MIN_LENGTH = 23;

        /*** 升级文件包头长度 */
        public static final int UPGRADE_FILE_HEAD_LENGTH = 64;

        /*** 升级文件包头设备类型起始位 */
        public static final int UPGRADE_FILE_HEAD_DEVICE_TYPE_BIT = 44;

        /*** 升级文件包头版本起始位 */
        public static final int UPGRADE_FILE_HEAD_VERSION_BIT = 46;

        /*** 升级设备MAC缓存redis失效时间 5分钟 */
        public static final int UPGRADE_DEVICE_MAC_REDIS_INVALID_TIME = 5;

        public static final String CODE_HEX_00 = "00";
        public static final String CODE_HEX_A1 = "A1";
        public static final String CODE_HEX_A2 = "A2";
        public static final String CODE_HEX_A3 = "A3";
        public static final String CODE_HEX_F1 = "F1";
        public static final String CODE_HEX_80 = "80";
        public static final String CODE_HEX_01 = "01";
        public static final String CODE_HEX_02 = "02";
        public static final String CODE_HEX_03 = "03";
        public static final String CODE_HEX_10 = "10";
        public static final String CODE_HEX_11 = "11";
        public static final String CODE_HEX_12 = "12";
        public static final String CODE_HEX_13 = "13";
        public static final String CODE_HEX_14 = "14";
        public static final String CODE_HEX_20 = "20";
        public static final String CODE_HEX_0D = "0D";
        public static final String CODE_HEX_0E = "0E";
        public static final String CODE_HEX_0F = "0F";
        public static final String CODE_HEX_A0 = "A0";
        public static final String CODE_HEX_06 = "06";
        public static final int DATA_AREA_8 = 8;
        public static final int DATA_AREA_6 = 6;
        public static final int DATA_AREA_26 = 26;
        public static final int DATA_AREA_10 = 10;
        public static final int DATA_AREA_80 = 80;

    }

    /**
     * 迈可行厂商常量
     */
    public static final class Micro {
        /**
         * 返回成功
         */
        public static final String MICRO_RESPONSE_SUCCESS = "0";
        /**
         * 返回失败
         */
        public static final String MICRO_RESPONSE_FAIL = "1";
        /**
         * 登录API
         */
        public static final String API_LOGIN = "/bccontrol/bc_third_login.action";
        /**
         * 用户名
         */
        public static final String PARAM_USER_NAME = "userName";
        /**
         * 密码
         */
        public static final String PARAM_PASSWORD = "passWord";
        /**
         * 秘钥ID
         */
        public static final String PARAM_KEY_ID = "keyId";
        /**
         * 登录IP
         */
        public static final String PARAM_LOGIN_IP = "loginIP";
        /**
         * 登录MAC
         */
        public static final String PARAM_LOGIN_MAC = "loginMAC";
        /**
         * 当前时间
         */
        public static final String PARAM_TIME = "time";
        /**
         * 心跳API
         */
        public static final String API_HEARTBEAT = "/bccontrol/bc_keepHeart.action";
        /**
         * 广播室编号
         */
        public static final String PARAM_ROOM_ID = "roomId";
        /**
         * 广播类型
         */
        public static final String PARAM_EMERGENCY_FLAG = "emergencyFlag";
        /**
         * 支持电话呼入标志
         */
        public static final String PARAM_PHONE_FLAG = "phoneFlag";
        /**
         * 电话呼入密码
         */
        public static final String PARAM_PHONE_PWD = "phonePwd";
        /**
         * 备注
         */
        public static final String PARAM_COMMENT = "comment";
        /**
         * 客户端IP
         */
        public static final String PARAM_SRC_IP = "srcIp";
        /**
         * 创建广播室API
         */
        public static final String API_CREATE_ROOM = "/bccontrol/bc_createRoom.action";
        /**
         * UTF-8
         */
        public static final String UTF_8 = "UTF-8";
        /**
         * 登录用户名
         */
        public static final String PARAM_LOGIN_NAME = "loginName";
        /**
         * 删除广播室API
         */
        public static final String API_DELETE_ROOM = "/bccontrol/bc_daleteRoomInfo.action";
        /**
         * 广播室ID
         */
        public static final String PARAM_BC_ID = "bcId";
        /**
         * 终端编号
         */
        public static final String PARAM_DEV_NO = "devNo";
        /**
         * 加入广播室API
         */
        public static final String API_JOIN_ROOM = "/bccontrol/bc_joinRoomSecDev.action";
        /**
         * 离开广播室API
         */
        public static final String API_LEAVE_ROOM = "/bccontrol/bc_leaveRoomSecDev.action";
        /**
         * 是否直播
         */
        public static final String PARAM_REAL_TIME = "real_time";
        /**
         * 文件存储路径
         */
        public static final String PARAM_FILE_NAME_PATH = "file_name_path";
        /**
         * 列表名称
         */
        public static final String PARAM_ATTR_NAME = "attr_name";
        /**
         * 播放模式
         */
        public static final String PARAM_PLAY_MOD = "play_mod";
        /**
         * 播放次数
         */
        public static final String PARAM_FILE_COUNT = "file_count";
        /**
         * 播放音量
         */
        public static final String PARAM_TASK_VOLUME = "task_volume";
        /**
         * 音源模式
         */
        public static final String PARAM_REAL_AUDIO_RSC = "real_audio_src";
        /**
         * 直播码率
         */
        public static final String PARAM_REAL_TIME_BITRATE = "real_time_bitrate";
        /**
         * 开始日期
         */
        public static final String PARAM_START_DATE = "start_date";
        /**
         * 开始时间
         */
        public static final String PARAM_START_TIME = "start_time";
        /**
         * 结束日期
         */
        public static final String PARAM_END_DATE = "end_date";
        /**
         * 结束时间
         */
        public static final String PARAM_END_TIME = "end_time";
        /**
         * 星期播放日
         */
        public static final String PARAM_WEEK_USE = "week_use";
        /**
         * 添加播放列表API
         */
        public static final String API_ADD_PLAY_LIST = "/bccontrol/bc_addPlayList.action";
        /**
         * 播放列表ID
         */
        public static final String PARAM_LIST_ID = "list_id";
        /**
         * 播放类型
         */
        public static final String PARAM_TYPE = "type";
        /**
         * 添加播放列表API
         */
        public static final String API_PLAY_CTRL = "/bccontrol/bc_playCtrlPlayList.action";
        /**
         * 终端ID
         */
        public static final String PARAM_DEV_IDS = "devIds";
        /**
         * 终端音量
         */
        public static final String PARAM_DEV_VOLUME = "devVolume";
        /**
         * 终端开关
         */
        public static final String PARAM_DEV_SWITCH_STATE = "devSwitchState";
        /**
         * 批量设置终端音量和开关API
         */
        public static final String API_BATCH_UPDATE_DEV_VOLUME = "/bccontrol/bc_updateDevMore.action";
        /**
         * 终端编号
         */
        public static final String PARAM_DEV_NUM_LIST = "devNums";
        /**
         * 分区ID
         */
        public static final String PARAM_SECTOR_ID = "sectorId";
        /**
         * 分配终端到分区API
         */
        public static final String API_ADD_DEV_TO_SECTOR = "/bccontrol/bc_addDevToSector.action";
        /**
         * 删除终端信息API
         */
        public static final String API_DELETE_DEV_INFO = "/bccontrol/bc_deleteDevInfo.action";
        /**
         * 文件类型
         */
        public static final String PARAM_PRIVATE_STATE = "private_state";
        /**
         * 当前页数
         */
        public static final String PARAM_PAGE = "page";
        /**
         * 每页数据条数
         */
        public static final String PARAM_PER_PAGE = "perPage";
        /**
         * 查询信息
         */
        public static final String PARAM_SEARCH_INFO = "search_info";
        /**
         * 任务类型
         */
        public static final String PARAM_ROOM_TASK = "room_task";
        /**
         * 获取用户广播室信息API
         */
        public static final String API_GET_ROOM_LIST = "/bccontrol/bc_getRoomLists.action";
        /**
         * 任务类型
         */
        public static final String PARAM_TASK_FLAG = "taskFlag";
        /**
         * 获取广播室播放列表信息API
         */
        public static final String API_GET_PLAY_LIST_IN_ROOM = "/bccontrol/bc_getPlayListsInRoom.action";
        /**
         * 查询信息
         */
        public static final String PARAM_CONDITION = "condition";
        /**
         * 常量0
         */
        public static final String STRING_CONSTANT_0 = "0";
        /**
         * 常量1
         */
        public static final String STRING_CONSTANT_1 = "1";
        /**
         * 常量99
         */
        public static final String STRING_CONSTANT_60 = "60";
        /**
         * 字符常量result
         */
        public static final String STRING_CONSTANT_RESULT = "result";
        /**
         * 字符常量reason
         */
        public static final String STRING_CONSTANT_REASON = "reason";
        /**
         * 播放类型常量
         */
        public static final String PLAY_TYPE_CONSTANT = "play";
        /**
         * 停止类型常量
         */
        public static final String STOP_TYPE_CONSTANT = "stop";
        /**
         * 空字符串
         */
        public static final String BLANK_STRING = "";
        /**
         * 获取用户权限下的媒体库文件信息
         */
        public static final String API_GET_MEDIA_FILE_INFO_BY_USER = "/bccontrol/bc_getMediaFileInfosByUser.action";
        /**
         * 获取已加入广播室的终端信息
         */
        public static final String API_GET_DEVICE_INFO_IN_ROOM = "/bccontrol/bc_getDevInfosInRoom.action";
        /**
         * 进入广播室手动模式
         */
        public static final String API_JOIN_MANUAL_MODE = "/bccontrol/bc_setRoomTask.action";
        /**
         * 客户端IP
         */
        public static final String PARAM_IP = "ip";
        /**
         * 客户端IP 设置默认IP
         */
        public static final String DEFAULT_IP = "192.168.1.1";
        /**
         * 广播模式 0：手动 1：定时
         */
        public static final String PARAM_TASK = "task";
        /**
         * 客户端MAC 设置默认IP
         */
        public static final String DEFAULT_MAC = "2C:FD:A1:5D:A7:41";

    }

    public static final class MicrophoneStatus {
        /**
         * 开启
         */
        public static final Boolean OPEN = true;
        /**
         * 关闭
         */
        public static final Boolean CLOSE = false;

    }

    /**
     * 0区块
     */
    public static final Integer NUM_ZERO = 0;

    /**
     * 传参使用(第三方状态)
     * 开启（正在播放）
     */
    public static final String THIRD_BROADCAST_OPEN = "0";

    /**
     * 传参使用(第三方状态)
     * 关闭（停止）
     */
    public static final String THIRD_BROADCAST_CLOSE = "1";

    /**
     * 空闲、在线
     */
    public static final Integer IDLE = 1;

    /**
     * 音乐、广播
     */
    public static final Integer USERING = 2;

    /**
     * 下线
     */
    public static final Integer OFF = 3;

    public static final String START_BROADCAST = "开始广播";
    public static final String STOP_BROADCAST = "关闭广播";
    public static final String CONTROL_VOLUME = "控制音量";

    public static final String START = "start";
    public static final String CLOSE = "close";

    public static final String RES = "res";

    public static final Integer HTTP_OVER_CODE = 400;

}
