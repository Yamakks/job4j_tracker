package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("login"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private void doStatement(String query) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            if (query.startsWith("CREATE")) {
                statement.execute(query);
            }
            statement.executeUpdate(query);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)")) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    item.setId((int) id);
                } else {
                    throw new SQLException("Сгенерированный ключ не найден.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

            @Override
    public boolean replace(int id, Item item) {
                int rowsAffected = 0;
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement("UPDATE items SET name=?, created=? WHERE id=?")) {
                    preparedStatement.setString(1, item.getName());
                    preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                    preparedStatement.setInt(3, id);
                    preparedStatement.execute();
                    rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Изменения внесены в таблицу.");
                    } else {
                        System.out.println("Изменения не были внесены в таблицу.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return rowsAffected > 0;
            }

    @Override
    public boolean delete(int id) {
        int rowsAffected = 0;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM items WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Изменения внесены в таблицу.");
            } else {
                System.out.println("Изменения не были внесены в таблицу.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected > 0;
    }

    @Override
    public List<Item> findAll() {
        return List.of();
    }

    @Override
    public List<Item> findByName(String key) {
        return List.of();
    }

    @Override
    public Item findById(int id) {
        return null;
    }
}
