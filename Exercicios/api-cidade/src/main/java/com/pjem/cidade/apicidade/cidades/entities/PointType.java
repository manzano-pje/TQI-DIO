package com.pjem.cidade.apicidade.cidades.entities;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.data.geo.Point;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pjem.cidade.apicidade.utils.StringLocationsUtils;

public class PointType implements UserType {

    @Override // sobrescrever metodo sqlTypes
    public int[] sqlTypes() {
        return new int[] {java.sql.Types.OTHER};
    }

    @Override // sobrescrever metodo returnedClass
    public Class returnedClass() {
        return Point.class;
    }

    @Override // sobrescrever metodo equals
    public boolean equals(Object x, Object y) throws HibernateException {
        return false;
    }

    @Override // sobrescrever metodo hashCode
    public int hashCode(Object x) throws HibernateException {
        return 0;
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session,
            Object owner) throws HibernateException, SQLException {
        Object object = rs.getObject(names[0]);
        Double[] points = StringLocationsUtils.transform(object.toString());
        return new Point(points[0], points[1]);
    }
    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index,
                            SharedSessionContractImplementor session)
            throws HibernateException, SQLException {
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }

}
