package main.com.springmvc.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Query {
    private final DataSource dataSource;

    public Query(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> List<T> executeQuery(String sql, Map<Integer, String> parameters, Class<T> typeClass) {
        List<T> outputList = null;
        ResultSet resultSet = null;
        try (Connection connection = dataSource.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            if (parameters != null) {
                for (Map.Entry<Integer, String> entry : parameters.entrySet()) {
                    preparedStatement.setString(entry.getKey(), entry.getValue());
                }
            }
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                outputList = mapResultSetToListObject(resultSet, typeClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return outputList;
    }


    public <T> List<T> mapResultSetToListObject(ResultSet rs, Class<T> outputClass) {
        List<T> outputList = new ArrayList<>();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            Field[] fields = outputClass.getDeclaredFields();

            while (rs.next()) {
                T bean = outputClass.newInstance();

                for (int _iterator = 1; _iterator <= rsmd.getColumnCount(); _iterator++) {
                    String columnName = rsmd.getColumnName(_iterator);
                    Object columnValue = rs.getObject(_iterator);

                    if (columnValue != null) {
                        if (columnValue instanceof Date) {
                            columnValue = columnValue.toString();
                        }
                        for (Field field : fields) {
                            if (field.getName().equalsIgnoreCase(columnName)) {
                                field.setAccessible(true);
                                BeanUtils.setProperty(bean, field.getName(), columnValue);
                                break;
                            }
                        }
                    }
                }
                outputList.add(bean);
            }
        } catch (IllegalAccessException | SQLException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return outputList;
    }

}
