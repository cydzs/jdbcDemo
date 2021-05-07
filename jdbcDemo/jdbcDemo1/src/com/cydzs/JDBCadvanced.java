package com.cydzs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC进阶部分动态查询
 * @Author: Cydzs
 * @GreateTime:2021/5/6
 **/
public class JDBCadvanced {

    //动态查询
    public List<Departments>selectDeptByproperty(Departments dept){
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        List <Departments> list = new ArrayList<>();
        try {
            conn = jdbcUtil.getConnection();
            String sql = genSQL(dept);
            System.out.println("sql = " + sql);
            ps= conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Departments departments = new Departments();
                departments.setDepartmentId(rs.getInt("department_id"));
                departments.setDepartmentName(rs.getString("depart_name"));
                departments.setLocationId(rs.getInt("location_id"));
                list.add(departments);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.closeResource(ps,conn,rs);
        }
        return list;
    }

    private String genSQL(Departments dept) {
        StringBuffer sb = new StringBuffer("select * from departments where 1=1 ");
        if (dept.getDepartmentId()>0) {
            sb.append("and department_id= ").append(dept.getDepartmentId());
        }
        if(dept.getDepartmentName()!=null){
            sb.append("and depart_name = '").append(dept.getDepartmentName()).append("'");
        }

        if (dept.getLocationId()>0) {
            sb.append("and location_id= ").append(dept.getLocationId());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JDBCadvanced jdbCadvanced = new JDBCadvanced();
        Departments departments =  new Departments();
        departments.setDepartmentName("teaching");
        List<Departments> list=jdbCadvanced.selectDeptByproperty(departments);
        for (Departments l :list){
            System.out.println("l = " + l);
        }
    }
}
