package com.llce.gmis.utils.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.llce.gmis.utils.encoder.Base64Utils;

public class PasswordHandler extends BaseTypeHandler<String>{
	
    public PasswordHandler() {
    }

	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		String pwdHash = rs.getString(columnName);
        
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
        		return locatePwd(pwdHash);
        }
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		String pwdHash = rs.getString(columnIndex);
        
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locatePwd(pwdHash);
        }
	}


	private String locatePwd(String pwdHash) {
        return (String) Base64Utils.decode(pwdHash);
    }

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, Base64Utils.encode(parameter));
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
