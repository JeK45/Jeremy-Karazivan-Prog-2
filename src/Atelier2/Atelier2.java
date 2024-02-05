package Atelier2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

class Atelier2 {
    JFrame frame;
    JComboBox<String> cmbChoice;
    JRadioButton radAscending, radDescending;
    ButtonGroup radGrp_sortOrder;
    JTextField txfMin, txfMax, txfAverage, txfValue;
    JButton btnSort, btnSearch, btnQuit;
    JTextArea txaNumbers;
    JScrollPane scr_txaNumbers;
    JPanel panLeft, panRight;

    Atelier2() {
        Dimension dimLeft = new Dimension(180, 25);

        frame = new JFrame("Atelier2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(400, 400));
        frame.setLayout(new GridLayout(1, 2));
//----------------------------------------------------------------------------------------
        cmbChoice = new JComboBox<>(new String[]{"Vider", "Garnir", "Nombres 1..100", "Nombres -25..25"});
        cmbChoice.setPreferredSize(dimLeft);
        cmbChoice.addItemListener(e -> cmbChoice_onSelection(e));
// ----------------------------------------------------------------------------------------
        radAscending = new JRadioButton("Croissant");
        radAscending.setSelected(true);

        radDescending = new JRadioButton("Décroissant");

        radGrp_sortOrder = new ButtonGroup();
        radGrp_sortOrder.add(radAscending);
        radGrp_sortOrder.add(radDescending);
//----------------------------------------------------------------------------------------
        txfMin = new JTextField("txfMin");
        txfMin.setEnabled(false);
        txfMin.setPreferredSize(dimLeft);
        txfMin.setHorizontalAlignment(JTextField.RIGHT);

        txfMax = new JTextField("txfMax");
        txfMax.setEnabled(false);
        txfMax.setPreferredSize(dimLeft);
        txfMax.setHorizontalAlignment(JTextField.RIGHT);

        txfAverage = new JTextField("txfMoyenne");
        txfAverage.setEnabled(false);
        txfAverage.setPreferredSize(dimLeft);
        txfAverage.setHorizontalAlignment(JTextField.RIGHT);

        txfValue = new JTextField("txfValeur");
        txfValue.setPreferredSize(dimLeft);
//----------------------------------------------------------------------------------------
        btnSort = new JButton("Trier");
        btnSort.addActionListener(e ->btnSort_onClick());

        btnSearch = new JButton("Chercher");
        btnSearch.addActionListener(e -> btnSearch_onClick());

        btnQuit = new JButton("Quitter");
        btnQuit.addActionListener( e -> btnQuit_onClick());
//----------------------------------------------------------------------------------------
        txaNumbers = new JTextArea();
        txaNumbers.setWrapStyleWord(true);
        txaNumbers.setLineWrap(true);
        txaNumbers.setEditable(false);
        txaNumbers.setPreferredSize(new Dimension(180, 350));

        scr_txaNumbers = new JScrollPane(txaNumbers);
//----------------------------------------------------------------------------------------
        panLeft = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 10));
        panLeft.add(cmbChoice);
        panLeft.add(radAscending);
        panLeft.add(radDescending);
        panLeft.add(btnSort);
        panLeft.add(txfMin);
        panLeft.add(txfMax);
        panLeft.add(txfAverage);
        panLeft.add(txfValue);
        panLeft.add(btnSearch);
        panLeft.add(btnQuit);

        panRight = new JPanel();
        panRight.add(txaNumbers);

        frame.add(panLeft);
        frame.add(panRight);

        frame.setVisible(true);
    }

    void cmbChoice_onSelection(ItemEvent e) {
        System.out.println(e.getStateChange() + " " + ItemEvent.SELECTED);
    }

    void btnSort_onClick() {

    }

    void btnSearch_onClick() {

    }

    void btnQuit_onClick() {
        System.exit(0);
    }

    public static void main(String[] args) {
        new Atelier2();
    }
}
