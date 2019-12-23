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

    //add
    public void addAddress(String city,String street,int house) {
        sqlManager.addAddress(city,street,house);
    }

    public void addOwner(int addressID,String name,boolean isLegalEntity,String head) {
        sqlManager.addOwner(addressID,name,isLegalEntity,head);
    }
    public void addCultureObject(int addressId, int ownerId,String name,String type,String telephone,
                                 int seatsNumber, boolean isSeasonal, Date openingDate) {
        sqlManager.addCultureObject(addressId, ownerId, name, type, telephone, seatsNumber, isSeasonal, openingDate);
    }

    public void addEvent(int cultureObjectId,String name,Date date,String type) {
        sqlManager.addEvent(cultureObjectId, name, date, type);
    }

    public void addPopularity(int cultureObjectId,Date date,int visitorsNumber){
        sqlManager.addPopularity(cultureObjectId, date, visitorsNumber);
    }

    //delete
    public void deleteAddress(int id) { sqlManager.deleteAddress(id); }

    public void deleteOwner(int id) { sqlManager.deleteOwner(id); }

    public void deleteCultureObject(int id) { sqlManager.deleteCultureObject(id); }

    public void deleteEvent(int id) { sqlManager.deleteEvent(id); }

    public void deletePopularity(int id) { sqlManager.deletePopularity(id); }

    //edit
    public void editAddress(int id,String city,String street,int house) {
        sqlManager.editAddress(id,city,street,house);
    }

    public void editOwner(int id,int addressID,String name,boolean isLegalEntity,String head) {
        sqlManager.editOwner(id,addressID,name,isLegalEntity,head);
    }
    public void editCultureObject(int id,int addressId, int ownerId,String name,String type,String telephone,
                                 int seatsNumber, boolean isSeasonal, Date openingDate) {
        sqlManager.editCultureObject(id,addressId, ownerId, name, type, telephone, seatsNumber, isSeasonal, openingDate);
    }

    public void editEvent(int id,int cultureObjectId,String name,Date date,String type) {
        sqlManager.editEvent(id,cultureObjectId, name, date, type);
    }

    public void editPopularity(int id,int cultureObjectId,Date date,int visitorsNumber){
        sqlManager.editPopularity(id,cultureObjectId, date, visitorsNumber);
    }

    //search
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
