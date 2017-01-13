/**
 * Copyright: 2016 Haiziwang
 **
 * Author:  Daniel Kong
 * Date:    2016-05-09
 */

'use strict';

var API_HOST = 'http://kwms.haiziwang.com';
var API_PORT = '80';
var API_BASE = '/api';

wmsApp.constant('WMS_API_PROVIDER', API_HOST ? (API_HOST + ':' + API_PORT) : '');
wmsApp.constant('WMS_API_END_POINT', API_BASE);

/**
 * 弹框配置
 */
wmsApp.config(['PopupProvider', function (PopupProvider) {
    PopupProvider.title = '提示';
    PopupProvider.okValue = '确定';
    PopupProvider.cancelValue = '取消';
}]);