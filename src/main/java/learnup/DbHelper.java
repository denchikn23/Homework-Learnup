package learnup;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DbHelper {
    private Connection connection;

    public DbHelper(String dbUrl, String username, String password) {
        try {
            this.connection = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean deleteDay(int day) {
        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM manager WHERE day = ?;");
            statement.setInt(1, day);
            final int modifiedCount = statement.executeUpdate();
            return modifiedCount > 0;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

    public boolean addDayAndSteps(int day, int steps) {
        try {
            final PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO manager(day, steps) VALUES (?, ?);");
            statement.setInt(1, day);
            statement.setInt(2, steps);
            return statement.executeUpdate() > 0;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

    public Map<Integer, Integer> getAllDaysAndSteps() {
        try {
            Map<Integer, Integer> result = new HashMap<>();
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT * FROM manager");
            while (resultSet.next()) {
                final int day = resultSet.getInt("day");
                final int steps = resultSet.getInt("steps");
                result.put(day, steps);
            }
            return result;
        } catch (SQLException err) {
            err.printStackTrace();
            return null;
        }
    }

    public boolean addStepsManager(Map<Integer, Integer> data) {
        boolean flag = false;
        for (Integer day : data.keySet()) {
            try {
                final PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO manager(day, steps) VALUES (?, ?);");
                statement.setInt(1, day);
                statement.setInt(2, data.get(day));
                flag = statement.executeUpdate() > 0;
            } catch (SQLException err) {
                err.printStackTrace();
                return false;
            }
        }
        return flag;
    }
}