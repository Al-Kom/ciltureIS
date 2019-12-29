package by.bsuir.alexkomar.cultureis;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class CultureISGui {
    private CultureISController controller;

    CultureISGui() {
    }

    void setController(CultureISController newController) {
        controller = newController;
    }

    void createGui() {
        JFrame frame = new JFrame();
        frame.setLayout( new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        //----------------------------------ADD Panel-------------------------------
        JPanel addButtonsPanel = new JPanel();
        JButton addAddressButton = new JButton("ADD ADDRESS");
        JButton addOwnerButton = new JButton("ADD OWNER");
        JButton addCultureObjectButton = new JButton("ADD CULTURE OBJECT");
        JButton addEventButton = new JButton("ADD EVENT");
        JButton addPopularityButton = new JButton("ADD POPULARITY");
        //buttons action listeners
        addAddressButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add address",
                    Arrays.asList("city", "street", "house"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addAddress(params.get(0),params.get(1),params.get(2));
            });
        });

        addOwnerButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add owner",
                    Arrays.asList("address id", "name", "is legal entity","head"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addOwner(params.get(0),params.get(1),
                        params.get(2),params.get(3));
            });
        });

        addCultureObjectButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add culture object",
                    Arrays.asList("address id", "owner id", "name", "type", "telephone",
                            "seatsNumber", "isSeasonal", "openingDate"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addCultureObject(params.get(0), params.get(1),
                        params.get(2), params.get(3), params.get(4), params.get(5),
                        params.get(6), params.get(7));
            });
        });

        addEventButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add event",
                    Arrays.asList("object id", "name", "date","type"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addEvent(params.get(0),params.get(1),
                        params.get(2),params.get(3));
            });
        });

        addPopularityButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Add popularity",
                    Arrays.asList("object id", "date","visitors number"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.addPopularity(params.get(0), params.get(1), params.get(2));
            });
        });

        //add buttons to panel
        addButtonsPanel.add(addAddressButton);
        addButtonsPanel.add(addOwnerButton);
        addButtonsPanel.add(addCultureObjectButton);
        addButtonsPanel.add(addEventButton);
        addButtonsPanel.add(addPopularityButton);
        frame.getContentPane().add(addButtonsPanel);


        //----------------------------------EDIT Panel------------------------------
        JButton editAddressButton = new JButton("EDIT ADDRESS");
        JButton editOwnerButton = new JButton("EDIT OWNER");
        JButton editCultureObjectButton = new JButton("EDIT CULTURE OBJECT");
        JButton editEventButton = new JButton("EDIT EVENT");
        JButton editPopularityButton = new JButton("EDIT POPULARITY");
        //buttons action listeners
        editAddressButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Edit address",
                    Arrays.asList("id", "city", "street", "house"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.editAddress(params.get(0), params.get(1), params.get(2), params.get(3));
            });
        });

        editOwnerButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Edit owner",
                    Arrays.asList("id", "address id", "name", "is legal entity", "head"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.editOwner(params.get(0), params.get(1),
                        params.get(2), params.get(3), params.get(4));
            });
        });

        editCultureObjectButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Edit culture object",
                    Arrays.asList("id", "address id", "owner id", "name", "type",
                            "telephone", "seatsNumber", "isSeasonal", "openingDate"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.editCultureObject(params.get(0), params.get(1),
                        params.get(2), params.get(3), params.get(4), params.get(5),
                        params.get(6), params.get(7), params.get(8));
            });
        });

        editEventButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Edit event",
                    Arrays.asList("id", "object id", "name", "date","type"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.editEvent(params.get(0), params.get(1),
                        params.get(2), params.get(3), params.get(4));
            });
        });

        editPopularityButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Edit popularity",
                    Arrays.asList("id", "object id", "date","visitors number"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.editPopularity(params.get(0), params.get(1), params.get(2), params.get(3));
            });
        });

        //add buttons to panel
        JPanel editButtonsPanel = new JPanel();
        editButtonsPanel.add(editAddressButton);
        editButtonsPanel.add(editOwnerButton);
        editButtonsPanel.add(editCultureObjectButton);
        editButtonsPanel.add(editEventButton);
        editButtonsPanel.add(editPopularityButton);
        frame.getContentPane().add(editButtonsPanel);


        //----------------------------------DELETE Panel----------------------------
        JButton deleteAddressButton = new JButton("DELETE ADDRESS");
        JButton deleteOwnerButton = new JButton("DELETE OWNER");
        JButton deleteCultureObjectButton = new JButton("DELETE CULTURE OBJECT");
        JButton deleteEventButton = new JButton("DELETE EVENT");
        JButton deletePopularityButton = new JButton("DELETE POPULARITY");
        //buttons action listeners
        deleteAddressButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Delete address",
                    Collections.singletonList("id"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.deleteAddress(params.get(0));
            });
        });

        deleteOwnerButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Delete owner",
                    Collections.singletonList("id"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.deleteOwner(params.get(0));
            });
        });

        deleteCultureObjectButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Delete culture object",
                    Collections.singletonList("id"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.deleteCultureObject(params.get(0));
            });
        });

        deleteEventButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Delete event",
                    Collections.singletonList("id"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.deleteEvent(params.get(0));
            });
        });

        deletePopularityButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Delete popularity",
                    Collections.singletonList("id"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.deletePopularity(params.get(0));
            });
        });

        //add buttons to panel
        JPanel deleteButtonsPanel = new JPanel();
        deleteButtonsPanel.add(deleteAddressButton);
        deleteButtonsPanel.add(deleteOwnerButton);
        deleteButtonsPanel.add(deleteCultureObjectButton);
        deleteButtonsPanel.add(deleteEventButton);
        deleteButtonsPanel.add(deletePopularityButton);
        frame.getContentPane().add(deleteButtonsPanel);


        //---------------------------------------SEARCH-----------------------------
        JButton searchCultureObjectsByOpeningDateButton = new JButton("Search culture object by opening date");
        JButton searchEventsByDateIntervalButton = new JButton("Search events by date interval");
        JButton searchCultureObjectsByMinimalPopularityButton = new JButton("Search culture objects by minimal popularity");
        //buttons action listener
        searchCultureObjectsByOpeningDateButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Search culture object by opening date",
                    Collections.singletonList("opening date"));
            dialog.create(e1 -> controller.searchCultureObjectsByOpeningDate(dialog.getData().get(0)));
        });

        searchEventsByDateIntervalButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Search events by date interval",
                    Arrays.asList("date from", "date to"));
            dialog.create(e1 -> {
                List<String> params = dialog.getData();
                controller.searchEventsByDateInterval(params.get(0), params.get(1));
            });
        });

        searchCultureObjectsByMinimalPopularityButton.addActionListener(e -> {
            VariableInputDialog dialog = new VariableInputDialog(
                    "Search culture objects by minimal popularity",
                    Collections.singletonList("minimal visitors value"));
            dialog.create(e1 -> controller.searchObjectByMinimalVisitorsNumber(dialog.getData().get(0)));
        });

        //add to panel
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.add(searchCultureObjectsByOpeningDateButton);
        searchPanel.add(searchEventsByDateIntervalButton);
        searchPanel.add(searchCultureObjectsByMinimalPopularityButton);
        frame.getContentPane().add(searchPanel);


        //--------------------------------TABLE-------------------------------------
        JTable table = new JTable(controller.getTableModel());
        JScrollPane scroller = new JScrollPane(table);
        scroller.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        frame.getContentPane().add(scroller);


        frame.setSize(900, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
