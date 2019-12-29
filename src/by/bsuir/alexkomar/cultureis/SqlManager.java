package by.bsuir.alexkomar.cultureis;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

class SqlManager {
    private static final String user = "pbz2";
    private static final String password = "pbz2";
    private static final String url = "jdbc:mysql://localhost:3306/cultureis?useUnicode=true&serverTimezone=UTC";

    private VariableTableModel tableModel;
    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    SqlManager() {
        tableModel = new VariableTableModel();
    }

    void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connection to Store DB succesfull!");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Class com.mysql.cj.jdbc.Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Undefined exception in SqlManager");
            e.printStackTrace();
        }
    }

    VariableTableModel getTableModel() {
        return tableModel;
    }


    //------------------------------ADD---------------------------------------------
    void addAddress(String city, String street, int house) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO\n" +
                    " addresses(city, street, house) VALUES\n(?, ?, ?);");
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, street);
            preparedStatement.setInt(3, house);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add address");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addOwner(int addressID, String name, boolean isLegalEntity, String head) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO\n" +
                    " owners(addressid,name,legalentity,head)  VALUES\n(?, ?, ?, ?);");
            preparedStatement.setInt(1, addressID);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, isLegalEntity);
            preparedStatement.setString(4, head);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add owner");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addCultureObject(int addressId, int ownerId, String name, String type, String telephone,
                                 int seatsNumber, boolean isSeasonal, Date openingDate) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO\n" +
                    " cultureobjects(addressid, ownerid, name, type, telephone,\n" +
                    " seatsnumber, seasonal, openingdate) VALUES\n" +
                    "(?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, addressId);
            preparedStatement.setInt(2, ownerId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, telephone);
            preparedStatement.setInt(6, seatsNumber);
            preparedStatement.setBoolean(7, isSeasonal);
            preparedStatement.setDate(8, openingDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add culture object");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addEvent(int cultureObjectId, String name, Date date, String type) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO\n" +
                    " events(cultureobjectid, name, date, type)  VALUES\n(?, ?, ?, ?);");
            preparedStatement.setInt(1, cultureObjectId);
            preparedStatement.setString(2, name);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, type);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add event");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void addPopularity(int cultureObjectId, Date date, int visitorsNumber) {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO\n" +
                    " popularity(cultureobjectid, date, visitorsnumber)  VALUES\n(?, ?, ?);");
            preparedStatement.setInt(1, cultureObjectId);
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, visitorsNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not add popularity");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //-----------------------------------DELETE-------------------------------------
    private void delete(String tableName, int id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM " +
                    tableName + " WHERE " + tableName + ".id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can't delete entry " + id + " in " + tableName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void deleteAddress(int id) {
        delete("addresses", id);
    }

    void deleteOwner(int id) {
        delete("owners", id);
    }

    void deleteCultureObject(int id) {
        delete("cultureobjects", id);
    }

    void deleteEvent(int id) {
        delete("events", id);
    }

    void deletePopularity(int id) {
        delete("popularity", id);
    }


    //----------------------------------EDIT----------------------------------------
    void editAddress(int id, String city, String street, int house) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE addresses SET\n" +
                    " city = ?," +
                    " street = ?," +
                    " house = ?" +
                    " WHERE addresses.id = ?;");
            preparedStatement.setString(1, city);
            preparedStatement.setString(2, street);
            preparedStatement.setInt(3, house);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not edit address");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editOwner(int id, int addressID, String name, boolean isLegalEntity, String head) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE owners SET\n" +
                    " addressid = ?," +
                    " name = ?," +
                    " legalentity = ?," +
                    " head = ?" +
                    " WHERE owners.id = ?;");
            preparedStatement.setInt(1, addressID);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, isLegalEntity);
            preparedStatement.setString(4, head);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not edit owner");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editCultureObject(int id, int addressId, int ownerId, String name, String type, String telephone,
                                  int seatsNumber, boolean isSeasonal, Date openingDate) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE cultureobjects SET\n" +
                    " addressid = ?," +
                    " ownerid = ?," +
                    " name = ?," +
                    " type = ?," +
                    " telephone = ?," +
                    " seatsnumber = ?," +
                    " seasonal = ?," +
                    " openingdate = ?" +
                    " WHERE cultureobjects.id = ?;");
            preparedStatement.setInt(1, addressId);
            preparedStatement.setInt(2, ownerId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, telephone);
            preparedStatement.setInt(6, seatsNumber);
            preparedStatement.setBoolean(7, isSeasonal);
            preparedStatement.setDate(8, openingDate);
            preparedStatement.setInt(9, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not edit culture object");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editEvent(int id, int cultureObjectId, String name, Date date, String type) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE events SET\n" +
                    " cultureobjectid = ?," +
                    " name = ?," +
                    " date = ?," +
                    " type = ?" +
                    " WHERE events.id = ?;");
            preparedStatement.setInt(1, cultureObjectId);
            preparedStatement.setString(2, name);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, type);
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not edit event");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editPopularity(int id, int cultureObjectId, Date date, int visitorsNumber) {
        try {
            preparedStatement = connection.prepareStatement("UPDATE popularity SET\n" +
                    " cultureobjectid = ?," +
                    " date = ?," +
                    " visitorsnumber = ?" +
                    " WHERE popularity.id = ?;");
            preparedStatement.setInt(1, cultureObjectId);
            preparedStatement.setDate(2, date);
            preparedStatement.setInt(3, visitorsNumber);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can not edit popularity");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //-----------------------------SEARCH-------------------------------------------
    void searchCultureObjectsByOpeningDate(Date openingDate) {
        try {
            tableModel.setColumnNames(Arrays.asList(
                    "openingdate", "name", "type", "city", "street", "house"
            ));

            preparedStatement = connection.prepareStatement("SELECT" +
                    " cultureobjects.openingdate, cultureobjects.name ," +
                    " cultureobjects.type, addresses.city, addresses.street," +
                    " addresses.house FROM cultureobjects, addresses " +
                    " WHERE cultureobjects.openingdate = ? AND cultureobjects.addressid = addresses.id;");
            preparedStatement.setDate(1, openingDate);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addEntry( new ArrayList<>(Arrays.asList(
                        resultSet.getDate("cultureobjects.openingdate").toString(),
                        resultSet.getString("cultureobjects.name"),
                        resultSet.getString("cultureobjects.type"),
                        resultSet.getString("addresses.city"),
                        resultSet.getString("addresses.street"),
                        resultSet.getString("addresses.house"))));
            }
            //update
            tableModel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("Can not find culture objects by opening date");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchEventsByDateInterval(Date date1, Date date2) {
        try {
            tableModel.setColumnNames(Arrays.asList(
                    "date", "name", "cultureobject.name", "city", "street", "house"
            ));

            preparedStatement = connection.prepareStatement("SELECT" +
                    " events.date, events.name, cultureobjects.name ," +
                    " addresses.city, addresses.street, addresses.house" +
                    " FROM events, cultureobjects, addresses " +
                    " WHERE events.date > ? AND events.date < ? AND" +
                    " events.cultureobjectid = cultureobjects.id AND" +
                    " cultureobjects.addressid = addresses.id;");
            preparedStatement.setDate(1, date1);
            preparedStatement.setDate(2, date2);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addEntry( new ArrayList<>(Arrays.asList(
                        resultSet.getDate("events.date").toString(),
                        resultSet.getString("events.name"),
                        resultSet.getString("cultureobjects.name"),
                        resultSet.getString("addresses.city"),
                        resultSet.getString("addresses.street"),
                        resultSet.getString("addresses.house"))));
            }
            //update
            tableModel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("Can not find events by date interval");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void searchObjectByMinimalVisitorsNumber(int visitorsNumber) {
        try {
            tableModel.setColumnNames(Arrays.asList(
                    "cultureobject.name", "sum(popularity)", "street", "house"
            ));

            preparedStatement = connection.prepareStatement("SELECT " +
                    " cultureobjects.name, SUM(popularity.visitorsnumber) " +
                    " FROM cultureobjects, popularity" +
                    " GROUP BY cultureobjects.name" +
                    " having popularity.cultureobjectid = cultureobjects.id AND" +
                    " popularity.visitorsnumber >= ?;");
            preparedStatement.setInt(1, visitorsNumber);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                tableModel.addEntry(new ArrayList<>(Arrays.asList(
                        resultSet.getString("cultureobjects.name"),
                        String.valueOf(resultSet.getInt("SUM(popularity.visitorsnumber)")))));
            }
            //update
            tableModel.fireTableDataChanged();
        } catch (SQLException e) {
            System.out.println("Can not find culture objects by minimal popularity");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
