package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    private Item generateItem(ResultSet resultSet) throws SQLException {
        Item item = new Item(resultSet.getInt("id"),
                resultSet.getString("name"));
        item.setCreated(resultSet.getTimestamp(3).toLocalDateTime());
        return  item;
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
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.execute();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Сгенерированный ключ не найден.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

            @Override
    public boolean replace(int id, Item item) {
                boolean result = false;
                try (PreparedStatement preparedStatement =
                             connection.prepareStatement("UPDATE items SET name=?, created=? WHERE id=?")) {
                    preparedStatement.setString(1, item.getName());
                    preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
                    preparedStatement.setInt(3, id);
                    result = preparedStatement.executeUpdate() > 0;
                    if (result) {
                        System.out.println("Изменения внесены в таблицу.");
                    } else {
                        System.out.println("Изменения не были внесены в таблицу.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return result;
            }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM items WHERE id=?")) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0;
            if (result) {
                System.out.println("Изменения внесены в таблицу.");
            } else {
                System.out.println("Изменения не были внесены в таблицу.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> allItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    allItems.add(generateItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allItems;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> nameItems = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            statement.setString(1, key);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                   nameItems.add(generateItem(resultSet));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameItems;
    }

    @Override
    public Item findById(int id) {
        Item idItem = new Item();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id=?")) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                   idItem = generateItem(resultSet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idItem;
    }
}
