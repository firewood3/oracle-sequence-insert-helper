package gchsj.dao;

import gchsj.dbconfig.DataSource;
import gchsj.model.Code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodeDao {
    public static List<gchsj.model.Code> selectAll() {
        String SQL_QUERY = "SELECT * from CMT_CODE_CT";
        List<gchsj.model.Code> cmtCodeCdList = new ArrayList<>();

        try(Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_QUERY)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                cmtCodeCdList.add(new gchsj.model.Code(
                        rs.getString("TYPE"),
                        rs.getString("CODE"),
                        rs.getString("CMT_CODE_CT_SEQ"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cmtCodeCdList;
    }

    public static void update(gchsj.model.Code code) {
        String SQL_QUERY = "UPDATE COMMON_CODE " +
                " SET CODE_SEQ = CMT_SEQ.NEXTVAL" +
                " WHERE TYPE = ? AND CODE = ?";

        try (Connection con = DataSource.getConnection(); PreparedStatement pst = con.prepareStatement(SQL_QUERY);) {
            pst.setString(1, code.getType());
            pst.setString(2, code.getCode());
            pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
