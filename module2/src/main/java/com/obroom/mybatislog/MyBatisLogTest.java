package com.obroom.mybatislog;

/**
 * @author ob
 */
public class MyBatisLogTest {
    public static void main(String[] args) {
        //select: String参数测试
        System.out.println("MyBatis Log Test: DEBUG sql1 -  ==>  Preparing: select * from t_table where name = ?");
        System.out.println("MyBatis Log Test: DEBUG sql1 -  ==> Parameters: hello(String)");

        //update: String和Integer参数测试
        System.out.println("MyBatis Log Test: INFO sql2 -  ==>  Preparing: update t_table set name = ? where id = ?");
        System.out.println("MyBatis Log Test: INFO sql2 -  ==> Parameters: world(String), 123(Integer)");

        //delete:
        System.out.println("MyBatis Log Test: WARN sql3 -  ==>  Preparing: delete from t_table where id = ?");
        System.out.println("MyBatis Log Test: WARN sql3 -  ==> Parameters: 123(Integer)");

        //无参数测试
        System.out.println("MyBatis Log Test: ERROR sql4 - ==>  Preparing: select * from t_table order by id asc ");
        System.out.println("MyBatis Log Test: ERROR sql4 - ==>  Parameters: ");

        //参数为空测试
        System.out.println("MyBatis Log Test: ERROR notParamTest - ==>  Preparing: select * from t_table where name = ? and code = ?\n");
        System.out.println("MyBatis Log Test: ERROR notParamTest - ==>  Parameters: hello(String), null\n");

        //UUID测试测试
        System.out.println("MyBatis Log Test: ERROR notParamTest - ==>  Preparing: select * from t_table where name = ? and code = ?");
        System.out.println("MyBatis Log Test: ERROR notParamTest - ==>  Parameters: hello(UUID), world(UUID)");

        //特殊参数测试
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Preparing: INSERT INTO sys_log( a, b, c, d, e, f, g ) VALUES ( ?, ?, ?, ?, ?, ?, ? )");
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Parameters: 2017-06-18 18:01:47(Date),    我的信息(String), Mozilla/5.0 (Windows NT 10.0; WOW64) /537.36(String), null, GET(String), (String), null");

        //特殊参数测试
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Preparing: INSERT INTO t_ml_vop_bil_interface (a,b,c,d) VALUES (?,?,?,?)");
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Parameters: 996aep(String), {\"eff\":\"abc\",\"barcode\":\"ddd\"}(String), {success=1}(String), 2017-06-29(Timestamp)");
        //特殊参数测试
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Preparing: select count(*) from t_table t1 left join t_ml_vop_pnm_partner t2 on t1.partner_id = t2.id left join t_ml_vop_cor_corp t3 on t1.corp_id = t3.id left join t_ml_vop_rnm_reseller t4 on t2.reseller_id = t4.id left join t_ml_vop_ssm_user t5 on t1.update_user_id = t5.id where 1=1 and t1.status = '3' and t1.ocr_identification = '1' and t1.update_ts >= '2017-06-01' and t1.partner_id in ( SELECT DISTINCT a.id FROM t_ml_vop_pnm_partner a INNER JOIN t_ml_vop_ssm_user_partner b ON a. ID = b.partner_id INNER JOIN t_ml_vop_pnm_partner_country c ON a. ID = c.partner_id AND b.user_id = ? AND c.country_code = ? AND a. ID NOT IN ( 'onlyou_init_20150201_00000000000' ) ) and t1.update_ts::timestamp + (? || ' hour')::interval < ? and t1.handle_status = ? ");
        System.out.println("2017-06-23 14:31:27.729 ERROR specialTest - ==>  Parameters: 53bb738a9b0346f8b435dbaf348a386f(String), MY(String), 24(String), null, 0(String)");

        String sql = "2017-06-23 14:31:27.729 ERROR notParamTest - ==>  Preparing: insert into sql_execute_fact ( hash_code, sql_scripts, sql_type, execute_time, result_size, created_at ) values ( ?, ?, ?, ?, ?, ? )";
        String param = "exec-7] (BaseJdbcLogger.java:159) - ==> Parameters: d26e232643e79e6dd00f73a3dc770684(String), H4sIAAAAAAAAAIWMywrCMBBFf+XuWiHgY+vHDDGMTcGZSDIx5u+rhSKC4PJezjmFbxwMpcqo3Cjz\n" + "RFplB1/QD+7rb7NFeg9jLx/q6PAH2/+snxxC0uCNWhmHwcEiU2efHYSCknrhlXwC15wEW+FlPTgb\n" + "ppzqHZe+ipLU4nkBWJrAG84AAAA=(String), 0(Integer), 62(Long), 442(Long), 2018-04-09 17:38:04.761(Timestamp)";
        System.out.println(sql);
        System.out.println(param);

        //SELECT *,CASE tb.username WHEN ('zhangsan') THEN TRUE ELSE FALSE END as state  from tb_user tb
        System.out.println("2017-06-23 14:31:27.729 ERROR notParamTest - ==>  Preparing: SELECT *,CASE WHEN status = 'REFUSE' THEN '拒绝' from test where name = ?");
        System.out.println("2017-06-23 14:31:27.729 ERROR notParamTest - ==>  Parameters: zhangsan(String)");
//
        System.out.println("2017-06-23 14:31:27.729 ERROR notParamTest - ==>  Preparing: SELECT * FROM T_DEMO T WHERE regexp_replace(T.PROJECT_BASED, '</?.+?/?>', '') LIKE CONCAT('%', CONCAT(?, '%'))");
        System.out.println("2017-06-23 14:31:27.729 ERROR notParamTest - ==>  Parameters: zhangsan(String)");
    }
}
