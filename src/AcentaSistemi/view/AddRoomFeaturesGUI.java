package AcentaSistemi.view;

import AcentaSistemi.helper.Config;
import AcentaSistemi.helper.Helper;
import AcentaSistemi.model.Room;
import AcentaSistemi.model.Roomfeatures;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoomFeaturesGUI extends JFrame {
    private JPanel wrapper;
    private JCheckBox cb_romm_tv;
    private JCheckBox cb_room_minibar;
    private JCheckBox cb_room_till;
    private JCheckBox cb_room_projection;
    private JCheckBox cb_room_game_console;
    private JButton btn_room_features_add;
    private JTextField room_test;
    private JButton btn_room_features_exit;
    private int selected_room_id = EmployeeGUI.getSelected_roomId();
    private Room room;
    public AddRoomFeaturesGUI(Room room){
        this.room=room;
        add(wrapper);
        setSize(350, 300);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.PROJECT_TITLE);
        setResizable(false);
        setVisible(true);
        String id = String.valueOf(room.getId());
        room_test.setText(id);

        btn_room_features_add.addActionListener(e -> {
            // Kullanıcının boş bir alan bırakıp bırakmadığını kontrol eder
            if (areFieldsEmptyRoomFeatures()) {
                Helper.showMsg("fill");
                return;
            }
            if(cb_romm_tv.isSelected()){
                String tv = "TV";
                Roomfeatures.add(tv, Integer.parseInt(room_test.getText()));
            }
            if(cb_room_minibar.isSelected()){
                String minibar = "Minibar";
                Roomfeatures.add(minibar, Integer.parseInt(room_test.getText()));
            }
            if(cb_room_till.isSelected()){
                String till = "Kasa";
                Roomfeatures.add(till,Integer.parseInt(room_test.getText()));
            }
            if(cb_room_projection.isSelected()){
                String projectin = "Projesiyon";
                Roomfeatures.add(projectin,Integer.parseInt(room_test.getText()));
            }
            if(cb_room_game_console.isSelected()){
                String game = "Oyun Konsolu";
                Roomfeatures.add(game,Integer.parseInt(room_test.getText()));
            }
            Helper.showMsg("done");
        });
        btn_room_features_exit.addActionListener(e -> {
            dispose();
        });
    }

    private boolean areFieldsEmptyRoomFeatures() {
        return !(cb_romm_tv.isSelected()  ||cb_room_minibar.isSelected() || cb_room_till.isSelected()||
        cb_room_projection.isSelected()  ||cb_room_game_console.isSelected());
    }
}
