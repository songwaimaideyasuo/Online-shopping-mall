package com.w.mall.utils;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000122693117";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDJwl2U/rbbB5naInQT7vl3tRtYHZsK4Y37Vk0crGm3vdOBxhY9xjAHRQNc9iV2oaYwumla2soSaCFjS6Mt9EfgeO1oToS36p/JtU0rNmX6mLtP6tQRpPrP036dKUZteziFx3nmMwJHqRRVNnoNxA6bS+RplG2o869bsW9SR7IDUdTF5odW4myEngtkScCDlsO2PqFcQvnSYJLbgCXAxMosJJ6z4x4JfZV5dejTzme0qQCTaly5UaBLIGPCbBzCPXikUjWRRHobiNkWo+M2P7LwJY4tw+GNNhOk280vsqv02gj3B8WK5p3oD9a8VtTEYXAsrqmfw+oVg1q1dknXHEHPAgMBAAECggEAInrVA2GEXmouINlCfSWZ/Js20Rg+Jt3lJc7Z3syYRI5sVwFDS8tS6eshaAGo5V06yZkR6DT706l4C0Ah4vicUABakjjY9ZVjOVWCmp/xTaJMYJwBIgLP2jSKrtEe+BbW0gYFDxIokZaTovxsX23iESgnIOP82aLLlR/9plIaWfaUSSwVdHevjMqEA2HRMxdQ3eUvD09bhqiRccfoqXG2ZCrMH2jfsWBIMFb0tW1ynMS/livrY48J656SNq3pEpquelPHe3wW651pn8muRE7jYdzM5zLl3UKhKha4X6KYYnCQq3SdJLQluJLycHGb/N6UDmgr/QMrn4OxOkq6XXrWAQKBgQDzeRed9PuymW8mAilo74ntLllirKrBkUDapXWTnJ/sRxKYTA423LliftOTMc/WfTmVwCYuBzoJ2zkq8y1WOAFXzfFgKkFMwTi7b9DOYKlR8hRRtax5XmA0ZMPMUOnCSv/2eW9xez8qyWCp4/aGQUx5ga4Y1BupqvwxvHe7mcEHtQKBgQDUI9b9Hk86jDuteiFVozcrn4dTbc1dyRN3Pj0qnPVT4tlVKqSmNYtLd7pbM3/YqbxM8+rplmzbUEH39UbTsaVt434MpF7qnd79iGULvMir8lw8YLC1WFUtOPcIZ61NBc6p/L4qhcAUeYyL2npanYma8U45oxUJf2OrNobcUJ7N8wKBgH6WJPtRVlQDhlCCqzkN4e5ZPMwa7iT5+ngzsq/urQ9R3I8ma/WGSTS2sBZFvcPNE9WSM8eWpkxdmJmGGbpMIBag0rCnB5B6nZ6Ggk/q3d3nOT1KccQgl3BmO47NOtxz1iU1+gVMiQkb7pAmIBSperNqAzSRg1hxt/G8BZyaUkxJAoGBAIh4ReWviehwLjP7TVZ6GRPHHJdfG64pnIwpTdAMCQZd+NIBDMqfx2xVKV1iU+xdxPT8NTLvwjeT+dw5vcaRkYqPvpcDZswnozwWcmqKl82FrDBrQ0JmAOWGr+SITcQu6DQSk4NnZ5nEV9XgRrXkgpFaiqgpcW8atFOAUGGKu55hAoGBALG5LI2puX3B/jtej2U69W5+60T/A/sHFrIWElddjSTXafp68P+VACAKgF2paHzcVwPoIWyFJUcLRVVRJVcqZG1dj8S3uAQKjAK3hgYz7OTngW4fKsinGHrtSa3yOxlgZFZS1d4xEjpSmJKG0lCmhKg+BtqiPeTdnVzlPVQGSPzd";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgJJbPUjAGQckdFmhoxCQX14WDWNh5/L/a4jGo8BjXfYqOG5DPWsZf1UC+rMAsa82A+veokEgqOFglD26lKR1abH+IOhwz7SiB7fy5YSNeBuyAb9ZemqHlJchdxE2HQNm8JeVxvDWmPARUaA3NGoFBsttjydLXpIonYRHhoJ1Z5fl3qseZf31UcAnUZP+uB/XcQTdEsU1t6LpqLKZDWgyWl+vVaqpcg44sMA6WVCx6+CTMSAMHxdOW3m8A/iRBlRhZ7XOi4fBxqGI01q2W5RRBXpFhKz4UXCJ7FiyDJBoLKYJVAG2il849kkHlNhaEgDqvDYVSjGX/B6Bs1/vRqd3/QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8084/pay/alipayNotifyNotice";


    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //当支付成功之后，通知我们服务（服务器必须定义一个servlet或jsp来接收apli的通知）
    public static String return_url = "http://localhost:8084/pay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 返回格式
    public static String FORMAT = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 支付宝网关日志
    public static String log_path = "F:\\支付资料\\alipay支付宝\\log";
}
