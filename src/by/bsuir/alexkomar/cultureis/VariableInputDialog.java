package by.bsuir.alexkomar.cultureis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class VariableInputDialog {
    private String title;
    private List<String> inputParams;
    private List<JTextField> textFields;

    VariableInputDialog(String title, List<String> inputParams) {
        this.title = title;
        this.inputParams = inputParams;
    }

    void create(ActionListener listener) {
        JPanel inputPanel = new JPanel();
        textFields = new ArrayList<>();
        inputPanel.setLayout(
                new GridLayout(inputParams.size(),2));
        inputPanel.setSize(300, 20*inputParams.size());
        for (String param : inputParams) {
            JTextField curTF = new JTextField();
            textFields.add(curTF);
            inputPanel.add(curTF);
            inputPanel.add(new JLabel(param));
        }

        JDialog dialog = new JDialog(null,
                title,
                JDialog.DEFAULT_MODALITY_TYPE);

        JButton button = new JButton(title);
        button.addActionListener(listener);

        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
        dialog.add(inputPanel);
        dialog.add(button);

        dialog.setSize(300, 20*inputParams.size() + 100);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    List<String> getData() {
        List<String> data = new ArrayList<>();
        for (JTextField curTF : textFields) {
            data.add(curTF.getText());
            curTF.setText("");
        }
        return data;
    }
}
