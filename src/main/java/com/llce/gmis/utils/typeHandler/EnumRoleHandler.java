package com.llce.gmis.utils.typeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.llce.gmis.entity.UserRole;

public class EnumRoleHandler extends BaseTypeHandler<UserRole>{

	private Class<UserRole> type;
	 
    private final UserRole[] enums;
	
    public EnumRoleHandler(Class<UserRole> type) {
        if (type == null)
            throw new IllegalArgumentException("Type argument cannot be null");
        this.type = type;
        this.enums = type.getEnumConstants();
        if (this.enums == null)
            throw new IllegalArgumentException(type.getSimpleName()
                    + " does not represent an enum type.");
    }
    
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			UserRole parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setInt(i, parameter.getValue());
	}

	@Override
	public UserRole getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		int i = rs.getInt(columnName);
        
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locateEnumRole(i);
        }
	}

	@Override
	public UserRole getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		int i = rs.getInt(columnIndex);
        
        if (rs.wasNull()) {
            return null;
        } else {
            // 根据数据库中的code值，定位EnumStatus子类
            return locateEnumRole(i);
        }
	}

	@Override
	public UserRole getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	private UserRole locateEnumRole(int code) {
        for(UserRole role : enums) {
            if(role.getValue()==code) {
                return role;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + code + ",请核对" + type.getSimpleName());
    }
}
