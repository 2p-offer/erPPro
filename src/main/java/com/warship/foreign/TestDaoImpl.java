//package com.warship.test.foreign;
//
//import com.alibaba.fastjson2.JSONArray;
//import com.alibaba.fastjson2.JSONObject;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@Repository
//public class TestDaoImpl implements TestDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public TestDaoImpl(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private static final String GET_ROLE = "select role_id,role_name from role where role_id = ?";
//
//    @Override
//    public TestRole getRole(long roleId) {
//        final TestRole res = new TestRole();
//        jdbcTemplate.queryForObject(GET_ROLE, new Object[]{roleId}, new RowMapper<TestRole>() {
//            @Override
//            public TestRole mapRow(ResultSet rs, int rowNum) throws SQLException {
//                res.setRoleId(rs.getLong("role_id"));
//                res.setRoleName(rs.getString("role_name"));
//                return null;
//            }
//        });
//        return res;
//    }
//
//    private static final String SAVE_NAME_AGE = "insert into name_age values(?,?,?,?)";
//
////    @Transactional
//    public void saveData(JSONArray data) {
//        jdbcTemplate.batchUpdate(SAVE_NAME_AGE, new BatchPreparedStatementSetter() {
//
//            @Override
//            public int getBatchSize() {
//                return data.size();
//            }
//
//            @Override
//            public void setValues(PreparedStatement ps,
//                                  int idx)
//                    throws SQLException {
//                JSONObject object = (JSONObject) data.get(idx);
//                int i = 1;
//                // set parameter for INSERT
//                ps.setInt(i++, object.getInteger("id"));
//                ps.setString(i++, object.getString("name"));
//                ps.setInt(i++, object.getInteger("age"));
//                ps.setLong(i++, System.currentTimeMillis());
////                if(idx > 10){
////                    System.out.println("hahahahha:"+idx);
////                    try {
////                        Thread.sleep(10000);
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }
//            }
//
//        });
//    }
//
//    private static final String DEL_NAME_AGE = "delete from name_age where id = ?";
//
//    @Override
//    public void delNameAge(int id) {
//        final TestRole res = new TestRole();
//        jdbcTemplate.update(DEL_NAME_AGE, new Object[]{id});
//    }
//
//
//}
