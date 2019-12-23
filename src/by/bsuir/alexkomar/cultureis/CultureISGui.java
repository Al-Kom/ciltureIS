package by.bsuir.alexkomar.cultureis;

import javax.swing.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class CultureISGui {
    private CultureISController controller;

    public CultureISGui() {
    }

    public void setController(CultureISController newController) {
        controller = newController;
    }

    public void createGui() {
        JFrame frame = new JFrame();
        frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        JPanel addButtonsPanel = new JPanel();
        JButton addAddressButton = new JButton("ADD ADDRESS");
        JButton addOwnerButton = new JButton("ADD OWNER");
        JButton addCultureObjectButton = new JButton("ADD CULTURE OBJECT");
        JButton addEventButton = new JButton("ADD EVENT");
        JButton addPopularityButton = new JButton("ADD POPULARITY");
        addButtonsPanel.add(addAddressButton);
        addButtonsPanel.add(addOwnerButton);
        addButtonsPanel.add(addCultureObjectButton);
        addButtonsPanel.add(addEventButton);
        addButtonsPanel.add(addPopularityButton);
        frame.getContentPane().add(addButtonsPanel);


        JButton editAddressButton = new JButton("EDIT ADDRESS");
        JButton editOwnerButton = new JButton("EDIT OWNER");
        JButton editCultureObjectButton = new JButton("EDIT CULTURE OBJECT");
        JButton editEventButton = new JButton("EDIT EVENT");
        JButton editPopularityButton = new JButton("EDIT POPULARITY");
        JPanel editButtonsPanel = new JPanel();
        editButtonsPanel.add(editAddressButton);
        editButtonsPanel.add(editOwnerButton);
        editButtonsPanel.add(editCultureObjectButton);
        editButtonsPanel.add(editEventButton);
        editButtonsPanel.add(editPopularityButton);
        frame.getContentPane().add(editButtonsPanel);



        JButton removeButton = new JButton("REMOVE");
        JButton searchButton = new JButton("SEARCH");

        //buttons action listeners
        addAddressButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add address",
                    Arrays.asList("city", "street", "house"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addAddress(params.get(0),params.get(1),Integer.valueOf(params.get(2)));
            });
        });
        addOwnerButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add owner",
                    Arrays.asList("address id", "name", "is legal entity","head"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addOwner(Integer.valueOf(params.get(0)),params.get(1),
                        Boolean.valueOf(params.get(2)),params.get(3));
            });
        });
        addCultureObjectButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add culture object",
                    Arrays.asList("address id", "owner id", "name", "type", "telephone",
                            "seatsNumber", "isSeasonal", "openingDate"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addCultureObject(Integer.valueOf(params.get(0)), Integer.valueOf(params.get(1)),
                        params.get(2), params.get(3), params.get(4), Integer.valueOf(params.get(5)),
                        Boolean.valueOf(params.get(6)), Date.valueOf(params.get(7)));
            });
        });
        addEventButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add event",
                    Arrays.asList("object id", "name", "date","type"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addEvent(Integer.valueOf(params.get(0)),params.get(1),
                        Date.valueOf(params.get(2)),params.get(3));
            });
        });
        addPopularityButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add popularity",
                    Arrays.asList("object id", "date","visitors number"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addPopularity(Integer.valueOf(params.get(0)),
                        Date.valueOf(params.get(1)),Integer.valueOf(params.get(2)));
            });
        });

        /**other buttons**/


        //table
        VariableTableModel tableModel = controller.getTableModel();
        JTable table = new JTable(tableModel);
        JScrollPane scroller = new JScrollPane(table);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.getContentPane().add(scroller);


        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
