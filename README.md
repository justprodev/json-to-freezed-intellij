[![Version](https://img.shields.io/jetbrains/plugin/v/16971-dartjsongenerator.svg)](https://plugins.jetbrains.com/plugin/16971-dartjsongenerator)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/16971-dartjsongenerator.svg)](https://plugins.jetbrains.com/plugin/16971-dartjsongenerator)

### Generating [freezed](https://pub.dev/packages/freezed) models with [json_serializable](https://pub.dev/packages/freezed#fromjsontojson) support from JSON examples.

Generating from the *New* menu:

![new](/screenshots/new.png)

Generating from the *Generate* menu:

![new](/screenshots/generate.png)

Generating dialog:

![new](/screenshots/dialog.png)

JSON:
```json
{
  "code": "2000",
  "data": {
    "test_field": "aaa",
    "facetoface_address": {
      "address": "",
      "receiver": "Luo",
      "receiver_cellphone": "1388345****",
      "sid": "001190e19e754001b53701d0aa81bfe0",
      "sort_number": 1,
      "title": "Ms.",
      "type": "FACETOFACE",
      "user_sid": "a19cf6e3586143d283dd4128c456bfaf"
    },
    "order": {
      "bidding": 2300,
      "broker_avatar": "broker/getAvatar?key=avatar/b82378ccaccb403c9d8420274372c904",
      "broker_cellphone": "1347282****",
      "broker_deal_num": 15,
      "broker_name": "Wang**",
      "broker_sid": "b82378ccaccb403c9d8420274372c904",
      "broker_stars": 4.5,
      "code": "1512151307270113",
      "cover": "show/getPoster?key=52f30bbce4ef4122919cbc95c2f01c36/52f30bbce4ef4122919cbc95c2f01c36",
      "created_datetime": "2015-12-15 13:07:28",
      "delivery_address_sid": "c25c1954ca204dee8fc18f51bcc71a3e",
      "delivery_fee": 0,
      "evaluate_starts": 0,
      "is_delete": false,
      "is_sequential": false,
      "order_status": "CLOSED",
      "order_status_array": [
        {
          "operate_datetime": "2015-12-15 13:07:28",
          "operate_user_sid": "b82378ccaccb403c9d8420274372c904",
          "operate_username": "Wang**",
          "order_sid": "21bc3cc65e9e47af952c1f4f1f0fd85a",
          "order_type": "1",
          "sid": "04940ed81540466ea4408f79989a5d54",
          "state": "TAKING"
        }
      ],
      "order_status_desp": "",
      "order_type": "1",
      "pay_type": "",
      "post_ticket_sid": "65cc6d54300349e984134ecd0faf3ede",
      "receive_datetime": "2015-12-15 13:07:28",
      "receiver": "Zhang**",
      "receiver_address": "Kongjiang Road 1209",
      "receiver_cellphone": "1502379****",
      "receiver_title": "Mr.",
      "remark": "",
      "request_datetime": "2015-12-15 13:07:28",
      "show_name": "Love Radio Pin Guan Where Are You Now Tour Concert Shanghai Station",
      "show_schedule": "2016-01-09 19:30:00",
      "show_schedule_sid": "eecfd0657fb445a7a36abedc9b621c89",
      "show_sid": "52f30bbce4ef4122919cbc95c2f01c36",
      "sid": "21bc3cc65e9e47af952c1f4f1f0fd85a",
      "state_desp": "Closed",
      "ticket_price": 88000,
      "ticket_quantity": 1,
      "ticket_sid": "c4583aa8a79a478e8e5cd14691028430",
      "total_price": 2300,
      "trade_type": "EXPRESS",
      "user_cellphone": "1502379****",
      "user_leave_message": "",
      "user_sid": "a19cf6e3586143d283dd4128c456bfaf",
      "venue_address": "No. 777 Wuyi Road, Changning District, Shanghai",
      "venue_name": "Shanghai International Gymnastics Center"
    }
  },
  "test_from_list": [
    {
      "test_key": "testValue"
    }
  ],
  "extra_data": [],
  "message": "",
  "success": true,
  "int_list": [
    1,
    2,
    3
  ],
  "bool_list": [
    true,
    false,
    true,
    true
  ],
  "double_list": [
    0.324542354353425342436764765746575473434564564564564,
    1.100000000000000088817841970012523233890533447265625,
    2.20000000000000017763568394002504646778106689453125,
    3.29999999999999982236431605997495353221893310546875
  ],
  "empty_list": [],
  "null_list": [
    null
  ],
  "null_obj": null
}
```
Dart (named **new_model.dart**):
```dart
import 'package:freezed_annotation/freezed_annotation.dart';

part 'standard_model.freezed.dart';
part 'standard_model.g.dart';

@freezed
class StandardModel with _$StandardModel {
  const factory StandardModel({
    @JsonKey(name: 'code') String? code,
    @JsonKey(name: 'data') Data? data,
    @JsonKey(name: 'test_from_list') List<TestFromList>? testFromList,
    @JsonKey(name: 'extra_data') List<dynamic>? extraData,
    @JsonKey(name: 'message') String? message,
    @JsonKey(name: 'success') bool? success,
    @JsonKey(name: 'int_list') List<int>? intList,
    @JsonKey(name: 'bool_list') List<bool>? boolList,
    @JsonKey(name: 'double_list') List<double>? doubleList,
    @JsonKey(name: 'empty_list') List<dynamic>? emptyList,
    @JsonKey(name: 'null_list') List<dynamic>? nullList,
    @JsonKey(name: 'null_obj') dynamic nullObj,
  }) = _StandardModel;

  factory StandardModel.fromJson(Map<String, Object?> json) => _$StandardModelFromJson(json);
}

@freezed
class TestFromList with _$TestFromList {
  const factory TestFromList({
    @JsonKey(name: 'test_key') String? testKey,
  }) = _TestFromList;

  factory TestFromList.fromJson(Map<String, Object?> json) => _$TestFromListFromJson(json);
}

@freezed
class Data with _$Data {
  const factory Data({
    @JsonKey(name: 'test_field') String? testField,
    @JsonKey(name: 'facetoface_address') FacetofaceAddress? facetofaceAddress,
    @JsonKey(name: 'order') Order? order,
  }) = _Data;

  factory Data.fromJson(Map<String, Object?> json) => _$DataFromJson(json);
}

@freezed
class Order with _$Order {
  const factory Order({
    @JsonKey(name: 'bidding') int? bidding,
    @JsonKey(name: 'broker_avatar') String? brokerAvatar,
    @JsonKey(name: 'broker_cellphone') String? brokerCellphone,
    @JsonKey(name: 'broker_deal_num') int? brokerDealNum,
    @JsonKey(name: 'broker_name') String? brokerName,
    @JsonKey(name: 'broker_sid') String? brokerSid,
    @JsonKey(name: 'broker_stars') double? brokerStars,
    @JsonKey(name: 'code') String? code,
    @JsonKey(name: 'cover') String? cover,
    @JsonKey(name: 'created_datetime') String? createdDatetime,
    @JsonKey(name: 'delivery_address_sid') String? deliveryAddressSid,
    @JsonKey(name: 'delivery_fee') int? deliveryFee,
    @JsonKey(name: 'evaluate_starts') int? evaluateStarts,
    @JsonKey(name: 'is_delete') bool? isDelete,
    @JsonKey(name: 'is_sequential') bool? isSequential,
    @JsonKey(name: 'order_status') String? orderStatus,
    @JsonKey(name: 'order_status_array') List<OrderStatusArray>? orderStatusArray,
    @JsonKey(name: 'order_status_desp') String? orderStatusDesp,
    @JsonKey(name: 'order_type') String? orderType,
    @JsonKey(name: 'pay_type') String? payType,
    @JsonKey(name: 'post_ticket_sid') String? postTicketSid,
    @JsonKey(name: 'receive_datetime') String? receiveDatetime,
    @JsonKey(name: 'receiver') String? receiver,
    @JsonKey(name: 'receiver_address') String? receiverAddress,
    @JsonKey(name: 'receiver_cellphone') String? receiverCellphone,
    @JsonKey(name: 'receiver_title') String? receiverTitle,
    @JsonKey(name: 'remark') String? remark,
    @JsonKey(name: 'request_datetime') String? requestDatetime,
    @JsonKey(name: 'show_name') String? showName,
    @JsonKey(name: 'show_schedule') String? showSchedule,
    @JsonKey(name: 'show_schedule_sid') String? showScheduleSid,
    @JsonKey(name: 'show_sid') String? showSid,
    @JsonKey(name: 'sid') String? sid,
    @JsonKey(name: 'state_desp') String? stateDesp,
    @JsonKey(name: 'ticket_price') int? ticketPrice,
    @JsonKey(name: 'ticket_quantity') int? ticketQuantity,
    @JsonKey(name: 'ticket_sid') String? ticketSid,
    @JsonKey(name: 'total_price') int? totalPrice,
    @JsonKey(name: 'trade_type') String? tradeType,
    @JsonKey(name: 'user_cellphone') String? userCellphone,
    @JsonKey(name: 'user_leave_message') String? userLeaveMessage,
    @JsonKey(name: 'user_sid') String? userSid,
    @JsonKey(name: 'venue_address') String? venueAddress,
    @JsonKey(name: 'venue_name') String? venueName,
  }) = _Order;

  factory Order.fromJson(Map<String, Object?> json) => _$OrderFromJson(json);
}

@freezed
class OrderStatusArray with _$OrderStatusArray {
  const factory OrderStatusArray({
    @JsonKey(name: 'operate_datetime') String? operateDatetime,
    @JsonKey(name: 'operate_user_sid') String? operateUserSid,
    @JsonKey(name: 'operate_username') String? operateUsername,
    @JsonKey(name: 'order_sid') String? orderSid,
    @JsonKey(name: 'order_type') String? orderType,
    @JsonKey(name: 'sid') String? sid,
    @JsonKey(name: 'state') String? state,
  }) = _OrderStatusArray;

  factory OrderStatusArray.fromJson(Map<String, Object?> json) => _$OrderStatusArrayFromJson(json);
}

@freezed
class FacetofaceAddress with _$FacetofaceAddress {
  const factory FacetofaceAddress({
    @JsonKey(name: 'address') String? address,
    @JsonKey(name: 'receiver') String? receiver,
    @JsonKey(name: 'receiver_cellphone') String? receiverCellphone,
    @JsonKey(name: 'sid') String? sid,
    @JsonKey(name: 'sort_number') int? sortNumber,
    @JsonKey(name: 'title') String? title,
    @JsonKey(name: 'type') String? type,
    @JsonKey(name: 'user_sid') String? userSid,
  }) = _FacetofaceAddress;

  factory FacetofaceAddress.fromJson(Map<String, Object?> json) => _$FacetofaceAddressFromJson(json);
}
```
You can generate [@Default](https://pub.dev/packages/freezed#default-values), enable in Settings

![settings](/screenshots/settings.png)
