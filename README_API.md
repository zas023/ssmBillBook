### 1.账单接口
>和账单相关操作

#### 1.1  每月账单详情
>返回每月账单详情，按天归类

**必选参数:**
/{uiserId}/{Year}/{Month}

* uiserId : 用户id
* Year : 年份
* Month ： 月份

*  **接口地址:**
`bill/user`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/user/1/2017/12`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","t_income":"300.00","t_outcome":"900.00","l_outcome":"0.00","daylist":[{"time":"06日-Wednesday","money":"支出：350.00 收入：300.00","list":[{"id":74,"cost":100.0,"content":"test","userid":1,"payid":5,"sortid":41,"crdate":1512565121000,"income":true,"sort":{"id":41,"uid":0,"sortName":"兼职","sortImg":"jianzhi@2x.png","priority":null,"income":true}},{"id":71,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":41,"crdate":1512565118000,"income":true,"sort":{"id":41,"uid":0,"sortName":"兼职","sortImg":"jianzhi@2x.png","priority":null,"income":true}},{"id":2,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":39,"crdate":1512565107000,"income":true,"sort":{"id":39,"uid":0,"sortName":"利息","sortImg":"lixi@2x.png","priority":null,"income":true}},{"id":58,"cost":250.0,"content":"null","userid":1,"payid":1,"sortid":3,"crdate":1512564492000,"income":false,"sort":{"id":3,"uid":0,"sortName":"商城消费","sortImg":"shangchengxiaofei@2x.png","priority":null,"income":false}},{"id":5,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":2,"crdate":1512564488000,"income":false,"sort":{"id":2,"uid":0,"sortName":"手续费","sortImg":"shouxufei@2x.png","priority":null,"income":false}}]},{"time":"05日-Tuesday","money":"支出：550.00 收入：0.00","list":[{"id":73,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":1,"crdate":1512450812000,"income":false,"sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false}},{"id":72,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":1,"crdate":1512450809000,"income":false,"sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false}},{"id":59,"cost":200.0,"content":"null","userid":1,"payid":1,"sortid":1,"crdate":1512450807000,"income":false,"sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false}},{"id":57,"cost":50.0,"content":"null","userid":1,"payid":1,"sortid":1,"crdate":1512450806000,"income":false,"sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false}},{"id":4,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":1,"crdate":1512450803000,"income":false,"sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false}}]}]}
}
```

#### 1.2  每月账单2
>返回每月账单图标详情，按账单类型归类

**必选参数:**
/{uiserId}/{Year}/{Month}

* uiserId : 用户id
* Year : 年份
* Month ： 月份

**接口地址:**
`bill/chart`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/chart/1/2017/12`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","totalOut":"900.00","totalIn":"300.00","l_totalOut":"0.00","l_totalIn":"0.00","outSortlist":[{"back_color":"#14F388","money":"550.00","sort":{"id":1,"uid":0,"sortName":"偿还费用","sortImg":"changhuanfeiyong@2x.png","priority":0,"income":false},"list":[{"id":73,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":1,"crdate":1512450812000,"income":false,"sort":null},{"id":72,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":1,"crdate":1512450809000,"income":false,"sort":null},{"id":59,"cost":200.0,"content":"null","userid":1,"payid":1,"sortid":1,"crdate":1512450807000,"income":false,"sort":null},{"id":57,"cost":50.0,"content":"null","userid":1,"payid":1,"sortid":1,"crdate":1512450806000,"income":false,"sort":null},{"id":4,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":1,"crdate":1512450803000,"income":false,"sort":null}]},{"back_color":"#636C97","money":"100.00","sort":{"id":2,"uid":0,"sortName":"手续费","sortImg":"shouxufei@2x.png","priority":null,"income":false},"list":[{"id":5,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":2,"crdate":1512564488000,"income":false,"sort":null}]},{"back_color":"#916314","money":"250.00","sort":{"id":3,"uid":0,"sortName":"商城消费","sortImg":"shangchengxiaofei@2x.png","priority":null,"income":false},"list":[{"id":58,"cost":250.0,"content":"null","userid":1,"payid":1,"sortid":3,"crdate":1512564492000,"income":false,"sort":null}]}],"inSortlist":[{"back_color":"#7DB960","money":"100.00","sort":{"id":39,"uid":0,"sortName":"利息","sortImg":"lixi@2x.png","priority":null,"income":true},"list":[{"id":2,"cost":100.0,"content":null,"userid":1,"payid":1,"sortid":39,"crdate":1512565107000,"income":true,"sort":null}]},{"back_color":"#F25445","money":"200.00","sort":{"id":41,"uid":0,"sortName":"兼职","sortImg":"jianzhi@2x.png","priority":null,"income":true},"list":[{"id":74,"cost":100.0,"content":"test","userid":1,"payid":5,"sortid":41,"crdate":1512565121000,"income":true,"sort":null},{"id":71,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":41,"crdate":1512565118000,"income":true,"sort":null}]}]}
```
#### 1.3  每月账单3
>返回每月账单图标详情，按账单支付方式归类

**必选参数:**
/{uiserId}/{Year}/{Month}

* uiserId : 用户id
* Year : 年份
* Month ： 月份

**接口地址:**
`bill/pay`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/pay/1/2017/12`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","totalOut":"900.00","totalIn":"300.00","l_totalOut":"0.00","l_totalIn":"0.00","list":[{"bPay":{"id":1,"uid":0,"payName":"现金","payImg":"cash@2x.png","payNum":null},"outcome":"900.00","income":"200.00"},{"bPay":{"id":2,"uid":0,"payName":"支付宝","payImg":"account@2x.png","payNum":null},"outcome":"0.00","income":"0.00"},{"bPay":{"id":3,"uid":0,"payName":"微信","payImg":"account@2x.png","payNum":null},"outcome":"0.00","income":"0.00"},{"bPay":{"id":4,"uid":1,"payName":"银行卡","payImg":"bank@2x.png","payNum":"尾号5467"},"outcome":"0.00","income":"0.00"},{"bPay":{"id":5,"uid":1,"payName":"银行卡","payImg":"bank@2x.png","payNum":"尾号4563"},"outcome":"0.00","income":"100.00"}]}
```
#### 1.4  添加账单
>返回新增账单

**必选参数:**
* uiserId : 用户id
* sortid : 账单分类id
* payid ： 用户支付方式id
* cost ： 账单金额
* crdate ： 创建时间
* content ： 备注
* income ： 是否为收入

**接口地址:**
`bill/add`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/add?userid=1&sortid=2&payid=3&cost=555.0&crdate=2017-12-27%2020:58:27&content=test&income=false`

__接口返回数据__
```javascript
{}
```

#### 1.5  修改账单
>返回更新的账单

**必选参数:**
* id ： 账单id
* uiserId : 用户id
* sortid : 账单分类id
* payid ： 用户支付方式id
* cost ： 账单金额
* crdate ： 创建时间
* content ： 备注
* income ： 是否为收入

**接口地址:**
`bill/update`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/add?id=80&userid=1&sortid=2&payid=3&cost=555.0&crdate=2017-12-27%2020:58:27&content=test&income=false`

__接口返回数据__
```javascript
{}
```

#### 1.6  删除账单
>返回通用信息

**必选参数:**
/{id}

* id ： 账单id

**接口地址:**
`bill/delete`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/delete/80`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！"}
```

#### 1.7  查询账单
>返回查询账单

**必选参数:**
/{id}

* id ： 账单id

**接口地址:**
`bill/find`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/bill/find/71`

__接口返回数据__
```javascript
{"id":71,"cost":100.0,"content":"test","userid":1,"payid":1,"sortid":41,"crdate":1512565118000,"income":true,"sort":null}
```

### 2.用户接口
>和用户相关操作

#### 2.1  用户登陆
>返回用户信息

**必选参数:**
* username : 用户名
* password : 用户密码

**接口地址:**
`user/login`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/user/login?username=admin&password=admin`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","id":1,"username":"admin","password":"3E3E6B0E5C1C68644FC5CE3CF060211D","image":"1_1514361165324.png","gender":"M","phone":"15922646438","mail":"375027533@qq.com","state":1,"mailcode":"c305953c88a34a80b4e582e6f35384ddbaa10badda674711989a1192583abec0","phonecode":null}
```

#### 2.2  用户注册
>返回用户注册信息，但须登陆注册邮箱激活

**必选参数:**
* username : 用户名
* password : 用户密码
* mail : 用户注册邮箱

**接口地址:**
`user/sign`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/user/sign?username=admin&password=admin&mail=375027533@qq.com`

__接口返回数据__
```javascript
{"status":200,"message":"用户名已经存在","id":null,"username":"admin","password":"admin","image":null,"gender":null,"phone":null,"mail":"375027533@qq.com","state":null,"mailcode":null,"phonecode":null}
```

#### 2.3  修改用户信息
>返回更新后的用户信息

**必选参数:**
* id : 用户id
* username : 用户名
* gender : 用户性别（M :男，F :女）
* phone : 用户电话
* mail : 用户邮箱

**接口地址:**
`user/update`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/user/update?id=16&username=user&gender=F&phone=18725912261&mail=375027533@qq.com`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","id":16,"username":"user","password":"2E1EF01B619313B6452C5C348F55CB26","image":null,"gender":"F","phone":"18725912261","mail":"375027533@qq.com","state":1,"mailcode":"c305953c88a34a80b4e582e6f35384ddbaa10badda674711989a1192583abec0","phonecode":null}
```

#### 2.4  忘记密码
>返回通用信息

**必选参数:**
* username : 用户名
* mail : 用户邮箱

**接口地址:**
`user/forgetPw`

**调用例子:**
`http://139.199.176.173:8080/ssmBillBook/user/forgetPw?username=user&mail=375027533@qq.com`

__接口返回数据__
```javascript
{"status":100,"message":"处理成功！","id":16,"username":"user","password":"2E1EF01B619313B6452C5C348F55CB26","image":null,"gender":"F","phone":"18725912261","mail":"375027533@qq.com","state":1,"mailcode":"c305953c88a34a80b4e582e6f35384ddbaa10badda674711989a1192583abec0","phonecode":null}
```
