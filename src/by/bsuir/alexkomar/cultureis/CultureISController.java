package by.bsuir.alexkomar.cultureis;

import java.sql.Date;

public class CultureISController {
    private  SqlManager sqlManager;

    CultureISController() {
    }

    void setSqlManager(SqlManager newSqlManager) { sqlManager = newSqlManager; }

    VariableTableModel getTableModel() {
        return sqlManager.getTableModel();
    }


    //---------------------------------ADD------------------------------------------
    void addAddress(String city, String street, String house) {
        sqlManager.addAddress(city,street,Integer.valueOf(house));
    }

    void addOwner(String addressID, String name, String isLegalEntity, String head) {
        sqlManager.addOwner(Integer.valueOf(addressID), name,
                Boolean.valueOf(isLegalEntity), head);
    }

    void addCultureObject(String addressId, String ownerId, String name,
                          String type, String telephone, String seatsNumber,
                          String isSeasonal, String openingDate) {
        sqlManager.addCultureObject(Integer.valueOf(addressId),
                Integer.valueOf(ownerId), name, type, telephone,
                Integer.valueOf(seatsNumber), Boolean.valueOf(isSeasonal),
                Date.valueOf(openingDate));
    }

    void addEvent(String cultureObjectId, String name, String date, String type) {
        sqlManager.addEvent(Integer.valueOf(cultureObjectId),name,
                Date.valueOf(date),type);
    }

    void addPopularity(String cultureObjectId, String date, String visitorsNumber){
        sqlManager.addPopularity(Integer.valueOf(cultureObjectId),
                Date.valueOf(date),Integer.valueOf(visitorsNumber));
    }


    //---------------------------------DELETE---------------------------------------
    public void deleteAddress(int id) { sqlManager.deleteAddress(id); }

    public void deleteOwner(int id) { sqlManager.deleteOwner(id); }

    public void deleteCultureObject(int id) { sqlManager.deleteCultureObject(id); }

    public void deleteEvent(int id) { sqlManager.deleteEvent(id); }

    public void deletePopularity(int id) { sqlManager.deletePopularity(id); }


    //---------------------------------EDIT-----------------------------------------
    void editAddress(String id, String city, String street, String house) {
        sqlManager.editAddress(Integer.valueOf(id), city, street, Integer.valueOf(house));
    }

    void editOwner(String id, String addressID, String name,
                   String isLegalEntity, String head) {
        sqlManager.editOwner(Integer.valueOf(id), Integer.valueOf(addressID), name,
                Boolean.valueOf(isLegalEntity), head);
    }

    void editCultureObject(String id, String addressId, String ownerId,
                           String name, String type, String telephone,
                           String seatsNumber, String isSeasonal,
                           String openingDate) {
        sqlManager.editCultureObject(Integer.valueOf(id), Integer.valueOf(addressId),
                Integer.valueOf(ownerId), name, type, telephone,
                Integer.valueOf(seatsNumber), Boolean.valueOf(isSeasonal),
                Date.valueOf(openingDate));
    }

    void editEvent(String id, String cultureObjectId, String name,
                   String date, String type) {
        sqlManager.editEvent(Integer.valueOf(id), Integer.valueOf(cultureObjectId),
                name, Date.valueOf(date), type);
    }

    void editPopularity(String id, String cultureObjectId, String date,
                        String visitorsNumber){
        sqlManager.editPopularity(Integer.valueOf(id), Integer.valueOf(cultureObjectId),
                Date.valueOf(date), Integer.valueOf(visitorsNumber));
    }


    //---------------------------------SEARCH---------------------------------------
    public void searchCultureObjectsByOpeningDate(Date openingDate) {
        sqlManager.searchCultureObjectsByOpeningDate(openingDate);
    }

    public void searchEventsByDateInterval(Date date1, Date date2) {
        sqlManager.searchEventsByDateInterval(date1, date2);
    }

    public void searchObjectByMinimalVisitorsNumber(int visitorsNumber) {
        sqlManager.searchObjectByMinimalVisitorsNumber(visitorsNumber);
    }
}
